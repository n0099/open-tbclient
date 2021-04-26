package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.core.Util;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class RemitSyncExecutor implements Handler.Callback {
    public static final String TAG = "RemitSyncExecutor";
    public static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    public static final int WHAT_REMOVE_FREE_ID = -2;
    public static final int WHAT_REMOVE_INFO = -3;
    public static final int WHAT_SYNC_BUNCH_ID = 0;
    @NonNull
    public final RemitAgent agent;
    @NonNull
    public final Set<Integer> freeToDBIdList;
    @NonNull
    public final Handler handler;

    /* loaded from: classes2.dex */
    public interface RemitAgent {
        void removeInfo(int i2);

        void syncCacheToDB(int i2) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent) {
        this.agent = remitAgent;
        this.freeToDBIdList = new HashSet();
        HandlerThread handlerThread = new HandlerThread("BdDownload RemitHandoverToDB");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == -3) {
            int i3 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i3));
            this.agent.removeInfo(i3);
            Util.d(TAG, "remove info " + i3);
            return true;
        } else if (i2 == -2) {
            int i4 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i4));
            Util.d(TAG, "remove free bunch id " + i4);
            return true;
        } else if (i2 == -1) {
            List list = (List) message.obj;
            this.freeToDBIdList.removeAll(list);
            Util.d(TAG, "remove free bunch ids " + list);
            return true;
        } else if (i2 != 0) {
            try {
                this.agent.syncCacheToDB(i2);
                this.freeToDBIdList.add(Integer.valueOf(i2));
                Util.d(TAG, "sync info with id: " + i2);
                return true;
            } catch (IOException unused) {
                Util.w(TAG, "sync cache to db failed for id: " + i2);
                return true;
            }
        } else {
            List<Integer> list2 = (List) message.obj;
            try {
                this.agent.syncCacheToDB(list2);
                this.freeToDBIdList.addAll(list2);
                Util.d(TAG, "sync bunch info with ids: " + list2);
                return true;
            } catch (IOException unused2) {
                Util.w(TAG, "sync info to db failed for ids: " + list2);
                return true;
            }
        }
    }

    public boolean isFreeToDatabase(int i2) {
        return this.freeToDBIdList.contains(Integer.valueOf(i2));
    }

    public void postRemoveFreeId(int i2) {
        Message obtainMessage = this.handler.obtainMessage(-2);
        obtainMessage.arg1 = i2;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveFreeIds(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(-1);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveInfo(int i2) {
        Message obtainMessage = this.handler.obtainMessage(-3);
        obtainMessage.arg1 = i2;
        this.handler.sendMessage(obtainMessage);
    }

    public void postSync(int i2) {
        this.handler.sendEmptyMessage(i2);
    }

    public void postSyncInfoDelay(int i2, long j) {
        this.handler.sendEmptyMessageDelayed(i2, j);
    }

    public void removePostWithId(int i2) {
        this.handler.removeMessages(i2);
    }

    public void removePostWithIds(int[] iArr) {
        for (int i2 : iArr) {
            this.handler.removeMessages(i2);
        }
    }

    public void shutdown() {
        this.handler.getLooper().quit();
    }

    public void postSync(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(0);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent, @Nullable Handler handler, @NonNull Set<Integer> set) {
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }
}

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
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface RemitAgent {
        void removeInfo(int i);

        void syncCacheToDB(int i) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent) {
        this.agent = remitAgent;
        this.freeToDBIdList = new HashSet();
        HandlerThread handlerThread = new HandlerThread("BdDownload RemitHandoverToDB");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    public boolean isFreeToDatabase(int i) {
        return this.freeToDBIdList.contains(Integer.valueOf(i));
    }

    public void postRemoveFreeId(int i) {
        Message obtainMessage = this.handler.obtainMessage(-2);
        obtainMessage.arg1 = i;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveFreeIds(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(-1);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveInfo(int i) {
        Message obtainMessage = this.handler.obtainMessage(-3);
        obtainMessage.arg1 = i;
        this.handler.sendMessage(obtainMessage);
    }

    public void postSync(int i) {
        this.handler.sendEmptyMessage(i);
    }

    public void removePostWithId(int i) {
        this.handler.removeMessages(i);
    }

    public void removePostWithIds(int[] iArr) {
        for (int i : iArr) {
            this.handler.removeMessages(i);
        }
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent, @Nullable Handler handler, @NonNull Set<Integer> set) {
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i != -3) {
            if (i != -2) {
                if (i != -1) {
                    if (i != 0) {
                        try {
                            this.agent.syncCacheToDB(i);
                            this.freeToDBIdList.add(Integer.valueOf(i));
                            Util.d(TAG, "sync info with id: " + i);
                            return true;
                        } catch (IOException unused) {
                            Util.w(TAG, "sync cache to db failed for id: " + i);
                            return true;
                        }
                    }
                    List<Integer> list = (List) message.obj;
                    try {
                        this.agent.syncCacheToDB(list);
                        this.freeToDBIdList.addAll(list);
                        Util.d(TAG, "sync bunch info with ids: " + list);
                        return true;
                    } catch (IOException unused2) {
                        Util.w(TAG, "sync info to db failed for ids: " + list);
                        return true;
                    }
                }
                List list2 = (List) message.obj;
                this.freeToDBIdList.removeAll(list2);
                Util.d(TAG, "remove free bunch ids " + list2);
                return true;
            }
            int i2 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i2));
            Util.d(TAG, "remove free bunch id " + i2);
            return true;
        }
        int i3 = message.arg1;
        this.freeToDBIdList.remove(Integer.valueOf(i3));
        this.agent.removeInfo(i3);
        Util.d(TAG, "remove info " + i3);
        return true;
    }

    public void postSync(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(0);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    public void postSyncInfoDelay(int i, long j) {
        this.handler.sendEmptyMessageDelayed(i, j);
    }

    public void shutdown() {
        this.handler.getLooper().quit();
    }
}

package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMFetchConfigMsg extends Message {
    private static final int MAX_COUNT = 50;
    public static final String TAG = IMFetchConfigMsg.class.getSimpleName();
    private static int cur_count = 1;
    private Context mContext;
    private long mCursor;
    private long mLimit;

    static /* synthetic */ int access$008() {
        int i = cur_count;
        cur_count = i + 1;
        return i;
    }

    public IMFetchConfigMsg(Context context, long j, long j2) {
        initCommonParameter(context);
        this.mContext = context;
        this.mCursor = j;
        this.mLimit = j2;
        setNeedReplay(true);
        setType(193);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 193);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("appid", this.mAppid);
            long readLongData = Utility.readLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, 0L);
            if (this.mCursor > readLongData) {
                readLongData = this.mCursor;
            }
            this.mCursor = readLongData;
            jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.mCursor);
            if (this.mLimit < 0 || this.mLimit > 20) {
                this.mLimit = 20L;
            }
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, this.mLimit);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMFetchConfigMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_CONFIG_CURSOR) && intent.hasExtra(Constants.EXTRA_CONFIG_LIMIT)) {
            return new IMFetchConfigMsg(context, intent.getLongExtra(Constants.EXTRA_CONFIG_CURSOR, 0L), intent.getLongExtra(Constants.EXTRA_CONFIG_LIMIT, 0L));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        TaskManager.getInstance(this.mContext).submitForNetWork(new FetchConfigTask(context, jSONObject, i, str));
    }

    /* loaded from: classes18.dex */
    private class FetchConfigTask extends TaskManager.Task {
        private Context mContext;
        private int mErrorCode;
        private JSONObject mObj;
        private String mStrMsg;

        protected FetchConfigTask(Context context, JSONObject jSONObject, int i, String str) {
            this.mContext = context;
            this.mObj = jSONObject;
            this.mErrorCode = i;
            this.mStrMsg = str;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Long] */
        @Override // com.baidu.android.imsdk.task.TaskManager.Task, java.lang.Runnable
        public void run() {
            Type type = new Type();
            type.t = 0L;
            if (this.mErrorCode == 0) {
                try {
                    long j = this.mObj.has(Constants.EXTRA_CONFIG_CURSOR) ? this.mObj.getLong(Constants.EXTRA_CONFIG_CURSOR) : 0L;
                    if (!(this.mObj.has("has_more") ? this.mObj.getBoolean("has_more") : false) || IMFetchConfigMsg.cur_count > 50) {
                        int unused = IMFetchConfigMsg.cur_count = 1;
                        if (j > Utility.readLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, 0L)) {
                            Utility.writeLongData(this.mContext, Constants.KEY_CONFIG_MAXCURSOR, j);
                        }
                    } else {
                        IMFetchConfigMsg.access$008();
                        ChatMsgManagerImpl.getInstance(this.mContext).fetchConfigMsg(this.mContext, j, IMFetchConfigMsg.this.mLimit);
                    }
                    if (this.mObj.has("messages")) {
                        ArrayList<ChatMsg> parserMessage = MessageParser.parserMessage(this.mContext, this.mObj.getJSONArray("messages"), type, true, false);
                        ChatMsgManagerImpl.getInstance(this.mContext).configMsgsFilter(parserMessage);
                        ChatMsgManagerImpl.getInstance(this.mContext).deliverConfigMessage(parserMessage);
                    }
                } catch (Exception e) {
                    LogUtils.e(IMFetchConfigMsg.TAG, "Exception ", e);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                }
            } else if (this.mErrorCode == 4001) {
                LoginManager.getInstance(this.mContext).triggleLogoutListener(this.mErrorCode, this.mStrMsg);
            }
        }
    }
}

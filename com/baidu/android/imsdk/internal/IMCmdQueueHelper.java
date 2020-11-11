package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes18.dex */
public class IMCmdQueueHelper {
    private static final String TAG = "IMCmdQueueHelper";

    public static Message getFirstIdleCmdQueueMsg(Context context) {
        Message message;
        CmdQueueMsg cmdQueueMsg;
        try {
            cmdQueueMsg = DBManager.getInstance(context).getCmdQueueMsg(0);
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "getFirstIdleCmdQueueMsg:", e);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            message = null;
        }
        if (cmdQueueMsg == null) {
            return null;
        }
        message = MessageFactory.getInstance().parseMessage(context, cmdQueueMsg.getMethodId(), cmdQueueMsg.getUuid(), cmdQueueMsg.getBody(), cmdQueueMsg.getExtra());
        return message;
    }
}

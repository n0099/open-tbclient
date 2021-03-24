package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes2.dex */
public class IMCmdQueueHelper {
    public static final String TAG = "IMCmdQueueHelper";

    public static Message getFirstIdleCmdQueueMsg(Context context) {
        try {
            CmdQueueMsg cmdQueueMsg = DBManager.getInstance(context).getCmdQueueMsg(0);
            if (cmdQueueMsg == null) {
                return null;
            }
            return MessageFactory.getInstance().parseMessage(context, cmdQueueMsg.getMethodId(), cmdQueueMsg.getUuid(), cmdQueueMsg.getBody(), cmdQueueMsg.getExtra());
        } catch (Exception e2) {
            LogUtils.e(LogUtils.TAG, "getFirstIdleCmdQueueMsg:", e2);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            return null;
        }
    }
}

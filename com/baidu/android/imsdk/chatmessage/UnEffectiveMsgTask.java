package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
/* loaded from: classes6.dex */
public class UnEffectiveMsgTask implements Runnable {
    private Context mContext;

    public UnEffectiveMsgTask(Context context) {
        this.mContext = context;
    }

    private void sendStatusChangeBroadcast(long j, int i) {
        Intent intent = new Intent(IMConstants.MESSAGE_STATUS_CHANGE);
        intent.setPackage(this.mContext.getApplicationContext().getPackageName());
        intent.putExtra(IMConstants.MSG_ROW_ID, j);
        intent.putExtra(IMConstants.MSG_STATUS, i);
        this.mContext.sendBroadcast(intent);
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        if (DBManager.getInstance(this.mContext).setCentainTypeIDel(new int[]{2}) < 0) {
            return;
        }
        while (true) {
            CmdQueueMsg cmdQueueMsg = DBManager.getInstance(this.mContext).getCmdQueueMsg(2);
            if (cmdQueueMsg != null) {
                String body = cmdQueueMsg.getBody();
                String extra = cmdQueueMsg.getExtra();
                try {
                    j = Long.parseLong(body);
                } catch (Exception e) {
                    j = -1;
                }
                if (j == -1 || TextUtils.isEmpty(extra)) {
                    DBManager.getInstance(this.mContext).deleteCmdMsg(cmdQueueMsg.getUuid());
                } else {
                    ChatObject parseTokenToChatObject = IMConfigInternal.getInstance().getIMConfig(this.mContext).parseTokenToChatObject(this.mContext, extra);
                    ChatMessageDBManager.getInstance(this.mContext).updateMsgStatus(j, 2);
                    sendStatusChangeBroadcast(j, 2);
                    ChatMessageDBManager.getInstance(this.mContext).updateSession(1, parseTokenToChatObject);
                    DBManager.getInstance(this.mContext).deleteCmdMsg(cmdQueueMsg.getUuid());
                }
            } else {
                return;
            }
        }
    }
}

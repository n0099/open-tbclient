package com.baidu.android.imsdk.chatmessage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.CmdQueueMsg;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class UnEffectiveMsgTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UnEffectiveMsgTask";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public UnEffectiveMsgTask(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void sendStatusChangeBroadcast(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            Intent intent = new Intent(IMConstants.MESSAGE_STATUS_CHANGE);
            intent.setPackage(this.mContext.getApplicationContext().getPackageName());
            intent.putExtra("_id", j2);
            intent.putExtra(IMConstants.MSG_STATUS, i2);
            this.mContext.sendBroadcast(intent);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || DBManager.getInstance(this.mContext).setCentainTypeIDel(new int[]{2}) < 0) {
            return;
        }
        while (true) {
            CmdQueueMsg cmdQueueMsg = DBManager.getInstance(this.mContext).getCmdQueueMsg(2);
            if (cmdQueueMsg == null) {
                return;
            }
            if (cmdQueueMsg.getMethodId() == 1048578) {
                String body = cmdQueueMsg.getBody();
                String extra = cmdQueueMsg.getExtra();
                try {
                    j2 = Long.parseLong(body);
                } catch (Exception unused) {
                    j2 = -1;
                }
                if (j2 != -1 && !TextUtils.isEmpty(extra)) {
                    ChatObject parseTokenToChatObject = IMConfigInternal.getInstance().getIMConfig(this.mContext).parseTokenToChatObject(this.mContext, extra);
                    ChatMessageDBManager.getInstance(this.mContext).updateMsgStatus(j2, 2);
                    sendStatusChangeBroadcast(j2, 2);
                    ChatMessageDBManager.getInstance(this.mContext).updateSession(1, parseTokenToChatObject);
                    DBManager.getInstance(this.mContext).deleteCmdMsg(cmdQueueMsg.getUuid());
                } else {
                    DBManager.getInstance(this.mContext).deleteCmdMsg(cmdQueueMsg.getUuid());
                }
            } else if (cmdQueueMsg.getMethodId() == 1048577) {
                String uuid = cmdQueueMsg.getUuid();
                LogUtils.i(TAG, "to get info of:" + uuid);
                ChatObject parseTokenToChatObject2 = IMConfigInternal.getInstance().getIMConfig(this.mContext).parseTokenToChatObject(this.mContext, uuid);
                if (parseTokenToChatObject2 != null) {
                    LogUtils.i(TAG, "ready to get info for Category = " + parseTokenToChatObject2.getCategory() + " Contacter = " + parseTokenToChatObject2.getContacter());
                    GetChatObjectInfoForRecordManager.getChatObjectForSession(this.mContext, parseTokenToChatObject2);
                } else {
                    LogUtils.i(TAG, "chatObject is null");
                    DBManager.getInstance(this.mContext).deleteCmdMsg(cmdQueueMsg.getUuid());
                }
            }
        }
    }
}

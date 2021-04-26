package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes.dex */
public class GetUserInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public GetUserInfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, final CallBack callBack) {
        ChatUserManagerImpl.getInstance(this.mContext).getUser(j, 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler.1
            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
            public void onGetUserResult(int i2, long j2, ChatUser chatUser) {
                LogUtils.d("GetUserInfoForRecordHandler", "getChatObjectInfo getUser error:" + i2);
                if (i2 == 0 && chatUser != null) {
                    GetUserInfoForRecordHandler.this.deleteUUid();
                    CallBack callBack2 = callBack;
                    if (callBack2 != null) {
                        callBack2.onSuccess(0, 0, chatUser);
                        return;
                    }
                    return;
                }
                CallBack callBack3 = callBack;
                if (callBack3 != null) {
                    callBack3.onError(0, 0, j2);
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj) {
        ChatUser chatUser = (ChatUser) obj;
        if (chatUser != null) {
            updateChatRecord(chatObject, chatUser.getUserName(), i2, chatUser.getIconUrl(), 0, "", "", 0, chatUser.getMarkTop(), chatUser.getMarkTopTime(), chatUser.getShield(), chatUser.getShieldTime(), chatUser.getVipId(), chatUser.getVPortrait(), chatUser.getIdentity());
        }
    }
}

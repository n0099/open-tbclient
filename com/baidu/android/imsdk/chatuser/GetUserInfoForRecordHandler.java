package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes9.dex */
public class GetUserInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public GetUserInfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, final CallBack callBack) {
        ChatUserManagerImpl.getInstance(this.mContext).getUser(j, 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler.1
            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
            public void onGetUserResult(int i, long j2, ChatUser chatUser) {
                LogUtils.d("GetUserInfoForRecordHandler", "getChatObjectInfo getUser error:" + i);
                if (i == 0 && chatUser != null) {
                    GetUserInfoForRecordHandler.this.deleteUUid();
                    if (callBack != null) {
                        callBack.onSuccess(0, 0, chatUser);
                    }
                } else if (callBack != null) {
                    callBack.onError(0, 0, j2);
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        ChatUser chatUser = (ChatUser) obj;
        if (chatUser != null) {
            updateChatRecord(chatObject, chatUser.getUserName(), i, chatUser.getIconUrl(), 0, "", "", 0, chatUser.getMarkTop(), chatUser.getMarkTopTime(), chatUser.getShield(), chatUser.getShieldTime(), chatUser.getVipId(), chatUser.getVPortrait(), chatUser.getIdentity());
        }
    }
}

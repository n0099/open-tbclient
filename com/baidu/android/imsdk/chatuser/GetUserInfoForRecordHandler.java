package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes6.dex */
public class GetUserInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public long FLAG;
    private GetIpInfoForRecordHandler mIpHandler;

    public GetUserInfoForRecordHandler(Context context) {
        super(context);
        this.FLAG = Constants.PAFLAG;
        this.mIpHandler = null;
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(final long j, final CallBack callBack) {
        ChatUserManagerImpl.getInstance(this.mContext).getUser(j, 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler.1
            @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
            public void onGetUserResult(int i, long j2, ChatUser chatUser) {
                if (i == 0 && chatUser != null) {
                    GetUserInfoForRecordHandler.this.deleteUUid();
                    if (!chatUser.isAnonymousUser()) {
                        callBack.onSuccess(0, 0, chatUser);
                        return;
                    }
                    GetUserInfoForRecordHandler.this.mIpHandler = new GetIpInfoForRecordHandler(GetUserInfoForRecordHandler.this.mContext);
                    GetUserInfoForRecordHandler.this.mIpHandler.getChatObjectInfo(j, callBack);
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        ChatUser chatUser = (ChatUser) obj;
        if (!chatUser.isAnonymousUser()) {
            updateChatRecord(chatObject, chatUser.getUserName(), i, chatUser.getIconUrl(), 0, "", "", 0, 0, 0L);
        } else if (this.mIpHandler != null) {
            this.mIpHandler.updateChatRecord(chatObject, i, i2, obj);
        }
    }
}

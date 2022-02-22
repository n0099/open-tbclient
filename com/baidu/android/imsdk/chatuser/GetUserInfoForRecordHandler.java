package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class GetUserInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserInfoForRecordHandler(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j2, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, callBack) == null) {
            ChatUserManagerImpl.getInstance(this.mContext).getUser(j2, 0, new IGetUserListener(this, callBack) { // from class: com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GetUserInfoForRecordHandler this$0;
                public final /* synthetic */ CallBack val$callBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = callBack;
                }

                @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                public void onGetUserResult(int i2, long j3, ChatUser chatUser) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j3), chatUser}) == null) {
                        LogUtils.d("GetUserInfoForRecordHandler", "getChatObjectInfo getUser error:" + i2);
                        if (i2 == 0 && chatUser != null) {
                            this.this$0.deleteUUid();
                            CallBack callBack2 = this.val$callBack;
                            if (callBack2 != null) {
                                callBack2.onSuccess(0, 0, chatUser);
                                return;
                            }
                            return;
                        }
                        CallBack callBack3 = this.val$callBack;
                        if (callBack3 != null) {
                            callBack3.onError(0, 0, j3);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj) {
        ChatUser chatUser;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) || (chatUser = (ChatUser) obj) == null) {
            return;
        }
        updateChatRecord(chatObject, chatUser.getUserName(), i2, chatUser.getIconUrl(), 0, "", "", 0, chatUser.getMarkTop(), chatUser.getMarkTopTime(), chatUser.getShield(), chatUser.getShieldTime(), chatUser.getVipId(), chatUser.getVPortrait(), chatUser.getIdentity());
    }
}

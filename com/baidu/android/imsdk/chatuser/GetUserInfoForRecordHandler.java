package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String getExtJson(ChatUser chatUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, chatUser)) == null) {
            if (chatUser == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (chatUser.getHasSpecialIdentity() == 0 && chatUser.getSubscribe() != 1 && chatUser.getSubscribe() != 3) {
                    jSONObject.put("stranger", 1);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, callBack) == null) {
            ChatUserManagerImpl.getInstance(this.mContext).getUser(j, 0, new IGetUserListener(this, callBack) { // from class: com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = callBack;
                }

                @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                public void onGetUserResult(int i, long j2, ChatUser chatUser) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j2), chatUser}) == null) {
                        LogUtils.d("GetUserInfoForRecordHandler", "getChatObjectInfo getUser error:" + i);
                        if (i == 0 && chatUser != null) {
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
                            callBack3.onError(0, 0, j2);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        ChatUser chatUser;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i), Integer.valueOf(i2), obj}) == null) && (chatUser = (ChatUser) obj) != null) {
            updateChatRecord(chatObject, chatUser.getUserName(), i, chatUser.getIconUrl(), 0, "", "", 0, chatUser.getMarkTop(), chatUser.getMarkTopTime(), chatUser.getShield(), chatUser.getShieldTime(), chatUser.getVipId(), chatUser.getVPortrait(), chatUser.getIdentity(), getExtJson(chatUser));
        }
    }
}

package com.baidu.android.imsdk.chatmessage.request.params;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SendMsgParam extends BaseRequestParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SendMsgParam";
    public transient /* synthetic */ FieldHolder $fh;
    public ChatMsg chatMsg;
    public long contacterBduid;
    public long contacterPaUid;
    public String contacterPassUk;
    public long contacterUk;
    public int contacterUserType;
    public BIMValueCallBack<SendMsgResponse> sendMsgRequestCallback;
    public long toUser;

    /* loaded from: classes.dex */
    public interface SendMsgParamConstruct {
        void construct(SendMsgParam sendMsgParam);
    }

    public SendMsgParam(BIMValueCallBack<SendMsgResponse> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMValueCallBack};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sendMsgRequestCallback = bIMValueCallBack;
    }

    public static SendMsgParam getEmptyParam(BIMValueCallBack<SendMsgResponse> bIMValueCallBack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bIMValueCallBack)) == null) {
            return new SendMsgParam(bIMValueCallBack);
        }
        return (SendMsgParam) invokeL.objValue;
    }

    public void setChatMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, chatMsg) == null) {
            this.chatMsg = chatMsg;
        }
    }

    public void setContacterBduid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.contacterBduid = j;
        }
    }

    public void setContacterPaUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.contacterPaUid = j;
        }
    }

    public void setContacterPassUk(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.contacterPassUk = str;
        }
    }

    public void setContacterUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.contacterUk = j;
        }
    }

    public void setContacterUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.contacterUserType = i;
        }
    }

    public void setToUser(@NonNull long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.toUser = j;
        }
    }

    public void setUk(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, chatMsg) == null) {
            this.chatMsg = chatMsg;
        }
    }

    public void onRequestResult(int i, String str, SendMsgResponse sendMsgResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048585, this, i, str, sendMsgResponse) == null) && getRequestCallBack() != null) {
            getRequestCallBack().onResult(i, str, sendMsgResponse);
        }
    }

    public static void constructSendParamFromPaInfo(ChatMsg chatMsg, SendMsgParam sendMsgParam, PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, chatMsg, sendMsgParam, paInfo) == null) && sendMsgParam != null && paInfo != null) {
            long bduid = paInfo.getBduid();
            sendMsgParam.setContacterPassUk(Utility.transBDUID(String.valueOf(bduid)));
            sendMsgParam.setContacterBduid(bduid);
            sendMsgParam.setContacterUk(paInfo.getImUk());
            chatMsg.setContacterUk(paInfo.getImUk());
        }
    }

    public static SendMsgParam newInstance(Context context, ChatMsg chatMsg, long j, long j2, long j3, BIMValueCallBack<SendMsgResponse> bIMValueCallBack) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, chatMsg, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bIMValueCallBack})) == null) {
            if (context != null && chatMsg != null && (j != 0 || j2 != 0)) {
                if (j2 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                SendMsgParam sendMsgParam = new SendMsgParam(bIMValueCallBack);
                chatMsg.setContacterUk(j);
                sendMsgParam.setChatMsg(chatMsg);
                if (z) {
                    sendMsgParam.setToUser(j2);
                } else {
                    sendMsgParam.setToUser(j);
                }
                sendMsgParam.setContacterUk(j);
                sendMsgParam.setContacterPaUid(j2);
                sendMsgParam.setContacterUserType(RequestParamManager.getUserType(z));
                sendMsgParam.setContacterBduid(j3);
                sendMsgParam.setContacterPassUk(Utility.transBDUID(String.valueOf(j3)));
                return sendMsgParam;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            return null;
        }
        return (SendMsgParam) invokeCommon.objValue;
    }

    public static void newInstance(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, long j2, BIMValueCallBack<SendMsgResponse> bIMValueCallBack, SendMsgParamConstruct sendMsgParamConstruct) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, chatMsg, Long.valueOf(j), Long.valueOf(j2), bIMValueCallBack, sendMsgParamConstruct}) == null) {
            if (context != null && chatMsg != null && (j != 0 || j2 != 0)) {
                int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i > 0) {
                    z = true;
                } else {
                    z = false;
                }
                SendMsgParam sendMsgParam = new SendMsgParam(bIMValueCallBack);
                sendMsgParam.setChatMsg(chatMsg);
                if (z) {
                    sendMsgParam.setToUser(j2);
                } else {
                    sendMsgParam.setToUser(j);
                    sendMsgParam.setContacterUk(j);
                    chatMsg.setContacterUk(j);
                }
                sendMsgParam.setContacterPaUid(j2);
                sendMsgParam.setContacterUserType(RequestParamManager.getUserType(z));
                if (z) {
                    if (i <= 0) {
                        LogUtils.e(TAG, "getSendMsgParam paUid invalid");
                        sendMsgParamConstruct.construct(sendMsgParam);
                        return;
                    }
                    PaInfo paInfoSync = IMBoxManager.getPaInfoSync(context, j2);
                    if (paInfoSync == null) {
                        IMBoxManager.getPaInfo(context, j2, new IGetPaInfoListener(chatMsg, sendMsgParam, sendMsgParamConstruct) { // from class: com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ChatMsg val$chatMsg;
                            public final /* synthetic */ SendMsgParamConstruct val$paramConstruct;
                            public final /* synthetic */ SendMsgParam val$sendMsgParam;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {chatMsg, sendMsgParam, sendMsgParamConstruct};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$chatMsg = chatMsg;
                                this.val$sendMsgParam = sendMsgParam;
                                this.val$paramConstruct = sendMsgParamConstruct;
                            }

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                            public void onGetPaInfoResult(int i2, String str, PaInfo paInfo) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, paInfo) == null) {
                                    if (paInfo != null) {
                                        SendMsgParam.constructSendParamFromPaInfo(this.val$chatMsg, this.val$sendMsgParam, paInfo);
                                    } else {
                                        LogUtils.e(SendMsgParam.TAG, "getSendMsgParam paUid invalid");
                                    }
                                    this.val$paramConstruct.construct(this.val$sendMsgParam);
                                }
                            }
                        });
                        return;
                    }
                    constructSendParamFromPaInfo(chatMsg, sendMsgParam, paInfoSync);
                    sendMsgParamConstruct.construct(sendMsgParam);
                    return;
                }
                BIMManager.getBdUkFromImUK(context, j, new IGetUserListener(sendMsgParam, sendMsgParamConstruct) { // from class: com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SendMsgParamConstruct val$paramConstruct;
                    public final /* synthetic */ SendMsgParam val$sendMsgParam;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {sendMsgParam, sendMsgParamConstruct};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$sendMsgParam = sendMsgParam;
                        this.val$paramConstruct = sendMsgParamConstruct;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                    public void onGetUserResult(int i2, long j3, ChatUser chatUser) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j3), chatUser}) == null) {
                            if (chatUser != null) {
                                String bdUk = chatUser.getBdUk();
                                this.val$sendMsgParam.setContacterPassUk(bdUk);
                                if (TextUtils.isEmpty(bdUk)) {
                                    bdUk = "0";
                                }
                                this.val$sendMsgParam.setContacterBduid(Long.valueOf(Utility.transBDUK(bdUk)).longValue());
                            } else {
                                LogUtils.e(SendMsgParam.TAG, "getSendMsgParam imUk invalid");
                            }
                            this.val$paramConstruct.construct(this.val$sendMsgParam);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            sendMsgParamConstruct.construct(getEmptyParam(bIMValueCallBack));
        }
    }

    public static void newInstanceByPa(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, BIMValueCallBack<SendMsgResponse> bIMValueCallBack, @NonNull SendMsgParamConstruct sendMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, chatMsg, Long.valueOf(j), bIMValueCallBack, sendMsgParamConstruct}) == null) {
            if (context != null && chatMsg != null && j != 0) {
                newInstance(context, chatMsg, 0L, j, bIMValueCallBack, sendMsgParamConstruct);
                return;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            sendMsgParamConstruct.construct(getEmptyParam(bIMValueCallBack));
        }
    }

    public static void newInstanceByUk(@NonNull Context context, @NonNull ChatMsg chatMsg, long j, BIMValueCallBack<SendMsgResponse> bIMValueCallBack, @NonNull SendMsgParamConstruct sendMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, chatMsg, Long.valueOf(j), bIMValueCallBack, sendMsgParamConstruct}) == null) {
            if (context != null && chatMsg != null && j != 0) {
                newInstance(context, chatMsg, j, 0L, bIMValueCallBack, sendMsgParamConstruct);
                return;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            sendMsgParamConstruct.construct(getEmptyParam(bIMValueCallBack));
        }
    }

    public ChatMsg getChatMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    public long getContacterBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.contacterBduid;
        }
        return invokeV.longValue;
    }

    public long getContacterPaUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.contacterPaUid;
        }
        return invokeV.longValue;
    }

    public String getContacterPassUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.contacterPassUk;
        }
        return (String) invokeV.objValue;
    }

    public long getContacterUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.contacterUk;
        }
        return invokeV.longValue;
    }

    public int getContacterUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.contacterUserType;
        }
        return invokeV.intValue;
    }

    public BIMValueCallBack<SendMsgResponse> getRequestCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.sendMsgRequestCallback;
        }
        return (BIMValueCallBack) invokeV.objValue;
    }

    public long getToUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.toUser;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.params.BaseRequestParam
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getChatMsg() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "SendMsgParam{, toUser=" + this.toUser + ", contacterPassUk='" + this.contacterPassUk + "', contacterUk=" + this.contacterUk + ", contacterUserType=" + this.contacterUserType + ", contacterPaUid=" + this.contacterPaUid + ", chatMsg=" + this.chatMsg.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}

package com.baidu.android.imsdk.chatmessage.request.params;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.response.DelMsgResponse;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DelMsgParam extends BaseRequestParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DelMsgParam";
    public transient /* synthetic */ FieldHolder $fh;
    public int category;
    public long contaceterPaUid;
    public long contacterBduid;
    public long contacterUk;
    public int contacterUserType;
    public ChatMsg delMsg;
    public BIMValueCallBack<DelMsgResponse> delMsgRequestCallback;
    public long maxMsgId;
    public long to;

    public DelMsgParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public BIMValueCallBack<DelMsgResponse> getRequestCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.delMsgRequestCallback;
        }
        return (BIMValueCallBack) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.params.BaseRequestParam
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (super.isValid() && (this.delMsg != null || (this.category >= 0 && this.to >= 0))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static DelMsgParam newInstance(@NonNull Context context, ChatMsg chatMsg, int i, long j, long j2, long j3, BIMValueCallBack<DelMsgResponse> bIMValueCallBack) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, chatMsg, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bIMValueCallBack})) == null) {
            if (context != null && (j != 0 || j2 != 0)) {
                if (j2 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                chatMsg.setCategory(i);
                DelMsgParam delMsgParam = new DelMsgParam();
                delMsgParam.delMsg = chatMsg;
                delMsgParam.category = i;
                if (z) {
                    delMsgParam.to = j2;
                } else {
                    delMsgParam.to = j;
                }
                delMsgParam.contaceterPaUid = j2;
                delMsgParam.contacterUk = j;
                delMsgParam.contacterUserType = RequestParamManager.getUserType(z);
                delMsgParam.contacterBduid = j3;
                delMsgParam.setRequestCallBack(bIMValueCallBack);
                return delMsgParam;
            }
            LogUtils.d(TAG, "get DelMsgParam failed, param invalid");
            return null;
        }
        return (DelMsgParam) invokeCommon.objValue;
    }

    public void onRequestResult(int i, String str, DelMsgResponse delMsgResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, delMsgResponse) == null) && getRequestCallBack() != null) {
            getRequestCallBack().onResult(i, str, delMsgResponse);
        }
    }

    public void setRequestCallBack(BIMValueCallBack<DelMsgResponse> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bIMValueCallBack) == null) {
            this.delMsgRequestCallback = bIMValueCallBack;
        }
    }
}

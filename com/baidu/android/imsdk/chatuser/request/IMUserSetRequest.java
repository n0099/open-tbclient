package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMUserSetRequest extends IMUserBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mAppid;
    public int mBlack;
    public int mDisturb;
    public String mKey;
    public long mUserUk;

    public IMUserSetRequest(Context context, String str, long j, long j2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mUserUk = j;
        this.mKey = str;
        this.mDisturb = i;
        this.mBlack = i2;
        this.mAppid = j2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("method=update_contacter_setting");
            sb.append("&appid=");
            sb.append(this.mAppid);
            sb.append("&contacter=");
            sb.append(this.mUserUk);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            if (this.mDisturb != -1) {
                sb.append("&do_not_disturb=");
                sb.append(this.mDisturb);
            }
            if (this.mBlack != -1) {
                sb.append("&blacklist=");
                sb.append(this.mBlack);
            }
            sb.append("&sign=");
            sb.append(getMd5("" + currentTimeMillis + bduss + this.mAppid));
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            ChatUserManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mUserUk, this.mDisturb, this.mBlack);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        int i3;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (jSONObject.has("response_params")) {
                    i3 = jSONObject.getJSONObject("response_params").getInt("error_code");
                    optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, Constants.ERROR_MSG_SUCCESS);
                } else {
                    i3 = jSONObject.getInt("error_code");
                    optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                }
                i2 = i3;
                str = optString;
            } catch (JSONException e2) {
                LogUtils.e("IMUserSetRequest", "JSONException", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 1010;
            }
            ChatUserManagerImpl.getInstance(this.mContext).onSetPrivacyResult(this.mKey, i2, str, this.mUserUk, this.mDisturb, this.mBlack);
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? AccountManager.isCuidLogin(this.mContext) : invokeV.booleanValue;
    }
}

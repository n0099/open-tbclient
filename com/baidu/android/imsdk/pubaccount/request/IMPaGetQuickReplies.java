package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IGetQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.QuickReply;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaGetQuickReplies extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mKey;
    public long mPaid;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMPaGetQuickReplies(Context context, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mPaid = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/2.0/im/custom_menu?method=read";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long appid = AccountManager.getAppid(this.mContext);
            String md5 = getMd5("" + currentTimeMillis + bduss + appid);
            sb.append("pa_uid=");
            sb.append(this.mPaid);
            sb.append("&device_type=");
            sb.append(this.mOsType);
            sb.append("&sdk_version=");
            sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            sb.append("&app_version=");
            sb.append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            sb.append("&cuid=");
            sb.append(Utility.getIMDeviceId(this.mContext));
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&sign=");
            sb.append(md5);
            sb.append("&type=");
            sb.append(1);
            sb.append("&appid=");
            sb.append(appid);
            return sb.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            transErrorCode(i, bArr, th);
            IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iGetQuickReplyListener != null) {
                iGetQuickReplyListener.onGetQuickReply(null, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        JSONObject jSONObject;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str = "";
            String str2 = new String(bArr);
            int i3 = 1010;
            try {
                jSONObject = new JSONObject(str2);
                i2 = jSONObject.getInt("error_code");
                jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
            } catch (JSONException e) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
            if (i2 == 0) {
                if (jSONObject.has("response_params")) {
                    str = jSONObject.getString("response_params");
                }
                String str3 = str;
                IGetQuickReplyListener iGetQuickReplyListener = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
                if (i3 != 0) {
                    QuickReply createQuickReply = QuickReply.createQuickReply(str3);
                    if (createQuickReply != null) {
                        PaManagerImpl.getInstance(this.mContext).setPaQuickRelies(this.mPaid, str3, System.currentTimeMillis());
                        if (iGetQuickReplyListener != null) {
                            if (createQuickReply.getStatus() == 0) {
                                iGetQuickReplyListener.onGetQuickReply(createQuickReply, false);
                                return;
                            } else {
                                iGetQuickReplyListener.onGetQuickReply(null, false);
                                return;
                            }
                        }
                        return;
                    } else if (iGetQuickReplyListener != null) {
                        iGetQuickReplyListener.onGetQuickReply(null, false);
                        return;
                    } else {
                        return;
                    }
                } else if (iGetQuickReplyListener != null) {
                    iGetQuickReplyListener.onGetQuickReply(null, false);
                    return;
                } else {
                    return;
                }
            }
            i3 = i2;
            String str32 = str;
            IGetQuickReplyListener iGetQuickReplyListener2 = (IGetQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (i3 != 0) {
            }
        }
    }
}

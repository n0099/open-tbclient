package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IClickPaQuickReplyListener;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaClickQuickReply extends PaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mButtonId;
    public String mKey;
    public long mPaid;
    public long mVersionId;

    public IMPaClickQuickReply(Context context, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, Long.valueOf(j2), str2};
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
        this.mPaid = j;
        this.mButtonId = str;
        this.mVersionId = j2;
        this.mKey = str2;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.pubaccount.request.PaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/2.0/im/custom_menu?method=button_act";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
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
            sb.append("&button_id=");
            sb.append(this.mButtonId);
            sb.append("&device_type=");
            sb.append(this.mOsType);
            sb.append("&version_id=");
            sb.append(this.mVersionId);
            sb.append("&cuid=");
            sb.append(Utility.getIMDeviceId(this.mContext));
            sb.append("&sdk_version=");
            sb.append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            sb.append("&app_version=");
            sb.append(AccountManagerImpl.getInstance(this.mContext).getAppVersion());
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
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        IClickPaQuickReplyListener iClickPaQuickReplyListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i2, bArr, th) == null) || (iClickPaQuickReplyListener = (IClickPaQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey)) == null) {
            return;
        }
        iClickPaQuickReplyListener.onClickQuickReply(i2);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bArr) == null) {
            String str = new String(bArr);
            IClickPaQuickReplyListener iClickPaQuickReplyListener = (IClickPaQuickReplyListener) ListenerManager.getInstance().removeListener(this.mKey);
            int i3 = 1010;
            if (TextUtils.isEmpty(str) && iClickPaQuickReplyListener != null) {
                iClickPaQuickReplyListener.onClickQuickReply(1010);
                return;
            }
            try {
                i3 = new JSONObject(str).getInt("error_code");
            } catch (JSONException e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
            if (i3 == 54000 || i3 == 54001 || i3 == 54002 || i3 == 54003) {
                PaManagerImpl.getInstance(this.mContext).setPaQuickRelies(this.mPaid, "", System.currentTimeMillis());
            }
            if (iClickPaQuickReplyListener != null) {
                iClickPaQuickReplyListener.onClickQuickReply(i3);
            }
        }
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
}

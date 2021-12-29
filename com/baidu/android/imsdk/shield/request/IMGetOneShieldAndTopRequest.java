package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class IMGetOneShieldAndTopRequest extends IMSettingBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetOneShieldAndTopRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mChatType;
    public int mCommodityStatus;
    public long mContacter;
    public int mContacterType;
    public int mDisturb;
    public long mDisturbTime;
    public int mGraphicStatus;
    public String mKey;
    public int mMarkTop;
    public long mMarkTopTime;
    public int mShield;
    public long mShieldTime;

    @Deprecated
    public IMGetOneShieldAndTopRequest(Context context, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mDisturb = 0;
        this.mDisturbTime = 0L;
        this.mGraphicStatus = 1;
        this.mCommodityStatus = 1;
        this.mContext = context;
        this.mContacter = j2;
        this.mKey = str;
        int i4 = (j2 & Constants.PAFLAG) != 0 ? 1 : 0;
        this.mChatType = i4;
        this.mContacterType = getContacterType(i4);
    }

    private int getContacterType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 != 0) {
                return (i2 == 3 || i2 == 57) ? 2 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "read_single_contacter_setting" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("uk", uk);
                jSONObject.put("contacter", this.mContacter);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("contacter_type", this.mContacterType);
                jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
                StringBuilder sb = new StringBuilder();
                sb.append("IMGetOneShieldAndTopRequest msg :");
                sb.append(jSONObject.toString());
                LogUtils.d(TAG, sb.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            GetShieldAndTopResult getShieldAndTopResult = new GetShieldAndTopResult();
            getShieldAndTopResult.setErrorCode(((Integer) transErrorCode.first).intValue());
            getShieldAndTopResult.setErrorMsg((String) transErrorCode.second);
            ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "IMGetOneShieldAndTopRequest onSuccess :" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i3 = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                JSONArray optJSONArray = jSONObject.optJSONArray("contacter");
                if (optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i4);
                        int optInt = jSONObject2.optInt("sub_business");
                        if (optInt == 2) {
                            this.mMarkTop = jSONObject2.optInt("ability");
                            this.mMarkTopTime = jSONObject2.optLong("timestamp");
                        } else if (optInt == 1) {
                            this.mShield = jSONObject2.optInt("ability");
                            this.mShieldTime = jSONObject2.optLong("timestamp");
                        } else if (optInt == 3) {
                            this.mDisturb = jSONObject2.optInt("ability");
                            this.mDisturbTime = jSONObject2.optLong("timestamp");
                        } else if (optInt == 4) {
                            this.mGraphicStatus = jSONObject2.optInt("ability", 1);
                        } else if (optInt == 5) {
                            this.mCommodityStatus = jSONObject2.optInt("ability", 1);
                        }
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "JSONException", e2);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            GetShieldAndTopResult getShieldAndTopResult = new GetShieldAndTopResult();
            getShieldAndTopResult.setErrorCode(i3);
            getShieldAndTopResult.setErrorMsg(str);
            getShieldAndTopResult.setContacter(this.mContacter);
            getShieldAndTopResult.setMarkTop(this.mMarkTop);
            getShieldAndTopResult.setMarkTopTime(this.mMarkTopTime);
            getShieldAndTopResult.setShield(this.mShield);
            getShieldAndTopResult.setShieldTime(this.mShieldTime);
            getShieldAndTopResult.setDisturbStatus(this.mDisturb);
            getShieldAndTopResult.setDisturbTime(this.mDisturbTime);
            getShieldAndTopResult.setGraphicStatus(this.mGraphicStatus);
            getShieldAndTopResult.setCommodityStatus(this.mCommodityStatus);
            getShieldAndTopResult.setChatType(this.mChatType);
            ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
        }
    }

    public IMGetOneShieldAndTopRequest(Context context, long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMarkTop = 0;
        this.mMarkTopTime = 0L;
        this.mShield = 0;
        this.mShieldTime = 0L;
        this.mDisturb = 0;
        this.mDisturbTime = 0L;
        this.mGraphicStatus = 1;
        this.mCommodityStatus = 1;
        this.mContext = context;
        this.mContacter = j2;
        this.mKey = str;
        this.mChatType = i2;
        this.mContacterType = getContacterType(i2);
    }
}

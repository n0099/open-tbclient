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
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.SapiContext;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMGetOneShieldAndTopRequest extends IMSettingBaseHttpRequest {
    private static final String TAG = "IMGetOneShieldAndTopRequest";
    private long mContacter;
    private String mKey;
    private int mMarkTop = 0;
    private long mMarkTopTime = 0;
    private int mShield = 0;
    private long mShieldTime = 0;

    public IMGetOneShieldAndTopRequest(Context context, long j, String str) {
        this.mContext = context;
        this.mContacter = j;
        this.mKey = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("uk", uk);
            jSONObject.put("contacter", this.mContacter);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
            LogUtils.d(TAG, "IMGetOneShieldAndTopRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "IMGetOneShieldAndTopRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("error_code");
            String optString = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            JSONArray optJSONArray = jSONObject.optJSONArray("contacter");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                    int optInt2 = jSONObject2.optInt("sub_business");
                    if (optInt2 == 2) {
                        this.mMarkTop = jSONObject2.optInt("ability");
                        this.mMarkTopTime = jSONObject2.optLong("timestamp");
                    } else if (optInt2 == 1) {
                        this.mShield = jSONObject2.optInt("ability");
                        this.mShieldTime = jSONObject2.optLong("timestamp");
                    }
                }
            }
            str = optString;
            i2 = optInt;
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        GetShieldAndTopResult getShieldAndTopResult = new GetShieldAndTopResult();
        getShieldAndTopResult.setErrorCode(i2);
        getShieldAndTopResult.setErrorMsg(str);
        getShieldAndTopResult.setContacter(this.mContacter);
        getShieldAndTopResult.setMarkTop(this.mMarkTop);
        getShieldAndTopResult.setMarkTopTime(this.mMarkTopTime);
        getShieldAndTopResult.setShield(this.mShield);
        getShieldAndTopResult.setShieldTime(this.mShieldTime);
        ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        GetShieldAndTopResult getShieldAndTopResult = new GetShieldAndTopResult();
        getShieldAndTopResult.setErrorCode(((Integer) transErrorCode.first).intValue());
        getShieldAndTopResult.setErrorMsg((String) transErrorCode.second);
        ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "read_single_contacter_setting";
    }
}

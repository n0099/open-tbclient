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
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetOneShieldAndTopRequest extends IMSettingBaseHttpRequest {
    public static final String TAG = "IMGetOneShieldAndTopRequest";
    public int mChatType;
    public long mContacter;
    public int mContacterType;
    public String mKey;
    public int mMarkTop = 0;
    public long mMarkTopTime = 0;
    public int mShield = 0;
    public long mShieldTime = 0;
    public int mDisturb = 0;
    public long mDisturbTime = 0;

    @Deprecated
    public IMGetOneShieldAndTopRequest(Context context, long j, String str) {
        this.mContext = context;
        this.mContacter = j;
        this.mKey = str;
        int i = (j & Constants.PAFLAG) != 0 ? 1 : 0;
        this.mChatType = i;
        this.mContacterType = getContacterType(i);
    }

    private int getContacterType(int i) {
        if (i != 0) {
            return i != 3 ? 1 : 2;
        }
        return 0;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "read_single_contacter_setting";
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
            jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        GetShieldAndTopResult getShieldAndTopResult = new GetShieldAndTopResult();
        getShieldAndTopResult.setErrorCode(((Integer) transErrorCode.first).intValue());
        getShieldAndTopResult.setErrorMsg((String) transErrorCode.second);
        ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        String str2 = new String(bArr);
        LogUtils.d(TAG, "IMGetOneShieldAndTopRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.optInt("error_code");
            str = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("contacter");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
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
                    }
                }
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, "JSONException", e2);
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
        getShieldAndTopResult.setDisturbStatus(this.mDisturb);
        getShieldAndTopResult.setDisturbTime(this.mDisturbTime);
        getShieldAndTopResult.setChatType(this.mChatType);
        ShieldAndTopManager.getInstance(this.mContext).onUserShieldAndTopResult(getShieldAndTopResult, this.mKey);
    }

    public IMGetOneShieldAndTopRequest(Context context, long j, int i, String str) {
        this.mContext = context;
        this.mContacter = j;
        this.mKey = str;
        this.mChatType = i;
        this.mContacterType = getContacterType(i);
    }
}

package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.SapiContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMSetShieldAndTopRequest extends IMSettingBaseHttpRequest {
    private static final String TAG = "IMSetShieldAndTopRequest";
    private long mContacter;
    private int mContacterType;
    private String mKey;
    private int mState;
    private int mSubBusiness;
    private long timeStamp;
    private ChatSession user;

    public IMSetShieldAndTopRequest(Context context, String str, long j, int i, int i2, int i3) {
        this.mContext = context;
        this.mContacter = j;
        this.mSubBusiness = i;
        this.mKey = str;
        this.mContacterType = i2 == 0 ? 0 : 1;
        this.mState = i3;
        this.user = new ChatSession();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long uk = AccountManager.getUK(this.mContext);
            this.timeStamp = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("uk", uk);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("sub_business", this.mSubBusiness);
            jSONObject.put("contacter", this.mContacter);
            jSONObject.put("contacter_type", this.mContacterType);
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put("ability", this.mState);
            jSONObject.put("sign", getMd5("" + this.timeStamp + uk + appid));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMSetShieldAndTopRequest msg :" + jSONObject.toString());
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
        LogUtils.e(TAG, "IMSetShieldAndTopRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "");
        } catch (JSONException e) {
            LogUtils.e(TAG, "JSONException", e);
            i2 = 1010;
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        if (i2 == 0) {
            this.user.setContacter(this.mContacter);
            if (this.mSubBusiness == 1) {
                this.user.setShield(this.mState);
                this.user.setShieldTime(this.timeStamp);
            } else if (this.mSubBusiness == 2) {
                this.user.setMarkTop(this.mState);
                this.user.setMarkTopTime(this.timeStamp);
            }
            this.user.setChatType(this.mContacterType);
        }
        if (this.mSubBusiness == 1) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(i2, str, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(i2, str, this.user, this.mKey);
            }
        } else if (this.mSubBusiness == 2) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(i2, str, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(i2, str, this.user, this.mKey);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        if (this.mSubBusiness == 1) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            }
        } else if (this.mSubBusiness == 2) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            }
        }
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "set_user_contacter_setting";
    }
}

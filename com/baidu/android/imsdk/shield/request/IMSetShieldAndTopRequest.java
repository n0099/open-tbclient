package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSetShieldAndTopRequest extends IMSettingBaseHttpRequest {
    public static final String TAG = "IMSetShieldAndTopRequest";
    public long mContacter;
    public int mContacterType;
    public String mKey;
    public int mState;
    public int mSubBusiness;
    public long timeStamp;
    public ChatSession user;

    public IMSetShieldAndTopRequest(Context context, String str, long j, int i, int i2, int i3) {
        this.mContext = context;
        this.mContacter = j;
        this.mSubBusiness = i;
        this.mKey = str;
        this.mContacterType = getContacterType(i2);
        this.mState = i3;
        this.user = new ChatSession();
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
        return "set_user_contacter_setting";
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
            jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
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
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        IStatusListener iStatusListener;
        Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
        int i2 = this.mSubBusiness;
        if (i2 == 1) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            }
        } else if (i2 != 2) {
            if (i2 != 3 || (iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey)) == null) {
                return;
            }
            iStatusListener.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mState, this.mContacter);
        } else {
            int i3 = this.mContacterType;
            if (i3 == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            } else if (i3 == 2) {
                ShieldAndTopManager.getInstance(this.mContext).onGroupMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.user, this.mKey);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        int i2;
        IStatusListener iStatusListener;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMSetShieldAndTopRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
        } catch (JSONException e2) {
            LogUtils.e(TAG, "JSONException", e2);
            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            i2 = 1010;
        }
        if (i2 == 0) {
            this.user.setContacter(this.mContacter);
            int i3 = this.mSubBusiness;
            if (i3 == 1) {
                this.user.setShield(this.mState);
                this.user.setShieldTime(this.timeStamp);
            } else if (i3 == 2) {
                this.user.setMarkTop(this.mState);
                this.user.setMarkTopTime(this.timeStamp);
            }
            this.user.setChatType(this.mContacterType);
        }
        int i4 = this.mSubBusiness;
        if (i4 == 1) {
            if (this.mContacterType == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserShieldResult(i2, str, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaShieldResult(i2, str, this.user, this.mKey);
            }
        } else if (i4 != 2) {
            if (i4 != 3 || (iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey)) == null) {
                return;
            }
            iStatusListener.onResult(i2, str, this.mState, this.mContacter);
        } else {
            int i5 = this.mContacterType;
            if (i5 == 0) {
                ShieldAndTopManager.getInstance(this.mContext).onUserMarkTopResult(i2, str, this.user, this.mKey);
            } else if (i5 == 2) {
                ShieldAndTopManager.getInstance(this.mContext).onGroupMarkTopResult(i2, str, this.user, this.mKey);
            } else {
                ShieldAndTopManager.getInstance(this.mContext).onPaMarkTopResult(i2, str, this.user, this.mKey);
            }
        }
    }
}

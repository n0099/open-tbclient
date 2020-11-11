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
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
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
        this.mContacterType = getContacterType(i2);
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
            jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
            jSONObject.put("sub_business", this.mSubBusiness);
            jSONObject.put("contacter", this.mContacter);
            jSONObject.put("contacter_type", this.mContacterType);
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put(FuFaceItem.JK_ABILITY, this.mState);
            jSONObject.put("sign", getMd5("" + this.timeStamp + uk + appid));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMSetShieldAndTopRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        IStatusListener iStatusListener;
        String str2 = new String(bArr);
        LogUtils.e(TAG, "IMSetShieldAndTopRequest onSuccess :" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            i2 = jSONObject.getInt("error_code");
            str = jSONObject.optString("error_msg", "");
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
        } else if (this.mSubBusiness == 3 && (iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey)) != null) {
            iStatusListener.onResult(i2, str, this.mState, this.mContacter);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        IStatusListener iStatusListener;
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
        } else if (this.mSubBusiness == 3 && (iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(this.mKey)) != null) {
            iStatusListener.onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, this.mState, this.mContacter);
        }
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        return "set_user_contacter_setting";
    }

    private int getContacterType(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
            default:
                return 1;
            case 3:
                return 2;
        }
    }
}

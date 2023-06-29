package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.stat.OneKeyLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.up1;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OneKeyLoginSdkCall {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String OKL_SCENE_INIT = "init";
    public static final String OKL_SCENE_LOGIN = "login";
    public static final String OKL_SCENE_PRODUCT = "product";
    public static final String OKL_SCENE_SAPI = "sapi";
    public static final int ONE_KEY_AVAILABLE = 1;
    public static final String OPERATOR_CHINA_MOBILE = "CMCC";
    public static final String OPERATOR_CHINA_TELECOM = "CTCC";
    public static final String OPERATOR_CHINA_UNICOM = "CUCC";
    public static final String OPERATOR_TYPE_CMCC = "CM";
    public static final String OPERATOR_TYPE_CTCC = "CT";
    public static final String OPERATOR_TYPE_CUCC = "CU";
    public static final String TAG = "OneKeyLogin";
    public static OneKeyLoginSdkCall instance = null;
    public static final String oneKeyLoginAppKey = "350675";
    public static final String oneKeyLoginAppSecret = "ba8df9d21db832db598b22fc7cbfbcd6";
    public static OneKeyLoginOptResult preLoginOptResult;
    public static String signFromAbilityApi;

    /* loaded from: classes3.dex */
    public interface TokenListener extends NoProguard {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    public static OneKeyLoginSdkCall getInstance() {
        if (instance == null) {
            instance = new OneKeyLoginSdkCall();
        }
        return instance;
    }

    public boolean checkSupOauth() {
        if (preLoginOptResult != null) {
            return true;
        }
        return false;
    }

    public OneKeyLoginOptResult getPreLoginOptResult() {
        return preLoginOptResult;
    }

    public void initOneKeyLoginSdk(SapiConfiguration sapiConfiguration) {
        try {
            up1.d().e(sapiConfiguration.context, oneKeyLoginAppKey, oneKeyLoginAppSecret);
            up1.d().b(sapiConfiguration.debug);
            up1.d().i(sapiConfiguration.context, sapiConfiguration.isAgreeDangerousProtocol());
        } catch (NoClassDefFoundError unused) {
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }

    public JSONObject getEncryptPhone() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (preLoginOptResult != null) {
                jSONObject.put("phone", preLoginOptResult.getSecurityPhone());
                jSONObject.put("operator", getOperatorType());
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e) {
            Log.e(TAG, e);
        }
        Log.d(TAG, "getEncryptPhone result:" + jSONObject.toString());
        return jSONObject;
    }

    public void getMobileOauthToken(SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        try {
            try {
                up1.d().j(sapiConfiguration.context, 15000L, new up1.a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.3
                    @Override // com.baidu.tieba.up1.a
                    public void onFinish(String str) {
                        Log.d(OneKeyLoginSdkCall.TAG, "getMobileOauthToken onFinish result=" + str);
                        OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                        String extraStr = formatOptResult.getExtraStr();
                        SapiStatUtil.statOneKeyOauthToken(formatOptResult.getCode(), formatOptResult.getSubCode(), 1 ^ (TextUtils.isEmpty(extraStr) ? 1 : 0));
                        final JSONObject jSONObject = new JSONObject();
                        if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                            try {
                                jSONObject.put("errno", 0);
                                jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                                jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
                                jSONObject.put("token", extraStr);
                                jSONObject.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                            } catch (Exception e) {
                                Log.e(OneKeyLoginSdkCall.TAG, e);
                            }
                        } else {
                            try {
                                jSONObject.put("errno", 0);
                                jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                            } catch (JSONException e2) {
                                Log.e(OneKeyLoginSdkCall.TAG, e2);
                            }
                        }
                        if (tokenListener != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    tokenListener.onGetTokenComplete(jSONObject);
                                }
                            });
                        }
                    }
                });
            } catch (NoClassDefFoundError unused) {
                if (tokenListener != null) {
                    tokenListener.onGetTokenComplete(new JSONObject());
                }
                Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
            }
        } catch (Exception e) {
            if (tokenListener != null) {
                tokenListener.onGetTokenComplete(new JSONObject());
            }
            Log.e(TAG, e.getMessage());
        }
    }

    public String getOperatorType() {
        OneKeyLoginOptResult oneKeyLoginOptResult = preLoginOptResult;
        if (oneKeyLoginOptResult != null) {
            if ("1".equals(oneKeyLoginOptResult.getOperateType())) {
                return "CM";
            }
            if ("2".equals(preLoginOptResult.getOperateType())) {
                return "CU";
            }
            if ("3".equals(preLoginOptResult.getOperateType())) {
                return "CT";
            }
            return null;
        }
        return null;
    }

    public void getToken(SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        OneKeyLoginStat.OauthToken.statExtMap.put("netType", SapiUtils.getNetworkClass(sapiConfiguration.context));
        OneKeyLoginStat.OauthToken.statExtMap.put("operator", up1.d().c(sapiConfiguration.context));
        try {
            try {
                up1.d().g(sapiConfiguration.context, 15000L, new up1.a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.2
                    @Override // com.baidu.tieba.up1.a
                    public void onFinish(String str) {
                        OneKeyLoginStat.OauthToken.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        Log.d(OneKeyLoginSdkCall.TAG, "SSOManager login onFinish result=" + str);
                        OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                        String extraStr = formatOptResult.getExtraStr();
                        SapiStatUtil.statOneKeyLoginSDKAction(formatOptResult.getCode(), formatOptResult.getSubCode(), !TextUtils.isEmpty(extraStr) ? 1 : 0);
                        final JSONObject jSONObject = new JSONObject();
                        try {
                            if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                                jSONObject.put("errno", 0);
                                jSONObject.put("code", 0);
                                jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
                                jSONObject.put("token", extraStr);
                                jSONObject.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                                jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                                if (formatOptResult.getOperateType().equals("2")) {
                                    jSONObject.put("CUVersion", "2");
                                }
                                OneKeyLoginStat.OauthToken.sValue = "1";
                                OneKeyLoginStat.OauthToken.statExtMap.put("code", Integer.valueOf(formatOptResult.getCode()));
                                OneKeyLoginStat.OauthToken.statExtMap.put("subCode", Integer.valueOf(formatOptResult.getSubCode()));
                                OneKeyLoginStat.OauthToken.upload();
                            }
                        } catch (JSONException e) {
                            Log.e(OneKeyLoginSdkCall.TAG, e.getMessage());
                            OneKeyLoginStat.OauthToken.sValue = "0";
                            OneKeyLoginStat.OauthToken.statExtMap.put("code", "JSONException");
                            OneKeyLoginStat.OauthToken.upload();
                        }
                        if (tokenListener != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    tokenListener.onGetTokenComplete(jSONObject);
                                }
                            });
                        }
                    }
                });
            } catch (NoClassDefFoundError unused) {
                if (tokenListener != null) {
                    tokenListener.onGetTokenComplete(new JSONObject());
                }
                Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
                OneKeyLoginStat.OauthToken.sValue = "0";
                OneKeyLoginStat.OauthToken.statExtMap.put("code", "NoClassDefFoundError");
                OneKeyLoginStat.OauthToken.upload();
            }
        } catch (Exception e) {
            if (tokenListener != null) {
                tokenListener.onGetTokenComplete(new JSONObject());
            }
            Log.e(TAG, e.getMessage());
            OneKeyLoginStat.OauthToken.sValue = "0";
            OneKeyLoginStat.OauthToken.statExtMap.put("code", e.getMessage());
            OneKeyLoginStat.OauthToken.upload();
        }
    }

    public boolean isMeetOneKeyLoginGray(String str) {
        String str2;
        if (TextUtils.equals(str, OPERATOR_CHINA_MOBILE)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH;
        } else if (TextUtils.equals(str, OPERATOR_CHINA_UNICOM)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH;
        } else if (TextUtils.equals(str, OPERATOR_CHINA_TELECOM)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH;
        } else {
            str2 = null;
        }
        Log.d(TAG, "isMeetOneKeyLoginGray ? operator=" + str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(str2).isMeetGray();
    }

    public void loadOneKeyLoginFail(OneKeyLoginCallback oneKeyLoginCallback, int i, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    public void transMobile(OneKeyLoginCallback oneKeyLoginCallback, int i, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i);
            oneKeyLoginResult.mobile = str;
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i);
            oneKeyLoginResult.setResultMsg("subCode=" + i2 + ", msg=" + str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preGetPhoneInfo(Context context, final String str, int i, boolean z, final OneKeyLoginOptCallback oneKeyLoginOptCallback) {
        boolean z2;
        final long currentTimeMillis = System.currentTimeMillis();
        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("scene", str);
        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("connectTimeout", Integer.valueOf(i));
        if (!z) {
            try {
                if (SapiAccountManager.getInstance().isLogin()) {
                    OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("is_login", "1");
                    OneKeyLoginStat.PreGetPhoneStat.sValue = "0";
                    OneKeyLoginStat.PreGetPhoneStat.upload();
                    Log.d(TAG, "preGetPhoneInfo account is logined");
                    if (oneKeyLoginOptCallback != null) {
                        OneKeyLoginOptResult oneKeyLoginOptResult = new OneKeyLoginOptResult();
                        oneKeyLoginOptResult.setCode(-110);
                        oneKeyLoginOptResult.setSubCode(-110);
                        oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult);
                        return;
                    }
                    return;
                }
            } catch (NoClassDefFoundError unused) {
                if (oneKeyLoginOptCallback != null) {
                    OneKeyLoginStat.PreGetPhoneStat.sValue = "0";
                    OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("code", -101);
                    OneKeyLoginStat.PreGetPhoneStat.upload();
                    OneKeyLoginOptResult oneKeyLoginOptResult2 = new OneKeyLoginOptResult();
                    oneKeyLoginOptResult2.setCode(-101);
                    oneKeyLoginOptResult2.setSubCode(-101);
                    oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult2);
                }
                Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
            }
        }
        final String networkClass = SapiUtils.getNetworkClass(context);
        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("netType", networkClass);
        String c = up1.d().c(context);
        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("operator", c);
        if (!TextUtils.equals(c, OPERATOR_CHINA_MOBILE) && !TextUtils.equals(c, OPERATOR_CHINA_UNICOM) && !TextUtils.equals(c, OPERATOR_CHINA_TELECOM)) {
            z2 = false;
        } else {
            z2 = true;
        }
        try {
            if (z2) {
                if (!isMeetOneKeyLoginGray(c)) {
                    OneKeyLoginStat.PreGetPhoneStat.statExtMap.put(OneKeyLoginStat.PreGetPhoneStat.KEY_EXT_IS_GRAY, "0");
                    OneKeyLoginStat.PreGetPhoneStat.sValue = "0";
                    OneKeyLoginStat.PreGetPhoneStat.upload();
                    Log.d(TAG, "未命中灰度，不请求预取号操作 operator=" + c);
                    if (oneKeyLoginOptCallback != null) {
                        OneKeyLoginOptResult oneKeyLoginOptResult3 = new OneKeyLoginOptResult();
                        oneKeyLoginOptResult3.setCode(-121);
                        oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult3);
                        return;
                    }
                    return;
                }
                OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("is_login", "0");
                OneKeyLoginStat.PreGetPhoneStat.statExtMap.put(OneKeyLoginStat.PreGetPhoneStat.KEY_EXT_IS_GRAY, "1");
                OneKeyLoginStat.PreGetPhoneStat.statExtMap.put(OneKeyLoginStat.PreGetPhoneStat.KEY_EXT_IS_ABLE_SIM, "1");
                up1.d().h(context, i, new up1.a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.1
                    @Override // com.baidu.tieba.up1.a
                    public void onFinish(String str2) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d(OneKeyLoginSdkCall.TAG, "SSOManager preLogin onFinish result=" + str2);
                        final OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str2);
                        if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                            formatOptResult.generateSecurityPhone();
                            OneKeyLoginOptResult unused2 = OneKeyLoginSdkCall.preLoginOptResult = formatOptResult;
                        }
                        SapiStatUtil.statOneKeyPreGetPhone(formatOptResult.getCode(), formatOptResult.getSubCode(), formatOptResult.getSecurityPhone(), formatOptResult.getOperateType(), str, networkClass);
                        OneKeyLoginStat.PreGetPhoneStat.sValue = "1";
                        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("code", Integer.valueOf(formatOptResult.getCode()));
                        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("subCode", Integer.valueOf(formatOptResult.getSubCode()));
                        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("phoneNum", formatOptResult.getSecurityPhone());
                        OneKeyLoginStat.PreGetPhoneStat.statExtMap.put("dur", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                        OneKeyLoginStat.PreGetPhoneStat.upload();
                        if (oneKeyLoginOptCallback != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    oneKeyLoginOptCallback.onFinish(formatOptResult);
                                }
                            });
                        }
                    }
                });
                return;
            }
            Log.d(TAG, "不能获取正确的运营商信息，请检查手机是否有sim卡，operator=" + c);
            if (oneKeyLoginOptCallback != null) {
                OneKeyLoginOptResult oneKeyLoginOptResult4 = new OneKeyLoginOptResult();
                oneKeyLoginOptResult4.setCode(-115);
                oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult4);
            }
            OneKeyLoginStat.PreGetPhoneStat.statExtMap.put(OneKeyLoginStat.PreGetPhoneStat.KEY_EXT_IS_ABLE_SIM, "0");
            OneKeyLoginStat.PreGetPhoneStat.sValue = "0";
            OneKeyLoginStat.PreGetPhoneStat.upload();
        } catch (NoClassDefFoundError unused2) {
            if (oneKeyLoginOptCallback != null) {
            }
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, String str) {
        try {
            preGetPhoneInfo(sapiConfiguration.context, str, 15000, false, null);
        } catch (NoClassDefFoundError unused) {
            Log.e(TAG, "please import the package : onekey_login_ssolibrary-*.aar");
        }
    }
}

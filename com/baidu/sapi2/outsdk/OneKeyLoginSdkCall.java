package com.baidu.sapi2.outsdk;

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
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.facebook.cache.disk.DefaultDiskStorage;
import d.a.j0.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
        return preLoginOptResult != null;
    }

    public JSONObject getEncryptPhone() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (preLoginOptResult != null) {
                jSONObject.put("phone", preLoginOptResult.getSecurityPhone());
                jSONObject.put("operator", getOperatorType());
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e2) {
            Log.e(TAG, e2);
        }
        Log.d(TAG, "getEncryptPhone result:" + jSONObject.toString());
        return jSONObject;
    }

    public void getMobileOauthToken(SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        a.c().i(sapiConfiguration.context, 15000L, new a.InterfaceC0605a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.3
            @Override // d.a.j0.a.InterfaceC0605a
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
                    } catch (Exception e2) {
                        Log.e(OneKeyLoginSdkCall.TAG, e2);
                    }
                } else {
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("operator", OneKeyLoginSdkCall.this.getOperatorType());
                    } catch (JSONException e3) {
                        Log.e(OneKeyLoginSdkCall.TAG, e3);
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
    }

    public String getOperatorType() {
        OneKeyLoginOptResult oneKeyLoginOptResult = preLoginOptResult;
        if (oneKeyLoginOptResult != null) {
            if ("1".equals(oneKeyLoginOptResult.getOperateType())) {
                return OPERATOR_TYPE_CMCC;
            }
            if ("2".equals(preLoginOptResult.getOperateType())) {
                return OPERATOR_TYPE_CUCC;
            }
            if ("3".equals(preLoginOptResult.getOperateType())) {
                return OPERATOR_TYPE_CTCC;
            }
            return null;
        }
        return null;
    }

    public OneKeyLoginOptResult getPreLoginOptResult() {
        return preLoginOptResult;
    }

    public void getToken(final SapiConfiguration sapiConfiguration, final TokenListener tokenListener) {
        a.c().f(sapiConfiguration.context, 15000L, new a.InterfaceC0605a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.2
            @Override // d.a.j0.a.InterfaceC0605a
            public void onFinish(String str) {
                Log.d(OneKeyLoginSdkCall.TAG, "SSOManager login onFinish result=" + str);
                OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                String extraStr = formatOptResult.getExtraStr();
                SapiStatUtil.statOneKeyLoginSDKAction(formatOptResult.getCode(), formatOptResult.getSubCode(), !TextUtils.isEmpty(extraStr) ? 1 : 0);
                final JSONObject jSONObject = new JSONObject();
                try {
                    if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                        jSONObject.put("errno", 0);
                        jSONObject.put("code", 0);
                        jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                        jSONObject.put("token", extraStr);
                        jSONObject.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                    }
                } catch (JSONException e2) {
                    Log.e(OneKeyLoginSdkCall.TAG, e2.getMessage());
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
    }

    public void initOneKeyLoginSdk(SapiConfiguration sapiConfiguration) {
        a.c().d(sapiConfiguration.context, oneKeyLoginAppKey, oneKeyLoginAppSecret);
        a.c().h(sapiConfiguration.context, sapiConfiguration.isAgreeDangerousProtocol());
    }

    public boolean isMeetOneKeyLoginGray(String str) {
        String str2;
        if (TextUtils.equals(str, OPERATOR_CHINA_MOBILE)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH;
        } else if (TextUtils.equals(str, OPERATOR_CHINA_UNICOM)) {
            str2 = SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH;
        } else {
            str2 = TextUtils.equals(str, OPERATOR_CHINA_TELECOM) ? SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH : null;
        }
        Log.d(TAG, "isMeetOneKeyLoginGray ? operator=" + str);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(str2).isMeetGray();
    }

    public void loadOneKeyLoginFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, int i3, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg("subCode=" + i3 + ", msg=" + str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, String str) {
        preGetPhoneInfo(sapiConfiguration, str, 15000, null);
    }

    public void transMobile(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.mobile = str;
            oneKeyLoginCallback.onFail(oneKeyLoginResult);
        }
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, final String str, int i2, final OneKeyLoginOptCallback oneKeyLoginOptCallback) {
        if (SapiAccountManager.getInstance().isLogin()) {
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
        String b2 = a.c().b(sapiConfiguration.context);
        if (TextUtils.equals(b2, OPERATOR_CHINA_MOBILE) || TextUtils.equals(b2, OPERATOR_CHINA_UNICOM) || TextUtils.equals(b2, OPERATOR_CHINA_TELECOM)) {
            if (!isMeetOneKeyLoginGray(b2)) {
                Log.d(TAG, "未命中灰度，不请求预取号操作 operator=" + b2);
                if (oneKeyLoginOptCallback != null) {
                    OneKeyLoginOptResult oneKeyLoginOptResult2 = new OneKeyLoginOptResult();
                    oneKeyLoginOptResult2.setCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY);
                    oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult2);
                    return;
                }
                return;
            }
            final String networkClass = SapiUtils.getNetworkClass(sapiConfiguration.context);
            a.c().g(sapiConfiguration.context, i2, new a.InterfaceC0605a() { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.1
                @Override // d.a.j0.a.InterfaceC0605a
                public void onFinish(String str2) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SSOManager preLogin onFinish result=" + str2);
                    final OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str2);
                    if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                        formatOptResult.generateSecurityPhone();
                        OneKeyLoginOptResult unused = OneKeyLoginSdkCall.preLoginOptResult = formatOptResult;
                    }
                    SapiStatUtil.statOneKeyPreGetPhone(formatOptResult.getCode(), formatOptResult.getSubCode(), formatOptResult.getSecurityPhone(), formatOptResult.getOperateType(), str, networkClass);
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
        Log.d(TAG, "不能获取正确的运营商信息，请检查手机是否有sim卡，operator=" + b2);
        if (oneKeyLoginOptCallback != null) {
            OneKeyLoginOptResult oneKeyLoginOptResult3 = new OneKeyLoginOptResult();
            oneKeyLoginOptResult3.setCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_INVALID_OPERATOR);
            oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult3);
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        if (oneKeyLoginCallback != null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(i2);
            oneKeyLoginResult.setResultMsg(str);
            oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
        }
    }
}

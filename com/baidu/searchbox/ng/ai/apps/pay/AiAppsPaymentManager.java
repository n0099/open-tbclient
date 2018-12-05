package com.baidu.searchbox.ng.ai.apps.pay;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.delegation.AliPayDelegation;
import com.baidu.searchbox.ng.ai.apps.pay.delegation.BaiFuBaoPayDelegation;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsPaymentManager {
    private static final String BANNED_CHANNELS = "bannedChannels";
    private static final boolean DEBUG = false;
    private static final int DEF_CODE = 0;
    private static final int DEF_STATUS_CODE = 0;
    private static final int LOGIN_SUCCESS = 0;
    private static final String NEW_VERSION = "2.0";
    private static final String PARAM_ADD_CALLBACK = "cb";
    private static final String PARAM_APPKEY = "appkey";
    private static final String PARAM_DELTA = "delta";
    private static final String PARAM_PARAMS = "params";
    private static final String PARAM_RASIGN = "rasign";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PAY_ID_KEY = "payId";
    private static final String PAY_RESULT_CANCEL_MSG = "支付取消";
    private static final String PAY_RESULT_FAILED_MSG = "支付失败";
    private static final String PAY_RESULT_KEY = "payResult";
    private static final String PAY_RESULT_SUCCESS_MSG = "支付成功";
    private static final String SYMBOL_CONNECTOR = "&";
    private static final String TAG = AiAppsPaymentManager.class.getSimpleName();
    private static final String VALUE_DELTA = "payid";
    private static volatile AiAppsPaymentManager sPaymentManager;
    private AiApp mAiApp;
    private Context mContext;

    public static synchronized AiAppsPaymentManager getInstance(Context context, AiApp aiApp) {
        AiAppsPaymentManager aiAppsPaymentManager;
        synchronized (AiAppsPaymentManager.class) {
            if (sPaymentManager == null) {
                synchronized (AiAppsPaymentManager.class) {
                    if (sPaymentManager == null) {
                        sPaymentManager = new AiAppsPaymentManager(context, aiApp);
                    }
                }
            }
            aiAppsPaymentManager = sPaymentManager;
        }
        return aiAppsPaymentManager;
    }

    private AiAppsPaymentManager(Context context, AiApp aiApp) {
        this.mContext = context;
        this.mAiApp = aiApp;
    }

    public boolean baiduPay(final String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str2) {
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.mAiApp.getAccount().login(this.mAiApp.getActivity(), new OnAiAppLoginResultListener() { // from class: com.baidu.searchbox.ng.ai.apps.pay.AiAppsPaymentManager.1
            @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
            public void onResult(int i) {
                if (i == 0) {
                    DelegateUtils.callOnMainWithActivity(AiAppsController.getInstance().getActivity(), PluginDelegateActivity.class, BaiFuBaoPayDelegation.class, BaiFuBaoPayDelegation.createExecParams(str), new DelegateListener() { // from class: com.baidu.searchbox.ng.ai.apps.pay.AiAppsPaymentManager.1.1
                        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                        public void onDelegateCallBack(DelegateResult delegateResult) {
                            int i2 = delegateResult.mResult.getInt("status_code");
                            String string = delegateResult.mResult.getString("params");
                            AiAppsPaymentManager.this.ubcPayResult(i2, AiAppsUBCStatistic.SOURCE_QIAN_BAO, string);
                            AiAppsPaymentManager.this.sendSecondCallback(callbackHandler, i2, string, unitedSchemeEntity, null, str2);
                        }
                    });
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean aliPay(String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str2) {
        AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        DelegateUtils.callOnMainWithActivity(AiAppsController.getInstance().getActivity(), PluginDelegateActivity.class, AliPayDelegation.class, AliPayDelegation.createExecParams(str), new DelegateListener() { // from class: com.baidu.searchbox.ng.ai.apps.pay.AiAppsPaymentManager.2
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(DelegateResult delegateResult) {
                int i = delegateResult.mResult.getInt("status_code");
                String string = delegateResult.mResult.getString("params");
                AiAppsPaymentManager.this.ubcPayResult(i, AiAppsUBCStatistic.SOURCE_ALI_PAY, string);
                AiAppsPaymentManager.this.sendSecondCallback(callbackHandler, i, string, unitedSchemeEntity, null, str2);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean weChatH5Pay(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (AiAppsWxPayLaunchMsg.getInstance().openWebView(this.mContext, callbackHandler, unitedSchemeEntity)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    public boolean polymerPay(JSONObject jSONObject, String str, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str2) {
        AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_POLYMER_PAYMENT");
        JSONArray optJSONArray = jSONObject.optJSONArray(BANNED_CHANNELS);
        String[] strArr = null;
        if (optJSONArray != null) {
            strArr = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                strArr[i] = String.valueOf(optJSONArray.opt(i));
            }
        }
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsRuntime.getPaymentRuntime().polymerPay(this.mContext, str, this.mAiApp.getActivity(), strArr, new PolymerPayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.pay.AiAppsPaymentManager.3
            @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback
            public void onPolymerPayResult(int i2, String str3) {
                AiAppsPaymentManager.this.ubcPayResult(i2, AiAppsUBCStatistic.SOURCE_NUO_MI, str3);
                AiAppsPaymentManager.this.sendSecondCallback(callbackHandler, i2, str3, unitedSchemeEntity, null, str2);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ubcPayResult(int i, String str, String str2) {
        AiAppsLaunchInfo launchInfo = this.mAiApp.getLaunchInfo();
        if (launchInfo != null) {
            int i2 = launchInfo.mAppFrameType;
        }
        AiAppsUBCStatistic.onPay(i == 0, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSecondCallback(CallbackHandler callbackHandler, int i, String str, UnitedSchemeEntity unitedSchemeEntity, String str2, String str3) {
        String str4;
        AiAppsLog.d(TAG, "sendSecondCallback, statusCode: " + i + ", params: " + str);
        String str5 = unitedSchemeEntity.getParams().get("params");
        if (!TextUtils.isEmpty(str5)) {
            try {
                str4 = new JSONObject(str5).optString("cb");
                try {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("responseData");
                        if (TextUtils.equals(str3, NEW_VERSION)) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject.put(PAY_ID_KEY, str2);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put(PAY_RESULT_KEY, Base64.encodeToString(optString.getBytes("UTF-8"), 2));
                            }
                            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i, getSecondCallbackMsg(i)).toString());
                            return;
                        }
                        callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(optString, i, getSecondCallbackMsg(i)).toString());
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, getSecondCallbackMsg(i)).toString());
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, getSecondCallbackMsg(i)).toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, getSecondCallbackMsg(i)).toString());
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str4 = null;
            } catch (JSONException e4) {
                e = e4;
                str4 = null;
            }
        }
    }

    private static String getSecondCallbackMsg(int i) {
        switch (i) {
            case 0:
                return PAY_RESULT_SUCCESS_MSG;
            case 1:
            default:
                return PAY_RESULT_FAILED_MSG;
            case 2:
                return PAY_RESULT_CANCEL_MSG;
        }
    }
}

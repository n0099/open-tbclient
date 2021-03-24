package com.baidu.pass.ecommerce.common.request;

import android.os.Handler;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class BaseRequest {
    public static final String CLIENT = "android";
    public static final String CLIENT_FROM = "native";
    public static final int HTTP_OK_CODE = 200;
    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "msg";
    public static final String KEY_RESPONSE_CODE = "errno";
    public static final String KEY_RESPONSE_MSG = "errmsg";
    public static final String PASS_TPL = "pp";
    public static final String TAG = "BaseRequest";
    public Handler actionTimeHandler;
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    public AddressManageDTO addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
    public SapiAccount account = SapiContext.getInstance().getCurrentAccount();
    public long OPTION_NET_LOADING_LIMIT_TIME = 300;
    public HttpHashMapWrap paramsMap = new HttpHashMapWrap() { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.1
        {
            put("client", "android");
            put("clientfrom", "native");
            put("tpl", BaseRequest.this.configuration.tpl);
            if (BaseRequest.this.addressManageDTO != null) {
                put("tplse", BaseRequest.this.addressManageDTO.tplse);
                put("tplt", BaseRequest.this.addressManageDTO.tplt);
            }
        }
    };
    public List<HttpCookie> cookies = new ArrayList<HttpCookie>() { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.2
        {
            add(BaseRequest.this.buildCookie("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID")));
            BaseRequest baseRequest = BaseRequest.this;
            add(baseRequest.buildCookie("cuid", SapiUtils.getClientId(baseRequest.configuration.context)));
            if (BaseRequest.this.account != null) {
                BaseRequest baseRequest2 = BaseRequest.this;
                add(baseRequest2.buildCookie(HttpRequest.BDUSS, baseRequest2.account.bduss));
                BaseRequest baseRequest3 = BaseRequest.this;
                add(baseRequest3.buildCookie("STOKEN", baseRequest3.getPPSToken()));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public HttpCookie buildCookie(String str, String str2) {
        HttpCookie httpCookie = new HttpCookie(str, str2);
        httpCookie.setDomain(this.configuration.environment.getUrlDomain());
        httpCookie.setPath("/");
        return httpCookie;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPPSToken() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("pp");
        return SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
            }
        }, this.account.bduss, arrayList).get("pp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseActionTimeHandler() {
        if (this.actionTimeHandler != null) {
            Log.d(TAG, "releaseActionTimeHandler");
            this.actionTimeHandler.removeCallbacksAndMessages(null);
            this.actionTimeHandler = null;
        }
    }

    public void addCookie(HttpCookie httpCookie) {
        this.cookies.add(httpCookie);
    }

    public void addParams(String str, String str2) {
        this.paramsMap.put(str, str2);
    }

    public abstract String getRelativeUrl();

    public String getUserAgent() {
        return null;
    }

    public void submit(final NetCallback netCallback) {
        Handler handler = new Handler();
        this.actionTimeHandler = handler;
        handler.postDelayed(new Runnable() { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.4
            @Override // java.lang.Runnable
            public void run() {
                netCallback.onShowLoading();
            }
        }, this.OPTION_NET_LOADING_LIMIT_TIME);
        new HttpClientWrap().post(getRelativeUrl(), this.paramsMap, this.cookies, getUserAgent(), new HttpHandlerWrap() { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.5
            /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
                if (android.text.TextUtils.isEmpty(r6) == false) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
                r6 = "未知错误";
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
                r2.onFailure(-10000, r6);
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0046, code lost:
                if (android.text.TextUtils.isEmpty(r6) == false) goto L9;
             */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFailure(Throwable th, int i, String str) {
                BaseRequest.this.releaseActionTimeHandler();
                Log.d(BaseRequest.TAG, "Failure: url=" + BaseRequest.this.getRelativeUrl() + " code=" + i + " response=" + str);
                if (netCallback == null) {
                    return;
                }
                if (th != null) {
                    str = th.getMessage();
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                int optInt;
                String optString;
                BaseRequest.this.releaseActionTimeHandler();
                Log.d(BaseRequest.TAG, "Success: url=" + BaseRequest.this.getRelativeUrl() + " response=" + str);
                NetCallback netCallback2 = netCallback;
                if (netCallback2 == null) {
                    return;
                }
                if (200 != i) {
                    netCallback2.onFailure(i, str);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("errno")) {
                        optInt = jSONObject.optInt("errno", -10000);
                    } else {
                        optInt = jSONObject.has("code") ? jSONObject.optInt("code", -10000) : -10000;
                    }
                    if (optInt == 0) {
                        netCallback.onSuccess(jSONObject);
                        return;
                    }
                    if (jSONObject.has("errmsg")) {
                        optString = jSONObject.optString("errmsg");
                    } else {
                        optString = jSONObject.has("msg") ? jSONObject.optString("msg") : "未知错误";
                    }
                    netCallback.onFailure(optInt, optString);
                } catch (JSONException e2) {
                    netCallback.onFailure(-10000, e2.getMessage());
                }
            }
        });
    }
}

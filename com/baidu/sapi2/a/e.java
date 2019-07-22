package com.baidu.sapi2.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.net.HttpCookie;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* loaded from: classes.dex */
    public interface a {
        void onFailure();

        void onFinish();

        void onStart();
    }

    public void a(final Context context, final SapiConfiguration sapiConfiguration, final View view, final SapiWebView.WeixinHandler weixinHandler, String str, String str2, final a aVar) {
        if (!a(sapiConfiguration)) {
            if (weixinHandler != null) {
                weixinHandler.handleNotInstall();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 9) {
            HttpCookie httpCookie = new HttpCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context));
            httpCookie.setDomain(sapiConfiguration.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""));
            httpCookie.setPath("/");
            arrayList.add(httpCookie);
        }
        new HttpClientWrap().get(str, null, arrayList, str2, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.e.1
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                aVar.onStart();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                aVar.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                if (view != null) {
                    aVar.onFailure();
                } else {
                    weixinHandler.handleServerError(str3);
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString("mkey", "");
                    if (!TextUtils.isEmpty(optString)) {
                        weixinHandler.onFinish();
                        SendAuth.Req req = new SendAuth.Req();
                        req.scope = "snsapi_userinfo";
                        req.state = optString;
                        WXAPIFactory.createWXAPI(context, sapiConfiguration.wxAppID).sendReq(req);
                    } else {
                        String optString2 = jSONObject.optString("error_code", "");
                        if (weixinHandler != null) {
                            weixinHandler.handleServerError(optString2);
                        }
                    }
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
        });
    }

    public boolean a(SapiConfiguration sapiConfiguration) {
        return WXAPIFactory.createWXAPI(sapiConfiguration.context, sapiConfiguration.wxAppID).isWXAppInstalled();
    }
}

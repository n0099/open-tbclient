package com.baidu.sapi2.outsdk;

import android.content.Context;
import android.os.Build;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.SapiUtils;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.net.HttpCookie;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e {
    public void a(Context context, SapiConfiguration sapiConfiguration, SapiWebView.WeixinHandler weixinHandler) {
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
        weixinHandler.onFinish();
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        WXAPIFactory.createWXAPI(context, sapiConfiguration.wxAppID).sendReq(req);
    }

    public boolean a(SapiConfiguration sapiConfiguration) {
        return WXAPIFactory.createWXAPI(sapiConfiguration.context, sapiConfiguration.wxAppID).isWXAppInstalled();
    }
}

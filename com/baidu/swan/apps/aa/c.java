package com.baidu.swan.apps.aa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.core.d.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes8.dex */
public class c extends i {
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        inflate.findViewById(a.f.ai_apps_title_bar_root).setVisibility(8);
        this.cix = aaL();
        this.cix.a(abm());
        this.bRR = this.cix.aaS();
        this.cix.loadUrl(this.mUrl);
        this.cix.a((FrameLayout) inflate.findViewById(a.f.aiapps_webView_container), this.bRR.covertToView());
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f aaL() {
        return com.baidu.swan.apps.core.turbo.d.ajS().ajT().bs(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d abm() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.aa.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean hu(String str) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> stringToMap = ai.stringToMap(ai.getParams(str));
                    if (stringToMap != null && stringToMap.get("statusCode") != null) {
                        try {
                            e.avt().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), URLDecoder.decode(stringToMap.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            e.avt().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), null);
                        }
                    } else {
                        e.avt().onPayResult(6, null);
                    }
                    i.ahA();
                    return true;
                }
                return super.hu(str);
            }
        };
    }
}

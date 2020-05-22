package com.baidu.swan.apps.ac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.core.d.h;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes11.dex */
public class c extends h {
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        inflate.findViewById(a.f.ai_apps_title_bar_root).setVisibility(8);
        this.bWj = Tb();
        this.bWj.a(Tx());
        this.bHi = this.bWj.Th();
        this.bWj.loadUrl(this.mUrl);
        this.bWj.a((FrameLayout) inflate.findViewById(a.f.aiapps_webView_container), this.bHi.covertToView());
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.h
    public com.baidu.swan.apps.adaptation.b.f Tb() {
        return com.baidu.swan.apps.core.turbo.d.abl().abm().bi(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Tx() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.ac.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fS(String str) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> stringToMap = ah.stringToMap(ah.getParams(str));
                    if (stringToMap != null && stringToMap.get("statusCode") != null) {
                        try {
                            e.akZ().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), URLDecoder.decode(stringToMap.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            e.akZ().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), null);
                        }
                    } else {
                        e.akZ().onPayResult(6, null);
                    }
                    h.Zg();
                    return true;
                }
                return super.fS(str);
            }
        };
    }
}

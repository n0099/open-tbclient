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
/* loaded from: classes25.dex */
public class c extends i {
    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.swan.apps.adaptation.b.d] */
    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        inflate.findViewById(a.f.ai_apps_title_bar_root).setVisibility(8);
        this.cQs = ala();
        this.cQs.a(alB());
        this.czQ = this.cQs.alh();
        this.cQs.loadUrl(this.mUrl);
        this.cQs.b((FrameLayout) inflate.findViewById(a.f.aiapps_webView_container), this.czQ.covertToView());
        return enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f ala() {
        return com.baidu.swan.apps.core.turbo.d.aui().auj().cd(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d alB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.aa.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean jo(String str) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> stringToMap = ai.stringToMap(ai.getParams(str));
                    if (stringToMap != null && stringToMap.get("statusCode") != null) {
                        try {
                            e.aFI().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), URLDecoder.decode(stringToMap.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            e.aFI().onPayResult(Integer.valueOf(stringToMap.get("statusCode")).intValue(), null);
                        }
                    } else {
                        e.aFI().onPayResult(6, null);
                    }
                    i.arP();
                    return true;
                }
                return super.jo(str);
            }
        };
    }
}

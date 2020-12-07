package com.baidu.swan.apps.aa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.i;
/* loaded from: classes25.dex */
public class f extends i {
    @Override // com.baidu.swan.apps.core.d.i
    protected void e(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f ala() {
        return com.baidu.swan.apps.core.turbo.d.aui().auj().cd(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d alB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.aa.f.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean jo(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.jo(str);
                }
                com.baidu.swan.apps.console.c.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                i.arP();
                return false;
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void at(View view) {
        super.at(view);
        this.cPk.setTitle(getResources().getString(a.h.aiapps_wx_pay_title));
        fe(false);
    }
}

package com.baidu.swan.apps.ac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.h;
/* loaded from: classes11.dex */
public class f extends h {
    @Override // com.baidu.swan.apps.core.d.h
    protected void a(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.d.h
    public com.baidu.swan.apps.adaptation.b.f Tb() {
        return com.baidu.swan.apps.core.turbo.d.abl().abm().bi(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Tx() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.ac.f.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fS(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.fS(str);
                }
                com.baidu.swan.apps.console.c.d("SwanAppWxPayFragment", " weixin  url:   " + str);
                h.Zg();
                return false;
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void ae(View view) {
        super.ae(view);
        this.bVa.setTitle(getResources().getString(a.h.aiapps_wx_pay_title));
        dC(false);
    }
}

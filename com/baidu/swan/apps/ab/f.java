package com.baidu.swan.apps.ab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.i;
/* loaded from: classes7.dex */
public class f extends i {
    @Override // com.baidu.swan.apps.core.d.i
    protected void a(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.d.i
    public com.baidu.swan.apps.adaptation.b.f UI() {
        return com.baidu.swan.apps.core.turbo.d.adw().adx().bl(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d Vh() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.ab.f.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean fZ(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.fZ(str);
                }
                com.baidu.swan.apps.console.c.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                i.abo();
                return false;
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void ah(View view) {
        super.ah(view);
        this.cbt.setTitle(getResources().getString(a.h.aiapps_wx_pay_title));
        dL(false);
    }
}

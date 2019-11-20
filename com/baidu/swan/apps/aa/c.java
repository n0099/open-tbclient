package com.baidu.swan.apps.aa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.d.g;
/* loaded from: classes2.dex */
public class c extends g {
    @Override // com.baidu.swan.apps.core.d.g
    protected void a(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected f Cn() {
        return com.baidu.swan.apps.core.j.c.GP().GQ().aL(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.g
    protected com.baidu.swan.apps.core.f.c CB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.aa.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.c
            public boolean dd(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.dd(str);
                }
                com.baidu.swan.apps.console.c.d("SwanAppWxPayFragment", " weixin  url:   " + str);
                g.FI();
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.g, com.baidu.swan.apps.core.d.b
    public void U(View view) {
        super.U(view);
        this.aKg.setTitle(getResources().getString(a.h.aiapps_wx_pay_title));
        this.aKg.setRightZoneVisibility(false);
        bv(false);
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return true;
    }
}

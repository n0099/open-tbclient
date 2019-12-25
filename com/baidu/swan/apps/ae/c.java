package com.baidu.swan.apps.ae;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.core.k.d;
/* loaded from: classes9.dex */
public class c extends h {
    @Override // com.baidu.swan.apps.core.d.h
    protected void a(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.d.h
    public f FW() {
        return d.NK().NL().bt(getContext());
    }

    @Override // com.baidu.swan.apps.core.d.h
    protected com.baidu.swan.apps.core.f.d Gr() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.ae.c.1
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public boolean dX(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.dX(str);
                }
                com.baidu.swan.apps.console.c.d("SwanAppWxPayFragment", " weixin  url:   " + str);
                h.LR();
                return false;
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.h, com.baidu.swan.apps.core.d.b
    protected void aa(View view) {
        super.aa(view);
        this.biw.setTitle(getResources().getString(a.h.aiapps_wx_pay_title));
        ce(false);
    }
}

package com.baidu.swan.apps.aa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.c.g;
/* loaded from: classes2.dex */
public class b extends g {
    @Override // com.baidu.swan.apps.core.c.g
    protected void a(FrameLayout frameLayout) {
        frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(b.g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected f vX() {
        return com.baidu.swan.apps.core.i.c.Ab().Ac().bq(getContext());
    }

    @Override // com.baidu.swan.apps.core.c.g
    protected com.baidu.swan.apps.core.e.c wl() {
        return new com.baidu.swan.apps.core.e.a() { // from class: com.baidu.swan.apps.aa.b.1
            @Override // com.baidu.swan.apps.core.e.a, com.baidu.swan.apps.core.e.c
            public boolean ea(String str) {
                if (str == null || !str.startsWith("weixin://wap/pay")) {
                    return super.ea(str);
                }
                com.baidu.swan.apps.console.c.d("SwanAppWxPayFragment", " weixin  url:   " + str);
                g.zf();
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.g, com.baidu.swan.apps.core.c.b
    public void M(View view) {
        super.M(view);
        this.apV.setTitle(getResources().getString(b.h.aiapps_wx_pay_title));
        this.apV.setRightMenuVisibility(false);
        aW(false);
    }
}

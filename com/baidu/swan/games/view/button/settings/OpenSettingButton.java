package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.a.l0.a.g1.f;
import d.a.l0.a.h;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.z1.b.f.e;
/* loaded from: classes3.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        v();
    }

    public void v() {
        g W = f.V().W();
        if (W == null) {
            e.f(AppRuntime.getAppContext(), h.aiapps_open_fragment_failed_toast).F();
            return;
        }
        g.b i2 = W.i("navigateTo");
        i2.n(g.f45752g, g.f45754i);
        i2.k("authority", null).a();
    }
}

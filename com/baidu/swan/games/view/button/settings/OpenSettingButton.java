package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.h;
import d.a.h0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        u();
    }

    public void u() {
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.e(AppRuntime.getAppContext(), h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i2 = W.i("navigateTo");
        i2.n(f.f42031g, f.f42033i);
        i2.k("authority", null).a();
    }
}

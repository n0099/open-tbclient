package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.h;
import d.b.g0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        y();
    }

    public void y() {
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.e(AppRuntime.getAppContext(), h.aiapps_open_fragment_failed_toast).C();
            return;
        }
        f.b i = W.i("navigateTo");
        i.n(f.f44012g, f.i);
        i.k("authority", null).a();
    }
}

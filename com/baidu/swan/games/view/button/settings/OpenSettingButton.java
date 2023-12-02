package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.c63;
import com.baidu.tieba.t52;
import com.baidu.tieba.xr2;
/* loaded from: classes4.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        B();
    }

    public void B() {
        t52 W = xr2.V().W();
        if (W == null) {
            c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01dd).G();
            return;
        }
        t52.b i = W.i("navigateTo");
        i.n(t52.g, t52.i);
        i.k("authority", null).a();
    }
}

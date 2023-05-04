package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.g72;
import com.baidu.tieba.kt2;
import com.baidu.tieba.p73;
/* loaded from: classes3.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        A();
    }

    public void A() {
        g72 V = kt2.U().V();
        if (V == null) {
            p73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01a6).G();
            return;
        }
        g72.b i = V.i("navigateTo");
        i.n(g72.g, g72.i);
        i.k("authority", null).a();
    }
}

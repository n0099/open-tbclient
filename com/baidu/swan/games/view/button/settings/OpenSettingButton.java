package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.d72;
import com.baidu.tieba.ht2;
import com.baidu.tieba.m73;
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
        d72 V = ht2.U().V();
        if (V == null) {
            m73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01a8).G();
            return;
        }
        d72.b i = V.i("navigateTo");
        i.n(d72.g, d72.i);
        i.k("authority", null).a();
    }
}

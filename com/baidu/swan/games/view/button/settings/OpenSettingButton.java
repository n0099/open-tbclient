package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.e72;
import com.baidu.tieba.it2;
import com.baidu.tieba.n73;
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
        e72 V = it2.U().V();
        if (V == null) {
            n73.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01a8).G();
            return;
        }
        e72.b i = V.i("navigateTo");
        i.n(e72.g, e72.i);
        i.k("authority", null).a();
    }
}

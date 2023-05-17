package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.p82;
import com.baidu.tieba.tu2;
import com.baidu.tieba.y83;
/* loaded from: classes4.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        A();
    }

    public void A() {
        p82 V = tu2.U().V();
        if (V == null) {
            y83.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d0).G();
            return;
        }
        p82.b i = V.i("navigateTo");
        i.n(p82.g, p82.i);
        i.k("authority", null).a();
    }
}

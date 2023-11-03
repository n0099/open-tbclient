package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.p52;
import com.baidu.tieba.tr2;
import com.baidu.tieba.y53;
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
        p52 W = tr2.V().W();
        if (W == null) {
            y53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d5).G();
            return;
        }
        p52.b i = W.i("navigateTo");
        i.n(p52.g, p52.i);
        i.k("authority", null).a();
    }
}

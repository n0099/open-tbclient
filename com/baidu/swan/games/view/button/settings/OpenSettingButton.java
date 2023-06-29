package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.lb2;
import com.baidu.tieba.px2;
import com.baidu.tieba.ub3;
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
        lb2 U = px2.T().U();
        if (U == null) {
            ub3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d2).G();
            return;
        }
        lb2.b i = U.i("navigateTo");
        i.n(lb2.g, lb2.i);
        i.k("authority", null).a();
    }
}

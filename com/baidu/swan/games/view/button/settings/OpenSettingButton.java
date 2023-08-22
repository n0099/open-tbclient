package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.ma2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.va3;
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
        ma2 U = qw2.T().U();
        if (U == null) {
            va3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d3).G();
            return;
        }
        ma2.b i = U.i("navigateTo");
        i.n(ma2.g, ma2.i);
        i.k("authority", null).a();
    }
}

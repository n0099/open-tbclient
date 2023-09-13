package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.qa2;
import com.baidu.tieba.uw2;
import com.baidu.tieba.za3;
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
        qa2 U = uw2.T().U();
        if (U == null) {
            za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d3).G();
            return;
        }
        qa2.b i = U.i("navigateTo");
        i.n(qa2.g, qa2.i);
        i.k("authority", null).a();
    }
}

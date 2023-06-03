package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.hb2;
import com.baidu.tieba.lx2;
import com.baidu.tieba.qb3;
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
        hb2 U = lx2.T().U();
        if (U == null) {
            qb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d0).G();
            return;
        }
        hb2.b i = U.i("navigateTo");
        i.n(hb2.g, hb2.i);
        i.k("authority", null).a();
    }
}

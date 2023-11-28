package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.q52;
import com.baidu.tieba.ur2;
import com.baidu.tieba.z53;
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
        q52 W = ur2.V().W();
        if (W == null) {
            z53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01dd).G();
            return;
        }
        q52.b i = W.i("navigateTo");
        i.n(q52.g, q52.i);
        i.k("authority", null).a();
    }
}

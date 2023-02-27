package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.e93;
import com.baidu.tieba.v82;
import com.baidu.tieba.zu2;
/* loaded from: classes3.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        u();
    }

    public void u() {
        v82 V = zu2.U().V();
        if (V == null) {
            e93.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01a8).G();
            return;
        }
        v82.b i = V.i("navigateTo");
        i.n(v82.g, v82.i);
        i.k("authority", null).a();
    }
}

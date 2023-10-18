package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.R;
import com.baidu.tieba.cr2;
import com.baidu.tieba.h53;
import com.baidu.tieba.y42;
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
        y42 W = cr2.V().W();
        if (W == null) {
            h53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01d5).G();
            return;
        }
        y42.b i = W.i("navigateTo");
        i.n(y42.g, y42.i);
        i.k("authority", null).a();
    }
}

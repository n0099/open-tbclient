package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes2.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        MX();
    }

    public void MX() {
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            d.l(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).II();
        } else {
            uy.ea("navigateTo").A(e.aqO, e.aqQ).a("setting", null).commit();
        }
    }
}

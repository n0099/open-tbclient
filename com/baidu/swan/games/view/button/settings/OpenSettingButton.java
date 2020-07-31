package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes7.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        amm();
    }

    public void amm() {
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
        } else {
            Sc.jO("navigateTo").ag(f.cci, f.cck).a("authority", null).commit();
        }
    }
}

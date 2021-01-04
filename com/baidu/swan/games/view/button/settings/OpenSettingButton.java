package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes9.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        aFJ();
    }

    public void aFJ() {
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs == null) {
            d.u(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).aLS();
        } else {
            ajs.nv("navigateTo").ai(f.cUY, f.cVa).a("authority", null).commit();
        }
    }
}

package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes25.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        aEq();
    }

    public void aEq() {
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            d.t(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
        } else {
            aim.nC("navigateTo").an(f.cQb, f.cQd).a("authority", null).commit();
        }
    }
}

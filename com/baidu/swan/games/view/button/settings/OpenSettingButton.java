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
        MZ();
    }

    public void MZ() {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            d.l(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).IK();
        } else {
            uz.dY("navigateTo").A(e.aqJ, e.aqL).a("setting", null).commit();
        }
    }
}

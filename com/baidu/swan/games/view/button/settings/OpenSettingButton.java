package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes11.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        agB();
    }

    public void agB() {
        e Ou = f.aeK().Ou();
        if (Ou == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
        } else {
            Ou.io("navigateTo").ab(e.bMz, e.bMB).a("setting", null).commit();
        }
    }
}

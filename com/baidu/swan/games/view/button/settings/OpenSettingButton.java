package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes2.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        Qy();
    }

    public void Qy() {
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).LQ();
        } else {
            vJ.dS("navigateTo").B(e.arw, e.ary).a("setting", null).commit();
        }
    }
}

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
        Vq();
    }

    public void Vq() {
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            d.i(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).QO();
        } else {
            AI.eC("navigateTo").F(e.aKT, e.aKV).a("setting", null).commit();
        }
    }
}

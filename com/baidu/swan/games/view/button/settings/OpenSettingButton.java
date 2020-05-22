package com.baidu.swan.games.view.button.settings;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.view.button.base.ApiButton;
/* loaded from: classes11.dex */
public class OpenSettingButton extends ApiButton {
    public OpenSettingButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        ajO();
    }

    public void ajO() {
        e QH = f.ahV().QH();
        if (QH == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
        } else {
            QH.jp("navigateTo").ae(e.bVN, e.bVP).a("setting", null).commit();
        }
    }
}

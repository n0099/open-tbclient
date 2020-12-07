package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.l.a;
/* loaded from: classes25.dex */
public class b {
    private FullScreenFloatView ebp;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.ebp == null) {
            if (a.a((bVar == null || bVar.ebP == null) ? null : bVar.ebP.edI).isEnabled()) {
                X(activity);
            }
        }
    }

    private void X(final Activity activity) {
        this.ebp = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.ebp.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.ebp.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.ebp.setAutoAttachEnable(false);
        this.ebp.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Y(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void aCe() {
            }
        });
        this.ebp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        e aJU = e.aJU();
        if (aJU != null && aJU.aio() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).f(resources.getString(a.h.aiapps_swan_inspector_info_title)).st(SwanInspectorEndpoint.aYx().a(resources)).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aJB();
        }
    }
}

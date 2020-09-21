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
/* loaded from: classes3.dex */
public class b {
    private FullScreenFloatView dvJ;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.dvJ == null) {
            if (a.a((bVar == null || bVar.dwj == null) ? null : bVar.dwj.dyb).isEnabled()) {
                X(activity);
            }
        }
    }

    private void X(final Activity activity) {
        this.dvJ = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.dvJ.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.dvJ.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.dvJ.setAutoAttachEnable(false);
        this.dvJ.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.Y(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void asy() {
            }
        });
        this.dvJ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Activity activity) {
        e aAr = e.aAr();
        if (aAr != null && aAr.YI() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).qy(SwanInspectorEndpoint.aOX().a(resources)).a(new com.baidu.swan.apps.view.c.a()).fz(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).azY();
        }
    }
}

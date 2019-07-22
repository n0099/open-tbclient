package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.games.i.a;
/* loaded from: classes2.dex */
public class b {
    private FullScreenFloatView bij;

    public void a(a.c cVar, Activity activity) {
        if (activity != null && this.bij == null) {
            if (a.a((cVar == null || cVar.biL == null) ? null : cVar.biL.bkf).isEnabled()) {
                V(activity);
            }
        }
    }

    private void V(final Activity activity) {
        this.bij = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bij.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bij.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bij.setAutoAttachEnable(false);
        this.bij.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.W(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void Gv() {
            }
        });
        this.bij.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Activity activity) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.vL() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).gC(SwanInspectorEndpoint.Ss().b(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).ce(false).b(a.h.aiapps_ok, null).Lx();
        }
    }
}

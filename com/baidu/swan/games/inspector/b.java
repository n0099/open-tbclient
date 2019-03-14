package com.baidu.swan.games.inspector;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.games.i.a;
/* loaded from: classes2.dex */
public class b {
    private FullScreenFloatView bdj;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.bdj == null) {
            if (a.a((bVar == null || bVar.bdE == null) ? null : bVar.bdE.beX).isEnabled()) {
                Q(activity);
            }
        }
    }

    private void Q(final Activity activity) {
        this.bdj = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bdj.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bdj.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bdj.setAutoAttachEnable(false);
        this.bdj.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.R(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void DS() {
            }
        });
        this.bdj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Activity activity) {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.uB() != null) {
            Resources resources = activity.getResources();
            new e.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).gd(SwanInspectorEndpoint.Oz().b(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(a.h.aiapps_ok, null).Iu();
        }
    }
}

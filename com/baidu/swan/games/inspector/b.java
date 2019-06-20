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
    private FullScreenFloatView bhu;

    public void a(a.c cVar, Activity activity) {
        if (activity != null && this.bhu == null) {
            if (a.a((cVar == null || cVar.bhW == null) ? null : cVar.bhW.bjs).isEnabled()) {
                S(activity);
            }
        }
    }

    private void S(final Activity activity) {
        this.bhu = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.bhu.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.bhu.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.bhu.setAutoAttachEnable(false);
        this.bhu.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.T(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void FL() {
            }
        });
        this.bhu.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Activity activity) {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.vk() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).d(resources.getString(a.h.aiapps_swan_inspector_info_title)).gw(SwanInspectorEndpoint.Rz().b(resources).toString()).a(new com.baidu.swan.apps.view.b.a()).cb(false).b(a.h.aiapps_ok, null).KK();
        }
    }
}

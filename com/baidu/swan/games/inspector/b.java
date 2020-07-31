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
/* loaded from: classes7.dex */
public class b {
    private FullScreenFloatView djw;

    public void a(a.b bVar, Activity activity) {
        if (activity != null && this.djw == null) {
            if (a.a((bVar == null || bVar.djW == null) ? null : bVar.djW.dlR).isEnabled()) {
                W(activity);
            }
        }
    }

    private void W(final Activity activity) {
        this.djw = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.djw.setFloatButtonText(activity.getString(a.h.aiapps_swan_inspector_info_button));
        this.djw.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
        this.djw.setAutoAttachEnable(false);
        this.djw.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.games.inspector.b.1
            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void onClick() {
                b.this.X(activity);
            }

            @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
            public void akg() {
            }
        });
        this.djw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(Activity activity) {
        e arv = e.arv();
        if (arv != null && arv.Se() != null) {
            Resources resources = activity.getResources();
            new g.a(activity).e(resources.getString(a.h.aiapps_swan_inspector_info_title)).og(SwanInspectorEndpoint.aFx().a(resources)).a(new com.baidu.swan.apps.view.c.a()).fh(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).ard();
        }
    }
}

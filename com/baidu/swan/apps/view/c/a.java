package com.baidu.swan.apps.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes10.dex */
public class a implements g.c {
    private FrameLayout dtt = null;

    @Override // com.baidu.swan.apps.res.widget.dialog.g.c
    public void a(g gVar, g.b bVar) {
        if (gVar != null && bVar != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            a(gVar);
            ViewGroup viewGroup = (ViewGroup) gVar.findViewById(16908290);
            if (viewGroup != null) {
                if (com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState()) {
                    d(viewGroup, bVar.mDialogLayout);
                } else {
                    F(viewGroup);
                }
            }
        }
    }

    private void a(g gVar) {
        Context context = gVar.getContext();
        if (gVar.getContext() instanceof ContextWrapper) {
            context = ((ContextWrapper) gVar.getContext()).getBaseContext();
        }
        if (context instanceof Activity) {
            e.b((Activity) context, gVar);
        }
    }

    private void d(final ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dtt == null) {
                        a.this.dtt = new FrameLayout(viewGroup.getContext());
                        a.this.dtt.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(a.this.dtt);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    viewGroup.addView(a.this.dtt, layoutParams);
                }
            });
        }
    }

    private void F(ViewGroup viewGroup) {
        if (viewGroup != null && this.dtt != null) {
            viewGroup.removeView(this.dtt);
            this.dtt = null;
        }
    }
}

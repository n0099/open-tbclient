package com.baidu.swan.apps.view.b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes2.dex */
public class a implements g.c {
    private FrameLayout aVZ = null;

    @Override // com.baidu.swan.apps.res.widget.dialog.g.c
    public void a(g gVar, g.b bVar) {
        if (gVar != null && bVar != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            b(gVar);
            ViewGroup viewGroup = (ViewGroup) gVar.findViewById(16908290);
            if (viewGroup != null) {
                if (com.baidu.swan.apps.u.a.EJ().Fi()) {
                    d(viewGroup, bVar.aOA);
                } else {
                    k(viewGroup);
                }
            }
        }
    }

    private void b(g gVar) {
        Context context = gVar.getContext();
        if (gVar.getContext() instanceof ContextWrapper) {
            context = ((ContextWrapper) gVar.getContext()).getBaseContext();
        }
        if (context instanceof Activity) {
            com.baidu.swan.apps.an.b.b((Activity) context, gVar);
        }
    }

    private void d(final ViewGroup viewGroup, final View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.swan.apps.view.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aVZ == null) {
                        a.this.aVZ = new FrameLayout(viewGroup.getContext());
                        a.this.aVZ.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(a.this.aVZ);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    viewGroup.addView(a.this.aVZ, layoutParams);
                }
            });
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aVZ != null) {
            viewGroup.removeView(this.aVZ);
            this.aVZ = null;
        }
    }
}

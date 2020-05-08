package com.baidu.swan.apps.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.c;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class a implements g.c {
    private FrameLayout ctI = null;

    @Override // com.baidu.swan.apps.res.widget.dialog.g.c
    public void a(g gVar, g.b bVar) {
        if (gVar != null && bVar != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            a(gVar);
            ViewGroup viewGroup = (ViewGroup) gVar.findViewById(16908290);
            if (viewGroup != null) {
                if (com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
                    d(viewGroup, bVar.mDialogLayout);
                } else {
                    s(viewGroup);
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
            c.b((Activity) context, gVar);
        }
    }

    private void d(final ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ctI == null) {
                        a.this.ctI = new FrameLayout(viewGroup.getContext());
                        a.this.ctI.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(a.this.ctI);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    viewGroup.addView(a.this.ctI, layoutParams);
                }
            });
        }
    }

    private void s(ViewGroup viewGroup) {
        if (viewGroup != null && this.ctI != null) {
            viewGroup.removeView(this.ctI);
            this.ctI = null;
        }
    }
}

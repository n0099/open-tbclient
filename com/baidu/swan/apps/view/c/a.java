package com.baidu.swan.apps.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes8.dex */
public class a implements g.c {
    private FrameLayout dMa = null;

    @Override // com.baidu.swan.apps.res.widget.dialog.g.c
    public void a(g gVar, g.b bVar) {
        if (gVar != null && bVar != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            a(gVar);
            ViewGroup viewGroup = (ViewGroup) gVar.findViewById(16908290);
            if (viewGroup != null) {
                if (com.baidu.swan.apps.t.a.axv().ail()) {
                    e(viewGroup, bVar.dCX);
                } else {
                    I(viewGroup);
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

    private void e(final ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.swan.apps.view.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dMa == null) {
                        a.this.dMa = new FrameLayout(viewGroup.getContext());
                        a.this.dMa.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(a.this.dMa);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    viewGroup.addView(a.this.dMa, layoutParams);
                }
            });
        }
    }

    private void I(ViewGroup viewGroup) {
        if (viewGroup != null && this.dMa != null) {
            viewGroup.removeView(this.dMa);
            this.dMa = null;
        }
    }
}

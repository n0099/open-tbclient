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
import com.baidu.swan.apps.res.widget.dialog.e;
/* loaded from: classes2.dex */
public class a implements e.c {
    private FrameLayout aSd = null;

    @Override // com.baidu.swan.apps.res.widget.dialog.e.c
    public void a(e eVar, e.b bVar) {
        if (eVar != null && bVar != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            b(eVar);
            ViewGroup viewGroup = (ViewGroup) eVar.findViewById(16908290);
            if (viewGroup != null) {
                if (com.baidu.swan.apps.u.a.CR().Dq()) {
                    d(viewGroup, bVar.aLA);
                } else {
                    k(viewGroup);
                }
            }
        }
    }

    private void b(e eVar) {
        Context context = eVar.getContext();
        if (eVar.getContext() instanceof ContextWrapper) {
            context = ((ContextWrapper) eVar.getContext()).getBaseContext();
        }
        if (context instanceof Activity) {
            com.baidu.swan.apps.an.b.a((Activity) context, eVar);
        }
    }

    private void d(final ViewGroup viewGroup, final View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.swan.apps.view.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aSd == null) {
                        a.this.aSd = new FrameLayout(viewGroup.getContext());
                        a.this.aSd.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(a.this.aSd);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    viewGroup.addView(a.this.aSd, layoutParams);
                }
            });
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aSd != null) {
            viewGroup.removeView(this.aSd);
            this.aSd = null;
        }
    }
}

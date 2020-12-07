package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes25.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dED = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState()) {
                C(baseMenuView);
            } else {
                D(baseMenuView);
            }
        }
    }

    private void C(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dED == null) {
                this.dED = new FrameLayout(viewGroup.getContext());
                this.dED.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dED);
            viewGroup.addView(this.dED, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void D(ViewGroup viewGroup) {
        if (viewGroup != null && this.dED != null) {
            viewGroup.removeView(this.dED);
            this.dED = null;
        }
    }
}

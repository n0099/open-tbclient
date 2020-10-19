package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dkR = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState()) {
                D(baseMenuView);
            } else {
                E(baseMenuView);
            }
        }
    }

    private void D(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dkR == null) {
                this.dkR = new FrameLayout(viewGroup.getContext());
                this.dkR.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dkR);
            viewGroup.addView(this.dkR, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void E(ViewGroup viewGroup) {
        if (viewGroup != null && this.dkR != null) {
            viewGroup.removeView(this.dkR);
            this.dkR = null;
        }
    }
}

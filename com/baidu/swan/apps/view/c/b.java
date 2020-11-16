package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dxE = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState()) {
                C(baseMenuView);
            } else {
                D(baseMenuView);
            }
        }
    }

    private void C(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dxE == null) {
                this.dxE = new FrameLayout(viewGroup.getContext());
                this.dxE.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dxE);
            viewGroup.addView(this.dxE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void D(ViewGroup viewGroup) {
        if (viewGroup != null && this.dxE != null) {
            viewGroup.removeView(this.dxE);
            this.dxE = null;
        }
    }
}

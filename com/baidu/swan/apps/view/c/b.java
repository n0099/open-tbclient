package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout cNE = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState()) {
                y(mainMenuView);
            } else {
                z(mainMenuView);
            }
            mainMenuView.setCoverView(this.cNE);
        }
    }

    private void y(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.cNE == null) {
                this.cNE = new FrameLayout(viewGroup.getContext());
                this.cNE.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cNE);
            viewGroup.addView(this.cNE, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void z(ViewGroup viewGroup) {
        if (viewGroup != null && this.cNE != null) {
            viewGroup.removeView(this.cNE);
            this.cNE = null;
        }
    }
}

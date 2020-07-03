package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout cKn = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState()) {
                x(mainMenuView);
            } else {
                y(mainMenuView);
            }
            mainMenuView.setCoverView(this.cKn);
        }
    }

    private void x(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.cKn == null) {
                this.cKn = new FrameLayout(viewGroup.getContext());
                this.cKn.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cKn);
            viewGroup.addView(this.cKn, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void y(ViewGroup viewGroup) {
        if (viewGroup != null && this.cKn != null) {
            viewGroup.removeView(this.cKn);
            this.cKn = null;
        }
    }
}

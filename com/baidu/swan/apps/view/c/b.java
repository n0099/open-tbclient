package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout bUA = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState()) {
                q(mainMenuView);
            } else {
                r(mainMenuView);
            }
            mainMenuView.setCoverView(this.bUA);
        }
    }

    private void q(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.bUA == null) {
                this.bUA = new FrameLayout(viewGroup.getContext());
                this.bUA.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUA);
            viewGroup.addView(this.bUA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUA != null) {
            viewGroup.removeView(this.bUA);
            this.bUA = null;
        }
    }
}

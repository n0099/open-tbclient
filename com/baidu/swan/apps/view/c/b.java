package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout bQu = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState()) {
                p(mainMenuView);
            } else {
                q(mainMenuView);
            }
            mainMenuView.setCoverView(this.bQu);
        }
    }

    private void p(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.bQu == null) {
                this.bQu = new FrameLayout(viewGroup.getContext());
                this.bQu.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bQu);
            viewGroup.addView(this.bQu, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void q(ViewGroup viewGroup) {
        if (viewGroup != null && this.bQu != null) {
            viewGroup.removeView(this.bQu);
            this.bQu = null;
        }
    }
}

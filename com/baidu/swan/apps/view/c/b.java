package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout ctC = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
                r(mainMenuView);
            } else {
                s(mainMenuView);
            }
            mainMenuView.setCoverView(this.ctC);
        }
    }

    private void r(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.ctC == null) {
                this.ctC = new FrameLayout(viewGroup.getContext());
                this.ctC.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.ctC);
            viewGroup.addView(this.ctC, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void s(ViewGroup viewGroup) {
        if (viewGroup != null && this.ctC != null) {
            viewGroup.removeView(this.ctC);
            this.ctC = null;
        }
    }
}

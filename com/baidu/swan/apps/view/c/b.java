package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout ctI = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState()) {
                r(mainMenuView);
            } else {
                s(mainMenuView);
            }
            mainMenuView.setCoverView(this.ctI);
        }
    }

    private void r(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.ctI == null) {
                this.ctI = new FrameLayout(viewGroup.getContext());
                this.ctI.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.ctI);
            viewGroup.addView(this.ctI, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void s(ViewGroup viewGroup) {
        if (viewGroup != null && this.ctI != null) {
            viewGroup.removeView(this.ctI);
            this.ctI = null;
        }
    }
}

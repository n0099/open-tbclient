package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout cFD = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState()) {
                v(mainMenuView);
            } else {
                w(mainMenuView);
            }
            mainMenuView.setCoverView(this.cFD);
        }
    }

    private void v(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.cFD == null) {
                this.cFD = new FrameLayout(viewGroup.getContext());
                this.cFD.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cFD);
            viewGroup.addView(this.cFD, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void w(ViewGroup viewGroup) {
        if (viewGroup != null && this.cFD != null) {
            viewGroup.removeView(this.cFD);
            this.cFD = null;
        }
    }
}

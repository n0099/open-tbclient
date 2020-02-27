package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout bUz = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState()) {
                q(mainMenuView);
            } else {
                r(mainMenuView);
            }
            mainMenuView.setCoverView(this.bUz);
        }
    }

    private void q(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.bUz == null) {
                this.bUz = new FrameLayout(viewGroup.getContext());
                this.bUz.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bUz);
            viewGroup.addView(this.bUz, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void r(ViewGroup viewGroup) {
        if (viewGroup != null && this.bUz != null) {
            viewGroup.removeView(this.bUz);
            this.bUz = null;
        }
    }
}

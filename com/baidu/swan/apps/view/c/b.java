package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout bPK = null;

    @Override // com.baidu.swan.menu.a
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState()) {
                m(mainMenuView);
            } else {
                n(mainMenuView);
            }
            mainMenuView.setCoverView(this.bPK);
        }
    }

    private void m(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.bPK == null) {
                this.bPK = new FrameLayout(viewGroup.getContext());
                this.bPK.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bPK);
            viewGroup.addView(this.bPK, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.bPK != null) {
            viewGroup.removeView(this.bPK);
            this.bPK = null;
        }
    }
}

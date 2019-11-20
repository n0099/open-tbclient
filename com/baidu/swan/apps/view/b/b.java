package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.menu.b {
    private FrameLayout boL = null;

    @Override // com.baidu.swan.menu.b
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.JE().Kd()) {
                m(mainMenuView);
            } else {
                n(mainMenuView);
            }
            mainMenuView.setCoverView(this.boL);
        }
    }

    private void m(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.boL == null) {
                this.boL = new FrameLayout(viewGroup.getContext());
                this.boL.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.boL);
            viewGroup.addView(this.boL, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.boL != null) {
            viewGroup.removeView(this.boL);
            this.boL = null;
        }
    }
}

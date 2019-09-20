package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.menu.b {
    private FrameLayout aVZ = null;

    @Override // com.baidu.swan.menu.b
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.EJ().Fi()) {
                j(mainMenuView);
            } else {
                k(mainMenuView);
            }
            mainMenuView.setCoverView(this.aVZ);
        }
    }

    private void j(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.aVZ == null) {
                this.aVZ = new FrameLayout(viewGroup.getContext());
                this.aVZ.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aVZ);
            viewGroup.addView(this.aVZ, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aVZ != null) {
            viewGroup.removeView(this.aVZ);
            this.aVZ = null;
        }
    }
}

package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.c;
/* loaded from: classes2.dex */
public class b implements c {
    private FrameLayout aRY = null;

    @Override // com.baidu.swan.menu.c
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.CT().Ds()) {
                j(mainMenuView);
            } else {
                k(mainMenuView);
            }
            mainMenuView.setCoverView(this.aRY);
        }
    }

    private void j(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.aRY == null) {
                this.aRY = new FrameLayout(viewGroup.getContext());
                this.aRY.setBackgroundResource(b.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aRY);
            viewGroup.addView(this.aRY, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aRY != null) {
            viewGroup.removeView(this.aRY);
            this.aRY = null;
        }
    }
}

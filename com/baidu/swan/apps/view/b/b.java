package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.c;
/* loaded from: classes2.dex */
public class b implements c {
    private FrameLayout aRZ = null;

    @Override // com.baidu.swan.menu.c
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.CT().Ds()) {
                j(mainMenuView);
            } else {
                k(mainMenuView);
            }
            mainMenuView.setCoverView(this.aRZ);
        }
    }

    private void j(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.aRZ == null) {
                this.aRZ = new FrameLayout(viewGroup.getContext());
                this.aRZ.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aRZ);
            viewGroup.addView(this.aRZ, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aRZ != null) {
            viewGroup.removeView(this.aRZ);
            this.aRZ = null;
        }
    }
}

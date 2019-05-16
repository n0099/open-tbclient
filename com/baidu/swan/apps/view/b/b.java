package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.menu.b {
    private FrameLayout aUR = null;

    @Override // com.baidu.swan.menu.b
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.DW().Ev()) {
                j(mainMenuView);
            } else {
                k(mainMenuView);
            }
            mainMenuView.setCoverView(this.aUR);
        }
    }

    private void j(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.aUR == null) {
                this.aUR = new FrameLayout(viewGroup.getContext());
                this.aUR.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.aUR);
            viewGroup.addView(this.aUR, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void k(ViewGroup viewGroup) {
        if (viewGroup != null && this.aUR != null) {
            viewGroup.removeView(this.aUR);
            this.aUR = null;
        }
    }
}

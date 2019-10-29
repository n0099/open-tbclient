package com.baidu.swan.apps.view.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.MainMenuView;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.menu.b {
    private FrameLayout bpd = null;

    @Override // com.baidu.swan.menu.b
    public void a(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.u.a.JD().Kc()) {
                m(mainMenuView);
            } else {
                n(mainMenuView);
            }
            mainMenuView.setCoverView(this.bpd);
        }
    }

    private void m(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.bpd == null) {
                this.bpd = new FrameLayout(viewGroup.getContext());
                this.bpd.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.bpd);
            viewGroup.addView(this.bpd, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.bpd != null) {
            viewGroup.removeView(this.bpd);
            this.bpd = null;
        }
    }
}

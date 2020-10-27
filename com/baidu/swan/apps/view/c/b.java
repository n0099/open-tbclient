package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dtt = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState()) {
                E(baseMenuView);
            } else {
                F(baseMenuView);
            }
        }
    }

    private void E(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dtt == null) {
                this.dtt = new FrameLayout(viewGroup.getContext());
                this.dtt.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dtt);
            viewGroup.addView(this.dtt, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void F(ViewGroup viewGroup) {
        if (viewGroup != null && this.dtt != null) {
            viewGroup.removeView(this.dtt);
            this.dtt = null;
        }
    }
}

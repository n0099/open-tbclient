package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout cWD = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState()) {
                z(baseMenuView);
            } else {
                A(baseMenuView);
            }
        }
    }

    private void z(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.cWD == null) {
                this.cWD = new FrameLayout(viewGroup.getContext());
                this.cWD.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cWD);
            viewGroup.addView(this.cWD, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void A(ViewGroup viewGroup) {
        if (viewGroup != null && this.cWD != null) {
            viewGroup.removeView(this.cWD);
            this.cWD = null;
        }
    }
}

package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes3.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout cYH = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState()) {
                B(baseMenuView);
            } else {
                C(baseMenuView);
            }
        }
    }

    private void B(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.cYH == null) {
                this.cYH = new FrameLayout(viewGroup.getContext());
                this.cYH.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.cYH);
            viewGroup.addView(this.cYH, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void C(ViewGroup viewGroup) {
        if (viewGroup != null && this.cYH != null) {
            viewGroup.removeView(this.cYH);
            this.cYH = null;
        }
    }
}

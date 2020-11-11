package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dzl = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState()) {
                G(baseMenuView);
            } else {
                H(baseMenuView);
            }
        }
    }

    private void G(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dzl == null) {
                this.dzl = new FrameLayout(viewGroup.getContext());
                this.dzl.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dzl);
            viewGroup.addView(this.dzl, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void H(ViewGroup viewGroup) {
        if (viewGroup != null && this.dzl != null) {
            viewGroup.removeView(this.dzl);
            this.dzl = null;
        }
    }
}

package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dKz = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.axs().aii()) {
                H(baseMenuView);
            } else {
                I(baseMenuView);
            }
        }
    }

    private void H(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dKz == null) {
                this.dKz = new FrameLayout(viewGroup.getContext());
                this.dKz.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dKz);
            viewGroup.addView(this.dKz, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void I(ViewGroup viewGroup) {
        if (viewGroup != null && this.dKz != null) {
            viewGroup.removeView(this.dKz);
            this.dKz = null;
        }
    }
}

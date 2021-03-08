package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dMa = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.axv().ail()) {
                H(baseMenuView);
            } else {
                I(baseMenuView);
            }
        }
    }

    private void H(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dMa == null) {
                this.dMa = new FrameLayout(viewGroup.getContext());
                this.dMa.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dMa);
            viewGroup.addView(this.dMa, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void I(ViewGroup viewGroup) {
        if (viewGroup != null && this.dMa != null) {
            viewGroup.removeView(this.dMa);
            this.dMa = null;
        }
    }
}

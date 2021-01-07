package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dNh = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.aAO().alE()) {
                J(baseMenuView);
            } else {
                K(baseMenuView);
            }
        }
    }

    private void J(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dNh == null) {
                this.dNh = new FrameLayout(viewGroup.getContext());
                this.dNh.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dNh);
            viewGroup.addView(this.dNh, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void K(ViewGroup viewGroup) {
        if (viewGroup != null && this.dNh != null) {
            viewGroup.removeView(this.dNh);
            this.dNh = null;
        }
    }
}

package com.baidu.swan.apps.view.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.menu.a {
    private FrameLayout dIv = null;

    @Override // com.baidu.swan.menu.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView != null && !ProcessUtils.isMainProcess() && SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            if (com.baidu.swan.apps.t.a.awU().ahK()) {
                J(baseMenuView);
            } else {
                K(baseMenuView);
            }
        }
    }

    private void J(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.dIv == null) {
                this.dIv = new FrameLayout(viewGroup.getContext());
                this.dIv.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dIv);
            viewGroup.addView(this.dIv, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void K(ViewGroup viewGroup) {
        if (viewGroup != null && this.dIv != null) {
            viewGroup.removeView(this.dIv);
            this.dIv = null;
        }
    }
}

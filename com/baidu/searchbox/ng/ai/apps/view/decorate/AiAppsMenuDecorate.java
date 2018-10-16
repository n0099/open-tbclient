package com.baidu.searchbox.ng.ai.apps.view.decorate;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsProcessInfo;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.aiapps.menu.IAiAppMenuDecorate;
import com.baidu.searchbox.ng.aiapps.menu.MainMenuView;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes2.dex */
public class AiAppsMenuDecorate implements IAiAppMenuDecorate {
    private FrameLayout mCoverLayer = null;

    @Override // com.baidu.searchbox.ng.aiapps.menu.IAiAppMenuDecorate
    public void decorateMainMenuView(MainMenuView mainMenuView) {
        if (mainMenuView != null && !ProcessUtils.isMainProcess() && AiAppsProcessInfo.isAiAppsProcess(ProcessUtils.getCurProcessName())) {
            if (AiAppNightModeHelper.getNightModeSwitcherState()) {
                decorateNightModeCover(mainMenuView);
            } else {
                removeNightModeCover(mainMenuView);
            }
            mainMenuView.setCoverView(this.mCoverLayer);
        }
    }

    private void decorateNightModeCover(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.mCoverLayer == null) {
                this.mCoverLayer = new FrameLayout(viewGroup.getContext());
                this.mCoverLayer.setBackgroundResource(R.color.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.mCoverLayer);
            viewGroup.addView(this.mCoverLayer, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void removeNightModeCover(ViewGroup viewGroup) {
        if (viewGroup != null && this.mCoverLayer != null) {
            viewGroup.removeView(this.mCoverLayer);
            this.mCoverLayer = null;
        }
    }
}

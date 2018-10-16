package com.baidu.searchbox.ng.ai.apps.view.decorate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsProcessInfo;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes2.dex */
public class AiAppsDialogDecorate implements AiAppAlertDialog.IDecorate {
    private FrameLayout mCoverLayer = null;

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.IDecorate
    public void decorate(AiAppAlertDialog aiAppAlertDialog, AiAppAlertDialog.DialogElement dialogElement) {
        ViewGroup viewGroup;
        if (aiAppAlertDialog != null && dialogElement != null && !ProcessUtils.isMainProcess() && AiAppsProcessInfo.isAiAppsProcess(ProcessUtils.getCurProcessName()) && (viewGroup = (ViewGroup) aiAppAlertDialog.findViewById(16908290)) != null) {
            if (AiAppNightModeHelper.getNightModeSwitcherState()) {
                decorateNightModeCover(viewGroup, dialogElement.mDialogLayout);
            } else {
                removeNightModeCover(viewGroup);
            }
        }
    }

    private void decorateNightModeCover(final ViewGroup viewGroup, final View view) {
        if (viewGroup != null && view != null && (viewGroup instanceof FrameLayout)) {
            view.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AiAppsDialogDecorate.this.mCoverLayer == null) {
                        AiAppsDialogDecorate.this.mCoverLayer = new FrameLayout(viewGroup.getContext());
                        AiAppsDialogDecorate.this.mCoverLayer.setBackgroundResource(R.color.aiapps_night_mode_cover_layer);
                    }
                    viewGroup.removeView(AiAppsDialogDecorate.this.mCoverLayer);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    viewGroup.addView(AiAppsDialogDecorate.this.mCoverLayer, layoutParams);
                }
            });
        }
    }

    private void removeNightModeCover(ViewGroup viewGroup) {
        if (viewGroup != null && this.mCoverLayer != null) {
            viewGroup.removeView(this.mCoverLayer);
            this.mCoverLayer = null;
        }
    }
}

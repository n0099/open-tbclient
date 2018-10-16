package com.baidu.searchbox.ng.ai.apps.canvas.manager;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasViewModel;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
/* loaded from: classes2.dex */
public abstract class AbsCanvasManager implements ICanvasManager {
    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public CanvasViewModel getCanvasViewModelByCanvasId(CanvasBasicModel canvasBasicModel) {
        if (canvasBasicModel == null) {
            return null;
        }
        String str = canvasBasicModel.slaveId;
        String str2 = canvasBasicModel.id;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        AiAppsSlaveManager aiAppsSlaveManager = (AiAppsSlaveManager) AiAppsController.getInstance().getWebViewManager(canvasBasicModel.slaveId);
        return aiAppsSlaveManager != null ? aiAppsSlaveManager.getCanvasViewModelByCanvasId(canvasBasicModel.id) : null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public CanvasView getCanvasViewByCanvasId(CanvasBasicModel canvasBasicModel) {
        CanvasViewModel canvasViewModelByCanvasId = getCanvasViewModelByCanvasId(canvasBasicModel);
        if (canvasViewModelByCanvasId == null) {
            return null;
        }
        return canvasViewModelByCanvasId.canvasView;
    }
}

package com.baidu.searchbox.ng.ai.apps.canvas;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.manager.AbsCanvasManager;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasDrawModel;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasViewModel;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public class CanvasManager extends AbsCanvasManager {
    private static final String MODULE_TAG = "AiAppCanvas";

    private CanvasManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final CanvasManager sInstance = new CanvasManager();

        private SingletonHolder() {
        }
    }

    public static CanvasManager getIns() {
        return SingletonHolder.sInstance;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public boolean insert(Context context, WebView webView, CanvasBasicModel canvasBasicModel) {
        if (context == null || webView == null || canvasBasicModel == null) {
            AiAppsLog.e(MODULE_TAG, "some params is invalid");
            return false;
        }
        String str = canvasBasicModel.id;
        AiAppsRectPosition aiAppsRectPosition = canvasBasicModel.position;
        if (TextUtils.isEmpty(str) || aiAppsRectPosition == null || !aiAppsRectPosition.isValid()) {
            AiAppsLog.e(MODULE_TAG, "canvas id is empty or position is null");
            return false;
        }
        CanvasViewModel canvasViewModel = new CanvasViewModel(context, str, canvasBasicModel);
        AiAppsSlaveManager aiAppsSlaveManager = (AiAppsSlaveManager) AiAppsController.getInstance().getWebViewManager(canvasBasicModel.slaveId);
        if (aiAppsSlaveManager != null) {
            aiAppsSlaveManager.insertCanvas(canvasViewModel);
        }
        new AiAppsNAViewContainer(webView.getContext()).insertView(canvasViewModel.canvasView, canvasBasicModel);
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public boolean remove(WebView webView, CanvasBasicModel canvasBasicModel) {
        AiAppsSlaveManager aiAppsSlaveManager;
        boolean z = false;
        if (webView == null || canvasBasicModel == null) {
            AiAppsLog.e(MODULE_TAG, "some params is invalid");
            return false;
        }
        CanvasViewModel canvasViewModelByCanvasId = getCanvasViewModelByCanvasId(canvasBasicModel);
        if (canvasViewModelByCanvasId == null) {
            AiAppsLog.e(MODULE_TAG, "get canvas view model is null");
            return false;
        }
        CanvasView canvasView = canvasViewModelByCanvasId.canvasView;
        if (canvasView != null) {
            canvasView.onRelease();
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(canvasBasicModel, null);
        if (findNAViewContainer != null && findNAViewContainer.removeView()) {
            z = true;
        }
        if (z && (aiAppsSlaveManager = (AiAppsSlaveManager) AiAppsController.getInstance().getWebViewManager(canvasBasicModel.slaveId)) != null) {
            aiAppsSlaveManager.removeCanvas(canvasViewModelByCanvasId);
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public boolean update(WebView webView, CanvasBasicModel canvasBasicModel) {
        AiAppsNAViewContainer findNAViewContainer;
        if (webView == null || canvasBasicModel == null) {
            AiAppsLog.e(MODULE_TAG, "some params is invalid");
            return false;
        }
        String str = canvasBasicModel.id;
        AiAppsRectPosition aiAppsRectPosition = canvasBasicModel.position;
        return (TextUtils.isEmpty(str) || aiAppsRectPosition == null || !aiAppsRectPosition.isValid() || (findNAViewContainer = NAViewFinder.findNAViewContainer(canvasBasicModel, null)) == null || !findNAViewContainer.updateView(canvasBasicModel)) ? false : true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.manager.ICanvasManager
    public boolean drawCanvas(Context context, CanvasBasicModel canvasBasicModel) {
        AiAppsFragment topAiAppsFragment;
        if (context == null || canvasBasicModel == null || !(canvasBasicModel instanceof CanvasDrawModel)) {
            AiAppsLog.e(MODULE_TAG, "some params is invalid");
            return false;
        }
        String str = canvasBasicModel.id;
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.e(MODULE_TAG, "drawCanvas canvasId = " + str);
            return false;
        }
        if (TextUtils.isEmpty(canvasBasicModel.slaveId) && (topAiAppsFragment = AiAppsController.getInstance().getTopAiAppsFragment()) != null) {
            canvasBasicModel.slaveId = topAiAppsFragment.getSlaveWebViewId();
        }
        CanvasView canvasViewByCanvasId = getCanvasViewByCanvasId(canvasBasicModel);
        if (canvasViewByCanvasId == null) {
            AiAppsLog.e(MODULE_TAG, "drawCanvas get canvas view is null");
            return false;
        }
        CanvasDrawModel canvasDrawModel = (CanvasDrawModel) canvasBasicModel;
        canvasViewByCanvasId.addDrawActionList(canvasDrawModel.getDrawActionList(), canvasDrawModel.isReserve());
        canvasViewByCanvasId.postInvalidate();
        return true;
    }
}

package com.baidu.searchbox.ng.ai.apps.view.container.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot;
import com.baidu.searchbox.ng.ai.apps.view.container.model.NAViewCache;
/* loaded from: classes2.dex */
public class NAViewUtils {
    public static boolean attachNAViewToParent(AiAppsNAViewContainer aiAppsNAViewContainer, @NonNull IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        if (aiAppsNAViewContainer == null || aiAppsNAViewContainer.getModel() == null) {
            return false;
        }
        AiAppsNaViewModel model = aiAppsNAViewContainer.getModel();
        if (TextUtils.isEmpty(model.parentId)) {
            if (model.position == null) {
                model.position = new AiAppsRectPosition();
            }
            return iAiAppsNAViewRoot.insertView(aiAppsNAViewContainer, model.position);
        }
        return attachNAViewToParent(aiAppsNAViewContainer);
    }

    private static boolean attachNAViewToParent(AiAppsNAViewContainer aiAppsNAViewContainer) {
        AiAppsNaViewModel model;
        AiAppsNAViewContainer findNAViewById;
        if (aiAppsNAViewContainer == null) {
            return false;
        }
        String parentId = aiAppsNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId) || (model = aiAppsNAViewContainer.getModel()) == null || model.position == null || !model.position.isValid() || (findNAViewById = NAViewFinder.findNAViewById(aiAppsNAViewContainer.getSlaveId(), parentId, null)) == null) {
            return false;
        }
        findNAViewById.addView(aiAppsNAViewContainer, model.generateLayoutParams());
        return true;
    }

    public static boolean removeNAViewFromParent(AiAppsNAViewContainer aiAppsNAViewContainer, @NonNull IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        if (aiAppsNAViewContainer == null || aiAppsNAViewContainer.getModel() == null) {
            return false;
        }
        if (TextUtils.isEmpty(aiAppsNAViewContainer.getModel().parentId)) {
            return iAiAppsNAViewRoot.removeView(aiAppsNAViewContainer);
        }
        return removeNAViewFromParent(aiAppsNAViewContainer);
    }

    private static boolean removeNAViewFromParent(AiAppsNAViewContainer aiAppsNAViewContainer) {
        AiAppsNAViewContainer findNAViewById;
        if (aiAppsNAViewContainer == null) {
            return false;
        }
        String parentId = aiAppsNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId) || (findNAViewById = NAViewFinder.findNAViewById(aiAppsNAViewContainer.getSlaveId(), parentId, null)) == null) {
            return false;
        }
        findNAViewById.removeView(aiAppsNAViewContainer);
        return true;
    }

    public static boolean updateNAView(AiAppsNAViewContainer aiAppsNAViewContainer, AiAppsNaViewModel aiAppsNaViewModel) {
        AiAppsNaViewModel model;
        if (aiAppsNAViewContainer == null || aiAppsNaViewModel == null || aiAppsNaViewModel.position == null || !aiAppsNaViewModel.position.isValid() || (model = aiAppsNAViewContainer.getModel()) == null || model.position == null || !model.position.isValid()) {
            return false;
        }
        if ((diffNAViewModel(model, aiAppsNaViewModel).get() & 1) == 1) {
            performPositionChange(aiAppsNAViewContainer, aiAppsNaViewModel, model);
        }
        aiAppsNAViewContainer.bindModel(aiAppsNaViewModel);
        return true;
    }

    private static void performPositionChange(@NonNull AiAppsNAViewContainer aiAppsNAViewContainer, AiAppsNaViewModel aiAppsNaViewModel, AiAppsNaViewModel aiAppsNaViewModel2) {
        String parentId = aiAppsNAViewContainer.getParentId();
        if (TextUtils.isEmpty(parentId)) {
            IAiAppsNAViewRoot viewRoot = getViewRoot(aiAppsNaViewModel.slaveId);
            if (viewRoot != null) {
                viewRoot.updateView(aiAppsNAViewContainer, aiAppsNaViewModel.position);
            } else {
                return;
            }
        } else {
            AiAppsNAViewContainer findNAViewById = NAViewFinder.findNAViewById(aiAppsNaViewModel.slaveId, parentId, null);
            if (findNAViewById != null) {
                findNAViewById.updateViewLayout(aiAppsNAViewContainer, aiAppsNaViewModel.generateLayoutParams());
            } else {
                return;
            }
        }
        if (aiAppsNaViewModel2 != null) {
            aiAppsNaViewModel2.setPosition(aiAppsNaViewModel.position);
        }
    }

    @NonNull
    public static Diff diffNAViewModel(AiAppsNaViewModel aiAppsNaViewModel, AiAppsNaViewModel aiAppsNaViewModel2) {
        Diff diff = new Diff();
        if (aiAppsNaViewModel != aiAppsNaViewModel2) {
            if (aiAppsNaViewModel != null && aiAppsNaViewModel2 != null) {
                aiAppsNaViewModel.diff(aiAppsNaViewModel2, diff);
            } else {
                diff.mask(15);
            }
        }
        return diff;
    }

    public static void registerWidgetToCache(AiAppsNAViewContainer aiAppsNAViewContainer, @Nullable IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        NAViewCache nAViewCache;
        if (iAiAppsNAViewRoot == null) {
            iAiAppsNAViewRoot = getViewRoot(aiAppsNAViewContainer.getSlaveId());
        }
        if (iAiAppsNAViewRoot != null && (nAViewCache = iAiAppsNAViewRoot.getNAViewCache()) != null) {
            nAViewCache.registerWidget(aiAppsNAViewContainer);
        }
    }

    public static void unregisterWidgetFromCache(AiAppsNAViewContainer aiAppsNAViewContainer, IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        NAViewCache nAViewCache;
        if (iAiAppsNAViewRoot == null) {
            iAiAppsNAViewRoot = getViewRoot(aiAppsNAViewContainer.getSlaveId());
        }
        if (iAiAppsNAViewRoot != null && (nAViewCache = iAiAppsNAViewRoot.getNAViewCache()) != null) {
            nAViewCache.unregisterWidget(aiAppsNAViewContainer);
        }
    }

    public static IAiAppsNAViewRoot getViewRoot(String str) {
        return AiAppsUtils.getCurrentNAViewRoot(str);
    }
}

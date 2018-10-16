package com.baidu.searchbox.ng.ai.apps.view.container.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot;
import com.baidu.searchbox.ng.ai.apps.view.container.model.NAViewCache;
/* loaded from: classes2.dex */
public class NAViewFinder {
    public static AiAppsNAViewContainer findNAViewContainer(AiAppsNaViewModel aiAppsNaViewModel, @Nullable IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        if (aiAppsNaViewModel == null) {
            return null;
        }
        return findNAViewById(aiAppsNaViewModel.slaveId, aiAppsNaViewModel.id, iAiAppsNAViewRoot);
    }

    public static AiAppsNAViewContainer findNAViewById(String str, String str2, @Nullable IAiAppsNAViewRoot iAiAppsNAViewRoot) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (iAiAppsNAViewRoot == null) {
            iAiAppsNAViewRoot = NAViewUtils.getViewRoot(str);
        }
        if (iAiAppsNAViewRoot == null) {
            return null;
        }
        NAViewCache nAViewCache = iAiAppsNAViewRoot.getNAViewCache();
        if (nAViewCache == null || nAViewCache.getWidgetList() == null) {
            return null;
        }
        for (View view : nAViewCache.getWidgetList()) {
            if (view instanceof AiAppsNAViewContainer) {
                AiAppsNAViewContainer aiAppsNAViewContainer = (AiAppsNAViewContainer) view;
                if (TextUtils.equals(aiAppsNAViewContainer.getViewId(), str2)) {
                    return aiAppsNAViewContainer;
                }
            }
        }
        return null;
    }
}

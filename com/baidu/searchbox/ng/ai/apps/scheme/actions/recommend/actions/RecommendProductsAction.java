package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
/* loaded from: classes2.dex */
public class RecommendProductsAction extends BaseRecommendAction {
    private static final String ACTION_TYPE = "/swan/recommendProducts";
    private static final boolean DEBUG = false;
    private static final String TAG = "RecommendProductsAction";

    public RecommendProductsAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction
    @NonNull
    protected String getUrl() {
        return AiAppsRuntime.getConfigRuntime().getRecommendProductsUrl();
    }
}

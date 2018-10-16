package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
/* loaded from: classes2.dex */
public class RecommendSimilarAction extends BaseRecommendAction {
    private static final String ACTION_TYPE = "/swan/recommendSimilarProducts";
    private static final boolean DEBUG = false;
    private static final String TAG = "RecommendSimilarAction";

    public RecommendSimilarAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction
    @NonNull
    protected String getUrl() {
        return AiAppsRuntime.getConfigRuntime().getRecommendSimilarUrl();
    }
}

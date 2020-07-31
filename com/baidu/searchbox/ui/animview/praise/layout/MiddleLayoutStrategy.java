package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes7.dex */
public class MiddleLayoutStrategy extends BaseLayoutStrategy {
    private static final float PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL = 0.5f;

    public MiddleLayoutStrategy(Rect rect, int i, int i2, IResourceProvider iResourceProvider) {
        super(rect, i, i2, iResourceProvider);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseLevelFactorPosX() {
        return 0.5f;
    }
}

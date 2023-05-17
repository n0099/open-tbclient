package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes4.dex */
public class RightLayoutStrategy extends BaseLayoutStrategy {
    public static final float PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL = 0.75f;

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    public float getPraiseLevelFactorPosX() {
        return 0.75f;
    }

    public RightLayoutStrategy(Rect rect, int i, int i2, IResourceProvider iResourceProvider) {
        super(rect, i, i2, iResourceProvider);
    }
}

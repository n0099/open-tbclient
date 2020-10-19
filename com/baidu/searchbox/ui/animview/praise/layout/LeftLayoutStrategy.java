package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes9.dex */
public class LeftLayoutStrategy extends BaseLayoutStrategy {
    private static final float PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL = 0.14f;
    private static final float PRAISELEVEL_SIZE_DP = 360.0f;
    private static final float PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL = 0.12f;
    private static final float PRAISENUM_FACTOR_POS_DELTA_X_BASED_PRAISELEVEL = 0.08f;
    private static final float PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL = 0.3f;
    private static final float PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL = 0.077295f;

    public LeftLayoutStrategy(Rect rect, int i, int i2, IResourceProvider iResourceProvider) {
        super(rect, i, i2, iResourceProvider);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseLevelFactorPosX() {
        return PRAISELEVEL_FACTOR_POS_X_BASED_PRAISELEVEL;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseNumFactorPosX() {
        return PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseNumFactorPosY() {
        return PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseNumFactorHeight() {
        return PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected int getPraiseLevelSize() {
        return DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), PRAISELEVEL_SIZE_DP);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy
    protected float getPraiseNumFactorDeltaX() {
        return -0.08f;
    }
}

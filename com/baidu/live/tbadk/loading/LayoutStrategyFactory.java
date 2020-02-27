package com.baidu.live.tbadk.loading;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class LayoutStrategyFactory {
    private LayoutStrategyFactory() {
    }

    public static ILayoutStrategy getStategy(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new LinearLayoutStrategy();
        }
        if (view instanceof RelativeLayout) {
            return new RelativeLayoutStrategy();
        }
        if (view instanceof FrameLayout) {
            return new FrameLayoutStrategy();
        }
        return null;
    }
}

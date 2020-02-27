package com.baidu.live.tbadk.loading;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class FrameLayoutStrategy implements ILayoutStrategy {
    @Override // com.baidu.live.tbadk.loading.ILayoutStrategy
    public void attachView(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
    }
}

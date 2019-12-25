package com.baidu.live.tbadk.loading;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class RelativeLayoutStrategy implements ILayoutStrategy {
    @Override // com.baidu.live.tbadk.loading.ILayoutStrategy
    public void attachView(View view, View view2, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (z) {
            relativeLayout.addView(view2, 0);
        } else {
            relativeLayout.addView(view2);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(14);
        view2.setLayoutParams(layoutParams);
    }
}

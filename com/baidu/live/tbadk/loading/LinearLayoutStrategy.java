package com.baidu.live.tbadk.loading;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes10.dex */
public class LinearLayoutStrategy implements ILayoutStrategy {
    @Override // com.baidu.live.tbadk.loading.ILayoutStrategy
    public void attachView(View view, View view2, boolean z) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (z) {
            linearLayout.addView(view2, 0);
        } else {
            linearLayout.addView(view2);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.gravity = 1;
        view2.setLayoutParams(layoutParams);
    }
}

package com.baidu.swan.apps.component.container.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.component.e.a;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    protected static final boolean DEBUG = b.DEBUG;
    private ScrollView bHY;
    private View mTargetView;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i) {
        if (this.mTargetView == view) {
            c.w("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.mTargetView != null) {
            a.aC("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.mTargetView);
        }
        this.mTargetView = view;
        addView(this.mTargetView, i, generateDefaultLayoutParams());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public void setHidden(boolean z) {
        ScrollView scrollView = this.bHY;
        ?? r1 = this;
        if (scrollView != null) {
            r1 = this.bHY;
        }
        r1.setVisibility(z ? 8 : 0);
    }

    public ScrollView getScrollView() {
        return this.bHY;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bHY = scrollView;
    }
}

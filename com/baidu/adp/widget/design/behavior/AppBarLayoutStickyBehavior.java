package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {
    private AppBarLayout awQ;
    private AppBarLayout.OnOffsetChangedListener awR;
    private boolean awS;
    private boolean awT;

    public AppBarLayoutStickyBehavior() {
        this.awS = false;
        this.awT = false;
    }

    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awS = false;
        this.awT = false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.awQ != null && this.awR != null && !this.awT) {
            this.awQ.addOnOffsetChangedListener(this.awR);
            this.awT = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.awQ != null && this.awR != null && this.awT) {
            this.awQ.removeOnOffsetChangedListener(this.awR);
            this.awT = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.x, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.awQ == null) {
            this.awQ = appBarLayout;
        }
        if (this.awR == null) {
            this.awR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior.1
                @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                    if (appBarLayout2 != null) {
                        if (Math.abs(i2) < appBarLayout2.getTotalScrollRange()) {
                            AppBarLayoutStickyBehavior.this.awS = false;
                        } else if (!AppBarLayoutStickyBehavior.this.awS) {
                            AppBarLayoutStickyBehavior.this.awS = true;
                            appBarLayout2.setActivated(false);
                            appBarLayout2.setExpanded(false, false);
                        }
                    }
                }
            };
        }
        if (this.awQ != null && this.awR != null && !this.awT) {
            this.awQ.addOnOffsetChangedListener(this.awR);
            this.awT = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        if (this.awS) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
        if (!this.awS) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
        if (!this.awS) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        if (this.awS) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
        if (this.awS) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, appBarLayout, view, f, f2, z);
    }

    public boolean isSticky() {
        return this.awS;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        expandedAppBarLayout(appBarLayout, true);
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        appBarLayout.setActivated(true);
        appBarLayout.setExpanded(true, z);
        this.awS = false;
    }
}

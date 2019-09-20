package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Qi;
    private AppBarLayout.OnOffsetChangedListener Qj;
    private boolean Qk;
    private boolean Ql;

    public AppBarLayoutStickyBehavior() {
        this.Qk = false;
        this.Ql = false;
    }

    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qk = false;
        this.Ql = false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Qi != null && this.Qj != null && !this.Ql) {
            this.Qi.addOnOffsetChangedListener(this.Qj);
            this.Ql = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Qi != null && this.Qj != null && this.Ql) {
            this.Qi.removeOnOffsetChangedListener(this.Qj);
            this.Ql = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Qi == null) {
            this.Qi = appBarLayout;
        }
        if (this.Qj == null) {
            this.Qj = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior.1
                @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                    if (appBarLayout2 != null) {
                        if (Math.abs(i2) < appBarLayout2.getTotalScrollRange()) {
                            AppBarLayoutStickyBehavior.this.Qk = false;
                        } else if (!AppBarLayoutStickyBehavior.this.Qk) {
                            AppBarLayoutStickyBehavior.this.Qk = true;
                            appBarLayout2.setActivated(false);
                            appBarLayout2.setExpanded(false, false);
                        }
                    }
                }
            };
        }
        if (this.Qi != null && this.Qj != null && !this.Ql) {
            this.Qi.addOnOffsetChangedListener(this.Qj);
            this.Ql = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        if (this.Qk) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
        if (!this.Qk) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
        if (!this.Qk) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        if (this.Qk) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
        if (this.Qk) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }

    public boolean isSticky() {
        return this.Qk;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        expandedAppBarLayout(appBarLayout, true);
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        appBarLayout.setActivated(true);
        appBarLayout.setExpanded(true, z);
        this.Qk = false;
    }
}

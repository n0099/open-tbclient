package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {
    private AppBarLayout QZ;
    private AppBarLayout.OnOffsetChangedListener Ra;
    private boolean Rb;
    private boolean Rc;

    public AppBarLayoutStickyBehavior() {
        this.Rb = false;
        this.Rc = false;
    }

    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rb = false;
        this.Rc = false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.QZ != null && this.Ra != null && !this.Rc) {
            this.QZ.addOnOffsetChangedListener(this.Ra);
            this.Rc = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.QZ != null && this.Ra != null && this.Rc) {
            this.QZ.removeOnOffsetChangedListener(this.Ra);
            this.Rc = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.QZ == null) {
            this.QZ = appBarLayout;
        }
        if (this.Ra == null) {
            this.Ra = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior.1
                @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                    if (appBarLayout2 != null) {
                        if (Math.abs(i2) < appBarLayout2.getTotalScrollRange()) {
                            AppBarLayoutStickyBehavior.this.Rb = false;
                        } else if (!AppBarLayoutStickyBehavior.this.Rb) {
                            AppBarLayoutStickyBehavior.this.Rb = true;
                            appBarLayout2.setActivated(false);
                            appBarLayout2.setExpanded(false, false);
                        }
                    }
                }
            };
        }
        if (this.QZ != null && this.Ra != null && !this.Rc) {
            this.QZ.addOnOffsetChangedListener(this.Ra);
            this.Rc = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        if (this.Rb) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
        if (!this.Rb) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
        if (!this.Rb) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        if (this.Rb) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
        if (this.Rb) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }

    public boolean isSticky() {
        return this.Rb;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        expandedAppBarLayout(appBarLayout, true);
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        appBarLayout.setActivated(true);
        appBarLayout.setExpanded(true, z);
        this.Rb = false;
    }
}

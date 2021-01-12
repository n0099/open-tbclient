package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {
    private AppBarLayout ZQ;
    private AppBarLayout.OnOffsetChangedListener ZR;
    private boolean ZS;
    private boolean ZT;

    public AppBarLayoutStickyBehavior() {
        this.ZS = false;
        this.ZT = false;
    }

    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZS = false;
        this.ZT = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.ZQ != null && this.ZR != null && !this.ZT) {
            this.ZQ.addOnOffsetChangedListener(this.ZR);
            this.ZT = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.ZQ != null && this.ZR != null && this.ZT) {
            this.ZQ.removeOnOffsetChangedListener(this.ZR);
            this.ZT = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.ZQ == null) {
            this.ZQ = appBarLayout;
        }
        if (this.ZR == null) {
            this.ZR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior.1
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                    if (appBarLayout2 != null) {
                        if (Math.abs(i2) < appBarLayout2.getTotalScrollRange()) {
                            AppBarLayoutStickyBehavior.this.ZS = false;
                        } else if (!AppBarLayoutStickyBehavior.this.ZS) {
                            AppBarLayoutStickyBehavior.this.ZS = true;
                            appBarLayout2.setActivated(false);
                            appBarLayout2.setExpanded(false, false);
                        }
                    }
                }
            };
        }
        if (this.ZQ != null && this.ZR != null && !this.ZT) {
            this.ZQ.addOnOffsetChangedListener(this.ZR);
            this.ZT = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        if (this.ZS) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
        if (!this.ZS) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
        if (!this.ZS) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        if (this.ZS) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
        if (this.ZS) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }

    public boolean isSticky() {
        return this.ZS;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        expandedAppBarLayout(appBarLayout, true);
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        appBarLayout.setActivated(true);
        appBarLayout.setExpanded(true, z);
        this.ZS = false;
    }
}

package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    public AppBarLayout f2465a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f2466b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2467c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2468d;

    /* loaded from: classes.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (appBarLayout == null) {
                return;
            }
            if (Math.abs(i2) < appBarLayout.getTotalScrollRange()) {
                AppBarLayoutStickyBehavior.this.f2467c = false;
            } else if (AppBarLayoutStickyBehavior.this.f2467c) {
            } else {
                AppBarLayoutStickyBehavior.this.f2467c = true;
                appBarLayout.setActivated(false);
                appBarLayout.setExpanded(false, false);
            }
        }
    }

    public AppBarLayoutStickyBehavior() {
        this.f2467c = false;
        this.f2468d = false;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        expandedAppBarLayout(appBarLayout, true);
    }

    public boolean isSticky() {
        return this.f2467c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        super.onAttachedToLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.f2465a;
        if (appBarLayout == null || (onOffsetChangedListener = this.f2466b) == null || this.f2468d) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
        this.f2468d = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        super.onDetachedFromLayoutParams();
        AppBarLayout appBarLayout = this.f2465a;
        if (appBarLayout == null || (onOffsetChangedListener = this.f2466b) == null || !this.f2468d) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener(onOffsetChangedListener);
        this.f2468d = false;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        appBarLayout.setActivated(true);
        appBarLayout.setExpanded(true, z);
        this.f2467c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        if (this.f2465a == null) {
            this.f2465a = appBarLayout;
        }
        if (this.f2466b == null) {
            this.f2466b = new a();
        }
        AppBarLayout appBarLayout2 = this.f2465a;
        if (appBarLayout2 != null && (onOffsetChangedListener = this.f2466b) != null && !this.f2468d) {
            appBarLayout2.addOnOffsetChangedListener(onOffsetChangedListener);
            this.f2468d = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean z) {
        if (this.f2467c) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f2, f3, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3) {
        if (this.f2467c) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f2, f3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr) {
        if (this.f2467c) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, iArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5) {
        if (this.f2467c) {
            return;
        }
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2) {
        if (this.f2467c) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i2);
    }

    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2467c = false;
        this.f2468d = false;
    }
}

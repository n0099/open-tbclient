package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
@RestrictTo
/* loaded from: classes2.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final Pools.Pool<BottomNavigationItemView> jD = new Pools.SynchronizedPool(5);
    private final int jA;
    private final int jB;
    private final a jC;
    private BottomNavigationItemView[] jE;
    private int jF;
    private ColorStateList jG;
    private ColorStateList jH;
    private int jI;
    private BottomNavigationPresenter jJ;
    private boolean js;
    private final int jz;
    private final int mItemHeight;
    private MenuBuilder mMenu;
    private final View.OnClickListener mOnClickListener;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.js = true;
        this.jF = 0;
        Resources resources = getResources();
        this.jz = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.jA = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.jB = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.mItemHeight = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        if (Build.VERSION.SDK_INT >= 14) {
            this.jC = new b();
        } else {
            this.jC = new a();
        }
        this.mOnClickListener = new View.OnClickListener() { // from class: android.support.design.internal.BottomNavigationMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) view;
                BottomNavigationMenuView.this.j(bottomNavigationItemView.getItemPosition());
                BottomNavigationMenuView.this.mMenu.performItemAction(bottomNavigationItemView.getItemData(), BottomNavigationMenuView.this.jJ, 0);
            }
        };
    }

    @Override // android.support.v7.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
        if (this.mMenu != null && this.mMenu.size() > this.jF) {
            this.mMenu.getItem(this.jF).setChecked(true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        int[] iArr = new int[childCount];
        if (this.js) {
            int i4 = childCount - 1;
            int min = Math.min(size - (this.jA * i4), this.jB);
            int min2 = Math.min((size - min) / i4, this.jz);
            int i5 = (size - min) - (i4 * min2);
            int i6 = 0;
            while (i6 < childCount) {
                iArr[i6] = i6 == this.jF ? min : min2;
                if (i5 > 0) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 = i5 - 1;
                } else {
                    i3 = i5;
                }
                i6++;
                i5 = i3;
            }
        } else {
            int min3 = Math.min(size / childCount, this.jB);
            int i7 = size - (min3 * childCount);
            for (int i8 = 0; i8 < childCount; i8++) {
                iArr[i8] = min3;
                if (i7 > 0) {
                    iArr[i8] = iArr[i8] + 1;
                    i7--;
                }
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(iArr[i10], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i9 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i9, View.MeasureSpec.makeMeasureSpec(i9, 1073741824), 0), ViewCompat.resolveSizeAndState(this.mItemHeight, makeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.jG = colorStateList;
        if (this.jE != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.jE) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.jG;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.jH = colorStateList;
        if (this.jE != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.jE) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.jH;
    }

    public void setItemBackgroundRes(int i) {
        this.jI = i;
        if (this.jE != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.jE) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.jI;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.jJ = bottomNavigationPresenter;
    }

    public void buildMenuView() {
        if (this.jE != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.jE) {
                jD.release(bottomNavigationItemView);
            }
        }
        removeAllViews();
        this.jE = new BottomNavigationItemView[this.mMenu.size()];
        this.js = this.mMenu.size() > 3;
        for (int i = 0; i < this.mMenu.size(); i++) {
            this.jJ.setUpdateSuspended(true);
            this.mMenu.getItem(i).setCheckable(true);
            this.jJ.setUpdateSuspended(false);
            BottomNavigationItemView newItem = getNewItem();
            this.jE[i] = newItem;
            newItem.setIconTintList(this.jG);
            newItem.setTextColor(this.jH);
            newItem.setItemBackground(this.jI);
            newItem.setShiftingMode(this.js);
            newItem.initialize((MenuItemImpl) this.mMenu.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.mOnClickListener);
            addView(newItem);
        }
    }

    public void updateMenuView() {
        int size = this.mMenu.size();
        if (size != this.jE.length) {
            buildMenuView();
            return;
        }
        for (int i = 0; i < size; i++) {
            this.jJ.setUpdateSuspended(true);
            this.jE[i].initialize((MenuItemImpl) this.mMenu.getItem(i), 0);
            this.jJ.setUpdateSuspended(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        if (this.jF != i) {
            this.jC.beginDelayedTransition(this);
            this.jJ.setUpdateSuspended(true);
            this.jE[this.jF].setChecked(false);
            this.jE[i].setChecked(true);
            this.jJ.setUpdateSuspended(false);
            this.jF = i;
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = jD.acquire();
        if (acquire == null) {
            return new BottomNavigationItemView(getContext());
        }
        return acquire;
    }
}

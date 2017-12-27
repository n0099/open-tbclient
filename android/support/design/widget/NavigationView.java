package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] jn = {16842912};
    private static final int[] lg = {-16842910};
    private MenuInflater lh;
    private int mMaxWidth;
    private final NavigationMenu pr;
    private final NavigationMenuPresenter pt;
    OnNavigationItemSelectedListener pu;

    /* loaded from: classes2.dex */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList n;
        int i2;
        boolean z;
        this.pt = new NavigationMenuPresenter();
        r.R(context);
        this.pr = new NavigationMenu(context);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.NavigationView, i, R.style.Widget_Design_NavigationView);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.NavigationView_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, obtainStyledAttributes.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemIconTint)) {
            n = obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemIconTint);
        } else {
            n = n(16842808);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextAppearance)) {
            i2 = obtainStyledAttributes.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            i2 = 0;
            z = false;
        }
        ColorStateList colorStateList = obtainStyledAttributes.hasValue(R.styleable.NavigationView_itemTextColor) ? obtainStyledAttributes.getColorStateList(R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateList == null) {
            colorStateList = n(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NavigationView_itemBackground);
        this.pr.setCallback(new MenuBuilder.Callback() { // from class: android.support.design.widget.NavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return NavigationView.this.pu != null && NavigationView.this.pu.onNavigationItemSelected(menuItem);
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        this.pt.setId(1);
        this.pt.initForMenu(context, this.pr);
        this.pt.setItemIconTintList(n);
        if (z) {
            this.pt.setItemTextAppearance(i2);
        }
        this.pt.setItemTextColor(colorStateList);
        this.pt.setItemBackground(drawable);
        this.pr.addMenuPresenter(this.pt);
        addView((View) this.pt.getMenuView(this));
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_menu)) {
            inflateMenu(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_menu, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.NavigationView_headerLayout)) {
            inflateHeaderView(obtainStyledAttributes.getResourceId(R.styleable.NavigationView_headerLayout, 0));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.pr.savePresenterStates(savedState.menuState);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.pr.restorePresenterStates(savedState.menuState);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.pu = onNavigationItemSelectedListener;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.mMaxWidth), 1073741824);
                break;
            case 0:
                i = View.MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.support.design.internal.ScrimInsetsFrameLayout
    @RestrictTo
    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        this.pt.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    public void inflateMenu(int i) {
        this.pt.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.pr);
        this.pt.setUpdateSuspended(false);
        this.pt.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.pr;
    }

    public View inflateHeaderView(int i) {
        return this.pt.inflateHeaderView(i);
    }

    public void addHeaderView(View view) {
        this.pt.addHeaderView(view);
    }

    public void removeHeaderView(View view) {
        this.pt.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.pt.getHeaderCount();
    }

    public View getHeaderView(int i) {
        return this.pt.getHeaderView(i);
    }

    public ColorStateList getItemIconTintList() {
        return this.pt.getItemTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.pt.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.pt.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.pt.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.pt.getItemBackground();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.pt.setItemBackground(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.pr.findItem(i);
        if (findItem != null) {
            this.pt.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.pt.setItemTextAppearance(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.lh == null) {
            this.lh = new SupportMenuInflater(getContext());
        }
        return this.lh;
    }

    private ColorStateList n(int i) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, typedValue, true)) {
                int i2 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                return new ColorStateList(new int[][]{lg, jn, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(lg, defaultColor), i2, defaultColor});
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: android.support.design.widget.NavigationView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: e */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: F */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }
}

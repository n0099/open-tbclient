package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.R;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {
    private static final int[] jn = {16842912};
    private static final int[] lg = {-16842910};
    private final BottomNavigationPresenter jJ;
    private final BottomNavigationMenuView jL;
    private MenuInflater lh;
    private OnNavigationItemSelectedListener li;
    private final MenuBuilder mMenu;

    /* loaded from: classes2.dex */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJ = new BottomNavigationPresenter();
        r.R(context);
        this.mMenu = new BottomNavigationMenu(context);
        this.jL = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.jL.setLayoutParams(layoutParams);
        this.jJ.setBottomNavigationMenuView(this.jL);
        this.jL.setPresenter(this.jJ);
        this.mMenu.addMenuPresenter(this.jJ);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.BottomNavigationView, i, R.style.Widget_Design_BottomNavigationView);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
            this.jL.setIconTintList(obtainStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            this.jL.setIconTintList(n(16842808));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
            this.jL.setItemTextColor(obtainStyledAttributes.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
        } else {
            this.jL.setItemTextColor(n(16842808));
        }
        this.jL.setItemBackgroundRes(obtainStyledAttributes.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0));
        if (obtainStyledAttributes.hasValue(R.styleable.BottomNavigationView_menu)) {
            inflateMenu(obtainStyledAttributes.getResourceId(R.styleable.BottomNavigationView_menu, 0));
        }
        obtainStyledAttributes.recycle();
        addView(this.jL, layoutParams);
        this.mMenu.setCallback(new MenuBuilder.Callback() { // from class: android.support.design.widget.BottomNavigationView.1
            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                return BottomNavigationView.this.li != null && BottomNavigationView.this.li.onNavigationItemSelected(menuItem);
            }

            @Override // android.support.v7.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.li = onNavigationItemSelectedListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public void inflateMenu(int i) {
        this.jJ.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.mMenu);
        this.jJ.initForMenu(getContext(), this.mMenu);
        this.jJ.setUpdateSuspended(false);
        this.jJ.updateMenuView(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.jL.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.jL.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.jL.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.jL.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.jL.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.jL.setItemBackgroundRes(i);
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
}

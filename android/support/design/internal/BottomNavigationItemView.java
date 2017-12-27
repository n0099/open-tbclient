package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
@RestrictTo
/* loaded from: classes2.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    public static final int INVALID_ITEM_POSITION = -1;
    private static final int[] jn = {16842912};
    private final int jo;
    private final int jp;
    private final float jq;
    private final float jr;
    private boolean js;
    private ImageView jt;
    private final TextView ju;
    private final TextView jv;
    private int jw;
    private MenuItemImpl jx;
    private ColorStateList jy;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jw = -1;
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_text_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_text_size);
        this.jo = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
        this.jp = dimensionPixelSize - dimensionPixelSize2;
        this.jq = (dimensionPixelSize2 * 1.0f) / dimensionPixelSize;
        this.jr = (dimensionPixelSize * 1.0f) / dimensionPixelSize2;
        LayoutInflater.from(context).inflate(R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
        this.jt = (ImageView) findViewById(R.id.icon);
        this.ju = (TextView) findViewById(R.id.smallLabel);
        this.jv = (TextView) findViewById(R.id.largeLabel);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.jx = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
    }

    public void setItemPosition(int i) {
        this.jw = i;
    }

    public int getItemPosition() {
        return this.jw;
    }

    public void setShiftingMode(boolean z) {
        this.js = z;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.jx;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.ju.setText(charSequence);
        this.jv.setText(charSequence);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        this.jx.setChecked(z);
        ViewCompat.setPivotX(this.jv, this.jv.getWidth() / 2);
        ViewCompat.setPivotY(this.jv, this.jv.getBaseline());
        ViewCompat.setPivotX(this.ju, this.ju.getWidth() / 2);
        ViewCompat.setPivotY(this.ju, this.ju.getBaseline());
        if (this.js) {
            if (z) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jt.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = this.jo;
                this.jt.setLayoutParams(layoutParams);
                this.jv.setVisibility(0);
                ViewCompat.setScaleX(this.jv, 1.0f);
                ViewCompat.setScaleY(this.jv, 1.0f);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.jt.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = this.jo;
                this.jt.setLayoutParams(layoutParams2);
                this.jv.setVisibility(4);
                ViewCompat.setScaleX(this.jv, 0.5f);
                ViewCompat.setScaleY(this.jv, 0.5f);
            }
            this.ju.setVisibility(4);
        } else if (z) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.jt.getLayoutParams();
            layoutParams3.gravity = 49;
            layoutParams3.topMargin = this.jo + this.jp;
            this.jt.setLayoutParams(layoutParams3);
            this.jv.setVisibility(0);
            this.ju.setVisibility(4);
            ViewCompat.setScaleX(this.jv, 1.0f);
            ViewCompat.setScaleY(this.jv, 1.0f);
            ViewCompat.setScaleX(this.ju, this.jq);
            ViewCompat.setScaleY(this.ju, this.jq);
        } else {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.jt.getLayoutParams();
            layoutParams4.gravity = 49;
            layoutParams4.topMargin = this.jo;
            this.jt.setLayoutParams(layoutParams4);
            this.jv.setVisibility(4);
            this.ju.setVisibility(0);
            ViewCompat.setScaleX(this.jv, this.jr);
            ViewCompat.setScaleY(this.jv, this.jr);
            ViewCompat.setScaleX(this.ju, 1.0f);
            ViewCompat.setScaleY(this.ju, 1.0f);
        }
        refreshDrawableState();
    }

    @Override // android.view.View, android.support.v7.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.ju.setEnabled(z);
        this.jv.setEnabled(z);
        this.jt.setEnabled(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.jx != null && this.jx.isCheckable() && this.jx.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jn);
        }
        return onCreateDrawableState;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, this.jy);
        }
        this.jt.setImageDrawable(drawable);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.jy = colorStateList;
        if (this.jx != null) {
            setIcon(this.jx.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.ju.setTextColor(colorStateList);
        this.jv.setTextColor(colorStateList);
    }

    public void setItemBackground(int i) {
        ViewCompat.setBackground(this, i == 0 ? null : ContextCompat.getDrawable(getContext(), i));
    }
}

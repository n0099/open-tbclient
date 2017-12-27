package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
@RestrictTo
/* loaded from: classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] jn = {16842912};
    private final int jS;
    private boolean jT;
    boolean jU;
    private final CheckedTextView jV;
    private FrameLayout jW;
    private ColorStateList jX;
    private boolean jY;
    private Drawable jZ;
    private MenuItemImpl jx;
    private final AccessibilityDelegateCompat kb;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kb = new AccessibilityDelegateCompat() { // from class: android.support.design.internal.NavigationMenuItemView.1
            @Override // android.support.v4.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.jU);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        this.jS = context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
        this.jV = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.jV.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.jV, this.kb);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.jx = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, aO());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        aN();
    }

    private boolean aM() {
        return this.jx.getTitle() == null && this.jx.getIcon() == null && this.jx.getActionView() != null;
    }

    private void aN() {
        if (aM()) {
            this.jV.setVisibility(8);
            if (this.jW != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) this.jW.getLayoutParams();
                layoutParams.width = -1;
                this.jW.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.jV.setVisibility(0);
        if (this.jW != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) this.jW.getLayoutParams();
            layoutParams2.width = -2;
            this.jW.setLayoutParams(layoutParams2);
        }
    }

    public void recycle() {
        if (this.jW != null) {
            this.jW.removeAllViews();
        }
        this.jV.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.jW == null) {
                this.jW = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.jW.removeAllViews();
            this.jW.addView(view);
        }
    }

    private StateListDrawable aO() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(jn, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.jx;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.jV.setText(charSequence);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.jU != z) {
            this.jU = z;
            this.kb.sendAccessibilityEvent(this.jV, 2048);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        refreshDrawableState();
        this.jV.setChecked(z);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.jY) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.jX);
            }
            drawable.setBounds(0, 0, this.jS, this.jS);
        } else if (this.jT) {
            if (this.jZ == null) {
                this.jZ = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.jZ != null) {
                    this.jZ.setBounds(0, 0, this.jS, this.jS);
                }
            }
            drawable = this.jZ;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.jV, drawable, null, null, null);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.jx != null && this.jx.isCheckable() && this.jx.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jn);
        }
        return onCreateDrawableState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.jX = colorStateList;
        this.jY = this.jX != null;
        if (this.jx != null) {
            setIcon(this.jx.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.jV, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.jV.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.jT = z;
    }
}

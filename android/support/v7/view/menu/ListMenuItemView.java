package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
@RestrictTo
/* loaded from: classes2.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
    private int IA;
    private boolean Ie;
    private RadioButton Is;
    private CheckBox It;
    private TextView Iu;
    private ImageView Iv;
    private Drawable Iw;
    private Context Ix;
    private boolean Iy;
    private Drawable Iz;
    private MenuItemImpl jx;
    private int ki;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.Iw = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.ki = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.Iy = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.Ix = context;
        this.Iz = obtainStyledAttributes.getDrawable(R.styleable.MenuView_subMenuArrow);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.Iw);
        this.mTitleView = (TextView) findViewById(R.id.title);
        if (this.ki != -1) {
            this.mTitleView.setTextAppearance(this.Ix, this.ki);
        }
        this.Iu = (TextView) findViewById(R.id.shortcut);
        this.Iv = (ImageView) findViewById(R.id.submenuarrow);
        if (this.Iv != null) {
            this.Iv.setImageDrawable(this.Iz);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.jx = menuItemImpl;
        this.IA = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.a(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.eZ(), menuItemImpl.eX());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
    }

    public void setForceShowIcon(boolean z) {
        this.Ie = z;
        this.Iy = z;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mTitleView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        } else if (this.mTitleView.getVisibility() != 8) {
            this.mTitleView.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.jx;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.Is != null || this.It != null) {
            if (this.jx.isExclusiveCheckable()) {
                if (this.Is == null) {
                    eT();
                }
                compoundButton = this.Is;
                compoundButton2 = this.It;
            } else {
                if (this.It == null) {
                    eU();
                }
                compoundButton = this.It;
                compoundButton2 = this.Is;
            }
            if (z) {
                compoundButton.setChecked(this.jx.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.It != null) {
                this.It.setVisibility(8);
            }
            if (this.Is != null) {
                this.Is.setVisibility(8);
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.jx.isExclusiveCheckable()) {
            if (this.Is == null) {
                eT();
            }
            compoundButton = this.Is;
        } else {
            if (this.It == null) {
                eU();
            }
            compoundButton = this.It;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.Iv != null) {
            this.Iv.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
        int i = (z && this.jx.eZ()) ? 0 : 8;
        if (i == 0) {
            this.Iu.setText(this.jx.eY());
        }
        if (this.Iu.getVisibility() != i) {
            this.Iu.setVisibility(i);
        }
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        boolean z = this.jx.shouldShowIcon() || this.Ie;
        if (z || this.Iy) {
            if (this.mIconView != null || drawable != null || this.Iy) {
                if (this.mIconView == null) {
                    eS();
                }
                if (drawable != null || this.Iy) {
                    ImageView imageView = this.mIconView;
                    if (!z) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.mIconView.getVisibility() != 0) {
                        this.mIconView.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.mIconView.setVisibility(8);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mIconView != null && this.Iy) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void eS() {
        this.mIconView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.mIconView, 0);
    }

    private void eT() {
        this.Is = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.Is);
    }

    private void eU() {
        this.It = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.It);
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.Ie;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }
}

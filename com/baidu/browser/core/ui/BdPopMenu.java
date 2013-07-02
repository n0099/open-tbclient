package com.baidu.browser.core.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BdPopMenu extends LinearLayout implements View.OnClickListener {
    private Context context;
    private float density;
    private int height;
    private LinearLayout.LayoutParams layoutParams;
    private BdPopMenuListener listener;
    private List menuItems;
    private int mid;
    private int width;

    public BdPopMenu(Context context) {
        this(context, null);
    }

    public BdPopMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mid = 0;
        this.density = 0.0f;
        this.width = 0;
        this.height = 0;
        this.context = context;
        this.density = this.context.getResources().getDisplayMetrics().density;
        this.width = (int) (80.0f * this.density);
        this.height = (int) (60.0f * this.density);
        this.layoutParams = new LinearLayout.LayoutParams(this.width, this.height);
        this.menuItems = new ArrayList();
        this.layoutParams.setMargins(4, 3, 4, 3);
        setOrientation(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.listener != null) {
            BdPopMenuItem bdPopMenuItem = (BdPopMenuItem) view;
            this.listener.onPopMenuClick(this.mid, this.menuItems.indexOf(bdPopMenuItem), bdPopMenuItem.getMText());
        }
    }

    public BdPopMenuListener getListener() {
        return this.listener;
    }

    public void setListener(BdPopMenuListener bdPopMenuListener) {
        this.listener = bdPopMenuListener;
    }

    public void setSkin(int i) {
        for (BdPopMenuItem bdPopMenuItem : this.menuItems) {
            bdPopMenuItem.setBackgroundResource(i);
        }
    }

    public void setTextSize(float f) {
        for (BdPopMenuItem bdPopMenuItem : this.menuItems) {
            bdPopMenuItem.setTextSize(f);
        }
    }

    public void layoutMenu() {
        int i;
        int size = this.menuItems.size();
        if (size == 4) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            LinearLayout linearLayout2 = new LinearLayout(this.context);
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < 2) {
                    linearLayout.addView((View) this.menuItems.get(i2), this.layoutParams);
                } else {
                    linearLayout2.addView((View) this.menuItems.get(i2), this.layoutParams);
                }
            }
            addView(linearLayout);
            addView(linearLayout2);
            return;
        }
        if (size % 3 == 0) {
            i = size / 3;
        } else {
            i = (size / 3) + 1;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            LinearLayout linearLayout3 = new LinearLayout(this.context);
            arrayList.add(linearLayout3);
            addView(linearLayout3);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.height);
        layoutParams.gravity = 17;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = i4 / 3;
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(this.context.getResources().getIdentifier("browser_select_separator", "drawable", this.context.getPackageName()));
            ((LinearLayout) arrayList.get(i5)).addView((View) this.menuItems.get(i4), this.layoutParams);
            if ((i4 + 1) % 3 != 0 && i4 + 1 != size) {
                ((LinearLayout) arrayList.get(i5)).addView(imageView, layoutParams);
            }
        }
    }

    public void addItem(String str, int i, int i2) {
        try {
            BdPopMenuItem bdPopMenuItem = new BdPopMenuItem(this.context);
            bdPopMenuItem.setOnClickListener(this);
            ColorStateList colorStateList = this.context.getResources().getColorStateList(i);
            bdPopMenuItem.setMText(str);
            bdPopMenuItem.setTextColor(colorStateList);
            bdPopMenuItem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.context.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
            this.menuItems.add(bdPopMenuItem);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addItem(String str, int i, int i2, int i3) {
        try {
            BdPopMenuItem bdPopMenuItem = new BdPopMenuItem(this.context);
            bdPopMenuItem.setOnClickListener(this);
            ColorStateList colorStateList = this.context.getResources().getColorStateList(i);
            bdPopMenuItem.setMText(str);
            bdPopMenuItem.setTextColor(colorStateList);
            bdPopMenuItem.setBackgroundResource(i3);
            bdPopMenuItem.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.context.getResources().getDrawable(i2), (Drawable) null, (Drawable) null);
            this.menuItems.add(bdPopMenuItem);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addItem(String[] strArr, int i, int[] iArr) {
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                addItem(strArr[i2], i, iArr[i2]);
            }
        }
    }

    public void addItem(String[] strArr, int i, int[] iArr, int i2) {
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                addItem(strArr[i3], i, iArr[i3], i2);
            }
        }
    }

    public void showItem(int i) {
        if (i >= 0 && i <= this.menuItems.size()) {
            ((BdPopMenuItem) this.menuItems.get(i)).setEnabled(true);
        }
    }

    public void hideItem(int i) {
        if (i >= 0 && i <= this.menuItems.size()) {
            ((BdPopMenuItem) this.menuItems.get(i)).setEnabled(false);
        }
    }

    public void hideAllItem() {
        for (BdPopMenuItem bdPopMenuItem : this.menuItems) {
            bdPopMenuItem.setEnabled(false);
        }
    }

    public void showAllItem() {
        for (BdPopMenuItem bdPopMenuItem : this.menuItems) {
            bdPopMenuItem.setEnabled(true);
        }
    }

    public void updateItemText(int i, String str) {
        if (i >= 0 && i <= this.menuItems.size()) {
            ((BdPopMenuItem) this.menuItems.get(i)).setMText(str);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public int getId() {
        return this.mid;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mid = i;
    }

    public List getMenuItemList() {
        return this.menuItems;
    }
}

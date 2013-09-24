package com.baidu.browser.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BdPopMenuGroup extends FrameLayout {
    private static BdPopMenuGroup instance;
    private FrameLayout.LayoutParams absParames;
    private Context context;
    private int mShowMenuId;
    private boolean menuShowMode;
    private List<BdPopMenu> menus;

    public BdPopMenuGroup(Context context) {
        this(context, null);
    }

    public BdPopMenuGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.absParames = new FrameLayout.LayoutParams(-2, -2);
        this.mShowMenuId = -1;
        this.context = context;
        instance = this;
        this.absParames.gravity = 17;
        this.menus = new ArrayList();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public static BdPopMenuGroup getInstance() {
        return instance;
    }

    public void addItem(int i, String str, int i2, int i3) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).addItem(str, i2, i3);
        }
    }

    public void addItem(int i, String[] strArr, int i2, int[] iArr) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).addItem(strArr, i2, iArr);
        }
    }

    public void addItem(int i, String[] strArr, int i2, int[] iArr, int i3) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).addItem(strArr, i2, iArr, i3);
        }
    }

    public void layoutMenu(int i) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).layoutMenu();
        }
    }

    public void show(int i) {
        if (i >= 0 && i < this.menus.size()) {
            this.mShowMenuId = i;
            this.menuShowMode = true;
            BdPopMenu bdPopMenu = this.menus.get(i);
            if (bdPopMenu.getListener() != null) {
                bdPopMenu.getListener().onPopMenuShow(i);
            }
            bdPopMenu.setDrawingCacheEnabled(true);
            bdPopMenu.setVisibility(0);
        }
    }

    public void showItem(int i, int i2) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).showItem(i2);
        }
    }

    public void hideItem(int i, int i2) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).hideItem(i2);
        }
    }

    public void hideAllItem(int i) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).hideAllItem();
        }
    }

    public void showAllItem(int i) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).showAllItem();
        }
    }

    public void hide(int i) {
        if (i >= 0 && i < this.menus.size()) {
            this.mShowMenuId = -1;
            this.menuShowMode = false;
            BdPopMenu bdPopMenu = this.menus.get(i);
            if (bdPopMenu.getListener() != null) {
                bdPopMenu.getListener().onPopMenuHide(i);
            }
            bdPopMenu.setVisibility(4);
            bdPopMenu.destroyDrawingCache();
        }
    }

    public void hideAll() {
        for (BdPopMenu bdPopMenu : this.menus) {
            if (bdPopMenu.getVisibility() == 0) {
                if (bdPopMenu.getListener() != null) {
                    bdPopMenu.getListener().onPopMenuHide(bdPopMenu.getId());
                }
                bdPopMenu.setVisibility(4);
            }
        }
        this.mShowMenuId = -1;
        this.menuShowMode = false;
    }

    public int createMenu(BdPopMenuListener bdPopMenuListener) {
        BdPopMenu bdPopMenu = new BdPopMenu(this.context);
        bdPopMenu.setListener(bdPopMenuListener);
        bdPopMenu.setVisibility(4);
        this.menus.add(bdPopMenu);
        addView(bdPopMenu, this.absParames);
        int indexOf = this.menus.indexOf(bdPopMenu);
        bdPopMenu.setId(indexOf);
        return indexOf;
    }

    public void setItemIcon(int i, int i2) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).setSkin(i2);
        }
    }

    public void setMenuSkin(int i, int i2) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).setBackgroundResource(i2);
        }
    }

    public void setMenuTextSize(int i, float f) {
        if (i >= 0 && i < this.menus.size()) {
            this.menus.get(i).setTextSize(f);
        }
    }

    public void updateMenuItemText(int i, int i2, String str) {
        if (i2 >= 0 && i2 <= this.menus.size()) {
            this.menus.get(i).updateItemText(i2, str);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.menuShowMode) {
                    hideAll();
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean isMenuShow() {
        return this.menuShowMode;
    }

    public BdPopMenu getShowMenu() {
        if (this.mShowMenuId < 0 || this.mShowMenuId >= this.menus.size()) {
            return null;
        }
        return this.menus.get(this.mShowMenuId);
    }
}

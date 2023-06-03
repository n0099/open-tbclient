package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
public class SwipeMenuItem {
    public Drawable background;
    public Drawable icon;
    public int id;
    public Context mContext;
    public float mTitlePxSize;
    public String title;
    public int titleColor;
    public int width;

    public SwipeMenuItem(Context context) {
        this.mContext = context;
    }

    public void setBackground(int i) {
        this.background = this.mContext.getResources().getDrawable(i);
    }

    public void setIcon(int i) {
        this.icon = this.mContext.getResources().getDrawable(i);
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setTitleColor(int i) {
        this.titleColor = i;
    }

    public void setTitlePxSize(float f) {
        this.mTitlePxSize = f;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public float getTitlePxSize() {
        return this.mTitlePxSize;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBackground(Drawable drawable) {
        this.background = drawable;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}

package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class AiAppMenuItem {
    public static final int MENU_ITEM_ABOUT = 36;
    public static final int MENU_ITEM_ADD_TO_LAUNCHER = 35;
    public static final int MENU_ITEM_AI_APPS_HOME_PAGE = 34;
    public static final int MENU_ITEM_AUTHORITY_MANAGEMENT = 37;
    public static final int MENU_ITEM_FEEDBACK = 9;
    public static final int MENU_ITEM_NIGHT_MODE = 5;
    public static final int MENU_ITEM_SHARE = 4;
    public boolean mEnable;
    public int mIconResId;
    public int mId;
    private int mImgLevel = 0;
    public OnAiAppMenuItemClickListener mListener;
    private String mTip;
    public int mTitleResId;

    public AiAppMenuItem(int i, int i2, int i3, boolean z) {
        this.mTitleResId = -1;
        this.mIconResId = -1;
        this.mEnable = true;
        this.mId = i;
        this.mTitleResId = i2;
        this.mIconResId = i3;
        this.mEnable = z;
    }

    public int getItemId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(int i) {
        this.mTitleResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIcon(int i) {
        this.mIconResId = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnItemClickListener(OnAiAppMenuItemClickListener onAiAppMenuItemClickListener) {
        this.mListener = onAiAppMenuItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnable() {
        return this.mEnable;
    }

    void setTip(String str) {
        this.mTip = str;
    }

    String getTip() {
        return this.mTip;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnAiAppMenuItemClickListener getOnItemClickListener() {
        return this.mListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTitle(Context context) {
        if (this.mTitleResId <= 0) {
            return null;
        }
        return context.getResources().getString(this.mTitleResId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getIcon(Context context) {
        if (this.mIconResId <= 0) {
            return null;
        }
        return context.getResources().getDrawable(this.mIconResId);
    }

    int getIconResId() {
        return this.mIconResId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getImgLevel() {
        return this.mImgLevel;
    }

    void setImgLevel(int i) {
        this.mImgLevel = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AiAppMenuItem makeCopy(AiAppMenuItem aiAppMenuItem) {
        if (aiAppMenuItem == null) {
            return null;
        }
        return new AiAppMenuItem(aiAppMenuItem.mId, aiAppMenuItem.mTitleResId, aiAppMenuItem.mIconResId, aiAppMenuItem.mEnable);
    }
}

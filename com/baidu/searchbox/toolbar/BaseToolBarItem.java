package com.baidu.searchbox.toolbar;

import android.view.View;
import com.baidu.searchbox.ui.fontsize.listener.IFontSizeViewListener;
/* loaded from: classes4.dex */
public class BaseToolBarItem {
    public static final float ITEM_ICON_SIZE = 57.0f;
    public boolean isResponseFontSize = true;
    public boolean mIsCustomClick;
    public int mItemId;
    public View mItemView;

    public BaseToolBarItem(int i) {
        this.mItemId = i;
    }

    public void setIsResponseFontSize(boolean z) {
        this.isResponseFontSize = z;
        View view2 = this.mItemView;
        if (view2 instanceof IFontSizeViewListener) {
            ((IFontSizeViewListener) view2).setIsResponseFontSize(z);
        }
    }

    public void setItemView(View view2) {
        this.mItemView = view2;
    }

    public BaseToolBarItem(int i, View view2) {
        this.mItemId = i;
        this.mItemView = view2;
    }

    public BaseToolBarItem(int i, View view2, boolean z) {
        this.mItemId = i;
        this.mItemView = view2;
        this.mIsCustomClick = z;
    }

    public BaseToolBarItem(int i, boolean z) {
        this.mItemId = i;
        this.mIsCustomClick = z;
    }

    public int getItemId() {
        return this.mItemId;
    }

    public View getItemView() {
        return this.mItemView;
    }

    public boolean isCustomClick() {
        return this.mIsCustomClick;
    }

    public boolean isResponseFontSize() {
        return this.isResponseFontSize;
    }

    public void onFontSizeChange() {
        View view2;
        if (this.isResponseFontSize && (view2 = this.mItemView) != null && (view2 instanceof IFontSizeViewListener)) {
            ((IFontSizeViewListener) view2).onFontSizeChange();
        }
    }
}

package com.baidu.searchbox.ng.aiapps.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView;
import java.util.List;
/* loaded from: classes2.dex */
class AiAppMenuGridViewAdapter extends SlideableGridView.GridItemAdapter {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_MAX_NUM_ITEMS_PER_PAGE = 10;
    private static final String TAG = "AiAppMenuGridViewAdapter";
    private Context mContext;
    private List<AiAppMenuItem> mItemList;
    private int mMenuStyle;
    private boolean mNightEnable = true;
    private int mMaxItemNumPerPage = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AiAppMenuGridViewAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(List<AiAppMenuItem> list) {
        this.mItemList = list;
    }

    public void setNightEnable(boolean z) {
        this.mNightEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMenuStyle(int i) {
        this.mMenuStyle = i;
    }

    void setMaxItemNumPerPage(int i) {
        if (this.mMaxItemNumPerPage != i && i > 0) {
            this.mMaxItemNumPerPage = i;
            notifyDataChanged();
        }
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView.GridItemAdapter
    public int getPageCount() {
        if (this.mItemList == null) {
            return 0;
        }
        if (this.mItemList.size() % this.mMaxItemNumPerPage == 0) {
            return this.mItemList.size() / this.mMaxItemNumPerPage;
        }
        return (this.mItemList.size() / this.mMaxItemNumPerPage) + 1;
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView.GridItemAdapter
    public int getPageGridItemCount(int i) {
        if (this.mItemList == null) {
            return 0;
        }
        return i < this.mItemList.size() / this.mMaxItemNumPerPage ? this.mMaxItemNumPerPage : this.mItemList.size() % this.mMaxItemNumPerPage;
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView.GridItemAdapter
    public View getGridItemView(int i, int i2, View view, ViewGroup viewGroup) {
        View aiAppMenuItemView = view == null ? new AiAppMenuItemView(this.mContext) : view;
        ((AiAppMenuItemView) aiAppMenuItemView).setMenuStyle(this.mMenuStyle);
        ((AiAppMenuItemView) aiAppMenuItemView).setData(this.mItemList.get((this.mMaxItemNumPerPage * i) + i2));
        return aiAppMenuItemView;
    }

    @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.SlideableGridView.GridItemAdapter
    public void onGridItemClick(int i, int i2, View view) {
        if (this.mItemList != null) {
            AiAppMenuItem aiAppMenuItem = this.mItemList.get((this.mMaxItemNumPerPage * i) + i2);
            OnAiAppMenuItemClickListener onItemClickListener = aiAppMenuItem.getOnItemClickListener();
            if (onItemClickListener != null) {
                onItemClickListener.onClick(view, aiAppMenuItem);
            }
        }
    }
}

package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SwipeMenu {
    public Context mContext;
    public List<SwipeMenuItem> mItems = new ArrayList();
    public int mViewType;

    public SwipeMenu(Context context) {
        this.mContext = context;
    }

    public void addMenuItem(SwipeMenuItem swipeMenuItem) {
        this.mItems.add(swipeMenuItem);
    }

    public SwipeMenuItem getMenuItem(int i) {
        return this.mItems.get(i);
    }

    public void removeMenuItem(SwipeMenuItem swipeMenuItem) {
        this.mItems.remove(swipeMenuItem);
    }

    public void setViewType(int i) {
        this.mViewType = i;
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<SwipeMenuItem> getMenuItems() {
        return this.mItems;
    }

    public int getViewType() {
        return this.mViewType;
    }
}

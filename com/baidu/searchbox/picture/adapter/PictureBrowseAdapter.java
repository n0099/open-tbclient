package com.baidu.searchbox.picture.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.picture.model.PictureInfo;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public abstract class PictureBrowseAdapter extends PagerAdapter {
    protected Context mContext;
    private int mCurrentPos;
    private View mCurrentView;
    private ArrayList<PictureInfo> mInfo;
    protected SparseArray<View> mViewList = new SparseArray<>();

    public PictureBrowseAdapter(Activity activity, ArrayList<PictureInfo> arrayList) {
        this.mContext = activity;
        this.mInfo = arrayList;
    }

    public void setData(ArrayList<PictureInfo> arrayList) {
        this.mInfo = arrayList;
        this.mViewList.clear();
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        this.mCurrentView = (View) obj;
        this.mCurrentPos = i;
        super.setPrimaryItem(viewGroup, i, obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mInfo == null) {
            return 0;
        }
        return this.mInfo.size();
    }

    public int getPictureCount() {
        if (this.mInfo == null) {
            return 0;
        }
        return this.mInfo.size();
    }

    public View getCurrentView(int i) {
        return this.mCurrentPos == i ? this.mCurrentView : this.mViewList.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public PictureInfo getItemByPosition(int i) {
        if (this.mInfo == null || i < 0 || i >= this.mInfo.size()) {
            return null;
        }
        return this.mInfo.get(i);
    }

    public void onNightModeChanged(boolean z) {
    }
}

package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.searchbox.live.widget.LiveContainer;
/* loaded from: classes3.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    public Context mContext;
    public SimpleArrayMap<Integer, FrameLayout> mPagerList = new SimpleArrayMap<>();

    private void setRealRoomInfo(FrameLayout frameLayout, LiveContainer.LiveItemModel liveItemModel) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    public AlaLoopViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    public FrameLayout getDefaultPage(int i) {
        return this.mPagerList.get(Integer.valueOf(i));
    }

    public int getNextItemIndex(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public FrameLayout getPageBySelectedPosition(int i) {
        return this.mPagerList.get(Integer.valueOf(i));
    }

    public int getPreItemIndex(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    public void initPageLayoutList() {
        if (this.mPagerList == null) {
            this.mPagerList = new SimpleArrayMap<>();
        }
        this.mPagerList.put(0, new FrameLayout(this.mContext));
        this.mPagerList.put(1, new FrameLayout(this.mContext));
        this.mPagerList.put(2, new FrameLayout(this.mContext));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mPagerList.get(Integer.valueOf(i)) != null && this.mPagerList.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.mPagerList.get(Integer.valueOf(i)).getParent()).removeView(this.mPagerList.get(Integer.valueOf(i)));
        }
        if (this.mPagerList.get(Integer.valueOf(i)) != null) {
            viewGroup.addView(this.mPagerList.get(Integer.valueOf(i)));
        }
        return this.mPagerList.get(Integer.valueOf(i));
    }

    public void onDestroy() {
        this.mPagerList.clear();
    }

    public void setCurRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        setRealRoomInfo(this.mPagerList.get(Integer.valueOf(i)), liveItemModel);
    }

    public void setNextRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        setRealRoomInfo(this.mPagerList.get(Integer.valueOf(getNextItemIndex(i))), liveItemModel);
    }

    public void setPreRoomInfo(int i, LiveContainer.LiveItemModel liveItemModel) {
        setRealRoomInfo(this.mPagerList.get(Integer.valueOf(getPreItemIndex(i))), liveItemModel);
    }
}

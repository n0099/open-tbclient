package com.baidu.searchbox.live.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
/* loaded from: classes2.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    public PagerAdapter mAdapter;
    public boolean mBoundaryCaching;
    public SparseArray<ToDestroy> mToDestroy = new SparseArray<>();

    private int getRealFirstPosition() {
        return 1;
    }

    public int toInnerPosition(int i) {
        return i + 1;
    }

    /* loaded from: classes2.dex */
    public static class ToDestroy {
        public ViewGroup container;
        public Object object;
        public int position;

        public ToDestroy(ViewGroup viewGroup, int i, Object obj) {
            this.container = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }

    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    public void setBoundaryCaching(boolean z) {
        this.mBoundaryCaching = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    public int toRealPosition(int i) {
        int realCount = getRealCount();
        if (realCount == 0) {
            return 0;
        }
        int i2 = (i - 1) % realCount;
        if (i2 < 0) {
            return i2 + realCount;
        }
        return i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    private int getRealLastPosition() {
        return (getRealFirstPosition() + getRealCount()) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public PagerAdapter getRealAdapter() {
        return this.mAdapter;
    }

    public int getRealCount() {
        return this.mAdapter.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        SparseArray<ToDestroy> sparseArray = this.mToDestroy;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.mToDestroy = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        int realFirstPosition = getRealFirstPosition();
        int realLastPosition = getRealLastPosition();
        PagerAdapter pagerAdapter = this.mAdapter;
        if (!(pagerAdapter instanceof FragmentPagerAdapter) && !(pagerAdapter instanceof FragmentStatePagerAdapter)) {
            i2 = toRealPosition(i);
        } else {
            i2 = i;
        }
        if (this.mBoundaryCaching && (i == realFirstPosition || i == realLastPosition)) {
            this.mToDestroy.put(i, new ToDestroy(viewGroup, i2, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, i2, obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.mAdapter.setPrimaryItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2;
        ToDestroy toDestroy;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (!(pagerAdapter instanceof FragmentPagerAdapter) && !(pagerAdapter instanceof FragmentStatePagerAdapter)) {
            i2 = toRealPosition(i);
        } else {
            i2 = i;
        }
        if (this.mBoundaryCaching && (toDestroy = this.mToDestroy.get(i)) != null) {
            this.mToDestroy.remove(i);
            return toDestroy.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return this.mAdapter.isViewFromObject(view2, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }
}

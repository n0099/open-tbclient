package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tieba.ke4;
/* loaded from: classes3.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {
    public ke4<View> a = new ke4<>(5);
    public SparseArray<View> b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface a {
        void recycle();
    }

    public abstract void b(View view2, int i);

    public abstract View c(ViewGroup viewGroup, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view2 = (View) obj;
        if (view2 instanceof a) {
            ((a) view2).recycle();
        }
        viewGroup.removeView(view2);
        this.a.b(view2);
        this.b.remove(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a2 = this.a.a();
        if (a2 == null) {
            a2 = c(viewGroup, i);
        }
        this.b.put(i, a2);
        viewGroup.addView(a2);
        b(a2, i);
        return a2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}

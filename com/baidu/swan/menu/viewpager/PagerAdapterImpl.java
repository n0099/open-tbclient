package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import d.a.l0.k.r.c;
/* loaded from: classes3.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public c<View> f11889a = new c<>(5);

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f11890b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface a {
        void recycle();
    }

    public abstract void a(View view, int i2);

    public abstract View b(ViewGroup viewGroup, int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view = (View) obj;
        if (view instanceof a) {
            ((a) view).recycle();
        }
        viewGroup.removeView(view);
        this.f11889a.b(view);
        this.f11890b.remove(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View a2 = this.f11889a.a();
        if (a2 == null) {
            a2 = b(viewGroup, i2);
        }
        this.f11890b.put(i2, a2);
        viewGroup.addView(a2);
        a(a2, i2);
        return a2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }
}

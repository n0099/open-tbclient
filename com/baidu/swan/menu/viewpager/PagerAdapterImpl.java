package com.baidu.swan.menu.viewpager;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import d.b.g0.i.r.c;
/* loaded from: classes3.dex */
public abstract class PagerAdapterImpl extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public c<View> f12673a = new c<>(5);

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f12674b = new SparseArray<>();

    /* loaded from: classes3.dex */
    public interface a {
        void recycle();
    }

    public abstract void a(View view, int i);

    public abstract View b(ViewGroup viewGroup, int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view instanceof a) {
            ((a) view).recycle();
        }
        viewGroup.removeView(view);
        this.f12673a.b(view);
        this.f12674b.remove(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a2 = this.f12673a.a();
        if (a2 == null) {
            a2 = b(viewGroup, i);
        }
        this.f12674b.put(i, a2);
        viewGroup.addView(a2);
        a(a2, i);
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

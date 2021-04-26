package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import d.a.c.j.e.n;
import d.a.i0.r.f0.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f13286e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f13287f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f13288g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<View> f13289h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public int f13290i = 0;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public View f13292f;

        /* renamed from: e  reason: collision with root package name */
        public int f13291e = 3;

        /* renamed from: g  reason: collision with root package name */
        public n f13293g = null;

        public a(View view) {
            this.f13292f = null;
            this.f13292f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            return this.f13293g;
        }

        public View b() {
            return this.f13292f;
        }

        public void c(n nVar) {
            this.f13293g = nVar;
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.f13286e = context;
    }

    public final View b(n nVar) {
        b<T, V> bVar = this.f13287f.get(nVar.getType());
        if (bVar != null) {
            V c2 = bVar.c(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + c2.getClass().getName());
            }
            if (c2 != null) {
                c2.c(nVar);
                bVar.e(null, c2, nVar);
                return c2.b();
            }
        }
        return null;
    }

    public void c() {
        b<T, V> bVar;
        List<View> list = this.f13289h;
        if (list != null) {
            for (View view : list) {
                a f2 = f(view);
                if (f2 != null && f2.a() != null && (bVar = this.f13287f.get(f2.a().getType())) != null) {
                    bVar.d(f2, f2.a());
                }
            }
            this.f13289h.clear();
            this.f13289h = null;
        }
        List<n> list2 = this.f13288g;
        if (list2 != null) {
            list2.clear();
        }
    }

    public final void d(a aVar, n nVar) {
        b<T, V> bVar;
        if (aVar == null || nVar == null || (bVar = this.f13287f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.e(null, aVar, nVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view;
        if (this.f13289h.size() <= 0 || i2 < 0 || i2 >= this.f13289h.size() || (view = this.f13289h.get(i2)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public View e(int i2) {
        if (i2 >= this.f13289h.size() || i2 >= this.f13288g.size()) {
            return null;
        }
        View view = this.f13289h.get(i2);
        a f2 = f(view);
        if (f2 != null && f2.a() == null) {
            d((a) view.getTag(), this.f13288g.get(i2));
        }
        return view;
    }

    public final a f(View view) {
        if (view == null || !(view.getTag() instanceof a)) {
            return null;
        }
        return (a) view.getTag();
    }

    public void g(Context context, b<T, V> bVar) {
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f13287f.put(bVar.b(), bVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f13288g.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i2 = this.f13290i;
        if (i2 > 0) {
            this.f13290i = i2 - 1;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public void h(List<n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        c();
        this.f13288g = list;
        if (this.f13289h == null) {
            this.f13289h = new ArrayList();
        }
        for (int i2 = 0; i2 < this.f13288g.size(); i2++) {
            n nVar = this.f13288g.get(i2);
            if (nVar != null) {
                View b2 = b(nVar);
                b2.setOnClickListener(this);
                this.f13289h.add(b2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (i2 >= this.f13288g.size()) {
            return null;
        }
        View e2 = e(i2);
        if (e2 != null && e2.getParent() != viewGroup) {
            viewGroup.addView(e2);
        }
        return e2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.f13290i = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        a f2 = f(view);
        if (f2 == null || f2.a() == null || f2.a().getType() == null || (bVar = this.f13287f.get(f2.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(f2, f2.a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }
}

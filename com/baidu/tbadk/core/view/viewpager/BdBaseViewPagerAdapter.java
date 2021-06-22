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
import d.a.c.k.e.n;
import d.a.n0.r.f0.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f12674e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f12675f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f12676g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<View> f12677h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public int f12678i = 0;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public View f12680f;

        /* renamed from: e  reason: collision with root package name */
        public int f12679e = 3;

        /* renamed from: g  reason: collision with root package name */
        public n f12681g = null;

        public a(View view) {
            this.f12680f = null;
            this.f12680f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            return this.f12681g;
        }

        public View b() {
            return this.f12680f;
        }

        public void c(n nVar) {
            this.f12681g = nVar;
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.f12674e = context;
    }

    public final View a(n nVar) {
        b<T, V> bVar = this.f12675f.get(nVar.getType());
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view;
        if (this.f12677h.size() <= 0 || i2 < 0 || i2 >= this.f12677h.size() || (view = this.f12677h.get(i2)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void e() {
        b<T, V> bVar;
        List<View> list = this.f12677h;
        if (list != null) {
            for (View view : list) {
                a j = j(view);
                if (j != null && j.a() != null && (bVar = this.f12675f.get(j.a().getType())) != null) {
                    bVar.d(j, j.a());
                }
            }
            this.f12677h.clear();
            this.f12677h = null;
        }
        List<n> list2 = this.f12676g;
        if (list2 != null) {
            list2.clear();
        }
    }

    public final void f(a aVar, n nVar) {
        b<T, V> bVar;
        if (aVar == null || nVar == null || (bVar = this.f12675f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.e(null, aVar, nVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12676g.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i2 = this.f12678i;
        if (i2 > 0) {
            this.f12678i = i2 - 1;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public View i(int i2) {
        if (i2 >= this.f12677h.size() || i2 >= this.f12676g.size()) {
            return null;
        }
        View view = this.f12677h.get(i2);
        a j = j(view);
        if (j != null && j.a() == null) {
            f((a) view.getTag(), this.f12676g.get(i2));
        }
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (i2 >= this.f12676g.size()) {
            return null;
        }
        View i3 = i(i2);
        if (i3 != null && i3.getParent() != viewGroup) {
            viewGroup.addView(i3);
        }
        return i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final a j(View view) {
        if (view == null || !(view.getTag() instanceof a)) {
            return null;
        }
        return (a) view.getTag();
    }

    public void k(Context context, b<T, V> bVar) {
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.f12675f.put(bVar.b(), bVar);
    }

    public void l(List<n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        e();
        this.f12676g = list;
        if (this.f12677h == null) {
            this.f12677h = new ArrayList();
        }
        for (int i2 = 0; i2 < this.f12676g.size(); i2++) {
            n nVar = this.f12676g.get(i2);
            if (nVar != null) {
                View a2 = a(nVar);
                a2.setOnClickListener(this);
                this.f12677h.add(a2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.f12678i = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        a j = j(view);
        if (j == null || j.a() == null || j.a().getType() == null || (bVar = this.f12675f.get(j.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(j, j.a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }
}

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
import d.b.b.j.e.n;
import d.b.h0.r.f0.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f13652e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f13653f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public List<n> f13654g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<View> f13655h = new ArrayList();
    public int i = 0;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public View f13657f;

        /* renamed from: e  reason: collision with root package name */
        public int f13656e = 3;

        /* renamed from: g  reason: collision with root package name */
        public n f13658g = null;

        public a(View view) {
            this.f13657f = null;
            this.f13657f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            return this.f13658g;
        }

        public View b() {
            return this.f13657f;
        }

        public void c(n nVar) {
            this.f13658g = nVar;
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.f13652e = context;
    }

    public final View a(n nVar) {
        b<T, V> bVar = this.f13653f.get(nVar.getType());
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
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view;
        if (this.f13655h.size() <= 0 || i < 0 || i >= this.f13655h.size() || (view = this.f13655h.get(i)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void e() {
        b<T, V> bVar;
        List<View> list = this.f13655h;
        if (list != null) {
            for (View view : list) {
                a j = j(view);
                if (j != null && j.a() != null && (bVar = this.f13653f.get(j.a().getType())) != null) {
                    bVar.d(j, j.a());
                }
            }
            this.f13655h.clear();
            this.f13655h = null;
        }
        List<n> list2 = this.f13654g;
        if (list2 != null) {
            list2.clear();
        }
    }

    public final void f(a aVar, n nVar) {
        b<T, V> bVar;
        if (aVar == null || nVar == null || (bVar = this.f13653f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.e(null, aVar, nVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f13654g.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i = this.i;
        if (i > 0) {
            this.i = i - 1;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public View i(int i) {
        if (i >= this.f13655h.size() || i >= this.f13654g.size()) {
            return null;
        }
        View view = this.f13655h.get(i);
        a j = j(view);
        if (j != null && j.a() == null) {
            f((a) view.getTag(), this.f13654g.get(i));
        }
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.f13654g.size()) {
            return null;
        }
        View i2 = i(i);
        if (i2 != null && i2.getParent() != viewGroup) {
            viewGroup.addView(i2);
        }
        return i2;
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
        this.f13653f.put(bVar.b(), bVar);
    }

    public void l(List<n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        e();
        this.f13654g = list;
        if (this.f13655h == null) {
            this.f13655h = new ArrayList();
        }
        for (int i = 0; i < this.f13654g.size(); i++) {
            n nVar = this.f13654g.get(i);
            if (nVar != null) {
                View a2 = a(nVar);
                a2.setOnClickListener(this);
                this.f13655h.add(a2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.i = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        a j = j(view);
        if (j == null || j.a() == null || j.a().getType() == null || (bVar = this.f13653f.get(j.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(j, j.a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }
}

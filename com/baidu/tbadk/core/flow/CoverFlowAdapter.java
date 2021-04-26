package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.a0;
import d.a.i0.r.w.b.a;
import d.a.j0.q0.h;
import d.a.j0.s2.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowAdapter<T extends a> extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public Context f12856c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12857d;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.w.a f12860g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<TbImageView> f12854a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12855b = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TbImageView> f12858e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12859f = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.f12856c = context;
    }

    public T b(int i2) {
        ArrayList<T> arrayList = this.f12855b;
        if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f12855b.size()) {
            return null;
        }
        return this.f12855b.get(i2);
    }

    public void c() {
        ArrayList<TbImageView> arrayList = this.f12854a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<TbImageView> it = this.f12854a.iterator();
        while (it.hasNext()) {
            it.next().refresh();
        }
    }

    public final void d(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(List<T> list, d.a.i0.r.w.a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12860g = aVar;
        this.f12855b.clear();
        this.f12855b.addAll(list);
        d(this.f12855b);
        int size = this.f12854a.size();
        int size2 = this.f12855b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                tbImageView = aVar.d(this.f12856c);
                this.f12854a.add(tbImageView);
                tbImageView2 = aVar.d(this.f12856c);
                this.f12858e.add(tbImageView2);
                this.f12859f.add(new RelativeLayout(this.f12856c));
            } else {
                tbImageView = this.f12854a.get(i2);
                tbImageView2 = this.f12858e.get(i2);
                this.f12859f.get(i2);
            }
            if (this.f12855b.get(i2) != null && tbImageView != null) {
                if (this.f12855b.get(i2) instanceof h) {
                    tbImageView.setImageDrawable(SkinManager.getDrawable(Integer.valueOf(this.f12855b.get(i2).a()).intValue()));
                } else {
                    tbImageView.V(this.f12855b.get(i2).a(), 10, false);
                }
                tbImageView.setOnClickListener(this.f12857d);
                if ((this.f12855b.get(i2) instanceof a0) && !((a0) this.f12855b.get(i2)).j()) {
                    a0 a0Var = (a0) this.f12855b.get(i2);
                    x.t(a0Var.g(), tbImageView2, a0Var.h(), l.g(this.f12856c, R.dimen.ds24));
                }
            }
        }
        int count = ListUtils.getCount(this.f12855b);
        int count2 = ListUtils.getCount(this.f12854a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12854a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12858e);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12858e, count, count3);
        }
        int count4 = ListUtils.getCount(this.f12859f);
        if (count4 > count) {
            ListUtils.removeSubList(this.f12859f, count, count4);
        }
        notifyDataSetChanged();
    }

    public void f(View.OnClickListener onClickListener) {
        this.f12857d = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<TbImageView> arrayList = this.f12854a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f12854a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<TbImageView> arrayList = this.f12854a;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        TbImageView tbImageView = (TbImageView) ListUtils.getItem(arrayList, i2);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        if ((ListUtils.getItem(this.f12855b, i2) instanceof a0) && !((a0) ListUtils.getItem(this.f12855b, i2)).j()) {
            RelativeLayout relativeLayout = (RelativeLayout) ListUtils.getItem(this.f12859f, i2);
            TbImageView tbImageView2 = (TbImageView) ListUtils.getItem(this.f12858e, i2);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f12860g.b() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.g(this.f12856c, R.dimen.ds220) - l.g(this.f12856c, R.dimen.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView2, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i2));
            return relativeLayout;
        }
        if (tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
        if (tbImageView.getParent() == null) {
            viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tbImageView.setTag(Integer.valueOf(i2));
        tbImageView.refresh();
        return tbImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

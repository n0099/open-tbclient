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
import d.b.b.e.p.l;
import d.b.h0.r.q.a0;
import d.b.h0.r.w.b.a;
import d.b.i0.p0.h;
import d.b.i0.r2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowAdapter<T extends a> extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    public Context f13265c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13266d;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.w.a f13269g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<TbImageView> f13263a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f13264b = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TbImageView> f13267e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f13268f = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.f13265c = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<TbImageView> arrayList = this.f13263a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f13263a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public T i(int i) {
        ArrayList<T> arrayList = this.f13264b;
        if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.f13264b.size()) {
            return null;
        }
        return this.f13264b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ArrayList<TbImageView> arrayList = this.f13263a;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) ListUtils.getItem(arrayList, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((ListUtils.getItem(this.f13264b, i) instanceof a0) && !((a0) ListUtils.getItem(this.f13264b, i)).i()) {
            RelativeLayout relativeLayout = (RelativeLayout) ListUtils.getItem(this.f13268f, i);
            TbImageView tbImageView2 = (TbImageView) ListUtils.getItem(this.f13267e, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f13269g.b() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.g(this.f13265c, R.dimen.ds220) - l.g(this.f13265c, R.dimen.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView2, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i));
            return relativeLayout;
        }
        if (tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
        if (tbImageView.getParent() == null) {
            viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tbImageView.setTag(Integer.valueOf(i));
        tbImageView.refresh();
        return tbImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j() {
        ArrayList<TbImageView> arrayList = this.f13263a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<TbImageView> it = this.f13263a.iterator();
        while (it.hasNext()) {
            it.next().refresh();
        }
    }

    public final void k(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void l(List<T> list, d.b.h0.r.w.a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f13269g = aVar;
        this.f13264b.clear();
        this.f13264b.addAll(list);
        k(this.f13264b);
        int size = this.f13263a.size();
        int size2 = this.f13264b.size();
        for (int i = 0; i < size2; i++) {
            if (i >= size) {
                tbImageView = aVar.c(this.f13265c);
                this.f13263a.add(tbImageView);
                tbImageView2 = aVar.c(this.f13265c);
                this.f13267e.add(tbImageView2);
                this.f13268f.add(new RelativeLayout(this.f13265c));
            } else {
                tbImageView = this.f13263a.get(i);
                tbImageView2 = this.f13267e.get(i);
                this.f13268f.get(i);
            }
            if (this.f13264b.get(i) != null && tbImageView != null) {
                if (this.f13264b.get(i) instanceof h) {
                    tbImageView.setImageDrawable(SkinManager.getDrawable(Integer.valueOf(this.f13264b.get(i).a()).intValue()));
                } else {
                    tbImageView.W(this.f13264b.get(i).a(), 10, false);
                }
                tbImageView.setOnClickListener(this.f13266d);
                if ((this.f13264b.get(i) instanceof a0) && !((a0) this.f13264b.get(i)).i()) {
                    a0 a0Var = (a0) this.f13264b.get(i);
                    t.t(a0Var.g(), tbImageView2, a0Var.h(), l.g(this.f13265c, R.dimen.ds24));
                }
            }
        }
        int count = ListUtils.getCount(this.f13264b);
        int count2 = ListUtils.getCount(this.f13263a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f13263a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f13267e);
        if (count3 > count) {
            ListUtils.removeSubList(this.f13267e, count, count3);
        }
        int count4 = ListUtils.getCount(this.f13268f);
        if (count4 > count) {
            ListUtils.removeSubList(this.f13268f, count, count4);
        }
        notifyDataSetChanged();
    }

    public void m(View.OnClickListener onClickListener) {
        this.f13266d = onClickListener;
    }
}

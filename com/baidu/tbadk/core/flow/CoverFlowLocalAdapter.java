package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import d.a.m0.r.w.b.a;
import d.a.n0.r0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f12105a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12106b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f12107c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12108d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12109e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12110f;

    public CoverFlowLocalAdapter(Context context) {
        new ArrayList();
        this.f12110f = new ArrayList<>();
        this.f12107c = context;
    }

    public T b(int i2) {
        ArrayList<T> arrayList = this.f12106b;
        if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f12106b.size()) {
            return null;
        }
        return this.f12106b.get(i2);
    }

    public final void c(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.f12109e) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void d(boolean z) {
        this.f12109e = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(List<T> list, d.a.m0.r.w.a aVar) {
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12106b.clear();
        this.f12106b.addAll(list);
        c(this.f12106b);
        int size = this.f12105a.size();
        int size2 = this.f12106b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                imageView = new ImageView(this.f12107c);
                this.f12105a.add(imageView);
                this.f12110f.add(new RelativeLayout(this.f12107c));
            } else {
                imageView = this.f12105a.get(i2);
                this.f12110f.get(i2);
            }
            if (this.f12106b.get(i2) != null && imageView != null) {
                if (this.f12106b.get(i2) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f12106b.get(i2).a()).intValue()));
                }
                imageView.setOnClickListener(this.f12108d);
            }
        }
        int count = ListUtils.getCount(this.f12106b);
        int count2 = ListUtils.getCount(this.f12105a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12105a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12110f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12110f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void f(View.OnClickListener onClickListener) {
        this.f12108d = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<ImageView> arrayList = this.f12105a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f12105a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<ImageView> arrayList = this.f12105a;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i2);
        }
        ImageView imageView = (ImageView) ListUtils.getItem(arrayList, i2);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i2));
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

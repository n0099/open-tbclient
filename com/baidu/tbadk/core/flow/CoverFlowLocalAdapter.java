package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import d.b.h0.r.w.b.a;
import d.b.i0.p0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f13270a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f13271b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f13272c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13273d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13274e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f13275f;

    public CoverFlowLocalAdapter(Context context) {
        new ArrayList();
        this.f13275f = new ArrayList<>();
        this.f13272c = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<ImageView> arrayList = this.f13270a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f13270a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public T i(int i) {
        ArrayList<T> arrayList = this.f13271b;
        if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.f13271b.size()) {
            return null;
        }
        return this.f13271b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ArrayList<ImageView> arrayList = this.f13270a;
        if (arrayList == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) ListUtils.getItem(arrayList, i);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i));
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void j(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.f13274e) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void k(boolean z) {
        this.f13274e = z;
    }

    public void l(List<T> list, d.b.h0.r.w.a aVar) {
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f13271b.clear();
        this.f13271b.addAll(list);
        j(this.f13271b);
        int size = this.f13270a.size();
        int size2 = this.f13271b.size();
        for (int i = 0; i < size2; i++) {
            if (i >= size) {
                imageView = new ImageView(this.f13272c);
                this.f13270a.add(imageView);
                this.f13275f.add(new RelativeLayout(this.f13272c));
            } else {
                imageView = this.f13270a.get(i);
                this.f13275f.get(i);
            }
            if (this.f13271b.get(i) != null && imageView != null) {
                if (this.f13271b.get(i) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f13271b.get(i).a()).intValue()));
                }
                imageView.setOnClickListener(this.f13273d);
            }
        }
        int count = ListUtils.getCount(this.f13271b);
        int count2 = ListUtils.getCount(this.f13270a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f13270a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f13275f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f13275f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void m(View.OnClickListener onClickListener) {
        this.f13273d = onClickListener;
    }
}

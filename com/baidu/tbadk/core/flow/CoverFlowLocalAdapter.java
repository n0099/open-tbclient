package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import d.a.i0.r.w.b.a;
import d.a.j0.q0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f12861a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12862b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f12863c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12864d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12865e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12866f;

    public CoverFlowLocalAdapter(Context context) {
        new ArrayList();
        this.f12866f = new ArrayList<>();
        this.f12863c = context;
    }

    public T b(int i2) {
        ArrayList<T> arrayList = this.f12862b;
        if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f12862b.size()) {
            return null;
        }
        return this.f12862b.get(i2);
    }

    public final void c(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.f12865e) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void d(boolean z) {
        this.f12865e = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(List<T> list, d.a.i0.r.w.a aVar) {
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12862b.clear();
        this.f12862b.addAll(list);
        c(this.f12862b);
        int size = this.f12861a.size();
        int size2 = this.f12862b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                imageView = new ImageView(this.f12863c);
                this.f12861a.add(imageView);
                this.f12866f.add(new RelativeLayout(this.f12863c));
            } else {
                imageView = this.f12861a.get(i2);
                this.f12866f.get(i2);
            }
            if (this.f12862b.get(i2) != null && imageView != null) {
                if (this.f12862b.get(i2) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f12862b.get(i2).a()).intValue()));
                }
                imageView.setOnClickListener(this.f12864d);
            }
        }
        int count = ListUtils.getCount(this.f12862b);
        int count2 = ListUtils.getCount(this.f12861a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12861a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12866f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12866f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void f(View.OnClickListener onClickListener) {
        this.f12864d = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<ImageView> arrayList = this.f12861a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f12861a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<ImageView> arrayList = this.f12861a;
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

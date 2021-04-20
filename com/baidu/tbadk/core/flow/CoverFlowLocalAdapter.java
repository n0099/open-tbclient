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
import d.b.i0.q0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f12931a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12932b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f12933c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12934d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12935e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12936f;

    public CoverFlowLocalAdapter(Context context) {
        new ArrayList();
        this.f12936f = new ArrayList<>();
        this.f12933c = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<ImageView> arrayList = this.f12931a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f12931a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public T i(int i) {
        ArrayList<T> arrayList = this.f12932b;
        if (arrayList == null || arrayList.isEmpty() || i < 0 || i >= this.f12932b.size()) {
            return null;
        }
        return this.f12932b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ArrayList<ImageView> arrayList = this.f12931a;
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
        if (arrayList != null && (size = arrayList.size()) > 1 && this.f12935e) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void k(boolean z) {
        this.f12935e = z;
    }

    public void l(List<T> list, d.b.h0.r.w.a aVar) {
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12932b.clear();
        this.f12932b.addAll(list);
        j(this.f12932b);
        int size = this.f12931a.size();
        int size2 = this.f12932b.size();
        for (int i = 0; i < size2; i++) {
            if (i >= size) {
                imageView = new ImageView(this.f12933c);
                this.f12931a.add(imageView);
                this.f12936f.add(new RelativeLayout(this.f12933c));
            } else {
                imageView = this.f12931a.get(i);
                this.f12936f.get(i);
            }
            if (this.f12932b.get(i) != null && imageView != null) {
                if (this.f12932b.get(i) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f12932b.get(i).a()).intValue()));
                }
                imageView.setOnClickListener(this.f12934d);
            }
        }
        int count = ListUtils.getCount(this.f12932b);
        int count2 = ListUtils.getCount(this.f12931a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12931a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12936f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12936f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void m(View.OnClickListener onClickListener) {
        this.f12934d = onClickListener;
    }
}

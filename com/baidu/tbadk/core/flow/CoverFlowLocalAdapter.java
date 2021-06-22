package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import d.a.n0.r.w.b.a;
import d.a.o0.r0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalAdapter<T extends a> extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f12249a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f12250b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f12251c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12252d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12253e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<RelativeLayout> f12254f;

    public CoverFlowLocalAdapter(Context context) {
        new ArrayList();
        this.f12254f = new ArrayList<>();
        this.f12251c = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<ImageView> arrayList = this.f12249a;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f12249a.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public T i(int i2) {
        ArrayList<T> arrayList = this.f12250b;
        if (arrayList == null || arrayList.isEmpty() || i2 < 0 || i2 >= this.f12250b.size()) {
            return null;
        }
        return this.f12250b.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        ArrayList<ImageView> arrayList = this.f12249a;
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

    public final void j(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.f12253e) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    public void k(boolean z) {
        this.f12253e = z;
    }

    public void l(List<T> list, d.a.n0.r.w.a aVar) {
        ImageView imageView;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f12250b.clear();
        this.f12250b.addAll(list);
        j(this.f12250b);
        int size = this.f12249a.size();
        int size2 = this.f12250b.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 >= size) {
                imageView = new ImageView(this.f12251c);
                this.f12249a.add(imageView);
                this.f12254f.add(new RelativeLayout(this.f12251c));
            } else {
                imageView = this.f12249a.get(i2);
                this.f12254f.get(i2);
            }
            if (this.f12250b.get(i2) != null && imageView != null) {
                if (this.f12250b.get(i2) instanceof h) {
                    imageView.setImageDrawable(SkinManager.getDrawable(imageView.getResources(), Integer.valueOf(this.f12250b.get(i2).a()).intValue()));
                }
                imageView.setOnClickListener(this.f12252d);
            }
        }
        int count = ListUtils.getCount(this.f12250b);
        int count2 = ListUtils.getCount(this.f12249a);
        if (count2 > count) {
            ListUtils.removeSubList(this.f12249a, count, count2);
        }
        int count3 = ListUtils.getCount(this.f12254f);
        if (count3 > count) {
            ListUtils.removeSubList(this.f12254f, count, count3);
        }
        notifyDataSetChanged();
    }

    public void m(View.OnClickListener onClickListener) {
        this.f12252d = onClickListener;
    }
}

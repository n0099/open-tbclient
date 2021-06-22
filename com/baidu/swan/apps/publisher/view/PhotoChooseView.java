package com.baidu.swan.apps.publisher.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import d.a.m0.a.i1.d.d.c;
import d.a.m0.a.p.d.h0;
import d.a.m0.a.w1.j.g;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoChooseView extends GridView implements AdapterView.OnItemClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f11175e;

    /* renamed from: f  reason: collision with root package name */
    public int f11176f;

    /* renamed from: g  reason: collision with root package name */
    public int f11177g;

    /* renamed from: h  reason: collision with root package name */
    public int f11178h;

    /* renamed from: i  reason: collision with root package name */
    public c f11179i;
    public d.a.m0.a.w1.h.f.a j;
    public Activity k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoChooseView photoChooseView = PhotoChooseView.this;
            photoChooseView.setAdapter((ListAdapter) photoChooseView.j);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public PhotoChooseView(Context context) {
        super(context);
        this.f11175e = 9;
    }

    public final void b() {
        if (getLeftCount() > 0) {
            g.i(getLeftCount(), this.f11179i);
        }
    }

    public final void c(int i2) {
        h0 y = d.a.m0.a.c1.a.y();
        if (y != null) {
            y.d(getContext(), (String[]) this.j.c().toArray(new String[0]), i2);
        }
    }

    public void d(Activity activity) {
        this.k = activity;
        this.j = new d.a.m0.a.w1.h.f.a(activity.getApplicationContext(), this.f11176f, this.f11178h);
        setOnItemClickListener(this);
        postDelayed(new a(), 10L);
    }

    public void e(List<String> list) {
        this.j.f(list);
        this.j.notifyDataSetChanged();
    }

    public List<String> getData() {
        List<String> c2 = this.j.c();
        if (c2 == null || c2.size() == 0) {
            return null;
        }
        return c2;
    }

    public int getLeftCount() {
        int size = this.j.c().size();
        int i2 = this.f11175e;
        if (size >= i2) {
            return 0;
        }
        return i2 - size;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (this.j.e(i2)) {
            if (i2 == this.j.getCount() - 1) {
                d.a.m0.a.w1.j.c.onEvent("pic_clk_content");
                b();
                return;
            }
            c(i2);
            return;
        }
        c(i2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        super.onMeasure(i2, i3);
        if (getCount() <= 0 || getChildAt(0) == null || (measuredHeight = getChildAt(0).getMeasuredHeight()) == -1) {
            return;
        }
        setMeasuredDimension(i2, (measuredHeight * (((getCount() - 1) / this.f11178h) + 1)) + (this.f11177g * ((getCount() - 1) / this.f11178h)));
    }

    public void setCallback(c cVar) {
        this.f11179i = cVar;
    }

    public void setDeleteListener(b bVar) {
        this.j.g(bVar);
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.f11176f = i2;
    }

    public void setMaxCount(int i2) {
        this.f11175e = i2;
        this.j.h(i2);
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        super.setNumColumns(i2);
        this.f11178h = i2;
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.f11177g = i2;
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11175e = 9;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'd.a.m0.a.w1.h.f.a' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.j;
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11175e = 9;
    }
}

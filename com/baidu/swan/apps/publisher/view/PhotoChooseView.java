package com.baidu.swan.apps.publisher.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tieba.br1;
import com.baidu.tieba.bu2;
import com.baidu.tieba.d43;
import com.baidu.tieba.h43;
import com.baidu.tieba.np2;
import com.baidu.tieba.x33;
import java.util.List;
/* loaded from: classes4.dex */
public class PhotoChooseView extends GridView implements AdapterView.OnItemClickListener {
    public int a;
    public int b;
    public int c;
    public int d;
    public bu2 e;
    public x33 f;
    public Activity g;

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoChooseView photoChooseView = PhotoChooseView.this;
            photoChooseView.setAdapter((ListAdapter) photoChooseView.f);
        }
    }

    public PhotoChooseView(Context context) {
        super(context);
        this.a = 9;
    }

    public final void c(int i) {
        br1 C = np2.C();
        if (C != null) {
            C.d(getContext(), (String[]) this.f.c().toArray(new String[0]), i);
        }
    }

    public void d(Activity activity) {
        this.g = activity;
        this.f = new x33(activity.getApplicationContext(), this.b, this.d);
        setOnItemClickListener(this);
        postDelayed(new a(), 10L);
    }

    public void e(List<String> list) {
        this.f.f(list);
        this.f.notifyDataSetChanged();
    }

    public void setCallback(bu2 bu2Var) {
        this.e = bu2Var;
    }

    public void setDeleteListener(b bVar) {
        this.f.g(bVar);
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.b = i;
    }

    public void setMaxCount(int i) {
        this.a = i;
        this.f.h(i);
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.d = i;
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.c = i;
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 9;
    }

    public PhotoChooseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 9;
    }

    public final void b() {
        if (getLeftCount() > 0) {
            h43.i(getLeftCount(), this.e);
        }
    }

    public List<String> getData() {
        List<String> c = this.f.c();
        if (c != null && c.size() != 0) {
            return c;
        }
        return null;
    }

    public int getLeftCount() {
        int size = this.f.c().size();
        int i = this.a;
        if (size >= i) {
            return 0;
        }
        return i - size;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.x33' to match base method */
    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.f;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (this.f.e(i)) {
            if (i == this.f.getCount() - 1) {
                d43.onEvent("pic_clk_content");
                b();
                return;
            }
            c(i);
            return;
        }
        c(i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        super.onMeasure(i, i2);
        if (getCount() > 0 && getChildAt(0) != null && (measuredHeight = getChildAt(0).getMeasuredHeight()) != -1) {
            setMeasuredDimension(i, (measuredHeight * (((getCount() - 1) / this.d) + 1)) + (this.c * ((getCount() - 1) / this.d)));
        }
    }
}

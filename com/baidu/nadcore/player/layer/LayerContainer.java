package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.pp0;
import com.baidu.tieba.vu0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public pp0 b;
    public ArrayList<vu0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull vu0 vu0Var) {
        b(vu0Var, getContainerParams());
    }

    public void c(@NonNull vu0 vu0Var) {
        e(vu0Var);
        vu0Var.M(this);
        vu0Var.s(getBindPlayer().y());
        this.c.add(0, vu0Var);
        if (vu0Var.getContentView() != null) {
            addView(vu0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull pp0 pp0Var) {
        this.b = pp0Var;
    }

    public void e(@NonNull vu0 vu0Var) {
        f(vu0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull vu0 vu0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(vu0Var);
        vu0Var.H();
        if (vu0Var.getContentView() != null && (viewGroup = (ViewGroup) vu0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(vu0Var.getContentView());
        }
        if (z) {
            vu0Var.t();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull vu0 vu0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(vu0Var)) {
            return;
        }
        vu0Var.M(this);
        vu0Var.F();
        vu0Var.s(getBindPlayer().y());
        this.c.add(vu0Var);
        if (vu0Var.getContentView() != null && vu0Var.getContentView() != this) {
            addView(vu0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public pp0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<vu0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<vu0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<vu0> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    public void i() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).onLayerRelease();
        }
        this.c.clear();
        removeAllViews();
    }
}

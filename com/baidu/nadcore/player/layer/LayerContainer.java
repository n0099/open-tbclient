package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.eu0;
import com.baidu.tieba.yo0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public yo0 b;
    public ArrayList<eu0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull eu0 eu0Var) {
        b(eu0Var, getContainerParams());
    }

    public void c(@NonNull eu0 eu0Var) {
        e(eu0Var);
        eu0Var.L(this);
        eu0Var.r(getBindPlayer().y());
        this.c.add(0, eu0Var);
        if (eu0Var.getContentView() != null) {
            addView(eu0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull yo0 yo0Var) {
        this.b = yo0Var;
    }

    public void e(@NonNull eu0 eu0Var) {
        f(eu0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull eu0 eu0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(eu0Var);
        eu0Var.G();
        if (eu0Var.getContentView() != null && (viewGroup = (ViewGroup) eu0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(eu0Var.getContentView());
        }
        if (z) {
            eu0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull eu0 eu0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(eu0Var)) {
            return;
        }
        eu0Var.L(this);
        eu0Var.E();
        eu0Var.r(getBindPlayer().y());
        this.c.add(eu0Var);
        if (eu0Var.getContentView() != null && eu0Var.getContentView() != this) {
            addView(eu0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public yo0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<eu0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<eu0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<eu0> it = arrayList.iterator();
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

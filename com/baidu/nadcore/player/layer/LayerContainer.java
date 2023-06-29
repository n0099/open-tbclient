package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.eu0;
import com.baidu.tieba.lz0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public eu0 b;
    public ArrayList<lz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull lz0 lz0Var) {
        b(lz0Var, getContainerParams());
    }

    public void c(@NonNull lz0 lz0Var) {
        e(lz0Var);
        lz0Var.K(this);
        lz0Var.r(getBindPlayer().x());
        this.c.add(0, lz0Var);
        if (lz0Var.getContentView() != null) {
            addView(lz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull eu0 eu0Var) {
        this.b = eu0Var;
    }

    public void e(@NonNull lz0 lz0Var) {
        f(lz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull lz0 lz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(lz0Var);
        lz0Var.F();
        if (lz0Var.getContentView() != null && (viewGroup = (ViewGroup) lz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(lz0Var.getContentView());
        }
        if (z) {
            lz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull lz0 lz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(lz0Var)) {
            return;
        }
        lz0Var.K(this);
        lz0Var.D();
        lz0Var.r(getBindPlayer().x());
        this.c.add(lz0Var);
        if (lz0Var.getContentView() != null && lz0Var.getContentView() != this) {
            addView(lz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public eu0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<lz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<lz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<lz0> it = arrayList.iterator();
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

package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.cu0;
import com.baidu.tieba.jz0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public cu0 b;
    public ArrayList<jz0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull jz0 jz0Var) {
        b(jz0Var, getContainerParams());
    }

    public void c(@NonNull jz0 jz0Var) {
        e(jz0Var);
        jz0Var.K(this);
        jz0Var.r(getBindPlayer().x());
        this.c.add(0, jz0Var);
        if (jz0Var.getContentView() != null) {
            addView(jz0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull cu0 cu0Var) {
        this.b = cu0Var;
    }

    public void e(@NonNull jz0 jz0Var) {
        f(jz0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull jz0 jz0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(jz0Var);
        jz0Var.F();
        if (jz0Var.getContentView() != null && (viewGroup = (ViewGroup) jz0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(jz0Var.getContentView());
        }
        if (z) {
            jz0Var.s();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull jz0 jz0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(jz0Var)) {
            return;
        }
        jz0Var.K(this);
        jz0Var.D();
        jz0Var.r(getBindPlayer().x());
        this.c.add(jz0Var);
        if (jz0Var.getContentView() != null && jz0Var.getContentView() != this) {
            addView(jz0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public cu0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<jz0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<jz0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<jz0> it = arrayList.iterator();
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

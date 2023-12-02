package com.baidu.nadcore.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.sp0;
import com.baidu.tieba.yu0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class LayerContainer extends FrameLayout {
    public FrameLayout.LayoutParams a;
    public sp0 b;
    public ArrayList<yu0> c;

    public LayerContainer(@NonNull Context context) {
        super(context);
        g();
    }

    public void a(@NonNull yu0 yu0Var) {
        b(yu0Var, getContainerParams());
    }

    public void c(@NonNull yu0 yu0Var) {
        e(yu0Var);
        yu0Var.M(this);
        yu0Var.s(getBindPlayer().y());
        this.c.add(0, yu0Var);
        if (yu0Var.getContentView() != null) {
            addView(yu0Var.getContentView(), 0, this.a);
        }
    }

    public void d(@NonNull sp0 sp0Var) {
        this.b = sp0Var;
    }

    public void e(@NonNull yu0 yu0Var) {
        f(yu0Var, false);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public void f(@NonNull yu0 yu0Var, boolean z) {
        ViewGroup viewGroup;
        this.c.remove(yu0Var);
        yu0Var.H();
        if (yu0Var.getContentView() != null && (viewGroup = (ViewGroup) yu0Var.getContentView().getParent()) != null) {
            viewGroup.removeView(yu0Var.getContentView());
        }
        if (z) {
            yu0Var.t();
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void b(@NonNull yu0 yu0Var, FrameLayout.LayoutParams layoutParams) {
        if (this.c.contains(yu0Var)) {
            return;
        }
        yu0Var.M(this);
        yu0Var.F();
        yu0Var.s(getBindPlayer().y());
        this.c.add(yu0Var);
        if (yu0Var.getContentView() != null && yu0Var.getContentView() != this) {
            addView(yu0Var.getContentView(), layoutParams);
        }
    }

    public final void g() {
        this.c = new ArrayList<>();
        this.a = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public sp0 getBindPlayer() {
        return this.b;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<yu0> getLayerList() {
        return this.c;
    }

    public void h() {
        ArrayList<yu0> arrayList = this.c;
        if (arrayList != null) {
            Iterator<yu0> it = arrayList.iterator();
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

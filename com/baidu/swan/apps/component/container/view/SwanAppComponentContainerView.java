package com.baidu.swan.apps.component.container.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import d.a.l0.a.c0.b.b;
import d.a.l0.a.c0.g.a;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class SwanAppComponentContainerView extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10673i = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public View f10674e;

    /* renamed from: f  reason: collision with root package name */
    public b f10675f;

    /* renamed from: g  reason: collision with root package name */
    public Path f10676g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f10677h;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void a(Canvas canvas) {
        Path path;
        if (Build.VERSION.SDK_INT < 21 || (path = this.f10676g) == null || this.f10674e == null) {
            return;
        }
        b bVar = this.f10675f;
        if (bVar instanceof d.a.l0.a.c0.c.e.c.b) {
            d.a.l0.a.c0.c.e.c.b bVar2 = (d.a.l0.a.c0.c.e.c.b) bVar;
            if (bVar2.r > 0) {
                path.reset();
                Path path2 = this.f10676g;
                float left = this.f10674e.getLeft();
                float top = this.f10674e.getTop();
                float right = this.f10674e.getRight();
                float bottom = this.f10674e.getBottom();
                int i2 = bVar2.r;
                path2.addRoundRect(left, top, right, bottom, i2, i2, Path.Direction.CW);
                if (f10673i) {
                    Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar2.r);
                }
                canvas.save();
                canvas.clipPath(this.f10676g);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        return this.f10677h;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void setHidden(boolean z) {
        View view = this.f10677h;
        if (view == null) {
            view = this;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public void setModel(@NonNull b bVar) {
        this.f10675f = bVar;
    }

    public void setScrollView(ScrollView scrollView) {
        this.f10677h = scrollView;
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i2) {
        if (this.f10674e == view) {
            d.l("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.f10676g == null) {
            this.f10676g = new Path();
        }
        if (this.f10674e != null) {
            a.a("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.f10674e);
        }
        this.f10674e = view;
        addView(view, i2, generateDefaultLayoutParams());
    }
}

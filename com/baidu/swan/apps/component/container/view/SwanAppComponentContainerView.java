package com.baidu.swan.apps.component.container.view;

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
import d.a.h0.a.a0.b.b;
import d.a.h0.a.a0.g.a;
import d.a.h0.a.c0.c;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class SwanAppComponentContainerView extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f11626i = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public View f11627e;

    /* renamed from: f  reason: collision with root package name */
    public b f11628f;

    /* renamed from: g  reason: collision with root package name */
    public Path f11629g;

    /* renamed from: h  reason: collision with root package name */
    public ScrollView f11630h;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    public final void a(Canvas canvas) {
        Path path;
        if (Build.VERSION.SDK_INT < 21 || (path = this.f11629g) == null || this.f11627e == null) {
            return;
        }
        b bVar = this.f11628f;
        if (bVar instanceof d.a.h0.a.a0.c.e.c.b) {
            d.a.h0.a.a0.c.e.c.b bVar2 = (d.a.h0.a.a0.c.e.c.b) bVar;
            if (bVar2.r > 0) {
                path.reset();
                Path path2 = this.f11629g;
                float left = this.f11627e.getLeft();
                float top = this.f11627e.getTop();
                float right = this.f11627e.getRight();
                float bottom = this.f11627e.getBottom();
                int i2 = bVar2.r;
                path2.addRoundRect(left, top, right, bottom, i2, i2, Path.Direction.CW);
                if (f11626i) {
                    Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar2.r);
                }
                canvas.save();
                canvas.clipPath(this.f11629g);
                canvas.restore();
            }
        }
    }

    public ScrollView getScrollView() {
        return this.f11630h;
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void setHidden(boolean z) {
        View view = this.f11630h;
        if (view == null) {
            view = this;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public void setModel(@NonNull b bVar) {
        this.f11628f = bVar;
    }

    public void setScrollView(ScrollView scrollView) {
        this.f11630h = scrollView;
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i2) {
        if (this.f11627e == view) {
            c.l("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.f11629g == null) {
            this.f11629g = new Path();
        }
        if (this.f11627e != null) {
            a.a("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.f11627e);
        }
        this.f11627e = view;
        addView(view, i2, generateDefaultLayoutParams());
    }
}

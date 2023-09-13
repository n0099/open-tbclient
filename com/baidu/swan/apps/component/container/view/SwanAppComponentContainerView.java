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
import com.baidu.tieba.a82;
import com.baidu.tieba.h82;
import com.baidu.tieba.p72;
import com.baidu.tieba.rr1;
import com.baidu.tieba.x62;
/* loaded from: classes4.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    public static final boolean e = rr1.a;
    public View a;
    public x62 b;
    public Path c;
    public ScrollView d;

    public ScrollView getScrollView() {
        return this.d;
    }

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void setHidden(boolean z) {
        int i;
        View view2 = this.d;
        if (view2 == null) {
            view2 = this;
        }
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
    }

    public void setModel(@NonNull x62 x62Var) {
        this.b = x62Var;
    }

    public void setScrollView(ScrollView scrollView) {
        this.d = scrollView;
    }

    public void setTargetView(@NonNull View view2) {
        setTargetView(view2, -1);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void a(Canvas canvas) {
        Path path;
        if (Build.VERSION.SDK_INT >= 21 && (path = this.c) != null && this.a != null) {
            x62 x62Var = this.b;
            if (x62Var instanceof p72) {
                p72 p72Var = (p72) x62Var;
                if (p72Var.n > 0) {
                    path.reset();
                    Path path2 = this.c;
                    float left = this.a.getLeft();
                    float top = this.a.getTop();
                    float right = this.a.getRight();
                    float bottom = this.a.getBottom();
                    int i = p72Var.n;
                    path2.addRoundRect(left, top, right, bottom, i, i, Path.Direction.CW);
                    if (e) {
                        Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + p72Var.n);
                    }
                    canvas.save();
                    canvas.clipPath(this.c);
                    canvas.restore();
                }
            }
        }
    }

    public void setTargetView(@NonNull View view2, int i) {
        if (this.a == view2) {
            h82.o("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.c == null) {
            this.c = new Path();
        }
        if (this.a != null) {
            a82.a("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.a);
        }
        this.a = view2;
        addView(view2, i, generateDefaultLayoutParams());
    }
}

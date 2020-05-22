package com.baidu.swan.apps.component.container.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.component.e.a;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class SwanAppComponentContainerView extends FrameLayout {
    protected static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.component.b.b bPw;
    private ScrollView bQQ;
    private Path mPath;
    private View mTargetView;

    public SwanAppComponentContainerView(@NonNull Context context) {
        super(context);
    }

    public void setTargetView(@NonNull View view) {
        setTargetView(view, -1);
    }

    public void setTargetView(@NonNull View view, int i) {
        if (this.mTargetView == view) {
            c.w("Component-ContainerView", "repeat setTargetView with the same view");
            return;
        }
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        if (this.mTargetView != null) {
            a.aS("Component-ContainerView", "repeat setTargetView with the different view");
            removeView(this.mTargetView);
        }
        this.mTargetView = view;
        addView(this.mTargetView, i, generateDefaultLayoutParams());
    }

    public void setModel(@NonNull com.baidu.swan.apps.component.b.b bVar) {
        this.bPw = bVar;
    }

    @Override // android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n(canvas);
    }

    private void n(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21 && this.mPath != null && this.mTargetView != null && (this.bPw instanceof com.baidu.swan.apps.component.components.e.c.b)) {
            com.baidu.swan.apps.component.components.e.c.b bVar = (com.baidu.swan.apps.component.components.e.c.b) this.bPw;
            this.mPath.addRoundRect(this.mTargetView.getLeft(), this.mTargetView.getTop(), this.mTargetView.getRight(), this.mTargetView.getBottom(), bVar.bPr, bVar.bPr, Path.Direction.CW);
            if (DEBUG) {
                Log.d("Component-ContainerView", "SwanAppComponentContainerView  model.borderRadius =" + bVar.bPr);
            }
            canvas.clipPath(this.mPath);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public void setHidden(boolean z) {
        ScrollView scrollView = this.bQQ;
        ?? r1 = this;
        if (scrollView != null) {
            r1 = this.bQQ;
        }
        r1.setVisibility(z ? 8 : 0);
    }

    public ScrollView getScrollView() {
        return this.bQQ;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bQQ = scrollView;
    }
}

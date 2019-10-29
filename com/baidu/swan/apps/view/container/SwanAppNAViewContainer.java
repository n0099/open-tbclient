package com.baidu.swan.apps.view.container;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.view.container.c.c;
/* loaded from: classes2.dex */
public class SwanAppNAViewContainer extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.model.a.a.a bvB;
    private View bvC;
    private ScrollView bvD;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        au(view);
        return Vd();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean Vc() {
        a jc;
        boolean z = false;
        if (this.bvB != null && (jc = ac.jc(this.bvB.aXH)) != null && (z = c.b(this, jc))) {
            c.d(this, jc);
            this.bvC = null;
        }
        return z;
    }

    public View getNAView() {
        return this.bvC;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.bvB = null;
            return;
        }
        this.bvB = aVar.Mq();
        setHidden(this.bvB.hidden);
        setGesture(this.bvB.aXK);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.bvB;
    }

    public void setHidden(boolean z) {
        (this.bvD == null ? this : this.bvD).setVisibility(z ? 8 : 0);
        if (this.bvB != null) {
            this.bvB.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.bvB != null) {
            this.bvB.aXK = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.bvB.aXH, this.bvB.id, this.bvB.aXG) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.bvB != null && SwanAppNAViewContainer.this.bvB.aXK && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.bvB != null ? this.bvB.aXH : "No_Id";
    }

    public String getViewId() {
        return this.bvB != null ? this.bvB.id : "No_Id";
    }

    public String getParentId() {
        return this.bvB != null ? this.bvB.aXI : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.bvB != null && this.bvB.aXJ != null) {
            this.bvB.aXJ.dI(marginLayoutParams.leftMargin);
            this.bvB.aXJ.dJ(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean Vd() {
        a jc;
        boolean z = false;
        if (this.bvB != null && (jc = ac.jc(this.bvB.aXH)) != null && (z = c.a(this, jc))) {
            c.c(this, jc);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.bvC = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.bvC = view;
    }

    private void au(View view) {
        addView(view, generateDefaultLayoutParams());
        this.bvC = view;
    }

    public ScrollView getScrollView() {
        return this.bvD;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bvD = scrollView;
    }
}

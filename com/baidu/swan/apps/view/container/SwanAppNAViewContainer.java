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
    private com.baidu.swan.apps.model.a.a.a buK;
    private View buL;
    private ScrollView buM;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        au(view);
        return Vb();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean Va() {
        a jc;
        boolean z = false;
        if (this.buK != null && (jc = ac.jc(this.buK.aXp)) != null && (z = c.b(this, jc))) {
            c.d(this, jc);
            this.buL = null;
        }
        return z;
    }

    public View getNAView() {
        return this.buL;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.buK = null;
            return;
        }
        this.buK = aVar.Mr();
        setHidden(this.buK.hidden);
        setGesture(this.buK.aXs);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.buK;
    }

    public void setHidden(boolean z) {
        (this.buM == null ? this : this.buM).setVisibility(z ? 8 : 0);
        if (this.buK != null) {
            this.buK.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.buK != null) {
            this.buK.aXs = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.buK.aXp, this.buK.id, this.buK.aXo) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.buK != null && SwanAppNAViewContainer.this.buK.aXs && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.buK != null ? this.buK.aXp : "No_Id";
    }

    public String getViewId() {
        return this.buK != null ? this.buK.id : "No_Id";
    }

    public String getParentId() {
        return this.buK != null ? this.buK.aXq : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.buK != null && this.buK.aXr != null) {
            this.buK.aXr.dI(marginLayoutParams.leftMargin);
            this.buK.aXr.dJ(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean Vb() {
        a jc;
        boolean z = false;
        if (this.buK != null && (jc = ac.jc(this.buK.aXp)) != null && (z = c.a(this, jc))) {
            c.c(this, jc);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.buL = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.buL = view;
    }

    private void au(View view) {
        addView(view, generateDefaultLayoutParams());
        this.buL = view;
    }

    public ScrollView getScrollView() {
        return this.buM;
    }

    public void setScrollView(ScrollView scrollView) {
        this.buM = scrollView;
    }
}

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
    private com.baidu.swan.apps.model.a.a.a bcC;
    private View bcD;
    private ScrollView bcE;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        ao(view);
        return Qn();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean Qm() {
        a iz;
        boolean z = false;
        if (this.bcC != null && (iz = ac.iz(this.bcC.aEs)) != null && (z = c.b(this, iz))) {
            c.d(this, iz);
            this.bcD = null;
        }
        return z;
    }

    public View getNAView() {
        return this.bcD;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.bcC = null;
            return;
        }
        this.bcC = aVar.Hw();
        setHidden(this.bcC.hidden);
        setGesture(this.bcC.aEv);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.bcC;
    }

    public void setHidden(boolean z) {
        (this.bcE == null ? this : this.bcE).setVisibility(z ? 8 : 0);
        if (this.bcC != null) {
            this.bcC.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.bcC != null) {
            this.bcC.aEv = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.bcC.aEs, this.bcC.id, this.bcC.aEr) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.bcC != null && SwanAppNAViewContainer.this.bcC.aEv && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.bcC != null ? this.bcC.aEs : "No_Id";
    }

    public String getViewId() {
        return this.bcC != null ? this.bcC.id : "No_Id";
    }

    public String getParentId() {
        return this.bcC != null ? this.bcC.aEt : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.bcC != null && this.bcC.aEu != null) {
            this.bcC.aEu.cN(marginLayoutParams.leftMargin);
            this.bcC.aEu.cO(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean Qn() {
        a iz;
        boolean z = false;
        if (this.bcC != null && (iz = ac.iz(this.bcC.aEs)) != null && (z = c.a(this, iz))) {
            c.c(this, iz);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.bcD = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.bcD = view;
    }

    private void ao(View view) {
        addView(view, generateDefaultLayoutParams());
        this.bcD = view;
    }

    public ScrollView getScrollView() {
        return this.bcE;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bcE = scrollView;
    }
}

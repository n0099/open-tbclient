package com.baidu.swan.apps.view.container;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.view.container.b.b;
/* loaded from: classes2.dex */
public class SwanAppNAViewContainer extends FrameLayout {
    private static final boolean DEBUG = c.DEBUG;
    private com.baidu.swan.apps.model.a.a.a aYA;
    private View aYB;
    private ScrollView aYC;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        aj(view);
        return ML();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return com.baidu.swan.apps.view.container.c.c.a(this, aVar);
    }

    public boolean MK() {
        a hM;
        boolean z = false;
        if (this.aYA != null && (hM = aa.hM(this.aYA.aBC)) != null && (z = com.baidu.swan.apps.view.container.c.c.b(this, hM))) {
            com.baidu.swan.apps.view.container.c.c.d(this, hM);
            this.aYB = null;
        }
        return z;
    }

    public View getNAView() {
        return this.aYB;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.aYA = null;
            return;
        }
        this.aYA = aVar.EM();
        setHidden(this.aYA.hidden);
        setGesture(this.aYA.aBF);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.aYA;
    }

    public void setHidden(boolean z) {
        (this.aYC == null ? this : this.aYC).setVisibility(z ? 8 : 0);
        if (this.aYA != null) {
            this.aYA.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.aYA != null) {
            this.aYA.aBF = z;
            if (z) {
                setOnTouchListener(new b(this.aYA.aBC, this.aYA.id, this.aYA.aBB) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.aYA != null && SwanAppNAViewContainer.this.aYA.aBF && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.aYA != null ? this.aYA.aBC : "No_Id";
    }

    public String getViewId() {
        return this.aYA != null ? this.aYA.id : "No_Id";
    }

    public String getParentId() {
        return this.aYA != null ? this.aYA.aBD : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.aYA != null && this.aYA.aBE != null) {
            this.aYA.aBE.setLeft(marginLayoutParams.leftMargin);
            this.aYA.aBE.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean ML() {
        a hM;
        boolean z = false;
        if (this.aYA != null && (hM = aa.hM(this.aYA.aBC)) != null && (z = com.baidu.swan.apps.view.container.c.c.a(this, hM))) {
            com.baidu.swan.apps.view.container.c.c.c(this, hM);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.aYB = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.aYB = view;
    }

    private void aj(View view) {
        addView(view, generateDefaultLayoutParams());
        this.aYB = view;
    }

    public ScrollView getScrollView() {
        return this.aYC;
    }

    public void setScrollView(ScrollView scrollView) {
        this.aYC = scrollView;
    }
}

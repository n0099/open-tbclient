package com.baidu.swan.apps.view.container;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.view.container.c.c;
/* loaded from: classes2.dex */
public class SwanAppNAViewContainer extends FrameLayout {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.model.a.a.a aYB;
    private View aYC;
    private ScrollView aYD;

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
        return c.a(this, aVar);
    }

    public boolean MK() {
        a hM;
        boolean z = false;
        if (this.aYB != null && (hM = aa.hM(this.aYB.aBD)) != null && (z = c.b(this, hM))) {
            c.d(this, hM);
            this.aYC = null;
        }
        return z;
    }

    public View getNAView() {
        return this.aYC;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.aYB = null;
            return;
        }
        this.aYB = aVar.EM();
        setHidden(this.aYB.hidden);
        setGesture(this.aYB.aBG);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.aYB;
    }

    public void setHidden(boolean z) {
        (this.aYD == null ? this : this.aYD).setVisibility(z ? 8 : 0);
        if (this.aYB != null) {
            this.aYB.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.aYB != null) {
            this.aYB.aBG = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.aYB.aBD, this.aYB.id, this.aYB.aBC) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.aYB != null && SwanAppNAViewContainer.this.aYB.aBG && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.aYB != null ? this.aYB.aBD : "No_Id";
    }

    public String getViewId() {
        return this.aYB != null ? this.aYB.id : "No_Id";
    }

    public String getParentId() {
        return this.aYB != null ? this.aYB.aBE : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.aYB != null && this.aYB.aBF != null) {
            this.aYB.aBF.setLeft(marginLayoutParams.leftMargin);
            this.aYB.aBF.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean ML() {
        a hM;
        boolean z = false;
        if (this.aYB != null && (hM = aa.hM(this.aYB.aBD)) != null && (z = c.a(this, hM))) {
            c.c(this, hM);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.aYC = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.aYC = view;
    }

    private void aj(View view) {
        addView(view, generateDefaultLayoutParams());
        this.aYC = view;
    }

    public ScrollView getScrollView() {
        return this.aYD;
    }

    public void setScrollView(ScrollView scrollView) {
        this.aYD = scrollView;
    }
}

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
    private com.baidu.swan.apps.model.a.a.a aYE;
    private View aYF;
    private ScrollView aYG;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        aj(view);
        return MJ();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean MI() {
        a hN;
        boolean z = false;
        if (this.aYE != null && (hN = aa.hN(this.aYE.aBG)) != null && (z = c.b(this, hN))) {
            c.d(this, hN);
            this.aYF = null;
        }
        return z;
    }

    public View getNAView() {
        return this.aYF;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.aYE = null;
            return;
        }
        this.aYE = aVar.EK();
        setHidden(this.aYE.hidden);
        setGesture(this.aYE.aBJ);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.aYE;
    }

    public void setHidden(boolean z) {
        (this.aYG == null ? this : this.aYG).setVisibility(z ? 8 : 0);
        if (this.aYE != null) {
            this.aYE.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.aYE != null) {
            this.aYE.aBJ = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.aYE.aBG, this.aYE.id, this.aYE.aBF) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.aYE != null && SwanAppNAViewContainer.this.aYE.aBJ && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.aYE != null ? this.aYE.aBG : "No_Id";
    }

    public String getViewId() {
        return this.aYE != null ? this.aYE.id : "No_Id";
    }

    public String getParentId() {
        return this.aYE != null ? this.aYE.aBH : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.aYE != null && this.aYE.aBI != null) {
            this.aYE.aBI.setLeft(marginLayoutParams.leftMargin);
            this.aYE.aBI.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean MJ() {
        a hN;
        boolean z = false;
        if (this.aYE != null && (hN = aa.hN(this.aYE.aBG)) != null && (z = c.a(this, hN))) {
            c.c(this, hN);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.aYF = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.aYF = view;
    }

    private void aj(View view) {
        addView(view, generateDefaultLayoutParams());
        this.aYF = view;
    }

    public ScrollView getScrollView() {
        return this.aYG;
    }

    public void setScrollView(ScrollView scrollView) {
        this.aYG = scrollView;
    }
}

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
    private com.baidu.swan.apps.model.a.a.a bce;
    private View bcf;
    private ScrollView bcg;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        ao(view);
        return Qj();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean Qi() {
        a ix;
        boolean z = false;
        if (this.bce != null && (ix = ac.ix(this.bce.aDU)) != null && (z = c.b(this, ix))) {
            c.d(this, ix);
            this.bcf = null;
        }
        return z;
    }

    public View getNAView() {
        return this.bcf;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.bce = null;
            return;
        }
        this.bce = aVar.Hs();
        setHidden(this.bce.hidden);
        setGesture(this.bce.aDX);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.bce;
    }

    public void setHidden(boolean z) {
        (this.bcg == null ? this : this.bcg).setVisibility(z ? 8 : 0);
        if (this.bce != null) {
            this.bce.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.bce != null) {
            this.bce.aDX = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.bce.aDU, this.bce.id, this.bce.aDT) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.bce != null && SwanAppNAViewContainer.this.bce.aDX && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.bce != null ? this.bce.aDU : "No_Id";
    }

    public String getViewId() {
        return this.bce != null ? this.bce.id : "No_Id";
    }

    public String getParentId() {
        return this.bce != null ? this.bce.aDV : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.bce != null && this.bce.aDW != null) {
            this.bce.aDW.cM(marginLayoutParams.leftMargin);
            this.bce.aDW.cN(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean Qj() {
        a ix;
        boolean z = false;
        if (this.bce != null && (ix = ac.ix(this.bce.aDU)) != null && (z = c.a(this, ix))) {
            c.c(this, ix);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.bcf = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.bcf = view;
    }

    private void ao(View view) {
        addView(view, generateDefaultLayoutParams());
        this.bcf = view;
    }

    public ScrollView getScrollView() {
        return this.bcg;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bcg = scrollView;
    }
}

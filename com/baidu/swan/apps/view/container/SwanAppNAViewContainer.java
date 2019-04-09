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
    private com.baidu.swan.apps.model.a.a.a aYF;
    private View aYG;
    private ScrollView aYH;

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
        if (this.aYF != null && (hN = aa.hN(this.aYF.aBH)) != null && (z = c.b(this, hN))) {
            c.d(this, hN);
            this.aYG = null;
        }
        return z;
    }

    public View getNAView() {
        return this.aYG;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.aYF = null;
            return;
        }
        this.aYF = aVar.EK();
        setHidden(this.aYF.hidden);
        setGesture(this.aYF.aBK);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.aYF;
    }

    public void setHidden(boolean z) {
        (this.aYH == null ? this : this.aYH).setVisibility(z ? 8 : 0);
        if (this.aYF != null) {
            this.aYF.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.aYF != null) {
            this.aYF.aBK = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.aYF.aBH, this.aYF.id, this.aYF.aBG) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.aYF != null && SwanAppNAViewContainer.this.aYF.aBK && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.aYF != null ? this.aYF.aBH : "No_Id";
    }

    public String getViewId() {
        return this.aYF != null ? this.aYF.id : "No_Id";
    }

    public String getParentId() {
        return this.aYF != null ? this.aYF.aBI : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.aYF != null && this.aYF.aBJ != null) {
            this.aYF.aBJ.setLeft(marginLayoutParams.leftMargin);
            this.aYF.aBJ.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean MJ() {
        a hN;
        boolean z = false;
        if (this.aYF != null && (hN = aa.hN(this.aYF.aBH)) != null && (z = c.a(this, hN))) {
            c.c(this, hN);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.aYG = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.aYG = view;
    }

    private void aj(View view) {
        addView(view, generateDefaultLayoutParams());
        this.aYG = view;
    }

    public ScrollView getScrollView() {
        return this.aYH;
    }

    public void setScrollView(ScrollView scrollView) {
        this.aYH = scrollView;
    }
}

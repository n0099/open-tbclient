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
    private com.baidu.swan.apps.model.a.a.a bbt;
    private View bbu;
    private ScrollView bbv;

    public SwanAppNAViewContainer(@NonNull Context context) {
        super(context);
    }

    public boolean a(View view, com.baidu.swan.apps.model.a.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        b(aVar);
        am(view);
        return Ps();
    }

    public boolean a(@NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        return c.a(this, aVar);
    }

    public boolean Pr() {
        a ir;
        boolean z = false;
        if (this.bbt != null && (ir = ac.ir(this.bbt.aDm)) != null && (z = c.b(this, ir))) {
            c.d(this, ir);
            this.bbu = null;
        }
        return z;
    }

    public View getNAView() {
        return this.bbu;
    }

    public void b(com.baidu.swan.apps.model.a.a.a aVar) {
        if (aVar == null) {
            this.bbt = null;
            return;
        }
        this.bbt = aVar.GI();
        setHidden(this.bbt.hidden);
        setGesture(this.bbt.aDp);
    }

    public com.baidu.swan.apps.model.a.a.a getModel() {
        return this.bbt;
    }

    public void setHidden(boolean z) {
        (this.bbv == null ? this : this.bbv).setVisibility(z ? 8 : 0);
        if (this.bbt != null) {
            this.bbt.hidden = z;
        }
    }

    public void setGesture(boolean z) {
        if (this.bbt != null) {
            this.bbt.aDp = z;
            if (z) {
                setOnTouchListener(new com.baidu.swan.apps.view.container.b.b(this.bbt.aDm, this.bbt.id, this.bbt.aDl) { // from class: com.baidu.swan.apps.view.container.SwanAppNAViewContainer.1
                    @Override // com.baidu.swan.apps.view.container.b.b, android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return SwanAppNAViewContainer.this.bbt != null && SwanAppNAViewContainer.this.bbt.aDp && super.onTouch(view, motionEvent);
                    }
                });
            }
        }
    }

    public String getSlaveId() {
        return this.bbt != null ? this.bbt.aDm : "No_Id";
    }

    public String getViewId() {
        return this.bbt != null ? this.bbt.id : "No_Id";
    }

    public String getParentId() {
        return this.bbt != null ? this.bbt.aDn : "No_Id";
    }

    public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null && this.bbt != null && this.bbt.aDo != null) {
            this.bbt.aDo.setLeft(marginLayoutParams.leftMargin);
            this.bbt.aDo.setTop(marginLayoutParams.topMargin);
            setLayoutParams(marginLayoutParams);
        }
    }

    public boolean Ps() {
        a ir;
        boolean z = false;
        if (this.bbt != null && (ir = ac.ir(this.bbt.aDm)) != null && (z = c.a(this, ir))) {
            c.c(this, ir);
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.bbu = view;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        this.bbu = view;
    }

    private void am(View view) {
        addView(view, generateDefaultLayoutParams());
        this.bbu = view;
    }

    public ScrollView getScrollView() {
        return this.bbv;
    }

    public void setScrollView(ScrollView scrollView) {
        this.bbv = scrollView;
    }
}

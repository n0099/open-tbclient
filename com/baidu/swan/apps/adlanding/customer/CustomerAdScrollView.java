package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.baidu.tieba.su1;
/* loaded from: classes3.dex */
public class CustomerAdScrollView extends ScrollView {
    public boolean a;
    public boolean b;
    public float c;
    public su1 d;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.a = false;
        this.b = false;
        this.d = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                if (y - this.c < 0.0f) {
                    if (!this.a || this.b) {
                        return false;
                    }
                } else if (!this.b) {
                    return false;
                }
            }
        } else {
            this.c = y;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.b = z;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.a = z;
    }

    public void setScrollViewListener(su1 su1Var) {
        this.d = su1Var;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        su1 su1Var = this.d;
        if (su1Var != null) {
            su1Var.onScrollChanged(i, i2, i3, i4);
        }
    }
}

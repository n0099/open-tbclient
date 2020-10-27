package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes10.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cqD;
    private boolean cqE;
    private float cqF;
    private a cqG;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cqD = false;
        this.cqE = false;
        this.cqG = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cqF = y;
                break;
            case 2:
                if (y - this.cqF < 0.0f) {
                    if (!this.cqD || this.cqE) {
                        return false;
                    }
                } else if (!this.cqE) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cqG != null) {
            this.cqG.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cqG = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cqD = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cqE = z;
    }
}

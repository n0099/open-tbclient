package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import d.a.l0.a.q.e.a;
/* loaded from: classes2.dex */
public class CustomerAdScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f10452e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10453f;

    /* renamed from: g  reason: collision with root package name */
    public float f10454g;

    /* renamed from: h  reason: collision with root package name */
    public a f10455h;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.f10452e = false;
        this.f10453f = false;
        this.f10455h = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10454g = y;
        } else if (action == 2) {
            if (y - this.f10454g < 0.0f) {
                if (!this.f10452e || this.f10453f) {
                    return false;
                }
            } else if (!this.f10453f) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f10455h;
        if (aVar != null) {
            aVar.onScrollChanged(i2, i3, i4, i5);
        }
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.f10453f = z;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.f10452e = z;
    }

    public void setScrollViewListener(a aVar) {
        this.f10455h = aVar;
    }
}

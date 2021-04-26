package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import d.a.h0.a.q.f.a;
/* loaded from: classes2.dex */
public class CustomerAdScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11419e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11420f;

    /* renamed from: g  reason: collision with root package name */
    public float f11421g;

    /* renamed from: h  reason: collision with root package name */
    public a f11422h;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.f11419e = false;
        this.f11420f = false;
        this.f11422h = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11421g = y;
        } else if (action == 2) {
            if (y - this.f11421g < 0.0f) {
                if (!this.f11419e || this.f11420f) {
                    return false;
                }
            } else if (!this.f11420f) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f11422h;
        if (aVar != null) {
            aVar.onScrollChanged(i2, i3, i4, i5);
        }
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.f11420f = z;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.f11419e = z;
    }

    public void setScrollViewListener(a aVar) {
        this.f11422h = aVar;
    }
}

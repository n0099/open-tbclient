package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import d.b.h0.a.q.f.a;
/* loaded from: classes2.dex */
public class CustomerAdScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11591e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11592f;

    /* renamed from: g  reason: collision with root package name */
    public float f11593g;

    /* renamed from: h  reason: collision with root package name */
    public a f11594h;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.f11591e = false;
        this.f11592f = false;
        this.f11594h = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11593g = y;
        } else if (action == 2) {
            if (y - this.f11593g < 0.0f) {
                if (!this.f11591e || this.f11592f) {
                    return false;
                }
            } else if (!this.f11592f) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f11594h;
        if (aVar != null) {
            aVar.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.f11592f = z;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.f11591e = z;
    }

    public void setScrollViewListener(a aVar) {
        this.f11594h = aVar;
    }
}

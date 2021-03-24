package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import d.b.g0.a.q.f.a;
/* loaded from: classes3.dex */
public class CustomerAdScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11921e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11922f;

    /* renamed from: g  reason: collision with root package name */
    public float f11923g;

    /* renamed from: h  reason: collision with root package name */
    public a f11924h;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.f11921e = false;
        this.f11922f = false;
        this.f11924h = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11923g = y;
        } else if (action == 2) {
            if (y - this.f11923g < 0.0f) {
                if (!this.f11921e || this.f11922f) {
                    return false;
                }
            } else if (!this.f11922f) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f11924h;
        if (aVar != null) {
            aVar.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.f11922f = z;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.f11921e = z;
    }

    public void setScrollViewListener(a aVar) {
        this.f11924h = aVar;
    }
}

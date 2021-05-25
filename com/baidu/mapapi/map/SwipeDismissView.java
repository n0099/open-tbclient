package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.WearMapView;
/* loaded from: classes2.dex */
public class SwipeDismissView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public WearMapView.OnDismissCallback f7004a;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i2, View view) {
        super(context, attributeSet, i2);
        this.f7004a = null;
        a(context, view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.f7004a = null;
        a(context, view);
    }

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.f7004a = null;
        a(context, view);
    }

    public void a(Context context, View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new s(this)));
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.f7004a = onDismissCallback;
    }
}

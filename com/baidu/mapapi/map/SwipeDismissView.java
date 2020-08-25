package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.WearMapView;
/* loaded from: classes20.dex */
public class SwipeDismissView extends RelativeLayout {
    WearMapView.OnDismissCallback a;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view) {
        super(context, attributeSet, i);
        this.a = null;
        a(context, view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.a = null;
        a(context, view);
    }

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.a = null;
        a(context, view);
    }

    void a(Context context, View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new x(this)));
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.a = onDismissCallback;
    }
}

package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.WearMapView;
/* loaded from: classes2.dex */
public class SwipeDismissView extends RelativeLayout {
    public WearMapView.OnDismissCallback a;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view2) {
        super(context, attributeSet, i);
        this.a = null;
        a(context, view2);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view2) {
        super(context, attributeSet);
        this.a = null;
        a(context, view2);
    }

    public SwipeDismissView(Context context, View view2) {
        super(context);
        this.a = null;
        a(context, view2);
    }

    public void a(Context context, View view2) {
        setOnTouchListener(new SwipeDismissTouchListener(view2, new Object(), new z(this)));
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.a = onDismissCallback;
    }
}

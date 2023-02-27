package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
import com.baidu.mapapi.map.WearMapView;
/* loaded from: classes2.dex */
public class z implements SwipeDismissTouchListener.DismissCallbacks {
    public final /* synthetic */ SwipeDismissView a;

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    public z(SwipeDismissView swipeDismissView) {
        this.a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view2, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.a.a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        WearMapView.OnDismissCallback onDismissCallback = this.a.a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onNotify();
    }
}

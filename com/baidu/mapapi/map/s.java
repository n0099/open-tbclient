package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
import com.baidu.mapapi.map.WearMapView;
/* loaded from: classes2.dex */
public class s implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissView f7205a;

    public s(SwipeDismissView swipeDismissView) {
        this.f7205a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.f7205a.f7104a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        WearMapView.OnDismissCallback onDismissCallback = this.f7205a.f7104a;
        if (onDismissCallback == null) {
            return;
        }
        onDismissCallback.onNotify();
    }
}

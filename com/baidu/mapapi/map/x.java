package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class x implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeDismissView f2088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SwipeDismissView swipeDismissView) {
        this.f2088a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        if (this.f2088a.f2045a == null) {
            return;
        }
        this.f2088a.f2045a.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        if (this.f2088a.f2045a == null) {
            return;
        }
        this.f2088a.f2045a.onNotify();
    }
}

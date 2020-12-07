package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class x implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeDismissView f2090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SwipeDismissView swipeDismissView) {
        this.f2090a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        if (this.f2090a.f2047a == null) {
            return;
        }
        this.f2090a.f2047a.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        if (this.f2090a.f2047a == null) {
            return;
        }
        this.f2090a.f2047a.onNotify();
    }
}

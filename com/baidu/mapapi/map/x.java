package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class x implements SwipeDismissTouchListener.DismissCallbacks {
    final /* synthetic */ SwipeDismissView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SwipeDismissView swipeDismissView) {
        this.a = swipeDismissView;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        if (this.a.a == null) {
            return;
        }
        this.a.a.onDismiss();
    }

    @Override // com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks
    public void onNotify() {
        if (this.a.a == null) {
            return;
        }
        this.a.a.onNotify();
    }
}

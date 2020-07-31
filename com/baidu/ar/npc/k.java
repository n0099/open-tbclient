package com.baidu.ar.npc;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.ar.npc.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class k extends OrientationEventListener {
    final /* synthetic */ ArBridge a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ArBridge arBridge, Context context, int i) {
        super(context, i);
        this.a = arBridge;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        int i3;
        int i4;
        this.a.i = i;
        StringBuilder append = new StringBuilder().append("orientation ");
        i2 = this.a.i;
        Log.d("orientation", append.append(i2).toString());
        i3 = this.a.i;
        if (i3 >= 0) {
            i4 = this.a.i;
            int i5 = (i4 + 360) % 360;
            if (i5 <= 45 || i5 > 315) {
                this.a.j = ArBridge.e.SCREEN_ORIENTATION_PORTRAIT;
                return;
            } else if (i5 > 45 && i5 <= 135) {
                this.a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                return;
            } else if (i5 > 135 && i5 <= 225) {
                this.a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                return;
            } else if (i5 > 225 && i5 <= 315) {
                this.a.j = ArBridge.e.SCREEN_ORIENTATION_LANDSCAPE;
                return;
            } else {
                return;
            }
        }
        this.a.j = ArBridge.e.SCREEN_ORIENTATION_NOT_DEFINED;
    }
}

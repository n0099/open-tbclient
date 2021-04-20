package com.baidu.ar.npc;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class k extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4221a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ArBridge arBridge, Context context, int i) {
        super(context, i);
        this.f4221a = arBridge;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        int i3;
        int i4;
        this.f4221a.i = i;
        StringBuilder sb = new StringBuilder();
        sb.append("orientation ");
        i2 = this.f4221a.i;
        sb.append(i2);
        Log.d("orientation", sb.toString());
        i3 = this.f4221a.i;
        if (i3 >= 0) {
            i4 = this.f4221a.i;
            int i5 = (i4 + 360) % 360;
            if (i5 <= 45 || i5 > 315) {
                this.f4221a.j = ArBridge.e.SCREEN_ORIENTATION_PORTRAIT;
                return;
            } else if (i5 > 45 && i5 <= 135) {
                this.f4221a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                return;
            } else if (i5 > 135 && i5 <= 225) {
                this.f4221a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                return;
            } else if (i5 <= 225 || i5 > 315) {
                return;
            } else {
                this.f4221a.j = ArBridge.e.SCREEN_ORIENTATION_LANDSCAPE;
                return;
            }
        }
        this.f4221a.j = ArBridge.e.SCREEN_ORIENTATION_NOT_DEFINED;
    }
}

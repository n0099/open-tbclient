package com.baidu.ar.npc;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class k extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4290a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ArBridge arBridge, Context context, int i2) {
        super(context, i2);
        this.f4290a = arBridge;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        int i3;
        int i4;
        int i5;
        this.f4290a.f4184i = i2;
        StringBuilder sb = new StringBuilder();
        sb.append("orientation ");
        i3 = this.f4290a.f4184i;
        sb.append(i3);
        Log.d("orientation", sb.toString());
        i4 = this.f4290a.f4184i;
        if (i4 >= 0) {
            i5 = this.f4290a.f4184i;
            int i6 = (i5 + 360) % 360;
            if (i6 <= 45 || i6 > 315) {
                this.f4290a.j = ArBridge.e.SCREEN_ORIENTATION_PORTRAIT;
                return;
            } else if (i6 > 45 && i6 <= 135) {
                this.f4290a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                return;
            } else if (i6 > 135 && i6 <= 225) {
                this.f4290a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                return;
            } else if (i6 <= 225 || i6 > 315) {
                return;
            } else {
                this.f4290a.j = ArBridge.e.SCREEN_ORIENTATION_LANDSCAPE;
                return;
            }
        }
        this.f4290a.j = ArBridge.e.SCREEN_ORIENTATION_NOT_DEFINED;
    }
}

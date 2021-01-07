package com.baidu.ar.npc;

import android.content.Context;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.npc.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ArBridge arBridge, Context context, int i) {
        super(context, i);
        this.f1535a = arBridge;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        int i3;
        int i4;
        this.f1535a.i = i;
        StringBuilder append = new StringBuilder().append("orientation ");
        i2 = this.f1535a.i;
        Log.d("orientation", append.append(i2).toString());
        i3 = this.f1535a.i;
        if (i3 >= 0) {
            i4 = this.f1535a.i;
            int i5 = (i4 + EncoderTextureDrawer.X264_WIDTH) % EncoderTextureDrawer.X264_WIDTH;
            if (i5 <= 45 || i5 > 315) {
                this.f1535a.j = ArBridge.e.SCREEN_ORIENTATION_PORTRAIT;
                return;
            } else if (i5 > 45 && i5 <= 135) {
                this.f1535a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                return;
            } else if (i5 > 135 && i5 <= 225) {
                this.f1535a.j = ArBridge.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                return;
            } else if (i5 > 225 && i5 <= 315) {
                this.f1535a.j = ArBridge.e.SCREEN_ORIENTATION_LANDSCAPE;
                return;
            } else {
                return;
            }
        }
        this.f1535a.j = ArBridge.e.SCREEN_ORIENTATION_NOT_DEFINED;
    }
}

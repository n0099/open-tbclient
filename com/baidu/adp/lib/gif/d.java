package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GifView f491a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        View view2;
        Bitmap bitmap;
        try {
            view = this.f491a.f;
            if (view != null) {
                view2 = this.f491a.f;
                bitmap = this.f491a.b;
                view2.setBackgroundDrawable(new BitmapDrawable(bitmap));
            } else {
                this.f491a.b();
            }
        } catch (Exception e) {
            Log.e("GifView", e.toString());
        }
    }
}

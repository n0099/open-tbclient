package com.baidu.adp.lib.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
class d extends Handler {
    final /* synthetic */ GifView a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        View view2;
        Bitmap bitmap;
        try {
            view = this.a.f;
            if (view != null) {
                view2 = this.a.f;
                bitmap = this.a.b;
                view2.setBackgroundDrawable(new BitmapDrawable(bitmap));
            } else {
                this.a.b();
            }
        } catch (Exception e) {
            Log.e("GifView", e.toString());
        }
    }
}

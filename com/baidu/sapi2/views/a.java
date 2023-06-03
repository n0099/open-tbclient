package com.baidu.sapi2.views;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.sapi2.utils.Log;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a extends SurfaceView implements SurfaceHolder.Callback {
    public static final int f = 1001;
    public SurfaceHolder a;
    public Camera b;
    public b c;
    public Handler d;
    public Camera.PreviewCallback e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0149a extends Handler {
        public HandlerC0149a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.b != null && a.this.c != null) {
                a.this.c.a(a.this.d, 1001);
                a.this.b.autoFocus(a.this.c);
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.d = new HandlerC0149a();
        this.b = camera;
        SurfaceHolder holder = getHolder();
        this.a = holder;
        holder.addCallback(this);
        this.a.setType(3);
    }

    /* loaded from: classes3.dex */
    public static class b implements Camera.AutoFocusCallback {
        public static final String c = b.class.getSimpleName();
        public static final long d = 500;
        public Handler a;
        public int b;

        public void a(Handler handler, int i) {
            this.a = handler;
            this.b = i;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.a;
            if (handler != null) {
                this.a.sendMessageDelayed(handler.obtainMessage(this.b, Boolean.valueOf(z)), 500L);
                this.a = null;
            }
        }
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e("SurfaceView-callback", "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("SurfaceView-callback", "surfaceDestroyed");
        surfaceHolder.removeCallback(this);
    }

    public void a() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.c = null;
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
        this.a.removeCallback(this);
        this.a = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.b.stopPreview();
            this.b.setDisplayOrientation(90);
            this.b.setPreviewDisplay(this.a);
            if (this.e != null) {
                this.b.setPreviewCallback(this.e);
            }
            this.b.startPreview();
            if (this.c == null) {
                this.c = new b();
            }
            this.c.a(this.d, 1001);
            this.b.autoFocus(this.c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

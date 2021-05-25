package com.baidu.sapi2.views;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.sapi2.utils.Log;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: f  reason: collision with root package name */
    public static final int f9911f = 1001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f9912a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f9913b;

    /* renamed from: c  reason: collision with root package name */
    public b f9914c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f9915d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f9916e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0128a extends Handler {
        public HandlerC0128a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f9913b == null || a.this.f9914c == null) {
                return;
            }
            a.this.f9914c.a(a.this.f9915d, 1001);
            a.this.f9913b.autoFocus(a.this.f9914c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final String f9918c = b.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public static final long f9919d = 500;

        /* renamed from: a  reason: collision with root package name */
        public Handler f9920a;

        /* renamed from: b  reason: collision with root package name */
        public int f9921b;

        public void a(Handler handler, int i2) {
            this.f9920a = handler;
            this.f9921b = i2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.f9920a;
            if (handler != null) {
                this.f9920a.sendMessageDelayed(handler.obtainMessage(this.f9921b, Boolean.valueOf(z)), 500L);
                this.f9920a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.f9915d = new HandlerC0128a();
        this.f9913b = camera;
        SurfaceHolder holder = getHolder();
        this.f9912a = holder;
        holder.addCallback(this);
        this.f9912a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.f9916e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.f9913b.stopPreview();
            this.f9913b.setDisplayOrientation(90);
            this.f9913b.setPreviewDisplay(this.f9912a);
            if (this.f9916e != null) {
                this.f9913b.setPreviewCallback(this.f9916e);
            }
            this.f9913b.startPreview();
            if (this.f9914c == null) {
                this.f9914c = new b();
            }
            this.f9914c.a(this.f9915d, 1001);
            this.f9913b.autoFocus(this.f9914c);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
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
        b bVar = this.f9914c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.f9914c = null;
        }
        Handler handler = this.f9915d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f9915d = null;
        }
        this.f9912a.removeCallback(this);
        this.f9912a = null;
    }
}

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
    public static final int f9973f = 1001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f9974a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f9975b;

    /* renamed from: c  reason: collision with root package name */
    public b f9976c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f9977d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f9978e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0128a extends Handler {
        public HandlerC0128a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f9975b == null || a.this.f9976c == null) {
                return;
            }
            a.this.f9976c.a(a.this.f9977d, 1001);
            a.this.f9975b.autoFocus(a.this.f9976c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final String f9980c = b.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public static final long f9981d = 500;

        /* renamed from: a  reason: collision with root package name */
        public Handler f9982a;

        /* renamed from: b  reason: collision with root package name */
        public int f9983b;

        public void a(Handler handler, int i2) {
            this.f9982a = handler;
            this.f9983b = i2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.f9982a;
            if (handler != null) {
                this.f9982a.sendMessageDelayed(handler.obtainMessage(this.f9983b, Boolean.valueOf(z)), 500L);
                this.f9982a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.f9977d = new HandlerC0128a();
        this.f9975b = camera;
        SurfaceHolder holder = getHolder();
        this.f9974a = holder;
        holder.addCallback(this);
        this.f9974a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.f9978e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.f9975b.stopPreview();
            this.f9975b.setDisplayOrientation(90);
            this.f9975b.setPreviewDisplay(this.f9974a);
            if (this.f9978e != null) {
                this.f9975b.setPreviewCallback(this.f9978e);
            }
            this.f9975b.startPreview();
            if (this.f9976c == null) {
                this.f9976c = new b();
            }
            this.f9976c.a(this.f9977d, 1001);
            this.f9975b.autoFocus(this.f9976c);
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
        b bVar = this.f9976c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.f9976c = null;
        }
        Handler handler = this.f9977d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f9977d = null;
        }
        this.f9974a.removeCallback(this);
        this.f9974a = null;
    }
}

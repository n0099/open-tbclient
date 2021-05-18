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
    public static final int f10011f = 1001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f10012a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f10013b;

    /* renamed from: c  reason: collision with root package name */
    public b f10014c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f10015d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f10016e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0127a extends Handler {
        public HandlerC0127a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f10013b == null || a.this.f10014c == null) {
                return;
            }
            a.this.f10014c.a(a.this.f10015d, 1001);
            a.this.f10013b.autoFocus(a.this.f10014c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final String f10018c = b.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public static final long f10019d = 500;

        /* renamed from: a  reason: collision with root package name */
        public Handler f10020a;

        /* renamed from: b  reason: collision with root package name */
        public int f10021b;

        public void a(Handler handler, int i2) {
            this.f10020a = handler;
            this.f10021b = i2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.f10020a;
            if (handler != null) {
                this.f10020a.sendMessageDelayed(handler.obtainMessage(this.f10021b, Boolean.valueOf(z)), 500L);
                this.f10020a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.f10015d = new HandlerC0127a();
        this.f10013b = camera;
        SurfaceHolder holder = getHolder();
        this.f10012a = holder;
        holder.addCallback(this);
        this.f10012a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.f10016e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.f10013b.stopPreview();
            this.f10013b.setDisplayOrientation(90);
            this.f10013b.setPreviewDisplay(this.f10012a);
            if (this.f10016e != null) {
                this.f10013b.setPreviewCallback(this.f10016e);
            }
            this.f10013b.startPreview();
            if (this.f10014c == null) {
                this.f10014c = new b();
            }
            this.f10014c.a(this.f10015d, 1001);
            this.f10013b.autoFocus(this.f10014c);
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
        b bVar = this.f10014c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.f10014c = null;
        }
        Handler handler = this.f10015d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10015d = null;
        }
        this.f10012a.removeCallback(this);
        this.f10012a = null;
    }
}

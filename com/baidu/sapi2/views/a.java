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
    public static final int f9994f = 1001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f9995a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f9996b;

    /* renamed from: c  reason: collision with root package name */
    public b f9997c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f9998d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f9999e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0129a extends Handler {
        public HandlerC0129a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f9996b == null || a.this.f9997c == null) {
                return;
            }
            a.this.f9997c.a(a.this.f9998d, 1001);
            a.this.f9996b.autoFocus(a.this.f9997c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final String f10001c = b.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public static final long f10002d = 500;

        /* renamed from: a  reason: collision with root package name */
        public Handler f10003a;

        /* renamed from: b  reason: collision with root package name */
        public int f10004b;

        public void a(Handler handler, int i2) {
            this.f10003a = handler;
            this.f10004b = i2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.f10003a;
            if (handler != null) {
                this.f10003a.sendMessageDelayed(handler.obtainMessage(this.f10004b, Boolean.valueOf(z)), 500L);
                this.f10003a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.f9998d = new HandlerC0129a();
        this.f9996b = camera;
        SurfaceHolder holder = getHolder();
        this.f9995a = holder;
        holder.addCallback(this);
        this.f9995a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.f9999e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.f9996b.stopPreview();
            this.f9996b.setDisplayOrientation(90);
            this.f9996b.setPreviewDisplay(this.f9995a);
            if (this.f9999e != null) {
                this.f9996b.setPreviewCallback(this.f9999e);
            }
            this.f9996b.startPreview();
            if (this.f9997c == null) {
                this.f9997c = new b();
            }
            this.f9997c.a(this.f9998d, 1001);
            this.f9996b.autoFocus(this.f9997c);
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
        b bVar = this.f9997c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.f9997c = null;
        }
        Handler handler = this.f9998d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f9998d = null;
        }
        this.f9995a.removeCallback(this);
        this.f9995a = null;
    }
}

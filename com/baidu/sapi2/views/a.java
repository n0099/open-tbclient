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
    public static final int f10974f = 1001;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f10975a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f10976b;

    /* renamed from: c  reason: collision with root package name */
    public b f10977c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f10978d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f10979e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0142a extends Handler {
        public HandlerC0142a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.this.f10976b == null || a.this.f10977c == null) {
                return;
            }
            a.this.f10977c.a(a.this.f10978d, 1001);
            a.this.f10976b.autoFocus(a.this.f10977c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {

        /* renamed from: c  reason: collision with root package name */
        public static final String f10981c = b.class.getSimpleName();

        /* renamed from: d  reason: collision with root package name */
        public static final long f10982d = 500;

        /* renamed from: a  reason: collision with root package name */
        public Handler f10983a;

        /* renamed from: b  reason: collision with root package name */
        public int f10984b;

        public void a(Handler handler, int i2) {
            this.f10983a = handler;
            this.f10984b = i2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler = this.f10983a;
            if (handler != null) {
                this.f10983a.sendMessageDelayed(handler.obtainMessage(this.f10984b, Boolean.valueOf(z)), 500L);
                this.f10983a = null;
            }
        }
    }

    public a(Context context, Camera camera) {
        super(context);
        this.f10978d = new HandlerC0142a();
        this.f10976b = camera;
        SurfaceHolder holder = getHolder();
        this.f10975a = holder;
        holder.addCallback(this);
        this.f10975a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.f10979e = previewCallback;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.e("SurfaceView-callback", "surfaceChanged");
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        try {
            this.f10976b.stopPreview();
            this.f10976b.setDisplayOrientation(90);
            this.f10976b.setPreviewDisplay(this.f10975a);
            if (this.f10979e != null) {
                this.f10976b.setPreviewCallback(this.f10979e);
            }
            this.f10976b.startPreview();
            if (this.f10977c == null) {
                this.f10977c = new b();
            }
            this.f10977c.a(this.f10978d, 1001);
            this.f10976b.autoFocus(this.f10977c);
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
        b bVar = this.f10977c;
        if (bVar != null) {
            bVar.a(null, 0);
            this.f10977c = null;
        }
        Handler handler = this.f10978d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10978d = null;
        }
        this.f10975a.removeCallback(this);
        this.f10975a = null;
    }
}

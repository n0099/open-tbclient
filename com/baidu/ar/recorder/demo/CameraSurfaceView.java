package com.baidu.ar.recorder.demo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.baidu.ar.recorder.demo.a;
import com.baidu.ar.recorder.encoder.EncoderParams;
/* loaded from: classes3.dex */
public class CameraSurfaceView extends GLSurfaceView implements a.InterfaceC0034a {
    private static final String a = CameraSurfaceView.class.getSimpleName();
    private a b;
    private volatile boolean c;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        a(context);
    }

    private void a(Context context) {
        setEGLContextClientVersion(2);
        this.b = new a(context.getApplicationContext());
        setRenderer(this.b);
        setRenderMode(0);
    }

    @Override // com.baidu.ar.recorder.demo.a.InterfaceC0034a
    public void a() {
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        queueEvent(new Runnable() { // from class: com.baidu.ar.recorder.demo.CameraSurfaceView.2
            @Override // java.lang.Runnable
            public void run() {
                CameraSurfaceView.this.b.a();
            }
        });
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
    }

    public void setRecordDegree(final int i) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.recorder.demo.CameraSurfaceView.3
            @Override // java.lang.Runnable
            public void run() {
                CameraSurfaceView.this.b.a(i);
            }
        });
    }

    public void setupRecorder(final EncoderParams encoderParams) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.recorder.demo.CameraSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                CameraSurfaceView.this.b.a(encoderParams);
            }
        });
    }
}

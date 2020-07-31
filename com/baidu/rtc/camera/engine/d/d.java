package com.baidu.rtc.camera.engine.d;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d extends Handler {
    private WeakReference<f> mWeakRenderThread;

    public d(f fVar) {
        super(fVar.getLooper());
        this.mWeakRenderThread = new WeakReference<>(fVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.mWeakRenderThread != null && this.mWeakRenderThread.get() != null) {
            f fVar = this.mWeakRenderThread.get();
            switch (message.what) {
                case 1:
                    if (message.obj instanceof SurfaceHolder) {
                        fVar.b(((SurfaceHolder) message.obj).getSurface());
                        return;
                    } else if (message.obj instanceof Surface) {
                        fVar.b((Surface) message.obj);
                        return;
                    } else if (message.obj instanceof SurfaceTexture) {
                        fVar.surfaceCreated((SurfaceTexture) message.obj);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    fVar.surfaceChanged(message.arg1, message.arg2);
                    return;
                case 3:
                    fVar.surfaceDestroyed();
                    return;
                case 4:
                    fVar.Ra();
                    return;
                case 5:
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 18:
                default:
                    throw new IllegalStateException("Can not handle message what is: " + message.what);
                case 6:
                    fVar.startRecording();
                    return;
                case 8:
                    fVar.stopRecording();
                    return;
                case 9:
                    fVar.Rd();
                    fVar.startPreview();
                    return;
                case 16:
                    fVar.switchCamera();
                    return;
                case 17:
                    fVar.E((byte[]) message.obj);
                    return;
                case 19:
                    fVar.Rb();
                    return;
            }
        }
    }
}

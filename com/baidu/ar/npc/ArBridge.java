package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class ArBridge {

    /* renamed from: a  reason: collision with root package name */
    public static ArBridge f4077a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<BaiduArView> f4078b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f4079c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f4080d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f4081e;

    /* renamed from: g  reason: collision with root package name */
    public f f4083g;

    /* renamed from: h  reason: collision with root package name */
    public OrientationEventListener f4084h;

    /* renamed from: f  reason: collision with root package name */
    public long f4082f = -1;
    public int i = -1;
    public e j = e.SCREEN_ORIENTATION_NOT_DEFINED;
    public int k = 0;
    public boolean l = false;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4085a;

        /* renamed from: b  reason: collision with root package name */
        public int f4086b;

        /* renamed from: c  reason: collision with root package name */
        public d f4087c;

        public a(int i, int i2, d dVar) {
            this.f4085a = i;
            this.f4086b = i2;
            this.f4087c = dVar;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4088a;

        /* renamed from: b  reason: collision with root package name */
        public int f4089b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, Object> f4090c;

        /* renamed from: d  reason: collision with root package name */
        public int f4091d;

        public b(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.f4088a = i;
            this.f4089b = i2;
            this.f4090c = hashMap;
            this.f4091d = i3;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes2.dex */
    public enum e {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(String str, int i, String str2);
    }

    public ArBridge() {
        HandlerThread handlerThread = new HandlerThread("msg_callback_thread");
        this.f4079c = handlerThread;
        handlerThread.start();
        this.f4080d = new Handler(this.f4079c.getLooper(), new com.baidu.ar.npc.a(this));
        this.f4081e = new LinkedList();
    }

    public static synchronized ArBridge getInstance() {
        ArBridge arBridge;
        synchronized (ArBridge.class) {
            if (f4077a == null) {
                f4077a = new ArBridge();
            }
            arBridge = f4077a;
        }
        return arBridge;
    }

    public static native boolean libraryHasLoaded();

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(b bVar) {
        for (a aVar : this.f4081e) {
            int i = aVar.f4085a;
            if (i == 0 || bVar.f4088a == i) {
                int i2 = aVar.f4086b;
                if (-1 == i2 || bVar.f4091d == i2) {
                    aVar.f4087c.a(bVar.f4088a, bVar.f4089b, bVar.f4090c);
                }
            }
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.f4080d.obtainMessage(1, new b(i, i2, hashMap, i3)).sendToTarget();
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    public void clearScreen() {
        executeOnGLThread(new g(this));
    }

    public int createCase(String str, HashMap<String, Object> hashMap, int i, int i2) {
        WeakReference<BaiduArView> weakReference = this.f4078b;
        if (weakReference != null && weakReference.get() != null) {
            this.f4078b.get().mNeedDestroy = false;
        }
        int caseId = getCaseId();
        executeOnGLThread(new t(this, str, caseId, hashMap, i, i2));
        return caseId;
    }

    public void destroyCase() {
        WeakReference<BaiduArView> weakReference = this.f4078b;
        if (weakReference != null && weakReference.get() != null && this.f4078b.get().mUpdating) {
            this.f4078b.get().mNeedDestroy = true;
        } else {
            nativeDestroyCase();
        }
    }

    public void executeOnGLThread(Runnable runnable) {
        WeakReference<BaiduArView> weakReference = this.f4078b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.f4082f == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            this.f4078b.get().queueEvent(runnable);
        }
    }

    public native int getCaseId();

    public int getFps() {
        executeOnGLThread(new i(this));
        return this.k;
    }

    public native int getMessageID();

    public native void nativeClearScreen();

    public native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    public native void nativeDestroyCase();

    public native int nativeGetFps();

    public native void nativeOnPause();

    public native void nativeOnPauseByUser();

    public native void nativeOnResume();

    public native void nativeOnResumeByUser();

    public native void nativeReset();

    public native void nativeSetCameraDefaultPos();

    public native void nativeSetEuler(float f2, float f3, float f4, String str);

    public native void nativeSetFrustum(float f2, float f3);

    public native void nativeSetSize(int i, int i2);

    public native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    public native void nativeUpdate();

    public native void nativeUpdateRMatrix(float[] fArr);

    public native void nativeUpdateRTMatrix(float[] fArr);

    public native void nativeUpdateSLAMMatrix(float[] fArr);

    public void onPauseByUser() {
        this.l = false;
        executeOnGLThread(new com.baidu.ar.npc.f(this));
    }

    public void onResumeByUser() {
        WeakReference<BaiduArView> weakReference = this.f4078b;
        if (weakReference == null || weakReference.get() == null) {
            this.l = true;
        }
        executeOnGLThread(new com.baidu.ar.npc.e(this));
    }

    public native void onTouchEventNative(int i, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, long j, int i4);

    public synchronized void registerMessageHandler(int i, d dVar) {
        this.f4080d.post(new r(this, i, dVar));
    }

    public synchronized void removeMessageHandeler(d dVar) {
        this.f4080d.post(new s(this, dVar));
    }

    public void reset() {
        executeOnGLThread(new h(this));
    }

    public void sendLuaScriptToEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("script", str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setArView(BaiduArView baiduArView) {
        this.f4078b = new WeakReference<>(baiduArView);
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public void setEuler(float f2, float f3, float f4, String str) {
        executeOnGLThread(new com.baidu.ar.npc.b(this, f2, f3, f4, str));
    }

    public void setFrustum(float f2, float f3) {
        executeOnGLThread(new com.baidu.ar.npc.c(this, f2, f3));
    }

    public native void setGLJniEnv();

    public void setGLThreadID(long j) {
        this.f4082f = j;
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("model_color", Integer.valueOf(i));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setSize(int i, int i2) {
        executeOnGLThread(new v(this, i, i2));
    }

    public void setTargetInfo(HashMap<String, Object> hashMap) {
        executeOnGLThread(new u(this, hashMap));
    }

    public synchronized void setVideoUpdateCallback(f fVar) {
        this.f4083g = fVar;
    }

    public void surfaceViewCapture(c cVar) {
        BaiduArView baiduArView = this.f4078b.get();
        if (baiduArView != null) {
            baiduArView.takeSnapshot(new l(this, cVar));
        } else {
            this.f4080d.post(new p(this, cVar));
        }
    }

    public void switchCase(String str, HashMap<String, Object> hashMap, int i, int i2) {
        executeOnGLThread(new com.baidu.ar.npc.d(this, str, hashMap, i, i2));
    }

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateVideoFrame(String str, int i, String str2) {
        f fVar = this.f4083g;
        if (fVar != null) {
            fVar.a(str, i, str2);
        }
    }

    private void sendMessageImpl(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        WeakReference<BaiduArView> weakReference = this.f4078b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f4078b.get().queueEvent(new q(this, i2, i, hashMap, i3));
    }

    public void c() {
        nativeUpdate();
    }

    public void b() {
        if (this.f4084h == null && this.f4078b.get() != null) {
            this.f4084h = new k(this, this.f4078b.get().getContext(), 3);
        }
        OrientationEventListener orientationEventListener = this.f4084h;
        if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
            this.f4084h.enable();
        }
        executeOnGLThread(new n(this));
        if (this.l) {
            onResumeByUser();
            this.l = false;
        }
    }

    public void a() {
        OrientationEventListener orientationEventListener = this.f4084h;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        executeOnGLThread(new j(this));
    }

    public void a(int i, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, long j) {
        executeOnGLThread(new o(this, i, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, j));
    }
}

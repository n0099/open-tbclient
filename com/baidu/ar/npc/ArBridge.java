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
/* loaded from: classes.dex */
public class ArBridge {

    /* renamed from: a  reason: collision with root package name */
    public static ArBridge f4176a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<BaiduArView> f4177b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f4178c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f4179d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f4180e;

    /* renamed from: g  reason: collision with root package name */
    public f f4182g;

    /* renamed from: h  reason: collision with root package name */
    public OrientationEventListener f4183h;

    /* renamed from: f  reason: collision with root package name */
    public long f4181f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f4184i = -1;
    public e j = e.SCREEN_ORIENTATION_NOT_DEFINED;
    public int k = 0;
    public boolean l = false;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4185a;

        /* renamed from: b  reason: collision with root package name */
        public int f4186b;

        /* renamed from: c  reason: collision with root package name */
        public d f4187c;

        public a(int i2, int i3, d dVar) {
            this.f4185a = i2;
            this.f4186b = i3;
            this.f4187c = dVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4188a;

        /* renamed from: b  reason: collision with root package name */
        public int f4189b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, Object> f4190c;

        /* renamed from: d  reason: collision with root package name */
        public int f4191d;

        public b(int i2, int i3, HashMap<String, Object> hashMap, int i4) {
            this.f4188a = i2;
            this.f4189b = i3;
            this.f4190c = hashMap;
            this.f4191d = i4;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i2, int i3, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes.dex */
    public enum e {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str, int i2, String str2);
    }

    public ArBridge() {
        HandlerThread handlerThread = new HandlerThread("msg_callback_thread");
        this.f4178c = handlerThread;
        handlerThread.start();
        this.f4179d = new Handler(this.f4178c.getLooper(), new com.baidu.ar.npc.a(this));
        this.f4180e = new LinkedList();
    }

    public static synchronized ArBridge getInstance() {
        ArBridge arBridge;
        synchronized (ArBridge.class) {
            if (f4176a == null) {
                f4176a = new ArBridge();
            }
            arBridge = f4176a;
        }
        return arBridge;
    }

    public static native boolean libraryHasLoaded();

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(b bVar) {
        for (a aVar : this.f4180e) {
            int i2 = aVar.f4185a;
            if (i2 == 0 || bVar.f4188a == i2) {
                int i3 = aVar.f4186b;
                if (-1 == i3 || bVar.f4191d == i3) {
                    aVar.f4187c.a(bVar.f4188a, bVar.f4189b, bVar.f4190c);
                }
            }
        }
    }

    private void receiveMsgFromEngine(int i2, int i3, HashMap<String, Object> hashMap, int i4) {
        this.f4179d.obtainMessage(1, new b(i2, i3, hashMap, i4)).sendToTarget();
    }

    private void sendMessageImpl(int i2, HashMap<String, Object> hashMap, int i3) {
        sendMessageImpl(i2, -1, hashMap, i3);
    }

    public void clearScreen() {
        executeOnGLThread(new g(this));
    }

    public int createCase(String str, HashMap<String, Object> hashMap, int i2, int i3) {
        WeakReference<BaiduArView> weakReference = this.f4177b;
        if (weakReference != null && weakReference.get() != null) {
            this.f4177b.get().mNeedDestroy = false;
        }
        int caseId = getCaseId();
        executeOnGLThread(new t(this, str, caseId, hashMap, i2, i3));
        return caseId;
    }

    public void destroyCase() {
        WeakReference<BaiduArView> weakReference = this.f4177b;
        if (weakReference != null && weakReference.get() != null && this.f4177b.get().mUpdating) {
            this.f4177b.get().mNeedDestroy = true;
        } else {
            nativeDestroyCase();
        }
    }

    public void executeOnGLThread(Runnable runnable) {
        WeakReference<BaiduArView> weakReference = this.f4177b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.f4181f == Thread.currentThread().getId()) {
            runnable.run();
        } else {
            this.f4177b.get().queueEvent(runnable);
        }
    }

    public native int getCaseId();

    public int getFps() {
        executeOnGLThread(new i(this));
        return this.k;
    }

    public native int getMessageID();

    public native void nativeClearScreen();

    public native void nativeCreateCase(String str, int i2, HashMap<String, Object> hashMap, int i3, int i4);

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

    public native void nativeSetSize(int i2, int i3);

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
        WeakReference<BaiduArView> weakReference = this.f4177b;
        if (weakReference == null || weakReference.get() == null) {
            this.l = true;
        }
        executeOnGLThread(new com.baidu.ar.npc.e(this));
    }

    public native void onTouchEventNative(int i2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, long j, int i5);

    public synchronized void registerMessageHandler(int i2, d dVar) {
        this.f4179d.post(new r(this, i2, dVar));
    }

    public synchronized void removeMessageHandeler(d dVar) {
        this.f4179d.post(new s(this, dVar));
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

    public void sendMessage(int i2, HashMap<String, Object> hashMap) {
        sendMessageImpl(i2, hashMap, -1);
    }

    public native void sendMessageToEngine(int i2, int i3, HashMap<String, Object> hashMap, int i4);

    public void sendResponseMessage(int i2, HashMap<String, Object> hashMap, int i3) {
        sendMessageImpl(i2, hashMap, i3);
    }

    public void setArView(BaiduArView baiduArView) {
        this.f4177b = new WeakReference<>(baiduArView);
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
        this.f4181f = j;
    }

    public void setModelVirtualColor(int i2, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("model_color", Integer.valueOf(i2));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setSize(int i2, int i3) {
        executeOnGLThread(new v(this, i2, i3));
    }

    public void setTargetInfo(HashMap<String, Object> hashMap) {
        executeOnGLThread(new u(this, hashMap));
    }

    public synchronized void setVideoUpdateCallback(f fVar) {
        this.f4182g = fVar;
    }

    public void surfaceViewCapture(c cVar) {
        BaiduArView baiduArView = this.f4177b.get();
        if (baiduArView != null) {
            baiduArView.takeSnapshot(new l(this, cVar));
        } else {
            this.f4179d.post(new p(this, cVar));
        }
    }

    public void switchCase(String str, HashMap<String, Object> hashMap, int i2, int i3) {
        executeOnGLThread(new com.baidu.ar.npc.d(this, str, hashMap, i2, i3));
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

    public void updateVideoFrame(String str, int i2, String str2) {
        f fVar = this.f4182g;
        if (fVar != null) {
            fVar.a(str, i2, str2);
        }
    }

    private void sendMessageImpl(int i2, int i3, HashMap<String, Object> hashMap, int i4) {
        WeakReference<BaiduArView> weakReference = this.f4177b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f4177b.get().queueEvent(new q(this, i3, i2, hashMap, i4));
    }

    public void c() {
        nativeUpdate();
    }

    public void b() {
        if (this.f4183h == null && this.f4177b.get() != null) {
            this.f4183h = new k(this, this.f4177b.get().getContext(), 3);
        }
        OrientationEventListener orientationEventListener = this.f4183h;
        if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
            this.f4183h.enable();
        }
        executeOnGLThread(new n(this));
        if (this.l) {
            onResumeByUser();
            this.l = false;
        }
    }

    public void a() {
        OrientationEventListener orientationEventListener = this.f4183h;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        executeOnGLThread(new j(this));
    }

    public void a(int i2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, long j) {
        executeOnGLThread(new o(this, i2, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, j));
    }
}

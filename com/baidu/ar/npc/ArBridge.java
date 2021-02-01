package com.baidu.ar.npc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ArBridge {

    /* renamed from: a  reason: collision with root package name */
    private static ArBridge f1492a = null;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<BaiduArView> f1493b;
    private Handler d;
    private List<a> e;
    private f g;
    private OrientationEventListener h;
    private long f = -1;
    private int i = -1;
    private e j = e.SCREEN_ORIENTATION_NOT_DEFINED;
    private int k = 0;
    private boolean l = false;
    private HandlerThread c = new HandlerThread("msg_callback_thread");

    /* loaded from: classes4.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes4.dex */
    public enum e {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(String str, int i, String str2);
    }

    public static native boolean libraryHasLoaded();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getCaseId();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int getMessageID();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeClearScreen();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeDestroyCase();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeGetFps();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeOnPause();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeOnPauseByUser();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeOnResume();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeOnResumeByUser();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeReset();

    native void nativeSetCameraDefaultPos();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeSetEuler(float f2, float f3, float f4, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeSetFrustum(float f2, float f3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeSetSize(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    native void nativeUpdate();

    native void nativeUpdateRMatrix(float[] fArr);

    native void nativeUpdateRTMatrix(float[] fArr);

    native void nativeUpdateSLAMMatrix(float[] fArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void onTouchEventNative(int i, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, long j, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void setGLJniEnv();

    private ArBridge() {
        this.c.start();
        this.d = new Handler(this.c.getLooper(), new com.baidu.ar.npc.a(this));
        this.e = new LinkedList();
    }

    public static synchronized ArBridge getInstance() {
        ArBridge arBridge;
        synchronized (ArBridge.class) {
            if (f1492a == null) {
                f1492a = new ArBridge();
            }
            arBridge = f1492a;
        }
        return arBridge;
    }

    public void setArView(BaiduArView baiduArView) {
        this.f1493b = new WeakReference<>(baiduArView);
    }

    public void surfaceViewCapture(c cVar) {
        BaiduArView baiduArView = this.f1493b.get();
        if (baiduArView != null) {
            baiduArView.takeSnapshot(new l(this, cVar));
        } else {
            this.d.post(new p(this, cVar));
        }
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    private void sendMessageImpl(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        if (this.f1493b != null && this.f1493b.get() != null) {
            this.f1493b.get().queueEvent(new q(this, i2, i, hashMap, i3));
        }
    }

    public void sendLuaScriptToEngine(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, str);
            sendMessage(2001, hashMap);
        }
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_COLOR_KEY, Integer.valueOf(i));
        if (!z) {
            hashMap.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, 1);
        }
        sendMessage(2002, hashMap);
    }

    public synchronized void registerMessageHandler(int i, d dVar) {
        this.d.post(new r(this, i, dVar));
    }

    public synchronized void removeMessageHandeler(d dVar) {
        this.d.post(new s(this, dVar));
    }

    public synchronized void setVideoUpdateCallback(f fVar) {
        this.g = fVar;
    }

    public void updateVideoFrame(String str, int i, String str2) {
        if (this.g != null) {
            this.g.a(str, i, str2);
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.d.obtainMessage(1, new b(i, i2, hashMap, i3)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(b bVar) {
        for (a aVar : this.e) {
            if (aVar.f1494a == 0 || bVar.f1496a == aVar.f1494a) {
                if (-1 == aVar.f1495b || bVar.d == aVar.f1495b) {
                    aVar.c.a(bVar.f1496a, bVar.f1497b, bVar.c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1496a;

        /* renamed from: b  reason: collision with root package name */
        public int f1497b;
        public HashMap<String, Object> c;
        public int d;

        public b(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.f1496a = i;
            this.f1497b = i2;
            this.c = hashMap;
            this.d = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1494a;

        /* renamed from: b  reason: collision with root package name */
        public int f1495b;
        public d c;

        public a(int i, int i2, d dVar) {
            this.f1494a = i;
            this.f1495b = i2;
            this.c = dVar;
        }
    }

    public void setGLThreadID(long j) {
        this.f = j;
    }

    public void executeOnGLThread(Runnable runnable) {
        if (this.f1493b != null && this.f1493b.get() != null) {
            if (this.f == Thread.currentThread().getId()) {
                runnable.run();
            } else {
                this.f1493b.get().queueEvent(runnable);
            }
        }
    }

    public int createCase(String str, HashMap<String, Object> hashMap, int i, int i2) {
        if (this.f1493b != null && this.f1493b.get() != null) {
            this.f1493b.get().mNeedDestroy = false;
        }
        int caseId = getCaseId();
        executeOnGLThread(new t(this, str, caseId, hashMap, i, i2));
        return caseId;
    }

    public void setTargetInfo(HashMap<String, Object> hashMap) {
        executeOnGLThread(new u(this, hashMap));
    }

    public void setSize(int i, int i2) {
        executeOnGLThread(new v(this, i, i2));
    }

    public void setEuler(float f2, float f3, float f4, String str) {
        executeOnGLThread(new com.baidu.ar.npc.b(this, f2, f3, f4, str));
    }

    public void setFrustum(float f2, float f3) {
        executeOnGLThread(new com.baidu.ar.npc.c(this, f2, f3));
    }

    public void switchCase(String str, HashMap<String, Object> hashMap, int i, int i2) {
        executeOnGLThread(new com.baidu.ar.npc.d(this, str, hashMap, i, i2));
    }

    public void destroyCase() {
        if (this.f1493b != null && this.f1493b.get() != null && this.f1493b.get().mUpdating) {
            this.f1493b.get().mNeedDestroy = true;
        } else {
            nativeDestroyCase();
        }
    }

    public void onResumeByUser() {
        if (this.f1493b == null || this.f1493b.get() == null) {
            this.l = true;
        }
        executeOnGLThread(new com.baidu.ar.npc.e(this));
    }

    public void onPauseByUser() {
        this.l = false;
        executeOnGLThread(new com.baidu.ar.npc.f(this));
    }

    public void clearScreen() {
        executeOnGLThread(new g(this));
    }

    public void reset() {
        executeOnGLThread(new h(this));
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public int getFps() {
        executeOnGLThread(new i(this));
        return this.k;
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.h != null) {
            this.h.disable();
        }
        executeOnGLThread(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.h == null && this.f1493b.get() != null) {
            this.h = new k(this, this.f1493b.get().getContext(), 3);
        }
        if (this.h != null && this.h.canDetectOrientation()) {
            this.h.enable();
        }
        executeOnGLThread(new n(this));
        if (this.l) {
            onResumeByUser();
            this.l = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        nativeUpdate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, long j) {
        executeOnGLThread(new o(this, i, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, j));
    }
}

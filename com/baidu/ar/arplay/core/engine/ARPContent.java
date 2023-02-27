package com.baidu.ar.arplay.core.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ARPContent {
    public c mCaseState = c.EUninit;
    public volatile boolean mIsEngineCreated = false;
    public volatile boolean mIsTempleteCreating = false;
    public volatile boolean mIsTempleteCreated = false;
    public volatile boolean mIsTempleteDestoring = true;
    public volatile boolean mIsTempleteDestoryed = false;
    public long mStartTime = 0;
    public boolean mIsFrontCamera = true;
    public int mPreviewWidth = 0;
    public int mPreviewHeight = 0;
    public int mWindowWidth = 720;
    public int mWindowHeight = 1280;
    public List<a> mCaseLoadListenerList = new ArrayList();

    /* renamed from: com.baidu.ar.arplay.core.engine.ARPContent$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] eh;

        static {
            int[] iArr = new int[b.values().length];
            eh = iArr;
            try {
                iArr[b.LoadCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eh[b.UnloadCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eh[b.OnCaseLoaded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eh[b.OnCaseUnloaded.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void onCaseLoaded(boolean z);
    }

    /* loaded from: classes.dex */
    public enum b {
        LoadCase,
        UnloadCase,
        OnCaseLoaded,
        OnCaseUnloaded
    }

    /* loaded from: classes.dex */
    public enum c {
        EUninit,
        ECreating,
        ECreated,
        EDestroying
    }

    private void releaseComponents() {
        com.baidu.ar.arplay.a.a.aA().aB();
        com.baidu.ar.arplay.a.e.aL().release();
        com.baidu.ar.arplay.d.b.bm().release();
        ARPScriptEnvironment.getInstance().release();
    }

    public boolean checkValid(b bVar) {
        c cVar;
        int i = AnonymousClass1.eh[bVar.ordinal()];
        if (i != 2) {
            if (i == 3 && (!this.mIsEngineCreated || this.mCaseState != c.ECreating)) {
                return false;
            }
        } else if (!this.mIsEngineCreated || (cVar = this.mCaseState) == c.EDestroying || cVar == c.EUninit) {
            return false;
        }
        return true;
    }

    public void clearAllCaseLoadListener() {
        this.mCaseLoadListenerList.clear();
    }

    public void destroy() {
        this.mCaseState = c.EUninit;
        notifyCaseLoadListener();
        clearAllCaseLoadListener();
        this.mIsEngineCreated = false;
        this.mIsTempleteCreating = false;
        this.mIsTempleteCreated = false;
        this.mIsTempleteDestoring = false;
        this.mIsTempleteDestoryed = false;
        releaseComponents();
    }

    public float[] getWindowSize() {
        return new float[]{this.mWindowWidth, this.mWindowHeight};
    }

    public boolean isCaseCreated() {
        return this.mCaseState == c.ECreated;
    }

    public boolean isEngineCanAccess() {
        return this.mIsEngineCreated && this.mCaseState == c.ECreated;
    }

    public int loadCaseWithResPath(String str, int i, int i2) {
        int i3;
        if (this.mIsEngineCreated) {
            c cVar = this.mCaseState;
            c cVar2 = c.ECreating;
            if (cVar == cVar2) {
                return -1;
            }
            this.mCaseState = cVar2;
            notifyCaseLoadListener();
            ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
            this.mStartTime = System.currentTimeMillis();
            int i4 = this.mPreviewWidth;
            if (i4 > 0) {
                i = i4;
            }
            this.mPreviewWidth = i;
            int i5 = this.mPreviewHeight;
            if (i5 > 0) {
                i2 = i5;
            }
            this.mPreviewHeight = i2;
            int i6 = this.mWindowWidth;
            if (i6 > 0 && (i3 = this.mWindowHeight) > 0) {
                nativeSetWindowSize(i6, i3);
            }
            nativeLoadCase(str, this.mPreviewWidth, this.mPreviewHeight);
            return 0;
        }
        return -1;
    }

    public void loadTempleteWithResPath(String str, int i, int i2) {
        if (this.mIsTempleteCreating) {
            return;
        }
        if (!this.mIsTempleteDestoring) {
            unloadTemplete();
        }
        this.mIsTempleteCreating = true;
        this.mIsTempleteDestoring = false;
        this.mIsTempleteDestoryed = false;
        this.mIsTempleteCreated = false;
        ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
        this.mStartTime = System.currentTimeMillis();
        nativeLoadTemplete(str, i, i2);
    }

    public native void nativeLoadCase(String str, int i, int i2);

    public native void nativeLoadTemplete(String str, int i, int i2);

    public native void nativeSetPreviewSize(int i, int i2);

    public native void nativeSetWindowSize(int i, int i2);

    public native void nativeUnloadCase();

    public native void nativeUnloadTemplete();

    public void notifyCaseLoadListener() {
        for (int i = 0; i < this.mCaseLoadListenerList.size(); i++) {
            this.mCaseLoadListenerList.get(i).onCaseLoaded(isCaseCreated());
        }
    }

    public void onCaseLoadCompleted(Map map) {
        if (this.mIsEngineCreated && this.mCaseState == c.ECreating && map != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2);
            com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
            this.mCaseState = c.ECreated;
            notifyCaseLoadListener();
        }
    }

    public void onCaseUnloadCompleted() {
        if (this.mIsEngineCreated && this.mCaseState == c.EDestroying) {
            this.mCaseState = c.EUninit;
        }
    }

    public void onTempleLoadCompleted(Map map) {
        if (map == null) {
            return;
        }
        int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "caseId : " + a2);
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "onTempleLoadCompleted : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
        this.mIsTempleteCreated = true;
        this.mIsTempleteCreating = false;
    }

    public void registerCaseLoadListener(a aVar) {
        this.mCaseLoadListenerList.add(aVar);
    }

    public void setEngineCreated(boolean z) {
        this.mIsEngineCreated = z;
    }

    public void setIsFrontCamera(boolean z) {
        this.mIsFrontCamera = z;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetPreviewSize(i, i2);
        }
    }

    public void setWindowSize(int i, int i2) {
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetWindowSize(i, i2);
        }
    }

    public void unloadCase() {
        c cVar;
        if (!this.mIsEngineCreated || (cVar = this.mCaseState) == c.EDestroying || cVar == c.EUninit) {
            return;
        }
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadCase");
        this.mCaseState = c.EDestroying;
        notifyCaseLoadListener();
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        nativeUnloadCase();
        releaseComponents();
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadCase finished");
    }

    public void unloadTemplete() {
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadTemplete");
        this.mIsTempleteDestoring = true;
        this.mIsTempleteCreated = false;
        nativeUnloadTemplete();
        com.baidu.ar.arplay.c.b.b(ARPEngine.TAG, "unloadTemplete finished");
        this.mIsTempleteDestoryed = true;
    }

    public void unregisterCaseLoadListener(a aVar) {
        this.mCaseLoadListenerList.remove(aVar);
    }
}

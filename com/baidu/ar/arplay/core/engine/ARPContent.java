package com.baidu.ar.arplay.core.engine;

import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ARPContent {
    private c mCaseState = c.EUninit;
    private volatile boolean mIsEngineCreated = false;
    private volatile boolean mIsTempleteCreating = false;
    private volatile boolean mIsTempleteCreated = false;
    private volatile boolean mIsTempleteDestoring = true;
    private volatile boolean mIsTempleteDestoryed = false;
    private long mStartTime = 0;
    private boolean mIsFrontCamera = true;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private int mWindowWidth = 720;
    private int mWindowHeight = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private List<a> mCaseLoadListenerList = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void onCaseLoaded(boolean z);
    }

    /* loaded from: classes6.dex */
    public enum b {
        LoadCase,
        UnloadCase,
        OnCaseLoaded,
        OnCaseUnloaded
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
        switch (bVar) {
            case LoadCase:
            default:
                return true;
            case UnloadCase:
                return (!this.mIsEngineCreated || this.mCaseState == c.EDestroying || this.mCaseState == c.EUninit) ? false : true;
            case OnCaseLoaded:
                return this.mIsEngineCreated && this.mCaseState == c.ECreating;
        }
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
        if (!this.mIsEngineCreated || this.mCaseState == c.ECreating) {
            return -1;
        }
        this.mCaseState = c.ECreating;
        notifyCaseLoadListener();
        ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
        this.mStartTime = System.currentTimeMillis();
        if (this.mPreviewWidth > 0) {
            i = this.mPreviewWidth;
        }
        this.mPreviewWidth = i;
        if (this.mPreviewHeight > 0) {
            i2 = this.mPreviewHeight;
        }
        this.mPreviewHeight = i2;
        if (this.mWindowWidth > 0 && this.mWindowHeight > 0) {
            nativeSetWindowSize(this.mWindowWidth, this.mWindowHeight);
        }
        nativeLoadCase(str, this.mPreviewWidth, this.mPreviewHeight);
        return 0;
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

    native void nativeLoadCase(String str, int i, int i2);

    native void nativeLoadTemplete(String str, int i, int i2);

    native void nativeSetPreviewSize(int i, int i2);

    native void nativeSetWindowSize(int i, int i2);

    native void nativeUnloadCase();

    native void nativeUnloadTemplete();

    public void notifyCaseLoadListener() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mCaseLoadListenerList.size()) {
                return;
            }
            this.mCaseLoadListenerList.get(i2).onCaseLoaded(isCaseCreated());
            i = i2 + 1;
        }
    }

    public void onCaseLoadCompleted(Map map) {
        if (this.mIsEngineCreated && this.mCaseState == c.ECreating && map != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
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
        com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2);
        com.baidu.ar.arplay.c.b.b("ARPEngine", "onTempleLoadCompleted : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
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
        if (!this.mIsEngineCreated || this.mCaseState == c.EDestroying || this.mCaseState == c.EUninit) {
            return;
        }
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadCase");
        this.mCaseState = c.EDestroying;
        notifyCaseLoadListener();
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        nativeUnloadCase();
        releaseComponents();
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadCase finished");
    }

    public void unloadTemplete() {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadTemplete");
        this.mIsTempleteDestoring = true;
        this.mIsTempleteCreated = false;
        nativeUnloadTemplete();
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadTemplete finished");
        this.mIsTempleteDestoryed = true;
    }

    public void unregisterCaseLoadListener(a aVar) {
        this.mCaseLoadListenerList.remove(aVar);
    }
}

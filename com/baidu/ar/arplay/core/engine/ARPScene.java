package com.baidu.ar.arplay.core.engine;

import android.util.Log;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class ARPScene {
    private HashMap<String, ARPNode> eh;
    private long ej = -1;

    public ARPScene() {
        init();
    }

    private ARPNode g(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.eh.get(nativeGetNodeName);
        if (aRPNode == null) {
            ARPNode aRPNode2 = new ARPNode();
            aRPNode2.e(j);
            this.eh.put(nativeGetNodeName, aRPNode2);
            return aRPNode2;
        }
        return aRPNode;
    }

    private void init() {
        this.eh = new HashMap<>();
    }

    public ARPNode E(String str) {
        if (this.ej == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetNodeByName(this.ej, str));
    }

    public ARPCamera aV() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.ej);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.e(nativeGetActiveCamera);
        return aRPCamera;
    }

    public ARPNode aW() {
        if (this.ej == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetRootNode(this.ej));
    }

    public void aX() {
        if (this.ej == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(this.ej);
        }
    }

    public void f(long j) {
        this.ej = j;
    }

    public boolean h(boolean z) {
        if (this.ej == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(this.ej, z);
        return true;
    }

    public void i(boolean z) {
        if (this.ej == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(this.ej, z);
        }
    }

    native long nativeGetActiveCamera(long j);

    native long nativeGetNodeByName(long j, String str);

    native String nativeGetNodeName(long j);

    native long nativeGetRootNode(long j);

    native void nativeRelocate(long j);

    native void nativeSetOffScreenGuideWork(long j, boolean z);

    native void nativeSetVisible(long j, boolean z);
}

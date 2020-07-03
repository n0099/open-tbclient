package com.baidu.ar.arplay.core.engine;

import android.util.Log;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARPScene {
    private HashMap<String, ARPNode> eI;
    private long eK = -1;

    public ARPScene() {
        aV();
    }

    private void aV() {
        this.eI = new HashMap<>();
    }

    private ARPNode g(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.eI.get(nativeGetNodeName);
        if (aRPNode == null) {
            ARPNode aRPNode2 = new ARPNode();
            aRPNode2.e(j);
            this.eI.put(nativeGetNodeName, aRPNode2);
            return aRPNode2;
        }
        return aRPNode;
    }

    public ARPNode D(String str) {
        if (this.eK == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetNodeByName(this.eK, str));
    }

    public ARPCamera aY() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.eK);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.e(nativeGetActiveCamera);
        return aRPCamera;
    }

    public ARPNode aZ() {
        if (this.eK == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetRootNode(this.eK));
    }

    public void ba() {
        if (this.eK == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(this.eK);
        }
    }

    public void f(long j) {
        this.eK = j;
    }

    public boolean g(boolean z) {
        if (this.eK == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(this.eK, z);
        return true;
    }

    public void h(boolean z) {
        if (this.eK == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(this.eK, z);
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

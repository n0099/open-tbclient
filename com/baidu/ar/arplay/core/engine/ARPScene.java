package com.baidu.ar.arplay.core.engine;

import android.util.Log;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARPScene {
    private HashMap<String, ARPNode> ew;
    private long ey = -1;

    public ARPScene() {
        aH();
    }

    private void aH() {
        this.ew = new HashMap<>();
    }

    private ARPNode g(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.ew.get(nativeGetNodeName);
        if (aRPNode == null) {
            ARPNode aRPNode2 = new ARPNode();
            aRPNode2.e(j);
            this.ew.put(nativeGetNodeName, aRPNode2);
            return aRPNode2;
        }
        return aRPNode;
    }

    public ARPNode D(String str) {
        if (this.ey == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetNodeByName(this.ey, str));
    }

    public ARPCamera aK() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.ey);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.e(nativeGetActiveCamera);
        return aRPCamera;
    }

    public ARPNode aL() {
        if (this.ey == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return g(nativeGetRootNode(this.ey));
    }

    public void aM() {
        if (this.ey == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(this.ey);
        }
    }

    public void f(long j) {
        this.ey = j;
    }

    public boolean h(boolean z) {
        if (this.ey == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(this.ey, z);
        return true;
    }

    public void i(boolean z) {
        if (this.ey == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(this.ey, z);
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

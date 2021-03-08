package com.baidu.ar.arplay.core.engine3d;

import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARPScene implements IARPScene {
    private HashMap<String, ARPNode> fL;
    private long fN = -1;

    public ARPScene() {
        init();
    }

    private IARPNode e(long j) {
        String nativeGetNodeName = nativeGetNodeName(j);
        ARPNode aRPNode = this.fL.get(nativeGetNodeName);
        if (aRPNode == null) {
            ARPNode aRPNode2 = new ARPNode();
            aRPNode2.bindInternal(j);
            this.fL.put(nativeGetNodeName, aRPNode2);
            return aRPNode2;
        }
        return aRPNode;
    }

    private void init() {
        this.fL = new HashMap<>();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPCamera getActiveCamera() {
        long nativeGetActiveCamera = nativeGetActiveCamera(this.fN);
        ARPCamera aRPCamera = new ARPCamera();
        aRPCamera.bindInternal(nativeGetActiveCamera);
        return aRPCamera;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public String getName(long j) {
        return nativeGetName(j);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getNodeByName(String str) {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return e(nativeGetNodeByName(this.fN, str));
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getRootNode() {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return e(nativeGetRootNode(this.fN));
    }

    native long nativeGetActiveCamera(long j);

    native String nativeGetName(long j);

    native long nativeGetNodeByName(long j, String str);

    native String nativeGetNodeName(long j);

    native long nativeGetRootNode(long j);

    native void nativeRelocate(long j);

    native float[] nativeSceneProject(long j, float[] fArr);

    native void nativeSetOffScreenGuideWork(long j, boolean z);

    native void nativeSetVisible(long j, boolean z);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void relocate() {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeRelocate(this.fN);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public float[] sceneProject(float[] fArr) {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return null;
        }
        return nativeSceneProject(this.fN, fArr);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setInternal(long j) {
        this.fN = j;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setOffScreenGuideWork(boolean z) {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetOffScreenGuideWork(this.fN, z);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public boolean setVisible(boolean z) {
        if (this.fN == -1) {
            Log.e(ARPScene.class.getSimpleName(), "node addr is error");
            return false;
        }
        nativeSetVisible(this.fN, z);
        return true;
    }
}

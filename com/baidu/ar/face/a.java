package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class a extends d implements IFace {
    private String K;
    private FaceListener na;
    private WeakReference<IFace> nn;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.nn != null) {
                this.nn.clear();
                this.nn = null;
                return;
            }
            return;
        }
        if (cVar instanceof IFace) {
            this.nn = new WeakReference<>((IFace) cVar);
            if (!TextUtils.isEmpty(this.K)) {
                this.nn.get().setFaceModelPath(this.K);
            }
        }
        if (this.na != null) {
            this.nn.get().setFaceListener(this.na);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.nn != null) {
            this.nn.clear();
            this.nn = null;
        }
        this.na = null;
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.na = faceListener;
        if (this.nn != null) {
            this.nn.get().setFaceListener(this.na);
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        this.K = str;
        if (this.nn != null) {
            this.nn.get().setFaceModelPath(str);
        }
    }
}

package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends d implements IFace {
    private String L;
    private WeakReference<IFace> nD;
    private FaceListener nq;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar == null) {
            if (this.nD != null) {
                this.nD.clear();
                this.nD = null;
                return;
            }
            return;
        }
        if (cVar instanceof IFace) {
            this.nD = new WeakReference<>((IFace) cVar);
            if (!TextUtils.isEmpty(this.L)) {
                this.nD.get().setFaceModelPath(this.L);
            }
        }
        if (this.nq != null) {
            this.nD.get().setFaceListener(this.nq);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.nD != null) {
            this.nD.clear();
            this.nD = null;
        }
        this.nq = null;
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.nq = faceListener;
        if (this.nD != null) {
            this.nD.get().setFaceListener(this.nq);
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        this.L = str;
        if (this.nD != null) {
            this.nD.get().setFaceModelPath(str);
        }
    }
}

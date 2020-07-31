package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class a extends d implements IFace {
    private String K;
    private WeakReference<IFace> mQ;
    private FaceListener ms;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar == null) {
            if (this.mQ != null) {
                this.mQ.clear();
                this.mQ = null;
                return;
            }
            return;
        }
        if (cVar instanceof IFace) {
            this.mQ = new WeakReference<>((IFace) cVar);
            if (!TextUtils.isEmpty(this.K)) {
                this.mQ.get().setFaceModelPath(this.K);
            }
        }
        if (this.ms != null) {
            this.mQ.get().setFaceListener(this.ms);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mQ != null) {
            this.mQ.clear();
            this.mQ = null;
        }
        this.ms = null;
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.ms = faceListener;
        if (this.mQ != null) {
            this.mQ.get().setFaceListener(this.ms);
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        this.K = str;
        if (this.mQ != null) {
            this.mQ.get().setFaceModelPath(str);
        }
    }
}

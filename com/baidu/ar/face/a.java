package com.baidu.ar.face;

import android.text.TextUtils;
import com.baidu.ar.c;
import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a extends d implements IFace {
    private String L;
    private FaceListener lT;
    private WeakReference<IFace> mt;

    @Override // com.baidu.ar.d
    public void a(c cVar) {
        if (cVar == null) {
            if (this.mt != null) {
                this.mt.clear();
                this.mt = null;
                return;
            }
            return;
        }
        if (cVar instanceof IFace) {
            this.mt = new WeakReference<>((IFace) cVar);
            if (!TextUtils.isEmpty(this.L)) {
                this.mt.get().setFaceModelPath(this.L);
            }
        }
        if (this.lT != null) {
            this.mt.get().setFaceListener(this.lT);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mt != null) {
            this.mt.clear();
            this.mt = null;
        }
        this.lT = null;
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceListener(FaceListener faceListener) {
        this.lT = faceListener;
        if (this.mt != null) {
            this.mt.get().setFaceListener(this.lT);
        }
    }

    @Override // com.baidu.ar.face.IFace
    public void setFaceModelPath(String str) {
        this.L = str;
        if (this.mt != null) {
            this.mt.get().setFaceModelPath(str);
        }
    }
}

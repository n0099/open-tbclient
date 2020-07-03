package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a brM;
    private List<b> brN;
    private int brO = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void U(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.brM.releaseEglSurface();
        for (b bVar : this.brN) {
            bVar.release();
        }
        this.brN.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.brN == null) {
                this.brN = new ArrayList();
            } else {
                this.brN.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.brN.add(new b(list.get(i2)));
                    if (list.get(i2).LP()) {
                        this.brO = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.brN.size() > this.brO) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.brM = new com.baidu.mario.gldraw2d.a.a(this.brN.get(this.brO).Lm(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.brM = new com.baidu.mario.gldraw2d.a.a(this.brN.get(this.brO).Lm(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.brM = new com.baidu.mario.gldraw2d.a.a(this.brN.get(this.brO).Lm(), (SurfaceHolder) obj);
                    }
                } else if (this.brN != null && this.brN != null && (bVar = this.brN.get(this.brO)) != null) {
                    this.brM.a(bVar.Lm());
                }
            }
            for (b bVar2 : this.brN) {
                if (this.brM != null) {
                    this.brM.b(bVar2.Lm());
                    bVar2.Ll();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.brN) {
            if (this.brM != null) {
                this.brM.b(bVar.Lm());
                bVar.a(cVar);
            }
        }
    }

    public void Lk() {
        if (this.brM != null) {
            this.brM.release();
            this.brM = null;
        }
        if (this.brN != null) {
            for (b bVar : this.brN) {
                bVar.release();
            }
            this.brN.clear();
            this.brN = null;
        }
    }

    public void aE(long j) {
        if (this.brM != null && this.brN != null && this.brN.size() != 0) {
            synchronized (this) {
                for (b bVar : this.brN) {
                    this.brM.b(bVar.Lm());
                    bVar.aF(j);
                }
                notifyAll();
            }
            this.brM.setPresentationTime(j);
            this.brM.swapBuffers();
        }
    }
}

package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a bya;
    private List<b> byb;
    private int byc = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void V(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bya.releaseEglSurface();
        for (b bVar : this.byb) {
            bVar.release();
        }
        this.byb.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.byb == null) {
                this.byb = new ArrayList();
            } else {
                this.byb.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.byb.add(new b(list.get(i2)));
                    if (list.get(i2).RV()) {
                        this.byc = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.byb.size() > this.byc) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bya = new com.baidu.mario.gldraw2d.a.a(this.byb.get(this.byc).Rt(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bya = new com.baidu.mario.gldraw2d.a.a(this.byb.get(this.byc).Rt(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bya = new com.baidu.mario.gldraw2d.a.a(this.byb.get(this.byc).Rt(), (SurfaceHolder) obj);
                    }
                } else if (this.byb != null && this.byb != null && (bVar = this.byb.get(this.byc)) != null && this.bya != null) {
                    this.bya.a(bVar.Rt());
                }
            }
            for (b bVar2 : this.byb) {
                if (this.bya != null) {
                    this.bya.b(bVar2.Rt());
                    bVar2.Rs();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.byb) {
            if (this.bya != null) {
                this.bya.b(bVar.Rt());
                bVar.a(cVar);
            }
        }
    }

    public void Rr() {
        if (this.bya != null) {
            this.bya.release();
            this.bya = null;
        }
        if (this.byb != null) {
            for (b bVar : this.byb) {
                bVar.release();
            }
            this.byb.clear();
            this.byb = null;
        }
    }

    public void aF(long j) {
        if (this.bya != null && this.byb != null && this.byb.size() != 0) {
            synchronized (this) {
                for (b bVar : this.byb) {
                    this.bya.b(bVar.Rt());
                    bVar.aG(j);
                }
                notifyAll();
            }
            this.bya.setPresentationTime(j);
            this.bya.swapBuffers();
        }
    }
}

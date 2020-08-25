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
    protected com.baidu.mario.gldraw2d.a.a bxX;
    private List<b> bxY;
    private int bxZ = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void V(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bxX.releaseEglSurface();
        for (b bVar : this.bxY) {
            bVar.release();
        }
        this.bxY.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bxY == null) {
                this.bxY = new ArrayList();
            } else {
                this.bxY.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bxY.add(new b(list.get(i2)));
                    if (list.get(i2).RV()) {
                        this.bxZ = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bxY.size() > this.bxZ) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bxX = new com.baidu.mario.gldraw2d.a.a(this.bxY.get(this.bxZ).Rt(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bxX = new com.baidu.mario.gldraw2d.a.a(this.bxY.get(this.bxZ).Rt(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bxX = new com.baidu.mario.gldraw2d.a.a(this.bxY.get(this.bxZ).Rt(), (SurfaceHolder) obj);
                    }
                } else if (this.bxY != null && this.bxY != null && (bVar = this.bxY.get(this.bxZ)) != null && this.bxX != null) {
                    this.bxX.a(bVar.Rt());
                }
            }
            for (b bVar2 : this.bxY) {
                if (this.bxX != null) {
                    this.bxX.b(bVar2.Rt());
                    bVar2.Rs();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bxY) {
            if (this.bxX != null) {
                this.bxX.b(bVar.Rt());
                bVar.a(cVar);
            }
        }
    }

    public void Rr() {
        if (this.bxX != null) {
            this.bxX.release();
            this.bxX = null;
        }
        if (this.bxY != null) {
            for (b bVar : this.bxY) {
                bVar.release();
            }
            this.bxY.clear();
            this.bxY = null;
        }
    }

    public void aF(long j) {
        if (this.bxX != null && this.bxY != null && this.bxY.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bxY) {
                    this.bxX.b(bVar.Rt());
                    bVar.aG(j);
                }
                notifyAll();
            }
            this.bxX.setPresentationTime(j);
            this.bxX.swapBuffers();
        }
    }
}

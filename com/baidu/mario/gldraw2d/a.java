package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a cfP;
    private List<b> cfQ;
    private int cfR = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void ax(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.cfP.releaseEglSurface();
        for (b bVar : this.cfQ) {
            bVar.release();
        }
        this.cfQ.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.cfQ == null) {
                this.cfQ = new ArrayList();
            } else {
                this.cfQ.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.cfQ.add(new b(list.get(i2)));
                    if (list.get(i2).aaE()) {
                        this.cfR = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.cfQ.size() > this.cfR) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.cfP = new com.baidu.mario.gldraw2d.a.a(this.cfQ.get(this.cfR).aaf(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.cfP = new com.baidu.mario.gldraw2d.a.a(this.cfQ.get(this.cfR).aaf(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.cfP = new com.baidu.mario.gldraw2d.a.a(this.cfQ.get(this.cfR).aaf(), (SurfaceHolder) obj);
                    }
                } else if (this.cfQ != null && this.cfQ != null && (bVar = this.cfQ.get(this.cfR)) != null && this.cfP != null) {
                    this.cfP.a(bVar.aaf());
                }
            }
            for (b bVar2 : this.cfQ) {
                if (this.cfP != null) {
                    this.cfP.b(bVar2.aaf());
                    bVar2.aae();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.cfQ) {
            if (this.cfP != null) {
                this.cfP.b(bVar.aaf());
                bVar.a(cVar);
            }
        }
    }

    public void aad() {
        if (this.cfP != null) {
            this.cfP.release();
            this.cfP = null;
        }
        if (this.cfQ != null) {
            for (b bVar : this.cfQ) {
                bVar.release();
            }
            this.cfQ.clear();
            this.cfQ = null;
        }
    }

    public void bH(long j) {
        if (this.cfP != null && this.cfQ != null && this.cfQ.size() != 0) {
            synchronized (this) {
                for (b bVar : this.cfQ) {
                    this.cfP.b(bVar.aaf());
                    bVar.bI(j);
                }
                notifyAll();
            }
            this.cfP.setPresentationTime(j);
            this.cfP.swapBuffers();
        }
    }
}

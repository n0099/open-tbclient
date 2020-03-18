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
    protected com.baidu.mario.gldraw2d.a.a aJp;
    private List<b> aJq;
    private int aJr = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void J(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aJp.releaseEglSurface();
        for (b bVar : this.aJq) {
            bVar.release();
        }
        this.aJq.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aJq == null) {
                this.aJq = new ArrayList();
            } else {
                this.aJq.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aJq.add(new b(list.get(i2)));
                    if (list.get(i2).CJ()) {
                        this.aJr = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aJq.size() > this.aJr) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aJp = new com.baidu.mario.gldraw2d.a.a(this.aJq.get(this.aJr).Cg(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aJp = new com.baidu.mario.gldraw2d.a.a(this.aJq.get(this.aJr).Cg(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aJp = new com.baidu.mario.gldraw2d.a.a(this.aJq.get(this.aJr).Cg(), (SurfaceHolder) obj);
                    }
                } else if (this.aJq != null && this.aJq != null && (bVar = this.aJq.get(this.aJr)) != null) {
                    this.aJp.a(bVar.Cg());
                }
            }
            for (b bVar2 : this.aJq) {
                if (this.aJp != null) {
                    this.aJp.b(bVar2.Cg());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aJq) {
            if (this.aJp != null) {
                this.aJp.b(bVar.Cg());
                bVar.a(cVar);
            }
        }
    }

    public void Cf() {
        if (this.aJp != null) {
            this.aJp.release();
            this.aJp = null;
        }
        if (this.aJq != null) {
            for (b bVar : this.aJq) {
                bVar.release();
            }
            this.aJq.clear();
            this.aJq = null;
        }
    }

    public void T(long j) {
        if (this.aJp != null && this.aJq != null && this.aJq.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aJq) {
                    this.aJp.b(bVar.Cg());
                    bVar.U(j);
                }
                notifyAll();
            }
            this.aJp.setPresentationTime(j);
            this.aJp.swapBuffers();
        }
    }
}

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
    protected com.baidu.mario.gldraw2d.a.a bfh;
    private List<b> bfi;
    private int bfj = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void P(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bfh.releaseEglSurface();
        for (b bVar : this.bfi) {
            bVar.release();
        }
        this.bfi.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bfi == null) {
                this.bfi = new ArrayList();
            } else {
                this.bfi.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bfi.add(new b(list.get(i2)));
                    if (list.get(i2).IO()) {
                        this.bfj = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bfi.size() > this.bfj) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bfh = new com.baidu.mario.gldraw2d.a.a(this.bfi.get(this.bfj).Il(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bfh = new com.baidu.mario.gldraw2d.a.a(this.bfi.get(this.bfj).Il(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bfh = new com.baidu.mario.gldraw2d.a.a(this.bfi.get(this.bfj).Il(), (SurfaceHolder) obj);
                    }
                } else if (this.bfi != null && this.bfi != null && (bVar = this.bfi.get(this.bfj)) != null) {
                    this.bfh.a(bVar.Il());
                }
            }
            for (b bVar2 : this.bfi) {
                if (this.bfh != null) {
                    this.bfh.b(bVar2.Il());
                    bVar2.Ik();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bfi) {
            if (this.bfh != null) {
                this.bfh.b(bVar.Il());
                bVar.a(cVar);
            }
        }
    }

    public void Ij() {
        if (this.bfh != null) {
            this.bfh.release();
            this.bfh = null;
        }
        if (this.bfi != null) {
            for (b bVar : this.bfi) {
                bVar.release();
            }
            this.bfi.clear();
            this.bfi = null;
        }
    }

    public void az(long j) {
        if (this.bfh != null && this.bfi != null && this.bfi.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bfi) {
                    this.bfh.b(bVar.Il());
                    bVar.aA(j);
                }
                notifyAll();
            }
            this.bfh.setPresentationTime(j);
            this.bfh.swapBuffers();
        }
    }
}

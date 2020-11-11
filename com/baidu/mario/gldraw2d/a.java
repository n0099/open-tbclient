package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a bWe;
    private List<b> bWf;
    private int bWg = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void at(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bWe.releaseEglSurface();
        for (b bVar : this.bWf) {
            bVar.release();
        }
        this.bWf.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bWf == null) {
                this.bWf = new ArrayList();
            } else {
                this.bWf.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bWf.add(new b(list.get(i2)));
                    if (list.get(i2).YY()) {
                        this.bWg = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bWf.size() > this.bWg) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bWe = new com.baidu.mario.gldraw2d.a.a(this.bWf.get(this.bWg).Yw(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bWe = new com.baidu.mario.gldraw2d.a.a(this.bWf.get(this.bWg).Yw(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bWe = new com.baidu.mario.gldraw2d.a.a(this.bWf.get(this.bWg).Yw(), (SurfaceHolder) obj);
                    }
                } else if (this.bWf != null && this.bWf != null && (bVar = this.bWf.get(this.bWg)) != null && this.bWe != null) {
                    this.bWe.a(bVar.Yw());
                }
            }
            for (b bVar2 : this.bWf) {
                if (this.bWe != null) {
                    this.bWe.b(bVar2.Yw());
                    bVar2.Yv();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bWf) {
            if (this.bWe != null) {
                this.bWe.b(bVar.Yw());
                bVar.a(cVar);
            }
        }
    }

    public void Yu() {
        if (this.bWe != null) {
            this.bWe.release();
            this.bWe = null;
        }
        if (this.bWf != null) {
            for (b bVar : this.bWf) {
                bVar.release();
            }
            this.bWf.clear();
            this.bWf = null;
        }
    }

    public void bf(long j) {
        if (this.bWe != null && this.bWf != null && this.bWf.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bWf) {
                    this.bWe.b(bVar.Yw());
                    bVar.bg(j);
                }
                notifyAll();
            }
            this.bWe.setPresentationTime(j);
            this.bWe.swapBuffers();
        }
    }
}

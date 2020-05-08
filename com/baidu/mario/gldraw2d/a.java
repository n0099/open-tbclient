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
    protected com.baidu.mario.gldraw2d.a.a bfm;
    private List<b> bfn;
    private int bfo = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void P(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bfm.releaseEglSurface();
        for (b bVar : this.bfn) {
            bVar.release();
        }
        this.bfn.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bfn == null) {
                this.bfn = new ArrayList();
            } else {
                this.bfn.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bfn.add(new b(list.get(i2)));
                    if (list.get(i2).IN()) {
                        this.bfo = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bfn.size() > this.bfo) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bfm = new com.baidu.mario.gldraw2d.a.a(this.bfn.get(this.bfo).Ik(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bfm = new com.baidu.mario.gldraw2d.a.a(this.bfn.get(this.bfo).Ik(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bfm = new com.baidu.mario.gldraw2d.a.a(this.bfn.get(this.bfo).Ik(), (SurfaceHolder) obj);
                    }
                } else if (this.bfn != null && this.bfn != null && (bVar = this.bfn.get(this.bfo)) != null) {
                    this.bfm.a(bVar.Ik());
                }
            }
            for (b bVar2 : this.bfn) {
                if (this.bfm != null) {
                    this.bfm.b(bVar2.Ik());
                    bVar2.Ij();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bfn) {
            if (this.bfm != null) {
                this.bfm.b(bVar.Ik());
                bVar.a(cVar);
            }
        }
    }

    public void Ii() {
        if (this.bfm != null) {
            this.bfm.release();
            this.bfm = null;
        }
        if (this.bfn != null) {
            for (b bVar : this.bfn) {
                bVar.release();
            }
            this.bfn.clear();
            this.bfn = null;
        }
    }

    public void az(long j) {
        if (this.bfm != null && this.bfn != null && this.bfn.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bfn) {
                    this.bfm.b(bVar.Ik());
                    bVar.aA(j);
                }
                notifyAll();
            }
            this.bfm.setPresentationTime(j);
            this.bfm.swapBuffers();
        }
    }
}

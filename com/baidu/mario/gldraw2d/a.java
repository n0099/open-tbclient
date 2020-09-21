package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a bBx;
    private List<b> bBy;
    private int bBz = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void Z(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bBx.releaseEglSurface();
        for (b bVar : this.bBy) {
            bVar.release();
        }
        this.bBy.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bBy == null) {
                this.bBy = new ArrayList();
            } else {
                this.bBy.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bBy.add(new b(list.get(i2)));
                    if (list.get(i2).SM()) {
                        this.bBz = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bBy.size() > this.bBz) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bBx = new com.baidu.mario.gldraw2d.a.a(this.bBy.get(this.bBz).Sk(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bBx = new com.baidu.mario.gldraw2d.a.a(this.bBy.get(this.bBz).Sk(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bBx = new com.baidu.mario.gldraw2d.a.a(this.bBy.get(this.bBz).Sk(), (SurfaceHolder) obj);
                    }
                } else if (this.bBy != null && this.bBy != null && (bVar = this.bBy.get(this.bBz)) != null && this.bBx != null) {
                    this.bBx.a(bVar.Sk());
                }
            }
            for (b bVar2 : this.bBy) {
                if (this.bBx != null) {
                    this.bBx.b(bVar2.Sk());
                    bVar2.Sj();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bBy) {
            if (this.bBx != null) {
                this.bBx.b(bVar.Sk());
                bVar.a(cVar);
            }
        }
    }

    public void Si() {
        if (this.bBx != null) {
            this.bBx.release();
            this.bBx = null;
        }
        if (this.bBy != null) {
            for (b bVar : this.bBy) {
                bVar.release();
            }
            this.bBy.clear();
            this.bBy = null;
        }
    }

    public void aF(long j) {
        if (this.bBx != null && this.bBy != null && this.bBy.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bBy) {
                    this.bBx.b(bVar.Sk());
                    bVar.aG(j);
                }
                notifyAll();
            }
            this.bBx.setPresentationTime(j);
            this.bBx.swapBuffers();
        }
    }
}

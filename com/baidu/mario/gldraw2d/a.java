package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a aEb;
    private List<b> aEc;
    private int aEd = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void K(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aEb.releaseEglSurface();
        for (b bVar : this.aEc) {
            bVar.release();
        }
        this.aEc.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aEc == null) {
                this.aEc = new ArrayList();
            } else {
                this.aEc.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aEc.add(new b(list.get(i2)));
                    if (list.get(i2).zO()) {
                        this.aEd = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aEc.size() > this.aEd) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aEb = new com.baidu.mario.gldraw2d.a.a(this.aEc.get(this.aEd).zl(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aEb = new com.baidu.mario.gldraw2d.a.a(this.aEc.get(this.aEd).zl(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aEb = new com.baidu.mario.gldraw2d.a.a(this.aEc.get(this.aEd).zl(), (SurfaceHolder) obj);
                    }
                } else if (this.aEc != null && this.aEc != null && (bVar = this.aEc.get(this.aEd)) != null) {
                    this.aEb.a(bVar.zl());
                }
            }
            for (b bVar2 : this.aEc) {
                if (this.aEb != null) {
                    this.aEb.b(bVar2.zl());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aEc) {
            if (this.aEb != null) {
                this.aEb.b(bVar.zl());
                bVar.a(cVar);
            }
        }
    }

    public void zk() {
        if (this.aEb != null) {
            this.aEb.release();
            this.aEb = null;
        }
        if (this.aEc != null) {
            for (b bVar : this.aEc) {
                bVar.release();
            }
            this.aEc.clear();
            this.aEc = null;
        }
    }

    public void M(long j) {
        if (this.aEb != null && this.aEc != null && this.aEc.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aEc) {
                    this.aEb.b(bVar.zl());
                    bVar.N(j);
                }
                notifyAll();
            }
            this.aEb.setPresentationTime(j);
            this.aEb.swapBuffers();
        }
    }
}

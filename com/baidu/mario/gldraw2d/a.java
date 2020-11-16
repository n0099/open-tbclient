package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a bUu;
    private List<b> bUv;
    private int bUw = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void at(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bUu.releaseEglSurface();
        for (b bVar : this.bUv) {
            bVar.release();
        }
        this.bUv.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bUv == null) {
                this.bUv = new ArrayList();
            } else {
                this.bUv.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bUv.add(new b(list.get(i2)));
                    if (list.get(i2).Yp()) {
                        this.bUw = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bUv.size() > this.bUw) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bUu = new com.baidu.mario.gldraw2d.a.a(this.bUv.get(this.bUw).XN(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bUu = new com.baidu.mario.gldraw2d.a.a(this.bUv.get(this.bUw).XN(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bUu = new com.baidu.mario.gldraw2d.a.a(this.bUv.get(this.bUw).XN(), (SurfaceHolder) obj);
                    }
                } else if (this.bUv != null && this.bUv != null && (bVar = this.bUv.get(this.bUw)) != null && this.bUu != null) {
                    this.bUu.a(bVar.XN());
                }
            }
            for (b bVar2 : this.bUv) {
                if (this.bUu != null) {
                    this.bUu.b(bVar2.XN());
                    bVar2.XM();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bUv) {
            if (this.bUu != null) {
                this.bUu.b(bVar.XN());
                bVar.a(cVar);
            }
        }
    }

    public void XL() {
        if (this.bUu != null) {
            this.bUu.release();
            this.bUu = null;
        }
        if (this.bUv != null) {
            for (b bVar : this.bUv) {
                bVar.release();
            }
            this.bUv.clear();
            this.bUv = null;
        }
    }

    public void bf(long j) {
        if (this.bUu != null && this.bUv != null && this.bUv.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bUv) {
                    this.bUu.b(bVar.XN());
                    bVar.bg(j);
                }
                notifyAll();
            }
            this.bUu.setPresentationTime(j);
            this.bUu.swapBuffers();
        }
    }
}

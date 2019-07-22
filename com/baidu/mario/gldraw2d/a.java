package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a adq;
    private List<b> adr;
    private int ads = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void n(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.adq.releaseEglSurface();
        for (b bVar : this.adr) {
            bVar.release();
        }
        this.adr.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        if (list != null && list.size() != 0) {
            if (this.adr == null) {
                this.adr = new ArrayList();
            } else {
                this.adr.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.adr.add(new b(list.get(i2)));
                    if (list.get(i2).td()) {
                        this.ads = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.adr.size() > this.ads) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.adq = new com.baidu.mario.gldraw2d.a.a(this.adr.get(this.ads).sA(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.adq = new com.baidu.mario.gldraw2d.a.a(this.adr.get(this.ads).sA(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.adq = new com.baidu.mario.gldraw2d.a.a(this.adr.get(this.ads).sA(), (SurfaceHolder) obj);
                    }
                } else {
                    this.adq.a(this.adr.get(this.ads).sA());
                }
            }
            for (b bVar : this.adr) {
                this.adq.b(bVar.sA());
                bVar.sz();
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.adr) {
            this.adq.b(bVar.sA());
            bVar.a(cVar);
        }
    }

    public void sy() {
        if (this.adq != null) {
            this.adq.release();
            this.adq = null;
        }
        if (this.adr != null) {
            for (b bVar : this.adr) {
                bVar.release();
            }
            this.adr.clear();
            this.adr = null;
        }
    }

    public void t(long j) {
        if (this.adq != null && this.adr != null && this.adr.size() != 0) {
            for (b bVar : this.adr) {
                this.adq.b(bVar.sA());
                bVar.u(j);
            }
            this.adq.setPresentationTime(j);
            this.adq.swapBuffers();
        }
    }
}

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
    protected com.baidu.mario.gldraw2d.a.a aJb;
    private List<b> aJc;
    private int aJd = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void J(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aJb.releaseEglSurface();
        for (b bVar : this.aJc) {
            bVar.release();
        }
        this.aJc.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aJc == null) {
                this.aJc = new ArrayList();
            } else {
                this.aJc.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aJc.add(new b(list.get(i2)));
                    if (list.get(i2).CC()) {
                        this.aJd = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aJc.size() > this.aJd) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aJb = new com.baidu.mario.gldraw2d.a.a(this.aJc.get(this.aJd).BZ(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aJb = new com.baidu.mario.gldraw2d.a.a(this.aJc.get(this.aJd).BZ(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aJb = new com.baidu.mario.gldraw2d.a.a(this.aJc.get(this.aJd).BZ(), (SurfaceHolder) obj);
                    }
                } else if (this.aJc != null && this.aJc != null && (bVar = this.aJc.get(this.aJd)) != null) {
                    this.aJb.a(bVar.BZ());
                }
            }
            for (b bVar2 : this.aJc) {
                if (this.aJb != null) {
                    this.aJb.b(bVar2.BZ());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aJc) {
            if (this.aJb != null) {
                this.aJb.b(bVar.BZ());
                bVar.a(cVar);
            }
        }
    }

    public void BY() {
        if (this.aJb != null) {
            this.aJb.release();
            this.aJb = null;
        }
        if (this.aJc != null) {
            for (b bVar : this.aJc) {
                bVar.release();
            }
            this.aJc.clear();
            this.aJc = null;
        }
    }

    public void T(long j) {
        if (this.aJb != null && this.aJc != null && this.aJc.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aJc) {
                    this.aJb.b(bVar.BZ());
                    bVar.U(j);
                }
                notifyAll();
            }
            this.aJb.setPresentationTime(j);
            this.aJb.swapBuffers();
        }
    }
}

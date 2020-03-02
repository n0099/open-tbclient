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
    protected com.baidu.mario.gldraw2d.a.a aJa;
    private List<b> aJb;
    private int aJc = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void J(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aJa.releaseEglSurface();
        for (b bVar : this.aJb) {
            bVar.release();
        }
        this.aJb.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aJb == null) {
                this.aJb = new ArrayList();
            } else {
                this.aJb.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aJb.add(new b(list.get(i2)));
                    if (list.get(i2).CC()) {
                        this.aJc = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aJb.size() > this.aJc) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aJa = new com.baidu.mario.gldraw2d.a.a(this.aJb.get(this.aJc).BZ(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aJa = new com.baidu.mario.gldraw2d.a.a(this.aJb.get(this.aJc).BZ(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aJa = new com.baidu.mario.gldraw2d.a.a(this.aJb.get(this.aJc).BZ(), (SurfaceHolder) obj);
                    }
                } else if (this.aJb != null && this.aJb != null && (bVar = this.aJb.get(this.aJc)) != null) {
                    this.aJa.a(bVar.BZ());
                }
            }
            for (b bVar2 : this.aJb) {
                if (this.aJa != null) {
                    this.aJa.b(bVar2.BZ());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aJb) {
            if (this.aJa != null) {
                this.aJa.b(bVar.BZ());
                bVar.a(cVar);
            }
        }
    }

    public void BY() {
        if (this.aJa != null) {
            this.aJa.release();
            this.aJa = null;
        }
        if (this.aJb != null) {
            for (b bVar : this.aJb) {
                bVar.release();
            }
            this.aJb.clear();
            this.aJb = null;
        }
    }

    public void T(long j) {
        if (this.aJa != null && this.aJb != null && this.aJb.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aJb) {
                    this.aJa.b(bVar.BZ());
                    bVar.U(j);
                }
                notifyAll();
            }
            this.aJa.setPresentationTime(j);
            this.aJa.swapBuffers();
        }
    }
}

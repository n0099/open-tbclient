package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a chp;
    private List<b> chq;
    private int chr = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void ax(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.chp.releaseEglSurface();
        for (b bVar : this.chq) {
            bVar.release();
        }
        this.chq.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.chq == null) {
                this.chq = new ArrayList();
            } else {
                this.chq.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.chq.add(new b(list.get(i2)));
                    if (list.get(i2).aaH()) {
                        this.chr = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.chq.size() > this.chr) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.chp = new com.baidu.mario.gldraw2d.a.a(this.chq.get(this.chr).aai(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.chp = new com.baidu.mario.gldraw2d.a.a(this.chq.get(this.chr).aai(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.chp = new com.baidu.mario.gldraw2d.a.a(this.chq.get(this.chr).aai(), (SurfaceHolder) obj);
                    }
                } else if (this.chq != null && this.chq != null && (bVar = this.chq.get(this.chr)) != null && this.chp != null) {
                    this.chp.a(bVar.aai());
                }
            }
            for (b bVar2 : this.chq) {
                if (this.chp != null) {
                    this.chp.b(bVar2.aai());
                    bVar2.aah();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.chq) {
            if (this.chp != null) {
                this.chp.b(bVar.aai());
                bVar.a(cVar);
            }
        }
    }

    public void aag() {
        if (this.chp != null) {
            this.chp.release();
            this.chp = null;
        }
        if (this.chq != null) {
            for (b bVar : this.chq) {
                bVar.release();
            }
            this.chq.clear();
            this.chq = null;
        }
    }

    public void bH(long j) {
        if (this.chp != null && this.chq != null && this.chq.size() != 0) {
            synchronized (this) {
                for (b bVar : this.chq) {
                    this.chp.b(bVar.aai());
                    bVar.bI(j);
                }
                notifyAll();
            }
            this.chp.setPresentationTime(j);
            this.chp.swapBuffers();
        }
    }
}

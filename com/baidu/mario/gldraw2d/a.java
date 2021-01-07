package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a cgt;
    private List<b> cgu;
    private int cgv = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void aA(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.cgt.releaseEglSurface();
        for (b bVar : this.cgu) {
            bVar.release();
        }
        this.cgu.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.cgu == null) {
                this.cgu = new ArrayList();
            } else {
                this.cgu.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.cgu.add(new b(list.get(i2)));
                    if (list.get(i2).acE()) {
                        this.cgv = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.cgu.size() > this.cgv) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.cgt = new com.baidu.mario.gldraw2d.a.a(this.cgu.get(this.cgv).ace(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.cgt = new com.baidu.mario.gldraw2d.a.a(this.cgu.get(this.cgv).ace(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.cgt = new com.baidu.mario.gldraw2d.a.a(this.cgu.get(this.cgv).ace(), (SurfaceHolder) obj);
                    }
                } else if (this.cgu != null && this.cgu != null && (bVar = this.cgu.get(this.cgv)) != null && this.cgt != null) {
                    this.cgt.a(bVar.ace());
                }
            }
            for (b bVar2 : this.cgu) {
                if (this.cgt != null) {
                    this.cgt.b(bVar2.ace());
                    bVar2.acd();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.cgu) {
            if (this.cgt != null) {
                this.cgt.b(bVar.ace());
                bVar.a(cVar);
            }
        }
    }

    public void acc() {
        if (this.cgt != null) {
            this.cgt.release();
            this.cgt = null;
        }
        if (this.cgu != null) {
            for (b bVar : this.cgu) {
                bVar.release();
            }
            this.cgu.clear();
            this.cgu = null;
        }
    }

    public void bD(long j) {
        if (this.cgt != null && this.cgu != null && this.cgu.size() != 0) {
            synchronized (this) {
                for (b bVar : this.cgu) {
                    this.cgt.b(bVar.ace());
                    bVar.bE(j);
                }
                notifyAll();
            }
            this.cgt.setPresentationTime(j);
            this.cgt.swapBuffers();
        }
    }
}

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
    protected com.baidu.mario.gldraw2d.a.a awO;
    private List<b> awP;
    private int awQ = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void M(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.awO.releaseEglSurface();
        for (b bVar : this.awP) {
            bVar.release();
        }
        this.awP.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        if (list != null && list.size() != 0) {
            if (this.awP == null) {
                this.awP = new ArrayList();
            } else {
                this.awP.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.awP.add(new b(list.get(i2)));
                    if (list.get(i2).xY()) {
                        this.awQ = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.awP.size() > this.awQ) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.awO = new com.baidu.mario.gldraw2d.a.a(this.awP.get(this.awQ).xv(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.awO = new com.baidu.mario.gldraw2d.a.a(this.awP.get(this.awQ).xv(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.awO = new com.baidu.mario.gldraw2d.a.a(this.awP.get(this.awQ).xv(), (SurfaceHolder) obj);
                    }
                } else {
                    this.awO.a(this.awP.get(this.awQ).xv());
                }
            }
            for (b bVar : this.awP) {
                this.awO.b(bVar.xv());
                bVar.xu();
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.awP) {
            this.awO.b(bVar.xv());
            bVar.a(cVar);
        }
    }

    public void xt() {
        if (this.awO != null) {
            this.awO.release();
            this.awO = null;
        }
        if (this.awP != null) {
            for (b bVar : this.awP) {
                bVar.release();
            }
            this.awP.clear();
            this.awP = null;
        }
    }

    public void M(long j) {
        if (this.awO != null && this.awP != null && this.awP.size() != 0) {
            for (b bVar : this.awP) {
                this.awO.b(bVar.xv());
                bVar.N(j);
            }
            this.awO.setPresentationTime(j);
            this.awO.swapBuffers();
        }
    }
}

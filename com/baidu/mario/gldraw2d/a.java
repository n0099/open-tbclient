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
    protected com.baidu.mario.gldraw2d.a.a cbE;
    private List<b> cbF;
    private int cbG = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void aA(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.cbE.releaseEglSurface();
        for (b bVar : this.cbF) {
            bVar.release();
        }
        this.cbF.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.cbF == null) {
                this.cbF = new ArrayList();
            } else {
                this.cbF.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.cbF.add(new b(list.get(i2)));
                    if (list.get(i2).YL()) {
                        this.cbG = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.cbF.size() > this.cbG) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.cbE = new com.baidu.mario.gldraw2d.a.a(this.cbF.get(this.cbG).Yl(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.cbE = new com.baidu.mario.gldraw2d.a.a(this.cbF.get(this.cbG).Yl(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.cbE = new com.baidu.mario.gldraw2d.a.a(this.cbF.get(this.cbG).Yl(), (SurfaceHolder) obj);
                    }
                } else if (this.cbF != null && this.cbF != null && (bVar = this.cbF.get(this.cbG)) != null && this.cbE != null) {
                    this.cbE.a(bVar.Yl());
                }
            }
            for (b bVar2 : this.cbF) {
                if (this.cbE != null) {
                    this.cbE.b(bVar2.Yl());
                    bVar2.Yk();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.cbF) {
            if (this.cbE != null) {
                this.cbE.b(bVar.Yl());
                bVar.a(cVar);
            }
        }
    }

    public void Yj() {
        if (this.cbE != null) {
            this.cbE.release();
            this.cbE = null;
        }
        if (this.cbF != null) {
            for (b bVar : this.cbF) {
                bVar.release();
            }
            this.cbF.clear();
            this.cbF = null;
        }
    }

    public void bD(long j) {
        if (this.cbE != null && this.cbF != null && this.cbF.size() != 0) {
            synchronized (this) {
                for (b bVar : this.cbF) {
                    this.cbE.b(bVar.Yl());
                    bVar.bE(j);
                }
                notifyAll();
            }
            this.cbE.setPresentationTime(j);
            this.cbE.swapBuffers();
        }
    }
}

package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a bHZ;
    private List<b> bIa;
    private int bIb = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void ac(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bHZ.releaseEglSurface();
        for (b bVar : this.bIa) {
            bVar.release();
        }
        this.bIa.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bIa == null) {
                this.bIa = new ArrayList();
            } else {
                this.bIa.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bIa.add(new b(list.get(i2)));
                    if (list.get(i2).UF()) {
                        this.bIb = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bIa.size() > this.bIb) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bHZ = new com.baidu.mario.gldraw2d.a.a(this.bIa.get(this.bIb).Ud(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bHZ = new com.baidu.mario.gldraw2d.a.a(this.bIa.get(this.bIb).Ud(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bHZ = new com.baidu.mario.gldraw2d.a.a(this.bIa.get(this.bIb).Ud(), (SurfaceHolder) obj);
                    }
                } else if (this.bIa != null && this.bIa != null && (bVar = this.bIa.get(this.bIb)) != null && this.bHZ != null) {
                    this.bHZ.a(bVar.Ud());
                }
            }
            for (b bVar2 : this.bIa) {
                if (this.bHZ != null) {
                    this.bHZ.b(bVar2.Ud());
                    bVar2.Uc();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bIa) {
            if (this.bHZ != null) {
                this.bHZ.b(bVar.Ud());
                bVar.a(cVar);
            }
        }
    }

    public void Ub() {
        if (this.bHZ != null) {
            this.bHZ.release();
            this.bHZ = null;
        }
        if (this.bIa != null) {
            for (b bVar : this.bIa) {
                bVar.release();
            }
            this.bIa.clear();
            this.bIa = null;
        }
    }

    public void aH(long j) {
        if (this.bHZ != null && this.bIa != null && this.bIa.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bIa) {
                    this.bHZ.b(bVar.Ud());
                    bVar.aI(j);
                }
                notifyAll();
            }
            this.bHZ.setPresentationTime(j);
            this.bHZ.swapBuffers();
        }
    }
}

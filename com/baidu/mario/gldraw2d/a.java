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
    protected com.baidu.mario.gldraw2d.a.a bmM;
    private List<b> bmN;
    private int bmO = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void Q(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bmM.releaseEglSurface();
        for (b bVar : this.bmN) {
            bVar.release();
        }
        this.bmN.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bmN == null) {
                this.bmN = new ArrayList();
            } else {
                this.bmN.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bmN.add(new b(list.get(i2)));
                    if (list.get(i2).KG()) {
                        this.bmO = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bmN.size() > this.bmO) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bmM = new com.baidu.mario.gldraw2d.a.a(this.bmN.get(this.bmO).Kd(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bmM = new com.baidu.mario.gldraw2d.a.a(this.bmN.get(this.bmO).Kd(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bmM = new com.baidu.mario.gldraw2d.a.a(this.bmN.get(this.bmO).Kd(), (SurfaceHolder) obj);
                    }
                } else if (this.bmN != null && this.bmN != null && (bVar = this.bmN.get(this.bmO)) != null) {
                    this.bmM.a(bVar.Kd());
                }
            }
            for (b bVar2 : this.bmN) {
                if (this.bmM != null) {
                    this.bmM.b(bVar2.Kd());
                    bVar2.Kc();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bmN) {
            if (this.bmM != null) {
                this.bmM.b(bVar.Kd());
                bVar.a(cVar);
            }
        }
    }

    public void Kb() {
        if (this.bmM != null) {
            this.bmM.release();
            this.bmM = null;
        }
        if (this.bmN != null) {
            for (b bVar : this.bmN) {
                bVar.release();
            }
            this.bmN.clear();
            this.bmN = null;
        }
    }

    public void aE(long j) {
        if (this.bmM != null && this.bmN != null && this.bmN.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bmN) {
                    this.bmM.b(bVar.Kd());
                    bVar.aF(j);
                }
                notifyAll();
            }
            this.bmM.setPresentationTime(j);
            this.bmM.swapBuffers();
        }
    }
}

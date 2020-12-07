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
    protected com.baidu.mario.gldraw2d.a.a bZJ;
    private List<b> bZK;
    private int bZL = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void av(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bZJ.releaseEglSurface();
        for (b bVar : this.bZK) {
            bVar.release();
        }
        this.bZK.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bZK == null) {
                this.bZK = new ArrayList();
            } else {
                this.bZK.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bZK.add(new b(list.get(i2)));
                    if (list.get(i2).aaS()) {
                        this.bZL = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bZK.size() > this.bZL) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bZJ = new com.baidu.mario.gldraw2d.a.a(this.bZK.get(this.bZL).aaq(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bZJ = new com.baidu.mario.gldraw2d.a.a(this.bZK.get(this.bZL).aaq(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bZJ = new com.baidu.mario.gldraw2d.a.a(this.bZK.get(this.bZL).aaq(), (SurfaceHolder) obj);
                    }
                } else if (this.bZK != null && this.bZK != null && (bVar = this.bZK.get(this.bZL)) != null && this.bZJ != null) {
                    this.bZJ.a(bVar.aaq());
                }
            }
            for (b bVar2 : this.bZK) {
                if (this.bZJ != null) {
                    this.bZJ.b(bVar2.aaq());
                    bVar2.aap();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bZK) {
            if (this.bZJ != null) {
                this.bZJ.b(bVar.aaq());
                bVar.a(cVar);
            }
        }
    }

    public void aao() {
        if (this.bZJ != null) {
            this.bZJ.release();
            this.bZJ = null;
        }
        if (this.bZK != null) {
            for (b bVar : this.bZK) {
                bVar.release();
            }
            this.bZK.clear();
            this.bZK = null;
        }
    }

    public void bD(long j) {
        if (this.bZJ != null && this.bZK != null && this.bZK.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bZK) {
                    this.bZJ.b(bVar.aaq());
                    bVar.bE(j);
                }
                notifyAll();
            }
            this.bZJ.setPresentationTime(j);
            this.bZJ.swapBuffers();
        }
    }
}

package com.baidu.mario.gldraw2d;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.params.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    protected com.baidu.mario.gldraw2d.a.a aET;
    private List<b> aEU;
    private int aEV = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void J(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aET.releaseEglSurface();
        for (b bVar : this.aEU) {
            bVar.release();
        }
        this.aEU.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aEU == null) {
                this.aEU = new ArrayList();
            } else {
                this.aEU.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aEU.add(new b(list.get(i2)));
                    if (list.get(i2).Ak()) {
                        this.aEV = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aEU.size() > this.aEV) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aET = new com.baidu.mario.gldraw2d.a.a(this.aEU.get(this.aEV).zH(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aET = new com.baidu.mario.gldraw2d.a.a(this.aEU.get(this.aEV).zH(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aET = new com.baidu.mario.gldraw2d.a.a(this.aEU.get(this.aEV).zH(), (SurfaceHolder) obj);
                    }
                } else if (this.aEU != null && this.aEU != null && (bVar = this.aEU.get(this.aEV)) != null) {
                    this.aET.a(bVar.zH());
                }
            }
            for (b bVar2 : this.aEU) {
                if (this.aET != null) {
                    this.aET.b(bVar2.zH());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aEU) {
            if (this.aET != null) {
                this.aET.b(bVar.zH());
                bVar.a(cVar);
            }
        }
    }

    public void zG() {
        if (this.aET != null) {
            this.aET.release();
            this.aET = null;
        }
        if (this.aEU != null) {
            for (b bVar : this.aEU) {
                bVar.release();
            }
            this.aEU.clear();
            this.aEU = null;
        }
    }

    public void P(long j) {
        if (this.aET != null && this.aEU != null && this.aEU.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aEU) {
                    this.aET.b(bVar.zH());
                    bVar.Q(j);
                }
                notifyAll();
            }
            this.aET.setPresentationTime(j);
            this.aET.swapBuffers();
        }
    }
}

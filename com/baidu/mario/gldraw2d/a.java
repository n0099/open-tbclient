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
    protected com.baidu.mario.gldraw2d.a.a aIZ;
    private List<b> aJa;
    private int aJb = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void J(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aIZ.releaseEglSurface();
        for (b bVar : this.aJa) {
            bVar.release();
        }
        this.aJa.clear();
        b(null, list);
    }

    private void b(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.aJa == null) {
                this.aJa = new ArrayList();
            } else {
                this.aJa.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.aJa.add(new b(list.get(i2)));
                    if (list.get(i2).CA()) {
                        this.aJb = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.aJa.size() > this.aJb) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aIZ = new com.baidu.mario.gldraw2d.a.a(this.aJa.get(this.aJb).BX(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aIZ = new com.baidu.mario.gldraw2d.a.a(this.aJa.get(this.aJb).BX(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aIZ = new com.baidu.mario.gldraw2d.a.a(this.aJa.get(this.aJb).BX(), (SurfaceHolder) obj);
                    }
                } else if (this.aJa != null && this.aJa != null && (bVar = this.aJa.get(this.aJb)) != null) {
                    this.aIZ.a(bVar.BX());
                }
            }
            for (b bVar2 : this.aJa) {
                if (this.aIZ != null) {
                    this.aIZ.b(bVar2.BX());
                    bVar2.setupFilter();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.aJa) {
            if (this.aIZ != null) {
                this.aIZ.b(bVar.BX());
                bVar.a(cVar);
            }
        }
    }

    public void BW() {
        if (this.aIZ != null) {
            this.aIZ.release();
            this.aIZ = null;
        }
        if (this.aJa != null) {
            for (b bVar : this.aJa) {
                bVar.release();
            }
            this.aJa.clear();
            this.aJa = null;
        }
    }

    public void T(long j) {
        if (this.aIZ != null && this.aJa != null && this.aJa.size() != 0) {
            synchronized (this) {
                for (b bVar : this.aJa) {
                    this.aIZ.b(bVar.BX());
                    bVar.U(j);
                }
                notifyAll();
            }
            this.aIZ.setPresentationTime(j);
            this.aIZ.swapBuffers();
        }
    }
}

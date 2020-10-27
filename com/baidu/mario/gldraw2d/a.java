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
    protected com.baidu.mario.gldraw2d.a.a bQu;
    private List<b> bQv;
    private int bQw = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void am(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bQu.releaseEglSurface();
        for (b bVar : this.bQv) {
            bVar.release();
        }
        this.bQv.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bQv == null) {
                this.bQv = new ArrayList();
            } else {
                this.bQv.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bQv.add(new b(list.get(i2)));
                    if (list.get(i2).Wz()) {
                        this.bQw = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bQv.size() > this.bQw) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bQu = new com.baidu.mario.gldraw2d.a.a(this.bQv.get(this.bQw).VX(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bQu = new com.baidu.mario.gldraw2d.a.a(this.bQv.get(this.bQw).VX(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bQu = new com.baidu.mario.gldraw2d.a.a(this.bQv.get(this.bQw).VX(), (SurfaceHolder) obj);
                    }
                } else if (this.bQv != null && this.bQv != null && (bVar = this.bQv.get(this.bQw)) != null && this.bQu != null) {
                    this.bQu.a(bVar.VX());
                }
            }
            for (b bVar2 : this.bQv) {
                if (this.bQu != null) {
                    this.bQu.b(bVar2.VX());
                    bVar2.VW();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bQv) {
            if (this.bQu != null) {
                this.bQu.b(bVar.VX());
                bVar.a(cVar);
            }
        }
    }

    public void VV() {
        if (this.bQu != null) {
            this.bQu.release();
            this.bQu = null;
        }
        if (this.bQv != null) {
            for (b bVar : this.bQv) {
                bVar.release();
            }
            this.bQv.clear();
            this.bQv = null;
        }
    }

    public void aJ(long j) {
        if (this.bQu != null && this.bQv != null && this.bQv.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bQv) {
                    this.bQu.b(bVar.VX());
                    bVar.aK(j);
                }
                notifyAll();
            }
            this.bQu.setPresentationTime(j);
            this.bQu.swapBuffers();
        }
    }
}

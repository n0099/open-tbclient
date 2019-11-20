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
    protected com.baidu.mario.gldraw2d.a.a aww;
    private List<b> awx;
    private int awy = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void M(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.aww.releaseEglSurface();
        for (b bVar : this.awx) {
            bVar.release();
        }
        this.awx.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        if (list != null && list.size() != 0) {
            if (this.awx == null) {
                this.awx = new ArrayList();
            } else {
                this.awx.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.awx.add(new b(list.get(i2)));
                    if (list.get(i2).xZ()) {
                        this.awy = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.awx.size() > this.awy) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.aww = new com.baidu.mario.gldraw2d.a.a(this.awx.get(this.awy).xw(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.aww = new com.baidu.mario.gldraw2d.a.a(this.awx.get(this.awy).xw(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.aww = new com.baidu.mario.gldraw2d.a.a(this.awx.get(this.awy).xw(), (SurfaceHolder) obj);
                    }
                } else {
                    this.aww.a(this.awx.get(this.awy).xw());
                }
            }
            for (b bVar : this.awx) {
                this.aww.b(bVar.xw());
                bVar.xv();
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.awx) {
            this.aww.b(bVar.xw());
            bVar.a(cVar);
        }
    }

    public void xu() {
        if (this.aww != null) {
            this.aww.release();
            this.aww = null;
        }
        if (this.awx != null) {
            for (b bVar : this.awx) {
                bVar.release();
            }
            this.awx.clear();
            this.awx = null;
        }
    }

    public void L(long j) {
        if (this.aww != null && this.awx != null && this.awx.size() != 0) {
            for (b bVar : this.awx) {
                this.aww.b(bVar.xw());
                bVar.M(j);
            }
            this.aww.setPresentationTime(j);
            this.aww.swapBuffers();
        }
    }
}

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
    protected com.baidu.mario.gldraw2d.a.a bsh;
    private List<b> bsi;
    private int bsj = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void U(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.bsh.releaseEglSurface();
        for (b bVar : this.bsi) {
            bVar.release();
        }
        this.bsi.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        b bVar;
        if (list != null && list.size() != 0) {
            if (this.bsi == null) {
                this.bsi = new ArrayList();
            } else {
                this.bsi.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.bsi.add(new b(list.get(i2)));
                    if (list.get(i2).LW()) {
                        this.bsj = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.bsi.size() > this.bsj) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.bsh = new com.baidu.mario.gldraw2d.a.a(this.bsi.get(this.bsj).Lt(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.bsh = new com.baidu.mario.gldraw2d.a.a(this.bsi.get(this.bsj).Lt(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.bsh = new com.baidu.mario.gldraw2d.a.a(this.bsi.get(this.bsj).Lt(), (SurfaceHolder) obj);
                    }
                } else if (this.bsi != null && this.bsi != null && (bVar = this.bsi.get(this.bsj)) != null) {
                    this.bsh.a(bVar.Lt());
                }
            }
            for (b bVar2 : this.bsi) {
                if (this.bsh != null) {
                    this.bsh.b(bVar2.Lt());
                    bVar2.Ls();
                }
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.bsi) {
            if (this.bsh != null) {
                this.bsh.b(bVar.Lt());
                bVar.a(cVar);
            }
        }
    }

    public void Lr() {
        if (this.bsh != null) {
            this.bsh.release();
            this.bsh = null;
        }
        if (this.bsi != null) {
            for (b bVar : this.bsi) {
                bVar.release();
            }
            this.bsi.clear();
            this.bsi = null;
        }
    }

    public void aE(long j) {
        if (this.bsh != null && this.bsi != null && this.bsi.size() != 0) {
            synchronized (this) {
                for (b bVar : this.bsi) {
                    this.bsh.b(bVar.Lt());
                    bVar.aF(j);
                }
                notifyAll();
            }
            this.bsh.setPresentationTime(j);
            this.bsh.swapBuffers();
        }
    }
}

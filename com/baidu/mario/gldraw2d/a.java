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
    protected com.baidu.mario.gldraw2d.a.a acS;
    private List<b> acT;
    private int acU = 0;

    public a(Object obj, List<c> list) {
        a(obj, list);
    }

    public void n(List<c> list) {
        Log.d(TAG, "updateSurfaceDrawer !!!");
        this.acS.releaseEglSurface();
        for (b bVar : this.acT) {
            bVar.release();
        }
        this.acT.clear();
        a(null, list);
    }

    private void a(Object obj, List<c> list) {
        if (list != null && list.size() != 0) {
            if (this.acT == null) {
                this.acT = new ArrayList();
            } else {
                this.acT.clear();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                try {
                    this.acT.add(new b(list.get(i2)));
                    if (list.get(i2).sF()) {
                        this.acU = i2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
            if (this.acT.size() > this.acU) {
                if (obj != null) {
                    if (obj instanceof Surface) {
                        this.acS = new com.baidu.mario.gldraw2d.a.a(this.acT.get(this.acU).sc(), (Surface) obj, true);
                    } else if (obj instanceof SurfaceTexture) {
                        this.acS = new com.baidu.mario.gldraw2d.a.a(this.acT.get(this.acU).sc(), (SurfaceTexture) obj);
                    } else if (obj instanceof SurfaceHolder) {
                        this.acS = new com.baidu.mario.gldraw2d.a.a(this.acT.get(this.acU).sc(), (SurfaceHolder) obj);
                    }
                } else {
                    this.acS.a(this.acT.get(this.acU).sc());
                }
            }
            for (b bVar : this.acT) {
                this.acS.b(bVar.sc());
                bVar.sb();
            }
        }
    }

    public void a(com.baidu.mario.gldraw2d.c.c cVar) {
        for (b bVar : this.acT) {
            this.acS.b(bVar.sc());
            bVar.a(cVar);
        }
    }

    public void sa() {
        if (this.acS != null) {
            this.acS.release();
            this.acS = null;
        }
        if (this.acT != null) {
            for (b bVar : this.acT) {
                bVar.release();
            }
            this.acT.clear();
            this.acT = null;
        }
    }

    public void t(long j) {
        if (this.acS != null && this.acT != null && this.acT.size() != 0) {
            for (b bVar : this.acT) {
                this.acS.b(bVar.sc());
                bVar.u(j);
            }
            this.acS.setPresentationTime(j);
            this.acS.swapBuffers();
        }
    }
}

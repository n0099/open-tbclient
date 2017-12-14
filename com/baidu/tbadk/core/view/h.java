package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.c {
    protected View amO;
    protected LinearLayout amP;
    protected ImageView amQ;
    private b amR;
    private a amS;
    private c amT;
    protected AnimationDrawable amU;
    private com.baidu.tieba.b.d.a amV;
    private a.e amW;
    protected com.baidu.tieba.b.b.b amX;
    protected LinearLayout amY;
    protected FrameLayout amZ;
    private Bitmap ana;
    private Bitmap anb;
    private Bitmap anc;
    private boolean and;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aL(boolean z);
    }

    public h(Context context) {
        super(context);
        this.amO = null;
        this.amP = null;
        this.amQ = null;
        this.amR = null;
        this.amS = null;
        this.amT = null;
        this.ana = null;
        this.anb = null;
        this.anc = null;
        this.mSkinType = ExploreByTouchHelper.INVALID_ID;
        this.and = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kX() {
        this.amO = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.amP = (LinearLayout) this.amO.findViewById(d.g.pull_root);
        this.amY = (LinearLayout) this.amP.findViewById(d.g.cube_container);
        this.amZ = (FrameLayout) this.amP.findViewById(d.g.loading_cube);
        this.amQ = (ImageView) this.amO.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!vj()) {
            this.amU = af.vb().cL(skinType);
        }
        this.amQ.setBackgroundDrawable(this.amU);
        this.amW = new a.e() { // from class: com.baidu.tbadk.core.view.h.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amX = new com.baidu.tieba.b.b.b(getContext());
        dz(skinType);
        this.ana = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.anb = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.anc = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.ana == null || this.anb == null || this.anc == null) {
            af.vb().az(false);
        }
        this.amX.a(this.ana, this.ana, this.anb, this.ana, this.ana, this.ana);
        this.amV = new com.baidu.tieba.b.d.a(getContext());
        this.amV.setEGLConfigChooser(this.amW);
        this.amV.setRenderer(this.amX);
        try {
            this.amV.setRenderMode(0);
        } catch (Exception e) {
        }
        this.amZ.addView(this.amV);
        this.amX.aaP();
        wE();
        return this.amO;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kY() {
        if (vj()) {
            this.amV.setVisibility(0);
            this.amV.setRenderMode(1);
        } else if (this.amU != null && this.amQ != null) {
            this.amU.stop();
            this.amQ.setBackgroundDrawable(this.amU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.amT != null) {
            this.amT.aL(z);
        }
        wE();
        this.and = true;
        if (vj()) {
            wF();
            this.amV.requestRender();
            this.amV.onResume();
            this.amV.setRenderMode(1);
            if (z) {
                this.amX.aaR();
            }
            this.amX.aaP();
            this.amV.setVisibility(0);
        } else if (this.amU != null && this.amQ != null) {
            this.amU.stop();
            this.amQ.setBackgroundDrawable(this.amU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kZ() {
        wE();
        if (vj()) {
            if (!this.and) {
                wF();
            }
            this.amV.requestRender();
            this.amV.onResume();
            this.amV.setVisibility(0);
            this.amV.setRenderMode(1);
            this.amX.aaQ();
            this.amX.a(this.ana, this.ana, this.ana, this.ana, this.ana, this.ana);
        } else if (this.amU != null && this.amQ != null) {
            this.amU.stop();
            this.amQ.setBackgroundDrawable(this.amU);
            this.amQ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.amU != null) {
                        h.this.amU.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.and = false;
        if (vj()) {
            this.amX.a(this.ana, this.ana, this.anb, this.ana, this.ana, this.ana);
            if (this.amV != null) {
                this.amV.setRenderMode(0);
                this.amV.onPause();
            }
        } else if (this.amU != null) {
            this.amU.stop();
        }
        release();
        if (this.amS != null) {
            this.amS.b(this.amO, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.amR != null) {
            this.amR.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void la() {
        if (vj()) {
            this.amX.a(this.ana, this.ana, this.anc, this.ana, this.ana, this.ana);
            this.amX.aaR();
            this.amV.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amR = bVar;
    }

    public void a(a aVar) {
        this.amS = aVar;
    }

    public void a(c cVar) {
        this.amT = cVar;
    }

    public void dz(int i) {
        if (vj() && this.amX != null) {
            if (this.amX.apD != i) {
                this.amX.iy(aj.getColor(i, d.C0096d.cp_bg_line_c));
                this.amX.apD = i;
            }
            aj.e(this.amO, d.C0096d.cp_bg_line_c, i);
            aj.e(this.amY, d.C0096d.cp_bg_line_c, i);
            aj.e(this.amZ, d.C0096d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vj() {
        return af.vb().vj();
    }

    private void wE() {
        if (vj()) {
            if (this.amQ != null && this.amY != null) {
                if (this.amQ.getVisibility() != 8) {
                    this.amQ.setVisibility(8);
                }
                if (this.amY.getVisibility() != 0) {
                    this.amY.setVisibility(0);
                }
            }
        } else if (this.amQ != null && this.amY != null) {
            if (this.amQ.getVisibility() != 0) {
                this.amQ.setVisibility(0);
            }
            if (this.amY.getVisibility() != 8) {
                this.amY.setVisibility(8);
            }
        }
    }

    private void wF() {
        this.amV = new com.baidu.tieba.b.d.a(getContext());
        this.amV.setVisibility(4);
        this.amV.setEGLConfigChooser(this.amW);
        this.amX.a(this.ana, this.ana, this.anb, this.ana, this.ana, this.ana);
        this.amV.setRenderer(this.amX);
        this.amZ.removeAllViews();
        this.amZ.addView(this.amV);
    }

    private void release() {
        if (vj()) {
            if (this.amU != null) {
                this.amU.stop();
                this.amU = null;
                return;
            }
            return;
        }
        if (this.ana != null) {
            this.ana.recycle();
            this.ana = null;
        }
        if (this.anb != null) {
            this.anb.recycle();
            this.anb = null;
        }
        if (this.anc != null) {
            this.anc.recycle();
            this.anc = null;
        }
    }
}

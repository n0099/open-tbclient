package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
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
public class j extends com.baidu.adp.widget.ListView.c {
    protected View IY;
    protected LinearLayout bcP;
    protected ImageView bcQ;
    private b bcR;
    private a bcS;
    private c bcT;
    protected AnimationDrawable bcU;
    private com.baidu.tieba.b.d.a bcV;
    private a.e bcW;
    protected com.baidu.tieba.b.b.b bcX;
    protected LinearLayout bcY;
    protected FrameLayout bcZ;
    private Bitmap bda;
    private Bitmap bdb;
    private Bitmap bdc;
    private boolean bdd;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void i(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bw(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bx(boolean z);
    }

    public j(Context context) {
        super(context);
        this.IY = null;
        this.bcP = null;
        this.bcQ = null;
        this.bcR = null;
        this.bcS = null;
        this.bcT = null;
        this.bda = null;
        this.bdb = null;
        this.bdc = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bdd = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View st() {
        this.IY = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bcP = (LinearLayout) this.IY.findViewById(d.g.pull_root);
        this.bcY = (LinearLayout) this.bcP.findViewById(d.g.cube_container);
        this.bcZ = (FrameLayout) this.bcP.findViewById(d.g.loading_cube);
        this.bcQ = (ImageView) this.IY.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CV()) {
            this.bcU = af.CN().fI(skinType);
        }
        this.bcQ.setBackgroundDrawable(this.bcU);
        this.bcW = new a.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.bcX = new com.baidu.tieba.b.b.b(getContext());
        gx(skinType);
        this.bda = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bdb = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bdc = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bda == null || this.bdb == null || this.bdc == null) {
            af.CN().bl(false);
        }
        this.bcX.a(this.bda, this.bda, this.bdb, this.bda, this.bda, this.bda);
        this.bcV = new com.baidu.tieba.b.d.a(getContext());
        this.bcV.setEGLConfigChooser(this.bcW);
        this.bcV.setRenderer(this.bcX);
        try {
            this.bcV.setRenderMode(0);
        } catch (Exception e) {
        }
        this.bcZ.addView(this.bcV);
        this.bcX.akB();
        Ep();
        return this.IY;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void su() {
        if (CV()) {
            if (!this.bdd) {
                Eq();
                this.bcV.requestRender();
                this.bcV.onResume();
                this.bcX.akB();
            }
            this.bcV.setVisibility(0);
            this.bcV.setRenderMode(1);
        } else if (this.bcU != null && this.bcQ != null) {
            this.bcU.stop();
            this.bcQ.setBackgroundDrawable(this.bcU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aD(boolean z) {
        if (this.bcT != null) {
            this.bcT.bx(z);
        }
        Ep();
        this.bdd = true;
        if (CV()) {
            Eq();
            this.bcV.requestRender();
            this.bcV.onResume();
            this.bcV.setRenderMode(1);
            if (z) {
                this.bcX.akD();
            }
            this.bcX.akB();
            this.bcV.setVisibility(0);
        } else if (this.bcU != null && this.bcQ != null) {
            this.bcU.stop();
            this.bcQ.setBackgroundDrawable(this.bcU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sv() {
        Ep();
        if (CV()) {
            if (!this.bdd) {
                Eq();
            }
            this.bcV.requestRender();
            this.bcV.onResume();
            this.bcV.setVisibility(0);
            this.bcV.setRenderMode(1);
            this.bcX.akC();
            this.bcX.a(this.bda, this.bda, this.bda, this.bda, this.bda, this.bda);
        } else if (this.bcU != null && this.bcQ != null) {
            this.bcU.stop();
            this.bcQ.setBackgroundDrawable(this.bcU);
            this.bcQ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.bcU != null) {
                        j.this.bcU.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aE(boolean z) {
        this.bdd = false;
        if (CV()) {
            this.bcX.a(this.bda, this.bda, this.bdb, this.bda, this.bda, this.bda);
            if (this.bcV != null) {
                this.bcV.setRenderMode(0);
                this.bcV.onPause();
            }
        } else if (this.bcU != null) {
            this.bcU.stop();
        }
        release();
        if (this.bcS != null) {
            this.bcS.i(this.IY, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aF(boolean z) {
        if (this.bcR != null) {
            this.bcR.bw(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        if (CV()) {
            this.bcX.a(this.bda, this.bda, this.bdc, this.bda, this.bda, this.bda);
            this.bcX.akD();
            this.bcV.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.bcR = bVar;
    }

    public void a(a aVar) {
        this.bcS = aVar;
    }

    public void a(c cVar) {
        this.bcT = cVar;
    }

    public void gx(int i) {
        if (CV() && this.bcX != null) {
            if (this.bcX.bfL != i) {
                this.bcX.lv(aj.getColor(i, d.C0140d.cp_bg_line_c));
                this.bcX.bfL = i;
                if (this.bcV != null) {
                    this.bcV.onResume();
                }
            }
            aj.g(this.IY, d.C0140d.cp_bg_line_c, i);
            aj.g(this.bcY, d.C0140d.cp_bg_line_c, i);
            aj.g(this.bcZ, d.C0140d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CV() {
        return af.CN().CV();
    }

    private void Ep() {
        if (CV()) {
            if (this.bcQ != null && this.bcY != null) {
                if (this.bcQ.getVisibility() != 8) {
                    this.bcQ.setVisibility(8);
                }
                if (this.bcY.getVisibility() != 0) {
                    this.bcY.setVisibility(0);
                }
            }
        } else if (this.bcQ != null && this.bcY != null) {
            if (this.bcQ.getVisibility() != 0) {
                this.bcQ.setVisibility(0);
            }
            if (this.bcY.getVisibility() != 8) {
                this.bcY.setVisibility(8);
            }
        }
    }

    private void Eq() {
        this.bcV = new com.baidu.tieba.b.d.a(getContext());
        this.bcV.setVisibility(4);
        this.bcV.setEGLConfigChooser(this.bcW);
        this.bcX.a(this.bda, this.bda, this.bdb, this.bda, this.bda, this.bda);
        this.bcV.setRenderer(this.bcX);
        this.bcZ.removeAllViews();
        this.bcZ.addView(this.bcV);
    }

    private void release() {
        if (CV()) {
            if (this.bcU != null) {
                this.bcU.stop();
                this.bcU = null;
                return;
            }
            return;
        }
        if (this.bda != null) {
            this.bda.recycle();
            this.bda = null;
        }
        if (this.bdb != null) {
            this.bdb.recycle();
            this.bdb = null;
        }
        if (this.bdc != null) {
            this.bdc.recycle();
            this.bdc = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sA() {
        return 2000L;
    }
}

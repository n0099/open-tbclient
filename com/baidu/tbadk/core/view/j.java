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
    protected View IS;
    protected LinearLayout bcD;
    protected ImageView bcE;
    private b bcF;
    private a bcG;
    private c bcH;
    protected AnimationDrawable bcI;
    private com.baidu.tieba.b.d.a bcJ;
    private a.e bcK;
    protected com.baidu.tieba.b.b.b bcL;
    protected LinearLayout bcM;
    protected FrameLayout bcN;
    private Bitmap bcO;
    private Bitmap bcP;
    private Bitmap bcQ;
    private boolean bcR;
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
        this.IS = null;
        this.bcD = null;
        this.bcE = null;
        this.bcF = null;
        this.bcG = null;
        this.bcH = null;
        this.bcO = null;
        this.bcP = null;
        this.bcQ = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bcR = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View st() {
        this.IS = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bcD = (LinearLayout) this.IS.findViewById(d.g.pull_root);
        this.bcM = (LinearLayout) this.bcD.findViewById(d.g.cube_container);
        this.bcN = (FrameLayout) this.bcD.findViewById(d.g.loading_cube);
        this.bcE = (ImageView) this.IS.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CU()) {
            this.bcI = af.CM().fI(skinType);
        }
        this.bcE.setBackgroundDrawable(this.bcI);
        this.bcK = new a.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.bcL = new com.baidu.tieba.b.b.b(getContext());
        gx(skinType);
        this.bcO = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bcP = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bcQ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bcO == null || this.bcP == null || this.bcQ == null) {
            af.CM().bl(false);
        }
        this.bcL.a(this.bcO, this.bcO, this.bcP, this.bcO, this.bcO, this.bcO);
        this.bcJ = new com.baidu.tieba.b.d.a(getContext());
        this.bcJ.setEGLConfigChooser(this.bcK);
        this.bcJ.setRenderer(this.bcL);
        try {
            this.bcJ.setRenderMode(0);
        } catch (Exception e) {
        }
        this.bcN.addView(this.bcJ);
        this.bcL.akA();
        Eo();
        return this.IS;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void su() {
        if (CU()) {
            if (!this.bcR) {
                Ep();
                this.bcJ.requestRender();
                this.bcJ.onResume();
                this.bcL.akA();
            }
            this.bcJ.setVisibility(0);
            this.bcJ.setRenderMode(1);
        } else if (this.bcI != null && this.bcE != null) {
            this.bcI.stop();
            this.bcE.setBackgroundDrawable(this.bcI.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aD(boolean z) {
        if (this.bcH != null) {
            this.bcH.bx(z);
        }
        Eo();
        this.bcR = true;
        if (CU()) {
            Ep();
            this.bcJ.requestRender();
            this.bcJ.onResume();
            this.bcJ.setRenderMode(1);
            if (z) {
                this.bcL.akC();
            }
            this.bcL.akA();
            this.bcJ.setVisibility(0);
        } else if (this.bcI != null && this.bcE != null) {
            this.bcI.stop();
            this.bcE.setBackgroundDrawable(this.bcI.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sv() {
        Eo();
        if (CU()) {
            if (!this.bcR) {
                Ep();
            }
            this.bcJ.requestRender();
            this.bcJ.onResume();
            this.bcJ.setVisibility(0);
            this.bcJ.setRenderMode(1);
            this.bcL.akB();
            this.bcL.a(this.bcO, this.bcO, this.bcO, this.bcO, this.bcO, this.bcO);
        } else if (this.bcI != null && this.bcE != null) {
            this.bcI.stop();
            this.bcE.setBackgroundDrawable(this.bcI);
            this.bcE.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.bcI != null) {
                        j.this.bcI.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aE(boolean z) {
        this.bcR = false;
        if (CU()) {
            this.bcL.a(this.bcO, this.bcO, this.bcP, this.bcO, this.bcO, this.bcO);
            if (this.bcJ != null) {
                this.bcJ.setRenderMode(0);
                this.bcJ.onPause();
            }
        } else if (this.bcI != null) {
            this.bcI.stop();
        }
        release();
        if (this.bcG != null) {
            this.bcG.i(this.IS, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aF(boolean z) {
        if (this.bcF != null) {
            this.bcF.bw(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        if (CU()) {
            this.bcL.a(this.bcO, this.bcO, this.bcQ, this.bcO, this.bcO, this.bcO);
            this.bcL.akC();
            this.bcJ.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.bcF = bVar;
    }

    public void a(a aVar) {
        this.bcG = aVar;
    }

    public void a(c cVar) {
        this.bcH = cVar;
    }

    public void gx(int i) {
        if (CU() && this.bcL != null) {
            if (this.bcL.bfz != i) {
                this.bcL.lv(aj.getColor(i, d.C0141d.cp_bg_line_c));
                this.bcL.bfz = i;
                if (this.bcJ != null) {
                    this.bcJ.onResume();
                }
            }
            aj.g(this.IS, d.C0141d.cp_bg_line_c, i);
            aj.g(this.bcM, d.C0141d.cp_bg_line_c, i);
            aj.g(this.bcN, d.C0141d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CU() {
        return af.CM().CU();
    }

    private void Eo() {
        if (CU()) {
            if (this.bcE != null && this.bcM != null) {
                if (this.bcE.getVisibility() != 8) {
                    this.bcE.setVisibility(8);
                }
                if (this.bcM.getVisibility() != 0) {
                    this.bcM.setVisibility(0);
                }
            }
        } else if (this.bcE != null && this.bcM != null) {
            if (this.bcE.getVisibility() != 0) {
                this.bcE.setVisibility(0);
            }
            if (this.bcM.getVisibility() != 8) {
                this.bcM.setVisibility(8);
            }
        }
    }

    private void Ep() {
        this.bcJ = new com.baidu.tieba.b.d.a(getContext());
        this.bcJ.setVisibility(4);
        this.bcJ.setEGLConfigChooser(this.bcK);
        this.bcL.a(this.bcO, this.bcO, this.bcP, this.bcO, this.bcO, this.bcO);
        this.bcJ.setRenderer(this.bcL);
        this.bcN.removeAllViews();
        this.bcN.addView(this.bcJ);
    }

    private void release() {
        if (CU()) {
            if (this.bcI != null) {
                this.bcI.stop();
                this.bcI = null;
                return;
            }
            return;
        }
        if (this.bcO != null) {
            this.bcO.recycle();
            this.bcO = null;
        }
        if (this.bcP != null) {
            this.bcP.recycle();
            this.bcP = null;
        }
        if (this.bcQ != null) {
            this.bcQ.recycle();
            this.bcQ = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sA() {
        return 2000L;
    }
}

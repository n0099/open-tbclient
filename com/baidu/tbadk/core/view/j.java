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
    protected LinearLayout bcF;
    protected ImageView bcG;
    private b bcH;
    private a bcI;
    private c bcJ;
    protected AnimationDrawable bcK;
    private com.baidu.tieba.b.d.a bcL;
    private a.e bcM;
    protected com.baidu.tieba.b.b.b bcN;
    protected LinearLayout bcO;
    protected FrameLayout bcP;
    private Bitmap bcQ;
    private Bitmap bcR;
    private Bitmap bcS;
    private boolean bcT;
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
        this.bcF = null;
        this.bcG = null;
        this.bcH = null;
        this.bcI = null;
        this.bcJ = null;
        this.bcQ = null;
        this.bcR = null;
        this.bcS = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bcT = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View st() {
        this.IS = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.bcF = (LinearLayout) this.IS.findViewById(d.g.pull_root);
        this.bcO = (LinearLayout) this.bcF.findViewById(d.g.cube_container);
        this.bcP = (FrameLayout) this.bcF.findViewById(d.g.loading_cube);
        this.bcG = (ImageView) this.IS.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CV()) {
            this.bcK = af.CN().fI(skinType);
        }
        this.bcG.setBackgroundDrawable(this.bcK);
        this.bcM = new a.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.bcN = new com.baidu.tieba.b.b.b(getContext());
        gx(skinType);
        this.bcQ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bcR = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bcS = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bcQ == null || this.bcR == null || this.bcS == null) {
            af.CN().bl(false);
        }
        this.bcN.a(this.bcQ, this.bcQ, this.bcR, this.bcQ, this.bcQ, this.bcQ);
        this.bcL = new com.baidu.tieba.b.d.a(getContext());
        this.bcL.setEGLConfigChooser(this.bcM);
        this.bcL.setRenderer(this.bcN);
        try {
            this.bcL.setRenderMode(0);
        } catch (Exception e) {
        }
        this.bcP.addView(this.bcL);
        this.bcN.akB();
        Ep();
        return this.IS;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void su() {
        if (CV()) {
            if (!this.bcT) {
                Eq();
                this.bcL.requestRender();
                this.bcL.onResume();
                this.bcN.akB();
            }
            this.bcL.setVisibility(0);
            this.bcL.setRenderMode(1);
        } else if (this.bcK != null && this.bcG != null) {
            this.bcK.stop();
            this.bcG.setBackgroundDrawable(this.bcK.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aD(boolean z) {
        if (this.bcJ != null) {
            this.bcJ.bx(z);
        }
        Ep();
        this.bcT = true;
        if (CV()) {
            Eq();
            this.bcL.requestRender();
            this.bcL.onResume();
            this.bcL.setRenderMode(1);
            if (z) {
                this.bcN.akD();
            }
            this.bcN.akB();
            this.bcL.setVisibility(0);
        } else if (this.bcK != null && this.bcG != null) {
            this.bcK.stop();
            this.bcG.setBackgroundDrawable(this.bcK.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sv() {
        Ep();
        if (CV()) {
            if (!this.bcT) {
                Eq();
            }
            this.bcL.requestRender();
            this.bcL.onResume();
            this.bcL.setVisibility(0);
            this.bcL.setRenderMode(1);
            this.bcN.akC();
            this.bcN.a(this.bcQ, this.bcQ, this.bcQ, this.bcQ, this.bcQ, this.bcQ);
        } else if (this.bcK != null && this.bcG != null) {
            this.bcK.stop();
            this.bcG.setBackgroundDrawable(this.bcK);
            this.bcG.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.bcK != null) {
                        j.this.bcK.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aE(boolean z) {
        this.bcT = false;
        if (CV()) {
            this.bcN.a(this.bcQ, this.bcQ, this.bcR, this.bcQ, this.bcQ, this.bcQ);
            if (this.bcL != null) {
                this.bcL.setRenderMode(0);
                this.bcL.onPause();
            }
        } else if (this.bcK != null) {
            this.bcK.stop();
        }
        release();
        if (this.bcI != null) {
            this.bcI.i(this.IS, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aF(boolean z) {
        if (this.bcH != null) {
            this.bcH.bw(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        if (CV()) {
            this.bcN.a(this.bcQ, this.bcQ, this.bcS, this.bcQ, this.bcQ, this.bcQ);
            this.bcN.akD();
            this.bcL.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.bcH = bVar;
    }

    public void a(a aVar) {
        this.bcI = aVar;
    }

    public void a(c cVar) {
        this.bcJ = cVar;
    }

    public void gx(int i) {
        if (CV() && this.bcN != null) {
            if (this.bcN.bfC != i) {
                this.bcN.lv(aj.getColor(i, d.C0141d.cp_bg_line_c));
                this.bcN.bfC = i;
                if (this.bcL != null) {
                    this.bcL.onResume();
                }
            }
            aj.g(this.IS, d.C0141d.cp_bg_line_c, i);
            aj.g(this.bcO, d.C0141d.cp_bg_line_c, i);
            aj.g(this.bcP, d.C0141d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CV() {
        return af.CN().CV();
    }

    private void Ep() {
        if (CV()) {
            if (this.bcG != null && this.bcO != null) {
                if (this.bcG.getVisibility() != 8) {
                    this.bcG.setVisibility(8);
                }
                if (this.bcO.getVisibility() != 0) {
                    this.bcO.setVisibility(0);
                }
            }
        } else if (this.bcG != null && this.bcO != null) {
            if (this.bcG.getVisibility() != 0) {
                this.bcG.setVisibility(0);
            }
            if (this.bcO.getVisibility() != 8) {
                this.bcO.setVisibility(8);
            }
        }
    }

    private void Eq() {
        this.bcL = new com.baidu.tieba.b.d.a(getContext());
        this.bcL.setVisibility(4);
        this.bcL.setEGLConfigChooser(this.bcM);
        this.bcN.a(this.bcQ, this.bcQ, this.bcR, this.bcQ, this.bcQ, this.bcQ);
        this.bcL.setRenderer(this.bcN);
        this.bcP.removeAllViews();
        this.bcP.addView(this.bcL);
    }

    private void release() {
        if (CV()) {
            if (this.bcK != null) {
                this.bcK.stop();
                this.bcK = null;
                return;
            }
            return;
        }
        if (this.bcQ != null) {
            this.bcQ.recycle();
            this.bcQ = null;
        }
        if (this.bcR != null) {
            this.bcR.recycle();
            this.bcR = null;
        }
        if (this.bcS != null) {
            this.bcS.recycle();
            this.bcS = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sA() {
        return 2000L;
    }
}

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.d {
    protected View agA;
    protected LinearLayout agB;
    protected ImageView agC;
    private b agD;
    private a agE;
    private c agF;
    protected AnimationDrawable agG;
    private com.baidu.tieba.b.d.a agH;
    private a.e agI;
    protected com.baidu.tieba.b.b.b agJ;
    protected LinearLayout agK;
    protected FrameLayout agL;
    private Bitmap agM;
    private Bitmap agN;
    private Bitmap agO;
    private boolean agP;

    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aI(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJ(boolean z);
    }

    public y(Context context) {
        super(context);
        this.agA = null;
        this.agB = null;
        this.agC = null;
        this.agD = null;
        this.agE = null;
        this.agF = null;
        this.agM = null;
        this.agN = null;
        this.agO = null;
        this.agP = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View kk() {
        this.agA = LayoutInflater.from(getContext()).inflate(r.h.tb_pull_view, (ViewGroup) null);
        this.agB = (LinearLayout) this.agA.findViewById(r.g.pull_root);
        this.agK = (LinearLayout) this.agB.findViewById(r.g.cube_container);
        this.agL = (FrameLayout) this.agB.findViewById(r.g.loading_cube);
        this.agC = (ImageView) this.agA.findViewById(r.g.pull_image);
        if (!vp()) {
            this.agG = com.baidu.tbadk.core.util.am.vh().cH(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.agC.setBackgroundDrawable(this.agG);
        this.agI = new z(this);
        this.agJ = new com.baidu.tieba.b.b.b(getContext());
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.agM = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.cube_top);
        this.agN = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_arrow);
        this.agO = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_ok);
        if (this.agM == null || this.agN == null || this.agO == null) {
            com.baidu.tbadk.core.util.am.vh().aA(false);
        }
        this.agJ.a(this.agM, this.agM, this.agN, this.agM, this.agM, this.agM);
        this.agH = new com.baidu.tieba.b.d.a(getContext());
        this.agH.setEGLConfigChooser(this.agI);
        this.agH.setRenderer(this.agJ);
        try {
            this.agH.setRenderMode(0);
        } catch (Exception e) {
        }
        this.agL.addView(this.agH);
        this.agJ.Nd();
        wJ();
        return this.agA;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kl() {
        if (vp()) {
            this.agH.setVisibility(0);
            this.agH.setRenderMode(1);
        } else if (this.agG != null && this.agC != null) {
            this.agG.stop();
            this.agC.setBackgroundDrawable(this.agG.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.agF != null) {
            this.agF.aJ(z);
        }
        wJ();
        this.agP = true;
        if (vp()) {
            wK();
            this.agH.requestRender();
            this.agH.onResume();
            this.agH.setRenderMode(1);
            if (z) {
                this.agJ.Nf();
            }
            this.agJ.Nd();
            this.agH.setVisibility(0);
        } else if (this.agG != null && this.agC != null) {
            this.agG.stop();
            this.agC.setBackgroundDrawable(this.agG.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void km() {
        wJ();
        if (vp()) {
            if (!this.agP) {
                wK();
            }
            this.agH.requestRender();
            this.agH.onResume();
            this.agH.setVisibility(0);
            this.agH.setRenderMode(1);
            this.agJ.Ne();
            this.agJ.a(this.agM, this.agM, this.agM, this.agM, this.agM, this.agM);
        } else if (this.agG != null && this.agC != null) {
            this.agG.stop();
            this.agC.setBackgroundDrawable(this.agG);
            this.agC.post(new aa(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agP = false;
        if (vp()) {
            this.agJ.a(this.agM, this.agM, this.agN, this.agM, this.agM, this.agM);
            if (this.agH != null) {
                this.agH.setRenderMode(0);
                this.agH.onPause();
            }
        } else if (this.agG != null) {
            this.agG.stop();
        }
        release();
        if (this.agE != null) {
            this.agE.F(this.agA);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.agD != null) {
            this.agD.aI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kn() {
        if (vp()) {
            this.agJ.a(this.agM, this.agM, this.agO, this.agM, this.agM, this.agM);
            this.agJ.Nf();
            this.agH.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.agD = bVar;
    }

    public void a(a aVar) {
        this.agE = aVar;
    }

    public void a(c cVar) {
        this.agF = cVar;
    }

    public void dh(int i) {
        if (vp() && this.agJ != null) {
            if (this.agJ.ahV != i) {
                this.agJ.gd(av.getColor(r.d.cp_bg_line_c));
                this.agJ.ahV = i;
            }
            av.l(this.agA, r.d.cp_bg_line_c);
            av.l(this.agK, r.d.cp_bg_line_c);
            av.l(this.agL, r.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vp() {
        return com.baidu.tbadk.core.util.am.vh().vp();
    }

    private void wJ() {
        if (vp()) {
            if (this.agC != null && this.agK != null) {
                if (this.agC.getVisibility() != 8) {
                    this.agC.setVisibility(8);
                }
                if (this.agK.getVisibility() != 0) {
                    this.agK.setVisibility(0);
                }
            }
        } else if (this.agC != null && this.agK != null) {
            if (this.agC.getVisibility() != 0) {
                this.agC.setVisibility(0);
            }
            if (this.agK.getVisibility() != 8) {
                this.agK.setVisibility(8);
            }
        }
    }

    private void wK() {
        this.agH = new com.baidu.tieba.b.d.a(getContext());
        this.agH.setVisibility(4);
        this.agH.setEGLConfigChooser(this.agI);
        this.agJ.a(this.agM, this.agM, this.agN, this.agM, this.agM, this.agM);
        this.agH.setRenderer(this.agJ);
        this.agL.removeAllViews();
        this.agL.addView(this.agH);
    }

    private void release() {
        if (vp()) {
            if (this.agG != null) {
                this.agG.stop();
                this.agG = null;
                return;
            }
            return;
        }
        if (this.agM != null) {
            this.agM.recycle();
            this.agM = null;
        }
        if (this.agN != null) {
            this.agN.recycle();
            this.agN = null;
        }
        if (this.agO != null) {
            this.agO.recycle();
            this.agO = null;
        }
    }
}

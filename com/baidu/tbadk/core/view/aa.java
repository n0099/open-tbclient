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
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.widget.ListView.d {
    protected View afF;
    protected LinearLayout afG;
    protected ImageView afH;
    private b afI;
    private a afJ;
    private c afK;
    protected AnimationDrawable afL;
    private com.baidu.tieba.b.d.a afM;
    private a.e afN;
    protected com.baidu.tieba.b.b.b afO;
    protected LinearLayout afP;
    protected FrameLayout afQ;
    private Bitmap afR;
    private Bitmap afS;
    private Bitmap afT;
    private boolean afU;

    /* loaded from: classes.dex */
    public interface a {
        void D(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aN(boolean z);
    }

    public aa(Context context) {
        super(context);
        this.afF = null;
        this.afG = null;
        this.afH = null;
        this.afI = null;
        this.afJ = null;
        this.afK = null;
        this.afR = null;
        this.afS = null;
        this.afT = null;
        this.afU = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View kg() {
        this.afF = LayoutInflater.from(getContext()).inflate(r.j.tb_pull_view, (ViewGroup) null);
        this.afG = (LinearLayout) this.afF.findViewById(r.h.pull_root);
        this.afP = (LinearLayout) this.afG.findViewById(r.h.cube_container);
        this.afQ = (FrameLayout) this.afG.findViewById(r.h.loading_cube);
        this.afH = (ImageView) this.afF.findViewById(r.h.pull_image);
        if (!uX()) {
            this.afL = com.baidu.tbadk.core.util.ah.uP().cJ(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.afH.setBackgroundDrawable(this.afL);
        this.afN = new ab(this);
        this.afO = new com.baidu.tieba.b.b.b(getContext());
        dl(TbadkCoreApplication.m9getInst().getSkinType());
        this.afR = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.g.cube_top);
        this.afS = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.g.btn_frs_post_arrow);
        this.afT = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.g.btn_frs_post_ok);
        if (this.afR == null || this.afS == null || this.afT == null) {
            com.baidu.tbadk.core.util.ah.uP().aE(false);
        }
        this.afO.a(this.afR, this.afR, this.afS, this.afR, this.afR, this.afR);
        this.afM = new com.baidu.tieba.b.d.a(getContext());
        this.afM.setEGLConfigChooser(this.afN);
        this.afM.setRenderer(this.afO);
        try {
            this.afM.setRenderMode(0);
        } catch (Exception e) {
        }
        this.afQ.addView(this.afM);
        this.afO.Qi();
        wu();
        return this.afF;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kh() {
        if (uX()) {
            this.afM.setVisibility(0);
            this.afM.setRenderMode(1);
        } else if (this.afL != null && this.afH != null) {
            this.afL.stop();
            this.afH.setBackgroundDrawable(this.afL.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.afK != null) {
            this.afK.aN(z);
        }
        wu();
        this.afU = true;
        if (uX()) {
            wv();
            this.afM.requestRender();
            this.afM.onResume();
            this.afM.setRenderMode(1);
            if (z) {
                this.afO.Qk();
            }
            this.afO.Qi();
            this.afM.setVisibility(0);
        } else if (this.afL != null && this.afH != null) {
            this.afL.stop();
            this.afH.setBackgroundDrawable(this.afL.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void ki() {
        wu();
        if (uX()) {
            if (!this.afU) {
                wv();
            }
            this.afM.requestRender();
            this.afM.onResume();
            this.afM.setVisibility(0);
            this.afM.setRenderMode(1);
            this.afO.Qj();
            this.afO.a(this.afR, this.afR, this.afR, this.afR, this.afR, this.afR);
        } else if (this.afL != null && this.afH != null) {
            this.afL.stop();
            this.afH.setBackgroundDrawable(this.afL);
            this.afH.post(new ac(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afU = false;
        if (uX()) {
            this.afO.a(this.afR, this.afR, this.afS, this.afR, this.afR, this.afR);
            if (this.afM != null) {
                this.afM.setRenderMode(0);
                this.afM.onPause();
            }
        } else if (this.afL != null) {
            this.afL.stop();
        }
        release();
        if (this.afJ != null) {
            this.afJ.D(this.afF);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.afI != null) {
            this.afI.aM(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kj() {
        if (uX()) {
            this.afO.a(this.afR, this.afR, this.afT, this.afR, this.afR, this.afR);
            this.afO.Qk();
            this.afM.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.afI = bVar;
    }

    public void a(a aVar) {
        this.afJ = aVar;
    }

    public void a(c cVar) {
        this.afK = cVar;
    }

    public void dl(int i) {
        if (uX() && this.afO != null) {
            if (this.afO.ahp != i) {
                this.afO.gB(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_bg_line_c));
                this.afO.ahp = i;
            }
            com.baidu.tbadk.core.util.ap.k(this.afF, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.k(this.afP, r.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.k(this.afQ, r.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uX() {
        return com.baidu.tbadk.core.util.ah.uP().uX();
    }

    private void wu() {
        if (uX()) {
            if (this.afH != null && this.afP != null) {
                if (this.afH.getVisibility() != 8) {
                    this.afH.setVisibility(8);
                }
                if (this.afP.getVisibility() != 0) {
                    this.afP.setVisibility(0);
                }
            }
        } else if (this.afH != null && this.afP != null) {
            if (this.afH.getVisibility() != 0) {
                this.afH.setVisibility(0);
            }
            if (this.afP.getVisibility() != 8) {
                this.afP.setVisibility(8);
            }
        }
    }

    private void wv() {
        this.afM = new com.baidu.tieba.b.d.a(getContext());
        this.afM.setVisibility(4);
        this.afM.setEGLConfigChooser(this.afN);
        this.afO.a(this.afR, this.afR, this.afS, this.afR, this.afR, this.afR);
        this.afM.setRenderer(this.afO);
        this.afQ.removeAllViews();
        this.afQ.addView(this.afM);
    }

    private void release() {
        if (uX()) {
            if (this.afL != null) {
                this.afL.stop();
                this.afL = null;
                return;
            }
            return;
        }
        if (this.afR != null) {
            this.afR.recycle();
            this.afR = null;
        }
        if (this.afS != null) {
            this.afS.recycle();
            this.afS = null;
        }
        if (this.afT != null) {
            this.afT.recycle();
            this.afT = null;
        }
    }
}

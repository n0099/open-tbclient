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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.d {
    protected View acA;
    protected LinearLayout acB;
    protected ImageView acC;
    private b acD;
    private c acE;
    private a acF;
    private d acG;
    protected AnimationDrawable acH;
    private com.baidu.tieba.b.d.a acI;
    private a.e acJ;
    protected com.baidu.tieba.b.b.b acK;
    protected LinearLayout acL;
    protected FrameLayout acM;
    private Bitmap acN;
    private Bitmap acO;
    private Bitmap acP;
    private boolean acQ;

    /* loaded from: classes.dex */
    public interface a {
        void E(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aE(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aF(boolean z);
    }

    public t(Context context) {
        super(context);
        this.acA = null;
        this.acB = null;
        this.acC = null;
        this.acD = null;
        this.acE = null;
        this.acN = null;
        this.acO = null;
        this.acP = null;
        this.acQ = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View jq() {
        this.acA = LayoutInflater.from(getContext()).inflate(u.h.tb_pull_view, (ViewGroup) null);
        this.acB = (LinearLayout) this.acA.findViewById(u.g.pull_root);
        this.acL = (LinearLayout) this.acB.findViewById(u.g.cube_container);
        this.acM = (FrameLayout) this.acB.findViewById(u.g.loading_cube);
        this.acC = (ImageView) this.acA.findViewById(u.g.pull_image);
        if (!tV()) {
            this.acH = com.baidu.tbadk.core.util.am.tN().cu(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.acC.setBackgroundDrawable(this.acH);
        this.acJ = new u(this);
        this.acK = new com.baidu.tieba.b.b.b(getContext());
        cT(TbadkCoreApplication.m9getInst().getSkinType());
        this.acN = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.cube_top);
        this.acO = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.btn_frs_post_arrow);
        this.acP = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.btn_frs_post_ok);
        if (this.acN == null || this.acO == null || this.acP == null) {
            com.baidu.tbadk.core.util.am.tN().aw(false);
        }
        this.acK.a(this.acN, this.acN, this.acO, this.acN, this.acN, this.acN);
        this.acI = new com.baidu.tieba.b.d.a(getContext());
        this.acI.setEGLConfigChooser(this.acJ);
        this.acI.setRenderer(this.acK);
        try {
            this.acI.setRenderMode(0);
        } catch (Exception e) {
        }
        this.acM.addView(this.acI);
        this.acK.Kb();
        vo();
        return this.acA;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jr() {
        if (tV()) {
            this.acI.setVisibility(0);
            this.acI.setRenderMode(1);
        } else if (this.acH != null && this.acC != null) {
            this.acH.stop();
            this.acC.setBackgroundDrawable(this.acH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        if (this.acG != null) {
            this.acG.aF(z);
        }
        vo();
        this.acQ = true;
        if (tV()) {
            vp();
            this.acI.requestRender();
            this.acI.onResume();
            this.acI.setRenderMode(1);
            if (z) {
                this.acK.Kd();
            }
            this.acK.Kb();
            this.acI.setVisibility(0);
        } else if (this.acH != null && this.acC != null) {
            this.acH.stop();
            this.acC.setBackgroundDrawable(this.acH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void js() {
        vo();
        if (tV()) {
            if (!this.acQ) {
                vp();
            }
            this.acI.requestRender();
            this.acI.onResume();
            this.acI.setVisibility(0);
            this.acI.setRenderMode(1);
            this.acK.Kc();
            this.acK.a(this.acN, this.acN, this.acN, this.acN, this.acN, this.acN);
        } else if (this.acH != null && this.acC != null) {
            this.acH.stop();
            this.acC.setBackgroundDrawable(this.acH);
            this.acC.post(new v(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.acQ = false;
        if (tV()) {
            this.acK.a(this.acN, this.acN, this.acO, this.acN, this.acN, this.acN);
            if (this.acI != null) {
                this.acI.setRenderMode(0);
                this.acI.onPause();
            }
        } else if (this.acH != null) {
            this.acH.stop();
        }
        release();
        if (this.acF != null) {
            this.acF.E(this.acA);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        if (this.acD != null) {
            this.acD.aE(z);
        }
        if (this.acE != null) {
            this.acE.b(this.acA, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jt() {
        if (tV()) {
            this.acK.a(this.acN, this.acN, this.acP, this.acN, this.acN, this.acN);
            this.acK.Kd();
            this.acI.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.acD = bVar;
    }

    public void a(c cVar) {
        this.acE = cVar;
    }

    public void a(a aVar) {
        this.acF = aVar;
    }

    public void a(d dVar) {
        this.acG = dVar;
    }

    public void cT(int i) {
        if (tV() && this.acK != null) {
            if (this.acK.aeK != i) {
                this.acK.fB(av.getColor(u.d.cp_bg_line_c));
                this.acK.aeK = i;
            }
            av.l(this.acA, u.d.cp_bg_line_c);
            av.l(this.acL, u.d.cp_bg_line_c);
            av.l(this.acM, u.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tV() {
        return com.baidu.tbadk.core.util.am.tN().tV();
    }

    private void vo() {
        if (tV()) {
            if (this.acC != null && this.acL != null) {
                if (this.acC.getVisibility() != 8) {
                    this.acC.setVisibility(8);
                }
                if (this.acL.getVisibility() != 0) {
                    this.acL.setVisibility(0);
                }
            }
        } else if (this.acC != null && this.acL != null) {
            if (this.acC.getVisibility() != 0) {
                this.acC.setVisibility(0);
            }
            if (this.acL.getVisibility() != 8) {
                this.acL.setVisibility(8);
            }
        }
    }

    private void vp() {
        this.acI = new com.baidu.tieba.b.d.a(getContext());
        this.acI.setVisibility(4);
        this.acI.setEGLConfigChooser(this.acJ);
        this.acK.a(this.acN, this.acN, this.acO, this.acN, this.acN, this.acN);
        this.acI.setRenderer(this.acK);
        this.acM.removeAllViews();
        this.acM.addView(this.acI);
    }

    private void release() {
        if (tV()) {
            if (this.acH != null) {
                this.acH.stop();
                this.acH = null;
                return;
            }
            return;
        }
        if (this.acN != null) {
            this.acN.recycle();
            this.acN = null;
        }
        if (this.acO != null) {
            this.acO.recycle();
            this.acO = null;
        }
        if (this.acP != null) {
            this.acP.recycle();
            this.acP = null;
        }
    }
}

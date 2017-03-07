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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.widget.ListView.d {
    protected View akX;
    protected LinearLayout akY;
    protected ImageView akZ;
    private b ala;
    private a alb;
    private c alc;
    protected AnimationDrawable ald;
    private com.baidu.tieba.b.d.a ale;
    private a.e alf;
    protected com.baidu.tieba.b.b.b alg;
    protected LinearLayout alh;
    protected FrameLayout ali;
    private Bitmap alj;
    private Bitmap alk;
    private Bitmap alm;
    private boolean aln;

    /* loaded from: classes.dex */
    public interface a {
        void B(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aM(boolean z);
    }

    public ab(Context context) {
        super(context);
        this.akX = null;
        this.akY = null;
        this.akZ = null;
        this.ala = null;
        this.alb = null;
        this.alc = null;
        this.alj = null;
        this.alk = null;
        this.alm = null;
        this.aln = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View la() {
        this.akX = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.akY = (LinearLayout) this.akX.findViewById(w.h.pull_root);
        this.alh = (LinearLayout) this.akY.findViewById(w.h.cube_container);
        this.ali = (FrameLayout) this.akY.findViewById(w.h.loading_cube);
        this.akZ = (ImageView) this.akX.findViewById(w.h.pull_image);
        if (!vu()) {
            this.ald = com.baidu.tbadk.core.util.ai.vm().cF(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.akZ.setBackgroundDrawable(this.ald);
        this.alf = new ac(this);
        this.alg = new com.baidu.tieba.b.b.b(getContext());
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.alj = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alk = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.alm = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.alj == null || this.alk == null || this.alm == null) {
            com.baidu.tbadk.core.util.ai.vm().aD(false);
        }
        this.alg.a(this.alj, this.alj, this.alk, this.alj, this.alj, this.alj);
        this.ale = new com.baidu.tieba.b.d.a(getContext());
        this.ale.setEGLConfigChooser(this.alf);
        this.ale.setRenderer(this.alg);
        try {
            this.ale.setRenderMode(0);
        } catch (Exception e) {
        }
        this.ali.addView(this.ale);
        this.alg.Rb();
        wR();
        return this.akX;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lb() {
        if (vu()) {
            this.ale.setVisibility(0);
            this.ale.setRenderMode(1);
        } else if (this.ald != null && this.akZ != null) {
            this.ald.stop();
            this.akZ.setBackgroundDrawable(this.ald.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.alc != null) {
            this.alc.aM(z);
        }
        wR();
        this.aln = true;
        if (vu()) {
            wS();
            this.ale.requestRender();
            this.ale.onResume();
            this.ale.setRenderMode(1);
            if (z) {
                this.alg.Rd();
            }
            this.alg.Rb();
            this.ale.setVisibility(0);
        } else if (this.ald != null && this.akZ != null) {
            this.ald.stop();
            this.akZ.setBackgroundDrawable(this.ald.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lc() {
        wR();
        if (vu()) {
            if (!this.aln) {
                wS();
            }
            this.ale.requestRender();
            this.ale.onResume();
            this.ale.setVisibility(0);
            this.ale.setRenderMode(1);
            this.alg.Rc();
            this.alg.a(this.alj, this.alj, this.alj, this.alj, this.alj, this.alj);
        } else if (this.ald != null && this.akZ != null) {
            this.ald.stop();
            this.akZ.setBackgroundDrawable(this.ald);
            this.akZ.post(new ad(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.aln = false;
        if (vu()) {
            this.alg.a(this.alj, this.alj, this.alk, this.alj, this.alj, this.alj);
            if (this.ale != null) {
                this.ale.setRenderMode(0);
                this.ale.onPause();
            }
        } else if (this.ald != null) {
            this.ald.stop();
        }
        release();
        if (this.alb != null) {
            this.alb.B(this.akX);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.ala != null) {
            this.ala.aL(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void ld() {
        if (vu()) {
            this.alg.a(this.alj, this.alj, this.alm, this.alj, this.alj, this.alj);
            this.alg.Rd();
            this.ale.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.ala = bVar;
    }

    public void a(a aVar) {
        this.alb = aVar;
    }

    public void a(c cVar) {
        this.alc = cVar;
    }

    public void dh(int i) {
        if (vu() && this.alg != null) {
            if (this.alg.amL != i) {
                this.alg.gy(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_bg_line_c));
                this.alg.amL = i;
            }
            com.baidu.tbadk.core.util.aq.k(this.akX, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alh, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.ali, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vu() {
        return com.baidu.tbadk.core.util.ai.vm().vu();
    }

    private void wR() {
        if (vu()) {
            if (this.akZ != null && this.alh != null) {
                if (this.akZ.getVisibility() != 8) {
                    this.akZ.setVisibility(8);
                }
                if (this.alh.getVisibility() != 0) {
                    this.alh.setVisibility(0);
                }
            }
        } else if (this.akZ != null && this.alh != null) {
            if (this.akZ.getVisibility() != 0) {
                this.akZ.setVisibility(0);
            }
            if (this.alh.getVisibility() != 8) {
                this.alh.setVisibility(8);
            }
        }
    }

    private void wS() {
        this.ale = new com.baidu.tieba.b.d.a(getContext());
        this.ale.setVisibility(4);
        this.ale.setEGLConfigChooser(this.alf);
        this.alg.a(this.alj, this.alj, this.alk, this.alj, this.alj, this.alj);
        this.ale.setRenderer(this.alg);
        this.ali.removeAllViews();
        this.ali.addView(this.ale);
    }

    private void release() {
        if (vu()) {
            if (this.ald != null) {
                this.ald.stop();
                this.ald = null;
                return;
            }
            return;
        }
        if (this.alj != null) {
            this.alj.recycle();
            this.alj = null;
        }
        if (this.alk != null) {
            this.alk.recycle();
            this.alk = null;
        }
        if (this.alm != null) {
            this.alm.recycle();
            this.alm = null;
        }
    }
}

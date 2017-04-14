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
    private Bitmap alA;
    private boolean alB;
    protected View alm;
    protected LinearLayout aln;
    protected ImageView alo;
    private b alp;
    private a alq;
    private c alr;
    protected AnimationDrawable als;
    private com.baidu.tieba.b.d.a alt;
    private a.e alu;
    protected com.baidu.tieba.b.b.b alv;
    protected LinearLayout alw;
    protected FrameLayout alx;
    private Bitmap aly;
    private Bitmap alz;

    /* loaded from: classes.dex */
    public interface a {
        void B(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aN(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aO(boolean z);
    }

    public ab(Context context) {
        super(context);
        this.alm = null;
        this.aln = null;
        this.alo = null;
        this.alp = null;
        this.alq = null;
        this.alr = null;
        this.aly = null;
        this.alz = null;
        this.alA = null;
        this.alB = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View le() {
        this.alm = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.aln = (LinearLayout) this.alm.findViewById(w.h.pull_root);
        this.alw = (LinearLayout) this.aln.findViewById(w.h.cube_container);
        this.alx = (FrameLayout) this.aln.findViewById(w.h.loading_cube);
        this.alo = (ImageView) this.alm.findViewById(w.h.pull_image);
        if (!vR()) {
            this.als = com.baidu.tbadk.core.util.ai.vJ().cI(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.alo.setBackgroundDrawable(this.als);
        this.alu = new ac(this);
        this.alv = new com.baidu.tieba.b.b.b(getContext());
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.aly = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alz = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.alA = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.aly == null || this.alz == null || this.alA == null) {
            com.baidu.tbadk.core.util.ai.vJ().aF(false);
        }
        this.alv.a(this.aly, this.aly, this.alz, this.aly, this.aly, this.aly);
        this.alt = new com.baidu.tieba.b.d.a(getContext());
        this.alt.setEGLConfigChooser(this.alu);
        this.alt.setRenderer(this.alv);
        try {
            this.alt.setRenderMode(0);
        } catch (Exception e) {
        }
        this.alx.addView(this.alt);
        this.alv.Rz();
        xn();
        return this.alm;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lf() {
        if (vR()) {
            this.alt.setVisibility(0);
            this.alt.setRenderMode(1);
        } else if (this.als != null && this.alo != null) {
            this.als.stop();
            this.alo.setBackgroundDrawable(this.als.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.alr != null) {
            this.alr.aO(z);
        }
        xn();
        this.alB = true;
        if (vR()) {
            xo();
            this.alt.requestRender();
            this.alt.onResume();
            this.alt.setRenderMode(1);
            if (z) {
                this.alv.RB();
            }
            this.alv.Rz();
            this.alt.setVisibility(0);
        } else if (this.als != null && this.alo != null) {
            this.als.stop();
            this.alo.setBackgroundDrawable(this.als.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lg() {
        xn();
        if (vR()) {
            if (!this.alB) {
                xo();
            }
            this.alt.requestRender();
            this.alt.onResume();
            this.alt.setVisibility(0);
            this.alt.setRenderMode(1);
            this.alv.RA();
            this.alv.a(this.aly, this.aly, this.aly, this.aly, this.aly, this.aly);
        } else if (this.als != null && this.alo != null) {
            this.als.stop();
            this.alo.setBackgroundDrawable(this.als);
            this.alo.post(new ad(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alB = false;
        if (vR()) {
            this.alv.a(this.aly, this.aly, this.alz, this.aly, this.aly, this.aly);
            if (this.alt != null) {
                this.alt.setRenderMode(0);
                this.alt.onPause();
            }
        } else if (this.als != null) {
            this.als.stop();
        }
        release();
        if (this.alq != null) {
            this.alq.B(this.alm);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.alp != null) {
            this.alp.aN(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lh() {
        if (vR()) {
            this.alv.a(this.aly, this.aly, this.alA, this.aly, this.aly, this.aly);
            this.alv.RB();
            this.alt.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.alp = bVar;
    }

    public void a(a aVar) {
        this.alq = aVar;
    }

    public void a(c cVar) {
        this.alr = cVar;
    }

    public void dk(int i) {
        if (vR() && this.alv != null) {
            if (this.alv.amZ != i) {
                this.alv.gB(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_bg_line_c));
                this.alv.amZ = i;
            }
            com.baidu.tbadk.core.util.aq.k(this.alm, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alw, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alx, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vR() {
        return com.baidu.tbadk.core.util.ai.vJ().vR();
    }

    private void xn() {
        if (vR()) {
            if (this.alo != null && this.alw != null) {
                if (this.alo.getVisibility() != 8) {
                    this.alo.setVisibility(8);
                }
                if (this.alw.getVisibility() != 0) {
                    this.alw.setVisibility(0);
                }
            }
        } else if (this.alo != null && this.alw != null) {
            if (this.alo.getVisibility() != 0) {
                this.alo.setVisibility(0);
            }
            if (this.alw.getVisibility() != 8) {
                this.alw.setVisibility(8);
            }
        }
    }

    private void xo() {
        this.alt = new com.baidu.tieba.b.d.a(getContext());
        this.alt.setVisibility(4);
        this.alt.setEGLConfigChooser(this.alu);
        this.alv.a(this.aly, this.aly, this.alz, this.aly, this.aly, this.aly);
        this.alt.setRenderer(this.alv);
        this.alx.removeAllViews();
        this.alx.addView(this.alt);
    }

    private void release() {
        if (vR()) {
            if (this.als != null) {
                this.als.stop();
                this.als = null;
                return;
            }
            return;
        }
        if (this.aly != null) {
            this.aly.recycle();
            this.aly = null;
        }
        if (this.alz != null) {
            this.alz.recycle();
            this.alz = null;
        }
        if (this.alA != null) {
            this.alA.recycle();
            this.alA = null;
        }
    }
}

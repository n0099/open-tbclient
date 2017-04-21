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
    private Bitmap alB;
    private boolean alC;
    protected View aln;
    protected LinearLayout alo;
    protected ImageView alp;
    private b alq;
    private a alr;
    private c als;
    protected AnimationDrawable alt;
    private com.baidu.tieba.b.d.a alu;
    private a.e alv;
    protected com.baidu.tieba.b.b.b alw;
    protected LinearLayout alx;
    protected FrameLayout aly;
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
        this.aln = null;
        this.alo = null;
        this.alp = null;
        this.alq = null;
        this.alr = null;
        this.als = null;
        this.alz = null;
        this.alA = null;
        this.alB = null;
        this.alC = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View lf() {
        this.aln = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.alo = (LinearLayout) this.aln.findViewById(w.h.pull_root);
        this.alx = (LinearLayout) this.alo.findViewById(w.h.cube_container);
        this.aly = (FrameLayout) this.alo.findViewById(w.h.loading_cube);
        this.alp = (ImageView) this.aln.findViewById(w.h.pull_image);
        if (!vR()) {
            this.alt = com.baidu.tbadk.core.util.ai.vJ().cI(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.alp.setBackgroundDrawable(this.alt);
        this.alv = new ac(this);
        this.alw = new com.baidu.tieba.b.b.b(getContext());
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.alz = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alA = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.alB = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.alz == null || this.alA == null || this.alB == null) {
            com.baidu.tbadk.core.util.ai.vJ().aF(false);
        }
        this.alw.a(this.alz, this.alz, this.alA, this.alz, this.alz, this.alz);
        this.alu = new com.baidu.tieba.b.d.a(getContext());
        this.alu.setEGLConfigChooser(this.alv);
        this.alu.setRenderer(this.alw);
        try {
            this.alu.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aly.addView(this.alu);
        this.alw.SB();
        xn();
        return this.aln;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lg() {
        if (vR()) {
            this.alu.setVisibility(0);
            this.alu.setRenderMode(1);
        } else if (this.alt != null && this.alp != null) {
            this.alt.stop();
            this.alp.setBackgroundDrawable(this.alt.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.als != null) {
            this.als.aO(z);
        }
        xn();
        this.alC = true;
        if (vR()) {
            xo();
            this.alu.requestRender();
            this.alu.onResume();
            this.alu.setRenderMode(1);
            if (z) {
                this.alw.SD();
            }
            this.alw.SB();
            this.alu.setVisibility(0);
        } else if (this.alt != null && this.alp != null) {
            this.alt.stop();
            this.alp.setBackgroundDrawable(this.alt.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lh() {
        xn();
        if (vR()) {
            if (!this.alC) {
                xo();
            }
            this.alu.requestRender();
            this.alu.onResume();
            this.alu.setVisibility(0);
            this.alu.setRenderMode(1);
            this.alw.SC();
            this.alw.a(this.alz, this.alz, this.alz, this.alz, this.alz, this.alz);
        } else if (this.alt != null && this.alp != null) {
            this.alt.stop();
            this.alp.setBackgroundDrawable(this.alt);
            this.alp.post(new ad(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alC = false;
        if (vR()) {
            this.alw.a(this.alz, this.alz, this.alA, this.alz, this.alz, this.alz);
            if (this.alu != null) {
                this.alu.setRenderMode(0);
                this.alu.onPause();
            }
        } else if (this.alt != null) {
            this.alt.stop();
        }
        release();
        if (this.alr != null) {
            this.alr.B(this.aln);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.alq != null) {
            this.alq.aN(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void li() {
        if (vR()) {
            this.alw.a(this.alz, this.alz, this.alB, this.alz, this.alz, this.alz);
            this.alw.SD();
            this.alu.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.alq = bVar;
    }

    public void a(a aVar) {
        this.alr = aVar;
    }

    public void a(c cVar) {
        this.als = cVar;
    }

    public void dk(int i) {
        if (vR() && this.alw != null) {
            if (this.alw.amZ != i) {
                this.alw.gH(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_bg_line_c));
                this.alw.amZ = i;
            }
            com.baidu.tbadk.core.util.aq.k(this.aln, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alx, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.aly, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vR() {
        return com.baidu.tbadk.core.util.ai.vJ().vR();
    }

    private void xn() {
        if (vR()) {
            if (this.alp != null && this.alx != null) {
                if (this.alp.getVisibility() != 8) {
                    this.alp.setVisibility(8);
                }
                if (this.alx.getVisibility() != 0) {
                    this.alx.setVisibility(0);
                }
            }
        } else if (this.alp != null && this.alx != null) {
            if (this.alp.getVisibility() != 0) {
                this.alp.setVisibility(0);
            }
            if (this.alx.getVisibility() != 8) {
                this.alx.setVisibility(8);
            }
        }
    }

    private void xo() {
        this.alu = new com.baidu.tieba.b.d.a(getContext());
        this.alu.setVisibility(4);
        this.alu.setEGLConfigChooser(this.alv);
        this.alw.a(this.alz, this.alz, this.alA, this.alz, this.alz, this.alz);
        this.alu.setRenderer(this.alw);
        this.aly.removeAllViews();
        this.aly.addView(this.alu);
    }

    private void release() {
        if (vR()) {
            if (this.alt != null) {
                this.alt.stop();
                this.alt = null;
                return;
            }
            return;
        }
        if (this.alz != null) {
            this.alz.recycle();
            this.alz = null;
        }
        if (this.alA != null) {
            this.alA.recycle();
            this.alA = null;
        }
        if (this.alB != null) {
            this.alB.recycle();
            this.alB = null;
        }
    }
}

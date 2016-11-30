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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.widget.ListView.d {
    protected View aha;
    protected LinearLayout ahb;
    protected ImageView ahc;
    private b ahd;
    private a ahe;
    private c ahf;
    protected AnimationDrawable ahg;
    private com.baidu.tieba.b.d.a ahh;
    private a.e ahi;
    protected com.baidu.tieba.b.b.b ahj;
    protected LinearLayout ahk;
    protected FrameLayout ahl;
    private Bitmap ahm;
    private Bitmap ahn;
    private Bitmap aho;
    private boolean ahp;

    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aL(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aM(boolean z);
    }

    public z(Context context) {
        super(context);
        this.aha = null;
        this.ahb = null;
        this.ahc = null;
        this.ahd = null;
        this.ahe = null;
        this.ahf = null;
        this.ahm = null;
        this.ahn = null;
        this.aho = null;
        this.ahp = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View kk() {
        this.aha = LayoutInflater.from(getContext()).inflate(r.h.tb_pull_view, (ViewGroup) null);
        this.ahb = (LinearLayout) this.aha.findViewById(r.g.pull_root);
        this.ahk = (LinearLayout) this.ahb.findViewById(r.g.cube_container);
        this.ahl = (FrameLayout) this.ahb.findViewById(r.g.loading_cube);
        this.ahc = (ImageView) this.aha.findViewById(r.g.pull_image);
        if (!vt()) {
            this.ahg = com.baidu.tbadk.core.util.ak.vl().cI(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.ahc.setBackgroundDrawable(this.ahg);
        this.ahi = new aa(this);
        this.ahj = new com.baidu.tieba.b.b.b(getContext());
        di(TbadkCoreApplication.m9getInst().getSkinType());
        this.ahm = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.cube_top);
        this.ahn = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_arrow);
        this.aho = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_ok);
        if (this.ahm == null || this.ahn == null || this.aho == null) {
            com.baidu.tbadk.core.util.ak.vl().aD(false);
        }
        this.ahj.a(this.ahm, this.ahm, this.ahn, this.ahm, this.ahm, this.ahm);
        this.ahh = new com.baidu.tieba.b.d.a(getContext());
        this.ahh.setEGLConfigChooser(this.ahi);
        this.ahh.setRenderer(this.ahj);
        try {
            this.ahh.setRenderMode(0);
        } catch (Exception e) {
        }
        this.ahl.addView(this.ahh);
        this.ahj.Og();
        wO();
        return this.aha;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kl() {
        if (vt()) {
            this.ahh.setVisibility(0);
            this.ahh.setRenderMode(1);
        } else if (this.ahg != null && this.ahc != null) {
            this.ahg.stop();
            this.ahc.setBackgroundDrawable(this.ahg.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.ahf != null) {
            this.ahf.aM(z);
        }
        wO();
        this.ahp = true;
        if (vt()) {
            wP();
            this.ahh.requestRender();
            this.ahh.onResume();
            this.ahh.setRenderMode(1);
            if (z) {
                this.ahj.Oi();
            }
            this.ahj.Og();
            this.ahh.setVisibility(0);
        } else if (this.ahg != null && this.ahc != null) {
            this.ahg.stop();
            this.ahc.setBackgroundDrawable(this.ahg.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void km() {
        wO();
        if (vt()) {
            if (!this.ahp) {
                wP();
            }
            this.ahh.requestRender();
            this.ahh.onResume();
            this.ahh.setVisibility(0);
            this.ahh.setRenderMode(1);
            this.ahj.Oh();
            this.ahj.a(this.ahm, this.ahm, this.ahm, this.ahm, this.ahm, this.ahm);
        } else if (this.ahg != null && this.ahc != null) {
            this.ahg.stop();
            this.ahc.setBackgroundDrawable(this.ahg);
            this.ahc.post(new ab(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.ahp = false;
        if (vt()) {
            this.ahj.a(this.ahm, this.ahm, this.ahn, this.ahm, this.ahm, this.ahm);
            if (this.ahh != null) {
                this.ahh.setRenderMode(0);
                this.ahh.onPause();
            }
        } else if (this.ahg != null) {
            this.ahg.stop();
        }
        release();
        if (this.ahe != null) {
            this.ahe.F(this.aha);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.ahd != null) {
            this.ahd.aL(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kn() {
        if (vt()) {
            this.ahj.a(this.ahm, this.ahm, this.aho, this.ahm, this.ahm, this.ahm);
            this.ahj.Oi();
            this.ahh.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.ahd = bVar;
    }

    public void a(a aVar) {
        this.ahe = aVar;
    }

    public void a(c cVar) {
        this.ahf = cVar;
    }

    public void di(int i) {
        if (vt() && this.ahj != null) {
            if (this.ahj.aiA != i) {
                this.ahj.gd(at.getColor(r.d.cp_bg_line_c));
                this.ahj.aiA = i;
            }
            at.l(this.aha, r.d.cp_bg_line_c);
            at.l(this.ahk, r.d.cp_bg_line_c);
            at.l(this.ahl, r.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vt() {
        return com.baidu.tbadk.core.util.ak.vl().vt();
    }

    private void wO() {
        if (vt()) {
            if (this.ahc != null && this.ahk != null) {
                if (this.ahc.getVisibility() != 8) {
                    this.ahc.setVisibility(8);
                }
                if (this.ahk.getVisibility() != 0) {
                    this.ahk.setVisibility(0);
                }
            }
        } else if (this.ahc != null && this.ahk != null) {
            if (this.ahc.getVisibility() != 0) {
                this.ahc.setVisibility(0);
            }
            if (this.ahk.getVisibility() != 8) {
                this.ahk.setVisibility(8);
            }
        }
    }

    private void wP() {
        this.ahh = new com.baidu.tieba.b.d.a(getContext());
        this.ahh.setVisibility(4);
        this.ahh.setEGLConfigChooser(this.ahi);
        this.ahj.a(this.ahm, this.ahm, this.ahn, this.ahm, this.ahm, this.ahm);
        this.ahh.setRenderer(this.ahj);
        this.ahl.removeAllViews();
        this.ahl.addView(this.ahh);
    }

    private void release() {
        if (vt()) {
            if (this.ahg != null) {
                this.ahg.stop();
                this.ahg = null;
                return;
            }
            return;
        }
        if (this.ahm != null) {
            this.ahm.recycle();
            this.ahm = null;
        }
        if (this.ahn != null) {
            this.ahn.recycle();
            this.ahn = null;
        }
        if (this.aho != null) {
            this.aho.recycle();
            this.aho = null;
        }
    }
}

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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.d {
    protected View aga;
    protected LinearLayout agb;
    protected ImageView agc;
    private b agd;
    private a agf;
    private c agg;
    protected AnimationDrawable agh;
    private com.baidu.tieba.b.d.a agi;
    private a.e agj;
    protected com.baidu.tieba.b.b.b agk;
    protected LinearLayout agl;
    protected FrameLayout agm;
    private Bitmap agn;
    private Bitmap ago;
    private Bitmap agp;
    private boolean agq;

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

    public t(Context context) {
        super(context);
        this.aga = null;
        this.agb = null;
        this.agc = null;
        this.agd = null;
        this.agf = null;
        this.agg = null;
        this.agn = null;
        this.ago = null;
        this.agp = null;
        this.agq = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View kk() {
        this.aga = LayoutInflater.from(getContext()).inflate(t.h.tb_pull_view, (ViewGroup) null);
        this.agb = (LinearLayout) this.aga.findViewById(t.g.pull_root);
        this.agl = (LinearLayout) this.agb.findViewById(t.g.cube_container);
        this.agm = (FrameLayout) this.agb.findViewById(t.g.loading_cube);
        this.agc = (ImageView) this.aga.findViewById(t.g.pull_image);
        if (!va()) {
            this.agh = com.baidu.tbadk.core.util.am.uS().cH(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.agc.setBackgroundDrawable(this.agh);
        this.agj = new u(this);
        this.agk = new com.baidu.tieba.b.b.b(getContext());
        dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.agn = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.cube_top);
        this.ago = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.btn_frs_post_arrow);
        this.agp = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.btn_frs_post_ok);
        if (this.agn == null || this.ago == null || this.agp == null) {
            com.baidu.tbadk.core.util.am.uS().aA(false);
        }
        this.agk.a(this.agn, this.agn, this.ago, this.agn, this.agn, this.agn);
        this.agi = new com.baidu.tieba.b.d.a(getContext());
        this.agi.setEGLConfigChooser(this.agj);
        this.agi.setRenderer(this.agk);
        try {
            this.agi.setRenderMode(0);
        } catch (Exception e) {
        }
        this.agm.addView(this.agi);
        this.agk.MC();
        ws();
        return this.aga;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kl() {
        if (va()) {
            this.agi.setVisibility(0);
            this.agi.setRenderMode(1);
        } else if (this.agh != null && this.agc != null) {
            this.agh.stop();
            this.agc.setBackgroundDrawable(this.agh.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.agg != null) {
            this.agg.aJ(z);
        }
        ws();
        this.agq = true;
        if (va()) {
            wt();
            this.agi.requestRender();
            this.agi.onResume();
            this.agi.setRenderMode(1);
            if (z) {
                this.agk.ME();
            }
            this.agk.MC();
            this.agi.setVisibility(0);
        } else if (this.agh != null && this.agc != null) {
            this.agh.stop();
            this.agc.setBackgroundDrawable(this.agh.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void km() {
        ws();
        if (va()) {
            if (!this.agq) {
                wt();
            }
            this.agi.requestRender();
            this.agi.onResume();
            this.agi.setVisibility(0);
            this.agi.setRenderMode(1);
            this.agk.MD();
            this.agk.a(this.agn, this.agn, this.agn, this.agn, this.agn, this.agn);
        } else if (this.agh != null && this.agc != null) {
            this.agh.stop();
            this.agc.setBackgroundDrawable(this.agh);
            this.agc.post(new v(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agq = false;
        if (va()) {
            this.agk.a(this.agn, this.agn, this.ago, this.agn, this.agn, this.agn);
            if (this.agi != null) {
                this.agi.setRenderMode(0);
                this.agi.onPause();
            }
        } else if (this.agh != null) {
            this.agh.stop();
        }
        release();
        if (this.agf != null) {
            this.agf.F(this.aga);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.agd != null) {
            this.agd.aI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kn() {
        if (va()) {
            this.agk.a(this.agn, this.agn, this.agp, this.agn, this.agn, this.agn);
            this.agk.ME();
            this.agi.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.agd = bVar;
    }

    public void a(a aVar) {
        this.agf = aVar;
    }

    public void a(c cVar) {
        this.agg = cVar;
    }

    public void dh(int i) {
        if (va() && this.agk != null) {
            if (this.agk.ait != i) {
                this.agk.fY(com.baidu.tbadk.core.util.av.getColor(t.d.cp_bg_line_c));
                this.agk.ait = i;
            }
            com.baidu.tbadk.core.util.av.l(this.aga, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.agl, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.l(this.agm, t.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean va() {
        return com.baidu.tbadk.core.util.am.uS().va();
    }

    private void ws() {
        if (va()) {
            if (this.agc != null && this.agl != null) {
                if (this.agc.getVisibility() != 8) {
                    this.agc.setVisibility(8);
                }
                if (this.agl.getVisibility() != 0) {
                    this.agl.setVisibility(0);
                }
            }
        } else if (this.agc != null && this.agl != null) {
            if (this.agc.getVisibility() != 0) {
                this.agc.setVisibility(0);
            }
            if (this.agl.getVisibility() != 8) {
                this.agl.setVisibility(8);
            }
        }
    }

    private void wt() {
        this.agi = new com.baidu.tieba.b.d.a(getContext());
        this.agi.setVisibility(4);
        this.agi.setEGLConfigChooser(this.agj);
        this.agk.a(this.agn, this.agn, this.ago, this.agn, this.agn, this.agn);
        this.agi.setRenderer(this.agk);
        this.agm.removeAllViews();
        this.agm.addView(this.agi);
    }

    private void release() {
        if (va()) {
            if (this.agh != null) {
                this.agh.stop();
                this.agh = null;
                return;
            }
            return;
        }
        if (this.agn != null) {
            this.agn.recycle();
            this.agn = null;
        }
        if (this.ago != null) {
            this.ago.recycle();
            this.ago = null;
        }
        if (this.agp != null) {
            this.agp.recycle();
            this.agp = null;
        }
    }
}

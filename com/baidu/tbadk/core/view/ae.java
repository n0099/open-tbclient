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
public class ae extends com.baidu.adp.widget.ListView.d {
    protected View akY;
    protected LinearLayout akZ;
    protected ImageView ala;
    private b alb;
    private a alc;
    private c ald;
    protected AnimationDrawable ale;
    private com.baidu.tieba.b.d.a alf;
    private a.e alg;
    protected com.baidu.tieba.b.b.b alh;
    protected LinearLayout ali;
    protected FrameLayout alj;
    private Bitmap alk;
    private Bitmap alm;
    private Bitmap aln;
    private boolean alo;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aL(boolean z);
    }

    public ae(Context context) {
        super(context);
        this.akY = null;
        this.akZ = null;
        this.ala = null;
        this.alb = null;
        this.alc = null;
        this.ald = null;
        this.alk = null;
        this.alm = null;
        this.aln = null;
        this.alo = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View le() {
        this.akY = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.akZ = (LinearLayout) this.akY.findViewById(w.h.pull_root);
        this.ali = (LinearLayout) this.akZ.findViewById(w.h.cube_container);
        this.alj = (FrameLayout) this.akZ.findViewById(w.h.loading_cube);
        this.ala = (ImageView) this.akY.findViewById(w.h.pull_image);
        if (!vb()) {
            this.ale = com.baidu.tbadk.core.util.ai.uT().cG(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.ala.setBackgroundDrawable(this.ale);
        this.alg = new af(this);
        this.alh = new com.baidu.tieba.b.b.b(getContext());
        dj(TbadkCoreApplication.m9getInst().getSkinType());
        this.alk = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alm = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.aln = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.alk == null || this.alm == null || this.aln == null) {
            com.baidu.tbadk.core.util.ai.uT().aC(false);
        }
        this.alh.a(this.alk, this.alk, this.alm, this.alk, this.alk, this.alk);
        this.alf = new com.baidu.tieba.b.d.a(getContext());
        this.alf.setEGLConfigChooser(this.alg);
        this.alf.setRenderer(this.alh);
        try {
            this.alf.setRenderMode(0);
        } catch (Exception e) {
        }
        this.alj.addView(this.alf);
        this.alh.Si();
        wu();
        return this.akY;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lf() {
        if (vb()) {
            this.alf.setVisibility(0);
            this.alf.setRenderMode(1);
        } else if (this.ale != null && this.ala != null) {
            this.ale.stop();
            this.ala.setBackgroundDrawable(this.ale.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.ald != null) {
            this.ald.aL(z);
        }
        wu();
        this.alo = true;
        if (vb()) {
            wv();
            this.alf.requestRender();
            this.alf.onResume();
            this.alf.setRenderMode(1);
            if (z) {
                this.alh.Sk();
            }
            this.alh.Si();
            this.alf.setVisibility(0);
        } else if (this.ale != null && this.ala != null) {
            this.ale.stop();
            this.ala.setBackgroundDrawable(this.ale.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lg() {
        wu();
        if (vb()) {
            if (!this.alo) {
                wv();
            }
            this.alf.requestRender();
            this.alf.onResume();
            this.alf.setVisibility(0);
            this.alf.setRenderMode(1);
            this.alh.Sj();
            this.alh.a(this.alk, this.alk, this.alk, this.alk, this.alk, this.alk);
        } else if (this.ale != null && this.ala != null) {
            this.ale.stop();
            this.ala.setBackgroundDrawable(this.ale);
            this.ala.post(new ag(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alo = false;
        if (vb()) {
            this.alh.a(this.alk, this.alk, this.alm, this.alk, this.alk, this.alk);
            if (this.alf != null) {
                this.alf.setRenderMode(0);
                this.alf.onPause();
            }
        } else if (this.ale != null) {
            this.ale.stop();
        }
        release();
        if (this.alc != null) {
            this.alc.b(this.akY, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.alb != null) {
            this.alb.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lh() {
        if (vb()) {
            this.alh.a(this.alk, this.alk, this.aln, this.alk, this.alk, this.alk);
            this.alh.Sk();
            this.alf.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.alb = bVar;
    }

    public void a(a aVar) {
        this.alc = aVar;
    }

    public void a(c cVar) {
        this.ald = cVar;
    }

    public void dj(int i) {
        if (vb() && this.alh != null) {
            if (this.alh.ana != i) {
                this.alh.gV(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_bg_line_c));
                this.alh.ana = i;
            }
            com.baidu.tbadk.core.util.aq.k(this.akY, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.ali, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alj, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vb() {
        return com.baidu.tbadk.core.util.ai.uT().vb();
    }

    private void wu() {
        if (vb()) {
            if (this.ala != null && this.ali != null) {
                if (this.ala.getVisibility() != 8) {
                    this.ala.setVisibility(8);
                }
                if (this.ali.getVisibility() != 0) {
                    this.ali.setVisibility(0);
                }
            }
        } else if (this.ala != null && this.ali != null) {
            if (this.ala.getVisibility() != 0) {
                this.ala.setVisibility(0);
            }
            if (this.ali.getVisibility() != 8) {
                this.ali.setVisibility(8);
            }
        }
    }

    private void wv() {
        this.alf = new com.baidu.tieba.b.d.a(getContext());
        this.alf.setVisibility(4);
        this.alf.setEGLConfigChooser(this.alg);
        this.alh.a(this.alk, this.alk, this.alm, this.alk, this.alk, this.alk);
        this.alf.setRenderer(this.alh);
        this.alj.removeAllViews();
        this.alj.addView(this.alf);
    }

    private void release() {
        if (vb()) {
            if (this.ale != null) {
                this.ale.stop();
                this.ale = null;
                return;
            }
            return;
        }
        if (this.alk != null) {
            this.alk.recycle();
            this.alk = null;
        }
        if (this.alm != null) {
            this.alm.recycle();
            this.alm = null;
        }
        if (this.aln != null) {
            this.aln.recycle();
            this.aln = null;
        }
    }
}

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
    protected View ali;
    protected LinearLayout alj;
    protected ImageView alk;
    private b alm;
    private a aln;
    private c alo;
    protected AnimationDrawable alp;
    private com.baidu.tieba.b.d.a alq;
    private a.e alr;
    protected com.baidu.tieba.b.b.b als;
    protected LinearLayout alt;
    protected FrameLayout alu;
    private Bitmap alv;
    private Bitmap alw;
    private Bitmap alx;
    private boolean aly;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aN(boolean z);
    }

    public ae(Context context) {
        super(context);
        this.ali = null;
        this.alj = null;
        this.alk = null;
        this.alm = null;
        this.aln = null;
        this.alo = null;
        this.alv = null;
        this.alw = null;
        this.alx = null;
        this.aly = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View le() {
        this.ali = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.alj = (LinearLayout) this.ali.findViewById(w.h.pull_root);
        this.alt = (LinearLayout) this.alj.findViewById(w.h.cube_container);
        this.alu = (FrameLayout) this.alj.findViewById(w.h.loading_cube);
        this.alk = (ImageView) this.ali.findViewById(w.h.pull_image);
        if (!ve()) {
            this.alp = com.baidu.tbadk.core.util.ai.uW().cF(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.alk.setBackgroundDrawable(this.alp);
        this.alr = new af(this);
        this.als = new com.baidu.tieba.b.b.b(getContext());
        di(TbadkCoreApplication.m9getInst().getSkinType());
        this.alv = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alw = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.alx = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.alv == null || this.alw == null || this.alx == null) {
            com.baidu.tbadk.core.util.ai.uW().aD(false);
        }
        this.als.a(this.alv, this.alv, this.alw, this.alv, this.alv, this.alv);
        this.alq = new com.baidu.tieba.b.d.a(getContext());
        this.alq.setEGLConfigChooser(this.alr);
        this.alq.setRenderer(this.als);
        try {
            this.alq.setRenderMode(0);
        } catch (Exception e) {
        }
        this.alu.addView(this.alq);
        this.als.RW();
        wy();
        return this.ali;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lf() {
        if (ve()) {
            this.alq.setVisibility(0);
            this.alq.setRenderMode(1);
        } else if (this.alp != null && this.alk != null) {
            this.alp.stop();
            this.alk.setBackgroundDrawable(this.alp.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.alo != null) {
            this.alo.aN(z);
        }
        wy();
        this.aly = true;
        if (ve()) {
            wz();
            this.alq.requestRender();
            this.alq.onResume();
            this.alq.setRenderMode(1);
            if (z) {
                this.als.RY();
            }
            this.als.RW();
            this.alq.setVisibility(0);
        } else if (this.alp != null && this.alk != null) {
            this.alp.stop();
            this.alk.setBackgroundDrawable(this.alp.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lg() {
        wy();
        if (ve()) {
            if (!this.aly) {
                wz();
            }
            this.alq.requestRender();
            this.alq.onResume();
            this.alq.setVisibility(0);
            this.alq.setRenderMode(1);
            this.als.RX();
            this.als.a(this.alv, this.alv, this.alv, this.alv, this.alv, this.alv);
        } else if (this.alp != null && this.alk != null) {
            this.alp.stop();
            this.alk.setBackgroundDrawable(this.alp);
            this.alk.post(new ag(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.aly = false;
        if (ve()) {
            this.als.a(this.alv, this.alv, this.alw, this.alv, this.alv, this.alv);
            if (this.alq != null) {
                this.alq.setRenderMode(0);
                this.alq.onPause();
            }
        } else if (this.alp != null) {
            this.alp.stop();
        }
        release();
        if (this.aln != null) {
            this.aln.b(this.ali, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.alm != null) {
            this.alm.aM(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lh() {
        if (ve()) {
            this.als.a(this.alv, this.alv, this.alx, this.alv, this.alv, this.alv);
            this.als.RY();
            this.alq.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.alm = bVar;
    }

    public void a(a aVar) {
        this.aln = aVar;
    }

    public void a(c cVar) {
        this.alo = cVar;
    }

    public void di(int i) {
        if (ve() && this.als != null) {
            if (this.als.ane != i) {
                this.als.gE(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_bg_line_c));
                this.als.ane = i;
            }
            com.baidu.tbadk.core.util.aq.k(this.ali, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alt, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.aq.k(this.alu, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ve() {
        return com.baidu.tbadk.core.util.ai.uW().ve();
    }

    private void wy() {
        if (ve()) {
            if (this.alk != null && this.alt != null) {
                if (this.alk.getVisibility() != 8) {
                    this.alk.setVisibility(8);
                }
                if (this.alt.getVisibility() != 0) {
                    this.alt.setVisibility(0);
                }
            }
        } else if (this.alk != null && this.alt != null) {
            if (this.alk.getVisibility() != 0) {
                this.alk.setVisibility(0);
            }
            if (this.alt.getVisibility() != 8) {
                this.alt.setVisibility(8);
            }
        }
    }

    private void wz() {
        this.alq = new com.baidu.tieba.b.d.a(getContext());
        this.alq.setVisibility(4);
        this.alq.setEGLConfigChooser(this.alr);
        this.als.a(this.alv, this.alv, this.alw, this.alv, this.alv, this.alv);
        this.alq.setRenderer(this.als);
        this.alu.removeAllViews();
        this.alu.addView(this.alq);
    }

    private void release() {
        if (ve()) {
            if (this.alp != null) {
                this.alp.stop();
                this.alp = null;
                return;
            }
            return;
        }
        if (this.alv != null) {
            this.alv.recycle();
            this.alv = null;
        }
        if (this.alw != null) {
            this.alw.recycle();
            this.alw = null;
        }
        if (this.alx != null) {
            this.alx.recycle();
            this.alx = null;
        }
    }
}

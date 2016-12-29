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
public class z extends com.baidu.adp.widget.ListView.d {
    private com.baidu.tieba.b.d.a agA;
    private a.e agB;
    protected com.baidu.tieba.b.b.b agC;
    protected LinearLayout agD;
    protected FrameLayout agE;
    private Bitmap agF;
    private Bitmap agG;
    private Bitmap agH;
    private boolean agI;
    protected View agt;
    protected LinearLayout agu;
    protected ImageView agv;
    private b agw;
    private a agx;
    private c agy;
    protected AnimationDrawable agz;

    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aM(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aN(boolean z);
    }

    public z(Context context) {
        super(context);
        this.agt = null;
        this.agu = null;
        this.agv = null;
        this.agw = null;
        this.agx = null;
        this.agy = null;
        this.agF = null;
        this.agG = null;
        this.agH = null;
        this.agI = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View kk() {
        this.agt = LayoutInflater.from(getContext()).inflate(r.h.tb_pull_view, (ViewGroup) null);
        this.agu = (LinearLayout) this.agt.findViewById(r.g.pull_root);
        this.agD = (LinearLayout) this.agu.findViewById(r.g.cube_container);
        this.agE = (FrameLayout) this.agu.findViewById(r.g.loading_cube);
        this.agv = (ImageView) this.agt.findViewById(r.g.pull_image);
        if (!vd()) {
            this.agz = com.baidu.tbadk.core.util.aj.uV().cK(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.agv.setBackgroundDrawable(this.agz);
        this.agB = new aa(this);
        this.agC = new com.baidu.tieba.b.b.b(getContext());
        dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.agF = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.cube_top);
        this.agG = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_arrow);
        this.agH = BitmapHelper.getResBitmapPowerOf2Size(getContext(), r.f.btn_frs_post_ok);
        if (this.agF == null || this.agG == null || this.agH == null) {
            com.baidu.tbadk.core.util.aj.uV().aE(false);
        }
        this.agC.a(this.agF, this.agF, this.agG, this.agF, this.agF, this.agF);
        this.agA = new com.baidu.tieba.b.d.a(getContext());
        this.agA.setEGLConfigChooser(this.agB);
        this.agA.setRenderer(this.agC);
        try {
            this.agA.setRenderMode(0);
        } catch (Exception e) {
        }
        this.agE.addView(this.agA);
        this.agC.Ns();
        wz();
        return this.agt;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kl() {
        if (vd()) {
            this.agA.setVisibility(0);
            this.agA.setRenderMode(1);
        } else if (this.agz != null && this.agv != null) {
            this.agz.stop();
            this.agv.setBackgroundDrawable(this.agz.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.agy != null) {
            this.agy.aN(z);
        }
        wz();
        this.agI = true;
        if (vd()) {
            wA();
            this.agA.requestRender();
            this.agA.onResume();
            this.agA.setRenderMode(1);
            if (z) {
                this.agC.Nu();
            }
            this.agC.Ns();
            this.agA.setVisibility(0);
        } else if (this.agz != null && this.agv != null) {
            this.agz.stop();
            this.agv.setBackgroundDrawable(this.agz.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void km() {
        wz();
        if (vd()) {
            if (!this.agI) {
                wA();
            }
            this.agA.requestRender();
            this.agA.onResume();
            this.agA.setVisibility(0);
            this.agA.setRenderMode(1);
            this.agC.Nt();
            this.agC.a(this.agF, this.agF, this.agF, this.agF, this.agF, this.agF);
        } else if (this.agz != null && this.agv != null) {
            this.agz.stop();
            this.agv.setBackgroundDrawable(this.agz);
            this.agv.post(new ab(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.agI = false;
        if (vd()) {
            this.agC.a(this.agF, this.agF, this.agG, this.agF, this.agF, this.agF);
            if (this.agA != null) {
                this.agA.setRenderMode(0);
                this.agA.onPause();
            }
        } else if (this.agz != null) {
            this.agz.stop();
        }
        release();
        if (this.agx != null) {
            this.agx.F(this.agt);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.agw != null) {
            this.agw.aM(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void kn() {
        if (vd()) {
            this.agC.a(this.agF, this.agF, this.agH, this.agF, this.agF, this.agF);
            this.agC.Nu();
            this.agA.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.agw = bVar;
    }

    public void a(a aVar) {
        this.agx = aVar;
    }

    public void a(c cVar) {
        this.agy = cVar;
    }

    public void dk(int i) {
        if (vd() && this.agC != null) {
            if (this.agC.aib != i) {
                this.agC.gc(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_bg_line_c));
                this.agC.aib = i;
            }
            com.baidu.tbadk.core.util.ar.l(this.agt, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.l(this.agD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.l(this.agE, r.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vd() {
        return com.baidu.tbadk.core.util.aj.uV().vd();
    }

    private void wz() {
        if (vd()) {
            if (this.agv != null && this.agD != null) {
                if (this.agv.getVisibility() != 8) {
                    this.agv.setVisibility(8);
                }
                if (this.agD.getVisibility() != 0) {
                    this.agD.setVisibility(0);
                }
            }
        } else if (this.agv != null && this.agD != null) {
            if (this.agv.getVisibility() != 0) {
                this.agv.setVisibility(0);
            }
            if (this.agD.getVisibility() != 8) {
                this.agD.setVisibility(8);
            }
        }
    }

    private void wA() {
        this.agA = new com.baidu.tieba.b.d.a(getContext());
        this.agA.setVisibility(4);
        this.agA.setEGLConfigChooser(this.agB);
        this.agC.a(this.agF, this.agF, this.agG, this.agF, this.agF, this.agF);
        this.agA.setRenderer(this.agC);
        this.agE.removeAllViews();
        this.agE.addView(this.agA);
    }

    private void release() {
        if (vd()) {
            if (this.agz != null) {
                this.agz.stop();
                this.agz = null;
                return;
            }
            return;
        }
        if (this.agF != null) {
            this.agF.recycle();
            this.agF = null;
        }
        if (this.agG != null) {
            this.agG.recycle();
            this.agG = null;
        }
        if (this.agH != null) {
            this.agH.recycle();
            this.agH = null;
        }
    }
}

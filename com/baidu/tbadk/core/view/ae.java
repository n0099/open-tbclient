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
    protected View alM;
    protected LinearLayout alN;
    protected ImageView alO;
    private b alP;
    private a alQ;
    private c alR;
    protected AnimationDrawable alS;
    private com.baidu.tieba.b.d.a alT;
    private a.e alU;
    protected com.baidu.tieba.b.b.b alV;
    protected LinearLayout alW;
    protected FrameLayout alX;
    private Bitmap alY;
    private Bitmap alZ;
    private Bitmap ama;
    private boolean amb;

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
        void aM(boolean z);
    }

    public ae(Context context) {
        super(context);
        this.alM = null;
        this.alN = null;
        this.alO = null;
        this.alP = null;
        this.alQ = null;
        this.alR = null;
        this.alY = null;
        this.alZ = null;
        this.ama = null;
        this.amb = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View lc() {
        this.alM = LayoutInflater.from(getContext()).inflate(w.j.tb_pull_view, (ViewGroup) null);
        this.alN = (LinearLayout) this.alM.findViewById(w.h.pull_root);
        this.alW = (LinearLayout) this.alN.findViewById(w.h.cube_container);
        this.alX = (FrameLayout) this.alN.findViewById(w.h.loading_cube);
        this.alO = (ImageView) this.alM.findViewById(w.h.pull_image);
        if (!vr()) {
            this.alS = com.baidu.tbadk.core.util.ak.vj().cI(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.alO.setBackgroundDrawable(this.alS);
        this.alU = new af(this);
        this.alV = new com.baidu.tieba.b.b.b(getContext());
        dl(TbadkCoreApplication.m9getInst().getSkinType());
        this.alY = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.cube_top);
        this.alZ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_arrow);
        this.ama = BitmapHelper.getResBitmapPowerOf2Size(getContext(), w.g.btn_frs_post_ok);
        if (this.alY == null || this.alZ == null || this.ama == null) {
            com.baidu.tbadk.core.util.ak.vj().aD(false);
        }
        this.alV.a(this.alY, this.alY, this.alZ, this.alY, this.alY, this.alY);
        this.alT = new com.baidu.tieba.b.d.a(getContext());
        this.alT.setEGLConfigChooser(this.alU);
        this.alT.setRenderer(this.alV);
        try {
            this.alT.setRenderMode(0);
        } catch (Exception e) {
        }
        this.alX.addView(this.alT);
        this.alV.TX();
        wM();
        return this.alM;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void ld() {
        if (vr()) {
            this.alT.setVisibility(0);
            this.alT.setRenderMode(1);
        } else if (this.alS != null && this.alO != null) {
            this.alS.stop();
            this.alO.setBackgroundDrawable(this.alS.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        if (this.alR != null) {
            this.alR.aM(z);
        }
        wM();
        this.amb = true;
        if (vr()) {
            wN();
            this.alT.requestRender();
            this.alT.onResume();
            this.alT.setRenderMode(1);
            if (z) {
                this.alV.TZ();
            }
            this.alV.TX();
            this.alT.setVisibility(0);
        } else if (this.alS != null && this.alO != null) {
            this.alS.stop();
            this.alO.setBackgroundDrawable(this.alS.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void le() {
        wM();
        if (vr()) {
            if (!this.amb) {
                wN();
            }
            this.alT.requestRender();
            this.alT.onResume();
            this.alT.setVisibility(0);
            this.alT.setRenderMode(1);
            this.alV.TY();
            this.alV.a(this.alY, this.alY, this.alY, this.alY, this.alY, this.alY);
        } else if (this.alS != null && this.alO != null) {
            this.alS.stop();
            this.alO.setBackgroundDrawable(this.alS);
            this.alO.post(new ag(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.amb = false;
        if (vr()) {
            this.alV.a(this.alY, this.alY, this.alZ, this.alY, this.alY, this.alY);
            if (this.alT != null) {
                this.alT.setRenderMode(0);
                this.alT.onPause();
            }
        } else if (this.alS != null) {
            this.alS.stop();
        }
        release();
        if (this.alQ != null) {
            this.alQ.b(this.alM, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        if (this.alP != null) {
            this.alP.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void lf() {
        if (vr()) {
            this.alV.a(this.alY, this.alY, this.ama, this.alY, this.alY, this.alY);
            this.alV.TZ();
            this.alT.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.alP = bVar;
    }

    public void a(a aVar) {
        this.alQ = aVar;
    }

    public void a(c cVar) {
        this.alR = cVar;
    }

    public void dl(int i) {
        if (vr() && this.alV != null) {
            if (this.alV.aoa != i) {
                this.alV.hb(com.baidu.tbadk.core.util.as.getColor(w.e.cp_bg_line_c));
                this.alV.aoa = i;
            }
            com.baidu.tbadk.core.util.as.k(this.alM, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.k(this.alW, w.e.cp_bg_line_c);
            com.baidu.tbadk.core.util.as.k(this.alX, w.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vr() {
        return com.baidu.tbadk.core.util.ak.vj().vr();
    }

    private void wM() {
        if (vr()) {
            if (this.alO != null && this.alW != null) {
                if (this.alO.getVisibility() != 8) {
                    this.alO.setVisibility(8);
                }
                if (this.alW.getVisibility() != 0) {
                    this.alW.setVisibility(0);
                }
            }
        } else if (this.alO != null && this.alW != null) {
            if (this.alO.getVisibility() != 0) {
                this.alO.setVisibility(0);
            }
            if (this.alW.getVisibility() != 8) {
                this.alW.setVisibility(8);
            }
        }
    }

    private void wN() {
        this.alT = new com.baidu.tieba.b.d.a(getContext());
        this.alT.setVisibility(4);
        this.alT.setEGLConfigChooser(this.alU);
        this.alV.a(this.alY, this.alY, this.alZ, this.alY, this.alY, this.alY);
        this.alT.setRenderer(this.alV);
        this.alX.removeAllViews();
        this.alX.addView(this.alT);
    }

    private void release() {
        if (vr()) {
            if (this.alS != null) {
                this.alS.stop();
                this.alS = null;
                return;
            }
            return;
        }
        if (this.alY != null) {
            this.alY.recycle();
            this.alY = null;
        }
        if (this.alZ != null) {
            this.alZ.recycle();
            this.alZ = null;
        }
        if (this.ama != null) {
            this.ama.recycle();
            this.ama = null;
        }
    }
}

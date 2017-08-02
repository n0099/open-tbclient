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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout amA;
    protected FrameLayout amB;
    private Bitmap amC;
    private Bitmap amD;
    private Bitmap amE;
    private boolean amF;
    protected View amq;
    protected LinearLayout amr;
    protected ImageView ams;
    private b amt;
    private a amu;
    private c amv;
    protected AnimationDrawable amw;
    private com.baidu.tieba.b.d.a amx;
    private a.e amy;
    protected com.baidu.tieba.b.b.b amz;

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
        void aN(boolean z);
    }

    public k(Context context) {
        super(context);
        this.amq = null;
        this.amr = null;
        this.ams = null;
        this.amt = null;
        this.amu = null;
        this.amv = null;
        this.amC = null;
        this.amD = null;
        this.amE = null;
        this.amF = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View la() {
        this.amq = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.amr = (LinearLayout) this.amq.findViewById(d.h.pull_root);
        this.amA = (LinearLayout) this.amr.findViewById(d.h.cube_container);
        this.amB = (FrameLayout) this.amr.findViewById(d.h.loading_cube);
        this.ams = (ImageView) this.amq.findViewById(d.h.pull_image);
        if (!vx()) {
            this.amw = ae.vp().cK(TbadkCoreApplication.getInst().getSkinType());
        }
        this.ams.setBackgroundDrawable(this.amw);
        this.amy = new a.e() { // from class: com.baidu.tbadk.core.view.k.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amz = new com.baidu.tieba.b.b.b(getContext());
        dn(TbadkCoreApplication.getInst().getSkinType());
        this.amC = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.amD = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.amE = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.amC == null || this.amD == null || this.amE == null) {
            ae.vp().aC(false);
        }
        this.amz.a(this.amC, this.amC, this.amD, this.amC, this.amC, this.amC);
        this.amx = new com.baidu.tieba.b.d.a(getContext());
        this.amx.setEGLConfigChooser(this.amy);
        this.amx.setRenderer(this.amz);
        try {
            this.amx.setRenderMode(0);
        } catch (Exception e) {
        }
        this.amB.addView(this.amx);
        this.amz.UH();
        wX();
        return this.amq;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lb() {
        if (vx()) {
            this.amx.setVisibility(0);
            this.amx.setRenderMode(1);
        } else if (this.amw != null && this.ams != null) {
            this.amw.stop();
            this.ams.setBackgroundDrawable(this.amw.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        if (this.amv != null) {
            this.amv.aN(z);
        }
        wX();
        this.amF = true;
        if (vx()) {
            wY();
            this.amx.requestRender();
            this.amx.onResume();
            this.amx.setRenderMode(1);
            if (z) {
                this.amz.UJ();
            }
            this.amz.UH();
            this.amx.setVisibility(0);
        } else if (this.amw != null && this.ams != null) {
            this.amw.stop();
            this.ams.setBackgroundDrawable(this.amw.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lc() {
        wX();
        if (vx()) {
            if (!this.amF) {
                wY();
            }
            this.amx.requestRender();
            this.amx.onResume();
            this.amx.setVisibility(0);
            this.amx.setRenderMode(1);
            this.amz.UI();
            this.amz.a(this.amC, this.amC, this.amC, this.amC, this.amC, this.amC);
        } else if (this.amw != null && this.ams != null) {
            this.amw.stop();
            this.ams.setBackgroundDrawable(this.amw);
            this.ams.post(new Runnable() { // from class: com.baidu.tbadk.core.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.amw != null) {
                        k.this.amw.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.amF = false;
        if (vx()) {
            this.amz.a(this.amC, this.amC, this.amD, this.amC, this.amC, this.amC);
            if (this.amx != null) {
                this.amx.setRenderMode(0);
                this.amx.onPause();
            }
        } else if (this.amw != null) {
            this.amw.stop();
        }
        release();
        if (this.amu != null) {
            this.amu.b(this.amq, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        if (this.amt != null) {
            this.amt.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ld() {
        if (vx()) {
            this.amz.a(this.amC, this.amC, this.amE, this.amC, this.amC, this.amC);
            this.amz.UJ();
            this.amx.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amt = bVar;
    }

    public void a(a aVar) {
        this.amu = aVar;
    }

    public void a(c cVar) {
        this.amv = cVar;
    }

    public void dn(int i) {
        if (vx() && this.amz != null) {
            if (this.amz.aoR != i) {
                this.amz.hh(ai.getColor(d.e.cp_bg_line_c));
                this.amz.aoR = i;
            }
            ai.k(this.amq, d.e.cp_bg_line_c);
            ai.k(this.amA, d.e.cp_bg_line_c);
            ai.k(this.amB, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vx() {
        return ae.vp().vx();
    }

    private void wX() {
        if (vx()) {
            if (this.ams != null && this.amA != null) {
                if (this.ams.getVisibility() != 8) {
                    this.ams.setVisibility(8);
                }
                if (this.amA.getVisibility() != 0) {
                    this.amA.setVisibility(0);
                }
            }
        } else if (this.ams != null && this.amA != null) {
            if (this.ams.getVisibility() != 0) {
                this.ams.setVisibility(0);
            }
            if (this.amA.getVisibility() != 8) {
                this.amA.setVisibility(8);
            }
        }
    }

    private void wY() {
        this.amx = new com.baidu.tieba.b.d.a(getContext());
        this.amx.setVisibility(4);
        this.amx.setEGLConfigChooser(this.amy);
        this.amz.a(this.amC, this.amC, this.amD, this.amC, this.amC, this.amC);
        this.amx.setRenderer(this.amz);
        this.amB.removeAllViews();
        this.amB.addView(this.amx);
    }

    private void release() {
        if (vx()) {
            if (this.amw != null) {
                this.amw.stop();
                this.amw = null;
                return;
            }
            return;
        }
        if (this.amC != null) {
            this.amC.recycle();
            this.amC = null;
        }
        if (this.amD != null) {
            this.amD.recycle();
            this.amD = null;
        }
        if (this.amE != null) {
            this.amE.recycle();
            this.amE = null;
        }
    }
}

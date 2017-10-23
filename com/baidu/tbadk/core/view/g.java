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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.c {
    protected View ama;
    protected LinearLayout amb;
    protected ImageView amc;
    private b amd;
    private a ame;
    private c amf;
    protected AnimationDrawable amg;
    private com.baidu.tieba.b.d.a amh;
    private a.e ami;
    protected com.baidu.tieba.b.b.b amj;
    protected LinearLayout amk;
    protected FrameLayout aml;
    private Bitmap amm;
    private Bitmap amn;
    private Bitmap amo;
    private boolean amp;

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

    public g(Context context) {
        super(context);
        this.ama = null;
        this.amb = null;
        this.amc = null;
        this.amd = null;
        this.ame = null;
        this.amf = null;
        this.amm = null;
        this.amn = null;
        this.amo = null;
        this.amp = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ld() {
        this.ama = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.amb = (LinearLayout) this.ama.findViewById(d.h.pull_root);
        this.amk = (LinearLayout) this.amb.findViewById(d.h.cube_container);
        this.aml = (FrameLayout) this.amb.findViewById(d.h.loading_cube);
        this.amc = (ImageView) this.ama.findViewById(d.h.pull_image);
        if (!vc()) {
            this.amg = af.uU().cK(TbadkCoreApplication.getInst().getSkinType());
        }
        this.amc.setBackgroundDrawable(this.amg);
        this.ami = new a.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amj = new com.baidu.tieba.b.b.b(getContext());
        dy(TbadkCoreApplication.getInst().getSkinType());
        this.amm = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.amn = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.amo = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.amm == null || this.amn == null || this.amo == null) {
            af.uU().aB(false);
        }
        this.amj.a(this.amm, this.amm, this.amn, this.amm, this.amm, this.amm);
        this.amh = new com.baidu.tieba.b.d.a(getContext());
        this.amh.setEGLConfigChooser(this.ami);
        this.amh.setRenderer(this.amj);
        try {
            this.amh.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aml.addView(this.amh);
        this.amj.WJ();
        ww();
        return this.ama;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void le() {
        if (vc()) {
            this.amh.setVisibility(0);
            this.amh.setRenderMode(1);
        } else if (this.amg != null && this.amc != null) {
            this.amg.stop();
            this.amc.setBackgroundDrawable(this.amg.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        if (this.amf != null) {
            this.amf.aM(z);
        }
        ww();
        this.amp = true;
        if (vc()) {
            wx();
            this.amh.requestRender();
            this.amh.onResume();
            this.amh.setRenderMode(1);
            if (z) {
                this.amj.WL();
            }
            this.amj.WJ();
            this.amh.setVisibility(0);
        } else if (this.amg != null && this.amc != null) {
            this.amg.stop();
            this.amc.setBackgroundDrawable(this.amg.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lf() {
        ww();
        if (vc()) {
            if (!this.amp) {
                wx();
            }
            this.amh.requestRender();
            this.amh.onResume();
            this.amh.setVisibility(0);
            this.amh.setRenderMode(1);
            this.amj.WK();
            this.amj.a(this.amm, this.amm, this.amm, this.amm, this.amm, this.amm);
        } else if (this.amg != null && this.amc != null) {
            this.amg.stop();
            this.amc.setBackgroundDrawable(this.amg);
            this.amc.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.amg != null) {
                        g.this.amg.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        this.amp = false;
        if (vc()) {
            this.amj.a(this.amm, this.amm, this.amn, this.amm, this.amm, this.amm);
            if (this.amh != null) {
                this.amh.setRenderMode(0);
                this.amh.onPause();
            }
        } else if (this.amg != null) {
            this.amg.stop();
        }
        release();
        if (this.ame != null) {
            this.ame.b(this.ama, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void W(boolean z) {
        if (this.amd != null) {
            this.amd.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lg() {
        if (vc()) {
            this.amj.a(this.amm, this.amm, this.amo, this.amm, this.amm, this.amm);
            this.amj.WL();
            this.amh.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amd = bVar;
    }

    public void a(a aVar) {
        this.ame = aVar;
    }

    public void a(c cVar) {
        this.amf = cVar;
    }

    public void dy(int i) {
        if (vc() && this.amj != null) {
            if (this.amj.aoN != i) {
                this.amj.hJ(aj.getColor(d.e.cp_bg_line_c));
                this.amj.aoN = i;
            }
            aj.k(this.ama, d.e.cp_bg_line_c);
            aj.k(this.amk, d.e.cp_bg_line_c);
            aj.k(this.aml, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vc() {
        return af.uU().vc();
    }

    private void ww() {
        if (vc()) {
            if (this.amc != null && this.amk != null) {
                if (this.amc.getVisibility() != 8) {
                    this.amc.setVisibility(8);
                }
                if (this.amk.getVisibility() != 0) {
                    this.amk.setVisibility(0);
                }
            }
        } else if (this.amc != null && this.amk != null) {
            if (this.amc.getVisibility() != 0) {
                this.amc.setVisibility(0);
            }
            if (this.amk.getVisibility() != 8) {
                this.amk.setVisibility(8);
            }
        }
    }

    private void wx() {
        this.amh = new com.baidu.tieba.b.d.a(getContext());
        this.amh.setVisibility(4);
        this.amh.setEGLConfigChooser(this.ami);
        this.amj.a(this.amm, this.amm, this.amn, this.amm, this.amm, this.amm);
        this.amh.setRenderer(this.amj);
        this.aml.removeAllViews();
        this.aml.addView(this.amh);
    }

    private void release() {
        if (vc()) {
            if (this.amg != null) {
                this.amg.stop();
                this.amg = null;
                return;
            }
            return;
        }
        if (this.amm != null) {
            this.amm.recycle();
            this.amm = null;
        }
        if (this.amn != null) {
            this.amn.recycle();
            this.amn = null;
        }
        if (this.amo != null) {
            this.amo.recycle();
            this.amo = null;
        }
    }
}

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
public class k extends com.baidu.adp.widget.ListView.c {
    protected View anc;
    protected LinearLayout and;
    protected ImageView ane;
    private b anf;
    private a ang;
    private c anh;
    protected AnimationDrawable ani;
    private com.baidu.tieba.b.d.a anj;
    private a.e ank;
    protected com.baidu.tieba.b.b.b anl;
    protected LinearLayout anm;
    protected FrameLayout ann;
    private Bitmap ano;
    private Bitmap anp;
    private Bitmap anq;
    private boolean anr;

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
        this.anc = null;
        this.and = null;
        this.ane = null;
        this.anf = null;
        this.ang = null;
        this.anh = null;
        this.ano = null;
        this.anp = null;
        this.anq = null;
        this.anr = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lb() {
        this.anc = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.and = (LinearLayout) this.anc.findViewById(d.h.pull_root);
        this.anm = (LinearLayout) this.and.findViewById(d.h.cube_container);
        this.ann = (FrameLayout) this.and.findViewById(d.h.loading_cube);
        this.ane = (ImageView) this.anc.findViewById(d.h.pull_image);
        if (!vF()) {
            this.ani = af.vx().cN(TbadkCoreApplication.getInst().getSkinType());
        }
        this.ane.setBackgroundDrawable(this.ani);
        this.ank = new a.e() { // from class: com.baidu.tbadk.core.view.k.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.anl = new com.baidu.tieba.b.b.b(getContext());
        dq(TbadkCoreApplication.getInst().getSkinType());
        this.ano = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.anp = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.anq = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.ano == null || this.anp == null || this.anq == null) {
            af.vx().aC(false);
        }
        this.anl.a(this.ano, this.ano, this.anp, this.ano, this.ano, this.ano);
        this.anj = new com.baidu.tieba.b.d.a(getContext());
        this.anj.setEGLConfigChooser(this.ank);
        this.anj.setRenderer(this.anl);
        try {
            this.anj.setRenderMode(0);
        } catch (Exception e) {
        }
        this.ann.addView(this.anj);
        this.anl.Wt();
        xe();
        return this.anc;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lc() {
        if (vF()) {
            this.anj.setVisibility(0);
            this.anj.setRenderMode(1);
        } else if (this.ani != null && this.ane != null) {
            this.ani.stop();
            this.ane.setBackgroundDrawable(this.ani.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.anh != null) {
            this.anh.aN(z);
        }
        xe();
        this.anr = true;
        if (vF()) {
            xf();
            this.anj.requestRender();
            this.anj.onResume();
            this.anj.setRenderMode(1);
            if (z) {
                this.anl.Wv();
            }
            this.anl.Wt();
            this.anj.setVisibility(0);
        } else if (this.ani != null && this.ane != null) {
            this.ani.stop();
            this.ane.setBackgroundDrawable(this.ani.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ld() {
        xe();
        if (vF()) {
            if (!this.anr) {
                xf();
            }
            this.anj.requestRender();
            this.anj.onResume();
            this.anj.setVisibility(0);
            this.anj.setRenderMode(1);
            this.anl.Wu();
            this.anl.a(this.ano, this.ano, this.ano, this.ano, this.ano, this.ano);
        } else if (this.ani != null && this.ane != null) {
            this.ani.stop();
            this.ane.setBackgroundDrawable(this.ani);
            this.ane.post(new Runnable() { // from class: com.baidu.tbadk.core.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.ani != null) {
                        k.this.ani.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.anr = false;
        if (vF()) {
            this.anl.a(this.ano, this.ano, this.anp, this.ano, this.ano, this.ano);
            if (this.anj != null) {
                this.anj.setRenderMode(0);
                this.anj.onPause();
            }
        } else if (this.ani != null) {
            this.ani.stop();
        }
        release();
        if (this.ang != null) {
            this.ang.b(this.anc, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.anf != null) {
            this.anf.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void le() {
        if (vF()) {
            this.anl.a(this.ano, this.ano, this.anq, this.ano, this.ano, this.ano);
            this.anl.Wv();
            this.anj.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.anf = bVar;
    }

    public void a(a aVar) {
        this.ang = aVar;
    }

    public void a(c cVar) {
        this.anh = cVar;
    }

    public void dq(int i) {
        if (vF() && this.anl != null) {
            if (this.anl.apQ != i) {
                this.anl.hw(aj.getColor(d.e.cp_bg_line_c));
                this.anl.apQ = i;
            }
            aj.k(this.anc, d.e.cp_bg_line_c);
            aj.k(this.anm, d.e.cp_bg_line_c);
            aj.k(this.ann, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vF() {
        return af.vx().vF();
    }

    private void xe() {
        if (vF()) {
            if (this.ane != null && this.anm != null) {
                if (this.ane.getVisibility() != 8) {
                    this.ane.setVisibility(8);
                }
                if (this.anm.getVisibility() != 0) {
                    this.anm.setVisibility(0);
                }
            }
        } else if (this.ane != null && this.anm != null) {
            if (this.ane.getVisibility() != 0) {
                this.ane.setVisibility(0);
            }
            if (this.anm.getVisibility() != 8) {
                this.anm.setVisibility(8);
            }
        }
    }

    private void xf() {
        this.anj = new com.baidu.tieba.b.d.a(getContext());
        this.anj.setVisibility(4);
        this.anj.setEGLConfigChooser(this.ank);
        this.anl.a(this.ano, this.ano, this.anp, this.ano, this.ano, this.ano);
        this.anj.setRenderer(this.anl);
        this.ann.removeAllViews();
        this.ann.addView(this.anj);
    }

    private void release() {
        if (vF()) {
            if (this.ani != null) {
                this.ani.stop();
                this.ani = null;
                return;
            }
            return;
        }
        if (this.ano != null) {
            this.ano.recycle();
            this.ano = null;
        }
        if (this.anp != null) {
            this.anp.recycle();
            this.anp = null;
        }
        if (this.anq != null) {
            this.anq.recycle();
            this.anq = null;
        }
    }
}

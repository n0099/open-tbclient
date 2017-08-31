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
    protected View ane;
    protected LinearLayout anf;
    protected ImageView ang;
    private b anh;
    private a ani;
    private c anj;
    protected AnimationDrawable ank;
    private com.baidu.tieba.b.d.a anl;
    private a.e anm;
    protected com.baidu.tieba.b.b.b ann;
    protected LinearLayout ano;
    protected FrameLayout anp;
    private Bitmap anq;
    private Bitmap anr;
    private Bitmap ans;
    private boolean ant;

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
        this.ane = null;
        this.anf = null;
        this.ang = null;
        this.anh = null;
        this.ani = null;
        this.anj = null;
        this.anq = null;
        this.anr = null;
        this.ans = null;
        this.ant = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lb() {
        this.ane = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.anf = (LinearLayout) this.ane.findViewById(d.h.pull_root);
        this.ano = (LinearLayout) this.anf.findViewById(d.h.cube_container);
        this.anp = (FrameLayout) this.anf.findViewById(d.h.loading_cube);
        this.ang = (ImageView) this.ane.findViewById(d.h.pull_image);
        if (!vF()) {
            this.ank = af.vx().cN(TbadkCoreApplication.getInst().getSkinType());
        }
        this.ang.setBackgroundDrawable(this.ank);
        this.anm = new a.e() { // from class: com.baidu.tbadk.core.view.k.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.ann = new com.baidu.tieba.b.b.b(getContext());
        dq(TbadkCoreApplication.getInst().getSkinType());
        this.anq = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.anr = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.ans = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.anq == null || this.anr == null || this.ans == null) {
            af.vx().aC(false);
        }
        this.ann.a(this.anq, this.anq, this.anr, this.anq, this.anq, this.anq);
        this.anl = new com.baidu.tieba.b.d.a(getContext());
        this.anl.setEGLConfigChooser(this.anm);
        this.anl.setRenderer(this.ann);
        try {
            this.anl.setRenderMode(0);
        } catch (Exception e) {
        }
        this.anp.addView(this.anl);
        this.ann.Wi();
        xe();
        return this.ane;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lc() {
        if (vF()) {
            this.anl.setVisibility(0);
            this.anl.setRenderMode(1);
        } else if (this.ank != null && this.ang != null) {
            this.ank.stop();
            this.ang.setBackgroundDrawable(this.ank.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.anj != null) {
            this.anj.aN(z);
        }
        xe();
        this.ant = true;
        if (vF()) {
            xf();
            this.anl.requestRender();
            this.anl.onResume();
            this.anl.setRenderMode(1);
            if (z) {
                this.ann.Wk();
            }
            this.ann.Wi();
            this.anl.setVisibility(0);
        } else if (this.ank != null && this.ang != null) {
            this.ank.stop();
            this.ang.setBackgroundDrawable(this.ank.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ld() {
        xe();
        if (vF()) {
            if (!this.ant) {
                xf();
            }
            this.anl.requestRender();
            this.anl.onResume();
            this.anl.setVisibility(0);
            this.anl.setRenderMode(1);
            this.ann.Wj();
            this.ann.a(this.anq, this.anq, this.anq, this.anq, this.anq, this.anq);
        } else if (this.ank != null && this.ang != null) {
            this.ank.stop();
            this.ang.setBackgroundDrawable(this.ank);
            this.ang.post(new Runnable() { // from class: com.baidu.tbadk.core.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.ank != null) {
                        k.this.ank.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.ant = false;
        if (vF()) {
            this.ann.a(this.anq, this.anq, this.anr, this.anq, this.anq, this.anq);
            if (this.anl != null) {
                this.anl.setRenderMode(0);
                this.anl.onPause();
            }
        } else if (this.ank != null) {
            this.ank.stop();
        }
        release();
        if (this.ani != null) {
            this.ani.b(this.ane, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.anh != null) {
            this.anh.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void le() {
        if (vF()) {
            this.ann.a(this.anq, this.anq, this.ans, this.anq, this.anq, this.anq);
            this.ann.Wk();
            this.anl.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.anh = bVar;
    }

    public void a(a aVar) {
        this.ani = aVar;
    }

    public void a(c cVar) {
        this.anj = cVar;
    }

    public void dq(int i) {
        if (vF() && this.ann != null) {
            if (this.ann.apS != i) {
                this.ann.hu(aj.getColor(d.e.cp_bg_line_c));
                this.ann.apS = i;
            }
            aj.k(this.ane, d.e.cp_bg_line_c);
            aj.k(this.ano, d.e.cp_bg_line_c);
            aj.k(this.anp, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vF() {
        return af.vx().vF();
    }

    private void xe() {
        if (vF()) {
            if (this.ang != null && this.ano != null) {
                if (this.ang.getVisibility() != 8) {
                    this.ang.setVisibility(8);
                }
                if (this.ano.getVisibility() != 0) {
                    this.ano.setVisibility(0);
                }
            }
        } else if (this.ang != null && this.ano != null) {
            if (this.ang.getVisibility() != 0) {
                this.ang.setVisibility(0);
            }
            if (this.ano.getVisibility() != 8) {
                this.ano.setVisibility(8);
            }
        }
    }

    private void xf() {
        this.anl = new com.baidu.tieba.b.d.a(getContext());
        this.anl.setVisibility(4);
        this.anl.setEGLConfigChooser(this.anm);
        this.ann.a(this.anq, this.anq, this.anr, this.anq, this.anq, this.anq);
        this.anl.setRenderer(this.ann);
        this.anp.removeAllViews();
        this.anp.addView(this.anl);
    }

    private void release() {
        if (vF()) {
            if (this.ank != null) {
                this.ank.stop();
                this.ank = null;
                return;
            }
            return;
        }
        if (this.anq != null) {
            this.anq.recycle();
            this.anq = null;
        }
        if (this.anr != null) {
            this.anr.recycle();
            this.anr = null;
        }
        if (this.ans != null) {
            this.ans.recycle();
            this.ans = null;
        }
    }
}

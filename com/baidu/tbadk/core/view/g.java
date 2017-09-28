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
    private Bitmap amA;
    private boolean amB;
    protected View amm;
    protected LinearLayout amn;
    protected ImageView amo;
    private b amp;
    private a amq;
    private c amr;
    protected AnimationDrawable ams;
    private com.baidu.tieba.b.d.a amt;
    private a.e amu;
    protected com.baidu.tieba.b.b.b amv;
    protected LinearLayout amw;
    protected FrameLayout amx;
    private Bitmap amy;
    private Bitmap amz;

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

    public g(Context context) {
        super(context);
        this.amm = null;
        this.amn = null;
        this.amo = null;
        this.amp = null;
        this.amq = null;
        this.amr = null;
        this.amy = null;
        this.amz = null;
        this.amA = null;
        this.amB = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ld() {
        this.amm = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.amn = (LinearLayout) this.amm.findViewById(d.h.pull_root);
        this.amw = (LinearLayout) this.amn.findViewById(d.h.cube_container);
        this.amx = (FrameLayout) this.amn.findViewById(d.h.loading_cube);
        this.amo = (ImageView) this.amm.findViewById(d.h.pull_image);
        if (!vj()) {
            this.ams = af.vb().cL(TbadkCoreApplication.getInst().getSkinType());
        }
        this.amo.setBackgroundDrawable(this.ams);
        this.amu = new a.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amv = new com.baidu.tieba.b.b.b(getContext());
        dz(TbadkCoreApplication.getInst().getSkinType());
        this.amy = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.amz = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.amA = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.amy == null || this.amz == null || this.amA == null) {
            af.vb().aC(false);
        }
        this.amv.a(this.amy, this.amy, this.amz, this.amy, this.amy, this.amy);
        this.amt = new com.baidu.tieba.b.d.a(getContext());
        this.amt.setEGLConfigChooser(this.amu);
        this.amt.setRenderer(this.amv);
        try {
            this.amt.setRenderMode(0);
        } catch (Exception e) {
        }
        this.amx.addView(this.amt);
        this.amv.WN();
        wD();
        return this.amm;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void le() {
        if (vj()) {
            this.amt.setVisibility(0);
            this.amt.setRenderMode(1);
        } else if (this.ams != null && this.amo != null) {
            this.ams.stop();
            this.amo.setBackgroundDrawable(this.ams.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        if (this.amr != null) {
            this.amr.aN(z);
        }
        wD();
        this.amB = true;
        if (vj()) {
            wE();
            this.amt.requestRender();
            this.amt.onResume();
            this.amt.setRenderMode(1);
            if (z) {
                this.amv.WP();
            }
            this.amv.WN();
            this.amt.setVisibility(0);
        } else if (this.ams != null && this.amo != null) {
            this.ams.stop();
            this.amo.setBackgroundDrawable(this.ams.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lf() {
        wD();
        if (vj()) {
            if (!this.amB) {
                wE();
            }
            this.amt.requestRender();
            this.amt.onResume();
            this.amt.setVisibility(0);
            this.amt.setRenderMode(1);
            this.amv.WO();
            this.amv.a(this.amy, this.amy, this.amy, this.amy, this.amy, this.amy);
        } else if (this.ams != null && this.amo != null) {
            this.ams.stop();
            this.amo.setBackgroundDrawable(this.ams);
            this.amo.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.ams != null) {
                        g.this.ams.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        this.amB = false;
        if (vj()) {
            this.amv.a(this.amy, this.amy, this.amz, this.amy, this.amy, this.amy);
            if (this.amt != null) {
                this.amt.setRenderMode(0);
                this.amt.onPause();
            }
        } else if (this.ams != null) {
            this.ams.stop();
        }
        release();
        if (this.amq != null) {
            this.amq.b(this.amm, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void W(boolean z) {
        if (this.amp != null) {
            this.amp.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lg() {
        if (vj()) {
            this.amv.a(this.amy, this.amy, this.amA, this.amy, this.amy, this.amy);
            this.amv.WP();
            this.amt.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amp = bVar;
    }

    public void a(a aVar) {
        this.amq = aVar;
    }

    public void a(c cVar) {
        this.amr = cVar;
    }

    public void dz(int i) {
        if (vj() && this.amv != null) {
            if (this.amv.aoZ != i) {
                this.amv.hK(aj.getColor(d.e.cp_bg_line_c));
                this.amv.aoZ = i;
            }
            aj.k(this.amm, d.e.cp_bg_line_c);
            aj.k(this.amw, d.e.cp_bg_line_c);
            aj.k(this.amx, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vj() {
        return af.vb().vj();
    }

    private void wD() {
        if (vj()) {
            if (this.amo != null && this.amw != null) {
                if (this.amo.getVisibility() != 8) {
                    this.amo.setVisibility(8);
                }
                if (this.amw.getVisibility() != 0) {
                    this.amw.setVisibility(0);
                }
            }
        } else if (this.amo != null && this.amw != null) {
            if (this.amo.getVisibility() != 0) {
                this.amo.setVisibility(0);
            }
            if (this.amw.getVisibility() != 8) {
                this.amw.setVisibility(8);
            }
        }
    }

    private void wE() {
        this.amt = new com.baidu.tieba.b.d.a(getContext());
        this.amt.setVisibility(4);
        this.amt.setEGLConfigChooser(this.amu);
        this.amv.a(this.amy, this.amy, this.amz, this.amy, this.amy, this.amy);
        this.amt.setRenderer(this.amv);
        this.amx.removeAllViews();
        this.amx.addView(this.amt);
    }

    private void release() {
        if (vj()) {
            if (this.ams != null) {
                this.ams.stop();
                this.ams = null;
                return;
            }
            return;
        }
        if (this.amy != null) {
            this.amy.recycle();
            this.amy = null;
        }
        if (this.amz != null) {
            this.amz.recycle();
            this.amz = null;
        }
        if (this.amA != null) {
            this.amA.recycle();
            this.amA = null;
        }
    }
}

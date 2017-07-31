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
    protected View anJ;
    protected LinearLayout anK;
    protected ImageView anL;
    private b anM;
    private a anN;
    private c anO;
    protected AnimationDrawable anP;
    private com.baidu.tieba.b.d.a anQ;
    private a.e anR;
    protected com.baidu.tieba.b.b.b anS;
    protected LinearLayout anT;
    protected FrameLayout anU;
    private Bitmap anV;
    private Bitmap anW;
    private Bitmap anX;
    private boolean anY;

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
        this.anJ = null;
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.anN = null;
        this.anO = null;
        this.anV = null;
        this.anW = null;
        this.anX = null;
        this.anY = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lk() {
        this.anJ = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.anK = (LinearLayout) this.anJ.findViewById(d.h.pull_root);
        this.anT = (LinearLayout) this.anK.findViewById(d.h.cube_container);
        this.anU = (FrameLayout) this.anK.findViewById(d.h.loading_cube);
        this.anL = (ImageView) this.anJ.findViewById(d.h.pull_image);
        if (!vH()) {
            this.anP = ae.vz().cM(TbadkCoreApplication.getInst().getSkinType());
        }
        this.anL.setBackgroundDrawable(this.anP);
        this.anR = new a.e() { // from class: com.baidu.tbadk.core.view.k.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.anS = new com.baidu.tieba.b.b.b(getContext());
        dp(TbadkCoreApplication.getInst().getSkinType());
        this.anV = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.anW = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.anX = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.anV == null || this.anW == null || this.anX == null) {
            ae.vz().aC(false);
        }
        this.anS.a(this.anV, this.anV, this.anW, this.anV, this.anV, this.anV);
        this.anQ = new com.baidu.tieba.b.d.a(getContext());
        this.anQ.setEGLConfigChooser(this.anR);
        this.anQ.setRenderer(this.anS);
        try {
            this.anQ.setRenderMode(0);
        } catch (Exception e) {
        }
        this.anU.addView(this.anQ);
        this.anS.UM();
        xf();
        return this.anJ;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ll() {
        if (vH()) {
            this.anQ.setVisibility(0);
            this.anQ.setRenderMode(1);
        } else if (this.anP != null && this.anL != null) {
            this.anP.stop();
            this.anL.setBackgroundDrawable(this.anP.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        if (this.anO != null) {
            this.anO.aN(z);
        }
        xf();
        this.anY = true;
        if (vH()) {
            xg();
            this.anQ.requestRender();
            this.anQ.onResume();
            this.anQ.setRenderMode(1);
            if (z) {
                this.anS.UO();
            }
            this.anS.UM();
            this.anQ.setVisibility(0);
        } else if (this.anP != null && this.anL != null) {
            this.anP.stop();
            this.anL.setBackgroundDrawable(this.anP.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lm() {
        xf();
        if (vH()) {
            if (!this.anY) {
                xg();
            }
            this.anQ.requestRender();
            this.anQ.onResume();
            this.anQ.setVisibility(0);
            this.anQ.setRenderMode(1);
            this.anS.UN();
            this.anS.a(this.anV, this.anV, this.anV, this.anV, this.anV, this.anV);
        } else if (this.anP != null && this.anL != null) {
            this.anP.stop();
            this.anL.setBackgroundDrawable(this.anP);
            this.anL.post(new Runnable() { // from class: com.baidu.tbadk.core.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.anP != null) {
                        k.this.anP.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.anY = false;
        if (vH()) {
            this.anS.a(this.anV, this.anV, this.anW, this.anV, this.anV, this.anV);
            if (this.anQ != null) {
                this.anQ.setRenderMode(0);
                this.anQ.onPause();
            }
        } else if (this.anP != null) {
            this.anP.stop();
        }
        release();
        if (this.anN != null) {
            this.anN.b(this.anJ, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        if (this.anM != null) {
            this.anM.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ln() {
        if (vH()) {
            this.anS.a(this.anV, this.anV, this.anX, this.anV, this.anV, this.anV);
            this.anS.UO();
            this.anQ.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.anM = bVar;
    }

    public void a(a aVar) {
        this.anN = aVar;
    }

    public void a(c cVar) {
        this.anO = cVar;
    }

    public void dp(int i) {
        if (vH() && this.anS != null) {
            if (this.anS.aql != i) {
                this.anS.hj(ai.getColor(d.e.cp_bg_line_c));
                this.anS.aql = i;
            }
            ai.k(this.anJ, d.e.cp_bg_line_c);
            ai.k(this.anT, d.e.cp_bg_line_c);
            ai.k(this.anU, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vH() {
        return ae.vz().vH();
    }

    private void xf() {
        if (vH()) {
            if (this.anL != null && this.anT != null) {
                if (this.anL.getVisibility() != 8) {
                    this.anL.setVisibility(8);
                }
                if (this.anT.getVisibility() != 0) {
                    this.anT.setVisibility(0);
                }
            }
        } else if (this.anL != null && this.anT != null) {
            if (this.anL.getVisibility() != 0) {
                this.anL.setVisibility(0);
            }
            if (this.anT.getVisibility() != 8) {
                this.anT.setVisibility(8);
            }
        }
    }

    private void xg() {
        this.anQ = new com.baidu.tieba.b.d.a(getContext());
        this.anQ.setVisibility(4);
        this.anQ.setEGLConfigChooser(this.anR);
        this.anS.a(this.anV, this.anV, this.anW, this.anV, this.anV, this.anV);
        this.anQ.setRenderer(this.anS);
        this.anU.removeAllViews();
        this.anU.addView(this.anQ);
    }

    private void release() {
        if (vH()) {
            if (this.anP != null) {
                this.anP.stop();
                this.anP = null;
                return;
            }
            return;
        }
        if (this.anV != null) {
            this.anV.recycle();
            this.anV = null;
        }
        if (this.anW != null) {
            this.anW.recycle();
            this.anW = null;
        }
        if (this.anX != null) {
            this.anX.recycle();
            this.anX = null;
        }
    }
}

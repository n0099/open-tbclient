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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.animation3d.View.GLTextureView;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout awO;
    protected ImageView awP;
    private b awQ;
    private a awR;
    private c awS;
    protected AnimationDrawable awT;
    private GLTextureView awU;
    private GLTextureView.e awV;
    protected com.baidu.tieba.animation3d.b.b awW;
    protected LinearLayout awX;
    protected FrameLayout awY;
    private Bitmap awZ;
    private Bitmap axa;
    private Bitmap axb;
    private boolean axc;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void c(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aU(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aV(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.awO = null;
        this.awP = null;
        this.awQ = null;
        this.awR = null;
        this.awS = null;
        this.awZ = null;
        this.axa = null;
        this.axb = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.axc = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nn() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.i.tb_pull_view, (ViewGroup) null);
        this.awO = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.awX = (LinearLayout) this.awO.findViewById(d.g.cube_container);
        this.awY = (FrameLayout) this.awO.findViewById(d.g.loading_cube);
        this.awP = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!zt()) {
            this.awT = ag.zl().cK(skinType);
        }
        this.awP.setBackgroundDrawable(this.awT);
        this.awV = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.awW = new com.baidu.tieba.animation3d.b.b(getContext());
        dz(skinType);
        this.awZ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.axa = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.axb = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.awZ == null || this.axa == null || this.axb == null) {
            ag.zl().aJ(false);
        }
        this.awW.a(this.awZ, this.awZ, this.axa, this.awZ, this.awZ, this.awZ);
        this.awU = new GLTextureView(getContext());
        this.awU.setEGLConfigChooser(this.awV);
        this.awU.setRenderer(this.awW);
        try {
            this.awU.setRenderMode(0);
        } catch (Exception e) {
        }
        this.awY.addView(this.awU);
        this.awW.ahw();
        AR();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void no() {
        if (zt()) {
            this.awU.setVisibility(0);
            this.awU.setRenderMode(1);
        } else if (this.awT != null && this.awP != null) {
            this.awT.stop();
            this.awP.setBackgroundDrawable(this.awT.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        if (this.awS != null) {
            this.awS.aV(z);
        }
        AR();
        this.axc = true;
        if (zt()) {
            AS();
            this.awU.requestRender();
            this.awU.onResume();
            this.awU.setRenderMode(1);
            if (z) {
                this.awW.ahy();
            }
            this.awW.ahw();
            this.awU.setVisibility(0);
        } else if (this.awT != null && this.awP != null) {
            this.awT.stop();
            this.awP.setBackgroundDrawable(this.awT.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void np() {
        AR();
        if (zt()) {
            if (!this.axc) {
                AS();
            }
            this.awU.requestRender();
            this.awU.onResume();
            this.awU.setVisibility(0);
            this.awU.setRenderMode(1);
            this.awW.ahx();
            this.awW.a(this.awZ, this.awZ, this.awZ, this.awZ, this.awZ, this.awZ);
        } else if (this.awT != null && this.awP != null) {
            this.awT.stop();
            this.awP.setBackgroundDrawable(this.awT);
            this.awP.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.awT != null) {
                        g.this.awT.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        this.axc = false;
        if (zt()) {
            this.awW.a(this.awZ, this.awZ, this.axa, this.awZ, this.awZ, this.awZ);
            if (this.awU != null) {
                this.awU.setRenderMode(0);
                this.awU.onPause();
            }
        } else if (this.awT != null) {
            this.awT.stop();
        }
        AT();
        if (this.awR != null) {
            this.awR.c(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ab(boolean z) {
        if (this.awQ != null) {
            this.awQ.aU(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        if (zt()) {
            this.awW.a(this.awZ, this.awZ, this.axb, this.awZ, this.awZ, this.awZ);
            this.awW.ahy();
            this.awU.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.awQ = bVar;
    }

    public void a(a aVar) {
        this.awR = aVar;
    }

    public void a(c cVar) {
        this.awS = cVar;
    }

    public void dz(int i) {
        if (zt() && this.awW != null) {
            if (this.awW.azP != i) {
                this.awW.iz(am.getColor(i, d.C0142d.cp_bg_line_e));
                this.awW.azP = i;
                if (this.awU != null) {
                    this.awU.onResume();
                }
            }
            am.e(this.mHeaderView, d.C0142d.cp_bg_line_e, i);
            am.e(this.awX, d.C0142d.cp_bg_line_e, i);
            am.e(this.awY, d.C0142d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zt() {
        return ag.zl().zt();
    }

    private void AR() {
        if (zt()) {
            if (this.awP != null && this.awX != null) {
                if (this.awP.getVisibility() != 8) {
                    this.awP.setVisibility(8);
                }
                if (this.awX.getVisibility() != 0) {
                    this.awX.setVisibility(0);
                }
            }
        } else if (this.awP != null && this.awX != null) {
            if (this.awP.getVisibility() != 0) {
                this.awP.setVisibility(0);
            }
            if (this.awX.getVisibility() != 8) {
                this.awX.setVisibility(8);
            }
        }
    }

    private void AS() {
        this.awU = new GLTextureView(getContext());
        this.awU.setVisibility(4);
        this.awU.setEGLConfigChooser(this.awV);
        this.awW.a(this.awZ, this.awZ, this.axa, this.awZ, this.awZ, this.awZ);
        this.awU.setRenderer(this.awW);
        this.awY.removeAllViews();
        this.awY.addView(this.awU);
    }

    private void AT() {
        if (zt()) {
            if (this.awT != null) {
                this.awT.stop();
                this.awT = null;
                return;
            }
            return;
        }
        if (this.awZ != null) {
            this.awZ.recycle();
            this.awZ = null;
        }
        if (this.axa != null) {
            this.axa.recycle();
            this.axa = null;
        }
        if (this.axb != null) {
            this.axb.recycle();
            this.axb = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long nu() {
        return 2000L;
    }
}

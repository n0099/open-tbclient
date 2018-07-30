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
    private GLTextureView awA;
    private GLTextureView.e awB;
    protected com.baidu.tieba.animation3d.b.b awC;
    protected LinearLayout awD;
    protected FrameLayout awE;
    private Bitmap awF;
    private Bitmap awG;
    private Bitmap awH;
    private boolean awI;
    protected LinearLayout awu;
    protected ImageView awv;
    private b aww;
    private a awx;
    private c awy;
    protected AnimationDrawable awz;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aT(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.awu = null;
        this.awv = null;
        this.aww = null;
        this.awx = null;
        this.awy = null;
        this.awF = null;
        this.awG = null;
        this.awH = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.awI = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.awu = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.awD = (LinearLayout) this.awu.findViewById(d.g.cube_container);
        this.awE = (FrameLayout) this.awu.findViewById(d.g.loading_cube);
        this.awv = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!zk()) {
            this.awz = ag.zc().cM(skinType);
        }
        this.awv.setBackgroundDrawable(this.awz);
        this.awB = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.awC = new com.baidu.tieba.animation3d.b.b(getContext());
        dC(skinType);
        this.awF = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.awG = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.awH = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.awF == null || this.awG == null || this.awH == null) {
            ag.zc().aH(false);
        }
        this.awC.a(this.awF, this.awF, this.awG, this.awF, this.awF, this.awF);
        this.awA = new GLTextureView(getContext());
        this.awA.setEGLConfigChooser(this.awB);
        this.awA.setRenderer(this.awC);
        try {
            this.awA.setRenderMode(0);
        } catch (Exception e) {
        }
        this.awE.addView(this.awA);
        this.awC.ahV();
        AI();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        if (zk()) {
            this.awA.setVisibility(0);
            this.awA.setRenderMode(1);
        } else if (this.awz != null && this.awv != null) {
            this.awz.stop();
            this.awv.setBackgroundDrawable(this.awz.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        if (this.awy != null) {
            this.awy.aT(z);
        }
        AI();
        this.awI = true;
        if (zk()) {
            AJ();
            this.awA.requestRender();
            this.awA.onResume();
            this.awA.setRenderMode(1);
            if (z) {
                this.awC.ahX();
            }
            this.awC.ahV();
            this.awA.setVisibility(0);
        } else if (this.awz != null && this.awv != null) {
            this.awz.stop();
            this.awv.setBackgroundDrawable(this.awz.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nr() {
        AI();
        if (zk()) {
            if (!this.awI) {
                AJ();
            }
            this.awA.requestRender();
            this.awA.onResume();
            this.awA.setVisibility(0);
            this.awA.setRenderMode(1);
            this.awC.ahW();
            this.awC.a(this.awF, this.awF, this.awF, this.awF, this.awF, this.awF);
        } else if (this.awz != null && this.awv != null) {
            this.awz.stop();
            this.awv.setBackgroundDrawable(this.awz);
            this.awv.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.awz != null) {
                        g.this.awz.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        this.awI = false;
        if (zk()) {
            this.awC.a(this.awF, this.awF, this.awG, this.awF, this.awF, this.awF);
            if (this.awA != null) {
                this.awA.setRenderMode(0);
                this.awA.onPause();
            }
        } else if (this.awz != null) {
            this.awz.stop();
        }
        AK();
        if (this.awx != null) {
            this.awx.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        if (this.aww != null) {
            this.aww.aS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ns() {
        if (zk()) {
            this.awC.a(this.awF, this.awF, this.awH, this.awF, this.awF, this.awF);
            this.awC.ahX();
            this.awA.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aww = bVar;
    }

    public void a(a aVar) {
        this.awx = aVar;
    }

    public void a(c cVar) {
        this.awy = cVar;
    }

    public void dC(int i) {
        if (zk() && this.awC != null) {
            if (this.awC.azI != i) {
                this.awC.iK(am.getColor(i, d.C0140d.cp_bg_line_e));
                this.awC.azI = i;
                if (this.awA != null) {
                    this.awA.onResume();
                }
            }
            am.e(this.mHeaderView, d.C0140d.cp_bg_line_e, i);
            am.e(this.awD, d.C0140d.cp_bg_line_e, i);
            am.e(this.awE, d.C0140d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zk() {
        return ag.zc().zk();
    }

    private void AI() {
        if (zk()) {
            if (this.awv != null && this.awD != null) {
                if (this.awv.getVisibility() != 8) {
                    this.awv.setVisibility(8);
                }
                if (this.awD.getVisibility() != 0) {
                    this.awD.setVisibility(0);
                }
            }
        } else if (this.awv != null && this.awD != null) {
            if (this.awv.getVisibility() != 0) {
                this.awv.setVisibility(0);
            }
            if (this.awD.getVisibility() != 8) {
                this.awD.setVisibility(8);
            }
        }
    }

    private void AJ() {
        this.awA = new GLTextureView(getContext());
        this.awA.setVisibility(4);
        this.awA.setEGLConfigChooser(this.awB);
        this.awC.a(this.awF, this.awF, this.awG, this.awF, this.awF, this.awF);
        this.awA.setRenderer(this.awC);
        this.awE.removeAllViews();
        this.awE.addView(this.awA);
    }

    private void AK() {
        if (zk()) {
            if (this.awz != null) {
                this.awz.stop();
                this.awz = null;
                return;
            }
            return;
        }
        if (this.awF != null) {
            this.awF.recycle();
            this.awF = null;
        }
        if (this.awG != null) {
            this.awG.recycle();
            this.awG = null;
        }
        if (this.awH != null) {
            this.awH.recycle();
            this.awH = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long nw() {
        return 2000L;
    }
}

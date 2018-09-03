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
import com.baidu.tieba.f;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout awA;
    protected FrameLayout awB;
    private Bitmap awC;
    private Bitmap awD;
    private Bitmap awE;
    private boolean awF;
    protected LinearLayout awr;
    protected ImageView aws;
    private b awt;
    private a awu;
    private c awv;
    protected AnimationDrawable aww;
    private GLTextureView awx;
    private GLTextureView.e awy;
    protected com.baidu.tieba.animation3d.b.b awz;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aT(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aU(boolean z);
    }

    public g(Context context) {
        super(context);
        this.mHeaderView = null;
        this.awr = null;
        this.aws = null;
        this.awt = null;
        this.awu = null;
        this.awv = null;
        this.awC = null;
        this.awD = null;
        this.awE = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.awF = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(f.h.tb_pull_view, (ViewGroup) null);
        this.awr = (LinearLayout) this.mHeaderView.findViewById(f.g.pull_root);
        this.awA = (LinearLayout) this.awr.findViewById(f.g.cube_container);
        this.awB = (FrameLayout) this.awr.findViewById(f.g.loading_cube);
        this.aws = (ImageView) this.mHeaderView.findViewById(f.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!zi()) {
            this.aww = ag.za().cM(skinType);
        }
        this.aws.setBackgroundDrawable(this.aww);
        this.awy = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.awz = new com.baidu.tieba.animation3d.b.b(getContext());
        dB(skinType);
        this.awC = BitmapHelper.getResBitmapPowerOf2Size(getContext(), f.C0146f.cube_top);
        this.awD = BitmapHelper.getResBitmapPowerOf2Size(getContext(), f.C0146f.btn_frs_post_arrow);
        this.awE = BitmapHelper.getResBitmapPowerOf2Size(getContext(), f.C0146f.btn_frs_post_ok);
        if (this.awC == null || this.awD == null || this.awE == null) {
            ag.za().aI(false);
        }
        this.awz.a(this.awC, this.awC, this.awD, this.awC, this.awC, this.awC);
        this.awx = new GLTextureView(getContext());
        this.awx.setEGLConfigChooser(this.awy);
        this.awx.setRenderer(this.awz);
        try {
            this.awx.setRenderMode(0);
        } catch (Exception e) {
        }
        this.awB.addView(this.awx);
        this.awz.ahY();
        AF();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (zi()) {
            this.awx.setVisibility(0);
            this.awx.setRenderMode(1);
        } else if (this.aww != null && this.aws != null) {
            this.aww.stop();
            this.aws.setBackgroundDrawable(this.aww.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        if (this.awv != null) {
            this.awv.aU(z);
        }
        AF();
        this.awF = true;
        if (zi()) {
            AG();
            this.awx.requestRender();
            this.awx.onResume();
            this.awx.setRenderMode(1);
            if (z) {
                this.awz.aia();
            }
            this.awz.ahY();
            this.awx.setVisibility(0);
        } else if (this.aww != null && this.aws != null) {
            this.aww.stop();
            this.aws.setBackgroundDrawable(this.aww.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        AF();
        if (zi()) {
            if (!this.awF) {
                AG();
            }
            this.awx.requestRender();
            this.awx.onResume();
            this.awx.setVisibility(0);
            this.awx.setRenderMode(1);
            this.awz.ahZ();
            this.awz.a(this.awC, this.awC, this.awC, this.awC, this.awC, this.awC);
        } else if (this.aww != null && this.aws != null) {
            this.aww.stop();
            this.aws.setBackgroundDrawable(this.aww);
            this.aws.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.aww != null) {
                        g.this.aww.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        this.awF = false;
        if (zi()) {
            this.awz.a(this.awC, this.awC, this.awD, this.awC, this.awC, this.awC);
            if (this.awx != null) {
                this.awx.setRenderMode(0);
                this.awx.onPause();
            }
        } else if (this.aww != null) {
            this.aww.stop();
        }
        AH();
        if (this.awu != null) {
            this.awu.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        if (this.awt != null) {
            this.awt.aT(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        if (zi()) {
            this.awz.a(this.awC, this.awC, this.awE, this.awC, this.awC, this.awC);
            this.awz.aia();
            this.awx.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.awt = bVar;
    }

    public void a(a aVar) {
        this.awu = aVar;
    }

    public void a(c cVar) {
        this.awv = cVar;
    }

    public void dB(int i) {
        if (zi() && this.awz != null) {
            if (this.awz.azF != i) {
                this.awz.iJ(am.getColor(i, f.d.cp_bg_line_e));
                this.awz.azF = i;
                if (this.awx != null) {
                    this.awx.onResume();
                }
            }
            am.e(this.mHeaderView, f.d.cp_bg_line_e, i);
            am.e(this.awA, f.d.cp_bg_line_e, i);
            am.e(this.awB, f.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zi() {
        return ag.za().zi();
    }

    private void AF() {
        if (zi()) {
            if (this.aws != null && this.awA != null) {
                if (this.aws.getVisibility() != 8) {
                    this.aws.setVisibility(8);
                }
                if (this.awA.getVisibility() != 0) {
                    this.awA.setVisibility(0);
                }
            }
        } else if (this.aws != null && this.awA != null) {
            if (this.aws.getVisibility() != 0) {
                this.aws.setVisibility(0);
            }
            if (this.awA.getVisibility() != 8) {
                this.awA.setVisibility(8);
            }
        }
    }

    private void AG() {
        this.awx = new GLTextureView(getContext());
        this.awx.setVisibility(4);
        this.awx.setEGLConfigChooser(this.awy);
        this.awz.a(this.awC, this.awC, this.awD, this.awC, this.awC, this.awC);
        this.awx.setRenderer(this.awz);
        this.awB.removeAllViews();
        this.awB.addView(this.awx);
    }

    private void AH() {
        if (zi()) {
            if (this.aww != null) {
                this.aww.stop();
                this.aww = null;
                return;
            }
            return;
        }
        if (this.awC != null) {
            this.awC.recycle();
            this.awC = null;
        }
        if (this.awD != null) {
            this.awD.recycle();
            this.awD = null;
        }
        if (this.awE != null) {
            this.awE.recycle();
            this.awE = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long nu() {
        return 2000L;
    }
}

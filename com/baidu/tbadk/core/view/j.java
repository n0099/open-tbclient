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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.animation3d.View.GLTextureView;
import com.baidu.tieba.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.c {
    private boolean aEA;
    protected LinearLayout aEm;
    protected ImageView aEn;
    private b aEo;
    private a aEp;
    private c aEq;
    protected AnimationDrawable aEr;
    private GLTextureView aEs;
    private GLTextureView.e aEt;
    protected com.baidu.tieba.animation3d.b.b aEu;
    protected LinearLayout aEv;
    protected FrameLayout aEw;
    private Bitmap aEx;
    private Bitmap aEy;
    private Bitmap aEz;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bq(boolean z);
    }

    public j(Context context) {
        super(context);
        this.mHeaderView = null;
        this.aEm = null;
        this.aEn = null;
        this.aEo = null;
        this.aEp = null;
        this.aEq = null;
        this.aEx = null;
        this.aEy = null;
        this.aEz = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aEA = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oG() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aEm = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aEv = (LinearLayout) this.aEm.findViewById(e.g.cube_container);
        this.aEw = (FrameLayout) this.aEm.findViewById(e.g.loading_cube);
        this.aEn = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!Cu()) {
            this.aEr = af.Cm().df(skinType);
        }
        this.aEn.setBackgroundDrawable(this.aEr);
        this.aEt = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aEu = new com.baidu.tieba.animation3d.b.b(getContext());
        dW(skinType);
        this.aEx = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aEy = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aEz = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aEx == null || this.aEy == null || this.aEz == null) {
            af.Cm().bc(false);
        }
        this.aEu.a(this.aEx, this.aEx, this.aEy, this.aEx, this.aEx, this.aEx);
        this.aEs = new GLTextureView(getContext());
        this.aEs.setEGLConfigChooser(this.aEt);
        this.aEs.setRenderer(this.aEu);
        try {
            this.aEs.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aEw.addView(this.aEs);
        this.aEu.anp();
        DX();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (Cu()) {
            this.aEs.setVisibility(0);
            this.aEs.setRenderMode(1);
        } else if (this.aEr != null && this.aEn != null) {
            this.aEr.stop();
            this.aEn.setBackgroundDrawable(this.aEr.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ah(boolean z) {
        if (this.aEq != null) {
            this.aEq.bq(z);
        }
        DX();
        this.aEA = true;
        if (Cu()) {
            DY();
            this.aEs.requestRender();
            this.aEs.onResume();
            this.aEs.setRenderMode(1);
            if (z) {
                this.aEu.anr();
            }
            this.aEu.anp();
            this.aEs.setVisibility(0);
        } else if (this.aEr != null && this.aEn != null) {
            this.aEr.stop();
            this.aEn.setBackgroundDrawable(this.aEr.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        DX();
        if (Cu()) {
            if (!this.aEA) {
                DY();
            }
            this.aEs.requestRender();
            this.aEs.onResume();
            this.aEs.setVisibility(0);
            this.aEs.setRenderMode(1);
            this.aEu.anq();
            this.aEu.a(this.aEx, this.aEx, this.aEx, this.aEx, this.aEx, this.aEx);
        } else if (this.aEr != null && this.aEn != null) {
            this.aEr.stop();
            this.aEn.setBackgroundDrawable(this.aEr);
            this.aEn.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aEr != null) {
                        j.this.aEr.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ai(boolean z) {
        this.aEA = false;
        if (Cu()) {
            this.aEu.a(this.aEx, this.aEx, this.aEy, this.aEx, this.aEx, this.aEx);
            if (this.aEs != null) {
                this.aEs.setRenderMode(0);
                this.aEs.onPause();
            }
        } else if (this.aEr != null) {
            this.aEr.stop();
        }
        DZ();
        if (this.aEp != null) {
            this.aEp.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aj(boolean z) {
        if (this.aEo != null) {
            this.aEo.bp(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oH() {
        if (Cu()) {
            this.aEu.a(this.aEx, this.aEx, this.aEz, this.aEx, this.aEx, this.aEx);
            this.aEu.anr();
            this.aEs.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aEo = bVar;
    }

    public void a(a aVar) {
        this.aEp = aVar;
    }

    public void a(c cVar) {
        this.aEq = cVar;
    }

    public void dW(int i) {
        if (Cu() && this.aEu != null) {
            if (this.aEu.aHp != i) {
                this.aEu.jH(al.getColor(i, e.d.cp_bg_line_e));
                this.aEu.aHp = i;
                if (this.aEs != null) {
                    this.aEs.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aEv, e.d.cp_bg_line_e, i);
            al.e(this.aEw, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Cu() {
        return af.Cm().Cu();
    }

    private void DX() {
        if (Cu()) {
            if (this.aEn != null && this.aEv != null) {
                if (this.aEn.getVisibility() != 8) {
                    this.aEn.setVisibility(8);
                }
                if (this.aEv.getVisibility() != 0) {
                    this.aEv.setVisibility(0);
                }
            }
        } else if (this.aEn != null && this.aEv != null) {
            if (this.aEn.getVisibility() != 0) {
                this.aEn.setVisibility(0);
            }
            if (this.aEv.getVisibility() != 8) {
                this.aEv.setVisibility(8);
            }
        }
    }

    private void DY() {
        if (this.aEs != null) {
            this.aEs = new GLTextureView(getContext());
            this.aEs.setVisibility(4);
            this.aEs.setEGLConfigChooser(this.aEt);
            this.aEu.a(this.aEx, this.aEx, this.aEy, this.aEx, this.aEx, this.aEx);
            this.aEs.setRenderer(this.aEu);
            this.aEw.removeAllViews();
            this.aEw.addView(this.aEs);
        }
    }

    private void DZ() {
        if (Cu()) {
            if (this.aEr != null) {
                this.aEr.stop();
                this.aEr = null;
                return;
            }
            return;
        }
        if (this.aEx != null) {
            this.aEx.recycle();
            this.aEx = null;
        }
        if (this.aEy != null) {
            this.aEy.recycle();
            this.aEy = null;
        }
        if (this.aEz != null) {
            this.aEz.recycle();
            this.aEz = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oK() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

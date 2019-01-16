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
    protected LinearLayout aJf;
    protected ImageView aJg;
    private b aJh;
    private a aJi;
    private c aJj;
    protected AnimationDrawable aJk;
    private GLTextureView aJl;
    private GLTextureView.e aJm;
    protected com.baidu.tieba.animation3d.b.b aJn;
    protected LinearLayout aJo;
    protected FrameLayout aJp;
    private Bitmap aJq;
    private Bitmap aJr;
    private Bitmap aJs;
    private boolean aJt;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bI(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bJ(boolean z);
    }

    public j(Context context) {
        super(context);
        this.mHeaderView = null;
        this.aJf = null;
        this.aJg = null;
        this.aJh = null;
        this.aJi = null;
        this.aJj = null;
        this.aJq = null;
        this.aJr = null;
        this.aJs = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aJt = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oH() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aJf = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aJo = (LinearLayout) this.aJf.findViewById(e.g.cube_container);
        this.aJp = (FrameLayout) this.aJf.findViewById(e.g.loading_cube);
        this.aJg = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!DS()) {
            this.aJk = af.DK().dH(skinType);
        }
        this.aJg.setBackgroundDrawable(this.aJk);
        this.aJm = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aJn = new com.baidu.tieba.animation3d.b.b(getContext());
        ey(skinType);
        this.aJq = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aJr = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aJs = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aJq == null || this.aJr == null || this.aJs == null) {
            af.DK().bu(false);
        }
        this.aJn.a(this.aJq, this.aJq, this.aJr, this.aJq, this.aJq, this.aJq);
        this.aJl = new GLTextureView(getContext());
        this.aJl.setEGLConfigChooser(this.aJm);
        this.aJl.setRenderer(this.aJn);
        try {
            this.aJl.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aJp.addView(this.aJl);
        this.aJn.apO();
        Fy();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (DS()) {
            this.aJl.setVisibility(0);
            this.aJl.setRenderMode(1);
        } else if (this.aJk != null && this.aJg != null) {
            this.aJk.stop();
            this.aJg.setBackgroundDrawable(this.aJk.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        if (this.aJj != null) {
            this.aJj.bJ(z);
        }
        Fy();
        this.aJt = true;
        if (DS()) {
            Fz();
            this.aJl.requestRender();
            this.aJl.onResume();
            this.aJl.setRenderMode(1);
            if (z) {
                this.aJn.apQ();
            }
            this.aJn.apO();
            this.aJl.setVisibility(0);
        } else if (this.aJk != null && this.aJg != null) {
            this.aJk.stop();
            this.aJg.setBackgroundDrawable(this.aJk.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        Fy();
        if (DS()) {
            if (!this.aJt) {
                Fz();
            }
            this.aJl.requestRender();
            this.aJl.onResume();
            this.aJl.setVisibility(0);
            this.aJl.setRenderMode(1);
            this.aJn.apP();
            this.aJn.a(this.aJq, this.aJq, this.aJq, this.aJq, this.aJq, this.aJq);
        } else if (this.aJk != null && this.aJg != null) {
            this.aJk.stop();
            this.aJg.setBackgroundDrawable(this.aJk);
            this.aJg.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aJk != null) {
                        j.this.aJk.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aJt = false;
        if (DS()) {
            this.aJn.a(this.aJq, this.aJq, this.aJr, this.aJq, this.aJq, this.aJq);
            if (this.aJl != null) {
                this.aJl.setRenderMode(0);
                this.aJl.onPause();
            }
        } else if (this.aJk != null) {
            this.aJk.stop();
        }
        FA();
        if (this.aJi != null) {
            this.aJi.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aJh != null) {
            this.aJh.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oI() {
        if (DS()) {
            this.aJn.a(this.aJq, this.aJq, this.aJs, this.aJq, this.aJq, this.aJq);
            this.aJn.apQ();
            this.aJl.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aJh = bVar;
    }

    public void a(a aVar) {
        this.aJi = aVar;
    }

    public void a(c cVar) {
        this.aJj = cVar;
    }

    public void ey(int i) {
        if (DS() && this.aJn != null) {
            if (this.aJn.aMj != i) {
                this.aJn.kC(al.getColor(i, e.d.cp_bg_line_e));
                this.aJn.aMj = i;
                if (this.aJl != null) {
                    this.aJl.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aJo, e.d.cp_bg_line_e, i);
            al.e(this.aJp, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DS() {
        return af.DK().DS();
    }

    private void Fy() {
        if (DS()) {
            if (this.aJg != null && this.aJo != null) {
                if (this.aJg.getVisibility() != 8) {
                    this.aJg.setVisibility(8);
                }
                if (this.aJo.getVisibility() != 0) {
                    this.aJo.setVisibility(0);
                }
            }
        } else if (this.aJg != null && this.aJo != null) {
            if (this.aJg.getVisibility() != 0) {
                this.aJg.setVisibility(0);
            }
            if (this.aJo.getVisibility() != 8) {
                this.aJo.setVisibility(8);
            }
        }
    }

    private void Fz() {
        if (this.aJl != null) {
            this.aJl = new GLTextureView(getContext());
            this.aJl.setVisibility(4);
            this.aJl.setEGLConfigChooser(this.aJm);
            this.aJn.a(this.aJq, this.aJq, this.aJr, this.aJq, this.aJq, this.aJq);
            this.aJl.setRenderer(this.aJn);
            this.aJp.removeAllViews();
            this.aJp.addView(this.aJl);
        }
    }

    private void FA() {
        if (DS()) {
            if (this.aJk != null) {
                this.aJk.stop();
                this.aJk = null;
                return;
            }
            return;
        }
        if (this.aJq != null) {
            this.aJq.recycle();
            this.aJq = null;
        }
        if (this.aJr != null) {
            this.aJr.recycle();
            this.aJr = null;
        }
        if (this.aJs != null) {
            this.aJs.recycle();
            this.aJs = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oL() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

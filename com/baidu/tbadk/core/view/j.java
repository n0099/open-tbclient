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
    protected LinearLayout aJg;
    protected ImageView aJh;
    private b aJi;
    private a aJj;
    private c aJk;
    protected AnimationDrawable aJl;
    private GLTextureView aJm;
    private GLTextureView.e aJn;
    protected com.baidu.tieba.animation3d.b.b aJo;
    protected LinearLayout aJp;
    protected FrameLayout aJq;
    private Bitmap aJr;
    private Bitmap aJs;
    private Bitmap aJt;
    private boolean aJu;
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
        this.aJg = null;
        this.aJh = null;
        this.aJi = null;
        this.aJj = null;
        this.aJk = null;
        this.aJr = null;
        this.aJs = null;
        this.aJt = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aJu = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oH() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aJg = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aJp = (LinearLayout) this.aJg.findViewById(e.g.cube_container);
        this.aJq = (FrameLayout) this.aJg.findViewById(e.g.loading_cube);
        this.aJh = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!DS()) {
            this.aJl = af.DK().dH(skinType);
        }
        this.aJh.setBackgroundDrawable(this.aJl);
        this.aJn = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aJo = new com.baidu.tieba.animation3d.b.b(getContext());
        ey(skinType);
        this.aJr = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aJs = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aJt = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aJr == null || this.aJs == null || this.aJt == null) {
            af.DK().bu(false);
        }
        this.aJo.a(this.aJr, this.aJr, this.aJs, this.aJr, this.aJr, this.aJr);
        this.aJm = new GLTextureView(getContext());
        this.aJm.setEGLConfigChooser(this.aJn);
        this.aJm.setRenderer(this.aJo);
        try {
            this.aJm.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aJq.addView(this.aJm);
        this.aJo.apO();
        Fy();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (DS()) {
            this.aJm.setVisibility(0);
            this.aJm.setRenderMode(1);
        } else if (this.aJl != null && this.aJh != null) {
            this.aJl.stop();
            this.aJh.setBackgroundDrawable(this.aJl.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        if (this.aJk != null) {
            this.aJk.bJ(z);
        }
        Fy();
        this.aJu = true;
        if (DS()) {
            Fz();
            this.aJm.requestRender();
            this.aJm.onResume();
            this.aJm.setRenderMode(1);
            if (z) {
                this.aJo.apQ();
            }
            this.aJo.apO();
            this.aJm.setVisibility(0);
        } else if (this.aJl != null && this.aJh != null) {
            this.aJl.stop();
            this.aJh.setBackgroundDrawable(this.aJl.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        Fy();
        if (DS()) {
            if (!this.aJu) {
                Fz();
            }
            this.aJm.requestRender();
            this.aJm.onResume();
            this.aJm.setVisibility(0);
            this.aJm.setRenderMode(1);
            this.aJo.apP();
            this.aJo.a(this.aJr, this.aJr, this.aJr, this.aJr, this.aJr, this.aJr);
        } else if (this.aJl != null && this.aJh != null) {
            this.aJl.stop();
            this.aJh.setBackgroundDrawable(this.aJl);
            this.aJh.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aJl != null) {
                        j.this.aJl.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aJu = false;
        if (DS()) {
            this.aJo.a(this.aJr, this.aJr, this.aJs, this.aJr, this.aJr, this.aJr);
            if (this.aJm != null) {
                this.aJm.setRenderMode(0);
                this.aJm.onPause();
            }
        } else if (this.aJl != null) {
            this.aJl.stop();
        }
        FA();
        if (this.aJj != null) {
            this.aJj.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aJi != null) {
            this.aJi.bI(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oI() {
        if (DS()) {
            this.aJo.a(this.aJr, this.aJr, this.aJt, this.aJr, this.aJr, this.aJr);
            this.aJo.apQ();
            this.aJm.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aJi = bVar;
    }

    public void a(a aVar) {
        this.aJj = aVar;
    }

    public void a(c cVar) {
        this.aJk = cVar;
    }

    public void ey(int i) {
        if (DS() && this.aJo != null) {
            if (this.aJo.aMk != i) {
                this.aJo.kC(al.getColor(i, e.d.cp_bg_line_e));
                this.aJo.aMk = i;
                if (this.aJm != null) {
                    this.aJm.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aJp, e.d.cp_bg_line_e, i);
            al.e(this.aJq, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DS() {
        return af.DK().DS();
    }

    private void Fy() {
        if (DS()) {
            if (this.aJh != null && this.aJp != null) {
                if (this.aJh.getVisibility() != 8) {
                    this.aJh.setVisibility(8);
                }
                if (this.aJp.getVisibility() != 0) {
                    this.aJp.setVisibility(0);
                }
            }
        } else if (this.aJh != null && this.aJp != null) {
            if (this.aJh.getVisibility() != 0) {
                this.aJh.setVisibility(0);
            }
            if (this.aJp.getVisibility() != 8) {
                this.aJp.setVisibility(8);
            }
        }
    }

    private void Fz() {
        if (this.aJm != null) {
            this.aJm = new GLTextureView(getContext());
            this.aJm.setVisibility(4);
            this.aJm.setEGLConfigChooser(this.aJn);
            this.aJo.a(this.aJr, this.aJr, this.aJs, this.aJr, this.aJr, this.aJr);
            this.aJm.setRenderer(this.aJo);
            this.aJq.removeAllViews();
            this.aJq.addView(this.aJm);
        }
    }

    private void FA() {
        if (DS()) {
            if (this.aJl != null) {
                this.aJl.stop();
                this.aJl = null;
                return;
            }
            return;
        }
        if (this.aJr != null) {
            this.aJr.recycle();
            this.aJr = null;
        }
        if (this.aJs != null) {
            this.aJs.recycle();
            this.aJs = null;
        }
        if (this.aJt != null) {
            this.aJt.recycle();
            this.aJt = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oL() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

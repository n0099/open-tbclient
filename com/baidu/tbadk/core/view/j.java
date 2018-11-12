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
    protected LinearLayout aFc;
    protected ImageView aFd;
    private b aFe;
    private a aFf;
    private c aFg;
    protected AnimationDrawable aFh;
    private GLTextureView aFi;
    private GLTextureView.e aFj;
    protected com.baidu.tieba.animation3d.b.b aFk;
    protected LinearLayout aFl;
    protected FrameLayout aFm;
    private Bitmap aFn;
    private Bitmap aFo;
    private Bitmap aFp;
    private boolean aFq;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bG(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bH(boolean z);
    }

    public j(Context context) {
        super(context);
        this.mHeaderView = null;
        this.aFc = null;
        this.aFd = null;
        this.aFe = null;
        this.aFf = null;
        this.aFg = null;
        this.aFn = null;
        this.aFo = null;
        this.aFp = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aFq = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oE() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aFc = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aFl = (LinearLayout) this.aFc.findViewById(e.g.cube_container);
        this.aFm = (FrameLayout) this.aFc.findViewById(e.g.loading_cube);
        this.aFd = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CB()) {
            this.aFh = af.Ct().dt(skinType);
        }
        this.aFd.setBackgroundDrawable(this.aFh);
        this.aFj = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aFk = new com.baidu.tieba.animation3d.b.b(getContext());
        ek(skinType);
        this.aFn = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aFo = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aFp = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aFn == null || this.aFo == null || this.aFp == null) {
            af.Ct().bs(false);
        }
        this.aFk.a(this.aFn, this.aFn, this.aFo, this.aFn, this.aFn, this.aFn);
        this.aFi = new GLTextureView(getContext());
        this.aFi.setEGLConfigChooser(this.aFj);
        this.aFi.setRenderer(this.aFk);
        try {
            this.aFi.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aFm.addView(this.aFi);
        this.aFk.amP();
        Eh();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (CB()) {
            this.aFi.setVisibility(0);
            this.aFi.setRenderMode(1);
        } else if (this.aFh != null && this.aFd != null) {
            this.aFh.stop();
            this.aFd.setBackgroundDrawable(this.aFh.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        if (this.aFg != null) {
            this.aFg.bH(z);
        }
        Eh();
        this.aFq = true;
        if (CB()) {
            Ei();
            this.aFi.requestRender();
            this.aFi.onResume();
            this.aFi.setRenderMode(1);
            if (z) {
                this.aFk.amR();
            }
            this.aFk.amP();
            this.aFi.setVisibility(0);
        } else if (this.aFh != null && this.aFd != null) {
            this.aFh.stop();
            this.aFd.setBackgroundDrawable(this.aFh.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        Eh();
        if (CB()) {
            if (!this.aFq) {
                Ei();
            }
            this.aFi.requestRender();
            this.aFi.onResume();
            this.aFi.setVisibility(0);
            this.aFi.setRenderMode(1);
            this.aFk.amQ();
            this.aFk.a(this.aFn, this.aFn, this.aFn, this.aFn, this.aFn, this.aFn);
        } else if (this.aFh != null && this.aFd != null) {
            this.aFh.stop();
            this.aFd.setBackgroundDrawable(this.aFh);
            this.aFd.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aFh != null) {
                        j.this.aFh.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aFq = false;
        if (CB()) {
            this.aFk.a(this.aFn, this.aFn, this.aFo, this.aFn, this.aFn, this.aFn);
            if (this.aFi != null) {
                this.aFi.setRenderMode(0);
                this.aFi.onPause();
            }
        } else if (this.aFh != null) {
            this.aFh.stop();
        }
        Ej();
        if (this.aFf != null) {
            this.aFf.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aFe != null) {
            this.aFe.bG(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oF() {
        if (CB()) {
            this.aFk.a(this.aFn, this.aFn, this.aFp, this.aFn, this.aFn, this.aFn);
            this.aFk.amR();
            this.aFi.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aFe = bVar;
    }

    public void a(a aVar) {
        this.aFf = aVar;
    }

    public void a(c cVar) {
        this.aFg = cVar;
    }

    public void ek(int i) {
        if (CB() && this.aFk != null) {
            if (this.aFk.aIf != i) {
                this.aFk.ka(al.getColor(i, e.d.cp_bg_line_e));
                this.aFk.aIf = i;
                if (this.aFi != null) {
                    this.aFi.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aFl, e.d.cp_bg_line_e, i);
            al.e(this.aFm, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CB() {
        return af.Ct().CB();
    }

    private void Eh() {
        if (CB()) {
            if (this.aFd != null && this.aFl != null) {
                if (this.aFd.getVisibility() != 8) {
                    this.aFd.setVisibility(8);
                }
                if (this.aFl.getVisibility() != 0) {
                    this.aFl.setVisibility(0);
                }
            }
        } else if (this.aFd != null && this.aFl != null) {
            if (this.aFd.getVisibility() != 0) {
                this.aFd.setVisibility(0);
            }
            if (this.aFl.getVisibility() != 8) {
                this.aFl.setVisibility(8);
            }
        }
    }

    private void Ei() {
        if (this.aFi != null) {
            this.aFi = new GLTextureView(getContext());
            this.aFi.setVisibility(4);
            this.aFi.setEGLConfigChooser(this.aFj);
            this.aFk.a(this.aFn, this.aFn, this.aFo, this.aFn, this.aFn, this.aFn);
            this.aFi.setRenderer(this.aFk);
            this.aFm.removeAllViews();
            this.aFm.addView(this.aFi);
        }
    }

    private void Ej() {
        if (CB()) {
            if (this.aFh != null) {
                this.aFh.stop();
                this.aFh = null;
                return;
            }
            return;
        }
        if (this.aFn != null) {
            this.aFn.recycle();
            this.aFn = null;
        }
        if (this.aFo != null) {
            this.aFo.recycle();
            this.aFo = null;
        }
        if (this.aFp != null) {
            this.aFp.recycle();
            this.aFp = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oI() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

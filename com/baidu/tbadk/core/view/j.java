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
    protected LinearLayout aID;
    protected ImageView aIE;
    private b aIF;
    private a aIG;
    private c aIH;
    protected AnimationDrawable aII;
    private GLTextureView aIJ;
    private GLTextureView.e aIK;
    protected com.baidu.tieba.animation3d.b.b aIL;
    protected LinearLayout aIM;
    protected FrameLayout aIN;
    private Bitmap aIO;
    private Bitmap aIP;
    private Bitmap aIQ;
    private boolean aIR;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bH(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bI(boolean z);
    }

    public j(Context context) {
        super(context);
        this.mHeaderView = null;
        this.aID = null;
        this.aIE = null;
        this.aIF = null;
        this.aIG = null;
        this.aIH = null;
        this.aIO = null;
        this.aIP = null;
        this.aIQ = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aIR = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oD() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aID = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aIM = (LinearLayout) this.aID.findViewById(e.g.cube_container);
        this.aIN = (FrameLayout) this.aID.findViewById(e.g.loading_cube);
        this.aIE = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!DF()) {
            this.aII = af.Dx().dH(skinType);
        }
        this.aIE.setBackgroundDrawable(this.aII);
        this.aIK = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aIL = new com.baidu.tieba.animation3d.b.b(getContext());
        ey(skinType);
        this.aIO = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aIP = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aIQ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aIO == null || this.aIP == null || this.aIQ == null) {
            af.Dx().bt(false);
        }
        this.aIL.a(this.aIO, this.aIO, this.aIP, this.aIO, this.aIO, this.aIO);
        this.aIJ = new GLTextureView(getContext());
        this.aIJ.setEGLConfigChooser(this.aIK);
        this.aIJ.setRenderer(this.aIL);
        try {
            this.aIJ.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aIN.addView(this.aIJ);
        this.aIL.apr();
        Fl();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (DF()) {
            this.aIJ.setVisibility(0);
            this.aIJ.setRenderMode(1);
        } else if (this.aII != null && this.aIE != null) {
            this.aII.stop();
            this.aIE.setBackgroundDrawable(this.aII.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        if (this.aIH != null) {
            this.aIH.bI(z);
        }
        Fl();
        this.aIR = true;
        if (DF()) {
            Fm();
            this.aIJ.requestRender();
            this.aIJ.onResume();
            this.aIJ.setRenderMode(1);
            if (z) {
                this.aIL.apt();
            }
            this.aIL.apr();
            this.aIJ.setVisibility(0);
        } else if (this.aII != null && this.aIE != null) {
            this.aII.stop();
            this.aIE.setBackgroundDrawable(this.aII.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        Fl();
        if (DF()) {
            if (!this.aIR) {
                Fm();
            }
            this.aIJ.requestRender();
            this.aIJ.onResume();
            this.aIJ.setVisibility(0);
            this.aIJ.setRenderMode(1);
            this.aIL.aps();
            this.aIL.a(this.aIO, this.aIO, this.aIO, this.aIO, this.aIO, this.aIO);
        } else if (this.aII != null && this.aIE != null) {
            this.aII.stop();
            this.aIE.setBackgroundDrawable(this.aII);
            this.aIE.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aII != null) {
                        j.this.aII.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aIR = false;
        if (DF()) {
            this.aIL.a(this.aIO, this.aIO, this.aIP, this.aIO, this.aIO, this.aIO);
            if (this.aIJ != null) {
                this.aIJ.setRenderMode(0);
                this.aIJ.onPause();
            }
        } else if (this.aII != null) {
            this.aII.stop();
        }
        Fn();
        if (this.aIG != null) {
            this.aIG.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aIF != null) {
            this.aIF.bH(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oE() {
        if (DF()) {
            this.aIL.a(this.aIO, this.aIO, this.aIQ, this.aIO, this.aIO, this.aIO);
            this.aIL.apt();
            this.aIJ.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aIF = bVar;
    }

    public void a(a aVar) {
        this.aIG = aVar;
    }

    public void a(c cVar) {
        this.aIH = cVar;
    }

    public void ey(int i) {
        if (DF() && this.aIL != null) {
            if (this.aIL.aLH != i) {
                this.aIL.kC(al.getColor(i, e.d.cp_bg_line_e));
                this.aIL.aLH = i;
                if (this.aIJ != null) {
                    this.aIJ.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aIM, e.d.cp_bg_line_e, i);
            al.e(this.aIN, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DF() {
        return af.Dx().DF();
    }

    private void Fl() {
        if (DF()) {
            if (this.aIE != null && this.aIM != null) {
                if (this.aIE.getVisibility() != 8) {
                    this.aIE.setVisibility(8);
                }
                if (this.aIM.getVisibility() != 0) {
                    this.aIM.setVisibility(0);
                }
            }
        } else if (this.aIE != null && this.aIM != null) {
            if (this.aIE.getVisibility() != 0) {
                this.aIE.setVisibility(0);
            }
            if (this.aIM.getVisibility() != 8) {
                this.aIM.setVisibility(8);
            }
        }
    }

    private void Fm() {
        if (this.aIJ != null) {
            this.aIJ = new GLTextureView(getContext());
            this.aIJ.setVisibility(4);
            this.aIJ.setEGLConfigChooser(this.aIK);
            this.aIL.a(this.aIO, this.aIO, this.aIP, this.aIO, this.aIO, this.aIO);
            this.aIJ.setRenderer(this.aIL);
            this.aIN.removeAllViews();
            this.aIN.addView(this.aIJ);
        }
    }

    private void Fn() {
        if (DF()) {
            if (this.aII != null) {
                this.aII.stop();
                this.aII = null;
                return;
            }
            return;
        }
        if (this.aIO != null) {
            this.aIO.recycle();
            this.aIO = null;
        }
        if (this.aIP != null) {
            this.aIP.recycle();
            this.aIP = null;
        }
        if (this.aIQ != null) {
            this.aIQ.recycle();
            this.aIQ = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oH() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

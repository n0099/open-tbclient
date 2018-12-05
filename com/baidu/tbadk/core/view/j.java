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
    protected LinearLayout aIC;
    protected ImageView aID;
    private b aIE;
    private a aIF;
    private c aIG;
    protected AnimationDrawable aIH;
    private GLTextureView aII;
    private GLTextureView.e aIJ;
    protected com.baidu.tieba.animation3d.b.b aIK;
    protected LinearLayout aIL;
    protected FrameLayout aIM;
    private Bitmap aIN;
    private Bitmap aIO;
    private Bitmap aIP;
    private boolean aIQ;
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
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.aIF = null;
        this.aIG = null;
        this.aIN = null;
        this.aIO = null;
        this.aIP = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aIQ = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View oD() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.aIC = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.aIL = (LinearLayout) this.aIC.findViewById(e.g.cube_container);
        this.aIM = (FrameLayout) this.aIC.findViewById(e.g.loading_cube);
        this.aID = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!DF()) {
            this.aIH = af.Dx().dH(skinType);
        }
        this.aID.setBackgroundDrawable(this.aIH);
        this.aIJ = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aIK = new com.baidu.tieba.animation3d.b.b(getContext());
        ey(skinType);
        this.aIN = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.aIO = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.aIP = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.aIN == null || this.aIO == null || this.aIP == null) {
            af.Dx().bt(false);
        }
        this.aIK.a(this.aIN, this.aIN, this.aIO, this.aIN, this.aIN, this.aIN);
        this.aII = new GLTextureView(getContext());
        this.aII.setEGLConfigChooser(this.aIJ);
        this.aII.setRenderer(this.aIK);
        try {
            this.aII.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aIM.addView(this.aII);
        this.aIK.aoB();
        Fl();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (DF()) {
            this.aII.setVisibility(0);
            this.aII.setRenderMode(1);
        } else if (this.aIH != null && this.aID != null) {
            this.aIH.stop();
            this.aID.setBackgroundDrawable(this.aIH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        if (this.aIG != null) {
            this.aIG.bI(z);
        }
        Fl();
        this.aIQ = true;
        if (DF()) {
            Fm();
            this.aII.requestRender();
            this.aII.onResume();
            this.aII.setRenderMode(1);
            if (z) {
                this.aIK.aoD();
            }
            this.aIK.aoB();
            this.aII.setVisibility(0);
        } else if (this.aIH != null && this.aID != null) {
            this.aIH.stop();
            this.aID.setBackgroundDrawable(this.aIH.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        Fl();
        if (DF()) {
            if (!this.aIQ) {
                Fm();
            }
            this.aII.requestRender();
            this.aII.onResume();
            this.aII.setVisibility(0);
            this.aII.setRenderMode(1);
            this.aIK.aoC();
            this.aIK.a(this.aIN, this.aIN, this.aIN, this.aIN, this.aIN, this.aIN);
        } else if (this.aIH != null && this.aID != null) {
            this.aIH.stop();
            this.aID.setBackgroundDrawable(this.aIH);
            this.aID.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.aIH != null) {
                        j.this.aIH.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aIQ = false;
        if (DF()) {
            this.aIK.a(this.aIN, this.aIN, this.aIO, this.aIN, this.aIN, this.aIN);
            if (this.aII != null) {
                this.aII.setRenderMode(0);
                this.aII.onPause();
            }
        } else if (this.aIH != null) {
            this.aIH.stop();
        }
        Fn();
        if (this.aIF != null) {
            this.aIF.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        if (this.aIE != null) {
            this.aIE.bH(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void oE() {
        if (DF()) {
            this.aIK.a(this.aIN, this.aIN, this.aIP, this.aIN, this.aIN, this.aIN);
            this.aIK.aoD();
            this.aII.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.aIE = bVar;
    }

    public void a(a aVar) {
        this.aIF = aVar;
    }

    public void a(c cVar) {
        this.aIG = cVar;
    }

    public void ey(int i) {
        if (DF() && this.aIK != null) {
            if (this.aIK.aLF != i) {
                this.aIK.kq(al.getColor(i, e.d.cp_bg_line_e));
                this.aIK.aLF = i;
                if (this.aII != null) {
                    this.aII.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.aIL, e.d.cp_bg_line_e, i);
            al.e(this.aIM, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DF() {
        return af.Dx().DF();
    }

    private void Fl() {
        if (DF()) {
            if (this.aID != null && this.aIL != null) {
                if (this.aID.getVisibility() != 8) {
                    this.aID.setVisibility(8);
                }
                if (this.aIL.getVisibility() != 0) {
                    this.aIL.setVisibility(0);
                }
            }
        } else if (this.aID != null && this.aIL != null) {
            if (this.aID.getVisibility() != 0) {
                this.aID.setVisibility(0);
            }
            if (this.aIL.getVisibility() != 8) {
                this.aIL.setVisibility(8);
            }
        }
    }

    private void Fm() {
        if (this.aII != null) {
            this.aII = new GLTextureView(getContext());
            this.aII.setVisibility(4);
            this.aII.setEGLConfigChooser(this.aIJ);
            this.aIK.a(this.aIN, this.aIN, this.aIO, this.aIN, this.aIN, this.aIN);
            this.aII.setRenderer(this.aIK);
            this.aIM.removeAllViews();
            this.aIM.addView(this.aII);
        }
    }

    private void Fn() {
        if (DF()) {
            if (this.aIH != null) {
                this.aIH.stop();
                this.aIH = null;
                return;
            }
            return;
        }
        if (this.aIN != null) {
            this.aIN.recycle();
            this.aIN = null;
        }
        if (this.aIO != null) {
            this.aIO.recycle();
            this.aIO = null;
        }
        if (this.aIP != null) {
            this.aIP.recycle();
            this.aIP = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oH() {
        return SystemScreenshotManager.DELAY_TIME;
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.c {
    protected View amR;
    protected LinearLayout amS;
    protected ImageView amT;
    private b amU;
    private a amV;
    private c amW;
    protected AnimationDrawable amX;
    private com.baidu.tieba.b.d.a amY;
    private a.e amZ;
    protected com.baidu.tieba.b.b.b ana;
    protected LinearLayout anb;
    protected FrameLayout anc;
    private Bitmap and;
    private Bitmap ane;
    private Bitmap anf;
    private boolean ang;
    protected int mSkinType;

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
        void aK(boolean z);
    }

    public g(Context context) {
        super(context);
        this.amR = null;
        this.amS = null;
        this.amT = null;
        this.amU = null;
        this.amV = null;
        this.amW = null;
        this.and = null;
        this.ane = null;
        this.anf = null;
        this.mSkinType = ExploreByTouchHelper.INVALID_ID;
        this.ang = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kX() {
        this.amR = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.amS = (LinearLayout) this.amR.findViewById(d.g.pull_root);
        this.anb = (LinearLayout) this.amS.findViewById(d.g.cube_container);
        this.anc = (FrameLayout) this.amS.findViewById(d.g.loading_cube);
        this.amT = (ImageView) this.amR.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!vm()) {
            this.amX = af.ve().cL(skinType);
        }
        this.amT.setBackgroundDrawable(this.amX);
        this.amZ = new a.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.ana = new com.baidu.tieba.b.b.b(getContext());
        dz(skinType);
        this.and = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.ane = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.anf = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.and == null || this.ane == null || this.anf == null) {
            af.ve().az(false);
        }
        this.ana.a(this.and, this.and, this.ane, this.and, this.and, this.and);
        this.amY = new com.baidu.tieba.b.d.a(getContext());
        this.amY.setEGLConfigChooser(this.amZ);
        this.amY.setRenderer(this.ana);
        try {
            this.amY.setRenderMode(0);
        } catch (Exception e) {
        }
        this.anc.addView(this.amY);
        this.ana.aaO();
        wG();
        return this.amR;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kY() {
        if (vm()) {
            this.amY.setVisibility(0);
            this.amY.setRenderMode(1);
        } else if (this.amX != null && this.amT != null) {
            this.amX.stop();
            this.amT.setBackgroundDrawable(this.amX.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.amW != null) {
            this.amW.aK(z);
        }
        wG();
        this.ang = true;
        if (vm()) {
            wH();
            this.amY.requestRender();
            this.amY.onResume();
            this.amY.setRenderMode(1);
            if (z) {
                this.ana.aaQ();
            }
            this.ana.aaO();
            this.amY.setVisibility(0);
        } else if (this.amX != null && this.amT != null) {
            this.amX.stop();
            this.amT.setBackgroundDrawable(this.amX.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kZ() {
        wG();
        if (vm()) {
            if (!this.ang) {
                wH();
            }
            this.amY.requestRender();
            this.amY.onResume();
            this.amY.setVisibility(0);
            this.amY.setRenderMode(1);
            this.ana.aaP();
            this.ana.a(this.and, this.and, this.and, this.and, this.and, this.and);
        } else if (this.amX != null && this.amT != null) {
            this.amX.stop();
            this.amT.setBackgroundDrawable(this.amX);
            this.amT.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.amX != null) {
                        g.this.amX.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.ang = false;
        if (vm()) {
            this.ana.a(this.and, this.and, this.ane, this.and, this.and, this.and);
            if (this.amY != null) {
                this.amY.setRenderMode(0);
                this.amY.onPause();
            }
        } else if (this.amX != null) {
            this.amX.stop();
        }
        release();
        if (this.amV != null) {
            this.amV.b(this.amR, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.amU != null) {
            this.amU.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void la() {
        if (vm()) {
            this.ana.a(this.and, this.and, this.anf, this.and, this.and, this.and);
            this.ana.aaQ();
            this.amY.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amU = bVar;
    }

    public void a(a aVar) {
        this.amV = aVar;
    }

    public void a(c cVar) {
        this.amW = cVar;
    }

    public void dz(int i) {
        if (vm() && this.ana != null) {
            if (this.ana.apA != i) {
                this.ana.iy(aj.getColor(i, d.C0082d.cp_bg_line_c));
                this.ana.apA = i;
            }
            aj.e(this.amR, d.C0082d.cp_bg_line_c, i);
            aj.e(this.anb, d.C0082d.cp_bg_line_c, i);
            aj.e(this.anc, d.C0082d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vm() {
        return af.ve().vm();
    }

    private void wG() {
        if (vm()) {
            if (this.amT != null && this.anb != null) {
                if (this.amT.getVisibility() != 8) {
                    this.amT.setVisibility(8);
                }
                if (this.anb.getVisibility() != 0) {
                    this.anb.setVisibility(0);
                }
            }
        } else if (this.amT != null && this.anb != null) {
            if (this.amT.getVisibility() != 0) {
                this.amT.setVisibility(0);
            }
            if (this.anb.getVisibility() != 8) {
                this.anb.setVisibility(8);
            }
        }
    }

    private void wH() {
        this.amY = new com.baidu.tieba.b.d.a(getContext());
        this.amY.setVisibility(4);
        this.amY.setEGLConfigChooser(this.amZ);
        this.ana.a(this.and, this.and, this.ane, this.and, this.and, this.and);
        this.amY.setRenderer(this.ana);
        this.anc.removeAllViews();
        this.anc.addView(this.amY);
    }

    private void release() {
        if (vm()) {
            if (this.amX != null) {
                this.amX.stop();
                this.amX = null;
                return;
            }
            return;
        }
        if (this.and != null) {
            this.and.recycle();
            this.and = null;
        }
        if (this.ane != null) {
            this.ane.recycle();
            this.ane = null;
        }
        if (this.anf != null) {
            this.anf.recycle();
            this.anf = null;
        }
    }
}

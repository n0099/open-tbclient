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
    private a amA;
    private c amB;
    protected AnimationDrawable amC;
    private com.baidu.tieba.b.d.a amD;
    private a.e amE;
    protected com.baidu.tieba.b.b.b amF;
    protected LinearLayout amG;
    protected FrameLayout amH;
    private Bitmap amI;
    private Bitmap amJ;
    private Bitmap amK;
    private boolean amL;
    protected View amw;
    protected LinearLayout amx;
    protected ImageView amy;
    private b amz;
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
        this.amw = null;
        this.amx = null;
        this.amy = null;
        this.amz = null;
        this.amA = null;
        this.amB = null;
        this.amI = null;
        this.amJ = null;
        this.amK = null;
        this.mSkinType = ExploreByTouchHelper.INVALID_ID;
        this.amL = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kX() {
        this.amw = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.amx = (LinearLayout) this.amw.findViewById(d.g.pull_root);
        this.amG = (LinearLayout) this.amx.findViewById(d.g.cube_container);
        this.amH = (FrameLayout) this.amx.findViewById(d.g.loading_cube);
        this.amy = (ImageView) this.amw.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!vj()) {
            this.amC = af.vb().cL(skinType);
        }
        this.amy.setBackgroundDrawable(this.amC);
        this.amE = new a.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amF = new com.baidu.tieba.b.b.b(getContext());
        dz(skinType);
        this.amI = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.amJ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.amK = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.amI == null || this.amJ == null || this.amK == null) {
            af.vb().az(false);
        }
        this.amF.a(this.amI, this.amI, this.amJ, this.amI, this.amI, this.amI);
        this.amD = new com.baidu.tieba.b.d.a(getContext());
        this.amD.setEGLConfigChooser(this.amE);
        this.amD.setRenderer(this.amF);
        try {
            this.amD.setRenderMode(0);
        } catch (Exception e) {
        }
        this.amH.addView(this.amD);
        this.amF.YT();
        wD();
        return this.amw;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kY() {
        if (vj()) {
            this.amD.setVisibility(0);
            this.amD.setRenderMode(1);
        } else if (this.amC != null && this.amy != null) {
            this.amC.stop();
            this.amy.setBackgroundDrawable(this.amC.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.amB != null) {
            this.amB.aK(z);
        }
        wD();
        this.amL = true;
        if (vj()) {
            wE();
            this.amD.requestRender();
            this.amD.onResume();
            this.amD.setRenderMode(1);
            if (z) {
                this.amF.YV();
            }
            this.amF.YT();
            this.amD.setVisibility(0);
        } else if (this.amC != null && this.amy != null) {
            this.amC.stop();
            this.amy.setBackgroundDrawable(this.amC.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kZ() {
        wD();
        if (vj()) {
            if (!this.amL) {
                wE();
            }
            this.amD.requestRender();
            this.amD.onResume();
            this.amD.setVisibility(0);
            this.amD.setRenderMode(1);
            this.amF.YU();
            this.amF.a(this.amI, this.amI, this.amI, this.amI, this.amI, this.amI);
        } else if (this.amC != null && this.amy != null) {
            this.amC.stop();
            this.amy.setBackgroundDrawable(this.amC);
            this.amy.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.amC != null) {
                        g.this.amC.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.amL = false;
        if (vj()) {
            this.amF.a(this.amI, this.amI, this.amJ, this.amI, this.amI, this.amI);
            if (this.amD != null) {
                this.amD.setRenderMode(0);
                this.amD.onPause();
            }
        } else if (this.amC != null) {
            this.amC.stop();
        }
        release();
        if (this.amA != null) {
            this.amA.b(this.amw, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.amz != null) {
            this.amz.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void la() {
        if (vj()) {
            this.amF.a(this.amI, this.amI, this.amK, this.amI, this.amI, this.amI);
            this.amF.YV();
            this.amD.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amz = bVar;
    }

    public void a(a aVar) {
        this.amA = aVar;
    }

    public void a(c cVar) {
        this.amB = cVar;
    }

    public void dz(int i) {
        if (vj() && this.amF != null) {
            if (this.amF.api != i) {
                this.amF.id(aj.getColor(i, d.C0080d.cp_bg_line_c));
                this.amF.api = i;
            }
            aj.e(this.amw, d.C0080d.cp_bg_line_c, i);
            aj.e(this.amG, d.C0080d.cp_bg_line_c, i);
            aj.e(this.amH, d.C0080d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vj() {
        return af.vb().vj();
    }

    private void wD() {
        if (vj()) {
            if (this.amy != null && this.amG != null) {
                if (this.amy.getVisibility() != 8) {
                    this.amy.setVisibility(8);
                }
                if (this.amG.getVisibility() != 0) {
                    this.amG.setVisibility(0);
                }
            }
        } else if (this.amy != null && this.amG != null) {
            if (this.amy.getVisibility() != 0) {
                this.amy.setVisibility(0);
            }
            if (this.amG.getVisibility() != 8) {
                this.amG.setVisibility(8);
            }
        }
    }

    private void wE() {
        this.amD = new com.baidu.tieba.b.d.a(getContext());
        this.amD.setVisibility(4);
        this.amD.setEGLConfigChooser(this.amE);
        this.amF.a(this.amI, this.amI, this.amJ, this.amI, this.amI, this.amI);
        this.amD.setRenderer(this.amF);
        this.amH.removeAllViews();
        this.amH.addView(this.amD);
    }

    private void release() {
        if (vj()) {
            if (this.amC != null) {
                this.amC.stop();
                this.amC = null;
                return;
            }
            return;
        }
        if (this.amI != null) {
            this.amI.recycle();
            this.amI = null;
        }
        if (this.amJ != null) {
            this.amJ.recycle();
            this.amJ = null;
        }
        if (this.amK != null) {
            this.amK.recycle();
            this.amK = null;
        }
    }
}

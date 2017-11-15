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
    private c amA;
    protected AnimationDrawable amB;
    private com.baidu.tieba.b.d.a amC;
    private a.e amD;
    protected com.baidu.tieba.b.b.b amE;
    protected LinearLayout amF;
    protected FrameLayout amG;
    private Bitmap amH;
    private Bitmap amI;
    private Bitmap amJ;
    private boolean amK;
    protected View amv;
    protected LinearLayout amw;
    protected ImageView amx;
    private b amy;
    private a amz;
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
        this.amv = null;
        this.amw = null;
        this.amx = null;
        this.amy = null;
        this.amz = null;
        this.amA = null;
        this.amH = null;
        this.amI = null;
        this.amJ = null;
        this.mSkinType = ExploreByTouchHelper.INVALID_ID;
        this.amK = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kX() {
        this.amv = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.amw = (LinearLayout) this.amv.findViewById(d.g.pull_root);
        this.amF = (LinearLayout) this.amw.findViewById(d.g.cube_container);
        this.amG = (FrameLayout) this.amw.findViewById(d.g.loading_cube);
        this.amx = (ImageView) this.amv.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!vj()) {
            this.amB = af.vb().cK(skinType);
        }
        this.amx.setBackgroundDrawable(this.amB);
        this.amD = new a.e() { // from class: com.baidu.tbadk.core.view.g.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.amE = new com.baidu.tieba.b.b.b(getContext());
        dy(skinType);
        this.amH = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.amI = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.amJ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.amH == null || this.amI == null || this.amJ == null) {
            af.vb().az(false);
        }
        this.amE.a(this.amH, this.amH, this.amI, this.amH, this.amH, this.amH);
        this.amC = new com.baidu.tieba.b.d.a(getContext());
        this.amC.setEGLConfigChooser(this.amD);
        this.amC.setRenderer(this.amE);
        try {
            this.amC.setRenderMode(0);
        } catch (Exception e) {
        }
        this.amG.addView(this.amC);
        this.amE.Zf();
        wD();
        return this.amv;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kY() {
        if (vj()) {
            this.amC.setVisibility(0);
            this.amC.setRenderMode(1);
        } else if (this.amB != null && this.amx != null) {
            this.amB.stop();
            this.amx.setBackgroundDrawable(this.amB.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        if (this.amA != null) {
            this.amA.aK(z);
        }
        wD();
        this.amK = true;
        if (vj()) {
            wE();
            this.amC.requestRender();
            this.amC.onResume();
            this.amC.setRenderMode(1);
            if (z) {
                this.amE.Zh();
            }
            this.amE.Zf();
            this.amC.setVisibility(0);
        } else if (this.amB != null && this.amx != null) {
            this.amB.stop();
            this.amx.setBackgroundDrawable(this.amB.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kZ() {
        wD();
        if (vj()) {
            if (!this.amK) {
                wE();
            }
            this.amC.requestRender();
            this.amC.onResume();
            this.amC.setVisibility(0);
            this.amC.setRenderMode(1);
            this.amE.Zg();
            this.amE.a(this.amH, this.amH, this.amH, this.amH, this.amH, this.amH);
        } else if (this.amB != null && this.amx != null) {
            this.amB.stop();
            this.amx.setBackgroundDrawable(this.amB);
            this.amx.post(new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.amB != null) {
                        g.this.amB.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.amK = false;
        if (vj()) {
            this.amE.a(this.amH, this.amH, this.amI, this.amH, this.amH, this.amH);
            if (this.amC != null) {
                this.amC.setRenderMode(0);
                this.amC.onPause();
            }
        } else if (this.amB != null) {
            this.amB.stop();
        }
        release();
        if (this.amz != null) {
            this.amz.b(this.amv, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        if (this.amy != null) {
            this.amy.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void la() {
        if (vj()) {
            this.amE.a(this.amH, this.amH, this.amJ, this.amH, this.amH, this.amH);
            this.amE.Zh();
            this.amC.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.amy = bVar;
    }

    public void a(a aVar) {
        this.amz = aVar;
    }

    public void a(c cVar) {
        this.amA = cVar;
    }

    public void dy(int i) {
        if (vj() && this.amE != null) {
            if (this.amE.aph != i) {
                this.amE.ib(aj.getColor(i, d.C0080d.cp_bg_line_c));
                this.amE.aph = i;
            }
            aj.e(this.amv, d.C0080d.cp_bg_line_c, i);
            aj.e(this.amF, d.C0080d.cp_bg_line_c, i);
            aj.e(this.amG, d.C0080d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vj() {
        return af.vb().vj();
    }

    private void wD() {
        if (vj()) {
            if (this.amx != null && this.amF != null) {
                if (this.amx.getVisibility() != 8) {
                    this.amx.setVisibility(8);
                }
                if (this.amF.getVisibility() != 0) {
                    this.amF.setVisibility(0);
                }
            }
        } else if (this.amx != null && this.amF != null) {
            if (this.amx.getVisibility() != 0) {
                this.amx.setVisibility(0);
            }
            if (this.amF.getVisibility() != 8) {
                this.amF.setVisibility(8);
            }
        }
    }

    private void wE() {
        this.amC = new com.baidu.tieba.b.d.a(getContext());
        this.amC.setVisibility(4);
        this.amC.setEGLConfigChooser(this.amD);
        this.amE.a(this.amH, this.amH, this.amI, this.amH, this.amH, this.amH);
        this.amC.setRenderer(this.amE);
        this.amG.removeAllViews();
        this.amG.addView(this.amC);
    }

    private void release() {
        if (vj()) {
            if (this.amB != null) {
                this.amB.stop();
                this.amB = null;
                return;
            }
            return;
        }
        if (this.amH != null) {
            this.amH.recycle();
            this.amH = null;
        }
        if (this.amI != null) {
            this.amI.recycle();
            this.amI = null;
        }
        if (this.amJ != null) {
            this.amJ.recycle();
            this.amJ = null;
        }
    }
}

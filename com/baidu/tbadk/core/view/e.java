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
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.animation3d.View.GLTextureView;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout anX;
    protected ImageView anY;
    private b anZ;
    private a aoa;
    private c aob;
    protected AnimationDrawable aoc;
    private GLTextureView aod;
    private GLTextureView.e aoe;
    protected com.baidu.tieba.animation3d.b.b aof;
    protected LinearLayout aog;
    protected FrameLayout aoh;
    private Bitmap aoi;
    private Bitmap aoj;
    private Bitmap aok;
    private boolean aol;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void c(View view2, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aO(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aP(boolean z);
    }

    public e(Context context) {
        super(context);
        this.mHeaderView = null;
        this.anX = null;
        this.anY = null;
        this.anZ = null;
        this.aoa = null;
        this.aob = null;
        this.aoi = null;
        this.aoj = null;
        this.aok = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.aol = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kz() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.i.tb_pull_view, (ViewGroup) null);
        this.anX = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.aog = (LinearLayout) this.anX.findViewById(d.g.cube_container);
        this.aoh = (FrameLayout) this.anX.findViewById(d.g.loading_cube);
        this.anY = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!vE()) {
            this.aoc = af.vw().cH(skinType);
        }
        this.anY.setBackgroundDrawable(this.aoc);
        this.aoe = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.e.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.aof = new com.baidu.tieba.animation3d.b.b(getContext());
        dw(skinType);
        this.aoi = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.aoj = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.aok = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.aoi == null || this.aoj == null || this.aok == null) {
            af.vw().aD(false);
        }
        this.aof.a(this.aoi, this.aoi, this.aoj, this.aoi, this.aoi, this.aoi);
        this.aod = new GLTextureView(getContext());
        this.aod.setEGLConfigChooser(this.aoe);
        this.aod.setRenderer(this.aof);
        try {
            this.aod.setRenderMode(0);
        } catch (Exception e) {
        }
        this.aoh.addView(this.aod);
        this.aof.aeG();
        wZ();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kA() {
        if (vE()) {
            if (!this.aol) {
                xa();
                this.aod.requestRender();
                this.aod.onResume();
                this.aof.aeG();
            }
            this.aod.setVisibility(0);
            this.aod.setRenderMode(1);
        } else if (this.aoc != null && this.anY != null) {
            this.aoc.stop();
            this.anY.setBackgroundDrawable(this.aoc.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void X(boolean z) {
        if (this.aob != null) {
            this.aob.aP(z);
        }
        wZ();
        this.aol = true;
        if (vE()) {
            xa();
            this.aod.requestRender();
            this.aod.onResume();
            this.aod.setRenderMode(1);
            if (z) {
                this.aof.aeI();
            }
            this.aof.aeG();
            this.aod.setVisibility(0);
        } else if (this.aoc != null && this.anY != null) {
            this.aoc.stop();
            this.anY.setBackgroundDrawable(this.aoc.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kB() {
        wZ();
        if (vE()) {
            if (!this.aol) {
                xa();
            }
            this.aod.requestRender();
            this.aod.onResume();
            this.aod.setVisibility(0);
            this.aod.setRenderMode(1);
            this.aof.aeH();
            this.aof.a(this.aoi, this.aoi, this.aoi, this.aoi, this.aoi, this.aoi);
        } else if (this.aoc != null && this.anY != null) {
            this.aoc.stop();
            this.anY.setBackgroundDrawable(this.aoc);
            this.anY.post(new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.aoc != null) {
                        e.this.aoc.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        this.aol = false;
        if (vE()) {
            this.aof.a(this.aoi, this.aoi, this.aoj, this.aoi, this.aoi, this.aoi);
            if (this.aod != null) {
                this.aod.setRenderMode(0);
                this.aod.onPause();
            }
        } else if (this.aoc != null) {
            this.aoc.stop();
        }
        release();
        if (this.aoa != null) {
            this.aoa.c(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        if (this.anZ != null) {
            this.anZ.aO(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void kC() {
        if (vE()) {
            this.aof.a(this.aoi, this.aoi, this.aok, this.aoi, this.aoi, this.aoi);
            this.aof.aeI();
            this.aod.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.anZ = bVar;
    }

    public void a(a aVar) {
        this.aoa = aVar;
    }

    public void a(c cVar) {
        this.aob = cVar;
    }

    public void dw(int i) {
        if (vE() && this.aof != null) {
            if (this.aof.aqQ != i) {
                this.aof.iB(ak.getColor(i, d.C0126d.cp_bg_line_c));
                this.aof.aqQ = i;
                if (this.aod != null) {
                    this.aod.onResume();
                }
            }
            ak.e(this.mHeaderView, d.C0126d.cp_bg_line_c, i);
            ak.e(this.aog, d.C0126d.cp_bg_line_c, i);
            ak.e(this.aoh, d.C0126d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vE() {
        return af.vw().vE();
    }

    private void wZ() {
        if (vE()) {
            if (this.anY != null && this.aog != null) {
                if (this.anY.getVisibility() != 8) {
                    this.anY.setVisibility(8);
                }
                if (this.aog.getVisibility() != 0) {
                    this.aog.setVisibility(0);
                }
            }
        } else if (this.anY != null && this.aog != null) {
            if (this.anY.getVisibility() != 0) {
                this.anY.setVisibility(0);
            }
            if (this.aog.getVisibility() != 8) {
                this.aog.setVisibility(8);
            }
        }
    }

    private void xa() {
        this.aod = new GLTextureView(getContext());
        this.aod.setVisibility(4);
        this.aod.setEGLConfigChooser(this.aoe);
        this.aof.a(this.aoi, this.aoi, this.aoj, this.aoi, this.aoi, this.aoi);
        this.aod.setRenderer(this.aof);
        this.aoh.removeAllViews();
        this.aoh.addView(this.aod);
    }

    private void release() {
        if (vE()) {
            if (this.aoc != null) {
                this.aoc.stop();
                this.aoc = null;
                return;
            }
            return;
        }
        if (this.aoi != null) {
            this.aoi.recycle();
            this.aoi = null;
        }
        if (this.aoj != null) {
            this.aoj.recycle();
            this.aoj = null;
        }
        if (this.aok != null) {
            this.aok.recycle();
            this.aok = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long kG() {
        return 2000L;
    }
}

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.c {
    protected View IZ;
    protected LinearLayout baX;
    protected ImageView baY;
    private b baZ;
    private a bba;
    private c bbb;
    protected AnimationDrawable bbc;
    private com.baidu.tieba.b.d.a bbd;
    private a.e bbe;
    protected com.baidu.tieba.b.b.b bbf;
    protected LinearLayout bbg;
    protected FrameLayout bbh;
    private Bitmap bbi;
    private Bitmap bbj;
    private Bitmap bbk;
    private boolean bbl;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void i(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bs(boolean z);
    }

    public j(Context context) {
        super(context);
        this.IZ = null;
        this.baX = null;
        this.baY = null;
        this.baZ = null;
        this.bba = null;
        this.bbb = null;
        this.bbi = null;
        this.bbj = null;
        this.bbk = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bbl = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View sv() {
        this.IZ = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.baX = (LinearLayout) this.IZ.findViewById(d.g.pull_root);
        this.bbg = (LinearLayout) this.baX.findViewById(d.g.cube_container);
        this.bbh = (FrameLayout) this.baX.findViewById(d.g.loading_cube);
        this.baY = (ImageView) this.IZ.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CC()) {
            this.bbc = af.Cu().fI(skinType);
        }
        this.baY.setBackgroundDrawable(this.bbc);
        this.bbe = new a.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.bbf = new com.baidu.tieba.b.b.b(getContext());
        gv(skinType);
        this.bbi = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bbj = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bbk = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bbi == null || this.bbj == null || this.bbk == null) {
            af.Cu().bi(false);
        }
        this.bbf.a(this.bbi, this.bbi, this.bbj, this.bbi, this.bbi, this.bbi);
        this.bbd = new com.baidu.tieba.b.d.a(getContext());
        this.bbd.setEGLConfigChooser(this.bbe);
        this.bbd.setRenderer(this.bbf);
        try {
            this.bbd.setRenderMode(0);
        } catch (Exception e) {
        }
        this.bbh.addView(this.bbd);
        this.bbf.ajD();
        DV();
        return this.IZ;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        if (CC()) {
            if (!this.bbl) {
                DW();
                this.bbd.requestRender();
                this.bbd.onResume();
                this.bbf.ajD();
            }
            this.bbd.setVisibility(0);
            this.bbd.setRenderMode(1);
        } else if (this.bbc != null && this.baY != null) {
            this.bbc.stop();
            this.baY.setBackgroundDrawable(this.bbc.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
        if (this.bbb != null) {
            this.bbb.bs(z);
        }
        DV();
        this.bbl = true;
        if (CC()) {
            DW();
            this.bbd.requestRender();
            this.bbd.onResume();
            this.bbd.setRenderMode(1);
            if (z) {
                this.bbf.ajF();
            }
            this.bbf.ajD();
            this.bbd.setVisibility(0);
        } else if (this.bbc != null && this.baY != null) {
            this.bbc.stop();
            this.baY.setBackgroundDrawable(this.bbc.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sx() {
        DV();
        if (CC()) {
            if (!this.bbl) {
                DW();
            }
            this.bbd.requestRender();
            this.bbd.onResume();
            this.bbd.setVisibility(0);
            this.bbd.setRenderMode(1);
            this.bbf.ajE();
            this.bbf.a(this.bbi, this.bbi, this.bbi, this.bbi, this.bbi, this.bbi);
        } else if (this.bbc != null && this.baY != null) {
            this.bbc.stop();
            this.baY.setBackgroundDrawable(this.bbc);
            this.baY.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.bbc != null) {
                        j.this.bbc.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aB(boolean z) {
        this.bbl = false;
        if (CC()) {
            this.bbf.a(this.bbi, this.bbi, this.bbj, this.bbi, this.bbi, this.bbi);
            if (this.bbd != null) {
                this.bbd.setRenderMode(0);
                this.bbd.onPause();
            }
        } else if (this.bbc != null) {
            this.bbc.stop();
        }
        release();
        if (this.bba != null) {
            this.bba.i(this.IZ, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aC(boolean z) {
        if (this.baZ != null) {
            this.baZ.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sy() {
        if (CC()) {
            this.bbf.a(this.bbi, this.bbi, this.bbk, this.bbi, this.bbi, this.bbi);
            this.bbf.ajF();
            this.bbd.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.baZ = bVar;
    }

    public void a(a aVar) {
        this.bba = aVar;
    }

    public void a(c cVar) {
        this.bbb = cVar;
    }

    public void gv(int i) {
        if (CC() && this.bbf != null) {
            if (this.bbf.bdS != i) {
                this.bbf.ly(aj.getColor(i, d.C0108d.cp_bg_line_c));
                this.bbf.bdS = i;
            }
            aj.g(this.IZ, d.C0108d.cp_bg_line_c, i);
            aj.g(this.bbg, d.C0108d.cp_bg_line_c, i);
            aj.g(this.bbh, d.C0108d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CC() {
        return af.Cu().CC();
    }

    private void DV() {
        if (CC()) {
            if (this.baY != null && this.bbg != null) {
                if (this.baY.getVisibility() != 8) {
                    this.baY.setVisibility(8);
                }
                if (this.bbg.getVisibility() != 0) {
                    this.bbg.setVisibility(0);
                }
            }
        } else if (this.baY != null && this.bbg != null) {
            if (this.baY.getVisibility() != 0) {
                this.baY.setVisibility(0);
            }
            if (this.bbg.getVisibility() != 8) {
                this.bbg.setVisibility(8);
            }
        }
    }

    private void DW() {
        this.bbd = new com.baidu.tieba.b.d.a(getContext());
        this.bbd.setVisibility(4);
        this.bbd.setEGLConfigChooser(this.bbe);
        this.bbf.a(this.bbi, this.bbi, this.bbj, this.bbi, this.bbi, this.bbi);
        this.bbd.setRenderer(this.bbf);
        this.bbh.removeAllViews();
        this.bbh.addView(this.bbd);
    }

    private void release() {
        if (CC()) {
            if (this.bbc != null) {
                this.bbc.stop();
                this.bbc = null;
                return;
            }
            return;
        }
        if (this.bbi != null) {
            this.bbi.recycle();
            this.bbi = null;
        }
        if (this.bbj != null) {
            this.bbj.recycle();
            this.bbj = null;
        }
        if (this.bbk != null) {
            this.bbk.recycle();
            this.bbk = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sC() {
        return 2000L;
    }
}

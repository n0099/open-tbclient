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
public class i extends com.baidu.adp.widget.ListView.c {
    protected View IZ;
    protected LinearLayout baQ;
    protected ImageView baR;
    private b baS;
    private a baT;
    private c baU;
    protected AnimationDrawable baV;
    private com.baidu.tieba.b.d.a baW;
    private a.e baX;
    protected com.baidu.tieba.b.b.b baY;
    protected LinearLayout baZ;
    protected FrameLayout bba;
    private Bitmap bbb;
    private Bitmap bbc;
    private Bitmap bbd;
    private boolean bbe;
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
        void br(boolean z);
    }

    public i(Context context) {
        super(context);
        this.IZ = null;
        this.baQ = null;
        this.baR = null;
        this.baS = null;
        this.baT = null;
        this.baU = null;
        this.bbb = null;
        this.bbc = null;
        this.bbd = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bbe = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View su() {
        this.IZ = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.baQ = (LinearLayout) this.IZ.findViewById(d.g.pull_root);
        this.baZ = (LinearLayout) this.baQ.findViewById(d.g.cube_container);
        this.bba = (FrameLayout) this.baQ.findViewById(d.g.loading_cube);
        this.baR = (ImageView) this.IZ.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CJ()) {
            this.baV = af.CB().fK(skinType);
        }
        this.baR.setBackgroundDrawable(this.baV);
        this.baX = new a.e() { // from class: com.baidu.tbadk.core.view.i.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.baY = new com.baidu.tieba.b.b.b(getContext());
        gy(skinType);
        this.bbb = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bbc = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bbd = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bbb == null || this.bbc == null || this.bbd == null) {
            af.CB().bh(false);
        }
        this.baY.a(this.bbb, this.bbb, this.bbc, this.bbb, this.bbb, this.bbb);
        this.baW = new com.baidu.tieba.b.d.a(getContext());
        this.baW.setEGLConfigChooser(this.baX);
        this.baW.setRenderer(this.baY);
        try {
            this.baW.setRenderMode(0);
        } catch (Exception e) {
        }
        this.bba.addView(this.baW);
        this.baY.aiv();
        Ec();
        return this.IZ;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sv() {
        if (CJ()) {
            if (!this.bbe) {
                Ed();
                this.baW.requestRender();
                this.baW.onResume();
                this.baY.aiv();
            }
            this.baW.setVisibility(0);
            this.baW.setRenderMode(1);
        } else if (this.baV != null && this.baR != null) {
            this.baV.stop();
            this.baR.setBackgroundDrawable(this.baV.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void az(boolean z) {
        if (this.baU != null) {
            this.baU.br(z);
        }
        Ec();
        this.bbe = true;
        if (CJ()) {
            Ed();
            this.baW.requestRender();
            this.baW.onResume();
            this.baW.setRenderMode(1);
            if (z) {
                this.baY.aix();
            }
            this.baY.aiv();
            this.baW.setVisibility(0);
        } else if (this.baV != null && this.baR != null) {
            this.baV.stop();
            this.baR.setBackgroundDrawable(this.baV.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        Ec();
        if (CJ()) {
            if (!this.bbe) {
                Ed();
            }
            this.baW.requestRender();
            this.baW.onResume();
            this.baW.setVisibility(0);
            this.baW.setRenderMode(1);
            this.baY.aiw();
            this.baY.a(this.bbb, this.bbb, this.bbb, this.bbb, this.bbb, this.bbb);
        } else if (this.baV != null && this.baR != null) {
            this.baV.stop();
            this.baR.setBackgroundDrawable(this.baV);
            this.baR.post(new Runnable() { // from class: com.baidu.tbadk.core.view.i.2
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.baV != null) {
                        i.this.baV.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
        this.bbe = false;
        if (CJ()) {
            this.baY.a(this.bbb, this.bbb, this.bbc, this.bbb, this.bbb, this.bbb);
            if (this.baW != null) {
                this.baW.setRenderMode(0);
                this.baW.onPause();
            }
        } else if (this.baV != null) {
            this.baV.stop();
        }
        release();
        if (this.baT != null) {
            this.baT.i(this.IZ, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aB(boolean z) {
        if (this.baS != null) {
            this.baS.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sx() {
        if (CJ()) {
            this.baY.a(this.bbb, this.bbb, this.bbd, this.bbb, this.bbb, this.bbb);
            this.baY.aix();
            this.baW.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.baS = bVar;
    }

    public void a(a aVar) {
        this.baT = aVar;
    }

    public void a(c cVar) {
        this.baU = cVar;
    }

    public void gy(int i) {
        if (CJ() && this.baY != null) {
            if (this.baY.bdE != i) {
                this.baY.lw(aj.getColor(i, d.C0108d.cp_bg_line_c));
                this.baY.bdE = i;
            }
            aj.g(this.IZ, d.C0108d.cp_bg_line_c, i);
            aj.g(this.baZ, d.C0108d.cp_bg_line_c, i);
            aj.g(this.bba, d.C0108d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CJ() {
        return af.CB().CJ();
    }

    private void Ec() {
        if (CJ()) {
            if (this.baR != null && this.baZ != null) {
                if (this.baR.getVisibility() != 8) {
                    this.baR.setVisibility(8);
                }
                if (this.baZ.getVisibility() != 0) {
                    this.baZ.setVisibility(0);
                }
            }
        } else if (this.baR != null && this.baZ != null) {
            if (this.baR.getVisibility() != 0) {
                this.baR.setVisibility(0);
            }
            if (this.baZ.getVisibility() != 8) {
                this.baZ.setVisibility(8);
            }
        }
    }

    private void Ed() {
        this.baW = new com.baidu.tieba.b.d.a(getContext());
        this.baW.setVisibility(4);
        this.baW.setEGLConfigChooser(this.baX);
        this.baY.a(this.bbb, this.bbb, this.bbc, this.bbb, this.bbb, this.bbb);
        this.baW.setRenderer(this.baY);
        this.bba.removeAllViews();
        this.bba.addView(this.baW);
    }

    private void release() {
        if (CJ()) {
            if (this.baV != null) {
                this.baV.stop();
                this.baV = null;
                return;
            }
            return;
        }
        if (this.bbb != null) {
            this.bbb.recycle();
            this.bbb = null;
        }
        if (this.bbc != null) {
            this.bbc.recycle();
            this.bbc = null;
        }
        if (this.bbd != null) {
            this.bbd.recycle();
            this.bbd = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sB() {
        return 2000L;
    }
}

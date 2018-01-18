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
    protected LinearLayout baP;
    protected ImageView baQ;
    private b baR;
    private a baS;
    private c baT;
    protected AnimationDrawable baU;
    private com.baidu.tieba.b.d.a baV;
    private a.e baW;
    protected com.baidu.tieba.b.b.b baX;
    protected LinearLayout baY;
    protected FrameLayout baZ;
    private Bitmap bba;
    private Bitmap bbb;
    private Bitmap bbc;
    private boolean bbd;
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

    public j(Context context) {
        super(context);
        this.IZ = null;
        this.baP = null;
        this.baQ = null;
        this.baR = null;
        this.baS = null;
        this.baT = null;
        this.bba = null;
        this.bbb = null;
        this.bbc = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.bbd = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View su() {
        this.IZ = LayoutInflater.from(getContext()).inflate(d.h.tb_pull_view, (ViewGroup) null);
        this.baP = (LinearLayout) this.IZ.findViewById(d.g.pull_root);
        this.baY = (LinearLayout) this.baP.findViewById(d.g.cube_container);
        this.baZ = (FrameLayout) this.baP.findViewById(d.g.loading_cube);
        this.baQ = (ImageView) this.IZ.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!CB()) {
            this.baU = af.Ct().fI(skinType);
        }
        this.baQ.setBackgroundDrawable(this.baU);
        this.baW = new a.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.baX = new com.baidu.tieba.b.b.b(getContext());
        gv(skinType);
        this.bba = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.bbb = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.bbc = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.bba == null || this.bbb == null || this.bbc == null) {
            af.Ct().bh(false);
        }
        this.baX.a(this.bba, this.bba, this.bbb, this.bba, this.bba, this.bba);
        this.baV = new com.baidu.tieba.b.d.a(getContext());
        this.baV.setEGLConfigChooser(this.baW);
        this.baV.setRenderer(this.baX);
        try {
            this.baV.setRenderMode(0);
        } catch (Exception e) {
        }
        this.baZ.addView(this.baV);
        this.baX.ajy();
        DT();
        return this.IZ;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sv() {
        if (CB()) {
            if (!this.bbd) {
                DU();
                this.baV.requestRender();
                this.baV.onResume();
                this.baX.ajy();
            }
            this.baV.setVisibility(0);
            this.baV.setRenderMode(1);
        } else if (this.baU != null && this.baQ != null) {
            this.baU.stop();
            this.baQ.setBackgroundDrawable(this.baU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void az(boolean z) {
        if (this.baT != null) {
            this.baT.br(z);
        }
        DT();
        this.bbd = true;
        if (CB()) {
            DU();
            this.baV.requestRender();
            this.baV.onResume();
            this.baV.setRenderMode(1);
            if (z) {
                this.baX.ajA();
            }
            this.baX.ajy();
            this.baV.setVisibility(0);
        } else if (this.baU != null && this.baQ != null) {
            this.baU.stop();
            this.baQ.setBackgroundDrawable(this.baU.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sw() {
        DT();
        if (CB()) {
            if (!this.bbd) {
                DU();
            }
            this.baV.requestRender();
            this.baV.onResume();
            this.baV.setVisibility(0);
            this.baV.setRenderMode(1);
            this.baX.ajz();
            this.baX.a(this.bba, this.bba, this.bba, this.bba, this.bba, this.bba);
        } else if (this.baU != null && this.baQ != null) {
            this.baU.stop();
            this.baQ.setBackgroundDrawable(this.baU);
            this.baQ.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.baU != null) {
                        j.this.baU.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
        this.bbd = false;
        if (CB()) {
            this.baX.a(this.bba, this.bba, this.bbb, this.bba, this.bba, this.bba);
            if (this.baV != null) {
                this.baV.setRenderMode(0);
                this.baV.onPause();
            }
        } else if (this.baU != null) {
            this.baU.stop();
        }
        release();
        if (this.baS != null) {
            this.baS.i(this.IZ, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aB(boolean z) {
        if (this.baR != null) {
            this.baR.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void sx() {
        if (CB()) {
            this.baX.a(this.bba, this.bba, this.bbc, this.bba, this.bba, this.bba);
            this.baX.ajA();
            this.baV.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.baR = bVar;
    }

    public void a(a aVar) {
        this.baS = aVar;
    }

    public void a(c cVar) {
        this.baT = cVar;
    }

    public void gv(int i) {
        if (CB() && this.baX != null) {
            if (this.baX.bdK != i) {
                this.baX.ly(aj.getColor(i, d.C0107d.cp_bg_line_c));
                this.baX.bdK = i;
            }
            aj.g(this.IZ, d.C0107d.cp_bg_line_c, i);
            aj.g(this.baY, d.C0107d.cp_bg_line_c, i);
            aj.g(this.baZ, d.C0107d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CB() {
        return af.Ct().CB();
    }

    private void DT() {
        if (CB()) {
            if (this.baQ != null && this.baY != null) {
                if (this.baQ.getVisibility() != 8) {
                    this.baQ.setVisibility(8);
                }
                if (this.baY.getVisibility() != 0) {
                    this.baY.setVisibility(0);
                }
            }
        } else if (this.baQ != null && this.baY != null) {
            if (this.baQ.getVisibility() != 0) {
                this.baQ.setVisibility(0);
            }
            if (this.baY.getVisibility() != 8) {
                this.baY.setVisibility(8);
            }
        }
    }

    private void DU() {
        this.baV = new com.baidu.tieba.b.d.a(getContext());
        this.baV.setVisibility(4);
        this.baV.setEGLConfigChooser(this.baW);
        this.baX.a(this.bba, this.bba, this.bbb, this.bba, this.bba, this.bba);
        this.baV.setRenderer(this.baX);
        this.baZ.removeAllViews();
        this.baZ.addView(this.baV);
    }

    private void release() {
        if (CB()) {
            if (this.baU != null) {
                this.baU.stop();
                this.baU = null;
                return;
            }
            return;
        }
        if (this.bba != null) {
            this.bba.recycle();
            this.bba = null;
        }
        if (this.bbb != null) {
            this.bbb.recycle();
            this.bbb = null;
        }
        if (this.bbc != null) {
            this.bbc.recycle();
            this.bbc = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long sB() {
        return 2000L;
    }
}

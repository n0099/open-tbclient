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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.animation3d.View.GLTextureView;
import com.baidu.tieba.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout azE;
    protected ImageView azF;
    private b azG;
    private a azH;
    private c azI;
    protected AnimationDrawable azJ;
    private GLTextureView azK;
    private GLTextureView.e azL;
    protected com.baidu.tieba.animation3d.b.b azM;
    protected LinearLayout azN;
    protected FrameLayout azO;
    private Bitmap azP;
    private Bitmap azQ;
    private Bitmap azR;
    private boolean azS;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bf(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bg(boolean z);
    }

    public j(Context context) {
        super(context);
        this.mHeaderView = null;
        this.azE = null;
        this.azF = null;
        this.azG = null;
        this.azH = null;
        this.azI = null;
        this.azP = null;
        this.azQ = null;
        this.azR = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.azS = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ov() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(e.h.tb_pull_view, (ViewGroup) null);
        this.azE = (LinearLayout) this.mHeaderView.findViewById(e.g.pull_root);
        this.azN = (LinearLayout) this.azE.findViewById(e.g.cube_container);
        this.azO = (FrameLayout) this.azE.findViewById(e.g.loading_cube);
        this.azF = (ImageView) this.mHeaderView.findViewById(e.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!An()) {
            this.azJ = af.Af().cV(skinType);
        }
        this.azF.setBackgroundDrawable(this.azJ);
        this.azL = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.j.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.azM = new com.baidu.tieba.animation3d.b.b(getContext());
        dM(skinType);
        this.azP = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.cube_top);
        this.azQ = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_arrow);
        this.azR = BitmapHelper.getResBitmapPowerOf2Size(getContext(), e.f.btn_frs_post_ok);
        if (this.azP == null || this.azQ == null || this.azR == null) {
            af.Af().aS(false);
        }
        this.azM.a(this.azP, this.azP, this.azQ, this.azP, this.azP, this.azP);
        this.azK = new GLTextureView(getContext());
        this.azK.setEGLConfigChooser(this.azL);
        this.azK.setRenderer(this.azM);
        try {
            this.azK.setRenderMode(0);
        } catch (Exception e) {
        }
        this.azO.addView(this.azK);
        this.azM.ajK();
        BS();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void releaseToRefresh() {
        if (An()) {
            this.azK.setVisibility(0);
            this.azK.setRenderMode(1);
        } else if (this.azJ != null && this.azF != null) {
            this.azJ.stop();
            this.azF.setBackgroundDrawable(this.azJ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ai(boolean z) {
        if (this.azI != null) {
            this.azI.bg(z);
        }
        BS();
        this.azS = true;
        if (An()) {
            BT();
            this.azK.requestRender();
            this.azK.onResume();
            this.azK.setRenderMode(1);
            if (z) {
                this.azM.ajM();
            }
            this.azM.ajK();
            this.azK.setVisibility(0);
        } else if (this.azJ != null && this.azF != null) {
            this.azJ.stop();
            this.azF.setBackgroundDrawable(this.azJ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void refreshing() {
        BS();
        if (An()) {
            if (!this.azS) {
                BT();
            }
            this.azK.requestRender();
            this.azK.onResume();
            this.azK.setVisibility(0);
            this.azK.setRenderMode(1);
            this.azM.ajL();
            this.azM.a(this.azP, this.azP, this.azP, this.azP, this.azP, this.azP);
        } else if (this.azJ != null && this.azF != null) {
            this.azJ.stop();
            this.azF.setBackgroundDrawable(this.azJ);
            this.azF.post(new Runnable() { // from class: com.baidu.tbadk.core.view.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.azJ != null) {
                        j.this.azJ.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aj(boolean z) {
        this.azS = false;
        if (An()) {
            this.azM.a(this.azP, this.azP, this.azQ, this.azP, this.azP, this.azP);
            if (this.azK != null) {
                this.azK.setRenderMode(0);
                this.azK.onPause();
            }
        } else if (this.azJ != null) {
            this.azJ.stop();
        }
        BU();
        if (this.azH != null) {
            this.azH.b(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ak(boolean z) {
        if (this.azG != null) {
            this.azG.bf(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ow() {
        if (An()) {
            this.azM.a(this.azP, this.azP, this.azR, this.azP, this.azP, this.azP);
            this.azM.ajM();
            this.azK.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.azG = bVar;
    }

    public void a(a aVar) {
        this.azH = aVar;
    }

    public void a(c cVar) {
        this.azI = cVar;
    }

    public void dM(int i) {
        if (An() && this.azM != null) {
            if (this.azM.aCJ != i) {
                this.azM.ji(al.getColor(i, e.d.cp_bg_line_e));
                this.azM.aCJ = i;
                if (this.azK != null) {
                    this.azK.onResume();
                }
            }
            al.e(this.mHeaderView, e.d.cp_bg_line_e, i);
            al.e(this.azN, e.d.cp_bg_line_e, i);
            al.e(this.azO, e.d.cp_bg_line_e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean An() {
        return af.Af().An();
    }

    private void BS() {
        if (An()) {
            if (this.azF != null && this.azN != null) {
                if (this.azF.getVisibility() != 8) {
                    this.azF.setVisibility(8);
                }
                if (this.azN.getVisibility() != 0) {
                    this.azN.setVisibility(0);
                }
            }
        } else if (this.azF != null && this.azN != null) {
            if (this.azF.getVisibility() != 0) {
                this.azF.setVisibility(0);
            }
            if (this.azN.getVisibility() != 8) {
                this.azN.setVisibility(8);
            }
        }
    }

    private void BT() {
        if (this.azK != null) {
            this.azK = new GLTextureView(getContext());
            this.azK.setVisibility(4);
            this.azK.setEGLConfigChooser(this.azL);
            this.azM.a(this.azP, this.azP, this.azQ, this.azP, this.azP, this.azP);
            this.azK.setRenderer(this.azM);
            this.azO.removeAllViews();
            this.azO.addView(this.azK);
        }
    }

    private void BU() {
        if (An()) {
            if (this.azJ != null) {
                this.azJ.stop();
                this.azJ = null;
                return;
            }
            return;
        }
        if (this.azP != null) {
            this.azP.recycle();
            this.azP = null;
        }
        if (this.azQ != null) {
            this.azQ.recycle();
            this.azQ = null;
        }
        if (this.azR != null) {
            this.azR.recycle();
            this.azR = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long oA() {
        return 2000L;
    }
}

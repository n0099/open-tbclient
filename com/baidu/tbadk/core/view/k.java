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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.c {
    protected View anK;
    protected LinearLayout anL;
    protected ImageView anM;
    private b anN;
    private a anO;
    private c anP;
    protected AnimationDrawable anQ;
    private com.baidu.tieba.b.d.a anR;
    private a.e anS;
    protected com.baidu.tieba.b.b.b anT;
    protected LinearLayout anU;
    protected FrameLayout anV;
    private Bitmap anW;
    private Bitmap anX;
    private Bitmap anY;
    private boolean anZ;

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
        void aN(boolean z);
    }

    public k(Context context) {
        super(context);
        this.anK = null;
        this.anL = null;
        this.anM = null;
        this.anN = null;
        this.anO = null;
        this.anP = null;
        this.anW = null;
        this.anX = null;
        this.anY = null;
        this.anZ = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lk() {
        this.anK = LayoutInflater.from(getContext()).inflate(d.j.tb_pull_view, (ViewGroup) null);
        this.anL = (LinearLayout) this.anK.findViewById(d.h.pull_root);
        this.anU = (LinearLayout) this.anL.findViewById(d.h.cube_container);
        this.anV = (FrameLayout) this.anL.findViewById(d.h.loading_cube);
        this.anM = (ImageView) this.anK.findViewById(d.h.pull_image);
        if (!vH()) {
            this.anQ = ae.vz().cM(TbadkCoreApplication.getInst().getSkinType());
        }
        this.anM.setBackgroundDrawable(this.anQ);
        this.anS = new a.e() { // from class: com.baidu.tbadk.core.view.k.1
            @Override // com.baidu.tieba.b.d.a.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.anT = new com.baidu.tieba.b.b.b(getContext());
        dp(TbadkCoreApplication.getInst().getSkinType());
        this.anW = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.cube_top);
        this.anX = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_arrow);
        this.anY = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.g.btn_frs_post_ok);
        if (this.anW == null || this.anX == null || this.anY == null) {
            ae.vz().aC(false);
        }
        this.anT.a(this.anW, this.anW, this.anX, this.anW, this.anW, this.anW);
        this.anR = new com.baidu.tieba.b.d.a(getContext());
        this.anR.setEGLConfigChooser(this.anS);
        this.anR.setRenderer(this.anT);
        try {
            this.anR.setRenderMode(0);
        } catch (Exception e) {
        }
        this.anV.addView(this.anR);
        this.anT.Vi();
        xf();
        return this.anK;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ll() {
        if (vH()) {
            this.anR.setVisibility(0);
            this.anR.setRenderMode(1);
        } else if (this.anQ != null && this.anM != null) {
            this.anQ.stop();
            this.anM.setBackgroundDrawable(this.anQ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        if (this.anP != null) {
            this.anP.aN(z);
        }
        xf();
        this.anZ = true;
        if (vH()) {
            xg();
            this.anR.requestRender();
            this.anR.onResume();
            this.anR.setRenderMode(1);
            if (z) {
                this.anT.Vk();
            }
            this.anT.Vi();
            this.anR.setVisibility(0);
        } else if (this.anQ != null && this.anM != null) {
            this.anQ.stop();
            this.anM.setBackgroundDrawable(this.anQ.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void lm() {
        xf();
        if (vH()) {
            if (!this.anZ) {
                xg();
            }
            this.anR.requestRender();
            this.anR.onResume();
            this.anR.setVisibility(0);
            this.anR.setRenderMode(1);
            this.anT.Vj();
            this.anT.a(this.anW, this.anW, this.anW, this.anW, this.anW, this.anW);
        } else if (this.anQ != null && this.anM != null) {
            this.anQ.stop();
            this.anM.setBackgroundDrawable(this.anQ);
            this.anM.post(new Runnable() { // from class: com.baidu.tbadk.core.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.anQ != null) {
                        k.this.anQ.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.anZ = false;
        if (vH()) {
            this.anT.a(this.anW, this.anW, this.anX, this.anW, this.anW, this.anW);
            if (this.anR != null) {
                this.anR.setRenderMode(0);
                this.anR.onPause();
            }
        } else if (this.anQ != null) {
            this.anQ.stop();
        }
        release();
        if (this.anO != null) {
            this.anO.b(this.anK, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        if (this.anN != null) {
            this.anN.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ln() {
        if (vH()) {
            this.anT.a(this.anW, this.anW, this.anY, this.anW, this.anW, this.anW);
            this.anT.Vk();
            this.anR.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.anN = bVar;
    }

    public void a(a aVar) {
        this.anO = aVar;
    }

    public void a(c cVar) {
        this.anP = cVar;
    }

    public void dp(int i) {
        if (vH() && this.anT != null) {
            if (this.anT.aqm != i) {
                this.anT.hk(ai.getColor(d.e.cp_bg_line_c));
                this.anT.aqm = i;
            }
            ai.k(this.anK, d.e.cp_bg_line_c);
            ai.k(this.anU, d.e.cp_bg_line_c);
            ai.k(this.anV, d.e.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vH() {
        return ae.vz().vH();
    }

    private void xf() {
        if (vH()) {
            if (this.anM != null && this.anU != null) {
                if (this.anM.getVisibility() != 8) {
                    this.anM.setVisibility(8);
                }
                if (this.anU.getVisibility() != 0) {
                    this.anU.setVisibility(0);
                }
            }
        } else if (this.anM != null && this.anU != null) {
            if (this.anM.getVisibility() != 0) {
                this.anM.setVisibility(0);
            }
            if (this.anU.getVisibility() != 8) {
                this.anU.setVisibility(8);
            }
        }
    }

    private void xg() {
        this.anR = new com.baidu.tieba.b.d.a(getContext());
        this.anR.setVisibility(4);
        this.anR.setEGLConfigChooser(this.anS);
        this.anT.a(this.anW, this.anW, this.anX, this.anW, this.anW, this.anW);
        this.anR.setRenderer(this.anT);
        this.anV.removeAllViews();
        this.anV.addView(this.anR);
    }

    private void release() {
        if (vH()) {
            if (this.anQ != null) {
                this.anQ.stop();
                this.anQ = null;
                return;
            }
            return;
        }
        if (this.anW != null) {
            this.anW.recycle();
            this.anW = null;
        }
        if (this.anX != null) {
            this.anX.recycle();
            this.anX = null;
        }
        if (this.anY != null) {
            this.anY.recycle();
            this.anY = null;
        }
    }
}

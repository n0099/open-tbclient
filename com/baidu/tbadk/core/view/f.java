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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.animation3d.View.GLTextureView;
import com.baidu.tieba.d;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.widget.ListView.c {
    protected LinearLayout awf;
    protected ImageView awg;
    private b awh;
    private a awi;
    private c awj;
    protected AnimationDrawable awk;
    private GLTextureView awl;
    private GLTextureView.e awm;
    protected com.baidu.tieba.animation3d.b.b awn;
    protected LinearLayout awo;
    protected FrameLayout awp;
    private Bitmap awq;
    private Bitmap awr;
    private Bitmap aws;
    private boolean awt;
    protected View mHeaderView;
    protected int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void c(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aS(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aT(boolean z);
    }

    public f(Context context) {
        super(context);
        this.mHeaderView = null;
        this.awf = null;
        this.awg = null;
        this.awh = null;
        this.awi = null;
        this.awj = null;
        this.awq = null;
        this.awr = null;
        this.aws = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.awt = false;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nn() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(d.i.tb_pull_view, (ViewGroup) null);
        this.awf = (LinearLayout) this.mHeaderView.findViewById(d.g.pull_root);
        this.awo = (LinearLayout) this.awf.findViewById(d.g.cube_container);
        this.awp = (FrameLayout) this.awf.findViewById(d.g.loading_cube);
        this.awg = (ImageView) this.mHeaderView.findViewById(d.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        if (!zf()) {
            this.awk = ag.yX().cJ(skinType);
        }
        this.awg.setBackgroundDrawable(this.awk);
        this.awm = new GLTextureView.e() { // from class: com.baidu.tbadk.core.view.f.1
            @Override // com.baidu.tieba.animation3d.View.GLTextureView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 1, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        };
        this.awn = new com.baidu.tieba.animation3d.b.b(getContext());
        dy(skinType);
        this.awq = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.cube_top);
        this.awr = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_arrow);
        this.aws = BitmapHelper.getResBitmapPowerOf2Size(getContext(), d.f.btn_frs_post_ok);
        if (this.awq == null || this.awr == null || this.aws == null) {
            ag.yX().aH(false);
        }
        this.awn.a(this.awq, this.awq, this.awr, this.awq, this.awq, this.awq);
        this.awl = new GLTextureView(getContext());
        this.awl.setEGLConfigChooser(this.awm);
        this.awl.setRenderer(this.awn);
        try {
            this.awl.setRenderMode(0);
        } catch (Exception e) {
        }
        this.awp.addView(this.awl);
        this.awn.aid();
        AA();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void no() {
        if (zf()) {
            if (!this.awt) {
                AB();
                this.awl.requestRender();
                this.awl.onResume();
                this.awn.aid();
            }
            this.awl.setVisibility(0);
            this.awl.setRenderMode(1);
        } else if (this.awk != null && this.awg != null) {
            this.awk.stop();
            this.awg.setBackgroundDrawable(this.awk.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        if (this.awj != null) {
            this.awj.aT(z);
        }
        AA();
        this.awt = true;
        if (zf()) {
            AB();
            this.awl.requestRender();
            this.awl.onResume();
            this.awl.setRenderMode(1);
            if (z) {
                this.awn.aif();
            }
            this.awn.aid();
            this.awl.setVisibility(0);
        } else if (this.awk != null && this.awg != null) {
            this.awk.stop();
            this.awg.setBackgroundDrawable(this.awk.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void np() {
        AA();
        if (zf()) {
            if (!this.awt) {
                AB();
            }
            this.awl.requestRender();
            this.awl.onResume();
            this.awl.setVisibility(0);
            this.awl.setRenderMode(1);
            this.awn.aie();
            this.awn.a(this.awq, this.awq, this.awq, this.awq, this.awq, this.awq);
        } else if (this.awk != null && this.awg != null) {
            this.awk.stop();
            this.awg.setBackgroundDrawable(this.awk);
            this.awg.post(new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.awk != null) {
                        f.this.awk.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        this.awt = false;
        if (zf()) {
            this.awn.a(this.awq, this.awq, this.awr, this.awq, this.awq, this.awq);
            if (this.awl != null) {
                this.awl.setRenderMode(0);
                this.awl.onPause();
            }
        } else if (this.awk != null) {
            this.awk.stop();
        }
        release();
        if (this.awi != null) {
            this.awi.c(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ab(boolean z) {
        if (this.awh != null) {
            this.awh.aS(z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nq() {
        if (zf()) {
            this.awn.a(this.awq, this.awq, this.aws, this.awq, this.awq, this.awq);
            this.awn.aif();
            this.awl.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.awh = bVar;
    }

    public void a(a aVar) {
        this.awi = aVar;
    }

    public void a(c cVar) {
        this.awj = cVar;
    }

    public void dy(int i) {
        if (zf() && this.awn != null) {
            if (this.awn.ayX != i) {
                this.awn.iC(al.getColor(i, d.C0141d.cp_bg_line_c));
                this.awn.ayX = i;
                if (this.awl != null) {
                    this.awl.onResume();
                }
            }
            al.e(this.mHeaderView, d.C0141d.cp_bg_line_c, i);
            al.e(this.awo, d.C0141d.cp_bg_line_c, i);
            al.e(this.awp, d.C0141d.cp_bg_line_c, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zf() {
        return ag.yX().zf();
    }

    private void AA() {
        if (zf()) {
            if (this.awg != null && this.awo != null) {
                if (this.awg.getVisibility() != 8) {
                    this.awg.setVisibility(8);
                }
                if (this.awo.getVisibility() != 0) {
                    this.awo.setVisibility(0);
                }
            }
        } else if (this.awg != null && this.awo != null) {
            if (this.awg.getVisibility() != 0) {
                this.awg.setVisibility(0);
            }
            if (this.awo.getVisibility() != 8) {
                this.awo.setVisibility(8);
            }
        }
    }

    private void AB() {
        this.awl = new GLTextureView(getContext());
        this.awl.setVisibility(4);
        this.awl.setEGLConfigChooser(this.awm);
        this.awn.a(this.awq, this.awq, this.awr, this.awq, this.awq, this.awq);
        this.awl.setRenderer(this.awn);
        this.awp.removeAllViews();
        this.awp.addView(this.awl);
    }

    private void release() {
        if (zf()) {
            if (this.awk != null) {
                this.awk.stop();
                this.awk = null;
                return;
            }
            return;
        }
        if (this.awq != null) {
            this.awq.recycle();
            this.awq = null;
        }
        if (this.awr != null) {
            this.awr.recycle();
            this.awr = null;
        }
        if (this.aws != null) {
            this.aws.recycle();
            this.aws = null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long nu() {
        return 2000L;
    }
}

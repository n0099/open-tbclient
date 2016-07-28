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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.b.d.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.d {
    private Bitmap adA;
    private boolean adB;
    protected View adl;
    protected LinearLayout adm;
    protected ImageView adn;
    private b ado;
    private c adp;
    private a adq;
    private d adr;
    protected AnimationDrawable ads;
    private com.baidu.tieba.b.d.a adt;
    private a.e adu;
    protected com.baidu.tieba.b.b.b adv;
    protected LinearLayout adw;
    protected FrameLayout adx;
    private Bitmap ady;
    private Bitmap adz;

    /* loaded from: classes.dex */
    public interface a {
        void E(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aH(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(View view, boolean z);
    }

    /* loaded from: classes.dex */
    public interface d {
        void aI(boolean z);
    }

    public t(Context context) {
        super(context);
        this.adl = null;
        this.adm = null;
        this.adn = null;
        this.ado = null;
        this.adp = null;
        this.ady = null;
        this.adz = null;
        this.adA = null;
        this.adB = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View jp() {
        this.adl = LayoutInflater.from(getContext()).inflate(u.h.tb_pull_view, (ViewGroup) null);
        this.adm = (LinearLayout) this.adl.findViewById(u.g.pull_root);
        this.adw = (LinearLayout) this.adm.findViewById(u.g.cube_container);
        this.adx = (FrameLayout) this.adm.findViewById(u.g.loading_cube);
        this.adn = (ImageView) this.adl.findViewById(u.g.pull_image);
        if (!tU()) {
            this.ads = com.baidu.tbadk.core.util.am.tM().cu(TbadkCoreApplication.m10getInst().getSkinType());
        }
        this.adn.setBackgroundDrawable(this.ads);
        this.adu = new u(this);
        this.adv = new com.baidu.tieba.b.b.b(getContext());
        cT(TbadkCoreApplication.m10getInst().getSkinType());
        this.ady = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.cube_top);
        this.adz = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.btn_frs_post_arrow);
        this.adA = BitmapHelper.getResBitmapPowerOf2Size(getContext(), u.f.btn_frs_post_ok);
        if (this.ady == null || this.adz == null || this.adA == null) {
            com.baidu.tbadk.core.util.am.tM().az(false);
        }
        this.adv.a(this.ady, this.ady, this.adz, this.ady, this.ady, this.ady);
        this.adt = new com.baidu.tieba.b.d.a(getContext());
        this.adt.setEGLConfigChooser(this.adu);
        this.adt.setRenderer(this.adv);
        try {
            this.adt.setRenderMode(0);
        } catch (Exception e) {
        }
        this.adx.addView(this.adt);
        this.adv.Ka();
        vo();
        return this.adl;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jq() {
        if (tU()) {
            this.adt.setVisibility(0);
            this.adt.setRenderMode(1);
        } else if (this.ads != null && this.adn != null) {
            this.ads.stop();
            this.adn.setBackgroundDrawable(this.ads.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        if (this.adr != null) {
            this.adr.aI(z);
        }
        vo();
        this.adB = true;
        if (tU()) {
            vp();
            this.adt.requestRender();
            this.adt.onResume();
            this.adt.setRenderMode(1);
            if (z) {
                this.adv.Kc();
            }
            this.adv.Ka();
            this.adt.setVisibility(0);
        } else if (this.ads != null && this.adn != null) {
            this.ads.stop();
            this.adn.setBackgroundDrawable(this.ads.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jr() {
        vo();
        if (tU()) {
            if (!this.adB) {
                vp();
            }
            this.adt.requestRender();
            this.adt.onResume();
            this.adt.setVisibility(0);
            this.adt.setRenderMode(1);
            this.adv.Kb();
            this.adv.a(this.ady, this.ady, this.ady, this.ady, this.ady, this.ady);
        } else if (this.ads != null && this.adn != null) {
            this.ads.stop();
            this.adn.setBackgroundDrawable(this.ads);
            this.adn.post(new v(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        this.adB = false;
        if (tU()) {
            this.adv.a(this.ady, this.ady, this.adz, this.ady, this.ady, this.ady);
            if (this.adt != null) {
                this.adt.setRenderMode(0);
                this.adt.onPause();
            }
        } else if (this.ads != null) {
            this.ads.stop();
        }
        release();
        if (this.adq != null) {
            this.adq.E(this.adl);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        if (this.ado != null) {
            this.ado.aH(z);
        }
        if (this.adp != null) {
            this.adp.b(this.adl, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void js() {
        if (tU()) {
            this.adv.a(this.ady, this.ady, this.adA, this.ady, this.ady, this.ady);
            this.adv.Kc();
            this.adt.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.ado = bVar;
    }

    public void a(c cVar) {
        this.adp = cVar;
    }

    public void a(a aVar) {
        this.adq = aVar;
    }

    public void a(d dVar) {
        this.adr = dVar;
    }

    public void cT(int i) {
        if (tU() && this.adv != null) {
            if (this.adv.afy != i) {
                this.adv.fA(av.getColor(u.d.cp_bg_line_c));
                this.adv.afy = i;
            }
            av.l(this.adl, u.d.cp_bg_line_c);
            av.l(this.adw, u.d.cp_bg_line_c);
            av.l(this.adx, u.d.cp_bg_line_c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tU() {
        return com.baidu.tbadk.core.util.am.tM().tU();
    }

    private void vo() {
        if (tU()) {
            if (this.adn != null && this.adw != null) {
                if (this.adn.getVisibility() != 8) {
                    this.adn.setVisibility(8);
                }
                if (this.adw.getVisibility() != 0) {
                    this.adw.setVisibility(0);
                }
            }
        } else if (this.adn != null && this.adw != null) {
            if (this.adn.getVisibility() != 0) {
                this.adn.setVisibility(0);
            }
            if (this.adw.getVisibility() != 8) {
                this.adw.setVisibility(8);
            }
        }
    }

    private void vp() {
        this.adt = new com.baidu.tieba.b.d.a(getContext());
        this.adt.setVisibility(4);
        this.adt.setEGLConfigChooser(this.adu);
        this.adv.a(this.ady, this.ady, this.adz, this.ady, this.ady, this.ady);
        this.adt.setRenderer(this.adv);
        this.adx.removeAllViews();
        this.adx.addView(this.adt);
    }

    private void release() {
        if (tU()) {
            if (this.ads != null) {
                this.ads.stop();
                this.ads = null;
                return;
            }
            return;
        }
        if (this.ady != null) {
            this.ady.recycle();
            this.ady = null;
        }
        if (this.adz != null) {
            this.adz.recycle();
            this.adz = null;
        }
        if (this.adA != null) {
            this.adA.recycle();
            this.adA = null;
        }
    }
}

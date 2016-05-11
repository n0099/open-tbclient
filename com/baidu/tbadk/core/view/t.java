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
import com.baidu.tieba.a.d.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.d {
    protected View acg;
    protected LinearLayout ach;
    protected ImageView aci;
    private b acj;
    private c ack;
    private a acl;
    protected AnimationDrawable acm;
    private com.baidu.tieba.a.d.a acn;
    private a.e aco;
    protected com.baidu.tieba.a.b.b acp;
    protected LinearLayout acq;
    protected FrameLayout acr;
    private Bitmap acs;
    private Bitmap act;
    private Bitmap acu;
    private boolean acv;

    /* loaded from: classes.dex */
    public interface a {
        void F(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aG(boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(View view, boolean z);
    }

    public t(Context context) {
        super(context);
        this.acg = null;
        this.ach = null;
        this.aci = null;
        this.acj = null;
        this.ack = null;
        this.acs = null;
        this.act = null;
        this.acu = null;
        this.acv = false;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View jn() {
        this.acg = LayoutInflater.from(getContext()).inflate(t.h.tb_pull_view, (ViewGroup) null);
        this.ach = (LinearLayout) this.acg.findViewById(t.g.pull_root);
        this.acq = (LinearLayout) this.ach.findViewById(t.g.cube_container);
        this.acr = (FrameLayout) this.ach.findViewById(t.g.loading_cube);
        this.aci = (ImageView) this.acg.findViewById(t.g.pull_image);
        this.acm = com.baidu.tbadk.core.util.al.tN().cu(TbadkCoreApplication.m11getInst().getSkinType());
        this.aci.setBackgroundDrawable(this.acm);
        this.aco = new u(this);
        this.acp = new com.baidu.tieba.a.b.b(getContext());
        cS(TbadkCoreApplication.m11getInst().getSkinType());
        this.acs = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.cube_top);
        this.act = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.btn_frs_post_arrow);
        this.acu = BitmapHelper.getResBitmapPowerOf2Size(getContext(), t.f.btn_frs_post_ok);
        if (this.acs == null || this.act == null || this.acu == null) {
            com.baidu.tbadk.core.util.al.tN().ay(false);
        }
        this.acp.a(this.acs, this.acs, this.act, this.acs, this.acs, this.acs);
        this.acn = new com.baidu.tieba.a.d.a(getContext());
        this.acn.setEGLConfigChooser(this.aco);
        this.acn.setRenderer(this.acp);
        try {
            this.acn.setRenderMode(0);
        } catch (Exception e) {
        }
        this.acr.addView(this.acn);
        this.acp.Jb();
        vn();
        return this.acg;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jo() {
        if (tV()) {
            this.acn.setVisibility(0);
            this.acn.setRenderMode(1);
        } else if (this.acm != null && this.aci != null) {
            this.acm.stop();
            this.aci.setBackgroundDrawable(this.acm.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        vn();
        this.acv = true;
        if (tV()) {
            vo();
            this.acn.requestRender();
            this.acn.onResume();
            this.acn.setRenderMode(1);
            if (z) {
                this.acp.Jd();
            }
            this.acp.Jb();
            this.acn.setVisibility(0);
        } else if (this.acm != null && this.aci != null) {
            this.acm.stop();
            this.aci.setBackgroundDrawable(this.acm.getFrame(0));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jp() {
        vn();
        if (tV()) {
            if (!this.acv) {
                vo();
            }
            this.acn.requestRender();
            this.acn.onResume();
            this.acn.setVisibility(0);
            this.acn.setRenderMode(1);
            this.acp.Jc();
            this.acp.a(this.acs, this.acs, this.acs, this.acs, this.acs, this.acs);
        } else if (this.acm != null && this.aci != null) {
            this.acm.stop();
            this.aci.setBackgroundDrawable(this.acm);
            this.aci.post(new v(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.acv = false;
        if (tV()) {
            this.acp.a(this.acs, this.acs, this.act, this.acs, this.acs, this.acs);
            if (this.acn != null) {
                this.acn.setRenderMode(0);
                this.acn.onPause();
            }
        } else if (this.acm != null) {
            this.acm.stop();
        }
        release();
        if (this.acl != null) {
            this.acl.F(this.acg);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        if (this.acj != null) {
            this.acj.aG(z);
        }
        if (this.ack != null) {
            this.ack.b(this.acg, z);
        }
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void jq() {
        if (tV()) {
            this.acp.a(this.acs, this.acs, this.acu, this.acs, this.acs, this.acs);
            this.acp.Jd();
            this.acn.setRenderMode(1);
        }
    }

    public void a(b bVar) {
        this.acj = bVar;
    }

    public void a(c cVar) {
        this.ack = cVar;
    }

    public void a(a aVar) {
        this.acl = aVar;
    }

    public void cS(int i) {
        if (tV() && this.acp != null) {
            this.acp.fq(com.baidu.tbadk.core.util.at.getColor(t.d.cp_bg_line_c));
            com.baidu.tbadk.core.util.at.l(this.acg, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.acq, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.l(this.acr, t.d.cp_bg_line_c);
        }
    }

    protected boolean tV() {
        return com.baidu.tbadk.core.util.al.tN().tV();
    }

    private void vn() {
        if (tV()) {
            if (this.aci != null && this.acq != null) {
                if (this.aci.getVisibility() != 8) {
                    this.aci.setVisibility(8);
                }
                if (this.acq.getVisibility() != 0) {
                    this.acq.setVisibility(0);
                }
            }
        } else if (this.aci != null && this.acq != null) {
            if (this.aci.getVisibility() != 0) {
                this.aci.setVisibility(0);
            }
            if (this.acq.getVisibility() != 8) {
                this.acq.setVisibility(8);
            }
        }
    }

    private void vo() {
        this.acn = new com.baidu.tieba.a.d.a(getContext());
        this.acn.setVisibility(4);
        this.acn.setEGLConfigChooser(this.aco);
        this.acp.a(this.acs, this.acs, this.act, this.acs, this.acs, this.acs);
        this.acn.setRenderer(this.acp);
        this.acr.removeAllViews();
        this.acr.addView(this.acn);
    }

    private void release() {
        if (tV()) {
            if (this.acm != null) {
                this.acm.stop();
                this.acm = null;
                return;
            }
            return;
        }
        if (this.acs != null) {
            this.acs.recycle();
            this.acs = null;
        }
        if (this.act != null) {
            this.act.recycle();
            this.act = null;
        }
        if (this.acu != null) {
            this.acu.recycle();
            this.acu = null;
        }
    }
}

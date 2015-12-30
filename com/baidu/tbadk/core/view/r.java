package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.d {
    private View agl;
    protected LinearLayout agm;
    protected ImageView agn;
    private a ago;
    private b agp;
    protected AnimationDrawable agq;

    /* loaded from: classes.dex */
    public interface a {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, boolean z);
    }

    public r(Context context) {
        super(context);
        this.agl = null;
        this.agm = null;
        this.agn = null;
        this.ago = null;
        this.agp = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View mT() {
        this.agl = LayoutInflater.from(getContext()).inflate(n.h.tb_pull_view, (ViewGroup) null);
        this.agm = (LinearLayout) this.agl.findViewById(n.g.pull_root);
        this.agn = (ImageView) this.agl.findViewById(n.g.pull_image);
        this.agq = ak.uJ().cr(TbadkCoreApplication.m411getInst().getSkinType());
        this.agn.setBackgroundDrawable(this.agq);
        return this.agl;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void mU() {
        this.agq.stop();
        this.agn.setBackgroundDrawable(this.agq.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.agq.stop();
        this.agn.setBackgroundDrawable(this.agq.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void mV() {
        this.agq.stop();
        this.agn.setBackgroundDrawable(this.agq);
        this.agn.post(new s(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        this.agq.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        if (this.ago != null) {
            this.ago.onListPullRefresh(z);
        }
        if (this.agp != null) {
            this.agp.a(this.agl, z);
        }
    }

    public void a(a aVar) {
        this.ago = aVar;
    }

    public void a(b bVar) {
        this.agp = bVar;
    }
}

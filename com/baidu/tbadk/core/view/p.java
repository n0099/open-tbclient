package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.widget.ListView.d {
    private View aeB;
    protected LinearLayout aeC;
    protected ImageView aeD;
    private a aeE;
    private b aeF;
    protected AnimationDrawable aeG;

    /* loaded from: classes.dex */
    public interface a {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, boolean z);
    }

    public p(Context context) {
        super(context);
        this.aeB = null;
        this.aeC = null;
        this.aeD = null;
        this.aeE = null;
        this.aeF = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View np() {
        this.aeB = LayoutInflater.from(getContext()).inflate(i.g.tb_pull_view, (ViewGroup) null);
        this.aeC = (LinearLayout) this.aeB.findViewById(i.f.pull_root);
        this.aeD = (ImageView) this.aeB.findViewById(i.f.pull_image);
        this.aeG = af.ut().cq(TbadkCoreApplication.m411getInst().getSkinType());
        this.aeD.setBackgroundDrawable(this.aeG);
        return this.aeB;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nq() {
        this.aeG.stop();
        this.aeD.setBackgroundDrawable(this.aeG.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.aeG.stop();
        this.aeD.setBackgroundDrawable(this.aeG.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nr() {
        this.aeG.stop();
        this.aeD.setBackgroundDrawable(this.aeG);
        this.aeD.post(new q(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aeG.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.aeE != null) {
            this.aeE.onListPullRefresh(z);
        }
        if (this.aeF != null) {
            this.aeF.a(this.aeB, z);
        }
    }

    public void a(a aVar) {
        this.aeE = aVar;
    }

    public void a(b bVar) {
        this.aeF = bVar;
    }
}

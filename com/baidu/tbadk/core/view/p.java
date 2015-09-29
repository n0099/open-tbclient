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
    protected AnimationDrawable aeA;
    private View aev;
    protected LinearLayout aew;
    protected ImageView aex;
    private a aey;
    private b aez;

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
        this.aev = null;
        this.aew = null;
        this.aex = null;
        this.aey = null;
        this.aez = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View no() {
        this.aev = LayoutInflater.from(getContext()).inflate(i.g.tb_pull_view, (ViewGroup) null);
        this.aew = (LinearLayout) this.aev.findViewById(i.f.pull_root);
        this.aex = (ImageView) this.aev.findViewById(i.f.pull_image);
        this.aeA = af.ut().cq(TbadkCoreApplication.m411getInst().getSkinType());
        this.aex.setBackgroundDrawable(this.aeA);
        return this.aev;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void np() {
        this.aeA.stop();
        this.aex.setBackgroundDrawable(this.aeA.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.aeA.stop();
        this.aex.setBackgroundDrawable(this.aeA.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nq() {
        this.aeA.stop();
        this.aex.setBackgroundDrawable(this.aeA);
        this.aex.post(new q(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aeA.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.aey != null) {
            this.aey.onListPullRefresh(z);
        }
        if (this.aez != null) {
            this.aez.a(this.aev, z);
        }
    }

    public void a(a aVar) {
        this.aey = aVar;
    }

    public void a(b bVar) {
        this.aez = bVar;
    }
}

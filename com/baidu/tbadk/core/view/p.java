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
    private b aeA;
    protected AnimationDrawable aeB;
    private View aew;
    protected LinearLayout aex;
    protected ImageView aey;
    private a aez;

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
        this.aew = null;
        this.aex = null;
        this.aey = null;
        this.aez = null;
        this.aeA = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View no() {
        this.aew = LayoutInflater.from(getContext()).inflate(i.g.tb_pull_view, (ViewGroup) null);
        this.aex = (LinearLayout) this.aew.findViewById(i.f.pull_root);
        this.aey = (ImageView) this.aew.findViewById(i.f.pull_image);
        this.aeB = af.ut().cq(TbadkCoreApplication.m411getInst().getSkinType());
        this.aey.setBackgroundDrawable(this.aeB);
        return this.aew;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void np() {
        this.aeB.stop();
        this.aey.setBackgroundDrawable(this.aeB.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.aeB.stop();
        this.aey.setBackgroundDrawable(this.aeB.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nq() {
        this.aeB.stop();
        this.aey.setBackgroundDrawable(this.aeB);
        this.aey.post(new q(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.aeB.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.aez != null) {
            this.aez.onListPullRefresh(z);
        }
        if (this.aeA != null) {
            this.aeA.a(this.aew, z);
        }
    }

    public void a(a aVar) {
        this.aez = aVar;
    }

    public void a(b bVar) {
        this.aeA = bVar;
    }
}

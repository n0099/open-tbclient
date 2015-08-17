package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.d {
    private View aeY;
    protected LinearLayout aeZ;
    protected ImageView afa;
    private a afb;
    private b afc;
    protected AnimationDrawable afd;

    /* loaded from: classes.dex */
    public interface a {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, boolean z);
    }

    public x(Context context) {
        super(context);
        this.aeY = null;
        this.aeZ = null;
        this.afa = null;
        this.afb = null;
        this.afc = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View nq() {
        this.aeY = LayoutInflater.from(getContext()).inflate(i.g.tb_pull_view, (ViewGroup) null);
        this.aeZ = (LinearLayout) this.aeY.findViewById(i.f.pull_root);
        this.afa = (ImageView) this.aeY.findViewById(i.f.pull_image);
        this.afd = com.baidu.tbadk.core.util.ae.uq().ck(TbadkCoreApplication.m411getInst().getSkinType());
        this.afa.setBackgroundDrawable(this.afd);
        return this.aeY;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nr() {
        this.afd.stop();
        this.afa.setBackgroundDrawable(this.afd.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.afd.stop();
        this.afa.setBackgroundDrawable(this.afd.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void ns() {
        this.afd.stop();
        this.afa.setBackgroundDrawable(this.afd);
        this.afa.post(new y(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afd.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.afb != null) {
            this.afb.onListPullRefresh(z);
        }
        if (this.afc != null) {
            this.afc.a(this.aeY, z);
        }
    }

    public void a(a aVar) {
        this.afb = aVar;
    }

    public void a(b bVar) {
        this.afc = bVar;
    }
}

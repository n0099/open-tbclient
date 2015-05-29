package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.widget.ListView.f {
    private View ZX;
    protected LinearLayout ZY;
    protected ImageView ZZ;
    private aj aaa;
    private ak aab;
    protected AnimationDrawable aac;

    public ah(Context context) {
        super(context);
        this.ZX = null;
        this.ZY = null;
        this.ZZ = null;
        this.aaa = null;
        this.aab = null;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public View ng() {
        this.ZX = com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.tb_pull_view, null);
        this.ZY = (LinearLayout) this.ZX.findViewById(com.baidu.tieba.q.pull_root);
        this.ZZ = (ImageView) this.ZX.findViewById(com.baidu.tieba.q.pull_image);
        this.aac = com.baidu.tbadk.core.util.aq.to().ce(TbadkCoreApplication.m411getInst().getSkinType());
        this.ZZ.setBackgroundDrawable(this.aac);
        return this.ZX;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void nh() {
        this.aac.stop();
        this.ZZ.setBackgroundDrawable(this.aac.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
        this.aac.stop();
        this.ZZ.setBackgroundDrawable(this.aac.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void ni() {
        this.aac.stop();
        this.ZZ.setBackgroundDrawable(this.aac);
        this.ZZ.post(new ai(this));
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void R(boolean z) {
        this.aac.stop();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void S(boolean z) {
        if (this.aaa != null) {
            this.aaa.onListPullRefresh(z);
        }
        if (this.aab != null) {
            this.aab.a(this.ZX, z);
        }
    }

    public void a(aj ajVar) {
        this.aaa = ajVar;
    }

    public void a(ak akVar) {
        this.aab = akVar;
    }
}

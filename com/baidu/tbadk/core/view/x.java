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
    private View afi;
    protected LinearLayout afj;
    protected ImageView afk;
    private a afl;
    private b afm;
    protected AnimationDrawable afn;

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
        this.afi = null;
        this.afj = null;
        this.afk = null;
        this.afl = null;
        this.afm = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View nn() {
        this.afi = LayoutInflater.from(getContext()).inflate(i.g.tb_pull_view, (ViewGroup) null);
        this.afj = (LinearLayout) this.afi.findViewById(i.f.pull_root);
        this.afk = (ImageView) this.afi.findViewById(i.f.pull_image);
        this.afn = com.baidu.tbadk.core.util.ae.uv().co(TbadkCoreApplication.m411getInst().getSkinType());
        this.afk.setBackgroundDrawable(this.afn);
        return this.afi;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void no() {
        this.afn.stop();
        this.afk.setBackgroundDrawable(this.afn.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.afn.stop();
        this.afk.setBackgroundDrawable(this.afn.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void np() {
        this.afn.stop();
        this.afk.setBackgroundDrawable(this.afn);
        this.afk.post(new y(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afn.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.afl != null) {
            this.afl.onListPullRefresh(z);
        }
        if (this.afm != null) {
            this.afm.a(this.afi, z);
        }
    }

    public void a(a aVar) {
        this.afl = aVar;
    }

    public void a(b bVar) {
        this.afm = bVar;
    }
}

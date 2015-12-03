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
public class q extends com.baidu.adp.widget.ListView.d {
    protected ImageView afA;
    private a afB;
    private b afC;
    protected AnimationDrawable afD;
    private View afy;
    protected LinearLayout afz;

    /* loaded from: classes.dex */
    public interface a {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, boolean z);
    }

    public q(Context context) {
        super(context);
        this.afy = null;
        this.afz = null;
        this.afA = null;
        this.afB = null;
        this.afC = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View nv() {
        this.afy = LayoutInflater.from(getContext()).inflate(n.g.tb_pull_view, (ViewGroup) null);
        this.afz = (LinearLayout) this.afy.findViewById(n.f.pull_root);
        this.afA = (ImageView) this.afy.findViewById(n.f.pull_image);
        this.afD = ak.uZ().cy(TbadkCoreApplication.m411getInst().getSkinType());
        this.afA.setBackgroundDrawable(this.afD);
        return this.afy;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nw() {
        this.afD.stop();
        this.afA.setBackgroundDrawable(this.afD.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        this.afD.stop();
        this.afA.setBackgroundDrawable(this.afD.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nx() {
        this.afD.stop();
        this.afA.setBackgroundDrawable(this.afD);
        this.afA.post(new r(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        this.afD.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        if (this.afB != null) {
            this.afB.onListPullRefresh(z);
        }
        if (this.afC != null) {
            this.afC.a(this.afy, z);
        }
    }

    public void a(a aVar) {
        this.afB = aVar;
    }

    public void a(b bVar) {
        this.afC = bVar;
    }
}

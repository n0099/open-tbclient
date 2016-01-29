package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.widget.ListView.d {
    private View agZ;
    protected LinearLayout aha;
    protected ImageView ahb;
    private a ahc;
    private b ahd;
    protected AnimationDrawable ahe;

    /* loaded from: classes.dex */
    public interface a {
        void az(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(View view, boolean z);
    }

    public r(Context context) {
        super(context);
        this.agZ = null;
        this.aha = null;
        this.ahb = null;
        this.ahc = null;
        this.ahd = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View ni() {
        this.agZ = LayoutInflater.from(getContext()).inflate(t.h.tb_pull_view, (ViewGroup) null);
        this.aha = (LinearLayout) this.agZ.findViewById(t.g.pull_root);
        this.ahb = (ImageView) this.agZ.findViewById(t.g.pull_image);
        this.ahe = aj.vO().cI(TbadkCoreApplication.m411getInst().getSkinType());
        this.ahb.setBackgroundDrawable(this.ahe);
        return this.agZ;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nj() {
        this.ahe.stop();
        this.ahb.setBackgroundDrawable(this.ahe.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.ahe.stop();
        this.ahb.setBackgroundDrawable(this.ahe.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nk() {
        this.ahe.stop();
        this.ahb.setBackgroundDrawable(this.ahe);
        this.ahb.post(new s(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        this.ahe.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        if (this.ahc != null) {
            this.ahc.az(z);
        }
        if (this.ahd != null) {
            this.ahd.b(this.agZ, z);
        }
    }

    public void a(a aVar) {
        this.ahc = aVar;
    }

    public void a(b bVar) {
        this.ahd = bVar;
    }
}

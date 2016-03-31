package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.d {
    private View agA;
    protected LinearLayout agB;
    protected ImageView agC;
    private a agD;
    private b agE;
    protected AnimationDrawable agF;

    /* loaded from: classes.dex */
    public interface a {
        void aB(boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(View view, boolean z);
    }

    public s(Context context) {
        super(context);
        this.agA = null;
        this.agB = null;
        this.agC = null;
        this.agD = null;
        this.agE = null;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View mZ() {
        this.agA = LayoutInflater.from(getContext()).inflate(t.h.tb_pull_view, (ViewGroup) null);
        this.agB = (LinearLayout) this.agA.findViewById(t.g.pull_root);
        this.agC = (ImageView) this.agA.findViewById(t.g.pull_image);
        this.agF = com.baidu.tbadk.core.util.al.wh().cL(TbadkCoreApplication.m411getInst().getSkinType());
        this.agC.setBackgroundDrawable(this.agF);
        return this.agA;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void na() {
        this.agF.stop();
        this.agC.setBackgroundDrawable(this.agF.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
        this.agF.stop();
        this.agC.setBackgroundDrawable(this.agF.getFrame(0));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void nb() {
        this.agF.stop();
        this.agC.setBackgroundDrawable(this.agF);
        this.agC.post(new t(this));
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
        this.agF.stop();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        if (this.agD != null) {
            this.agD.aB(z);
        }
        if (this.agE != null) {
            this.agE.b(this.agA, z);
        }
    }

    public void a(a aVar) {
        this.agD = aVar;
    }

    public void a(b bVar) {
        this.agE = bVar;
    }
}

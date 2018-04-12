package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends e {
    private ViewGroup adg;
    private TextView adh;
    private TextView adi;
    private View.OnClickListener adj;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.adg = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.adh = (TextView) this.adg.findViewById(d.g.yes);
        this.adi = (TextView) this.adg.findViewById(d.g.no);
    }

    public f a(int i, View.OnClickListener onClickListener) {
        this.adh.setText(i);
        this.adh.setOnClickListener(onClickListener);
        this.adj = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            ak.h(this.adh, d.C0126d.cp_link_tip_a);
            this.adh.setOnClickListener(this.adj);
            return;
        }
        ak.h(this.adh, d.C0126d.cp_cont_e);
        this.adh.setOnClickListener(null);
    }

    public f b(int i, View.OnClickListener onClickListener) {
        this.adi.setText(i);
        this.adi.setOnClickListener(onClickListener);
        return this;
    }
}

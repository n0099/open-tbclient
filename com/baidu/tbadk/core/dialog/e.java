package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends d {
    private ViewGroup acb;
    private TextView acc;
    private TextView acd;
    private View.OnClickListener ace;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.acb = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.acc = (TextView) this.acb.findViewById(d.g.yes);
        this.acd = (TextView) this.acb.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.acc.setText(i);
        this.acc.setOnClickListener(onClickListener);
        this.ace = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.i(this.acc, d.C0095d.cp_link_tip_a);
            this.acc.setOnClickListener(this.ace);
            return;
        }
        aj.i(this.acc, d.C0095d.cp_cont_e);
        this.acc.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.acd.setText(i);
        this.acd.setOnClickListener(onClickListener);
        return this;
    }
}

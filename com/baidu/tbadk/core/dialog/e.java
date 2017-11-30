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
    private ViewGroup ace;
    private TextView acf;
    private TextView acg;
    private View.OnClickListener ach;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.ace = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.acf = (TextView) this.ace.findViewById(d.g.yes);
        this.acg = (TextView) this.ace.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.acf.setText(i);
        this.acf.setOnClickListener(onClickListener);
        this.ach = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.i(this.acf, d.C0082d.cp_link_tip_a);
            this.acf.setOnClickListener(this.ach);
            return;
        }
        aj.i(this.acf, d.C0082d.cp_cont_e);
        this.acf.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.acg.setText(i);
        this.acg.setOnClickListener(onClickListener);
        return this;
    }
}

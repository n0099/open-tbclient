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
    private ViewGroup aQt;
    private TextView aQu;
    private TextView aQv;
    private View.OnClickListener aQw;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aQt = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aQu = (TextView) this.aQt.findViewById(d.g.yes);
        this.aQv = (TextView) this.aQt.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.aQu.setText(i);
        this.aQu.setOnClickListener(onClickListener);
        this.aQw = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aQu, d.C0108d.cp_link_tip_a);
            this.aQu.setOnClickListener(this.aQw);
            return;
        }
        aj.r(this.aQu, d.C0108d.cp_cont_e);
        this.aQu.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.aQv.setText(i);
        this.aQv.setOnClickListener(onClickListener);
        return this;
    }
}

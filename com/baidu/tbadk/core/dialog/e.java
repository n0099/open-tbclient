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
    private ViewGroup aQr;
    private TextView aQs;
    private TextView aQt;
    private View.OnClickListener aQu;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aQr = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aQs = (TextView) this.aQr.findViewById(d.g.yes);
        this.aQt = (TextView) this.aQr.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.aQs.setText(i);
        this.aQs.setOnClickListener(onClickListener);
        this.aQu = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aQs, d.C0108d.cp_link_tip_a);
            this.aQs.setOnClickListener(this.aQu);
            return;
        }
        aj.r(this.aQs, d.C0108d.cp_cont_e);
        this.aQs.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.aQt.setText(i);
        this.aQt.setOnClickListener(onClickListener);
        return this;
    }
}

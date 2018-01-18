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
    private ViewGroup aQq;
    private TextView aQr;
    private TextView aQs;
    private View.OnClickListener aQt;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aQq = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aQr = (TextView) this.aQq.findViewById(d.g.yes);
        this.aQs = (TextView) this.aQq.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.aQr.setText(i);
        this.aQr.setOnClickListener(onClickListener);
        this.aQt = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aQr, d.C0107d.cp_link_tip_a);
            this.aQr.setOnClickListener(this.aQt);
            return;
        }
        aj.r(this.aQr, d.C0107d.cp_cont_e);
        this.aQr.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.aQs.setText(i);
        this.aQs.setOnClickListener(onClickListener);
        return this;
    }
}

package com.baidu.tbadk.core.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends e {
    private ViewGroup aRJ;
    private TextView aRK;
    private TextView aRL;
    private View.OnClickListener aRM;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aRJ = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aRK = (TextView) this.aRJ.findViewById(d.g.yes);
        this.aRL = (TextView) this.aRJ.findViewById(d.g.no);
    }

    public f a(int i, View.OnClickListener onClickListener) {
        this.aRK.setText(i);
        this.aRK.setOnClickListener(onClickListener);
        this.aRM = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aRK, d.C0141d.cp_link_tip_a);
            this.aRK.setOnClickListener(this.aRM);
            return;
        }
        aj.r(this.aRK, d.C0141d.cp_cont_e);
        this.aRK.setOnClickListener(null);
    }

    public f b(int i, View.OnClickListener onClickListener) {
        this.aRL.setText(i);
        this.aRL.setOnClickListener(onClickListener);
        return this;
    }
}

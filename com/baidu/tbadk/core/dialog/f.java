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
    private ViewGroup aRH;
    private TextView aRI;
    private TextView aRJ;
    private View.OnClickListener aRK;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aRH = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aRI = (TextView) this.aRH.findViewById(d.g.yes);
        this.aRJ = (TextView) this.aRH.findViewById(d.g.no);
    }

    public f a(int i, View.OnClickListener onClickListener) {
        this.aRI.setText(i);
        this.aRI.setOnClickListener(onClickListener);
        this.aRK = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aRI, d.C0141d.cp_link_tip_a);
            this.aRI.setOnClickListener(this.aRK);
            return;
        }
        aj.r(this.aRI, d.C0141d.cp_cont_e);
        this.aRI.setOnClickListener(null);
    }

    public f b(int i, View.OnClickListener onClickListener) {
        this.aRJ.setText(i);
        this.aRJ.setOnClickListener(onClickListener);
        return this;
    }
}

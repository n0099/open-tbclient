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
    private ViewGroup aRS;
    private TextView aRT;
    private TextView aRU;
    private View.OnClickListener aRV;
    private TbPageContext<?> mPageContext;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.aRS = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.aRT = (TextView) this.aRS.findViewById(d.g.yes);
        this.aRU = (TextView) this.aRS.findViewById(d.g.no);
    }

    public f a(int i, View.OnClickListener onClickListener) {
        this.aRT.setText(i);
        this.aRT.setOnClickListener(onClickListener);
        this.aRV = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.r(this.aRT, d.C0140d.cp_link_tip_a);
            this.aRT.setOnClickListener(this.aRV);
            return;
        }
        aj.r(this.aRT, d.C0140d.cp_cont_e);
        this.aRT.setOnClickListener(null);
    }

    public f b(int i, View.OnClickListener onClickListener) {
        this.aRU.setText(i);
        this.aRU.setOnClickListener(onClickListener);
        return this;
    }
}

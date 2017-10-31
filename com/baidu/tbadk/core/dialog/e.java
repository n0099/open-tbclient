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
    private ViewGroup abJ;
    private TextView abK;
    private TextView abL;
    private View.OnClickListener abM;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.abJ = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.abK = (TextView) this.abJ.findViewById(d.g.yes);
        this.abL = (TextView) this.abJ.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.abK.setText(i);
        this.abK.setOnClickListener(onClickListener);
        this.abM = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.i(this.abK, d.C0080d.cp_link_tip_a);
            this.abK.setOnClickListener(this.abM);
            return;
        }
        aj.i(this.abK, d.C0080d.cp_cont_e);
        this.abK.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.abL.setText(i);
        this.abL.setOnClickListener(onClickListener);
        return this;
    }
}

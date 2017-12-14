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
    private ViewGroup abY;
    private TextView abZ;
    private TextView aca;
    private View.OnClickListener acb;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.abY = (ViewGroup) ((ViewStub) getRootView().findViewById(d.g.yes_no_viewStub)).inflate();
        this.abZ = (TextView) this.abY.findViewById(d.g.yes);
        this.aca = (TextView) this.abY.findViewById(d.g.no);
    }

    public e a(int i, View.OnClickListener onClickListener) {
        this.abZ.setText(i);
        this.abZ.setOnClickListener(onClickListener);
        this.acb = onClickListener;
        return this;
    }

    public void setPositiveButtonEnable(boolean z) {
        if (z) {
            aj.i(this.abZ, d.C0096d.cp_link_tip_a);
            this.abZ.setOnClickListener(this.acb);
            return;
        }
        aj.i(this.abZ, d.C0096d.cp_cont_e);
        this.abZ.setOnClickListener(null);
    }

    public e b(int i, View.OnClickListener onClickListener) {
        this.aca.setText(i);
        this.aca.setOnClickListener(onClickListener);
        return this;
    }
}

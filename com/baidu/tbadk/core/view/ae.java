package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ae extends RelativeLayout {
    private String Nq;
    private LinearLayout Nr;
    private TextView Ns;
    private TextView Nt;
    private View.OnClickListener Nu;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public ae(Context context) {
        super(context);
        this.Nq = "sq_tb_search";
        this.Nr = null;
        this.Ns = null;
        this.Nt = null;
        this.Nu = new af(this);
        this.mOnClickListener = new ag(this);
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.x.widget_search_box, this);
        this.Nr = (LinearLayout) findViewById(com.baidu.tieba.w.search_bg_layout);
        this.Ns = (TextView) findViewById(com.baidu.tieba.w.search_bar_text);
        this.Nr.setOnClickListener(this.mOnClickListener);
        this.Nt = (TextView) findViewById(com.baidu.tieba.w.search_from_qr);
        this.Nt.setOnClickListener(this.Nu);
    }

    public void setClickStatKey(String str) {
        this.Nq = str;
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) jVar;
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(this);
        }
        this.Ns.setHintTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.widget_searchbox_text));
        com.baidu.tbadk.core.util.ax.j(this, com.baidu.tieba.t.search_box_bg);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.Nr.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.Ns.setHint(charSequence);
    }

    public void setText(int i) {
        this.Ns.setHint(i);
    }
}

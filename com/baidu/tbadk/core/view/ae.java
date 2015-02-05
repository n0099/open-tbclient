package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class ae extends RelativeLayout {
    private String NJ;
    private LinearLayout NK;
    private TextView NL;
    private TextView NM;
    private View.OnClickListener NN;
    private Activity mCurrentActivity;
    private View.OnClickListener mOnClickListener;

    public ae(Context context) {
        super(context);
        this.NJ = "sq_tb_search";
        this.NK = null;
        this.NL = null;
        this.NM = null;
        this.NN = new af(this);
        this.mOnClickListener = new ag(this);
        init(context);
    }

    private void init(Context context) {
        this.mCurrentActivity = (Activity) context;
        com.baidu.adp.lib.g.b.ei().inflate(context, com.baidu.tieba.x.widget_search_box, this);
        this.NK = (LinearLayout) findViewById(com.baidu.tieba.w.search_bg_layout);
        this.NL = (TextView) findViewById(com.baidu.tieba.w.search_bar_text);
        this.NK.setOnClickListener(this.mOnClickListener);
        this.NM = (TextView) findViewById(com.baidu.tieba.w.search_from_qr);
        this.NM.setOnClickListener(this.NN);
    }

    public void setClickStatKey(String str) {
        this.NJ = str;
    }

    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        if (jVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) jVar;
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(this);
        }
        this.NL.setHintTextColor(bc.getColor(com.baidu.tieba.t.widget_searchbox_text));
        bc.j(this, com.baidu.tieba.t.search_box_bg);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.NK.setOnClickListener(onClickListener);
        }
    }

    public void setText(CharSequence charSequence) {
        this.NL.setHint(charSequence);
    }

    public void setText(int i) {
        this.NL.setHint(i);
    }
}

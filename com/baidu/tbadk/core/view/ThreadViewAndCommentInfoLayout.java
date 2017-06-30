package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView amm;
    private TextView amo;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.amo = (TextView) inflate.findViewById(w.h.thread_view_num);
        this.amm = (TextView) inflate.findViewById(w.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bm bmVar) {
        if (bmVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        h(bmVar);
        p(bmVar);
    }

    private void h(bm bmVar) {
        if (this.amo != null && bmVar != null) {
            if (bmVar.rk() >= 0) {
                this.amo.setVisibility(0);
                this.amo.setText(String.format(this.mContext.getString(w.l.person_view_num), com.baidu.tbadk.core.util.aw.t(bmVar.rk())));
                return;
            }
            this.amo.setVisibility(8);
        }
    }

    private void p(bm bmVar) {
        if (this.amm != null && bmVar != null) {
            if (bmVar.rj() >= 0) {
                this.amm.setVisibility(0);
                this.amm.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.aw.t(bmVar.rj())));
                return;
            }
            this.amm.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.i(this.amo, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.i(this.amm, w.e.cp_cont_d);
    }
}

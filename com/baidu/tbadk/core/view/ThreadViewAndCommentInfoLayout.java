package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView alI;
    private TextView alJ;
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
        this.alJ = (TextView) inflate.findViewById(w.h.thread_view_num);
        this.alI = (TextView) inflate.findViewById(w.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        g(bkVar);
        l(bkVar);
    }

    private void g(bk bkVar) {
        if (this.alJ != null && bkVar != null) {
            if (bkVar.rs() >= 0) {
                this.alJ.setVisibility(0);
                this.alJ.setText(String.format(this.mContext.getString(w.l.person_view_num), com.baidu.tbadk.core.util.au.t(bkVar.rs())));
                return;
            }
            this.alJ.setVisibility(8);
        }
    }

    private void l(bk bkVar) {
        if (this.alI != null && bkVar != null) {
            if (bkVar.rr() >= 0) {
                this.alI.setVisibility(0);
                this.alI.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.au.t(bkVar.rr())));
                return;
            }
            this.alI.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alJ, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.alI, w.e.cp_cont_d);
    }
}

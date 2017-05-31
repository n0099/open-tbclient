package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView aly;
    private TextView alz;
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
        this.alz = (TextView) inflate.findViewById(w.h.thread_view_num);
        this.aly = (TextView) inflate.findViewById(w.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        g(blVar);
        o(blVar);
    }

    private void g(bl blVar) {
        if (this.alz != null && blVar != null) {
            if (blVar.ro() >= 0) {
                this.alz.setVisibility(0);
                this.alz.setText(String.format(this.mContext.getString(w.l.person_view_num), com.baidu.tbadk.core.util.au.t(blVar.ro())));
                return;
            }
            this.alz.setVisibility(8);
        }
    }

    private void o(bl blVar) {
        if (this.aly != null && blVar != null) {
            if (blVar.rn() >= 0) {
                this.aly.setVisibility(0);
                this.aly.setText(String.format(this.mContext.getString(w.l.comment_num_tip), com.baidu.tbadk.core.util.au.t(blVar.rn())));
                return;
            }
            this.aly.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.i(this.alz, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.i(this.aly, w.e.cp_cont_d);
    }
}

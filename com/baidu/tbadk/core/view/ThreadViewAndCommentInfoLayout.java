package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dKx;
    public int ekb;
    private TextView elo;
    private boolean elp;
    private boolean elq;
    private boolean elr;
    private boolean els;
    private boolean elt;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.elp = false;
        this.elq = false;
        this.elr = false;
        this.els = false;
        this.elt = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elp = false;
        this.elq = false;
        this.elr = false;
        this.els = false;
        this.elt = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.elo = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dKx = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bv bvVar) {
        if (bvVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        J(bvVar);
        K(bvVar);
        L(bvVar);
        M(bvVar);
        y(bvVar);
    }

    private void J(bv bvVar) {
        if (this.elo != null && bvVar != null && this.elr && bvVar.aWF() != null && bvVar.aXF()) {
            this.elo.setVisibility(0);
            this.elo.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), as.numberUniformFormat(bvVar.aWF().audience_count)));
        }
    }

    private void K(bv bvVar) {
        if (this.elo != null && bvVar != null && this.elp) {
            if (bvVar.aWd() >= 0) {
                this.elo.setVisibility(0);
                this.elo.setText(String.format(this.mContext.getString(R.string.person_view_num), as.numberUniformFormat(bvVar.aWd())));
                return;
            }
            this.elo.setVisibility(8);
        }
    }

    private void L(bv bvVar) {
        if (this.dKx != null && bvVar != null && this.elq) {
            if (bvVar.aWc() >= 0) {
                this.dKx.setVisibility(0);
                this.dKx.setText(String.format(this.mContext.getString(R.string.comment_num_tip), as.numberUniformFormat(bvVar.aWc())));
                return;
            }
            this.dKx.setVisibility(8);
        }
    }

    private void M(bv bvVar) {
        if (this.dKx != null && bvVar != null && this.els && bvVar.aXF()) {
            this.dKx.setVisibility(0);
            this.dKx.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), as.numberUniformFormat(bvVar.aXJ())));
        }
    }

    private void y(bv bvVar) {
        if (this.dKx != null && bvVar != null && this.elt && bvVar.aXF()) {
            this.dKx.setVisibility(0);
            this.dKx.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), as.numberUniformFormat((bvVar.aWF() == null || bvVar.aWF().share_info == null) ? 0 : bvVar.aWF().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.elp = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.elq = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.elr = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.els = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.elt = z;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.elo, R.color.cp_cont_d);
        ao.setViewTextColor(this.dKx, R.color.cp_cont_d);
    }
}

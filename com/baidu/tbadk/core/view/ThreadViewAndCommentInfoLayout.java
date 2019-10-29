package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int cqT;
    private TextView cqq;
    private TextView csb;
    private boolean csc;
    private boolean csd;
    private boolean cse;
    private boolean csf;
    private boolean csg;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.csc = false;
        this.csd = false;
        this.cse = false;
        this.csf = false;
        this.csg = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csc = false;
        this.csd = false;
        this.cse = false;
        this.csf = false;
        this.csg = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.csb = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.cqq = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        E(bhVar);
        F(bhVar);
        G(bhVar);
        H(bhVar);
        q(bhVar);
    }

    private void E(bh bhVar) {
        if (this.csb != null && bhVar != null && this.cse && bhVar.aiZ() != null && bhVar.ajT()) {
            this.csb.setVisibility(0);
            this.csb.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bhVar.aiZ().audience_count)));
        }
    }

    private void F(bh bhVar) {
        if (this.csb != null && bhVar != null && this.csc) {
            if (bhVar.aiy() >= 0) {
                this.csb.setVisibility(0);
                this.csb.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bhVar.aiy())));
                return;
            }
            this.csb.setVisibility(8);
        }
    }

    private void G(bh bhVar) {
        if (this.cqq != null && bhVar != null && this.csd) {
            if (bhVar.aix() >= 0) {
                this.cqq.setVisibility(0);
                this.cqq.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bhVar.aix())));
                return;
            }
            this.cqq.setVisibility(8);
        }
    }

    private void H(bh bhVar) {
        if (this.cqq != null && bhVar != null && this.csf && bhVar.ajT()) {
            this.cqq.setVisibility(0);
            this.cqq.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bhVar.ajY())));
        }
    }

    private void q(bh bhVar) {
        if (this.cqq != null && bhVar != null && this.csg && bhVar.ajT()) {
            this.cqq.setVisibility(0);
            this.cqq.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bhVar.aiZ() == null || bhVar.aiZ().share_info == null) ? 0 : bhVar.aiZ().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.csc = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.csd = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.cse = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.csf = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.csg = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.csb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.cqq, (int) R.color.cp_cont_d);
    }
}

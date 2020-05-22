package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dVV;
    public int dWv;
    private TextView dXI;
    private boolean dXJ;
    private boolean dXK;
    private boolean dXL;
    private boolean dXM;
    private boolean dXN;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.dXJ = false;
        this.dXK = false;
        this.dXL = false;
        this.dXM = false;
        this.dXN = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXJ = false;
        this.dXK = false;
        this.dXL = false;
        this.dXM = false;
        this.dXN = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.dXI = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dVV = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        M(bkVar);
        N(bkVar);
        O(bkVar);
        P(bkVar);
        x(bkVar);
    }

    private void M(bk bkVar) {
        if (this.dXI != null && bkVar != null && this.dXL && bkVar.aQS() != null && bkVar.aRS()) {
            this.dXI.setVisibility(0);
            this.dXI.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bkVar.aQS().audience_count)));
        }
    }

    private void N(bk bkVar) {
        if (this.dXI != null && bkVar != null && this.dXJ) {
            if (bkVar.aQp() >= 0) {
                this.dXI.setVisibility(0);
                this.dXI.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bkVar.aQp())));
                return;
            }
            this.dXI.setVisibility(8);
        }
    }

    private void O(bk bkVar) {
        if (this.dVV != null && bkVar != null && this.dXK) {
            if (bkVar.aQo() >= 0) {
                this.dVV.setVisibility(0);
                this.dVV.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bkVar.aQo())));
                return;
            }
            this.dVV.setVisibility(8);
        }
    }

    private void P(bk bkVar) {
        if (this.dVV != null && bkVar != null && this.dXM && bkVar.aRS()) {
            this.dVV.setVisibility(0);
            this.dVV.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bkVar.aRW())));
        }
    }

    private void x(bk bkVar) {
        if (this.dVV != null && bkVar != null && this.dXN && bkVar.aRS()) {
            this.dVV.setVisibility(0);
            this.dVV.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bkVar.aQS() == null || bkVar.aQS().share_info == null) ? 0 : bkVar.aQS().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.dXJ = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.dXK = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.dXL = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.dXM = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.dXN = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dXI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dVV, (int) R.color.cp_cont_d);
    }
}

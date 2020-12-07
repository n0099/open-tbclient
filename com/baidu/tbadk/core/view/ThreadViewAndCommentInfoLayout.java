package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView eBF;
    public int fdg;
    private TextView feq;
    private boolean fer;
    private boolean fes;
    private boolean fet;
    private boolean feu;
    private boolean fev;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.fer = false;
        this.fes = false;
        this.fet = false;
        this.feu = false;
        this.fev = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fer = false;
        this.fes = false;
        this.fet = false;
        this.feu = false;
        this.fev = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.feq = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eBF = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(by byVar) {
        if (byVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        M(byVar);
        N(byVar);
        O(byVar);
        P(byVar);
        B(byVar);
    }

    private void M(by byVar) {
        if (this.feq != null && byVar != null && this.fet && byVar.bpj() != null && byVar.bql()) {
            this.feq.setVisibility(0);
            this.feq.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), au.numberUniformFormat(byVar.bpj().audience_count)));
        }
    }

    private void N(by byVar) {
        if (this.feq != null && byVar != null && this.fer) {
            if (byVar.boH() >= 0) {
                this.feq.setVisibility(0);
                this.feq.setText(String.format(this.mContext.getString(R.string.person_view_num), au.numberUniformFormat(byVar.boH())));
                return;
            }
            this.feq.setVisibility(8);
        }
    }

    private void O(by byVar) {
        if (this.eBF != null && byVar != null && this.fes) {
            if (byVar.boG() >= 0) {
                this.eBF.setVisibility(0);
                this.eBF.setText(String.format(this.mContext.getString(R.string.comment_num_tip), au.numberUniformFormat(byVar.boG())));
                return;
            }
            this.eBF.setVisibility(8);
        }
    }

    private void P(by byVar) {
        if (this.eBF != null && byVar != null && this.feu && byVar.bql()) {
            this.eBF.setVisibility(0);
            this.eBF.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), au.numberUniformFormat(byVar.bqp())));
        }
    }

    private void B(by byVar) {
        if (this.eBF != null && byVar != null && this.fev && byVar.bql()) {
            this.eBF.setVisibility(0);
            this.eBF.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), au.numberUniformFormat((byVar.bpj() == null || byVar.bpj().share_info == null) ? 0 : byVar.bpj().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.fer = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.fes = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.fet = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.feu = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.fev = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.feq, R.color.CAM_X0109);
        ap.setViewTextColor(this.eBF, R.color.CAM_X0109);
    }
}

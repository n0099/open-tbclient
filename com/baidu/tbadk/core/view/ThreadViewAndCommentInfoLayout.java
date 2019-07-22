package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int cbF;
    private TextView cbc;
    private TextView ccN;
    private boolean ccO;
    private boolean ccP;
    private boolean ccQ;
    private boolean ccR;
    private boolean ccS;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.ccO = false;
        this.ccP = false;
        this.ccQ = false;
        this.ccR = false;
        this.ccS = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccO = false;
        this.ccP = false;
        this.ccQ = false;
        this.ccR = false;
        this.ccS = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ccN = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.cbc = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        C(bgVar);
        D(bgVar);
        E(bgVar);
        F(bgVar);
        o(bgVar);
    }

    private void C(bg bgVar) {
        if (this.ccN != null && bgVar != null && this.ccQ && bgVar.aeQ() != null && bgVar.afL()) {
            this.ccN.setVisibility(0);
            this.ccN.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.aH(bgVar.aeQ().audience_count)));
        }
    }

    private void D(bg bgVar) {
        if (this.ccN != null && bgVar != null && this.ccO) {
            if (bgVar.aep() >= 0) {
                this.ccN.setVisibility(0);
                this.ccN.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.aH(bgVar.aep())));
                return;
            }
            this.ccN.setVisibility(8);
        }
    }

    private void E(bg bgVar) {
        if (this.cbc != null && bgVar != null && this.ccP) {
            if (bgVar.aeo() >= 0) {
                this.cbc.setVisibility(0);
                this.cbc.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.aH(bgVar.aeo())));
                return;
            }
            this.cbc.setVisibility(8);
        }
    }

    private void F(bg bgVar) {
        if (this.cbc != null && bgVar != null && this.ccR && bgVar.afL()) {
            this.cbc.setVisibility(0);
            this.cbc.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.aH(bgVar.afQ())));
        }
    }

    private void o(bg bgVar) {
        if (this.cbc != null && bgVar != null && this.ccS && bgVar.afL()) {
            this.cbc.setVisibility(0);
            this.cbc.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.aH((bgVar.aeQ() == null || bgVar.aeQ().share_info == null) ? 0 : bgVar.aeQ().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.ccO = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.ccP = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.ccQ = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ccR = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.ccS = z;
    }

    public void onChangeSkinType() {
        am.j(this.ccN, R.color.cp_cont_d);
        am.j(this.cbc, R.color.cp_cont_d);
    }
}

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
    public int ccG;
    private TextView ccc;
    private TextView cdN;
    private boolean cdO;
    private boolean cdP;
    private boolean cdQ;
    private boolean cdR;
    private boolean cdS;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.cdO = false;
        this.cdP = false;
        this.cdQ = false;
        this.cdR = false;
        this.cdS = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdO = false;
        this.cdP = false;
        this.cdQ = false;
        this.cdR = false;
        this.cdS = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.cdN = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.ccc = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.cdN != null && bhVar != null && this.cdQ && bhVar.aeV() != null && bhVar.afQ()) {
            this.cdN.setVisibility(0);
            this.cdN.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.aH(bhVar.aeV().audience_count)));
        }
    }

    private void F(bh bhVar) {
        if (this.cdN != null && bhVar != null && this.cdO) {
            if (bhVar.aeu() >= 0) {
                this.cdN.setVisibility(0);
                this.cdN.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.aH(bhVar.aeu())));
                return;
            }
            this.cdN.setVisibility(8);
        }
    }

    private void G(bh bhVar) {
        if (this.ccc != null && bhVar != null && this.cdP) {
            if (bhVar.aet() >= 0) {
                this.ccc.setVisibility(0);
                this.ccc.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.aH(bhVar.aet())));
                return;
            }
            this.ccc.setVisibility(8);
        }
    }

    private void H(bh bhVar) {
        if (this.ccc != null && bhVar != null && this.cdR && bhVar.afQ()) {
            this.ccc.setVisibility(0);
            this.ccc.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.aH(bhVar.afV())));
        }
    }

    private void q(bh bhVar) {
        if (this.ccc != null && bhVar != null && this.cdS && bhVar.afQ()) {
            this.ccc.setVisibility(0);
            this.ccc.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.aH((bhVar.aeV() == null || bhVar.aeV().share_info == null) ? 0 : bhVar.aeV().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.cdO = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.cdP = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.cdQ = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.cdR = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.cdS = z;
    }

    public void onChangeSkinType() {
        am.j(this.cdN, R.color.cp_cont_d);
        am.j(this.ccc, R.color.cp_cont_d);
    }
}

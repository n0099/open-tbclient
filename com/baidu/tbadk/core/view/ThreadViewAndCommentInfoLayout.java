package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int eWz;
    private TextView eXM;
    private boolean eXN;
    private boolean eXO;
    private boolean eXP;
    private boolean eXQ;
    private boolean eXR;
    private TextView ewm;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.eXN = false;
        this.eXO = false;
        this.eXP = false;
        this.eXQ = false;
        this.eXR = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXN = false;
        this.eXO = false;
        this.eXP = false;
        this.eXQ = false;
        this.eXR = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.eXM = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.ewm = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        K(bwVar);
        L(bwVar);
        M(bwVar);
        N(bwVar);
        z(bwVar);
    }

    private void K(bw bwVar) {
        if (this.eXM != null && bwVar != null && this.eXP && bwVar.bmU() != null && bwVar.bnU()) {
            this.eXM.setVisibility(0);
            this.eXM.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.bmU().audience_count)));
        }
    }

    private void L(bw bwVar) {
        if (this.eXM != null && bwVar != null && this.eXN) {
            if (bwVar.bms() >= 0) {
                this.eXM.setVisibility(0);
                this.eXM.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bms())));
                return;
            }
            this.eXM.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.ewm != null && bwVar != null && this.eXO) {
            if (bwVar.bmr() >= 0) {
                this.ewm.setVisibility(0);
                this.ewm.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bmr())));
                return;
            }
            this.ewm.setVisibility(8);
        }
    }

    private void N(bw bwVar) {
        if (this.ewm != null && bwVar != null && this.eXQ && bwVar.bnU()) {
            this.ewm.setVisibility(0);
            this.ewm.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bnY())));
        }
    }

    private void z(bw bwVar) {
        if (this.ewm != null && bwVar != null && this.eXR && bwVar.bnU()) {
            this.ewm.setVisibility(0);
            this.ewm.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.bmU() == null || bwVar.bmU().share_info == null) ? 0 : bwVar.bmU().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.eXN = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.eXO = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.eXP = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.eXQ = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.eXR = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eXM, R.color.cp_cont_d);
        ap.setViewTextColor(this.ewm, R.color.cp_cont_d);
    }
}

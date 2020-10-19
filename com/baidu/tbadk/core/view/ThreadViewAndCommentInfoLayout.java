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
    public int eIo;
    private TextView eJB;
    private boolean eJC;
    private boolean eJD;
    private boolean eJE;
    private boolean eJF;
    private boolean eJG;
    private TextView ehV;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.eJC = false;
        this.eJD = false;
        this.eJE = false;
        this.eJF = false;
        this.eJG = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJC = false;
        this.eJD = false;
        this.eJE = false;
        this.eJF = false;
        this.eJG = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.eJB = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.ehV = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.eJB != null && bwVar != null && this.eJE && bwVar.biB() != null && bwVar.bjB()) {
            this.eJB.setVisibility(0);
            this.eJB.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.biB().audience_count)));
        }
    }

    private void L(bw bwVar) {
        if (this.eJB != null && bwVar != null && this.eJC) {
            if (bwVar.bhZ() >= 0) {
                this.eJB.setVisibility(0);
                this.eJB.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bhZ())));
                return;
            }
            this.eJB.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.ehV != null && bwVar != null && this.eJD) {
            if (bwVar.bhY() >= 0) {
                this.ehV.setVisibility(0);
                this.ehV.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bhY())));
                return;
            }
            this.ehV.setVisibility(8);
        }
    }

    private void N(bw bwVar) {
        if (this.ehV != null && bwVar != null && this.eJF && bwVar.bjB()) {
            this.ehV.setVisibility(0);
            this.ehV.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bjF())));
        }
    }

    private void z(bw bwVar) {
        if (this.ehV != null && bwVar != null && this.eJG && bwVar.bjB()) {
            this.ehV.setVisibility(0);
            this.ehV.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.biB() == null || bwVar.biB().share_info == null) ? 0 : bwVar.biB().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.eJC = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.eJD = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.eJE = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.eJF = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.eJG = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eJB, R.color.cp_cont_d);
        ap.setViewTextColor(this.ehV, R.color.cp_cont_d);
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int eVJ;
    private TextView eWT;
    private boolean eWU;
    private boolean eWV;
    private boolean eWW;
    private boolean eWX;
    private boolean eWY;
    private TextView euD;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.eWU = false;
        this.eWV = false;
        this.eWW = false;
        this.eWX = false;
        this.eWY = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWU = false;
        this.eWV = false;
        this.eWW = false;
        this.eWX = false;
        this.eWY = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.eWT = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.euD = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bx bxVar) {
        if (bxVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        M(bxVar);
        N(bxVar);
        O(bxVar);
        P(bxVar);
        B(bxVar);
    }

    private void M(bx bxVar) {
        if (this.eWT != null && bxVar != null && this.eWW && bxVar.blW() != null && bxVar.bmY()) {
            this.eWT.setVisibility(0);
            this.eWT.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), au.numberUniformFormat(bxVar.blW().audience_count)));
        }
    }

    private void N(bx bxVar) {
        if (this.eWT != null && bxVar != null && this.eWU) {
            if (bxVar.blu() >= 0) {
                this.eWT.setVisibility(0);
                this.eWT.setText(String.format(this.mContext.getString(R.string.person_view_num), au.numberUniformFormat(bxVar.blu())));
                return;
            }
            this.eWT.setVisibility(8);
        }
    }

    private void O(bx bxVar) {
        if (this.euD != null && bxVar != null && this.eWV) {
            if (bxVar.blt() >= 0) {
                this.euD.setVisibility(0);
                this.euD.setText(String.format(this.mContext.getString(R.string.comment_num_tip), au.numberUniformFormat(bxVar.blt())));
                return;
            }
            this.euD.setVisibility(8);
        }
    }

    private void P(bx bxVar) {
        if (this.euD != null && bxVar != null && this.eWX && bxVar.bmY()) {
            this.euD.setVisibility(0);
            this.euD.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), au.numberUniformFormat(bxVar.bnc())));
        }
    }

    private void B(bx bxVar) {
        if (this.euD != null && bxVar != null && this.eWY && bxVar.bmY()) {
            this.euD.setVisibility(0);
            this.euD.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), au.numberUniformFormat((bxVar.blW() == null || bxVar.blW().share_info == null) ? 0 : bxVar.blW().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.eWU = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.eWV = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.eWW = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.eWX = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.eWY = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eWT, R.color.CAM_X0109);
        ap.setViewTextColor(this.euD, R.color.CAM_X0109);
    }
}

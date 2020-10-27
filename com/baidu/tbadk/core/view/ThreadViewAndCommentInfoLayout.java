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
    public int eQK;
    private TextView eRX;
    private boolean eRY;
    private boolean eRZ;
    private boolean eSa;
    private boolean eSb;
    private boolean eSc;
    private TextView eqt;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.eRY = false;
        this.eRZ = false;
        this.eSa = false;
        this.eSb = false;
        this.eSc = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRY = false;
        this.eRZ = false;
        this.eSa = false;
        this.eSb = false;
        this.eSc = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.eRX = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eqt = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.eRX != null && bwVar != null && this.eSa && bwVar.bku() != null && bwVar.blu()) {
            this.eRX.setVisibility(0);
            this.eRX.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.bku().audience_count)));
        }
    }

    private void L(bw bwVar) {
        if (this.eRX != null && bwVar != null && this.eRY) {
            if (bwVar.bjS() >= 0) {
                this.eRX.setVisibility(0);
                this.eRX.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bjS())));
                return;
            }
            this.eRX.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.eqt != null && bwVar != null && this.eRZ) {
            if (bwVar.bjR() >= 0) {
                this.eqt.setVisibility(0);
                this.eqt.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bjR())));
                return;
            }
            this.eqt.setVisibility(8);
        }
    }

    private void N(bw bwVar) {
        if (this.eqt != null && bwVar != null && this.eSb && bwVar.blu()) {
            this.eqt.setVisibility(0);
            this.eqt.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bly())));
        }
    }

    private void z(bw bwVar) {
        if (this.eqt != null && bwVar != null && this.eSc && bwVar.blu()) {
            this.eqt.setVisibility(0);
            this.eqt.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.bku() == null || bwVar.bku().share_info == null) ? 0 : bwVar.bku().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.eRY = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.eRZ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.eSa = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.eSb = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.eSc = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eRX, R.color.cp_cont_d);
        ap.setViewTextColor(this.eqt, R.color.cp_cont_d);
    }
}

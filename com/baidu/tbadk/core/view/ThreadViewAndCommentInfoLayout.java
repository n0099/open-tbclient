package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView eID;
    public int fkw;
    private TextView flH;
    private boolean flI;
    private boolean flJ;
    private boolean flK;
    private boolean flL;
    private boolean flM;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.flI = false;
        this.flJ = false;
        this.flK = false;
        this.flL = false;
        this.flM = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flI = false;
        this.flJ = false;
        this.flK = false;
        this.flL = false;
        this.flM = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.flH = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eID = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        N(cbVar);
        O(cbVar);
        P(cbVar);
        Q(cbVar);
        B(cbVar);
    }

    private void N(cb cbVar) {
        if (this.flH != null && cbVar != null && this.flK && cbVar.boj() != null && cbVar.bpm()) {
            this.flH.setVisibility(0);
            this.flH.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), au.numberUniformFormat(cbVar.boj().audience_count)));
        }
    }

    private void O(cb cbVar) {
        if (this.flH != null && cbVar != null && this.flI) {
            if (cbVar.bnI() >= 0) {
                this.flH.setVisibility(0);
                this.flH.setText(String.format(this.mContext.getString(R.string.person_view_num), au.numberUniformFormat(cbVar.bnI())));
                return;
            }
            this.flH.setVisibility(8);
        }
    }

    private void P(cb cbVar) {
        if (this.eID != null && cbVar != null && this.flJ) {
            if (cbVar.bnH() >= 0) {
                this.eID.setVisibility(0);
                this.eID.setText(String.format(this.mContext.getString(R.string.comment_num_tip), au.numberUniformFormat(cbVar.bnH())));
                return;
            }
            this.eID.setVisibility(8);
        }
    }

    private void Q(cb cbVar) {
        if (this.eID != null && cbVar != null && this.flL && cbVar.bpm()) {
            this.eID.setVisibility(0);
            this.eID.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), au.numberUniformFormat(cbVar.bpq())));
        }
    }

    private void B(cb cbVar) {
        if (this.eID != null && cbVar != null && this.flM && cbVar.bpm()) {
            this.eID.setVisibility(0);
            this.eID.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), au.numberUniformFormat((cbVar.boj() == null || cbVar.boj().share_info == null) ? 0 : cbVar.boj().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.flI = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.flJ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.flK = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.flL = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.flM = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.flH, R.color.CAM_X0109);
        ap.setViewTextColor(this.eID, R.color.CAM_X0109);
    }
}

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
    private TextView dTJ;
    public int eua;
    private TextView evn;
    private boolean evo;
    private boolean evp;
    private boolean evq;
    private boolean evr;
    private boolean evs;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.evo = false;
        this.evp = false;
        this.evq = false;
        this.evr = false;
        this.evs = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evo = false;
        this.evp = false;
        this.evq = false;
        this.evr = false;
        this.evs = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.evn = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dTJ = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        J(bwVar);
        K(bwVar);
        L(bwVar);
        M(bwVar);
        y(bwVar);
    }

    private void J(bw bwVar) {
        if (this.evn != null && bwVar != null && this.evq && bwVar.beY() != null && bwVar.bfY()) {
            this.evn.setVisibility(0);
            this.evn.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.beY().audience_count)));
        }
    }

    private void K(bw bwVar) {
        if (this.evn != null && bwVar != null && this.evo) {
            if (bwVar.bew() >= 0) {
                this.evn.setVisibility(0);
                this.evn.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bew())));
                return;
            }
            this.evn.setVisibility(8);
        }
    }

    private void L(bw bwVar) {
        if (this.dTJ != null && bwVar != null && this.evp) {
            if (bwVar.bev() >= 0) {
                this.dTJ.setVisibility(0);
                this.dTJ.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bev())));
                return;
            }
            this.dTJ.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.dTJ != null && bwVar != null && this.evr && bwVar.bfY()) {
            this.dTJ.setVisibility(0);
            this.dTJ.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bgc())));
        }
    }

    private void y(bw bwVar) {
        if (this.dTJ != null && bwVar != null && this.evs && bwVar.bfY()) {
            this.dTJ.setVisibility(0);
            this.dTJ.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.beY() == null || bwVar.beY().share_info == null) ? 0 : bwVar.beY().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.evo = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.evp = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.evq = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.evr = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.evs = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.evn, R.color.cp_cont_d);
        ap.setViewTextColor(this.dTJ, R.color.cp_cont_d);
    }
}

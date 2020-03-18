package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dhH;
    public int dih;
    private boolean djA;
    private boolean djB;
    private TextView djw;
    private boolean djx;
    private boolean djy;
    private boolean djz;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.djx = false;
        this.djy = false;
        this.djz = false;
        this.djA = false;
        this.djB = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djx = false;
        this.djy = false;
        this.djz = false;
        this.djA = false;
        this.djB = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.djw = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dhH = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        L(bjVar);
        M(bjVar);
        N(bjVar);
        O(bjVar);
        w(bjVar);
    }

    private void L(bj bjVar) {
        if (this.djw != null && bjVar != null && this.djz && bjVar.aCK() != null && bjVar.aDH()) {
            this.djw.setVisibility(0);
            this.djw.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aCK().audience_count)));
        }
    }

    private void M(bj bjVar) {
        if (this.djw != null && bjVar != null && this.djx) {
            if (bjVar.aCj() >= 0) {
                this.djw.setVisibility(0);
                this.djw.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aCj())));
                return;
            }
            this.djw.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dhH != null && bjVar != null && this.djy) {
            if (bjVar.aCi() >= 0) {
                this.dhH.setVisibility(0);
                this.dhH.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aCi())));
                return;
            }
            this.dhH.setVisibility(8);
        }
    }

    private void O(bj bjVar) {
        if (this.dhH != null && bjVar != null && this.djA && bjVar.aDH()) {
            this.dhH.setVisibility(0);
            this.dhH.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aDL())));
        }
    }

    private void w(bj bjVar) {
        if (this.dhH != null && bjVar != null && this.djB && bjVar.aDH()) {
            this.dhH.setVisibility(0);
            this.dhH.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aCK() == null || bjVar.aCK().share_info == null) ? 0 : bjVar.aCK().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.djx = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.djy = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.djz = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.djA = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.djB = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.djw, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dhH, (int) R.color.cp_cont_d);
    }
}

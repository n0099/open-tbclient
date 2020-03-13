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
    public int dhT;
    private TextView dhu;
    private TextView djj;
    private boolean djk;
    private boolean djl;
    private boolean djm;
    private boolean djn;
    private boolean djo;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.djk = false;
        this.djl = false;
        this.djm = false;
        this.djn = false;
        this.djo = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djk = false;
        this.djl = false;
        this.djm = false;
        this.djn = false;
        this.djo = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.djj = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dhu = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        K(bjVar);
        L(bjVar);
        M(bjVar);
        N(bjVar);
        v(bjVar);
    }

    private void K(bj bjVar) {
        if (this.djj != null && bjVar != null && this.djm && bjVar.aCH() != null && bjVar.aDD()) {
            this.djj.setVisibility(0);
            this.djj.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aCH().audience_count)));
        }
    }

    private void L(bj bjVar) {
        if (this.djj != null && bjVar != null && this.djk) {
            if (bjVar.aCg() >= 0) {
                this.djj.setVisibility(0);
                this.djj.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aCg())));
                return;
            }
            this.djj.setVisibility(8);
        }
    }

    private void M(bj bjVar) {
        if (this.dhu != null && bjVar != null && this.djl) {
            if (bjVar.aCf() >= 0) {
                this.dhu.setVisibility(0);
                this.dhu.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aCf())));
                return;
            }
            this.dhu.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dhu != null && bjVar != null && this.djn && bjVar.aDD()) {
            this.dhu.setVisibility(0);
            this.dhu.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aDH())));
        }
    }

    private void v(bj bjVar) {
        if (this.dhu != null && bjVar != null && this.djo && bjVar.aDD()) {
            this.dhu.setVisibility(0);
            this.dhu.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aCH() == null || bjVar.aCH().share_info == null) ? 0 : bjVar.aCH().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.djk = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.djl = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.djm = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.djn = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.djo = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.djj, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dhu, (int) R.color.cp_cont_d);
    }
}

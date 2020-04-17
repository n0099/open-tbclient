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
    private TextView dHC;
    public int dIc;
    private TextView dJp;
    private boolean dJq;
    private boolean dJr;
    private boolean dJs;
    private boolean dJt;
    private boolean dJu;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.dJq = false;
        this.dJr = false;
        this.dJs = false;
        this.dJt = false;
        this.dJu = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJq = false;
        this.dJr = false;
        this.dJs = false;
        this.dJt = false;
        this.dJu = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.dJp = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dHC = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.dJp != null && bjVar != null && this.dJs && bjVar.aKX() != null && bjVar.aLV()) {
            this.dJp.setVisibility(0);
            this.dJp.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aKX().audience_count)));
        }
    }

    private void M(bj bjVar) {
        if (this.dJp != null && bjVar != null && this.dJq) {
            if (bjVar.aKw() >= 0) {
                this.dJp.setVisibility(0);
                this.dJp.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aKw())));
                return;
            }
            this.dJp.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dHC != null && bjVar != null && this.dJr) {
            if (bjVar.aKv() >= 0) {
                this.dHC.setVisibility(0);
                this.dHC.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aKv())));
                return;
            }
            this.dHC.setVisibility(8);
        }
    }

    private void O(bj bjVar) {
        if (this.dHC != null && bjVar != null && this.dJt && bjVar.aLV()) {
            this.dHC.setVisibility(0);
            this.dHC.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aLZ())));
        }
    }

    private void w(bj bjVar) {
        if (this.dHC != null && bjVar != null && this.dJu && bjVar.aLV()) {
            this.dHC.setVisibility(0);
            this.dHC.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aKX() == null || bjVar.aKX().share_info == null) ? 0 : bjVar.aKX().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.dJq = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.dJr = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.dJs = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.dJt = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.dJu = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dJp, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dHC, (int) R.color.cp_cont_d);
    }
}

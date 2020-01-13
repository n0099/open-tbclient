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
    public int ddB;
    private TextView ddb;
    private TextView deP;
    private boolean deQ;
    private boolean deR;
    private boolean deS;
    private boolean deT;
    private boolean deU;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.deQ = false;
        this.deR = false;
        this.deS = false;
        this.deT = false;
        this.deU = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deQ = false;
        this.deR = false;
        this.deS = false;
        this.deT = false;
        this.deU = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.deP = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.ddb = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        J(bjVar);
        K(bjVar);
        L(bjVar);
        M(bjVar);
        v(bjVar);
    }

    private void J(bj bjVar) {
        if (this.deP != null && bjVar != null && this.deS && bjVar.aAq() != null && bjVar.aBo()) {
            this.deP.setVisibility(0);
            this.deP.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aAq().audience_count)));
        }
    }

    private void K(bj bjVar) {
        if (this.deP != null && bjVar != null && this.deQ) {
            if (bjVar.azP() >= 0) {
                this.deP.setVisibility(0);
                this.deP.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.azP())));
                return;
            }
            this.deP.setVisibility(8);
        }
    }

    private void L(bj bjVar) {
        if (this.ddb != null && bjVar != null && this.deR) {
            if (bjVar.azO() >= 0) {
                this.ddb.setVisibility(0);
                this.ddb.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.azO())));
                return;
            }
            this.ddb.setVisibility(8);
        }
    }

    private void M(bj bjVar) {
        if (this.ddb != null && bjVar != null && this.deT && bjVar.aBo()) {
            this.ddb.setVisibility(0);
            this.ddb.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aBs())));
        }
    }

    private void v(bj bjVar) {
        if (this.ddb != null && bjVar != null && this.deU && bjVar.aBo()) {
            this.ddb.setVisibility(0);
            this.ddb.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aAq() == null || bjVar.aAq().share_info == null) ? 0 : bjVar.aAq().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.deQ = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.deR = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.deS = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.deT = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.deU = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.deP, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ddb, (int) R.color.cp_cont_d);
    }
}

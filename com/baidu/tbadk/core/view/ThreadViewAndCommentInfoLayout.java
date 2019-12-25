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
    private TextView dcR;
    public int ddq;
    private TextView deD;
    private boolean deE;
    private boolean deF;
    private boolean deG;
    private boolean deH;
    private boolean deI;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.deE = false;
        this.deF = false;
        this.deG = false;
        this.deH = false;
        this.deI = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deE = false;
        this.deF = false;
        this.deG = false;
        this.deH = false;
        this.deI = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.deD = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dcR = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        I(bjVar);
        J(bjVar);
        K(bjVar);
        L(bjVar);
        v(bjVar);
    }

    private void I(bj bjVar) {
        if (this.deD != null && bjVar != null && this.deG && bjVar.azX() != null && bjVar.aAV()) {
            this.deD.setVisibility(0);
            this.deD.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.azX().audience_count)));
        }
    }

    private void J(bj bjVar) {
        if (this.deD != null && bjVar != null && this.deE) {
            if (bjVar.azw() >= 0) {
                this.deD.setVisibility(0);
                this.deD.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.azw())));
                return;
            }
            this.deD.setVisibility(8);
        }
    }

    private void K(bj bjVar) {
        if (this.dcR != null && bjVar != null && this.deF) {
            if (bjVar.azv() >= 0) {
                this.dcR.setVisibility(0);
                this.dcR.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.azv())));
                return;
            }
            this.dcR.setVisibility(8);
        }
    }

    private void L(bj bjVar) {
        if (this.dcR != null && bjVar != null && this.deH && bjVar.aAV()) {
            this.dcR.setVisibility(0);
            this.dcR.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aAZ())));
        }
    }

    private void v(bj bjVar) {
        if (this.dcR != null && bjVar != null && this.deI && bjVar.aAV()) {
            this.dcR.setVisibility(0);
            this.dcR.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.azX() == null || bjVar.azX().share_info == null) ? 0 : bjVar.azX().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.deE = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.deF = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.deG = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.deH = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.deI = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.deD, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dcR, (int) R.color.cp_cont_d);
    }
}

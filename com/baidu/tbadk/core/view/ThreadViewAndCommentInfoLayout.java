package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int bSH;
    private TextView bSe;
    private TextView bTM;
    private boolean bTN;
    private boolean bTO;
    private boolean bTP;
    private boolean bTQ;
    private boolean bTR;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.bTN = false;
        this.bTO = false;
        this.bTP = false;
        this.bTQ = false;
        this.bTR = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTN = false;
        this.bTO = false;
        this.bTP = false;
        this.bTQ = false;
        this.bTR = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.bTM = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bSe = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        C(bgVar);
        D(bgVar);
        E(bgVar);
        F(bgVar);
        o(bgVar);
    }

    private void C(bg bgVar) {
        if (this.bTM != null && bgVar != null && this.bTP && bgVar.Zk() != null && bgVar.aaf()) {
            this.bTM.setVisibility(0);
            this.bTM.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), ap.as(bgVar.Zk().audience_count)));
        }
    }

    private void D(bg bgVar) {
        if (this.bTM != null && bgVar != null && this.bTN) {
            if (bgVar.YJ() >= 0) {
                this.bTM.setVisibility(0);
                this.bTM.setText(String.format(this.mContext.getString(d.j.person_view_num), ap.as(bgVar.YJ())));
                return;
            }
            this.bTM.setVisibility(8);
        }
    }

    private void E(bg bgVar) {
        if (this.bSe != null && bgVar != null && this.bTO) {
            if (bgVar.YI() >= 0) {
                this.bSe.setVisibility(0);
                this.bSe.setText(String.format(this.mContext.getString(d.j.comment_num_tip), ap.as(bgVar.YI())));
                return;
            }
            this.bSe.setVisibility(8);
        }
    }

    private void F(bg bgVar) {
        if (this.bSe != null && bgVar != null && this.bTQ && bgVar.aaf()) {
            this.bSe.setVisibility(0);
            this.bSe.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), ap.as(bgVar.aak())));
        }
    }

    private void o(bg bgVar) {
        if (this.bSe != null && bgVar != null && this.bTR && bgVar.aaf()) {
            this.bSe.setVisibility(0);
            this.bSe.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), ap.as((bgVar.Zk() == null || bgVar.Zk().share_info == null) ? 0 : bgVar.Zk().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.bTN = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.bTO = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.bTP = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.bTQ = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.bTR = z;
    }

    public void onChangeSkinType() {
        al.j(this.bTM, d.C0277d.cp_cont_d);
        al.j(this.bSe, d.C0277d.cp_cont_d);
    }
}

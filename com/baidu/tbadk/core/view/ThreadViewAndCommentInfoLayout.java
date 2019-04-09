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
    public int bSK;
    private TextView bSh;
    private TextView bTP;
    private boolean bTQ;
    private boolean bTR;
    private boolean bTS;
    private boolean bTT;
    private boolean bTU;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.bTQ = false;
        this.bTR = false;
        this.bTS = false;
        this.bTT = false;
        this.bTU = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTQ = false;
        this.bTR = false;
        this.bTS = false;
        this.bTT = false;
        this.bTU = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.bTP = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bSh = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.bTP != null && bgVar != null && this.bTS && bgVar.Zh() != null && bgVar.aac()) {
            this.bTP.setVisibility(0);
            this.bTP.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), ap.as(bgVar.Zh().audience_count)));
        }
    }

    private void D(bg bgVar) {
        if (this.bTP != null && bgVar != null && this.bTQ) {
            if (bgVar.YG() >= 0) {
                this.bTP.setVisibility(0);
                this.bTP.setText(String.format(this.mContext.getString(d.j.person_view_num), ap.as(bgVar.YG())));
                return;
            }
            this.bTP.setVisibility(8);
        }
    }

    private void E(bg bgVar) {
        if (this.bSh != null && bgVar != null && this.bTR) {
            if (bgVar.YF() >= 0) {
                this.bSh.setVisibility(0);
                this.bSh.setText(String.format(this.mContext.getString(d.j.comment_num_tip), ap.as(bgVar.YF())));
                return;
            }
            this.bSh.setVisibility(8);
        }
    }

    private void F(bg bgVar) {
        if (this.bSh != null && bgVar != null && this.bTT && bgVar.aac()) {
            this.bSh.setVisibility(0);
            this.bSh.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), ap.as(bgVar.aah())));
        }
    }

    private void o(bg bgVar) {
        if (this.bSh != null && bgVar != null && this.bTU && bgVar.aac()) {
            this.bSh.setVisibility(0);
            this.bSh.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), ap.as((bgVar.Zh() == null || bgVar.Zh().share_info == null) ? 0 : bgVar.Zh().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.bTQ = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.bTR = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.bTS = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.bTT = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.bTU = z;
    }

    public void onChangeSkinType() {
        al.j(this.bTP, d.C0277d.cp_cont_d);
        al.j(this.bSh, d.C0277d.cp_cont_d);
    }
}

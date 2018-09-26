package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView aAb;
    private TextView aBL;
    private boolean aBM;
    private boolean aBN;
    private boolean aBO;
    private boolean aBP;
    private boolean aBQ;
    public int amD;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aBM = false;
        this.aBN = false;
        this.aBO = false;
        this.aBP = false;
        this.aBQ = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBM = false;
        this.aBN = false;
        this.aBO = false;
        this.aBP = false;
        this.aBQ = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aBL = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aAb = (TextView) inflate.findViewById(e.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        u(bbVar);
        v(bbVar);
        w(bbVar);
        x(bbVar);
        h(bbVar);
    }

    private void u(bb bbVar) {
        if (this.aBL != null && bbVar != null && this.aBO && bbVar.wG() != null && bbVar.xt()) {
            this.aBL.setVisibility(0);
            this.aBL.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.E(bbVar.wG().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aBL != null && bbVar != null && this.aBM) {
            if (bbVar.we() >= 0) {
                this.aBL.setVisibility(0);
                this.aBL.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.E(bbVar.we())));
                return;
            }
            this.aBL.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aAb != null && bbVar != null && this.aBN) {
            if (bbVar.wd() >= 0) {
                this.aAb.setVisibility(0);
                this.aAb.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.E(bbVar.wd())));
                return;
            }
            this.aAb.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aAb != null && bbVar != null && this.aBP && bbVar.xt()) {
            this.aAb.setVisibility(0);
            this.aAb.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.E(bbVar.xy())));
        }
    }

    private void h(bb bbVar) {
        if (this.aAb != null && bbVar != null && this.aBQ && bbVar.xt()) {
            this.aAb.setVisibility(0);
            this.aAb.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.E((bbVar.wG() == null || bbVar.wG().share_info == null) ? 0 : bbVar.wG().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aBM = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aBN = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aBO = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aBP = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aBQ = z;
    }

    public void onChangeSkinType() {
        al.h(this.aBL, e.d.cp_cont_d);
        al.h(this.aAb, e.d.cp_cont_d);
    }
}

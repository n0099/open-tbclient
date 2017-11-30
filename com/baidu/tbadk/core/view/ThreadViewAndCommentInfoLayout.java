package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int anM;
    private TextView anq;
    private TextView aoI;
    private boolean aoJ;
    private boolean aoK;
    private boolean aoL;
    private boolean aoM;
    private boolean aoN;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aoJ = false;
        this.aoK = false;
        this.aoL = false;
        this.aoM = false;
        this.aoN = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoJ = false;
        this.aoK = false;
        this.aoL = false;
        this.aoM = false;
        this.aoN = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aoI = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.anq = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        p(bdVar);
        q(bdVar);
        r(bdVar);
        s(bdVar);
        f(bdVar);
    }

    private void p(bd bdVar) {
        if (this.aoI != null && bdVar != null && this.aoL && bdVar.rQ() != null && bdVar.sG()) {
            this.aoI.setVisibility(0);
            this.aoI.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.u(bdVar.rQ().audience_count)));
        }
    }

    private void q(bd bdVar) {
        if (this.aoI != null && bdVar != null && this.aoJ) {
            if (bdVar.rq() >= 0) {
                this.aoI.setVisibility(0);
                this.aoI.setText(String.format(this.mContext.getString(d.j.person_view_num), am.u(bdVar.rq())));
                return;
            }
            this.aoI.setVisibility(8);
        }
    }

    private void r(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoK) {
            if (bdVar.rp() >= 0) {
                this.anq.setVisibility(0);
                this.anq.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bdVar.rp())));
                return;
            }
            this.anq.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoM && bdVar.sG()) {
            this.anq.setVisibility(0);
            this.anq.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.u(bdVar.sL())));
        }
    }

    private void f(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoN && bdVar.sG()) {
            this.anq.setVisibility(0);
            this.anq.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.u((bdVar.rQ() == null || bdVar.rQ().share_info == null) ? 0 : bdVar.rQ().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aoJ = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aoK = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aoL = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aoM = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aoN = z;
    }

    public void onChangeSkinType() {
        aj.i(this.aoI, d.C0082d.cp_cont_d);
        aj.i(this.anq, d.C0082d.cp_cont_d);
    }
}

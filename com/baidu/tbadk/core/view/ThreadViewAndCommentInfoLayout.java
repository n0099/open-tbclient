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
    public int anR;
    private TextView anq;
    private TextView aoO;
    private boolean aoP;
    private boolean aoQ;
    private boolean aoR;
    private boolean aoS;
    private boolean aoT;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aoP = false;
        this.aoQ = false;
        this.aoR = false;
        this.aoS = false;
        this.aoT = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoP = false;
        this.aoQ = false;
        this.aoR = false;
        this.aoS = false;
        this.aoT = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aoO = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.anq = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        r(bdVar);
        s(bdVar);
        t(bdVar);
        u(bdVar);
        f(bdVar);
    }

    private void r(bd bdVar) {
        if (this.aoO != null && bdVar != null && this.aoR && bdVar.rO() != null && bdVar.sE()) {
            this.aoO.setVisibility(0);
            this.aoO.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.u(bdVar.rO().audience_count)));
        }
    }

    private void s(bd bdVar) {
        if (this.aoO != null && bdVar != null && this.aoP) {
            if (bdVar.ro() >= 0) {
                this.aoO.setVisibility(0);
                this.aoO.setText(String.format(this.mContext.getString(d.j.person_view_num), am.u(bdVar.ro())));
                return;
            }
            this.aoO.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoQ) {
            if (bdVar.rn() >= 0) {
                this.anq.setVisibility(0);
                this.anq.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bdVar.rn())));
                return;
            }
            this.anq.setVisibility(8);
        }
    }

    private void u(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoS && bdVar.sE()) {
            this.anq.setVisibility(0);
            this.anq.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.u(bdVar.sJ())));
        }
    }

    private void f(bd bdVar) {
        if (this.anq != null && bdVar != null && this.aoT && bdVar.sE()) {
            this.anq.setVisibility(0);
            this.anq.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.u((bdVar.rO() == null || bdVar.rO().share_info == null) ? 0 : bdVar.rO().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aoP = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aoQ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aoR = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aoS = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aoT = z;
    }

    public void onChangeSkinType() {
        aj.i(this.aoO, d.C0095d.cp_cont_d);
        aj.i(this.anq, d.C0095d.cp_cont_d);
    }
}

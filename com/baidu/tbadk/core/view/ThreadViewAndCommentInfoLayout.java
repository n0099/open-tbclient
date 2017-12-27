package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int bbP;
    private TextView bbo;
    private TextView bcN;
    private boolean bcO;
    private boolean bcP;
    private boolean bcQ;
    private boolean bcR;
    private boolean bcS;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.bcO = false;
        this.bcP = false;
        this.bcQ = false;
        this.bcR = false;
        this.bcS = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcO = false;
        this.bcP = false;
        this.bcQ = false;
        this.bcR = false;
        this.bcS = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.bcN = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bbo = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(be beVar) {
        if (beVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        r(beVar);
        s(beVar);
        t(beVar);
        u(beVar);
        f(beVar);
    }

    private void r(be beVar) {
        if (this.bcN != null && beVar != null && this.bcQ && beVar.zq() != null && beVar.Ag()) {
            this.bcN.setVisibility(0);
            this.bcN.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(beVar.zq().audience_count)));
        }
    }

    private void s(be beVar) {
        if (this.bcN != null && beVar != null && this.bcO) {
            if (beVar.yQ() >= 0) {
                this.bcN.setVisibility(0);
                this.bcN.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(beVar.yQ())));
                return;
            }
            this.bcN.setVisibility(8);
        }
    }

    private void t(be beVar) {
        if (this.bbo != null && beVar != null && this.bcP) {
            if (beVar.yP() >= 0) {
                this.bbo.setVisibility(0);
                this.bbo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(beVar.yP())));
                return;
            }
            this.bbo.setVisibility(8);
        }
    }

    private void u(be beVar) {
        if (this.bbo != null && beVar != null && this.bcR && beVar.Ag()) {
            this.bbo.setVisibility(0);
            this.bbo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(beVar.Al())));
        }
    }

    private void f(be beVar) {
        if (this.bbo != null && beVar != null && this.bcS && beVar.Ag()) {
            this.bbo.setVisibility(0);
            this.bbo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((beVar.zq() == null || beVar.zq().share_info == null) ? 0 : beVar.zq().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.bcO = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.bcP = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.bcQ = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.bcR = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.bcS = z;
    }

    public void onChangeSkinType() {
        aj.r(this.bcN, d.C0108d.cp_cont_d);
        aj.r(this.bbo, d.C0108d.cp_cont_d);
    }
}

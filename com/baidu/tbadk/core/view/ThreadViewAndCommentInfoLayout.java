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
    public int bbP;
    private TextView bbo;
    private TextView bcT;
    private boolean bcU;
    private boolean bcV;
    private boolean bcW;
    private boolean bcX;
    private boolean bcY;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.bcU = false;
        this.bcV = false;
        this.bcW = false;
        this.bcX = false;
        this.bcY = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcU = false;
        this.bcV = false;
        this.bcW = false;
        this.bcX = false;
        this.bcY = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.bcT = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bbo = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.bcT != null && bdVar != null && this.bcW && bdVar.zl() != null && bdVar.zY()) {
            this.bcT.setVisibility(0);
            this.bcT.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(bdVar.zl().audience_count)));
        }
    }

    private void s(bd bdVar) {
        if (this.bcT != null && bdVar != null && this.bcU) {
            if (bdVar.yL() >= 0) {
                this.bcT.setVisibility(0);
                this.bcT.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(bdVar.yL())));
                return;
            }
            this.bcT.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.bbo != null && bdVar != null && this.bcV) {
            if (bdVar.yK() >= 0) {
                this.bbo.setVisibility(0);
                this.bbo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.yK())));
                return;
            }
            this.bbo.setVisibility(8);
        }
    }

    private void u(bd bdVar) {
        if (this.bbo != null && bdVar != null && this.bcX && bdVar.zY()) {
            this.bbo.setVisibility(0);
            this.bbo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(bdVar.Ad())));
        }
    }

    private void f(bd bdVar) {
        if (this.bbo != null && bdVar != null && this.bcY && bdVar.zY()) {
            this.bbo.setVisibility(0);
            this.bbo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((bdVar.zl() == null || bdVar.zl().share_info == null) ? 0 : bdVar.zl().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.bcU = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.bcV = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.bcW = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.bcX = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.bcY = z;
    }

    public void onChangeSkinType() {
        aj.r(this.bcT, d.C0107d.cp_cont_d);
        aj.r(this.bbo, d.C0107d.cp_cont_d);
    }
}

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
    public int bbX;
    private TextView bbw;
    private TextView bdb;
    private boolean bdc;
    private boolean bdd;
    private boolean bde;
    private boolean bdf;
    private boolean bdg;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.bdc = false;
        this.bdd = false;
        this.bde = false;
        this.bdf = false;
        this.bdg = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdc = false;
        this.bdd = false;
        this.bde = false;
        this.bdf = false;
        this.bdg = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.bdb = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bbw = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.bdb != null && bdVar != null && this.bde && bdVar.zm() != null && bdVar.zZ()) {
            this.bdb.setVisibility(0);
            this.bdb.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(bdVar.zm().audience_count)));
        }
    }

    private void s(bd bdVar) {
        if (this.bdb != null && bdVar != null && this.bdc) {
            if (bdVar.yM() >= 0) {
                this.bdb.setVisibility(0);
                this.bdb.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(bdVar.yM())));
                return;
            }
            this.bdb.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.bbw != null && bdVar != null && this.bdd) {
            if (bdVar.yL() >= 0) {
                this.bbw.setVisibility(0);
                this.bbw.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.yL())));
                return;
            }
            this.bbw.setVisibility(8);
        }
    }

    private void u(bd bdVar) {
        if (this.bbw != null && bdVar != null && this.bdf && bdVar.zZ()) {
            this.bbw.setVisibility(0);
            this.bbw.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(bdVar.Ae())));
        }
    }

    private void f(bd bdVar) {
        if (this.bbw != null && bdVar != null && this.bdg && bdVar.zZ()) {
            this.bbw.setVisibility(0);
            this.bbw.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((bdVar.zm() == null || bdVar.zm().share_info == null) ? 0 : bdVar.zm().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.bdc = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.bdd = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.bde = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.bdf = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.bdg = z;
    }

    public void onChangeSkinType() {
        aj.r(this.bdb, d.C0108d.cp_cont_d);
        aj.r(this.bbw, d.C0108d.cp_cont_d);
    }
}

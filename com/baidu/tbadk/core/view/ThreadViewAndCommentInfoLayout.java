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
    public int aQt;
    private TextView bdc;
    private TextView beH;
    private boolean beI;
    private boolean beJ;
    private boolean beK;
    private boolean beL;
    private boolean beM;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.beI = false;
        this.beJ = false;
        this.beK = false;
        this.beL = false;
        this.beM = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beI = false;
        this.beJ = false;
        this.beK = false;
        this.beL = false;
        this.beM = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.beH = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bdc = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        q(bdVar);
        r(bdVar);
        s(bdVar);
        t(bdVar);
        f(bdVar);
    }

    private void q(bd bdVar) {
        if (this.beH != null && bdVar != null && this.beK && bdVar.zG() != null && bdVar.As()) {
            this.beH.setVisibility(0);
            this.beH.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(bdVar.zG().audience_count)));
        }
    }

    private void r(bd bdVar) {
        if (this.beH != null && bdVar != null && this.beI) {
            if (bdVar.zg() >= 0) {
                this.beH.setVisibility(0);
                this.beH.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(bdVar.zg())));
                return;
            }
            this.beH.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.bdc != null && bdVar != null && this.beJ) {
            if (bdVar.zf() >= 0) {
                this.bdc.setVisibility(0);
                this.bdc.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bdc.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.bdc != null && bdVar != null && this.beL && bdVar.As()) {
            this.bdc.setVisibility(0);
            this.bdc.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(bdVar.Ax())));
        }
    }

    private void f(bd bdVar) {
        if (this.bdc != null && bdVar != null && this.beM && bdVar.As()) {
            this.bdc.setVisibility(0);
            this.bdc.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((bdVar.zG() == null || bdVar.zG().share_info == null) ? 0 : bdVar.zG().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.beI = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.beJ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.beK = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.beL = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.beM = z;
    }

    public void onChangeSkinType() {
        aj.r(this.beH, d.C0141d.cp_cont_d);
        aj.r(this.bdc, d.C0141d.cp_cont_d);
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView amW;
    private TextView ane;
    private boolean aos;
    private boolean aot;
    private boolean aou;
    private boolean aov;
    private boolean aow;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aos = false;
        this.aot = false;
        this.aou = false;
        this.aov = false;
        this.aow = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aos = false;
        this.aot = false;
        this.aou = false;
        this.aov = false;
        this.aow = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ane = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.amW = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        q(bhVar);
        i(bhVar);
        r(bhVar);
        s(bhVar);
        h(bhVar);
    }

    private void q(bh bhVar) {
        if (this.ane != null && bhVar != null && this.aou && bhVar.rM() != null && bhVar.sD()) {
            this.ane.setVisibility(0);
            this.ane.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.u(bhVar.rM().audience_count)));
        }
    }

    private void i(bh bhVar) {
        if (this.ane != null && bhVar != null && this.aos) {
            if (bhVar.rm() >= 0) {
                this.ane.setVisibility(0);
                this.ane.setText(String.format(this.mContext.getString(d.j.person_view_num), am.u(bhVar.rm())));
                return;
            }
            this.ane.setVisibility(8);
        }
    }

    private void r(bh bhVar) {
        if (this.amW != null && bhVar != null && this.aot) {
            if (bhVar.rl() >= 0) {
                this.amW.setVisibility(0);
                this.amW.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bhVar.rl())));
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    private void s(bh bhVar) {
        if (this.amW != null && bhVar != null && this.aov && bhVar.sD()) {
            this.amW.setVisibility(0);
            this.amW.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.u(bhVar.sI())));
        }
    }

    private void h(bh bhVar) {
        if (this.amW != null && bhVar != null && this.aow && bhVar.sD()) {
            this.amW.setVisibility(0);
            this.amW.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.u((bhVar.rM() == null || bhVar.rM().UR == null) ? 0 : bhVar.rM().UR.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aos = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aot = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aou = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aov = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aow = z;
    }

    public void onChangeSkinType() {
        aj.i(this.ane, d.C0080d.cp_cont_d);
        aj.i(this.amW, d.C0080d.cp_cont_d);
    }
}

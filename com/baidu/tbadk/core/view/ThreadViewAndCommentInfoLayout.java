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
    private TextView amO;
    private TextView amW;
    private boolean aok;
    private boolean aol;
    private boolean aom;
    private boolean aon;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aok = false;
        this.aol = false;
        this.aom = false;
        this.aon = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aok = false;
        this.aol = false;
        this.aom = false;
        this.aon = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.amW = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.amO = (TextView) inflate.findViewById(d.h.thread_comment_num);
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
    }

    private void q(bh bhVar) {
        if (this.amW != null && bhVar != null && this.aom && bhVar.rN() != null && bhVar.sD()) {
            this.amW.setVisibility(0);
            this.amW.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), am.t(bhVar.rN().audience_count)));
        }
    }

    private void i(bh bhVar) {
        if (this.amW != null && bhVar != null && this.aok) {
            if (bhVar.ro() >= 0) {
                this.amW.setVisibility(0);
                this.amW.setText(String.format(this.mContext.getString(d.l.person_view_num), am.t(bhVar.ro())));
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    private void r(bh bhVar) {
        if (this.amO != null && bhVar != null && this.aol) {
            if (bhVar.rn() >= 0) {
                this.amO.setVisibility(0);
                this.amO.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.t(bhVar.rn())));
                return;
            }
            this.amO.setVisibility(8);
        }
    }

    private void s(bh bhVar) {
        if (this.amO != null && bhVar != null && this.aon && bhVar.sD()) {
            this.amO.setVisibility(0);
            this.amO.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), am.t(bhVar.sI())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aok = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aol = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aom = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aon = z;
    }

    public void onChangeSkinType() {
        aj.i(this.amW, d.e.cp_cont_d);
        aj.i(this.amO, d.e.cp_cont_d);
    }
}

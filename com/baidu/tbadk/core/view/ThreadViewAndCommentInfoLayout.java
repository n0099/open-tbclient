package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int abV;
    private TextView aow;
    private TextView aqa;
    private boolean aqb;
    private boolean aqc;
    private boolean aqd;
    private boolean aqe;
    private boolean aqf;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aqb = false;
        this.aqc = false;
        this.aqd = false;
        this.aqe = false;
        this.aqf = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqb = false;
        this.aqc = false;
        this.aqd = false;
        this.aqe = false;
        this.aqf = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aqa = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.aow = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.aqa != null && bdVar != null && this.aqd && bdVar.si() != null && bdVar.sU()) {
            this.aqa.setVisibility(0);
            this.aqa.setText(String.format(this.mContext.getString(d.k.person_view_item_live_watch_num), an.v(bdVar.si().audience_count)));
        }
    }

    private void q(bd bdVar) {
        if (this.aqa != null && bdVar != null && this.aqb) {
            if (bdVar.rJ() >= 0) {
                this.aqa.setVisibility(0);
                this.aqa.setText(String.format(this.mContext.getString(d.k.person_view_num), an.v(bdVar.rJ())));
                return;
            }
            this.aqa.setVisibility(8);
        }
    }

    private void r(bd bdVar) {
        if (this.aow != null && bdVar != null && this.aqc) {
            if (bdVar.rI() >= 0) {
                this.aow.setVisibility(0);
                this.aow.setText(String.format(this.mContext.getString(d.k.comment_num_tip), an.v(bdVar.rI())));
                return;
            }
            this.aow.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.aow != null && bdVar != null && this.aqe && bdVar.sU()) {
            this.aow.setVisibility(0);
            this.aow.setText(String.format(this.mContext.getString(d.k.person_view_item_live_zan_num), an.v(bdVar.sZ())));
        }
    }

    private void f(bd bdVar) {
        if (this.aow != null && bdVar != null && this.aqf && bdVar.sU()) {
            this.aow.setVisibility(0);
            this.aow.setText(String.format(this.mContext.getString(d.k.person_view_item_live_share_num), an.v((bdVar.si() == null || bdVar.si().share_info == null) ? 0 : bdVar.si().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aqb = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aqc = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aqd = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aqe = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aqf = z;
    }

    public void onChangeSkinType() {
        ak.h(this.aqa, d.C0126d.cp_cont_d);
        ak.h(this.aow, d.C0126d.cp_cont_d);
    }
}

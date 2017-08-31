package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView anG;
    private TextView anK;
    private boolean apb;
    private boolean apc;
    private boolean apd;
    private boolean ape;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.apb = false;
        this.apc = false;
        this.apd = false;
        this.ape = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apb = false;
        this.apc = false;
        this.apd = false;
        this.ape = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.anK = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.anG = (TextView) inflate.findViewById(d.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        u(bjVar);
        l(bjVar);
        v(bjVar);
        w(bjVar);
    }

    private void u(bj bjVar) {
        if (this.anK != null && bjVar != null && this.apd && bjVar.rT() != null && bjVar.sJ()) {
            this.anK.setVisibility(0);
            this.anK.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), am.u(bjVar.rT().audience_count)));
        }
    }

    private void l(bj bjVar) {
        if (this.anK != null && bjVar != null && this.apb) {
            if (bjVar.ru() >= 0) {
                this.anK.setVisibility(0);
                this.anK.setText(String.format(this.mContext.getString(d.l.person_view_num), am.u(bjVar.ru())));
                return;
            }
            this.anK.setVisibility(8);
        }
    }

    private void v(bj bjVar) {
        if (this.anG != null && bjVar != null && this.apc) {
            if (bjVar.rt() >= 0) {
                this.anG.setVisibility(0);
                this.anG.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bjVar.rt())));
                return;
            }
            this.anG.setVisibility(8);
        }
    }

    private void w(bj bjVar) {
        if (this.anG != null && bjVar != null && this.ape && bjVar.sJ()) {
            this.anG.setVisibility(0);
            this.anG.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), am.u(bjVar.sO())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.apb = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.apc = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.apd = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ape = z;
    }

    public void onChangeSkinType() {
        aj.i(this.anK, d.e.cp_cont_d);
        aj.i(this.anG, d.e.cp_cont_d);
    }
}

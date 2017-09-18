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
    private TextView anE;
    private TextView anI;
    private boolean aoZ;
    private boolean apa;
    private boolean apb;
    private boolean apc;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aoZ = false;
        this.apa = false;
        this.apb = false;
        this.apc = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoZ = false;
        this.apa = false;
        this.apb = false;
        this.apc = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.anI = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.anE = (TextView) inflate.findViewById(d.h.thread_comment_num);
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
        if (this.anI != null && bjVar != null && this.apb && bjVar.rT() != null && bjVar.sJ()) {
            this.anI.setVisibility(0);
            this.anI.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), am.u(bjVar.rT().audience_count)));
        }
    }

    private void l(bj bjVar) {
        if (this.anI != null && bjVar != null && this.aoZ) {
            if (bjVar.ru() >= 0) {
                this.anI.setVisibility(0);
                this.anI.setText(String.format(this.mContext.getString(d.l.person_view_num), am.u(bjVar.ru())));
                return;
            }
            this.anI.setVisibility(8);
        }
    }

    private void v(bj bjVar) {
        if (this.anE != null && bjVar != null && this.apa) {
            if (bjVar.rt() >= 0) {
                this.anE.setVisibility(0);
                this.anE.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bjVar.rt())));
                return;
            }
            this.anE.setVisibility(8);
        }
    }

    private void w(bj bjVar) {
        if (this.anE != null && bjVar != null && this.apc && bjVar.sJ()) {
            this.anE.setVisibility(0);
            this.anE.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), am.u(bjVar.sO())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aoZ = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.apa = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.apb = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.apc = z;
    }

    public void onChangeSkinType() {
        aj.i(this.anI, d.e.cp_cont_d);
        aj.i(this.anE, d.e.cp_cont_d);
    }
}

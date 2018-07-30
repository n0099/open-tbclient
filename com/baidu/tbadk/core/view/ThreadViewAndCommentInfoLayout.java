package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int ajY;
    private TextView awT;
    private TextView ayM;
    private boolean ayN;
    private boolean ayO;
    private boolean ayP;
    private boolean ayQ;
    private boolean ayR;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.ayN = false;
        this.ayO = false;
        this.ayP = false;
        this.ayQ = false;
        this.ayR = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayN = false;
        this.ayO = false;
        this.ayP = false;
        this.ayQ = false;
        this.ayR = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ayM = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.awT = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        t(bbVar);
        u(bbVar);
        v(bbVar);
        w(bbVar);
        g(bbVar);
    }

    private void t(bb bbVar) {
        if (this.ayM != null && bbVar != null && this.ayP && bbVar.vD() != null && bbVar.wp()) {
            this.ayM.setVisibility(0);
            this.ayM.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), ap.A(bbVar.vD().audience_count)));
        }
    }

    private void u(bb bbVar) {
        if (this.ayM != null && bbVar != null && this.ayN) {
            if (bbVar.vc() >= 0) {
                this.ayM.setVisibility(0);
                this.ayM.setText(String.format(this.mContext.getString(d.j.person_view_num), ap.A(bbVar.vc())));
                return;
            }
            this.ayM.setVisibility(8);
        }
    }

    private void v(bb bbVar) {
        if (this.awT != null && bbVar != null && this.ayO) {
            if (bbVar.vb() >= 0) {
                this.awT.setVisibility(0);
                this.awT.setText(String.format(this.mContext.getString(d.j.comment_num_tip), ap.A(bbVar.vb())));
                return;
            }
            this.awT.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.awT != null && bbVar != null && this.ayQ && bbVar.wp()) {
            this.awT.setVisibility(0);
            this.awT.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), ap.A(bbVar.wu())));
        }
    }

    private void g(bb bbVar) {
        if (this.awT != null && bbVar != null && this.ayR && bbVar.wp()) {
            this.awT.setVisibility(0);
            this.awT.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), ap.A((bbVar.vD() == null || bbVar.vD().share_info == null) ? 0 : bbVar.vD().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.ayN = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.ayO = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.ayP = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ayQ = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.ayR = z;
    }

    public void onChangeSkinType() {
        am.h(this.ayM, d.C0140d.cp_cont_d);
        am.h(this.awT, d.C0140d.cp_cont_d);
    }
}

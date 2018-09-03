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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int ajY;
    private TextView awQ;
    private TextView ayJ;
    private boolean ayK;
    private boolean ayL;
    private boolean ayM;
    private boolean ayN;
    private boolean ayO;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.ayK = false;
        this.ayL = false;
        this.ayM = false;
        this.ayN = false;
        this.ayO = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayK = false;
        this.ayL = false;
        this.ayM = false;
        this.ayN = false;
        this.ayO = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ayJ = (TextView) inflate.findViewById(f.g.thread_view_num);
        this.awQ = (TextView) inflate.findViewById(f.g.thread_comment_num);
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
        if (this.ayJ != null && bbVar != null && this.ayM && bbVar.vC() != null && bbVar.wo()) {
            this.ayJ.setVisibility(0);
            this.ayJ.setText(String.format(this.mContext.getString(f.j.person_view_item_live_watch_num), ap.A(bbVar.vC().audience_count)));
        }
    }

    private void u(bb bbVar) {
        if (this.ayJ != null && bbVar != null && this.ayK) {
            if (bbVar.vb() >= 0) {
                this.ayJ.setVisibility(0);
                this.ayJ.setText(String.format(this.mContext.getString(f.j.person_view_num), ap.A(bbVar.vb())));
                return;
            }
            this.ayJ.setVisibility(8);
        }
    }

    private void v(bb bbVar) {
        if (this.awQ != null && bbVar != null && this.ayL) {
            if (bbVar.va() >= 0) {
                this.awQ.setVisibility(0);
                this.awQ.setText(String.format(this.mContext.getString(f.j.comment_num_tip), ap.A(bbVar.va())));
                return;
            }
            this.awQ.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.awQ != null && bbVar != null && this.ayN && bbVar.wo()) {
            this.awQ.setVisibility(0);
            this.awQ.setText(String.format(this.mContext.getString(f.j.person_view_item_live_zan_num), ap.A(bbVar.wt())));
        }
    }

    private void g(bb bbVar) {
        if (this.awQ != null && bbVar != null && this.ayO && bbVar.wo()) {
            this.awQ.setVisibility(0);
            this.awQ.setText(String.format(this.mContext.getString(f.j.person_view_item_live_share_num), ap.A((bbVar.vC() == null || bbVar.vC().share_info == null) ? 0 : bbVar.vC().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.ayK = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.ayL = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.ayM = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ayN = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.ayO = z;
    }

    public void onChangeSkinType() {
        am.h(this.ayJ, f.d.cp_cont_d);
        am.h(this.awQ, f.d.cp_cont_d);
    }
}

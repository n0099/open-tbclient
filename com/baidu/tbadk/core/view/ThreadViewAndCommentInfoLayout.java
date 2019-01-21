package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView aJD;
    private TextView aLm;
    private boolean aLn;
    private boolean aLo;
    private boolean aLp;
    private boolean aLq;
    private boolean aLr;
    public int awp;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aLn = false;
        this.aLo = false;
        this.aLp = false;
        this.aLq = false;
        this.aLr = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLn = false;
        this.aLo = false;
        this.aLp = false;
        this.aLq = false;
        this.aLr = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aLm = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aJD = (TextView) inflate.findViewById(e.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        u(bbVar);
        v(bbVar);
        w(bbVar);
        x(bbVar);
        h(bbVar);
    }

    private void u(bb bbVar) {
        if (this.aLm != null && bbVar != null && this.aLp && bbVar.An() != null && bbVar.Ba()) {
            this.aLm.setVisibility(0);
            this.aLm.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.Q(bbVar.An().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aLm != null && bbVar != null && this.aLn) {
            if (bbVar.zL() >= 0) {
                this.aLm.setVisibility(0);
                this.aLm.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.Q(bbVar.zL())));
                return;
            }
            this.aLm.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aJD != null && bbVar != null && this.aLo) {
            if (bbVar.zK() >= 0) {
                this.aJD.setVisibility(0);
                this.aJD.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.Q(bbVar.zK())));
                return;
            }
            this.aJD.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aJD != null && bbVar != null && this.aLq && bbVar.Ba()) {
            this.aJD.setVisibility(0);
            this.aJD.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.Q(bbVar.Bf())));
        }
    }

    private void h(bb bbVar) {
        if (this.aJD != null && bbVar != null && this.aLr && bbVar.Ba()) {
            this.aJD.setVisibility(0);
            this.aJD.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.Q((bbVar.An() == null || bbVar.An().share_info == null) ? 0 : bbVar.An().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aLn = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aLo = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aLp = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aLq = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aLr = z;
    }

    public void onChangeSkinType() {
        al.h(this.aLm, e.d.cp_cont_d);
        al.h(this.aJD, e.d.cp_cont_d);
    }
}

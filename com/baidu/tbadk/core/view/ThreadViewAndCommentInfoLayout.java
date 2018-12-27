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
    private TextView aJa;
    private TextView aKJ;
    private boolean aKK;
    private boolean aKL;
    private boolean aKM;
    private boolean aKN;
    private boolean aKO;
    public int avM;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aKK = false;
        this.aKL = false;
        this.aKM = false;
        this.aKN = false;
        this.aKO = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKK = false;
        this.aKL = false;
        this.aKM = false;
        this.aKN = false;
        this.aKO = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aKJ = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aJa = (TextView) inflate.findViewById(e.g.thread_comment_num);
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
        if (this.aKJ != null && bbVar != null && this.aKM && bbVar.Aa() != null && bbVar.AN()) {
            this.aKJ.setVisibility(0);
            this.aKJ.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.Q(bbVar.Aa().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aKJ != null && bbVar != null && this.aKK) {
            if (bbVar.zy() >= 0) {
                this.aKJ.setVisibility(0);
                this.aKJ.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.Q(bbVar.zy())));
                return;
            }
            this.aKJ.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aJa != null && bbVar != null && this.aKL) {
            if (bbVar.zx() >= 0) {
                this.aJa.setVisibility(0);
                this.aJa.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.Q(bbVar.zx())));
                return;
            }
            this.aJa.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aJa != null && bbVar != null && this.aKN && bbVar.AN()) {
            this.aJa.setVisibility(0);
            this.aJa.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.Q(bbVar.AS())));
        }
    }

    private void h(bb bbVar) {
        if (this.aJa != null && bbVar != null && this.aKO && bbVar.AN()) {
            this.aJa.setVisibility(0);
            this.aJa.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.Q((bbVar.Aa() == null || bbVar.Aa().share_info == null) ? 0 : bbVar.Aa().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aKK = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aKL = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aKM = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aKN = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aKO = z;
    }

    public void onChangeSkinType() {
        al.h(this.aKJ, e.d.cp_cont_d);
        al.h(this.aJa, e.d.cp_cont_d);
    }
}

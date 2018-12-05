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
    private TextView aIZ;
    private TextView aKH;
    private boolean aKI;
    private boolean aKJ;
    private boolean aKK;
    private boolean aKL;
    private boolean aKM;
    public int avL;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aKI = false;
        this.aKJ = false;
        this.aKK = false;
        this.aKL = false;
        this.aKM = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKI = false;
        this.aKJ = false;
        this.aKK = false;
        this.aKL = false;
        this.aKM = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aKH = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aIZ = (TextView) inflate.findViewById(e.g.thread_comment_num);
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
        if (this.aKH != null && bbVar != null && this.aKK && bbVar.Aa() != null && bbVar.AN()) {
            this.aKH.setVisibility(0);
            this.aKH.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.P(bbVar.Aa().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aKH != null && bbVar != null && this.aKI) {
            if (bbVar.zy() >= 0) {
                this.aKH.setVisibility(0);
                this.aKH.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.P(bbVar.zy())));
                return;
            }
            this.aKH.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aIZ != null && bbVar != null && this.aKJ) {
            if (bbVar.zx() >= 0) {
                this.aIZ.setVisibility(0);
                this.aIZ.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.P(bbVar.zx())));
                return;
            }
            this.aIZ.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aIZ != null && bbVar != null && this.aKL && bbVar.AN()) {
            this.aIZ.setVisibility(0);
            this.aIZ.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.P(bbVar.AS())));
        }
    }

    private void h(bb bbVar) {
        if (this.aIZ != null && bbVar != null && this.aKM && bbVar.AN()) {
            this.aIZ.setVisibility(0);
            this.aIZ.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.P((bbVar.Aa() == null || bbVar.Aa().share_info == null) ? 0 : bbVar.Aa().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aKI = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aKJ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aKK = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aKL = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aKM = z;
    }

    public void onChangeSkinType() {
        al.h(this.aKH, e.d.cp_cont_d);
        al.h(this.aIZ, e.d.cp_cont_d);
    }
}

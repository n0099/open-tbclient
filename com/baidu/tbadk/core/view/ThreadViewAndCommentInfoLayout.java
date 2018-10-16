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
    private TextView aEJ;
    private TextView aGr;
    private boolean aGs;
    private boolean aGt;
    private boolean aGu;
    private boolean aGv;
    private boolean aGw;
    public int ary;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aGs = false;
        this.aGt = false;
        this.aGu = false;
        this.aGv = false;
        this.aGw = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGs = false;
        this.aGt = false;
        this.aGu = false;
        this.aGv = false;
        this.aGw = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aGr = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aEJ = (TextView) inflate.findViewById(e.g.thread_comment_num);
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
        if (this.aGr != null && bbVar != null && this.aGu && bbVar.yP() != null && bbVar.zC()) {
            this.aGr.setVisibility(0);
            this.aGr.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.G(bbVar.yP().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aGr != null && bbVar != null && this.aGs) {
            if (bbVar.yn() >= 0) {
                this.aGr.setVisibility(0);
                this.aGr.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.G(bbVar.yn())));
                return;
            }
            this.aGr.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aEJ != null && bbVar != null && this.aGt) {
            if (bbVar.ym() >= 0) {
                this.aEJ.setVisibility(0);
                this.aEJ.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.G(bbVar.ym())));
                return;
            }
            this.aEJ.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aEJ != null && bbVar != null && this.aGv && bbVar.zC()) {
            this.aEJ.setVisibility(0);
            this.aEJ.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.G(bbVar.zH())));
        }
    }

    private void h(bb bbVar) {
        if (this.aEJ != null && bbVar != null && this.aGw && bbVar.zC()) {
            this.aEJ.setVisibility(0);
            this.aEJ.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.G((bbVar.yP() == null || bbVar.yP().share_info == null) ? 0 : bbVar.yP().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aGs = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aGt = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aGu = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aGv = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aGw = z;
    }

    public void onChangeSkinType() {
        al.h(this.aGr, e.d.cp_cont_d);
        al.h(this.aEJ, e.d.cp_cont_d);
    }
}

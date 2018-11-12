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
    private TextView aFz;
    private TextView aHh;
    private boolean aHi;
    private boolean aHj;
    private boolean aHk;
    private boolean aHl;
    private boolean aHm;
    public int asl;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aHi = false;
        this.aHj = false;
        this.aHk = false;
        this.aHl = false;
        this.aHm = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHi = false;
        this.aHj = false;
        this.aHk = false;
        this.aHl = false;
        this.aHm = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aHh = (TextView) inflate.findViewById(e.g.thread_view_num);
        this.aFz = (TextView) inflate.findViewById(e.g.thread_comment_num);
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
        if (this.aHh != null && bbVar != null && this.aHk && bbVar.yW() != null && bbVar.zJ()) {
            this.aHh.setVisibility(0);
            this.aHh.setText(String.format(this.mContext.getString(e.j.person_view_item_live_watch_num), ao.I(bbVar.yW().audience_count)));
        }
    }

    private void v(bb bbVar) {
        if (this.aHh != null && bbVar != null && this.aHi) {
            if (bbVar.yu() >= 0) {
                this.aHh.setVisibility(0);
                this.aHh.setText(String.format(this.mContext.getString(e.j.person_view_num), ao.I(bbVar.yu())));
                return;
            }
            this.aHh.setVisibility(8);
        }
    }

    private void w(bb bbVar) {
        if (this.aFz != null && bbVar != null && this.aHj) {
            if (bbVar.yt() >= 0) {
                this.aFz.setVisibility(0);
                this.aFz.setText(String.format(this.mContext.getString(e.j.comment_num_tip), ao.I(bbVar.yt())));
                return;
            }
            this.aFz.setVisibility(8);
        }
    }

    private void x(bb bbVar) {
        if (this.aFz != null && bbVar != null && this.aHl && bbVar.zJ()) {
            this.aFz.setVisibility(0);
            this.aFz.setText(String.format(this.mContext.getString(e.j.person_view_item_live_zan_num), ao.I(bbVar.zO())));
        }
    }

    private void h(bb bbVar) {
        if (this.aFz != null && bbVar != null && this.aHm && bbVar.zJ()) {
            this.aFz.setVisibility(0);
            this.aFz.setText(String.format(this.mContext.getString(e.j.person_view_item_live_share_num), ao.I((bbVar.yW() == null || bbVar.yW().share_info == null) ? 0 : bbVar.yW().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aHi = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aHj = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aHk = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aHl = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aHm = z;
    }

    public void onChangeSkinType() {
        al.h(this.aHh, e.d.cp_cont_d);
        al.h(this.aFz, e.d.cp_cont_d);
    }
}

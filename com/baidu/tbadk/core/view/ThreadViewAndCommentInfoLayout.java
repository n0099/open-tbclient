package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int aka;
    private TextView awE;
    private TextView ayh;
    private boolean ayi;
    private boolean ayj;
    private boolean ayk;
    private boolean ayl;
    private boolean aym;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.ayi = false;
        this.ayj = false;
        this.ayk = false;
        this.ayl = false;
        this.aym = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayi = false;
        this.ayj = false;
        this.ayk = false;
        this.ayl = false;
        this.aym = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ayh = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.awE = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.ayh != null && bdVar != null && this.ayk && bdVar.vE() != null && bdVar.wq()) {
            this.ayh.setVisibility(0);
            this.ayh.setText(String.format(this.mContext.getString(d.k.person_view_item_live_watch_num), ao.y(bdVar.vE().audience_count)));
        }
    }

    private void q(bd bdVar) {
        if (this.ayh != null && bdVar != null && this.ayi) {
            if (bdVar.vf() >= 0) {
                this.ayh.setVisibility(0);
                this.ayh.setText(String.format(this.mContext.getString(d.k.person_view_num), ao.y(bdVar.vf())));
                return;
            }
            this.ayh.setVisibility(8);
        }
    }

    private void r(bd bdVar) {
        if (this.awE != null && bdVar != null && this.ayj) {
            if (bdVar.ve() >= 0) {
                this.awE.setVisibility(0);
                this.awE.setText(String.format(this.mContext.getString(d.k.comment_num_tip), ao.y(bdVar.ve())));
                return;
            }
            this.awE.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.awE != null && bdVar != null && this.ayl && bdVar.wq()) {
            this.awE.setVisibility(0);
            this.awE.setText(String.format(this.mContext.getString(d.k.person_view_item_live_zan_num), ao.y(bdVar.wv())));
        }
    }

    private void f(bd bdVar) {
        if (this.awE != null && bdVar != null && this.aym && bdVar.wq()) {
            this.awE.setVisibility(0);
            this.awE.setText(String.format(this.mContext.getString(d.k.person_view_item_live_share_num), ao.y((bdVar.vE() == null || bdVar.vE().share_info == null) ? 0 : bdVar.vE().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.ayi = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.ayj = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.ayk = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ayl = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.aym = z;
    }

    public void onChangeSkinType() {
        al.h(this.ayh, d.C0141d.cp_cont_d);
        al.h(this.awE, d.C0141d.cp_cont_d);
    }
}

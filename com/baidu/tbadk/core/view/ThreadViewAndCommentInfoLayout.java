package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView amS;
    private TextView amV;
    private boolean aoc;
    private boolean aod;
    private boolean aoe;
    private boolean aof;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.aoc = false;
        this.aod = false;
        this.aoe = false;
        this.aof = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoc = false;
        this.aod = false;
        this.aoe = false;
        this.aof = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.amV = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.amS = (TextView) inflate.findViewById(d.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        r(blVar);
        i(blVar);
        s(blVar);
        t(blVar);
    }

    private void r(bl blVar) {
        if (this.amV != null && blVar != null && this.aoe && blVar.rN() != null && blVar.sD()) {
            this.amV.setVisibility(0);
            this.amV.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), al.u(blVar.rN().audience_count)));
        }
    }

    private void i(bl blVar) {
        if (this.amV != null && blVar != null && this.aoc) {
            if (blVar.ro() >= 0) {
                this.amV.setVisibility(0);
                this.amV.setText(String.format(this.mContext.getString(d.l.person_view_num), al.u(blVar.ro())));
                return;
            }
            this.amV.setVisibility(8);
        }
    }

    private void s(bl blVar) {
        if (this.amS != null && blVar != null && this.aod) {
            if (blVar.rn() >= 0) {
                this.amS.setVisibility(0);
                this.amS.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rn())));
                return;
            }
            this.amS.setVisibility(8);
        }
    }

    private void t(bl blVar) {
        if (this.amS != null && blVar != null && this.aof && blVar.sD()) {
            this.amS.setVisibility(0);
            this.amS.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), al.u(blVar.sI())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.aoc = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.aod = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aoe = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aof = z;
    }

    public void onChangeSkinType() {
        ai.i(this.amV, d.e.cp_cont_d);
        ai.i(this.amS, d.e.cp_cont_d);
    }
}

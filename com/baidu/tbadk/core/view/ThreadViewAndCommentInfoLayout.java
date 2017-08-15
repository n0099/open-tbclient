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
    private TextView aom;
    private TextView aop;
    private boolean apA;
    private boolean apx;
    private boolean apy;
    private boolean apz;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.apx = false;
        this.apy = false;
        this.apz = false;
        this.apA = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apx = false;
        this.apy = false;
        this.apz = false;
        this.apA = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aop = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.aom = (TextView) inflate.findViewById(d.h.thread_comment_num);
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
        if (this.aop != null && blVar != null && this.apz && blVar.rX() != null && blVar.sN()) {
            this.aop.setVisibility(0);
            this.aop.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), al.u(blVar.rX().audience_count)));
        }
    }

    private void i(bl blVar) {
        if (this.aop != null && blVar != null && this.apx) {
            if (blVar.ry() >= 0) {
                this.aop.setVisibility(0);
                this.aop.setText(String.format(this.mContext.getString(d.l.person_view_num), al.u(blVar.ry())));
                return;
            }
            this.aop.setVisibility(8);
        }
    }

    private void s(bl blVar) {
        if (this.aom != null && blVar != null && this.apy) {
            if (blVar.rx() >= 0) {
                this.aom.setVisibility(0);
                this.aom.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rx())));
                return;
            }
            this.aom.setVisibility(8);
        }
    }

    private void t(bl blVar) {
        if (this.aom != null && blVar != null && this.apA && blVar.sN()) {
            this.aom.setVisibility(0);
            this.aom.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), al.u(blVar.sS())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.apx = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.apy = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.apz = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.apA = z;
    }

    public void onChangeSkinType() {
        ai.i(this.aop, d.e.cp_cont_d);
        ai.i(this.aom, d.e.cp_cont_d);
    }
}

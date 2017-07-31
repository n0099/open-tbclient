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
    private TextView aol;
    private TextView aoo;
    private boolean apw;
    private boolean apx;
    private boolean apy;
    private boolean apz;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.apw = false;
        this.apx = false;
        this.apy = false;
        this.apz = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apw = false;
        this.apx = false;
        this.apy = false;
        this.apz = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aoo = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.aol = (TextView) inflate.findViewById(d.h.thread_comment_num);
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
        if (this.aoo != null && blVar != null && this.apy && blVar.rX() != null && blVar.sN()) {
            this.aoo.setVisibility(0);
            this.aoo.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), al.u(blVar.rX().audience_count)));
        }
    }

    private void i(bl blVar) {
        if (this.aoo != null && blVar != null && this.apw) {
            if (blVar.ry() >= 0) {
                this.aoo.setVisibility(0);
                this.aoo.setText(String.format(this.mContext.getString(d.l.person_view_num), al.u(blVar.ry())));
                return;
            }
            this.aoo.setVisibility(8);
        }
    }

    private void s(bl blVar) {
        if (this.aol != null && blVar != null && this.apx) {
            if (blVar.rx() >= 0) {
                this.aol.setVisibility(0);
                this.aol.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rx())));
                return;
            }
            this.aol.setVisibility(8);
        }
    }

    private void t(bl blVar) {
        if (this.aol != null && blVar != null && this.apz && blVar.sN()) {
            this.aol.setVisibility(0);
            this.aol.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), al.u(blVar.sS())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.apw = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.apx = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.apy = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.apz = z;
    }

    public void onChangeSkinType() {
        ai.i(this.aoo, d.e.cp_cont_d);
        ai.i(this.aol, d.e.cp_cont_d);
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView amC;
    private TextView amK;
    private boolean anY;
    private boolean anZ;
    private boolean aoa;
    private boolean aob;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.anY = false;
        this.anZ = false;
        this.aoa = false;
        this.aob = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anY = false;
        this.anZ = false;
        this.aoa = false;
        this.aob = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.amK = (TextView) inflate.findViewById(d.h.thread_view_num);
        this.amC = (TextView) inflate.findViewById(d.h.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        q(bhVar);
        i(bhVar);
        r(bhVar);
        s(bhVar);
    }

    private void q(bh bhVar) {
        if (this.amK != null && bhVar != null && this.aoa && bhVar.rG() != null && bhVar.sw()) {
            this.amK.setVisibility(0);
            this.amK.setText(String.format(this.mContext.getString(d.l.person_view_item_live_watch_num), am.u(bhVar.rG().audience_count)));
        }
    }

    private void i(bh bhVar) {
        if (this.amK != null && bhVar != null && this.anY) {
            if (bhVar.rh() >= 0) {
                this.amK.setVisibility(0);
                this.amK.setText(String.format(this.mContext.getString(d.l.person_view_num), am.u(bhVar.rh())));
                return;
            }
            this.amK.setVisibility(8);
        }
    }

    private void r(bh bhVar) {
        if (this.amC != null && bhVar != null && this.anZ) {
            if (bhVar.rg() >= 0) {
                this.amC.setVisibility(0);
                this.amC.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bhVar.rg())));
                return;
            }
            this.amC.setVisibility(8);
        }
    }

    private void s(bh bhVar) {
        if (this.amC != null && bhVar != null && this.aob && bhVar.sw()) {
            this.amC.setVisibility(0);
            this.amC.setText(String.format(this.mContext.getString(d.l.person_view_item_live_zan_num), am.u(bhVar.sB())));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.anY = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.anZ = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.aoa = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aob = z;
    }

    public void onChangeSkinType() {
        aj.i(this.amK, d.e.cp_cont_d);
        aj.i(this.amC, d.e.cp_cont_d);
    }
}

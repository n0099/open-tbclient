package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int aQE;
    private TextView bdo;
    private TextView beT;
    private boolean beU;
    private boolean beV;
    private boolean beW;
    private boolean beX;
    private boolean beY;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.beU = false;
        this.beV = false;
        this.beW = false;
        this.beX = false;
        this.beY = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beU = false;
        this.beV = false;
        this.beW = false;
        this.beX = false;
        this.beY = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.beT = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bdo = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        q(bdVar);
        r(bdVar);
        s(bdVar);
        t(bdVar);
        f(bdVar);
    }

    private void q(bd bdVar) {
        if (this.beT != null && bdVar != null && this.beW && bdVar.zG() != null && bdVar.As()) {
            this.beT.setVisibility(0);
            this.beT.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(bdVar.zG().audience_count)));
        }
    }

    private void r(bd bdVar) {
        if (this.beT != null && bdVar != null && this.beU) {
            if (bdVar.zg() >= 0) {
                this.beT.setVisibility(0);
                this.beT.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(bdVar.zg())));
                return;
            }
            this.beT.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.bdo != null && bdVar != null && this.beV) {
            if (bdVar.zf() >= 0) {
                this.bdo.setVisibility(0);
                this.bdo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bdo.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.bdo != null && bdVar != null && this.beX && bdVar.As()) {
            this.bdo.setVisibility(0);
            this.bdo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(bdVar.Ax())));
        }
    }

    private void f(bd bdVar) {
        if (this.bdo != null && bdVar != null && this.beY && bdVar.As()) {
            this.bdo.setVisibility(0);
            this.bdo.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((bdVar.zG() == null || bdVar.zG().share_info == null) ? 0 : bdVar.zG().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.beU = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.beV = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.beW = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.beX = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.beY = z;
    }

    public void onChangeSkinType() {
        aj.r(this.beT, d.C0140d.cp_cont_d);
        aj.r(this.bdo, d.C0140d.cp_cont_d);
    }
}

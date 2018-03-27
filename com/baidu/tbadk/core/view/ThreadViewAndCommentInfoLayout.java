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
    public int aQv;
    private TextView bde;
    private TextView beK;
    private boolean beL;
    private boolean beM;
    private boolean beN;
    private boolean beO;
    private boolean beP;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.beL = false;
        this.beM = false;
        this.beN = false;
        this.beO = false;
        this.beP = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beL = false;
        this.beM = false;
        this.beN = false;
        this.beO = false;
        this.beP = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.beK = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.bde = (TextView) inflate.findViewById(d.g.thread_comment_num);
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
        if (this.beK != null && bdVar != null && this.beN && bdVar.zG() != null && bdVar.As()) {
            this.beK.setVisibility(0);
            this.beK.setText(String.format(this.mContext.getString(d.j.person_view_item_live_watch_num), am.C(bdVar.zG().audience_count)));
        }
    }

    private void r(bd bdVar) {
        if (this.beK != null && bdVar != null && this.beL) {
            if (bdVar.zg() >= 0) {
                this.beK.setVisibility(0);
                this.beK.setText(String.format(this.mContext.getString(d.j.person_view_num), am.C(bdVar.zg())));
                return;
            }
            this.beK.setVisibility(8);
        }
    }

    private void s(bd bdVar) {
        if (this.bde != null && bdVar != null && this.beM) {
            if (bdVar.zf() >= 0) {
                this.bde.setVisibility(0);
                this.bde.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bde.setVisibility(8);
        }
    }

    private void t(bd bdVar) {
        if (this.bde != null && bdVar != null && this.beO && bdVar.As()) {
            this.bde.setVisibility(0);
            this.bde.setText(String.format(this.mContext.getString(d.j.person_view_item_live_zan_num), am.C(bdVar.Ax())));
        }
    }

    private void f(bd bdVar) {
        if (this.bde != null && bdVar != null && this.beP && bdVar.As()) {
            this.bde.setVisibility(0);
            this.bde.setText(String.format(this.mContext.getString(d.j.person_view_item_live_share_num), am.C((bdVar.zG() == null || bdVar.zG().share_info == null) ? 0 : bdVar.zG().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.beL = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.beM = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.beN = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.beO = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.beP = z;
    }

    public void onChangeSkinType() {
        aj.r(this.beK, d.C0141d.cp_cont_d);
        aj.r(this.bde, d.C0141d.cp_cont_d);
    }
}

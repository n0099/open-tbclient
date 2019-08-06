package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int cbM;
    private TextView cbj;
    private TextView ccU;
    private boolean ccV;
    private boolean ccW;
    private boolean ccX;
    private boolean ccY;
    private boolean ccZ;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.ccV = false;
        this.ccW = false;
        this.ccX = false;
        this.ccY = false;
        this.ccZ = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccV = false;
        this.ccW = false;
        this.ccX = false;
        this.ccY = false;
        this.ccZ = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.ccU = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.cbj = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        D(bhVar);
        E(bhVar);
        F(bhVar);
        G(bhVar);
        p(bhVar);
    }

    private void D(bh bhVar) {
        if (this.ccU != null && bhVar != null && this.ccX && bhVar.aeR() != null && bhVar.afM()) {
            this.ccU.setVisibility(0);
            this.ccU.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.aH(bhVar.aeR().audience_count)));
        }
    }

    private void E(bh bhVar) {
        if (this.ccU != null && bhVar != null && this.ccV) {
            if (bhVar.aeq() >= 0) {
                this.ccU.setVisibility(0);
                this.ccU.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.aH(bhVar.aeq())));
                return;
            }
            this.ccU.setVisibility(8);
        }
    }

    private void F(bh bhVar) {
        if (this.cbj != null && bhVar != null && this.ccW) {
            if (bhVar.aep() >= 0) {
                this.cbj.setVisibility(0);
                this.cbj.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.aH(bhVar.aep())));
                return;
            }
            this.cbj.setVisibility(8);
        }
    }

    private void G(bh bhVar) {
        if (this.cbj != null && bhVar != null && this.ccY && bhVar.afM()) {
            this.cbj.setVisibility(0);
            this.cbj.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.aH(bhVar.afR())));
        }
    }

    private void p(bh bhVar) {
        if (this.cbj != null && bhVar != null && this.ccZ && bhVar.afM()) {
            this.cbj.setVisibility(0);
            this.cbj.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.aH((bhVar.aeR() == null || bhVar.aeR().share_info == null) ? 0 : bhVar.aeR().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.ccV = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.ccW = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.ccX = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.ccY = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.ccZ = z;
    }

    public void onChangeSkinType() {
        am.j(this.ccU, R.color.cp_cont_d);
        am.j(this.cbj, R.color.cp_cont_d);
    }
}

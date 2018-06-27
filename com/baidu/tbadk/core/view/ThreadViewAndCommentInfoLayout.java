package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int akz;
    private TextView axn;
    private TextView aza;
    private boolean azb;
    private boolean azc;
    private boolean azd;
    private boolean aze;
    private boolean azf;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.azb = false;
        this.azc = false;
        this.azd = false;
        this.aze = false;
        this.azf = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azb = false;
        this.azc = false;
        this.azd = false;
        this.aze = false;
        this.azf = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.aza = (TextView) inflate.findViewById(d.g.thread_view_num);
        this.axn = (TextView) inflate.findViewById(d.g.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bc bcVar) {
        if (bcVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        r(bcVar);
        s(bcVar);
        t(bcVar);
        u(bcVar);
        g(bcVar);
    }

    private void r(bc bcVar) {
        if (this.aza != null && bcVar != null && this.azd && bcVar.vO() != null && bcVar.wA()) {
            this.aza.setVisibility(0);
            this.aza.setText(String.format(this.mContext.getString(d.k.person_view_item_live_watch_num), ap.z(bcVar.vO().audience_count)));
        }
    }

    private void s(bc bcVar) {
        if (this.aza != null && bcVar != null && this.azb) {
            if (bcVar.vo() >= 0) {
                this.aza.setVisibility(0);
                this.aza.setText(String.format(this.mContext.getString(d.k.person_view_num), ap.z(bcVar.vo())));
                return;
            }
            this.aza.setVisibility(8);
        }
    }

    private void t(bc bcVar) {
        if (this.axn != null && bcVar != null && this.azc) {
            if (bcVar.vn() >= 0) {
                this.axn.setVisibility(0);
                this.axn.setText(String.format(this.mContext.getString(d.k.comment_num_tip), ap.z(bcVar.vn())));
                return;
            }
            this.axn.setVisibility(8);
        }
    }

    private void u(bc bcVar) {
        if (this.axn != null && bcVar != null && this.aze && bcVar.wA()) {
            this.axn.setVisibility(0);
            this.axn.setText(String.format(this.mContext.getString(d.k.person_view_item_live_zan_num), ap.z(bcVar.wF())));
        }
    }

    private void g(bc bcVar) {
        if (this.axn != null && bcVar != null && this.azf && bcVar.wA()) {
            this.axn.setVisibility(0);
            this.axn.setText(String.format(this.mContext.getString(d.k.person_view_item_live_share_num), ap.z((bcVar.vO() == null || bcVar.vO().share_info == null) ? 0 : bcVar.vO().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.azb = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.azc = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.azd = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.aze = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.azf = z;
    }

    public void onChangeSkinType() {
        am.h(this.aza, d.C0142d.cp_cont_d);
        am.h(this.axn, d.C0142d.cp_cont_d);
    }
}

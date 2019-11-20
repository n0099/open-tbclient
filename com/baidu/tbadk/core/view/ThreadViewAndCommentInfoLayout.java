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
    private TextView cpz;
    public int cqc;
    private TextView crk;
    private boolean crl;
    private boolean crm;
    private boolean crn;
    private boolean cro;
    private boolean crp;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.crl = false;
        this.crm = false;
        this.crn = false;
        this.cro = false;
        this.crp = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crl = false;
        this.crm = false;
        this.crn = false;
        this.cro = false;
        this.crp = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.crk = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.cpz = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        E(bhVar);
        F(bhVar);
        G(bhVar);
        H(bhVar);
        q(bhVar);
    }

    private void E(bh bhVar) {
        if (this.crk != null && bhVar != null && this.crn && bhVar.aiX() != null && bhVar.ajR()) {
            this.crk.setVisibility(0);
            this.crk.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bhVar.aiX().audience_count)));
        }
    }

    private void F(bh bhVar) {
        if (this.crk != null && bhVar != null && this.crl) {
            if (bhVar.aiw() >= 0) {
                this.crk.setVisibility(0);
                this.crk.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bhVar.aiw())));
                return;
            }
            this.crk.setVisibility(8);
        }
    }

    private void G(bh bhVar) {
        if (this.cpz != null && bhVar != null && this.crm) {
            if (bhVar.aiv() >= 0) {
                this.cpz.setVisibility(0);
                this.cpz.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bhVar.aiv())));
                return;
            }
            this.cpz.setVisibility(8);
        }
    }

    private void H(bh bhVar) {
        if (this.cpz != null && bhVar != null && this.cro && bhVar.ajR()) {
            this.cpz.setVisibility(0);
            this.cpz.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bhVar.ajW())));
        }
    }

    private void q(bh bhVar) {
        if (this.cpz != null && bhVar != null && this.crp && bhVar.ajR()) {
            this.cpz.setVisibility(0);
            this.cpz.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bhVar.aiX() == null || bhVar.aiX().share_info == null) ? 0 : bhVar.aiX().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.crl = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.crm = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.crn = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.cro = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.crp = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.crk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.cpz, (int) R.color.cp_cont_d);
    }
}

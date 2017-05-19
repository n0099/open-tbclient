package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bk ahV;
    private TextView alE;
    private TextView alK;
    public ClickableHeaderImageView amf;
    public TextView amg;
    private boolean amj;
    private View.OnClickListener amk;
    private View.OnClickListener aml;
    private UserIconBox amq;
    private UserIconBox amr;
    private View.OnClickListener ams;
    private View.OnClickListener amt;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.ams = new as(this);
        this.aml = new at(this);
        this.amt = new au(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.ams = new as(this);
        this.aml = new at(this);
        this.amt = new au(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.ams = new as(this);
        this.aml = new at(this);
        this.amt = new au(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_user_info_layout, (ViewGroup) this, true);
        this.amf = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amq = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_tshow_icon);
        this.amg = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.amr = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_user_icon);
        this.alE = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        setGravity(16);
        this.mContext = context;
        wC();
        this.amq.setOnClickListener(this.ams);
        this.amg.setOnClickListener(this.aml);
        this.amr.setOnClickListener(this.amt);
    }

    public boolean a(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahV = bkVar;
        j(bkVar);
        i(bkVar);
        k(bkVar);
        c(bkVar);
        setVisibility(0);
        return true;
    }

    private void wC() {
        if (this.amf != null) {
            this.amf.setDefaultResource(17170445);
            this.amf.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.amf.setDefaultBgResource(w.e.cp_bg_line_e);
            this.amf.setIsRound(true);
            this.amf.setAfterClickListener(this.amk);
        }
    }

    private void j(bk bkVar) {
        if (this.amq != null && bkVar != null && bkVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bkVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0) {
                this.amq.setVisibility(0);
                this.amq.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.amq.setVisibility(8);
        }
    }

    private void i(bk bkVar) {
        if (this.amg != null && bkVar != null) {
            if (!StringUtils.isNull(this.ahV.getAuthor().getName_show())) {
                this.amg.setText(com.baidu.tbadk.core.util.au.d(this.ahV.getAuthor().getName_show(), 14, "..."));
            }
            wE();
        }
    }

    private void k(bk bkVar) {
        if (this.amr != null && bkVar != null && bkVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bkVar.getAuthor().getIconInfo();
            if (com.baidu.tbadk.core.util.x.q(iconInfo) != 0) {
                this.amr.setVisibility(0);
                this.amr.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.amr.setVisibility(8);
        }
    }

    private void c(bk bkVar) {
        String q;
        if (this.alE != null && bkVar != null) {
            if (bkVar.rt() <= 0) {
                this.alE.setVisibility(4);
                return;
            }
            this.alE.setVisibility(0);
            if (this.mFrom == 2) {
                q = com.baidu.tbadk.core.util.au.p(bkVar.rt());
            } else {
                q = com.baidu.tbadk.core.util.au.q(bkVar.rt() * 1000);
            }
            this.alE.setText(q);
        }
    }

    private void wE() {
        if (this.ahV != null && this.ahV.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.r(this.ahV.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i(this.amg, w.e.cp_cont_r);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.amg, w.e.cp_cont_b);
            }
        }
    }

    public void onChangeSkinType() {
        wE();
        if (this.ahV != null && this.ahV.sC() != null && this.ahV.sC().channelId > 0) {
            com.baidu.tbadk.core.util.aq.i(this.amg, w.e.cp_cont_b);
        }
        com.baidu.tbadk.core.util.aq.i(this.alE, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.aq.j(this.alK, w.g.btn_frs_more_selector);
    }

    public void setIsSimpleThread(boolean z) {
        this.amj = z;
    }

    public boolean getIsSimpleThread() {
        return this.amj;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amk = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.amf != null) {
            this.amf.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.amf;
    }
}

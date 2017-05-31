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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bl ahM;
    private TextView alA;
    public ClickableHeaderImageView alV;
    public TextView alW;
    private boolean alZ;
    private TextView alu;
    private View.OnClickListener ama;
    private View.OnClickListener amb;
    private UserIconBox amk;
    private UserIconBox aml;
    private TextView amm;
    private View amn;
    private LinearLayout amo;
    private View.OnClickListener amp;
    private View.OnClickListener amq;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.amp = new as(this);
        this.amb = new at(this);
        this.amq = new au(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.amp = new as(this);
        this.amb = new at(this);
        this.amq = new au(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.amp = new as(this);
        this.amb = new at(this);
        this.amq = new au(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_user_info_layout, (ViewGroup) this, true);
        this.alV = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.amk = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_tshow_icon);
        this.amo = (LinearLayout) inflate.findViewById(w.h.card_home_page_normal_thread_user_info);
        this.alW = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.aml = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_user_icon);
        this.alu = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.amm = (TextView) inflate.findViewById(w.h.thread_info_god_intro);
        this.amn = com.baidu.tbadk.ala.b.nz().h(context, 1);
        if (this.amn != null) {
            this.amn.setVisibility(8);
            this.amo.addView(this.amn);
        }
        setGravity(16);
        this.mContext = context;
        wy();
        this.amk.setOnClickListener(this.amp);
        this.alW.setOnClickListener(this.amb);
        this.aml.setOnClickListener(this.amq);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahM = blVar;
        j(blVar);
        i(blVar);
        k(blVar);
        c(blVar);
        l(blVar);
        m(blVar);
        n(blVar);
        setVisibility(0);
        return true;
    }

    private void wy() {
        if (this.alV != null) {
            this.alV.setDefaultResource(17170445);
            this.alV.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.alV.setDefaultBgResource(w.e.cp_bg_line_e);
            this.alV.setIsRound(true);
            this.alV.setAfterClickListener(this.ama);
        }
    }

    private void j(bl blVar) {
        if (this.amk != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0) {
                this.amk.setVisibility(0);
                this.amk.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.amk.setVisibility(8);
        }
    }

    private void i(bl blVar) {
        if (this.alW != null && blVar != null) {
            if (!StringUtils.isNull(this.ahM.getAuthor().getName_show())) {
                this.alW.setText(com.baidu.tbadk.core.util.au.d(this.ahM.getAuthor().getName_show(), 14, "..."));
            }
            wA();
        }
    }

    private void k(bl blVar) {
        if (this.aml != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (com.baidu.tbadk.core.util.x.q(iconInfo) != 0) {
                this.aml.setVisibility(0);
                this.aml.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.aml.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String q;
        if (this.alu != null && blVar != null) {
            if (blVar.rp() <= 0) {
                this.alu.setVisibility(4);
                return;
            }
            this.alu.setVisibility(0);
            if (this.mFrom == 2) {
                q = com.baidu.tbadk.core.util.au.p(blVar.rp());
            } else {
                q = com.baidu.tbadk.core.util.au.q(blVar.rp() * 1000);
            }
            this.alu.setText(q);
        }
    }

    private void l(bl blVar) {
        if (this.amm != null && blVar != null && this.ahM.getAuthor() != null) {
            if (!StringUtils.isNull(this.ahM.getAuthor().getGodIntro())) {
                this.amm.setText(com.baidu.tbadk.core.util.au.d(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.user_god_bar)) + this.ahM.getAuthor().getGodIntro(), 20, "..."));
                this.amm.setVisibility(0);
                return;
            }
            this.amm.setVisibility(8);
        }
    }

    private void m(bl blVar) {
        if (this.alV != null && blVar != null && this.ahM.getAuthor() != null) {
            this.alV.setShowV(this.ahM.getAuthor().isBigV());
        }
    }

    private void n(bl blVar) {
        if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
            if (this.amn != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.PW = alaUserData;
                aVar.type = 1;
                this.amn.setTag(aVar);
                if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                    this.amn.setVisibility(8);
                } else {
                    this.amn.setVisibility(0);
                }
            }
        }
    }

    private void wA() {
        if (this.ahM != null && this.ahM.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.r(this.ahM.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i(this.alW, w.e.cp_cont_r);
            } else {
                com.baidu.tbadk.core.util.aq.i(this.alW, w.e.cp_cont_b);
            }
        }
    }

    public void onChangeSkinType() {
        wA();
        com.baidu.tbadk.core.util.aq.i(this.alu, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.aq.i(this.amm, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.aq.j(this.alA, w.g.btn_frs_more_selector);
        com.baidu.tbadk.core.util.aq.i(this.amn, w.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.alZ = z;
    }

    public boolean getIsSimpleThread() {
        return this.alZ;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
        if (this.alV != null) {
            this.alV.setAfterClickListener(this.ama);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.alV != null) {
            this.alV.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.alV;
    }
}

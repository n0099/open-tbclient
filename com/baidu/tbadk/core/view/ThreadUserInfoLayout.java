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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bm aiu;
    public ClickableHeaderImageView amN;
    public TextView amO;
    private boolean amR;
    private View.OnClickListener amS;
    private View.OnClickListener amT;
    private TextView ami;
    private TextView amp;
    private UserIconBox ani;
    private UserIconBox anj;
    private TextView ank;
    private View anl;
    private LinearLayout anm;
    private View.OnClickListener ann;
    private View.OnClickListener ano;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.ann = new at(this);
        this.amT = new au(this);
        this.ano = new av(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.ann = new at(this);
        this.amT = new au(this);
        this.ano = new av(this);
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.ann = new at(this);
        this.amT = new au(this);
        this.ano = new av(this);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(w.j.thread_user_info_layout, (ViewGroup) this, true);
        this.amN = (ClickableHeaderImageView) inflate.findViewById(w.h.card_home_page_normal_thread_user_header);
        this.ani = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_tshow_icon);
        this.anm = (LinearLayout) inflate.findViewById(w.h.card_home_page_normal_thread_user_info);
        this.amO = (TextView) inflate.findViewById(w.h.card_home_page_normal_thread_user_name);
        this.anj = (UserIconBox) inflate.findViewById(w.h.card_home_page_normal_thread_user_icon);
        this.ami = (TextView) inflate.findViewById(w.h.thread_info_reply_time);
        this.ank = (TextView) inflate.findViewById(w.h.thread_info_god_intro);
        this.anl = com.baidu.tbadk.ala.b.nv().h(context, 1);
        if (this.anl != null) {
            this.anl.setVisibility(8);
            this.anm.addView(this.anl);
        }
        setGravity(16);
        this.mContext = context;
        wQ();
        this.ani.setOnClickListener(this.ann);
        this.amO.setOnClickListener(this.amT);
        this.anj.setOnClickListener(this.ano);
    }

    public boolean a(bm bmVar) {
        if (bmVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiu = bmVar;
        k(bmVar);
        j(bmVar);
        l(bmVar);
        c(bmVar);
        m(bmVar);
        n(bmVar);
        o(bmVar);
        setVisibility(0);
        return true;
    }

    private void wQ() {
        if (this.amN != null) {
            this.amN.setDefaultResource(17170445);
            this.amN.setDefaultErrorResource(w.g.icon_default_avatar100);
            this.amN.setDefaultBgResource(w.e.cp_bg_line_e);
            this.amN.setIsRound(true);
            this.amN.setAfterClickListener(this.amS);
        }
    }

    private void k(bm bmVar) {
        if (this.ani != null && bmVar != null && bmVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bmVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.z.s(tShowInfoNew) != 0) {
                this.ani.setVisibility(0);
                this.ani.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.ani.setVisibility(8);
        }
    }

    private void j(bm bmVar) {
        if (this.amO != null && bmVar != null) {
            if (!StringUtils.isNull(this.aiu.getAuthor().getName_show())) {
                this.amO.setText(com.baidu.tbadk.core.util.aw.d(this.aiu.getAuthor().getName_show(), 14, "..."));
            }
            wS();
            if (this.mFrom == 3) {
                String name_show = this.aiu.getAuthor().getName_show();
                String userName = this.aiu.getAuthor().getUserName();
                if (com.baidu.tbadk.n.ab.fU() && name_show != null && !name_show.equals(userName)) {
                    this.amO.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.amO.getText().toString()));
                    this.amO.setGravity(16);
                    this.amO.setTag(w.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aLW());
                    com.baidu.tbadk.core.util.as.c(this.amO, w.e.cp_other_e, 1);
                }
            }
        }
    }

    private void l(bm bmVar) {
        if (this.anj != null && bmVar != null && bmVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bmVar.getAuthor().getIconInfo();
            if (com.baidu.tbadk.core.util.z.s(iconInfo) != 0) {
                this.anj.setVisibility(0);
                this.anj.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds26), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
                return;
            }
            this.anj.setVisibility(8);
        }
    }

    private void c(bm bmVar) {
        String q;
        if (this.ami != null && bmVar != null) {
            if (bmVar.rl() <= 0) {
                this.ami.setVisibility(4);
                return;
            }
            this.ami.setVisibility(0);
            if (this.mFrom == 2) {
                q = com.baidu.tbadk.core.util.aw.p(bmVar.rl());
            } else {
                q = com.baidu.tbadk.core.util.aw.q(bmVar.rl() * 1000);
            }
            this.ami.setText(q);
        }
    }

    private void m(bm bmVar) {
        if (this.ank != null && bmVar != null && this.aiu.getAuthor() != null) {
            if (!StringUtils.isNull(this.aiu.getAuthor().getGodIntro())) {
                this.ank.setText(com.baidu.tbadk.core.util.aw.d(String.valueOf(TbadkCoreApplication.m9getInst().getString(w.l.user_god_bar)) + this.aiu.getAuthor().getGodIntro(), 20, "..."));
                this.ank.setVisibility(0);
                return;
            }
            this.ank.setVisibility(8);
        }
    }

    private void n(bm bmVar) {
        if (this.amN != null && bmVar != null && this.aiu.getAuthor() != null) {
            this.amN.setShowV(this.aiu.getAuthor().isBigV());
        }
    }

    private void o(bm bmVar) {
        if (bmVar.getAuthor() != null && bmVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bmVar.getAuthor().getAlaUserData();
            if (this.anl != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.PQ = alaUserData;
                aVar.type = 1;
                this.anl.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.anl.setVisibility(8);
                } else {
                    this.anl.setVisibility(0);
                }
            }
        }
    }

    private void wS() {
        if (this.aiu != null && this.aiu.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.z.t(this.aiu.getAuthor().getTShowInfoNew()) || this.aiu.getAuthor().isBigV()) {
                com.baidu.tbadk.core.util.as.i(this.amO, w.e.cp_cont_r);
            } else {
                com.baidu.tbadk.core.util.as.i(this.amO, w.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wS();
        com.baidu.tbadk.core.util.as.i(this.ami, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.as.i(this.ank, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.as.j(this.amp, w.g.btn_frs_more_selector);
        com.baidu.tbadk.core.util.as.i(this.anl, w.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.amR = z;
    }

    public boolean getIsSimpleThread() {
        return this.amR;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amS = onClickListener;
        if (this.amN != null) {
            this.amN.setAfterClickListener(this.amS);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.amN != null) {
            this.amN.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.amN;
    }
}

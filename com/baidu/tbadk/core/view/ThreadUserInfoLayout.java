package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bl akj;
    public ClickableHeaderImageView aoR;
    public TextView aoS;
    private boolean aoV;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    private TextView aof;
    private TextView aop;
    private UserIconBox apm;
    private UserIconBox apn;
    private TextView apo;
    private TextView apq;
    private View apr;
    private LinearLayout aps;
    private View.OnClickListener apt;
    private View.OnClickListener apu;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akj.sJ() == null || ThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.sJ().channelId, ThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoW != null) {
                        ThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akj.sJ() == null || ThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.sJ().channelId, ThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoW != null) {
                        ThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akj.sJ() == null || ThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akj.sJ().channelId, ThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoW != null) {
                        ThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akj != null && ThreadUserInfoLayout.this.akj.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akj.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_user_info_layout, (ViewGroup) this, true);
        this.aoR = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.apm = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.aps = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.aoS = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.apn = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.aof = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.apo = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.apq = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.apr = com.baidu.tbadk.ala.b.nC().h(context, 1);
        if (this.apr != null) {
            this.apr.setVisibility(8);
            this.aps.addView(this.apr);
        }
        setGravity(16);
        this.mContext = context;
        xj();
        this.apm.setOnClickListener(this.apt);
        this.aoS.setOnClickListener(this.aoX);
        this.apn.setOnClickListener(this.apu);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akj = blVar;
        l(blVar);
        k(blVar);
        n(blVar);
        m(blVar);
        c(blVar);
        o(blVar);
        p(blVar);
        q(blVar);
        setVisibility(0);
        return true;
    }

    private void xj() {
        if (this.aoR != null) {
            this.aoR.setDefaultResource(17170445);
            this.aoR.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoR.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoR.setIsRound(true);
            this.aoR.setAfterClickListener(this.aoW);
        }
    }

    private void l(bl blVar) {
        if (this.apm != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apm.setVisibility(0);
                this.apm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apm.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.aoS != null && blVar != null) {
            if (!StringUtils.isNull(this.akj.getAuthor().getName_show())) {
                this.aoS.setText(al.d(this.akj.getAuthor().getName_show(), 14, "..."));
            }
            xl();
            if (this.mFrom == 3) {
                String name_show = this.akj.getAuthor().getName_show();
                String userName = this.akj.getAuthor().getUserName();
                if (ab.ge() && name_show != null && !name_show.equals(userName)) {
                    this.aoS.setText(com.baidu.tieba.pb.c.ao(this.mContext, this.aoS.getText().toString()));
                    this.aoS.setGravity(16);
                    this.aoS.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aOK());
                    ai.c(this.aoS, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bl blVar) {
        if (this.apn != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (u.u(iconInfo) != 0) {
                this.apn.setVisibility(0);
                this.apn.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apn.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String r;
        if (this.aof != null && blVar != null) {
            if (blVar.rz() <= 0) {
                this.aof.setVisibility(4);
                return;
            }
            this.aof.setVisibility(0);
            if (this.mFrom == 2) {
                r = al.p(blVar.rz());
            } else if (blVar.sK()) {
                r = TbadkCoreApplication.getInst().getString(d.l.ala_living_card_time_prefix, new Object[]{al.q(blVar.getCreateTime())});
            } else {
                r = al.r(blVar.rz() * 1000);
            }
            this.aof.setText(r);
        }
    }

    private void n(bl blVar) {
        if (this.apq != null) {
            if (blVar == null || this.akj.rX() == null || this.akj.rX().Vr == null || this.akj.rX().Vr.share_user_count <= 0 || !this.akj.sN()) {
                this.apq.setVisibility(8);
                return;
            }
            this.apq.setVisibility(0);
            int i = this.akj.rX().Vr.share_user_count;
            if (i == 1) {
                this.apq.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.apq.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{al.v(i)}));
            }
        }
    }

    private void o(bl blVar) {
        if (this.apo != null && blVar != null && this.akj.getAuthor() != null) {
            if (!StringUtils.isNull(this.akj.getAuthor().getGodIntro())) {
                this.apo.setText(al.d(TbadkCoreApplication.getInst().getString(d.l.user_god_bar) + this.akj.getAuthor().getGodIntro(), 20, "..."));
                this.apo.setVisibility(0);
                return;
            }
            this.apo.setVisibility(8);
        }
    }

    private void p(bl blVar) {
        if (this.aoR != null && blVar != null && this.akj.getAuthor() != null) {
            this.aoR.setShowV(this.akj.getAuthor().isBigV());
        }
    }

    private void q(bl blVar) {
        if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
            if (this.apr != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.Ro = alaUserData;
                aVar.type = 1;
                this.apr.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.apr.setVisibility(8);
                } else {
                    this.apr.setVisibility(0);
                }
            }
        }
    }

    private void xl() {
        if (this.akj != null && this.akj.getAuthor() != null) {
            if (!u.v(this.akj.getAuthor().getTShowInfoNew()) || this.akj.getAuthor().isBigV()) {
                ai.i(this.aoS, d.e.cp_cont_r);
            } else {
                ai.i(this.aoS, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xl();
        ai.i(this.aof, d.e.cp_cont_f);
        ai.i(this.apo, d.e.cp_cont_f);
        ai.j(this.aop, d.g.btn_frs_more_selector);
        ai.i(this.apr, d.e.cp_link_tip_a);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoV = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoV;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoW = onClickListener;
        if (this.aoR != null) {
            this.aoR.setAfterClickListener(this.aoW);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoR != null) {
            this.aoR.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aoR;
    }

    public TextView getUserName() {
        return this.aoS;
    }
}

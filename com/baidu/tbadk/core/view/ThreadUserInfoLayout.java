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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bj ajE;
    private TextView anJ;
    private TextView any;
    private UserIconBox aoQ;
    private UserIconBox aoR;
    private TextView aoS;
    private TextView aoT;
    private View aoU;
    private LinearLayout aoV;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    public ClickableHeaderImageView aop;
    public TextView aoq;
    private boolean aot;
    private View.OnClickListener aou;
    private View.OnClickListener aow;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajE.sF() == null || ThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.sF().channelId, ThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aou != null) {
                        ThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajE.sF() == null || ThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.sF().channelId, ThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aou != null) {
                        ThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajE.sF() == null || ThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajE.sF().channelId, ThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aou != null) {
                        ThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajE != null && ThreadUserInfoLayout.this.ajE.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_user_info_layout, (ViewGroup) this, true);
        this.aop = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoQ = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.aoV = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.aoq = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.aoR = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.any = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aoS = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.aoT = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.aoU = com.baidu.tbadk.ala.b.nw().h(context, 1);
        if (this.aoU != null) {
            this.aoU.setVisibility(8);
            this.aoV.addView(this.aoU);
        }
        setGravity(16);
        this.mContext = context;
        xl();
        this.aoQ.setOnClickListener(this.aoW);
        this.aoq.setOnClickListener(this.aow);
        this.aoR.setOnClickListener(this.aoX);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajE = bjVar;
        o(bjVar);
        n(bjVar);
        q(bjVar);
        p(bjVar);
        e(bjVar);
        r(bjVar);
        s(bjVar);
        t(bjVar);
        setVisibility(0);
        return true;
    }

    private void xl() {
        if (this.aop != null) {
            this.aop.setDefaultResource(17170445);
            this.aop.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aop.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aop.setIsRound(true);
            this.aop.setAfterClickListener(this.aou);
        }
    }

    private void o(bj bjVar) {
        if (this.aoQ != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoQ.setVisibility(0);
                this.aoQ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoQ.setVisibility(8);
        }
    }

    private void n(bj bjVar) {
        if (this.aoq != null && bjVar != null) {
            if (!StringUtils.isNull(this.ajE.getAuthor().getName_show())) {
                this.aoq.setText(am.e(this.ajE.getAuthor().getName_show(), 14, "..."));
            }
            xn();
            if (this.mFrom == 3) {
                String name_show = this.ajE.getAuthor().getName_show();
                String userName = this.ajE.getAuthor().getUserName();
                if (ac.fT() && name_show != null && !name_show.equals(userName)) {
                    this.aoq.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aoq.getText().toString()));
                    this.aoq.setGravity(16);
                    this.aoq.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOJ());
                    aj.c(this.aoq, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void p(bj bjVar) {
        if (this.aoR != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bjVar.getAuthor().getIconInfo();
            if (v.u(iconInfo) != 0) {
                this.aoR.setVisibility(0);
                this.aoR.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoR.setVisibility(8);
        }
    }

    private void e(bj bjVar) {
        String r;
        if (this.any != null && bjVar != null) {
            if (bjVar.rv() <= 0) {
                this.any.setVisibility(4);
                return;
            }
            this.any.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.p(bjVar.rv());
            } else if (bjVar.sG()) {
                r = TbadkCoreApplication.getInst().getString(d.l.ala_living_card_time_prefix, new Object[]{am.q(bjVar.getCreateTime())});
            } else {
                r = am.r(bjVar.rv() * 1000);
            }
            this.any.setText(r);
        }
    }

    private void q(bj bjVar) {
        if (this.aoT != null) {
            if (bjVar == null || this.ajE.rT() == null || this.ajE.rT().Uv == null || this.ajE.rT().Uv.share_user_count <= 0 || !this.ajE.sJ()) {
                this.aoT.setVisibility(8);
                return;
            }
            this.aoT.setVisibility(0);
            int i = this.ajE.rT().Uv.share_user_count;
            if (i == 1) {
                this.aoT.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.aoT.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void r(bj bjVar) {
        if (this.aoS != null && bjVar != null && this.ajE.getAuthor() != null) {
            if (!StringUtils.isNull(this.ajE.getAuthor().getGodIntro())) {
                this.aoS.setText(am.e(this.ajE.getAuthor().getGodIntro(), 20, "..."));
                this.aoS.setVisibility(0);
                return;
            }
            this.aoS.setVisibility(8);
        }
    }

    private void s(bj bjVar) {
        if (this.aop != null && bjVar != null && this.ajE.getAuthor() != null) {
            this.aop.setShowV(this.ajE.getAuthor().isBigV());
        }
    }

    private void t(bj bjVar) {
        if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
            if (this.aoU != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.Qs = alaUserData;
                aVar.type = 1;
                this.aoU.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.aoU.setVisibility(8);
                } else {
                    this.aoU.setVisibility(0);
                }
            }
        }
    }

    private void xn() {
        if (this.ajE != null && this.ajE.getAuthor() != null) {
            if (!v.v(this.ajE.getAuthor().getTShowInfoNew()) || this.ajE.getAuthor().isBigV()) {
                aj.i(this.aoq, d.e.cp_cont_r);
            } else {
                aj.i(this.aoq, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xn();
        aj.i(this.aoT, d.e.cp_cont_f);
        aj.i(this.any, d.e.cp_cont_f);
        aj.i(this.aoS, d.e.cp_cont_f);
        aj.j(this.anJ, d.g.btn_frs_more_selector);
        aj.i(this.aoU, d.e.cp_link_tip_a);
    }

    public void setIsSimpleThread(boolean z) {
        this.aot = z;
    }

    public boolean getIsSimpleThread() {
        return this.aot;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aou = onClickListener;
        if (this.aop != null) {
            this.aop.setAfterClickListener(this.aou);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aop != null) {
            this.aop.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aop;
    }

    public TextView getUserName() {
        return this.aoq;
    }
}

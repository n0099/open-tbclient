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
    private bj ajF;
    private TextView anA;
    private TextView anL;
    private UserIconBox aoS;
    private UserIconBox aoT;
    private TextView aoU;
    private TextView aoV;
    private View aoW;
    private LinearLayout aoX;
    private View.OnClickListener aoY;
    private View.OnClickListener aoZ;
    public ClickableHeaderImageView aor;
    public TextView aos;
    private boolean aov;
    private View.OnClickListener aow;
    private View.OnClickListener aoy;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajF.sF() == null || ThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.sF().channelId, ThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aow != null) {
                        ThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.aoZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), true, true, true);
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
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajF.sF() == null || ThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.sF().channelId, ThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aow != null) {
                        ThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.aoZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), true, true, true);
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
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajF.sF() == null || ThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajF.sF().channelId, ThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aow != null) {
                        ThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.aoZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajF != null && ThreadUserInfoLayout.this.ajF.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), true, true, true);
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
        this.aor = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoS = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.aoX = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.aos = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.aoT = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.anA = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aoU = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.aoV = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.aoW = com.baidu.tbadk.ala.b.nw().i(context, 1);
        if (this.aoW != null) {
            this.aoW.setVisibility(8);
            this.aoX.addView(this.aoW);
        }
        setGravity(16);
        this.mContext = context;
        xl();
        this.aoS.setOnClickListener(this.aoY);
        this.aos.setOnClickListener(this.aoy);
        this.aoT.setOnClickListener(this.aoZ);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajF = bjVar;
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
        if (this.aor != null) {
            this.aor.setDefaultResource(17170445);
            this.aor.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aor.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aor.setIsRound(true);
            this.aor.setAfterClickListener(this.aow);
        }
    }

    private void o(bj bjVar) {
        if (this.aoS != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoS.setVisibility(0);
                this.aoS.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoS.setVisibility(8);
        }
    }

    private void n(bj bjVar) {
        if (this.aos != null && bjVar != null) {
            if (!StringUtils.isNull(this.ajF.getAuthor().getName_show())) {
                this.aos.setText(am.e(this.ajF.getAuthor().getName_show(), 14, "..."));
            }
            xn();
            if (this.mFrom == 3) {
                String name_show = this.ajF.getAuthor().getName_show();
                String userName = this.ajF.getAuthor().getUserName();
                if (ac.fT() && name_show != null && !name_show.equals(userName)) {
                    this.aos.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aos.getText().toString()));
                    this.aos.setGravity(16);
                    this.aos.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOy());
                    aj.c(this.aos, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void p(bj bjVar) {
        if (this.aoT != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bjVar.getAuthor().getIconInfo();
            if (v.u(iconInfo) != 0) {
                this.aoT.setVisibility(0);
                this.aoT.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoT.setVisibility(8);
        }
    }

    private void e(bj bjVar) {
        String r;
        if (this.anA != null && bjVar != null) {
            if (bjVar.rv() <= 0) {
                this.anA.setVisibility(4);
                return;
            }
            this.anA.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.p(bjVar.rv());
            } else if (bjVar.sG()) {
                r = TbadkCoreApplication.getInst().getString(d.l.ala_living_card_time_prefix, new Object[]{am.q(bjVar.getCreateTime())});
            } else {
                r = am.r(bjVar.rv() * 1000);
            }
            this.anA.setText(r);
        }
    }

    private void q(bj bjVar) {
        if (this.aoV != null) {
            if (bjVar == null || this.ajF.rT() == null || this.ajF.rT().Uv == null || this.ajF.rT().Uv.share_user_count <= 0 || !this.ajF.sJ()) {
                this.aoV.setVisibility(8);
                return;
            }
            this.aoV.setVisibility(0);
            int i = this.ajF.rT().Uv.share_user_count;
            if (i == 1) {
                this.aoV.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.aoV.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void r(bj bjVar) {
        if (this.aoU != null && bjVar != null && this.ajF.getAuthor() != null) {
            if (!StringUtils.isNull(this.ajF.getAuthor().getGodIntro())) {
                this.aoU.setText(am.e(this.ajF.getAuthor().getGodIntro(), 20, "..."));
                this.aoU.setVisibility(0);
                return;
            }
            this.aoU.setVisibility(8);
        }
    }

    private void s(bj bjVar) {
        if (this.aor != null && bjVar != null && this.ajF.getAuthor() != null) {
            this.aor.setShowV(this.ajF.getAuthor().isBigV());
        }
    }

    private void t(bj bjVar) {
        if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
            if (this.aoW != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.Qs = alaUserData;
                aVar.type = 1;
                this.aoW.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.aoW.setVisibility(8);
                } else {
                    this.aoW.setVisibility(0);
                }
            }
        }
    }

    private void xn() {
        if (this.ajF != null && this.ajF.getAuthor() != null) {
            if (!v.v(this.ajF.getAuthor().getTShowInfoNew()) || this.ajF.getAuthor().isBigV()) {
                aj.i(this.aos, d.e.cp_cont_r);
            } else {
                aj.i(this.aos, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xn();
        aj.i(this.aoV, d.e.cp_cont_f);
        aj.i(this.anA, d.e.cp_cont_f);
        aj.i(this.aoU, d.e.cp_cont_f);
        aj.j(this.anL, d.g.btn_frs_more_selector);
        aj.i(this.aoW, d.e.cp_link_tip_a);
    }

    public void setIsSimpleThread(boolean z) {
        this.aov = z;
    }

    public boolean getIsSimpleThread() {
        return this.aov;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aow = onClickListener;
        if (this.aor != null) {
            this.aor.setAfterClickListener(this.aow);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aor != null) {
            this.aor.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aor;
    }

    public TextView getUserName() {
        return this.aos;
    }
}

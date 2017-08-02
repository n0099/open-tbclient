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
    private bl aiQ;
    private TextView amM;
    private TextView amW;
    private boolean anC;
    private View.OnClickListener anD;
    private View.OnClickListener anE;
    private UserIconBox anT;
    private UserIconBox anU;
    private TextView anV;
    private TextView anW;
    private View anX;
    private LinearLayout anY;
    private View.OnClickListener anZ;
    public ClickableHeaderImageView any;
    public TextView anz;
    private View.OnClickListener aoa;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiQ.sz() == null || ThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.sz().channelId, ThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anD != null) {
                        ThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.aoa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), true, true, true);
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
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiQ.sz() == null || ThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.sz().channelId, ThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anD != null) {
                        ThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.aoa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), true, true, true);
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
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiQ.sz() == null || ThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiQ.sz().channelId, ThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anD != null) {
                        ThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.aoa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiQ != null && ThreadUserInfoLayout.this.aiQ.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), true, true, true);
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
        this.any = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anT = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.anY = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.anz = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.anU = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.amM = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anV = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.anW = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.anX = com.baidu.tbadk.ala.b.ns().h(context, 1);
        if (this.anX != null) {
            this.anX.setVisibility(8);
            this.anY.addView(this.anX);
        }
        setGravity(16);
        this.mContext = context;
        xb();
        this.anT.setOnClickListener(this.anZ);
        this.anz.setOnClickListener(this.anE);
        this.anU.setOnClickListener(this.aoa);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiQ = blVar;
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

    private void xb() {
        if (this.any != null) {
            this.any.setDefaultResource(17170445);
            this.any.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.any.setDefaultBgResource(d.e.cp_bg_line_e);
            this.any.setIsRound(true);
            this.any.setAfterClickListener(this.anD);
        }
    }

    private void l(bl blVar) {
        if (this.anT != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.anT.setVisibility(0);
                this.anT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anT.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.anz != null && blVar != null) {
            if (!StringUtils.isNull(this.aiQ.getAuthor().getName_show())) {
                this.anz.setText(al.d(this.aiQ.getAuthor().getName_show(), 14, "..."));
            }
            xd();
            if (this.mFrom == 3) {
                String name_show = this.aiQ.getAuthor().getName_show();
                String userName = this.aiQ.getAuthor().getUserName();
                if (ab.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anz.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.anz.getText().toString()));
                    this.anz.setGravity(16);
                    this.anz.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOz());
                    ai.c(this.anz, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bl blVar) {
        if (this.anU != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (u.u(iconInfo) != 0) {
                this.anU.setVisibility(0);
                this.anU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anU.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String r;
        if (this.amM != null && blVar != null) {
            if (blVar.rp() <= 0) {
                this.amM.setVisibility(4);
                return;
            }
            this.amM.setVisibility(0);
            if (this.mFrom == 2) {
                r = al.p(blVar.rp());
            } else if (blVar.sA()) {
                r = TbadkCoreApplication.getInst().getString(d.l.ala_living_card_time_prefix, new Object[]{al.q(blVar.getCreateTime())});
            } else {
                r = al.r(blVar.rp() * 1000);
            }
            this.amM.setText(r);
        }
    }

    private void n(bl blVar) {
        if (this.anW != null) {
            if (blVar == null || this.aiQ.rN() == null || this.aiQ.rN().TS == null || this.aiQ.rN().TS.share_user_count <= 0 || !this.aiQ.sD()) {
                this.anW.setVisibility(8);
                return;
            }
            this.anW.setVisibility(0);
            int i = this.aiQ.rN().TS.share_user_count;
            if (i == 1) {
                this.anW.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.anW.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{al.v(i)}));
            }
        }
    }

    private void o(bl blVar) {
        if (this.anV != null && blVar != null && this.aiQ.getAuthor() != null) {
            if (!StringUtils.isNull(this.aiQ.getAuthor().getGodIntro())) {
                this.anV.setText(al.d(TbadkCoreApplication.getInst().getString(d.l.user_god_bar) + this.aiQ.getAuthor().getGodIntro(), 20, "..."));
                this.anV.setVisibility(0);
                return;
            }
            this.anV.setVisibility(8);
        }
    }

    private void p(bl blVar) {
        if (this.any != null && blVar != null && this.aiQ.getAuthor() != null) {
            this.any.setShowV(this.aiQ.getAuthor().isBigV());
        }
    }

    private void q(bl blVar) {
        if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
            if (this.anX != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.PQ = alaUserData;
                aVar.type = 1;
                this.anX.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.anX.setVisibility(8);
                } else {
                    this.anX.setVisibility(0);
                }
            }
        }
    }

    private void xd() {
        if (this.aiQ != null && this.aiQ.getAuthor() != null) {
            if (!u.v(this.aiQ.getAuthor().getTShowInfoNew()) || this.aiQ.getAuthor().isBigV()) {
                ai.i(this.anz, d.e.cp_cont_r);
            } else {
                ai.i(this.anz, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xd();
        ai.i(this.amM, d.e.cp_cont_f);
        ai.i(this.anV, d.e.cp_cont_f);
        ai.j(this.amW, d.g.btn_frs_more_selector);
        ai.i(this.anX, d.e.cp_link_tip_a);
    }

    public void setIsSimpleThread(boolean z) {
        this.anC = z;
    }

    public boolean getIsSimpleThread() {
        return this.anC;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anD = onClickListener;
        if (this.any != null) {
            this.any.setAfterClickListener(this.anD);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.any != null) {
            this.any.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.any;
    }

    public TextView getUserName() {
        return this.anz;
    }
}

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
    private bl akl;
    public ClickableHeaderImageView aoS;
    public TextView aoT;
    private boolean aoW;
    private View.OnClickListener aoX;
    private View.OnClickListener aoY;
    private TextView aog;
    private TextView aoq;
    private UserIconBox apn;
    private UserIconBox apo;
    private TextView apq;
    private TextView apr;
    private View aps;
    private LinearLayout apt;
    private View.OnClickListener apu;
    private View.OnClickListener apv;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akl.rL() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akl.sK() == null || ThreadUserInfoLayout.this.akl.sK().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ThreadUserInfoLayout.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.sK().channelId, ThreadUserInfoLayout.this.akl.sK().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoX != null) {
                        ThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.apv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), true, true, true);
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
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akl.rL() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akl.sK() == null || ThreadUserInfoLayout.this.akl.sK().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ThreadUserInfoLayout.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.sK().channelId, ThreadUserInfoLayout.this.akl.sK().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoX != null) {
                        ThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.apv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), true, true, true);
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
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ThreadUserInfoLayout.this.akl.rL() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.akl.sK() == null || ThreadUserInfoLayout.this.akl.sK().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ThreadUserInfoLayout.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.akl.sK().channelId, ThreadUserInfoLayout.this.akl.sK().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.aoX != null) {
                        ThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.apv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.akl != null && ThreadUserInfoLayout.this.akl.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.akl.getAuthor().getUserId(), true, true, true);
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
        this.aoS = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.apn = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.apt = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.aoT = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.apo = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.aog = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.apq = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.apr = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.aps = com.baidu.tbadk.ala.b.nD().h(context, 1);
        if (this.aps != null) {
            this.aps.setVisibility(8);
            this.apt.addView(this.aps);
        }
        setGravity(16);
        this.mContext = context;
        xj();
        this.apn.setOnClickListener(this.apu);
        this.aoT.setOnClickListener(this.aoY);
        this.apo.setOnClickListener(this.apv);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akl = blVar;
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
        if (this.aoS != null) {
            this.aoS.setDefaultResource(17170445);
            this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoS.setIsRound(true);
            this.aoS.setAfterClickListener(this.aoX);
        }
    }

    private void l(bl blVar) {
        if (this.apn != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apn.setVisibility(0);
                this.apn.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apn.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.aoT != null && blVar != null) {
            if (!StringUtils.isNull(this.akl.getAuthor().getName_show())) {
                this.aoT.setText(al.e(this.akl.getAuthor().getName_show(), 14, "..."));
            }
            xl();
            if (this.mFrom == 3) {
                String name_show = this.akl.getAuthor().getName_show();
                String userName = this.akl.getAuthor().getUserName();
                if (ab.ge() && name_show != null && !name_show.equals(userName)) {
                    this.aoT.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aoT.getText().toString()));
                    this.aoT.setGravity(16);
                    this.aoT.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPm());
                    ai.c(this.aoT, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bl blVar) {
        if (this.apo != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (u.u(iconInfo) != 0) {
                this.apo.setVisibility(0);
                this.apo.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apo.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String r;
        if (this.aog != null && blVar != null) {
            if (blVar.rA() <= 0) {
                this.aog.setVisibility(4);
                return;
            }
            this.aog.setVisibility(0);
            if (this.mFrom == 2) {
                r = al.p(blVar.rA());
            } else if (blVar.sL()) {
                r = TbadkCoreApplication.getInst().getString(d.l.ala_living_card_time_prefix, new Object[]{al.q(blVar.getCreateTime())});
            } else {
                r = al.r(blVar.rA() * 1000);
            }
            this.aog.setText(r);
        }
    }

    private void n(bl blVar) {
        if (this.apr != null) {
            if (blVar == null || this.akl.rY() == null || this.akl.rY().Vu == null || this.akl.rY().Vu.share_user_count <= 0 || !this.akl.sO()) {
                this.apr.setVisibility(8);
                return;
            }
            this.apr.setVisibility(0);
            int i = this.akl.rY().Vu.share_user_count;
            if (i == 1) {
                this.apr.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.apr.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{al.v(i)}));
            }
        }
    }

    private void o(bl blVar) {
        if (this.apq != null && blVar != null && this.akl.getAuthor() != null) {
            if (!StringUtils.isNull(this.akl.getAuthor().getGodIntro())) {
                this.apq.setText(al.e(TbadkCoreApplication.getInst().getString(d.l.user_god_bar) + this.akl.getAuthor().getGodIntro(), 20, "..."));
                this.apq.setVisibility(0);
                return;
            }
            this.apq.setVisibility(8);
        }
    }

    private void p(bl blVar) {
        if (this.aoS != null && blVar != null && this.akl.getAuthor() != null) {
            this.aoS.setShowV(this.akl.getAuthor().isBigV());
        }
    }

    private void q(bl blVar) {
        if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
            if (this.aps != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.Rq = alaUserData;
                aVar.type = 1;
                this.aps.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.aps.setVisibility(8);
                } else {
                    this.aps.setVisibility(0);
                }
            }
        }
    }

    private void xl() {
        if (this.akl != null && this.akl.getAuthor() != null) {
            if (!u.v(this.akl.getAuthor().getTShowInfoNew()) || this.akl.getAuthor().isBigV()) {
                ai.i(this.aoT, d.e.cp_cont_r);
            } else {
                ai.i(this.aoT, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xl();
        ai.i(this.aog, d.e.cp_cont_f);
        ai.i(this.apq, d.e.cp_cont_f);
        ai.j(this.aoq, d.g.btn_frs_more_selector);
        ai.i(this.aps, d.e.cp_link_tip_a);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoW = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoW;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoX = onClickListener;
        if (this.aoS != null) {
            this.aoS.setAfterClickListener(this.aoX);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoS != null) {
            this.aoS.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aoS;
    }

    public TextView getUserName() {
        return this.aoT;
    }
}

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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bh ajg;
    private TextView amI;
    private TextView amX;
    public ClickableHeaderImageView anE;
    public TextView anF;
    private boolean anI;
    private View.OnClickListener anJ;
    private View.OnClickListener anL;
    private UserIconBox aoa;
    private UserIconBox aob;
    private TextView aoc;
    private View aod;
    private TextView aoe;
    private View aof;
    private LinearLayout aog;
    private View.OnClickListener aoh;
    private View.OnClickListener aoi;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajg.sz() == null || ThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.sz().channelId, ThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anJ != null) {
                        ThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), true, true, true);
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
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajg.sz() == null || ThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.sz().channelId, ThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anJ != null) {
                        ThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), true, true, true);
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
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajg.sz() == null || ThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajg.sz().channelId, ThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anJ != null) {
                        ThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajg != null && ThreadUserInfoLayout.this.ajg.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), true, true, true);
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
        this.anE = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoa = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.aog = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.anF = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.aob = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.amI = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aoc = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.aod = inflate.findViewById(d.h.divider);
        this.aoe = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.aof = com.baidu.tbadk.ala.b.nz().h(context, 1);
        if (this.aof != null) {
            this.aof.setVisibility(8);
            this.aog.addView(this.aof);
        }
        setGravity(16);
        this.mContext = context;
        wJ();
        this.aoa.setOnClickListener(this.aoh);
        this.anF.setOnClickListener(this.anL);
        this.aob.setOnClickListener(this.aoi);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajg = bhVar;
        l(bhVar);
        k(bhVar);
        n(bhVar);
        m(bhVar);
        d(bhVar);
        o(bhVar);
        p(bhVar);
        setVisibility(0);
        return true;
    }

    private void wJ() {
        if (this.anE != null) {
            this.anE.setDefaultResource(17170445);
            this.anE.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.anE.setDefaultBgResource(d.e.cp_bg_line_e);
            this.anE.setIsRound(true);
            this.anE.setAfterClickListener(this.anJ);
        }
    }

    private void l(bh bhVar) {
        if (this.aoa != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.aoa.setVisibility(0);
                this.aoa.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoa.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.anF != null && bhVar != null) {
            if (!StringUtils.isNull(this.ajg.getAuthor().getName_show())) {
                this.anF.setText(am.e(this.ajg.getAuthor().getName_show(), 14, "..."));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajg.getAuthor().getName_show();
                String userName = this.ajg.getAuthor().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anF.setText(com.baidu.tieba.pb.c.aq(this.mContext, this.anF.getText().toString()));
                    this.anF.setGravity(16);
                    this.anF.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMD());
                    aj.c(this.anF, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bh bhVar) {
        if (this.aob != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bhVar.getAuthor().getIconInfo();
            if (v.t(iconInfo) != 0) {
                this.aob.setVisibility(0);
                this.aob.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aob.setVisibility(8);
        }
    }

    private void d(bh bhVar) {
        String q;
        if (this.amI != null && bhVar != null) {
            if (bhVar.rp() <= 0) {
                this.amI.setVisibility(4);
                return;
            }
            this.amI.setVisibility(0);
            if (this.mFrom == 2) {
                q = am.p(bhVar.rp());
            } else if (bhVar.sA()) {
                q = am.q(bhVar.getCreateTime());
            } else {
                q = am.q(bhVar.rp() * 1000);
            }
            this.amI.setText(q);
        }
    }

    private void n(bh bhVar) {
        if (this.aoe != null) {
            if (bhVar == null || this.ajg.rN() == null || this.ajg.rN().UK == null || this.ajg.rN().UK.share_user_count <= 0 || !this.ajg.sD()) {
                this.aoe.setVisibility(8);
                return;
            }
            this.aoe.setVisibility(0);
            int i = this.ajg.rN().UK.share_user_count;
            if (i == 1) {
                this.aoe.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.aoe.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{am.u(i)}));
            }
        }
    }

    private void o(bh bhVar) {
        if (this.aoc != null && bhVar != null && this.ajg.getAuthor() != null) {
            if (!StringUtils.isNull(this.ajg.getAuthor().getGodIntro())) {
                this.aoc.setText(am.e(this.ajg.getAuthor().getGodIntro(), 20, "..."));
                this.aoc.setVisibility(0);
                this.aod.setVisibility(0);
                return;
            }
            this.aoc.setVisibility(8);
            this.aod.setVisibility(8);
        }
    }

    private void p(bh bhVar) {
        if (this.anE != null && bhVar != null && this.ajg.getAuthor() != null) {
            this.anE.setShowV(this.ajg.getAuthor().isBigV());
        }
    }

    private void wL() {
        if (this.ajg != null && this.ajg.getAuthor() != null) {
            if (!v.u(this.ajg.getAuthor().getTShowInfoNew()) || this.ajg.getAuthor().isBigV()) {
                aj.i(this.anF, d.e.cp_cont_h);
            } else {
                aj.i(this.anF, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.aoe, d.e.cp_cont_f);
        aj.i(this.amI, d.e.cp_cont_d);
        aj.i(this.aoc, d.e.cp_cont_d);
        aj.j(this.amX, d.g.btn_frs_more_selector);
        aj.i(this.aof, d.e.cp_link_tip_a);
        aj.k(this.aod, d.e.cp_cont_e);
    }

    public void setIsSimpleThread(boolean z) {
        this.anI = z;
    }

    public boolean getIsSimpleThread() {
        return this.anI;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anJ = onClickListener;
        if (this.anE != null) {
            this.anE.setAfterClickListener(this.anJ);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anE != null) {
            this.anE.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anE;
    }

    public TextView getUserName() {
        return this.anF;
    }
}

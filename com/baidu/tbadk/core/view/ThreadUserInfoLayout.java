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
    private bh aiU;
    private TextView amL;
    private TextView amw;
    private UserIconBox anO;
    private UserIconBox anP;
    private TextView anQ;
    private View anR;
    private TextView anS;
    private View anT;
    private LinearLayout anU;
    private View.OnClickListener anV;
    private View.OnClickListener anW;
    public ClickableHeaderImageView ans;
    public TextView ant;
    private boolean anw;
    private View.OnClickListener anx;
    private View.OnClickListener anz;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.anV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiU.ss() == null || ThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.ss().channelId, ThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anx != null) {
                        ThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.anW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), true, true, true);
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
        this.anV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiU.ss() == null || ThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.ss().channelId, ThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anx != null) {
                        ThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.anW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), true, true, true);
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
        this.anV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aiU.ss() == null || ThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiU.ss().channelId, ThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anx != null) {
                        ThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.anW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiU != null && ThreadUserInfoLayout.this.aiU.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), true, true, true);
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
        this.ans = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anO = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_tshow_icon);
        this.anU = (LinearLayout) inflate.findViewById(d.h.card_home_page_normal_thread_user_info);
        this.ant = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.anP = (UserIconBox) inflate.findViewById(d.h.card_home_page_normal_thread_user_icon);
        this.amw = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anQ = (TextView) inflate.findViewById(d.h.thread_info_god_intro);
        this.anR = inflate.findViewById(d.h.divider);
        this.anS = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_share_intro);
        this.anT = com.baidu.tbadk.ala.b.nr().g(context, 1);
        if (this.anT != null) {
            this.anT.setVisibility(8);
            this.anU.addView(this.anT);
        }
        setGravity(16);
        this.mContext = context;
        wC();
        this.anO.setOnClickListener(this.anV);
        this.ant.setOnClickListener(this.anz);
        this.anP.setOnClickListener(this.anW);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiU = bhVar;
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

    private void wC() {
        if (this.ans != null) {
            this.ans.setDefaultResource(17170445);
            this.ans.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.ans.setDefaultBgResource(d.e.cp_bg_line_e);
            this.ans.setIsRound(true);
            this.ans.setAfterClickListener(this.anx);
        }
    }

    private void l(bh bhVar) {
        if (this.anO != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.anO.setVisibility(0);
                this.anO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anO.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.ant != null && bhVar != null) {
            if (!StringUtils.isNull(this.aiU.getAuthor().getName_show())) {
                this.ant.setText(am.e(this.aiU.getAuthor().getName_show(), 14, "..."));
            }
            wE();
            if (this.mFrom == 3) {
                String name_show = this.aiU.getAuthor().getName_show();
                String userName = this.aiU.getAuthor().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.ant.setText(com.baidu.tieba.pb.c.al(this.mContext, this.ant.getText().toString()));
                    this.ant.setGravity(16);
                    this.ant.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMy());
                    aj.c(this.ant, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bh bhVar) {
        if (this.anP != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> iconInfo = bhVar.getAuthor().getIconInfo();
            if (v.t(iconInfo) != 0) {
                this.anP.setVisibility(0);
                this.anP.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds26), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anP.setVisibility(8);
        }
    }

    private void d(bh bhVar) {
        String r;
        if (this.amw != null && bhVar != null) {
            if (bhVar.ri() <= 0) {
                this.amw.setVisibility(4);
                return;
            }
            this.amw.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.q(bhVar.ri());
            } else if (bhVar.st()) {
                r = am.r(bhVar.getCreateTime());
            } else {
                r = am.r(bhVar.ri() * 1000);
            }
            this.amw.setText(r);
        }
    }

    private void n(bh bhVar) {
        if (this.anS != null) {
            if (bhVar == null || this.aiU.rG() == null || this.aiU.rG().Ux == null || this.aiU.rG().Ux.share_user_count <= 0 || !this.aiU.sw()) {
                this.anS.setVisibility(8);
                return;
            }
            this.anS.setVisibility(0);
            int i = this.aiU.rG().Ux.share_user_count;
            if (i == 1) {
                this.anS.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label_simple));
            } else {
                this.anS.setText(TbadkCoreApplication.getInst().getString(d.l.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void o(bh bhVar) {
        if (this.anQ != null && bhVar != null && this.aiU.getAuthor() != null) {
            if (!StringUtils.isNull(this.aiU.getAuthor().getGodIntro())) {
                this.anQ.setText(am.e(this.aiU.getAuthor().getGodIntro(), 20, "..."));
                this.anQ.setVisibility(0);
                this.anR.setVisibility(0);
                return;
            }
            this.anQ.setVisibility(8);
            this.anR.setVisibility(8);
        }
    }

    private void p(bh bhVar) {
        if (this.ans != null && bhVar != null && this.aiU.getAuthor() != null) {
            this.ans.setShowV(this.aiU.getAuthor().isBigV());
        }
    }

    private void wE() {
        if (this.aiU != null && this.aiU.getAuthor() != null) {
            if (!v.u(this.aiU.getAuthor().getTShowInfoNew()) || this.aiU.getAuthor().isBigV()) {
                aj.i(this.ant, d.e.cp_cont_h);
            } else {
                aj.i(this.ant, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wE();
        aj.i(this.anS, d.e.cp_cont_f);
        aj.i(this.amw, d.e.cp_cont_d);
        aj.i(this.anQ, d.e.cp_cont_d);
        aj.j(this.amL, d.g.btn_frs_more_selector);
        aj.i(this.anT, d.e.cp_link_tip_a);
        aj.k(this.anR, d.e.cp_cont_e);
    }

    public void setIsSimpleThread(boolean z) {
        this.anw = z;
    }

    public boolean getIsSimpleThread() {
        return this.anw;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
        if (this.ans != null) {
            this.ans.setAfterClickListener(this.anx);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ans != null) {
            this.ans.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ans;
    }

    public TextView getUserName() {
        return this.ant;
    }
}

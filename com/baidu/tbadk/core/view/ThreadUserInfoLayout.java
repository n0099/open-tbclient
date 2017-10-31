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
import com.baidu.tbadk.p.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bh ajq;
    private TextView amR;
    public ClickableHeaderImageView anN;
    public TextView anO;
    private boolean anR;
    private View.OnClickListener anS;
    private View.OnClickListener anU;
    private TextView ang;
    private UserIconBox aoj;
    private UserIconBox aok;
    private TextView aol;
    private View aom;
    private TextView aon;
    private View aoo;
    private LinearLayout aop;
    private View.OnClickListener aoq;
    private View.OnClickListener aor;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getUserId()) && ThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajq.sz() == null || ThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.rt().getUserId(), ThreadUserInfoLayout.this.ajq.rt().getName_show(), ThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.sz().channelId, ThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anS != null) {
                        ThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        this.aor = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajq.rt().getUserId(), true, true, true);
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
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getUserId()) && ThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajq.sz() == null || ThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.rt().getUserId(), ThreadUserInfoLayout.this.ajq.rt().getName_show(), ThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.sz().channelId, ThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anS != null) {
                        ThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        this.aor = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajq.rt().getUserId(), true, true, true);
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
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajq.rt().getUserId()) && ThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajq.sz() == null || ThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.rt().getUserId(), ThreadUserInfoLayout.this.ajq.rt().getName_show(), ThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajq.sz().channelId, ThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ThreadUserInfoLayout.this.anS != null) {
                        ThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        this.aor = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajq != null && ThreadUserInfoLayout.this.ajq.rt() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajq.rt().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.anN = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aoj = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.aop = (LinearLayout) inflate.findViewById(d.g.card_home_page_normal_thread_user_info);
        this.anO = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.aok = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.amR = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aol = (TextView) inflate.findViewById(d.g.thread_info_god_intro);
        this.aom = inflate.findViewById(d.g.divider);
        this.aon = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.aoo = com.baidu.tbadk.ala.b.nu().g(context, 1);
        if (this.aoo != null) {
            this.aoo.setVisibility(8);
            this.aop.addView(this.aoo);
        }
        setGravity(16);
        this.mContext = context;
        wJ();
        this.aoj.setOnClickListener(this.aoq);
        this.anO.setOnClickListener(this.anU);
        this.aok.setOnClickListener(this.aor);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajq = bhVar;
        if (this.ajq.aao > 0) {
            if (this.ajq.aap == 0 && this.ajq.rt() != null) {
                if (!v.v(this.ajq.rt().getTShowInfoNew())) {
                    this.ajq.rt().getTShowInfoNew().clear();
                }
                this.ajq.rt().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.aoj.setOnClickListener(null);
            this.anO.setOnClickListener(null);
            this.aok.setOnClickListener(null);
            this.anN.setClickable(false);
        } else {
            this.aoj.setOnClickListener(this.aoq);
            this.anO.setOnClickListener(this.anU);
            this.aok.setOnClickListener(this.aor);
            this.anN.setClickable(true);
        }
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
        if (this.anN != null) {
            this.anN.setDefaultResource(17170445);
            this.anN.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anN.setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.anN.setIsRound(true);
            this.anN.setAfterClickListener(this.anS);
        }
    }

    private void l(bh bhVar) {
        if (this.aoj != null && bhVar != null && bhVar.rt() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.rt().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoj.setVisibility(0);
                this.aoj.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.aoj.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.anO != null && bhVar != null) {
            if (!StringUtils.isNull(this.ajq.rt().getName_show())) {
                this.anO.setText(es(this.ajq.rt().getName_show()));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajq.rt().getName_show();
                String userName = this.ajq.rt().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anO.setText(com.baidu.tieba.pb.c.al(this.mContext, this.anO.getText().toString()));
                    this.anO.setGravity(16);
                    this.anO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPq());
                    aj.c(this.anO, d.C0080d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bh bhVar) {
        if (this.aok == null || bhVar == null || bhVar.rt() == null || (bhVar.aao > 0 && bhVar.aap == 0)) {
            this.aok.setVisibility(8);
            return;
        }
        ArrayList<IconData> iconInfo = bhVar.rt().getIconInfo();
        if (v.u(iconInfo) != 0) {
            this.aok.setVisibility(0);
            this.aok.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(d.e.ds26), this.mContext.getResources().getDimensionPixelSize(d.e.ds26), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            return;
        }
        this.aok.setVisibility(8);
    }

    private void d(bh bhVar) {
        String r;
        if (this.amR != null && bhVar != null) {
            if (bhVar.rn() <= 0) {
                this.amR.setVisibility(4);
                return;
            }
            this.amR.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.q(bhVar.rn());
            } else if (bhVar.sA()) {
                r = am.r(bhVar.getCreateTime());
            } else {
                r = am.r(bhVar.rn() * 1000);
            }
            this.amR.setText(r);
        }
    }

    private void n(bh bhVar) {
        if (this.aon != null) {
            if (bhVar == null || this.ajq.rM() == null || this.ajq.rM().UR == null || this.ajq.rM().UR.share_user_count <= 0 || !this.ajq.sD() || (this.ajq.aao > 0 && this.ajq.aap == 0)) {
                this.aon.setVisibility(8);
                return;
            }
            this.aon.setVisibility(0);
            int i = this.ajq.rM().UR.share_user_count;
            if (i == 1) {
                this.aon.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.aon.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void o(bh bhVar) {
        if (this.aol == null || bhVar == null || this.ajq.rt() == null || (bhVar.aao > 0 && bhVar.aap == 0)) {
            this.aol.setVisibility(8);
            this.aom.setVisibility(8);
        } else if (!StringUtils.isNull(this.ajq.rt().getGodIntro())) {
            this.aol.setText(am.e(this.ajq.rt().getGodIntro(), 20, "..."));
            this.aol.setVisibility(0);
            this.aom.setVisibility(0);
        } else {
            this.aol.setVisibility(8);
            this.aom.setVisibility(8);
        }
    }

    private void p(bh bhVar) {
        if (this.anN != null && bhVar != null && this.ajq.rt() != null) {
            if (this.ajq.aao > 0 && this.ajq.aap == 0) {
                this.anN.setShowV(false);
            } else {
                this.anN.setShowV(this.ajq.rt().isBigV());
            }
        }
    }

    private void wL() {
        if (this.ajq != null && this.ajq.rt() != null) {
            if (this.ajq.aao > 0 && this.ajq.aap == 0) {
                aj.i(this.anO, d.C0080d.cp_cont_f);
            } else if (!v.v(this.ajq.rt().getTShowInfoNew()) || this.ajq.rt().isBigV()) {
                aj.i(this.anO, d.C0080d.cp_cont_h);
            } else {
                aj.i(this.anO, d.C0080d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.aon, d.C0080d.cp_cont_f);
        aj.i(this.amR, d.C0080d.cp_cont_d);
        aj.i(this.aol, d.C0080d.cp_cont_d);
        aj.j(this.ang, d.f.btn_frs_more_selector);
        aj.i(this.aoo, d.C0080d.cp_link_tip_a);
        aj.k(this.aom, d.C0080d.cp_cont_e);
    }

    public void setIsSimpleThread(boolean z) {
        this.anR = z;
    }

    public boolean getIsSimpleThread() {
        return this.anR;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anS = onClickListener;
        if (this.anN != null) {
            this.anN.setAfterClickListener(this.anS);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anN != null) {
            this.anN.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anN;
    }

    public TextView getUserName() {
        return this.anO;
    }

    protected String es(String str) {
        return am.e(str, 14, "...");
    }
}

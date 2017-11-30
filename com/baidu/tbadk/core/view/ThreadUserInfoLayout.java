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
import com.baidu.tbadk.core.data.bd;
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
    private bd ajM;
    public ClickableHeaderImageView anW;
    public TextView anX;
    private TextView anm;
    private TextView aoA;
    private boolean aoB;
    private View aoC;
    private TextView aoD;
    private boolean aoE;
    private View.OnClickListener aoF;
    private View.OnClickListener aoG;
    private boolean aoa;
    private View.OnClickListener aob;
    private View.OnClickListener aod;
    private UserIconBox aov;
    protected UserIconBox aow;
    private TextView aox;
    private View aoy;
    protected TextView aoz;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aoB = true;
        this.mFrom = 1;
        this.aoF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getUserId()) && ThreadUserInfoLayout.this.ajM.rD() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sC() != null && ThreadUserInfoLayout.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sC().channelId, ThreadUserInfoLayout.this.ajM.sC().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rx().getUserId(), ThreadUserInfoLayout.this.ajM.rx().getName_show(), ThreadUserInfoLayout.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aob != null) {
                        ThreadUserInfoLayout.this.aob.onClick(view);
                    }
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rx().getUserId(), true, true, true);
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
        this.aoB = true;
        this.mFrom = 1;
        this.aoF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getUserId()) && ThreadUserInfoLayout.this.ajM.rD() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sC() != null && ThreadUserInfoLayout.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sC().channelId, ThreadUserInfoLayout.this.ajM.sC().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rx().getUserId(), ThreadUserInfoLayout.this.ajM.rx().getName_show(), ThreadUserInfoLayout.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aob != null) {
                        ThreadUserInfoLayout.this.aob.onClick(view);
                    }
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rx().getUserId(), true, true, true);
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
        this.aoB = true;
        this.mFrom = 1;
        this.aoF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rx().getUserId()) && ThreadUserInfoLayout.this.ajM.rD() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sC() != null && ThreadUserInfoLayout.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sC().channelId, ThreadUserInfoLayout.this.ajM.sC().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rx().getUserId(), ThreadUserInfoLayout.this.ajM.rx().getName_show(), ThreadUserInfoLayout.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aob != null) {
                        ThreadUserInfoLayout.this.aob.onClick(view);
                    }
                }
            }
        };
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rx() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rx().getUserId(), true, true, true);
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
        this.anW = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aov = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.anX = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.aow = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aox = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.aoy = inflate.findViewById(d.g.divider);
        this.aoC = findViewById(d.g.divider_forum_name);
        this.aoD = (TextView) findViewById(d.g.thread_info_forum_name);
        this.aoz = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.aoA = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.aov.setOnClickListener(this.aoF);
        this.anX.setOnClickListener(this.aod);
        this.aow.setOnClickListener(this.aoG);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        if (this.ajM.aaG > 0) {
            if (this.ajM.aaH == 0 && this.ajM.rx() != null) {
                if (!v.w(this.ajM.rx().getTShowInfoNew())) {
                    this.ajM.rx().getTShowInfoNew().clear();
                }
                this.ajM.rx().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.aov.setOnClickListener(null);
            this.anX.setOnClickListener(null);
            this.aow.setOnClickListener(null);
            this.anW.setClickable(false);
        } else {
            this.aov.setOnClickListener(this.aoF);
            this.anX.setOnClickListener(this.aod);
            this.aow.setOnClickListener(this.aoG);
            this.anW.setClickable(true);
        }
        j(bdVar);
        h(bdVar);
        l(bdVar);
        k(bdVar);
        d(bdVar);
        m(bdVar);
        o(bdVar);
        n(bdVar);
        setVisibility(0);
        i(bdVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.anW != null) {
            this.anW.setDefaultResource(17170445);
            this.anW.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anW.setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.anW.setIsRound(true);
            this.anW.setAfterClickListener(this.aob);
        }
    }

    private void i(bd bdVar) {
        if (this.aoA != null && bdVar != null && bdVar.rx() != null) {
            if (bdVar.rx().hadConcerned()) {
                this.aoA.setVisibility(0);
                aj.i(this.aoA, d.C0082d.cp_cont_d);
                aj.j(this.aoA, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aoA.setVisibility(8);
        }
    }

    private void j(bd bdVar) {
        if (this.aov != null && bdVar != null && bdVar.rx() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.rx().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aov.setVisibility(0);
                this.aov.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.aov.setVisibility(8);
        }
    }

    private void h(bd bdVar) {
        if (this.anX != null && bdVar != null) {
            if (!StringUtils.isNull(this.ajM.rx().getName_show())) {
                this.anX.setText(ex(this.ajM.rx().getName_show()));
            }
            wM();
            if (this.mFrom == 3) {
                String name_show = this.ajM.rx().getName_show();
                String userName = this.ajM.rx().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anX.setText(com.baidu.tieba.pb.c.ak(this.mContext, this.anX.getText().toString()));
                    this.anX.setGravity(16);
                    this.anX.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQJ());
                    aj.c(this.anX, d.C0082d.cp_other_e, 1);
                }
            }
        }
    }

    private void k(bd bdVar) {
        if (this.aow != null) {
            if (this.aoE) {
                this.aow.setVisibility(8);
            } else if (bdVar == null || bdVar.rx() == null || ((bdVar.aaG > 0 && bdVar.aaH == 0) || !this.aoB)) {
                this.aow.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.rx().getIconInfo();
                if (v.v(iconInfo) != 0) {
                    this.aow.setVisibility(0);
                    this.aow.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.aow.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String r;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rr() <= 0) {
                this.anm.setVisibility(4);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.q(bdVar.rr());
            } else if (bdVar.sD()) {
                r = am.r(bdVar.getCreateTime());
            } else {
                r = am.r(bdVar.rr() * 1000);
            }
            this.anm.setText(r);
        }
    }

    protected void l(bd bdVar) {
        if (this.aoz == null || bdVar == null) {
            this.aoz.setVisibility(8);
        } else if (this.aoE) {
            if (StringUtils.isNull(bdVar.rW())) {
                this.aoz.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoz.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aoz.setLayoutParams(layoutParams);
            }
            this.aoz.setText(bdVar.rW());
            this.aoz.setVisibility(0);
        } else if (this.ajM.rQ() == null || this.ajM.rQ().share_info == null || this.ajM.rQ().share_info.share_user_count <= 0 || !this.ajM.sG() || (this.ajM.aaG > 0 && this.ajM.aaH == 0)) {
            this.aoz.setVisibility(8);
        } else {
            this.aoz.setVisibility(0);
            int i = this.ajM.rQ().share_info.share_user_count;
            if (i == 1) {
                this.aoz.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.aoz.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void m(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.aox.setVisibility(8);
            this.aoy.setVisibility(8);
            return;
        }
        this.aox.setText(this.ajM.getAddress());
        this.aox.setVisibility(0);
        this.aoy.setVisibility(0);
    }

    private void n(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.rD()) || this.mFrom == 3) {
            this.aoD.setVisibility(8);
            this.aoC.setVisibility(8);
            return;
        }
        if (this.ajM.aaG > 0 && this.ajM.aaH == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.ajM.rD(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.aoD.setText(str);
        this.aoD.setVisibility(0);
        this.aoC.setVisibility(0);
    }

    private void o(bd bdVar) {
        if (this.anW != null && bdVar != null && this.ajM.rx() != null) {
            if (this.ajM.aaG > 0 && this.ajM.aaH == 0) {
                this.anW.setShowV(false);
            } else {
                this.anW.setShowV(this.ajM.rx().isBigV());
            }
        }
    }

    private void wM() {
        if (this.ajM != null && this.ajM.rx() != null) {
            if (this.ajM.aaG > 0 && this.ajM.aaH == 0) {
                aj.i(this.anX, d.C0082d.cp_cont_f);
            } else if (!v.w(this.ajM.rx().getTShowInfoNew()) || this.ajM.rx().isBigV()) {
                aj.i(this.anX, d.C0082d.cp_cont_h);
            } else {
                aj.i(this.anX, d.C0082d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wM();
        aj.i(this.aoz, d.C0082d.cp_cont_f);
        aj.i(this.anm, d.C0082d.cp_cont_d);
        aj.k(this.aoy, d.C0082d.cp_cont_e);
        aj.i(this.aox, d.C0082d.cp_cont_d);
        aj.i(this.aoD, d.C0082d.cp_cont_d);
        aj.k(this.aoy, d.C0082d.cp_cont_e);
        aj.k(this.aoC, d.C0082d.cp_cont_e);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoa = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoa;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aob = onClickListener;
        if (this.anW != null) {
            this.anW.setAfterClickListener(this.aob);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anW != null) {
            this.anW.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anW;
    }

    public TextView getUserName() {
        return this.anX;
    }

    protected String ex(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aoB;
    }

    public void setTShowVisible(boolean z) {
        this.aoB = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoE = z;
    }
}

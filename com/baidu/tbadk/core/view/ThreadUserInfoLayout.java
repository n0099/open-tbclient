package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.data.MetaData;
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
    private bd ajJ;
    public ClickableHeaderImageView anY;
    public TextView anZ;
    private TextView anj;
    private TextView aoA;
    private View aoB;
    protected TextView aoC;
    private TextView aoD;
    private boolean aoE;
    private View aoF;
    private TextView aoG;
    private boolean aoH;
    private View.OnClickListener aoI;
    private View.OnClickListener aoJ;
    private boolean aoc;
    private View.OnClickListener aod;
    private View.OnClickListener aof;
    private UserIconBox aox;
    public ImageView aoy;
    protected UserIconBox aoz;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aoE = true;
        this.mFrom = 1;
        this.aoI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getUserId()) && ThreadUserInfoLayout.this.ajJ.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajJ.sA() != null && ThreadUserInfoLayout.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.sA().channelId, ThreadUserInfoLayout.this.ajJ.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.rv().getUserId(), ThreadUserInfoLayout.this.ajJ.rv().getName_show(), ThreadUserInfoLayout.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aod != null) {
                        ThreadUserInfoLayout.this.aod.onClick(view);
                    }
                }
            }
        };
        this.aoJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajJ.rv().getUserId(), true, true, true);
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
        this.aoE = true;
        this.mFrom = 1;
        this.aoI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getUserId()) && ThreadUserInfoLayout.this.ajJ.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajJ.sA() != null && ThreadUserInfoLayout.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.sA().channelId, ThreadUserInfoLayout.this.ajJ.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.rv().getUserId(), ThreadUserInfoLayout.this.ajJ.rv().getName_show(), ThreadUserInfoLayout.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aod != null) {
                        ThreadUserInfoLayout.this.aod.onClick(view);
                    }
                }
            }
        };
        this.aoJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajJ.rv().getUserId(), true, true, true);
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
        this.aoE = true;
        this.mFrom = 1;
        this.aoI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajJ.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajJ.rv().getUserId()) && ThreadUserInfoLayout.this.ajJ.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajJ.sA() != null && ThreadUserInfoLayout.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.sA().channelId, ThreadUserInfoLayout.this.ajJ.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajJ.rv().getUserId(), ThreadUserInfoLayout.this.ajJ.rv().getName_show(), ThreadUserInfoLayout.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aod != null) {
                        ThreadUserInfoLayout.this.aod.onClick(view);
                    }
                }
            }
        };
        this.aoJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajJ != null && ThreadUserInfoLayout.this.ajJ.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajJ.rv().getUserId(), true, true, true);
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
        this.anY = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aox = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.anZ = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.aoy = (ImageView) inflate.findViewById(d.g.identity_view);
        this.aoz = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.anj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aoA = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.aoB = inflate.findViewById(d.g.divider);
        this.aoF = findViewById(d.g.divider_forum_name);
        this.aoG = (TextView) findViewById(d.g.thread_info_forum_name);
        this.aoC = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.aoD = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.aox.setOnClickListener(this.aoI);
        this.anZ.setOnClickListener(this.aof);
        this.aoz.setOnClickListener(this.aoJ);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajJ = bdVar;
        if (this.ajJ.aaA > 0) {
            if (this.ajJ.aaB == 0 && this.ajJ.rv() != null) {
                if (!v.w(this.ajJ.rv().getTShowInfoNew())) {
                    this.ajJ.rv().getTShowInfoNew().clear();
                }
                this.ajJ.rv().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.aox.setOnClickListener(null);
            this.anZ.setOnClickListener(null);
            this.aoz.setOnClickListener(null);
            this.anY.setClickable(false);
        } else {
            this.aox.setOnClickListener(this.aoI);
            this.anZ.setOnClickListener(this.aof);
            this.aoz.setOnClickListener(this.aoJ);
            this.anY.setClickable(true);
        }
        k(bdVar);
        i(bdVar);
        n(bdVar);
        l(bdVar);
        m(bdVar);
        d(bdVar);
        o(bdVar);
        q(bdVar);
        p(bdVar);
        setVisibility(0);
        j(bdVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.anY != null) {
            this.anY.setDefaultResource(17170445);
            this.anY.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anY.setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.anY.setIsRound(true);
            this.anY.setAfterClickListener(this.aod);
        }
    }

    private void j(bd bdVar) {
        if (this.aoD != null && bdVar != null && bdVar.rv() != null) {
            if (bdVar.rv().hadConcerned()) {
                this.aoD.setVisibility(0);
                aj.i(this.aoD, d.C0096d.cp_cont_d);
                aj.j(this.aoD, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aoD.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.aox != null && bdVar != null && bdVar.rv() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.rv().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aox.setVisibility(0);
                this.aox.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.aox.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.aoy != null && bdVar != null && bdVar.rv() != null) {
            MetaData rv = bdVar.rv();
            if (rv.getIs_bawu() == 1) {
                if ("manager".equals(rv.getBawu_type())) {
                    aj.c(this.aoy, d.f.icon_id_bazhu);
                    this.aoy.setVisibility(0);
                    return;
                } else if ("assist".equals(rv.getBawu_type())) {
                    aj.c(this.aoy, d.f.icon_id_xiaobazhu);
                    this.aoy.setVisibility(0);
                    return;
                } else {
                    this.aoy.setVisibility(8);
                    return;
                }
            }
            this.aoy.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.anZ != null && bdVar != null) {
            if (!StringUtils.isNull(this.ajJ.rv().getName_show())) {
                this.anZ.setText(ex(this.ajJ.rv().getName_show()));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajJ.rv().getName_show();
                String userName = this.ajJ.rv().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anZ.setText(com.baidu.tieba.pb.c.aj(this.mContext, this.anZ.getText().toString()));
                    this.anZ.setGravity(16);
                    this.anZ.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                    aj.c(this.anZ, d.C0096d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.aoz != null) {
            if (this.aoH) {
                this.aoz.setVisibility(8);
            } else if (bdVar == null || bdVar.rv() == null || ((bdVar.aaA > 0 && bdVar.aaB == 0) || !this.aoE)) {
                this.aoz.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.rv().getIconInfo();
                if (v.v(iconInfo) != 0) {
                    this.aoz.setVisibility(0);
                    this.aoz.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.aoz.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String r;
        if (this.anj != null && bdVar != null) {
            if (bdVar.rp() <= 0) {
                this.anj.setVisibility(4);
                return;
            }
            this.anj.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.q(bdVar.rp());
            } else if (bdVar.sB()) {
                r = am.r(bdVar.getCreateTime());
            } else {
                r = am.r(bdVar.rp() * 1000);
            }
            this.anj.setText(r);
        }
    }

    protected void n(bd bdVar) {
        if (this.aoC == null || bdVar == null) {
            this.aoC.setVisibility(8);
        } else if (this.aoH) {
            if (StringUtils.isNull(bdVar.rU())) {
                this.aoC.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoC.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aoC.setLayoutParams(layoutParams);
            }
            this.aoC.setText(bdVar.rU());
            this.aoC.setVisibility(0);
        } else if (this.ajJ.rO() == null || this.ajJ.rO().share_info == null || this.ajJ.rO().share_info.share_user_count <= 0 || !this.ajJ.sE() || (this.ajJ.aaA > 0 && this.ajJ.aaB == 0)) {
            this.aoC.setVisibility(8);
        } else {
            this.aoC.setVisibility(0);
            int i = this.ajJ.rO().share_info.share_user_count;
            if (i == 1) {
                this.aoC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.aoC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.aoA.setVisibility(8);
            this.aoB.setVisibility(8);
            return;
        }
        this.aoA.setText(this.ajJ.getAddress());
        this.aoA.setVisibility(0);
        this.aoB.setVisibility(0);
    }

    private void p(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.rB()) || this.mFrom == 3) {
            this.aoG.setVisibility(8);
            this.aoF.setVisibility(8);
            return;
        }
        if (this.ajJ.aaA > 0 && this.ajJ.aaB == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.ajJ.rB(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.aoG.setText(str);
        this.aoG.setVisibility(0);
        this.aoF.setVisibility(0);
    }

    private void q(bd bdVar) {
        if (this.anY != null && bdVar != null && this.ajJ.rv() != null) {
            if (this.ajJ.aaA > 0 && this.ajJ.aaB == 0) {
                this.anY.setShowV(false);
            } else {
                this.anY.setShowV(this.ajJ.rv().isBigV());
            }
        }
    }

    private void wL() {
        if (this.ajJ != null && this.ajJ.rv() != null) {
            if (this.ajJ.aaA > 0 && this.ajJ.aaB == 0) {
                aj.i(this.anZ, d.C0096d.cp_cont_f);
            } else if (!v.w(this.ajJ.rv().getTShowInfoNew()) || this.ajJ.rv().isBigV()) {
                aj.i(this.anZ, d.C0096d.cp_cont_h);
            } else {
                aj.i(this.anZ, d.C0096d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.aoC, d.C0096d.cp_cont_f);
        aj.i(this.anj, d.C0096d.cp_cont_d);
        aj.k(this.aoB, d.C0096d.cp_cont_e);
        aj.i(this.aoA, d.C0096d.cp_cont_d);
        aj.i(this.aoG, d.C0096d.cp_cont_d);
        aj.k(this.aoB, d.C0096d.cp_cont_e);
        aj.k(this.aoF, d.C0096d.cp_cont_e);
        l(this.ajJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoc = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoc;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aod = onClickListener;
        if (this.anY != null) {
            this.anY.setAfterClickListener(this.aod);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anY != null) {
            this.anY.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anY;
    }

    public TextView getUserName() {
        return this.anZ;
    }

    protected String ex(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aoE;
    }

    public void setTShowVisible(boolean z) {
        this.aoE = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoH = z;
    }
}

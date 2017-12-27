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
import com.baidu.tbadk.core.data.be;
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
    private be aXV;
    public ClickableHeaderImageView bbZ;
    private TextView bbk;
    public ImageView bcA;
    protected UserIconBox bcB;
    private TextView bcC;
    private View bcD;
    protected TextView bcE;
    private TextView bcF;
    private boolean bcG;
    private View bcH;
    private TextView bcI;
    private boolean bcJ;
    private View.OnClickListener bcK;
    private View.OnClickListener bcL;
    public TextView bca;
    private boolean bcd;
    private View.OnClickListener bce;
    private View.OnClickListener bcg;
    private UserIconBox bcz;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bcG = true;
        this.mFrom = 1;
        this.bcK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getUserId()) && ThreadUserInfoLayout.this.aXV.zd() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXV.Ac() != null && ThreadUserInfoLayout.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.Ac().channelId, ThreadUserInfoLayout.this.aXV.Ac().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.yX().getUserId(), ThreadUserInfoLayout.this.aXV.yX().getName_show(), ThreadUserInfoLayout.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXV.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXV.yX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcG = true;
        this.mFrom = 1;
        this.bcK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getUserId()) && ThreadUserInfoLayout.this.aXV.zd() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXV.Ac() != null && ThreadUserInfoLayout.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.Ac().channelId, ThreadUserInfoLayout.this.aXV.Ac().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.yX().getUserId(), ThreadUserInfoLayout.this.aXV.yX().getName_show(), ThreadUserInfoLayout.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXV.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXV.yX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcG = true;
        this.mFrom = 1;
        this.bcK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXV.yX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXV.yX().getUserId()) && ThreadUserInfoLayout.this.aXV.zd() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXV.Ac() != null && ThreadUserInfoLayout.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.Ac().channelId, ThreadUserInfoLayout.this.aXV.Ac().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXV.yX().getUserId(), ThreadUserInfoLayout.this.aXV.yX().getName_show(), ThreadUserInfoLayout.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXV.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXV != null && ThreadUserInfoLayout.this.aXV.yX() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXV.yX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.bbZ = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bcz = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bca = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bcA = (ImageView) inflate.findViewById(d.g.identity_view);
        this.bcB = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bbk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bcC = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bcD = inflate.findViewById(d.g.divider);
        this.bcH = findViewById(d.g.divider_forum_name);
        this.bcI = (TextView) findViewById(d.g.thread_info_forum_name);
        this.bcE = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bcF = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bcz.setOnClickListener(this.bcK);
        this.bca.setOnClickListener(this.bcg);
        this.bcB.setOnClickListener(this.bcL);
    }

    public boolean setData(be beVar) {
        if (beVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXV = beVar;
        if (this.aXV.aOZ > 0) {
            if (this.aXV.aPa == 0 && this.aXV.yX() != null) {
                if (!v.G(this.aXV.yX().getTShowInfoNew())) {
                    this.aXV.yX().getTShowInfoNew().clear();
                }
                this.aXV.yX().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.bcz.setOnClickListener(null);
            this.bca.setOnClickListener(null);
            this.bcB.setOnClickListener(null);
            this.bbZ.setClickable(false);
        } else {
            this.bcz.setOnClickListener(this.bcK);
            this.bca.setOnClickListener(this.bcg);
            this.bcB.setOnClickListener(this.bcL);
            this.bbZ.setClickable(true);
        }
        k(beVar);
        i(beVar);
        n(beVar);
        l(beVar);
        m(beVar);
        d(beVar);
        o(beVar);
        q(beVar);
        p(beVar);
        setVisibility(0);
        j(beVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.bbZ != null) {
            this.bbZ.setDefaultResource(17170445);
            this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bbZ.setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.bbZ.setIsRound(true);
            this.bbZ.setAfterClickListener(this.bce);
        }
    }

    private void j(be beVar) {
        if (this.bcF != null && beVar != null && beVar.yX() != null) {
            if (beVar.yX().hadConcerned()) {
                this.bcF.setVisibility(0);
                aj.r(this.bcF, d.C0108d.cp_cont_d);
                aj.s(this.bcF, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bcF.setVisibility(8);
        }
    }

    private void k(be beVar) {
        if (this.bcz != null && beVar != null && beVar.yX() != null) {
            ArrayList<IconData> tShowInfoNew = beVar.yX().getTShowInfoNew();
            if (v.F(tShowInfoNew) != 0) {
                this.bcz.setVisibility(0);
                this.bcz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.bcz.setVisibility(8);
        }
    }

    private void l(be beVar) {
        if (this.bcA != null && beVar != null && beVar.yX() != null) {
            MetaData yX = beVar.yX();
            if (yX.getIs_bawu() == 1) {
                if ("manager".equals(yX.getBawu_type())) {
                    aj.c(this.bcA, d.f.icon_id_bazhu);
                    this.bcA.setVisibility(0);
                    return;
                } else if ("assist".equals(yX.getBawu_type())) {
                    aj.c(this.bcA, d.f.icon_id_xiaobazhu);
                    this.bcA.setVisibility(0);
                    return;
                } else {
                    this.bcA.setVisibility(8);
                    return;
                }
            }
            this.bcA.setVisibility(8);
        }
    }

    private void i(be beVar) {
        if (this.bca != null && beVar != null) {
            if (!StringUtils.isNull(this.aXV.yX().getName_show())) {
                this.bca.setText(eE(this.aXV.yX().getName_show()));
            }
            Ej();
            if (this.mFrom == 3) {
                String name_show = this.aXV.yX().getName_show();
                String userName = this.aXV.yX().getUserName();
                if (ac.nu() && name_show != null && !name_show.equals(userName)) {
                    this.bca.setText(com.baidu.tieba.pb.c.am(this.mContext, this.bca.getText().toString()));
                    this.bca.setGravity(16);
                    this.bca.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYc());
                    aj.e(this.bca, d.C0108d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(be beVar) {
        if (this.bcB != null) {
            if (this.bcJ) {
                this.bcB.setVisibility(8);
            } else if (beVar == null || beVar.yX() == null || ((beVar.aOZ > 0 && beVar.aPa == 0) || !this.bcG)) {
                this.bcB.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = beVar.yX().getIconInfo();
                if (v.F(iconInfo) != 0) {
                    this.bcB.setVisibility(0);
                    this.bcB.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.bcB.setVisibility(8);
            }
        }
    }

    private void d(be beVar) {
        String z;
        if (this.bbk != null && beVar != null) {
            if (beVar.yR() <= 0) {
                this.bbk.setVisibility(4);
                return;
            }
            this.bbk.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(beVar.yR());
            } else if (beVar.Ad()) {
                z = am.z(beVar.getCreateTime());
            } else {
                z = am.z(beVar.yR() * 1000);
            }
            this.bbk.setText(z);
        }
    }

    protected void n(be beVar) {
        if (this.bcE == null || beVar == null) {
            this.bcE.setVisibility(8);
        } else if (this.bcJ) {
            if (StringUtils.isNull(beVar.zw())) {
                this.bcE.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcE.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.bcE.setLayoutParams(layoutParams);
            }
            this.bcE.setText(beVar.zw());
            this.bcE.setVisibility(0);
        } else if (this.aXV.zq() == null || this.aXV.zq().share_info == null || this.aXV.zq().share_info.share_user_count <= 0 || !this.aXV.Ag() || (this.aXV.aOZ > 0 && this.aXV.aPa == 0)) {
            this.bcE.setVisibility(8);
        } else {
            this.bcE.setVisibility(0);
            int i = this.aXV.zq().share_info.share_user_count;
            if (i == 1) {
                this.bcE.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.bcE.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.D(i)}));
            }
        }
    }

    private void o(be beVar) {
        if (beVar == null || StringUtils.isNull(beVar.getAddress())) {
            this.bcC.setVisibility(8);
            this.bcD.setVisibility(8);
            return;
        }
        this.bcC.setText(this.aXV.getAddress());
        this.bcC.setVisibility(0);
        this.bcD.setVisibility(0);
    }

    private void p(be beVar) {
        String str;
        if (beVar == null || StringUtils.isNull(beVar.zd()) || this.mFrom == 3) {
            this.bcI.setVisibility(8);
            this.bcH.setVisibility(8);
            return;
        }
        if (this.aXV.aOZ > 0 && this.aXV.aPa == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aXV.zd(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.bcI.setText(str);
        this.bcI.setVisibility(0);
        this.bcH.setVisibility(0);
    }

    private void q(be beVar) {
        if (this.bbZ != null && beVar != null && this.aXV.yX() != null) {
            if (this.aXV.aOZ > 0 && this.aXV.aPa == 0) {
                this.bbZ.setShowV(false);
            } else {
                this.bbZ.setShowV(this.aXV.yX().isBigV());
            }
        }
    }

    private void Ej() {
        if (this.aXV != null && this.aXV.yX() != null) {
            if (this.aXV.aOZ > 0 && this.aXV.aPa == 0) {
                aj.r(this.bca, d.C0108d.cp_cont_f);
            } else if (!v.G(this.aXV.yX().getTShowInfoNew()) || this.aXV.yX().isBigV()) {
                aj.r(this.bca, d.C0108d.cp_cont_h);
            } else {
                aj.r(this.bca, d.C0108d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ej();
        aj.r(this.bcE, d.C0108d.cp_cont_f);
        aj.r(this.bbk, d.C0108d.cp_cont_d);
        aj.t(this.bcD, d.C0108d.cp_cont_e);
        aj.r(this.bcC, d.C0108d.cp_cont_d);
        aj.r(this.bcI, d.C0108d.cp_cont_d);
        aj.t(this.bcD, d.C0108d.cp_cont_e);
        aj.t(this.bcH, d.C0108d.cp_cont_e);
        l(this.aXV);
    }

    public void setIsSimpleThread(boolean z) {
        this.bcd = z;
    }

    public boolean getIsSimpleThread() {
        return this.bcd;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bce = onClickListener;
        if (this.bbZ != null) {
            this.bbZ.setAfterClickListener(this.bce);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bbZ != null) {
            this.bbZ.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.bbZ;
    }

    public TextView getUserName() {
        return this.bca;
    }

    protected String eE(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.bcG;
    }

    public void setTShowVisible(boolean z) {
        this.bcG = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcJ = z;
    }
}

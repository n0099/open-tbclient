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
    private bd aXU;
    public ClickableHeaderImageView bbZ;
    private TextView bbk;
    private UserIconBox bcF;
    public ImageView bcG;
    protected UserIconBox bcH;
    private TextView bcI;
    private View bcJ;
    protected TextView bcK;
    private TextView bcL;
    private boolean bcM;
    private View bcN;
    private TextView bcO;
    private boolean bcP;
    private View.OnClickListener bcQ;
    private View.OnClickListener bcR;
    public TextView bca;
    private boolean bcd;
    private View.OnClickListener bce;
    private View.OnClickListener bcg;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bcM = true;
        this.mFrom = 1;
        this.bcQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getUserId()) && ThreadUserInfoLayout.this.aXU.yY() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXU.zU() != null && ThreadUserInfoLayout.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.zU().channelId, ThreadUserInfoLayout.this.aXU.zU().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.yS().getUserId(), ThreadUserInfoLayout.this.aXU.yS().getName_show(), ThreadUserInfoLayout.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXU.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXU.yS().getUserId(), true, true, true);
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
        this.bcM = true;
        this.mFrom = 1;
        this.bcQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getUserId()) && ThreadUserInfoLayout.this.aXU.yY() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXU.zU() != null && ThreadUserInfoLayout.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.zU().channelId, ThreadUserInfoLayout.this.aXU.zU().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.yS().getUserId(), ThreadUserInfoLayout.this.aXU.yS().getName_show(), ThreadUserInfoLayout.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXU.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXU.yS().getUserId(), true, true, true);
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
        this.bcM = true;
        this.mFrom = 1;
        this.bcQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aXU.yS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aXU.yS().getUserId()) && ThreadUserInfoLayout.this.aXU.yY() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.be(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aXU.zU() != null && ThreadUserInfoLayout.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.zU().channelId, ThreadUserInfoLayout.this.aXU.zU().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aXU.yS().getUserId(), ThreadUserInfoLayout.this.aXU.yS().getName_show(), ThreadUserInfoLayout.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aXU.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bce != null) {
                        ThreadUserInfoLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bcR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aXU != null && ThreadUserInfoLayout.this.aXU.yS() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aXU.yS().getUserId(), true, true, true);
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
        this.bcF = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bca = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bcG = (ImageView) inflate.findViewById(d.g.identity_view);
        this.bcH = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bbk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bcI = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bcJ = inflate.findViewById(d.g.divider);
        this.bcN = findViewById(d.g.divider_forum_name);
        this.bcO = (TextView) findViewById(d.g.thread_info_forum_name);
        this.bcK = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bcL = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bcF.setOnClickListener(this.bcQ);
        this.bca.setOnClickListener(this.bcg);
        this.bcH.setOnClickListener(this.bcR);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXU = bdVar;
        if (this.aXU.aOX > 0) {
            if (this.aXU.aOY == 0 && this.aXU.yS() != null) {
                if (!v.E(this.aXU.yS().getTShowInfoNew())) {
                    this.aXU.yS().getTShowInfoNew().clear();
                }
                this.aXU.yS().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.bcF.setOnClickListener(null);
            this.bca.setOnClickListener(null);
            this.bcH.setOnClickListener(null);
            this.bbZ.setClickable(false);
        } else {
            this.bcF.setOnClickListener(this.bcQ);
            this.bca.setOnClickListener(this.bcg);
            this.bcH.setOnClickListener(this.bcR);
            this.bbZ.setClickable(true);
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
        if (this.bbZ != null) {
            this.bbZ.setDefaultResource(17170445);
            this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bbZ.setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.bbZ.setIsRound(true);
            this.bbZ.setAfterClickListener(this.bce);
        }
    }

    private void j(bd bdVar) {
        if (this.bcL != null && bdVar != null && bdVar.yS() != null) {
            if (bdVar.yS().hadConcerned()) {
                this.bcL.setVisibility(0);
                aj.r(this.bcL, d.C0107d.cp_cont_d);
                aj.s(this.bcL, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bcL.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.bcF != null && bdVar != null && bdVar.yS() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.yS().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bcF.setVisibility(0);
                this.bcF.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.bcF.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.bcG != null && bdVar != null && bdVar.yS() != null) {
            MetaData yS = bdVar.yS();
            if (yS.getIs_bawu() == 1) {
                if ("manager".equals(yS.getBawu_type())) {
                    aj.c(this.bcG, d.f.icon_id_bazhu);
                    this.bcG.setVisibility(0);
                    return;
                } else if ("assist".equals(yS.getBawu_type())) {
                    aj.c(this.bcG, d.f.icon_id_xiaobazhu);
                    this.bcG.setVisibility(0);
                    return;
                } else {
                    this.bcG.setVisibility(8);
                    return;
                }
            }
            this.bcG.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.bca != null && bdVar != null) {
            if (!StringUtils.isNull(this.aXU.yS().getName_show())) {
                this.bca.setText(eE(this.aXU.yS().getName_show()));
            }
            Ea();
            if (this.mFrom == 3) {
                String name_show = this.aXU.yS().getName_show();
                String userName = this.aXU.yS().getUserName();
                if (ac.nu() && name_show != null && !name_show.equals(userName)) {
                    this.bca.setText(com.baidu.tieba.pb.c.al(this.mContext, this.bca.getText().toString()));
                    this.bca.setGravity(16);
                    this.bca.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYi());
                    aj.e(this.bca, d.C0107d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.bcH != null) {
            if (this.bcP) {
                this.bcH.setVisibility(8);
            } else if (bdVar == null || bdVar.yS() == null || ((bdVar.aOX > 0 && bdVar.aOY == 0) || !this.bcM)) {
                this.bcH.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.yS().getIconInfo();
                if (v.D(iconInfo) != 0) {
                    this.bcH.setVisibility(0);
                    this.bcH.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.bcH.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String z;
        if (this.bbk != null && bdVar != null) {
            if (bdVar.yM() <= 0) {
                this.bbk.setVisibility(4);
                return;
            }
            this.bbk.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(bdVar.yM());
            } else if (bdVar.zV()) {
                z = am.z(bdVar.getCreateTime());
            } else {
                z = am.z(bdVar.yM() * 1000);
            }
            this.bbk.setText(z);
        }
    }

    protected void n(bd bdVar) {
        if (this.bcK == null || bdVar == null) {
            this.bcK.setVisibility(8);
        } else if (this.bcP) {
            if (StringUtils.isNull(bdVar.zr())) {
                this.bcK.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcK.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.bcK.setLayoutParams(layoutParams);
            }
            this.bcK.setText(bdVar.zr());
            this.bcK.setVisibility(0);
        } else if (this.aXU.zl() == null || this.aXU.zl().share_info == null || this.aXU.zl().share_info.share_user_count <= 0 || !this.aXU.zY() || (this.aXU.aOX > 0 && this.aXU.aOY == 0)) {
            this.bcK.setVisibility(8);
        } else {
            this.bcK.setVisibility(0);
            int i = this.aXU.zl().share_info.share_user_count;
            if (i == 1) {
                this.bcK.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.bcK.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.E(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.bcI.setVisibility(8);
            this.bcJ.setVisibility(8);
            return;
        }
        this.bcI.setText(this.aXU.getAddress());
        this.bcI.setVisibility(0);
        this.bcJ.setVisibility(0);
    }

    private void p(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.yY()) || this.mFrom == 3) {
            this.bcO.setVisibility(8);
            this.bcN.setVisibility(8);
            return;
        }
        if (this.aXU.aOX > 0 && this.aXU.aOY == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aXU.yY(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.bcO.setText(str);
        this.bcO.setVisibility(0);
        this.bcN.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            p(this.aXU);
            return;
        }
        this.bcO.setVisibility(8);
        this.bcN.setVisibility(8);
    }

    private void q(bd bdVar) {
        if (this.bbZ != null && bdVar != null && this.aXU.yS() != null) {
            if (this.aXU.aOX > 0 && this.aXU.aOY == 0) {
                this.bbZ.setShowV(false);
            } else {
                this.bbZ.setShowV(this.aXU.yS().isBigV());
            }
        }
    }

    private void Ea() {
        if (this.aXU != null && this.aXU.yS() != null) {
            if (this.aXU.aOX > 0 && this.aXU.aOY == 0) {
                aj.r(this.bca, d.C0107d.cp_cont_f);
            } else if (!v.E(this.aXU.yS().getTShowInfoNew()) || this.aXU.yS().isBigV()) {
                aj.r(this.bca, d.C0107d.cp_cont_h);
            } else {
                aj.r(this.bca, d.C0107d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ea();
        aj.r(this.bcK, d.C0107d.cp_cont_f);
        aj.r(this.bbk, d.C0107d.cp_cont_d);
        aj.t(this.bcJ, d.C0107d.cp_cont_e);
        aj.r(this.bcI, d.C0107d.cp_cont_d);
        aj.r(this.bcO, d.C0107d.cp_cont_d);
        aj.t(this.bcJ, d.C0107d.cp_cont_e);
        aj.t(this.bcN, d.C0107d.cp_cont_e);
        l(this.aXU);
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
        return this.bcM;
    }

    public void setTShowVisible(boolean z) {
        this.bcM = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcP = z;
    }
}

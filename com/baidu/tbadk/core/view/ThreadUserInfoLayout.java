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
    private bd aYc;
    private TextView bbs;
    private UserIconBox bcN;
    public ImageView bcO;
    protected UserIconBox bcP;
    private TextView bcQ;
    private View bcR;
    protected TextView bcS;
    private TextView bcT;
    private boolean bcU;
    private View bcV;
    private TextView bcW;
    private boolean bcX;
    private View.OnClickListener bcY;
    private View.OnClickListener bcZ;
    public ClickableHeaderImageView bch;
    public TextView bci;
    private boolean bcl;
    private View.OnClickListener bcm;
    private View.OnClickListener bco;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bcU = true;
        this.mFrom = 1;
        this.bcY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.bb(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getUserId()) && ThreadUserInfoLayout.this.aYc.yZ() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.bb(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aYc.zV() != null && ThreadUserInfoLayout.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.zV().channelId, ThreadUserInfoLayout.this.aYc.zV().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.yT().getUserId(), ThreadUserInfoLayout.this.aYc.yT().getName_show(), ThreadUserInfoLayout.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aYc.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bcm != null) {
                        ThreadUserInfoLayout.this.bcm.onClick(view);
                    }
                }
            }
        };
        this.bcZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aYc.yT().getUserId(), true, true, true);
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
        this.bcU = true;
        this.mFrom = 1;
        this.bcY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.bb(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getUserId()) && ThreadUserInfoLayout.this.aYc.yZ() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.bb(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aYc.zV() != null && ThreadUserInfoLayout.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.zV().channelId, ThreadUserInfoLayout.this.aYc.zV().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.yT().getUserId(), ThreadUserInfoLayout.this.aYc.yT().getName_show(), ThreadUserInfoLayout.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aYc.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bcm != null) {
                        ThreadUserInfoLayout.this.bcm.onClick(view);
                    }
                }
            }
        };
        this.bcZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aYc.yT().getUserId(), true, true, true);
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
        this.bcU = true;
        this.mFrom = 1;
        this.bcY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.bb(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aYc.yT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aYc.yT().getUserId()) && ThreadUserInfoLayout.this.aYc.yZ() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.bb(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aYc.zV() != null && ThreadUserInfoLayout.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.zV().channelId, ThreadUserInfoLayout.this.aYc.zV().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aYc.yT().getUserId(), ThreadUserInfoLayout.this.aYc.yT().getName_show(), ThreadUserInfoLayout.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aYc.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bcm != null) {
                        ThreadUserInfoLayout.this.bcm.onClick(view);
                    }
                }
            }
        };
        this.bcZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aYc != null && ThreadUserInfoLayout.this.aYc.yT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aYc.yT().getUserId(), true, true, true);
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
        this.bch = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bcN = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bci = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bcO = (ImageView) inflate.findViewById(d.g.identity_view);
        this.bcP = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bbs = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bcQ = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bcR = inflate.findViewById(d.g.divider);
        this.bcV = findViewById(d.g.divider_forum_name);
        this.bcW = (TextView) findViewById(d.g.thread_info_forum_name);
        this.bcS = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bcT = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bcN.setOnClickListener(this.bcY);
        this.bci.setOnClickListener(this.bco);
        this.bcP.setOnClickListener(this.bcZ);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aYc = bdVar;
        if (this.aYc.aPa > 0) {
            if (this.aYc.aPb == 0 && this.aYc.yT() != null) {
                if (!v.E(this.aYc.yT().getTShowInfoNew())) {
                    this.aYc.yT().getTShowInfoNew().clear();
                }
                this.aYc.yT().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.bcN.setOnClickListener(null);
            this.bci.setOnClickListener(null);
            this.bcP.setOnClickListener(null);
            this.bch.setClickable(false);
        } else {
            this.bcN.setOnClickListener(this.bcY);
            this.bci.setOnClickListener(this.bco);
            this.bcP.setOnClickListener(this.bcZ);
            this.bch.setClickable(true);
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
        if (this.bch != null) {
            this.bch.setDefaultResource(17170445);
            this.bch.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bch.setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.bch.setIsRound(true);
            this.bch.setAfterClickListener(this.bcm);
        }
    }

    private void j(bd bdVar) {
        if (this.bcT != null && bdVar != null && bdVar.yT() != null) {
            if (bdVar.yT().hadConcerned()) {
                this.bcT.setVisibility(0);
                aj.r(this.bcT, d.C0108d.cp_cont_d);
                aj.s(this.bcT, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bcT.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.bcN != null && bdVar != null && bdVar.yT() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.yT().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bcN.setVisibility(0);
                this.bcN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.bcN.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.bcO != null && bdVar != null && bdVar.yT() != null) {
            MetaData yT = bdVar.yT();
            if (yT.getIs_bawu() == 1) {
                if ("manager".equals(yT.getBawu_type())) {
                    aj.c(this.bcO, d.f.icon_id_bazhu);
                    this.bcO.setVisibility(0);
                    return;
                } else if ("assist".equals(yT.getBawu_type())) {
                    aj.c(this.bcO, d.f.icon_id_xiaobazhu);
                    this.bcO.setVisibility(0);
                    return;
                } else {
                    this.bcO.setVisibility(8);
                    return;
                }
            }
            this.bcO.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.bci != null && bdVar != null) {
            if (!StringUtils.isNull(this.aYc.yT().getName_show())) {
                this.bci.setText(eM(this.aYc.yT().getName_show()));
            }
            Ec();
            if (this.mFrom == 3) {
                String name_show = this.aYc.yT().getName_show();
                String userName = this.aYc.yT().getUserName();
                if (ac.nv() && name_show != null && !name_show.equals(userName)) {
                    this.bci.setText(com.baidu.tieba.pb.c.ak(this.mContext, this.bci.getText().toString()));
                    this.bci.setGravity(16);
                    this.bci.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYn());
                    aj.e(this.bci, d.C0108d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.bcP != null) {
            if (this.bcX) {
                this.bcP.setVisibility(8);
            } else if (bdVar == null || bdVar.yT() == null || ((bdVar.aPa > 0 && bdVar.aPb == 0) || !this.bcU)) {
                this.bcP.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.yT().getIconInfo();
                if (v.D(iconInfo) != 0) {
                    this.bcP.setVisibility(0);
                    this.bcP.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.bcP.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String z;
        if (this.bbs != null && bdVar != null) {
            if (bdVar.yN() <= 0) {
                this.bbs.setVisibility(4);
                return;
            }
            this.bbs.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(bdVar.yN());
            } else if (bdVar.zW()) {
                z = am.z(bdVar.getCreateTime());
            } else {
                z = am.z(bdVar.yN() * 1000);
            }
            this.bbs.setText(z);
        }
    }

    protected void n(bd bdVar) {
        if (this.bcS == null || bdVar == null) {
            this.bcS.setVisibility(8);
        } else if (this.bcX) {
            if (StringUtils.isNull(bdVar.zs())) {
                this.bcS.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcS.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.bcS.setLayoutParams(layoutParams);
            }
            this.bcS.setText(bdVar.zs());
            this.bcS.setVisibility(0);
        } else if (this.aYc.zm() == null || this.aYc.zm().share_info == null || this.aYc.zm().share_info.share_user_count <= 0 || !this.aYc.zZ() || (this.aYc.aPa > 0 && this.aYc.aPb == 0)) {
            this.bcS.setVisibility(8);
        } else {
            this.bcS.setVisibility(0);
            int i = this.aYc.zm().share_info.share_user_count;
            if (i == 1) {
                this.bcS.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.bcS.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.E(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.bcQ.setVisibility(8);
            this.bcR.setVisibility(8);
            return;
        }
        this.bcQ.setText(this.aYc.getAddress());
        this.bcQ.setVisibility(0);
        this.bcR.setVisibility(0);
    }

    private void p(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.yZ()) || this.mFrom == 3) {
            this.bcW.setVisibility(8);
            this.bcV.setVisibility(8);
            return;
        }
        if (this.aYc.aPa > 0 && this.aYc.aPb == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aYc.yZ(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.bcW.setText(str);
        this.bcW.setVisibility(0);
        this.bcV.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            p(this.aYc);
            return;
        }
        this.bcW.setVisibility(8);
        this.bcV.setVisibility(8);
    }

    private void q(bd bdVar) {
        if (this.bch != null && bdVar != null && this.aYc.yT() != null) {
            if (this.aYc.aPa > 0 && this.aYc.aPb == 0) {
                this.bch.setShowV(false);
            } else {
                this.bch.setShowV(this.aYc.yT().isBigV());
            }
        }
    }

    private void Ec() {
        if (this.aYc != null && this.aYc.yT() != null) {
            if (this.aYc.aPa > 0 && this.aYc.aPb == 0) {
                aj.r(this.bci, d.C0108d.cp_cont_f);
            } else if (!v.E(this.aYc.yT().getTShowInfoNew()) || this.aYc.yT().isBigV()) {
                aj.r(this.bci, d.C0108d.cp_cont_h);
            } else {
                aj.r(this.bci, d.C0108d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ec();
        aj.r(this.bcS, d.C0108d.cp_cont_f);
        aj.r(this.bbs, d.C0108d.cp_cont_d);
        aj.t(this.bcR, d.C0108d.cp_cont_e);
        aj.r(this.bcQ, d.C0108d.cp_cont_d);
        aj.r(this.bcW, d.C0108d.cp_cont_d);
        aj.t(this.bcR, d.C0108d.cp_cont_e);
        aj.t(this.bcV, d.C0108d.cp_cont_e);
        l(this.aYc);
    }

    public void setIsSimpleThread(boolean z) {
        this.bcl = z;
    }

    public boolean getIsSimpleThread() {
        return this.bcl;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bcm = onClickListener;
        if (this.bch != null) {
            this.bch.setAfterClickListener(this.bcm);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bch != null) {
            this.bch.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.bch;
    }

    public TextView getUserName() {
        return this.bci;
    }

    protected String eM(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.bcU;
    }

    public void setTShowVisible(boolean z) {
        this.bcU = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bcX = z;
    }
}

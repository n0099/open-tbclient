package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.s.ao;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements d {
    private bg XT;
    public TextView ZA;
    protected UserIconBox ZB;
    private UserIconBox ZC;
    protected TextView ZE;
    private View ZG;
    private FrameLayout ZH;
    private View.OnClickListener ZI;
    private View.OnClickListener ZN;
    private View.OnClickListener ZO;
    private View.OnClickListener ZP;
    public TextView Zz;
    private TextView bSe;
    private TextView bTH;
    private View bTI;
    private TextView bTJ;
    private boolean bTK;
    private View bTL;
    private boolean bTM;
    private boolean bTN;
    private TextView bTb;
    public ClickableHeaderImageView bTm;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bTK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getUserId()) && ThreadUserInfoLayout.this.XT.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XT.ZY() != null && ThreadUserInfoLayout.this.XT.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.ZY().channelId, ThreadUserInfoLayout.this.XT.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.YO().getUserId(), ThreadUserInfoLayout.this.XT.YO().getName_show(), ThreadUserInfoLayout.this.XT.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZI != null) {
                        ThreadUserInfoLayout.this.ZI.onClick(view);
                    }
                }
            }
        };
        this.ZP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XT.YO().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getUserId()) && ThreadUserInfoLayout.this.XT.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XT.ZY() != null && ThreadUserInfoLayout.this.XT.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.ZY().channelId, ThreadUserInfoLayout.this.XT.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.YO().getUserId(), ThreadUserInfoLayout.this.XT.YO().getName_show(), ThreadUserInfoLayout.this.XT.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZI != null) {
                        ThreadUserInfoLayout.this.ZI.onClick(view);
                    }
                }
            }
        };
        this.ZP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XT.YO().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XT.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XT.YO().getUserId()) && ThreadUserInfoLayout.this.XT.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XT.ZY() != null && ThreadUserInfoLayout.this.XT.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.ZY().channelId, ThreadUserInfoLayout.this.XT.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XT.YO().getUserId(), ThreadUserInfoLayout.this.XT.YO().getName_show(), ThreadUserInfoLayout.this.XT.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZI != null) {
                        ThreadUserInfoLayout.this.ZI.onClick(view);
                    }
                }
            }
        };
        this.ZP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XT != null && ThreadUserInfoLayout.this.XT.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XT.YO().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.bTm = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ZC = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.Zz = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.ZA = (TextView) inflate.findViewById(d.g.identity_view);
        this.ZB = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bSe = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bTH = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTI = inflate.findViewById(d.g.divider);
        this.bTL = findViewById(d.g.divider_forum_name);
        this.bTb = (TextView) findViewById(d.g.thread_info_forum_name);
        this.ZE = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bTJ = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        this.ZH = (FrameLayout) inflate.findViewById(d.g.ala_live_info_content_layout);
        this.ZG = com.baidu.tbadk.ala.b.UH().n(this.mContext, 1);
        if (this.ZG != null) {
            this.ZG.setVisibility(8);
            this.ZH.addView(this.ZG);
        }
        setGravity(16);
        initHeaderImg();
        this.ZC.setOnClickListener(this.ZN);
        this.Zz.setOnClickListener(this.ZO);
        this.ZB.setOnClickListener(this.ZP);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XT = bgVar;
        if (this.XT.bDx > 0) {
            if (this.XT.bDy == 0 && this.XT.YO() != null) {
                if (!v.T(this.XT.YO().getTShowInfoNew())) {
                    this.XT.YO().getTShowInfoNew().clear();
                }
                this.XT.YO().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.ZC.setOnClickListener(null);
            this.Zz.setOnClickListener(null);
            this.ZB.setOnClickListener(null);
            this.bTm.setClickable(false);
        } else {
            this.ZC.setOnClickListener(this.ZN);
            this.Zz.setOnClickListener(this.ZO);
            this.ZB.setOnClickListener(this.ZP);
            this.bTm.setClickable(true);
        }
        i(bgVar);
        f(bgVar);
        g(bgVar);
        h(bgVar);
        j(bgVar);
        v(bgVar);
        A(bgVar);
        c(bgVar);
        B(bgVar);
        setVisibility(0);
        z(bgVar);
        e(bgVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.bTm != null) {
            this.bTm.setDefaultResource(17170445);
            this.bTm.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTm.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.bTm.setIsRound(true);
            this.bTm.setAfterClickListener(this.ZI);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YO().getAlaUserData();
                if (this.ZG != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsN = alaUserData;
                    aVar.type = 1;
                    this.ZG.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ZG.setVisibility(8);
                    } else {
                        this.ZG.setVisibility(0);
                    }
                }
            } else if (this.ZG != null) {
                this.ZG.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.bTJ != null && bgVar != null && bgVar.YO() != null) {
            if (bgVar.YO().hadConcerned()) {
                this.bTJ.setVisibility(0);
                al.j(this.bTJ, d.C0277d.cp_cont_d);
                al.k(this.bTJ, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bTJ.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.ZC != null && bgVar != null && bgVar.YO() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.YO().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZC.setVisibility(0);
                this.ZC.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ZC.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.ZA != null && bgVar != null && bgVar.YO() != null) {
            MetaData YO = bgVar.YO();
            if (YO.getIs_bawu() == 1) {
                int i = bgVar.bDJ ? d.f.brand_official_btn : d.f.user_identity_btn;
                int i2 = bgVar.bDJ ? d.C0277d.cp_btn_a : d.C0277d.cp_cont_j;
                al.k(this.ZA, i);
                al.j(this.ZA, i2);
                if (bgVar.bDJ) {
                    this.ZA.setVisibility(0);
                    this.ZA.setText(d.j.brand_Official);
                } else if ("manager".equals(YO.getBawu_type())) {
                    this.ZA.setVisibility(0);
                    this.ZA.setText(d.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(YO.getBawu_type())) {
                    this.ZA.setText(d.j.bawu_member_xbazhu_tip);
                    this.ZA.setVisibility(0);
                } else if ("pri_content_assist".equals(YO.getBawu_type())) {
                    this.ZA.setText(d.j.bawu_content_assist_tip);
                    this.ZA.setVisibility(0);
                } else if ("pri_manage_assist".equals(YO.getBawu_type())) {
                    this.ZA.setText(d.j.bawu_manage_assist_tip);
                    this.ZA.setVisibility(0);
                } else if (YO.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.ZA.setVisibility(8);
                }
            } else if (YO.getIs_biggie()) {
                k(bgVar);
            } else {
                this.ZA.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        al.k(this.ZA, d.f.brand_official_btn);
        al.j(this.ZA, d.C0277d.cp_link_tip_a);
        this.ZA.setText(d.j.video_mcn);
        if (bgVar.ZO()) {
            this.ZB.setVisibility(8);
        }
        this.ZA.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.Zz != null && bgVar != null) {
            if (!StringUtils.isNull(this.XT.YO().getName_show())) {
                this.Zz.setText(nt(this.XT.YO().getName_show()));
            }
            rG();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.XT.YO().getName_show();
                String userName = this.XT.YO().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    this.Zz.setText(com.baidu.tieba.pb.c.aP(this.mContext, this.Zz.getText().toString()));
                    this.Zz.setGravity(16);
                    this.Zz.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                    al.d(this.Zz, d.C0277d.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.ZB != null) {
            if (this.bTN) {
                this.ZB.setVisibility(8);
            } else if (bgVar == null || bgVar.YO() == null || ((bgVar.bDx > 0 && bgVar.bDy == 0) || !this.bTK)) {
                this.ZB.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.YO().getIconInfo();
                if (v.S(iconInfo) != 0) {
                    this.ZB.setVisibility(0);
                    this.ZB.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.ZB.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String ao;
        if (this.bSe != null && bgVar != null) {
            if (bgVar.YH() <= 0) {
                this.bSe.setVisibility(4);
                return;
            }
            this.bSe.setVisibility(0);
            if (this.mFrom == 2) {
                ao = ap.an(bgVar.YH());
            } else if (bgVar.ZZ()) {
                ao = ap.ao(bgVar.getCreateTime());
            } else if (bgVar.YS()) {
                ao = ap.ap(bgVar.YH() * 1000);
            } else {
                ao = ap.ao(bgVar.YH() * 1000);
            }
            this.bSe.setText(ao);
        }
    }

    protected void g(bg bgVar) {
        if (this.ZE == null || bgVar == null) {
            this.ZE.setVisibility(8);
        } else if (this.bTN) {
            if (StringUtils.isNull(bgVar.WP())) {
                this.ZE.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZE.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ZE.setLayoutParams(layoutParams);
            }
            this.ZE.setText(bgVar.WP());
            this.ZE.setVisibility(0);
        } else if (this.XT.Zh() == null || this.XT.Zh().share_info == null || this.XT.Zh().share_info.share_user_count <= 0 || !this.XT.aac() || (this.XT.bDx > 0 && this.XT.bDy == 0)) {
            this.ZE.setVisibility(8);
        } else {
            this.ZE.setVisibility(0);
            int i = this.XT.Zh().share_info.share_user_count;
            if (i == 1) {
                this.ZE.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.ZE.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{ap.at(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTH.setVisibility(8);
            this.bTI.setVisibility(8);
            return;
        }
        this.bTH.setText(this.XT.getAddress());
        this.bTH.setVisibility(0);
        this.bTI.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.bTb.setVisibility(8);
            this.bTL.setVisibility(8);
            return;
        }
        String YT = this.XT.YT();
        if (this.mFrom == 3 || this.mFrom == 4) {
            YT = null;
        } else if (this.mFrom == 5) {
            YT = bgVar.aaz();
        }
        if (bgVar.aay()) {
            YT = bgVar.bDI.ori_fname;
        }
        if (StringUtils.isNull(YT)) {
            this.bTb.setVisibility(8);
            this.bTL.setVisibility(8);
            return;
        }
        if (this.XT.bDx > 0 && this.XT.bDy == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = ap.g(YT, 12, "...") + getResources().getString(d.j.forum);
        }
        this.bTb.setText(str);
        this.bTb.setVisibility(0);
        this.bTL.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XT);
            return;
        }
        this.bTb.setVisibility(8);
        this.bTL.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.bTm != null && bgVar != null && this.XT.YO() != null) {
            if (this.XT.bDx > 0 && this.XT.bDy == 0) {
                this.bTm.setShowV(false);
            } else {
                this.bTm.setShowV(this.XT.YO().isBigV());
            }
        }
    }

    private void rG() {
        if (this.XT != null && this.XT.YO() != null) {
            if (this.XT.bDx > 0 && this.XT.bDy == 0) {
                al.j(this.Zz, d.C0277d.cp_cont_f);
            } else if (!v.T(this.XT.YO().getTShowInfoNew()) || this.XT.YO().isBigV()) {
                al.j(this.Zz, d.C0277d.cp_cont_h);
            } else {
                al.j(this.Zz, d.C0277d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        rG();
        al.j(this.ZE, d.C0277d.cp_cont_f);
        al.j(this.bSe, d.C0277d.cp_cont_d);
        al.l(this.bTI, d.C0277d.cp_cont_e);
        al.j(this.bTH, d.C0277d.cp_cont_d);
        al.j(this.bTb, d.C0277d.cp_cont_d);
        al.l(this.bTI, d.C0277d.cp_cont_e);
        al.l(this.bTL, d.C0277d.cp_cont_e);
        j(this.XT);
    }

    public void setIsSimpleThread(boolean z) {
        this.bTM = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.bTM;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZI = onClickListener;
        if (this.bTm != null) {
            this.bTm.setAfterClickListener(this.ZI);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTm != null) {
            this.bTm.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTm;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.Zz;
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.bTK = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTN = z;
    }
}

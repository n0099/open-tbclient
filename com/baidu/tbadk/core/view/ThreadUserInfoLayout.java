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
    private bg XS;
    protected UserIconBox ZA;
    private UserIconBox ZB;
    protected TextView ZD;
    private View ZF;
    private FrameLayout ZG;
    private View.OnClickListener ZH;
    private View.OnClickListener ZM;
    private View.OnClickListener ZN;
    private View.OnClickListener ZO;
    public TextView Zy;
    public TextView Zz;
    private TextView bSd;
    private TextView bTG;
    private View bTH;
    private TextView bTI;
    private boolean bTJ;
    private View bTK;
    private boolean bTL;
    private boolean bTM;
    private TextView bTa;
    public ClickableHeaderImageView bTl;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bTJ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getUserId()) && ThreadUserInfoLayout.this.XS.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XS.ZY() != null && ThreadUserInfoLayout.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.ZY().channelId, ThreadUserInfoLayout.this.XS.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.YO().getUserId(), ThreadUserInfoLayout.this.XS.YO().getName_show(), ThreadUserInfoLayout.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XS.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZH != null) {
                        ThreadUserInfoLayout.this.ZH.onClick(view);
                    }
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XS.YO().getUserId(), true, true, true);
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
        this.bTJ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getUserId()) && ThreadUserInfoLayout.this.XS.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XS.ZY() != null && ThreadUserInfoLayout.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.ZY().channelId, ThreadUserInfoLayout.this.XS.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.YO().getUserId(), ThreadUserInfoLayout.this.XS.YO().getName_show(), ThreadUserInfoLayout.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XS.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZH != null) {
                        ThreadUserInfoLayout.this.ZH.onClick(view);
                    }
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XS.YO().getUserId(), true, true, true);
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
        this.bTJ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XS.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XS.YO().getUserId()) && ThreadUserInfoLayout.this.XS.YT() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XS.ZY() != null && ThreadUserInfoLayout.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.ZY().channelId, ThreadUserInfoLayout.this.XS.ZY().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XS.YO().getUserId(), ThreadUserInfoLayout.this.XS.YO().getName_show(), ThreadUserInfoLayout.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XS.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZH != null) {
                        ThreadUserInfoLayout.this.ZH.onClick(view);
                    }
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XS != null && ThreadUserInfoLayout.this.XS.YO() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XS.YO().getUserId(), true, true, true);
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
        this.bTl = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ZB = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.Zy = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.Zz = (TextView) inflate.findViewById(d.g.identity_view);
        this.ZA = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bSd = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bTG = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTH = inflate.findViewById(d.g.divider);
        this.bTK = findViewById(d.g.divider_forum_name);
        this.bTa = (TextView) findViewById(d.g.thread_info_forum_name);
        this.ZD = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bTI = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        this.ZG = (FrameLayout) inflate.findViewById(d.g.ala_live_info_content_layout);
        this.ZF = com.baidu.tbadk.ala.b.UH().n(this.mContext, 1);
        if (this.ZF != null) {
            this.ZF.setVisibility(8);
            this.ZG.addView(this.ZF);
        }
        setGravity(16);
        initHeaderImg();
        this.ZB.setOnClickListener(this.ZM);
        this.Zy.setOnClickListener(this.ZN);
        this.ZA.setOnClickListener(this.ZO);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XS = bgVar;
        if (this.XS.bDw > 0) {
            if (this.XS.bDx == 0 && this.XS.YO() != null) {
                if (!v.T(this.XS.YO().getTShowInfoNew())) {
                    this.XS.YO().getTShowInfoNew().clear();
                }
                this.XS.YO().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.ZB.setOnClickListener(null);
            this.Zy.setOnClickListener(null);
            this.ZA.setOnClickListener(null);
            this.bTl.setClickable(false);
        } else {
            this.ZB.setOnClickListener(this.ZM);
            this.Zy.setOnClickListener(this.ZN);
            this.ZA.setOnClickListener(this.ZO);
            this.bTl.setClickable(true);
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
        if (this.bTl != null) {
            this.bTl.setDefaultResource(17170445);
            this.bTl.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.bTl.setIsRound(true);
            this.bTl.setAfterClickListener(this.ZH);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YO().getAlaUserData();
                if (this.ZF != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsM = alaUserData;
                    aVar.type = 1;
                    this.ZF.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ZF.setVisibility(8);
                    } else {
                        this.ZF.setVisibility(0);
                    }
                }
            } else if (this.ZF != null) {
                this.ZF.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.bTI != null && bgVar != null && bgVar.YO() != null) {
            if (bgVar.YO().hadConcerned()) {
                this.bTI.setVisibility(0);
                al.j(this.bTI, d.C0277d.cp_cont_d);
                al.k(this.bTI, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bTI.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.ZB != null && bgVar != null && bgVar.YO() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.YO().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZB.setVisibility(0);
                this.ZB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ZB.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Zz != null && bgVar != null && bgVar.YO() != null) {
            MetaData YO = bgVar.YO();
            if (YO.getIs_bawu() == 1) {
                int i = bgVar.bDI ? d.f.brand_official_btn : d.f.user_identity_btn;
                int i2 = bgVar.bDI ? d.C0277d.cp_btn_a : d.C0277d.cp_cont_j;
                al.k(this.Zz, i);
                al.j(this.Zz, i2);
                if (bgVar.bDI) {
                    this.Zz.setVisibility(0);
                    this.Zz.setText(d.j.brand_Official);
                } else if ("manager".equals(YO.getBawu_type())) {
                    this.Zz.setVisibility(0);
                    this.Zz.setText(d.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(YO.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_member_xbazhu_tip);
                    this.Zz.setVisibility(0);
                } else if ("pri_content_assist".equals(YO.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_content_assist_tip);
                    this.Zz.setVisibility(0);
                } else if ("pri_manage_assist".equals(YO.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_manage_assist_tip);
                    this.Zz.setVisibility(0);
                } else if (YO.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Zz.setVisibility(8);
                }
            } else if (YO.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Zz.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        al.k(this.Zz, d.f.brand_official_btn);
        al.j(this.Zz, d.C0277d.cp_link_tip_a);
        this.Zz.setText(d.j.video_mcn);
        if (bgVar.ZO()) {
            this.ZA.setVisibility(8);
        }
        this.Zz.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.Zy != null && bgVar != null) {
            if (!StringUtils.isNull(this.XS.YO().getName_show())) {
                this.Zy.setText(nt(this.XS.YO().getName_show()));
            }
            rG();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.XS.YO().getName_show();
                String userName = this.XS.YO().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    this.Zy.setText(com.baidu.tieba.pb.c.aP(this.mContext, this.Zy.getText().toString()));
                    this.Zy.setGravity(16);
                    this.Zy.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHH());
                    al.d(this.Zy, d.C0277d.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.ZA != null) {
            if (this.bTM) {
                this.ZA.setVisibility(8);
            } else if (bgVar == null || bgVar.YO() == null || ((bgVar.bDw > 0 && bgVar.bDx == 0) || !this.bTJ)) {
                this.ZA.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.YO().getIconInfo();
                if (v.S(iconInfo) != 0) {
                    this.ZA.setVisibility(0);
                    this.ZA.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.ZA.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String ao;
        if (this.bSd != null && bgVar != null) {
            if (bgVar.YH() <= 0) {
                this.bSd.setVisibility(4);
                return;
            }
            this.bSd.setVisibility(0);
            if (this.mFrom == 2) {
                ao = ap.an(bgVar.YH());
            } else if (bgVar.ZZ()) {
                ao = ap.ao(bgVar.getCreateTime());
            } else if (bgVar.YS()) {
                ao = ap.ap(bgVar.YH() * 1000);
            } else {
                ao = ap.ao(bgVar.YH() * 1000);
            }
            this.bSd.setText(ao);
        }
    }

    protected void g(bg bgVar) {
        if (this.ZD == null || bgVar == null) {
            this.ZD.setVisibility(8);
        } else if (this.bTM) {
            if (StringUtils.isNull(bgVar.WP())) {
                this.ZD.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZD.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ZD.setLayoutParams(layoutParams);
            }
            this.ZD.setText(bgVar.WP());
            this.ZD.setVisibility(0);
        } else if (this.XS.Zh() == null || this.XS.Zh().share_info == null || this.XS.Zh().share_info.share_user_count <= 0 || !this.XS.aac() || (this.XS.bDw > 0 && this.XS.bDx == 0)) {
            this.ZD.setVisibility(8);
        } else {
            this.ZD.setVisibility(0);
            int i = this.XS.Zh().share_info.share_user_count;
            if (i == 1) {
                this.ZD.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.ZD.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{ap.at(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTG.setVisibility(8);
            this.bTH.setVisibility(8);
            return;
        }
        this.bTG.setText(this.XS.getAddress());
        this.bTG.setVisibility(0);
        this.bTH.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.bTa.setVisibility(8);
            this.bTK.setVisibility(8);
            return;
        }
        String YT = this.XS.YT();
        if (this.mFrom == 3 || this.mFrom == 4) {
            YT = null;
        } else if (this.mFrom == 5) {
            YT = bgVar.aaz();
        }
        if (bgVar.aay()) {
            YT = bgVar.bDH.ori_fname;
        }
        if (StringUtils.isNull(YT)) {
            this.bTa.setVisibility(8);
            this.bTK.setVisibility(8);
            return;
        }
        if (this.XS.bDw > 0 && this.XS.bDx == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = ap.g(YT, 12, "...") + getResources().getString(d.j.forum);
        }
        this.bTa.setText(str);
        this.bTa.setVisibility(0);
        this.bTK.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XS);
            return;
        }
        this.bTa.setVisibility(8);
        this.bTK.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.bTl != null && bgVar != null && this.XS.YO() != null) {
            if (this.XS.bDw > 0 && this.XS.bDx == 0) {
                this.bTl.setShowV(false);
            } else {
                this.bTl.setShowV(this.XS.YO().isBigV());
            }
        }
    }

    private void rG() {
        if (this.XS != null && this.XS.YO() != null) {
            if (this.XS.bDw > 0 && this.XS.bDx == 0) {
                al.j(this.Zy, d.C0277d.cp_cont_f);
            } else if (!v.T(this.XS.YO().getTShowInfoNew()) || this.XS.YO().isBigV()) {
                al.j(this.Zy, d.C0277d.cp_cont_h);
            } else {
                al.j(this.Zy, d.C0277d.cp_cont_f);
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
        al.j(this.ZD, d.C0277d.cp_cont_f);
        al.j(this.bSd, d.C0277d.cp_cont_d);
        al.l(this.bTH, d.C0277d.cp_cont_e);
        al.j(this.bTG, d.C0277d.cp_cont_d);
        al.j(this.bTa, d.C0277d.cp_cont_d);
        al.l(this.bTH, d.C0277d.cp_cont_e);
        al.l(this.bTK, d.C0277d.cp_cont_e);
        j(this.XS);
    }

    public void setIsSimpleThread(boolean z) {
        this.bTL = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.bTL;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZH = onClickListener;
        if (this.bTl != null) {
            this.bTl.setAfterClickListener(this.ZH);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTl != null) {
            this.bTl.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTl;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.Zy;
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.bTJ = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTM = z;
    }
}

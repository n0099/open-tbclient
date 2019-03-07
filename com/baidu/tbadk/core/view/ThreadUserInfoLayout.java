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
    private bg XR;
    private UserIconBox ZA;
    protected TextView ZC;
    private View ZD;
    private FrameLayout ZE;
    private View.OnClickListener ZF;
    private View.OnClickListener ZK;
    private View.OnClickListener ZL;
    private View.OnClickListener ZM;
    public TextView Zx;
    public TextView Zy;
    protected UserIconBox Zz;
    private TextView bSX;
    private TextView bSa;
    private TextView bTD;
    private View bTE;
    private TextView bTF;
    private boolean bTG;
    private View bTH;
    private boolean bTI;
    private boolean bTJ;
    public ClickableHeaderImageView bTi;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.bTG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getUserId()) && ThreadUserInfoLayout.this.XR.YW() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XR.aab() != null && ThreadUserInfoLayout.this.XR.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.aab().channelId, ThreadUserInfoLayout.this.XR.aab().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.YR().getUserId(), ThreadUserInfoLayout.this.XR.YR().getName_show(), ThreadUserInfoLayout.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XR.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZF != null) {
                        ThreadUserInfoLayout.this.ZF.onClick(view);
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XR.YR().getUserId(), true, true, true);
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
        this.bTG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getUserId()) && ThreadUserInfoLayout.this.XR.YW() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XR.aab() != null && ThreadUserInfoLayout.this.XR.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.aab().channelId, ThreadUserInfoLayout.this.XR.aab().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.YR().getUserId(), ThreadUserInfoLayout.this.XR.YR().getName_show(), ThreadUserInfoLayout.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XR.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZF != null) {
                        ThreadUserInfoLayout.this.ZF.onClick(view);
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XR.YR().getUserId(), true, true, true);
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
        this.bTG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ZK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.XR.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.XR.YR().getUserId()) && ThreadUserInfoLayout.this.XR.YW() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.XR.aab() != null && ThreadUserInfoLayout.this.XR.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.aab().channelId, ThreadUserInfoLayout.this.XR.aab().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.XR.YR().getUserId(), ThreadUserInfoLayout.this.XR.YR().getName_show(), ThreadUserInfoLayout.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.XR.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ZF != null) {
                        ThreadUserInfoLayout.this.ZF.onClick(view);
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.XR != null && ThreadUserInfoLayout.this.XR.YR() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.XR.YR().getUserId(), true, true, true);
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
        this.bTi = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ZA = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.Zx = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.Zy = (TextView) inflate.findViewById(d.g.identity_view);
        this.Zz = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bSa = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bTD = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bTE = inflate.findViewById(d.g.divider);
        this.bTH = findViewById(d.g.divider_forum_name);
        this.bSX = (TextView) findViewById(d.g.thread_info_forum_name);
        this.ZC = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bTF = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        this.ZE = (FrameLayout) inflate.findViewById(d.g.ala_live_info_content_layout);
        this.ZD = com.baidu.tbadk.ala.b.UK().n(this.mContext, 1);
        if (this.ZD != null) {
            this.ZD.setVisibility(8);
            this.ZE.addView(this.ZD);
        }
        setGravity(16);
        initHeaderImg();
        this.ZA.setOnClickListener(this.ZK);
        this.Zx.setOnClickListener(this.ZL);
        this.Zz.setOnClickListener(this.ZM);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XR = bgVar;
        if (this.XR.bDr > 0) {
            if (this.XR.bDs == 0 && this.XR.YR() != null) {
                if (!v.T(this.XR.YR().getTShowInfoNew())) {
                    this.XR.YR().getTShowInfoNew().clear();
                }
                this.XR.YR().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.ZA.setOnClickListener(null);
            this.Zx.setOnClickListener(null);
            this.Zz.setOnClickListener(null);
            this.bTi.setClickable(false);
        } else {
            this.ZA.setOnClickListener(this.ZK);
            this.Zx.setOnClickListener(this.ZL);
            this.Zz.setOnClickListener(this.ZM);
            this.bTi.setClickable(true);
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
        if (this.bTi != null) {
            this.bTi.setDefaultResource(17170445);
            this.bTi.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bTi.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.bTi.setIsRound(true);
            this.bTi.setAfterClickListener(this.ZF);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YR().getAlaUserData();
                if (this.ZD != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsI = alaUserData;
                    aVar.type = 1;
                    this.ZD.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ZD.setVisibility(8);
                    } else {
                        this.ZD.setVisibility(0);
                    }
                }
            } else if (this.ZD != null) {
                this.ZD.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.bTF != null && bgVar != null && bgVar.YR() != null) {
            if (bgVar.YR().hadConcerned()) {
                this.bTF.setVisibility(0);
                al.j(this.bTF, d.C0236d.cp_cont_d);
                al.k(this.bTF, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bTF.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.ZA != null && bgVar != null && bgVar.YR() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.YR().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZA.setVisibility(0);
                this.ZA.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ZA.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Zy != null && bgVar != null && bgVar.YR() != null) {
            MetaData YR = bgVar.YR();
            if (YR.getIs_bawu() == 1) {
                int i = bgVar.bDD ? d.f.brand_official_btn : d.f.user_identity_btn;
                int i2 = bgVar.bDD ? d.C0236d.cp_btn_a : d.C0236d.cp_cont_j;
                al.k(this.Zy, i);
                al.j(this.Zy, i2);
                if (bgVar.bDD) {
                    this.Zy.setVisibility(0);
                    this.Zy.setText(d.j.brand_Official);
                } else if ("manager".equals(YR.getBawu_type())) {
                    this.Zy.setVisibility(0);
                    this.Zy.setText(d.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(YR.getBawu_type())) {
                    this.Zy.setText(d.j.bawu_member_xbazhu_tip);
                    this.Zy.setVisibility(0);
                } else if ("pri_content_assist".equals(YR.getBawu_type())) {
                    this.Zy.setText(d.j.bawu_content_assist_tip);
                    this.Zy.setVisibility(0);
                } else if ("pri_manage_assist".equals(YR.getBawu_type())) {
                    this.Zy.setText(d.j.bawu_manage_assist_tip);
                    this.Zy.setVisibility(0);
                } else if (YR.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Zy.setVisibility(8);
                }
            } else if (YR.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Zy.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        al.k(this.Zy, d.f.brand_official_btn);
        al.j(this.Zy, d.C0236d.cp_link_tip_a);
        this.Zy.setText(d.j.video_mcn);
        if (bgVar.ZR()) {
            this.Zz.setVisibility(8);
        }
        this.Zy.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.Zx != null && bgVar != null) {
            if (!StringUtils.isNull(this.XR.YR().getName_show())) {
                this.Zx.setText(ns(this.XR.YR().getName_show()));
            }
            rG();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.XR.YR().getName_show();
                String userName = this.XR.YR().getUserName();
                if (ao.jK() && name_show != null && !name_show.equals(userName)) {
                    this.Zx.setText(com.baidu.tieba.pb.c.aQ(this.mContext, this.Zx.getText().toString()));
                    this.Zx.setGravity(16);
                    this.Zx.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bHK());
                    al.d(this.Zx, d.C0236d.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.Zz != null) {
            if (this.bTJ) {
                this.Zz.setVisibility(8);
            } else if (bgVar == null || bgVar.YR() == null || ((bgVar.bDr > 0 && bgVar.bDs == 0) || !this.bTG)) {
                this.Zz.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.YR().getIconInfo();
                if (v.S(iconInfo) != 0) {
                    this.Zz.setVisibility(0);
                    this.Zz.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.Zz.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String ao;
        if (this.bSa != null && bgVar != null) {
            if (bgVar.YK() <= 0) {
                this.bSa.setVisibility(4);
                return;
            }
            this.bSa.setVisibility(0);
            if (this.mFrom == 2) {
                ao = ap.an(bgVar.YK());
            } else if (bgVar.aac()) {
                ao = ap.ao(bgVar.getCreateTime());
            } else if (bgVar.YV()) {
                ao = ap.ap(bgVar.YK() * 1000);
            } else {
                ao = ap.ao(bgVar.YK() * 1000);
            }
            this.bSa.setText(ao);
        }
    }

    protected void g(bg bgVar) {
        if (this.ZC == null || bgVar == null) {
            this.ZC.setVisibility(8);
        } else if (this.bTJ) {
            if (StringUtils.isNull(bgVar.WS())) {
                this.ZC.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZC.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ZC.setLayoutParams(layoutParams);
            }
            this.ZC.setText(bgVar.WS());
            this.ZC.setVisibility(0);
        } else if (this.XR.Zk() == null || this.XR.Zk().share_info == null || this.XR.Zk().share_info.share_user_count <= 0 || !this.XR.aaf() || (this.XR.bDr > 0 && this.XR.bDs == 0)) {
            this.ZC.setVisibility(8);
        } else {
            this.ZC.setVisibility(0);
            int i = this.XR.Zk().share_info.share_user_count;
            if (i == 1) {
                this.ZC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.ZC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{ap.at(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.bTD.setVisibility(8);
            this.bTE.setVisibility(8);
            return;
        }
        this.bTD.setText(this.XR.getAddress());
        this.bTD.setVisibility(0);
        this.bTE.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.bSX.setVisibility(8);
            this.bTH.setVisibility(8);
            return;
        }
        String YW = this.XR.YW();
        if (this.mFrom == 3 || this.mFrom == 4) {
            YW = null;
        } else if (this.mFrom == 5) {
            YW = bgVar.aaC();
        }
        if (bgVar.aaB()) {
            YW = bgVar.bDC.ori_fname;
        }
        if (StringUtils.isNull(YW)) {
            this.bSX.setVisibility(8);
            this.bTH.setVisibility(8);
            return;
        }
        if (this.XR.bDr > 0 && this.XR.bDs == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = ap.g(YW, 12, "...") + getResources().getString(d.j.forum);
        }
        this.bSX.setText(str);
        this.bSX.setVisibility(0);
        this.bTH.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void dN(boolean z) {
        if (z) {
            B(this.XR);
            return;
        }
        this.bSX.setVisibility(8);
        this.bTH.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.bTi != null && bgVar != null && this.XR.YR() != null) {
            if (this.XR.bDr > 0 && this.XR.bDs == 0) {
                this.bTi.setShowV(false);
            } else {
                this.bTi.setShowV(this.XR.YR().isBigV());
            }
        }
    }

    private void rG() {
        if (this.XR != null && this.XR.YR() != null) {
            if (this.XR.bDr > 0 && this.XR.bDs == 0) {
                al.j(this.Zx, d.C0236d.cp_cont_f);
            } else if (!v.T(this.XR.YR().getTShowInfoNew()) || this.XR.YR().isBigV()) {
                al.j(this.Zx, d.C0236d.cp_cont_h);
            } else {
                al.j(this.Zx, d.C0236d.cp_cont_f);
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
        al.j(this.ZC, d.C0236d.cp_cont_f);
        al.j(this.bSa, d.C0236d.cp_cont_d);
        al.l(this.bTE, d.C0236d.cp_cont_e);
        al.j(this.bTD, d.C0236d.cp_cont_d);
        al.j(this.bSX, d.C0236d.cp_cont_d);
        al.l(this.bTE, d.C0236d.cp_cont_e);
        al.l(this.bTH, d.C0236d.cp_cont_e);
        j(this.XR);
    }

    public void setIsSimpleThread(boolean z) {
        this.bTI = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.bTI;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
        if (this.bTi != null) {
            this.bTi.setAfterClickListener(this.ZF);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bTi != null) {
            this.bTi.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.bTi;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.Zx;
    }

    protected String ns(String str) {
        return ap.g(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.bTG = z;
    }

    public void setIsFromConcern(boolean z) {
        this.bTJ = z;
    }
}

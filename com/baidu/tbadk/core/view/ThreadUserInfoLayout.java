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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.an;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements f {
    private bb aBF;
    private TextView aFx;
    public ClickableHeaderImageView aGN;
    private UserIconBox aGO;
    public TextView aGP;
    public TextView aGQ;
    protected UserIconBox aGR;
    private TextView aGS;
    private View aGT;
    protected TextView aGU;
    private TextView aGV;
    private View aGW;
    private FrameLayout aGX;
    private boolean aGY;
    private View aGZ;
    private TextView aGk;
    private View.OnClickListener aHa;
    private boolean aHb;
    private boolean aHc;
    private View.OnClickListener aHd;
    private View.OnClickListener aHe;
    private View.OnClickListener aHf;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aGY = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aHd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bG(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aHe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getUserId()) && ThreadUserInfoLayout.this.aBF.yI() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bG(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aBF.zF() != null && ThreadUserInfoLayout.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.zF().channelId, ThreadUserInfoLayout.this.aBF.zF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.yC().getUserId(), ThreadUserInfoLayout.this.aBF.yC().getName_show(), ThreadUserInfoLayout.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aBF.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aHa != null) {
                        ThreadUserInfoLayout.this.aHa.onClick(view);
                    }
                }
            }
        };
        this.aHf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aBF.yC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGY = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aHd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bG(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aHe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getUserId()) && ThreadUserInfoLayout.this.aBF.yI() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bG(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aBF.zF() != null && ThreadUserInfoLayout.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.zF().channelId, ThreadUserInfoLayout.this.aBF.zF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.yC().getUserId(), ThreadUserInfoLayout.this.aBF.yC().getName_show(), ThreadUserInfoLayout.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aBF.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aHa != null) {
                        ThreadUserInfoLayout.this.aHa.onClick(view);
                    }
                }
            }
        };
        this.aHf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aBF.yC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGY = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aHd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bG(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aBF.yC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aHe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aBF.yC().getUserId()) && ThreadUserInfoLayout.this.aBF.yI() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bG(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aBF.zF() != null && ThreadUserInfoLayout.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.zF().channelId, ThreadUserInfoLayout.this.aBF.zF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aBF.yC().getUserId(), ThreadUserInfoLayout.this.aBF.yC().getName_show(), ThreadUserInfoLayout.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aBF.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aHa != null) {
                        ThreadUserInfoLayout.this.aHa.onClick(view);
                    }
                }
            }
        };
        this.aHf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aBF != null && ThreadUserInfoLayout.this.aBF.yC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aBF.yC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_user_info_layout, (ViewGroup) this, true);
        this.aGN = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aGO = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aGP = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aGQ = (TextView) inflate.findViewById(e.g.identity_view);
        this.aGR = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aFx = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aGS = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aGT = inflate.findViewById(e.g.divider);
        this.aGZ = findViewById(e.g.divider_forum_name);
        this.aGk = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aGU = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aGV = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aGX = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aGW = com.baidu.tbadk.ala.b.uV().j(this.mContext, 1);
        if (this.aGW != null) {
            this.aGW.setVisibility(8);
            this.aGX.addView(this.aGW);
        }
        setGravity(16);
        initHeaderImg();
        this.aGO.setOnClickListener(this.aHd);
        this.aGP.setOnClickListener(this.aHe);
        this.aGR.setOnClickListener(this.aHf);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aBF = bbVar;
        if (this.aBF.arR > 0) {
            if (this.aBF.arS == 0 && this.aBF.yC() != null) {
                if (!v.I(this.aBF.yC().getTShowInfoNew())) {
                    this.aBF.yC().getTShowInfoNew().clear();
                }
                this.aBF.yC().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aGO.setOnClickListener(null);
            this.aGP.setOnClickListener(null);
            this.aGR.setOnClickListener(null);
            this.aGN.setClickable(false);
        } else {
            this.aGO.setOnClickListener(this.aHd);
            this.aGP.setOnClickListener(this.aHe);
            this.aGR.setOnClickListener(this.aHf);
            this.aGN.setClickable(true);
        }
        m(bbVar);
        p(bbVar);
        r(bbVar);
        q(bbVar);
        n(bbVar);
        f(bbVar);
        s(bbVar);
        t(bbVar);
        updateForumName(bbVar);
        setVisibility(0);
        l(bbVar);
        k(bbVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.aGN != null) {
            this.aGN.setDefaultResource(17170445);
            this.aGN.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aGN.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aGN.setIsRound(true);
            this.aGN.setAfterClickListener(this.aHa);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.yC() != null && bbVar.yC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.yC().getAlaUserData();
                if (this.aGW != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aig = alaUserData;
                    aVar.type = 1;
                    this.aGW.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aGW.setVisibility(8);
                    } else {
                        this.aGW.setVisibility(0);
                    }
                }
            } else if (this.aGW != null) {
                this.aGW.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aGV != null && bbVar != null && bbVar.yC() != null) {
            if (bbVar.yC().hadConcerned()) {
                this.aGV.setVisibility(0);
                al.h(this.aGV, e.d.cp_cont_d);
                al.i(this.aGV, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aGV.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aGO != null && bbVar != null && bbVar.yC() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.yC().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aGO.setVisibility(0);
                this.aGO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds8), true);
                return;
            }
            this.aGO.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aGQ != null && bbVar != null && bbVar.yC() != null) {
            MetaData yC = bbVar.yC();
            if (yC.getIs_bawu() == 1) {
                int i = bbVar.asd ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.asd ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aGQ, i);
                al.h(this.aGQ, i2);
                if (bbVar.asd) {
                    this.aGQ.setVisibility(0);
                    this.aGQ.setText(e.j.brand_Official);
                } else if ("manager".equals(yC.getBawu_type())) {
                    this.aGQ.setVisibility(0);
                    this.aGQ.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(yC.getBawu_type())) {
                    this.aGQ.setText(e.j.bawu_member_xbazhu_tip);
                    this.aGQ.setVisibility(0);
                } else if (yC.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aGQ.setVisibility(8);
                }
            } else if (yC.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aGQ.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aGQ, e.f.brand_official_btn);
        al.h(this.aGQ, e.d.cp_link_tip_a);
        this.aGQ.setText(e.j.video_mcn);
        if (bbVar.zu()) {
            this.aGR.setVisibility(8);
        }
        this.aGQ.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aGP != null && bbVar != null) {
            if (!StringUtils.isNull(this.aBF.yC().getName_show())) {
                this.aGP.setText(fZ(this.aBF.yC().getName_show()));
            }
            Eo();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aBF.yC().getName_show();
                String userName = this.aBF.yC().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    this.aGP.setText(com.baidu.tieba.pb.c.aB(this.mContext, this.aGP.getText().toString()));
                    this.aGP.setGravity(16);
                    this.aGP.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bec());
                    al.c(this.aGP, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aGR != null) {
            if (this.aHc) {
                this.aGR.setVisibility(8);
            } else if (bbVar == null || bbVar.yC() == null || ((bbVar.arR > 0 && bbVar.arS == 0) || !this.aGY)) {
                this.aGR.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.yC().getIconInfo();
                if (v.H(iconInfo) != 0) {
                    this.aGR.setVisibility(0);
                    this.aGR.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds8), true);
                    return;
                }
                this.aGR.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String E;
        if (this.aFx != null && bbVar != null) {
            if (bbVar.yv() <= 0) {
                this.aFx.setVisibility(4);
                return;
            }
            this.aFx.setVisibility(0);
            if (this.mFrom == 2) {
                E = ao.D(bbVar.yv());
            } else if (bbVar.zG()) {
                E = ao.E(bbVar.getCreateTime());
            } else if (bbVar.yH()) {
                E = ao.F(bbVar.yv() * 1000);
            } else {
                E = ao.E(bbVar.yv() * 1000);
            }
            this.aFx.setText(E);
        }
    }

    protected void r(bb bbVar) {
        if (this.aGU == null || bbVar == null) {
            this.aGU.setVisibility(8);
        } else if (this.aHc) {
            if (StringUtils.isNull(bbVar.zb())) {
                this.aGU.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aGU.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aGU.setLayoutParams(layoutParams);
            }
            this.aGU.setText(bbVar.zb());
            this.aGU.setVisibility(0);
        } else if (this.aBF.yW() == null || this.aBF.yW().share_info == null || this.aBF.yW().share_info.share_user_count <= 0 || !this.aBF.zJ() || (this.aBF.arR > 0 && this.aBF.arS == 0)) {
            this.aGU.setVisibility(8);
        } else {
            this.aGU.setVisibility(0);
            int i = this.aBF.yW().share_info.share_user_count;
            if (i == 1) {
                this.aGU.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aGU.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.K(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aGS.setVisibility(8);
            this.aGT.setVisibility(8);
            return;
        }
        this.aGS.setText(this.aBF.getAddress());
        this.aGS.setVisibility(0);
        this.aGT.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aGk.setVisibility(8);
            this.aGZ.setVisibility(8);
            return;
        }
        String yI = this.aBF.yI();
        if (this.mFrom == 3 || this.mFrom == 4) {
            yI = null;
        } else if (this.mFrom == 5) {
            yI = bbVar.Af();
        }
        if (bbVar.Ae()) {
            yI = bbVar.asc.ori_fname;
        }
        if (StringUtils.isNull(yI)) {
            this.aGk.setVisibility(8);
            this.aGZ.setVisibility(8);
            return;
        }
        if (this.aBF.arR > 0 && this.aBF.arS == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(yI, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aGk.setText(str);
        this.aGk.setVisibility(0);
        this.aGZ.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aBF);
            return;
        }
        this.aGk.setVisibility(8);
        this.aGZ.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aGN != null && bbVar != null && this.aBF.yC() != null) {
            if (this.aBF.arR > 0 && this.aBF.arS == 0) {
                this.aGN.setShowV(false);
            } else {
                this.aGN.setShowV(this.aBF.yC().isBigV());
            }
        }
    }

    private void Eo() {
        if (this.aBF != null && this.aBF.yC() != null) {
            if (this.aBF.arR > 0 && this.aBF.arS == 0) {
                al.h(this.aGP, e.d.cp_cont_f);
            } else if (!v.I(this.aBF.yC().getTShowInfoNew()) || this.aBF.yC().isBigV()) {
                al.h(this.aGP, e.d.cp_cont_h);
            } else {
                al.h(this.aGP, e.d.cp_cont_f);
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
        Eo();
        al.h(this.aGU, e.d.cp_cont_f);
        al.h(this.aFx, e.d.cp_cont_d);
        al.j(this.aGT, e.d.cp_cont_e);
        al.h(this.aGS, e.d.cp_cont_d);
        al.h(this.aGk, e.d.cp_cont_d);
        al.j(this.aGT, e.d.cp_cont_e);
        al.j(this.aGZ, e.d.cp_cont_e);
        n(this.aBF);
    }

    public void setIsSimpleThread(boolean z) {
        this.aHb = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aHb;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aHa = onClickListener;
        if (this.aGN != null) {
            this.aGN.setAfterClickListener(this.aHa);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aGN != null) {
            this.aGN.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aGN;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aGP;
    }

    protected String fZ(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aGY;
    }

    public void setTShowVisible(boolean z) {
        this.aGY = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aHc = z;
    }
}

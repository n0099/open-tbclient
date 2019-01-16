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
    private bb aFI;
    private TextView aJA;
    public ClickableHeaderImageView aKR;
    private UserIconBox aKS;
    public TextView aKT;
    public TextView aKU;
    protected UserIconBox aKV;
    private TextView aKW;
    private View aKX;
    protected TextView aKY;
    private TextView aKZ;
    private TextView aKo;
    private View aLa;
    private FrameLayout aLb;
    private boolean aLc;
    private View aLd;
    private View.OnClickListener aLe;
    private boolean aLf;
    private boolean aLg;
    private View.OnClickListener aLh;
    private View.OnClickListener aLi;
    private View.OnClickListener aLj;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aLc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getUserId()) && ThreadUserInfoLayout.this.aFI.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFI.AW() != null && ThreadUserInfoLayout.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.AW().channelId, ThreadUserInfoLayout.this.aFI.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.zT().getUserId(), ThreadUserInfoLayout.this.aFI.zT().getName_show(), ThreadUserInfoLayout.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFI.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLe != null) {
                        ThreadUserInfoLayout.this.aLe.onClick(view);
                    }
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFI.zT().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getUserId()) && ThreadUserInfoLayout.this.aFI.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFI.AW() != null && ThreadUserInfoLayout.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.AW().channelId, ThreadUserInfoLayout.this.aFI.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.zT().getUserId(), ThreadUserInfoLayout.this.aFI.zT().getName_show(), ThreadUserInfoLayout.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFI.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLe != null) {
                        ThreadUserInfoLayout.this.aLe.onClick(view);
                    }
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFI.zT().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFI.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFI.zT().getUserId()) && ThreadUserInfoLayout.this.aFI.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFI.AW() != null && ThreadUserInfoLayout.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.AW().channelId, ThreadUserInfoLayout.this.aFI.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFI.zT().getUserId(), ThreadUserInfoLayout.this.aFI.zT().getName_show(), ThreadUserInfoLayout.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFI.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLe != null) {
                        ThreadUserInfoLayout.this.aLe.onClick(view);
                    }
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFI != null && ThreadUserInfoLayout.this.aFI.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFI.zT().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_user_info_layout, (ViewGroup) this, true);
        this.aKR = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKS = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aKT = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aKU = (TextView) inflate.findViewById(e.g.identity_view);
        this.aKV = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aJA = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKW = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKX = inflate.findViewById(e.g.divider);
        this.aLd = findViewById(e.g.divider_forum_name);
        this.aKo = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aKY = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aKZ = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aLb = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aLa = com.baidu.tbadk.ala.b.wg().j(this.mContext, 1);
        if (this.aLa != null) {
            this.aLa.setVisibility(8);
            this.aLb.addView(this.aLa);
        }
        setGravity(16);
        initHeaderImg();
        this.aKS.setOnClickListener(this.aLh);
        this.aKT.setOnClickListener(this.aLi);
        this.aKV.setOnClickListener(this.aLj);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFI = bbVar;
        if (this.aFI.avT > 0) {
            if (this.aFI.avU == 0 && this.aFI.zT() != null) {
                if (!v.I(this.aFI.zT().getTShowInfoNew())) {
                    this.aFI.zT().getTShowInfoNew().clear();
                }
                this.aFI.zT().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aKS.setOnClickListener(null);
            this.aKT.setOnClickListener(null);
            this.aKV.setOnClickListener(null);
            this.aKR.setClickable(false);
        } else {
            this.aKS.setOnClickListener(this.aLh);
            this.aKT.setOnClickListener(this.aLi);
            this.aKV.setOnClickListener(this.aLj);
            this.aKR.setClickable(true);
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
        if (this.aKR != null) {
            this.aKR.setDefaultResource(17170445);
            this.aKR.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKR.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKR.setIsRound(true);
            this.aKR.setAfterClickListener(this.aLe);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zT().getAlaUserData();
                if (this.aLa != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = alaUserData;
                    aVar.type = 1;
                    this.aLa.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aLa.setVisibility(8);
                    } else {
                        this.aLa.setVisibility(0);
                    }
                }
            } else if (this.aLa != null) {
                this.aLa.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aKZ != null && bbVar != null && bbVar.zT() != null) {
            if (bbVar.zT().hadConcerned()) {
                this.aKZ.setVisibility(0);
                al.h(this.aKZ, e.d.cp_cont_d);
                al.i(this.aKZ, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aKZ.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aKS != null && bbVar != null && bbVar.zT() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.zT().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKS.setVisibility(0);
                this.aKS.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                return;
            }
            this.aKS.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aKU != null && bbVar != null && bbVar.zT() != null) {
            MetaData zT = bbVar.zT();
            if (zT.getIs_bawu() == 1) {
                int i = bbVar.awf ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.awf ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aKU, i);
                al.h(this.aKU, i2);
                if (bbVar.awf) {
                    this.aKU.setVisibility(0);
                    this.aKU.setText(e.j.brand_Official);
                } else if ("manager".equals(zT.getBawu_type())) {
                    this.aKU.setVisibility(0);
                    this.aKU.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(zT.getBawu_type())) {
                    this.aKU.setText(e.j.bawu_member_xbazhu_tip);
                    this.aKU.setVisibility(0);
                } else if (zT.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aKU.setVisibility(8);
                }
            } else if (zT.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aKU.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aKU, e.f.brand_official_btn);
        al.h(this.aKU, e.d.cp_link_tip_a);
        this.aKU.setText(e.j.video_mcn);
        if (bbVar.AL()) {
            this.aKV.setVisibility(8);
        }
        this.aKU.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aKT != null && bbVar != null) {
            if (!StringUtils.isNull(this.aFI.zT().getName_show())) {
                this.aKT.setText(gG(this.aFI.zT().getName_show()));
            }
            FG();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aFI.zT().getName_show();
                String userName = this.aFI.zT().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    this.aKT.setText(com.baidu.tieba.pb.c.aC(this.mContext, this.aKT.getText().toString()));
                    this.aKT.setGravity(16);
                    this.aKT.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                    al.c(this.aKT, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aKV != null) {
            if (this.aLg) {
                this.aKV.setVisibility(8);
            } else if (bbVar == null || bbVar.zT() == null || ((bbVar.avT > 0 && bbVar.avU == 0) || !this.aLc)) {
                this.aKV.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.zT().getIconInfo();
                if (v.H(iconInfo) != 0) {
                    this.aKV.setVisibility(0);
                    this.aKV.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    return;
                }
                this.aKV.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String M;
        if (this.aJA != null && bbVar != null) {
            if (bbVar.zM() <= 0) {
                this.aJA.setVisibility(4);
                return;
            }
            this.aJA.setVisibility(0);
            if (this.mFrom == 2) {
                M = ao.L(bbVar.zM());
            } else if (bbVar.AX()) {
                M = ao.M(bbVar.getCreateTime());
            } else if (bbVar.zY()) {
                M = ao.N(bbVar.zM() * 1000);
            } else {
                M = ao.M(bbVar.zM() * 1000);
            }
            this.aJA.setText(M);
        }
    }

    protected void r(bb bbVar) {
        if (this.aKY == null || bbVar == null) {
            this.aKY.setVisibility(8);
        } else if (this.aLg) {
            if (StringUtils.isNull(bbVar.As())) {
                this.aKY.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKY.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aKY.setLayoutParams(layoutParams);
            }
            this.aKY.setText(bbVar.As());
            this.aKY.setVisibility(0);
        } else if (this.aFI.An() == null || this.aFI.An().share_info == null || this.aFI.An().share_info.share_user_count <= 0 || !this.aFI.Ba() || (this.aFI.avT > 0 && this.aFI.avU == 0)) {
            this.aKY.setVisibility(8);
        } else {
            this.aKY.setVisibility(0);
            int i = this.aFI.An().share_info.share_user_count;
            if (i == 1) {
                this.aKY.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aKY.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.S(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKW.setVisibility(8);
            this.aKX.setVisibility(8);
            return;
        }
        this.aKW.setText(this.aFI.getAddress());
        this.aKW.setVisibility(0);
        this.aKX.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aKo.setVisibility(8);
            this.aLd.setVisibility(8);
            return;
        }
        String zZ = this.aFI.zZ();
        if (this.mFrom == 3 || this.mFrom == 4) {
            zZ = null;
        } else if (this.mFrom == 5) {
            zZ = bbVar.Bw();
        }
        if (bbVar.Bv()) {
            zZ = bbVar.awe.ori_fname;
        }
        if (StringUtils.isNull(zZ)) {
            this.aKo.setVisibility(8);
            this.aLd.setVisibility(8);
            return;
        }
        if (this.aFI.avT > 0 && this.aFI.avU == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(zZ, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aKo.setText(str);
        this.aKo.setVisibility(0);
        this.aLd.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFI);
            return;
        }
        this.aKo.setVisibility(8);
        this.aLd.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aKR != null && bbVar != null && this.aFI.zT() != null) {
            if (this.aFI.avT > 0 && this.aFI.avU == 0) {
                this.aKR.setShowV(false);
            } else {
                this.aKR.setShowV(this.aFI.zT().isBigV());
            }
        }
    }

    private void FG() {
        if (this.aFI != null && this.aFI.zT() != null) {
            if (this.aFI.avT > 0 && this.aFI.avU == 0) {
                al.h(this.aKT, e.d.cp_cont_f);
            } else if (!v.I(this.aFI.zT().getTShowInfoNew()) || this.aFI.zT().isBigV()) {
                al.h(this.aKT, e.d.cp_cont_h);
            } else {
                al.h(this.aKT, e.d.cp_cont_f);
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
        FG();
        al.h(this.aKY, e.d.cp_cont_f);
        al.h(this.aJA, e.d.cp_cont_d);
        al.j(this.aKX, e.d.cp_cont_e);
        al.h(this.aKW, e.d.cp_cont_d);
        al.h(this.aKo, e.d.cp_cont_d);
        al.j(this.aKX, e.d.cp_cont_e);
        al.j(this.aLd, e.d.cp_cont_e);
        n(this.aFI);
    }

    public void setIsSimpleThread(boolean z) {
        this.aLf = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aLf;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLe = onClickListener;
        if (this.aKR != null) {
            this.aKR.setAfterClickListener(this.aLe);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKR != null) {
            this.aKR.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKR;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKT;
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aLc;
    }

    public void setTShowVisible(boolean z) {
        this.aLc = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aLg = z;
    }
}

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
    private bb aFJ;
    private TextView aJB;
    public ClickableHeaderImageView aKS;
    private UserIconBox aKT;
    public TextView aKU;
    public TextView aKV;
    protected UserIconBox aKW;
    private TextView aKX;
    private View aKY;
    protected TextView aKZ;
    private TextView aKp;
    private TextView aLa;
    private View aLb;
    private FrameLayout aLc;
    private boolean aLd;
    private View aLe;
    private View.OnClickListener aLf;
    private boolean aLg;
    private boolean aLh;
    private View.OnClickListener aLi;
    private View.OnClickListener aLj;
    private View.OnClickListener aLk;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aLd = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getUserId()) && ThreadUserInfoLayout.this.aFJ.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFJ.AW() != null && ThreadUserInfoLayout.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.AW().channelId, ThreadUserInfoLayout.this.aFJ.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.zT().getUserId(), ThreadUserInfoLayout.this.aFJ.zT().getName_show(), ThreadUserInfoLayout.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLf != null) {
                        ThreadUserInfoLayout.this.aLf.onClick(view);
                    }
                }
            }
        };
        this.aLk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFJ.zT().getUserId(), true, true, true);
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
        this.aLd = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getUserId()) && ThreadUserInfoLayout.this.aFJ.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFJ.AW() != null && ThreadUserInfoLayout.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.AW().channelId, ThreadUserInfoLayout.this.aFJ.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.zT().getUserId(), ThreadUserInfoLayout.this.aFJ.zT().getName_show(), ThreadUserInfoLayout.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLf != null) {
                        ThreadUserInfoLayout.this.aLf.onClick(view);
                    }
                }
            }
        };
        this.aLk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFJ.zT().getUserId(), true, true, true);
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
        this.aLd = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFJ.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFJ.zT().getUserId()) && ThreadUserInfoLayout.this.aFJ.zZ() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFJ.AW() != null && ThreadUserInfoLayout.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.AW().channelId, ThreadUserInfoLayout.this.aFJ.AW().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFJ.zT().getUserId(), ThreadUserInfoLayout.this.aFJ.zT().getName_show(), ThreadUserInfoLayout.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aLf != null) {
                        ThreadUserInfoLayout.this.aLf.onClick(view);
                    }
                }
            }
        };
        this.aLk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFJ != null && ThreadUserInfoLayout.this.aFJ.zT() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFJ.zT().getUserId(), true, true, true);
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
        this.aKS = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKT = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aKU = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aKV = (TextView) inflate.findViewById(e.g.identity_view);
        this.aKW = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aJB = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKX = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKY = inflate.findViewById(e.g.divider);
        this.aLe = findViewById(e.g.divider_forum_name);
        this.aKp = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aKZ = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aLa = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aLc = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aLb = com.baidu.tbadk.ala.b.wg().j(this.mContext, 1);
        if (this.aLb != null) {
            this.aLb.setVisibility(8);
            this.aLc.addView(this.aLb);
        }
        setGravity(16);
        initHeaderImg();
        this.aKT.setOnClickListener(this.aLi);
        this.aKU.setOnClickListener(this.aLj);
        this.aKW.setOnClickListener(this.aLk);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFJ = bbVar;
        if (this.aFJ.avU > 0) {
            if (this.aFJ.avV == 0 && this.aFJ.zT() != null) {
                if (!v.I(this.aFJ.zT().getTShowInfoNew())) {
                    this.aFJ.zT().getTShowInfoNew().clear();
                }
                this.aFJ.zT().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aKT.setOnClickListener(null);
            this.aKU.setOnClickListener(null);
            this.aKW.setOnClickListener(null);
            this.aKS.setClickable(false);
        } else {
            this.aKT.setOnClickListener(this.aLi);
            this.aKU.setOnClickListener(this.aLj);
            this.aKW.setOnClickListener(this.aLk);
            this.aKS.setClickable(true);
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
        if (this.aKS != null) {
            this.aKS.setDefaultResource(17170445);
            this.aKS.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKS.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKS.setIsRound(true);
            this.aKS.setAfterClickListener(this.aLf);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zT().getAlaUserData();
                if (this.aLb != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = alaUserData;
                    aVar.type = 1;
                    this.aLb.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aLb.setVisibility(8);
                    } else {
                        this.aLb.setVisibility(0);
                    }
                }
            } else if (this.aLb != null) {
                this.aLb.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aLa != null && bbVar != null && bbVar.zT() != null) {
            if (bbVar.zT().hadConcerned()) {
                this.aLa.setVisibility(0);
                al.h(this.aLa, e.d.cp_cont_d);
                al.i(this.aLa, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aLa.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aKT != null && bbVar != null && bbVar.zT() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.zT().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKT.setVisibility(0);
                this.aKT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                return;
            }
            this.aKT.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aKV != null && bbVar != null && bbVar.zT() != null) {
            MetaData zT = bbVar.zT();
            if (zT.getIs_bawu() == 1) {
                int i = bbVar.awg ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.awg ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aKV, i);
                al.h(this.aKV, i2);
                if (bbVar.awg) {
                    this.aKV.setVisibility(0);
                    this.aKV.setText(e.j.brand_Official);
                } else if ("manager".equals(zT.getBawu_type())) {
                    this.aKV.setVisibility(0);
                    this.aKV.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(zT.getBawu_type())) {
                    this.aKV.setText(e.j.bawu_member_xbazhu_tip);
                    this.aKV.setVisibility(0);
                } else if (zT.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aKV.setVisibility(8);
                }
            } else if (zT.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aKV.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aKV, e.f.brand_official_btn);
        al.h(this.aKV, e.d.cp_link_tip_a);
        this.aKV.setText(e.j.video_mcn);
        if (bbVar.AL()) {
            this.aKW.setVisibility(8);
        }
        this.aKV.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aKU != null && bbVar != null) {
            if (!StringUtils.isNull(this.aFJ.zT().getName_show())) {
                this.aKU.setText(gG(this.aFJ.zT().getName_show()));
            }
            FG();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aFJ.zT().getName_show();
                String userName = this.aFJ.zT().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    this.aKU.setText(com.baidu.tieba.pb.c.aC(this.mContext, this.aKU.getText().toString()));
                    this.aKU.setGravity(16);
                    this.aKU.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bhi());
                    al.c(this.aKU, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aKW != null) {
            if (this.aLh) {
                this.aKW.setVisibility(8);
            } else if (bbVar == null || bbVar.zT() == null || ((bbVar.avU > 0 && bbVar.avV == 0) || !this.aLd)) {
                this.aKW.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.zT().getIconInfo();
                if (v.H(iconInfo) != 0) {
                    this.aKW.setVisibility(0);
                    this.aKW.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    return;
                }
                this.aKW.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String M;
        if (this.aJB != null && bbVar != null) {
            if (bbVar.zM() <= 0) {
                this.aJB.setVisibility(4);
                return;
            }
            this.aJB.setVisibility(0);
            if (this.mFrom == 2) {
                M = ao.L(bbVar.zM());
            } else if (bbVar.AX()) {
                M = ao.M(bbVar.getCreateTime());
            } else if (bbVar.zY()) {
                M = ao.N(bbVar.zM() * 1000);
            } else {
                M = ao.M(bbVar.zM() * 1000);
            }
            this.aJB.setText(M);
        }
    }

    protected void r(bb bbVar) {
        if (this.aKZ == null || bbVar == null) {
            this.aKZ.setVisibility(8);
        } else if (this.aLh) {
            if (StringUtils.isNull(bbVar.As())) {
                this.aKZ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKZ.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aKZ.setLayoutParams(layoutParams);
            }
            this.aKZ.setText(bbVar.As());
            this.aKZ.setVisibility(0);
        } else if (this.aFJ.An() == null || this.aFJ.An().share_info == null || this.aFJ.An().share_info.share_user_count <= 0 || !this.aFJ.Ba() || (this.aFJ.avU > 0 && this.aFJ.avV == 0)) {
            this.aKZ.setVisibility(8);
        } else {
            this.aKZ.setVisibility(0);
            int i = this.aFJ.An().share_info.share_user_count;
            if (i == 1) {
                this.aKZ.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aKZ.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.S(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKX.setVisibility(8);
            this.aKY.setVisibility(8);
            return;
        }
        this.aKX.setText(this.aFJ.getAddress());
        this.aKX.setVisibility(0);
        this.aKY.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aKp.setVisibility(8);
            this.aLe.setVisibility(8);
            return;
        }
        String zZ = this.aFJ.zZ();
        if (this.mFrom == 3 || this.mFrom == 4) {
            zZ = null;
        } else if (this.mFrom == 5) {
            zZ = bbVar.Bw();
        }
        if (bbVar.Bv()) {
            zZ = bbVar.awf.ori_fname;
        }
        if (StringUtils.isNull(zZ)) {
            this.aKp.setVisibility(8);
            this.aLe.setVisibility(8);
            return;
        }
        if (this.aFJ.avU > 0 && this.aFJ.avV == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(zZ, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aKp.setText(str);
        this.aKp.setVisibility(0);
        this.aLe.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFJ);
            return;
        }
        this.aKp.setVisibility(8);
        this.aLe.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aKS != null && bbVar != null && this.aFJ.zT() != null) {
            if (this.aFJ.avU > 0 && this.aFJ.avV == 0) {
                this.aKS.setShowV(false);
            } else {
                this.aKS.setShowV(this.aFJ.zT().isBigV());
            }
        }
    }

    private void FG() {
        if (this.aFJ != null && this.aFJ.zT() != null) {
            if (this.aFJ.avU > 0 && this.aFJ.avV == 0) {
                al.h(this.aKU, e.d.cp_cont_f);
            } else if (!v.I(this.aFJ.zT().getTShowInfoNew()) || this.aFJ.zT().isBigV()) {
                al.h(this.aKU, e.d.cp_cont_h);
            } else {
                al.h(this.aKU, e.d.cp_cont_f);
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
        al.h(this.aKZ, e.d.cp_cont_f);
        al.h(this.aJB, e.d.cp_cont_d);
        al.j(this.aKY, e.d.cp_cont_e);
        al.h(this.aKX, e.d.cp_cont_d);
        al.h(this.aKp, e.d.cp_cont_d);
        al.j(this.aKY, e.d.cp_cont_e);
        al.j(this.aLe, e.d.cp_cont_e);
        n(this.aFJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.aLg = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aLg;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLf = onClickListener;
        if (this.aKS != null) {
            this.aKS.setAfterClickListener(this.aLf);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKS != null) {
            this.aKS.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKS;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKU;
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aLd;
    }

    public void setTShowVisible(boolean z) {
        this.aLd = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aLh = z;
    }
}

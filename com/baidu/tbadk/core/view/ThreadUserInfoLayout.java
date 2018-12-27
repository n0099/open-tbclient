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
    private bb aFg;
    private TextView aIY;
    private TextView aJM;
    private boolean aKA;
    private View aKB;
    private View.OnClickListener aKC;
    private boolean aKD;
    private boolean aKE;
    private View.OnClickListener aKF;
    private View.OnClickListener aKG;
    private View.OnClickListener aKH;
    public ClickableHeaderImageView aKp;
    private UserIconBox aKq;
    public TextView aKr;
    public TextView aKs;
    protected UserIconBox aKt;
    private TextView aKu;
    private View aKv;
    protected TextView aKw;
    private TextView aKx;
    private View aKy;
    private FrameLayout aKz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aKA = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getUserId()) && ThreadUserInfoLayout.this.aFg.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFg.AJ() != null && ThreadUserInfoLayout.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.AJ().channelId, ThreadUserInfoLayout.this.aFg.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.zG().getUserId(), ThreadUserInfoLayout.this.aFg.zG().getName_show(), ThreadUserInfoLayout.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFg.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKC != null) {
                        ThreadUserInfoLayout.this.aKC.onClick(view);
                    }
                }
            }
        };
        this.aKH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFg.zG().getUserId(), true, true, true);
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
        this.aKA = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getUserId()) && ThreadUserInfoLayout.this.aFg.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFg.AJ() != null && ThreadUserInfoLayout.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.AJ().channelId, ThreadUserInfoLayout.this.aFg.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.zG().getUserId(), ThreadUserInfoLayout.this.aFg.zG().getName_show(), ThreadUserInfoLayout.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFg.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKC != null) {
                        ThreadUserInfoLayout.this.aKC.onClick(view);
                    }
                }
            }
        };
        this.aKH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFg.zG().getUserId(), true, true, true);
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
        this.aKA = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFg.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFg.zG().getUserId()) && ThreadUserInfoLayout.this.aFg.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFg.AJ() != null && ThreadUserInfoLayout.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.AJ().channelId, ThreadUserInfoLayout.this.aFg.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFg.zG().getUserId(), ThreadUserInfoLayout.this.aFg.zG().getName_show(), ThreadUserInfoLayout.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFg.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKC != null) {
                        ThreadUserInfoLayout.this.aKC.onClick(view);
                    }
                }
            }
        };
        this.aKH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFg != null && ThreadUserInfoLayout.this.aFg.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFg.zG().getUserId(), true, true, true);
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
        this.aKp = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKq = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aKr = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aKs = (TextView) inflate.findViewById(e.g.identity_view);
        this.aKt = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aIY = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKu = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKv = inflate.findViewById(e.g.divider);
        this.aKB = findViewById(e.g.divider_forum_name);
        this.aJM = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aKw = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aKx = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aKz = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aKy = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 1);
        if (this.aKy != null) {
            this.aKy.setVisibility(8);
            this.aKz.addView(this.aKy);
        }
        setGravity(16);
        initHeaderImg();
        this.aKq.setOnClickListener(this.aKF);
        this.aKr.setOnClickListener(this.aKG);
        this.aKt.setOnClickListener(this.aKH);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFg = bbVar;
        if (this.aFg.avr > 0) {
            if (this.aFg.avs == 0 && this.aFg.zG() != null) {
                if (!v.I(this.aFg.zG().getTShowInfoNew())) {
                    this.aFg.zG().getTShowInfoNew().clear();
                }
                this.aFg.zG().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aKq.setOnClickListener(null);
            this.aKr.setOnClickListener(null);
            this.aKt.setOnClickListener(null);
            this.aKp.setClickable(false);
        } else {
            this.aKq.setOnClickListener(this.aKF);
            this.aKr.setOnClickListener(this.aKG);
            this.aKt.setOnClickListener(this.aKH);
            this.aKp.setClickable(true);
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
        if (this.aKp != null) {
            this.aKp.setDefaultResource(17170445);
            this.aKp.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKp.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKp.setIsRound(true);
            this.aKp.setAfterClickListener(this.aKC);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zG().getAlaUserData();
                if (this.aKy != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = alaUserData;
                    aVar.type = 1;
                    this.aKy.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aKy.setVisibility(8);
                    } else {
                        this.aKy.setVisibility(0);
                    }
                }
            } else if (this.aKy != null) {
                this.aKy.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aKx != null && bbVar != null && bbVar.zG() != null) {
            if (bbVar.zG().hadConcerned()) {
                this.aKx.setVisibility(0);
                al.h(this.aKx, e.d.cp_cont_d);
                al.i(this.aKx, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aKx.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aKq != null && bbVar != null && bbVar.zG() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.zG().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKq.setVisibility(0);
                this.aKq.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                return;
            }
            this.aKq.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aKs != null && bbVar != null && bbVar.zG() != null) {
            MetaData zG = bbVar.zG();
            if (zG.getIs_bawu() == 1) {
                int i = bbVar.avD ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.avD ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aKs, i);
                al.h(this.aKs, i2);
                if (bbVar.avD) {
                    this.aKs.setVisibility(0);
                    this.aKs.setText(e.j.brand_Official);
                } else if ("manager".equals(zG.getBawu_type())) {
                    this.aKs.setVisibility(0);
                    this.aKs.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(zG.getBawu_type())) {
                    this.aKs.setText(e.j.bawu_member_xbazhu_tip);
                    this.aKs.setVisibility(0);
                } else if (zG.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aKs.setVisibility(8);
                }
            } else if (zG.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aKs.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aKs, e.f.brand_official_btn);
        al.h(this.aKs, e.d.cp_link_tip_a);
        this.aKs.setText(e.j.video_mcn);
        if (bbVar.Ay()) {
            this.aKt.setVisibility(8);
        }
        this.aKs.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aKr != null && bbVar != null) {
            if (!StringUtils.isNull(this.aFg.zG().getName_show())) {
                this.aKr.setText(gt(this.aFg.zG().getName_show()));
            }
            Ft();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aFg.zG().getName_show();
                String userName = this.aFg.zG().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    this.aKr.setText(com.baidu.tieba.pb.c.aE(this.mContext, this.aKr.getText().toString()));
                    this.aKr.setGravity(16);
                    this.aKr.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bgE());
                    al.c(this.aKr, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aKt != null) {
            if (this.aKE) {
                this.aKt.setVisibility(8);
            } else if (bbVar == null || bbVar.zG() == null || ((bbVar.avr > 0 && bbVar.avs == 0) || !this.aKA)) {
                this.aKt.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.zG().getIconInfo();
                if (v.H(iconInfo) != 0) {
                    this.aKt.setVisibility(0);
                    this.aKt.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    return;
                }
                this.aKt.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String M;
        if (this.aIY != null && bbVar != null) {
            if (bbVar.zz() <= 0) {
                this.aIY.setVisibility(4);
                return;
            }
            this.aIY.setVisibility(0);
            if (this.mFrom == 2) {
                M = ao.L(bbVar.zz());
            } else if (bbVar.AK()) {
                M = ao.M(bbVar.getCreateTime());
            } else if (bbVar.zL()) {
                M = ao.N(bbVar.zz() * 1000);
            } else {
                M = ao.M(bbVar.zz() * 1000);
            }
            this.aIY.setText(M);
        }
    }

    protected void r(bb bbVar) {
        if (this.aKw == null || bbVar == null) {
            this.aKw.setVisibility(8);
        } else if (this.aKE) {
            if (StringUtils.isNull(bbVar.Af())) {
                this.aKw.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKw.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aKw.setLayoutParams(layoutParams);
            }
            this.aKw.setText(bbVar.Af());
            this.aKw.setVisibility(0);
        } else if (this.aFg.Aa() == null || this.aFg.Aa().share_info == null || this.aFg.Aa().share_info.share_user_count <= 0 || !this.aFg.AN() || (this.aFg.avr > 0 && this.aFg.avs == 0)) {
            this.aKw.setVisibility(8);
        } else {
            this.aKw.setVisibility(0);
            int i = this.aFg.Aa().share_info.share_user_count;
            if (i == 1) {
                this.aKw.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aKw.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.S(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKu.setVisibility(8);
            this.aKv.setVisibility(8);
            return;
        }
        this.aKu.setText(this.aFg.getAddress());
        this.aKu.setVisibility(0);
        this.aKv.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aJM.setVisibility(8);
            this.aKB.setVisibility(8);
            return;
        }
        String zM = this.aFg.zM();
        if (this.mFrom == 3 || this.mFrom == 4) {
            zM = null;
        } else if (this.mFrom == 5) {
            zM = bbVar.Bj();
        }
        if (bbVar.Bi()) {
            zM = bbVar.avC.ori_fname;
        }
        if (StringUtils.isNull(zM)) {
            this.aJM.setVisibility(8);
            this.aKB.setVisibility(8);
            return;
        }
        if (this.aFg.avr > 0 && this.aFg.avs == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(zM, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aJM.setText(str);
        this.aJM.setVisibility(0);
        this.aKB.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFg);
            return;
        }
        this.aJM.setVisibility(8);
        this.aKB.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aKp != null && bbVar != null && this.aFg.zG() != null) {
            if (this.aFg.avr > 0 && this.aFg.avs == 0) {
                this.aKp.setShowV(false);
            } else {
                this.aKp.setShowV(this.aFg.zG().isBigV());
            }
        }
    }

    private void Ft() {
        if (this.aFg != null && this.aFg.zG() != null) {
            if (this.aFg.avr > 0 && this.aFg.avs == 0) {
                al.h(this.aKr, e.d.cp_cont_f);
            } else if (!v.I(this.aFg.zG().getTShowInfoNew()) || this.aFg.zG().isBigV()) {
                al.h(this.aKr, e.d.cp_cont_h);
            } else {
                al.h(this.aKr, e.d.cp_cont_f);
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
        Ft();
        al.h(this.aKw, e.d.cp_cont_f);
        al.h(this.aIY, e.d.cp_cont_d);
        al.j(this.aKv, e.d.cp_cont_e);
        al.h(this.aKu, e.d.cp_cont_d);
        al.h(this.aJM, e.d.cp_cont_d);
        al.j(this.aKv, e.d.cp_cont_e);
        al.j(this.aKB, e.d.cp_cont_e);
        n(this.aFg);
    }

    public void setIsSimpleThread(boolean z) {
        this.aKD = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aKD;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKC = onClickListener;
        if (this.aKp != null) {
            this.aKp.setAfterClickListener(this.aKC);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKp != null) {
            this.aKp.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKp;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKr;
    }

    protected String gt(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aKA;
    }

    public void setTShowVisible(boolean z) {
        this.aKA = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aKE = z;
    }
}

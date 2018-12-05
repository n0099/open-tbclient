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
    private bb aFf;
    private TextView aIX;
    private TextView aJK;
    private View.OnClickListener aKA;
    private boolean aKB;
    private boolean aKC;
    private View.OnClickListener aKD;
    private View.OnClickListener aKE;
    private View.OnClickListener aKF;
    public ClickableHeaderImageView aKn;
    private UserIconBox aKo;
    public TextView aKp;
    public TextView aKq;
    protected UserIconBox aKr;
    private TextView aKs;
    private View aKt;
    protected TextView aKu;
    private TextView aKv;
    private View aKw;
    private FrameLayout aKx;
    private boolean aKy;
    private View aKz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aKy = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getUserId()) && ThreadUserInfoLayout.this.aFf.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFf.AJ() != null && ThreadUserInfoLayout.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.AJ().channelId, ThreadUserInfoLayout.this.aFf.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.zG().getUserId(), ThreadUserInfoLayout.this.aFf.zG().getName_show(), ThreadUserInfoLayout.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKA != null) {
                        ThreadUserInfoLayout.this.aKA.onClick(view);
                    }
                }
            }
        };
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFf.zG().getUserId(), true, true, true);
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
        this.aKy = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getUserId()) && ThreadUserInfoLayout.this.aFf.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFf.AJ() != null && ThreadUserInfoLayout.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.AJ().channelId, ThreadUserInfoLayout.this.aFf.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.zG().getUserId(), ThreadUserInfoLayout.this.aFf.zG().getName_show(), ThreadUserInfoLayout.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKA != null) {
                        ThreadUserInfoLayout.this.aKA.onClick(view);
                    }
                }
            }
        };
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFf.zG().getUserId(), true, true, true);
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
        this.aKy = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aKD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aFf.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aKE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aFf.zG().getUserId()) && ThreadUserInfoLayout.this.aFf.zM() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bJ(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aFf.AJ() != null && ThreadUserInfoLayout.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.AJ().channelId, ThreadUserInfoLayout.this.aFf.AJ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aFf.zG().getUserId(), ThreadUserInfoLayout.this.aFf.zG().getName_show(), ThreadUserInfoLayout.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aFf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aKA != null) {
                        ThreadUserInfoLayout.this.aKA.onClick(view);
                    }
                }
            }
        };
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aFf != null && ThreadUserInfoLayout.this.aFf.zG() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aFf.zG().getUserId(), true, true, true);
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
        this.aKn = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aKo = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aKp = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aKq = (TextView) inflate.findViewById(e.g.identity_view);
        this.aKr = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aIX = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKs = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aKt = inflate.findViewById(e.g.divider);
        this.aKz = findViewById(e.g.divider_forum_name);
        this.aJK = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aKu = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aKv = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aKx = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aKw = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 1);
        if (this.aKw != null) {
            this.aKw.setVisibility(8);
            this.aKx.addView(this.aKw);
        }
        setGravity(16);
        initHeaderImg();
        this.aKo.setOnClickListener(this.aKD);
        this.aKp.setOnClickListener(this.aKE);
        this.aKr.setOnClickListener(this.aKF);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFf = bbVar;
        if (this.aFf.avr > 0) {
            if (this.aFf.avs == 0 && this.aFf.zG() != null) {
                if (!v.I(this.aFf.zG().getTShowInfoNew())) {
                    this.aFf.zG().getTShowInfoNew().clear();
                }
                this.aFf.zG().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aKo.setOnClickListener(null);
            this.aKp.setOnClickListener(null);
            this.aKr.setOnClickListener(null);
            this.aKn.setClickable(false);
        } else {
            this.aKo.setOnClickListener(this.aKD);
            this.aKp.setOnClickListener(this.aKE);
            this.aKr.setOnClickListener(this.aKF);
            this.aKn.setClickable(true);
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
        if (this.aKn != null) {
            this.aKn.setDefaultResource(17170445);
            this.aKn.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aKn.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aKn.setIsRound(true);
            this.aKn.setAfterClickListener(this.aKA);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zG().getAlaUserData();
                if (this.aKw != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = alaUserData;
                    aVar.type = 1;
                    this.aKw.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aKw.setVisibility(8);
                    } else {
                        this.aKw.setVisibility(0);
                    }
                }
            } else if (this.aKw != null) {
                this.aKw.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aKv != null && bbVar != null && bbVar.zG() != null) {
            if (bbVar.zG().hadConcerned()) {
                this.aKv.setVisibility(0);
                al.h(this.aKv, e.d.cp_cont_d);
                al.i(this.aKv, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aKv.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aKo != null && bbVar != null && bbVar.zG() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.zG().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKo.setVisibility(0);
                this.aKo.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                return;
            }
            this.aKo.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aKq != null && bbVar != null && bbVar.zG() != null) {
            MetaData zG = bbVar.zG();
            if (zG.getIs_bawu() == 1) {
                int i = bbVar.avD ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.avD ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aKq, i);
                al.h(this.aKq, i2);
                if (bbVar.avD) {
                    this.aKq.setVisibility(0);
                    this.aKq.setText(e.j.brand_Official);
                } else if ("manager".equals(zG.getBawu_type())) {
                    this.aKq.setVisibility(0);
                    this.aKq.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(zG.getBawu_type())) {
                    this.aKq.setText(e.j.bawu_member_xbazhu_tip);
                    this.aKq.setVisibility(0);
                } else if (zG.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aKq.setVisibility(8);
                }
            } else if (zG.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aKq.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aKq, e.f.brand_official_btn);
        al.h(this.aKq, e.d.cp_link_tip_a);
        this.aKq.setText(e.j.video_mcn);
        if (bbVar.Ay()) {
            this.aKr.setVisibility(8);
        }
        this.aKq.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aKp != null && bbVar != null) {
            if (!StringUtils.isNull(this.aFf.zG().getName_show())) {
                this.aKp.setText(gr(this.aFf.zG().getName_show()));
            }
            Fs();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aFf.zG().getName_show();
                String userName = this.aFf.zG().getUserName();
                if (an.jJ() && name_show != null && !name_show.equals(userName)) {
                    this.aKp.setText(com.baidu.tieba.pb.c.aE(this.mContext, this.aKp.getText().toString()));
                    this.aKp.setGravity(16);
                    this.aKp.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bfT());
                    al.c(this.aKp, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aKr != null) {
            if (this.aKC) {
                this.aKr.setVisibility(8);
            } else if (bbVar == null || bbVar.zG() == null || ((bbVar.avr > 0 && bbVar.avs == 0) || !this.aKy)) {
                this.aKr.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.zG().getIconInfo();
                if (v.H(iconInfo) != 0) {
                    this.aKr.setVisibility(0);
                    this.aKr.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    return;
                }
                this.aKr.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String L;
        if (this.aIX != null && bbVar != null) {
            if (bbVar.zz() <= 0) {
                this.aIX.setVisibility(4);
                return;
            }
            this.aIX.setVisibility(0);
            if (this.mFrom == 2) {
                L = ao.K(bbVar.zz());
            } else if (bbVar.AK()) {
                L = ao.L(bbVar.getCreateTime());
            } else if (bbVar.zL()) {
                L = ao.M(bbVar.zz() * 1000);
            } else {
                L = ao.L(bbVar.zz() * 1000);
            }
            this.aIX.setText(L);
        }
    }

    protected void r(bb bbVar) {
        if (this.aKu == null || bbVar == null) {
            this.aKu.setVisibility(8);
        } else if (this.aKC) {
            if (StringUtils.isNull(bbVar.Af())) {
                this.aKu.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKu.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aKu.setLayoutParams(layoutParams);
            }
            this.aKu.setText(bbVar.Af());
            this.aKu.setVisibility(0);
        } else if (this.aFf.Aa() == null || this.aFf.Aa().share_info == null || this.aFf.Aa().share_info.share_user_count <= 0 || !this.aFf.AN() || (this.aFf.avr > 0 && this.aFf.avs == 0)) {
            this.aKu.setVisibility(8);
        } else {
            this.aKu.setVisibility(0);
            int i = this.aFf.Aa().share_info.share_user_count;
            if (i == 1) {
                this.aKu.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aKu.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.R(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aKs.setVisibility(8);
            this.aKt.setVisibility(8);
            return;
        }
        this.aKs.setText(this.aFf.getAddress());
        this.aKs.setVisibility(0);
        this.aKt.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aJK.setVisibility(8);
            this.aKz.setVisibility(8);
            return;
        }
        String zM = this.aFf.zM();
        if (this.mFrom == 3 || this.mFrom == 4) {
            zM = null;
        } else if (this.mFrom == 5) {
            zM = bbVar.Bj();
        }
        if (bbVar.Bi()) {
            zM = bbVar.avC.ori_fname;
        }
        if (StringUtils.isNull(zM)) {
            this.aJK.setVisibility(8);
            this.aKz.setVisibility(8);
            return;
        }
        if (this.aFf.avr > 0 && this.aFf.avs == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(zM, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aJK.setText(str);
        this.aJK.setVisibility(0);
        this.aKz.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aFf);
            return;
        }
        this.aJK.setVisibility(8);
        this.aKz.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aKn != null && bbVar != null && this.aFf.zG() != null) {
            if (this.aFf.avr > 0 && this.aFf.avs == 0) {
                this.aKn.setShowV(false);
            } else {
                this.aKn.setShowV(this.aFf.zG().isBigV());
            }
        }
    }

    private void Fs() {
        if (this.aFf != null && this.aFf.zG() != null) {
            if (this.aFf.avr > 0 && this.aFf.avs == 0) {
                al.h(this.aKp, e.d.cp_cont_f);
            } else if (!v.I(this.aFf.zG().getTShowInfoNew()) || this.aFf.zG().isBigV()) {
                al.h(this.aKp, e.d.cp_cont_h);
            } else {
                al.h(this.aKp, e.d.cp_cont_f);
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
        Fs();
        al.h(this.aKu, e.d.cp_cont_f);
        al.h(this.aIX, e.d.cp_cont_d);
        al.j(this.aKt, e.d.cp_cont_e);
        al.h(this.aKs, e.d.cp_cont_d);
        al.h(this.aJK, e.d.cp_cont_d);
        al.j(this.aKt, e.d.cp_cont_e);
        al.j(this.aKz, e.d.cp_cont_e);
        n(this.aFf);
    }

    public void setIsSimpleThread(boolean z) {
        this.aKB = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aKB;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKA = onClickListener;
        if (this.aKn != null) {
            this.aKn.setAfterClickListener(this.aKA);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aKn != null) {
            this.aKn.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aKn;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aKp;
    }

    protected String gr(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aKy;
    }

    public void setTShowVisible(boolean z) {
        this.aKy = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aKC = z;
    }
}

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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements f {
    private bb aAQ;
    private TextView aEH;
    public ClickableHeaderImageView aFX;
    private UserIconBox aFY;
    public TextView aFZ;
    private TextView aFu;
    public TextView aGa;
    protected UserIconBox aGb;
    private TextView aGc;
    private View aGd;
    protected TextView aGe;
    private TextView aGf;
    private View aGg;
    private FrameLayout aGh;
    private boolean aGi;
    private View aGj;
    private View.OnClickListener aGk;
    private boolean aGl;
    private boolean aGm;
    private View.OnClickListener aGn;
    private View.OnClickListener aGo;
    private View.OnClickListener aGp;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aGi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aGn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bI(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getUserId()) && ThreadUserInfoLayout.this.aAQ.yB() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bI(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aAQ.zy() != null && ThreadUserInfoLayout.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.zy().channelId, ThreadUserInfoLayout.this.aAQ.zy().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.yv().getUserId(), ThreadUserInfoLayout.this.aAQ.yv().getName_show(), ThreadUserInfoLayout.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aAQ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aGk != null) {
                        ThreadUserInfoLayout.this.aGk.onClick(view);
                    }
                }
            }
        };
        this.aGp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aAQ.yv().getUserId(), true, true, true);
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
        this.aGi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aGn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bI(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getUserId()) && ThreadUserInfoLayout.this.aAQ.yB() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bI(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aAQ.zy() != null && ThreadUserInfoLayout.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.zy().channelId, ThreadUserInfoLayout.this.aAQ.zy().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.yv().getUserId(), ThreadUserInfoLayout.this.aAQ.yv().getName_show(), ThreadUserInfoLayout.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aAQ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aGk != null) {
                        ThreadUserInfoLayout.this.aGk.onClick(view);
                    }
                }
            }
        };
        this.aGp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aAQ.yv().getUserId(), true, true, true);
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
        this.aGi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aGn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bI(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aAQ.yv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aAQ.yv().getUserId()) && ThreadUserInfoLayout.this.aAQ.yB() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bI(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aAQ.zy() != null && ThreadUserInfoLayout.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.zy().channelId, ThreadUserInfoLayout.this.aAQ.zy().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aAQ.yv().getUserId(), ThreadUserInfoLayout.this.aAQ.yv().getName_show(), ThreadUserInfoLayout.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aAQ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aGk != null) {
                        ThreadUserInfoLayout.this.aGk.onClick(view);
                    }
                }
            }
        };
        this.aGp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aAQ != null && ThreadUserInfoLayout.this.aAQ.yv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aAQ.yv().getUserId(), true, true, true);
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
        this.aFX = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aFY = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aFZ = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aGa = (TextView) inflate.findViewById(e.g.identity_view);
        this.aGb = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.aEH = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aGc = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aGd = inflate.findViewById(e.g.divider);
        this.aGj = findViewById(e.g.divider_forum_name);
        this.aFu = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aGe = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aGf = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aGh = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aGg = com.baidu.tbadk.ala.b.uL().j(this.mContext, 1);
        if (this.aGg != null) {
            this.aGg.setVisibility(8);
            this.aGh.addView(this.aGg);
        }
        setGravity(16);
        initHeaderImg();
        this.aFY.setOnClickListener(this.aGn);
        this.aFZ.setOnClickListener(this.aGo);
        this.aGb.setOnClickListener(this.aGp);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aAQ = bbVar;
        if (this.aAQ.are > 0) {
            if (this.aAQ.arf == 0 && this.aAQ.yv() != null) {
                if (!v.J(this.aAQ.yv().getTShowInfoNew())) {
                    this.aAQ.yv().getTShowInfoNew().clear();
                }
                this.aAQ.yv().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aFY.setOnClickListener(null);
            this.aFZ.setOnClickListener(null);
            this.aGb.setOnClickListener(null);
            this.aFX.setClickable(false);
        } else {
            this.aFY.setOnClickListener(this.aGn);
            this.aFZ.setOnClickListener(this.aGo);
            this.aGb.setOnClickListener(this.aGp);
            this.aFX.setClickable(true);
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
        if (this.aFX != null) {
            this.aFX.setDefaultResource(17170445);
            this.aFX.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aFX.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aFX.setIsRound(true);
            this.aFX.setAfterClickListener(this.aGk);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.yv() != null && bbVar.yv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.yv().getAlaUserData();
                if (this.aGg != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aht = alaUserData;
                    aVar.type = 1;
                    this.aGg.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aGg.setVisibility(8);
                    } else {
                        this.aGg.setVisibility(0);
                    }
                }
            } else if (this.aGg != null) {
                this.aGg.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aGf != null && bbVar != null && bbVar.yv() != null) {
            if (bbVar.yv().hadConcerned()) {
                this.aGf.setVisibility(0);
                al.h(this.aGf, e.d.cp_cont_d);
                al.i(this.aGf, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aGf.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aFY != null && bbVar != null && bbVar.yv() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.yv().getTShowInfoNew();
            if (v.I(tShowInfoNew) != 0) {
                this.aFY.setVisibility(0);
                this.aFY.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8), true);
                return;
            }
            this.aFY.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aGa != null && bbVar != null && bbVar.yv() != null) {
            MetaData yv = bbVar.yv();
            if (yv.getIs_bawu() == 1) {
                int i = bbVar.arq ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.arq ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aGa, i);
                al.h(this.aGa, i2);
                if (bbVar.arq) {
                    this.aGa.setVisibility(0);
                    this.aGa.setText(e.j.brand_Official);
                } else if ("manager".equals(yv.getBawu_type())) {
                    this.aGa.setVisibility(0);
                    this.aGa.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(yv.getBawu_type())) {
                    this.aGa.setText(e.j.bawu_member_xbazhu_tip);
                    this.aGa.setVisibility(0);
                } else if (yv.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aGa.setVisibility(8);
                }
            } else if (yv.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aGa.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aGa, e.f.brand_official_btn);
        al.h(this.aGa, e.d.cp_link_tip_a);
        this.aGa.setText(e.j.video_mcn);
        if (bbVar.zn()) {
            this.aGb.setVisibility(8);
        }
        this.aGa.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aFZ != null && bbVar != null) {
            if (!StringUtils.isNull(this.aAQ.yv().getName_show())) {
                this.aFZ.setText(fY(this.aAQ.yv().getName_show()));
            }
            Ee();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.aAQ.yv().getName_show();
                String userName = this.aAQ.yv().getUserName();
                if (com.baidu.tbadk.p.am.jL() && name_show != null && !name_show.equals(userName)) {
                    this.aFZ.setText(com.baidu.tieba.pb.c.aD(this.mContext, this.aFZ.getText().toString()));
                    this.aFZ.setGravity(16);
                    this.aFZ.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.beD());
                    al.c(this.aFZ, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aGb != null) {
            if (this.aGm) {
                this.aGb.setVisibility(8);
            } else if (bbVar == null || bbVar.yv() == null || ((bbVar.are > 0 && bbVar.arf == 0) || !this.aGi)) {
                this.aGb.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.yv().getIconInfo();
                if (v.I(iconInfo) != 0) {
                    this.aGb.setVisibility(0);
                    this.aGb.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8), true);
                    return;
                }
                this.aGb.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String C;
        if (this.aEH != null && bbVar != null) {
            if (bbVar.yo() <= 0) {
                this.aEH.setVisibility(4);
                return;
            }
            this.aEH.setVisibility(0);
            if (this.mFrom == 2) {
                C = ao.B(bbVar.yo());
            } else if (bbVar.zz()) {
                C = ao.C(bbVar.getCreateTime());
            } else if (bbVar.yA()) {
                C = ao.D(bbVar.yo() * 1000);
            } else {
                C = ao.C(bbVar.yo() * 1000);
            }
            this.aEH.setText(C);
        }
    }

    protected void r(bb bbVar) {
        if (this.aGe == null || bbVar == null) {
            this.aGe.setVisibility(8);
        } else if (this.aGm) {
            if (StringUtils.isNull(bbVar.yU())) {
                this.aGe.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aGe.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aGe.setLayoutParams(layoutParams);
            }
            this.aGe.setText(bbVar.yU());
            this.aGe.setVisibility(0);
        } else if (this.aAQ.yP() == null || this.aAQ.yP().share_info == null || this.aAQ.yP().share_info.share_user_count <= 0 || !this.aAQ.zC() || (this.aAQ.are > 0 && this.aAQ.arf == 0)) {
            this.aGe.setVisibility(8);
        } else {
            this.aGe.setVisibility(0);
            int i = this.aAQ.yP().share_info.share_user_count;
            if (i == 1) {
                this.aGe.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aGe.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.I(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aGc.setVisibility(8);
            this.aGd.setVisibility(8);
            return;
        }
        this.aGc.setText(this.aAQ.getAddress());
        this.aGc.setVisibility(0);
        this.aGd.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aFu.setVisibility(8);
            this.aGj.setVisibility(8);
            return;
        }
        String yB = this.aAQ.yB();
        if (this.mFrom == 3 || this.mFrom == 4) {
            yB = null;
        } else if (this.mFrom == 5) {
            yB = bbVar.zY();
        }
        if (bbVar.zX()) {
            yB = bbVar.arp.ori_fname;
        }
        if (StringUtils.isNull(yB)) {
            this.aFu.setVisibility(8);
            this.aGj.setVisibility(8);
            return;
        }
        if (this.aAQ.are > 0 && this.aAQ.arf == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(yB, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aFu.setText(str);
        this.aFu.setVisibility(0);
        this.aGj.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aAQ);
            return;
        }
        this.aFu.setVisibility(8);
        this.aGj.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aFX != null && bbVar != null && this.aAQ.yv() != null) {
            if (this.aAQ.are > 0 && this.aAQ.arf == 0) {
                this.aFX.setShowV(false);
            } else {
                this.aFX.setShowV(this.aAQ.yv().isBigV());
            }
        }
    }

    private void Ee() {
        if (this.aAQ != null && this.aAQ.yv() != null) {
            if (this.aAQ.are > 0 && this.aAQ.arf == 0) {
                al.h(this.aFZ, e.d.cp_cont_f);
            } else if (!v.J(this.aAQ.yv().getTShowInfoNew()) || this.aAQ.yv().isBigV()) {
                al.h(this.aFZ, e.d.cp_cont_h);
            } else {
                al.h(this.aFZ, e.d.cp_cont_f);
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
        Ee();
        al.h(this.aGe, e.d.cp_cont_f);
        al.h(this.aEH, e.d.cp_cont_d);
        al.j(this.aGd, e.d.cp_cont_e);
        al.h(this.aGc, e.d.cp_cont_d);
        al.h(this.aFu, e.d.cp_cont_d);
        al.j(this.aGd, e.d.cp_cont_e);
        al.j(this.aGj, e.d.cp_cont_e);
        n(this.aAQ);
    }

    public void setIsSimpleThread(boolean z) {
        this.aGl = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aGl;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aGk = onClickListener;
        if (this.aFX != null) {
            this.aFX.setAfterClickListener(this.aGk);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aFX != null) {
            this.aFX.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aFX;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aFZ;
    }

    protected String fY(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aGi;
    }

    public void setTShowVisible(boolean z) {
        this.aGi = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aGm = z;
    }
}

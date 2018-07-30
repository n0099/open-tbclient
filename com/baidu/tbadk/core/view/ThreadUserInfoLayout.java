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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements c {
    private bb atD;
    private TextView awP;
    public ClickableHeaderImageView axK;
    public TextView axL;
    private boolean axN;
    private View.OnClickListener axO;
    private View.OnClickListener axQ;
    private TextView axT;
    private TextView ayA;
    private View ayB;
    protected TextView ayC;
    private TextView ayD;
    private View ayE;
    private FrameLayout ayF;
    private boolean ayG;
    private View ayH;
    private boolean ayI;
    private View.OnClickListener ayJ;
    private View.OnClickListener ayK;
    private UserIconBox ayx;
    public TextView ayy;
    protected UserIconBox ayz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.ayG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getUserId()) && ThreadUserInfoLayout.this.atD.vq() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atD.wl() != null && ThreadUserInfoLayout.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.wl().channelId, ThreadUserInfoLayout.this.atD.wl().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.vk().getUserId(), ThreadUserInfoLayout.this.atD.vk().getName_show(), ThreadUserInfoLayout.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atD.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axO != null) {
                        ThreadUserInfoLayout.this.axO.onClick(view);
                    }
                }
            }
        };
        this.ayK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atD.vk().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getUserId()) && ThreadUserInfoLayout.this.atD.vq() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atD.wl() != null && ThreadUserInfoLayout.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.wl().channelId, ThreadUserInfoLayout.this.atD.wl().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.vk().getUserId(), ThreadUserInfoLayout.this.atD.vk().getName_show(), ThreadUserInfoLayout.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atD.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axO != null) {
                        ThreadUserInfoLayout.this.axO.onClick(view);
                    }
                }
            }
        };
        this.ayK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atD.vk().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayG = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aV(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atD.vk().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atD.vk().getUserId()) && ThreadUserInfoLayout.this.atD.vq() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aV(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atD.wl() != null && ThreadUserInfoLayout.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.wl().channelId, ThreadUserInfoLayout.this.atD.wl().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atD.vk().getUserId(), ThreadUserInfoLayout.this.atD.vk().getName_show(), ThreadUserInfoLayout.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atD.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axO != null) {
                        ThreadUserInfoLayout.this.axO.onClick(view);
                    }
                }
            }
        };
        this.ayK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atD != null && ThreadUserInfoLayout.this.atD.vk() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atD.vk().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.axK = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ayx = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.axL = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.ayy = (TextView) inflate.findViewById(d.g.identity_view);
        this.ayz = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.awP = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.ayA = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.ayB = inflate.findViewById(d.g.divider);
        this.ayH = findViewById(d.g.divider_forum_name);
        this.axT = (TextView) findViewById(d.g.thread_info_forum_name);
        this.ayC = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.ayD = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        this.ayF = (FrameLayout) inflate.findViewById(d.g.ala_live_info_content_layout);
        this.ayE = com.baidu.tbadk.ala.b.rx().g(this.mContext, 1);
        if (this.ayE != null) {
            this.ayE.setVisibility(8);
            this.ayF.addView(this.ayE);
        }
        setGravity(16);
        initHeaderImg();
        this.ayx.setOnClickListener(this.ayJ);
        this.axL.setOnClickListener(this.axQ);
        this.ayz.setOnClickListener(this.ayK);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atD = bbVar;
        if (this.atD.ajF > 0) {
            if (this.atD.ajG == 0 && this.atD.vk() != null) {
                if (!w.z(this.atD.vk().getTShowInfoNew())) {
                    this.atD.vk().getTShowInfoNew().clear();
                }
                this.atD.vk().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.ayx.setOnClickListener(null);
            this.axL.setOnClickListener(null);
            this.ayz.setOnClickListener(null);
            this.axK.setClickable(false);
        } else {
            this.ayx.setOnClickListener(this.ayJ);
            this.axL.setOnClickListener(this.axQ);
            this.ayz.setOnClickListener(this.ayK);
            this.axK.setClickable(true);
        }
        l(bbVar);
        o(bbVar);
        q(bbVar);
        p(bbVar);
        m(bbVar);
        e(bbVar);
        r(bbVar);
        s(bbVar);
        updateForumName(bbVar);
        setVisibility(0);
        k(bbVar);
        j(bbVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.axK != null) {
            this.axK.setDefaultResource(17170445);
            this.axK.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axK.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.axK.setIsRound(true);
            this.axK.setAfterClickListener(this.axO);
        }
    }

    private void j(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.vk() != null && bbVar.vk().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.vk().getAlaUserData();
                if (this.ayE != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZR = alaUserData;
                    aVar.type = 1;
                    this.ayE.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ayE.setVisibility(8);
                    } else {
                        this.ayE.setVisibility(0);
                    }
                }
            } else if (this.ayE != null) {
                this.ayE.setVisibility(8);
            }
        }
    }

    private void k(bb bbVar) {
        if (this.ayD != null && bbVar != null && bbVar.vk() != null) {
            if (bbVar.vk().hadConcerned()) {
                this.ayD.setVisibility(0);
                am.h(this.ayD, d.C0140d.cp_cont_d);
                am.i(this.ayD, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.ayD.setVisibility(8);
        }
    }

    private void l(bb bbVar) {
        if (this.ayx != null && bbVar != null && bbVar.vk() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.vk().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.ayx.setVisibility(0);
                this.ayx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ayx.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.ayy != null && bbVar != null && bbVar.vk() != null) {
            MetaData vk = bbVar.vk();
            if (vk.getIs_bawu() == 1) {
                int i = bbVar.ajR ? d.f.brand_official_btn : d.f.user_identity_btn;
                int i2 = bbVar.ajR ? d.C0140d.cp_link_tip_a : d.C0140d.cp_cont_j;
                am.i(this.ayy, i);
                am.h(this.ayy, i2);
                if (bbVar.ajR) {
                    this.ayy.setVisibility(0);
                    this.ayy.setText(d.j.brand_Official);
                } else if ("manager".equals(vk.getBawu_type())) {
                    this.ayy.setVisibility(0);
                    this.ayy.setText(d.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(vk.getBawu_type())) {
                    this.ayy.setText(d.j.bawu_member_xbazhu_tip);
                    this.ayy.setVisibility(0);
                } else if (vk.getIs_biggie()) {
                    n(bbVar);
                } else {
                    this.ayy.setVisibility(8);
                }
            } else if (vk.getIs_biggie()) {
                n(bbVar);
            } else {
                this.ayy.setVisibility(8);
            }
        }
    }

    private void n(bb bbVar) {
        am.i(this.ayy, d.f.brand_official_btn);
        am.h(this.ayy, d.C0140d.cp_link_tip_a);
        this.ayy.setText(d.j.video_mcn);
        if (bbVar.wa()) {
            this.ayz.setVisibility(8);
        }
        this.ayy.setVisibility(0);
    }

    private void o(bb bbVar) {
        if (this.axL != null && bbVar != null) {
            if (!StringUtils.isNull(this.atD.vk().getName_show())) {
                this.axL.setText(fp(this.atD.vk().getName_show()));
            }
            AQ();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.atD.vk().getName_show();
                String userName = this.atD.vk().getUserName();
                if (aj.iq() && name_show != null && !name_show.equals(userName)) {
                    this.axL.setText(com.baidu.tieba.pb.c.al(this.mContext, this.axL.getText().toString()));
                    this.axL.setGravity(16);
                    this.axL.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYV());
                    am.c(this.axL, d.C0140d.cp_other_e, 1);
                }
            }
        }
    }

    private void p(bb bbVar) {
        if (this.ayz != null) {
            if (this.ayI) {
                this.ayz.setVisibility(8);
            } else if (bbVar == null || bbVar.vk() == null || ((bbVar.ajF > 0 && bbVar.ajG == 0) || !this.ayG)) {
                this.ayz.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.vk().getIconInfo();
                if (w.y(iconInfo) != 0) {
                    this.ayz.setVisibility(0);
                    this.ayz.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.ayz.setVisibility(8);
            }
        }
    }

    private void e(bb bbVar) {
        String w;
        if (this.awP != null && bbVar != null) {
            if (bbVar.vd() <= 0) {
                this.awP.setVisibility(4);
                return;
            }
            this.awP.setVisibility(0);
            if (this.mFrom == 2) {
                w = ap.v(bbVar.vd());
            } else if (bbVar.wm()) {
                w = ap.w(bbVar.getCreateTime());
            } else if (bbVar.vp()) {
                w = ap.x(bbVar.vd() * 1000);
            } else {
                w = ap.w(bbVar.vd() * 1000);
            }
            this.awP.setText(w);
        }
    }

    protected void q(bb bbVar) {
        if (this.ayC == null || bbVar == null) {
            this.ayC.setVisibility(8);
        } else if (this.ayI) {
            if (StringUtils.isNull(bbVar.vI())) {
                this.ayC.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayC.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ayC.setLayoutParams(layoutParams);
            }
            this.ayC.setText(bbVar.vI());
            this.ayC.setVisibility(0);
        } else if (this.atD.vD() == null || this.atD.vD().share_info == null || this.atD.vD().share_info.share_user_count <= 0 || !this.atD.wp() || (this.atD.ajF > 0 && this.atD.ajG == 0)) {
            this.ayC.setVisibility(8);
        } else {
            this.ayC.setVisibility(0);
            int i = this.atD.vD().share_info.share_user_count;
            if (i == 1) {
                this.ayC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.ayC.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{ap.C(i)}));
            }
        }
    }

    private void r(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.ayA.setVisibility(8);
            this.ayB.setVisibility(8);
            return;
        }
        this.ayA.setText(this.atD.getAddress());
        this.ayA.setVisibility(0);
        this.ayB.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.axT.setVisibility(8);
            this.ayH.setVisibility(8);
            return;
        }
        String vq = this.atD.vq();
        if (this.mFrom == 3 || this.mFrom == 4) {
            vq = null;
        } else if (this.mFrom == 5) {
            vq = bbVar.wJ();
        }
        if (bbVar.wI()) {
            vq = bbVar.ajQ.ori_fname;
        }
        if (StringUtils.isNull(vq)) {
            this.axT.setVisibility(8);
            this.ayH.setVisibility(8);
            return;
        }
        if (this.atD.ajF > 0 && this.atD.ajG == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = ap.e(vq, 12, "...") + getResources().getString(d.j.forum);
        }
        this.axT.setText(str);
        this.axT.setVisibility(0);
        this.ayH.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atD);
            return;
        }
        this.axT.setVisibility(8);
        this.ayH.setVisibility(8);
    }

    private void s(bb bbVar) {
        if (this.axK != null && bbVar != null && this.atD.vk() != null) {
            if (this.atD.ajF > 0 && this.atD.ajG == 0) {
                this.axK.setShowV(false);
            } else {
                this.axK.setShowV(this.atD.vk().isBigV());
            }
        }
    }

    private void AQ() {
        if (this.atD != null && this.atD.vk() != null) {
            if (this.atD.ajF > 0 && this.atD.ajG == 0) {
                am.h(this.axL, d.C0140d.cp_cont_f);
            } else if (!w.z(this.atD.vk().getTShowInfoNew()) || this.atD.vk().isBigV()) {
                am.h(this.axL, d.C0140d.cp_cont_h);
            } else {
                am.h(this.axL, d.C0140d.cp_cont_f);
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
        AQ();
        am.h(this.ayC, d.C0140d.cp_cont_f);
        am.h(this.awP, d.C0140d.cp_cont_d);
        am.j(this.ayB, d.C0140d.cp_cont_e);
        am.h(this.ayA, d.C0140d.cp_cont_d);
        am.h(this.axT, d.C0140d.cp_cont_d);
        am.j(this.ayB, d.C0140d.cp_cont_e);
        am.j(this.ayH, d.C0140d.cp_cont_e);
        m(this.atD);
    }

    public void setIsSimpleThread(boolean z) {
        this.axN = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.axN;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axO = onClickListener;
        if (this.axK != null) {
            this.axK.setAfterClickListener(this.axO);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axK != null) {
            this.axK.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.axK;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.axL;
    }

    protected String fp(String str) {
        return ap.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.ayG;
    }

    public void setTShowVisible(boolean z) {
        this.ayG = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayI = z;
    }
}

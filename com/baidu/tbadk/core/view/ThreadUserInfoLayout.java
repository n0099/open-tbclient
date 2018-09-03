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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.aj;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements c {
    private bb atE;
    private TextView awM;
    public ClickableHeaderImageView axH;
    public TextView axI;
    private boolean axK;
    private View.OnClickListener axL;
    private View.OnClickListener axN;
    private TextView axQ;
    private TextView ayA;
    private View ayB;
    private FrameLayout ayC;
    private boolean ayD;
    private View ayE;
    private boolean ayF;
    private View.OnClickListener ayG;
    private View.OnClickListener ayH;
    private UserIconBox ayu;
    public TextView ayv;
    protected UserIconBox ayw;
    private TextView ayx;
    private View ayy;
    protected TextView ayz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.ayD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getUserId()) && ThreadUserInfoLayout.this.atE.vp() != null) {
                    if (view.getTag(f.g.tag_nick_name_activity) != null && (view.getTag(f.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(f.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atE.wk() != null && ThreadUserInfoLayout.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.wk().channelId, ThreadUserInfoLayout.this.atE.wk().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.vj().getUserId(), ThreadUserInfoLayout.this.atE.vj().getName_show(), ThreadUserInfoLayout.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atE.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axL != null) {
                        ThreadUserInfoLayout.this.axL.onClick(view);
                    }
                }
            }
        };
        this.ayH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atE.vj().getUserId(), true, true, true);
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
        this.ayD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getUserId()) && ThreadUserInfoLayout.this.atE.vp() != null) {
                    if (view.getTag(f.g.tag_nick_name_activity) != null && (view.getTag(f.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(f.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atE.wk() != null && ThreadUserInfoLayout.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.wk().channelId, ThreadUserInfoLayout.this.atE.wk().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.vj().getUserId(), ThreadUserInfoLayout.this.atE.vj().getName_show(), ThreadUserInfoLayout.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atE.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axL != null) {
                        ThreadUserInfoLayout.this.axL.onClick(view);
                    }
                }
            }
        };
        this.ayH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atE.vj().getUserId(), true, true, true);
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
        this.ayD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atE.vj().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atE.vj().getUserId()) && ThreadUserInfoLayout.this.atE.vp() != null) {
                    if (view.getTag(f.g.tag_nick_name_activity) != null && (view.getTag(f.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(f.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atE.wk() != null && ThreadUserInfoLayout.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.wk().channelId, ThreadUserInfoLayout.this.atE.wk().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atE.vj().getUserId(), ThreadUserInfoLayout.this.atE.vj().getName_show(), ThreadUserInfoLayout.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atE.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axL != null) {
                        ThreadUserInfoLayout.this.axL.onClick(view);
                    }
                }
            }
        };
        this.ayH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atE != null && ThreadUserInfoLayout.this.atE.vj() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atE.vj().getUserId(), true, true, true);
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
        View inflate = LayoutInflater.from(context).inflate(f.h.thread_user_info_layout, (ViewGroup) this, true);
        this.axH = (ClickableHeaderImageView) inflate.findViewById(f.g.card_home_page_normal_thread_user_header);
        this.ayu = (UserIconBox) inflate.findViewById(f.g.card_home_page_normal_thread_tshow_icon);
        this.axI = (TextView) inflate.findViewById(f.g.card_home_page_normal_thread_user_name);
        this.ayv = (TextView) inflate.findViewById(f.g.identity_view);
        this.ayw = (UserIconBox) inflate.findViewById(f.g.card_home_page_normal_thread_user_icon);
        this.awM = (TextView) inflate.findViewById(f.g.thread_info_reply_time);
        this.ayx = (TextView) inflate.findViewById(f.g.thread_info_address);
        this.ayy = inflate.findViewById(f.g.divider);
        this.ayE = findViewById(f.g.divider_forum_name);
        this.axQ = (TextView) findViewById(f.g.thread_info_forum_name);
        this.ayz = (TextView) inflate.findViewById(f.g.card_home_page_normal_thread_share_intro);
        this.ayA = (TextView) inflate.findViewById(f.g.thread_user_info_has_concern_lable);
        this.ayC = (FrameLayout) inflate.findViewById(f.g.ala_live_info_content_layout);
        this.ayB = com.baidu.tbadk.ala.b.rv().g(this.mContext, 1);
        if (this.ayB != null) {
            this.ayB.setVisibility(8);
            this.ayC.addView(this.ayB);
        }
        setGravity(16);
        initHeaderImg();
        this.ayu.setOnClickListener(this.ayG);
        this.axI.setOnClickListener(this.axN);
        this.ayw.setOnClickListener(this.ayH);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atE = bbVar;
        if (this.atE.ajF > 0) {
            if (this.atE.ajG == 0 && this.atE.vj() != null) {
                if (!w.z(this.atE.vj().getTShowInfoNew())) {
                    this.atE.vj().getTShowInfoNew().clear();
                }
                this.atE.vj().setName_show(getContext().getString(f.j.perfect_selection_video));
            }
            this.ayu.setOnClickListener(null);
            this.axI.setOnClickListener(null);
            this.ayw.setOnClickListener(null);
            this.axH.setClickable(false);
        } else {
            this.ayu.setOnClickListener(this.ayG);
            this.axI.setOnClickListener(this.axN);
            this.ayw.setOnClickListener(this.ayH);
            this.axH.setClickable(true);
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
        if (this.axH != null) {
            this.axH.setDefaultResource(17170445);
            this.axH.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.axH.setDefaultBgResource(f.d.cp_bg_line_e);
            this.axH.setIsRound(true);
            this.axH.setAfterClickListener(this.axL);
        }
    }

    private void j(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.vj() != null && bbVar.vj().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.vj().getAlaUserData();
                if (this.ayB != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZS = alaUserData;
                    aVar.type = 1;
                    this.ayB.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ayB.setVisibility(8);
                    } else {
                        this.ayB.setVisibility(0);
                    }
                }
            } else if (this.ayB != null) {
                this.ayB.setVisibility(8);
            }
        }
    }

    private void k(bb bbVar) {
        if (this.ayA != null && bbVar != null && bbVar.vj() != null) {
            if (bbVar.vj().hadConcerned()) {
                this.ayA.setVisibility(0);
                am.h(this.ayA, f.d.cp_cont_d);
                am.i(this.ayA, f.C0146f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.ayA.setVisibility(8);
        }
    }

    private void l(bb bbVar) {
        if (this.ayu != null && bbVar != null && bbVar.vj() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.vj().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.ayu.setVisibility(0);
                this.ayu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(f.e.tbds48), this.mContext.getResources().getDimensionPixelSize(f.e.tbds48), this.mContext.getResources().getDimensionPixelSize(f.e.ds8), true);
                return;
            }
            this.ayu.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.ayv != null && bbVar != null && bbVar.vj() != null) {
            MetaData vj = bbVar.vj();
            if (vj.getIs_bawu() == 1) {
                int i = bbVar.ajR ? f.C0146f.brand_official_btn : f.C0146f.user_identity_btn;
                int i2 = bbVar.ajR ? f.d.cp_link_tip_a : f.d.cp_cont_j;
                am.i(this.ayv, i);
                am.h(this.ayv, i2);
                if (bbVar.ajR) {
                    this.ayv.setVisibility(0);
                    this.ayv.setText(f.j.brand_Official);
                } else if ("manager".equals(vj.getBawu_type())) {
                    this.ayv.setVisibility(0);
                    this.ayv.setText(f.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(vj.getBawu_type())) {
                    this.ayv.setText(f.j.bawu_member_xbazhu_tip);
                    this.ayv.setVisibility(0);
                } else if (vj.getIs_biggie()) {
                    n(bbVar);
                } else {
                    this.ayv.setVisibility(8);
                }
            } else if (vj.getIs_biggie()) {
                n(bbVar);
            } else {
                this.ayv.setVisibility(8);
            }
        }
    }

    private void n(bb bbVar) {
        am.i(this.ayv, f.C0146f.brand_official_btn);
        am.h(this.ayv, f.d.cp_link_tip_a);
        this.ayv.setText(f.j.video_mcn);
        if (bbVar.vZ()) {
            this.ayw.setVisibility(8);
        }
        this.ayv.setVisibility(0);
    }

    private void o(bb bbVar) {
        if (this.axI != null && bbVar != null) {
            if (!StringUtils.isNull(this.atE.vj().getName_show())) {
                this.axI.setText(fp(this.atE.vj().getName_show()));
            }
            AN();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.atE.vj().getName_show();
                String userName = this.atE.vj().getUserName();
                if (aj.iq() && name_show != null && !name_show.equals(userName)) {
                    this.axI.setText(com.baidu.tieba.pb.c.al(this.mContext, this.axI.getText().toString()));
                    this.axI.setGravity(16);
                    this.axI.setTag(f.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYQ());
                    am.c(this.axI, f.d.cp_other_e, 1);
                }
            }
        }
    }

    private void p(bb bbVar) {
        if (this.ayw != null) {
            if (this.ayF) {
                this.ayw.setVisibility(8);
            } else if (bbVar == null || bbVar.vj() == null || ((bbVar.ajF > 0 && bbVar.ajG == 0) || !this.ayD)) {
                this.ayw.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.vj().getIconInfo();
                if (w.y(iconInfo) != 0) {
                    this.ayw.setVisibility(0);
                    this.ayw.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(f.e.tbds40), this.mContext.getResources().getDimensionPixelSize(f.e.tbds40), this.mContext.getResources().getDimensionPixelSize(f.e.ds8), true);
                    return;
                }
                this.ayw.setVisibility(8);
            }
        }
    }

    private void e(bb bbVar) {
        String w;
        if (this.awM != null && bbVar != null) {
            if (bbVar.vc() <= 0) {
                this.awM.setVisibility(4);
                return;
            }
            this.awM.setVisibility(0);
            if (this.mFrom == 2) {
                w = ap.v(bbVar.vc());
            } else if (bbVar.wl()) {
                w = ap.w(bbVar.getCreateTime());
            } else if (bbVar.vo()) {
                w = ap.x(bbVar.vc() * 1000);
            } else {
                w = ap.w(bbVar.vc() * 1000);
            }
            this.awM.setText(w);
        }
    }

    protected void q(bb bbVar) {
        if (this.ayz == null || bbVar == null) {
            this.ayz.setVisibility(8);
        } else if (this.ayF) {
            if (StringUtils.isNull(bbVar.vH())) {
                this.ayz.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayz.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ayz.setLayoutParams(layoutParams);
            }
            this.ayz.setText(bbVar.vH());
            this.ayz.setVisibility(0);
        } else if (this.atE.vC() == null || this.atE.vC().share_info == null || this.atE.vC().share_info.share_user_count <= 0 || !this.atE.wo() || (this.atE.ajF > 0 && this.atE.ajG == 0)) {
            this.ayz.setVisibility(8);
        } else {
            this.ayz.setVisibility(0);
            int i = this.atE.vC().share_info.share_user_count;
            if (i == 1) {
                this.ayz.setText(TbadkCoreApplication.getInst().getString(f.j.ala_live_share_live_label_simple));
            } else {
                this.ayz.setText(TbadkCoreApplication.getInst().getString(f.j.ala_live_share_live_label, new Object[]{ap.C(i)}));
            }
        }
    }

    private void r(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.ayx.setVisibility(8);
            this.ayy.setVisibility(8);
            return;
        }
        this.ayx.setText(this.atE.getAddress());
        this.ayx.setVisibility(0);
        this.ayy.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.axQ.setVisibility(8);
            this.ayE.setVisibility(8);
            return;
        }
        String vp = this.atE.vp();
        if (this.mFrom == 3 || this.mFrom == 4) {
            vp = null;
        } else if (this.mFrom == 5) {
            vp = bbVar.wI();
        }
        if (bbVar.wH()) {
            vp = bbVar.ajQ.ori_fname;
        }
        if (StringUtils.isNull(vp)) {
            this.axQ.setVisibility(8);
            this.ayE.setVisibility(8);
            return;
        }
        if (this.atE.ajF > 0 && this.atE.ajG == 0) {
            str = getContext().getString(f.j.select_video_list);
        } else {
            str = ap.d(vp, 12, "...") + getResources().getString(f.j.forum);
        }
        this.axQ.setText(str);
        this.axQ.setVisibility(0);
        this.ayE.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atE);
            return;
        }
        this.axQ.setVisibility(8);
        this.ayE.setVisibility(8);
    }

    private void s(bb bbVar) {
        if (this.axH != null && bbVar != null && this.atE.vj() != null) {
            if (this.atE.ajF > 0 && this.atE.ajG == 0) {
                this.axH.setShowV(false);
            } else {
                this.axH.setShowV(this.atE.vj().isBigV());
            }
        }
    }

    private void AN() {
        if (this.atE != null && this.atE.vj() != null) {
            if (this.atE.ajF > 0 && this.atE.ajG == 0) {
                am.h(this.axI, f.d.cp_cont_f);
            } else if (!w.z(this.atE.vj().getTShowInfoNew()) || this.atE.vj().isBigV()) {
                am.h(this.axI, f.d.cp_cont_h);
            } else {
                am.h(this.axI, f.d.cp_cont_f);
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
        AN();
        am.h(this.ayz, f.d.cp_cont_f);
        am.h(this.awM, f.d.cp_cont_d);
        am.j(this.ayy, f.d.cp_cont_e);
        am.h(this.ayx, f.d.cp_cont_d);
        am.h(this.axQ, f.d.cp_cont_d);
        am.j(this.ayy, f.d.cp_cont_e);
        am.j(this.ayE, f.d.cp_cont_e);
        m(this.atE);
    }

    public void setIsSimpleThread(boolean z) {
        this.axK = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.axK;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axL = onClickListener;
        if (this.axH != null) {
            this.axH.setAfterClickListener(this.axL);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axH != null) {
            this.axH.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.axH;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.axI;
    }

    protected String fp(String str) {
        return ap.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.ayD;
    }

    public void setTShowVisible(boolean z) {
        this.ayD = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayF = z;
    }
}

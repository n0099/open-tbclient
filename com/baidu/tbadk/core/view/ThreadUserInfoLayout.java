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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements c {
    private bc atZ;
    private TextView axj;
    private UserIconBox ayK;
    public TextView ayL;
    protected UserIconBox ayM;
    private TextView ayN;
    private View ayO;
    protected TextView ayP;
    private TextView ayQ;
    private View ayR;
    private FrameLayout ayS;
    private boolean ayT;
    private View ayU;
    private TextView ayV;
    private boolean ayW;
    private View.OnClickListener ayX;
    private View.OnClickListener ayY;
    public ClickableHeaderImageView aye;
    public TextView ayf;
    private boolean ayh;
    private View.OnClickListener ayi;
    private View.OnClickListener ayk;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.ayT = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getUserId()) && ThreadUserInfoLayout.this.atZ.vB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atZ.ww() != null && ThreadUserInfoLayout.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.ww().channelId, ThreadUserInfoLayout.this.atZ.ww().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.vw().getUserId(), ThreadUserInfoLayout.this.atZ.vw().getName_show(), ThreadUserInfoLayout.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atZ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ayi != null) {
                        ThreadUserInfoLayout.this.ayi.onClick(view);
                    }
                }
            }
        };
        this.ayY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atZ.vw().getUserId(), true, true, true);
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
        this.ayT = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getUserId()) && ThreadUserInfoLayout.this.atZ.vB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atZ.ww() != null && ThreadUserInfoLayout.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.ww().channelId, ThreadUserInfoLayout.this.atZ.ww().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.vw().getUserId(), ThreadUserInfoLayout.this.atZ.vw().getName_show(), ThreadUserInfoLayout.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atZ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ayi != null) {
                        ThreadUserInfoLayout.this.ayi.onClick(view);
                    }
                }
            }
        };
        this.ayY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atZ.vw().getUserId(), true, true, true);
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
        this.ayT = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ayX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bb.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew() != null && w.d(ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atZ.vw().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atZ.vw().getUserId()) && ThreadUserInfoLayout.this.atZ.vB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bb.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atZ.ww() != null && ThreadUserInfoLayout.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.ww().channelId, ThreadUserInfoLayout.this.atZ.ww().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atZ.vw().getUserId(), ThreadUserInfoLayout.this.atZ.vw().getName_show(), ThreadUserInfoLayout.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atZ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.ayi != null) {
                        ThreadUserInfoLayout.this.ayi.onClick(view);
                    }
                }
            }
        };
        this.ayY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atZ != null && ThreadUserInfoLayout.this.atZ.vw() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atZ.vw().getUserId(), true, true, true);
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
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_user_info_layout, (ViewGroup) this, true);
        this.aye = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ayK = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.ayf = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.ayL = (TextView) inflate.findViewById(d.g.identity_view);
        this.ayM = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.axj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.ayN = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.ayO = inflate.findViewById(d.g.divider);
        this.ayU = findViewById(d.g.divider_forum_name);
        this.ayV = (TextView) findViewById(d.g.thread_info_forum_name);
        this.ayP = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.ayQ = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        this.ayS = (FrameLayout) inflate.findViewById(d.g.ala_live_info_content_layout);
        this.ayR = com.baidu.tbadk.ala.b.rM().f(this.mContext, 1);
        if (this.ayR != null) {
            this.ayR.setVisibility(8);
            this.ayS.addView(this.ayR);
        }
        setGravity(16);
        initHeaderImg();
        this.ayK.setOnClickListener(this.ayX);
        this.ayf.setOnClickListener(this.ayk);
        this.ayM.setOnClickListener(this.ayY);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bc bcVar) {
        if (bcVar == null) {
            setVisibility(8);
            return false;
        }
        this.atZ = bcVar;
        if (this.atZ.aki > 0) {
            if (this.atZ.akj == 0 && this.atZ.vw() != null) {
                if (!w.A(this.atZ.vw().getTShowInfoNew())) {
                    this.atZ.vw().getTShowInfoNew().clear();
                }
                this.atZ.vw().setName_show(getContext().getString(d.k.perfect_selection_video));
            }
            this.ayK.setOnClickListener(null);
            this.ayf.setOnClickListener(null);
            this.ayM.setOnClickListener(null);
            this.aye.setClickable(false);
        } else {
            this.ayK.setOnClickListener(this.ayX);
            this.ayf.setOnClickListener(this.ayk);
            this.ayM.setOnClickListener(this.ayY);
            this.aye.setClickable(true);
        }
        k(bcVar);
        m(bcVar);
        o(bcVar);
        l(bcVar);
        n(bcVar);
        e(bcVar);
        p(bcVar);
        q(bcVar);
        updateForumName(bcVar);
        setVisibility(0);
        j(bcVar);
        i(bcVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.aye != null) {
            this.aye.setDefaultResource(17170445);
            this.aye.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.aye.setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.aye.setIsRound(true);
            this.aye.setAfterClickListener(this.ayi);
        }
    }

    private void i(bc bcVar) {
        if (this.mFrom == 3) {
            if (bcVar != null && bcVar.vw() != null && bcVar.vw().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bcVar.vw().getAlaUserData();
                if (this.ayR != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aan = alaUserData;
                    aVar.type = 1;
                    this.ayR.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.ayR.setVisibility(8);
                    } else {
                        this.ayR.setVisibility(0);
                    }
                }
            } else if (this.ayR != null) {
                this.ayR.setVisibility(8);
            }
        }
    }

    private void j(bc bcVar) {
        if (this.ayQ != null && bcVar != null && bcVar.vw() != null) {
            if (bcVar.vw().hadConcerned()) {
                this.ayQ.setVisibility(0);
                am.h(this.ayQ, d.C0142d.cp_cont_d);
                am.i(this.ayQ, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.ayQ.setVisibility(8);
        }
    }

    private void k(bc bcVar) {
        if (this.ayK != null && bcVar != null && bcVar.vw() != null) {
            ArrayList<IconData> tShowInfoNew = bcVar.vw().getTShowInfoNew();
            if (w.z(tShowInfoNew) != 0) {
                this.ayK.setVisibility(0);
                this.ayK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ayK.setVisibility(8);
        }
    }

    private void l(bc bcVar) {
        if (this.ayL != null && bcVar != null && bcVar.vw() != null) {
            MetaData vw = bcVar.vw();
            if (vw.getIs_bawu() == 1) {
                int i = bcVar.aku ? d.f.brand_official_btn : d.f.user_identity_btn;
                int i2 = bcVar.aku ? d.C0142d.cp_link_tip_a : d.C0142d.cp_cont_j;
                am.i(this.ayL, i);
                am.h(this.ayL, i2);
                if (bcVar.aku) {
                    this.ayL.setVisibility(0);
                    this.ayL.setText(d.k.brand_Official);
                    return;
                } else if ("manager".equals(vw.getBawu_type())) {
                    this.ayL.setVisibility(0);
                    this.ayL.setText(d.k.bawu_member_bazhu_tip);
                    return;
                } else if ("assist".equals(vw.getBawu_type())) {
                    this.ayL.setText(d.k.bawu_member_xbazhu_tip);
                    this.ayL.setVisibility(0);
                    return;
                } else {
                    this.ayL.setVisibility(8);
                    return;
                }
            }
            this.ayL.setVisibility(8);
        }
    }

    private void m(bc bcVar) {
        if (this.ayf != null && bcVar != null) {
            if (!StringUtils.isNull(this.atZ.vw().getName_show())) {
                this.ayf.setText(fs(this.atZ.vw().getName_show()));
            }
            AZ();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.atZ.vw().getName_show();
                String userName = this.atZ.vw().getUserName();
                if (ai.ip() && name_show != null && !name_show.equals(userName)) {
                    this.ayf.setText(com.baidu.tieba.pb.c.aj(this.mContext, this.ayf.getText().toString()));
                    this.ayf.setGravity(16);
                    this.ayf.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baD());
                    am.c(this.ayf, d.C0142d.cp_other_e, 1);
                }
            }
        }
    }

    private void n(bc bcVar) {
        if (this.ayM != null) {
            if (this.ayW) {
                this.ayM.setVisibility(8);
            } else if (bcVar == null || bcVar.vw() == null || ((bcVar.aki > 0 && bcVar.akj == 0) || !this.ayT)) {
                this.ayM.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bcVar.vw().getIconInfo();
                if (w.z(iconInfo) != 0) {
                    this.ayM.setVisibility(0);
                    this.ayM.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.ayM.setVisibility(8);
            }
        }
    }

    private void e(bc bcVar) {
        String w;
        if (this.axj != null && bcVar != null) {
            if (bcVar.vp() <= 0) {
                this.axj.setVisibility(4);
                return;
            }
            this.axj.setVisibility(0);
            if (this.mFrom == 2) {
                w = ap.v(bcVar.vp());
            } else if (bcVar.wx()) {
                w = ap.w(bcVar.getCreateTime());
            } else {
                w = ap.w(bcVar.vp() * 1000);
            }
            this.axj.setText(w);
        }
    }

    protected void o(bc bcVar) {
        if (this.ayP == null || bcVar == null) {
            this.ayP.setVisibility(8);
        } else if (this.ayW) {
            if (StringUtils.isNull(bcVar.vT())) {
                this.ayP.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ayP.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ayP.setLayoutParams(layoutParams);
            }
            this.ayP.setText(bcVar.vT());
            this.ayP.setVisibility(0);
        } else if (this.atZ.vO() == null || this.atZ.vO().share_info == null || this.atZ.vO().share_info.share_user_count <= 0 || !this.atZ.wA() || (this.atZ.aki > 0 && this.atZ.akj == 0)) {
            this.ayP.setVisibility(8);
        } else {
            this.ayP.setVisibility(0);
            int i = this.atZ.vO().share_info.share_user_count;
            if (i == 1) {
                this.ayP.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label_simple));
            } else {
                this.ayP.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label, new Object[]{ap.B(i)}));
            }
        }
    }

    private void p(bc bcVar) {
        if (bcVar == null || StringUtils.isNull(bcVar.getAddress())) {
            this.ayN.setVisibility(8);
            this.ayO.setVisibility(8);
            return;
        }
        this.ayN.setText(this.atZ.getAddress());
        this.ayN.setVisibility(0);
        this.ayO.setVisibility(0);
    }

    public void updateForumName(bc bcVar) {
        String str;
        if (bcVar == null) {
            this.ayV.setVisibility(8);
            this.ayU.setVisibility(8);
            return;
        }
        String vB = this.atZ.vB();
        if (this.mFrom == 3 || this.mFrom == 4) {
            vB = null;
        } else if (this.mFrom == 5) {
            vB = bcVar.wU();
        }
        if (bcVar.wT()) {
            vB = bcVar.akt.ori_fname;
        }
        if (StringUtils.isNull(vB)) {
            this.ayV.setVisibility(8);
            this.ayU.setVisibility(8);
            return;
        }
        if (this.atZ.aki > 0 && this.atZ.akj == 0) {
            str = getContext().getString(d.k.select_video_list);
        } else {
            str = ap.e(vB, 12, "...") + getResources().getString(d.k.forum);
        }
        this.ayV.setText(str);
        this.ayV.setVisibility(0);
        this.ayU.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atZ);
            return;
        }
        this.ayV.setVisibility(8);
        this.ayU.setVisibility(8);
    }

    private void q(bc bcVar) {
        if (this.aye != null && bcVar != null && this.atZ.vw() != null) {
            if (this.atZ.aki > 0 && this.atZ.akj == 0) {
                this.aye.setShowV(false);
            } else {
                this.aye.setShowV(this.atZ.vw().isBigV());
            }
        }
    }

    private void AZ() {
        if (this.atZ != null && this.atZ.vw() != null) {
            if (this.atZ.aki > 0 && this.atZ.akj == 0) {
                am.h(this.ayf, d.C0142d.cp_cont_f);
            } else if (!w.A(this.atZ.vw().getTShowInfoNew()) || this.atZ.vw().isBigV()) {
                am.h(this.ayf, d.C0142d.cp_cont_h);
            } else {
                am.h(this.ayf, d.C0142d.cp_cont_f);
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
        AZ();
        am.h(this.ayP, d.C0142d.cp_cont_f);
        am.h(this.axj, d.C0142d.cp_cont_d);
        am.j(this.ayO, d.C0142d.cp_cont_e);
        am.h(this.ayN, d.C0142d.cp_cont_d);
        am.h(this.ayV, d.C0142d.cp_cont_d);
        am.j(this.ayO, d.C0142d.cp_cont_e);
        am.j(this.ayU, d.C0142d.cp_cont_e);
        l(this.atZ);
    }

    public void setIsSimpleThread(boolean z) {
        this.ayh = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.ayh;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ayi = onClickListener;
        if (this.aye != null) {
            this.aye.setAfterClickListener(this.ayi);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aye != null) {
            this.aye.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.aye;
    }

    @Override // com.baidu.tbadk.core.view.c
    public TextView getUserName() {
        return this.ayf;
    }

    protected String fs(String str) {
        return ap.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.ayT;
    }

    public void setTShowVisible(boolean z) {
        this.ayT = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayW = z;
    }
}

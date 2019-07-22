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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements d {
    private bg We;
    public TextView XL;
    public TextView XM;
    protected UserIconBox XN;
    private UserIconBox XO;
    protected TextView XQ;
    private View XS;
    private FrameLayout XT;
    private View.OnClickListener XU;
    private View.OnClickListener XZ;
    private View.OnClickListener Ya;
    private View.OnClickListener Yb;
    private TextView caZ;
    private TextView cbW;
    private TextView ccF;
    private View ccG;
    private TextView ccH;
    private boolean ccI;
    private View ccJ;
    private boolean ccK;
    private boolean ccL;
    public ClickableHeaderImageView cch;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.ccI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && ThreadUserInfoLayout.this.We.aex().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aex().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aex().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getUserId()) && ThreadUserInfoLayout.this.We.aeC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afH() != null && ThreadUserInfoLayout.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afH().channelId, ThreadUserInfoLayout.this.We.afH().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aex().getUserId(), ThreadUserInfoLayout.this.We.aex().getName_show(), ThreadUserInfoLayout.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.We.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XU != null) {
                        ThreadUserInfoLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aex().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && ThreadUserInfoLayout.this.We.aex().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aex().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aex().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getUserId()) && ThreadUserInfoLayout.this.We.aeC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afH() != null && ThreadUserInfoLayout.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afH().channelId, ThreadUserInfoLayout.this.We.afH().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aex().getUserId(), ThreadUserInfoLayout.this.We.aex().getName_show(), ThreadUserInfoLayout.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.We.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XU != null) {
                        ThreadUserInfoLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aex().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && ThreadUserInfoLayout.this.We.aex().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aex().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aex().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aex().getUserId()) && ThreadUserInfoLayout.this.We.aeC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afH() != null && ThreadUserInfoLayout.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afH().channelId, ThreadUserInfoLayout.this.We.afH().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aex().getUserId(), ThreadUserInfoLayout.this.We.aex().getName_show(), ThreadUserInfoLayout.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.We.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XU != null) {
                        ThreadUserInfoLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aex() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aex().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.cch = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.XO = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.XL = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.XM = (TextView) inflate.findViewById(R.id.identity_view);
        this.XN = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.caZ = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.ccF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.ccG = inflate.findViewById(R.id.divider);
        this.ccJ = findViewById(R.id.divider_forum_name);
        this.cbW = (TextView) findViewById(R.id.thread_info_forum_name);
        this.XQ = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.ccH = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.XT = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.XS = com.baidu.tbadk.ala.b.aak().n(this.mContext, 1);
        if (this.XS != null) {
            this.XS.setVisibility(8);
            this.XT.addView(this.XS);
        }
        setGravity(16);
        initHeaderImg();
        this.XO.setOnClickListener(this.XZ);
        this.XL.setOnClickListener(this.Ya);
        this.XN.setOnClickListener(this.Yb);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bgVar;
        if (this.We.bLO > 0) {
            if (this.We.bLP == 0 && this.We.aex() != null) {
                if (!v.aa(this.We.aex().getTShowInfoNew())) {
                    this.We.aex().getTShowInfoNew().clear();
                }
                this.We.aex().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.XO.setOnClickListener(null);
            this.XL.setOnClickListener(null);
            this.XN.setOnClickListener(null);
            this.cch.setClickable(false);
        } else {
            this.XO.setOnClickListener(this.XZ);
            this.XL.setOnClickListener(this.Ya);
            this.XN.setOnClickListener(this.Yb);
            this.cch.setClickable(true);
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
        if (this.cch != null) {
            this.cch.setDefaultResource(17170445);
            this.cch.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cch.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.cch.setIsRound(true);
            this.cch.setAfterClickListener(this.XU);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.aex() != null && bgVar.aex().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.aex().getAlaUserData();
                if (this.XS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bAN = alaUserData;
                    aVar.type = 1;
                    this.XS.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.XS.setVisibility(8);
                    } else {
                        this.XS.setVisibility(0);
                    }
                }
            } else if (this.XS != null) {
                this.XS.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.ccH != null && bgVar != null && bgVar.aex() != null) {
            if (bgVar.aex().hadConcerned()) {
                this.ccH.setVisibility(0);
                am.j(this.ccH, R.color.cp_cont_d);
                am.k(this.ccH, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.ccH.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.XO != null && bgVar != null && bgVar.aex() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.aex().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XO.setVisibility(0);
                this.XO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.XO.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.XM != null && bgVar != null && bgVar.aex() != null) {
            MetaData aex = bgVar.aex();
            if (aex.getIs_bawu() == 1) {
                int i = bgVar.bMb ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bgVar.bMb ? R.color.cp_btn_a : R.color.cp_cont_j;
                am.k(this.XM, i);
                am.j(this.XM, i2);
                if (bgVar.bMb) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.brand_Official);
                } else if ("manager".equals(aex.getBawu_type())) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_member_xbazhu_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_content_assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_content_assist_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_manage_assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_manage_assist_tip);
                    this.XM.setVisibility(0);
                } else if (aex.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.XM.setVisibility(8);
                }
            } else if (aex.getIs_biggie()) {
                k(bgVar);
            } else {
                this.XM.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        am.k(this.XM, R.drawable.brand_official_btn);
        am.j(this.XM, R.color.cp_link_tip_a);
        this.XM.setText(R.string.video_mcn);
        if (bgVar.afx()) {
            this.XN.setVisibility(8);
        }
        this.XM.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.XL != null && bgVar != null) {
            if (!StringUtils.isNull(this.We.aex().getName_show())) {
                this.XL.setText(oT(this.We.aex().getName_show()));
            }
            qY();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.We.aex().getName_show();
                String userName = this.We.aex().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    this.XL.setText(com.baidu.tieba.pb.c.aE(this.mContext, this.XL.getText().toString()));
                    this.XL.setGravity(16);
                    this.XL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSg());
                    am.f(this.XL, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.XN != null) {
            if (this.ccL) {
                this.XN.setVisibility(8);
            } else if (bgVar == null || bgVar.aex() == null || ((bgVar.bLO > 0 && bgVar.bLP == 0) || !this.ccI)) {
                this.XN.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.aex().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.XN.setVisibility(0);
                    this.XN.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.XN.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String aD;
        if (this.caZ != null && bgVar != null) {
            if (bgVar.aeq() <= 0) {
                this.caZ.setVisibility(4);
                return;
            }
            this.caZ.setVisibility(0);
            if (this.mFrom == 2) {
                aD = aq.aC(bgVar.aeq());
            } else if (bgVar.afI()) {
                aD = aq.aD(bgVar.getCreateTime());
            } else if (bgVar.aeB()) {
                aD = aq.aE(bgVar.aeq() * 1000);
            } else {
                aD = aq.aD(bgVar.aeq() * 1000);
            }
            this.caZ.setText(aD);
        }
    }

    protected void g(bg bgVar) {
        if (this.XQ == null || bgVar == null) {
            this.XQ.setVisibility(8);
        } else if (this.ccL) {
            if (StringUtils.isNull(bgVar.acy())) {
                this.XQ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XQ.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.XQ.setLayoutParams(layoutParams);
            }
            this.XQ.setText(bgVar.acy());
            this.XQ.setVisibility(0);
        } else if (this.We.aeQ() == null || this.We.aeQ().share_info == null || this.We.aeQ().share_info.share_user_count <= 0 || !this.We.afL() || (this.We.bLO > 0 && this.We.bLP == 0)) {
            this.XQ.setVisibility(8);
        } else {
            this.XQ.setVisibility(0);
            int i = this.We.aeQ().share_info.share_user_count;
            if (i == 1) {
                this.XQ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.XQ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.aI(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.ccF.setVisibility(8);
            this.ccG.setVisibility(8);
            return;
        }
        this.ccF.setText(this.We.getAddress());
        this.ccF.setVisibility(0);
        this.ccG.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.cbW.setVisibility(8);
            this.ccJ.setVisibility(8);
            return;
        }
        String aeC = this.We.aeC();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aeC = null;
        } else if (this.mFrom == 5) {
            aeC = bgVar.agi();
        }
        if (bgVar.agh()) {
            aeC = bgVar.bMa.ori_fname;
        }
        if (StringUtils.isNull(aeC)) {
            this.cbW.setVisibility(8);
            this.ccJ.setVisibility(8);
            return;
        }
        if (this.We.bLO > 0 && this.We.bLP == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.j(aeC, 12, "...") + getResources().getString(R.string.forum);
        }
        this.cbW.setText(str);
        this.cbW.setVisibility(0);
        this.ccJ.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void en(boolean z) {
        if (z) {
            B(this.We);
            return;
        }
        this.cbW.setVisibility(8);
        this.ccJ.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.cch != null && bgVar != null && this.We.aex() != null) {
            if (this.We.bLO > 0 && this.We.bLP == 0) {
                this.cch.setShowV(false);
            } else {
                this.cch.setShowV(this.We.aex().isBigV());
            }
        }
    }

    private void qY() {
        if (this.We != null && this.We.aex() != null) {
            if (this.We.bLO > 0 && this.We.bLP == 0) {
                am.j(this.XL, R.color.cp_cont_f);
            } else if (!v.aa(this.We.aex().getTShowInfoNew()) || this.We.aex().isBigV()) {
                am.j(this.XL, R.color.cp_cont_h);
            } else {
                am.j(this.XL, R.color.cp_cont_f);
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
        qY();
        am.j(this.XQ, R.color.cp_cont_f);
        am.j(this.caZ, R.color.cp_cont_d);
        am.l(this.ccG, R.color.cp_cont_e);
        am.j(this.ccF, R.color.cp_cont_d);
        am.j(this.cbW, R.color.cp_cont_d);
        am.l(this.ccG, R.color.cp_cont_e);
        am.l(this.ccJ, R.color.cp_cont_e);
        j(this.We);
    }

    public void setIsSimpleThread(boolean z) {
        this.ccK = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.ccK;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cch != null) {
            this.cch.setAfterClickListener(this.XU);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cch != null) {
            this.cch.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cch;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.XL;
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.ccI = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ccL = z;
    }
}

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
import com.baidu.tbadk.core.data.bh;
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
    private bh We;
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
    private TextView cbg;
    private TextView ccM;
    private View ccN;
    private TextView ccO;
    private boolean ccP;
    private View ccQ;
    private boolean ccR;
    private boolean ccS;
    private TextView ccd;
    public ClickableHeaderImageView cco;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.ccP = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && ThreadUserInfoLayout.this.We.aey().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aey().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aey().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getUserId()) && ThreadUserInfoLayout.this.We.aeD() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afI() != null && ThreadUserInfoLayout.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afI().channelId, ThreadUserInfoLayout.this.We.afI().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aey().getUserId(), ThreadUserInfoLayout.this.We.aey().getName_show(), ThreadUserInfoLayout.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aey().getUserId(), true, true, true);
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
        this.ccP = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && ThreadUserInfoLayout.this.We.aey().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aey().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aey().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getUserId()) && ThreadUserInfoLayout.this.We.aeD() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afI() != null && ThreadUserInfoLayout.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afI().channelId, ThreadUserInfoLayout.this.We.afI().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aey().getUserId(), ThreadUserInfoLayout.this.We.aey().getName_show(), ThreadUserInfoLayout.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aey().getUserId(), true, true, true);
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
        this.ccP = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && ThreadUserInfoLayout.this.We.aey().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.We.aey().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.We.aey().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.We.aey().getUserId()) && ThreadUserInfoLayout.this.We.aeD() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.We.afI() != null && ThreadUserInfoLayout.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.afI().channelId, ThreadUserInfoLayout.this.We.afI().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.We.aey().getUserId(), ThreadUserInfoLayout.this.We.aey().getName_show(), ThreadUserInfoLayout.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.We != null && ThreadUserInfoLayout.this.We.aey() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.We.aey().getUserId(), true, true, true);
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
        this.cco = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.XO = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.XL = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.XM = (TextView) inflate.findViewById(R.id.identity_view);
        this.XN = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.cbg = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.ccM = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.ccN = inflate.findViewById(R.id.divider);
        this.ccQ = findViewById(R.id.divider_forum_name);
        this.ccd = (TextView) findViewById(R.id.thread_info_forum_name);
        this.XQ = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.ccO = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
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
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bhVar;
        if (this.We.bLT > 0) {
            if (this.We.bLU == 0 && this.We.aey() != null) {
                if (!v.aa(this.We.aey().getTShowInfoNew())) {
                    this.We.aey().getTShowInfoNew().clear();
                }
                this.We.aey().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.XO.setOnClickListener(null);
            this.XL.setOnClickListener(null);
            this.XN.setOnClickListener(null);
            this.cco.setClickable(false);
        } else {
            this.XO.setOnClickListener(this.XZ);
            this.XL.setOnClickListener(this.Ya);
            this.XN.setOnClickListener(this.Yb);
            this.cco.setClickable(true);
        }
        i(bhVar);
        f(bhVar);
        g(bhVar);
        h(bhVar);
        j(bhVar);
        w(bhVar);
        B(bhVar);
        c(bhVar);
        C(bhVar);
        setVisibility(0);
        A(bhVar);
        e(bhVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.cco != null) {
            this.cco.setDefaultResource(17170445);
            this.cco.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cco.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
            this.cco.setIsRound(true);
            this.cco.setAfterClickListener(this.XU);
        }
    }

    private void e(bh bhVar) {
        if (this.mFrom == 3) {
            if (bhVar != null && bhVar.aey() != null && bhVar.aey().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aey().getAlaUserData();
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

    private void A(bh bhVar) {
        if (this.ccO != null && bhVar != null && bhVar.aey() != null) {
            if (bhVar.aey().hadConcerned()) {
                this.ccO.setVisibility(0);
                am.j(this.ccO, R.color.cp_cont_d);
                am.k(this.ccO, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.ccO.setVisibility(8);
        }
    }

    private void i(bh bhVar) {
        if (this.XO != null && bhVar != null && bhVar.aey() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.aey().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XO.setVisibility(0);
                this.XO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.XO.setVisibility(8);
        }
    }

    private void j(bh bhVar) {
        if (this.XM != null && bhVar != null && bhVar.aey() != null) {
            MetaData aey = bhVar.aey();
            if (aey.getIs_bawu() == 1) {
                int i = bhVar.bMg ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bhVar.bMg ? R.color.cp_btn_a : R.color.cp_cont_j;
                am.k(this.XM, i);
                am.j(this.XM, i2);
                if (bhVar.bMg) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.brand_Official);
                } else if ("manager".equals(aey.getBawu_type())) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(aey.getBawu_type())) {
                    this.XM.setText(R.string.bawu_member_xbazhu_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_content_assist".equals(aey.getBawu_type())) {
                    this.XM.setText(R.string.bawu_content_assist_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_manage_assist".equals(aey.getBawu_type())) {
                    this.XM.setText(R.string.bawu_manage_assist_tip);
                    this.XM.setVisibility(0);
                } else if (aey.getIs_biggie()) {
                    k(bhVar);
                } else {
                    this.XM.setVisibility(8);
                }
            } else if (aey.getIs_biggie()) {
                k(bhVar);
            } else {
                this.XM.setVisibility(8);
            }
        }
    }

    private void k(bh bhVar) {
        am.k(this.XM, R.drawable.brand_official_btn);
        am.j(this.XM, R.color.cp_link_tip_a);
        this.XM.setText(R.string.video_mcn);
        if (bhVar.afy()) {
            this.XN.setVisibility(8);
        }
        this.XM.setVisibility(0);
    }

    private void f(bh bhVar) {
        if (this.XL != null && bhVar != null) {
            if (!StringUtils.isNull(this.We.aey().getName_show())) {
                this.XL.setText(oT(this.We.aey().getName_show()));
            }
            qY();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.We.aey().getName_show();
                String userName = this.We.aey().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    this.XL.setText(com.baidu.tieba.pb.c.aE(this.mContext, this.XL.getText().toString()));
                    this.XL.setGravity(16);
                    this.XL.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bSu());
                    am.f(this.XL, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bh bhVar) {
        if (this.XN != null) {
            if (this.ccS) {
                this.XN.setVisibility(8);
            } else if (bhVar == null || bhVar.aey() == null || ((bhVar.bLT > 0 && bhVar.bLU == 0) || !this.ccP)) {
                this.XN.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aey().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.XN.setVisibility(0);
                    this.XN.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.XN.setVisibility(8);
            }
        }
    }

    private void w(bh bhVar) {
        String aD;
        if (this.cbg != null && bhVar != null) {
            if (bhVar.aer() <= 0) {
                this.cbg.setVisibility(4);
                return;
            }
            this.cbg.setVisibility(0);
            if (this.mFrom == 2) {
                aD = aq.aC(bhVar.aer());
            } else if (bhVar.afJ()) {
                aD = aq.aD(bhVar.getCreateTime());
            } else if (bhVar.aeC()) {
                aD = aq.aE(bhVar.aer() * 1000);
            } else {
                aD = aq.aD(bhVar.aer() * 1000);
            }
            this.cbg.setText(aD);
        }
    }

    protected void g(bh bhVar) {
        if (this.XQ == null || bhVar == null) {
            this.XQ.setVisibility(8);
        } else if (this.ccS) {
            if (StringUtils.isNull(bhVar.acz())) {
                this.XQ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XQ.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.XQ.setLayoutParams(layoutParams);
            }
            this.XQ.setText(bhVar.acz());
            this.XQ.setVisibility(0);
        } else if (this.We.aeR() == null || this.We.aeR().share_info == null || this.We.aeR().share_info.share_user_count <= 0 || !this.We.afM() || (this.We.bLT > 0 && this.We.bLU == 0)) {
            this.XQ.setVisibility(8);
        } else {
            this.XQ.setVisibility(0);
            int i = this.We.aeR().share_info.share_user_count;
            if (i == 1) {
                this.XQ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.XQ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.aI(i)}));
            }
        }
    }

    private void B(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.ccM.setVisibility(8);
            this.ccN.setVisibility(8);
            return;
        }
        this.ccM.setText(this.We.getAddress());
        this.ccM.setVisibility(0);
        this.ccN.setVisibility(0);
    }

    public void C(bh bhVar) {
        String str;
        if (bhVar == null) {
            this.ccd.setVisibility(8);
            this.ccQ.setVisibility(8);
            return;
        }
        String aeD = this.We.aeD();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aeD = null;
        } else if (this.mFrom == 5) {
            aeD = bhVar.agj();
        }
        if (bhVar.agi()) {
            aeD = bhVar.bMf.ori_fname;
        }
        if (StringUtils.isNull(aeD)) {
            this.ccd.setVisibility(8);
            this.ccQ.setVisibility(8);
            return;
        }
        if (this.We.bLT > 0 && this.We.bLU == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.j(aeD, 12, "...") + getResources().getString(R.string.forum);
        }
        this.ccd.setText(str);
        this.ccd.setVisibility(0);
        this.ccQ.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void en(boolean z) {
        if (z) {
            C(this.We);
            return;
        }
        this.ccd.setVisibility(8);
        this.ccQ.setVisibility(8);
    }

    private void c(bh bhVar) {
        if (this.cco != null && bhVar != null && this.We.aey() != null) {
            if (this.We.bLT > 0 && this.We.bLU == 0) {
                this.cco.setShowV(false);
            } else {
                this.cco.setShowV(this.We.aey().isBigV());
            }
        }
    }

    private void qY() {
        if (this.We != null && this.We.aey() != null) {
            if (this.We.bLT > 0 && this.We.bLU == 0) {
                am.j(this.XL, R.color.cp_cont_f);
            } else if (!v.aa(this.We.aey().getTShowInfoNew()) || this.We.aey().isBigV()) {
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
        am.j(this.cbg, R.color.cp_cont_d);
        am.l(this.ccN, R.color.cp_cont_e);
        am.j(this.ccM, R.color.cp_cont_d);
        am.j(this.ccd, R.color.cp_cont_d);
        am.l(this.ccN, R.color.cp_cont_e);
        am.l(this.ccQ, R.color.cp_cont_e);
        j(this.We);
    }

    public void setIsSimpleThread(boolean z) {
        this.ccR = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.ccR;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cco != null) {
            this.cco.setAfterClickListener(this.XU);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cco != null) {
            this.cco.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cco;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.XL;
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.ccP = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ccS = z;
    }
}

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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements d {
    private bh Wd;
    public TextView XK;
    public TextView XL;
    protected UserIconBox XM;
    private UserIconBox XN;
    protected TextView XP;
    private View XS;
    private FrameLayout XT;
    private View.OnClickListener XU;
    private View.OnClickListener XZ;
    private View.OnClickListener Ya;
    private View.OnClickListener Yb;
    private TextView cbZ;
    private TextView ccX;
    private TextView cdF;
    private View cdG;
    private TextView cdH;
    private boolean cdI;
    private View cdJ;
    private boolean cdK;
    private boolean cdL;
    public ClickableHeaderImageView cdi;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.cdI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getUserId()) && ThreadUserInfoLayout.this.Wd.aeH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Wd.afM() != null && ThreadUserInfoLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.afM().channelId, ThreadUserInfoLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.aeC().getUserId(), ThreadUserInfoLayout.this.Wd.aeC().getName_show(), ThreadUserInfoLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Wd.getTid());
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
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.Wd.aeC().getUserId(), true, true, true);
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
        this.cdI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getUserId()) && ThreadUserInfoLayout.this.Wd.aeH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Wd.afM() != null && ThreadUserInfoLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.afM().channelId, ThreadUserInfoLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.aeC().getUserId(), ThreadUserInfoLayout.this.Wd.aeC().getName_show(), ThreadUserInfoLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Wd.getTid());
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
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.Wd.aeC().getUserId(), true, true, true);
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
        this.cdI = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Wd.aeC().getUserId()) && ThreadUserInfoLayout.this.Wd.aeH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cF(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Wd.afM() != null && ThreadUserInfoLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.afM().channelId, ThreadUserInfoLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Wd.aeC().getUserId(), ThreadUserInfoLayout.this.Wd.aeC().getName_show(), ThreadUserInfoLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Wd.getTid());
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
                if (ThreadUserInfoLayout.this.Wd != null && ThreadUserInfoLayout.this.Wd.aeC() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.Wd.aeC().getUserId(), true, true, true);
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
        this.cdi = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.XN = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.XK = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.XL = (TextView) inflate.findViewById(R.id.identity_view);
        this.XM = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.cbZ = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.cdF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cdG = inflate.findViewById(R.id.divider);
        this.cdJ = findViewById(R.id.divider_forum_name);
        this.ccX = (TextView) findViewById(R.id.thread_info_forum_name);
        this.XP = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.cdH = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.XT = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.XS = com.baidu.tbadk.ala.b.aao().n(this.mContext, 1);
        if (this.XS != null) {
            this.XS.setVisibility(8);
            this.XT.addView(this.XS);
        }
        setGravity(16);
        initHeaderImg();
        this.XN.setOnClickListener(this.XZ);
        this.XK.setOnClickListener(this.Ya);
        this.XM.setOnClickListener(this.Yb);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Wd = bhVar;
        if (this.Wd.bMr > 0) {
            if (this.Wd.bMs == 0 && this.Wd.aeC() != null) {
                if (!v.aa(this.Wd.aeC().getTShowInfoNew())) {
                    this.Wd.aeC().getTShowInfoNew().clear();
                }
                this.Wd.aeC().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.XN.setOnClickListener(null);
            this.XK.setOnClickListener(null);
            this.XM.setOnClickListener(null);
            this.cdi.setClickable(false);
        } else {
            this.XN.setOnClickListener(this.XZ);
            this.XK.setOnClickListener(this.Ya);
            this.XM.setOnClickListener(this.Yb);
            this.cdi.setClickable(true);
        }
        j(bhVar);
        g(bhVar);
        h(bhVar);
        i(bhVar);
        k(bhVar);
        x(bhVar);
        C(bhVar);
        c(bhVar);
        D(bhVar);
        setVisibility(0);
        B(bhVar);
        f(bhVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.cdi != null) {
            this.cdi.setDefaultResource(17170445);
            this.cdi.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cdi.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.cdi.setIsRound(true);
            this.cdi.setAfterClickListener(this.XU);
        }
    }

    private void f(bh bhVar) {
        if (this.mFrom == 3) {
            if (bhVar != null && bhVar.aeC() != null && bhVar.aeC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aeC().getAlaUserData();
                if (this.XS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bBl = alaUserData;
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

    private void B(bh bhVar) {
        if (this.cdH != null && bhVar != null && bhVar.aeC() != null) {
            if (bhVar.aeC().hadConcerned()) {
                this.cdH.setVisibility(0);
                am.j(this.cdH, R.color.cp_cont_d);
                am.k(this.cdH, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.cdH.setVisibility(8);
        }
    }

    private void j(bh bhVar) {
        if (this.XN != null && bhVar != null && bhVar.aeC() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.aeC().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XN.setVisibility(0);
                this.XN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.XN.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.XL != null && bhVar != null && bhVar.aeC() != null) {
            MetaData aeC = bhVar.aeC();
            if (aeC.getIs_bawu() == 1) {
                int i = bhVar.bME ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bhVar.bME ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.k(this.XL, i);
                am.j(this.XL, i2);
                if (bhVar.bME) {
                    this.XL.setVisibility(0);
                    this.XL.setText(R.string.brand_Official);
                } else if ("manager".equals(aeC.getBawu_type())) {
                    this.XL.setVisibility(0);
                    this.XL.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_member_xbazhu_tip);
                    this.XL.setVisibility(0);
                } else if ("pri_content_assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_content_assist_tip);
                    this.XL.setVisibility(0);
                } else if ("pri_manage_assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_manage_assist_tip);
                    this.XL.setVisibility(0);
                } else if (aeC.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.XL.setVisibility(8);
                }
            } else if (aeC.getIs_biggie()) {
                l(bhVar);
            } else {
                this.XL.setVisibility(8);
            }
        }
    }

    private void l(bh bhVar) {
        am.k(this.XL, R.drawable.brand_official_btn);
        am.j(this.XL, R.color.cp_link_tip_a);
        this.XL.setText(R.string.video_mcn);
        if (bhVar.afC()) {
            this.XM.setVisibility(8);
        }
        this.XL.setVisibility(0);
    }

    private void g(bh bhVar) {
        if (this.XK != null && bhVar != null) {
            if (!StringUtils.isNull(this.Wd.aeC().getName_show())) {
                this.XK.setText(pb(this.Wd.aeC().getName_show()));
            }
            qZ();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.Wd.aeC().getName_show();
                String userName = this.Wd.aeC().getUserName();
                if (as.iN() && name_show != null && !name_show.equals(userName)) {
                    this.XK.setText(com.baidu.tieba.pb.c.aL(this.mContext, this.XK.getText().toString()));
                    this.XK.setGravity(16);
                    this.XK.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bTh());
                    am.f(this.XK, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void i(bh bhVar) {
        if (this.XM != null) {
            if (this.cdL) {
                this.XM.setVisibility(8);
            } else if (bhVar == null || bhVar.aeC() == null || ((bhVar.bMr > 0 && bhVar.bMs == 0) || !this.cdI)) {
                this.XM.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aeC().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.XM.setVisibility(0);
                    this.XM.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.XM.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String aD;
        if (this.cbZ != null && bhVar != null) {
            if (bhVar.aev() <= 0) {
                this.cbZ.setVisibility(4);
                return;
            }
            this.cbZ.setVisibility(0);
            if (this.mFrom == 2) {
                aD = aq.aC(bhVar.aev());
            } else if (bhVar.afN()) {
                aD = aq.aD(bhVar.getCreateTime());
            } else if (bhVar.aeG()) {
                aD = aq.aE(bhVar.aev() * 1000);
            } else {
                aD = aq.aD(bhVar.aev() * 1000);
            }
            this.cbZ.setText(aD);
        }
    }

    protected void h(bh bhVar) {
        if (this.XP == null || bhVar == null) {
            this.XP.setVisibility(8);
        } else if (this.cdL) {
            if (StringUtils.isNull(bhVar.acD())) {
                this.XP.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XP.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.XP.setLayoutParams(layoutParams);
            }
            this.XP.setText(bhVar.acD());
            this.XP.setVisibility(0);
        } else if (this.Wd.aeV() == null || this.Wd.aeV().share_info == null || this.Wd.aeV().share_info.share_user_count <= 0 || !this.Wd.afQ() || (this.Wd.bMr > 0 && this.Wd.bMs == 0)) {
            this.XP.setVisibility(8);
        } else {
            this.XP.setVisibility(0);
            int i = this.Wd.aeV().share_info.share_user_count;
            if (i == 1) {
                this.XP.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.XP.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.aI(i)}));
            }
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.cdF.setVisibility(8);
            this.cdG.setVisibility(8);
            return;
        }
        this.cdF.setText(this.Wd.getAddress());
        this.cdF.setVisibility(0);
        this.cdG.setVisibility(0);
    }

    public void D(bh bhVar) {
        String str;
        if (bhVar == null) {
            this.ccX.setVisibility(8);
            this.cdJ.setVisibility(8);
            return;
        }
        String aeH = this.Wd.aeH();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aeH = null;
        } else if (this.mFrom == 5) {
            aeH = bhVar.agn();
        }
        if (bhVar.agm()) {
            aeH = bhVar.bMD.ori_fname;
        }
        if (StringUtils.isNull(aeH)) {
            this.ccX.setVisibility(8);
            this.cdJ.setVisibility(8);
            return;
        }
        if (this.Wd.bMr > 0 && this.Wd.bMs == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.j(aeH, 12, "...") + getResources().getString(R.string.forum);
        }
        this.ccX.setText(str);
        this.ccX.setVisibility(0);
        this.cdJ.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void eq(boolean z) {
        if (z) {
            D(this.Wd);
            return;
        }
        this.ccX.setVisibility(8);
        this.cdJ.setVisibility(8);
    }

    private void c(bh bhVar) {
        if (this.cdi != null && bhVar != null && this.Wd.aeC() != null) {
            if (this.Wd.bMr > 0 && this.Wd.bMs == 0) {
                this.cdi.setShowV(false);
            } else {
                this.cdi.setShowV(this.Wd.aeC().isBigV());
            }
        }
    }

    private void qZ() {
        if (this.Wd != null && this.Wd.aeC() != null) {
            if (this.Wd.bMr > 0 && this.Wd.bMs == 0) {
                am.j(this.XK, R.color.cp_cont_f);
            } else if (!v.aa(this.Wd.aeC().getTShowInfoNew()) || this.Wd.aeC().isBigV()) {
                am.j(this.XK, R.color.cp_cont_h);
            } else {
                am.j(this.XK, R.color.cp_cont_f);
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
        qZ();
        am.j(this.XP, R.color.cp_cont_f);
        am.j(this.cbZ, R.color.cp_cont_d);
        am.l(this.cdG, R.color.cp_cont_e);
        am.j(this.cdF, R.color.cp_cont_d);
        am.j(this.ccX, R.color.cp_cont_d);
        am.l(this.cdG, R.color.cp_cont_e);
        am.l(this.cdJ, R.color.cp_cont_e);
        k(this.Wd);
    }

    public void setIsSimpleThread(boolean z) {
        this.cdK = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.cdK;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
        if (this.cdi != null) {
            this.cdi.setAfterClickListener(this.XU);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cdi != null) {
            this.cdi.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cdi;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.XK;
    }

    protected String pb(String str) {
        return aq.j(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.cdI = z;
    }

    public void setIsFromConcern(boolean z) {
        this.cdL = z;
    }
}

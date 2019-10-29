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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
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
    private bh FT;
    public TextView HE;
    public TextView HF;
    protected UserIconBox HG;
    private UserIconBox HH;
    protected TextView HJ;
    private View HM;
    private FrameLayout HN;
    private View.OnClickListener HO;
    private View.OnClickListener HU;
    private View.OnClickListener HV;
    private View.OnClickListener HW;
    private TextView cqn;
    private TextView crT;
    private View crU;
    private TextView crV;
    private boolean crW;
    private View crX;
    private boolean crY;
    private boolean crZ;
    private TextView crl;
    public ClickableHeaderImageView crw;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.crW = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.HU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getUserId()) && ThreadUserInfoLayout.this.FT.aiL() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.FT.ajP() != null && ThreadUserInfoLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.ajP().channelId, ThreadUserInfoLayout.this.FT.ajP().ZN)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.aiG().getUserId(), ThreadUserInfoLayout.this.FT.aiG().getName_show(), ThreadUserInfoLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.FT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.HO != null) {
                        ThreadUserInfoLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.HW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crW = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.HU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getUserId()) && ThreadUserInfoLayout.this.FT.aiL() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.FT.ajP() != null && ThreadUserInfoLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.ajP().channelId, ThreadUserInfoLayout.this.FT.ajP().ZN)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.aiG().getUserId(), ThreadUserInfoLayout.this.FT.aiG().getName_show(), ThreadUserInfoLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.FT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.HO != null) {
                        ThreadUserInfoLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.HW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crW = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.HU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.FT.aiG().getUserId()) && ThreadUserInfoLayout.this.FT.aiL() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.FT.ajP() != null && ThreadUserInfoLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.ajP().channelId, ThreadUserInfoLayout.this.FT.ajP().ZN)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.FT.aiG().getUserId(), ThreadUserInfoLayout.this.FT.aiG().getName_show(), ThreadUserInfoLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.FT.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.HO != null) {
                        ThreadUserInfoLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.HW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.FT != null && ThreadUserInfoLayout.this.FT.aiG() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.crw = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.HH = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.HE = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.HF = (TextView) inflate.findViewById(R.id.identity_view);
        this.HG = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.cqn = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.crT = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.crU = inflate.findViewById(R.id.divider);
        this.crX = findViewById(R.id.divider_forum_name);
        this.crl = (TextView) findViewById(R.id.thread_info_forum_name);
        this.HJ = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.crV = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.HN = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.HM = com.baidu.tbadk.ala.b.afc().l(this.mContext, 1);
        if (this.HM != null) {
            this.HM.setVisibility(8);
            this.HN.addView(this.HM);
        }
        setGravity(16);
        initHeaderImg();
        this.HH.setOnClickListener(this.HU);
        this.HE.setOnClickListener(this.HV);
        this.HG.setOnClickListener(this.HW);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.FT = bhVar;
        if (this.FT.cea > 0) {
            if (this.FT.ceb == 0 && this.FT.aiG() != null) {
                if (!v.isEmpty(this.FT.aiG().getTShowInfoNew())) {
                    this.FT.aiG().getTShowInfoNew().clear();
                }
                this.FT.aiG().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.HH.setOnClickListener(null);
            this.HE.setOnClickListener(null);
            this.HG.setOnClickListener(null);
            this.crw.setClickable(false);
        } else {
            this.HH.setOnClickListener(this.HU);
            this.HE.setOnClickListener(this.HV);
            this.HG.setOnClickListener(this.HW);
            this.crw.setClickable(true);
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
        if (this.crw != null) {
            this.crw.setDefaultResource(17170445);
            this.crw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.crw.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.crw.setIsRound(true);
            this.crw.setAfterClickListener(this.HO);
        }
    }

    private void f(bh bhVar) {
        if (this.mFrom == 3) {
            if (bhVar != null && bhVar.aiG() != null && bhVar.aiG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aiG().getAlaUserData();
                if (this.HM != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTT = alaUserData;
                    aVar.type = 1;
                    this.HM.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.HM.setVisibility(8);
                    } else {
                        this.HM.setVisibility(0);
                    }
                }
            } else if (this.HM != null) {
                this.HM.setVisibility(8);
            }
        }
    }

    private void B(bh bhVar) {
        if (this.crV != null && bhVar != null && bhVar.aiG() != null) {
            if (bhVar.aiG().hadConcerned()) {
                this.crV.setVisibility(0);
                am.setViewTextColor(this.crV, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.crV, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.crV.setVisibility(8);
        }
    }

    private void j(bh bhVar) {
        if (this.HH != null && bhVar != null && bhVar.aiG() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.aiG().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.HH.setVisibility(0);
                this.HH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.HH.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.HF != null && bhVar != null && bhVar.aiG() != null) {
            MetaData aiG = bhVar.aiG();
            if (aiG.getIs_bawu() == 1) {
                int i = bhVar.cen ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bhVar.cen ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.HF, i);
                am.setViewTextColor(this.HF, i2);
                if (bhVar.cen) {
                    this.HF.setVisibility(0);
                    this.HF.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aiG.getBawu_type())) {
                    this.HF.setVisibility(0);
                    this.HF.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_member_xbazhu_tip);
                    this.HF.setVisibility(0);
                } else if ("pri_content_assist".equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_content_assist_tip);
                    this.HF.setVisibility(0);
                } else if ("pri_manage_assist".equals(aiG.getBawu_type())) {
                    this.HF.setText(R.string.bawu_manage_assist_tip);
                    this.HF.setVisibility(0);
                } else if (aiG.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.HF.setVisibility(8);
                }
            } else if (aiG.getIs_biggie()) {
                l(bhVar);
            } else {
                this.HF.setVisibility(8);
            }
        }
    }

    private void l(bh bhVar) {
        am.setBackgroundResource(this.HF, R.drawable.brand_official_btn);
        am.setViewTextColor(this.HF, (int) R.color.cp_link_tip_a);
        this.HF.setText(R.string.video_mcn);
        if (bhVar.ajG()) {
            this.HG.setVisibility(8);
        }
        this.HF.setVisibility(0);
    }

    private void g(bh bhVar) {
        if (this.HE != null && bhVar != null) {
            if (!StringUtils.isNull(this.FT.aiG().getName_show())) {
                this.HE.setText(oA(this.FT.aiG().getName_show()));
            }
            me();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.FT.aiG().getName_show();
                String userName = this.FT.aiG().getUserName();
                if (as.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.HE.setText(com.baidu.tieba.pb.c.aI(this.mContext, this.HE.getText().toString()));
                    this.HE.setGravity(16);
                    this.HE.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQg());
                    am.setViewTextColor(this.HE, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void i(bh bhVar) {
        if (this.HG != null) {
            if (this.crZ) {
                this.HG.setVisibility(8);
            } else if (bhVar == null || bhVar.aiG() == null || ((bhVar.cea > 0 && bhVar.ceb == 0) || !this.crW)) {
                this.HG.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aiG().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.HG.setVisibility(0);
                    this.HG.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.HG.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String formatTime;
        if (this.cqn != null && bhVar != null) {
            if (bhVar.aiz() <= 0) {
                this.cqn.setVisibility(4);
                return;
            }
            this.cqn.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bhVar.aiz());
            } else if (bhVar.ajQ()) {
                formatTime = aq.getFormatTime(bhVar.getCreateTime());
            } else if (bhVar.aiK()) {
                formatTime = aq.aS(bhVar.aiz() * 1000);
            } else {
                formatTime = aq.getFormatTime(bhVar.aiz() * 1000);
            }
            this.cqn.setText(formatTime);
        }
    }

    protected void h(bh bhVar) {
        if (this.HJ == null || bhVar == null) {
            this.HJ.setVisibility(8);
        } else if (this.crZ) {
            if (StringUtils.isNull(bhVar.agJ())) {
                this.HJ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HJ.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.HJ.setLayoutParams(layoutParams);
            }
            this.HJ.setText(bhVar.agJ());
            this.HJ.setVisibility(0);
        } else if (this.FT.aiZ() == null || this.FT.aiZ().share_info == null || this.FT.aiZ().share_info.share_user_count <= 0 || !this.FT.ajT() || (this.FT.cea > 0 && this.FT.ceb == 0)) {
            this.HJ.setVisibility(8);
        } else {
            this.HJ.setVisibility(0);
            int i = this.FT.aiZ().share_info.share_user_count;
            if (i == 1) {
                this.HJ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.HJ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.crT.setVisibility(8);
            this.crU.setVisibility(8);
            return;
        }
        this.crT.setText(this.FT.getAddress());
        this.crT.setVisibility(0);
        this.crU.setVisibility(0);
    }

    public void D(bh bhVar) {
        String str;
        if (bhVar == null) {
            this.crl.setVisibility(8);
            this.crX.setVisibility(8);
            return;
        }
        String aiL = this.FT.aiL();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aiL = null;
        } else if (this.mFrom == 5) {
            aiL = bhVar.akq();
        }
        if (bhVar.akp()) {
            aiL = bhVar.cem.ori_fname;
        }
        if (StringUtils.isNull(aiL)) {
            this.crl.setVisibility(8);
            this.crX.setVisibility(8);
            return;
        }
        if (this.FT.cea > 0 && this.FT.ceb == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(aiL, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.crl.setText(str);
        this.crl.setVisibility(0);
        this.crX.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void et(boolean z) {
        if (z) {
            D(this.FT);
            return;
        }
        this.crl.setVisibility(8);
        this.crX.setVisibility(8);
    }

    private void c(bh bhVar) {
        if (this.crw != null && bhVar != null && this.FT.aiG() != null) {
            if (this.FT.cea > 0 && this.FT.ceb == 0) {
                this.crw.setShowV(false);
            } else {
                this.crw.setShowV(this.FT.aiG().isBigV());
            }
        }
    }

    private void me() {
        if (this.FT != null && this.FT.aiG() != null) {
            if (this.FT.cea > 0 && this.FT.ceb == 0) {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.FT.aiG().getTShowInfoNew()) || this.FT.aiG().isBigV()) {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.HE, (int) R.color.cp_cont_f);
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
        me();
        am.setViewTextColor(this.HJ, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.cqn, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.crU, R.color.cp_cont_e);
        am.setViewTextColor(this.crT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.crl, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.crU, R.color.cp_cont_e);
        am.setBackgroundColor(this.crX, R.color.cp_cont_e);
        k(this.FT);
    }

    public void setIsSimpleThread(boolean z) {
        this.crY = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.crY;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.HO = onClickListener;
        if (this.crw != null) {
            this.crw.setAfterClickListener(this.HO);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.crw != null) {
            this.crw.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.crw;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.HE;
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.crW = z;
    }

    public void setIsFromConcern(boolean z) {
        this.crZ = z;
    }
}

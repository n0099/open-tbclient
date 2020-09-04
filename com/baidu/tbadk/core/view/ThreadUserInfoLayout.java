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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bw afL;
    public TextView aiH;
    public TextView aiI;
    protected UserIconBox aiJ;
    private UserIconBox aiK;
    protected TextView aiO;
    private View.OnClickListener aiT;
    private View.OnClickListener aja;
    private View.OnClickListener ajb;
    private View.OnClickListener ajc;
    private TextView etz;
    public ClickableHeaderImageView euH;
    private TextView euw;
    private TextView evd;
    private View eve;
    private TextView evf;
    private View evg;
    private FrameLayout evh;
    private boolean evi;
    private View evj;
    private boolean evk;
    private boolean evl;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.evi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getUserId()) && ThreadUserInfoLayout.this.afL.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afL.beE().getUserId(), ThreadUserInfoLayout.this.afL.beE().getName_show(), ThreadUserInfoLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afL.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiT != null) {
                        ThreadUserInfoLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afL.beE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getUserId()) && ThreadUserInfoLayout.this.afL.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afL.beE().getUserId(), ThreadUserInfoLayout.this.afL.beE().getName_show(), ThreadUserInfoLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afL.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiT != null) {
                        ThreadUserInfoLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afL.beE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evi = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afL.beE().getUserId()) && ThreadUserInfoLayout.this.afL.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afL.beE().getUserId(), ThreadUserInfoLayout.this.afL.beE().getName_show(), ThreadUserInfoLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afL.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiT != null) {
                        ThreadUserInfoLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afL != null && ThreadUserInfoLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afL.beE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.euH = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.aiK = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.aiH = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.aiI = (TextView) inflate.findViewById(R.id.identity_view);
        this.aiJ = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.etz = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.evd = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eve = inflate.findViewById(R.id.divider);
        this.evj = findViewById(R.id.divider_forum_name);
        this.euw = (TextView) findViewById(R.id.thread_info_forum_name);
        this.aiO = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.evf = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.evh = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.evg = com.baidu.tbadk.ala.b.bar().q(this.mContext, 1);
        if (this.evg != null) {
            this.evg.setVisibility(8);
            this.evh.addView(this.evg);
        }
        setGravity(16);
        initHeaderImg();
        this.aiK.setOnClickListener(this.aja);
        this.aiH.setOnClickListener(this.ajb);
        this.aiJ.setOnClickListener(this.ajc);
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.afL = bwVar;
        if (this.afL.edG > 0) {
            if (this.afL.edH == 0 && this.afL.beE() != null) {
                if (!y.isEmpty(this.afL.beE().getTShowInfoNew())) {
                    this.afL.beE().getTShowInfoNew().clear();
                }
                this.afL.beE().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.aiK.setOnClickListener(null);
            this.aiH.setOnClickListener(null);
            this.aiJ.setOnClickListener(null);
            this.euH.setClickable(false);
        } else {
            this.aiK.setOnClickListener(this.aja);
            this.aiH.setOnClickListener(this.ajb);
            this.aiJ.setOnClickListener(this.ajc);
            this.euH.setClickable(true);
        }
        k(bwVar);
        h(bwVar);
        i(bwVar);
        j(bwVar);
        l(bwVar);
        C(bwVar);
        H(bwVar);
        c(bwVar);
        I(bwVar);
        setVisibility(0);
        G(bwVar);
        F(bwVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.euH != null) {
            this.euH.setDefaultResource(17170445);
            this.euH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.euH.setPlaceHolder(1);
            this.euH.setIsRound(true);
            this.euH.setAfterClickListener(this.aiT);
        }
    }

    private void F(bw bwVar) {
        if (this.mFrom == 3) {
            if (bwVar != null && bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.beE().getAlaUserData();
                if (this.evg != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dRB = alaUserData;
                    aVar.type = 1;
                    this.evg.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.evg.setVisibility(8);
                    } else {
                        this.evg.setVisibility(0);
                    }
                }
            } else if (this.evg != null) {
                this.evg.setVisibility(8);
            }
        }
    }

    private void G(bw bwVar) {
        if (this.evf != null && bwVar != null && bwVar.beE() != null) {
            if (bwVar.beE().hadConcerned()) {
                this.evf.setVisibility(0);
                ap.setViewTextColor(this.evf, R.color.cp_cont_d);
                ap.setBackgroundResource(this.evf, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.evf.setVisibility(8);
        }
    }

    private void k(bw bwVar) {
        if (this.aiK != null && bwVar != null && bwVar.beE() != null) {
            ArrayList<IconData> tShowInfoNew = bwVar.beE().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aiK.setVisibility(0);
                this.aiK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aiK.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.aiI != null && bwVar != null && bwVar.beE() != null) {
            MetaData beE = bwVar.beE();
            if (beE.getIs_bawu() == 1) {
                int i = bwVar.edU ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bwVar.edU ? R.color.cp_cont_a : R.color.cp_cont_j;
                ap.setBackgroundResource(this.aiI, i);
                ap.setViewTextColor(this.aiI, i2);
                if (bwVar.edU) {
                    this.aiI.setVisibility(0);
                    this.aiI.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                    this.aiI.setVisibility(0);
                    this.aiI.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                    this.aiI.setText(R.string.bawu_member_xbazhu_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(beE.getBawu_type())) {
                    this.aiI.setText(R.string.bawu_content_assist_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(beE.getBawu_type())) {
                    this.aiI.setText(R.string.bawu_manage_assist_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else {
                    this.aiI.setVisibility(8);
                    return;
                }
            }
            this.aiI.setVisibility(8);
        }
    }

    private void h(bw bwVar) {
        if (this.aiH != null && bwVar != null) {
            if (!StringUtils.isNull(this.afL.beE().getName_show())) {
                this.aiH.setText(AG(this.afL.beE().getName_show()));
            }
            ug();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.afL.beE().getName_show();
                String userName = this.afL.beE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.aiH.setText(com.baidu.tieba.pb.c.aN(this.mContext, this.aiH.getText().toString()));
                    this.aiH.setGravity(16);
                    this.aiH.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUW());
                    ap.setViewTextColor(this.aiH, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bw bwVar) {
        if (this.aiJ != null) {
            if (this.evl) {
                this.aiJ.setVisibility(8);
            } else if (bwVar == null || bwVar.beE() == null || ((bwVar.edG > 0 && bwVar.edH == 0) || !this.evi)) {
                this.aiJ.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.beE().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aiJ.setVisibility(0);
                    this.aiJ.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.aiJ.setVisibility(8);
            }
        }
    }

    private void C(bw bwVar) {
        String formatTime;
        if (this.etz != null && bwVar != null) {
            if (bwVar.bex() <= 0) {
                this.etz.setVisibility(4);
                return;
            }
            this.etz.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bwVar.bex());
            } else if (bwVar.bfV()) {
                formatTime = at.getFormatTime(bwVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bwVar.bex() * 1000);
            }
            this.etz.setText(formatTime);
        }
    }

    protected void i(bw bwVar) {
        if (this.aiO == null || bwVar == null) {
            this.aiO.setVisibility(8);
        } else if (this.evl) {
            if (StringUtils.isNull(bwVar.bcf())) {
                this.aiO.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiO.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aiO.setLayoutParams(layoutParams);
            }
            this.aiO.setText(bwVar.bcf());
            this.aiO.setVisibility(0);
        } else if (this.afL.beY() == null || this.afL.beY().share_info == null || this.afL.beY().share_info.share_user_count <= 0 || !this.afL.bfY() || (this.afL.edG > 0 && this.afL.edH == 0)) {
            this.aiO.setVisibility(8);
        } else {
            this.aiO.setVisibility(0);
            int i = this.afL.beY().share_info.share_user_count;
            if (i == 1) {
                this.aiO.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.aiO.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void H(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.getAddress())) {
            this.evd.setVisibility(8);
            this.eve.setVisibility(8);
            return;
        }
        this.evd.setText(this.afL.getAddress());
        this.evd.setVisibility(0);
        this.eve.setVisibility(0);
    }

    public void I(bw bwVar) {
        String str;
        if (bwVar == null) {
            this.euw.setVisibility(8);
            this.evj.setVisibility(8);
            return;
        }
        this.afL.beI();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bwVar.bgr()) {
            str2 = bwVar.edT.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.euw.setVisibility(8);
            this.evj.setVisibility(8);
            return;
        }
        if (this.afL.edG > 0 && this.afL.edH == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.euw.setText(str);
        this.euw.setVisibility(0);
        this.evj.setVisibility(0);
    }

    public void iC(boolean z) {
        if (z) {
            I(this.afL);
            return;
        }
        this.euw.setVisibility(8);
        this.evj.setVisibility(8);
    }

    private void c(bw bwVar) {
        if (this.euH != null && bwVar != null && this.afL.beE() != null) {
            if (this.afL.edG > 0 && this.afL.edH == 0) {
                this.euH.setShowV(false);
            } else {
                this.euH.setShowV(this.afL.beE().isBigV());
            }
        }
    }

    private void ug() {
        if (this.afL != null && this.afL.beE() != null) {
            if (this.afL.edG > 0 && this.afL.edH == 0) {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_f);
            } else if (!y.isEmpty(this.afL.beE().getTShowInfoNew()) || this.afL.beE().isBigV()) {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        ug();
        ap.setViewTextColor(this.aiO, R.color.cp_cont_f);
        ap.setViewTextColor(this.etz, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eve, R.color.cp_cont_e);
        ap.setViewTextColor(this.evd, R.color.cp_cont_d);
        ap.setViewTextColor(this.euw, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eve, R.color.cp_cont_e);
        ap.setBackgroundColor(this.evj, R.color.cp_cont_e);
        l(this.afL);
    }

    public void setIsSimpleThread(boolean z) {
        this.evk = z;
    }

    public boolean getIsSimpleThread() {
        return this.evk;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiT = onClickListener;
        if (this.euH != null) {
            this.euH.setAfterClickListener(this.aiT);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euH != null) {
            this.euH.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.euH;
    }

    public TextView getUserName() {
        return this.aiH;
    }

    protected String AG(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.evi = z;
    }

    public void setIsFromConcern(boolean z) {
        this.evl = z;
    }
}

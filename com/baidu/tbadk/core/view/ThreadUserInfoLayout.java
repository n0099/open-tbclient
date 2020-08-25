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
/* loaded from: classes2.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bw afJ;
    public TextView aiF;
    public TextView aiG;
    protected UserIconBox aiH;
    private UserIconBox aiI;
    protected TextView aiM;
    private View.OnClickListener aiR;
    private View.OnClickListener aiY;
    private View.OnClickListener aiZ;
    private View.OnClickListener aja;
    private TextView etv;
    public ClickableHeaderImageView euD;
    private TextView euZ;
    private TextView eus;
    private View eva;
    private TextView evb;
    private View evc;
    private FrameLayout evd;
    private boolean eve;
    private View evf;
    private boolean evg;
    private boolean evh;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.eve = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aiY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getUserId()) && ThreadUserInfoLayout.this.afJ.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afJ.beE().getUserId(), ThreadUserInfoLayout.this.afJ.beE().getName_show(), ThreadUserInfoLayout.this.afJ.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiR != null) {
                        ThreadUserInfoLayout.this.aiR.onClick(view);
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afJ.beE().getUserId(), true, true, true);
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
        this.eve = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aiY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getUserId()) && ThreadUserInfoLayout.this.afJ.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afJ.beE().getUserId(), ThreadUserInfoLayout.this.afJ.beE().getName_show(), ThreadUserInfoLayout.this.afJ.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiR != null) {
                        ThreadUserInfoLayout.this.aiR.onClick(view);
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afJ.beE().getUserId(), true, true, true);
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
        this.eve = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aiY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.afJ.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.afJ.beE().getUserId()) && ThreadUserInfoLayout.this.afJ.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.afJ.beE().getUserId(), ThreadUserInfoLayout.this.afJ.beE().getName_show(), ThreadUserInfoLayout.this.afJ.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.afJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aiR != null) {
                        ThreadUserInfoLayout.this.aiR.onClick(view);
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.afJ != null && ThreadUserInfoLayout.this.afJ.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.afJ.beE().getUserId(), true, true, true);
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
        this.euD = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.aiI = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.aiF = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.aiG = (TextView) inflate.findViewById(R.id.identity_view);
        this.aiH = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.etv = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.euZ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eva = inflate.findViewById(R.id.divider);
        this.evf = findViewById(R.id.divider_forum_name);
        this.eus = (TextView) findViewById(R.id.thread_info_forum_name);
        this.aiM = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.evb = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.evd = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.evc = com.baidu.tbadk.ala.b.bar().q(this.mContext, 1);
        if (this.evc != null) {
            this.evc.setVisibility(8);
            this.evd.addView(this.evc);
        }
        setGravity(16);
        initHeaderImg();
        this.aiI.setOnClickListener(this.aiY);
        this.aiF.setOnClickListener(this.aiZ);
        this.aiH.setOnClickListener(this.aja);
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.afJ = bwVar;
        if (this.afJ.edC > 0) {
            if (this.afJ.edD == 0 && this.afJ.beE() != null) {
                if (!y.isEmpty(this.afJ.beE().getTShowInfoNew())) {
                    this.afJ.beE().getTShowInfoNew().clear();
                }
                this.afJ.beE().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.aiI.setOnClickListener(null);
            this.aiF.setOnClickListener(null);
            this.aiH.setOnClickListener(null);
            this.euD.setClickable(false);
        } else {
            this.aiI.setOnClickListener(this.aiY);
            this.aiF.setOnClickListener(this.aiZ);
            this.aiH.setOnClickListener(this.aja);
            this.euD.setClickable(true);
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
        if (this.euD != null) {
            this.euD.setDefaultResource(17170445);
            this.euD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.euD.setPlaceHolder(1);
            this.euD.setIsRound(true);
            this.euD.setAfterClickListener(this.aiR);
        }
    }

    private void F(bw bwVar) {
        if (this.mFrom == 3) {
            if (bwVar != null && bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.beE().getAlaUserData();
                if (this.evc != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dRx = alaUserData;
                    aVar.type = 1;
                    this.evc.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.evc.setVisibility(8);
                    } else {
                        this.evc.setVisibility(0);
                    }
                }
            } else if (this.evc != null) {
                this.evc.setVisibility(8);
            }
        }
    }

    private void G(bw bwVar) {
        if (this.evb != null && bwVar != null && bwVar.beE() != null) {
            if (bwVar.beE().hadConcerned()) {
                this.evb.setVisibility(0);
                ap.setViewTextColor(this.evb, R.color.cp_cont_d);
                ap.setBackgroundResource(this.evb, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.evb.setVisibility(8);
        }
    }

    private void k(bw bwVar) {
        if (this.aiI != null && bwVar != null && bwVar.beE() != null) {
            ArrayList<IconData> tShowInfoNew = bwVar.beE().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aiI.setVisibility(0);
                this.aiI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aiI.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.aiG != null && bwVar != null && bwVar.beE() != null) {
            MetaData beE = bwVar.beE();
            if (beE.getIs_bawu() == 1) {
                int i = bwVar.edQ ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bwVar.edQ ? R.color.cp_cont_a : R.color.cp_cont_j;
                ap.setBackgroundResource(this.aiG, i);
                ap.setViewTextColor(this.aiG, i2);
                if (bwVar.edQ) {
                    this.aiG.setVisibility(0);
                    this.aiG.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                    this.aiG.setVisibility(0);
                    this.aiG.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                    this.aiG.setText(R.string.bawu_member_xbazhu_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(beE.getBawu_type())) {
                    this.aiG.setText(R.string.bawu_content_assist_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(beE.getBawu_type())) {
                    this.aiG.setText(R.string.bawu_manage_assist_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else {
                    this.aiG.setVisibility(8);
                    return;
                }
            }
            this.aiG.setVisibility(8);
        }
    }

    private void h(bw bwVar) {
        if (this.aiF != null && bwVar != null) {
            if (!StringUtils.isNull(this.afJ.beE().getName_show())) {
                this.aiF.setText(AF(this.afJ.beE().getName_show()));
            }
            ug();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.afJ.beE().getName_show();
                String userName = this.afJ.beE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.aiF.setText(com.baidu.tieba.pb.c.aN(this.mContext, this.aiF.getText().toString()));
                    this.aiF.setGravity(16);
                    this.aiF.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cUV());
                    ap.setViewTextColor(this.aiF, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bw bwVar) {
        if (this.aiH != null) {
            if (this.evh) {
                this.aiH.setVisibility(8);
            } else if (bwVar == null || bwVar.beE() == null || ((bwVar.edC > 0 && bwVar.edD == 0) || !this.eve)) {
                this.aiH.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.beE().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aiH.setVisibility(0);
                    this.aiH.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.aiH.setVisibility(8);
            }
        }
    }

    private void C(bw bwVar) {
        String formatTime;
        if (this.etv != null && bwVar != null) {
            if (bwVar.bex() <= 0) {
                this.etv.setVisibility(4);
                return;
            }
            this.etv.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bwVar.bex());
            } else if (bwVar.bfV()) {
                formatTime = at.getFormatTime(bwVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bwVar.bex() * 1000);
            }
            this.etv.setText(formatTime);
        }
    }

    protected void i(bw bwVar) {
        if (this.aiM == null || bwVar == null) {
            this.aiM.setVisibility(8);
        } else if (this.evh) {
            if (StringUtils.isNull(bwVar.bcf())) {
                this.aiM.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiM.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aiM.setLayoutParams(layoutParams);
            }
            this.aiM.setText(bwVar.bcf());
            this.aiM.setVisibility(0);
        } else if (this.afJ.beY() == null || this.afJ.beY().share_info == null || this.afJ.beY().share_info.share_user_count <= 0 || !this.afJ.bfY() || (this.afJ.edC > 0 && this.afJ.edD == 0)) {
            this.aiM.setVisibility(8);
        } else {
            this.aiM.setVisibility(0);
            int i = this.afJ.beY().share_info.share_user_count;
            if (i == 1) {
                this.aiM.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.aiM.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void H(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.getAddress())) {
            this.euZ.setVisibility(8);
            this.eva.setVisibility(8);
            return;
        }
        this.euZ.setText(this.afJ.getAddress());
        this.euZ.setVisibility(0);
        this.eva.setVisibility(0);
    }

    public void I(bw bwVar) {
        String str;
        if (bwVar == null) {
            this.eus.setVisibility(8);
            this.evf.setVisibility(8);
            return;
        }
        this.afJ.beI();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bwVar.bgr()) {
            str2 = bwVar.edP.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.eus.setVisibility(8);
            this.evf.setVisibility(8);
            return;
        }
        if (this.afJ.edC > 0 && this.afJ.edD == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.eus.setText(str);
        this.eus.setVisibility(0);
        this.evf.setVisibility(0);
    }

    public void iB(boolean z) {
        if (z) {
            I(this.afJ);
            return;
        }
        this.eus.setVisibility(8);
        this.evf.setVisibility(8);
    }

    private void c(bw bwVar) {
        if (this.euD != null && bwVar != null && this.afJ.beE() != null) {
            if (this.afJ.edC > 0 && this.afJ.edD == 0) {
                this.euD.setShowV(false);
            } else {
                this.euD.setShowV(this.afJ.beE().isBigV());
            }
        }
    }

    private void ug() {
        if (this.afJ != null && this.afJ.beE() != null) {
            if (this.afJ.edC > 0 && this.afJ.edD == 0) {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_f);
            } else if (!y.isEmpty(this.afJ.beE().getTShowInfoNew()) || this.afJ.beE().isBigV()) {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        ug();
        ap.setViewTextColor(this.aiM, R.color.cp_cont_f);
        ap.setViewTextColor(this.etv, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eva, R.color.cp_cont_e);
        ap.setViewTextColor(this.euZ, R.color.cp_cont_d);
        ap.setViewTextColor(this.eus, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eva, R.color.cp_cont_e);
        ap.setBackgroundColor(this.evf, R.color.cp_cont_e);
        l(this.afJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.evg = z;
    }

    public boolean getIsSimpleThread() {
        return this.evg;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiR = onClickListener;
        if (this.euD != null) {
            this.euD.setAfterClickListener(this.aiR);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euD != null) {
            this.euD.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.euD;
    }

    public TextView getUserName() {
        return this.aiF;
    }

    protected String AF(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.eve = z;
    }

    public void setIsFromConcern(boolean z) {
        this.evh = z;
    }
}

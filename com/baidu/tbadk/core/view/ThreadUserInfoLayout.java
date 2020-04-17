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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements c {
    private bj adG;
    public TextView afW;
    public TextView afX;
    protected UserIconBox afY;
    private UserIconBox afZ;
    protected TextView agb;
    private View.OnClickListener agi;
    private View.OnClickListener agp;
    private View.OnClickListener agq;
    private View.OnClickListener agr;
    private TextView dHA;
    public ClickableHeaderImageView dIJ;
    private TextView dIy;
    private TextView dJf;
    private View dJg;
    private TextView dJh;
    private View dJi;
    private FrameLayout dJj;
    private boolean dJk;
    private View dJl;
    private boolean dJm;
    private boolean dJn;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.dJk = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getUserId()) && ThreadUserInfoLayout.this.adG.aKJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adG.aKE().getUserId(), ThreadUserInfoLayout.this.adG.aKE().getName_show(), ThreadUserInfoLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adG.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agi != null) {
                        ThreadUserInfoLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.agr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJk = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getUserId()) && ThreadUserInfoLayout.this.adG.aKJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adG.aKE().getUserId(), ThreadUserInfoLayout.this.adG.aKE().getName_show(), ThreadUserInfoLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adG.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agi != null) {
                        ThreadUserInfoLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.agr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJk = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adG.aKE().getUserId()) && ThreadUserInfoLayout.this.adG.aKJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adG.aKE().getUserId(), ThreadUserInfoLayout.this.adG.aKE().getName_show(), ThreadUserInfoLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adG.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agi != null) {
                        ThreadUserInfoLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.agr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adG != null && ThreadUserInfoLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.dIJ = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.afZ = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.afW = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.afX = (TextView) inflate.findViewById(R.id.identity_view);
        this.afY = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dHA = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.dJf = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dJg = inflate.findViewById(R.id.divider);
        this.dJl = findViewById(R.id.divider_forum_name);
        this.dIy = (TextView) findViewById(R.id.thread_info_forum_name);
        this.agb = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.dJh = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.dJj = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.dJi = com.baidu.tbadk.ala.b.aGP().p(this.mContext, 1);
        if (this.dJi != null) {
            this.dJi.setVisibility(8);
            this.dJj.addView(this.dJi);
        }
        setGravity(16);
        initHeaderImg();
        this.afZ.setOnClickListener(this.agp);
        this.afW.setOnClickListener(this.agq);
        this.afY.setOnClickListener(this.agr);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.adG = bjVar;
        if (this.adG.dtm > 0) {
            if (this.adG.dtn == 0 && this.adG.aKE() != null) {
                if (!v.isEmpty(this.adG.aKE().getTShowInfoNew())) {
                    this.adG.aKE().getTShowInfoNew().clear();
                }
                this.adG.aKE().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.afZ.setOnClickListener(null);
            this.afW.setOnClickListener(null);
            this.afY.setOnClickListener(null);
            this.dIJ.setClickable(false);
        } else {
            this.afZ.setOnClickListener(this.agp);
            this.afW.setOnClickListener(this.agq);
            this.afY.setOnClickListener(this.agr);
            this.dIJ.setClickable(true);
        }
        k(bjVar);
        h(bjVar);
        i(bjVar);
        j(bjVar);
        l(bjVar);
        D(bjVar);
        J(bjVar);
        c(bjVar);
        K(bjVar);
        setVisibility(0);
        I(bjVar);
        H(bjVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.dIJ != null) {
            this.dIJ.setDefaultResource(17170445);
            this.dIJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dIJ.setPlaceHolder(1);
            this.dIJ.setIsRound(true);
            this.dIJ.setAfterClickListener(this.agi);
        }
    }

    private void H(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.aKE() != null && bjVar.aKE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKE().getAlaUserData();
                if (this.dJi != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djj = alaUserData;
                    aVar.type = 1;
                    this.dJi.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.dJi.setVisibility(8);
                    } else {
                        this.dJi.setVisibility(0);
                    }
                }
            } else if (this.dJi != null) {
                this.dJi.setVisibility(8);
            }
        }
    }

    private void I(bj bjVar) {
        if (this.dJh != null && bjVar != null && bjVar.aKE() != null) {
            if (bjVar.aKE().hadConcerned()) {
                this.dJh.setVisibility(0);
                am.setViewTextColor(this.dJh, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.dJh, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.dJh.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.afZ != null && bjVar != null && bjVar.aKE() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.aKE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.afZ.setVisibility(0);
                this.afZ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.afZ.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.afX != null && bjVar != null && bjVar.aKE() != null) {
            MetaData aKE = bjVar.aKE();
            if (aKE.getIs_bawu() == 1) {
                int i = bjVar.dtA ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.dtA ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.afX, i);
                am.setViewTextColor(this.afX, i2);
                if (bjVar.dtA) {
                    this.afX.setVisibility(0);
                    this.afX.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aKE.getBawu_type())) {
                    this.afX.setVisibility(0);
                    this.afX.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aKE.getBawu_type())) {
                    this.afX.setText(R.string.bawu_member_xbazhu_tip);
                    this.afX.setVisibility(0);
                } else if ("pri_content_assist".equals(aKE.getBawu_type())) {
                    this.afX.setText(R.string.bawu_content_assist_tip);
                    this.afX.setVisibility(0);
                } else if ("pri_manage_assist".equals(aKE.getBawu_type())) {
                    this.afX.setText(R.string.bawu_manage_assist_tip);
                    this.afX.setVisibility(0);
                } else if (aKE.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.afX.setVisibility(8);
                }
            } else if (aKE.getIs_biggie()) {
                m(bjVar);
            } else {
                this.afX.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.afX, R.drawable.brand_official_btn);
        am.setViewTextColor(this.afX, (int) R.color.cp_link_tip_a);
        this.afX.setText(R.string.video_mcn);
        if (bjVar.aLJ()) {
            this.afY.setVisibility(8);
        }
        this.afX.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.afW != null && bjVar != null) {
            if (!StringUtils.isNull(this.adG.aKE().getName_show())) {
                this.afW.setText(vm(this.adG.aKE().getName_show()));
            }
            rM();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.adG.aKE().getName_show();
                String userName = this.adG.aKE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.afW.setText(com.baidu.tieba.pb.c.aV(this.mContext, this.afW.getText().toString()));
                    this.afW.setGravity(16);
                    this.afW.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cvd());
                    am.setViewTextColor(this.afW, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.afY != null) {
            if (this.dJn) {
                this.afY.setVisibility(8);
            } else if (bjVar == null || bjVar.aKE() == null || ((bjVar.dtm > 0 && bjVar.dtn == 0) || !this.dJk)) {
                this.afY.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aKE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.afY.setVisibility(0);
                    this.afY.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.afY.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String formatTime;
        if (this.dHA != null && bjVar != null) {
            if (bjVar.aKx() <= 0) {
                this.dHA.setVisibility(4);
                return;
            }
            this.dHA.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.aKx());
            } else if (bjVar.aLS()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aKI()) {
                formatTime = aq.cj(bjVar.aKx() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.aKx() * 1000);
            }
            this.dHA.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.agb == null || bjVar == null) {
            this.agb.setVisibility(8);
        } else if (this.dJn) {
            if (StringUtils.isNull(bjVar.aIx())) {
                this.agb.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agb.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.agb.setLayoutParams(layoutParams);
            }
            this.agb.setText(bjVar.aIx());
            this.agb.setVisibility(0);
        } else if (this.adG.aKX() == null || this.adG.aKX().share_info == null || this.adG.aKX().share_info.share_user_count <= 0 || !this.adG.aLV() || (this.adG.dtm > 0 && this.adG.dtn == 0)) {
            this.agb.setVisibility(8);
        } else {
            this.agb.setVisibility(0);
            int i = this.adG.aKX().share_info.share_user_count;
            if (i == 1) {
                this.agb.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.agb.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dJf.setVisibility(8);
            this.dJg.setVisibility(8);
            return;
        }
        this.dJf.setText(this.adG.getAddress());
        this.dJf.setVisibility(0);
        this.dJg.setVisibility(0);
    }

    public void K(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.dIy.setVisibility(8);
            this.dJl.setVisibility(8);
            return;
        }
        this.adG.aKJ();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bjVar.aMo()) {
            str2 = bjVar.dtz.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.dIy.setVisibility(8);
            this.dJl.setVisibility(8);
            return;
        }
        if (this.adG.dtm > 0 && this.adG.dtn == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.dIy.setText(str);
        this.dIy.setVisibility(0);
        this.dJl.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void gQ(boolean z) {
        if (z) {
            K(this.adG);
            return;
        }
        this.dIy.setVisibility(8);
        this.dJl.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.dIJ != null && bjVar != null && this.adG.aKE() != null) {
            if (this.adG.dtm > 0 && this.adG.dtn == 0) {
                this.dIJ.setShowV(false);
            } else {
                this.dIJ.setShowV(this.adG.aKE().isBigV());
            }
        }
    }

    private void rM() {
        if (this.adG != null && this.adG.aKE() != null) {
            if (this.adG.dtm > 0 && this.adG.dtn == 0) {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.adG.aKE().getTShowInfoNew()) || this.adG.aKE().isBigV()) {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_f);
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
        rM();
        am.setViewTextColor(this.agb, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dHA, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dJg, R.color.cp_cont_e);
        am.setViewTextColor(this.dJf, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIy, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dJg, R.color.cp_cont_e);
        am.setBackgroundColor(this.dJl, R.color.cp_cont_e);
        l(this.adG);
    }

    public void setIsSimpleThread(boolean z) {
        this.dJm = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.dJm;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agi = onClickListener;
        if (this.dIJ != null) {
            this.dIJ.setAfterClickListener(this.agi);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIJ != null) {
            this.dIJ.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dIJ;
    }

    public TextView getUserName() {
        return this.afW;
    }

    protected String vm(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.dJk = z;
    }

    public void setIsFromConcern(boolean z) {
        this.dJn = z;
    }
}

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
    private bj Kn;
    public TextView MK;
    public TextView MN;
    protected UserIconBox MO;
    private UserIconBox MP;
    protected TextView MR;
    private View.OnClickListener MX;
    private View.OnClickListener Nf;
    private View.OnClickListener Ng;
    private View.OnClickListener Nh;
    private TextView dcZ;
    private TextView ddX;
    private TextView deF;
    private View deG;
    private TextView deH;
    private View deI;
    private FrameLayout deJ;
    private boolean deK;
    private View deL;
    private boolean deM;
    private boolean deN;
    public ClickableHeaderImageView dei;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.deK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Nf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getUserId()) && ThreadUserInfoLayout.this.Kn.aAc() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Kn.azX().getUserId(), ThreadUserInfoLayout.this.Kn.azX().getName_show(), ThreadUserInfoLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Kn.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MX != null) {
                        ThreadUserInfoLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Nf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getUserId()) && ThreadUserInfoLayout.this.Kn.aAc() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Kn.azX().getUserId(), ThreadUserInfoLayout.this.Kn.azX().getName_show(), ThreadUserInfoLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Kn.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MX != null) {
                        ThreadUserInfoLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deK = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Nf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Kn.azX().getUserId()) && ThreadUserInfoLayout.this.Kn.aAc() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Kn.azX().getUserId(), ThreadUserInfoLayout.this.Kn.azX().getName_show(), ThreadUserInfoLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Kn.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MX != null) {
                        ThreadUserInfoLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Kn != null && ThreadUserInfoLayout.this.Kn.azX() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.dei = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.MP = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.MK = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.MN = (TextView) inflate.findViewById(R.id.identity_view);
        this.MO = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dcZ = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.deF = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.deG = inflate.findViewById(R.id.divider);
        this.deL = findViewById(R.id.divider_forum_name);
        this.ddX = (TextView) findViewById(R.id.thread_info_forum_name);
        this.MR = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.deH = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.deJ = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.deI = com.baidu.tbadk.ala.b.awm().u(this.mContext, 1);
        if (this.deI != null) {
            this.deI.setVisibility(8);
            this.deJ.addView(this.deI);
        }
        setGravity(16);
        initHeaderImg();
        this.MP.setOnClickListener(this.Nf);
        this.MK.setOnClickListener(this.Ng);
        this.MO.setOnClickListener(this.Nh);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.Kn = bjVar;
        if (this.Kn.cPL > 0) {
            if (this.Kn.cPM == 0 && this.Kn.azX() != null) {
                if (!v.isEmpty(this.Kn.azX().getTShowInfoNew())) {
                    this.Kn.azX().getTShowInfoNew().clear();
                }
                this.Kn.azX().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.MP.setOnClickListener(null);
            this.MK.setOnClickListener(null);
            this.MO.setOnClickListener(null);
            this.dei.setClickable(false);
        } else {
            this.MP.setOnClickListener(this.Nf);
            this.MK.setOnClickListener(this.Ng);
            this.MO.setOnClickListener(this.Nh);
            this.dei.setClickable(true);
        }
        k(bjVar);
        h(bjVar);
        i(bjVar);
        j(bjVar);
        l(bjVar);
        B(bjVar);
        H(bjVar);
        c(bjVar);
        I(bjVar);
        setVisibility(0);
        G(bjVar);
        F(bjVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.dei != null) {
            this.dei.setDefaultResource(17170445);
            this.dei.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dei.setPlaceHolder(1);
            this.dei.setIsRound(true);
            this.dei.setAfterClickListener(this.MX);
        }
    }

    private void F(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.azX() != null && bjVar.azX().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.azX().getAlaUserData();
                if (this.deI != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFM = alaUserData;
                    aVar.type = 1;
                    this.deI.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.deI.setVisibility(8);
                    } else {
                        this.deI.setVisibility(0);
                    }
                }
            } else if (this.deI != null) {
                this.deI.setVisibility(8);
            }
        }
    }

    private void G(bj bjVar) {
        if (this.deH != null && bjVar != null && bjVar.azX() != null) {
            if (bjVar.azX().hadConcerned()) {
                this.deH.setVisibility(0);
                am.setViewTextColor(this.deH, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.deH, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.deH.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.MP != null && bjVar != null && bjVar.azX() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.azX().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MP.setVisibility(0);
                this.MP.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.MP.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.MN != null && bjVar != null && bjVar.azX() != null) {
            MetaData azX = bjVar.azX();
            if (azX.getIs_bawu() == 1) {
                int i = bjVar.cPY ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.cPY ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.MN, i);
                am.setViewTextColor(this.MN, i2);
                if (bjVar.cPY) {
                    this.MN.setVisibility(0);
                    this.MN.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(azX.getBawu_type())) {
                    this.MN.setVisibility(0);
                    this.MN.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(azX.getBawu_type())) {
                    this.MN.setText(R.string.bawu_member_xbazhu_tip);
                    this.MN.setVisibility(0);
                } else if ("pri_content_assist".equals(azX.getBawu_type())) {
                    this.MN.setText(R.string.bawu_content_assist_tip);
                    this.MN.setVisibility(0);
                } else if ("pri_manage_assist".equals(azX.getBawu_type())) {
                    this.MN.setText(R.string.bawu_manage_assist_tip);
                    this.MN.setVisibility(0);
                } else if (azX.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.MN.setVisibility(8);
                }
            } else if (azX.getIs_biggie()) {
                m(bjVar);
            } else {
                this.MN.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.MN, R.drawable.brand_official_btn);
        am.setViewTextColor(this.MN, (int) R.color.cp_link_tip_a);
        this.MN.setText(R.string.video_mcn);
        if (bjVar.aBd()) {
            this.MO.setVisibility(8);
        }
        this.MN.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.MK != null && bjVar != null) {
            if (!StringUtils.isNull(this.Kn.azX().getName_show())) {
                this.MK.setText(tI(this.Kn.azX().getName_show()));
            }
            nc();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.Kn.azX().getName_show();
                String userName = this.Kn.azX().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.MK.setText(com.baidu.tieba.pb.d.ba(this.mContext, this.MK.getText().toString()));
                    this.MK.setGravity(16);
                    this.MK.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.cix());
                    am.setViewTextColor(this.MK, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.MO != null) {
            if (this.deN) {
                this.MO.setVisibility(8);
            } else if (bjVar == null || bjVar.azX() == null || ((bjVar.cPL > 0 && bjVar.cPM == 0) || !this.deK)) {
                this.MO.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.azX().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.MO.setVisibility(0);
                    this.MO.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.MO.setVisibility(8);
            }
        }
    }

    private void B(bj bjVar) {
        String formatTime;
        if (this.dcZ != null && bjVar != null) {
            if (bjVar.azQ() <= 0) {
                this.dcZ.setVisibility(4);
                return;
            }
            this.dcZ.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.azQ());
            } else if (bjVar.aBl()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aAb()) {
                formatTime = aq.bz(bjVar.azQ() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.azQ() * 1000);
            }
            this.dcZ.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.MR == null || bjVar == null) {
            this.MR.setVisibility(8);
        } else if (this.deN) {
            if (StringUtils.isNull(bjVar.axR())) {
                this.MR.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MR.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.MR.setLayoutParams(layoutParams);
            }
            this.MR.setText(bjVar.axR());
            this.MR.setVisibility(0);
        } else if (this.Kn.aAq() == null || this.Kn.aAq().share_info == null || this.Kn.aAq().share_info.share_user_count <= 0 || !this.Kn.aBo() || (this.Kn.cPL > 0 && this.Kn.cPM == 0)) {
            this.MR.setVisibility(8);
        } else {
            this.MR.setVisibility(0);
            int i = this.Kn.aAq().share_info.share_user_count;
            if (i == 1) {
                this.MR.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.MR.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void H(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.deF.setVisibility(8);
            this.deG.setVisibility(8);
            return;
        }
        this.deF.setText(this.Kn.getAddress());
        this.deF.setVisibility(0);
        this.deG.setVisibility(0);
    }

    public void I(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.ddX.setVisibility(8);
            this.deL.setVisibility(8);
            return;
        }
        String aAc = this.Kn.aAc();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aAc = null;
        } else if (this.mFrom == 5) {
            aAc = bjVar.aBI();
        }
        if (bjVar.aBH()) {
            aAc = bjVar.cPX.ori_fname;
        }
        if (StringUtils.isNull(aAc)) {
            this.ddX.setVisibility(8);
            this.deL.setVisibility(8);
            return;
        }
        if (this.Kn.cPL > 0 && this.Kn.cPM == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(aAc, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.ddX.setText(str);
        this.ddX.setVisibility(0);
        this.deL.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fK(boolean z) {
        if (z) {
            I(this.Kn);
            return;
        }
        this.ddX.setVisibility(8);
        this.deL.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.dei != null && bjVar != null && this.Kn.azX() != null) {
            if (this.Kn.cPL > 0 && this.Kn.cPM == 0) {
                this.dei.setShowV(false);
            } else {
                this.dei.setShowV(this.Kn.azX().isBigV());
            }
        }
    }

    private void nc() {
        if (this.Kn != null && this.Kn.azX() != null) {
            if (this.Kn.cPL > 0 && this.Kn.cPM == 0) {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Kn.azX().getTShowInfoNew()) || this.Kn.azX().isBigV()) {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_f);
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
        nc();
        am.setViewTextColor(this.MR, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dcZ, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.deG, R.color.cp_cont_e);
        am.setViewTextColor(this.deF, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ddX, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.deG, R.color.cp_cont_e);
        am.setBackgroundColor(this.deL, R.color.cp_cont_e);
        l(this.Kn);
    }

    public void setIsSimpleThread(boolean z) {
        this.deM = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.deM;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MX = onClickListener;
        if (this.dei != null) {
            this.dei.setAfterClickListener(this.MX);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dei != null) {
            this.dei.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dei;
    }

    public TextView getUserName() {
        return this.MK;
    }

    protected String tI(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.deK = z;
    }

    public void setIsFromConcern(boolean z) {
        this.deN = z;
    }
}

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
    private bj KJ;
    private View.OnClickListener NF;
    private View.OnClickListener NG;
    private View.OnClickListener NH;
    public TextView Nl;
    public TextView Nm;
    protected UserIconBox Nn;
    private UserIconBox No;
    protected TextView Nq;
    private View.OnClickListener Nw;
    private TextView dhe;
    private TextView diL;
    private View diM;
    private TextView diN;
    private View diO;
    private FrameLayout diP;
    private boolean diQ;
    private View diR;
    private boolean diS;
    private boolean diT;
    private TextView dib;
    public ClickableHeaderImageView din;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.diQ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getUserId()) && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCm().getUserId(), ThreadUserInfoLayout.this.KJ.aCm().getName_show(), ThreadUserInfoLayout.this.KJ.aCr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nw != null) {
                        ThreadUserInfoLayout.this.Nw.onClick(view);
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diQ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getUserId()) && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCm().getUserId(), ThreadUserInfoLayout.this.KJ.aCm().getName_show(), ThreadUserInfoLayout.this.KJ.aCr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nw != null) {
                        ThreadUserInfoLayout.this.Nw.onClick(view);
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diQ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCm().getUserId()) && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCm().getUserId(), ThreadUserInfoLayout.this.KJ.aCm().getName_show(), ThreadUserInfoLayout.this.KJ.aCr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nw != null) {
                        ThreadUserInfoLayout.this.Nw.onClick(view);
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCm() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.din = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.No = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.Nl = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Nm = (TextView) inflate.findViewById(R.id.identity_view);
        this.Nn = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dhe = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.diL = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.diM = inflate.findViewById(R.id.divider);
        this.diR = findViewById(R.id.divider_forum_name);
        this.dib = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Nq = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.diN = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.diP = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.diO = com.baidu.tbadk.ala.b.ayz().u(this.mContext, 1);
        if (this.diO != null) {
            this.diO.setVisibility(8);
            this.diP.addView(this.diO);
        }
        setGravity(16);
        initHeaderImg();
        this.No.setOnClickListener(this.NF);
        this.Nl.setOnClickListener(this.NG);
        this.Nn.setOnClickListener(this.NH);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.KJ = bjVar;
        if (this.KJ.cTN > 0) {
            if (this.KJ.cTO == 0 && this.KJ.aCm() != null) {
                if (!v.isEmpty(this.KJ.aCm().getTShowInfoNew())) {
                    this.KJ.aCm().getTShowInfoNew().clear();
                }
                this.KJ.aCm().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.No.setOnClickListener(null);
            this.Nl.setOnClickListener(null);
            this.Nn.setOnClickListener(null);
            this.din.setClickable(false);
        } else {
            this.No.setOnClickListener(this.NF);
            this.Nl.setOnClickListener(this.NG);
            this.Nn.setOnClickListener(this.NH);
            this.din.setClickable(true);
        }
        k(bjVar);
        h(bjVar);
        i(bjVar);
        j(bjVar);
        l(bjVar);
        C(bjVar);
        I(bjVar);
        c(bjVar);
        J(bjVar);
        setVisibility(0);
        H(bjVar);
        G(bjVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.din != null) {
            this.din.setDefaultResource(17170445);
            this.din.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.din.setPlaceHolder(1);
            this.din.setIsRound(true);
            this.din.setAfterClickListener(this.Nw);
        }
    }

    private void G(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.aCm() != null && bjVar.aCm().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCm().getAlaUserData();
                if (this.diO != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cJQ = alaUserData;
                    aVar.type = 1;
                    this.diO.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.diO.setVisibility(8);
                    } else {
                        this.diO.setVisibility(0);
                    }
                }
            } else if (this.diO != null) {
                this.diO.setVisibility(8);
            }
        }
    }

    private void H(bj bjVar) {
        if (this.diN != null && bjVar != null && bjVar.aCm() != null) {
            if (bjVar.aCm().hadConcerned()) {
                this.diN.setVisibility(0);
                am.setViewTextColor(this.diN, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.diN, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.diN.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.No != null && bjVar != null && bjVar.aCm() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.aCm().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.No.setVisibility(0);
                this.No.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.No.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.Nm != null && bjVar != null && bjVar.aCm() != null) {
            MetaData aCm = bjVar.aCm();
            if (aCm.getIs_bawu() == 1) {
                int i = bjVar.cUa ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.cUa ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.Nm, i);
                am.setViewTextColor(this.Nm, i2);
                if (bjVar.cUa) {
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aCm.getBawu_type())) {
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aCm.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_member_xbazhu_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_content_assist".equals(aCm.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_content_assist_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_manage_assist".equals(aCm.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_manage_assist_tip);
                    this.Nm.setVisibility(0);
                } else if (aCm.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.Nm.setVisibility(8);
                }
            } else if (aCm.getIs_biggie()) {
                m(bjVar);
            } else {
                this.Nm.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.Nm, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Nm, (int) R.color.cp_link_tip_a);
        this.Nm.setText(R.string.video_mcn);
        if (bjVar.aDq()) {
            this.Nn.setVisibility(8);
        }
        this.Nm.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.Nl != null && bjVar != null) {
            if (!StringUtils.isNull(this.KJ.aCm().getName_show())) {
                this.Nl.setText(tY(this.KJ.aCm().getName_show()));
            }
            nt();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.KJ.aCm().getName_show();
                String userName = this.KJ.aCm().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.Nl.setText(com.baidu.tieba.pb.c.ba(this.mContext, this.Nl.getText().toString()));
                    this.Nl.setGravity(16);
                    this.Nl.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.ckb());
                    am.setViewTextColor(this.Nl, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.Nn != null) {
            if (this.diT) {
                this.Nn.setVisibility(8);
            } else if (bjVar == null || bjVar.aCm() == null || ((bjVar.cTN > 0 && bjVar.cTO == 0) || !this.diQ)) {
                this.Nn.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aCm().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.Nn.setVisibility(0);
                    this.Nn.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.Nn.setVisibility(8);
            }
        }
    }

    private void C(bj bjVar) {
        String formatTime;
        if (this.dhe != null && bjVar != null) {
            if (bjVar.aCf() <= 0) {
                this.dhe.setVisibility(4);
                return;
            }
            this.dhe.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.aCf());
            } else if (bjVar.aDy()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aCq()) {
                formatTime = aq.bD(bjVar.aCf() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.aCf() * 1000);
            }
            this.dhe.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.Nq == null || bjVar == null) {
            this.Nq.setVisibility(8);
        } else if (this.diT) {
            if (StringUtils.isNull(bjVar.aAf())) {
                this.Nq.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nq.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Nq.setLayoutParams(layoutParams);
            }
            this.Nq.setText(bjVar.aAf());
            this.Nq.setVisibility(0);
        } else if (this.KJ.aCF() == null || this.KJ.aCF().share_info == null || this.KJ.aCF().share_info.share_user_count <= 0 || !this.KJ.aDB() || (this.KJ.cTN > 0 && this.KJ.cTO == 0)) {
            this.Nq.setVisibility(8);
        } else {
            this.Nq.setVisibility(0);
            int i = this.KJ.aCF().share_info.share_user_count;
            if (i == 1) {
                this.Nq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Nq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void I(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.diL.setVisibility(8);
            this.diM.setVisibility(8);
            return;
        }
        this.diL.setText(this.KJ.getAddress());
        this.diL.setVisibility(0);
        this.diM.setVisibility(0);
    }

    public void J(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.dib.setVisibility(8);
            this.diR.setVisibility(8);
            return;
        }
        this.KJ.aCr();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bjVar.aDU()) {
            str2 = bjVar.cTZ.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.dib.setVisibility(8);
            this.diR.setVisibility(8);
            return;
        }
        if (this.KJ.cTN > 0 && this.KJ.cTO == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.dib.setText(str);
        this.dib.setVisibility(0);
        this.diR.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fR(boolean z) {
        if (z) {
            J(this.KJ);
            return;
        }
        this.dib.setVisibility(8);
        this.diR.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.din != null && bjVar != null && this.KJ.aCm() != null) {
            if (this.KJ.cTN > 0 && this.KJ.cTO == 0) {
                this.din.setShowV(false);
            } else {
                this.din.setShowV(this.KJ.aCm().isBigV());
            }
        }
    }

    private void nt() {
        if (this.KJ != null && this.KJ.aCm() != null) {
            if (this.KJ.cTN > 0 && this.KJ.cTO == 0) {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.KJ.aCm().getTShowInfoNew()) || this.KJ.aCm().isBigV()) {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_f);
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
        nt();
        am.setViewTextColor(this.Nq, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dhe, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.diM, R.color.cp_cont_e);
        am.setViewTextColor(this.diL, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dib, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.diM, R.color.cp_cont_e);
        am.setBackgroundColor(this.diR, R.color.cp_cont_e);
        l(this.KJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.diS = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.diS;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
        if (this.din != null) {
            this.din.setAfterClickListener(this.Nw);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.din != null) {
            this.din.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.din;
    }

    public TextView getUserName() {
        return this.Nl;
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.diQ = z;
    }

    public void setIsFromConcern(boolean z) {
        this.diT = z;
    }
}

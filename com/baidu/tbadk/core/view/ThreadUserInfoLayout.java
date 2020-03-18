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
    private View.OnClickListener NG;
    private View.OnClickListener NH;
    private View.OnClickListener NI;
    public TextView Nm;
    public TextView Nn;
    protected UserIconBox No;
    private UserIconBox Np;
    protected TextView Nr;
    private View.OnClickListener Nx;
    private TextView dhF;
    private TextView diF;
    public ClickableHeaderImageView diQ;
    private TextView djm;
    private View djn;
    private TextView djo;
    private View djp;
    private FrameLayout djq;
    private boolean djr;
    private View djs;
    private boolean djt;
    private boolean dju;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.djr = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getUserId()) && ThreadUserInfoLayout.this.KJ.aCw() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCr().getUserId(), ThreadUserInfoLayout.this.KJ.aCr().getName_show(), ThreadUserInfoLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nx != null) {
                        ThreadUserInfoLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.NI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCr().getUserId(), true, true, true);
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
        this.djr = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getUserId()) && ThreadUserInfoLayout.this.KJ.aCw() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCr().getUserId(), ThreadUserInfoLayout.this.KJ.aCr().getName_show(), ThreadUserInfoLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nx != null) {
                        ThreadUserInfoLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.NI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCr().getUserId(), true, true, true);
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
        this.djr = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCr().getUserId()) && ThreadUserInfoLayout.this.KJ.aCw() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCr().getUserId(), ThreadUserInfoLayout.this.KJ.aCr().getName_show(), ThreadUserInfoLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.Nx != null) {
                        ThreadUserInfoLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.NI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCr().getUserId(), true, true, true);
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
        this.diQ = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.Np = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.Nm = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Nn = (TextView) inflate.findViewById(R.id.identity_view);
        this.No = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dhF = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.djm = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.djn = inflate.findViewById(R.id.divider);
        this.djs = findViewById(R.id.divider_forum_name);
        this.diF = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Nr = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.djo = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.djq = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.djp = com.baidu.tbadk.ala.b.ayE().u(this.mContext, 1);
        if (this.djp != null) {
            this.djp.setVisibility(8);
            this.djq.addView(this.djp);
        }
        setGravity(16);
        initHeaderImg();
        this.Np.setOnClickListener(this.NG);
        this.Nm.setOnClickListener(this.NH);
        this.No.setOnClickListener(this.NI);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.KJ = bjVar;
        if (this.KJ.cUc > 0) {
            if (this.KJ.cUd == 0 && this.KJ.aCr() != null) {
                if (!v.isEmpty(this.KJ.aCr().getTShowInfoNew())) {
                    this.KJ.aCr().getTShowInfoNew().clear();
                }
                this.KJ.aCr().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.Np.setOnClickListener(null);
            this.Nm.setOnClickListener(null);
            this.No.setOnClickListener(null);
            this.diQ.setClickable(false);
        } else {
            this.Np.setOnClickListener(this.NG);
            this.Nm.setOnClickListener(this.NH);
            this.No.setOnClickListener(this.NI);
            this.diQ.setClickable(true);
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
        if (this.diQ != null) {
            this.diQ.setDefaultResource(17170445);
            this.diQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.diQ.setPlaceHolder(1);
            this.diQ.setIsRound(true);
            this.diQ.setAfterClickListener(this.Nx);
        }
    }

    private void H(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.aCr() != null && bjVar.aCr().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCr().getAlaUserData();
                if (this.djp != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cKd = alaUserData;
                    aVar.type = 1;
                    this.djp.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.djp.setVisibility(8);
                    } else {
                        this.djp.setVisibility(0);
                    }
                }
            } else if (this.djp != null) {
                this.djp.setVisibility(8);
            }
        }
    }

    private void I(bj bjVar) {
        if (this.djo != null && bjVar != null && bjVar.aCr() != null) {
            if (bjVar.aCr().hadConcerned()) {
                this.djo.setVisibility(0);
                am.setViewTextColor(this.djo, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.djo, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.djo.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.Np != null && bjVar != null && bjVar.aCr() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.aCr().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Np.setVisibility(0);
                this.Np.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Np.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.Nn != null && bjVar != null && bjVar.aCr() != null) {
            MetaData aCr = bjVar.aCr();
            if (aCr.getIs_bawu() == 1) {
                int i = bjVar.cUp ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.cUp ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.Nn, i);
                am.setViewTextColor(this.Nn, i2);
                if (bjVar.cUp) {
                    this.Nn.setVisibility(0);
                    this.Nn.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aCr.getBawu_type())) {
                    this.Nn.setVisibility(0);
                    this.Nn.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aCr.getBawu_type())) {
                    this.Nn.setText(R.string.bawu_member_xbazhu_tip);
                    this.Nn.setVisibility(0);
                } else if ("pri_content_assist".equals(aCr.getBawu_type())) {
                    this.Nn.setText(R.string.bawu_content_assist_tip);
                    this.Nn.setVisibility(0);
                } else if ("pri_manage_assist".equals(aCr.getBawu_type())) {
                    this.Nn.setText(R.string.bawu_manage_assist_tip);
                    this.Nn.setVisibility(0);
                } else if (aCr.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.Nn.setVisibility(8);
                }
            } else if (aCr.getIs_biggie()) {
                m(bjVar);
            } else {
                this.Nn.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.Nn, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Nn, (int) R.color.cp_link_tip_a);
        this.Nn.setText(R.string.video_mcn);
        if (bjVar.aDw()) {
            this.No.setVisibility(8);
        }
        this.Nn.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.Nm != null && bjVar != null) {
            if (!StringUtils.isNull(this.KJ.aCr().getName_show())) {
                this.Nm.setText(tY(this.KJ.aCr().getName_show()));
            }
            nt();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.KJ.aCr().getName_show();
                String userName = this.KJ.aCr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.Nm.setText(com.baidu.tieba.pb.c.ba(this.mContext, this.Nm.getText().toString()));
                    this.Nm.setGravity(16);
                    this.Nm.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cky());
                    am.setViewTextColor(this.Nm, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.No != null) {
            if (this.dju) {
                this.No.setVisibility(8);
            } else if (bjVar == null || bjVar.aCr() == null || ((bjVar.cUc > 0 && bjVar.cUd == 0) || !this.djr)) {
                this.No.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aCr().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.No.setVisibility(0);
                    this.No.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.No.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String formatTime;
        if (this.dhF != null && bjVar != null) {
            if (bjVar.aCk() <= 0) {
                this.dhF.setVisibility(4);
                return;
            }
            this.dhF.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.aCk());
            } else if (bjVar.aDE()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aCv()) {
                formatTime = aq.bD(bjVar.aCk() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.aCk() * 1000);
            }
            this.dhF.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.Nr == null || bjVar == null) {
            this.Nr.setVisibility(8);
        } else if (this.dju) {
            if (StringUtils.isNull(bjVar.aAk())) {
                this.Nr.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nr.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Nr.setLayoutParams(layoutParams);
            }
            this.Nr.setText(bjVar.aAk());
            this.Nr.setVisibility(0);
        } else if (this.KJ.aCK() == null || this.KJ.aCK().share_info == null || this.KJ.aCK().share_info.share_user_count <= 0 || !this.KJ.aDH() || (this.KJ.cUc > 0 && this.KJ.cUd == 0)) {
            this.Nr.setVisibility(8);
        } else {
            this.Nr.setVisibility(0);
            int i = this.KJ.aCK().share_info.share_user_count;
            if (i == 1) {
                this.Nr.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Nr.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.djm.setVisibility(8);
            this.djn.setVisibility(8);
            return;
        }
        this.djm.setText(this.KJ.getAddress());
        this.djm.setVisibility(0);
        this.djn.setVisibility(0);
    }

    public void K(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.diF.setVisibility(8);
            this.djs.setVisibility(8);
            return;
        }
        this.KJ.aCw();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bjVar.aEa()) {
            str2 = bjVar.cUo.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.diF.setVisibility(8);
            this.djs.setVisibility(8);
            return;
        }
        if (this.KJ.cUc > 0 && this.KJ.cUd == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.diF.setText(str);
        this.diF.setVisibility(0);
        this.djs.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fS(boolean z) {
        if (z) {
            K(this.KJ);
            return;
        }
        this.diF.setVisibility(8);
        this.djs.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.diQ != null && bjVar != null && this.KJ.aCr() != null) {
            if (this.KJ.cUc > 0 && this.KJ.cUd == 0) {
                this.diQ.setShowV(false);
            } else {
                this.diQ.setShowV(this.KJ.aCr().isBigV());
            }
        }
    }

    private void nt() {
        if (this.KJ != null && this.KJ.aCr() != null) {
            if (this.KJ.cUc > 0 && this.KJ.cUd == 0) {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.KJ.aCr().getTShowInfoNew()) || this.KJ.aCr().isBigV()) {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_f);
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
        am.setViewTextColor(this.Nr, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dhF, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.djn, R.color.cp_cont_e);
        am.setViewTextColor(this.djm, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.diF, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.djn, R.color.cp_cont_e);
        am.setBackgroundColor(this.djs, R.color.cp_cont_e);
        l(this.KJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.djt = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.djt;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nx = onClickListener;
        if (this.diQ != null) {
            this.diQ.setAfterClickListener(this.Nx);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.diQ != null) {
            this.diQ.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.diQ;
    }

    public TextView getUserName() {
        return this.Nm;
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.djr = z;
    }

    public void setIsFromConcern(boolean z) {
        this.dju = z;
    }
}

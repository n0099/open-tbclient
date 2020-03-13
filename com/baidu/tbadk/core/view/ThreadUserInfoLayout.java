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
    private TextView dhs;
    public ClickableHeaderImageView diD;
    private TextView diZ;
    private TextView diq;
    private View dja;
    private TextView djb;
    private View djc;
    private FrameLayout djd;
    private boolean dje;
    private View djf;
    private boolean djg;
    private boolean djh;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.dje = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getUserId()) && ThreadUserInfoLayout.this.KJ.aCt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCo().getUserId(), ThreadUserInfoLayout.this.KJ.aCo().getName_show(), ThreadUserInfoLayout.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCo().getUserId(), true, true, true);
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
        this.dje = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getUserId()) && ThreadUserInfoLayout.this.KJ.aCt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCo().getUserId(), ThreadUserInfoLayout.this.KJ.aCo().getName_show(), ThreadUserInfoLayout.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCo().getUserId(), true, true, true);
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
        this.dje = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.NF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.KJ.aCo().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.KJ.aCo().getUserId()) && ThreadUserInfoLayout.this.KJ.aCt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.KJ.aCo().getUserId(), ThreadUserInfoLayout.this.KJ.aCo().getName_show(), ThreadUserInfoLayout.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
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
                if (ThreadUserInfoLayout.this.KJ != null && ThreadUserInfoLayout.this.KJ.aCo() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.KJ.aCo().getUserId(), true, true, true);
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
        this.diD = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.No = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.Nl = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Nm = (TextView) inflate.findViewById(R.id.identity_view);
        this.Nn = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dhs = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.diZ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dja = inflate.findViewById(R.id.divider);
        this.djf = findViewById(R.id.divider_forum_name);
        this.diq = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Nq = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.djb = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.djd = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.djc = com.baidu.tbadk.ala.b.ayB().u(this.mContext, 1);
        if (this.djc != null) {
            this.djc.setVisibility(8);
            this.djd.addView(this.djc);
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
        if (this.KJ.cTP > 0) {
            if (this.KJ.cTQ == 0 && this.KJ.aCo() != null) {
                if (!v.isEmpty(this.KJ.aCo().getTShowInfoNew())) {
                    this.KJ.aCo().getTShowInfoNew().clear();
                }
                this.KJ.aCo().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.No.setOnClickListener(null);
            this.Nl.setOnClickListener(null);
            this.Nn.setOnClickListener(null);
            this.diD.setClickable(false);
        } else {
            this.No.setOnClickListener(this.NF);
            this.Nl.setOnClickListener(this.NG);
            this.Nn.setOnClickListener(this.NH);
            this.diD.setClickable(true);
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
        if (this.diD != null) {
            this.diD.setDefaultResource(17170445);
            this.diD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.diD.setPlaceHolder(1);
            this.diD.setIsRound(true);
            this.diD.setAfterClickListener(this.Nw);
        }
    }

    private void G(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.aCo() != null && bjVar.aCo().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCo().getAlaUserData();
                if (this.djc != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cJS = alaUserData;
                    aVar.type = 1;
                    this.djc.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.djc.setVisibility(8);
                    } else {
                        this.djc.setVisibility(0);
                    }
                }
            } else if (this.djc != null) {
                this.djc.setVisibility(8);
            }
        }
    }

    private void H(bj bjVar) {
        if (this.djb != null && bjVar != null && bjVar.aCo() != null) {
            if (bjVar.aCo().hadConcerned()) {
                this.djb.setVisibility(0);
                am.setViewTextColor(this.djb, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.djb, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.djb.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.No != null && bjVar != null && bjVar.aCo() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.aCo().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.No.setVisibility(0);
                this.No.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.No.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.Nm != null && bjVar != null && bjVar.aCo() != null) {
            MetaData aCo = bjVar.aCo();
            if (aCo.getIs_bawu() == 1) {
                int i = bjVar.cUc ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.cUc ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.Nm, i);
                am.setViewTextColor(this.Nm, i2);
                if (bjVar.cUc) {
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_member_xbazhu_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_content_assist".equals(aCo.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_content_assist_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_manage_assist".equals(aCo.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_manage_assist_tip);
                    this.Nm.setVisibility(0);
                } else if (aCo.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.Nm.setVisibility(8);
                }
            } else if (aCo.getIs_biggie()) {
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
        if (bjVar.aDs()) {
            this.Nn.setVisibility(8);
        }
        this.Nm.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.Nl != null && bjVar != null) {
            if (!StringUtils.isNull(this.KJ.aCo().getName_show())) {
                this.Nl.setText(tZ(this.KJ.aCo().getName_show()));
            }
            nt();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.KJ.aCo().getName_show();
                String userName = this.KJ.aCo().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.Nl.setText(com.baidu.tieba.pb.c.ba(this.mContext, this.Nl.getText().toString()));
                    this.Nl.setGravity(16);
                    this.Nl.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cke());
                    am.setViewTextColor(this.Nl, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.Nn != null) {
            if (this.djh) {
                this.Nn.setVisibility(8);
            } else if (bjVar == null || bjVar.aCo() == null || ((bjVar.cTP > 0 && bjVar.cTQ == 0) || !this.dje)) {
                this.Nn.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aCo().getIconInfo();
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
        if (this.dhs != null && bjVar != null) {
            if (bjVar.aCh() <= 0) {
                this.dhs.setVisibility(4);
                return;
            }
            this.dhs.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.aCh());
            } else if (bjVar.aDA()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aCs()) {
                formatTime = aq.bD(bjVar.aCh() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.aCh() * 1000);
            }
            this.dhs.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.Nq == null || bjVar == null) {
            this.Nq.setVisibility(8);
        } else if (this.djh) {
            if (StringUtils.isNull(bjVar.aAh())) {
                this.Nq.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nq.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Nq.setLayoutParams(layoutParams);
            }
            this.Nq.setText(bjVar.aAh());
            this.Nq.setVisibility(0);
        } else if (this.KJ.aCH() == null || this.KJ.aCH().share_info == null || this.KJ.aCH().share_info.share_user_count <= 0 || !this.KJ.aDD() || (this.KJ.cTP > 0 && this.KJ.cTQ == 0)) {
            this.Nq.setVisibility(8);
        } else {
            this.Nq.setVisibility(0);
            int i = this.KJ.aCH().share_info.share_user_count;
            if (i == 1) {
                this.Nq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Nq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void I(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.diZ.setVisibility(8);
            this.dja.setVisibility(8);
            return;
        }
        this.diZ.setText(this.KJ.getAddress());
        this.diZ.setVisibility(0);
        this.dja.setVisibility(0);
    }

    public void J(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.diq.setVisibility(8);
            this.djf.setVisibility(8);
            return;
        }
        this.KJ.aCt();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bjVar.aDW()) {
            str2 = bjVar.cUb.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.diq.setVisibility(8);
            this.djf.setVisibility(8);
            return;
        }
        if (this.KJ.cTP > 0 && this.KJ.cTQ == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.diq.setText(str);
        this.diq.setVisibility(0);
        this.djf.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fR(boolean z) {
        if (z) {
            J(this.KJ);
            return;
        }
        this.diq.setVisibility(8);
        this.djf.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.diD != null && bjVar != null && this.KJ.aCo() != null) {
            if (this.KJ.cTP > 0 && this.KJ.cTQ == 0) {
                this.diD.setShowV(false);
            } else {
                this.diD.setShowV(this.KJ.aCo().isBigV());
            }
        }
    }

    private void nt() {
        if (this.KJ != null && this.KJ.aCo() != null) {
            if (this.KJ.cTP > 0 && this.KJ.cTQ == 0) {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.KJ.aCo().getTShowInfoNew()) || this.KJ.aCo().isBigV()) {
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
        am.setViewTextColor(this.dhs, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dja, R.color.cp_cont_e);
        am.setViewTextColor(this.diZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.diq, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dja, R.color.cp_cont_e);
        am.setBackgroundColor(this.djf, R.color.cp_cont_e);
        l(this.KJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.djg = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.djg;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
        if (this.diD != null) {
            this.diD.setAfterClickListener(this.Nw);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.diD != null) {
            this.diD.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.diD;
    }

    public TextView getUserName() {
        return this.Nl;
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.dje = z;
    }

    public void setIsFromConcern(boolean z) {
        this.djh = z;
    }
}

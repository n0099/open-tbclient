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
    private bj adJ;
    public TextView afZ;
    public TextView aga;
    protected UserIconBox agb;
    private UserIconBox agc;
    protected TextView agf;
    private View.OnClickListener agl;
    private View.OnClickListener ags;
    private View.OnClickListener agt;
    private View.OnClickListener agu;
    private TextView dHE;
    private TextView dIC;
    public ClickableHeaderImageView dIN;
    private TextView dJj;
    private View dJk;
    private TextView dJl;
    private View dJm;
    private FrameLayout dJn;
    private boolean dJo;
    private View dJp;
    private boolean dJq;
    private boolean dJr;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.dJo = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ags = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getUserId()) && ThreadUserInfoLayout.this.adJ.aKH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adJ.aKC().getUserId(), ThreadUserInfoLayout.this.adJ.aKC().getName_show(), ThreadUserInfoLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agl != null) {
                        ThreadUserInfoLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.agu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adJ.aKC().getUserId(), true, true, true);
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
        this.dJo = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ags = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getUserId()) && ThreadUserInfoLayout.this.adJ.aKH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adJ.aKC().getUserId(), ThreadUserInfoLayout.this.adJ.aKC().getName_show(), ThreadUserInfoLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agl != null) {
                        ThreadUserInfoLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.agu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adJ.aKC().getUserId(), true, true, true);
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
        this.dJo = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ags = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.adJ.aKC().getUserId()) && ThreadUserInfoLayout.this.adJ.aKH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.adJ.aKC().getUserId(), ThreadUserInfoLayout.this.adJ.aKC().getName_show(), ThreadUserInfoLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.adJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agl != null) {
                        ThreadUserInfoLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.agu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.adJ != null && ThreadUserInfoLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.adJ.aKC().getUserId(), true, true, true);
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
        this.dIN = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.agc = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.afZ = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.aga = (TextView) inflate.findViewById(R.id.identity_view);
        this.agb = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dHE = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.dJj = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dJk = inflate.findViewById(R.id.divider);
        this.dJp = findViewById(R.id.divider_forum_name);
        this.dIC = (TextView) findViewById(R.id.thread_info_forum_name);
        this.agf = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.dJl = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.dJn = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.dJm = com.baidu.tbadk.ala.b.aGN().p(this.mContext, 1);
        if (this.dJm != null) {
            this.dJm.setVisibility(8);
            this.dJn.addView(this.dJm);
        }
        setGravity(16);
        initHeaderImg();
        this.agc.setOnClickListener(this.ags);
        this.afZ.setOnClickListener(this.agt);
        this.agb.setOnClickListener(this.agu);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.adJ = bjVar;
        if (this.adJ.dtq > 0) {
            if (this.adJ.dtr == 0 && this.adJ.aKC() != null) {
                if (!v.isEmpty(this.adJ.aKC().getTShowInfoNew())) {
                    this.adJ.aKC().getTShowInfoNew().clear();
                }
                this.adJ.aKC().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.agc.setOnClickListener(null);
            this.afZ.setOnClickListener(null);
            this.agb.setOnClickListener(null);
            this.dIN.setClickable(false);
        } else {
            this.agc.setOnClickListener(this.ags);
            this.afZ.setOnClickListener(this.agt);
            this.agb.setOnClickListener(this.agu);
            this.dIN.setClickable(true);
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
        if (this.dIN != null) {
            this.dIN.setDefaultResource(17170445);
            this.dIN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dIN.setPlaceHolder(1);
            this.dIN.setIsRound(true);
            this.dIN.setAfterClickListener(this.agl);
        }
    }

    private void H(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.aKC() != null && bjVar.aKC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKC().getAlaUserData();
                if (this.dJm != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djn = alaUserData;
                    aVar.type = 1;
                    this.dJm.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.dJm.setVisibility(8);
                    } else {
                        this.dJm.setVisibility(0);
                    }
                }
            } else if (this.dJm != null) {
                this.dJm.setVisibility(8);
            }
        }
    }

    private void I(bj bjVar) {
        if (this.dJl != null && bjVar != null && bjVar.aKC() != null) {
            if (bjVar.aKC().hadConcerned()) {
                this.dJl.setVisibility(0);
                am.setViewTextColor(this.dJl, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.dJl, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.dJl.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.agc != null && bjVar != null && bjVar.aKC() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.aKC().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agc.setVisibility(0);
                this.agc.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.agc.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.aga != null && bjVar != null && bjVar.aKC() != null) {
            MetaData aKC = bjVar.aKC();
            if (aKC.getIs_bawu() == 1) {
                int i = bjVar.dtE ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.dtE ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.aga, i);
                am.setViewTextColor(this.aga, i2);
                if (bjVar.dtE) {
                    this.aga.setVisibility(0);
                    this.aga.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aKC.getBawu_type())) {
                    this.aga.setVisibility(0);
                    this.aga.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aKC.getBawu_type())) {
                    this.aga.setText(R.string.bawu_member_xbazhu_tip);
                    this.aga.setVisibility(0);
                } else if ("pri_content_assist".equals(aKC.getBawu_type())) {
                    this.aga.setText(R.string.bawu_content_assist_tip);
                    this.aga.setVisibility(0);
                } else if ("pri_manage_assist".equals(aKC.getBawu_type())) {
                    this.aga.setText(R.string.bawu_manage_assist_tip);
                    this.aga.setVisibility(0);
                } else if (aKC.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.aga.setVisibility(8);
                }
            } else if (aKC.getIs_biggie()) {
                m(bjVar);
            } else {
                this.aga.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.aga, R.drawable.brand_official_btn);
        am.setViewTextColor(this.aga, (int) R.color.cp_link_tip_a);
        this.aga.setText(R.string.video_mcn);
        if (bjVar.aLH()) {
            this.agb.setVisibility(8);
        }
        this.aga.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.afZ != null && bjVar != null) {
            if (!StringUtils.isNull(this.adJ.aKC().getName_show())) {
                this.afZ.setText(vp(this.adJ.aKC().getName_show()));
            }
            rM();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.adJ.aKC().getName_show();
                String userName = this.adJ.aKC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.afZ.setText(com.baidu.tieba.pb.c.aJ(this.mContext, this.afZ.getText().toString()));
                    this.afZ.setGravity(16);
                    this.afZ.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cva());
                    am.setViewTextColor(this.afZ, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.agb != null) {
            if (this.dJr) {
                this.agb.setVisibility(8);
            } else if (bjVar == null || bjVar.aKC() == null || ((bjVar.dtq > 0 && bjVar.dtr == 0) || !this.dJo)) {
                this.agb.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aKC().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.agb.setVisibility(0);
                    this.agb.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.agb.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String formatTime;
        if (this.dHE != null && bjVar != null) {
            if (bjVar.aKv() <= 0) {
                this.dHE.setVisibility(4);
                return;
            }
            this.dHE.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.aKv());
            } else if (bjVar.aLQ()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.aKG()) {
                formatTime = aq.cj(bjVar.aKv() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.aKv() * 1000);
            }
            this.dHE.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.agf == null || bjVar == null) {
            this.agf.setVisibility(8);
        } else if (this.dJr) {
            if (StringUtils.isNull(bjVar.aIv())) {
                this.agf.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agf.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.agf.setLayoutParams(layoutParams);
            }
            this.agf.setText(bjVar.aIv());
            this.agf.setVisibility(0);
        } else if (this.adJ.aKV() == null || this.adJ.aKV().share_info == null || this.adJ.aKV().share_info.share_user_count <= 0 || !this.adJ.aLT() || (this.adJ.dtq > 0 && this.adJ.dtr == 0)) {
            this.agf.setVisibility(8);
        } else {
            this.agf.setVisibility(0);
            int i = this.adJ.aKV().share_info.share_user_count;
            if (i == 1) {
                this.agf.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.agf.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void J(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dJj.setVisibility(8);
            this.dJk.setVisibility(8);
            return;
        }
        this.dJj.setText(this.adJ.getAddress());
        this.dJj.setVisibility(0);
        this.dJk.setVisibility(0);
    }

    public void K(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.dIC.setVisibility(8);
            this.dJp.setVisibility(8);
            return;
        }
        this.adJ.aKH();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bjVar.aMm()) {
            str2 = bjVar.dtD.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.dIC.setVisibility(8);
            this.dJp.setVisibility(8);
            return;
        }
        if (this.adJ.dtq > 0 && this.adJ.dtr == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.dIC.setText(str);
        this.dIC.setVisibility(0);
        this.dJp.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void gQ(boolean z) {
        if (z) {
            K(this.adJ);
            return;
        }
        this.dIC.setVisibility(8);
        this.dJp.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.dIN != null && bjVar != null && this.adJ.aKC() != null) {
            if (this.adJ.dtq > 0 && this.adJ.dtr == 0) {
                this.dIN.setShowV(false);
            } else {
                this.dIN.setShowV(this.adJ.aKC().isBigV());
            }
        }
    }

    private void rM() {
        if (this.adJ != null && this.adJ.aKC() != null) {
            if (this.adJ.dtq > 0 && this.adJ.dtr == 0) {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.adJ.aKC().getTShowInfoNew()) || this.adJ.aKC().isBigV()) {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_f);
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
        am.setViewTextColor(this.agf, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dHE, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dJk, R.color.cp_cont_e);
        am.setViewTextColor(this.dJj, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dIC, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dJk, R.color.cp_cont_e);
        am.setBackgroundColor(this.dJp, R.color.cp_cont_e);
        l(this.adJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.dJq = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.dJq;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agl = onClickListener;
        if (this.dIN != null) {
            this.dIN.setAfterClickListener(this.agl);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dIN != null) {
            this.dIN.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.dIN;
    }

    public TextView getUserName() {
        return this.afZ;
    }

    protected String vp(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.dJo = z;
    }

    public void setIsFromConcern(boolean z) {
        this.dJr = z;
    }
}

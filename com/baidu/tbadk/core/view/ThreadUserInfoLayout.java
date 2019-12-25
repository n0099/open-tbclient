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
    private bj Ki;
    public TextView ME;
    public TextView MF;
    protected UserIconBox MG;
    private UserIconBox MH;
    protected TextView MJ;
    private View MP;
    private FrameLayout MQ;
    private View.OnClickListener MT;
    private View.OnClickListener Na;
    private View.OnClickListener Nb;
    private View.OnClickListener Nc;
    private TextView dcP;
    private TextView ddN;
    public ClickableHeaderImageView ddY;
    private boolean deA;
    private boolean deB;
    private TextView dev;
    private View dew;
    private TextView dex;
    private boolean dey;
    private View dez;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.dey = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Na = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getUserId()) && ThreadUserInfoLayout.this.Ki.azJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Ki.azE().getUserId(), ThreadUserInfoLayout.this.Ki.azE().getName_show(), ThreadUserInfoLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Ki.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MT != null) {
                        ThreadUserInfoLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.Nc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Ki.azE().getUserId(), true, true, true);
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
        this.dey = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Na = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getUserId()) && ThreadUserInfoLayout.this.Ki.azJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Ki.azE().getUserId(), ThreadUserInfoLayout.this.Ki.azE().getName_show(), ThreadUserInfoLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Ki.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MT != null) {
                        ThreadUserInfoLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.Nc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Ki.azE().getUserId(), true, true, true);
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
        this.dey = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Na = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Ki.azE().getUserId()) && ThreadUserInfoLayout.this.Ki.azJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Ki.azE().getUserId(), ThreadUserInfoLayout.this.Ki.azE().getName_show(), ThreadUserInfoLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Ki.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.MT != null) {
                        ThreadUserInfoLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.Nc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Ki != null && ThreadUserInfoLayout.this.Ki.azE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Ki.azE().getUserId(), true, true, true);
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
        this.ddY = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.MH = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ME = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.MF = (TextView) inflate.findViewById(R.id.identity_view);
        this.MG = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dcP = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.dev = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dew = inflate.findViewById(R.id.divider);
        this.dez = findViewById(R.id.divider_forum_name);
        this.ddN = (TextView) findViewById(R.id.thread_info_forum_name);
        this.MJ = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.dex = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.MQ = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.MP = com.baidu.tbadk.ala.b.avT().u(this.mContext, 1);
        if (this.MP != null) {
            this.MP.setVisibility(8);
            this.MQ.addView(this.MP);
        }
        setGravity(16);
        initHeaderImg();
        this.MH.setOnClickListener(this.Na);
        this.ME.setOnClickListener(this.Nb);
        this.MG.setOnClickListener(this.Nc);
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.Ki = bjVar;
        if (this.Ki.cPB > 0) {
            if (this.Ki.cPC == 0 && this.Ki.azE() != null) {
                if (!v.isEmpty(this.Ki.azE().getTShowInfoNew())) {
                    this.Ki.azE().getTShowInfoNew().clear();
                }
                this.Ki.azE().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.MH.setOnClickListener(null);
            this.ME.setOnClickListener(null);
            this.MG.setOnClickListener(null);
            this.ddY.setClickable(false);
        } else {
            this.MH.setOnClickListener(this.Na);
            this.ME.setOnClickListener(this.Nb);
            this.MG.setOnClickListener(this.Nc);
            this.ddY.setClickable(true);
        }
        k(bjVar);
        h(bjVar);
        i(bjVar);
        j(bjVar);
        l(bjVar);
        B(bjVar);
        G(bjVar);
        c(bjVar);
        H(bjVar);
        setVisibility(0);
        F(bjVar);
        g(bjVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.ddY != null) {
            this.ddY.setDefaultResource(17170445);
            this.ddY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ddY.setPlaceHolder(1);
            this.ddY.setIsRound(true);
            this.ddY.setAfterClickListener(this.MT);
        }
    }

    private void g(bj bjVar) {
        if (this.mFrom == 3) {
            if (bjVar != null && bjVar.azE() != null && bjVar.azE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.azE().getAlaUserData();
                if (this.MP != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFA = alaUserData;
                    aVar.type = 1;
                    this.MP.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.MP.setVisibility(8);
                    } else {
                        this.MP.setVisibility(0);
                    }
                }
            } else if (this.MP != null) {
                this.MP.setVisibility(8);
            }
        }
    }

    private void F(bj bjVar) {
        if (this.dex != null && bjVar != null && bjVar.azE() != null) {
            if (bjVar.azE().hadConcerned()) {
                this.dex.setVisibility(0);
                am.setViewTextColor(this.dex, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.dex, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.dex.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.MH != null && bjVar != null && bjVar.azE() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.azE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MH.setVisibility(0);
                this.MH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.MH.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.MF != null && bjVar != null && bjVar.azE() != null) {
            MetaData azE = bjVar.azE();
            if (azE.getIs_bawu() == 1) {
                int i = bjVar.cPO ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bjVar.cPO ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.MF, i);
                am.setViewTextColor(this.MF, i2);
                if (bjVar.cPO) {
                    this.MF.setVisibility(0);
                    this.MF.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(azE.getBawu_type())) {
                    this.MF.setVisibility(0);
                    this.MF.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(azE.getBawu_type())) {
                    this.MF.setText(R.string.bawu_member_xbazhu_tip);
                    this.MF.setVisibility(0);
                } else if ("pri_content_assist".equals(azE.getBawu_type())) {
                    this.MF.setText(R.string.bawu_content_assist_tip);
                    this.MF.setVisibility(0);
                } else if ("pri_manage_assist".equals(azE.getBawu_type())) {
                    this.MF.setText(R.string.bawu_manage_assist_tip);
                    this.MF.setVisibility(0);
                } else if (azE.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.MF.setVisibility(8);
                }
            } else if (azE.getIs_biggie()) {
                m(bjVar);
            } else {
                this.MF.setVisibility(8);
            }
        }
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.MF, R.drawable.brand_official_btn);
        am.setViewTextColor(this.MF, (int) R.color.cp_link_tip_a);
        this.MF.setText(R.string.video_mcn);
        if (bjVar.aAK()) {
            this.MG.setVisibility(8);
        }
        this.MF.setVisibility(0);
    }

    private void h(bj bjVar) {
        if (this.ME != null && bjVar != null) {
            if (!StringUtils.isNull(this.Ki.azE().getName_show())) {
                this.ME.setText(tE(this.Ki.azE().getName_show()));
            }
            nb();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.Ki.azE().getName_show();
                String userName = this.Ki.azE().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ME.setText(com.baidu.tieba.pb.d.aZ(this.mContext, this.ME.getText().toString()));
                    this.ME.setGravity(16);
                    this.ME.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.d.chp());
                    am.setViewTextColor(this.ME, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bj bjVar) {
        if (this.MG != null) {
            if (this.deB) {
                this.MG.setVisibility(8);
            } else if (bjVar == null || bjVar.azE() == null || ((bjVar.cPB > 0 && bjVar.cPC == 0) || !this.dey)) {
                this.MG.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.azE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.MG.setVisibility(0);
                    this.MG.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.MG.setVisibility(8);
            }
        }
    }

    private void B(bj bjVar) {
        String formatTime;
        if (this.dcP != null && bjVar != null) {
            if (bjVar.azx() <= 0) {
                this.dcP.setVisibility(4);
                return;
            }
            this.dcP.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bjVar.azx());
            } else if (bjVar.aAS()) {
                formatTime = aq.getFormatTime(bjVar.getCreateTime());
            } else if (bjVar.azI()) {
                formatTime = aq.bw(bjVar.azx() * 1000);
            } else {
                formatTime = aq.getFormatTime(bjVar.azx() * 1000);
            }
            this.dcP.setText(formatTime);
        }
    }

    protected void i(bj bjVar) {
        if (this.MJ == null || bjVar == null) {
            this.MJ.setVisibility(8);
        } else if (this.deB) {
            if (StringUtils.isNull(bjVar.axy())) {
                this.MJ.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MJ.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.MJ.setLayoutParams(layoutParams);
            }
            this.MJ.setText(bjVar.axy());
            this.MJ.setVisibility(0);
        } else if (this.Ki.azX() == null || this.Ki.azX().share_info == null || this.Ki.azX().share_info.share_user_count <= 0 || !this.Ki.aAV() || (this.Ki.cPB > 0 && this.Ki.cPC == 0)) {
            this.MJ.setVisibility(8);
        } else {
            this.MJ.setVisibility(0);
            int i = this.Ki.azX().share_info.share_user_count;
            if (i == 1) {
                this.MJ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.MJ.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void G(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.getAddress())) {
            this.dev.setVisibility(8);
            this.dew.setVisibility(8);
            return;
        }
        this.dev.setText(this.Ki.getAddress());
        this.dev.setVisibility(0);
        this.dew.setVisibility(0);
    }

    public void H(bj bjVar) {
        String str;
        if (bjVar == null) {
            this.ddN.setVisibility(8);
            this.dez.setVisibility(8);
            return;
        }
        String azJ = this.Ki.azJ();
        if (this.mFrom == 3 || this.mFrom == 4) {
            azJ = null;
        } else if (this.mFrom == 5) {
            azJ = bjVar.aBp();
        }
        if (bjVar.aBo()) {
            azJ = bjVar.cPN.ori_fname;
        }
        if (StringUtils.isNull(azJ)) {
            this.ddN.setVisibility(8);
            this.dez.setVisibility(8);
            return;
        }
        if (this.Ki.cPB > 0 && this.Ki.cPC == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(azJ, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.ddN.setText(str);
        this.ddN.setVisibility(0);
        this.dez.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.c
    public void fF(boolean z) {
        if (z) {
            H(this.Ki);
            return;
        }
        this.ddN.setVisibility(8);
        this.dez.setVisibility(8);
    }

    private void c(bj bjVar) {
        if (this.ddY != null && bjVar != null && this.Ki.azE() != null) {
            if (this.Ki.cPB > 0 && this.Ki.cPC == 0) {
                this.ddY.setShowV(false);
            } else {
                this.ddY.setShowV(this.Ki.azE().isBigV());
            }
        }
    }

    private void nb() {
        if (this.Ki != null && this.Ki.azE() != null) {
            if (this.Ki.cPB > 0 && this.Ki.cPC == 0) {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Ki.azE().getTShowInfoNew()) || this.Ki.azE().isBigV()) {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_f);
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
        nb();
        am.setViewTextColor(this.MJ, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dcP, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dew, R.color.cp_cont_e);
        am.setViewTextColor(this.dev, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ddN, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dew, R.color.cp_cont_e);
        am.setBackgroundColor(this.dez, R.color.cp_cont_e);
        l(this.Ki);
    }

    public void setIsSimpleThread(boolean z) {
        this.deA = z;
    }

    @Override // com.baidu.tbadk.core.view.c
    public boolean getIsSimpleThread() {
        return this.deA;
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
        if (this.ddY != null) {
            this.ddY.setAfterClickListener(this.MT);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddY != null) {
            this.ddY.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.c
    public ClickableHeaderImageView getHeaderImg() {
        return this.ddY;
    }

    public TextView getUserName() {
        return this.ME;
    }

    protected String tE(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.dey = z;
    }

    public void setIsFromConcern(boolean z) {
        this.deB = z;
    }
}

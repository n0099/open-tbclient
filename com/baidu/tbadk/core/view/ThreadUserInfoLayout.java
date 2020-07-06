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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bu aeK;
    public TextView ahA;
    public TextView ahB;
    protected UserIconBox ahC;
    private UserIconBox ahD;
    protected TextView ahH;
    private View.OnClickListener ahM;
    private View.OnClickListener ahT;
    private View.OnClickListener ahU;
    private View.OnClickListener ahV;
    private TextView edq;
    private TextView eeU;
    private View eeV;
    private TextView eeW;
    private View eeX;
    private FrameLayout eeY;
    private boolean eeZ;
    private TextView een;
    public ClickableHeaderImageView eey;
    private View efa;
    private boolean efb;
    private boolean efc;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.eeZ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew() != null && w.getItem(ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getUserId()) && ThreadUserInfoLayout.this.aeK.aSt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && be.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeK.aSp().getUserId(), ThreadUserInfoLayout.this.aeK.aSp().getName_show(), ThreadUserInfoLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeK.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahM != null) {
                        ThreadUserInfoLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.ahV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeZ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew() != null && w.getItem(ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getUserId()) && ThreadUserInfoLayout.this.aeK.aSt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && be.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeK.aSp().getUserId(), ThreadUserInfoLayout.this.aeK.aSp().getName_show(), ThreadUserInfoLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeK.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahM != null) {
                        ThreadUserInfoLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.ahV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eeZ = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew() != null && w.getItem(ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeK.aSp().getUserId()) && ThreadUserInfoLayout.this.aeK.aSt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && be.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeK.aSp().getUserId(), ThreadUserInfoLayout.this.aeK.aSp().getName_show(), ThreadUserInfoLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeK.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahM != null) {
                        ThreadUserInfoLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.ahV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeK != null && ThreadUserInfoLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.eey = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ahD = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ahA = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ahB = (TextView) inflate.findViewById(R.id.identity_view);
        this.ahC = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.edq = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.eeU = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eeV = inflate.findViewById(R.id.divider);
        this.efa = findViewById(R.id.divider_forum_name);
        this.een = (TextView) findViewById(R.id.thread_info_forum_name);
        this.ahH = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.eeW = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.eeY = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.eeX = com.baidu.tbadk.ala.b.aOf().p(this.mContext, 1);
        if (this.eeX != null) {
            this.eeX.setVisibility(8);
            this.eeY.addView(this.eeX);
        }
        setGravity(16);
        initHeaderImg();
        this.ahD.setOnClickListener(this.ahT);
        this.ahA.setOnClickListener(this.ahU);
        this.ahC.setOnClickListener(this.ahV);
    }

    public boolean setData(bu buVar) {
        if (buVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeK = buVar;
        if (this.aeK.dNV > 0) {
            if (this.aeK.dNW == 0 && this.aeK.aSp() != null) {
                if (!w.isEmpty(this.aeK.aSp().getTShowInfoNew())) {
                    this.aeK.aSp().getTShowInfoNew().clear();
                }
                this.aeK.aSp().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ahD.setOnClickListener(null);
            this.ahA.setOnClickListener(null);
            this.ahC.setOnClickListener(null);
            this.eey.setClickable(false);
        } else {
            this.ahD.setOnClickListener(this.ahT);
            this.ahA.setOnClickListener(this.ahU);
            this.ahC.setOnClickListener(this.ahV);
            this.eey.setClickable(true);
        }
        k(buVar);
        h(buVar);
        i(buVar);
        j(buVar);
        l(buVar);
        E(buVar);
        K(buVar);
        c(buVar);
        L(buVar);
        setVisibility(0);
        J(buVar);
        I(buVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.eey != null) {
            this.eey.setDefaultResource(17170445);
            this.eey.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eey.setPlaceHolder(1);
            this.eey.setIsRound(true);
            this.eey.setAfterClickListener(this.ahM);
        }
    }

    private void I(bu buVar) {
        if (this.mFrom == 3) {
            if (buVar != null && buVar.aSp() != null && buVar.aSp().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = buVar.aSp().getAlaUserData();
                if (this.eeX != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dCt = alaUserData;
                    aVar.type = 1;
                    this.eeX.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.eeX.setVisibility(8);
                    } else {
                        this.eeX.setVisibility(0);
                    }
                }
            } else if (this.eeX != null) {
                this.eeX.setVisibility(8);
            }
        }
    }

    private void J(bu buVar) {
        if (this.eeW != null && buVar != null && buVar.aSp() != null) {
            if (buVar.aSp().hadConcerned()) {
                this.eeW.setVisibility(0);
                an.setViewTextColor(this.eeW, (int) R.color.cp_cont_d);
                an.setBackgroundResource(this.eeW, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.eeW.setVisibility(8);
        }
    }

    private void k(bu buVar) {
        if (this.ahD != null && buVar != null && buVar.aSp() != null) {
            ArrayList<IconData> tShowInfoNew = buVar.aSp().getTShowInfoNew();
            if (w.getCount(tShowInfoNew) != 0) {
                this.ahD.setVisibility(0);
                this.ahD.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ahD.setVisibility(8);
        }
    }

    private void l(bu buVar) {
        if (this.ahB != null && buVar != null && buVar.aSp() != null) {
            MetaData aSp = buVar.aSp();
            if (aSp.getIs_bawu() == 1) {
                int i = buVar.dOj ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = buVar.dOj ? R.color.cp_cont_a : R.color.cp_cont_j;
                an.setBackgroundResource(this.ahB, i);
                an.setViewTextColor(this.ahB, i2);
                if (buVar.dOj) {
                    this.ahB.setVisibility(0);
                    this.ahB.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(aSp.getBawu_type())) {
                    this.ahB.setVisibility(0);
                    this.ahB.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(aSp.getBawu_type())) {
                    this.ahB.setText(R.string.bawu_member_xbazhu_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(aSp.getBawu_type())) {
                    this.ahB.setText(R.string.bawu_content_assist_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(aSp.getBawu_type())) {
                    this.ahB.setText(R.string.bawu_manage_assist_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else {
                    this.ahB.setVisibility(8);
                    return;
                }
            }
            this.ahB.setVisibility(8);
        }
    }

    private void h(bu buVar) {
        if (this.ahA != null && buVar != null) {
            if (!StringUtils.isNull(this.aeK.aSp().getName_show())) {
                this.ahA.setText(xm(this.aeK.aSp().getName_show()));
            }
            sr();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.aeK.aSp().getName_show();
                String userName = this.aeK.aSp().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ahA.setText(com.baidu.tieba.pb.c.aK(this.mContext, this.ahA.getText().toString()));
                    this.ahA.setGravity(16);
                    this.ahA.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cGy());
                    an.setViewTextColor(this.ahA, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bu buVar) {
        if (this.ahC != null) {
            if (this.efc) {
                this.ahC.setVisibility(8);
            } else if (buVar == null || buVar.aSp() == null || ((buVar.dNV > 0 && buVar.dNW == 0) || !this.eeZ)) {
                this.ahC.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = buVar.aSp().getIconInfo();
                if (w.getCount(iconInfo) != 0) {
                    this.ahC.setVisibility(0);
                    this.ahC.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.ahC.setVisibility(8);
            }
        }
    }

    private void E(bu buVar) {
        String formatTime;
        if (this.edq != null && buVar != null) {
            if (buVar.aSi() <= 0) {
                this.edq.setVisibility(4);
                return;
            }
            this.edq.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = ar.getPostTimeInterval(buVar.aSi());
            } else if (buVar.aTG()) {
                formatTime = ar.getFormatTime(buVar.getCreateTime());
            } else {
                formatTime = ar.getFormatTime(buVar.aSi() * 1000);
            }
            this.edq.setText(formatTime);
        }
    }

    protected void i(bu buVar) {
        if (this.ahH == null || buVar == null) {
            this.ahH.setVisibility(8);
        } else if (this.efc) {
            if (StringUtils.isNull(buVar.aPT())) {
                this.ahH.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahH.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ahH.setLayoutParams(layoutParams);
            }
            this.ahH.setText(buVar.aPT());
            this.ahH.setVisibility(0);
        } else if (this.aeK.aSJ() == null || this.aeK.aSJ().share_info == null || this.aeK.aSJ().share_info.share_user_count <= 0 || !this.aeK.aTJ() || (this.aeK.dNV > 0 && this.aeK.dNW == 0)) {
            this.ahH.setVisibility(8);
        } else {
            this.ahH.setVisibility(0);
            int i = this.aeK.aSJ().share_info.share_user_count;
            if (i == 1) {
                this.ahH.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.ahH.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{ar.numberUniform(i)}));
            }
        }
    }

    private void K(bu buVar) {
        if (buVar == null || StringUtils.isNull(buVar.getAddress())) {
            this.eeU.setVisibility(8);
            this.eeV.setVisibility(8);
            return;
        }
        this.eeU.setText(this.aeK.getAddress());
        this.eeU.setVisibility(0);
        this.eeV.setVisibility(0);
    }

    public void L(bu buVar) {
        String str;
        if (buVar == null) {
            this.een.setVisibility(8);
            this.efa.setVisibility(8);
            return;
        }
        this.aeK.aSt();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (buVar.aUc()) {
            str2 = buVar.dOi.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.een.setVisibility(8);
            this.efa.setVisibility(8);
            return;
        }
        if (this.aeK.dNV > 0 && this.aeK.dNW == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = ar.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.een.setText(str);
        this.een.setVisibility(0);
        this.efa.setVisibility(0);
    }

    public void hz(boolean z) {
        if (z) {
            L(this.aeK);
            return;
        }
        this.een.setVisibility(8);
        this.efa.setVisibility(8);
    }

    private void c(bu buVar) {
        if (this.eey != null && buVar != null && this.aeK.aSp() != null) {
            if (this.aeK.dNV > 0 && this.aeK.dNW == 0) {
                this.eey.setShowV(false);
            } else {
                this.eey.setShowV(this.aeK.aSp().isBigV());
            }
        }
    }

    private void sr() {
        if (this.aeK != null && this.aeK.aSp() != null) {
            if (this.aeK.dNV > 0 && this.aeK.dNW == 0) {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_f);
            } else if (!w.isEmpty(this.aeK.aSp().getTShowInfoNew()) || this.aeK.aSp().isBigV()) {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_h);
            } else {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        sr();
        an.setViewTextColor(this.ahH, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.edq, (int) R.color.cp_cont_d);
        an.setBackgroundColor(this.eeV, R.color.cp_cont_e);
        an.setViewTextColor(this.eeU, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.een, (int) R.color.cp_cont_d);
        an.setBackgroundColor(this.eeV, R.color.cp_cont_e);
        an.setBackgroundColor(this.efa, R.color.cp_cont_e);
        l(this.aeK);
    }

    public void setIsSimpleThread(boolean z) {
        this.efb = z;
    }

    public boolean getIsSimpleThread() {
        return this.efb;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahM = onClickListener;
        if (this.eey != null) {
            this.eey.setAfterClickListener(this.ahM);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eey != null) {
            this.eey.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eey;
    }

    public TextView getUserName() {
        return this.ahA;
    }

    protected String xm(String str) {
        return ar.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.eeZ = z;
    }

    public void setIsFromConcern(boolean z) {
        this.efc = z;
    }
}

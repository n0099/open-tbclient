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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bx agB;
    public TextView ajA;
    protected UserIconBox ajB;
    private UserIconBox ajC;
    protected TextView ajG;
    private View.OnClickListener ajJ;
    private View.OnClickListener ajQ;
    private View.OnClickListener ajR;
    private View.OnClickListener ajS;
    public TextView ajz;
    private TextView eVh;
    private TextView eWJ;
    private View eWK;
    private TextView eWL;
    private View eWM;
    private FrameLayout eWN;
    private boolean eWO;
    private View eWP;
    private boolean eWQ;
    private boolean eWR;
    private TextView eWc;
    public ClickableHeaderImageView eWn;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.eWO = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getUserId()) && ThreadUserInfoLayout.this.agB.blG() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agB.blC().getUserId(), ThreadUserInfoLayout.this.agB.blC().getName_show(), ThreadUserInfoLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajJ != null) {
                        ThreadUserInfoLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.ajS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agB.blC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWO = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getUserId()) && ThreadUserInfoLayout.this.agB.blG() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agB.blC().getUserId(), ThreadUserInfoLayout.this.agB.blC().getName_show(), ThreadUserInfoLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajJ != null) {
                        ThreadUserInfoLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.ajS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agB.blC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWO = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agB.blC().getUserId()) && ThreadUserInfoLayout.this.agB.blG() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agB.blC().getUserId(), ThreadUserInfoLayout.this.agB.blC().getName_show(), ThreadUserInfoLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajJ != null) {
                        ThreadUserInfoLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.ajS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agB != null && ThreadUserInfoLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agB.blC().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.eWn = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ajC = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ajz = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ajA = (TextView) inflate.findViewById(R.id.identity_view);
        this.ajB = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.eVh = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.eWJ = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eWK = inflate.findViewById(R.id.divider);
        this.eWP = findViewById(R.id.divider_forum_name);
        this.eWc = (TextView) findViewById(R.id.thread_info_forum_name);
        this.ajG = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.eWL = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.eWN = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.eWM = com.baidu.tbadk.ala.b.bhG().q(this.mContext, 1);
        if (this.eWM != null) {
            this.eWM.setVisibility(8);
            this.eWN.addView(this.eWM);
        }
        setGravity(16);
        initHeaderImg();
        this.ajC.setOnClickListener(this.ajQ);
        this.ajz.setOnClickListener(this.ajR);
        this.ajB.setOnClickListener(this.ajS);
    }

    public boolean setData(bx bxVar) {
        if (bxVar == null) {
            setVisibility(8);
            return false;
        }
        this.agB = bxVar;
        if (this.agB.eED > 0) {
            if (this.agB.eEE == 0 && this.agB.blC() != null) {
                if (!y.isEmpty(this.agB.blC().getTShowInfoNew())) {
                    this.agB.blC().getTShowInfoNew().clear();
                }
                this.agB.blC().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ajC.setOnClickListener(null);
            this.ajz.setOnClickListener(null);
            this.ajB.setOnClickListener(null);
            this.eWn.setClickable(false);
        } else {
            this.ajC.setOnClickListener(this.ajQ);
            this.ajz.setOnClickListener(this.ajR);
            this.ajB.setOnClickListener(this.ajS);
            this.eWn.setClickable(true);
        }
        l(bxVar);
        i(bxVar);
        j(bxVar);
        k(bxVar);
        m(bxVar);
        F(bxVar);
        K(bxVar);
        d(bxVar);
        L(bxVar);
        setVisibility(0);
        J(bxVar);
        I(bxVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.eWn != null) {
            this.eWn.setDefaultResource(17170445);
            this.eWn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eWn.setPlaceHolder(1);
            this.eWn.setIsRound(true);
            this.eWn.setAfterClickListener(this.ajJ);
        }
    }

    private void I(bx bxVar) {
        if (this.mFrom == 3) {
            if (bxVar != null && bxVar.blC() != null && bxVar.blC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bxVar.blC().getAlaUserData();
                if (this.eWM != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.esy = alaUserData;
                    aVar.type = 1;
                    this.eWM.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.eWM.setVisibility(8);
                    } else {
                        this.eWM.setVisibility(0);
                    }
                }
            } else if (this.eWM != null) {
                this.eWM.setVisibility(8);
            }
        }
    }

    private void J(bx bxVar) {
        if (this.eWL != null && bxVar != null && bxVar.blC() != null) {
            if (bxVar.blC().hadConcerned()) {
                this.eWL.setVisibility(0);
                ap.setViewTextColor(this.eWL, R.color.CAM_X0109);
                ap.setBackgroundResource(this.eWL, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.eWL.setVisibility(8);
        }
    }

    private void l(bx bxVar) {
        if (this.ajC != null && bxVar != null && bxVar.blC() != null) {
            ArrayList<IconData> tShowInfoNew = bxVar.blC().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajC.setVisibility(0);
                this.ajC.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajC.setVisibility(8);
        }
    }

    private void m(bx bxVar) {
        if (this.ajA != null && bxVar != null && bxVar.blC() != null) {
            MetaData blC = bxVar.blC();
            if (blC.getIs_bawu() == 1) {
                int i = bxVar.eER ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bxVar.eER ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ap.setBackgroundResource(this.ajA, i);
                ap.setViewTextColor(this.ajA, i2);
                if (bxVar.eER) {
                    this.ajA.setVisibility(0);
                    this.ajA.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                    this.ajA.setVisibility(0);
                    this.ajA.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_content_assist_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_manage_assist_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else {
                    this.ajA.setVisibility(8);
                    return;
                }
            }
            this.ajA.setVisibility(8);
        }
    }

    private void i(bx bxVar) {
        if (this.ajz != null && bxVar != null) {
            if (!StringUtils.isNull(this.agB.blC().getName_show())) {
                this.ajz.setText(BU(this.agB.blC().getName_show()));
            }
            um();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.agB.blC().getName_show();
                String userName = this.agB.blC().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ajz.setText(com.baidu.tieba.pb.c.aR(this.mContext, this.ajz.getText().toString()));
                    this.ajz.setGravity(16);
                    this.ajz.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dhr());
                    ap.setViewTextColor(this.ajz, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(bx bxVar) {
        if (this.ajB != null) {
            if (this.eWR) {
                this.ajB.setVisibility(8);
            } else if (bxVar == null || bxVar.blC() == null || ((bxVar.eED > 0 && bxVar.eEE == 0) || !this.eWO)) {
                this.ajB.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bxVar.blC().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajB.setVisibility(0);
                    this.ajB.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.ajB.setVisibility(8);
            }
        }
    }

    private void F(bx bxVar) {
        String formatTime;
        if (this.eVh != null && bxVar != null) {
            if (bxVar.blv() <= 0) {
                this.eVh.setVisibility(4);
                return;
            }
            this.eVh.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = au.getPostTimeInterval(bxVar.blv());
            } else if (bxVar.bmV()) {
                formatTime = au.getFormatTime(bxVar.getCreateTime());
            } else {
                formatTime = au.getFormatTime(bxVar.blv() * 1000);
            }
            this.eVh.setText(formatTime);
        }
    }

    protected void j(bx bxVar) {
        if (this.ajG == null || bxVar == null) {
            this.ajG.setVisibility(8);
        } else if (this.eWR) {
            if (StringUtils.isNull(bxVar.bje())) {
                this.ajG.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajG.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ajG.setLayoutParams(layoutParams);
            }
            this.ajG.setText(bxVar.bje());
            this.ajG.setVisibility(0);
        } else if (this.agB.blW() == null || this.agB.blW().share_info == null || this.agB.blW().share_info.share_user_count <= 0 || !this.agB.bmY() || (this.agB.eED > 0 && this.agB.eEE == 0)) {
            this.ajG.setVisibility(8);
        } else {
            this.ajG.setVisibility(0);
            int i = this.agB.blW().share_info.share_user_count;
            if (i == 1) {
                this.ajG.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.ajG.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{au.numberUniform(i)}));
            }
        }
    }

    private void K(bx bxVar) {
        if (bxVar == null || StringUtils.isNull(bxVar.getAddress())) {
            this.eWJ.setVisibility(8);
            this.eWK.setVisibility(8);
            return;
        }
        this.eWJ.setText(this.agB.getAddress());
        this.eWJ.setVisibility(0);
        this.eWK.setVisibility(0);
    }

    public void L(bx bxVar) {
        String str;
        if (bxVar == null) {
            this.eWc.setVisibility(8);
            this.eWP.setVisibility(8);
            return;
        }
        this.agB.blG();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bxVar.bnr()) {
            str2 = bxVar.eEQ.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.eWc.setVisibility(8);
            this.eWP.setVisibility(8);
            return;
        }
        if (this.agB.eED > 0 && this.agB.eEE == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = au.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.eWc.setText(str);
        this.eWc.setVisibility(0);
        this.eWP.setVisibility(0);
    }

    public void ju(boolean z) {
        if (z) {
            L(this.agB);
            return;
        }
        this.eWc.setVisibility(8);
        this.eWP.setVisibility(8);
    }

    private void d(bx bxVar) {
        if (this.eWn != null && bxVar != null && this.agB.blC() != null) {
            if (this.agB.eED > 0 && this.agB.eEE == 0) {
                this.eWn.setShowV(false);
            } else {
                this.eWn.setShowV(this.agB.blC().isBigV());
            }
        }
    }

    private void um() {
        if (this.agB != null && this.agB.blC() != null) {
            if (this.agB.eED > 0 && this.agB.eEE == 0) {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0106);
            } else if (!y.isEmpty(this.agB.blC().getTShowInfoNew()) || this.agB.blC().isBigV()) {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        um();
        ap.setViewTextColor(this.ajG, R.color.CAM_X0106);
        ap.setViewTextColor(this.eVh, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eWK, R.color.CAM_X0110);
        ap.setViewTextColor(this.eWJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.eWc, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eWK, R.color.CAM_X0110);
        ap.setBackgroundColor(this.eWP, R.color.CAM_X0110);
        m(this.agB);
    }

    public void setIsSimpleThread(boolean z) {
        this.eWQ = z;
    }

    public boolean getIsSimpleThread() {
        return this.eWQ;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajJ = onClickListener;
        if (this.eWn != null) {
            this.eWn.setAfterClickListener(this.ajJ);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWn != null) {
            this.eWn.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eWn;
    }

    public TextView getUserName() {
        return this.ajz;
    }

    protected String BU(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.eWO = z;
    }

    public void setIsFromConcern(boolean z) {
        this.eWR = z;
    }
}

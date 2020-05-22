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
import com.baidu.tbadk.core.data.bk;
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
public class ThreadUserInfoLayout extends LinearLayout {
    private bk aee;
    protected TextView agD;
    private View.OnClickListener agI;
    private View.OnClickListener agO;
    private View.OnClickListener agP;
    private View.OnClickListener agQ;
    public TextView agw;
    public TextView agx;
    protected UserIconBox agy;
    private UserIconBox agz;
    private TextView dVT;
    private TextView dWR;
    private TextView dXA;
    private View dXB;
    private FrameLayout dXC;
    private boolean dXD;
    private View dXE;
    private boolean dXF;
    private boolean dXG;
    public ClickableHeaderImageView dXc;
    private TextView dXy;
    private View dXz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.dXD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getUserId()) && ThreadUserInfoLayout.this.aee.aQC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aee.aQx().getUserId(), ThreadUserInfoLayout.this.aee.aQx().getName_show(), ThreadUserInfoLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aee.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agI != null) {
                        ThreadUserInfoLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.agQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getUserId()) && ThreadUserInfoLayout.this.aee.aQC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aee.aQx().getUserId(), ThreadUserInfoLayout.this.aee.aQx().getName_show(), ThreadUserInfoLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aee.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agI != null) {
                        ThreadUserInfoLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.agQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXD = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.agO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aee.aQx().getUserId()) && ThreadUserInfoLayout.this.aee.aQC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aee.aQx().getUserId(), ThreadUserInfoLayout.this.aee.aQx().getName_show(), ThreadUserInfoLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aee.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.agI != null) {
                        ThreadUserInfoLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.agQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aee != null && ThreadUserInfoLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.dXc = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.agz = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.agw = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.agx = (TextView) inflate.findViewById(R.id.identity_view);
        this.agy = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.dVT = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.dXy = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.dXz = inflate.findViewById(R.id.divider);
        this.dXE = findViewById(R.id.divider_forum_name);
        this.dWR = (TextView) findViewById(R.id.thread_info_forum_name);
        this.agD = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.dXA = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.dXC = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.dXB = com.baidu.tbadk.ala.b.aMC().p(this.mContext, 1);
        if (this.dXB != null) {
            this.dXB.setVisibility(8);
            this.dXC.addView(this.dXB);
        }
        setGravity(16);
        initHeaderImg();
        this.agz.setOnClickListener(this.agO);
        this.agw.setOnClickListener(this.agP);
        this.agy.setOnClickListener(this.agQ);
    }

    public boolean setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.aee = bkVar;
        if (this.aee.dHk > 0) {
            if (this.aee.dHl == 0 && this.aee.aQx() != null) {
                if (!v.isEmpty(this.aee.aQx().getTShowInfoNew())) {
                    this.aee.aQx().getTShowInfoNew().clear();
                }
                this.aee.aQx().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.agz.setOnClickListener(null);
            this.agw.setOnClickListener(null);
            this.agy.setOnClickListener(null);
            this.dXc.setClickable(false);
        } else {
            this.agz.setOnClickListener(this.agO);
            this.agw.setOnClickListener(this.agP);
            this.agy.setOnClickListener(this.agQ);
            this.dXc.setClickable(true);
        }
        k(bkVar);
        h(bkVar);
        i(bkVar);
        j(bkVar);
        l(bkVar);
        E(bkVar);
        K(bkVar);
        c(bkVar);
        L(bkVar);
        setVisibility(0);
        J(bkVar);
        I(bkVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.dXc != null) {
            this.dXc.setDefaultResource(17170445);
            this.dXc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.dXc.setPlaceHolder(1);
            this.dXc.setIsRound(true);
            this.dXc.setAfterClickListener(this.agI);
        }
    }

    private void I(bk bkVar) {
        if (this.mFrom == 3) {
            if (bkVar != null && bkVar.aQx() != null && bkVar.aQx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bkVar.aQx().getAlaUserData();
                if (this.dXB != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dxn = alaUserData;
                    aVar.type = 1;
                    this.dXB.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.dXB.setVisibility(8);
                    } else {
                        this.dXB.setVisibility(0);
                    }
                }
            } else if (this.dXB != null) {
                this.dXB.setVisibility(8);
            }
        }
    }

    private void J(bk bkVar) {
        if (this.dXA != null && bkVar != null && bkVar.aQx() != null) {
            if (bkVar.aQx().hadConcerned()) {
                this.dXA.setVisibility(0);
                am.setViewTextColor(this.dXA, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.dXA, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.dXA.setVisibility(8);
        }
    }

    private void k(bk bkVar) {
        if (this.agz != null && bkVar != null && bkVar.aQx() != null) {
            ArrayList<IconData> tShowInfoNew = bkVar.aQx().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agz.setVisibility(0);
                this.agz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.agz.setVisibility(8);
        }
    }

    private void l(bk bkVar) {
        if (this.agx != null && bkVar != null && bkVar.aQx() != null) {
            MetaData aQx = bkVar.aQx();
            if (aQx.getIs_bawu() == 1) {
                int i = bkVar.dHx ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bkVar.dHx ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.agx, i);
                am.setViewTextColor(this.agx, i2);
                if (bkVar.dHx) {
                    this.agx.setVisibility(0);
                    this.agx.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                    this.agx.setVisibility(0);
                    this.agx.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                    this.agx.setText(R.string.bawu_member_xbazhu_tip);
                    this.agx.setVisibility(0);
                } else if ("pri_content_assist".equals(aQx.getBawu_type())) {
                    this.agx.setText(R.string.bawu_content_assist_tip);
                    this.agx.setVisibility(0);
                } else if ("pri_manage_assist".equals(aQx.getBawu_type())) {
                    this.agx.setText(R.string.bawu_manage_assist_tip);
                    this.agx.setVisibility(0);
                } else if (aQx.getIs_biggie()) {
                    m(bkVar);
                } else {
                    this.agx.setVisibility(8);
                }
            } else if (aQx.getIs_biggie()) {
                m(bkVar);
            } else {
                this.agx.setVisibility(8);
            }
        }
    }

    private void m(bk bkVar) {
        am.setBackgroundResource(this.agx, R.drawable.brand_official_btn);
        am.setViewTextColor(this.agx, (int) R.color.cp_link_tip_a);
        this.agx.setText(R.string.video_mcn);
        if (bkVar.aRG()) {
            this.agy.setVisibility(8);
        }
        this.agx.setVisibility(0);
    }

    private void h(bk bkVar) {
        if (this.agw != null && bkVar != null) {
            if (!StringUtils.isNull(this.aee.aQx().getName_show())) {
                this.agw.setText(wV(this.aee.aQx().getName_show()));
            }
            rW();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.aee.aQx().getName_show();
                String userName = this.aee.aQx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.agw.setText(com.baidu.tieba.pb.c.aK(this.mContext, this.agw.getText().toString()));
                    this.agw.setGravity(16);
                    this.agw.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cBR());
                    am.setViewTextColor(this.agw, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bk bkVar) {
        if (this.agy != null) {
            if (this.dXG) {
                this.agy.setVisibility(8);
            } else if (bkVar == null || bkVar.aQx() == null || ((bkVar.dHk > 0 && bkVar.dHl == 0) || !this.dXD)) {
                this.agy.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bkVar.aQx().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.agy.setVisibility(0);
                    this.agy.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.agy.setVisibility(8);
            }
        }
    }

    private void E(bk bkVar) {
        String formatTime;
        if (this.dVT != null && bkVar != null) {
            if (bkVar.aQq() <= 0) {
                this.dVT.setVisibility(4);
                return;
            }
            this.dVT.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bkVar.aQq());
            } else if (bkVar.aRP()) {
                formatTime = aq.getFormatTime(bkVar.getCreateTime());
            } else if (bkVar.aQB()) {
                formatTime = aq.cj(bkVar.aQq() * 1000);
            } else {
                formatTime = aq.getFormatTime(bkVar.aQq() * 1000);
            }
            this.dVT.setText(formatTime);
        }
    }

    protected void i(bk bkVar) {
        if (this.agD == null || bkVar == null) {
            this.agD.setVisibility(8);
        } else if (this.dXG) {
            if (StringUtils.isNull(bkVar.aOj())) {
                this.agD.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agD.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.agD.setLayoutParams(layoutParams);
            }
            this.agD.setText(bkVar.aOj());
            this.agD.setVisibility(0);
        } else if (this.aee.aQS() == null || this.aee.aQS().share_info == null || this.aee.aQS().share_info.share_user_count <= 0 || !this.aee.aRS() || (this.aee.dHk > 0 && this.aee.dHl == 0)) {
            this.agD.setVisibility(8);
        } else {
            this.agD.setVisibility(0);
            int i = this.aee.aQS().share_info.share_user_count;
            if (i == 1) {
                this.agD.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.agD.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void K(bk bkVar) {
        if (bkVar == null || StringUtils.isNull(bkVar.getAddress())) {
            this.dXy.setVisibility(8);
            this.dXz.setVisibility(8);
            return;
        }
        this.dXy.setText(this.aee.getAddress());
        this.dXy.setVisibility(0);
        this.dXz.setVisibility(0);
    }

    public void L(bk bkVar) {
        String str;
        if (bkVar == null) {
            this.dWR.setVisibility(8);
            this.dXE.setVisibility(8);
            return;
        }
        this.aee.aQC();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bkVar.aSl()) {
            str2 = bkVar.dHw.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.dWR.setVisibility(8);
            this.dXE.setVisibility(8);
            return;
        }
        if (this.aee.dHk > 0 && this.aee.dHl == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.dWR.setText(str);
        this.dWR.setVisibility(0);
        this.dXE.setVisibility(0);
    }

    public void hq(boolean z) {
        if (z) {
            L(this.aee);
            return;
        }
        this.dWR.setVisibility(8);
        this.dXE.setVisibility(8);
    }

    private void c(bk bkVar) {
        if (this.dXc != null && bkVar != null && this.aee.aQx() != null) {
            if (this.aee.dHk > 0 && this.aee.dHl == 0) {
                this.dXc.setShowV(false);
            } else {
                this.dXc.setShowV(this.aee.aQx().isBigV());
            }
        }
    }

    private void rW() {
        if (this.aee != null && this.aee.aQx() != null) {
            if (this.aee.dHk > 0 && this.aee.dHl == 0) {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.aee.aQx().getTShowInfoNew()) || this.aee.aQx().isBigV()) {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        rW();
        am.setViewTextColor(this.agD, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dVT, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dXz, R.color.cp_cont_e);
        am.setViewTextColor(this.dXy, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dWR, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.dXz, R.color.cp_cont_e);
        am.setBackgroundColor(this.dXE, R.color.cp_cont_e);
        l(this.aee);
    }

    public void setIsSimpleThread(boolean z) {
        this.dXF = z;
    }

    public boolean getIsSimpleThread() {
        return this.dXF;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agI = onClickListener;
        if (this.dXc != null) {
            this.dXc.setAfterClickListener(this.agI);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dXc != null) {
            this.dXc.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.dXc;
    }

    public TextView getUserName() {
        return this.agw;
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.dXD = z;
    }

    public void setIsFromConcern(boolean z) {
        this.dXG = z;
    }
}

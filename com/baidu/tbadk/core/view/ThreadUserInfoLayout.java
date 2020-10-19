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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bw agw;
    protected TextView ajA;
    private View.OnClickListener ajF;
    private View.OnClickListener ajM;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    public TextView ajt;
    public TextView aju;
    protected UserIconBox ajv;
    private UserIconBox ajw;
    private TextView eHN;
    private TextView eIK;
    public ClickableHeaderImageView eIV;
    private TextView eJr;
    private View eJs;
    private TextView eJt;
    private View eJu;
    private FrameLayout eJv;
    private boolean eJw;
    private View eJx;
    private boolean eJy;
    private boolean eJz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.eJw = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getUserId()) && ThreadUserInfoLayout.this.agw.bil() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agw.bih().getUserId(), ThreadUserInfoLayout.this.agw.bih().getName_show(), ThreadUserInfoLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agw.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajF != null) {
                        ThreadUserInfoLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agw.bih().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJw = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getUserId()) && ThreadUserInfoLayout.this.agw.bil() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agw.bih().getUserId(), ThreadUserInfoLayout.this.agw.bih().getName_show(), ThreadUserInfoLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agw.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajF != null) {
                        ThreadUserInfoLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agw.bih().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJw = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agw.bih().getUserId()) && ThreadUserInfoLayout.this.agw.bil() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agw.bih().getUserId(), ThreadUserInfoLayout.this.agw.bih().getName_show(), ThreadUserInfoLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agw.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajF != null) {
                        ThreadUserInfoLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agw != null && ThreadUserInfoLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agw.bih().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.eIV = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ajw = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ajt = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.aju = (TextView) inflate.findViewById(R.id.identity_view);
        this.ajv = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.eHN = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.eJr = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eJs = inflate.findViewById(R.id.divider);
        this.eJx = findViewById(R.id.divider_forum_name);
        this.eIK = (TextView) findViewById(R.id.thread_info_forum_name);
        this.ajA = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.eJt = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.eJv = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.eJu = com.baidu.tbadk.ala.b.bdT().q(this.mContext, 1);
        if (this.eJu != null) {
            this.eJu.setVisibility(8);
            this.eJv.addView(this.eJu);
        }
        setGravity(16);
        initHeaderImg();
        this.ajw.setOnClickListener(this.ajM);
        this.ajt.setOnClickListener(this.ajN);
        this.ajv.setOnClickListener(this.ajO);
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agw = bwVar;
        if (this.agw.erW > 0) {
            if (this.agw.erX == 0 && this.agw.bih() != null) {
                if (!y.isEmpty(this.agw.bih().getTShowInfoNew())) {
                    this.agw.bih().getTShowInfoNew().clear();
                }
                this.agw.bih().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ajw.setOnClickListener(null);
            this.ajt.setOnClickListener(null);
            this.ajv.setOnClickListener(null);
            this.eIV.setClickable(false);
        } else {
            this.ajw.setOnClickListener(this.ajM);
            this.ajt.setOnClickListener(this.ajN);
            this.ajv.setOnClickListener(this.ajO);
            this.eIV.setClickable(true);
        }
        l(bwVar);
        i(bwVar);
        j(bwVar);
        k(bwVar);
        m(bwVar);
        D(bwVar);
        I(bwVar);
        d(bwVar);
        J(bwVar);
        setVisibility(0);
        H(bwVar);
        G(bwVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.eIV != null) {
            this.eIV.setDefaultResource(17170445);
            this.eIV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eIV.setPlaceHolder(1);
            this.eIV.setIsRound(true);
            this.eIV.setAfterClickListener(this.ajF);
        }
    }

    private void G(bw bwVar) {
        if (this.mFrom == 3) {
            if (bwVar != null && bwVar.bih() != null && bwVar.bih().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bih().getAlaUserData();
                if (this.eJu != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.efM = alaUserData;
                    aVar.type = 1;
                    this.eJu.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.eJu.setVisibility(8);
                    } else {
                        this.eJu.setVisibility(0);
                    }
                }
            } else if (this.eJu != null) {
                this.eJu.setVisibility(8);
            }
        }
    }

    private void H(bw bwVar) {
        if (this.eJt != null && bwVar != null && bwVar.bih() != null) {
            if (bwVar.bih().hadConcerned()) {
                this.eJt.setVisibility(0);
                ap.setViewTextColor(this.eJt, R.color.cp_cont_d);
                ap.setBackgroundResource(this.eJt, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.eJt.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.ajw != null && bwVar != null && bwVar.bih() != null) {
            ArrayList<IconData> tShowInfoNew = bwVar.bih().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajw.setVisibility(0);
                this.ajw.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajw.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.aju != null && bwVar != null && bwVar.bih() != null) {
            MetaData bih = bwVar.bih();
            if (bih.getIs_bawu() == 1) {
                int i = bwVar.esk ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bwVar.esk ? R.color.cp_cont_a : R.color.cp_cont_j;
                ap.setBackgroundResource(this.aju, i);
                ap.setViewTextColor(this.aju, i2);
                if (bwVar.esk) {
                    this.aju.setVisibility(0);
                    this.aju.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bih.getBawu_type())) {
                    this.aju.setVisibility(0);
                    this.aju.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bih.getBawu_type())) {
                    this.aju.setText(R.string.bawu_member_xbazhu_tip);
                    this.aju.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bih.getBawu_type())) {
                    this.aju.setText(R.string.bawu_content_assist_tip);
                    this.aju.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bih.getBawu_type())) {
                    this.aju.setText(R.string.bawu_manage_assist_tip);
                    this.aju.setVisibility(0);
                    return;
                } else {
                    this.aju.setVisibility(8);
                    return;
                }
            }
            this.aju.setVisibility(8);
        }
    }

    private void i(bw bwVar) {
        if (this.ajt != null && bwVar != null) {
            if (!StringUtils.isNull(this.agw.bih().getName_show())) {
                this.ajt.setText(BO(this.agw.bih().getName_show()));
            }
            um();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.agw.bih().getName_show();
                String userName = this.agw.bih().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ajt.setText(com.baidu.tieba.pb.c.aS(this.mContext, this.ajt.getText().toString()));
                    this.ajt.setGravity(16);
                    this.ajt.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dck());
                    ap.setViewTextColor(this.ajt, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajv != null) {
            if (this.eJz) {
                this.ajv.setVisibility(8);
            } else if (bwVar == null || bwVar.bih() == null || ((bwVar.erW > 0 && bwVar.erX == 0) || !this.eJw)) {
                this.ajv.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bih().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajv.setVisibility(0);
                    this.ajv.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.ajv.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String formatTime;
        if (this.eHN != null && bwVar != null) {
            if (bwVar.bia() <= 0) {
                this.eHN.setVisibility(4);
                return;
            }
            this.eHN.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bwVar.bia());
            } else if (bwVar.bjy()) {
                formatTime = at.getFormatTime(bwVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bwVar.bia() * 1000);
            }
            this.eHN.setText(formatTime);
        }
    }

    protected void j(bw bwVar) {
        if (this.ajA == null || bwVar == null) {
            this.ajA.setVisibility(8);
        } else if (this.eJz) {
            if (StringUtils.isNull(bwVar.bfH())) {
                this.ajA.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajA.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ajA.setLayoutParams(layoutParams);
            }
            this.ajA.setText(bwVar.bfH());
            this.ajA.setVisibility(0);
        } else if (this.agw.biB() == null || this.agw.biB().share_info == null || this.agw.biB().share_info.share_user_count <= 0 || !this.agw.bjB() || (this.agw.erW > 0 && this.agw.erX == 0)) {
            this.ajA.setVisibility(8);
        } else {
            this.ajA.setVisibility(0);
            int i = this.agw.biB().share_info.share_user_count;
            if (i == 1) {
                this.ajA.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.ajA.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void I(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.getAddress())) {
            this.eJr.setVisibility(8);
            this.eJs.setVisibility(8);
            return;
        }
        this.eJr.setText(this.agw.getAddress());
        this.eJr.setVisibility(0);
        this.eJs.setVisibility(0);
    }

    public void J(bw bwVar) {
        String str;
        if (bwVar == null) {
            this.eIK.setVisibility(8);
            this.eJx.setVisibility(8);
            return;
        }
        this.agw.bil();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bwVar.bjU()) {
            str2 = bwVar.esj.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.eIK.setVisibility(8);
            this.eJx.setVisibility(8);
            return;
        }
        if (this.agw.erW > 0 && this.agw.erX == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.eIK.setText(str);
        this.eIK.setVisibility(0);
        this.eJx.setVisibility(0);
    }

    public void iX(boolean z) {
        if (z) {
            J(this.agw);
            return;
        }
        this.eIK.setVisibility(8);
        this.eJx.setVisibility(8);
    }

    private void d(bw bwVar) {
        if (this.eIV != null && bwVar != null && this.agw.bih() != null) {
            if (this.agw.erW > 0 && this.agw.erX == 0) {
                this.eIV.setShowV(false);
            } else {
                this.eIV.setShowV(this.agw.bih().isBigV());
            }
        }
    }

    private void um() {
        if (this.agw != null && this.agw.bih() != null) {
            if (this.agw.erW > 0 && this.agw.erX == 0) {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_f);
            } else if (!y.isEmpty(this.agw.bih().getTShowInfoNew()) || this.agw.bih().isBigV()) {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        um();
        ap.setViewTextColor(this.ajA, R.color.cp_cont_f);
        ap.setViewTextColor(this.eHN, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eJs, R.color.cp_cont_e);
        ap.setViewTextColor(this.eJr, R.color.cp_cont_d);
        ap.setViewTextColor(this.eIK, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eJs, R.color.cp_cont_e);
        ap.setBackgroundColor(this.eJx, R.color.cp_cont_e);
        m(this.agw);
    }

    public void setIsSimpleThread(boolean z) {
        this.eJy = z;
    }

    public boolean getIsSimpleThread() {
        return this.eJy;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajF = onClickListener;
        if (this.eIV != null) {
            this.eIV.setAfterClickListener(this.ajF);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eIV != null) {
            this.eIV.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eIV;
    }

    public TextView getUserName() {
        return this.ajt;
    }

    protected String BO(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.eJw = z;
    }

    public void setIsFromConcern(boolean z) {
        this.eJz = z;
    }
}

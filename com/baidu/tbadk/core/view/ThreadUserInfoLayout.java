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
import com.baidu.tbadk.core.data.by;
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
    private by ahA;
    protected UserIconBox akA;
    private UserIconBox akB;
    protected TextView akF;
    private View.OnClickListener akI;
    private View.OnClickListener akQ;
    private View.OnClickListener akR;
    private View.OnClickListener akS;
    public TextView aky;
    public TextView akz;
    private TextView fcE;
    public ClickableHeaderImageView fdK;
    private TextView fdz;
    private TextView feg;
    private View feh;
    private TextView fei;
    private View fej;
    private FrameLayout fek;
    private boolean fel;
    private View fem;
    private boolean fen;
    private boolean feo;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.fel = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getUserId()) && ThreadUserInfoLayout.this.ahA.boT() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahA.boP().getUserId(), ThreadUserInfoLayout.this.ahA.boP().getName_show(), ThreadUserInfoLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akI != null) {
                        ThreadUserInfoLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.akS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fel = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getUserId()) && ThreadUserInfoLayout.this.ahA.boT() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahA.boP().getUserId(), ThreadUserInfoLayout.this.ahA.boP().getName_show(), ThreadUserInfoLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akI != null) {
                        ThreadUserInfoLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.akS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fel = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahA.boP().getUserId()) && ThreadUserInfoLayout.this.ahA.boT() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahA.boP().getUserId(), ThreadUserInfoLayout.this.ahA.boP().getName_show(), ThreadUserInfoLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akI != null) {
                        ThreadUserInfoLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.akS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahA != null && ThreadUserInfoLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.fdK = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.akB = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.aky = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.akz = (TextView) inflate.findViewById(R.id.identity_view);
        this.akA = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.fcE = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.feg = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.feh = inflate.findViewById(R.id.divider);
        this.fem = findViewById(R.id.divider_forum_name);
        this.fdz = (TextView) findViewById(R.id.thread_info_forum_name);
        this.akF = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.fei = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.fek = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.fej = com.baidu.tbadk.ala.b.bkP().z(this.mContext, 1);
        if (this.fej != null) {
            this.fej.setVisibility(8);
            this.fek.addView(this.fej);
        }
        setGravity(16);
        initHeaderImg();
        this.akB.setOnClickListener(this.akQ);
        this.aky.setOnClickListener(this.akR);
        this.akA.setOnClickListener(this.akS);
    }

    public boolean setData(by byVar) {
        if (byVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahA = byVar;
        if (this.ahA.eLF > 0) {
            if (this.ahA.eLG == 0 && this.ahA.boP() != null) {
                if (!y.isEmpty(this.ahA.boP().getTShowInfoNew())) {
                    this.ahA.boP().getTShowInfoNew().clear();
                }
                this.ahA.boP().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.akB.setOnClickListener(null);
            this.aky.setOnClickListener(null);
            this.akA.setOnClickListener(null);
            this.fdK.setClickable(false);
        } else {
            this.akB.setOnClickListener(this.akQ);
            this.aky.setOnClickListener(this.akR);
            this.akA.setOnClickListener(this.akS);
            this.fdK.setClickable(true);
        }
        l(byVar);
        i(byVar);
        j(byVar);
        k(byVar);
        m(byVar);
        F(byVar);
        K(byVar);
        d(byVar);
        L(byVar);
        setVisibility(0);
        J(byVar);
        I(byVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.fdK != null) {
            this.fdK.setDefaultResource(17170445);
            this.fdK.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fdK.setPlaceHolder(1);
            this.fdK.setIsRound(true);
            this.fdK.setAfterClickListener(this.akI);
        }
    }

    private void I(by byVar) {
        if (this.mFrom == 3) {
            if (byVar != null && byVar.boP() != null && byVar.boP().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = byVar.boP().getAlaUserData();
                if (this.fej != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ezB = alaUserData;
                    aVar.type = 1;
                    this.fej.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.fej.setVisibility(8);
                    } else {
                        this.fej.setVisibility(0);
                    }
                }
            } else if (this.fej != null) {
                this.fej.setVisibility(8);
            }
        }
    }

    private void J(by byVar) {
        if (this.fei != null && byVar != null && byVar.boP() != null) {
            if (byVar.boP().hadConcerned()) {
                this.fei.setVisibility(0);
                ap.setViewTextColor(this.fei, R.color.CAM_X0109);
                ap.setBackgroundResource(this.fei, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.fei.setVisibility(8);
        }
    }

    private void l(by byVar) {
        if (this.akB != null && byVar != null && byVar.boP() != null) {
            ArrayList<IconData> tShowInfoNew = byVar.boP().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akB.setVisibility(0);
                this.akB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akB.setVisibility(8);
        }
    }

    private void m(by byVar) {
        if (this.akz != null && byVar != null && byVar.boP() != null) {
            MetaData boP = byVar.boP();
            if (boP.getIs_bawu() == 1) {
                int i = byVar.eLT ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = byVar.eLT ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ap.setBackgroundResource(this.akz, i);
                ap.setViewTextColor(this.akz, i2);
                if (byVar.eLT) {
                    this.akz.setVisibility(0);
                    this.akz.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                    this.akz.setVisibility(0);
                    this.akz.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_member_xbazhu_tip);
                    this.akz.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_content_assist_tip);
                    this.akz.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_manage_assist_tip);
                    this.akz.setVisibility(0);
                    return;
                } else {
                    this.akz.setVisibility(8);
                    return;
                }
            }
            this.akz.setVisibility(8);
        }
    }

    private void i(by byVar) {
        if (this.aky != null && byVar != null) {
            if (!StringUtils.isNull(this.ahA.boP().getName_show())) {
                this.aky.setText(CC(this.ahA.boP().getName_show()));
            }
            up();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.ahA.boP().getName_show();
                String userName = this.ahA.boP().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.aky.setText(com.baidu.tieba.pb.c.aV(this.mContext, this.aky.getText().toString()));
                    this.aky.setGravity(16);
                    this.aky.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmD());
                    ap.setViewTextColor(this.aky, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(by byVar) {
        if (this.akA != null) {
            if (this.feo) {
                this.akA.setVisibility(8);
            } else if (byVar == null || byVar.boP() == null || ((byVar.eLF > 0 && byVar.eLG == 0) || !this.fel)) {
                this.akA.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = byVar.boP().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.akA.setVisibility(0);
                    this.akA.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.akA.setVisibility(8);
            }
        }
    }

    private void F(by byVar) {
        String formatTime;
        if (this.fcE != null && byVar != null) {
            if (byVar.boI() <= 0) {
                this.fcE.setVisibility(4);
                return;
            }
            this.fcE.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = au.getPostTimeInterval(byVar.boI());
            } else if (byVar.bqi()) {
                formatTime = au.getFormatTime(byVar.getCreateTime());
            } else {
                formatTime = au.getFormatTime(byVar.boI() * 1000);
            }
            this.fcE.setText(formatTime);
        }
    }

    protected void j(by byVar) {
        if (this.akF == null || byVar == null) {
            this.akF.setVisibility(8);
        } else if (this.feo) {
            if (StringUtils.isNull(byVar.bmo())) {
                this.akF.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akF.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.akF.setLayoutParams(layoutParams);
            }
            this.akF.setText(byVar.bmo());
            this.akF.setVisibility(0);
        } else if (this.ahA.bpj() == null || this.ahA.bpj().share_info == null || this.ahA.bpj().share_info.share_user_count <= 0 || !this.ahA.bql() || (this.ahA.eLF > 0 && this.ahA.eLG == 0)) {
            this.akF.setVisibility(8);
        } else {
            this.akF.setVisibility(0);
            int i = this.ahA.bpj().share_info.share_user_count;
            if (i == 1) {
                this.akF.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.akF.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{au.numberUniform(i)}));
            }
        }
    }

    private void K(by byVar) {
        if (byVar == null || StringUtils.isNull(byVar.getAddress())) {
            this.feg.setVisibility(8);
            this.feh.setVisibility(8);
            return;
        }
        this.feg.setText(this.ahA.getAddress());
        this.feg.setVisibility(0);
        this.feh.setVisibility(0);
    }

    public void L(by byVar) {
        String str;
        if (byVar == null) {
            this.fdz.setVisibility(8);
            this.fem.setVisibility(8);
            return;
        }
        this.ahA.boT();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (byVar.bqE()) {
            str2 = byVar.eLS.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.fdz.setVisibility(8);
            this.fem.setVisibility(8);
            return;
        }
        if (this.ahA.eLF > 0 && this.ahA.eLG == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = au.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.fdz.setText(str);
        this.fdz.setVisibility(0);
        this.fem.setVisibility(0);
    }

    public void jK(boolean z) {
        if (z) {
            L(this.ahA);
            return;
        }
        this.fdz.setVisibility(8);
        this.fem.setVisibility(8);
    }

    private void d(by byVar) {
        if (this.fdK != null && byVar != null && this.ahA.boP() != null) {
            if (this.ahA.eLF > 0 && this.ahA.eLG == 0) {
                this.fdK.setShowV(false);
            } else {
                this.fdK.setShowV(this.ahA.boP().isBigV());
            }
        }
    }

    private void up() {
        if (this.ahA != null && this.ahA.boP() != null) {
            if (this.ahA.eLF > 0 && this.ahA.eLG == 0) {
                ap.setViewTextColor(this.aky, R.color.CAM_X0106);
            } else if (!y.isEmpty(this.ahA.boP().getTShowInfoNew()) || this.ahA.boP().isBigV()) {
                ap.setViewTextColor(this.aky, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.aky, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        up();
        ap.setViewTextColor(this.akF, R.color.CAM_X0106);
        ap.setViewTextColor(this.fcE, R.color.CAM_X0109);
        ap.setBackgroundColor(this.feh, R.color.CAM_X0110);
        ap.setViewTextColor(this.feg, R.color.CAM_X0109);
        ap.setViewTextColor(this.fdz, R.color.CAM_X0109);
        ap.setBackgroundColor(this.feh, R.color.CAM_X0110);
        ap.setBackgroundColor(this.fem, R.color.CAM_X0110);
        m(this.ahA);
    }

    public void setIsSimpleThread(boolean z) {
        this.fen = z;
    }

    public boolean getIsSimpleThread() {
        return this.fen;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
        if (this.fdK != null) {
            this.fdK.setAfterClickListener(this.akI);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fdK != null) {
            this.fdK.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fdK;
    }

    public TextView getUserName() {
        return this.aky;
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.fel = z;
    }

    public void setIsFromConcern(boolean z) {
        this.feo = z;
    }
}

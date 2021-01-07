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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bz aim;
    public TextView ala;
    public TextView alb;
    protected UserIconBox alc;
    private UserIconBox ald;
    protected TextView alh;
    private View.OnClickListener alk;
    private View.OnClickListener alt;
    private View.OnClickListener alu;
    private View.OnClickListener alv;
    private TextView fmn;
    private TextView fnP;
    private View fnQ;
    private TextView fnR;
    private View fnS;
    private FrameLayout fnT;
    private boolean fnU;
    private View fnV;
    private boolean fnW;
    private boolean fnX;
    private TextView fni;
    public ClickableHeaderImageView fnt;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.fnU = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getUserId()) && ThreadUserInfoLayout.this.aim.brv() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aim.brr().getUserId(), ThreadUserInfoLayout.this.aim.brr().getName_show(), ThreadUserInfoLayout.this.aim.brv(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aim.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alk != null) {
                        ThreadUserInfoLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.alv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aim.brr().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnU = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getUserId()) && ThreadUserInfoLayout.this.aim.brv() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aim.brr().getUserId(), ThreadUserInfoLayout.this.aim.brr().getName_show(), ThreadUserInfoLayout.this.aim.brv(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aim.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alk != null) {
                        ThreadUserInfoLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.alv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aim.brr().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnU = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aim.brr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aim.brr().getUserId()) && ThreadUserInfoLayout.this.aim.brv() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aim.brr().getUserId(), ThreadUserInfoLayout.this.aim.brr().getName_show(), ThreadUserInfoLayout.this.aim.brv(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aim.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alk != null) {
                        ThreadUserInfoLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.alv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aim != null && ThreadUserInfoLayout.this.aim.brr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aim.brr().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.fnt = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ald = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ala = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.alb = (TextView) inflate.findViewById(R.id.identity_view);
        this.alc = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.fmn = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.fnP = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fnQ = inflate.findViewById(R.id.divider);
        this.fnV = findViewById(R.id.divider_forum_name);
        this.fni = (TextView) findViewById(R.id.thread_info_forum_name);
        this.alh = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.fnR = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.fnT = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.fnS = com.baidu.tbadk.ala.b.bnp().A(this.mContext, 1);
        if (this.fnS != null) {
            this.fnS.setVisibility(8);
            this.fnT.addView(this.fnS);
        }
        setGravity(16);
        initHeaderImg();
        this.ald.setOnClickListener(this.alt);
        this.ala.setOnClickListener(this.alu);
        this.alc.setOnClickListener(this.alv);
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.aim = bzVar;
        if (this.aim.eVz > 0) {
            if (this.aim.eVA == 0 && this.aim.brr() != null) {
                if (!x.isEmpty(this.aim.brr().getTShowInfoNew())) {
                    this.aim.brr().getTShowInfoNew().clear();
                }
                this.aim.brr().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ald.setOnClickListener(null);
            this.ala.setOnClickListener(null);
            this.alc.setOnClickListener(null);
            this.fnt.setClickable(false);
        } else {
            this.ald.setOnClickListener(this.alt);
            this.ala.setOnClickListener(this.alu);
            this.alc.setOnClickListener(this.alv);
            this.fnt.setClickable(true);
        }
        l(bzVar);
        i(bzVar);
        j(bzVar);
        k(bzVar);
        m(bzVar);
        F(bzVar);
        K(bzVar);
        d(bzVar);
        L(bzVar);
        setVisibility(0);
        J(bzVar);
        I(bzVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.fnt != null) {
            this.fnt.setDefaultResource(17170445);
            this.fnt.setPlaceHolder(1);
            this.fnt.setIsRound(true);
            this.fnt.setAfterClickListener(this.alk);
        }
    }

    private void I(bz bzVar) {
        if (this.mFrom == 3) {
            if (bzVar != null && bzVar.brr() != null && bzVar.brr().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.brr().getAlaUserData();
                if (this.fnS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eJe = alaUserData;
                    aVar.type = 1;
                    this.fnS.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.fnS.setVisibility(8);
                    } else {
                        this.fnS.setVisibility(0);
                    }
                }
            } else if (this.fnS != null) {
                this.fnS.setVisibility(8);
            }
        }
    }

    private void J(bz bzVar) {
        if (this.fnR != null && bzVar != null && bzVar.brr() != null) {
            if (bzVar.brr().hadConcerned()) {
                this.fnR.setVisibility(0);
                ao.setViewTextColor(this.fnR, R.color.CAM_X0109);
                ao.setBackgroundResource(this.fnR, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.fnR.setVisibility(8);
        }
    }

    private void l(bz bzVar) {
        if (this.ald != null && bzVar != null && bzVar.brr() != null) {
            ArrayList<IconData> tShowInfoNew = bzVar.brr().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ald.setVisibility(0);
                this.ald.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ald.setVisibility(8);
        }
    }

    private void m(bz bzVar) {
        if (this.alb != null && bzVar != null && bzVar.brr() != null) {
            MetaData brr = bzVar.brr();
            if (brr.getIs_bawu() == 1) {
                int i = bzVar.eVN ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bzVar.eVN ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ao.setBackgroundResource(this.alb, i);
                ao.setViewTextColor(this.alb, i2);
                if (bzVar.eVN) {
                    this.alb.setVisibility(0);
                    this.alb.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                    this.alb.setVisibility(0);
                    this.alb.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_member_xbazhu_tip);
                    this.alb.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_content_assist_tip);
                    this.alb.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_manage_assist_tip);
                    this.alb.setVisibility(0);
                    return;
                } else {
                    this.alb.setVisibility(8);
                    return;
                }
            }
            this.alb.setVisibility(8);
        }
    }

    private void i(bz bzVar) {
        if (this.ala != null && bzVar != null) {
            if (!StringUtils.isNull(this.aim.brr().getName_show())) {
                this.ala.setText(Cz(this.aim.brr().getName_show()));
            }
            tO();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.aim.brr().getName_show();
                String userName = this.aim.brr().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ala.setText(com.baidu.tieba.pb.c.bb(this.mContext, this.ala.getText().toString()));
                    this.ala.setGravity(16);
                    this.ala.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dmp());
                    ao.setViewTextColor(this.ala, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(bz bzVar) {
        if (this.alc != null) {
            if (this.fnX) {
                this.alc.setVisibility(8);
            } else if (bzVar == null || bzVar.brr() == null || ((bzVar.eVz > 0 && bzVar.eVA == 0) || !this.fnU)) {
                this.alc.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bzVar.brr().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.alc.setVisibility(0);
                    this.alc.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.alc.setVisibility(8);
            }
        }
    }

    private void F(bz bzVar) {
        String formatTime;
        if (this.fmn != null && bzVar != null) {
            if (bzVar.brk() <= 0) {
                this.fmn.setVisibility(4);
                return;
            }
            this.fmn.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bzVar.brk());
            } else if (bzVar.bsL()) {
                formatTime = at.getFormatTime(bzVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bzVar.brk() * 1000);
            }
            this.fmn.setText(formatTime);
        }
    }

    protected void j(bz bzVar) {
        if (this.alh == null || bzVar == null) {
            this.alh.setVisibility(8);
        } else if (this.fnX) {
            if (StringUtils.isNull(bzVar.boQ())) {
                this.alh.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alh.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.alh.setLayoutParams(layoutParams);
            }
            this.alh.setText(bzVar.boQ());
            this.alh.setVisibility(0);
        } else if (this.aim.brK() == null || this.aim.brK().share_info == null || this.aim.brK().share_info.share_user_count <= 0 || !this.aim.bsO() || (this.aim.eVz > 0 && this.aim.eVA == 0)) {
            this.alh.setVisibility(8);
        } else {
            this.alh.setVisibility(0);
            int i = this.aim.brK().share_info.share_user_count;
            if (i == 1) {
                this.alh.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.alh.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void K(bz bzVar) {
        if (bzVar == null || StringUtils.isNull(bzVar.getAddress())) {
            this.fnP.setVisibility(8);
            this.fnQ.setVisibility(8);
            return;
        }
        this.fnP.setText(this.aim.getAddress());
        this.fnP.setVisibility(0);
        this.fnQ.setVisibility(0);
    }

    public void L(bz bzVar) {
        String str;
        if (bzVar == null) {
            this.fni.setVisibility(8);
            this.fnV.setVisibility(8);
            return;
        }
        this.aim.brv();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bzVar.bth()) {
            str2 = bzVar.eVM.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.fni.setVisibility(8);
            this.fnV.setVisibility(8);
            return;
        }
        if (this.aim.eVz > 0 && this.aim.eVA == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.fni.setText(str);
        this.fni.setVisibility(0);
        this.fnV.setVisibility(0);
    }

    public void kg(boolean z) {
        if (z) {
            L(this.aim);
            return;
        }
        this.fni.setVisibility(8);
        this.fnV.setVisibility(8);
    }

    private void d(bz bzVar) {
        if (this.fnt != null && bzVar != null && this.aim.brr() != null) {
            if (this.aim.eVz > 0 && this.aim.eVA == 0) {
                this.fnt.setShowV(false);
            } else {
                this.fnt.setShowV(this.aim.brr().isBigV());
            }
        }
    }

    private void tO() {
        if (this.aim != null && this.aim.brr() != null) {
            if (this.aim.eVz > 0 && this.aim.eVA == 0) {
                ao.setViewTextColor(this.ala, R.color.CAM_X0106);
            } else if (!x.isEmpty(this.aim.brr().getTShowInfoNew()) || this.aim.brr().isBigV()) {
                ao.setViewTextColor(this.ala, R.color.CAM_X0301);
            } else {
                ao.setViewTextColor(this.ala, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        tO();
        ao.setViewTextColor(this.alh, R.color.CAM_X0106);
        ao.setViewTextColor(this.fmn, R.color.CAM_X0109);
        ao.setBackgroundColor(this.fnQ, R.color.CAM_X0110);
        ao.setViewTextColor(this.fnP, R.color.CAM_X0109);
        ao.setViewTextColor(this.fni, R.color.CAM_X0109);
        ao.setBackgroundColor(this.fnQ, R.color.CAM_X0110);
        ao.setBackgroundColor(this.fnV, R.color.CAM_X0110);
        m(this.aim);
    }

    public void setIsSimpleThread(boolean z) {
        this.fnW = z;
    }

    public boolean getIsSimpleThread() {
        return this.fnW;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alk = onClickListener;
        if (this.fnt != null) {
            this.fnt.setAfterClickListener(this.alk);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fnt != null) {
            this.fnt.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fnt;
    }

    public TextView getUserName() {
        return this.ala;
    }

    protected String Cz(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.fnU = z;
    }

    public void setIsFromConcern(boolean z) {
        this.fnX = z;
    }
}

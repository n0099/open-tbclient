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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bv aeA;
    private View.OnClickListener ahD;
    private View.OnClickListener ahK;
    private View.OnClickListener ahL;
    private View.OnClickListener ahM;
    public TextView ahr;
    public TextView ahs;
    protected UserIconBox aht;
    private UserIconBox ahu;
    protected TextView ahy;
    private TextView ejA;
    public ClickableHeaderImageView ekI;
    private TextView ekx;
    private TextView ele;
    private View elf;
    private TextView elg;
    private View elh;
    private FrameLayout eli;
    private boolean elj;
    private View elk;
    private boolean ell;
    private boolean elm;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.elj = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getUserId()) && ThreadUserInfoLayout.this.aeA.aWp() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bf.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeA.aWl().getUserId(), ThreadUserInfoLayout.this.aeA.aWl().getName_show(), ThreadUserInfoLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahD != null) {
                        ThreadUserInfoLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elj = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getUserId()) && ThreadUserInfoLayout.this.aeA.aWp() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bf.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeA.aWl().getUserId(), ThreadUserInfoLayout.this.aeA.aWl().getName_show(), ThreadUserInfoLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahD != null) {
                        ThreadUserInfoLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.elj = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ahK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aeA.aWl().getUserId()) && ThreadUserInfoLayout.this.aeA.aWp() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bf.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aeA.aWl().getUserId(), ThreadUserInfoLayout.this.aeA.aWl().getName_show(), ThreadUserInfoLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aeA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ahD != null) {
                        ThreadUserInfoLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aeA != null && ThreadUserInfoLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.ekI = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ahu = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ahr = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ahs = (TextView) inflate.findViewById(R.id.identity_view);
        this.aht = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.ejA = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.ele = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.elf = inflate.findViewById(R.id.divider);
        this.elk = findViewById(R.id.divider_forum_name);
        this.ekx = (TextView) findViewById(R.id.thread_info_forum_name);
        this.ahy = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.elg = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.eli = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.elh = com.baidu.tbadk.ala.b.aSa().p(this.mContext, 1);
        if (this.elh != null) {
            this.elh.setVisibility(8);
            this.eli.addView(this.elh);
        }
        setGravity(16);
        initHeaderImg();
        this.ahu.setOnClickListener(this.ahK);
        this.ahr.setOnClickListener(this.ahL);
        this.aht.setOnClickListener(this.ahM);
    }

    public boolean setData(bv bvVar) {
        if (bvVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeA = bvVar;
        if (this.aeA.dUg > 0) {
            if (this.aeA.dUh == 0 && this.aeA.aWl() != null) {
                if (!x.isEmpty(this.aeA.aWl().getTShowInfoNew())) {
                    this.aeA.aWl().getTShowInfoNew().clear();
                }
                this.aeA.aWl().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ahu.setOnClickListener(null);
            this.ahr.setOnClickListener(null);
            this.aht.setOnClickListener(null);
            this.ekI.setClickable(false);
        } else {
            this.ahu.setOnClickListener(this.ahK);
            this.ahr.setOnClickListener(this.ahL);
            this.aht.setOnClickListener(this.ahM);
            this.ekI.setClickable(true);
        }
        k(bvVar);
        h(bvVar);
        i(bvVar);
        j(bvVar);
        l(bvVar);
        C(bvVar);
        H(bvVar);
        c(bvVar);
        I(bvVar);
        setVisibility(0);
        G(bvVar);
        F(bvVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.ekI != null) {
            this.ekI.setDefaultResource(17170445);
            this.ekI.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ekI.setPlaceHolder(1);
            this.ekI.setIsRound(true);
            this.ekI.setAfterClickListener(this.ahD);
        }
    }

    private void F(bv bvVar) {
        if (this.mFrom == 3) {
            if (bvVar != null && bvVar.aWl() != null && bvVar.aWl().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bvVar.aWl().getAlaUserData();
                if (this.elh != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dIq = alaUserData;
                    aVar.type = 1;
                    this.elh.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.elh.setVisibility(8);
                    } else {
                        this.elh.setVisibility(0);
                    }
                }
            } else if (this.elh != null) {
                this.elh.setVisibility(8);
            }
        }
    }

    private void G(bv bvVar) {
        if (this.elg != null && bvVar != null && bvVar.aWl() != null) {
            if (bvVar.aWl().hadConcerned()) {
                this.elg.setVisibility(0);
                ao.setViewTextColor(this.elg, R.color.cp_cont_d);
                ao.setBackgroundResource(this.elg, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.elg.setVisibility(8);
        }
    }

    private void k(bv bvVar) {
        if (this.ahu != null && bvVar != null && bvVar.aWl() != null) {
            ArrayList<IconData> tShowInfoNew = bvVar.aWl().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ahu.setVisibility(0);
                this.ahu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ahu.setVisibility(8);
        }
    }

    private void l(bv bvVar) {
        if (this.ahs != null && bvVar != null && bvVar.aWl() != null) {
            MetaData aWl = bvVar.aWl();
            if (aWl.getIs_bawu() == 1) {
                int i = bvVar.dUu ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bvVar.dUu ? R.color.cp_cont_a : R.color.cp_cont_j;
                ao.setBackgroundResource(this.ahs, i);
                ao.setViewTextColor(this.ahs, i2);
                if (bvVar.dUu) {
                    this.ahs.setVisibility(0);
                    this.ahs.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                    this.ahs.setVisibility(0);
                    this.ahs.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                    this.ahs.setText(R.string.bawu_member_xbazhu_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(aWl.getBawu_type())) {
                    this.ahs.setText(R.string.bawu_content_assist_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(aWl.getBawu_type())) {
                    this.ahs.setText(R.string.bawu_manage_assist_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else {
                    this.ahs.setVisibility(8);
                    return;
                }
            }
            this.ahs.setVisibility(8);
        }
    }

    private void h(bv bvVar) {
        if (this.ahr != null && bvVar != null) {
            if (!StringUtils.isNull(this.aeA.aWl().getName_show())) {
                this.ahr.setText(yr(this.aeA.aWl().getName_show()));
            }
            st();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.aeA.aWl().getName_show();
                String userName = this.aeA.aWl().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ahr.setText(com.baidu.tieba.pb.c.aJ(this.mContext, this.ahr.getText().toString()));
                    this.ahr.setGravity(16);
                    this.ahr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cKh());
                    ao.setViewTextColor(this.ahr, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void j(bv bvVar) {
        if (this.aht != null) {
            if (this.elm) {
                this.aht.setVisibility(8);
            } else if (bvVar == null || bvVar.aWl() == null || ((bvVar.dUg > 0 && bvVar.dUh == 0) || !this.elj)) {
                this.aht.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bvVar.aWl().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.aht.setVisibility(0);
                    this.aht.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.aht.setVisibility(8);
            }
        }
    }

    private void C(bv bvVar) {
        String formatTime;
        if (this.ejA != null && bvVar != null) {
            if (bvVar.aWe() <= 0) {
                this.ejA.setVisibility(4);
                return;
            }
            this.ejA.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = as.getPostTimeInterval(bvVar.aWe());
            } else if (bvVar.aXC()) {
                formatTime = as.getFormatTime(bvVar.getCreateTime());
            } else {
                formatTime = as.getFormatTime(bvVar.aWe() * 1000);
            }
            this.ejA.setText(formatTime);
        }
    }

    protected void i(bv bvVar) {
        if (this.ahy == null || bvVar == null) {
            this.ahy.setVisibility(8);
        } else if (this.elm) {
            if (StringUtils.isNull(bvVar.aTO())) {
                this.ahy.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahy.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ahy.setLayoutParams(layoutParams);
            }
            this.ahy.setText(bvVar.aTO());
            this.ahy.setVisibility(0);
        } else if (this.aeA.aWF() == null || this.aeA.aWF().share_info == null || this.aeA.aWF().share_info.share_user_count <= 0 || !this.aeA.aXF() || (this.aeA.dUg > 0 && this.aeA.dUh == 0)) {
            this.ahy.setVisibility(8);
        } else {
            this.ahy.setVisibility(0);
            int i = this.aeA.aWF().share_info.share_user_count;
            if (i == 1) {
                this.ahy.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.ahy.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{as.numberUniform(i)}));
            }
        }
    }

    private void H(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.getAddress())) {
            this.ele.setVisibility(8);
            this.elf.setVisibility(8);
            return;
        }
        this.ele.setText(this.aeA.getAddress());
        this.ele.setVisibility(0);
        this.elf.setVisibility(0);
    }

    public void I(bv bvVar) {
        String str;
        if (bvVar == null) {
            this.ekx.setVisibility(8);
            this.elk.setVisibility(8);
            return;
        }
        this.aeA.aWp();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bvVar.aXY()) {
            str2 = bvVar.dUt.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.ekx.setVisibility(8);
            this.elk.setVisibility(8);
            return;
        }
        if (this.aeA.dUg > 0 && this.aeA.dUh == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = as.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.ekx.setText(str);
        this.ekx.setVisibility(0);
        this.elk.setVisibility(0);
    }

    public void ie(boolean z) {
        if (z) {
            I(this.aeA);
            return;
        }
        this.ekx.setVisibility(8);
        this.elk.setVisibility(8);
    }

    private void c(bv bvVar) {
        if (this.ekI != null && bvVar != null && this.aeA.aWl() != null) {
            if (this.aeA.dUg > 0 && this.aeA.dUh == 0) {
                this.ekI.setShowV(false);
            } else {
                this.ekI.setShowV(this.aeA.aWl().isBigV());
            }
        }
    }

    private void st() {
        if (this.aeA != null && this.aeA.aWl() != null) {
            if (this.aeA.dUg > 0 && this.aeA.dUh == 0) {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_f);
            } else if (!x.isEmpty(this.aeA.aWl().getTShowInfoNew()) || this.aeA.aWl().isBigV()) {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_h);
            } else {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        st();
        ao.setViewTextColor(this.ahy, R.color.cp_cont_f);
        ao.setViewTextColor(this.ejA, R.color.cp_cont_d);
        ao.setBackgroundColor(this.elf, R.color.cp_cont_e);
        ao.setViewTextColor(this.ele, R.color.cp_cont_d);
        ao.setViewTextColor(this.ekx, R.color.cp_cont_d);
        ao.setBackgroundColor(this.elf, R.color.cp_cont_e);
        ao.setBackgroundColor(this.elk, R.color.cp_cont_e);
        l(this.aeA);
    }

    public void setIsSimpleThread(boolean z) {
        this.ell = z;
    }

    public boolean getIsSimpleThread() {
        return this.ell;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
        if (this.ekI != null) {
            this.ekI.setAfterClickListener(this.ahD);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ekI != null) {
            this.ekI.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ekI;
    }

    public TextView getUserName() {
        return this.ahr;
    }

    protected String yr(String str) {
        return as.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.elj = z;
    }

    public void setIsFromConcern(boolean z) {
        this.elm = z;
    }
}

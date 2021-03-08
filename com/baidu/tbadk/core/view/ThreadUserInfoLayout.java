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
import com.baidu.tbadk.core.data.cb;
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
    private cb aiB;
    private View.OnClickListener alB;
    private View.OnClickListener alJ;
    private View.OnClickListener alK;
    private View.OnClickListener alL;
    public TextView alr;
    public TextView als;
    protected UserIconBox alt;
    private UserIconBox alu;
    protected TextView aly;
    private TextView flu;
    public ClickableHeaderImageView fmB;
    private TextView fmX;
    private View fmY;
    private TextView fmZ;
    private TextView fmq;
    private View fna;
    private FrameLayout fnb;
    private boolean fnc;
    private View fnd;
    private boolean fne;
    private boolean fnf;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.fnc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getUserId()) && ThreadUserInfoLayout.this.aiB.bnW() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiB.bnS().getUserId(), ThreadUserInfoLayout.this.aiB.bnS().getName_show(), ThreadUserInfoLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aiB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alB != null) {
                        ThreadUserInfoLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.alL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getUserId()) && ThreadUserInfoLayout.this.aiB.bnW() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiB.bnS().getUserId(), ThreadUserInfoLayout.this.aiB.bnS().getName_show(), ThreadUserInfoLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aiB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alB != null) {
                        ThreadUserInfoLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.alL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnc = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.alJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aiB.bnS().getUserId()) && ThreadUserInfoLayout.this.aiB.bnW() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aiB.bnS().getUserId(), ThreadUserInfoLayout.this.aiB.bnS().getName_show(), ThreadUserInfoLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aiB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.alB != null) {
                        ThreadUserInfoLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.alL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aiB != null && ThreadUserInfoLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.fmB = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.alu = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.alr = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.als = (TextView) inflate.findViewById(R.id.identity_view);
        this.alt = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.flu = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.fmX = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fmY = inflate.findViewById(R.id.divider);
        this.fnd = findViewById(R.id.divider_forum_name);
        this.fmq = (TextView) findViewById(R.id.thread_info_forum_name);
        this.aly = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.fmZ = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.fnb = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.fna = com.baidu.tbadk.ala.b.bjS().A(this.mContext, 1);
        if (this.fna != null) {
            this.fna.setVisibility(8);
            this.fnb.addView(this.fna);
        }
        setGravity(16);
        initHeaderImg();
        this.alu.setOnClickListener(this.alJ);
        this.alr.setOnClickListener(this.alK);
        this.alt.setOnClickListener(this.alL);
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiB = cbVar;
        if (this.aiB.eUB > 0) {
            if (this.aiB.eUC == 0 && this.aiB.bnS() != null) {
                if (!y.isEmpty(this.aiB.bnS().getTShowInfoNew())) {
                    this.aiB.bnS().getTShowInfoNew().clear();
                }
                this.aiB.bnS().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.alu.setOnClickListener(null);
            this.alr.setOnClickListener(null);
            this.alt.setOnClickListener(null);
            this.fmB.setClickable(false);
        } else {
            this.alu.setOnClickListener(this.alJ);
            this.alr.setOnClickListener(this.alK);
            this.alt.setOnClickListener(this.alL);
            this.fmB.setClickable(true);
        }
        l(cbVar);
        i(cbVar);
        j(cbVar);
        k(cbVar);
        m(cbVar);
        G(cbVar);
        L(cbVar);
        d(cbVar);
        M(cbVar);
        setVisibility(0);
        K(cbVar);
        J(cbVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.fmB != null) {
            this.fmB.setDefaultResource(17170445);
            this.fmB.setPlaceHolder(1);
            this.fmB.setIsRound(true);
            this.fmB.setAfterClickListener(this.alB);
        }
    }

    private void J(cb cbVar) {
        if (this.mFrom == 3) {
            if (cbVar != null && cbVar.bnS() != null && cbVar.bnS().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnS().getAlaUserData();
                if (this.fna != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eIb = alaUserData;
                    aVar.type = 1;
                    this.fna.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.fna.setVisibility(8);
                    } else {
                        this.fna.setVisibility(0);
                    }
                }
            } else if (this.fna != null) {
                this.fna.setVisibility(8);
            }
        }
    }

    private void K(cb cbVar) {
        if (this.fmZ != null && cbVar != null && cbVar.bnS() != null) {
            if (cbVar.bnS().hadConcerned()) {
                this.fmZ.setVisibility(0);
                ap.setViewTextColor(this.fmZ, R.color.CAM_X0109);
                ap.setBackgroundResource(this.fmZ, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.fmZ.setVisibility(8);
        }
    }

    private void l(cb cbVar) {
        if (this.alu != null && cbVar != null && cbVar.bnS() != null) {
            ArrayList<IconData> tShowInfoNew = cbVar.bnS().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.alu.setVisibility(0);
                this.alu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.alu.setVisibility(8);
        }
    }

    private void m(cb cbVar) {
        if (this.als != null && cbVar != null && cbVar.bnS() != null) {
            MetaData bnS = cbVar.bnS();
            if (bnS.getIs_bawu() == 1) {
                int i = cbVar.eUP ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = cbVar.eUP ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ap.setBackgroundResource(this.als, i);
                ap.setViewTextColor(this.als, i2);
                if (cbVar.eUP) {
                    this.als.setVisibility(0);
                    this.als.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                    this.als.setVisibility(0);
                    this.als.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_member_xbazhu_tip);
                    this.als.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_content_assist_tip);
                    this.als.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_manage_assist_tip);
                    this.als.setVisibility(0);
                    return;
                } else {
                    this.als.setVisibility(8);
                    return;
                }
            }
            this.als.setVisibility(8);
        }
    }

    private void i(cb cbVar) {
        if (this.alr != null && cbVar != null) {
            if (!StringUtils.isNull(this.aiB.bnS().getName_show())) {
                this.alr.setText(BM(this.aiB.bnS().getName_show()));
            }
            tA();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.aiB.bnS().getName_show();
                String userName = this.aiB.bnS().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.alr.setText(com.baidu.tieba.pb.c.aY(this.mContext, this.alr.getText().toString()));
                    this.alr.setGravity(16);
                    this.alr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkZ());
                    ap.setViewTextColor(this.alr, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(cb cbVar) {
        if (this.alt != null) {
            if (this.fnf) {
                this.alt.setVisibility(8);
            } else if (cbVar == null || cbVar.bnS() == null || ((cbVar.eUB > 0 && cbVar.eUC == 0) || !this.fnc)) {
                this.alt.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = cbVar.bnS().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.alt.setVisibility(0);
                    this.alt.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.alt.setVisibility(8);
            }
        }
    }

    private void G(cb cbVar) {
        String formatTime;
        if (this.flu != null && cbVar != null) {
            if (cbVar.bnL() <= 0) {
                this.flu.setVisibility(4);
                return;
            }
            this.flu.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = au.getPostTimeInterval(cbVar.bnL());
            } else if (cbVar.bpl()) {
                formatTime = au.getFormatTime(cbVar.getCreateTime());
            } else {
                formatTime = au.getFormatTime(cbVar.bnL() * 1000);
            }
            this.flu.setText(formatTime);
        }
    }

    protected void j(cb cbVar) {
        if (this.aly == null || cbVar == null) {
            this.aly.setVisibility(8);
        } else if (this.fnf) {
            if (StringUtils.isNull(cbVar.blq())) {
                this.aly.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aly.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aly.setLayoutParams(layoutParams);
            }
            this.aly.setText(cbVar.blq());
            this.aly.setVisibility(0);
        } else if (this.aiB.bol() == null || this.aiB.bol().share_info == null || this.aiB.bol().share_info.share_user_count <= 0 || !this.aiB.bpo() || (this.aiB.eUB > 0 && this.aiB.eUC == 0)) {
            this.aly.setVisibility(8);
        } else {
            this.aly.setVisibility(0);
            int i = this.aiB.bol().share_info.share_user_count;
            if (i == 1) {
                this.aly.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.aly.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{au.numberUniform(i)}));
            }
        }
    }

    private void L(cb cbVar) {
        if (cbVar == null || StringUtils.isNull(cbVar.getAddress())) {
            this.fmX.setVisibility(8);
            this.fmY.setVisibility(8);
            return;
        }
        this.fmX.setText(this.aiB.getAddress());
        this.fmX.setVisibility(0);
        this.fmY.setVisibility(0);
    }

    public void M(cb cbVar) {
        String str;
        if (cbVar == null) {
            this.fmq.setVisibility(8);
            this.fnd.setVisibility(8);
            return;
        }
        this.aiB.bnW();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (cbVar.bpH()) {
            str2 = cbVar.eUO.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.fmq.setVisibility(8);
            this.fnd.setVisibility(8);
            return;
        }
        if (this.aiB.eUB > 0 && this.aiB.eUC == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = au.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.fmq.setText(str);
        this.fmq.setVisibility(0);
        this.fnd.setVisibility(0);
    }

    public void kf(boolean z) {
        if (z) {
            M(this.aiB);
            return;
        }
        this.fmq.setVisibility(8);
        this.fnd.setVisibility(8);
    }

    private void d(cb cbVar) {
        if (this.fmB != null && cbVar != null && this.aiB.bnS() != null) {
            if (this.aiB.eUB > 0 && this.aiB.eUC == 0) {
                this.fmB.setShowV(false);
            } else {
                this.fmB.setShowV(this.aiB.bnS().isBigV());
            }
        }
    }

    private void tA() {
        if (this.aiB != null && this.aiB.bnS() != null) {
            if (this.aiB.eUB > 0 && this.aiB.eUC == 0) {
                ap.setViewTextColor(this.alr, R.color.CAM_X0106);
            } else if (!y.isEmpty(this.aiB.bnS().getTShowInfoNew()) || this.aiB.bnS().isBigV()) {
                ap.setViewTextColor(this.alr, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.alr, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        tA();
        ap.setViewTextColor(this.aly, R.color.CAM_X0106);
        ap.setViewTextColor(this.flu, R.color.CAM_X0109);
        ap.setBackgroundColor(this.fmY, R.color.CAM_X0110);
        ap.setViewTextColor(this.fmX, R.color.CAM_X0109);
        ap.setViewTextColor(this.fmq, R.color.CAM_X0109);
        ap.setBackgroundColor(this.fmY, R.color.CAM_X0110);
        ap.setBackgroundColor(this.fnd, R.color.CAM_X0110);
        m(this.aiB);
    }

    public void setIsSimpleThread(boolean z) {
        this.fne = z;
    }

    public boolean getIsSimpleThread() {
        return this.fne;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alB = onClickListener;
        if (this.fmB != null) {
            this.fmB.setAfterClickListener(this.alB);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fmB != null) {
            this.fmB.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fmB;
    }

    public TextView getUserName() {
        return this.alr;
    }

    protected String BM(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.fnc = z;
    }

    public void setIsFromConcern(boolean z) {
        this.fnf = z;
    }
}

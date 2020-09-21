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
    private bw agf;
    public TextView ajb;
    public TextView ajc;
    protected UserIconBox ajd;
    private UserIconBox aje;
    protected TextView aji;
    private View.OnClickListener ajn;
    private View.OnClickListener aju;
    private View.OnClickListener ajv;
    private View.OnClickListener ajw;
    private TextView evD;
    private TextView ewA;
    public ClickableHeaderImageView ewL;
    private TextView exh;
    private View exi;
    private TextView exj;
    private View exk;
    private FrameLayout exl;
    private boolean exm;
    private View exn;
    private boolean exo;
    private boolean exp;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.exm = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getUserId()) && ThreadUserInfoLayout.this.agf.bfC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agf.bfy().getUserId(), ThreadUserInfoLayout.this.agf.bfy().getName_show(), ThreadUserInfoLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agf.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajn != null) {
                        ThreadUserInfoLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.ajw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exm = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getUserId()) && ThreadUserInfoLayout.this.agf.bfC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agf.bfy().getUserId(), ThreadUserInfoLayout.this.agf.bfy().getName_show(), ThreadUserInfoLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agf.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajn != null) {
                        ThreadUserInfoLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.ajw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exm = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agf.bfy().getUserId()) && ThreadUserInfoLayout.this.agf.bfC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agf.bfy().getUserId(), ThreadUserInfoLayout.this.agf.bfy().getName_show(), ThreadUserInfoLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agf.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajn != null) {
                        ThreadUserInfoLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.ajw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agf != null && ThreadUserInfoLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.ewL = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.aje = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ajb = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ajc = (TextView) inflate.findViewById(R.id.identity_view);
        this.ajd = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.evD = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.exh = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.exi = inflate.findViewById(R.id.divider);
        this.exn = findViewById(R.id.divider_forum_name);
        this.ewA = (TextView) findViewById(R.id.thread_info_forum_name);
        this.aji = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.exj = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.exl = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.exk = com.baidu.tbadk.ala.b.bbl().q(this.mContext, 1);
        if (this.exk != null) {
            this.exk.setVisibility(8);
            this.exl.addView(this.exk);
        }
        setGravity(16);
        initHeaderImg();
        this.aje.setOnClickListener(this.aju);
        this.ajb.setOnClickListener(this.ajv);
        this.ajd.setOnClickListener(this.ajw);
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agf = bwVar;
        if (this.agf.efQ > 0) {
            if (this.agf.efR == 0 && this.agf.bfy() != null) {
                if (!y.isEmpty(this.agf.bfy().getTShowInfoNew())) {
                    this.agf.bfy().getTShowInfoNew().clear();
                }
                this.agf.bfy().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.aje.setOnClickListener(null);
            this.ajb.setOnClickListener(null);
            this.ajd.setOnClickListener(null);
            this.ewL.setClickable(false);
        } else {
            this.aje.setOnClickListener(this.aju);
            this.ajb.setOnClickListener(this.ajv);
            this.ajd.setOnClickListener(this.ajw);
            this.ewL.setClickable(true);
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
        if (this.ewL != null) {
            this.ewL.setDefaultResource(17170445);
            this.ewL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.ewL.setPlaceHolder(1);
            this.ewL.setIsRound(true);
            this.ewL.setAfterClickListener(this.ajn);
        }
    }

    private void G(bw bwVar) {
        if (this.mFrom == 3) {
            if (bwVar != null && bwVar.bfy() != null && bwVar.bfy().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bfy().getAlaUserData();
                if (this.exk != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dTL = alaUserData;
                    aVar.type = 1;
                    this.exk.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.exk.setVisibility(8);
                    } else {
                        this.exk.setVisibility(0);
                    }
                }
            } else if (this.exk != null) {
                this.exk.setVisibility(8);
            }
        }
    }

    private void H(bw bwVar) {
        if (this.exj != null && bwVar != null && bwVar.bfy() != null) {
            if (bwVar.bfy().hadConcerned()) {
                this.exj.setVisibility(0);
                ap.setViewTextColor(this.exj, R.color.cp_cont_d);
                ap.setBackgroundResource(this.exj, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.exj.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.aje != null && bwVar != null && bwVar.bfy() != null) {
            ArrayList<IconData> tShowInfoNew = bwVar.bfy().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aje.setVisibility(0);
                this.aje.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aje.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.ajc != null && bwVar != null && bwVar.bfy() != null) {
            MetaData bfy = bwVar.bfy();
            if (bfy.getIs_bawu() == 1) {
                int i = bwVar.ege ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bwVar.ege ? R.color.cp_cont_a : R.color.cp_cont_j;
                ap.setBackgroundResource(this.ajc, i);
                ap.setViewTextColor(this.ajc, i2);
                if (bwVar.ege) {
                    this.ajc.setVisibility(0);
                    this.ajc.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bfy.getBawu_type())) {
                    this.ajc.setVisibility(0);
                    this.ajc.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bfy.getBawu_type())) {
                    this.ajc.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bfy.getBawu_type())) {
                    this.ajc.setText(R.string.bawu_content_assist_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bfy.getBawu_type())) {
                    this.ajc.setText(R.string.bawu_manage_assist_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else {
                    this.ajc.setVisibility(8);
                    return;
                }
            }
            this.ajc.setVisibility(8);
        }
    }

    private void i(bw bwVar) {
        if (this.ajb != null && bwVar != null) {
            if (!StringUtils.isNull(this.agf.bfy().getName_show())) {
                this.ajb.setText(Bc(this.agf.bfy().getName_show()));
            }
            um();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.agf.bfy().getName_show();
                String userName = this.agf.bfy().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ajb.setText(com.baidu.tieba.pb.c.aQ(this.mContext, this.ajb.getText().toString()));
                    this.ajb.setGravity(16);
                    this.ajb.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.cYB());
                    ap.setViewTextColor(this.ajb, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajd != null) {
            if (this.exp) {
                this.ajd.setVisibility(8);
            } else if (bwVar == null || bwVar.bfy() == null || ((bwVar.efQ > 0 && bwVar.efR == 0) || !this.exm)) {
                this.ajd.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bfy().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajd.setVisibility(0);
                    this.ajd.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.ajd.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String formatTime;
        if (this.evD != null && bwVar != null) {
            if (bwVar.bfr() <= 0) {
                this.evD.setVisibility(4);
                return;
            }
            this.evD.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bwVar.bfr());
            } else if (bwVar.bgP()) {
                formatTime = at.getFormatTime(bwVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bwVar.bfr() * 1000);
            }
            this.evD.setText(formatTime);
        }
    }

    protected void j(bw bwVar) {
        if (this.aji == null || bwVar == null) {
            this.aji.setVisibility(8);
        } else if (this.exp) {
            if (StringUtils.isNull(bwVar.bcZ())) {
                this.aji.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aji.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aji.setLayoutParams(layoutParams);
            }
            this.aji.setText(bwVar.bcZ());
            this.aji.setVisibility(0);
        } else if (this.agf.bfS() == null || this.agf.bfS().share_info == null || this.agf.bfS().share_info.share_user_count <= 0 || !this.agf.bgS() || (this.agf.efQ > 0 && this.agf.efR == 0)) {
            this.aji.setVisibility(8);
        } else {
            this.aji.setVisibility(0);
            int i = this.agf.bfS().share_info.share_user_count;
            if (i == 1) {
                this.aji.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.aji.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void I(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.getAddress())) {
            this.exh.setVisibility(8);
            this.exi.setVisibility(8);
            return;
        }
        this.exh.setText(this.agf.getAddress());
        this.exh.setVisibility(0);
        this.exi.setVisibility(0);
    }

    public void J(bw bwVar) {
        String str;
        if (bwVar == null) {
            this.ewA.setVisibility(8);
            this.exn.setVisibility(8);
            return;
        }
        this.agf.bfC();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bwVar.bhl()) {
            str2 = bwVar.egd.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.ewA.setVisibility(8);
            this.exn.setVisibility(8);
            return;
        }
        if (this.agf.efQ > 0 && this.agf.efR == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.ewA.setText(str);
        this.ewA.setVisibility(0);
        this.exn.setVisibility(0);
    }

    public void iz(boolean z) {
        if (z) {
            J(this.agf);
            return;
        }
        this.ewA.setVisibility(8);
        this.exn.setVisibility(8);
    }

    private void d(bw bwVar) {
        if (this.ewL != null && bwVar != null && this.agf.bfy() != null) {
            if (this.agf.efQ > 0 && this.agf.efR == 0) {
                this.ewL.setShowV(false);
            } else {
                this.ewL.setShowV(this.agf.bfy().isBigV());
            }
        }
    }

    private void um() {
        if (this.agf != null && this.agf.bfy() != null) {
            if (this.agf.efQ > 0 && this.agf.efR == 0) {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_f);
            } else if (!y.isEmpty(this.agf.bfy().getTShowInfoNew()) || this.agf.bfy().isBigV()) {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        um();
        ap.setViewTextColor(this.aji, R.color.cp_cont_f);
        ap.setViewTextColor(this.evD, R.color.cp_cont_d);
        ap.setBackgroundColor(this.exi, R.color.cp_cont_e);
        ap.setViewTextColor(this.exh, R.color.cp_cont_d);
        ap.setViewTextColor(this.ewA, R.color.cp_cont_d);
        ap.setBackgroundColor(this.exi, R.color.cp_cont_e);
        ap.setBackgroundColor(this.exn, R.color.cp_cont_e);
        m(this.agf);
    }

    public void setIsSimpleThread(boolean z) {
        this.exo = z;
    }

    public boolean getIsSimpleThread() {
        return this.exo;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajn = onClickListener;
        if (this.ewL != null) {
            this.ewL.setAfterClickListener(this.ajn);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ewL != null) {
            this.ewL.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ewL;
    }

    public TextView getUserName() {
        return this.ajb;
    }

    protected String Bc(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.exm = z;
    }

    public void setIsFromConcern(boolean z) {
        this.exp = z;
    }
}

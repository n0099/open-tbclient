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
    private cb ahi;
    public TextView ajY;
    public TextView ajZ;
    protected UserIconBox aka;
    private UserIconBox akb;
    protected TextView akf;
    private View.OnClickListener aki;
    private View.OnClickListener akq;
    private View.OnClickListener akr;
    private View.OnClickListener aks;
    private TextView fjV;
    private TextView fkQ;
    private View flA;
    private FrameLayout flB;
    private boolean flC;
    private View flD;
    private boolean flE;
    private boolean flF;
    public ClickableHeaderImageView flb;
    private TextView flx;
    private View fly;
    private TextView flz;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.flC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getUserId()) && ThreadUserInfoLayout.this.ahi.bnU() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), ThreadUserInfoLayout.this.ahi.bnQ().getName_show(), ThreadUserInfoLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahi.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aki != null) {
                        ThreadUserInfoLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.aks = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getUserId()) && ThreadUserInfoLayout.this.ahi.bnU() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), ThreadUserInfoLayout.this.ahi.bnQ().getName_show(), ThreadUserInfoLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahi.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aki != null) {
                        ThreadUserInfoLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.aks = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahi.bnQ().getUserId()) && ThreadUserInfoLayout.this.ahi.bnU() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), ThreadUserInfoLayout.this.ahi.bnQ().getName_show(), ThreadUserInfoLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahi.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.aki != null) {
                        ThreadUserInfoLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.aks = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahi != null && ThreadUserInfoLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.flb = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.akb = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.ajY = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ajZ = (TextView) inflate.findViewById(R.id.identity_view);
        this.aka = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.fjV = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.flx = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fly = inflate.findViewById(R.id.divider);
        this.flD = findViewById(R.id.divider_forum_name);
        this.fkQ = (TextView) findViewById(R.id.thread_info_forum_name);
        this.akf = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.flz = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.flB = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.flA = com.baidu.tbadk.ala.b.bjQ().A(this.mContext, 1);
        if (this.flA != null) {
            this.flA.setVisibility(8);
            this.flB.addView(this.flA);
        }
        setGravity(16);
        initHeaderImg();
        this.akb.setOnClickListener(this.akq);
        this.ajY.setOnClickListener(this.akr);
        this.aka.setOnClickListener(this.aks);
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahi = cbVar;
        if (this.ahi.eTa > 0) {
            if (this.ahi.eTb == 0 && this.ahi.bnQ() != null) {
                if (!y.isEmpty(this.ahi.bnQ().getTShowInfoNew())) {
                    this.ahi.bnQ().getTShowInfoNew().clear();
                }
                this.ahi.bnQ().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.akb.setOnClickListener(null);
            this.ajY.setOnClickListener(null);
            this.aka.setOnClickListener(null);
            this.flb.setClickable(false);
        } else {
            this.akb.setOnClickListener(this.akq);
            this.ajY.setOnClickListener(this.akr);
            this.aka.setOnClickListener(this.aks);
            this.flb.setClickable(true);
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
        if (this.flb != null) {
            this.flb.setDefaultResource(17170445);
            this.flb.setPlaceHolder(1);
            this.flb.setIsRound(true);
            this.flb.setAfterClickListener(this.aki);
        }
    }

    private void J(cb cbVar) {
        if (this.mFrom == 3) {
            if (cbVar != null && cbVar.bnQ() != null && cbVar.bnQ().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnQ().getAlaUserData();
                if (this.flA != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eGA = alaUserData;
                    aVar.type = 1;
                    this.flA.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.flA.setVisibility(8);
                    } else {
                        this.flA.setVisibility(0);
                    }
                }
            } else if (this.flA != null) {
                this.flA.setVisibility(8);
            }
        }
    }

    private void K(cb cbVar) {
        if (this.flz != null && cbVar != null && cbVar.bnQ() != null) {
            if (cbVar.bnQ().hadConcerned()) {
                this.flz.setVisibility(0);
                ap.setViewTextColor(this.flz, R.color.CAM_X0109);
                ap.setBackgroundResource(this.flz, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.flz.setVisibility(8);
        }
    }

    private void l(cb cbVar) {
        if (this.akb != null && cbVar != null && cbVar.bnQ() != null) {
            ArrayList<IconData> tShowInfoNew = cbVar.bnQ().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akb.setVisibility(0);
                this.akb.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akb.setVisibility(8);
        }
    }

    private void m(cb cbVar) {
        if (this.ajZ != null && cbVar != null && cbVar.bnQ() != null) {
            MetaData bnQ = cbVar.bnQ();
            if (bnQ.getIs_bawu() == 1) {
                int i = cbVar.eTo ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = cbVar.eTo ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ap.setBackgroundResource(this.ajZ, i);
                ap.setViewTextColor(this.ajZ, i2);
                if (cbVar.eTo) {
                    this.ajZ.setVisibility(0);
                    this.ajZ.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                    this.ajZ.setVisibility(0);
                    this.ajZ.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_content_assist_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_manage_assist_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else {
                    this.ajZ.setVisibility(8);
                    return;
                }
            }
            this.ajZ.setVisibility(8);
        }
    }

    private void i(cb cbVar) {
        if (this.ajY != null && cbVar != null) {
            if (!StringUtils.isNull(this.ahi.bnQ().getName_show())) {
                this.ajY.setText(BF(this.ahi.bnQ().getName_show()));
            }
            tA();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.ahi.bnQ().getName_show();
                String userName = this.ahi.bnQ().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.ajY.setText(com.baidu.tieba.pb.c.aY(this.mContext, this.ajY.getText().toString()));
                    this.ajY.setGravity(16);
                    this.ajY.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dkQ());
                    ap.setViewTextColor(this.ajY, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(cb cbVar) {
        if (this.aka != null) {
            if (this.flF) {
                this.aka.setVisibility(8);
            } else if (cbVar == null || cbVar.bnQ() == null || ((cbVar.eTa > 0 && cbVar.eTb == 0) || !this.flC)) {
                this.aka.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = cbVar.bnQ().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aka.setVisibility(0);
                    this.aka.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.aka.setVisibility(8);
            }
        }
    }

    private void G(cb cbVar) {
        String formatTime;
        if (this.fjV != null && cbVar != null) {
            if (cbVar.bnJ() <= 0) {
                this.fjV.setVisibility(4);
                return;
            }
            this.fjV.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = au.getPostTimeInterval(cbVar.bnJ());
            } else if (cbVar.bpj()) {
                formatTime = au.getFormatTime(cbVar.getCreateTime());
            } else {
                formatTime = au.getFormatTime(cbVar.bnJ() * 1000);
            }
            this.fjV.setText(formatTime);
        }
    }

    protected void j(cb cbVar) {
        if (this.akf == null || cbVar == null) {
            this.akf.setVisibility(8);
        } else if (this.flF) {
            if (StringUtils.isNull(cbVar.blo())) {
                this.akf.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akf.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.akf.setLayoutParams(layoutParams);
            }
            this.akf.setText(cbVar.blo());
            this.akf.setVisibility(0);
        } else if (this.ahi.boj() == null || this.ahi.boj().share_info == null || this.ahi.boj().share_info.share_user_count <= 0 || !this.ahi.bpm() || (this.ahi.eTa > 0 && this.ahi.eTb == 0)) {
            this.akf.setVisibility(8);
        } else {
            this.akf.setVisibility(0);
            int i = this.ahi.boj().share_info.share_user_count;
            if (i == 1) {
                this.akf.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.akf.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{au.numberUniform(i)}));
            }
        }
    }

    private void L(cb cbVar) {
        if (cbVar == null || StringUtils.isNull(cbVar.getAddress())) {
            this.flx.setVisibility(8);
            this.fly.setVisibility(8);
            return;
        }
        this.flx.setText(this.ahi.getAddress());
        this.flx.setVisibility(0);
        this.fly.setVisibility(0);
    }

    public void M(cb cbVar) {
        String str;
        if (cbVar == null) {
            this.fkQ.setVisibility(8);
            this.flD.setVisibility(8);
            return;
        }
        this.ahi.bnU();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (cbVar.bpF()) {
            str2 = cbVar.eTn.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.fkQ.setVisibility(8);
            this.flD.setVisibility(8);
            return;
        }
        if (this.ahi.eTa > 0 && this.ahi.eTb == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = au.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.fkQ.setText(str);
        this.fkQ.setVisibility(0);
        this.flD.setVisibility(0);
    }

    public void kf(boolean z) {
        if (z) {
            M(this.ahi);
            return;
        }
        this.fkQ.setVisibility(8);
        this.flD.setVisibility(8);
    }

    private void d(cb cbVar) {
        if (this.flb != null && cbVar != null && this.ahi.bnQ() != null) {
            if (this.ahi.eTa > 0 && this.ahi.eTb == 0) {
                this.flb.setShowV(false);
            } else {
                this.flb.setShowV(this.ahi.bnQ().isBigV());
            }
        }
    }

    private void tA() {
        if (this.ahi != null && this.ahi.bnQ() != null) {
            if (this.ahi.eTa > 0 && this.ahi.eTb == 0) {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0106);
            } else if (!y.isEmpty(this.ahi.bnQ().getTShowInfoNew()) || this.ahi.bnQ().isBigV()) {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        tA();
        ap.setViewTextColor(this.akf, R.color.CAM_X0106);
        ap.setViewTextColor(this.fjV, R.color.CAM_X0109);
        ap.setBackgroundColor(this.fly, R.color.CAM_X0110);
        ap.setViewTextColor(this.flx, R.color.CAM_X0109);
        ap.setViewTextColor(this.fkQ, R.color.CAM_X0109);
        ap.setBackgroundColor(this.fly, R.color.CAM_X0110);
        ap.setBackgroundColor(this.flD, R.color.CAM_X0110);
        m(this.ahi);
    }

    public void setIsSimpleThread(boolean z) {
        this.flE = z;
    }

    public boolean getIsSimpleThread() {
        return this.flE;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aki = onClickListener;
        if (this.flb != null) {
            this.flb.setAfterClickListener(this.aki);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.flb != null) {
            this.flb.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.flb;
    }

    public TextView getUserName() {
        return this.ajY;
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.flC = z;
    }

    public void setIsFromConcern(boolean z) {
        this.flF = z;
    }
}

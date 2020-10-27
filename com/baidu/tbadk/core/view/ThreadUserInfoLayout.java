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
    private bw agx;
    protected TextView ajB;
    private View.OnClickListener ajG;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    private View.OnClickListener ajP;
    public TextView aju;
    public TextView ajv;
    protected UserIconBox ajw;
    private UserIconBox ajx;
    private TextView eQj;
    private TextView eRN;
    private View eRO;
    private TextView eRP;
    private View eRQ;
    private FrameLayout eRR;
    private boolean eRS;
    private View eRT;
    private boolean eRU;
    private boolean eRV;
    private TextView eRg;
    public ClickableHeaderImageView eRr;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.eRS = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getUserId()) && ThreadUserInfoLayout.this.agx.bke() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agx.bka().getUserId(), ThreadUserInfoLayout.this.agx.bka().getName_show(), ThreadUserInfoLayout.this.agx.bke(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agx.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajG != null) {
                        ThreadUserInfoLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.ajP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agx.bka().getUserId(), true, true, true);
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
        this.eRS = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getUserId()) && ThreadUserInfoLayout.this.agx.bke() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agx.bka().getUserId(), ThreadUserInfoLayout.this.agx.bka().getName_show(), ThreadUserInfoLayout.this.agx.bke(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agx.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajG != null) {
                        ThreadUserInfoLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.ajP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agx.bka().getUserId(), true, true, true);
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
        this.eRS = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew() != null && y.getItem(ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.agx.bka().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.agx.bka().getUserId()) && ThreadUserInfoLayout.this.agx.bke() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.agx.bka().getUserId(), ThreadUserInfoLayout.this.agx.bka().getName_show(), ThreadUserInfoLayout.this.agx.bke(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.agx.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.ajG != null) {
                        ThreadUserInfoLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.ajP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.agx != null && ThreadUserInfoLayout.this.agx.bka() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.agx.bka().getUserId(), true, true, true);
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
        this.eRr = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.ajx = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.aju = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.ajv = (TextView) inflate.findViewById(R.id.identity_view);
        this.ajw = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.eQj = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.eRN = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.eRO = inflate.findViewById(R.id.divider);
        this.eRT = findViewById(R.id.divider_forum_name);
        this.eRg = (TextView) findViewById(R.id.thread_info_forum_name);
        this.ajB = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.eRP = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.eRR = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.eRQ = com.baidu.tbadk.ala.b.bfM().q(this.mContext, 1);
        if (this.eRQ != null) {
            this.eRQ.setVisibility(8);
            this.eRR.addView(this.eRQ);
        }
        setGravity(16);
        initHeaderImg();
        this.ajx.setOnClickListener(this.ajN);
        this.aju.setOnClickListener(this.ajO);
        this.ajw.setOnClickListener(this.ajP);
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agx = bwVar;
        if (this.agx.eAw > 0) {
            if (this.agx.eAx == 0 && this.agx.bka() != null) {
                if (!y.isEmpty(this.agx.bka().getTShowInfoNew())) {
                    this.agx.bka().getTShowInfoNew().clear();
                }
                this.agx.bka().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.ajx.setOnClickListener(null);
            this.aju.setOnClickListener(null);
            this.ajw.setOnClickListener(null);
            this.eRr.setClickable(false);
        } else {
            this.ajx.setOnClickListener(this.ajN);
            this.aju.setOnClickListener(this.ajO);
            this.ajw.setOnClickListener(this.ajP);
            this.eRr.setClickable(true);
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
        if (this.eRr != null) {
            this.eRr.setDefaultResource(17170445);
            this.eRr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.eRr.setPlaceHolder(1);
            this.eRr.setIsRound(true);
            this.eRr.setAfterClickListener(this.ajG);
        }
    }

    private void G(bw bwVar) {
        if (this.mFrom == 3) {
            if (bwVar != null && bwVar.bka() != null && bwVar.bka().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bka().getAlaUserData();
                if (this.eRQ != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eol = alaUserData;
                    aVar.type = 1;
                    this.eRQ.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.eRQ.setVisibility(8);
                    } else {
                        this.eRQ.setVisibility(0);
                    }
                }
            } else if (this.eRQ != null) {
                this.eRQ.setVisibility(8);
            }
        }
    }

    private void H(bw bwVar) {
        if (this.eRP != null && bwVar != null && bwVar.bka() != null) {
            if (bwVar.bka().hadConcerned()) {
                this.eRP.setVisibility(0);
                ap.setViewTextColor(this.eRP, R.color.cp_cont_d);
                ap.setBackgroundResource(this.eRP, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.eRP.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.ajx != null && bwVar != null && bwVar.bka() != null) {
            ArrayList<IconData> tShowInfoNew = bwVar.bka().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajx.setVisibility(0);
                this.ajx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajx.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.ajv != null && bwVar != null && bwVar.bka() != null) {
            MetaData bka = bwVar.bka();
            if (bka.getIs_bawu() == 1) {
                int i = bwVar.eAK ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bwVar.eAK ? R.color.cp_cont_a : R.color.cp_cont_j;
                ap.setBackgroundResource(this.ajv, i);
                ap.setViewTextColor(this.ajv, i2);
                if (bwVar.eAK) {
                    this.ajv.setVisibility(0);
                    this.ajv.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bka.getBawu_type())) {
                    this.ajv.setVisibility(0);
                    this.ajv.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bka.getBawu_type())) {
                    this.ajv.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bka.getBawu_type())) {
                    this.ajv.setText(R.string.bawu_content_assist_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bka.getBawu_type())) {
                    this.ajv.setText(R.string.bawu_manage_assist_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else {
                    this.ajv.setVisibility(8);
                    return;
                }
            }
            this.ajv.setVisibility(8);
        }
    }

    private void i(bw bwVar) {
        if (this.aju != null && bwVar != null) {
            if (!StringUtils.isNull(this.agx.bka().getName_show())) {
                this.aju.setText(Ch(this.agx.bka().getName_show()));
            }
            um();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.agx.bka().getName_show();
                String userName = this.agx.bka().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.aju.setText(com.baidu.tieba.pb.c.aU(this.mContext, this.aju.getText().toString()));
                    this.aju.setGravity(16);
                    this.aju.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dfs());
                    ap.setViewTextColor(this.aju, R.color.cp_other_f, 1);
                }
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajw != null) {
            if (this.eRV) {
                this.ajw.setVisibility(8);
            } else if (bwVar == null || bwVar.bka() == null || ((bwVar.eAw > 0 && bwVar.eAx == 0) || !this.eRS)) {
                this.ajw.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bka().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajw.setVisibility(0);
                    this.ajw.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.ajw.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String formatTime;
        if (this.eQj != null && bwVar != null) {
            if (bwVar.bjT() <= 0) {
                this.eQj.setVisibility(4);
                return;
            }
            this.eQj.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bwVar.bjT());
            } else if (bwVar.blr()) {
                formatTime = at.getFormatTime(bwVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bwVar.bjT() * 1000);
            }
            this.eQj.setText(formatTime);
        }
    }

    protected void j(bw bwVar) {
        if (this.ajB == null || bwVar == null) {
            this.ajB.setVisibility(8);
        } else if (this.eRV) {
            if (StringUtils.isNull(bwVar.bhA())) {
                this.ajB.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajB.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.ajB.setLayoutParams(layoutParams);
            }
            this.ajB.setText(bwVar.bhA());
            this.ajB.setVisibility(0);
        } else if (this.agx.bku() == null || this.agx.bku().share_info == null || this.agx.bku().share_info.share_user_count <= 0 || !this.agx.blu() || (this.agx.eAw > 0 && this.agx.eAx == 0)) {
            this.ajB.setVisibility(8);
        } else {
            this.ajB.setVisibility(0);
            int i = this.agx.bku().share_info.share_user_count;
            if (i == 1) {
                this.ajB.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.ajB.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void I(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.getAddress())) {
            this.eRN.setVisibility(8);
            this.eRO.setVisibility(8);
            return;
        }
        this.eRN.setText(this.agx.getAddress());
        this.eRN.setVisibility(0);
        this.eRO.setVisibility(0);
    }

    public void J(bw bwVar) {
        String str;
        if (bwVar == null) {
            this.eRg.setVisibility(8);
            this.eRT.setVisibility(8);
            return;
        }
        this.agx.bke();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bwVar.blN()) {
            str2 = bwVar.eAJ.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.eRg.setVisibility(8);
            this.eRT.setVisibility(8);
            return;
        }
        if (this.agx.eAw > 0 && this.agx.eAx == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.eRg.setText(str);
        this.eRg.setVisibility(0);
        this.eRT.setVisibility(0);
    }

    public void jk(boolean z) {
        if (z) {
            J(this.agx);
            return;
        }
        this.eRg.setVisibility(8);
        this.eRT.setVisibility(8);
    }

    private void d(bw bwVar) {
        if (this.eRr != null && bwVar != null && this.agx.bka() != null) {
            if (this.agx.eAw > 0 && this.agx.eAx == 0) {
                this.eRr.setShowV(false);
            } else {
                this.eRr.setShowV(this.agx.bka().isBigV());
            }
        }
    }

    private void um() {
        if (this.agx != null && this.agx.bka() != null) {
            if (this.agx.eAw > 0 && this.agx.eAx == 0) {
                ap.setViewTextColor(this.aju, R.color.cp_cont_f);
            } else if (!y.isEmpty(this.agx.bka().getTShowInfoNew()) || this.agx.bka().isBigV()) {
                ap.setViewTextColor(this.aju, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aju, R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        um();
        ap.setViewTextColor(this.ajB, R.color.cp_cont_f);
        ap.setViewTextColor(this.eQj, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eRO, R.color.cp_cont_e);
        ap.setViewTextColor(this.eRN, R.color.cp_cont_d);
        ap.setViewTextColor(this.eRg, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eRO, R.color.cp_cont_e);
        ap.setBackgroundColor(this.eRT, R.color.cp_cont_e);
        m(this.agx);
    }

    public void setIsSimpleThread(boolean z) {
        this.eRU = z;
    }

    public boolean getIsSimpleThread() {
        return this.eRU;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
        if (this.eRr != null) {
            this.eRr.setAfterClickListener(this.ajG);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eRr != null) {
            this.eRr.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.eRr;
    }

    public TextView getUserName() {
        return this.aju;
    }

    protected String Ch(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.eRS = z;
    }

    public void setIsFromConcern(boolean z) {
        this.eRV = z;
    }
}

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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements d {
    private bh Fs;
    public TextView He;
    public TextView Hf;
    protected UserIconBox Hg;
    private UserIconBox Hh;
    protected TextView Hj;
    private View Hm;
    private FrameLayout Hn;
    private View.OnClickListener Ho;
    private View.OnClickListener Ht;
    private View.OnClickListener Hu;
    private View.OnClickListener Hv;
    private TextView cpw;
    public ClickableHeaderImageView cqE;
    private TextView cqt;
    private TextView crb;
    private View crd;
    private TextView cre;
    private boolean crf;
    private View crg;
    private boolean crh;
    private boolean cri;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.crf = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Ht = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getUserId()) && ThreadUserInfoLayout.this.Fs.aiJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Fs.ajN() != null && ThreadUserInfoLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.ajN().channelId, ThreadUserInfoLayout.this.Fs.ajN().Zv)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.aiE().getUserId(), ThreadUserInfoLayout.this.Fs.aiE().getName_show(), ThreadUserInfoLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Fs.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Ho != null) {
                        ThreadUserInfoLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.Hv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crf = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Ht = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getUserId()) && ThreadUserInfoLayout.this.Fs.aiJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Fs.ajN() != null && ThreadUserInfoLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.ajN().channelId, ThreadUserInfoLayout.this.Fs.ajN().Zv)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.aiE().getUserId(), ThreadUserInfoLayout.this.Fs.aiE().getName_show(), ThreadUserInfoLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Fs.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Ho != null) {
                        ThreadUserInfoLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.Hv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crf = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.Ht = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew() != null && v.getItem(ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.Fs.aiE().getUserId()) && ThreadUserInfoLayout.this.Fs.aiJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.Fs.ajN() != null && ThreadUserInfoLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.ajN().channelId, ThreadUserInfoLayout.this.Fs.ajN().Zv)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.Fs.aiE().getUserId(), ThreadUserInfoLayout.this.Fs.aiE().getName_show(), ThreadUserInfoLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.Fs.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Ho != null) {
                        ThreadUserInfoLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.Hv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.Fs != null && ThreadUserInfoLayout.this.Fs.aiE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.cqE = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.Hh = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.He = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Hf = (TextView) inflate.findViewById(R.id.identity_view);
        this.Hg = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.cpw = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.crb = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.crd = inflate.findViewById(R.id.divider);
        this.crg = findViewById(R.id.divider_forum_name);
        this.cqt = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Hj = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.cre = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.Hn = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.Hm = com.baidu.tbadk.ala.b.afa().l(this.mContext, 1);
        if (this.Hm != null) {
            this.Hm.setVisibility(8);
            this.Hn.addView(this.Hm);
        }
        setGravity(16);
        initHeaderImg();
        this.Hh.setOnClickListener(this.Ht);
        this.He.setOnClickListener(this.Hu);
        this.Hg.setOnClickListener(this.Hv);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Fs = bhVar;
        if (this.Fs.cdj > 0) {
            if (this.Fs.cdk == 0 && this.Fs.aiE() != null) {
                if (!v.isEmpty(this.Fs.aiE().getTShowInfoNew())) {
                    this.Fs.aiE().getTShowInfoNew().clear();
                }
                this.Fs.aiE().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.Hh.setOnClickListener(null);
            this.He.setOnClickListener(null);
            this.Hg.setOnClickListener(null);
            this.cqE.setClickable(false);
        } else {
            this.Hh.setOnClickListener(this.Ht);
            this.He.setOnClickListener(this.Hu);
            this.Hg.setOnClickListener(this.Hv);
            this.cqE.setClickable(true);
        }
        j(bhVar);
        g(bhVar);
        h(bhVar);
        i(bhVar);
        k(bhVar);
        x(bhVar);
        C(bhVar);
        c(bhVar);
        D(bhVar);
        setVisibility(0);
        B(bhVar);
        f(bhVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.cqE != null) {
            this.cqE.setDefaultResource(17170445);
            this.cqE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cqE.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.cqE.setIsRound(true);
            this.cqE.setAfterClickListener(this.Ho);
        }
    }

    private void f(bh bhVar) {
        if (this.mFrom == 3) {
            if (bhVar != null && bhVar.aiE() != null && bhVar.aiE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aiE().getAlaUserData();
                if (this.Hm != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTc = alaUserData;
                    aVar.type = 1;
                    this.Hm.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.Hm.setVisibility(8);
                    } else {
                        this.Hm.setVisibility(0);
                    }
                }
            } else if (this.Hm != null) {
                this.Hm.setVisibility(8);
            }
        }
    }

    private void B(bh bhVar) {
        if (this.cre != null && bhVar != null && bhVar.aiE() != null) {
            if (bhVar.aiE().hadConcerned()) {
                this.cre.setVisibility(0);
                am.setViewTextColor(this.cre, (int) R.color.cp_cont_d);
                am.setBackgroundResource(this.cre, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.cre.setVisibility(8);
        }
    }

    private void j(bh bhVar) {
        if (this.Hh != null && bhVar != null && bhVar.aiE() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.aiE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Hh.setVisibility(0);
                this.Hh.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Hh.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.Hf != null && bhVar != null && bhVar.aiE() != null) {
            MetaData aiE = bhVar.aiE();
            if (aiE.getIs_bawu() == 1) {
                int i = bhVar.cdw ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bhVar.cdw ? R.color.cp_cont_a : R.color.cp_cont_j;
                am.setBackgroundResource(this.Hf, i);
                am.setViewTextColor(this.Hf, i2);
                if (bhVar.cdw) {
                    this.Hf.setVisibility(0);
                    this.Hf.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aiE.getBawu_type())) {
                    this.Hf.setVisibility(0);
                    this.Hf.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_member_xbazhu_tip);
                    this.Hf.setVisibility(0);
                } else if ("pri_content_assist".equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_content_assist_tip);
                    this.Hf.setVisibility(0);
                } else if ("pri_manage_assist".equals(aiE.getBawu_type())) {
                    this.Hf.setText(R.string.bawu_manage_assist_tip);
                    this.Hf.setVisibility(0);
                } else if (aiE.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.Hf.setVisibility(8);
                }
            } else if (aiE.getIs_biggie()) {
                l(bhVar);
            } else {
                this.Hf.setVisibility(8);
            }
        }
    }

    private void l(bh bhVar) {
        am.setBackgroundResource(this.Hf, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Hf, (int) R.color.cp_link_tip_a);
        this.Hf.setText(R.string.video_mcn);
        if (bhVar.ajE()) {
            this.Hg.setVisibility(8);
        }
        this.Hf.setVisibility(0);
    }

    private void g(bh bhVar) {
        if (this.He != null && bhVar != null) {
            if (!StringUtils.isNull(this.Fs.aiE().getName_show())) {
                this.He.setText(oA(this.Fs.aiE().getName_show()));
            }
            me();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.Fs.aiE().getName_show();
                String userName = this.Fs.aiE().getUserName();
                if (as.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.He.setText(com.baidu.tieba.pb.c.aI(this.mContext, this.He.getText().toString()));
                    this.He.setGravity(16);
                    this.He.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bQe());
                    am.setViewTextColor(this.He, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void i(bh bhVar) {
        if (this.Hg != null) {
            if (this.cri) {
                this.Hg.setVisibility(8);
            } else if (bhVar == null || bhVar.aiE() == null || ((bhVar.cdj > 0 && bhVar.cdk == 0) || !this.crf)) {
                this.Hg.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aiE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.Hg.setVisibility(0);
                    this.Hg.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.Hg.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String formatTime;
        if (this.cpw != null && bhVar != null) {
            if (bhVar.aix() <= 0) {
                this.cpw.setVisibility(4);
                return;
            }
            this.cpw.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = aq.getPostTimeInterval(bhVar.aix());
            } else if (bhVar.ajO()) {
                formatTime = aq.getFormatTime(bhVar.getCreateTime());
            } else if (bhVar.aiI()) {
                formatTime = aq.aR(bhVar.aix() * 1000);
            } else {
                formatTime = aq.getFormatTime(bhVar.aix() * 1000);
            }
            this.cpw.setText(formatTime);
        }
    }

    protected void h(bh bhVar) {
        if (this.Hj == null || bhVar == null) {
            this.Hj.setVisibility(8);
        } else if (this.cri) {
            if (StringUtils.isNull(bhVar.agH())) {
                this.Hj.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Hj.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Hj.setLayoutParams(layoutParams);
            }
            this.Hj.setText(bhVar.agH());
            this.Hj.setVisibility(0);
        } else if (this.Fs.aiX() == null || this.Fs.aiX().share_info == null || this.Fs.aiX().share_info.share_user_count <= 0 || !this.Fs.ajR() || (this.Fs.cdj > 0 && this.Fs.cdk == 0)) {
            this.Hj.setVisibility(8);
        } else {
            this.Hj.setVisibility(0);
            int i = this.Fs.aiX().share_info.share_user_count;
            if (i == 1) {
                this.Hj.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Hj.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{aq.numberUniform(i)}));
            }
        }
    }

    private void C(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.getAddress())) {
            this.crb.setVisibility(8);
            this.crd.setVisibility(8);
            return;
        }
        this.crb.setText(this.Fs.getAddress());
        this.crb.setVisibility(0);
        this.crd.setVisibility(0);
    }

    public void D(bh bhVar) {
        String str;
        if (bhVar == null) {
            this.cqt.setVisibility(8);
            this.crg.setVisibility(8);
            return;
        }
        String aiJ = this.Fs.aiJ();
        if (this.mFrom == 3 || this.mFrom == 4) {
            aiJ = null;
        } else if (this.mFrom == 5) {
            aiJ = bhVar.ako();
        }
        if (bhVar.akn()) {
            aiJ = bhVar.cdv.ori_fname;
        }
        if (StringUtils.isNull(aiJ)) {
            this.cqt.setVisibility(8);
            this.crg.setVisibility(8);
            return;
        }
        if (this.Fs.cdj > 0 && this.Fs.cdk == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = aq.cutChineseAndEnglishWithSuffix(aiJ, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.cqt.setText(str);
        this.cqt.setVisibility(0);
        this.crg.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void et(boolean z) {
        if (z) {
            D(this.Fs);
            return;
        }
        this.cqt.setVisibility(8);
        this.crg.setVisibility(8);
    }

    private void c(bh bhVar) {
        if (this.cqE != null && bhVar != null && this.Fs.aiE() != null) {
            if (this.Fs.cdj > 0 && this.Fs.cdk == 0) {
                this.cqE.setShowV(false);
            } else {
                this.cqE.setShowV(this.Fs.aiE().isBigV());
            }
        }
    }

    private void me() {
        if (this.Fs != null && this.Fs.aiE() != null) {
            if (this.Fs.cdj > 0 && this.Fs.cdk == 0) {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Fs.aiE().getTShowInfoNew()) || this.Fs.aiE().isBigV()) {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.He, (int) R.color.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        me();
        am.setViewTextColor(this.Hj, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.cpw, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.crd, R.color.cp_cont_e);
        am.setViewTextColor(this.crb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.cqt, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.crd, R.color.cp_cont_e);
        am.setBackgroundColor(this.crg, R.color.cp_cont_e);
        k(this.Fs);
    }

    public void setIsSimpleThread(boolean z) {
        this.crh = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.crh;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Ho = onClickListener;
        if (this.cqE != null) {
            this.cqE.setAfterClickListener(this.Ho);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cqE != null) {
            this.cqE.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cqE;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.He;
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.crf = z;
    }

    public void setIsFromConcern(boolean z) {
        this.cri = z;
    }
}

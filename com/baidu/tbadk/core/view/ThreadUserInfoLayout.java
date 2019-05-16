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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements d {
    private bg VK;
    private View.OnClickListener XA;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    private View.OnClickListener XH;
    public TextView Xr;
    public TextView Xs;
    protected UserIconBox Xt;
    private UserIconBox Xu;
    protected TextView Xw;
    private View Xy;
    private FrameLayout Xz;
    private TextView bZW;
    private TextView caT;
    private TextView cbB;
    private View cbC;
    private TextView cbD;
    private boolean cbE;
    private View cbF;
    private boolean cbG;
    private boolean cbH;
    public ClickableHeaderImageView cbe;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.cbE = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getUserId()) && ThreadUserInfoLayout.this.VK.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VK.aeF() != null && ThreadUserInfoLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.aeF().channelId, ThreadUserInfoLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.adv().getUserId(), ThreadUserInfoLayout.this.VK.adv().getName_show(), ThreadUserInfoLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VK.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XA != null) {
                        ThreadUserInfoLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.XH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VK.adv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbE = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getUserId()) && ThreadUserInfoLayout.this.VK.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VK.aeF() != null && ThreadUserInfoLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.aeF().channelId, ThreadUserInfoLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.adv().getUserId(), ThreadUserInfoLayout.this.VK.adv().getName_show(), ThreadUserInfoLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VK.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XA != null) {
                        ThreadUserInfoLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.XH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VK.adv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbE = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VK.adv().getUserId()) && ThreadUserInfoLayout.this.VK.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VK.aeF() != null && ThreadUserInfoLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.aeF().channelId, ThreadUserInfoLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VK.adv().getUserId(), ThreadUserInfoLayout.this.VK.adv().getName_show(), ThreadUserInfoLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VK.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.XA != null) {
                        ThreadUserInfoLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.XH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VK != null && ThreadUserInfoLayout.this.VK.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VK.adv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.cbe = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.Xu = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.Xr = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Xs = (TextView) inflate.findViewById(R.id.identity_view);
        this.Xt = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.bZW = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.cbB = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cbC = inflate.findViewById(R.id.divider);
        this.cbF = findViewById(R.id.divider_forum_name);
        this.caT = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Xw = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.cbD = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.Xz = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.Xy = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 1);
        if (this.Xy != null) {
            this.Xy.setVisibility(8);
            this.Xz.addView(this.Xy);
        }
        setGravity(16);
        initHeaderImg();
        this.Xu.setOnClickListener(this.XF);
        this.Xr.setOnClickListener(this.XG);
        this.Xt.setOnClickListener(this.XH);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VK = bgVar;
        if (this.VK.bKN > 0) {
            if (this.VK.bKO == 0 && this.VK.adv() != null) {
                if (!v.aa(this.VK.adv().getTShowInfoNew())) {
                    this.VK.adv().getTShowInfoNew().clear();
                }
                this.VK.adv().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.Xu.setOnClickListener(null);
            this.Xr.setOnClickListener(null);
            this.Xt.setOnClickListener(null);
            this.cbe.setClickable(false);
        } else {
            this.Xu.setOnClickListener(this.XF);
            this.Xr.setOnClickListener(this.XG);
            this.Xt.setOnClickListener(this.XH);
            this.cbe.setClickable(true);
        }
        i(bgVar);
        f(bgVar);
        g(bgVar);
        h(bgVar);
        j(bgVar);
        v(bgVar);
        A(bgVar);
        c(bgVar);
        B(bgVar);
        setVisibility(0);
        z(bgVar);
        e(bgVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.cbe != null) {
            this.cbe.setDefaultResource(17170445);
            this.cbe.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cbe.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cbe.setIsRound(true);
            this.cbe.setAfterClickListener(this.XA);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
                if (this.Xy != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = alaUserData;
                    aVar.type = 1;
                    this.Xy.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.Xy.setVisibility(8);
                    } else {
                        this.Xy.setVisibility(0);
                    }
                }
            } else if (this.Xy != null) {
                this.Xy.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.cbD != null && bgVar != null && bgVar.adv() != null) {
            if (bgVar.adv().hadConcerned()) {
                this.cbD.setVisibility(0);
                al.j(this.cbD, R.color.cp_cont_d);
                al.k(this.cbD, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.cbD.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.Xu != null && bgVar != null && bgVar.adv() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xu.setVisibility(0);
                this.Xu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Xu.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Xs != null && bgVar != null && bgVar.adv() != null) {
            MetaData adv = bgVar.adv();
            if (adv.getIs_bawu() == 1) {
                int i = bgVar.bLa ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bgVar.bLa ? R.color.cp_btn_a : R.color.cp_cont_j;
                al.k(this.Xs, i);
                al.j(this.Xs, i2);
                if (bgVar.bLa) {
                    this.Xs.setVisibility(0);
                    this.Xs.setText(R.string.brand_Official);
                } else if ("manager".equals(adv.getBawu_type())) {
                    this.Xs.setVisibility(0);
                    this.Xs.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_member_xbazhu_tip);
                    this.Xs.setVisibility(0);
                } else if ("pri_content_assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_content_assist_tip);
                    this.Xs.setVisibility(0);
                } else if ("pri_manage_assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_manage_assist_tip);
                    this.Xs.setVisibility(0);
                } else if (adv.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Xs.setVisibility(8);
                }
            } else if (adv.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Xs.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        al.k(this.Xs, R.drawable.brand_official_btn);
        al.j(this.Xs, R.color.cp_link_tip_a);
        this.Xs.setText(R.string.video_mcn);
        if (bgVar.aev()) {
            this.Xt.setVisibility(8);
        }
        this.Xs.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.Xr != null && bgVar != null) {
            if (!StringUtils.isNull(this.VK.adv().getName_show())) {
                this.Xr.setText(oD(this.VK.adv().getName_show()));
            }
            qB();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.VK.adv().getName_show();
                String userName = this.VK.adv().getUserName();
                if (as.iE() && name_show != null && !name_show.equals(userName)) {
                    this.Xr.setText(com.baidu.tieba.pb.c.aD(this.mContext, this.Xr.getText().toString()));
                    this.Xr.setGravity(16);
                    this.Xr.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPr());
                    al.f(this.Xr, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.Xt != null) {
            if (this.cbH) {
                this.Xt.setVisibility(8);
            } else if (bgVar == null || bgVar.adv() == null || ((bgVar.bKN > 0 && bgVar.bKO == 0) || !this.cbE)) {
                this.Xt.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.Xt.setVisibility(0);
                    this.Xt.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.Xt.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String aC;
        if (this.bZW != null && bgVar != null) {
            if (bgVar.ado() <= 0) {
                this.bZW.setVisibility(4);
                return;
            }
            this.bZW.setVisibility(0);
            if (this.mFrom == 2) {
                aC = ap.aB(bgVar.ado());
            } else if (bgVar.aeG()) {
                aC = ap.aC(bgVar.getCreateTime());
            } else if (bgVar.adz()) {
                aC = ap.aD(bgVar.ado() * 1000);
            } else {
                aC = ap.aC(bgVar.ado() * 1000);
            }
            this.bZW.setText(aC);
        }
    }

    protected void g(bg bgVar) {
        if (this.Xw == null || bgVar == null) {
            this.Xw.setVisibility(8);
        } else if (this.cbH) {
            if (StringUtils.isNull(bgVar.abw())) {
                this.Xw.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xw.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Xw.setLayoutParams(layoutParams);
            }
            this.Xw.setText(bgVar.abw());
            this.Xw.setVisibility(0);
        } else if (this.VK.adO() == null || this.VK.adO().share_info == null || this.VK.adO().share_info.share_user_count <= 0 || !this.VK.aeJ() || (this.VK.bKN > 0 && this.VK.bKO == 0)) {
            this.Xw.setVisibility(8);
        } else {
            this.Xw.setVisibility(0);
            int i = this.VK.adO().share_info.share_user_count;
            if (i == 1) {
                this.Xw.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Xw.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{ap.aH(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.cbB.setVisibility(8);
            this.cbC.setVisibility(8);
            return;
        }
        this.cbB.setText(this.VK.getAddress());
        this.cbB.setVisibility(0);
        this.cbC.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.caT.setVisibility(8);
            this.cbF.setVisibility(8);
            return;
        }
        String adA = this.VK.adA();
        if (this.mFrom == 3 || this.mFrom == 4) {
            adA = null;
        } else if (this.mFrom == 5) {
            adA = bgVar.afg();
        }
        if (bgVar.aff()) {
            adA = bgVar.bKZ.ori_fname;
        }
        if (StringUtils.isNull(adA)) {
            this.caT.setVisibility(8);
            this.cbF.setVisibility(8);
            return;
        }
        if (this.VK.bKN > 0 && this.VK.bKO == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = ap.j(adA, 12, "...") + getResources().getString(R.string.forum);
        }
        this.caT.setText(str);
        this.caT.setVisibility(0);
        this.cbF.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void ej(boolean z) {
        if (z) {
            B(this.VK);
            return;
        }
        this.caT.setVisibility(8);
        this.cbF.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.cbe != null && bgVar != null && this.VK.adv() != null) {
            if (this.VK.bKN > 0 && this.VK.bKO == 0) {
                this.cbe.setShowV(false);
            } else {
                this.cbe.setShowV(this.VK.adv().isBigV());
            }
        }
    }

    private void qB() {
        if (this.VK != null && this.VK.adv() != null) {
            if (this.VK.bKN > 0 && this.VK.bKO == 0) {
                al.j(this.Xr, R.color.cp_cont_f);
            } else if (!v.aa(this.VK.adv().getTShowInfoNew()) || this.VK.adv().isBigV()) {
                al.j(this.Xr, R.color.cp_cont_h);
            } else {
                al.j(this.Xr, R.color.cp_cont_f);
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
        qB();
        al.j(this.Xw, R.color.cp_cont_f);
        al.j(this.bZW, R.color.cp_cont_d);
        al.l(this.cbC, R.color.cp_cont_e);
        al.j(this.cbB, R.color.cp_cont_d);
        al.j(this.caT, R.color.cp_cont_d);
        al.l(this.cbC, R.color.cp_cont_e);
        al.l(this.cbF, R.color.cp_cont_e);
        j(this.VK);
    }

    public void setIsSimpleThread(boolean z) {
        this.cbG = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.cbG;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
        if (this.cbe != null) {
            this.cbe.setAfterClickListener(this.XA);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbe != null) {
            this.cbe.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cbe;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.Xr;
    }

    protected String oD(String str) {
        return ap.j(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.cbE = z;
    }

    public void setIsFromConcern(boolean z) {
        this.cbH = z;
    }
}

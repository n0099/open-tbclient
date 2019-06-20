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
    private bg VJ;
    private View.OnClickListener XE;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    public TextView Xq;
    public TextView Xr;
    protected UserIconBox Xs;
    private UserIconBox Xt;
    protected TextView Xv;
    private View Xx;
    private FrameLayout Xy;
    private View.OnClickListener Xz;
    private TextView bZX;
    private TextView caU;
    private TextView cbC;
    private View cbD;
    private TextView cbE;
    private boolean cbF;
    private View cbG;
    private boolean cbH;
    private boolean cbI;
    public ClickableHeaderImageView cbf;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.cbF = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getUserId()) && ThreadUserInfoLayout.this.VJ.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VJ.aeF() != null && ThreadUserInfoLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.aeF().channelId, ThreadUserInfoLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.adv().getUserId(), ThreadUserInfoLayout.this.VJ.adv().getName_show(), ThreadUserInfoLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Xz != null) {
                        ThreadUserInfoLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VJ.adv().getUserId(), true, true, true);
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
        this.cbF = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getUserId()) && ThreadUserInfoLayout.this.VJ.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VJ.aeF() != null && ThreadUserInfoLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.aeF().channelId, ThreadUserInfoLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.adv().getUserId(), ThreadUserInfoLayout.this.VJ.adv().getName_show(), ThreadUserInfoLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Xz != null) {
                        ThreadUserInfoLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VJ.adv().getUserId(), true, true, true);
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
        this.cbF = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.XE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.VJ.adv().getUserId()) && ThreadUserInfoLayout.this.VJ.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.VJ.aeF() != null && ThreadUserInfoLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.aeF().channelId, ThreadUserInfoLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.VJ.adv().getUserId(), ThreadUserInfoLayout.this.VJ.adv().getName_show(), ThreadUserInfoLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.VJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.Xz != null) {
                        ThreadUserInfoLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.VJ != null && ThreadUserInfoLayout.this.VJ.adv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.VJ.adv().getUserId(), true, true, true);
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
        this.cbf = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.Xt = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.Xq = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.Xr = (TextView) inflate.findViewById(R.id.identity_view);
        this.Xs = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.bZX = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.cbC = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.cbD = inflate.findViewById(R.id.divider);
        this.cbG = findViewById(R.id.divider_forum_name);
        this.caU = (TextView) findViewById(R.id.thread_info_forum_name);
        this.Xv = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.cbE = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.Xy = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.Xx = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 1);
        if (this.Xx != null) {
            this.Xx.setVisibility(8);
            this.Xy.addView(this.Xx);
        }
        setGravity(16);
        initHeaderImg();
        this.Xt.setOnClickListener(this.XE);
        this.Xq.setOnClickListener(this.XF);
        this.Xs.setOnClickListener(this.XG);
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VJ = bgVar;
        if (this.VJ.bKO > 0) {
            if (this.VJ.bKP == 0 && this.VJ.adv() != null) {
                if (!v.aa(this.VJ.adv().getTShowInfoNew())) {
                    this.VJ.adv().getTShowInfoNew().clear();
                }
                this.VJ.adv().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.Xt.setOnClickListener(null);
            this.Xq.setOnClickListener(null);
            this.Xs.setOnClickListener(null);
            this.cbf.setClickable(false);
        } else {
            this.Xt.setOnClickListener(this.XE);
            this.Xq.setOnClickListener(this.XF);
            this.Xs.setOnClickListener(this.XG);
            this.cbf.setClickable(true);
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
        if (this.cbf != null) {
            this.cbf.setDefaultResource(17170445);
            this.cbf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.cbf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
            this.cbf.setIsRound(true);
            this.cbf.setAfterClickListener(this.Xz);
        }
    }

    private void e(bg bgVar) {
        if (this.mFrom == 3) {
            if (bgVar != null && bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
                if (this.Xx != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = alaUserData;
                    aVar.type = 1;
                    this.Xx.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.Xx.setVisibility(8);
                    } else {
                        this.Xx.setVisibility(0);
                    }
                }
            } else if (this.Xx != null) {
                this.Xx.setVisibility(8);
            }
        }
    }

    private void z(bg bgVar) {
        if (this.cbE != null && bgVar != null && bgVar.adv() != null) {
            if (bgVar.adv().hadConcerned()) {
                this.cbE.setVisibility(0);
                al.j(this.cbE, R.color.cp_cont_d);
                al.k(this.cbE, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.cbE.setVisibility(8);
        }
    }

    private void i(bg bgVar) {
        if (this.Xt != null && bgVar != null && bgVar.adv() != null) {
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xt.setVisibility(0);
                this.Xt.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Xt.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Xr != null && bgVar != null && bgVar.adv() != null) {
            MetaData adv = bgVar.adv();
            if (adv.getIs_bawu() == 1) {
                int i = bgVar.bLb ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bgVar.bLb ? R.color.cp_btn_a : R.color.cp_cont_j;
                al.k(this.Xr, i);
                al.j(this.Xr, i2);
                if (bgVar.bLb) {
                    this.Xr.setVisibility(0);
                    this.Xr.setText(R.string.brand_Official);
                } else if ("manager".equals(adv.getBawu_type())) {
                    this.Xr.setVisibility(0);
                    this.Xr.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_member_xbazhu_tip);
                    this.Xr.setVisibility(0);
                } else if ("pri_content_assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_content_assist_tip);
                    this.Xr.setVisibility(0);
                } else if ("pri_manage_assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_manage_assist_tip);
                    this.Xr.setVisibility(0);
                } else if (adv.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Xr.setVisibility(8);
                }
            } else if (adv.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Xr.setVisibility(8);
            }
        }
    }

    private void k(bg bgVar) {
        al.k(this.Xr, R.drawable.brand_official_btn);
        al.j(this.Xr, R.color.cp_link_tip_a);
        this.Xr.setText(R.string.video_mcn);
        if (bgVar.aev()) {
            this.Xs.setVisibility(8);
        }
        this.Xr.setVisibility(0);
    }

    private void f(bg bgVar) {
        if (this.Xq != null && bgVar != null) {
            if (!StringUtils.isNull(this.VJ.adv().getName_show())) {
                this.Xq.setText(oC(this.VJ.adv().getName_show()));
            }
            qB();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.VJ.adv().getName_show();
                String userName = this.VJ.adv().getUserName();
                if (as.iE() && name_show != null && !name_show.equals(userName)) {
                    this.Xq.setText(com.baidu.tieba.pb.c.aD(this.mContext, this.Xq.getText().toString()));
                    this.Xq.setGravity(16);
                    this.Xq.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.bPv());
                    al.f(this.Xq, R.color.cp_other_e, 1);
                }
            }
        }
    }

    private void h(bg bgVar) {
        if (this.Xs != null) {
            if (this.cbI) {
                this.Xs.setVisibility(8);
            } else if (bgVar == null || bgVar.adv() == null || ((bgVar.bKO > 0 && bgVar.bKP == 0) || !this.cbF)) {
                this.Xs.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.Xs.setVisibility(0);
                    this.Xs.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.Xs.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String aC;
        if (this.bZX != null && bgVar != null) {
            if (bgVar.ado() <= 0) {
                this.bZX.setVisibility(4);
                return;
            }
            this.bZX.setVisibility(0);
            if (this.mFrom == 2) {
                aC = ap.aB(bgVar.ado());
            } else if (bgVar.aeG()) {
                aC = ap.aC(bgVar.getCreateTime());
            } else if (bgVar.adz()) {
                aC = ap.aD(bgVar.ado() * 1000);
            } else {
                aC = ap.aC(bgVar.ado() * 1000);
            }
            this.bZX.setText(aC);
        }
    }

    protected void g(bg bgVar) {
        if (this.Xv == null || bgVar == null) {
            this.Xv.setVisibility(8);
        } else if (this.cbI) {
            if (StringUtils.isNull(bgVar.abw())) {
                this.Xv.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xv.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.Xv.setLayoutParams(layoutParams);
            }
            this.Xv.setText(bgVar.abw());
            this.Xv.setVisibility(0);
        } else if (this.VJ.adO() == null || this.VJ.adO().share_info == null || this.VJ.adO().share_info.share_user_count <= 0 || !this.VJ.aeJ() || (this.VJ.bKO > 0 && this.VJ.bKP == 0)) {
            this.Xv.setVisibility(8);
        } else {
            this.Xv.setVisibility(0);
            int i = this.VJ.adO().share_info.share_user_count;
            if (i == 1) {
                this.Xv.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.Xv.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{ap.aH(i)}));
            }
        }
    }

    private void A(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.getAddress())) {
            this.cbC.setVisibility(8);
            this.cbD.setVisibility(8);
            return;
        }
        this.cbC.setText(this.VJ.getAddress());
        this.cbC.setVisibility(0);
        this.cbD.setVisibility(0);
    }

    public void B(bg bgVar) {
        String str;
        if (bgVar == null) {
            this.caU.setVisibility(8);
            this.cbG.setVisibility(8);
            return;
        }
        String adA = this.VJ.adA();
        if (this.mFrom == 3 || this.mFrom == 4) {
            adA = null;
        } else if (this.mFrom == 5) {
            adA = bgVar.afg();
        }
        if (bgVar.aff()) {
            adA = bgVar.bLa.ori_fname;
        }
        if (StringUtils.isNull(adA)) {
            this.caU.setVisibility(8);
            this.cbG.setVisibility(8);
            return;
        }
        if (this.VJ.bKO > 0 && this.VJ.bKP == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = ap.j(adA, 12, "...") + getResources().getString(R.string.forum);
        }
        this.caU.setText(str);
        this.caU.setVisibility(0);
        this.cbG.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.d
    public void ej(boolean z) {
        if (z) {
            B(this.VJ);
            return;
        }
        this.caU.setVisibility(8);
        this.cbG.setVisibility(8);
    }

    private void c(bg bgVar) {
        if (this.cbf != null && bgVar != null && this.VJ.adv() != null) {
            if (this.VJ.bKO > 0 && this.VJ.bKP == 0) {
                this.cbf.setShowV(false);
            } else {
                this.cbf.setShowV(this.VJ.adv().isBigV());
            }
        }
    }

    private void qB() {
        if (this.VJ != null && this.VJ.adv() != null) {
            if (this.VJ.bKO > 0 && this.VJ.bKP == 0) {
                al.j(this.Xq, R.color.cp_cont_f);
            } else if (!v.aa(this.VJ.adv().getTShowInfoNew()) || this.VJ.adv().isBigV()) {
                al.j(this.Xq, R.color.cp_cont_h);
            } else {
                al.j(this.Xq, R.color.cp_cont_f);
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
        al.j(this.Xv, R.color.cp_cont_f);
        al.j(this.bZX, R.color.cp_cont_d);
        al.l(this.cbD, R.color.cp_cont_e);
        al.j(this.cbC, R.color.cp_cont_d);
        al.j(this.caU, R.color.cp_cont_d);
        al.l(this.cbD, R.color.cp_cont_e);
        al.l(this.cbG, R.color.cp_cont_e);
        j(this.VJ);
    }

    public void setIsSimpleThread(boolean z) {
        this.cbH = z;
    }

    @Override // com.baidu.tbadk.core.view.d
    public boolean getIsSimpleThread() {
        return this.cbH;
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Xz = onClickListener;
        if (this.cbf != null) {
            this.cbf.setAfterClickListener(this.Xz);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cbf != null) {
            this.cbf.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.d
    public ClickableHeaderImageView getHeaderImg() {
        return this.cbf;
    }

    @Override // com.baidu.tbadk.core.view.d
    public TextView getUserName() {
        return this.Xq;
    }

    protected String oC(String str) {
        return ap.j(str, 14, "...");
    }

    public void setTShowVisible(boolean z) {
        this.cbF = z;
    }

    public void setIsFromConcern(boolean z) {
        this.cbI = z;
    }
}

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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements f {
    private TextView aAN;
    private View aBA;
    private FrameLayout aBB;
    private boolean aBC;
    private View aBD;
    private View.OnClickListener aBE;
    private boolean aBF;
    private boolean aBG;
    private View.OnClickListener aBH;
    private View.OnClickListener aBI;
    private View.OnClickListener aBJ;
    public ClickableHeaderImageView aBr;
    private UserIconBox aBs;
    public TextView aBt;
    public TextView aBu;
    protected UserIconBox aBv;
    private TextView aBw;
    private View aBx;
    protected TextView aBy;
    private TextView aBz;
    private bb awf;
    private TextView azZ;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aBC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aBH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bA(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aBI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getUserId()) && ThreadUserInfoLayout.this.awf.ws() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bA(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.awf.xp() != null && ThreadUserInfoLayout.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.xp().channelId, ThreadUserInfoLayout.this.awf.xp().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.wm().getUserId(), ThreadUserInfoLayout.this.awf.wm().getName_show(), ThreadUserInfoLayout.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.awf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aBE != null) {
                        ThreadUserInfoLayout.this.aBE.onClick(view);
                    }
                }
            }
        };
        this.aBJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.awf.wm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").w("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aBH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bA(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aBI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getUserId()) && ThreadUserInfoLayout.this.awf.ws() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bA(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.awf.xp() != null && ThreadUserInfoLayout.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.xp().channelId, ThreadUserInfoLayout.this.awf.xp().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.wm().getUserId(), ThreadUserInfoLayout.this.awf.wm().getName_show(), ThreadUserInfoLayout.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.awf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aBE != null) {
                        ThreadUserInfoLayout.this.aBE.onClick(view);
                    }
                }
            }
        };
        this.aBJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.awf.wm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").w("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBC = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aBH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bA(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew() != null && v.d(ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.awf.wm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aBI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.awf.wm().getUserId()) && ThreadUserInfoLayout.this.awf.ws() != null) {
                    if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(e.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.bA(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.awf.xp() != null && ThreadUserInfoLayout.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.xp().channelId, ThreadUserInfoLayout.this.awf.xp().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.awf.wm().getUserId(), ThreadUserInfoLayout.this.awf.wm().getName_show(), ThreadUserInfoLayout.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.awf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aBE != null) {
                        ThreadUserInfoLayout.this.aBE.onClick(view);
                    }
                }
            }
        };
        this.aBJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.awf != null && ThreadUserInfoLayout.this.awf.wm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.awf.wm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").w("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_user_info_layout, (ViewGroup) this, true);
        this.aBr = (ClickableHeaderImageView) inflate.findViewById(e.g.card_home_page_normal_thread_user_header);
        this.aBs = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_tshow_icon);
        this.aBt = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_user_name);
        this.aBu = (TextView) inflate.findViewById(e.g.identity_view);
        this.aBv = (UserIconBox) inflate.findViewById(e.g.card_home_page_normal_thread_user_icon);
        this.azZ = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aBw = (TextView) inflate.findViewById(e.g.thread_info_address);
        this.aBx = inflate.findViewById(e.g.divider);
        this.aBD = findViewById(e.g.divider_forum_name);
        this.aAN = (TextView) findViewById(e.g.thread_info_forum_name);
        this.aBy = (TextView) inflate.findViewById(e.g.card_home_page_normal_thread_share_intro);
        this.aBz = (TextView) inflate.findViewById(e.g.thread_user_info_has_concern_lable);
        this.aBB = (FrameLayout) inflate.findViewById(e.g.ala_live_info_content_layout);
        this.aBA = com.baidu.tbadk.ala.b.sB().i(this.mContext, 1);
        if (this.aBA != null) {
            this.aBA.setVisibility(8);
            this.aBB.addView(this.aBA);
        }
        setGravity(16);
        initHeaderImg();
        this.aBs.setOnClickListener(this.aBH);
        this.aBt.setOnClickListener(this.aBI);
        this.aBv.setOnClickListener(this.aBJ);
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.awf = bbVar;
        if (this.awf.amj > 0) {
            if (this.awf.amk == 0 && this.awf.wm() != null) {
                if (!v.z(this.awf.wm().getTShowInfoNew())) {
                    this.awf.wm().getTShowInfoNew().clear();
                }
                this.awf.wm().setName_show(getContext().getString(e.j.perfect_selection_video));
            }
            this.aBs.setOnClickListener(null);
            this.aBt.setOnClickListener(null);
            this.aBv.setOnClickListener(null);
            this.aBr.setClickable(false);
        } else {
            this.aBs.setOnClickListener(this.aBH);
            this.aBt.setOnClickListener(this.aBI);
            this.aBv.setOnClickListener(this.aBJ);
            this.aBr.setClickable(true);
        }
        m(bbVar);
        p(bbVar);
        r(bbVar);
        q(bbVar);
        n(bbVar);
        f(bbVar);
        s(bbVar);
        t(bbVar);
        updateForumName(bbVar);
        setVisibility(0);
        l(bbVar);
        k(bbVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.aBr != null) {
            this.aBr.setDefaultResource(17170445);
            this.aBr.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.aBr.setDefaultBgResource(e.d.cp_bg_line_e);
            this.aBr.setIsRound(true);
            this.aBr.setAfterClickListener(this.aBE);
        }
    }

    private void k(bb bbVar) {
        if (this.mFrom == 3) {
            if (bbVar != null && bbVar.wm() != null && bbVar.wm().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.wm().getAlaUserData();
                if (this.aBA != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.acu = alaUserData;
                    aVar.type = 1;
                    this.aBA.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aBA.setVisibility(8);
                    } else {
                        this.aBA.setVisibility(0);
                    }
                }
            } else if (this.aBA != null) {
                this.aBA.setVisibility(8);
            }
        }
    }

    private void l(bb bbVar) {
        if (this.aBz != null && bbVar != null && bbVar.wm() != null) {
            if (bbVar.wm().hadConcerned()) {
                this.aBz.setVisibility(0);
                al.h(this.aBz, e.d.cp_cont_d);
                al.i(this.aBz, e.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aBz.setVisibility(8);
        }
    }

    private void m(bb bbVar) {
        if (this.aBs != null && bbVar != null && bbVar.wm() != null) {
            ArrayList<IconData> tShowInfoNew = bbVar.wm().getTShowInfoNew();
            if (v.y(tShowInfoNew) != 0) {
                this.aBs.setVisibility(0);
                this.aBs.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds48), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds8), true);
                return;
            }
            this.aBs.setVisibility(8);
        }
    }

    private void n(bb bbVar) {
        if (this.aBu != null && bbVar != null && bbVar.wm() != null) {
            MetaData wm = bbVar.wm();
            if (wm.getIs_bawu() == 1) {
                int i = bbVar.amv ? e.f.brand_official_btn : e.f.user_identity_btn;
                int i2 = bbVar.amv ? e.d.cp_link_tip_a : e.d.cp_cont_j;
                al.i(this.aBu, i);
                al.h(this.aBu, i2);
                if (bbVar.amv) {
                    this.aBu.setVisibility(0);
                    this.aBu.setText(e.j.brand_Official);
                } else if ("manager".equals(wm.getBawu_type())) {
                    this.aBu.setVisibility(0);
                    this.aBu.setText(e.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(wm.getBawu_type())) {
                    this.aBu.setText(e.j.bawu_member_xbazhu_tip);
                    this.aBu.setVisibility(0);
                } else if (wm.getIs_biggie()) {
                    o(bbVar);
                } else {
                    this.aBu.setVisibility(8);
                }
            } else if (wm.getIs_biggie()) {
                o(bbVar);
            } else {
                this.aBu.setVisibility(8);
            }
        }
    }

    private void o(bb bbVar) {
        al.i(this.aBu, e.f.brand_official_btn);
        al.h(this.aBu, e.d.cp_link_tip_a);
        this.aBu.setText(e.j.video_mcn);
        if (bbVar.xe()) {
            this.aBv.setVisibility(8);
        }
        this.aBu.setVisibility(0);
    }

    private void p(bb bbVar) {
        if (this.aBt != null && bbVar != null) {
            if (!StringUtils.isNull(this.awf.wm().getName_show())) {
                this.aBt.setText(fK(this.awf.wm().getName_show()));
            }
            BZ();
            if (this.mFrom == 3 || this.mFrom == 4 || this.mFrom == 5) {
                String name_show = this.awf.wm().getName_show();
                String userName = this.awf.wm().getUserName();
                if (com.baidu.tbadk.p.am.jw() && name_show != null && !name_show.equals(userName)) {
                    this.aBt.setText(com.baidu.tieba.pb.c.aB(this.mContext, this.aBt.getText().toString()));
                    this.aBt.setGravity(16);
                    this.aBt.setTag(e.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bbr());
                    al.c(this.aBt, e.d.cp_other_e, 1);
                }
            }
        }
    }

    private void q(bb bbVar) {
        if (this.aBv != null) {
            if (this.aBG) {
                this.aBv.setVisibility(8);
            } else if (bbVar == null || bbVar.wm() == null || ((bbVar.amj > 0 && bbVar.amk == 0) || !this.aBC)) {
                this.aBv.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bbVar.wm().getIconInfo();
                if (v.y(iconInfo) != 0) {
                    this.aBv.setVisibility(0);
                    this.aBv.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds40), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds8), true);
                    return;
                }
                this.aBv.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String A;
        if (this.azZ != null && bbVar != null) {
            if (bbVar.wf() <= 0) {
                this.azZ.setVisibility(4);
                return;
            }
            this.azZ.setVisibility(0);
            if (this.mFrom == 2) {
                A = ao.z(bbVar.wf());
            } else if (bbVar.xq()) {
                A = ao.A(bbVar.getCreateTime());
            } else if (bbVar.wr()) {
                A = ao.B(bbVar.wf() * 1000);
            } else {
                A = ao.A(bbVar.wf() * 1000);
            }
            this.azZ.setText(A);
        }
    }

    protected void r(bb bbVar) {
        if (this.aBy == null || bbVar == null) {
            this.aBy.setVisibility(8);
        } else if (this.aBG) {
            if (StringUtils.isNull(bbVar.wL())) {
                this.aBy.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBy.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aBy.setLayoutParams(layoutParams);
            }
            this.aBy.setText(bbVar.wL());
            this.aBy.setVisibility(0);
        } else if (this.awf.wG() == null || this.awf.wG().share_info == null || this.awf.wG().share_info.share_user_count <= 0 || !this.awf.xt() || (this.awf.amj > 0 && this.awf.amk == 0)) {
            this.aBy.setVisibility(8);
        } else {
            this.aBy.setVisibility(0);
            int i = this.awf.wG().share_info.share_user_count;
            if (i == 1) {
                this.aBy.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label_simple));
            } else {
                this.aBy.setText(TbadkCoreApplication.getInst().getString(e.j.ala_live_share_live_label, new Object[]{ao.G(i)}));
            }
        }
    }

    private void s(bb bbVar) {
        if (bbVar == null || StringUtils.isNull(bbVar.getAddress())) {
            this.aBw.setVisibility(8);
            this.aBx.setVisibility(8);
            return;
        }
        this.aBw.setText(this.awf.getAddress());
        this.aBw.setVisibility(0);
        this.aBx.setVisibility(0);
    }

    public void updateForumName(bb bbVar) {
        String str;
        if (bbVar == null) {
            this.aAN.setVisibility(8);
            this.aBD.setVisibility(8);
            return;
        }
        String ws = this.awf.ws();
        if (this.mFrom == 3 || this.mFrom == 4) {
            ws = null;
        } else if (this.mFrom == 5) {
            ws = bbVar.xP();
        }
        if (bbVar.xO()) {
            ws = bbVar.amu.ori_fname;
        }
        if (StringUtils.isNull(ws)) {
            this.aAN.setVisibility(8);
            this.aBD.setVisibility(8);
            return;
        }
        if (this.awf.amj > 0 && this.awf.amk == 0) {
            str = getContext().getString(e.j.select_video_list);
        } else {
            str = ao.d(ws, 12, "...") + getResources().getString(e.j.forum);
        }
        this.aAN.setText(str);
        this.aAN.setVisibility(0);
        this.aBD.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.f
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.awf);
            return;
        }
        this.aAN.setVisibility(8);
        this.aBD.setVisibility(8);
    }

    private void t(bb bbVar) {
        if (this.aBr != null && bbVar != null && this.awf.wm() != null) {
            if (this.awf.amj > 0 && this.awf.amk == 0) {
                this.aBr.setShowV(false);
            } else {
                this.aBr.setShowV(this.awf.wm().isBigV());
            }
        }
    }

    private void BZ() {
        if (this.awf != null && this.awf.wm() != null) {
            if (this.awf.amj > 0 && this.awf.amk == 0) {
                al.h(this.aBt, e.d.cp_cont_f);
            } else if (!v.z(this.awf.wm().getTShowInfoNew()) || this.awf.wm().isBigV()) {
                al.h(this.aBt, e.d.cp_cont_h);
            } else {
                al.h(this.aBt, e.d.cp_cont_f);
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
        BZ();
        al.h(this.aBy, e.d.cp_cont_f);
        al.h(this.azZ, e.d.cp_cont_d);
        al.j(this.aBx, e.d.cp_cont_e);
        al.h(this.aBw, e.d.cp_cont_d);
        al.h(this.aAN, e.d.cp_cont_d);
        al.j(this.aBx, e.d.cp_cont_e);
        al.j(this.aBD, e.d.cp_cont_e);
        n(this.awf);
    }

    public void setIsSimpleThread(boolean z) {
        this.aBF = z;
    }

    @Override // com.baidu.tbadk.core.view.f
    public boolean getIsSimpleThread() {
        return this.aBF;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aBE = onClickListener;
        if (this.aBr != null) {
            this.aBr.setAfterClickListener(this.aBE);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aBr != null) {
            this.aBr.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.f
    public ClickableHeaderImageView getHeaderImg() {
        return this.aBr;
    }

    @Override // com.baidu.tbadk.core.view.f
    public TextView getUserName() {
        return this.aBt;
    }

    protected String fK(String str) {
        return ao.d(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aBC;
    }

    public void setTShowVisible(boolean z) {
        this.aBC = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aBG = z;
    }
}

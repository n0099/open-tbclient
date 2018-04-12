package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.af;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bd alf;
    private TextView aos;
    private UserIconBox apM;
    public ImageView apN;
    protected UserIconBox apO;
    private TextView apP;
    private View apQ;
    protected TextView apR;
    private TextView apS;
    private boolean apT;
    private View apU;
    private TextView apV;
    private boolean apW;
    private View.OnClickListener apX;
    private View.OnClickListener apY;
    public ClickableHeaderImageView apf;
    public TextView apg;
    private boolean api;
    private View.OnClickListener apj;
    private View.OnClickListener apl;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.apT = true;
        this.mFrom = 1;
        this.apX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                if (az.aK(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getUserId()) && ThreadUserInfoLayout.this.alf.rV() != null) {
                    if (view2.getTag(d.g.tag_nick_name_activity) != null && (view2.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view2.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && az.aK(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.alf.sQ() != null && ThreadUserInfoLayout.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.sQ().channelId, ThreadUserInfoLayout.this.alf.sQ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.rQ().getUserId(), ThreadUserInfoLayout.this.alf.rQ().getName_show(), ThreadUserInfoLayout.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.alf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.apj != null) {
                        ThreadUserInfoLayout.this.apj.onClick(view2);
                    }
                }
            }
        };
        this.apY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.alf.rQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new al("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apT = true;
        this.mFrom = 1;
        this.apX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                if (az.aK(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getUserId()) && ThreadUserInfoLayout.this.alf.rV() != null) {
                    if (view2.getTag(d.g.tag_nick_name_activity) != null && (view2.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view2.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && az.aK(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.alf.sQ() != null && ThreadUserInfoLayout.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.sQ().channelId, ThreadUserInfoLayout.this.alf.sQ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.rQ().getUserId(), ThreadUserInfoLayout.this.alf.rQ().getName_show(), ThreadUserInfoLayout.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.alf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.apj != null) {
                        ThreadUserInfoLayout.this.apj.onClick(view2);
                    }
                }
            }
        };
        this.apY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.alf.rQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new al("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apT = true;
        this.mFrom = 1;
        this.apX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                if (az.aK(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.alf.rQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.alf.rQ().getUserId()) && ThreadUserInfoLayout.this.alf.rV() != null) {
                    if (view2.getTag(d.g.tag_nick_name_activity) != null && (view2.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view2.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && az.aK(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.alf.sQ() != null && ThreadUserInfoLayout.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.sQ().channelId, ThreadUserInfoLayout.this.alf.sQ().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.alf.rQ().getUserId(), ThreadUserInfoLayout.this.alf.rQ().getName_show(), ThreadUserInfoLayout.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.alf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.apj != null) {
                        ThreadUserInfoLayout.this.apj.onClick(view2);
                    }
                }
            }
        };
        this.apY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadUserInfoLayout.this.alf != null && ThreadUserInfoLayout.this.alf.rQ() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.alf.rQ().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new al("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_user_info_layout, (ViewGroup) this, true);
        this.apf = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.apM = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.apg = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.apN = (ImageView) inflate.findViewById(d.g.identity_view);
        this.apO = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.aos = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.apP = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.apQ = inflate.findViewById(d.g.divider);
        this.apU = findViewById(d.g.divider_forum_name);
        this.apV = (TextView) findViewById(d.g.thread_info_forum_name);
        this.apR = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.apS = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.apM.setOnClickListener(this.apX);
        this.apg.setOnClickListener(this.apl);
        this.apO.setOnClickListener(this.apY);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.alf = bdVar;
        if (this.alf.abJ > 0) {
            if (this.alf.abK == 0 && this.alf.rQ() != null) {
                if (!v.w(this.alf.rQ().getTShowInfoNew())) {
                    this.alf.rQ().getTShowInfoNew().clear();
                }
                this.alf.rQ().setName_show(getContext().getString(d.k.perfect_selection_video));
            }
            this.apM.setOnClickListener(null);
            this.apg.setOnClickListener(null);
            this.apO.setOnClickListener(null);
            this.apf.setClickable(false);
        } else {
            this.apM.setOnClickListener(this.apX);
            this.apg.setOnClickListener(this.apl);
            this.apO.setOnClickListener(this.apY);
            this.apf.setClickable(true);
        }
        i(bdVar);
        k(bdVar);
        m(bdVar);
        j(bdVar);
        l(bdVar);
        d(bdVar);
        n(bdVar);
        o(bdVar);
        updateForumName(bdVar);
        setVisibility(0);
        h(bdVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.apf != null) {
            this.apf.setDefaultResource(17170445);
            this.apf.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.apf.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.apf.setIsRound(true);
            this.apf.setAfterClickListener(this.apj);
        }
    }

    private void h(bd bdVar) {
        if (this.apS != null && bdVar != null && bdVar.rQ() != null) {
            if (bdVar.rQ().hadConcerned()) {
                this.apS.setVisibility(0);
                ak.h(this.apS, d.C0126d.cp_cont_d);
                ak.i(this.apS, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.apS.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.apM != null && bdVar != null && bdVar.rQ() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.rQ().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.apM.setVisibility(0);
                this.apM.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.apM.setVisibility(8);
        }
    }

    private void j(bd bdVar) {
        if (this.apN != null && bdVar != null && bdVar.rQ() != null) {
            MetaData rQ = bdVar.rQ();
            if (rQ.getIs_bawu() == 1) {
                if ("manager".equals(rQ.getBawu_type())) {
                    ak.c(this.apN, d.f.icon_id_bazhu);
                    this.apN.setVisibility(0);
                    return;
                } else if ("assist".equals(rQ.getBawu_type())) {
                    ak.c(this.apN, d.f.icon_id_xiaobazhu);
                    this.apN.setVisibility(0);
                    return;
                } else {
                    this.apN.setVisibility(8);
                    return;
                }
            }
            this.apN.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.apg != null && bdVar != null) {
            if (!StringUtils.isNull(this.alf.rQ().getName_show())) {
                this.apg.setText(eP(this.alf.rQ().getName_show()));
            }
            xh();
            if (this.mFrom == 3) {
                String name_show = this.alf.rQ().getName_show();
                String userName = this.alf.rQ().getUserName();
                if (af.fz() && name_show != null && !name_show.equals(userName)) {
                    this.apg.setText(com.baidu.tieba.pb.c.ah(this.mContext, this.apg.getText().toString()));
                    this.apg.setGravity(16);
                    this.apg.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aVa());
                    ak.c(this.apg, d.C0126d.cp_other_e, 1);
                }
            }
        }
    }

    private void l(bd bdVar) {
        if (this.apO != null) {
            if (this.apW) {
                this.apO.setVisibility(8);
            } else if (bdVar == null || bdVar.rQ() == null || ((bdVar.abJ > 0 && bdVar.abK == 0) || !this.apT)) {
                this.apO.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.rQ().getIconInfo();
                if (v.v(iconInfo) != 0) {
                    this.apO.setVisibility(0);
                    this.apO.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.apO.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String s;
        if (this.aos != null && bdVar != null) {
            if (bdVar.rK() <= 0) {
                this.aos.setVisibility(4);
                return;
            }
            this.aos.setVisibility(0);
            if (this.mFrom == 2) {
                s = an.r(bdVar.rK());
            } else if (bdVar.sR()) {
                s = an.s(bdVar.getCreateTime());
            } else {
                s = an.s(bdVar.rK() * 1000);
            }
            this.aos.setText(s);
        }
    }

    protected void m(bd bdVar) {
        if (this.apR == null || bdVar == null) {
            this.apR.setVisibility(8);
        } else if (this.apW) {
            if (StringUtils.isNull(bdVar.sn())) {
                this.apR.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apR.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.apR.setLayoutParams(layoutParams);
            }
            this.apR.setText(bdVar.sn());
            this.apR.setVisibility(0);
        } else if (this.alf.si() == null || this.alf.si().share_info == null || this.alf.si().share_info.share_user_count <= 0 || !this.alf.sU() || (this.alf.abJ > 0 && this.alf.abK == 0)) {
            this.apR.setVisibility(8);
        } else {
            this.apR.setVisibility(0);
            int i = this.alf.si().share_info.share_user_count;
            if (i == 1) {
                this.apR.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label_simple));
            } else {
                this.apR.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label, new Object[]{an.x(i)}));
            }
        }
    }

    private void n(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.apP.setVisibility(8);
            this.apQ.setVisibility(8);
            return;
        }
        this.apP.setText(this.alf.getAddress());
        this.apP.setVisibility(0);
        this.apQ.setVisibility(0);
    }

    public void updateForumName(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.rV()) || this.mFrom == 3) {
            this.apV.setVisibility(8);
            this.apU.setVisibility(8);
            return;
        }
        if (this.alf.abJ > 0 && this.alf.abK == 0) {
            str = getContext().getString(d.k.select_video_list);
        } else {
            str = an.e(this.alf.rV(), 12, "...") + getResources().getString(d.k.forum);
        }
        this.apV.setText(str);
        this.apV.setVisibility(0);
        this.apU.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.alf);
            return;
        }
        this.apV.setVisibility(8);
        this.apU.setVisibility(8);
    }

    private void o(bd bdVar) {
        if (this.apf != null && bdVar != null && this.alf.rQ() != null) {
            if (this.alf.abJ > 0 && this.alf.abK == 0) {
                this.apf.setShowV(false);
            } else {
                this.apf.setShowV(this.alf.rQ().isBigV());
            }
        }
    }

    private void xh() {
        if (this.alf != null && this.alf.rQ() != null) {
            if (this.alf.abJ > 0 && this.alf.abK == 0) {
                ak.h(this.apg, d.C0126d.cp_cont_f);
            } else if (!v.w(this.alf.rQ().getTShowInfoNew()) || this.alf.rQ().isBigV()) {
                ak.h(this.apg, d.C0126d.cp_cont_h);
            } else {
                ak.h(this.apg, d.C0126d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xh();
        ak.h(this.apR, d.C0126d.cp_cont_f);
        ak.h(this.aos, d.C0126d.cp_cont_d);
        ak.j(this.apQ, d.C0126d.cp_cont_e);
        ak.h(this.apP, d.C0126d.cp_cont_d);
        ak.h(this.apV, d.C0126d.cp_cont_d);
        ak.j(this.apQ, d.C0126d.cp_cont_e);
        ak.j(this.apU, d.C0126d.cp_cont_e);
        j(this.alf);
    }

    public void setIsSimpleThread(boolean z) {
        this.api = z;
    }

    public boolean getIsSimpleThread() {
        return this.api;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.apj = onClickListener;
        if (this.apf != null) {
            this.apf.setAfterClickListener(this.apj);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.apf != null) {
            this.apf.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.apf;
    }

    public TextView getUserName() {
        return this.apg;
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.apT;
    }

    public void setTShowVisible(boolean z) {
        this.apT = z;
    }

    public void setIsFromConcern(boolean z) {
        this.apW = z;
    }
}

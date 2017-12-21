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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bd ajM;
    private TextView anm;
    private UserIconBox aoA;
    public ImageView aoB;
    protected UserIconBox aoC;
    private TextView aoD;
    private View aoE;
    protected TextView aoF;
    private TextView aoG;
    private boolean aoH;
    private View aoI;
    private TextView aoJ;
    private boolean aoK;
    private View.OnClickListener aoL;
    private View.OnClickListener aoM;
    public ClickableHeaderImageView aob;
    public TextView aoc;
    private boolean aof;
    private View.OnClickListener aog;
    private View.OnClickListener aoi;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aoH = true;
        this.mFrom = 1;
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getUserId()) && ThreadUserInfoLayout.this.ajM.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sA() != null && ThreadUserInfoLayout.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sA().channelId, ThreadUserInfoLayout.this.ajM.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rv().getUserId(), ThreadUserInfoLayout.this.ajM.rv().getName_show(), ThreadUserInfoLayout.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aog != null) {
                        ThreadUserInfoLayout.this.aog.onClick(view);
                    }
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoH = true;
        this.mFrom = 1;
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getUserId()) && ThreadUserInfoLayout.this.ajM.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sA() != null && ThreadUserInfoLayout.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sA().channelId, ThreadUserInfoLayout.this.ajM.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rv().getUserId(), ThreadUserInfoLayout.this.ajM.rv().getName_show(), ThreadUserInfoLayout.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aog != null) {
                        ThreadUserInfoLayout.this.aog.onClick(view);
                    }
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoH = true;
        this.mFrom = 1;
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew() != null && v.c(ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ajM.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ajM.rv().getUserId()) && ThreadUserInfoLayout.this.ajM.rB() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aS(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.ajM.sA() != null && ThreadUserInfoLayout.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.sA().channelId, ThreadUserInfoLayout.this.ajM.sA().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ajM.rv().getUserId(), ThreadUserInfoLayout.this.ajM.rv().getName_show(), ThreadUserInfoLayout.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.aog != null) {
                        ThreadUserInfoLayout.this.aog.onClick(view);
                    }
                }
            }
        };
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ajM != null && ThreadUserInfoLayout.this.ajM.rv() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.ajM.rv().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.aob = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aoA = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.aoc = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.aoB = (ImageView) inflate.findViewById(d.g.identity_view);
        this.aoC = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aoD = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.aoE = inflate.findViewById(d.g.divider);
        this.aoI = findViewById(d.g.divider_forum_name);
        this.aoJ = (TextView) findViewById(d.g.thread_info_forum_name);
        this.aoF = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.aoG = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.aoA.setOnClickListener(this.aoL);
        this.aoc.setOnClickListener(this.aoi);
        this.aoC.setOnClickListener(this.aoM);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        if (this.ajM.aaD > 0) {
            if (this.ajM.aaE == 0 && this.ajM.rv() != null) {
                if (!v.w(this.ajM.rv().getTShowInfoNew())) {
                    this.ajM.rv().getTShowInfoNew().clear();
                }
                this.ajM.rv().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.aoA.setOnClickListener(null);
            this.aoc.setOnClickListener(null);
            this.aoC.setOnClickListener(null);
            this.aob.setClickable(false);
        } else {
            this.aoA.setOnClickListener(this.aoL);
            this.aoc.setOnClickListener(this.aoi);
            this.aoC.setOnClickListener(this.aoM);
            this.aob.setClickable(true);
        }
        k(bdVar);
        i(bdVar);
        n(bdVar);
        l(bdVar);
        m(bdVar);
        d(bdVar);
        o(bdVar);
        q(bdVar);
        p(bdVar);
        setVisibility(0);
        j(bdVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.aob != null) {
            this.aob.setDefaultResource(17170445);
            this.aob.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.aob.setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.aob.setIsRound(true);
            this.aob.setAfterClickListener(this.aog);
        }
    }

    private void j(bd bdVar) {
        if (this.aoG != null && bdVar != null && bdVar.rv() != null) {
            if (bdVar.rv().hadConcerned()) {
                this.aoG.setVisibility(0);
                aj.i(this.aoG, d.C0095d.cp_cont_d);
                aj.j(this.aoG, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.aoG.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.aoA != null && bdVar != null && bdVar.rv() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.rv().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aoA.setVisibility(0);
                this.aoA.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.aoA.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.aoB != null && bdVar != null && bdVar.rv() != null) {
            MetaData rv = bdVar.rv();
            if (rv.getIs_bawu() == 1) {
                if ("manager".equals(rv.getBawu_type())) {
                    aj.c(this.aoB, d.f.icon_id_bazhu);
                    this.aoB.setVisibility(0);
                    return;
                } else if ("assist".equals(rv.getBawu_type())) {
                    aj.c(this.aoB, d.f.icon_id_xiaobazhu);
                    this.aoB.setVisibility(0);
                    return;
                } else {
                    this.aoB.setVisibility(8);
                    return;
                }
            }
            this.aoB.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.aoc != null && bdVar != null) {
            if (!StringUtils.isNull(this.ajM.rv().getName_show())) {
                this.aoc.setText(ex(this.ajM.rv().getName_show()));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajM.rv().getName_show();
                String userName = this.ajM.rv().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.aoc.setText(com.baidu.tieba.pb.c.aj(this.mContext, this.aoc.getText().toString()));
                    this.aoc.setGravity(16);
                    this.aoc.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aQS());
                    aj.c(this.aoc, d.C0095d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.aoC != null) {
            if (this.aoK) {
                this.aoC.setVisibility(8);
            } else if (bdVar == null || bdVar.rv() == null || ((bdVar.aaD > 0 && bdVar.aaE == 0) || !this.aoH)) {
                this.aoC.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.rv().getIconInfo();
                if (v.v(iconInfo) != 0) {
                    this.aoC.setVisibility(0);
                    this.aoC.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.aoC.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String r;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rp() <= 0) {
                this.anm.setVisibility(4);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.q(bdVar.rp());
            } else if (bdVar.sB()) {
                r = am.r(bdVar.getCreateTime());
            } else {
                r = am.r(bdVar.rp() * 1000);
            }
            this.anm.setText(r);
        }
    }

    protected void n(bd bdVar) {
        if (this.aoF == null || bdVar == null) {
            this.aoF.setVisibility(8);
        } else if (this.aoK) {
            if (StringUtils.isNull(bdVar.rU())) {
                this.aoF.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoF.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.aoF.setLayoutParams(layoutParams);
            }
            this.aoF.setText(bdVar.rU());
            this.aoF.setVisibility(0);
        } else if (this.ajM.rO() == null || this.ajM.rO().share_info == null || this.ajM.rO().share_info.share_user_count <= 0 || !this.ajM.sE() || (this.ajM.aaD > 0 && this.ajM.aaE == 0)) {
            this.aoF.setVisibility(8);
        } else {
            this.aoF.setVisibility(0);
            int i = this.ajM.rO().share_info.share_user_count;
            if (i == 1) {
                this.aoF.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.aoF.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.v(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.aoD.setVisibility(8);
            this.aoE.setVisibility(8);
            return;
        }
        this.aoD.setText(this.ajM.getAddress());
        this.aoD.setVisibility(0);
        this.aoE.setVisibility(0);
    }

    private void p(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.rB()) || this.mFrom == 3) {
            this.aoJ.setVisibility(8);
            this.aoI.setVisibility(8);
            return;
        }
        if (this.ajM.aaD > 0 && this.ajM.aaE == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.ajM.rB(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.aoJ.setText(str);
        this.aoJ.setVisibility(0);
        this.aoI.setVisibility(0);
    }

    private void q(bd bdVar) {
        if (this.aob != null && bdVar != null && this.ajM.rv() != null) {
            if (this.ajM.aaD > 0 && this.ajM.aaE == 0) {
                this.aob.setShowV(false);
            } else {
                this.aob.setShowV(this.ajM.rv().isBigV());
            }
        }
    }

    private void wL() {
        if (this.ajM != null && this.ajM.rv() != null) {
            if (this.ajM.aaD > 0 && this.ajM.aaE == 0) {
                aj.i(this.aoc, d.C0095d.cp_cont_f);
            } else if (!v.w(this.ajM.rv().getTShowInfoNew()) || this.ajM.rv().isBigV()) {
                aj.i(this.aoc, d.C0095d.cp_cont_h);
            } else {
                aj.i(this.aoc, d.C0095d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.aoF, d.C0095d.cp_cont_f);
        aj.i(this.anm, d.C0095d.cp_cont_d);
        aj.k(this.aoE, d.C0095d.cp_cont_e);
        aj.i(this.aoD, d.C0095d.cp_cont_d);
        aj.i(this.aoJ, d.C0095d.cp_cont_d);
        aj.k(this.aoE, d.C0095d.cp_cont_e);
        aj.k(this.aoI, d.C0095d.cp_cont_e);
        l(this.ajM);
    }

    public void setIsSimpleThread(boolean z) {
        this.aof = z;
    }

    public boolean getIsSimpleThread() {
        return this.aof;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aog = onClickListener;
        if (this.aob != null) {
            this.aob.setAfterClickListener(this.aog);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aob != null) {
            this.aob.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aob;
    }

    public TextView getUserName() {
        return this.aoc;
    }

    protected String ex(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aoH;
    }

    public void setTShowVisible(boolean z) {
        this.aoH = z;
    }

    public void setIsFromConcern(boolean z) {
        this.aoK = z;
    }
}

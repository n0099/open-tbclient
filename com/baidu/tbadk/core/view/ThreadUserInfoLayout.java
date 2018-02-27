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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.af;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bd aZA;
    private TextView bcY;
    public ClickableHeaderImageView bdL;
    public TextView bdM;
    private boolean bdP;
    private View.OnClickListener bdQ;
    private View.OnClickListener bdS;
    private boolean beA;
    private View beB;
    private TextView beC;
    private boolean beD;
    private View.OnClickListener beE;
    private View.OnClickListener beF;
    private UserIconBox bes;
    public ImageView beu;
    protected UserIconBox bev;
    private TextView bew;
    private View bex;
    protected TextView bey;
    private TextView bez;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.beA = true;
        this.mFrom = 1;
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getUserId()) && ThreadUserInfoLayout.this.aZA.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZA.Ao() != null && ThreadUserInfoLayout.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.Ao().channelId, ThreadUserInfoLayout.this.aZA.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.zn().getUserId(), ThreadUserInfoLayout.this.aZA.zn().getName_show(), ThreadUserInfoLayout.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZA.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdQ != null) {
                        ThreadUserInfoLayout.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.beF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZA.zn().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beA = true;
        this.mFrom = 1;
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getUserId()) && ThreadUserInfoLayout.this.aZA.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZA.Ao() != null && ThreadUserInfoLayout.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.Ao().channelId, ThreadUserInfoLayout.this.aZA.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.zn().getUserId(), ThreadUserInfoLayout.this.aZA.zn().getName_show(), ThreadUserInfoLayout.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZA.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdQ != null) {
                        ThreadUserInfoLayout.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.beF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZA.zn().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beA = true;
        this.mFrom = 1;
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZA.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZA.zn().getUserId()) && ThreadUserInfoLayout.this.aZA.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZA.Ao() != null && ThreadUserInfoLayout.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.Ao().channelId, ThreadUserInfoLayout.this.aZA.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZA.zn().getUserId(), ThreadUserInfoLayout.this.aZA.zn().getName_show(), ThreadUserInfoLayout.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZA.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdQ != null) {
                        ThreadUserInfoLayout.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.beF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZA != null && ThreadUserInfoLayout.this.aZA.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZA.zn().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_user_info_layout, (ViewGroup) this, true);
        this.bdL = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bes = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bdM = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.beu = (ImageView) inflate.findViewById(d.g.identity_view);
        this.bev = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bcY = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bew = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.bex = inflate.findViewById(d.g.divider);
        this.beB = findViewById(d.g.divider_forum_name);
        this.beC = (TextView) findViewById(d.g.thread_info_forum_name);
        this.bey = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.bez = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bes.setOnClickListener(this.beE);
        this.bdM.setOnClickListener(this.bdS);
        this.bev.setOnClickListener(this.beF);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZA = bdVar;
        if (this.aZA.aQj > 0) {
            if (this.aZA.aQk == 0 && this.aZA.zn() != null) {
                if (!v.E(this.aZA.zn().getTShowInfoNew())) {
                    this.aZA.zn().getTShowInfoNew().clear();
                }
                this.aZA.zn().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.bes.setOnClickListener(null);
            this.bdM.setOnClickListener(null);
            this.bev.setOnClickListener(null);
            this.bdL.setClickable(false);
        } else {
            this.bes.setOnClickListener(this.beE);
            this.bdM.setOnClickListener(this.bdS);
            this.bev.setOnClickListener(this.beF);
            this.bdL.setClickable(true);
        }
        k(bdVar);
        i(bdVar);
        n(bdVar);
        l(bdVar);
        m(bdVar);
        d(bdVar);
        o(bdVar);
        p(bdVar);
        updateForumName(bdVar);
        setVisibility(0);
        j(bdVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.bdL != null) {
            this.bdL.setDefaultResource(17170445);
            this.bdL.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdL.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bdL.setIsRound(true);
            this.bdL.setAfterClickListener(this.bdQ);
        }
    }

    private void j(bd bdVar) {
        if (this.bez != null && bdVar != null && bdVar.zn() != null) {
            if (bdVar.zn().hadConcerned()) {
                this.bez.setVisibility(0);
                aj.r(this.bez, d.C0141d.cp_cont_d);
                aj.s(this.bez, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.bez.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.bes != null && bdVar != null && bdVar.zn() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bes.setVisibility(0);
                this.bes.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.bes.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.beu != null && bdVar != null && bdVar.zn() != null) {
            MetaData zn = bdVar.zn();
            if (zn.getIs_bawu() == 1) {
                if ("manager".equals(zn.getBawu_type())) {
                    aj.c(this.beu, d.f.icon_id_bazhu);
                    this.beu.setVisibility(0);
                    return;
                } else if ("assist".equals(zn.getBawu_type())) {
                    aj.c(this.beu, d.f.icon_id_xiaobazhu);
                    this.beu.setVisibility(0);
                    return;
                } else {
                    this.beu.setVisibility(8);
                    return;
                }
            }
            this.beu.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.bdM != null && bdVar != null) {
            if (!StringUtils.isNull(this.aZA.zn().getName_show())) {
                this.bdM.setText(eX(this.aZA.zn().getName_show()));
            }
            Ew();
            if (this.mFrom == 3) {
                String name_show = this.aZA.zn().getName_show();
                String userName = this.aZA.zn().getUserName();
                if (af.nv() && name_show != null && !name_show.equals(userName)) {
                    this.bdM.setText(com.baidu.tieba.pb.c.am(this.mContext, this.bdM.getText().toString()));
                    this.bdM.setGravity(16);
                    this.bdM.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.baa());
                    aj.e(this.bdM, d.C0141d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.bev != null) {
            if (this.beD) {
                this.bev.setVisibility(8);
            } else if (bdVar == null || bdVar.zn() == null || ((bdVar.aQj > 0 && bdVar.aQk == 0) || !this.beA)) {
                this.bev.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
                if (v.D(iconInfo) != 0) {
                    this.bev.setVisibility(0);
                    this.bev.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.bev.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String z;
        if (this.bcY != null && bdVar != null) {
            if (bdVar.zh() <= 0) {
                this.bcY.setVisibility(4);
                return;
            }
            this.bcY.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(bdVar.zh());
            } else if (bdVar.Ap()) {
                z = am.z(bdVar.getCreateTime());
            } else {
                z = am.z(bdVar.zh() * 1000);
            }
            this.bcY.setText(z);
        }
    }

    protected void n(bd bdVar) {
        if (this.bey == null || bdVar == null) {
            this.bey.setVisibility(8);
        } else if (this.beD) {
            if (StringUtils.isNull(bdVar.zM())) {
                this.bey.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bey.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.bey.setLayoutParams(layoutParams);
            }
            this.bey.setText(bdVar.zM());
            this.bey.setVisibility(0);
        } else if (this.aZA.zG() == null || this.aZA.zG().share_info == null || this.aZA.zG().share_info.share_user_count <= 0 || !this.aZA.As() || (this.aZA.aQj > 0 && this.aZA.aQk == 0)) {
            this.bey.setVisibility(8);
        } else {
            this.bey.setVisibility(0);
            int i = this.aZA.zG().share_info.share_user_count;
            if (i == 1) {
                this.bey.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.bey.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.E(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.bew.setVisibility(8);
            this.bex.setVisibility(8);
            return;
        }
        this.bew.setText(this.aZA.getAddress());
        this.bew.setVisibility(0);
        this.bex.setVisibility(0);
    }

    public void updateForumName(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.zt()) || this.mFrom == 3) {
            this.beC.setVisibility(8);
            this.beB.setVisibility(8);
            return;
        }
        if (this.aZA.aQj > 0 && this.aZA.aQk == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aZA.zt(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.beC.setText(str);
        this.beC.setVisibility(0);
        this.beB.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aZA);
            return;
        }
        this.beC.setVisibility(8);
        this.beB.setVisibility(8);
    }

    private void p(bd bdVar) {
        if (this.bdL != null && bdVar != null && this.aZA.zn() != null) {
            if (this.aZA.aQj > 0 && this.aZA.aQk == 0) {
                this.bdL.setShowV(false);
            } else {
                this.bdL.setShowV(this.aZA.zn().isBigV());
            }
        }
    }

    private void Ew() {
        if (this.aZA != null && this.aZA.zn() != null) {
            if (this.aZA.aQj > 0 && this.aZA.aQk == 0) {
                aj.r(this.bdM, d.C0141d.cp_cont_f);
            } else if (!v.E(this.aZA.zn().getTShowInfoNew()) || this.aZA.zn().isBigV()) {
                aj.r(this.bdM, d.C0141d.cp_cont_h);
            } else {
                aj.r(this.bdM, d.C0141d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ew();
        aj.r(this.bey, d.C0141d.cp_cont_f);
        aj.r(this.bcY, d.C0141d.cp_cont_d);
        aj.t(this.bex, d.C0141d.cp_cont_e);
        aj.r(this.bew, d.C0141d.cp_cont_d);
        aj.r(this.beC, d.C0141d.cp_cont_d);
        aj.t(this.bex, d.C0141d.cp_cont_e);
        aj.t(this.beB, d.C0141d.cp_cont_e);
        l(this.aZA);
    }

    public void setIsSimpleThread(boolean z) {
        this.bdP = z;
    }

    public boolean getIsSimpleThread() {
        return this.bdP;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdQ = onClickListener;
        if (this.bdL != null) {
            this.bdL.setAfterClickListener(this.bdQ);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdL != null) {
            this.bdL.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.bdL;
    }

    public TextView getUserName() {
        return this.bdM;
    }

    protected String eX(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.beA;
    }

    public void setTShowVisible(boolean z) {
        this.beA = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beD = z;
    }
}

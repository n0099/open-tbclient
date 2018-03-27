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
    private boolean aQq;
    private bd aZC;
    public ClickableHeaderImageView bdO;
    public TextView bdP;
    private boolean bdS;
    private View.OnClickListener bdT;
    private View.OnClickListener bdV;
    private TextView bda;
    private View beA;
    protected TextView beB;
    private TextView beC;
    private boolean beD;
    private View beE;
    private TextView beF;
    private boolean beG;
    private View.OnClickListener beH;
    private View.OnClickListener beI;
    private UserIconBox bew;
    public ImageView bex;
    protected UserIconBox bey;
    private TextView bez;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.beD = true;
        this.mFrom = 1;
        this.aQq = false;
        this.beH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getUserId()) && ThreadUserInfoLayout.this.aZC.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZC.Ao() != null && ThreadUserInfoLayout.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.Ao().channelId, ThreadUserInfoLayout.this.aZC.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.zn().getUserId(), ThreadUserInfoLayout.this.aZC.zn().getName_show(), ThreadUserInfoLayout.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZC.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdT != null) {
                        ThreadUserInfoLayout.this.bdT.onClick(view);
                    }
                }
            }
        };
        this.beI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZC.zn().getUserId(), true, true, true);
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
        this.beD = true;
        this.mFrom = 1;
        this.aQq = false;
        this.beH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getUserId()) && ThreadUserInfoLayout.this.aZC.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZC.Ao() != null && ThreadUserInfoLayout.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.Ao().channelId, ThreadUserInfoLayout.this.aZC.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.zn().getUserId(), ThreadUserInfoLayout.this.aZC.zn().getName_show(), ThreadUserInfoLayout.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZC.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdT != null) {
                        ThreadUserInfoLayout.this.bdT.onClick(view);
                    }
                }
            }
        };
        this.beI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZC.zn().getUserId(), true, true, true);
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
        this.beD = true;
        this.mFrom = 1;
        this.aQq = false;
        this.beH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZC.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZC.zn().getUserId()) && ThreadUserInfoLayout.this.aZC.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZC.Ao() != null && ThreadUserInfoLayout.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.Ao().channelId, ThreadUserInfoLayout.this.aZC.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZC.zn().getUserId(), ThreadUserInfoLayout.this.aZC.zn().getName_show(), ThreadUserInfoLayout.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZC.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bdT != null) {
                        ThreadUserInfoLayout.this.bdT.onClick(view);
                    }
                }
            }
        };
        this.beI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZC != null && ThreadUserInfoLayout.this.aZC.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZC.zn().getUserId(), true, true, true);
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
        this.bdO = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bew = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bdP = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bex = (ImageView) inflate.findViewById(d.g.identity_view);
        this.bey = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bda = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bez = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.beA = inflate.findViewById(d.g.divider);
        this.beE = findViewById(d.g.divider_forum_name);
        this.beF = (TextView) findViewById(d.g.thread_info_forum_name);
        this.beB = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.beC = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bew.setOnClickListener(this.beH);
        this.bdP.setOnClickListener(this.bdV);
        this.bey.setOnClickListener(this.beI);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZC = bdVar;
        if (this.aZC.aQk > 0) {
            if (this.aZC.aQl == 0 && this.aZC.zn() != null) {
                if (!v.E(this.aZC.zn().getTShowInfoNew())) {
                    this.aZC.zn().getTShowInfoNew().clear();
                }
                this.aZC.zn().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.bew.setOnClickListener(null);
            this.bdP.setOnClickListener(null);
            this.bey.setOnClickListener(null);
            this.bdO.setClickable(false);
        } else {
            this.bew.setOnClickListener(this.beH);
            this.bdP.setOnClickListener(this.bdV);
            this.bey.setOnClickListener(this.beI);
            this.bdO.setClickable(true);
        }
        this.bdO.changeGrayScaleMode(this.aZC.AC());
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
        if (this.bdO != null) {
            this.bdO.setDefaultResource(17170445);
            this.bdO.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdO.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bdO.setIsRound(true);
            this.bdO.setAfterClickListener(this.bdT);
        }
    }

    private void j(bd bdVar) {
        if (this.beC != null && bdVar != null && bdVar.zn() != null) {
            if (bdVar.zn().hadConcerned()) {
                this.beC.setVisibility(0);
                aj.r(this.beC, d.C0141d.cp_cont_d);
                aj.s(this.beC, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.beC.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.bew != null && bdVar != null && bdVar.zn() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bew.setVisibility(0);
                this.bew.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true, bdVar.AC());
                return;
            }
            this.bew.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.bex != null && bdVar != null && bdVar.zn() != null) {
            MetaData zn = bdVar.zn();
            if (zn.getIs_bawu() == 1) {
                if ("manager".equals(zn.getBawu_type())) {
                    aj.c(this.bex, d.f.icon_id_bazhu);
                    this.bex.setVisibility(0);
                    return;
                } else if ("assist".equals(zn.getBawu_type())) {
                    aj.c(this.bex, d.f.icon_id_xiaobazhu);
                    this.bex.setVisibility(0);
                    return;
                } else {
                    this.bex.setVisibility(8);
                    return;
                }
            }
            this.bex.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.bdP != null && bdVar != null) {
            if (!StringUtils.isNull(this.aZC.zn().getName_show())) {
                this.bdP.setText(eX(this.aZC.zn().getName_show()));
            }
            Ex();
            if (this.mFrom == 3) {
                String name_show = this.aZC.zn().getName_show();
                String userName = this.aZC.zn().getUserName();
                if (af.nv() && name_show != null && !name_show.equals(userName)) {
                    this.bdP.setText(com.baidu.tieba.pb.c.am(this.mContext, this.bdP.getText().toString()));
                    this.bdP.setGravity(16);
                    this.bdP.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                    aj.e(this.bdP, d.C0141d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.bey != null) {
            if (this.beG) {
                this.bey.setVisibility(8);
            } else if (bdVar == null || bdVar.zn() == null || ((bdVar.aQk > 0 && bdVar.aQl == 0) || !this.beD)) {
                this.bey.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
                if (v.D(iconInfo) != 0) {
                    this.bey.setVisibility(0);
                    this.bey.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true, bdVar.AC());
                    return;
                }
                this.bey.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String z;
        if (this.bda != null && bdVar != null) {
            if (bdVar.zh() <= 0) {
                this.bda.setVisibility(4);
                return;
            }
            this.bda.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(bdVar.zh());
            } else if (bdVar.Ap()) {
                z = am.z(bdVar.getCreateTime());
            } else {
                z = am.z(bdVar.zh() * 1000);
            }
            this.bda.setText(z);
        }
    }

    protected void n(bd bdVar) {
        if (this.beB == null || bdVar == null) {
            this.beB.setVisibility(8);
        } else if (this.beG) {
            if (StringUtils.isNull(bdVar.zM())) {
                this.beB.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beB.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.beB.setLayoutParams(layoutParams);
            }
            this.beB.setText(bdVar.zM());
            this.beB.setVisibility(0);
        } else if (this.aZC.zG() == null || this.aZC.zG().share_info == null || this.aZC.zG().share_info.share_user_count <= 0 || !this.aZC.As() || (this.aZC.aQk > 0 && this.aZC.aQl == 0)) {
            this.beB.setVisibility(8);
        } else {
            this.beB.setVisibility(0);
            int i = this.aZC.zG().share_info.share_user_count;
            if (i == 1) {
                this.beB.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.beB.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.E(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.bez.setVisibility(8);
            this.beA.setVisibility(8);
            return;
        }
        this.bez.setText(this.aZC.getAddress());
        this.bez.setVisibility(0);
        this.beA.setVisibility(0);
    }

    public void updateForumName(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.zt()) || this.mFrom == 3) {
            this.beF.setVisibility(8);
            this.beE.setVisibility(8);
            return;
        }
        if (this.aZC.aQk > 0 && this.aZC.aQl == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aZC.zt(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.beF.setText(str);
        this.beF.setVisibility(0);
        this.beE.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aZC);
            return;
        }
        this.beF.setVisibility(8);
        this.beE.setVisibility(8);
    }

    private void p(bd bdVar) {
        if (this.bdO != null && bdVar != null && this.aZC.zn() != null) {
            if (this.aZC.aQk > 0 && this.aZC.aQl == 0) {
                this.bdO.setShowV(false);
            } else {
                this.bdO.setShowV(this.aZC.zn().isBigV());
            }
        }
    }

    private void Ex() {
        if (this.aZC != null && this.aZC.zn() != null) {
            if (this.aZC.aQk > 0 && this.aZC.aQl == 0) {
                aj.r(this.bdP, d.C0141d.cp_cont_f);
                return;
            }
            ArrayList<IconData> tShowInfoNew = this.aZC.zn().getTShowInfoNew();
            if (!this.aZC.AC() && (!v.E(tShowInfoNew) || this.aZC.zn().isBigV())) {
                aj.r(this.bdP, d.C0141d.cp_cont_h);
            } else {
                aj.r(this.bdP, d.C0141d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ex();
        aj.r(this.beB, d.C0141d.cp_cont_f);
        aj.r(this.bda, d.C0141d.cp_cont_d);
        aj.t(this.beA, d.C0141d.cp_cont_e);
        aj.r(this.bez, d.C0141d.cp_cont_d);
        aj.r(this.beF, d.C0141d.cp_cont_d);
        aj.t(this.beA, d.C0141d.cp_cont_e);
        aj.t(this.beE, d.C0141d.cp_cont_e);
        l(this.aZC);
    }

    public void setIsSimpleThread(boolean z) {
        this.bdS = z;
    }

    public boolean getIsSimpleThread() {
        return this.bdS;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
        if (this.bdO != null) {
            this.bdO.setAfterClickListener(this.bdT);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdO != null) {
            this.bdO.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.bdO;
    }

    public TextView getUserName() {
        return this.bdP;
    }

    protected String eX(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.beD;
    }

    public void setTShowVisible(boolean z) {
        this.beD = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beG = z;
    }
}

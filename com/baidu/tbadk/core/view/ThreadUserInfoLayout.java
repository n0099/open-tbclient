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
    private bd aZM;
    public ClickableHeaderImageView bdX;
    public TextView bdY;
    private TextView bdk;
    private UserIconBox beF;
    public ImageView beG;
    protected UserIconBox beH;
    private TextView beI;
    private View beJ;
    protected TextView beK;
    private TextView beL;
    private boolean beM;
    private View beN;
    private TextView beO;
    private boolean beP;
    private View.OnClickListener beQ;
    private View.OnClickListener beR;
    private boolean beb;
    private View.OnClickListener bec;
    private View.OnClickListener bee;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.beM = true;
        this.mFrom = 1;
        this.beQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getUserId()) && ThreadUserInfoLayout.this.aZM.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZM.Ao() != null && ThreadUserInfoLayout.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.Ao().channelId, ThreadUserInfoLayout.this.aZM.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.zn().getUserId(), ThreadUserInfoLayout.this.aZM.zn().getName_show(), ThreadUserInfoLayout.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bec != null) {
                        ThreadUserInfoLayout.this.bec.onClick(view);
                    }
                }
            }
        };
        this.beR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZM.zn().getUserId(), true, true, true);
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
        this.beM = true;
        this.mFrom = 1;
        this.beQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getUserId()) && ThreadUserInfoLayout.this.aZM.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZM.Ao() != null && ThreadUserInfoLayout.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.Ao().channelId, ThreadUserInfoLayout.this.aZM.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.zn().getUserId(), ThreadUserInfoLayout.this.aZM.zn().getName_show(), ThreadUserInfoLayout.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bec != null) {
                        ThreadUserInfoLayout.this.bec.onClick(view);
                    }
                }
            }
        };
        this.beR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZM.zn().getUserId(), true, true, true);
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
        this.beM = true;
        this.mFrom = 1;
        this.beQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew() != null && v.f(ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.aZM.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.aZM.zn().getUserId()) && ThreadUserInfoLayout.this.aZM.zt() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ay.ba(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.aZM.Ao() != null && ThreadUserInfoLayout.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.Ao().channelId, ThreadUserInfoLayout.this.aZM.Ao().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.aZM.zn().getUserId(), ThreadUserInfoLayout.this.aZM.zn().getName_show(), ThreadUserInfoLayout.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.aZM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.bec != null) {
                        ThreadUserInfoLayout.this.bec.onClick(view);
                    }
                }
            }
        };
        this.beR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.aZM != null && ThreadUserInfoLayout.this.aZM.zn() != null) {
                    com.baidu.tbadk.browser.b.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.aZM.zn().getUserId(), true, true, true);
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
        this.bdX = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.beF = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.bdY = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.beG = (ImageView) inflate.findViewById(d.g.identity_view);
        this.beH = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.bdk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.beI = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.beJ = inflate.findViewById(d.g.divider);
        this.beN = findViewById(d.g.divider_forum_name);
        this.beO = (TextView) findViewById(d.g.thread_info_forum_name);
        this.beK = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.beL = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.beF.setOnClickListener(this.beQ);
        this.bdY.setOnClickListener(this.bee);
        this.beH.setOnClickListener(this.beR);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZM = bdVar;
        if (this.aZM.aQu > 0) {
            if (this.aZM.aQv == 0 && this.aZM.zn() != null) {
                if (!v.E(this.aZM.zn().getTShowInfoNew())) {
                    this.aZM.zn().getTShowInfoNew().clear();
                }
                this.aZM.zn().setName_show(getContext().getString(d.j.perfect_selection_video));
            }
            this.beF.setOnClickListener(null);
            this.bdY.setOnClickListener(null);
            this.beH.setOnClickListener(null);
            this.bdX.setClickable(false);
        } else {
            this.beF.setOnClickListener(this.beQ);
            this.bdY.setOnClickListener(this.bee);
            this.beH.setOnClickListener(this.beR);
            this.bdX.setClickable(true);
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
        if (this.bdX != null) {
            this.bdX.setDefaultResource(17170445);
            this.bdX.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdX.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bdX.setIsRound(true);
            this.bdX.setAfterClickListener(this.bec);
        }
    }

    private void j(bd bdVar) {
        if (this.beL != null && bdVar != null && bdVar.zn() != null) {
            if (bdVar.zn().hadConcerned()) {
                this.beL.setVisibility(0);
                aj.r(this.beL, d.C0140d.cp_cont_d);
                aj.s(this.beL, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.beL.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.beF != null && bdVar != null && bdVar.zn() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.beF.setVisibility(0);
                this.beF.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.beF.setVisibility(8);
        }
    }

    private void l(bd bdVar) {
        if (this.beG != null && bdVar != null && bdVar.zn() != null) {
            MetaData zn = bdVar.zn();
            if (zn.getIs_bawu() == 1) {
                if ("manager".equals(zn.getBawu_type())) {
                    aj.c(this.beG, d.f.icon_id_bazhu);
                    this.beG.setVisibility(0);
                    return;
                } else if ("assist".equals(zn.getBawu_type())) {
                    aj.c(this.beG, d.f.icon_id_xiaobazhu);
                    this.beG.setVisibility(0);
                    return;
                } else {
                    this.beG.setVisibility(8);
                    return;
                }
            }
            this.beG.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.bdY != null && bdVar != null) {
            if (!StringUtils.isNull(this.aZM.zn().getName_show())) {
                this.bdY.setText(eX(this.aZM.zn().getName_show()));
            }
            Ex();
            if (this.mFrom == 3) {
                String name_show = this.aZM.zn().getName_show();
                String userName = this.aZM.zn().getUserName();
                if (af.nv() && name_show != null && !name_show.equals(userName)) {
                    this.bdY.setText(com.baidu.tieba.pb.c.am(this.mContext, this.bdY.getText().toString()));
                    this.bdY.setGravity(16);
                    this.bdY.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.bab());
                    aj.e(this.bdY, d.C0140d.cp_other_e, 1);
                }
            }
        }
    }

    private void m(bd bdVar) {
        if (this.beH != null) {
            if (this.beP) {
                this.beH.setVisibility(8);
            } else if (bdVar == null || bdVar.zn() == null || ((bdVar.aQu > 0 && bdVar.aQv == 0) || !this.beM)) {
                this.beH.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
                if (v.D(iconInfo) != 0) {
                    this.beH.setVisibility(0);
                    this.beH.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.beH.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String z;
        if (this.bdk != null && bdVar != null) {
            if (bdVar.zh() <= 0) {
                this.bdk.setVisibility(4);
                return;
            }
            this.bdk.setVisibility(0);
            if (this.mFrom == 2) {
                z = am.y(bdVar.zh());
            } else if (bdVar.Ap()) {
                z = am.z(bdVar.getCreateTime());
            } else {
                z = am.z(bdVar.zh() * 1000);
            }
            this.bdk.setText(z);
        }
    }

    protected void n(bd bdVar) {
        if (this.beK == null || bdVar == null) {
            this.beK.setVisibility(8);
        } else if (this.beP) {
            if (StringUtils.isNull(bdVar.zM())) {
                this.beK.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.beK.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.beK.setLayoutParams(layoutParams);
            }
            this.beK.setText(bdVar.zM());
            this.beK.setVisibility(0);
        } else if (this.aZM.zG() == null || this.aZM.zG().share_info == null || this.aZM.zG().share_info.share_user_count <= 0 || !this.aZM.As() || (this.aZM.aQu > 0 && this.aZM.aQv == 0)) {
            this.beK.setVisibility(8);
        } else {
            this.beK.setVisibility(0);
            int i = this.aZM.zG().share_info.share_user_count;
            if (i == 1) {
                this.beK.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple));
            } else {
                this.beK.setText(TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{am.E(i)}));
            }
        }
    }

    private void o(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.beI.setVisibility(8);
            this.beJ.setVisibility(8);
            return;
        }
        this.beI.setText(this.aZM.getAddress());
        this.beI.setVisibility(0);
        this.beJ.setVisibility(0);
    }

    public void updateForumName(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.zt()) || this.mFrom == 3) {
            this.beO.setVisibility(8);
            this.beN.setVisibility(8);
            return;
        }
        if (this.aZM.aQu > 0 && this.aZM.aQv == 0) {
            str = getContext().getString(d.j.select_video_list);
        } else {
            str = am.e(this.aZM.zt(), 12, "...") + getResources().getString(d.j.forum);
        }
        this.beO.setText(str);
        this.beO.setVisibility(0);
        this.beN.setVisibility(0);
    }

    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.aZM);
            return;
        }
        this.beO.setVisibility(8);
        this.beN.setVisibility(8);
    }

    private void p(bd bdVar) {
        if (this.bdX != null && bdVar != null && this.aZM.zn() != null) {
            if (this.aZM.aQu > 0 && this.aZM.aQv == 0) {
                this.bdX.setShowV(false);
            } else {
                this.bdX.setShowV(this.aZM.zn().isBigV());
            }
        }
    }

    private void Ex() {
        if (this.aZM != null && this.aZM.zn() != null) {
            if (this.aZM.aQu > 0 && this.aZM.aQv == 0) {
                aj.r(this.bdY, d.C0140d.cp_cont_f);
            } else if (!v.E(this.aZM.zn().getTShowInfoNew()) || this.aZM.zn().isBigV()) {
                aj.r(this.bdY, d.C0140d.cp_cont_h);
            } else {
                aj.r(this.bdY, d.C0140d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        Ex();
        aj.r(this.beK, d.C0140d.cp_cont_f);
        aj.r(this.bdk, d.C0140d.cp_cont_d);
        aj.t(this.beJ, d.C0140d.cp_cont_e);
        aj.r(this.beI, d.C0140d.cp_cont_d);
        aj.r(this.beO, d.C0140d.cp_cont_d);
        aj.t(this.beJ, d.C0140d.cp_cont_e);
        aj.t(this.beN, d.C0140d.cp_cont_e);
        l(this.aZM);
    }

    public void setIsSimpleThread(boolean z) {
        this.beb = z;
    }

    public boolean getIsSimpleThread() {
        return this.beb;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bec = onClickListener;
        if (this.bdX != null) {
            this.bdX.setAfterClickListener(this.bec);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdX != null) {
            this.bdX.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.bdX;
    }

    public TextView getUserName() {
        return this.bdY;
    }

    protected String eX(String str) {
        return am.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.beM;
    }

    public void setTShowVisible(boolean z) {
        this.beM = z;
    }

    public void setIsFromConcern(boolean z) {
        this.beP = z;
    }
}

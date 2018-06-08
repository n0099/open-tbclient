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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.o.ah;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout implements b {
    private bd atn;
    private TextView awA;
    private UserIconBox axT;
    public ImageView axU;
    protected UserIconBox axV;
    private TextView axW;
    private View axX;
    protected TextView axY;
    private TextView axZ;
    public ClickableHeaderImageView axn;
    public TextView axo;
    private boolean axq;
    private View.OnClickListener axr;
    private View.OnClickListener axt;
    private boolean aya;
    private View ayb;
    private TextView ayc;
    private boolean ayd;
    private View.OnClickListener aye;
    private View.OnClickListener ayf;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.aya = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aye = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew() != null && w.c(ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getUserId()) && ThreadUserInfoLayout.this.atn.vr() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atn.wm() != null && ThreadUserInfoLayout.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.wm().channelId, ThreadUserInfoLayout.this.atn.wm().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.vm().getUserId(), ThreadUserInfoLayout.this.atn.vm().getName_show(), ThreadUserInfoLayout.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axr != null) {
                        ThreadUserInfoLayout.this.axr.onClick(view);
                    }
                }
            }
        };
        this.ayf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atn.vm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aya = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aye = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew() != null && w.c(ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getUserId()) && ThreadUserInfoLayout.this.atn.vr() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atn.wm() != null && ThreadUserInfoLayout.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.wm().channelId, ThreadUserInfoLayout.this.atn.wm().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.vm().getUserId(), ThreadUserInfoLayout.this.atn.vm().getName_show(), ThreadUserInfoLayout.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axr != null) {
                        ThreadUserInfoLayout.this.axr.onClick(view);
                    }
                }
            }
        };
        this.ayf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atn.vm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aya = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.aye = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aU(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew() != null && w.c(ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.atn.vm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.atn.vm().getUserId()) && ThreadUserInfoLayout.this.atn.vr() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ba.aU(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ThreadUserInfoLayout.this.atn.wm() != null && ThreadUserInfoLayout.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.wm().channelId, ThreadUserInfoLayout.this.atn.wm().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.atn.vm().getUserId(), ThreadUserInfoLayout.this.atn.vm().getName_show(), ThreadUserInfoLayout.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.atn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (ThreadUserInfoLayout.this.axr != null) {
                        ThreadUserInfoLayout.this.axr.onClick(view);
                    }
                }
            }
        };
        this.ayf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.atn != null && ThreadUserInfoLayout.this.atn.vm() != null) {
                    com.baidu.tbadk.browser.a.a(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.atn.vm().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new am("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_user_info_layout, (ViewGroup) this, true);
        this.axn = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.axT = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_tshow_icon);
        this.axo = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.axU = (ImageView) inflate.findViewById(d.g.identity_view);
        this.axV = (UserIconBox) inflate.findViewById(d.g.card_home_page_normal_thread_user_icon);
        this.awA = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.axW = (TextView) inflate.findViewById(d.g.thread_info_address);
        this.axX = inflate.findViewById(d.g.divider);
        this.ayb = findViewById(d.g.divider_forum_name);
        this.ayc = (TextView) findViewById(d.g.thread_info_forum_name);
        this.axY = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_share_intro);
        this.axZ = (TextView) inflate.findViewById(d.g.thread_user_info_has_concern_lable);
        setGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.axT.setOnClickListener(this.aye);
        this.axo.setOnClickListener(this.axt);
        this.axV.setOnClickListener(this.ayf);
    }

    @Override // com.baidu.tbadk.core.view.b
    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.atn = bdVar;
        if (this.atn.ajN > 0) {
            if (this.atn.ajO == 0 && this.atn.vm() != null) {
                if (!w.z(this.atn.vm().getTShowInfoNew())) {
                    this.atn.vm().getTShowInfoNew().clear();
                }
                this.atn.vm().setName_show(getContext().getString(d.k.perfect_selection_video));
            }
            this.axT.setOnClickListener(null);
            this.axo.setOnClickListener(null);
            this.axV.setOnClickListener(null);
            this.axn.setClickable(false);
        } else {
            this.axT.setOnClickListener(this.aye);
            this.axo.setOnClickListener(this.axt);
            this.axV.setOnClickListener(this.ayf);
            this.axn.setClickable(true);
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
        if (this.axn != null) {
            this.axn.setDefaultResource(17170445);
            this.axn.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axn.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.axn.setIsRound(true);
            this.axn.setAfterClickListener(this.axr);
        }
    }

    private void h(bd bdVar) {
        if (this.axZ != null && bdVar != null && bdVar.vm() != null) {
            if (bdVar.vm().hadConcerned()) {
                this.axZ.setVisibility(0);
                al.h(this.axZ, d.C0141d.cp_cont_d);
                al.i(this.axZ, d.f.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.axZ.setVisibility(8);
        }
    }

    private void i(bd bdVar) {
        if (this.axT != null && bdVar != null && bdVar.vm() != null) {
            ArrayList<IconData> tShowInfoNew = bdVar.vm().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.axT.setVisibility(0);
                this.axT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.axT.setVisibility(8);
        }
    }

    private void j(bd bdVar) {
        if (this.axU != null && bdVar != null && bdVar.vm() != null) {
            MetaData vm = bdVar.vm();
            if (vm.getIs_bawu() == 1) {
                if ("manager".equals(vm.getBawu_type())) {
                    al.c(this.axU, d.f.icon_id_bazhu);
                    this.axU.setVisibility(0);
                    return;
                } else if ("assist".equals(vm.getBawu_type())) {
                    al.c(this.axU, d.f.icon_id_xiaobazhu);
                    this.axU.setVisibility(0);
                    return;
                } else {
                    this.axU.setVisibility(8);
                    return;
                }
            }
            this.axU.setVisibility(8);
        }
    }

    private void k(bd bdVar) {
        if (this.axo != null && bdVar != null) {
            if (!StringUtils.isNull(this.atn.vm().getName_show())) {
                this.axo.setText(fo(this.atn.vm().getName_show()));
            }
            AH();
            if (this.mFrom == 3) {
                String name_show = this.atn.vm().getName_show();
                String userName = this.atn.vm().getUserName();
                if (ah.ip() && name_show != null && !name_show.equals(userName)) {
                    this.axo.setText(com.baidu.tieba.pb.c.aj(this.mContext, this.axo.getText().toString()));
                    this.axo.setGravity(16);
                    this.axo.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aZW());
                    al.c(this.axo, d.C0141d.cp_other_e, 1);
                }
            }
        }
    }

    private void l(bd bdVar) {
        if (this.axV != null) {
            if (this.ayd) {
                this.axV.setVisibility(8);
            } else if (bdVar == null || bdVar.vm() == null || ((bdVar.ajN > 0 && bdVar.ajO == 0) || !this.aya)) {
                this.axV.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bdVar.vm().getIconInfo();
                if (w.y(iconInfo) != 0) {
                    this.axV.setVisibility(0);
                    this.axV.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                    return;
                }
                this.axV.setVisibility(8);
            }
        }
    }

    private void d(bd bdVar) {
        String v;
        if (this.awA != null && bdVar != null) {
            if (bdVar.vg() <= 0) {
                this.awA.setVisibility(4);
                return;
            }
            this.awA.setVisibility(0);
            if (this.mFrom == 2) {
                v = ao.u(bdVar.vg());
            } else if (bdVar.wn()) {
                v = ao.v(bdVar.getCreateTime());
            } else {
                v = ao.v(bdVar.vg() * 1000);
            }
            this.awA.setText(v);
        }
    }

    protected void m(bd bdVar) {
        if (this.axY == null || bdVar == null) {
            this.axY.setVisibility(8);
        } else if (this.ayd) {
            if (StringUtils.isNull(bdVar.vJ())) {
                this.axY.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axY.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.axY.setLayoutParams(layoutParams);
            }
            this.axY.setText(bdVar.vJ());
            this.axY.setVisibility(0);
        } else if (this.atn.vE() == null || this.atn.vE().share_info == null || this.atn.vE().share_info.share_user_count <= 0 || !this.atn.wq() || (this.atn.ajN > 0 && this.atn.ajO == 0)) {
            this.axY.setVisibility(8);
        } else {
            this.axY.setVisibility(0);
            int i = this.atn.vE().share_info.share_user_count;
            if (i == 1) {
                this.axY.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label_simple));
            } else {
                this.axY.setText(TbadkCoreApplication.getInst().getString(d.k.ala_live_share_live_label, new Object[]{ao.A(i)}));
            }
        }
    }

    private void n(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.getAddress())) {
            this.axW.setVisibility(8);
            this.axX.setVisibility(8);
            return;
        }
        this.axW.setText(this.atn.getAddress());
        this.axW.setVisibility(0);
        this.axX.setVisibility(0);
    }

    public void updateForumName(bd bdVar) {
        String str;
        if (bdVar == null || StringUtils.isNull(bdVar.vr()) || this.mFrom == 3) {
            this.ayc.setVisibility(8);
            this.ayb.setVisibility(8);
            return;
        }
        if (this.atn.ajN > 0 && this.atn.ajO == 0) {
            str = getContext().getString(d.k.select_video_list);
        } else {
            str = ao.e(this.atn.vr(), 12, "...") + getResources().getString(d.k.forum);
        }
        this.ayc.setText(str);
        this.ayc.setVisibility(0);
        this.ayb.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.b
    public void showForumNameView(boolean z) {
        if (z) {
            updateForumName(this.atn);
            return;
        }
        this.ayc.setVisibility(8);
        this.ayb.setVisibility(8);
    }

    private void o(bd bdVar) {
        if (this.axn != null && bdVar != null && this.atn.vm() != null) {
            if (this.atn.ajN > 0 && this.atn.ajO == 0) {
                this.axn.setShowV(false);
            } else {
                this.axn.setShowV(this.atn.vm().isBigV());
            }
        }
    }

    private void AH() {
        if (this.atn != null && this.atn.vm() != null) {
            if (this.atn.ajN > 0 && this.atn.ajO == 0) {
                al.h(this.axo, d.C0141d.cp_cont_f);
            } else if (!w.z(this.atn.vm().getTShowInfoNew()) || this.atn.vm().isBigV()) {
                al.h(this.axo, d.C0141d.cp_cont_h);
            } else {
                al.h(this.axo, d.C0141d.cp_cont_f);
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
        AH();
        al.h(this.axY, d.C0141d.cp_cont_f);
        al.h(this.awA, d.C0141d.cp_cont_d);
        al.j(this.axX, d.C0141d.cp_cont_e);
        al.h(this.axW, d.C0141d.cp_cont_d);
        al.h(this.ayc, d.C0141d.cp_cont_d);
        al.j(this.axX, d.C0141d.cp_cont_e);
        al.j(this.ayb, d.C0141d.cp_cont_e);
        j(this.atn);
    }

    public void setIsSimpleThread(boolean z) {
        this.axq = z;
    }

    @Override // com.baidu.tbadk.core.view.b
    public boolean getIsSimpleThread() {
        return this.axq;
    }

    @Override // com.baidu.tbadk.core.view.b
    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axr = onClickListener;
        if (this.axn != null) {
            this.axn.setAfterClickListener(this.axr);
        }
    }

    @Override // com.baidu.tbadk.core.view.b
    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axn != null) {
            this.axn.setPageId(bdUniqueId);
        }
    }

    @Override // com.baidu.tbadk.core.view.b
    public ClickableHeaderImageView getHeaderImg() {
        return this.axn;
    }

    @Override // com.baidu.tbadk.core.view.b
    public TextView getUserName() {
        return this.axo;
    }

    protected String fo(String str) {
        return ao.e(str, 14, "...");
    }

    public boolean isTShowVisible() {
        return this.aya;
    }

    public void setTShowVisible(boolean z) {
        this.aya = z;
    }

    public void setIsFromConcern(boolean z) {
        this.ayd = z;
    }
}

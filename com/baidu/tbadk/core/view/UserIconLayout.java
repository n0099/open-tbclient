package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bj ajF;
    private UserIconBox aoS;
    private UserIconBox aoT;
    private View aoW;
    private View.OnClickListener aoY;
    private View.OnClickListener aoZ;
    private View.OnClickListener aow;
    private View.OnClickListener aoy;
    public TextView apl;
    private ImageView apm;
    public boolean apn;
    public boolean apo;
    private boolean apq;
    private int apr;
    private boolean aps;
    private View.OnClickListener apt;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apn = false;
        this.apo = false;
        this.apq = false;
        this.apr = 0;
        this.aps = false;
        this.aoZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajF.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apr == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null && UserIconLayout.this.ajF.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajF.getAuthor().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.X(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.X(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajF.getAuthor().getUserId()) && UserIconLayout.this.ajF.rG() != null) {
                    if (UserIconLayout.this.ajF.sF() != null && UserIconLayout.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.sF().channelId, UserIconLayout.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.getAuthor().getUserId(), UserIconLayout.this.ajF.getAuthor().getName_show(), UserIconLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aow != null) {
                        UserIconLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.sF() != null && UserIconLayout.this.ajF.sF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.sF().channelId, UserIconLayout.this.ajF.sF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apn = false;
        this.apo = false;
        this.apq = false;
        this.apr = 0;
        this.aps = false;
        this.aoZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajF.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apr == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null && UserIconLayout.this.ajF.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajF.getAuthor().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.X(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.X(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajF.getAuthor().getUserId()) && UserIconLayout.this.ajF.rG() != null) {
                    if (UserIconLayout.this.ajF.sF() != null && UserIconLayout.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.sF().channelId, UserIconLayout.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.getAuthor().getUserId(), UserIconLayout.this.ajF.getAuthor().getName_show(), UserIconLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aow != null) {
                        UserIconLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajF != null && UserIconLayout.this.ajF.sF() != null && UserIconLayout.this.ajF.sF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajF.sF().channelId, UserIconLayout.this.ajF.sF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.apl.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.aps = z;
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        layoutParams3.gravity = 16;
        layoutParams4.gravity = 16;
        this.aoS = new UserIconBox(this.mContext);
        this.aoT = new UserIconBox(this.mContext);
        this.apl = new TextView(this.mContext);
        this.aoW = com.baidu.tbadk.ala.b.nw().i(this.mContext, 1);
        if (this.aoW != null) {
            this.aoW.setVisibility(8);
        }
        this.apm = new ImageView(this.mContext);
        if (this.apm != null) {
            this.apm.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds3), 0, 0);
        this.apl.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.fontsize24));
        if (!this.apq) {
            this.apl.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aoS.setLayoutParams(layoutParams);
        this.aoT.setLayoutParams(layoutParams2);
        this.apl.setLayoutParams(layoutParams3);
        this.apm.setLayoutParams(layoutParams4);
        addView(this.aoS);
        addView(this.apl);
        if (this.apm != null) {
            addView(this.apm);
        }
        if (this.aoW != null) {
            addView(this.aoW);
        }
        addView(this.aoT);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ajF = bjVar;
            this.aoS.setOnClickListener(this.aoY);
            this.aoT.setOnClickListener(this.aoZ);
            this.apl.setOnClickListener(this.aoy);
            this.apm.setOnClickListener(this.apt);
            if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                if (this.aoW != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qs = alaUserData;
                    aVar.type = 1;
                    this.aoW.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aoW.setVisibility(8);
                    } else {
                        this.aoW.setVisibility(0);
                    }
                }
            }
            int i2 = 3;
            if (this.ajF.sF() != null && this.ajF.sF().channelId > 0) {
                this.apl.setText(com.baidu.tbadk.util.v.u(this.ajF.sF().channelName, 20));
                this.aoT.setVisibility(8);
                this.aoS.setVisibility(8);
                if (this.apo) {
                    this.apm.setVisibility(0);
                } else {
                    this.apm.setVisibility(8);
                }
                aj.i(this.apl, d.e.cp_cont_b);
                return;
            }
            this.apm.setVisibility(8);
            if (StringUtils.isNull(this.ajF.getAuthor().getName_show())) {
                this.apl.setVisibility(8);
                i = 3;
            } else {
                this.apl.setVisibility(0);
                String name_show = this.ajF.getAuthor().getName_show();
                if (this.apq) {
                    if (this.aps) {
                        this.apl.setText(ah(this.ajF.getAuthor().getSealPrefix(), com.baidu.tbadk.util.v.u(name_show, 20)));
                        int aP = com.baidu.adp.lib.util.j.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.apl.setText(com.baidu.tbadk.util.v.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.aps) {
                    this.apl.setText(ah(this.ajF.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.apl.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.getAuthor().getIconInfo();
            if (this.apn && v.u(iconInfo) != 0) {
                this.aoT.setVisibility(0);
                this.aoT.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.aoT.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoS.setVisibility(0);
                this.aoS.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.aoS.setVisibility(8);
            }
            setUserTextColor(bjVar);
        }
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bj bjVar) {
        if (this.ajF != null && this.ajF.getAuthor() != null) {
            if (!v.v(this.ajF.getAuthor().getTShowInfoNew()) || this.ajF.getAuthor().isBigV()) {
                aj.i(this.apl, d.e.cp_cont_h);
                if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                    if (this.aoW != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
                        this.aoS.setLayoutParams(layoutParams);
                        this.aoT.setLayoutParams(layoutParams2);
                        this.apl.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            aj.i(this.apl, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajF);
        if (this.ajF != null && this.ajF.sF() != null && this.ajF.sF().channelId > 0) {
            aj.i(this.apl, d.e.cp_cont_b);
        }
        if (this.apm != null) {
            aj.j(this.apm, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aow = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apq = z;
    }

    public void setPageName(int i) {
        this.apr = i;
    }
}

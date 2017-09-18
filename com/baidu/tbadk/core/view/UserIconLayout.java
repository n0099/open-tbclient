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
    private bj ajE;
    private UserIconBox aoQ;
    private UserIconBox aoR;
    private View aoU;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    private View.OnClickListener aou;
    private View.OnClickListener aow;
    public TextView apj;
    private ImageView apk;
    public boolean apl;
    public boolean apm;
    private boolean apn;
    private int apo;
    private boolean apq;
    private View.OnClickListener apr;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apl = false;
        this.apm = false;
        this.apn = false;
        this.apo = 0;
        this.apq = false;
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajE.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apo == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(UserIconLayout.this.mContext) && UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null && UserIconLayout.this.ajE.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajE.getAuthor().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajE.getAuthor().getUserId()) && UserIconLayout.this.ajE.rG() != null) {
                    if (UserIconLayout.this.ajE.sF() != null && UserIconLayout.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.sF().channelId, UserIconLayout.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.getAuthor().getUserId(), UserIconLayout.this.ajE.getAuthor().getName_show(), UserIconLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aou != null) {
                        UserIconLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        this.apr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.sF() != null && UserIconLayout.this.ajE.sF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.sF().channelId, UserIconLayout.this.ajE.sF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apl = false;
        this.apm = false;
        this.apn = false;
        this.apo = 0;
        this.apq = false;
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajE.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apo == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(UserIconLayout.this.mContext) && UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null && UserIconLayout.this.ajE.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajE.getAuthor().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajE.getAuthor().getUserId()) && UserIconLayout.this.ajE.rG() != null) {
                    if (UserIconLayout.this.ajE.sF() != null && UserIconLayout.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.sF().channelId, UserIconLayout.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.getAuthor().getUserId(), UserIconLayout.this.ajE.getAuthor().getName_show(), UserIconLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aou != null) {
                        UserIconLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        this.apr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajE != null && UserIconLayout.this.ajE.sF() != null && UserIconLayout.this.ajE.sF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajE.sF().channelId, UserIconLayout.this.ajE.sF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.apj.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, i));
    }

    public void aP(boolean z) {
        this.apq = z;
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
        this.aoQ = new UserIconBox(this.mContext);
        this.aoR = new UserIconBox(this.mContext);
        this.apj = new TextView(this.mContext);
        this.aoU = com.baidu.tbadk.ala.b.nw().h(this.mContext, 1);
        if (this.aoU != null) {
            this.aoU.setVisibility(8);
        }
        this.apk = new ImageView(this.mContext);
        if (this.apk != null) {
            this.apk.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds8), com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds3), 0, 0);
        this.apj.setTextSize(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.fontsize24));
        if (!this.apn) {
            this.apj.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aoQ.setLayoutParams(layoutParams);
        this.aoR.setLayoutParams(layoutParams2);
        this.apj.setLayoutParams(layoutParams3);
        this.apk.setLayoutParams(layoutParams4);
        addView(this.aoQ);
        addView(this.apj);
        if (this.apk != null) {
            addView(this.apk);
        }
        if (this.aoU != null) {
            addView(this.aoU);
        }
        addView(this.aoR);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ajE = bjVar;
            this.aoQ.setOnClickListener(this.aoW);
            this.aoR.setOnClickListener(this.aoX);
            this.apj.setOnClickListener(this.aow);
            this.apk.setOnClickListener(this.apr);
            if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                if (this.aoU != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qs = alaUserData;
                    aVar.type = 1;
                    this.aoU.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aoU.setVisibility(8);
                    } else {
                        this.aoU.setVisibility(0);
                    }
                }
            }
            int i2 = 3;
            if (this.ajE.sF() != null && this.ajE.sF().channelId > 0) {
                this.apj.setText(com.baidu.tbadk.util.v.u(this.ajE.sF().channelName, 20));
                this.aoR.setVisibility(8);
                this.aoQ.setVisibility(8);
                if (this.apm) {
                    this.apk.setVisibility(0);
                } else {
                    this.apk.setVisibility(8);
                }
                aj.i(this.apj, d.e.cp_cont_b);
                return;
            }
            this.apk.setVisibility(8);
            if (StringUtils.isNull(this.ajE.getAuthor().getName_show())) {
                this.apj.setVisibility(8);
                i = 3;
            } else {
                this.apj.setVisibility(0);
                String name_show = this.ajE.getAuthor().getName_show();
                if (this.apn) {
                    if (this.apq) {
                        this.apj.setText(ah(this.ajE.getAuthor().getSealPrefix(), com.baidu.tbadk.util.v.u(name_show, 20)));
                        int aP = com.baidu.adp.lib.util.j.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.apj.setText(com.baidu.tbadk.util.v.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.apq) {
                    this.apj.setText(ah(this.ajE.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.apj.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.getAuthor().getIconInfo();
            if (this.apl && v.u(iconInfo) != 0) {
                this.aoR.setVisibility(0);
                this.aoR.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.aoR.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoQ.setVisibility(0);
                this.aoQ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.aoQ.setVisibility(8);
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
        if (this.ajE != null && this.ajE.getAuthor() != null) {
            if (!v.v(this.ajE.getAuthor().getTShowInfoNew()) || this.ajE.getAuthor().isBigV()) {
                aj.i(this.apj, d.e.cp_cont_h);
                if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                    if (this.aoU != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds2), 0, 0);
                        this.aoQ.setLayoutParams(layoutParams);
                        this.aoR.setLayoutParams(layoutParams2);
                        this.apj.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            aj.i(this.apj, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajE);
        if (this.ajE != null && this.ajE.sF() != null && this.ajE.sF().channelId > 0) {
            aj.i(this.apj, d.e.cp_cont_b);
        }
        if (this.apk != null) {
            aj.j(this.apk, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aou = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apn = z;
    }

    public void setPageName(int i) {
        this.apo = i;
    }
}

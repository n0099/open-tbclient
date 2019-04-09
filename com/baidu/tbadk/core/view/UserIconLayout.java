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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bg XT;
    private UserIconBox ZB;
    private UserIconBox ZC;
    private View ZG;
    private View.OnClickListener ZI;
    private View.OnClickListener ZN;
    private View.OnClickListener ZO;
    private View.OnClickListener ZP;
    public TextView bUb;
    private ImageView bUc;
    public boolean bUd;
    public boolean bUe;
    private boolean bUf;
    private int bUg;
    private boolean bUh;
    private View.OnClickListener bUi;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bUd = false;
        this.bUe = false;
        this.bUf = false;
        this.bUg = 0;
        this.bUh = false;
        this.ZP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XT.YO().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUg == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null && UserIconLayout.this.XT.YO().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XT.YO().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XT.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null && !StringUtils.isNull(UserIconLayout.this.XT.YO().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XT.YO().getUserId()) && UserIconLayout.this.XT.YT() != null) {
                    if (UserIconLayout.this.XT.ZY() != null && UserIconLayout.this.XT.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.ZY().channelId, UserIconLayout.this.XT.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.YO().getUserId(), UserIconLayout.this.XT.YO().getName_show(), UserIconLayout.this.XT.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZI != null) {
                        UserIconLayout.this.ZI.onClick(view);
                    }
                }
            }
        };
        this.bUi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.ZY() != null && UserIconLayout.this.XT.ZY().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.ZY().channelId, UserIconLayout.this.XT.ZY().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUd = false;
        this.bUe = false;
        this.bUf = false;
        this.bUg = 0;
        this.bUh = false;
        this.ZP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XT.YO().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUg == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null && UserIconLayout.this.XT.YO().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XT.YO().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XT.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.YO() != null && !StringUtils.isNull(UserIconLayout.this.XT.YO().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XT.YO().getUserId()) && UserIconLayout.this.XT.YT() != null) {
                    if (UserIconLayout.this.XT.ZY() != null && UserIconLayout.this.XT.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.ZY().channelId, UserIconLayout.this.XT.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.YO().getUserId(), UserIconLayout.this.XT.YO().getName_show(), UserIconLayout.this.XT.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZI != null) {
                        UserIconLayout.this.ZI.onClick(view);
                    }
                }
            }
        };
        this.bUi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XT != null && UserIconLayout.this.XT.ZY() != null && UserIconLayout.this.XT.ZY().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XT.ZY().channelId, UserIconLayout.this.XT.ZY().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bUb.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.ZC = new UserIconBox(this.mContext);
        this.ZB = new UserIconBox(this.mContext);
        this.bUb = new TextView(this.mContext);
        this.ZG = com.baidu.tbadk.ala.b.UH().n(this.mContext, 1);
        if (this.ZG != null) {
            this.ZG.setVisibility(8);
        }
        this.bUc = new ImageView(this.mContext);
        if (this.bUc != null) {
            this.bUc.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds3), 0, 0);
        this.bUb.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
        if (!this.bUf) {
            this.bUb.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ZC.setLayoutParams(layoutParams);
        this.ZB.setLayoutParams(layoutParams2);
        this.bUb.setLayoutParams(layoutParams3);
        this.bUc.setLayoutParams(layoutParams4);
        addView(this.ZC);
        addView(this.bUb);
        if (this.bUc != null) {
            addView(this.bUc);
        }
        if (this.ZG != null) {
            addView(this.ZG);
        }
        addView(this.ZB);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.YO() != null) {
            this.XT = bgVar;
            this.ZC.setOnClickListener(this.ZN);
            this.ZB.setOnClickListener(this.ZP);
            this.bUb.setOnClickListener(this.ZO);
            this.bUc.setOnClickListener(this.bUi);
            if (bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YO().getAlaUserData();
                if (this.ZG != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsN = alaUserData;
                    aVar.type = 1;
                    this.ZG.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.XT.ZY() != null && this.XT.ZY().channelId > 0) {
                this.bUb.setText(ab.W(this.XT.ZY().channelName, 20));
                this.ZB.setVisibility(8);
                this.ZC.setVisibility(8);
                if (this.bUe) {
                    this.bUc.setVisibility(0);
                } else {
                    this.bUc.setVisibility(8);
                }
                al.j(this.bUb, d.C0277d.cp_cont_b);
                return;
            }
            this.bUc.setVisibility(8);
            if (StringUtils.isNull(this.XT.YO().getName_show())) {
                this.bUb.setVisibility(8);
                i = 4;
            } else {
                this.bUb.setVisibility(0);
                String name_show = this.XT.YO().getName_show();
                if (this.bUf) {
                    if (this.bUh) {
                        this.bUb.setText(bN(this.XT.YO().getSealPrefix(), ab.W(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bUb.setText(ab.W(name_show, 20));
                        i = 4;
                    }
                } else if (this.bUh) {
                    this.bUb.setText(bN(this.XT.YO().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bUb.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.YO().getIconInfo();
            if (this.bUd && v.S(iconInfo) != 0) {
                this.ZB.setVisibility(0);
                this.ZB.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.ZB.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.YO().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZC.setVisibility(0);
                this.ZC.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.ZC.setVisibility(8);
            }
            setUserTextColor(bgVar);
        }
    }

    private SpannableStringBuilder bN(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bg bgVar) {
        if (this.XT != null && this.XT.YO() != null) {
            if (!v.T(this.XT.YO().getTShowInfoNew()) || this.XT.YO().isBigV()) {
                al.j(this.bUb, d.C0277d.cp_cont_h);
                if (bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                    bgVar.YO().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.bUb, d.C0277d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZI = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bUf = z;
    }

    public void setPageName(int i) {
        this.bUg = i;
    }
}

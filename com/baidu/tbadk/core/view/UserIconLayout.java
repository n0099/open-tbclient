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
    private bg XS;
    private UserIconBox ZA;
    private UserIconBox ZB;
    private View ZF;
    private View.OnClickListener ZH;
    private View.OnClickListener ZM;
    private View.OnClickListener ZN;
    private View.OnClickListener ZO;
    public TextView bUa;
    private ImageView bUb;
    public boolean bUc;
    public boolean bUd;
    private boolean bUe;
    private int bUf;
    private boolean bUg;
    private View.OnClickListener bUh;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bUc = false;
        this.bUd = false;
        this.bUe = false;
        this.bUf = 0;
        this.bUg = false;
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XS.YO().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUf == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null && UserIconLayout.this.XS.YO().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XS.YO().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XS.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null && !StringUtils.isNull(UserIconLayout.this.XS.YO().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XS.YO().getUserId()) && UserIconLayout.this.XS.YT() != null) {
                    if (UserIconLayout.this.XS.ZY() != null && UserIconLayout.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.ZY().channelId, UserIconLayout.this.XS.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.YO().getUserId(), UserIconLayout.this.XS.YO().getName_show(), UserIconLayout.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZH != null) {
                        UserIconLayout.this.ZH.onClick(view);
                    }
                }
            }
        };
        this.bUh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.ZY() != null && UserIconLayout.this.XS.ZY().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.ZY().channelId, UserIconLayout.this.XS.ZY().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUc = false;
        this.bUd = false;
        this.bUe = false;
        this.bUf = 0;
        this.bUg = false;
        this.ZO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XS.YO().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUf == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null && UserIconLayout.this.XS.YO().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XS.YO().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XS.YO().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YO() != null && !StringUtils.isNull(UserIconLayout.this.XS.YO().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XS.YO().getUserId()) && UserIconLayout.this.XS.YT() != null) {
                    if (UserIconLayout.this.XS.ZY() != null && UserIconLayout.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.ZY().channelId, UserIconLayout.this.XS.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.YO().getUserId(), UserIconLayout.this.XS.YO().getName_show(), UserIconLayout.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZH != null) {
                        UserIconLayout.this.ZH.onClick(view);
                    }
                }
            }
        };
        this.bUh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.ZY() != null && UserIconLayout.this.XS.ZY().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.ZY().channelId, UserIconLayout.this.XS.ZY().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bUa.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.ZB = new UserIconBox(this.mContext);
        this.ZA = new UserIconBox(this.mContext);
        this.bUa = new TextView(this.mContext);
        this.ZF = com.baidu.tbadk.ala.b.UH().n(this.mContext, 1);
        if (this.ZF != null) {
            this.ZF.setVisibility(8);
        }
        this.bUb = new ImageView(this.mContext);
        if (this.bUb != null) {
            this.bUb.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds3), 0, 0);
        this.bUa.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
        if (!this.bUe) {
            this.bUa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ZB.setLayoutParams(layoutParams);
        this.ZA.setLayoutParams(layoutParams2);
        this.bUa.setLayoutParams(layoutParams3);
        this.bUb.setLayoutParams(layoutParams4);
        addView(this.ZB);
        addView(this.bUa);
        if (this.bUb != null) {
            addView(this.bUb);
        }
        if (this.ZF != null) {
            addView(this.ZF);
        }
        addView(this.ZA);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.YO() != null) {
            this.XS = bgVar;
            this.ZB.setOnClickListener(this.ZM);
            this.ZA.setOnClickListener(this.ZO);
            this.bUa.setOnClickListener(this.ZN);
            this.bUb.setOnClickListener(this.bUh);
            if (bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YO().getAlaUserData();
                if (this.ZF != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsM = alaUserData;
                    aVar.type = 1;
                    this.ZF.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.XS.ZY() != null && this.XS.ZY().channelId > 0) {
                this.bUa.setText(ab.W(this.XS.ZY().channelName, 20));
                this.ZA.setVisibility(8);
                this.ZB.setVisibility(8);
                if (this.bUd) {
                    this.bUb.setVisibility(0);
                } else {
                    this.bUb.setVisibility(8);
                }
                al.j(this.bUa, d.C0277d.cp_cont_b);
                return;
            }
            this.bUb.setVisibility(8);
            if (StringUtils.isNull(this.XS.YO().getName_show())) {
                this.bUa.setVisibility(8);
                i = 4;
            } else {
                this.bUa.setVisibility(0);
                String name_show = this.XS.YO().getName_show();
                if (this.bUe) {
                    if (this.bUg) {
                        this.bUa.setText(bN(this.XS.YO().getSealPrefix(), ab.W(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bUa.setText(ab.W(name_show, 20));
                        i = 4;
                    }
                } else if (this.bUg) {
                    this.bUa.setText(bN(this.XS.YO().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bUa.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.YO().getIconInfo();
            if (this.bUc && v.S(iconInfo) != 0) {
                this.ZA.setVisibility(0);
                this.ZA.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.ZA.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.YO().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZB.setVisibility(0);
                this.ZB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.ZB.setVisibility(8);
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
        if (this.XS != null && this.XS.YO() != null) {
            if (!v.T(this.XS.YO().getTShowInfoNew()) || this.XS.YO().isBigV()) {
                al.j(this.bUa, d.C0277d.cp_cont_h);
                if (bgVar.YO() != null && bgVar.YO().getAlaUserData() != null) {
                    bgVar.YO().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.bUa, d.C0277d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZH = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bUe = z;
    }

    public void setPageName(int i) {
        this.bUf = i;
    }
}

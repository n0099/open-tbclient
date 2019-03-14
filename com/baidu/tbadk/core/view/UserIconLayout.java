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
    private View ZE;
    private View.OnClickListener ZG;
    private View.OnClickListener ZL;
    private View.OnClickListener ZM;
    private View.OnClickListener ZN;
    public TextView bTY;
    private ImageView bTZ;
    public boolean bUa;
    public boolean bUb;
    private boolean bUc;
    private int bUd;
    private boolean bUe;
    private View.OnClickListener bUf;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bUa = false;
        this.bUb = false;
        this.bUc = false;
        this.bUd = 0;
        this.bUe = false;
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XS.YR().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUd == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null && UserIconLayout.this.XS.YR().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XS.YR().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XS.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null && !StringUtils.isNull(UserIconLayout.this.XS.YR().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XS.YR().getUserId()) && UserIconLayout.this.XS.YW() != null) {
                    if (UserIconLayout.this.XS.aab() != null && UserIconLayout.this.XS.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.aab().channelId, UserIconLayout.this.XS.aab().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.YR().getUserId(), UserIconLayout.this.XS.YR().getName_show(), UserIconLayout.this.XS.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZG != null) {
                        UserIconLayout.this.ZG.onClick(view);
                    }
                }
            }
        };
        this.bUf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.aab() != null && UserIconLayout.this.XS.aab().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.aab().channelId, UserIconLayout.this.XS.aab().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUa = false;
        this.bUb = false;
        this.bUc = false;
        this.bUd = 0;
        this.bUe = false;
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XS.YR().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUd == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null && UserIconLayout.this.XS.YR().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XS.YR().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XS.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.YR() != null && !StringUtils.isNull(UserIconLayout.this.XS.YR().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XS.YR().getUserId()) && UserIconLayout.this.XS.YW() != null) {
                    if (UserIconLayout.this.XS.aab() != null && UserIconLayout.this.XS.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.aab().channelId, UserIconLayout.this.XS.aab().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.YR().getUserId(), UserIconLayout.this.XS.YR().getName_show(), UserIconLayout.this.XS.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZG != null) {
                        UserIconLayout.this.ZG.onClick(view);
                    }
                }
            }
        };
        this.bUf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XS != null && UserIconLayout.this.XS.aab() != null && UserIconLayout.this.XS.aab().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XS.aab().channelId, UserIconLayout.this.XS.aab().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bTY.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.bTY = new TextView(this.mContext);
        this.ZE = com.baidu.tbadk.ala.b.UK().n(this.mContext, 1);
        if (this.ZE != null) {
            this.ZE.setVisibility(8);
        }
        this.bTZ = new ImageView(this.mContext);
        if (this.bTZ != null) {
            this.bTZ.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds3), 0, 0);
        this.bTY.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
        if (!this.bUc) {
            this.bTY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ZB.setLayoutParams(layoutParams);
        this.ZA.setLayoutParams(layoutParams2);
        this.bTY.setLayoutParams(layoutParams3);
        this.bTZ.setLayoutParams(layoutParams4);
        addView(this.ZB);
        addView(this.bTY);
        if (this.bTZ != null) {
            addView(this.bTZ);
        }
        if (this.ZE != null) {
            addView(this.ZE);
        }
        addView(this.ZA);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.YR() != null) {
            this.XS = bgVar;
            this.ZB.setOnClickListener(this.ZL);
            this.ZA.setOnClickListener(this.ZN);
            this.bTY.setOnClickListener(this.ZM);
            this.bTZ.setOnClickListener(this.bUf);
            if (bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YR().getAlaUserData();
                if (this.ZE != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsJ = alaUserData;
                    aVar.type = 1;
                    this.ZE.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.XS.aab() != null && this.XS.aab().channelId > 0) {
                this.bTY.setText(ab.W(this.XS.aab().channelName, 20));
                this.ZA.setVisibility(8);
                this.ZB.setVisibility(8);
                if (this.bUb) {
                    this.bTZ.setVisibility(0);
                } else {
                    this.bTZ.setVisibility(8);
                }
                al.j(this.bTY, d.C0277d.cp_cont_b);
                return;
            }
            this.bTZ.setVisibility(8);
            if (StringUtils.isNull(this.XS.YR().getName_show())) {
                this.bTY.setVisibility(8);
                i = 4;
            } else {
                this.bTY.setVisibility(0);
                String name_show = this.XS.YR().getName_show();
                if (this.bUc) {
                    if (this.bUe) {
                        this.bTY.setText(bN(this.XS.YR().getSealPrefix(), ab.W(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bTY.setText(ab.W(name_show, 20));
                        i = 4;
                    }
                } else if (this.bUe) {
                    this.bTY.setText(bN(this.XS.YR().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bTY.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.YR().getIconInfo();
            if (this.bUa && v.S(iconInfo) != 0) {
                this.ZA.setVisibility(0);
                this.ZA.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.ZA.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.YR().getTShowInfoNew();
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
        if (this.XS != null && this.XS.YR() != null) {
            if (!v.T(this.XS.YR().getTShowInfoNew()) || this.XS.YR().isBigV()) {
                al.j(this.bTY, d.C0277d.cp_cont_h);
                if (bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
                    bgVar.YR().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.bTY, d.C0277d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZG = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bUc = z;
    }

    public void setPageName(int i) {
        this.bUd = i;
    }
}

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
    private bg XR;
    private UserIconBox ZA;
    private View ZD;
    private View.OnClickListener ZF;
    private View.OnClickListener ZK;
    private View.OnClickListener ZL;
    private View.OnClickListener ZM;
    private UserIconBox Zz;
    public TextView bTX;
    private ImageView bTY;
    public boolean bTZ;
    public boolean bUa;
    private boolean bUb;
    private int bUc;
    private boolean bUd;
    private View.OnClickListener bUe;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bTZ = false;
        this.bUa = false;
        this.bUb = false;
        this.bUc = 0;
        this.bUd = false;
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XR.YR().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUc == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null && UserIconLayout.this.XR.YR().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XR.YR().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XR.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null && !StringUtils.isNull(UserIconLayout.this.XR.YR().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XR.YR().getUserId()) && UserIconLayout.this.XR.YW() != null) {
                    if (UserIconLayout.this.XR.aab() != null && UserIconLayout.this.XR.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.aab().channelId, UserIconLayout.this.XR.aab().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.YR().getUserId(), UserIconLayout.this.XR.YR().getName_show(), UserIconLayout.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZF != null) {
                        UserIconLayout.this.ZF.onClick(view);
                    }
                }
            }
        };
        this.bUe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.aab() != null && UserIconLayout.this.XR.aab().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.aab().channelId, UserIconLayout.this.XR.aab().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTZ = false;
        this.bUa = false;
        this.bUb = false;
        this.bUc = 0;
        this.bUd = false;
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.XR.YR().getUserId(), true, true, true);
                    if (UserIconLayout.this.bUc == 1) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                }
            }
        };
        this.ZK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(UserIconLayout.this.mContext) && UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null && UserIconLayout.this.XR.YR().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.XR.YR().getTShowInfoNew();
                    if (v.S(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.XR.YR().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.YR() != null && !StringUtils.isNull(UserIconLayout.this.XR.YR().getName_show()) && !StringUtils.isNull(UserIconLayout.this.XR.YR().getUserId()) && UserIconLayout.this.XR.YW() != null) {
                    if (UserIconLayout.this.XR.aab() != null && UserIconLayout.this.XR.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.aab().channelId, UserIconLayout.this.XR.aab().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.YR().getUserId(), UserIconLayout.this.XR.YR().getName_show(), UserIconLayout.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ZF != null) {
                        UserIconLayout.this.ZF.onClick(view);
                    }
                }
            }
        };
        this.bUe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.XR != null && UserIconLayout.this.XR.aab() != null && UserIconLayout.this.XR.aab().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.XR.aab().channelId, UserIconLayout.this.XR.aab().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bTX.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.ZA = new UserIconBox(this.mContext);
        this.Zz = new UserIconBox(this.mContext);
        this.bTX = new TextView(this.mContext);
        this.ZD = com.baidu.tbadk.ala.b.UK().n(this.mContext, 1);
        if (this.ZD != null) {
            this.ZD.setVisibility(8);
        }
        this.bTY = new ImageView(this.mContext);
        if (this.bTY != null) {
            this.bTY.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds3), 0, 0);
        this.bTX.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
        if (!this.bUb) {
            this.bTX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ZA.setLayoutParams(layoutParams);
        this.Zz.setLayoutParams(layoutParams2);
        this.bTX.setLayoutParams(layoutParams3);
        this.bTY.setLayoutParams(layoutParams4);
        addView(this.ZA);
        addView(this.bTX);
        if (this.bTY != null) {
            addView(this.bTY);
        }
        if (this.ZD != null) {
            addView(this.ZD);
        }
        addView(this.Zz);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.YR() != null) {
            this.XR = bgVar;
            this.ZA.setOnClickListener(this.ZK);
            this.Zz.setOnClickListener(this.ZM);
            this.bTX.setOnClickListener(this.ZL);
            this.bTY.setOnClickListener(this.bUe);
            if (bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.YR().getAlaUserData();
                if (this.ZD != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bsI = alaUserData;
                    aVar.type = 1;
                    this.ZD.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.XR.aab() != null && this.XR.aab().channelId > 0) {
                this.bTX.setText(ab.W(this.XR.aab().channelName, 20));
                this.Zz.setVisibility(8);
                this.ZA.setVisibility(8);
                if (this.bUa) {
                    this.bTY.setVisibility(0);
                } else {
                    this.bTY.setVisibility(8);
                }
                al.j(this.bTX, d.C0236d.cp_cont_b);
                return;
            }
            this.bTY.setVisibility(8);
            if (StringUtils.isNull(this.XR.YR().getName_show())) {
                this.bTX.setVisibility(8);
                i = 4;
            } else {
                this.bTX.setVisibility(0);
                String name_show = this.XR.YR().getName_show();
                if (this.bUb) {
                    if (this.bUd) {
                        this.bTX.setText(bN(this.XR.YR().getSealPrefix(), ab.W(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bTX.setText(ab.W(name_show, 20));
                        i = 4;
                    }
                } else if (this.bUd) {
                    this.bTX.setText(bN(this.XR.YR().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bTX.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.YR().getIconInfo();
            if (this.bTZ && v.S(iconInfo) != 0) {
                this.Zz.setVisibility(0);
                this.Zz.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.Zz.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.YR().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZA.setVisibility(0);
                this.ZA.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.ZA.setVisibility(8);
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
        if (this.XR != null && this.XR.YR() != null) {
            if (!v.T(this.XR.YR().getTShowInfoNew()) || this.XR.YR().isBigV()) {
                al.j(this.bTX, d.C0236d.cp_cont_h);
                if (bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
                    bgVar.YR().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.bTX, d.C0236d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bUb = z;
    }

    public void setPageName(int i) {
        this.bUc = i;
    }
}

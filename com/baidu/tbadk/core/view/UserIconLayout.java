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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bb aFI;
    private UserIconBox aKS;
    private UserIconBox aKV;
    public boolean aLA;
    private boolean aLB;
    private int aLC;
    private boolean aLD;
    private View.OnClickListener aLE;
    private View aLa;
    private View.OnClickListener aLe;
    private View.OnClickListener aLh;
    private View.OnClickListener aLi;
    private View.OnClickListener aLj;
    public TextView aLx;
    private ImageView aLy;
    public boolean aLz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aLz = false;
        this.aLA = false;
        this.aLB = false;
        this.aLC = 0;
        this.aLD = false;
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFI.zT().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLC == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        this.aLh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null && UserIconLayout.this.aFI.zT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFI.zT().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFI.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null && !StringUtils.isNull(UserIconLayout.this.aFI.zT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFI.zT().getUserId()) && UserIconLayout.this.aFI.zZ() != null) {
                    if (UserIconLayout.this.aFI.AW() != null && UserIconLayout.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.AW().channelId, UserIconLayout.this.aFI.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.zT().getUserId(), UserIconLayout.this.aFI.zT().getName_show(), UserIconLayout.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aLe != null) {
                        UserIconLayout.this.aLe.onClick(view);
                    }
                }
            }
        };
        this.aLE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.AW() != null && UserIconLayout.this.aFI.AW().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.AW().channelId, UserIconLayout.this.aFI.AW().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLz = false;
        this.aLA = false;
        this.aLB = false;
        this.aLC = 0;
        this.aLD = false;
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFI.zT().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLC == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        this.aLh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null && UserIconLayout.this.aFI.zT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFI.zT().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFI.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.zT() != null && !StringUtils.isNull(UserIconLayout.this.aFI.zT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFI.zT().getUserId()) && UserIconLayout.this.aFI.zZ() != null) {
                    if (UserIconLayout.this.aFI.AW() != null && UserIconLayout.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.AW().channelId, UserIconLayout.this.aFI.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.zT().getUserId(), UserIconLayout.this.aFI.zT().getName_show(), UserIconLayout.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aLe != null) {
                        UserIconLayout.this.aLe.onClick(view);
                    }
                }
            }
        };
        this.aLE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFI != null && UserIconLayout.this.aFI.AW() != null && UserIconLayout.this.aFI.AW().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFI.AW().channelId, UserIconLayout.this.aFI.AW().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aLx.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aKS = new UserIconBox(this.mContext);
        this.aKV = new UserIconBox(this.mContext);
        this.aLx = new TextView(this.mContext);
        this.aLa = com.baidu.tbadk.ala.b.wg().j(this.mContext, 1);
        if (this.aLa != null) {
            this.aLa.setVisibility(8);
        }
        this.aLy = new ImageView(this.mContext);
        if (this.aLy != null) {
            this.aLy.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds3), 0, 0);
        this.aLx.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.fontsize24));
        if (!this.aLB) {
            this.aLx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aKS.setLayoutParams(layoutParams);
        this.aKV.setLayoutParams(layoutParams2);
        this.aLx.setLayoutParams(layoutParams3);
        this.aLy.setLayoutParams(layoutParams4);
        addView(this.aKS);
        addView(this.aLx);
        if (this.aLy != null) {
            addView(this.aLy);
        }
        if (this.aLa != null) {
            addView(this.aLa);
        }
        addView(this.aKV);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.zT() != null) {
            this.aFI = bbVar;
            this.aKS.setOnClickListener(this.aLh);
            this.aKV.setOnClickListener(this.aLj);
            this.aLx.setOnClickListener(this.aLi);
            this.aLy.setOnClickListener(this.aLE);
            if (bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zT().getAlaUserData();
                if (this.aLa != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = alaUserData;
                    aVar.type = 1;
                    this.aLa.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aFI.AW() != null && this.aFI.AW().channelId > 0) {
                this.aLx.setText(z.B(this.aFI.AW().channelName, 20));
                this.aKV.setVisibility(8);
                this.aKS.setVisibility(8);
                if (this.aLA) {
                    this.aLy.setVisibility(0);
                } else {
                    this.aLy.setVisibility(8);
                }
                al.h(this.aLx, e.d.cp_cont_b);
                return;
            }
            this.aLy.setVisibility(8);
            if (StringUtils.isNull(this.aFI.zT().getName_show())) {
                this.aLx.setVisibility(8);
                i = 4;
            } else {
                this.aLx.setVisibility(0);
                String name_show = this.aFI.zT().getName_show();
                if (this.aLB) {
                    if (this.aLD) {
                        this.aLx.setText(aF(this.aFI.zT().getSealPrefix(), z.B(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aLx.setText(z.B(name_show, 20));
                        i = 4;
                    }
                } else if (this.aLD) {
                    this.aLx.setText(aF(this.aFI.zT().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aLx.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.zT().getIconInfo();
            if (this.aLz && v.H(iconInfo) != 0) {
                this.aKV.setVisibility(0);
                this.aKV.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10), true);
            } else {
                this.aKV.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.zT().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKS.setVisibility(0);
                this.aKS.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
            } else {
                this.aKS.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder aF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.aFI != null && this.aFI.zT() != null) {
            if (!v.I(this.aFI.zT().getTShowInfoNew()) || this.aFI.zT().isBigV()) {
                al.h(this.aLx, e.d.cp_cont_h);
                if (bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                    bbVar.zT().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aLx, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLe = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aLB = z;
    }

    public void setPageName(int i) {
        this.aLC = i;
    }
}

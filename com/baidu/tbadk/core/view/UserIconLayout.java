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
import com.baidu.tbadk.util.y;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bb aBF;
    private UserIconBox aGO;
    private UserIconBox aGR;
    private View aGW;
    private View.OnClickListener aHA;
    private View.OnClickListener aHa;
    private View.OnClickListener aHd;
    private View.OnClickListener aHe;
    private View.OnClickListener aHf;
    public TextView aHt;
    private ImageView aHu;
    public boolean aHv;
    public boolean aHw;
    private boolean aHx;
    private int aHy;
    private boolean aHz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aHv = false;
        this.aHw = false;
        this.aHx = false;
        this.aHy = 0;
        this.aHz = false;
        this.aHf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aBF.yC().getUserId(), true, true, true);
                    if (UserIconLayout.this.aHy == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aHd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bG(UserIconLayout.this.mContext) && UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null && UserIconLayout.this.aBF.yC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aBF.yC().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aBF.yC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aHe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null && !StringUtils.isNull(UserIconLayout.this.aBF.yC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aBF.yC().getUserId()) && UserIconLayout.this.aBF.yI() != null) {
                    if (UserIconLayout.this.aBF.zF() != null && UserIconLayout.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.zF().channelId, UserIconLayout.this.aBF.zF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.yC().getUserId(), UserIconLayout.this.aBF.yC().getName_show(), UserIconLayout.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aHa != null) {
                        UserIconLayout.this.aHa.onClick(view);
                    }
                }
            }
        };
        this.aHA = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.zF() != null && UserIconLayout.this.aBF.zF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.zF().channelId, UserIconLayout.this.aBF.zF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHv = false;
        this.aHw = false;
        this.aHx = false;
        this.aHy = 0;
        this.aHz = false;
        this.aHf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aBF.yC().getUserId(), true, true, true);
                    if (UserIconLayout.this.aHy == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aHd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bG(UserIconLayout.this.mContext) && UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null && UserIconLayout.this.aBF.yC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aBF.yC().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aBF.yC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aHe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.yC() != null && !StringUtils.isNull(UserIconLayout.this.aBF.yC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aBF.yC().getUserId()) && UserIconLayout.this.aBF.yI() != null) {
                    if (UserIconLayout.this.aBF.zF() != null && UserIconLayout.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.zF().channelId, UserIconLayout.this.aBF.zF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.yC().getUserId(), UserIconLayout.this.aBF.yC().getName_show(), UserIconLayout.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aHa != null) {
                        UserIconLayout.this.aHa.onClick(view);
                    }
                }
            }
        };
        this.aHA = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aBF != null && UserIconLayout.this.aBF.zF() != null && UserIconLayout.this.aBF.zF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aBF.zF().channelId, UserIconLayout.this.aBF.zF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aHt.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aGO = new UserIconBox(this.mContext);
        this.aGR = new UserIconBox(this.mContext);
        this.aHt = new TextView(this.mContext);
        this.aGW = com.baidu.tbadk.ala.b.uV().j(this.mContext, 1);
        if (this.aGW != null) {
            this.aGW.setVisibility(8);
        }
        this.aHu = new ImageView(this.mContext);
        if (this.aHu != null) {
            this.aHu.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds3), 0, 0);
        this.aHt.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.fontsize24));
        if (!this.aHx) {
            this.aHt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aGO.setLayoutParams(layoutParams);
        this.aGR.setLayoutParams(layoutParams2);
        this.aHt.setLayoutParams(layoutParams3);
        this.aHu.setLayoutParams(layoutParams4);
        addView(this.aGO);
        addView(this.aHt);
        if (this.aHu != null) {
            addView(this.aHu);
        }
        if (this.aGW != null) {
            addView(this.aGW);
        }
        addView(this.aGR);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.yC() != null) {
            this.aBF = bbVar;
            this.aGO.setOnClickListener(this.aHd);
            this.aGR.setOnClickListener(this.aHf);
            this.aHt.setOnClickListener(this.aHe);
            this.aHu.setOnClickListener(this.aHA);
            if (bbVar.yC() != null && bbVar.yC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.yC().getAlaUserData();
                if (this.aGW != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aig = alaUserData;
                    aVar.type = 1;
                    this.aGW.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aBF.zF() != null && this.aBF.zF().channelId > 0) {
                this.aHt.setText(y.A(this.aBF.zF().channelName, 20));
                this.aGR.setVisibility(8);
                this.aGO.setVisibility(8);
                if (this.aHw) {
                    this.aHu.setVisibility(0);
                } else {
                    this.aHu.setVisibility(8);
                }
                al.h(this.aHt, e.d.cp_cont_b);
                return;
            }
            this.aHu.setVisibility(8);
            if (StringUtils.isNull(this.aBF.yC().getName_show())) {
                this.aHt.setVisibility(8);
                i = 4;
            } else {
                this.aHt.setVisibility(0);
                String name_show = this.aBF.yC().getName_show();
                if (this.aHx) {
                    if (this.aHz) {
                        this.aHt.setText(aB(this.aBF.yC().getSealPrefix(), y.A(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aHt.setText(y.A(name_show, 20));
                        i = 4;
                    }
                } else if (this.aHz) {
                    this.aHt.setText(aB(this.aBF.yC().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aHt.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.yC().getIconInfo();
            if (this.aHv && v.H(iconInfo) != 0) {
                this.aGR.setVisibility(0);
                this.aGR.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds10), true);
            } else {
                this.aGR.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.yC().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aGO.setVisibility(0);
                this.aGO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds8), true);
            } else {
                this.aGO.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.aBF != null && this.aBF.yC() != null) {
            if (!v.I(this.aBF.yC().getTShowInfoNew()) || this.aBF.yC().isBigV()) {
                al.h(this.aHt, e.d.cp_cont_h);
                if (bbVar.yC() != null && bbVar.yC().getAlaUserData() != null) {
                    bbVar.yC().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aHt, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aHa = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aHx = z;
    }

    public void setPageName(int i) {
        this.aHy = i;
    }
}

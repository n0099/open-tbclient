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
    private bb aFJ;
    private UserIconBox aKT;
    private UserIconBox aKW;
    public boolean aLA;
    public boolean aLB;
    private boolean aLC;
    private int aLD;
    private boolean aLE;
    private View.OnClickListener aLF;
    private View aLb;
    private View.OnClickListener aLf;
    private View.OnClickListener aLi;
    private View.OnClickListener aLj;
    private View.OnClickListener aLk;
    public TextView aLy;
    private ImageView aLz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aLA = false;
        this.aLB = false;
        this.aLC = false;
        this.aLD = 0;
        this.aLE = false;
        this.aLk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFJ.zT().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLD == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null && UserIconLayout.this.aFJ.zT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFJ.zT().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFJ.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null && !StringUtils.isNull(UserIconLayout.this.aFJ.zT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFJ.zT().getUserId()) && UserIconLayout.this.aFJ.zZ() != null) {
                    if (UserIconLayout.this.aFJ.AW() != null && UserIconLayout.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.AW().channelId, UserIconLayout.this.aFJ.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.zT().getUserId(), UserIconLayout.this.aFJ.zT().getName_show(), UserIconLayout.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aLf != null) {
                        UserIconLayout.this.aLf.onClick(view);
                    }
                }
            }
        };
        this.aLF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.AW() != null && UserIconLayout.this.aFJ.AW().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.AW().channelId, UserIconLayout.this.aFJ.AW().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLA = false;
        this.aLB = false;
        this.aLC = false;
        this.aLD = 0;
        this.aLE = false;
        this.aLk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFJ.zT().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLD == 1) {
                        TiebaStatic.log(new am("c10134").y("obj_type", 3));
                    }
                }
            }
        };
        this.aLi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null && UserIconLayout.this.aFJ.zT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFJ.zT().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFJ.zT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aLj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.zT() != null && !StringUtils.isNull(UserIconLayout.this.aFJ.zT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFJ.zT().getUserId()) && UserIconLayout.this.aFJ.zZ() != null) {
                    if (UserIconLayout.this.aFJ.AW() != null && UserIconLayout.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.AW().channelId, UserIconLayout.this.aFJ.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.zT().getUserId(), UserIconLayout.this.aFJ.zT().getName_show(), UserIconLayout.this.aFJ.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aLf != null) {
                        UserIconLayout.this.aLf.onClick(view);
                    }
                }
            }
        };
        this.aLF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFJ != null && UserIconLayout.this.aFJ.AW() != null && UserIconLayout.this.aFJ.AW().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFJ.AW().channelId, UserIconLayout.this.aFJ.AW().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aLy.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aKT = new UserIconBox(this.mContext);
        this.aKW = new UserIconBox(this.mContext);
        this.aLy = new TextView(this.mContext);
        this.aLb = com.baidu.tbadk.ala.b.wg().j(this.mContext, 1);
        if (this.aLb != null) {
            this.aLb.setVisibility(8);
        }
        this.aLz = new ImageView(this.mContext);
        if (this.aLz != null) {
            this.aLz.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds3), 0, 0);
        this.aLy.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.fontsize24));
        if (!this.aLC) {
            this.aLy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aKT.setLayoutParams(layoutParams);
        this.aKW.setLayoutParams(layoutParams2);
        this.aLy.setLayoutParams(layoutParams3);
        this.aLz.setLayoutParams(layoutParams4);
        addView(this.aKT);
        addView(this.aLy);
        if (this.aLz != null) {
            addView(this.aLz);
        }
        if (this.aLb != null) {
            addView(this.aLb);
        }
        addView(this.aKW);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.zT() != null) {
            this.aFJ = bbVar;
            this.aKT.setOnClickListener(this.aLi);
            this.aKW.setOnClickListener(this.aLk);
            this.aLy.setOnClickListener(this.aLj);
            this.aLz.setOnClickListener(this.aLF);
            if (bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zT().getAlaUserData();
                if (this.aLb != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.amc = alaUserData;
                    aVar.type = 1;
                    this.aLb.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aFJ.AW() != null && this.aFJ.AW().channelId > 0) {
                this.aLy.setText(z.B(this.aFJ.AW().channelName, 20));
                this.aKW.setVisibility(8);
                this.aKT.setVisibility(8);
                if (this.aLB) {
                    this.aLz.setVisibility(0);
                } else {
                    this.aLz.setVisibility(8);
                }
                al.h(this.aLy, e.d.cp_cont_b);
                return;
            }
            this.aLz.setVisibility(8);
            if (StringUtils.isNull(this.aFJ.zT().getName_show())) {
                this.aLy.setVisibility(8);
                i = 4;
            } else {
                this.aLy.setVisibility(0);
                String name_show = this.aFJ.zT().getName_show();
                if (this.aLC) {
                    if (this.aLE) {
                        this.aLy.setText(aF(this.aFJ.zT().getSealPrefix(), z.B(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aLy.setText(z.B(name_show, 20));
                        i = 4;
                    }
                } else if (this.aLE) {
                    this.aLy.setText(aF(this.aFJ.zT().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aLy.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.zT().getIconInfo();
            if (this.aLA && v.H(iconInfo) != 0) {
                this.aKW.setVisibility(0);
                this.aKW.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10), true);
            } else {
                this.aKW.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.zT().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKT.setVisibility(0);
                this.aKT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
            } else {
                this.aKT.setVisibility(8);
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
        if (this.aFJ != null && this.aFJ.zT() != null) {
            if (!v.I(this.aFJ.zT().getTShowInfoNew()) || this.aFJ.zT().isBigV()) {
                al.h(this.aLy, e.d.cp_cont_h);
                if (bbVar.zT() != null && bbVar.zT().getAlaUserData() != null) {
                    bbVar.zT().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aLy, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aLf = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aLC = z;
    }

    public void setPageName(int i) {
        this.aLD = i;
    }
}

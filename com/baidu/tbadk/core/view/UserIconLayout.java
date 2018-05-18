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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bd alf;
    private UserIconBox apM;
    private UserIconBox apO;
    private View.OnClickListener apX;
    private View.OnClickListener apY;
    private View.OnClickListener apj;
    private View.OnClickListener apl;
    public TextView aqm;
    private View aqn;
    private ImageView aqo;
    public boolean aqp;
    public boolean aqq;
    private boolean aqr;
    private int aqs;
    private boolean aqt;
    private View.OnClickListener aqu;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aqp = false;
        this.aqq = false;
        this.aqr = false;
        this.aqs = 0;
        this.aqt = false;
        this.apY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.alf.rP().getUserId(), true, true, true);
                    if (UserIconLayout.this.aqs == 1) {
                        TiebaStatic.log(new al("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                if (az.aK(UserIconLayout.this.mContext) && UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null && UserIconLayout.this.alf.rP().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.alf.rP().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.alf.rP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null && !StringUtils.isNull(UserIconLayout.this.alf.rP().getName_show()) && !StringUtils.isNull(UserIconLayout.this.alf.rP().getUserId()) && UserIconLayout.this.alf.rU() != null) {
                    if (UserIconLayout.this.alf.sP() != null && UserIconLayout.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.sP().channelId, UserIconLayout.this.alf.sP().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.rP().getUserId(), UserIconLayout.this.alf.rP().getName_show(), UserIconLayout.this.alf.rU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.apj != null) {
                        UserIconLayout.this.apj.onClick(view2);
                    }
                }
            }
        };
        this.aqu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.sP() != null && UserIconLayout.this.alf.sP().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.sP().channelId, UserIconLayout.this.alf.sP().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqp = false;
        this.aqq = false;
        this.aqr = false;
        this.aqs = 0;
        this.aqt = false;
        this.apY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.alf.rP().getUserId(), true, true, true);
                    if (UserIconLayout.this.aqs == 1) {
                        TiebaStatic.log(new al("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String url;
                if (az.aK(UserIconLayout.this.mContext) && UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null && UserIconLayout.this.alf.rP().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.alf.rP().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.alf.rP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.rP() != null && !StringUtils.isNull(UserIconLayout.this.alf.rP().getName_show()) && !StringUtils.isNull(UserIconLayout.this.alf.rP().getUserId()) && UserIconLayout.this.alf.rU() != null) {
                    if (UserIconLayout.this.alf.sP() != null && UserIconLayout.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.sP().channelId, UserIconLayout.this.alf.sP().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.rP().getUserId(), UserIconLayout.this.alf.rP().getName_show(), UserIconLayout.this.alf.rU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.apj != null) {
                        UserIconLayout.this.apj.onClick(view2);
                    }
                }
            }
        };
        this.aqu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (UserIconLayout.this.alf != null && UserIconLayout.this.alf.sP() != null && UserIconLayout.this.alf.sP().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.alf.sP().channelId, UserIconLayout.this.alf.sP().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aqm.setTextSize(0, l.e(this.mContext, i));
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
        this.apM = new UserIconBox(this.mContext);
        this.apO = new UserIconBox(this.mContext);
        this.aqm = new TextView(this.mContext);
        this.aqn = com.baidu.tbadk.ala.b.or().f(this.mContext, 1);
        if (this.aqn != null) {
            this.aqn.setVisibility(8);
        }
        this.aqo = new ImageView(this.mContext);
        if (this.aqo != null) {
            this.aqo.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.e(this.mContext, d.e.ds10), l.e(this.mContext, d.e.ds4));
        layoutParams2.setMargins(l.e(this.mContext, d.e.ds14), -l.e(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, l.e(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(l.e(this.mContext, d.e.ds8), l.e(this.mContext, d.e.ds3), 0, 0);
        this.aqm.setTextSize(0, l.e(this.mContext, d.e.fontsize24));
        if (!this.aqr) {
            this.aqm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.apM.setLayoutParams(layoutParams);
        this.apO.setLayoutParams(layoutParams2);
        this.aqm.setLayoutParams(layoutParams3);
        this.aqo.setLayoutParams(layoutParams4);
        addView(this.apM);
        addView(this.aqm);
        if (this.aqo != null) {
            addView(this.aqo);
        }
        if (this.aqn != null) {
            addView(this.aqn);
        }
        addView(this.apO);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.rP() != null) {
            this.alf = bdVar;
            this.apM.setOnClickListener(this.apX);
            this.apO.setOnClickListener(this.apY);
            this.aqm.setOnClickListener(this.apl);
            this.aqo.setOnClickListener(this.aqu);
            if (bdVar.rP() != null && bdVar.rP().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.rP().getAlaUserData();
                if (this.aqn != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Sa = alaUserData;
                    aVar.type = 1;
                    this.aqn.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.alf.sP() != null && this.alf.sP().channelId > 0) {
                this.aqm.setText(w.u(this.alf.sP().channelName, 20));
                this.apO.setVisibility(8);
                this.apM.setVisibility(8);
                if (this.aqq) {
                    this.aqo.setVisibility(0);
                } else {
                    this.aqo.setVisibility(8);
                }
                ak.h(this.aqm, d.C0126d.cp_cont_b);
                return;
            }
            this.aqo.setVisibility(8);
            if (StringUtils.isNull(this.alf.rP().getName_show())) {
                this.aqm.setVisibility(8);
                i = 4;
            } else {
                this.aqm.setVisibility(0);
                String name_show = this.alf.rP().getName_show();
                if (this.aqr) {
                    if (this.aqt) {
                        this.aqm.setText(ag(this.alf.rP().getSealPrefix(), w.u(name_show, 20)));
                        int aU = com.baidu.adp.lib.util.k.aU(name_show);
                        if (aU >= 20) {
                            i2 = 1;
                        } else if (aU >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aqm.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.aqt) {
                    this.aqm.setText(ag(this.alf.rP().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aqm.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.rP().getIconInfo();
            if (this.aqp && v.v(iconInfo) != 0) {
                this.apO.setVisibility(0);
                this.apO.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.apO.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.rP().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.apM.setVisibility(0);
                this.apM.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.apM.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.alf != null && this.alf.rP() != null) {
            if (!v.w(this.alf.rP().getTShowInfoNew()) || this.alf.rP().isBigV()) {
                ak.h(this.aqm, d.C0126d.cp_cont_h);
                if (bdVar.rP() != null && bdVar.rP().getAlaUserData() != null) {
                    bdVar.rP().getAlaUserData();
                    return;
                }
                return;
            }
            ak.h(this.aqm, d.C0126d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.apj = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aqr = z;
    }

    public void setPageName(int i) {
        this.aqs = i;
    }
}

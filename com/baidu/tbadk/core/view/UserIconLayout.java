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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bd aZA;
    private View.OnClickListener bdQ;
    private View.OnClickListener bdS;
    private View.OnClickListener beE;
    private View.OnClickListener beF;
    public TextView beT;
    private View beU;
    private ImageView beV;
    public boolean beW;
    public boolean beX;
    private boolean beY;
    private int beZ;
    private UserIconBox bes;
    private UserIconBox bev;
    private boolean bfa;
    private View.OnClickListener bfc;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.beW = false;
        this.beX = false;
        this.beY = false;
        this.beZ = 0;
        this.bfa = false;
        this.beF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZA.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.beZ == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null && UserIconLayout.this.aZA.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZA.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZA.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZA.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZA.zn().getUserId()) && UserIconLayout.this.aZA.zt() != null) {
                    if (UserIconLayout.this.aZA.Ao() != null && UserIconLayout.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.Ao().channelId, UserIconLayout.this.aZA.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.zn().getUserId(), UserIconLayout.this.aZA.zn().getName_show(), UserIconLayout.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bdQ != null) {
                        UserIconLayout.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.bfc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.Ao() != null && UserIconLayout.this.aZA.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.Ao().channelId, UserIconLayout.this.aZA.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beW = false;
        this.beX = false;
        this.beY = false;
        this.beZ = 0;
        this.bfa = false;
        this.beF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZA.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.beZ == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null && UserIconLayout.this.aZA.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZA.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZA.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZA.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZA.zn().getUserId()) && UserIconLayout.this.aZA.zt() != null) {
                    if (UserIconLayout.this.aZA.Ao() != null && UserIconLayout.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.Ao().channelId, UserIconLayout.this.aZA.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.zn().getUserId(), UserIconLayout.this.aZA.zn().getName_show(), UserIconLayout.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bdQ != null) {
                        UserIconLayout.this.bdQ.onClick(view);
                    }
                }
            }
        };
        this.bfc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZA != null && UserIconLayout.this.aZA.Ao() != null && UserIconLayout.this.aZA.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZA.Ao().channelId, UserIconLayout.this.aZA.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.beT.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void by(boolean z) {
        this.bfa = z;
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
        this.bes = new UserIconBox(this.mContext);
        this.bev = new UserIconBox(this.mContext);
        this.beT = new TextView(this.mContext);
        this.beU = com.baidu.tbadk.ala.b.vL().u(this.mContext, 1);
        if (this.beU != null) {
            this.beU.setVisibility(8);
        }
        this.beV = new ImageView(this.mContext);
        if (this.beV != null) {
            this.beV.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds3), 0, 0);
        this.beT.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.fontsize24));
        if (!this.beY) {
            this.beT.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.bes.setLayoutParams(layoutParams);
        this.bev.setLayoutParams(layoutParams2);
        this.beT.setLayoutParams(layoutParams3);
        this.beV.setLayoutParams(layoutParams4);
        addView(this.bes);
        addView(this.beT);
        if (this.beV != null) {
            addView(this.beV);
        }
        if (this.beU != null) {
            addView(this.beU);
        }
        addView(this.bev);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.zn() != null) {
            this.aZA = bdVar;
            this.bes.setOnClickListener(this.beE);
            this.bev.setOnClickListener(this.beF);
            this.beT.setOnClickListener(this.bdS);
            this.beV.setOnClickListener(this.bfc);
            if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.zn().getAlaUserData();
                if (this.beU != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aGT = alaUserData;
                    aVar.type = 1;
                    this.beU.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aZA.Ao() != null && this.aZA.Ao().channelId > 0) {
                this.beT.setText(w.u(this.aZA.Ao().channelName, 20));
                this.bev.setVisibility(8);
                this.bes.setVisibility(8);
                if (this.beX) {
                    this.beV.setVisibility(0);
                } else {
                    this.beV.setVisibility(8);
                }
                aj.r(this.beT, d.C0141d.cp_cont_b);
                return;
            }
            this.beV.setVisibility(8);
            if (StringUtils.isNull(this.aZA.zn().getName_show())) {
                this.beT.setVisibility(8);
                i = 4;
            } else {
                this.beT.setVisibility(0);
                String name_show = this.aZA.zn().getName_show();
                if (this.beY) {
                    if (this.bfa) {
                        this.beT.setText(af(this.aZA.zn().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.beT.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bfa) {
                    this.beT.setText(af(this.aZA.zn().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.beT.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
            if (this.beW && v.D(iconInfo) != 0) {
                this.bev.setVisibility(0);
                this.bev.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.bev.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bes.setVisibility(0);
                this.bes.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.bes.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.j.a(this.mContext, str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.aZA != null && this.aZA.zn() != null) {
            if (!v.E(this.aZA.zn().getTShowInfoNew()) || this.aZA.zn().isBigV()) {
                aj.r(this.beT, d.C0141d.cp_cont_h);
                if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                    bdVar.zn().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.beT, d.C0141d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aZA);
        if (this.aZA != null && this.aZA.Ao() != null && this.aZA.Ao().channelId > 0) {
            aj.r(this.beT, d.C0141d.cp_cont_b);
        }
        if (this.beV != null) {
            aj.s(this.beV, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdQ = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.beY = z;
    }

    public void setPageName(int i) {
        this.beZ = i;
    }
}

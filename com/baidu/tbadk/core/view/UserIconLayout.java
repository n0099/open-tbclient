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
    private bd aZC;
    private View.OnClickListener bdT;
    private View.OnClickListener bdV;
    private View.OnClickListener beH;
    private View.OnClickListener beI;
    public TextView beW;
    private View beX;
    private ImageView beY;
    public boolean beZ;
    private UserIconBox bew;
    private UserIconBox bey;
    public boolean bfa;
    private boolean bfc;
    private int bfd;
    private boolean bfe;
    private View.OnClickListener bff;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.beZ = false;
        this.bfa = false;
        this.bfc = false;
        this.bfd = 0;
        this.bfe = false;
        this.beI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZC.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.bfd == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null && UserIconLayout.this.aZC.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZC.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZC.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZC.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZC.zn().getUserId()) && UserIconLayout.this.aZC.zt() != null) {
                    if (UserIconLayout.this.aZC.Ao() != null && UserIconLayout.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.Ao().channelId, UserIconLayout.this.aZC.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.zn().getUserId(), UserIconLayout.this.aZC.zn().getName_show(), UserIconLayout.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bdT != null) {
                        UserIconLayout.this.bdT.onClick(view);
                    }
                }
            }
        };
        this.bff = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.Ao() != null && UserIconLayout.this.aZC.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.Ao().channelId, UserIconLayout.this.aZC.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beZ = false;
        this.bfa = false;
        this.bfc = false;
        this.bfd = 0;
        this.bfe = false;
        this.beI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZC.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.bfd == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null && UserIconLayout.this.aZC.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZC.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZC.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZC.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZC.zn().getUserId()) && UserIconLayout.this.aZC.zt() != null) {
                    if (UserIconLayout.this.aZC.Ao() != null && UserIconLayout.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.Ao().channelId, UserIconLayout.this.aZC.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.zn().getUserId(), UserIconLayout.this.aZC.zn().getName_show(), UserIconLayout.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bdT != null) {
                        UserIconLayout.this.bdT.onClick(view);
                    }
                }
            }
        };
        this.bff = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZC != null && UserIconLayout.this.aZC.Ao() != null && UserIconLayout.this.aZC.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZC.Ao().channelId, UserIconLayout.this.aZC.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.beW.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void by(boolean z) {
        this.bfe = z;
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
        this.bew = new UserIconBox(this.mContext);
        this.bey = new UserIconBox(this.mContext);
        this.beW = new TextView(this.mContext);
        this.beX = com.baidu.tbadk.ala.b.vL().u(this.mContext, 1);
        if (this.beX != null) {
            this.beX.setVisibility(8);
        }
        this.beY = new ImageView(this.mContext);
        if (this.beY != null) {
            this.beY.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds3), 0, 0);
        this.beW.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.fontsize24));
        if (!this.bfc) {
            this.beW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.bew.setLayoutParams(layoutParams);
        this.bey.setLayoutParams(layoutParams2);
        this.beW.setLayoutParams(layoutParams3);
        this.beY.setLayoutParams(layoutParams4);
        addView(this.bew);
        addView(this.beW);
        if (this.beY != null) {
            addView(this.beY);
        }
        if (this.beX != null) {
            addView(this.beX);
        }
        addView(this.bey);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.zn() != null) {
            this.aZC = bdVar;
            this.bew.setOnClickListener(this.beH);
            this.bey.setOnClickListener(this.beI);
            this.beW.setOnClickListener(this.bdV);
            this.beY.setOnClickListener(this.bff);
            if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.zn().getAlaUserData();
                if (this.beX != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aGU = alaUserData;
                    aVar.type = 1;
                    this.beX.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aZC.Ao() != null && this.aZC.Ao().channelId > 0) {
                this.beW.setText(w.u(this.aZC.Ao().channelName, 20));
                this.bey.setVisibility(8);
                this.bew.setVisibility(8);
                if (this.bfa) {
                    this.beY.setVisibility(0);
                } else {
                    this.beY.setVisibility(8);
                }
                aj.r(this.beW, d.C0141d.cp_cont_b);
                return;
            }
            this.beY.setVisibility(8);
            if (StringUtils.isNull(this.aZC.zn().getName_show())) {
                this.beW.setVisibility(8);
                i = 4;
            } else {
                this.beW.setVisibility(0);
                String name_show = this.aZC.zn().getName_show();
                if (this.bfc) {
                    if (this.bfe) {
                        this.beW.setText(af(this.aZC.zn().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.beW.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bfe) {
                    this.beW.setText(af(this.aZC.zn().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.beW.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
            if (this.beZ && v.D(iconInfo) != 0) {
                this.bey.setVisibility(0);
                this.bey.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true, bdVar.AC());
            } else {
                this.bey.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bew.setVisibility(0);
                this.bew.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true, bdVar.AC());
            } else {
                this.bew.setVisibility(8);
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
        if (this.aZC != null && this.aZC.zn() != null) {
            if (!v.E(this.aZC.zn().getTShowInfoNew()) || this.aZC.zn().isBigV()) {
                aj.r(this.beW, d.C0141d.cp_cont_h);
                if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                    bdVar.zn().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.beW, d.C0141d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aZC);
        if (this.aZC != null && this.aZC.Ao() != null && this.aZC.Ao().channelId > 0) {
            aj.r(this.beW, d.C0141d.cp_cont_b);
        }
        if (this.beY != null) {
            aj.s(this.beY, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bfc = z;
    }

    public void setPageName(int i) {
        this.bfd = i;
    }
}

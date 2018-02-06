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
    private bd aZM;
    private UserIconBox beF;
    private UserIconBox beH;
    private View.OnClickListener beQ;
    private View.OnClickListener beR;
    private View.OnClickListener bec;
    private View.OnClickListener bee;
    public TextView bfg;
    private View bfh;
    private ImageView bfi;
    public boolean bfj;
    public boolean bfk;
    private boolean bfl;
    private int bfm;
    private boolean bfn;
    private View.OnClickListener bfo;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bfj = false;
        this.bfk = false;
        this.bfl = false;
        this.bfm = 0;
        this.bfn = false;
        this.beR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZM.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.bfm == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null && UserIconLayout.this.aZM.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZM.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZM.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZM.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZM.zn().getUserId()) && UserIconLayout.this.aZM.zt() != null) {
                    if (UserIconLayout.this.aZM.Ao() != null && UserIconLayout.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.Ao().channelId, UserIconLayout.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.zn().getUserId(), UserIconLayout.this.aZM.zn().getName_show(), UserIconLayout.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bec != null) {
                        UserIconLayout.this.bec.onClick(view);
                    }
                }
            }
        };
        this.bfo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.Ao() != null && UserIconLayout.this.aZM.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.Ao().channelId, UserIconLayout.this.aZM.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfj = false;
        this.bfk = false;
        this.bfl = false;
        this.bfm = 0;
        this.bfn = false;
        this.beR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null) {
                    com.baidu.tbadk.browser.b.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aZM.zn().getUserId(), true, true, true);
                    if (UserIconLayout.this.bfm == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.beQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ay.ba(UserIconLayout.this.mContext) && UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null && UserIconLayout.this.aZM.zn().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aZM.zn().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aZM.zn().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.zn() != null && !StringUtils.isNull(UserIconLayout.this.aZM.zn().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aZM.zn().getUserId()) && UserIconLayout.this.aZM.zt() != null) {
                    if (UserIconLayout.this.aZM.Ao() != null && UserIconLayout.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.Ao().channelId, UserIconLayout.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.zn().getUserId(), UserIconLayout.this.aZM.zn().getName_show(), UserIconLayout.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bec != null) {
                        UserIconLayout.this.bec.onClick(view);
                    }
                }
            }
        };
        this.bfo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aZM != null && UserIconLayout.this.aZM.Ao() != null && UserIconLayout.this.aZM.Ao().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aZM.Ao().channelId, UserIconLayout.this.aZM.Ao().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bfg.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, i));
    }

    public void by(boolean z) {
        this.bfn = z;
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
        this.beF = new UserIconBox(this.mContext);
        this.beH = new UserIconBox(this.mContext);
        this.bfg = new TextView(this.mContext);
        this.bfh = com.baidu.tbadk.ala.b.vL().u(this.mContext, 1);
        if (this.bfh != null) {
            this.bfh.setVisibility(8);
        }
        this.bfi = new ImageView(this.mContext);
        if (this.bfi != null) {
            this.bfi.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds3), 0, 0);
        this.bfg.setTextSize(0, com.baidu.adp.lib.util.l.t(this.mContext, d.e.fontsize24));
        if (!this.bfl) {
            this.bfg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.beF.setLayoutParams(layoutParams);
        this.beH.setLayoutParams(layoutParams2);
        this.bfg.setLayoutParams(layoutParams3);
        this.bfi.setLayoutParams(layoutParams4);
        addView(this.beF);
        addView(this.bfg);
        if (this.bfi != null) {
            addView(this.bfi);
        }
        if (this.bfh != null) {
            addView(this.bfh);
        }
        addView(this.beH);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.zn() != null) {
            this.aZM = bdVar;
            this.beF.setOnClickListener(this.beQ);
            this.beH.setOnClickListener(this.beR);
            this.bfg.setOnClickListener(this.bee);
            this.bfi.setOnClickListener(this.bfo);
            if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.zn().getAlaUserData();
                if (this.bfh != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aHe = alaUserData;
                    aVar.type = 1;
                    this.bfh.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aZM.Ao() != null && this.aZM.Ao().channelId > 0) {
                this.bfg.setText(w.u(this.aZM.Ao().channelName, 20));
                this.beH.setVisibility(8);
                this.beF.setVisibility(8);
                if (this.bfk) {
                    this.bfi.setVisibility(0);
                } else {
                    this.bfi.setVisibility(8);
                }
                aj.r(this.bfg, d.C0140d.cp_cont_b);
                return;
            }
            this.bfi.setVisibility(8);
            if (StringUtils.isNull(this.aZM.zn().getName_show())) {
                this.bfg.setVisibility(8);
                i = 4;
            } else {
                this.bfg.setVisibility(0);
                String name_show = this.aZM.zn().getName_show();
                if (this.bfl) {
                    if (this.bfn) {
                        this.bfg.setText(af(this.aZM.zn().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bfg.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bfn) {
                    this.bfg.setText(af(this.aZM.zn().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bfg.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.zn().getIconInfo();
            if (this.bfj && v.D(iconInfo) != 0) {
                this.beH.setVisibility(0);
                this.beH.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.beH.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.zn().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.beF.setVisibility(0);
                this.beF.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.beF.setVisibility(8);
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
        if (this.aZM != null && this.aZM.zn() != null) {
            if (!v.E(this.aZM.zn().getTShowInfoNew()) || this.aZM.zn().isBigV()) {
                aj.r(this.bfg, d.C0140d.cp_cont_h);
                if (bdVar.zn() != null && bdVar.zn().getAlaUserData() != null) {
                    bdVar.zn().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.bfg, d.C0140d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aZM);
        if (this.aZM != null && this.aZM.Ao() != null && this.aZM.Ao().channelId > 0) {
            aj.r(this.bfg, d.C0140d.cp_cont_b);
        }
        if (this.bfi != null) {
            aj.s(this.bfi, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bec = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bfl = z;
    }

    public void setPageName(int i) {
        this.bfm = i;
    }
}

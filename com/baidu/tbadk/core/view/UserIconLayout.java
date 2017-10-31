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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh ajq;
    private View.OnClickListener anS;
    private View.OnClickListener anU;
    public TextView aoE;
    private ImageView aoF;
    public boolean aoG;
    public boolean aoH;
    private boolean aoI;
    private int aoJ;
    private boolean aoK;
    private View.OnClickListener aoL;
    private UserIconBox aoj;
    private UserIconBox aok;
    private View aoo;
    private View.OnClickListener aoq;
    private View.OnClickListener aor;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aoG = false;
        this.aoH = false;
        this.aoI = false;
        this.aoJ = 0;
        this.aoK = false;
        this.aor = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajq.rt().getUserId(), true, true, true);
                    if (UserIconLayout.this.aoJ == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null && UserIconLayout.this.ajq.rt().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajq.rt().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null && !StringUtils.isNull(UserIconLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajq.rt().getUserId()) && UserIconLayout.this.ajq.rz() != null) {
                    if (UserIconLayout.this.ajq.sz() != null && UserIconLayout.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.sz().channelId, UserIconLayout.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.rt().getUserId(), UserIconLayout.this.ajq.rt().getName_show(), UserIconLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anS != null) {
                        UserIconLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.sz() != null && UserIconLayout.this.ajq.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.sz().channelId, UserIconLayout.this.ajq.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoG = false;
        this.aoH = false;
        this.aoI = false;
        this.aoJ = 0;
        this.aoK = false;
        this.aor = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajq.rt().getUserId(), true, true, true);
                    if (UserIconLayout.this.aoJ == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null && UserIconLayout.this.ajq.rt().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajq.rt().getTShowInfoNew();
                    if (v.u(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.rt() != null && !StringUtils.isNull(UserIconLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajq.rt().getUserId()) && UserIconLayout.this.ajq.rz() != null) {
                    if (UserIconLayout.this.ajq.sz() != null && UserIconLayout.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.sz().channelId, UserIconLayout.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.rt().getUserId(), UserIconLayout.this.ajq.rt().getName_show(), UserIconLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anS != null) {
                        UserIconLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajq != null && UserIconLayout.this.ajq.sz() != null && UserIconLayout.this.ajq.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajq.sz().channelId, UserIconLayout.this.ajq.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aoE.setTextSize(0, l.f(this.mContext, i));
    }

    public void aL(boolean z) {
        this.aoK = z;
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
        this.aoj = new UserIconBox(this.mContext);
        this.aok = new UserIconBox(this.mContext);
        this.aoE = new TextView(this.mContext);
        this.aoo = com.baidu.tbadk.ala.b.nu().g(this.mContext, 1);
        if (this.aoo != null) {
            this.aoo.setVisibility(8);
        }
        this.aoF = new ImageView(this.mContext);
        if (this.aoF != null) {
            this.aoF.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.e.ds10), l.f(this.mContext, d.e.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.e.ds14), -l.f(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.e.ds8), l.f(this.mContext, d.e.ds3), 0, 0);
        this.aoE.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
        if (!this.aoI) {
            this.aoE.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aoj.setLayoutParams(layoutParams);
        this.aok.setLayoutParams(layoutParams2);
        this.aoE.setLayoutParams(layoutParams3);
        this.aoF.setLayoutParams(layoutParams4);
        addView(this.aoj);
        addView(this.aoE);
        if (this.aoF != null) {
            addView(this.aoF);
        }
        if (this.aoo != null) {
            addView(this.aoo);
        }
        addView(this.aok);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.rt() != null) {
            this.ajq = bhVar;
            this.aoj.setOnClickListener(this.aoq);
            this.aok.setOnClickListener(this.aor);
            this.aoE.setOnClickListener(this.anU);
            this.aoF.setOnClickListener(this.aoL);
            if (bhVar.rt() != null && bhVar.rt().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.rt().getAlaUserData();
                if (this.aoo != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.QK = alaUserData;
                    aVar.type = 1;
                    this.aoo.setTag(aVar);
                }
            }
            int i2 = 3;
            if (this.ajq.sz() != null && this.ajq.sz().channelId > 0) {
                this.aoE.setText(w.u(this.ajq.sz().channelName, 20));
                this.aok.setVisibility(8);
                this.aoj.setVisibility(8);
                if (this.aoH) {
                    this.aoF.setVisibility(0);
                } else {
                    this.aoF.setVisibility(8);
                }
                aj.i(this.aoE, d.C0080d.cp_cont_b);
                return;
            }
            this.aoF.setVisibility(8);
            if (StringUtils.isNull(this.ajq.rt().getName_show())) {
                this.aoE.setVisibility(8);
                i = 3;
            } else {
                this.aoE.setVisibility(0);
                String name_show = this.ajq.rt().getName_show();
                if (this.aoI) {
                    if (this.aoK) {
                        this.aoE.setText(ag(this.ajq.rt().getSealPrefix(), w.u(name_show, 20)));
                        int aP = k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aoE.setText(w.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.aoK) {
                    this.aoE.setText(ag(this.ajq.rt().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.aoE.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.rt().getIconInfo();
            if (this.aoG && v.u(iconInfo) != 0) {
                this.aok.setVisibility(0);
                this.aok.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.aok.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.rt().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoj.setVisibility(0);
                this.aoj.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.aoj.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.f.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.ajq != null && this.ajq.rt() != null) {
            if (!v.v(this.ajq.rt().getTShowInfoNew()) || this.ajq.rt().isBigV()) {
                aj.i(this.aoE, d.C0080d.cp_cont_h);
                if (bhVar.rt() != null && bhVar.rt().getAlaUserData() != null) {
                    bhVar.rt().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.aoE, d.C0080d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajq);
        if (this.ajq != null && this.ajq.sz() != null && this.ajq.sz().channelId > 0) {
            aj.i(this.aoE, d.C0080d.cp_cont_b);
        }
        if (this.aoF != null) {
            aj.j(this.aoF, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anS = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aoI = z;
    }

    public void setPageName(int i) {
        this.aoJ = i;
    }
}

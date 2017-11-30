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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bd ajM;
    private View.OnClickListener aoF;
    private View.OnClickListener aoG;
    public TextView aoU;
    private View aoV;
    private ImageView aoW;
    public boolean aoX;
    public boolean aoY;
    private boolean aoZ;
    private View.OnClickListener aob;
    private View.OnClickListener aod;
    private UserIconBox aov;
    private UserIconBox aow;
    private int apa;
    private boolean apb;
    private View.OnClickListener apc;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aoX = false;
        this.aoY = false;
        this.aoZ = false;
        this.apa = 0;
        this.apb = false;
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajM.rx().getUserId(), true, true, true);
                    if (UserIconLayout.this.apa == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aV(UserIconLayout.this.mContext) && UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null && UserIconLayout.this.ajM.rx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajM.rx().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajM.rx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null && !StringUtils.isNull(UserIconLayout.this.ajM.rx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajM.rx().getUserId()) && UserIconLayout.this.ajM.rD() != null) {
                    if (UserIconLayout.this.ajM.sC() != null && UserIconLayout.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sC().channelId, UserIconLayout.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.rx().getUserId(), UserIconLayout.this.ajM.rx().getName_show(), UserIconLayout.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aob != null) {
                        UserIconLayout.this.aob.onClick(view);
                    }
                }
            }
        };
        this.apc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.sC() != null && UserIconLayout.this.ajM.sC().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sC().channelId, UserIconLayout.this.ajM.sC().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoX = false;
        this.aoY = false;
        this.aoZ = false;
        this.apa = 0;
        this.apb = false;
        this.aoG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajM.rx().getUserId(), true, true, true);
                    if (UserIconLayout.this.apa == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aV(UserIconLayout.this.mContext) && UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null && UserIconLayout.this.ajM.rx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajM.rx().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajM.rx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rx() != null && !StringUtils.isNull(UserIconLayout.this.ajM.rx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajM.rx().getUserId()) && UserIconLayout.this.ajM.rD() != null) {
                    if (UserIconLayout.this.ajM.sC() != null && UserIconLayout.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sC().channelId, UserIconLayout.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.rx().getUserId(), UserIconLayout.this.ajM.rx().getName_show(), UserIconLayout.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aob != null) {
                        UserIconLayout.this.aob.onClick(view);
                    }
                }
            }
        };
        this.apc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.sC() != null && UserIconLayout.this.ajM.sC().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sC().channelId, UserIconLayout.this.ajM.sC().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aoU.setTextSize(0, l.f(this.mContext, i));
    }

    public void aL(boolean z) {
        this.apb = z;
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
        this.aov = new UserIconBox(this.mContext);
        this.aow = new UserIconBox(this.mContext);
        this.aoU = new TextView(this.mContext);
        this.aoV = com.baidu.tbadk.ala.b.ny().g(this.mContext, 1);
        if (this.aoV != null) {
            this.aoV.setVisibility(8);
        }
        this.aoW = new ImageView(this.mContext);
        if (this.aoW != null) {
            this.aoW.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.e.ds10), l.f(this.mContext, d.e.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.e.ds14), -l.f(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.e.ds8), l.f(this.mContext, d.e.ds3), 0, 0);
        this.aoU.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
        if (!this.aoZ) {
            this.aoU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aov.setLayoutParams(layoutParams);
        this.aow.setLayoutParams(layoutParams2);
        this.aoU.setLayoutParams(layoutParams3);
        this.aoW.setLayoutParams(layoutParams4);
        addView(this.aov);
        addView(this.aoU);
        if (this.aoW != null) {
            addView(this.aoW);
        }
        if (this.aoV != null) {
            addView(this.aoV);
        }
        addView(this.aow);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.rx() != null) {
            this.ajM = bdVar;
            this.aov.setOnClickListener(this.aoF);
            this.aow.setOnClickListener(this.aoG);
            this.aoU.setOnClickListener(this.aod);
            this.aoW.setOnClickListener(this.apc);
            if (bdVar.rx() != null && bdVar.rx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.rx().getAlaUserData();
                if (this.aoV != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rd = alaUserData;
                    aVar.type = 1;
                    this.aoV.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.ajM.sC() != null && this.ajM.sC().channelId > 0) {
                this.aoU.setText(w.u(this.ajM.sC().channelName, 20));
                this.aow.setVisibility(8);
                this.aov.setVisibility(8);
                if (this.aoY) {
                    this.aoW.setVisibility(0);
                } else {
                    this.aoW.setVisibility(8);
                }
                aj.i(this.aoU, d.C0082d.cp_cont_b);
                return;
            }
            this.aoW.setVisibility(8);
            if (StringUtils.isNull(this.ajM.rx().getName_show())) {
                this.aoU.setVisibility(8);
                i = 4;
            } else {
                this.aoU.setVisibility(0);
                String name_show = this.ajM.rx().getName_show();
                if (this.aoZ) {
                    if (this.apb) {
                        this.aoU.setText(ag(this.ajM.rx().getSealPrefix(), w.u(name_show, 20)));
                        int aP = k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aoU.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.apb) {
                    this.aoU.setText(ag(this.ajM.rx().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aoU.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.rx().getIconInfo();
            if (this.aoX && v.v(iconInfo) != 0) {
                this.aow.setVisibility(0);
                this.aow.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.aow.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.rx().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aov.setVisibility(0);
                this.aov.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.aov.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a(this.mContext, str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.ajM != null && this.ajM.rx() != null) {
            if (!v.w(this.ajM.rx().getTShowInfoNew()) || this.ajM.rx().isBigV()) {
                aj.i(this.aoU, d.C0082d.cp_cont_h);
                if (bdVar.rx() != null && bdVar.rx().getAlaUserData() != null) {
                    bdVar.rx().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.aoU, d.C0082d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajM);
        if (this.ajM != null && this.ajM.sC() != null && this.ajM.sC().channelId > 0) {
            aj.i(this.aoU, d.C0082d.cp_cont_b);
        }
        if (this.aoW != null) {
            aj.j(this.aoW, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aob = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aoZ = z;
    }

    public void setPageName(int i) {
        this.apa = i;
    }
}

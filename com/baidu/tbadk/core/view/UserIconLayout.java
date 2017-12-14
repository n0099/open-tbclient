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
    private bd ajJ;
    private View.OnClickListener aoI;
    private View.OnClickListener aoJ;
    public TextView aoX;
    private View aoY;
    private ImageView aoZ;
    private View.OnClickListener aod;
    private View.OnClickListener aof;
    private UserIconBox aox;
    private UserIconBox aoz;
    public boolean apa;
    public boolean apb;
    private boolean apc;
    private int apd;
    private boolean ape;
    private View.OnClickListener apf;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apa = false;
        this.apb = false;
        this.apc = false;
        this.apd = 0;
        this.ape = false;
        this.aoJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajJ.rv().getUserId(), true, true, true);
                    if (UserIconLayout.this.apd == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(UserIconLayout.this.mContext) && UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null && UserIconLayout.this.ajJ.rv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajJ.rv().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajJ.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null && !StringUtils.isNull(UserIconLayout.this.ajJ.rv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajJ.rv().getUserId()) && UserIconLayout.this.ajJ.rB() != null) {
                    if (UserIconLayout.this.ajJ.sA() != null && UserIconLayout.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.sA().channelId, UserIconLayout.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.rv().getUserId(), UserIconLayout.this.ajJ.rv().getName_show(), UserIconLayout.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aod != null) {
                        UserIconLayout.this.aod.onClick(view);
                    }
                }
            }
        };
        this.apf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.sA() != null && UserIconLayout.this.ajJ.sA().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.sA().channelId, UserIconLayout.this.ajJ.sA().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apa = false;
        this.apb = false;
        this.apc = false;
        this.apd = 0;
        this.ape = false;
        this.aoJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajJ.rv().getUserId(), true, true, true);
                    if (UserIconLayout.this.apd == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(UserIconLayout.this.mContext) && UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null && UserIconLayout.this.ajJ.rv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajJ.rv().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajJ.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.rv() != null && !StringUtils.isNull(UserIconLayout.this.ajJ.rv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajJ.rv().getUserId()) && UserIconLayout.this.ajJ.rB() != null) {
                    if (UserIconLayout.this.ajJ.sA() != null && UserIconLayout.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.sA().channelId, UserIconLayout.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.rv().getUserId(), UserIconLayout.this.ajJ.rv().getName_show(), UserIconLayout.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aod != null) {
                        UserIconLayout.this.aod.onClick(view);
                    }
                }
            }
        };
        this.apf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajJ != null && UserIconLayout.this.ajJ.sA() != null && UserIconLayout.this.ajJ.sA().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajJ.sA().channelId, UserIconLayout.this.ajJ.sA().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aoX.setTextSize(0, l.f(this.mContext, i));
    }

    public void aM(boolean z) {
        this.ape = z;
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
        this.aox = new UserIconBox(this.mContext);
        this.aoz = new UserIconBox(this.mContext);
        this.aoX = new TextView(this.mContext);
        this.aoY = com.baidu.tbadk.ala.b.nv().g(this.mContext, 1);
        if (this.aoY != null) {
            this.aoY.setVisibility(8);
        }
        this.aoZ = new ImageView(this.mContext);
        if (this.aoZ != null) {
            this.aoZ.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.e.ds10), l.f(this.mContext, d.e.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.e.ds14), -l.f(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.e.ds8), l.f(this.mContext, d.e.ds3), 0, 0);
        this.aoX.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
        if (!this.apc) {
            this.aoX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aox.setLayoutParams(layoutParams);
        this.aoz.setLayoutParams(layoutParams2);
        this.aoX.setLayoutParams(layoutParams3);
        this.aoZ.setLayoutParams(layoutParams4);
        addView(this.aox);
        addView(this.aoX);
        if (this.aoZ != null) {
            addView(this.aoZ);
        }
        if (this.aoY != null) {
            addView(this.aoY);
        }
        addView(this.aoz);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.rv() != null) {
            this.ajJ = bdVar;
            this.aox.setOnClickListener(this.aoI);
            this.aoz.setOnClickListener(this.aoJ);
            this.aoX.setOnClickListener(this.aof);
            this.aoZ.setOnClickListener(this.apf);
            if (bdVar.rv() != null && bdVar.rv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.rv().getAlaUserData();
                if (this.aoY != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rb = alaUserData;
                    aVar.type = 1;
                    this.aoY.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.ajJ.sA() != null && this.ajJ.sA().channelId > 0) {
                this.aoX.setText(w.u(this.ajJ.sA().channelName, 20));
                this.aoz.setVisibility(8);
                this.aox.setVisibility(8);
                if (this.apb) {
                    this.aoZ.setVisibility(0);
                } else {
                    this.aoZ.setVisibility(8);
                }
                aj.i(this.aoX, d.C0096d.cp_cont_b);
                return;
            }
            this.aoZ.setVisibility(8);
            if (StringUtils.isNull(this.ajJ.rv().getName_show())) {
                this.aoX.setVisibility(8);
                i = 4;
            } else {
                this.aoX.setVisibility(0);
                String name_show = this.ajJ.rv().getName_show();
                if (this.apc) {
                    if (this.ape) {
                        this.aoX.setText(ag(this.ajJ.rv().getSealPrefix(), w.u(name_show, 20)));
                        int aP = com.baidu.adp.lib.util.k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aoX.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.ape) {
                    this.aoX.setText(ag(this.ajJ.rv().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aoX.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.rv().getIconInfo();
            if (this.apa && v.v(iconInfo) != 0) {
                this.aoz.setVisibility(0);
                this.aoz.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.aoz.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.rv().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aox.setVisibility(0);
                this.aox.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.aox.setVisibility(8);
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
        if (this.ajJ != null && this.ajJ.rv() != null) {
            if (!v.w(this.ajJ.rv().getTShowInfoNew()) || this.ajJ.rv().isBigV()) {
                aj.i(this.aoX, d.C0096d.cp_cont_h);
                if (bdVar.rv() != null && bdVar.rv().getAlaUserData() != null) {
                    bdVar.rv().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.aoX, d.C0096d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajJ);
        if (this.ajJ != null && this.ajJ.sA() != null && this.ajJ.sA().channelId > 0) {
            aj.i(this.aoX, d.C0096d.cp_cont_b);
        }
        if (this.aoZ != null) {
            aj.j(this.aoZ, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aod = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apc = z;
    }

    public void setPageName(int i) {
        this.apd = i;
    }
}

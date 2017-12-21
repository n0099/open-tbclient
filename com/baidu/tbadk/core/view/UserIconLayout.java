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
    private bd ajM;
    private UserIconBox aoA;
    private UserIconBox aoC;
    private View.OnClickListener aoL;
    private View.OnClickListener aoM;
    private View.OnClickListener aog;
    private View.OnClickListener aoi;
    public TextView apa;
    private View apb;
    private ImageView apc;
    public boolean apd;
    public boolean ape;
    private boolean apf;
    private int apg;
    private boolean aph;
    private View.OnClickListener api;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apd = false;
        this.ape = false;
        this.apf = false;
        this.apg = 0;
        this.aph = false;
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajM.rv().getUserId(), true, true, true);
                    if (UserIconLayout.this.apg == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(UserIconLayout.this.mContext) && UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null && UserIconLayout.this.ajM.rv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajM.rv().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajM.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null && !StringUtils.isNull(UserIconLayout.this.ajM.rv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajM.rv().getUserId()) && UserIconLayout.this.ajM.rB() != null) {
                    if (UserIconLayout.this.ajM.sA() != null && UserIconLayout.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sA().channelId, UserIconLayout.this.ajM.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.rv().getUserId(), UserIconLayout.this.ajM.rv().getName_show(), UserIconLayout.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aog != null) {
                        UserIconLayout.this.aog.onClick(view);
                    }
                }
            }
        };
        this.api = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.sA() != null && UserIconLayout.this.ajM.sA().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sA().channelId, UserIconLayout.this.ajM.sA().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apd = false;
        this.ape = false;
        this.apf = false;
        this.apg = 0;
        this.aph = false;
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajM.rv().getUserId(), true, true, true);
                    if (UserIconLayout.this.apg == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aS(UserIconLayout.this.mContext) && UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null && UserIconLayout.this.ajM.rv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajM.rv().getTShowInfoNew();
                    if (v.v(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajM.rv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.rv() != null && !StringUtils.isNull(UserIconLayout.this.ajM.rv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajM.rv().getUserId()) && UserIconLayout.this.ajM.rB() != null) {
                    if (UserIconLayout.this.ajM.sA() != null && UserIconLayout.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sA().channelId, UserIconLayout.this.ajM.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.rv().getUserId(), UserIconLayout.this.ajM.rv().getName_show(), UserIconLayout.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aog != null) {
                        UserIconLayout.this.aog.onClick(view);
                    }
                }
            }
        };
        this.api = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajM != null && UserIconLayout.this.ajM.sA() != null && UserIconLayout.this.ajM.sA().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajM.sA().channelId, UserIconLayout.this.ajM.sA().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.apa.setTextSize(0, l.f(this.mContext, i));
    }

    public void aM(boolean z) {
        this.aph = z;
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
        this.aoA = new UserIconBox(this.mContext);
        this.aoC = new UserIconBox(this.mContext);
        this.apa = new TextView(this.mContext);
        this.apb = com.baidu.tbadk.ala.b.nv().g(this.mContext, 1);
        if (this.apb != null) {
            this.apb.setVisibility(8);
        }
        this.apc = new ImageView(this.mContext);
        if (this.apc != null) {
            this.apc.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.e.ds10), l.f(this.mContext, d.e.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.e.ds14), -l.f(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.e.ds8), l.f(this.mContext, d.e.ds3), 0, 0);
        this.apa.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
        if (!this.apf) {
            this.apa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aoA.setLayoutParams(layoutParams);
        this.aoC.setLayoutParams(layoutParams2);
        this.apa.setLayoutParams(layoutParams3);
        this.apc.setLayoutParams(layoutParams4);
        addView(this.aoA);
        addView(this.apa);
        if (this.apc != null) {
            addView(this.apc);
        }
        if (this.apb != null) {
            addView(this.apb);
        }
        addView(this.aoC);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.rv() != null) {
            this.ajM = bdVar;
            this.aoA.setOnClickListener(this.aoL);
            this.aoC.setOnClickListener(this.aoM);
            this.apa.setOnClickListener(this.aoi);
            this.apc.setOnClickListener(this.api);
            if (bdVar.rv() != null && bdVar.rv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.rv().getAlaUserData();
                if (this.apb != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rc = alaUserData;
                    aVar.type = 1;
                    this.apb.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.ajM.sA() != null && this.ajM.sA().channelId > 0) {
                this.apa.setText(w.u(this.ajM.sA().channelName, 20));
                this.aoC.setVisibility(8);
                this.aoA.setVisibility(8);
                if (this.ape) {
                    this.apc.setVisibility(0);
                } else {
                    this.apc.setVisibility(8);
                }
                aj.i(this.apa, d.C0095d.cp_cont_b);
                return;
            }
            this.apc.setVisibility(8);
            if (StringUtils.isNull(this.ajM.rv().getName_show())) {
                this.apa.setVisibility(8);
                i = 4;
            } else {
                this.apa.setVisibility(0);
                String name_show = this.ajM.rv().getName_show();
                if (this.apf) {
                    if (this.aph) {
                        this.apa.setText(ag(this.ajM.rv().getSealPrefix(), w.u(name_show, 20)));
                        int aP = com.baidu.adp.lib.util.k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.apa.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.aph) {
                    this.apa.setText(ag(this.ajM.rv().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.apa.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.rv().getIconInfo();
            if (this.apd && v.v(iconInfo) != 0) {
                this.aoC.setVisibility(0);
                this.aoC.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.aoC.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.rv().getTShowInfoNew();
            if (v.v(tShowInfoNew) != 0) {
                this.aoA.setVisibility(0);
                this.aoA.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.aoA.setVisibility(8);
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
        if (this.ajM != null && this.ajM.rv() != null) {
            if (!v.w(this.ajM.rv().getTShowInfoNew()) || this.ajM.rv().isBigV()) {
                aj.i(this.apa, d.C0095d.cp_cont_h);
                if (bdVar.rv() != null && bdVar.rv().getAlaUserData() != null) {
                    bdVar.rv().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.apa, d.C0095d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajM);
        if (this.ajM != null && this.ajM.sA() != null && this.ajM.sA().channelId > 0) {
            aj.i(this.apa, d.C0095d.cp_cont_b);
        }
        if (this.apc != null) {
            aj.j(this.apc, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aog = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apf = z;
    }

    public void setPageName(int i) {
        this.apg = i;
    }
}

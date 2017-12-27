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
import com.baidu.tbadk.core.data.be;
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
    private be aXV;
    private UserIconBox bcB;
    private View.OnClickListener bcK;
    private View.OnClickListener bcL;
    public TextView bcZ;
    private View.OnClickListener bce;
    private View.OnClickListener bcg;
    private UserIconBox bcz;
    private View bda;
    private ImageView bdb;
    public boolean bdc;
    public boolean bdd;
    private boolean bde;
    private int bdf;
    private boolean bdg;
    private View.OnClickListener bdh;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bdc = false;
        this.bdd = false;
        this.bde = false;
        this.bdf = 0;
        this.bdg = false;
        this.bcL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aXV.yX().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdf == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(UserIconLayout.this.mContext) && UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null && UserIconLayout.this.aXV.yX().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aXV.yX().getTShowInfoNew();
                    if (v.F(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aXV.yX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null && !StringUtils.isNull(UserIconLayout.this.aXV.yX().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aXV.yX().getUserId()) && UserIconLayout.this.aXV.zd() != null) {
                    if (UserIconLayout.this.aXV.Ac() != null && UserIconLayout.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.Ac().channelId, UserIconLayout.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.yX().getUserId(), UserIconLayout.this.aXV.yX().getName_show(), UserIconLayout.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bce != null) {
                        UserIconLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bdh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.Ac() != null && UserIconLayout.this.aXV.Ac().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.Ac().channelId, UserIconLayout.this.aXV.Ac().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdc = false;
        this.bdd = false;
        this.bde = false;
        this.bdf = 0;
        this.bdg = false;
        this.bcL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aXV.yX().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdf == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(UserIconLayout.this.mContext) && UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null && UserIconLayout.this.aXV.yX().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aXV.yX().getTShowInfoNew();
                    if (v.F(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aXV.yX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.yX() != null && !StringUtils.isNull(UserIconLayout.this.aXV.yX().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aXV.yX().getUserId()) && UserIconLayout.this.aXV.zd() != null) {
                    if (UserIconLayout.this.aXV.Ac() != null && UserIconLayout.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.Ac().channelId, UserIconLayout.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.yX().getUserId(), UserIconLayout.this.aXV.yX().getName_show(), UserIconLayout.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bce != null) {
                        UserIconLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bdh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXV != null && UserIconLayout.this.aXV.Ac() != null && UserIconLayout.this.aXV.Ac().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXV.Ac().channelId, UserIconLayout.this.aXV.Ac().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bcZ.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void bs(boolean z) {
        this.bdg = z;
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
        this.bcz = new UserIconBox(this.mContext);
        this.bcB = new UserIconBox(this.mContext);
        this.bcZ = new TextView(this.mContext);
        this.bda = com.baidu.tbadk.ala.b.uY().t(this.mContext, 1);
        if (this.bda != null) {
            this.bda.setVisibility(8);
        }
        this.bdb = new ImageView(this.mContext);
        if (this.bdb != null) {
            this.bdb.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds3), 0, 0);
        this.bcZ.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.fontsize24));
        if (!this.bde) {
            this.bcZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.bcz.setLayoutParams(layoutParams);
        this.bcB.setLayoutParams(layoutParams2);
        this.bcZ.setLayoutParams(layoutParams3);
        this.bdb.setLayoutParams(layoutParams4);
        addView(this.bcz);
        addView(this.bcZ);
        if (this.bdb != null) {
            addView(this.bdb);
        }
        if (this.bda != null) {
            addView(this.bda);
        }
        addView(this.bcB);
    }

    public void setData(be beVar) {
        int i;
        if (beVar != null && beVar.yX() != null) {
            this.aXV = beVar;
            this.bcz.setOnClickListener(this.bcK);
            this.bcB.setOnClickListener(this.bcL);
            this.bcZ.setOnClickListener(this.bcg);
            this.bdb.setOnClickListener(this.bdh);
            if (beVar.yX() != null && beVar.yX().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = beVar.yX().getAlaUserData();
                if (this.bda != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFJ = alaUserData;
                    aVar.type = 1;
                    this.bda.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aXV.Ac() != null && this.aXV.Ac().channelId > 0) {
                this.bcZ.setText(w.u(this.aXV.Ac().channelName, 20));
                this.bcB.setVisibility(8);
                this.bcz.setVisibility(8);
                if (this.bdd) {
                    this.bdb.setVisibility(0);
                } else {
                    this.bdb.setVisibility(8);
                }
                aj.r(this.bcZ, d.C0108d.cp_cont_b);
                return;
            }
            this.bdb.setVisibility(8);
            if (StringUtils.isNull(this.aXV.yX().getName_show())) {
                this.bcZ.setVisibility(8);
                i = 4;
            } else {
                this.bcZ.setVisibility(0);
                String name_show = this.aXV.yX().getName_show();
                if (this.bde) {
                    if (this.bdg) {
                        this.bcZ.setText(af(this.aXV.yX().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bcZ.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bdg) {
                    this.bcZ.setText(af(this.aXV.yX().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bcZ.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = beVar.yX().getIconInfo();
            if (this.bdc && v.F(iconInfo) != 0) {
                this.bcB.setVisibility(0);
                this.bcB.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.bcB.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = beVar.yX().getTShowInfoNew();
            if (v.F(tShowInfoNew) != 0) {
                this.bcz.setVisibility(0);
                this.bcz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.bcz.setVisibility(8);
            }
            setUserTextColor(beVar);
        }
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a(this.mContext, str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(be beVar) {
        if (this.aXV != null && this.aXV.yX() != null) {
            if (!v.G(this.aXV.yX().getTShowInfoNew()) || this.aXV.yX().isBigV()) {
                aj.r(this.bcZ, d.C0108d.cp_cont_h);
                if (beVar.yX() != null && beVar.yX().getAlaUserData() != null) {
                    beVar.yX().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.bcZ, d.C0108d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aXV);
        if (this.aXV != null && this.aXV.Ac() != null && this.aXV.Ac().channelId > 0) {
            aj.r(this.bcZ, d.C0108d.cp_cont_b);
        }
        if (this.bdb != null) {
            aj.s(this.bdb, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bce = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bde = z;
    }

    public void setPageName(int i) {
        this.bdf = i;
    }
}

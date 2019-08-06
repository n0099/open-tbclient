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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh We;
    private UserIconBox XN;
    private UserIconBox XO;
    private View XS;
    private View.OnClickListener XU;
    private View.OnClickListener XZ;
    private View.OnClickListener Ya;
    private View.OnClickListener Yb;
    public TextView cdg;
    private ImageView cdh;
    public boolean cdi;
    public boolean cdj;
    private boolean cdk;
    private int cdl;
    private boolean cdm;
    private View.OnClickListener cdn;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.cdi = false;
        this.cdj = false;
        this.cdk = false;
        this.cdl = 0;
        this.cdm = false;
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.We.aey().getUserId(), true, true, true);
                    if (UserIconLayout.this.cdl == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(UserIconLayout.this.mContext) && UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null && UserIconLayout.this.We.aey().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.We.aey().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.We.aey().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null && !StringUtils.isNull(UserIconLayout.this.We.aey().getName_show()) && !StringUtils.isNull(UserIconLayout.this.We.aey().getUserId()) && UserIconLayout.this.We.aeD() != null) {
                    if (UserIconLayout.this.We.afI() != null && UserIconLayout.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.afI().channelId, UserIconLayout.this.We.afI().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.aey().getUserId(), UserIconLayout.this.We.aey().getName_show(), UserIconLayout.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XU != null) {
                        UserIconLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.cdn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.afI() != null && UserIconLayout.this.We.afI().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.afI().channelId, UserIconLayout.this.We.afI().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdi = false;
        this.cdj = false;
        this.cdk = false;
        this.cdl = 0;
        this.cdm = false;
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.We.aey().getUserId(), true, true, true);
                    if (UserIconLayout.this.cdl == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(UserIconLayout.this.mContext) && UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null && UserIconLayout.this.We.aey().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.We.aey().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.We.aey().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.aey() != null && !StringUtils.isNull(UserIconLayout.this.We.aey().getName_show()) && !StringUtils.isNull(UserIconLayout.this.We.aey().getUserId()) && UserIconLayout.this.We.aeD() != null) {
                    if (UserIconLayout.this.We.afI() != null && UserIconLayout.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.afI().channelId, UserIconLayout.this.We.afI().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.aey().getUserId(), UserIconLayout.this.We.aey().getName_show(), UserIconLayout.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XU != null) {
                        UserIconLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.cdn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.We != null && UserIconLayout.this.We.afI() != null && UserIconLayout.this.We.afI().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.We.afI().channelId, UserIconLayout.this.We.afI().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cdg.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
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
        this.XO = new UserIconBox(this.mContext);
        this.XN = new UserIconBox(this.mContext);
        this.cdg = new TextView(this.mContext);
        this.XS = com.baidu.tbadk.ala.b.aak().n(this.mContext, 1);
        if (this.XS != null) {
            this.XS.setVisibility(8);
        }
        this.cdh = new ImageView(this.mContext);
        if (this.cdh != null) {
            this.cdh.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds3), 0, 0);
        this.cdg.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.fontsize24));
        if (!this.cdk) {
            this.cdg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.XO.setLayoutParams(layoutParams);
        this.XN.setLayoutParams(layoutParams2);
        this.cdg.setLayoutParams(layoutParams3);
        this.cdh.setLayoutParams(layoutParams4);
        addView(this.XO);
        addView(this.cdg);
        if (this.cdh != null) {
            addView(this.cdh);
        }
        if (this.XS != null) {
            addView(this.XS);
        }
        addView(this.XN);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.aey() != null) {
            this.We = bhVar;
            this.XO.setOnClickListener(this.XZ);
            this.XN.setOnClickListener(this.Yb);
            this.cdg.setOnClickListener(this.Ya);
            this.cdh.setOnClickListener(this.cdn);
            if (bhVar.aey() != null && bhVar.aey().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aey().getAlaUserData();
                if (this.XS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bAN = alaUserData;
                    aVar.type = 1;
                    this.XS.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.We.afI() != null && this.We.afI().channelId > 0) {
                this.cdg.setText(ab.S(this.We.afI().channelName, 20));
                this.XN.setVisibility(8);
                this.XO.setVisibility(8);
                if (this.cdj) {
                    this.cdh.setVisibility(0);
                } else {
                    this.cdh.setVisibility(8);
                }
                am.j(this.cdg, R.color.cp_cont_b);
                return;
            }
            this.cdh.setVisibility(8);
            if (StringUtils.isNull(this.We.aey().getName_show())) {
                this.cdg.setVisibility(8);
                i = 4;
            } else {
                this.cdg.setVisibility(0);
                String name_show = this.We.aey().getName_show();
                if (this.cdk) {
                    if (this.cdm) {
                        this.cdg.setText(bY(this.We.aey().getSealPrefix(), ab.S(name_show, 20)));
                        int bk = com.baidu.adp.lib.util.k.bk(name_show);
                        if (bk >= 20) {
                            i2 = 1;
                        } else if (bk >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cdg.setText(ab.S(name_show, 20));
                        i = 4;
                    }
                } else if (this.cdm) {
                    this.cdg.setText(bY(this.We.aey().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cdg.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.aey().getIconInfo();
            if (this.cdi && v.Z(iconInfo) != 0) {
                this.XN.setVisibility(0);
                this.XN.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.XN.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.aey().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XO.setVisibility(0);
                this.XO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.XO.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.We != null && this.We.aey() != null) {
            if (!v.aa(this.We.aey().getTShowInfoNew()) || this.We.aey().isBigV()) {
                am.j(this.cdg, R.color.cp_cont_h);
                if (bhVar.aey() != null && bhVar.aey().getAlaUserData() != null) {
                    bhVar.aey().getAlaUserData();
                    return;
                }
                return;
            }
            am.j(this.cdg, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.cdk = z;
    }

    public void setPageName(int i) {
        this.cdl = i;
    }
}

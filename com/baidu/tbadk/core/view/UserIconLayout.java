package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bu aeK;
    private UserIconBox ahC;
    private UserIconBox ahD;
    private View.OnClickListener ahM;
    private View.OnClickListener ahT;
    private View.OnClickListener ahU;
    private View.OnClickListener ahV;
    public TextView dEL;
    private View eeX;
    public boolean efq;
    private boolean efr;
    private int efs;
    private boolean eft;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.efq = false;
        this.efr = false;
        this.efs = 0;
        this.eft = false;
        this.ahV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (UserIconLayout.this.efs == 1) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        this.ahT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null && UserIconLayout.this.aeK.aSp().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aeK.aSp().getTShowInfoNew();
                    if (w.getCount(tShowInfoNew) != 0 && w.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null && !StringUtils.isNull(UserIconLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aeK.aSp().getUserId()) && UserIconLayout.this.aeK.aSt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aeK.aSp().getUserId(), UserIconLayout.this.aeK.aSp().getName_show(), UserIconLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ahM != null) {
                        UserIconLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efq = false;
        this.efr = false;
        this.efs = 0;
        this.eft = false;
        this.ahV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (UserIconLayout.this.efs == 1) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        this.ahT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null && UserIconLayout.this.aeK.aSp().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aeK.aSp().getTShowInfoNew();
                    if (w.getCount(tShowInfoNew) != 0 && w.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeK != null && UserIconLayout.this.aeK.aSp() != null && !StringUtils.isNull(UserIconLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aeK.aSp().getUserId()) && UserIconLayout.this.aeK.aSt() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aeK.aSp().getUserId(), UserIconLayout.this.aeK.aSp().getName_show(), UserIconLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ahM != null) {
                        UserIconLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.dEL.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ahD = new UserIconBox(this.mContext);
        this.ahC = new UserIconBox(this.mContext);
        this.dEL = new TextView(this.mContext);
        this.eeX = com.baidu.tbadk.ala.b.aOf().p(this.mContext, 1);
        if (this.eeX != null) {
            this.eeX.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.dEL.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.efr) {
            this.dEL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahD.setLayoutParams(layoutParams);
        this.ahC.setLayoutParams(layoutParams2);
        this.dEL.setLayoutParams(layoutParams3);
        addView(this.ahD);
        addView(this.dEL);
        if (this.eeX != null) {
            addView(this.eeX);
        }
        addView(this.ahC);
    }

    public void setData(bu buVar) {
        int i;
        if (buVar != null && buVar.aSp() != null) {
            this.aeK = buVar;
            this.ahD.setOnClickListener(this.ahT);
            this.ahC.setOnClickListener(this.ahV);
            this.dEL.setOnClickListener(this.ahU);
            if (buVar.aSp() != null && buVar.aSp().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = buVar.aSp().getAlaUserData();
                if (this.eeX != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dCt = alaUserData;
                    aVar.type = 1;
                    this.eeX.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.aeK.aSp().getName_show())) {
                this.dEL.setVisibility(8);
                i = 4;
            } else {
                this.dEL.setVisibility(0);
                String name_show = this.aeK.aSp().getName_show();
                if (this.efr) {
                    if (this.eft) {
                        this.dEL.setText(dn(this.aeK.aSp().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.dEL.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.eft) {
                    this.dEL.setText(dn(this.aeK.aSp().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.dEL.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = buVar.aSp().getIconInfo();
            if (this.efq && w.getCount(iconInfo) != 0) {
                this.ahC.setVisibility(0);
                this.ahC.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.ahC.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = buVar.aSp().getTShowInfoNew();
            if (w.getCount(tShowInfoNew) != 0) {
                this.ahD.setVisibility(0);
                this.ahD.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ahD.setVisibility(8);
            }
            setUserTextColor(buVar);
        }
    }

    private SpannableStringBuilder dn(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bu buVar) {
        if (this.aeK != null && this.aeK.aSp() != null) {
            if (!w.isEmpty(this.aeK.aSp().getTShowInfoNew()) || this.aeK.aSp().isBigV()) {
                an.setViewTextColor(this.dEL, (int) R.color.cp_cont_h);
                if (buVar.aSp() != null && buVar.aSp().getAlaUserData() != null) {
                    buVar.aSp().getAlaUserData();
                    return;
                }
                return;
            }
            an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahM = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.efr = z;
    }

    public void setPageName(int i) {
        this.efs = i;
    }
}

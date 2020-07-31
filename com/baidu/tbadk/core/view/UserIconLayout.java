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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bv aeA;
    private View.OnClickListener ahD;
    private View.OnClickListener ahK;
    private View.OnClickListener ahL;
    private View.OnClickListener ahM;
    private UserIconBox aht;
    private UserIconBox ahu;
    public TextView dKI;
    public boolean elA;
    private boolean elB;
    private int elC;
    private boolean elD;
    private View elh;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.elA = false;
        this.elB = false;
        this.elC = 0;
        this.elD = false;
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (UserIconLayout.this.elC == 1) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        this.ahK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null && UserIconLayout.this.aeA.aWl().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aeA.aWl().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null && !StringUtils.isNull(UserIconLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aeA.aWl().getUserId()) && UserIconLayout.this.aeA.aWp() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aeA.aWl().getUserId(), UserIconLayout.this.aeA.aWl().getName_show(), UserIconLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ahD != null) {
                        UserIconLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.elA = false;
        this.elB = false;
        this.elC = 0;
        this.elD = false;
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (UserIconLayout.this.elC == 1) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        this.ahK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null && UserIconLayout.this.aeA.aWl().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aeA.aWl().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aeA != null && UserIconLayout.this.aeA.aWl() != null && !StringUtils.isNull(UserIconLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aeA.aWl().getUserId()) && UserIconLayout.this.aeA.aWp() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aeA.aWl().getUserId(), UserIconLayout.this.aeA.aWl().getName_show(), UserIconLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ahD != null) {
                        UserIconLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.dKI.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ahu = new UserIconBox(this.mContext);
        this.aht = new UserIconBox(this.mContext);
        this.dKI = new TextView(this.mContext);
        this.elh = com.baidu.tbadk.ala.b.aSa().p(this.mContext, 1);
        if (this.elh != null) {
            this.elh.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.dKI.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.elB) {
            this.dKI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahu.setLayoutParams(layoutParams);
        this.aht.setLayoutParams(layoutParams2);
        this.dKI.setLayoutParams(layoutParams3);
        addView(this.ahu);
        addView(this.dKI);
        if (this.elh != null) {
            addView(this.elh);
        }
        addView(this.aht);
    }

    public void setData(bv bvVar) {
        int i;
        if (bvVar != null && bvVar.aWl() != null) {
            this.aeA = bvVar;
            this.ahu.setOnClickListener(this.ahK);
            this.aht.setOnClickListener(this.ahM);
            this.dKI.setOnClickListener(this.ahL);
            if (bvVar.aWl() != null && bvVar.aWl().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bvVar.aWl().getAlaUserData();
                if (this.elh != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dIq = alaUserData;
                    aVar.type = 1;
                    this.elh.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.aeA.aWl().getName_show())) {
                this.dKI.setVisibility(8);
                i = 4;
            } else {
                this.dKI.setVisibility(0);
                String name_show = this.aeA.aWl().getName_show();
                if (this.elB) {
                    if (this.elD) {
                        this.dKI.setText(dp(this.aeA.aWl().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.dKI.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.elD) {
                    this.dKI.setText(dp(this.aeA.aWl().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.dKI.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bvVar.aWl().getIconInfo();
            if (this.elA && x.getCount(iconInfo) != 0) {
                this.aht.setVisibility(0);
                this.aht.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.aht.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bvVar.aWl().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ahu.setVisibility(0);
                this.ahu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ahu.setVisibility(8);
            }
            setUserTextColor(bvVar);
        }
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bv bvVar) {
        if (this.aeA != null && this.aeA.aWl() != null) {
            if (!x.isEmpty(this.aeA.aWl().getTShowInfoNew()) || this.aeA.aWl().isBigV()) {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_h);
                if (bvVar.aWl() != null && bvVar.aWl().getAlaUserData() != null) {
                    bvVar.aWl().getAlaUserData();
                    return;
                }
                return;
            }
            ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.elB = z;
    }

    public void setPageName(int i) {
        this.elC = i;
    }
}

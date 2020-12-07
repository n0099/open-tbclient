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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private by ahA;
    private UserIconBox akA;
    private UserIconBox akB;
    private View.OnClickListener akI;
    private View.OnClickListener akQ;
    private View.OnClickListener akR;
    private View.OnClickListener akS;
    public TextView eBQ;
    public boolean feC;
    private boolean feD;
    private int feE;
    private boolean feF;
    private View fej;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.feC = false;
        this.feD = false;
        this.feE = 0;
        this.feF = false;
        this.akS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (UserIconLayout.this.feE == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        this.akQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null && UserIconLayout.this.ahA.boP().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahA.boP().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.J(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null && !StringUtils.isNull(UserIconLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahA.boP().getUserId()) && UserIconLayout.this.ahA.boT() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahA.boP().getUserId(), UserIconLayout.this.ahA.boP().getName_show(), UserIconLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.akI != null) {
                        UserIconLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.feC = false;
        this.feD = false;
        this.feE = 0;
        this.feF = false;
        this.akS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (UserIconLayout.this.feE == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        this.akQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null && UserIconLayout.this.ahA.boP().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahA.boP().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.J(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahA != null && UserIconLayout.this.ahA.boP() != null && !StringUtils.isNull(UserIconLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahA.boP().getUserId()) && UserIconLayout.this.ahA.boT() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahA.boP().getUserId(), UserIconLayout.this.ahA.boP().getName_show(), UserIconLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.akI != null) {
                        UserIconLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eBQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.akB = new UserIconBox(this.mContext);
        this.akA = new UserIconBox(this.mContext);
        this.eBQ = new TextView(this.mContext);
        this.fej = com.baidu.tbadk.ala.b.bkP().z(this.mContext, 1);
        if (this.fej != null) {
            this.fej.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eBQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.feD) {
            this.eBQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.akB.setLayoutParams(layoutParams);
        this.akA.setLayoutParams(layoutParams2);
        this.eBQ.setLayoutParams(layoutParams3);
        addView(this.akB);
        addView(this.eBQ);
        if (this.fej != null) {
            addView(this.fej);
        }
        addView(this.akA);
    }

    public void setData(by byVar) {
        int i;
        if (byVar != null && byVar.boP() != null) {
            this.ahA = byVar;
            this.akB.setOnClickListener(this.akQ);
            this.akA.setOnClickListener(this.akS);
            this.eBQ.setOnClickListener(this.akR);
            if (byVar.boP() != null && byVar.boP().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = byVar.boP().getAlaUserData();
                if (this.fej != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ezB = alaUserData;
                    aVar.type = 1;
                    this.fej.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.ahA.boP().getName_show())) {
                this.eBQ.setVisibility(8);
                i = 4;
            } else {
                this.eBQ.setVisibility(0);
                String name_show = this.ahA.boP().getName_show();
                if (this.feD) {
                    if (this.feF) {
                        this.eBQ.setText(ea(this.ahA.boP().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eBQ.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.feF) {
                    this.eBQ.setText(ea(this.ahA.boP().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eBQ.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = byVar.boP().getIconInfo();
            if (this.feC && y.getCount(iconInfo) != 0) {
                this.akA.setVisibility(0);
                this.akA.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.akA.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = byVar.boP().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akB.setVisibility(0);
                this.akB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.akB.setVisibility(8);
            }
            setUserTextColor(byVar);
        }
    }

    private SpannableStringBuilder ea(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(by byVar) {
        if (this.ahA != null && this.ahA.boP() != null) {
            if (!y.isEmpty(this.ahA.boP().getTShowInfoNew()) || this.ahA.boP().isBigV()) {
                ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
                if (byVar.boP() != null && byVar.boP().getAlaUserData() != null) {
                    byVar.boP().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.feD = z;
    }

    public void setPageName(int i) {
        this.feE = i;
    }
}

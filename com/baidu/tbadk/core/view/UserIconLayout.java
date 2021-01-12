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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bz ahu;
    private View.OnClickListener akB;
    private View.OnClickListener akC;
    private View.OnClickListener akD;
    private UserIconBox akl;
    private UserIconBox akm;
    private View.OnClickListener akt;
    public TextView eGI;
    public boolean fjB;
    private boolean fjC;
    private int fjD;
    private boolean fjE;
    private View fjj;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.fjB = false;
        this.fjC = false;
        this.fjD = 0;
        this.fjE = false;
        this.akD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (UserIconLayout.this.fjD == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        this.akB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null && UserIconLayout.this.ahu.bnx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahu.bnx().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null && !StringUtils.isNull(UserIconLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahu.bnx().getUserId()) && UserIconLayout.this.ahu.bnB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahu.bnx().getUserId(), UserIconLayout.this.ahu.bnx().getName_show(), UserIconLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.akt != null) {
                        UserIconLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjB = false;
        this.fjC = false;
        this.fjD = 0;
        this.fjE = false;
        this.akD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (UserIconLayout.this.fjD == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        this.akB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null && UserIconLayout.this.ahu.bnx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahu.bnx().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahu != null && UserIconLayout.this.ahu.bnx() != null && !StringUtils.isNull(UserIconLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahu.bnx().getUserId()) && UserIconLayout.this.ahu.bnB() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahu.bnx().getUserId(), UserIconLayout.this.ahu.bnx().getName_show(), UserIconLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.akt != null) {
                        UserIconLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eGI.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.akm = new UserIconBox(this.mContext);
        this.akl = new UserIconBox(this.mContext);
        this.eGI = new TextView(this.mContext);
        this.fjj = com.baidu.tbadk.ala.b.bjv().A(this.mContext, 1);
        if (this.fjj != null) {
            this.fjj.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eGI.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.fjC) {
            this.eGI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.akm.setLayoutParams(layoutParams);
        this.akl.setLayoutParams(layoutParams2);
        this.eGI.setLayoutParams(layoutParams3);
        addView(this.akm);
        addView(this.eGI);
        if (this.fjj != null) {
            addView(this.fjj);
        }
        addView(this.akl);
    }

    public void setData(bz bzVar) {
        int i;
        if (bzVar != null && bzVar.bnx() != null) {
            this.ahu = bzVar;
            this.akm.setOnClickListener(this.akB);
            this.akl.setOnClickListener(this.akD);
            this.eGI.setOnClickListener(this.akC);
            if (bzVar.bnx() != null && bzVar.bnx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.bnx().getAlaUserData();
                if (this.fjj != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eEt = alaUserData;
                    aVar.type = 1;
                    this.fjj.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.ahu.bnx().getName_show())) {
                this.eGI.setVisibility(8);
                i = 4;
            } else {
                this.eGI.setVisibility(0);
                String name_show = this.ahu.bnx().getName_show();
                if (this.fjC) {
                    if (this.fjE) {
                        this.eGI.setText(dY(this.ahu.bnx().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eGI.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.fjE) {
                    this.eGI.setText(dY(this.ahu.bnx().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eGI.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bzVar.bnx().getIconInfo();
            if (this.fjB && x.getCount(iconInfo) != 0) {
                this.akl.setVisibility(0);
                this.akl.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.akl.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bzVar.bnx().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.akm.setVisibility(0);
                this.akm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.akm.setVisibility(8);
            }
            setUserTextColor(bzVar);
        }
    }

    private SpannableStringBuilder dY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bz bzVar) {
        if (this.ahu != null && this.ahu.bnx() != null) {
            if (!x.isEmpty(this.ahu.bnx().getTShowInfoNew()) || this.ahu.bnx().isBigV()) {
                ao.setViewTextColor(this.eGI, R.color.CAM_X0301);
                if (bzVar.bnx() != null && bzVar.bnx().getAlaUserData() != null) {
                    bzVar.bnx().getAlaUserData();
                    return;
                }
                return;
            }
            ao.setViewTextColor(this.eGI, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.fjC = z;
    }

    public void setPageName(int i) {
        this.fjD = i;
    }
}

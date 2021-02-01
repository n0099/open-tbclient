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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private cb ahi;
    private UserIconBox aka;
    private UserIconBox akb;
    private View.OnClickListener aki;
    private View.OnClickListener akq;
    private View.OnClickListener akr;
    private View.OnClickListener aks;
    public TextView eIO;
    private View flA;
    public boolean flS;
    private boolean flT;
    private int flU;
    private boolean flV;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.flS = false;
        this.flT = false;
        this.flU = 0;
        this.flV = false;
        this.aks = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (UserIconLayout.this.flU == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        this.akq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null && UserIconLayout.this.ahi.bnQ().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahi.bnQ().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null && !StringUtils.isNull(UserIconLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahi.bnQ().getUserId()) && UserIconLayout.this.ahi.bnU() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahi.bnQ().getUserId(), UserIconLayout.this.ahi.bnQ().getName_show(), UserIconLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.aki != null) {
                        UserIconLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flS = false;
        this.flT = false;
        this.flU = 0;
        this.flV = false;
        this.aks = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (UserIconLayout.this.flU == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        this.akq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null && UserIconLayout.this.ahi.bnQ().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ahi.bnQ().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ahi != null && UserIconLayout.this.ahi.bnQ() != null && !StringUtils.isNull(UserIconLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ahi.bnQ().getUserId()) && UserIconLayout.this.ahi.bnU() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ahi.bnQ().getUserId(), UserIconLayout.this.ahi.bnQ().getName_show(), UserIconLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.aki != null) {
                        UserIconLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eIO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.akb = new UserIconBox(this.mContext);
        this.aka = new UserIconBox(this.mContext);
        this.eIO = new TextView(this.mContext);
        this.flA = com.baidu.tbadk.ala.b.bjQ().A(this.mContext, 1);
        if (this.flA != null) {
            this.flA.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eIO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.flT) {
            this.eIO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.akb.setLayoutParams(layoutParams);
        this.aka.setLayoutParams(layoutParams2);
        this.eIO.setLayoutParams(layoutParams3);
        addView(this.akb);
        addView(this.eIO);
        if (this.flA != null) {
            addView(this.flA);
        }
        addView(this.aka);
    }

    public void setData(cb cbVar) {
        int i;
        if (cbVar != null && cbVar.bnQ() != null) {
            this.ahi = cbVar;
            this.akb.setOnClickListener(this.akq);
            this.aka.setOnClickListener(this.aks);
            this.eIO.setOnClickListener(this.akr);
            if (cbVar.bnQ() != null && cbVar.bnQ().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnQ().getAlaUserData();
                if (this.flA != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eGA = alaUserData;
                    aVar.type = 1;
                    this.flA.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.ahi.bnQ().getName_show())) {
                this.eIO.setVisibility(8);
                i = 4;
            } else {
                this.eIO.setVisibility(0);
                String name_show = this.ahi.bnQ().getName_show();
                if (this.flT) {
                    if (this.flV) {
                        this.eIO.setText(dT(this.ahi.bnQ().getSealPrefix(), ag.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eIO.setText(ag.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.flV) {
                    this.eIO.setText(dT(this.ahi.bnQ().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eIO.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = cbVar.bnQ().getIconInfo();
            if (this.flS && y.getCount(iconInfo) != 0) {
                this.aka.setVisibility(0);
                this.aka.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.aka.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = cbVar.bnQ().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akb.setVisibility(0);
                this.akb.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.akb.setVisibility(8);
            }
            setUserTextColor(cbVar);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(cb cbVar) {
        if (this.ahi != null && this.ahi.bnQ() != null) {
            if (!y.isEmpty(this.ahi.bnQ().getTShowInfoNew()) || this.ahi.bnQ().isBigV()) {
                ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
                if (cbVar.bnQ() != null && cbVar.bnQ().getAlaUserData() != null) {
                    cbVar.bnQ().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aki = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.flT = z;
    }

    public void setPageName(int i) {
        this.flU = i;
    }
}

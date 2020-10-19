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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bw agw;
    private View.OnClickListener ajF;
    private View.OnClickListener ajM;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    private UserIconBox ajv;
    private UserIconBox ajw;
    public boolean eJN;
    private boolean eJO;
    private int eJP;
    private boolean eJQ;
    private View eJu;
    public TextView eig;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.eJN = false;
        this.eJO = false;
        this.eJP = 0;
        this.eJQ = false;
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agw.bih().getUserId(), true, true, true);
                    if (UserIconLayout.this.eJP == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    }
                }
            }
        };
        this.ajM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null && UserIconLayout.this.agw.bih().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agw.bih().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null && !StringUtils.isNull(UserIconLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agw.bih().getUserId()) && UserIconLayout.this.agw.bil() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agw.bih().getUserId(), UserIconLayout.this.agw.bih().getName_show(), UserIconLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajF != null) {
                        UserIconLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJN = false;
        this.eJO = false;
        this.eJP = 0;
        this.eJQ = false;
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agw.bih().getUserId(), true, true, true);
                    if (UserIconLayout.this.eJP == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    }
                }
            }
        };
        this.ajM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null && UserIconLayout.this.agw.bih().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agw.bih().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agw != null && UserIconLayout.this.agw.bih() != null && !StringUtils.isNull(UserIconLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agw.bih().getUserId()) && UserIconLayout.this.agw.bil() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agw.bih().getUserId(), UserIconLayout.this.agw.bih().getName_show(), UserIconLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajF != null) {
                        UserIconLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eig.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ajw = new UserIconBox(this.mContext);
        this.ajv = new UserIconBox(this.mContext);
        this.eig = new TextView(this.mContext);
        this.eJu = com.baidu.tbadk.ala.b.bdT().q(this.mContext, 1);
        if (this.eJu != null) {
            this.eJu.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eig.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.eJO) {
            this.eig.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ajw.setLayoutParams(layoutParams);
        this.ajv.setLayoutParams(layoutParams2);
        this.eig.setLayoutParams(layoutParams3);
        addView(this.ajw);
        addView(this.eig);
        if (this.eJu != null) {
            addView(this.eJu);
        }
        addView(this.ajv);
    }

    public void setData(bw bwVar) {
        int i;
        if (bwVar != null && bwVar.bih() != null) {
            this.agw = bwVar;
            this.ajw.setOnClickListener(this.ajM);
            this.ajv.setOnClickListener(this.ajO);
            this.eig.setOnClickListener(this.ajN);
            if (bwVar.bih() != null && bwVar.bih().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bih().getAlaUserData();
                if (this.eJu != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.efM = alaUserData;
                    aVar.type = 1;
                    this.eJu.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.agw.bih().getName_show())) {
                this.eig.setVisibility(8);
                i = 4;
            } else {
                this.eig.setVisibility(0);
                String name_show = this.agw.bih().getName_show();
                if (this.eJO) {
                    if (this.eJQ) {
                        this.eig.setText(dM(this.agw.bih().getSealPrefix(), af.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eig.setText(af.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.eJQ) {
                    this.eig.setText(dM(this.agw.bih().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eig.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bwVar.bih().getIconInfo();
            if (this.eJN && y.getCount(iconInfo) != 0) {
                this.ajv.setVisibility(0);
                this.ajv.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.ajv.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bwVar.bih().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajw.setVisibility(0);
                this.ajw.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ajw.setVisibility(8);
            }
            setUserTextColor(bwVar);
        }
    }

    private SpannableStringBuilder dM(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bw bwVar) {
        if (this.agw != null && this.agw.bih() != null) {
            if (!y.isEmpty(this.agw.bih().getTShowInfoNew()) || this.agw.bih().isBigV()) {
                ap.setViewTextColor(this.eig, R.color.cp_cont_h);
                if (bwVar.bih() != null && bwVar.bih().getAlaUserData() != null) {
                    bwVar.bih().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.eig, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajF = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.eJO = z;
    }

    public void setPageName(int i) {
        this.eJP = i;
    }
}

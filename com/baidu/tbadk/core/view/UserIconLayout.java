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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bj KJ;
    private View.OnClickListener NG;
    private View.OnClickListener NH;
    private View.OnClickListener NI;
    private UserIconBox No;
    private UserIconBox Np;
    private View.OnClickListener Nx;
    public TextView cbW;
    public boolean djI;
    private boolean djJ;
    private int djK;
    private boolean djL;
    private View djp;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.djI = false;
        this.djJ = false;
        this.djK = 0;
        this.djL = false;
        this.NI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.KJ.aCr().getUserId(), true, true, true);
                    if (UserIconLayout.this.djK == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null && UserIconLayout.this.KJ.aCr().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.KJ.aCr().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null && !StringUtils.isNull(UserIconLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(UserIconLayout.this.KJ.aCr().getUserId()) && UserIconLayout.this.KJ.aCw() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.KJ.aCr().getUserId(), UserIconLayout.this.KJ.aCr().getName_show(), UserIconLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.Nx != null) {
                        UserIconLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.djI = false;
        this.djJ = false;
        this.djK = 0;
        this.djL = false;
        this.NI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.KJ.aCr().getUserId(), true, true, true);
                    if (UserIconLayout.this.djK == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null && UserIconLayout.this.KJ.aCr().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.KJ.aCr().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.KJ != null && UserIconLayout.this.KJ.aCr() != null && !StringUtils.isNull(UserIconLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(UserIconLayout.this.KJ.aCr().getUserId()) && UserIconLayout.this.KJ.aCw() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.KJ.aCr().getUserId(), UserIconLayout.this.KJ.aCr().getName_show(), UserIconLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.Nx != null) {
                        UserIconLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cbW.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.Np = new UserIconBox(this.mContext);
        this.No = new UserIconBox(this.mContext);
        this.cbW = new TextView(this.mContext);
        this.djp = com.baidu.tbadk.ala.b.ayE().u(this.mContext, 1);
        if (this.djp != null) {
            this.djp.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.cbW.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.djJ) {
            this.cbW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.Np.setLayoutParams(layoutParams);
        this.No.setLayoutParams(layoutParams2);
        this.cbW.setLayoutParams(layoutParams3);
        addView(this.Np);
        addView(this.cbW);
        if (this.djp != null) {
            addView(this.djp);
        }
        addView(this.No);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.aCr() != null) {
            this.KJ = bjVar;
            this.Np.setOnClickListener(this.NG);
            this.No.setOnClickListener(this.NI);
            this.cbW.setOnClickListener(this.NH);
            if (bjVar.aCr() != null && bjVar.aCr().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aCr().getAlaUserData();
                if (this.djp != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cKd = alaUserData;
                    aVar.type = 1;
                    this.djp.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.KJ.aCr().getName_show())) {
                this.cbW.setVisibility(8);
                i = 4;
            } else {
                this.cbW.setVisibility(0);
                String name_show = this.KJ.aCr().getName_show();
                if (this.djJ) {
                    if (this.djL) {
                        this.cbW.setText(cA(this.KJ.aCr().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cbW.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.djL) {
                    this.cbW.setText(cA(this.KJ.aCr().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cbW.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.aCr().getIconInfo();
            if (this.djI && v.getCount(iconInfo) != 0) {
                this.No.setVisibility(0);
                this.No.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.No.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.aCr().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Np.setVisibility(0);
                this.Np.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.Np.setVisibility(8);
            }
            setUserTextColor(bjVar);
        }
    }

    private SpannableStringBuilder cA(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a(this.mContext, str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bj bjVar) {
        if (this.KJ != null && this.KJ.aCr() != null) {
            if (!v.isEmpty(this.KJ.aCr().getTShowInfoNew()) || this.KJ.aCr().isBigV()) {
                am.setViewTextColor(this.cbW, (int) R.color.cp_cont_h);
                if (bjVar.aCr() != null && bjVar.aCr().getAlaUserData() != null) {
                    bjVar.aCr().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.cbW, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nx = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.djJ = z;
    }

    public void setPageName(int i) {
        this.djK = i;
    }
}

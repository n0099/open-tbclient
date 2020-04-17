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
    private bj adG;
    private UserIconBox afY;
    private UserIconBox afZ;
    private View.OnClickListener agi;
    private View.OnClickListener agp;
    private View.OnClickListener agq;
    private View.OnClickListener agr;
    public TextView cAX;
    public boolean dJB;
    private boolean dJC;
    private int dJD;
    private boolean dJE;
    private View dJi;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.dJB = false;
        this.dJC = false;
        this.dJD = 0;
        this.dJE = false;
        this.agr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (UserIconLayout.this.dJD == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        this.agp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null && UserIconLayout.this.adG.aKE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.adG.aKE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.T(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null && !StringUtils.isNull(UserIconLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.adG.aKE().getUserId()) && UserIconLayout.this.adG.aKJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.adG.aKE().getUserId(), UserIconLayout.this.adG.aKE().getName_show(), UserIconLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agi != null) {
                        UserIconLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJB = false;
        this.dJC = false;
        this.dJD = 0;
        this.dJE = false;
        this.agr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (UserIconLayout.this.dJD == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        this.agp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null && UserIconLayout.this.adG.aKE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.adG.aKE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.T(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adG != null && UserIconLayout.this.adG.aKE() != null && !StringUtils.isNull(UserIconLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.adG.aKE().getUserId()) && UserIconLayout.this.adG.aKJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.adG.aKE().getUserId(), UserIconLayout.this.adG.aKE().getName_show(), UserIconLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agi != null) {
                        UserIconLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cAX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.afZ = new UserIconBox(this.mContext);
        this.afY = new UserIconBox(this.mContext);
        this.cAX = new TextView(this.mContext);
        this.dJi = com.baidu.tbadk.ala.b.aGP().p(this.mContext, 1);
        if (this.dJi != null) {
            this.dJi.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.cAX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.dJC) {
            this.cAX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.afZ.setLayoutParams(layoutParams);
        this.afY.setLayoutParams(layoutParams2);
        this.cAX.setLayoutParams(layoutParams3);
        addView(this.afZ);
        addView(this.cAX);
        if (this.dJi != null) {
            addView(this.dJi);
        }
        addView(this.afY);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.aKE() != null) {
            this.adG = bjVar;
            this.afZ.setOnClickListener(this.agp);
            this.afY.setOnClickListener(this.agr);
            this.cAX.setOnClickListener(this.agq);
            if (bjVar.aKE() != null && bjVar.aKE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKE().getAlaUserData();
                if (this.dJi != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djj = alaUserData;
                    aVar.type = 1;
                    this.dJi.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.adG.aKE().getName_show())) {
                this.cAX.setVisibility(8);
                i = 4;
            } else {
                this.cAX.setVisibility(0);
                String name_show = this.adG.aKE().getName_show();
                if (this.dJC) {
                    if (this.dJE) {
                        this.cAX.setText(cL(this.adG.aKE().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cAX.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.dJE) {
                    this.cAX.setText(cL(this.adG.aKE().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cAX.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.aKE().getIconInfo();
            if (this.dJB && v.getCount(iconInfo) != 0) {
                this.afY.setVisibility(0);
                this.afY.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.afY.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.aKE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.afZ.setVisibility(0);
                this.afZ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.afZ.setVisibility(8);
            }
            setUserTextColor(bjVar);
        }
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a(this.mContext, str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bj bjVar) {
        if (this.adG != null && this.adG.aKE() != null) {
            if (!v.isEmpty(this.adG.aKE().getTShowInfoNew()) || this.adG.aKE().isBigV()) {
                am.setViewTextColor(this.cAX, (int) R.color.cp_cont_h);
                if (bjVar.aKE() != null && bjVar.aKE().getAlaUserData() != null) {
                    bjVar.aKE().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.cAX, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agi = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.dJC = z;
    }

    public void setPageName(int i) {
        this.dJD = i;
    }
}

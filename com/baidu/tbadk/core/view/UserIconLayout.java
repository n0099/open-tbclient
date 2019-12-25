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
    private bj Ki;
    private UserIconBox MG;
    private UserIconBox MH;
    private View MP;
    private View.OnClickListener MT;
    private View.OnClickListener Na;
    private View.OnClickListener Nb;
    private View.OnClickListener Nc;
    public TextView bXt;
    public boolean deP;
    private boolean deQ;
    private int deR;
    private boolean deS;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.deP = false;
        this.deQ = false;
        this.deR = 0;
        this.deS = false;
        this.Nc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Ki.azE().getUserId(), true, true, true);
                    if (UserIconLayout.this.deR == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        this.Na = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null && UserIconLayout.this.Ki.azE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Ki.azE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null && !StringUtils.isNull(UserIconLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Ki.azE().getUserId()) && UserIconLayout.this.Ki.azJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Ki.azE().getUserId(), UserIconLayout.this.Ki.azE().getName_show(), UserIconLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.MT != null) {
                        UserIconLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deP = false;
        this.deQ = false;
        this.deR = 0;
        this.deS = false;
        this.Nc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Ki.azE().getUserId(), true, true, true);
                    if (UserIconLayout.this.deR == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        this.Na = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null && UserIconLayout.this.Ki.azE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Ki.azE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Ki != null && UserIconLayout.this.Ki.azE() != null && !StringUtils.isNull(UserIconLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Ki.azE().getUserId()) && UserIconLayout.this.Ki.azJ() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Ki.azE().getUserId(), UserIconLayout.this.Ki.azE().getName_show(), UserIconLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.MT != null) {
                        UserIconLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bXt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.MH = new UserIconBox(this.mContext);
        this.MG = new UserIconBox(this.mContext);
        this.bXt = new TextView(this.mContext);
        this.MP = com.baidu.tbadk.ala.b.avT().u(this.mContext, 1);
        if (this.MP != null) {
            this.MP.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.bXt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.deQ) {
            this.bXt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.MH.setLayoutParams(layoutParams);
        this.MG.setLayoutParams(layoutParams2);
        this.bXt.setLayoutParams(layoutParams3);
        addView(this.MH);
        addView(this.bXt);
        if (this.MP != null) {
            addView(this.MP);
        }
        addView(this.MG);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.azE() != null) {
            this.Ki = bjVar;
            this.MH.setOnClickListener(this.Na);
            this.MG.setOnClickListener(this.Nc);
            this.bXt.setOnClickListener(this.Nb);
            if (bjVar.azE() != null && bjVar.azE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.azE().getAlaUserData();
                if (this.MP != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFA = alaUserData;
                    aVar.type = 1;
                    this.MP.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.Ki.azE().getName_show())) {
                this.bXt.setVisibility(8);
                i = 4;
            } else {
                this.bXt.setVisibility(0);
                String name_show = this.Ki.azE().getName_show();
                if (this.deQ) {
                    if (this.deS) {
                        this.bXt.setText(cs(this.Ki.azE().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bXt.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.deS) {
                    this.bXt.setText(cs(this.Ki.azE().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bXt.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.azE().getIconInfo();
            if (this.deP && v.getCount(iconInfo) != 0) {
                this.MG.setVisibility(0);
                this.MG.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.MG.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.azE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MH.setVisibility(0);
                this.MH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.MH.setVisibility(8);
            }
            setUserTextColor(bjVar);
        }
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a(this.mContext, str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bj bjVar) {
        if (this.Ki != null && this.Ki.azE() != null) {
            if (!v.isEmpty(this.Ki.azE().getTShowInfoNew()) || this.Ki.azE().isBigV()) {
                am.setViewTextColor(this.bXt, (int) R.color.cp_cont_h);
                if (bjVar.azE() != null && bjVar.azE().getAlaUserData() != null) {
                    bjVar.azE().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.bXt, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.deQ = z;
    }

    public void setPageName(int i) {
        this.deR = i;
    }
}

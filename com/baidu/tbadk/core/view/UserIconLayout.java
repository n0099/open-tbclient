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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bw afL;
    private UserIconBox aiJ;
    private UserIconBox aiK;
    private View.OnClickListener aiT;
    private View.OnClickListener aja;
    private View.OnClickListener ajb;
    private View.OnClickListener ajc;
    public TextView dTU;
    private boolean evA;
    private int evB;
    private boolean evC;
    private View evg;
    public boolean evz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.evz = false;
        this.evA = false;
        this.evB = 0;
        this.evC = false;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.afL.beE().getUserId(), true, true, true);
                    if (UserIconLayout.this.evB == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null && UserIconLayout.this.afL.beE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.afL.beE().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bju().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null && !StringUtils.isNull(UserIconLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.afL.beE().getUserId()) && UserIconLayout.this.afL.beI() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.afL.beE().getUserId(), UserIconLayout.this.afL.beE().getName_show(), UserIconLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.aiT != null) {
                        UserIconLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evz = false;
        this.evA = false;
        this.evB = 0;
        this.evC = false;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.afL.beE().getUserId(), true, true, true);
                    if (UserIconLayout.this.evB == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null && UserIconLayout.this.afL.beE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.afL.beE().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bju().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.afL != null && UserIconLayout.this.afL.beE() != null && !StringUtils.isNull(UserIconLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.afL.beE().getUserId()) && UserIconLayout.this.afL.beI() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.afL.beE().getUserId(), UserIconLayout.this.afL.beE().getName_show(), UserIconLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.aiT != null) {
                        UserIconLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.dTU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.aiK = new UserIconBox(this.mContext);
        this.aiJ = new UserIconBox(this.mContext);
        this.dTU = new TextView(this.mContext);
        this.evg = com.baidu.tbadk.ala.b.bar().q(this.mContext, 1);
        if (this.evg != null) {
            this.evg.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.dTU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.evA) {
            this.dTU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aiK.setLayoutParams(layoutParams);
        this.aiJ.setLayoutParams(layoutParams2);
        this.dTU.setLayoutParams(layoutParams3);
        addView(this.aiK);
        addView(this.dTU);
        if (this.evg != null) {
            addView(this.evg);
        }
        addView(this.aiJ);
    }

    public void setData(bw bwVar) {
        int i;
        if (bwVar != null && bwVar.beE() != null) {
            this.afL = bwVar;
            this.aiK.setOnClickListener(this.aja);
            this.aiJ.setOnClickListener(this.ajc);
            this.dTU.setOnClickListener(this.ajb);
            if (bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.beE().getAlaUserData();
                if (this.evg != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dRB = alaUserData;
                    aVar.type = 1;
                    this.evg.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.afL.beE().getName_show())) {
                this.dTU.setVisibility(8);
                i = 4;
            } else {
                this.dTU.setVisibility(0);
                String name_show = this.afL.beE().getName_show();
                if (this.evA) {
                    if (this.evC) {
                        this.dTU.setText(dF(this.afL.beE().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.dTU.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.evC) {
                    this.dTU.setText(dF(this.afL.beE().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.dTU.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bwVar.beE().getIconInfo();
            if (this.evz && y.getCount(iconInfo) != 0) {
                this.aiJ.setVisibility(0);
                this.aiJ.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.aiJ.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bwVar.beE().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aiK.setVisibility(0);
                this.aiK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.aiK.setVisibility(8);
            }
            setUserTextColor(bwVar);
        }
    }

    private SpannableStringBuilder dF(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bw bwVar) {
        if (this.afL != null && this.afL.beE() != null) {
            if (!y.isEmpty(this.afL.beE().getTShowInfoNew()) || this.afL.beE().isBigV()) {
                ap.setViewTextColor(this.dTU, R.color.cp_cont_h);
                if (bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
                    bwVar.beE().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.dTU, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiT = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.evA = z;
    }

    public void setPageName(int i) {
        this.evB = i;
    }
}

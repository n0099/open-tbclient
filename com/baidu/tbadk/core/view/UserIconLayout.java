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
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bw agx;
    private View.OnClickListener ajG;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    private View.OnClickListener ajP;
    private UserIconBox ajw;
    private UserIconBox ajx;
    private View eXF;
    public boolean eXY;
    private boolean eXZ;
    private int eYa;
    private boolean eYb;
    public TextView ewx;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.eXY = false;
        this.eXZ = false;
        this.eYa = 0;
        this.eYb = false;
        this.ajP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agx.bmA().getUserId(), true, true, true);
                    if (UserIconLayout.this.eYa == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null && UserIconLayout.this.agx.bmA().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agx.bmA().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agx.bmA().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.brr().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null && !StringUtils.isNull(UserIconLayout.this.agx.bmA().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agx.bmA().getUserId()) && UserIconLayout.this.agx.bmE() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agx.bmA().getUserId(), UserIconLayout.this.agx.bmA().getName_show(), UserIconLayout.this.agx.bmE(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajG != null) {
                        UserIconLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXY = false;
        this.eXZ = false;
        this.eYa = 0;
        this.eYb = false;
        this.ajP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agx.bmA().getUserId(), true, true, true);
                    if (UserIconLayout.this.eYa == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null && UserIconLayout.this.agx.bmA().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agx.bmA().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agx.bmA().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.brr().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agx != null && UserIconLayout.this.agx.bmA() != null && !StringUtils.isNull(UserIconLayout.this.agx.bmA().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agx.bmA().getUserId()) && UserIconLayout.this.agx.bmE() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agx.bmA().getUserId(), UserIconLayout.this.agx.bmA().getName_show(), UserIconLayout.this.agx.bmE(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajG != null) {
                        UserIconLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ewx.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ajx = new UserIconBox(this.mContext);
        this.ajw = new UserIconBox(this.mContext);
        this.ewx = new TextView(this.mContext);
        this.eXF = com.baidu.tbadk.ala.b.bim().q(this.mContext, 1);
        if (this.eXF != null) {
            this.eXF.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.ewx.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.eXZ) {
            this.ewx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ajx.setLayoutParams(layoutParams);
        this.ajw.setLayoutParams(layoutParams2);
        this.ewx.setLayoutParams(layoutParams3);
        addView(this.ajx);
        addView(this.ewx);
        if (this.eXF != null) {
            addView(this.eXF);
        }
        addView(this.ajw);
    }

    public void setData(bw bwVar) {
        int i;
        if (bwVar != null && bwVar.bmA() != null) {
            this.agx = bwVar;
            this.ajx.setOnClickListener(this.ajN);
            this.ajw.setOnClickListener(this.ajP);
            this.ewx.setOnClickListener(this.ajO);
            if (bwVar.bmA() != null && bwVar.bmA().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bmA().getAlaUserData();
                if (this.eXF != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eue = alaUserData;
                    aVar.type = 1;
                    this.eXF.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.agx.bmA().getName_show())) {
                this.ewx.setVisibility(8);
                i = 4;
            } else {
                this.ewx.setVisibility(0);
                String name_show = this.agx.bmA().getName_show();
                if (this.eXZ) {
                    if (this.eYb) {
                        this.ewx.setText(dT(this.agx.bmA().getSealPrefix(), af.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.ewx.setText(af.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.eYb) {
                    this.ewx.setText(dT(this.agx.bmA().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.ewx.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bwVar.bmA().getIconInfo();
            if (this.eXY && y.getCount(iconInfo) != 0) {
                this.ajw.setVisibility(0);
                this.ajw.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.ajw.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bwVar.bmA().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajx.setVisibility(0);
                this.ajx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ajx.setVisibility(8);
            }
            setUserTextColor(bwVar);
        }
    }

    private SpannableStringBuilder dT(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bw bwVar) {
        if (this.agx != null && this.agx.bmA() != null) {
            if (!y.isEmpty(this.agx.bmA().getTShowInfoNew()) || this.agx.bmA().isBigV()) {
                ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
                if (bwVar.bmA() != null && bwVar.bmA().getAlaUserData() != null) {
                    bwVar.bmA().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.eXZ = z;
    }

    public void setPageName(int i) {
        this.eYa = i;
    }
}

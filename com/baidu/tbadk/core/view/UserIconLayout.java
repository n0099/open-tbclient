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
import com.baidu.tbadk.core.data.bx;
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
    private bx agB;
    private UserIconBox ajB;
    private UserIconBox ajC;
    private View.OnClickListener ajJ;
    private View.OnClickListener ajQ;
    private View.OnClickListener ajR;
    private View.OnClickListener ajS;
    private View eWM;
    public boolean eXf;
    private boolean eXg;
    private int eXh;
    private boolean eXi;
    public TextView euO;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.eXf = false;
        this.eXg = false;
        this.eXh = 0;
        this.eXi = false;
        this.ajS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agB.blC().getUserId(), true, true, true);
                    if (UserIconLayout.this.eXh == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null && UserIconLayout.this.agB.blC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agB.blC().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null && !StringUtils.isNull(UserIconLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agB.blC().getUserId()) && UserIconLayout.this.agB.blG() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agB.blC().getUserId(), UserIconLayout.this.agB.blC().getName_show(), UserIconLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajJ != null) {
                        UserIconLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXf = false;
        this.eXg = false;
        this.eXh = 0;
        this.eXi = false;
        this.ajS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agB.blC().getUserId(), true, true, true);
                    if (UserIconLayout.this.eXh == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null && UserIconLayout.this.agB.blC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agB.blC().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agB != null && UserIconLayout.this.agB.blC() != null && !StringUtils.isNull(UserIconLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agB.blC().getUserId()) && UserIconLayout.this.agB.blG() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agB.blC().getUserId(), UserIconLayout.this.agB.blC().getName_show(), UserIconLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajJ != null) {
                        UserIconLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.euO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ajC = new UserIconBox(this.mContext);
        this.ajB = new UserIconBox(this.mContext);
        this.euO = new TextView(this.mContext);
        this.eWM = com.baidu.tbadk.ala.b.bhG().q(this.mContext, 1);
        if (this.eWM != null) {
            this.eWM.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.euO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.eXg) {
            this.euO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ajC.setLayoutParams(layoutParams);
        this.ajB.setLayoutParams(layoutParams2);
        this.euO.setLayoutParams(layoutParams3);
        addView(this.ajC);
        addView(this.euO);
        if (this.eWM != null) {
            addView(this.eWM);
        }
        addView(this.ajB);
    }

    public void setData(bx bxVar) {
        int i;
        if (bxVar != null && bxVar.blC() != null) {
            this.agB = bxVar;
            this.ajC.setOnClickListener(this.ajQ);
            this.ajB.setOnClickListener(this.ajS);
            this.euO.setOnClickListener(this.ajR);
            if (bxVar.blC() != null && bxVar.blC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bxVar.blC().getAlaUserData();
                if (this.eWM != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.esy = alaUserData;
                    aVar.type = 1;
                    this.eWM.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.agB.blC().getName_show())) {
                this.euO.setVisibility(8);
                i = 4;
            } else {
                this.euO.setVisibility(0);
                String name_show = this.agB.blC().getName_show();
                if (this.eXg) {
                    if (this.eXi) {
                        this.euO.setText(dT(this.agB.blC().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.euO.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.eXi) {
                    this.euO.setText(dT(this.agB.blC().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.euO.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bxVar.blC().getIconInfo();
            if (this.eXf && y.getCount(iconInfo) != 0) {
                this.ajB.setVisibility(0);
                this.ajB.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.ajB.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bxVar.blC().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajC.setVisibility(0);
                this.ajC.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ajC.setVisibility(8);
            }
            setUserTextColor(bxVar);
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

    private void setUserTextColor(bx bxVar) {
        if (this.agB != null && this.agB.blC() != null) {
            if (!y.isEmpty(this.agB.blC().getTShowInfoNew()) || this.agB.blC().isBigV()) {
                ap.setViewTextColor(this.euO, R.color.CAM_X0301);
                if (bxVar.blC() != null && bxVar.blC().getAlaUserData() != null) {
                    bxVar.blC().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.euO, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajJ = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.eXg = z;
    }

    public void setPageName(int i) {
        this.eXh = i;
    }
}

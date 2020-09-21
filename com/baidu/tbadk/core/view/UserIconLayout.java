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
    private bw agf;
    private UserIconBox ajd;
    private UserIconBox aje;
    private View.OnClickListener ajn;
    private View.OnClickListener aju;
    private View.OnClickListener ajv;
    private View.OnClickListener ajw;
    public TextView dWe;
    public boolean exE;
    private boolean exF;
    private int exG;
    private boolean exH;
    private View exk;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.exE = false;
        this.exF = false;
        this.exG = 0;
        this.exH = false;
        this.ajw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (UserIconLayout.this.exG == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        this.aju = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null && UserIconLayout.this.agf.bfy().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agf.bfy().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null && !StringUtils.isNull(UserIconLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agf.bfy().getUserId()) && UserIconLayout.this.agf.bfC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agf.bfy().getUserId(), UserIconLayout.this.agf.bfy().getName_show(), UserIconLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajn != null) {
                        UserIconLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exE = false;
        this.exF = false;
        this.exG = 0;
        this.exH = false;
        this.ajw = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (UserIconLayout.this.exG == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        this.aju = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null && UserIconLayout.this.agf.bfy().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.agf.bfy().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.I(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.agf != null && UserIconLayout.this.agf.bfy() != null && !StringUtils.isNull(UserIconLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(UserIconLayout.this.agf.bfy().getUserId()) && UserIconLayout.this.agf.bfC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.agf.bfy().getUserId(), UserIconLayout.this.agf.bfy().getName_show(), UserIconLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.ajn != null) {
                        UserIconLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.dWe.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.aje = new UserIconBox(this.mContext);
        this.ajd = new UserIconBox(this.mContext);
        this.dWe = new TextView(this.mContext);
        this.exk = com.baidu.tbadk.ala.b.bbl().q(this.mContext, 1);
        if (this.exk != null) {
            this.exk.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.dWe.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.exF) {
            this.dWe.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aje.setLayoutParams(layoutParams);
        this.ajd.setLayoutParams(layoutParams2);
        this.dWe.setLayoutParams(layoutParams3);
        addView(this.aje);
        addView(this.dWe);
        if (this.exk != null) {
            addView(this.exk);
        }
        addView(this.ajd);
    }

    public void setData(bw bwVar) {
        int i;
        if (bwVar != null && bwVar.bfy() != null) {
            this.agf = bwVar;
            this.aje.setOnClickListener(this.aju);
            this.ajd.setOnClickListener(this.ajw);
            this.dWe.setOnClickListener(this.ajv);
            if (bwVar.bfy() != null && bwVar.bfy().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bwVar.bfy().getAlaUserData();
                if (this.exk != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dTL = alaUserData;
                    aVar.type = 1;
                    this.exk.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.agf.bfy().getName_show())) {
                this.dWe.setVisibility(8);
                i = 4;
            } else {
                this.dWe.setVisibility(0);
                String name_show = this.agf.bfy().getName_show();
                if (this.exF) {
                    if (this.exH) {
                        this.dWe.setText(dH(this.agf.bfy().getSealPrefix(), af.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.dWe.setText(af.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.exH) {
                    this.dWe.setText(dH(this.agf.bfy().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.dWe.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bwVar.bfy().getIconInfo();
            if (this.exE && y.getCount(iconInfo) != 0) {
                this.ajd.setVisibility(0);
                this.ajd.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.ajd.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bwVar.bfy().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aje.setVisibility(0);
                this.aje.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.aje.setVisibility(8);
            }
            setUserTextColor(bwVar);
        }
    }

    private SpannableStringBuilder dH(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bw bwVar) {
        if (this.agf != null && this.agf.bfy() != null) {
            if (!y.isEmpty(this.agf.bfy().getTShowInfoNew()) || this.agf.bfy().isBigV()) {
                ap.setViewTextColor(this.dWe, R.color.cp_cont_h);
                if (bwVar.bfy() != null && bwVar.bfy().getAlaUserData() != null) {
                    bwVar.bfy().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.dWe, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajn = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.exF = z;
    }

    public void setPageName(int i) {
        this.exG = i;
    }
}

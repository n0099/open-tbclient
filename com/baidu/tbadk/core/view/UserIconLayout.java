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
    private cb aiB;
    private View.OnClickListener alB;
    private View.OnClickListener alJ;
    private View.OnClickListener alK;
    private View.OnClickListener alL;
    private UserIconBox alt;
    private UserIconBox alu;
    public TextView eKp;
    private View fna;
    public boolean fns;
    private boolean fnt;
    private int fnu;
    private boolean fnv;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.fns = false;
        this.fnt = false;
        this.fnu = 0;
        this.fnv = false;
        this.alL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (UserIconLayout.this.fnu == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    }
                }
            }
        };
        this.alJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null && UserIconLayout.this.aiB.bnS().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiB.bnS().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.J(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null && !StringUtils.isNull(UserIconLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiB.bnS().getUserId()) && UserIconLayout.this.aiB.bnW() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiB.bnS().getUserId(), UserIconLayout.this.aiB.bnS().getName_show(), UserIconLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.alB != null) {
                        UserIconLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fns = false;
        this.fnt = false;
        this.fnu = 0;
        this.fnv = false;
        this.alL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (UserIconLayout.this.fnu == 1) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    }
                }
            }
        };
        this.alJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null && UserIconLayout.this.aiB.bnS().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiB.bnS().getTShowInfoNew();
                    if (y.getCount(tShowInfoNew) != 0 && y.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.J(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiB != null && UserIconLayout.this.aiB.bnS() != null && !StringUtils.isNull(UserIconLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiB.bnS().getUserId()) && UserIconLayout.this.aiB.bnW() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiB.bnS().getUserId(), UserIconLayout.this.aiB.bnS().getName_show(), UserIconLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.alB != null) {
                        UserIconLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eKp.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.alu = new UserIconBox(this.mContext);
        this.alt = new UserIconBox(this.mContext);
        this.eKp = new TextView(this.mContext);
        this.fna = com.baidu.tbadk.ala.b.bjS().A(this.mContext, 1);
        if (this.fna != null) {
            this.fna.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eKp.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.fnt) {
            this.eKp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.alu.setLayoutParams(layoutParams);
        this.alt.setLayoutParams(layoutParams2);
        this.eKp.setLayoutParams(layoutParams3);
        addView(this.alu);
        addView(this.eKp);
        if (this.fna != null) {
            addView(this.fna);
        }
        addView(this.alt);
    }

    public void setData(cb cbVar) {
        int i;
        if (cbVar != null && cbVar.bnS() != null) {
            this.aiB = cbVar;
            this.alu.setOnClickListener(this.alJ);
            this.alt.setOnClickListener(this.alL);
            this.eKp.setOnClickListener(this.alK);
            if (cbVar.bnS() != null && cbVar.bnS().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = cbVar.bnS().getAlaUserData();
                if (this.fna != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eIb = alaUserData;
                    aVar.type = 1;
                    this.fna.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.aiB.bnS().getName_show())) {
                this.eKp.setVisibility(8);
                i = 4;
            } else {
                this.eKp.setVisibility(0);
                String name_show = this.aiB.bnS().getName_show();
                if (this.fnt) {
                    if (this.fnv) {
                        this.eKp.setText(dT(this.aiB.bnS().getSealPrefix(), ag.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eKp.setText(ag.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.fnv) {
                    this.eKp.setText(dT(this.aiB.bnS().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eKp.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = cbVar.bnS().getIconInfo();
            if (this.fns && y.getCount(iconInfo) != 0) {
                this.alt.setVisibility(0);
                this.alt.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.alt.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = cbVar.bnS().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.alu.setVisibility(0);
                this.alu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.alu.setVisibility(8);
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
        if (this.aiB != null && this.aiB.bnS() != null) {
            if (!y.isEmpty(this.aiB.bnS().getTShowInfoNew()) || this.aiB.bnS().isBigV()) {
                ap.setViewTextColor(this.eKp, R.color.CAM_X0301);
                if (cbVar.bnS() != null && cbVar.bnS().getAlaUserData() != null) {
                    cbVar.bnS().getAlaUserData();
                    return;
                }
                return;
            }
            ap.setViewTextColor(this.eKp, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alB = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.fnt = z;
    }

    public void setPageName(int i) {
        this.fnu = i;
    }
}

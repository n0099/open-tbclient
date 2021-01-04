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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bz aim;
    private UserIconBox alc;
    private UserIconBox ald;
    private View.OnClickListener alk;
    private View.OnClickListener alt;
    private View.OnClickListener alu;
    private View.OnClickListener alv;
    public TextView eLt;
    private View fnS;
    public boolean fok;
    private boolean fol;
    private int fom;
    private boolean fon;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.fok = false;
        this.fol = false;
        this.fom = 0;
        this.fon = false;
        this.alv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aim.brq().getUserId(), true, true, true);
                    if (UserIconLayout.this.fom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        this.alt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null && UserIconLayout.this.aim.brq().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aim.brq().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aim.brq().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bwu().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null && !StringUtils.isNull(UserIconLayout.this.aim.brq().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aim.brq().getUserId()) && UserIconLayout.this.aim.bru() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aim.brq().getUserId(), UserIconLayout.this.aim.brq().getName_show(), UserIconLayout.this.aim.bru(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.alk != null) {
                        UserIconLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fok = false;
        this.fol = false;
        this.fom = 0;
        this.fon = false;
        this.alv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aim.brq().getUserId(), true, true, true);
                    if (UserIconLayout.this.fom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        this.alt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null && UserIconLayout.this.aim.brq().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aim.brq().getTShowInfoNew();
                    if (x.getCount(tShowInfoNew) != 0 && x.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aim.brq().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        be.bwu().b((TbPageContext) com.baidu.adp.base.j.K(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aim != null && UserIconLayout.this.aim.brq() != null && !StringUtils.isNull(UserIconLayout.this.aim.brq().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aim.brq().getUserId()) && UserIconLayout.this.aim.bru() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aim.brq().getUserId(), UserIconLayout.this.aim.brq().getName_show(), UserIconLayout.this.aim.bru(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.alk != null) {
                        UserIconLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.eLt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.ald = new UserIconBox(this.mContext);
        this.alc = new UserIconBox(this.mContext);
        this.eLt = new TextView(this.mContext);
        this.fnS = com.baidu.tbadk.ala.b.bno().A(this.mContext, 1);
        if (this.fnS != null) {
            this.fnS.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.eLt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.fol) {
            this.eLt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ald.setLayoutParams(layoutParams);
        this.alc.setLayoutParams(layoutParams2);
        this.eLt.setLayoutParams(layoutParams3);
        addView(this.ald);
        addView(this.eLt);
        if (this.fnS != null) {
            addView(this.fnS);
        }
        addView(this.alc);
    }

    public void setData(bz bzVar) {
        int i;
        if (bzVar != null && bzVar.brq() != null) {
            this.aim = bzVar;
            this.ald.setOnClickListener(this.alt);
            this.alc.setOnClickListener(this.alv);
            this.eLt.setOnClickListener(this.alu);
            if (bzVar.brq() != null && bzVar.brq().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.brq().getAlaUserData();
                if (this.fnS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eJe = alaUserData;
                    aVar.type = 1;
                    this.fnS.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.aim.brq().getName_show())) {
                this.eLt.setVisibility(8);
                i = 4;
            } else {
                this.eLt.setVisibility(0);
                String name_show = this.aim.brq().getName_show();
                if (this.fol) {
                    if (this.fon) {
                        this.eLt.setText(dZ(this.aim.brq().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.eLt.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.fon) {
                    this.eLt.setText(dZ(this.aim.brq().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.eLt.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bzVar.brq().getIconInfo();
            if (this.fok && x.getCount(iconInfo) != 0) {
                this.alc.setVisibility(0);
                this.alc.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.alc.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bzVar.brq().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ald.setVisibility(0);
                this.ald.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.ald.setVisibility(8);
            }
            setUserTextColor(bzVar);
        }
    }

    private SpannableStringBuilder dZ(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bz bzVar) {
        if (this.aim != null && this.aim.brq() != null) {
            if (!x.isEmpty(this.aim.brq().getTShowInfoNew()) || this.aim.brq().isBigV()) {
                ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
                if (bzVar.brq() != null && bzVar.brq().getAlaUserData() != null) {
                    bzVar.brq().getAlaUserData();
                    return;
                }
                return;
            }
            ao.setViewTextColor(this.eLt, R.color.CAM_X0105);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alk = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.fol = z;
    }

    public void setPageName(int i) {
        this.fom = i;
    }
}

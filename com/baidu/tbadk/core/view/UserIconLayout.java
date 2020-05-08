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
    private bj adJ;
    private UserIconBox agb;
    private UserIconBox agc;
    private View.OnClickListener agl;
    private View.OnClickListener ags;
    private View.OnClickListener agt;
    private View.OnClickListener agu;
    public TextView cBd;
    public boolean dJF;
    private boolean dJG;
    private int dJH;
    private boolean dJI;
    private View dJm;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.dJF = false;
        this.dJG = false;
        this.dJH = 0;
        this.dJI = false;
        this.agu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.adJ.aKC().getUserId(), true, true, true);
                    if (UserIconLayout.this.dJH == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        this.ags = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null && UserIconLayout.this.adJ.aKC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.adJ.aKC().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null && !StringUtils.isNull(UserIconLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.adJ.aKC().getUserId()) && UserIconLayout.this.adJ.aKH() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.adJ.aKC().getUserId(), UserIconLayout.this.adJ.aKC().getName_show(), UserIconLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agl != null) {
                        UserIconLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJF = false;
        this.dJG = false;
        this.dJH = 0;
        this.dJI = false;
        this.agu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.adJ.aKC().getUserId(), true, true, true);
                    if (UserIconLayout.this.dJH == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    }
                }
            }
        };
        this.ags = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null && UserIconLayout.this.adJ.aKC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.adJ.aKC().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.adJ != null && UserIconLayout.this.adJ.aKC() != null && !StringUtils.isNull(UserIconLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.adJ.aKC().getUserId()) && UserIconLayout.this.adJ.aKH() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.adJ.aKC().getUserId(), UserIconLayout.this.adJ.aKC().getName_show(), UserIconLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agl != null) {
                        UserIconLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cBd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.agc = new UserIconBox(this.mContext);
        this.agb = new UserIconBox(this.mContext);
        this.cBd = new TextView(this.mContext);
        this.dJm = com.baidu.tbadk.ala.b.aGN().p(this.mContext, 1);
        if (this.dJm != null) {
            this.dJm.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.cBd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.dJG) {
            this.cBd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.agc.setLayoutParams(layoutParams);
        this.agb.setLayoutParams(layoutParams2);
        this.cBd.setLayoutParams(layoutParams3);
        addView(this.agc);
        addView(this.cBd);
        if (this.dJm != null) {
            addView(this.dJm);
        }
        addView(this.agb);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.aKC() != null) {
            this.adJ = bjVar;
            this.agc.setOnClickListener(this.ags);
            this.agb.setOnClickListener(this.agu);
            this.cBd.setOnClickListener(this.agt);
            if (bjVar.aKC() != null && bjVar.aKC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.aKC().getAlaUserData();
                if (this.dJm != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djn = alaUserData;
                    aVar.type = 1;
                    this.dJm.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.adJ.aKC().getName_show())) {
                this.cBd.setVisibility(8);
                i = 4;
            } else {
                this.cBd.setVisibility(0);
                String name_show = this.adJ.aKC().getName_show();
                if (this.dJG) {
                    if (this.dJI) {
                        this.cBd.setText(cL(this.adJ.aKC().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cBd.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.dJI) {
                    this.cBd.setText(cL(this.adJ.aKC().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cBd.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.aKC().getIconInfo();
            if (this.dJF && v.getCount(iconInfo) != 0) {
                this.agb.setVisibility(0);
                this.agb.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.agb.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.aKC().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agc.setVisibility(0);
                this.agc.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.agc.setVisibility(8);
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
        if (this.adJ != null && this.adJ.aKC() != null) {
            if (!v.isEmpty(this.adJ.aKC().getTShowInfoNew()) || this.adJ.aKC().isBigV()) {
                am.setViewTextColor(this.cBd, (int) R.color.cp_cont_h);
                if (bjVar.aKC() != null && bjVar.aKC().getAlaUserData() != null) {
                    bjVar.aKC().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.cBd, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agl = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.dJG = z;
    }

    public void setPageName(int i) {
        this.dJH = i;
    }
}

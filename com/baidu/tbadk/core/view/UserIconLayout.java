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
    private bj Kn;
    private UserIconBox MO;
    private UserIconBox MP;
    private View.OnClickListener MX;
    private View.OnClickListener Nf;
    private View.OnClickListener Ng;
    private View.OnClickListener Nh;
    public TextView bXF;
    private View deI;
    public boolean dfb;
    private boolean dfc;
    private int dfd;
    private boolean dfe;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.dfb = false;
        this.dfc = false;
        this.dfd = 0;
        this.dfe = false;
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (UserIconLayout.this.dfd == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        this.Nf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null && UserIconLayout.this.Kn.azX().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Kn.azX().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null && !StringUtils.isNull(UserIconLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Kn.azX().getUserId()) && UserIconLayout.this.Kn.aAc() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Kn.azX().getUserId(), UserIconLayout.this.Kn.azX().getName_show(), UserIconLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.MX != null) {
                        UserIconLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfb = false;
        this.dfc = false;
        this.dfd = 0;
        this.dfe = false;
        this.Nh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (UserIconLayout.this.dfd == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                }
            }
        };
        this.Nf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null && UserIconLayout.this.Kn.azX().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Kn.azX().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Kn != null && UserIconLayout.this.Kn.azX() != null && !StringUtils.isNull(UserIconLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Kn.azX().getUserId()) && UserIconLayout.this.Kn.aAc() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Kn.azX().getUserId(), UserIconLayout.this.Kn.azX().getName_show(), UserIconLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.MX != null) {
                        UserIconLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bXF.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.MP = new UserIconBox(this.mContext);
        this.MO = new UserIconBox(this.mContext);
        this.bXF = new TextView(this.mContext);
        this.deI = com.baidu.tbadk.ala.b.awm().u(this.mContext, 1);
        if (this.deI != null) {
            this.deI.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.bXF.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.dfc) {
            this.bXF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.MP.setLayoutParams(layoutParams);
        this.MO.setLayoutParams(layoutParams2);
        this.bXF.setLayoutParams(layoutParams3);
        addView(this.MP);
        addView(this.bXF);
        if (this.deI != null) {
            addView(this.deI);
        }
        addView(this.MO);
    }

    public void setData(bj bjVar) {
        int i;
        if (bjVar != null && bjVar.azX() != null) {
            this.Kn = bjVar;
            this.MP.setOnClickListener(this.Nf);
            this.MO.setOnClickListener(this.Nh);
            this.bXF.setOnClickListener(this.Ng);
            if (bjVar.azX() != null && bjVar.azX().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.azX().getAlaUserData();
                if (this.deI != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFM = alaUserData;
                    aVar.type = 1;
                    this.deI.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.Kn.azX().getName_show())) {
                this.bXF.setVisibility(8);
                i = 4;
            } else {
                this.bXF.setVisibility(0);
                String name_show = this.Kn.azX().getName_show();
                if (this.dfc) {
                    if (this.dfe) {
                        this.bXF.setText(cs(this.Kn.azX().getSealPrefix(), ad.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bXF.setText(ad.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.dfe) {
                    this.bXF.setText(cs(this.Kn.azX().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bXF.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bjVar.azX().getIconInfo();
            if (this.dfb && v.getCount(iconInfo) != 0) {
                this.MO.setVisibility(0);
                this.MO.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.MO.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.azX().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MP.setVisibility(0);
                this.MP.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.MP.setVisibility(8);
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
        if (this.Kn != null && this.Kn.azX() != null) {
            if (!v.isEmpty(this.Kn.azX().getTShowInfoNew()) || this.Kn.azX().isBigV()) {
                am.setViewTextColor(this.bXF, (int) R.color.cp_cont_h);
                if (bjVar.azX() != null && bjVar.azX().getAlaUserData() != null) {
                    bjVar.azX().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.bXF, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MX = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.dfc = z;
    }

    public void setPageName(int i) {
        this.dfd = i;
    }
}

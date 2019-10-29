package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh FT;
    private UserIconBox HG;
    private UserIconBox HH;
    private View HM;
    private View.OnClickListener HO;
    private View.OnClickListener HU;
    private View.OnClickListener HV;
    private View.OnClickListener HW;
    public TextView csn;
    private ImageView cso;
    public boolean csp;
    public boolean csq;
    private boolean csr;
    private int css;
    private boolean cst;
    private View.OnClickListener csu;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.csp = false;
        this.csq = false;
        this.csr = false;
        this.css = 0;
        this.cst = false;
        this.HW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (UserIconLayout.this.css == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        this.HU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null && UserIconLayout.this.FT.aiG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.FT.aiG().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null && !StringUtils.isNull(UserIconLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.FT.aiG().getUserId()) && UserIconLayout.this.FT.aiL() != null) {
                    if (UserIconLayout.this.FT.ajP() != null && UserIconLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.ajP().channelId, UserIconLayout.this.FT.ajP().ZN)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.aiG().getUserId(), UserIconLayout.this.FT.aiG().getName_show(), UserIconLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.HO != null) {
                        UserIconLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.csu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.ajP() != null && UserIconLayout.this.FT.ajP().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.ajP().channelId, UserIconLayout.this.FT.ajP().ZN)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csp = false;
        this.csq = false;
        this.csr = false;
        this.css = 0;
        this.cst = false;
        this.HW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.FT.aiG().getUserId(), true, true, true);
                    if (UserIconLayout.this.css == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        this.HU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null && UserIconLayout.this.FT.aiG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.FT.aiG().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.FT.aiG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.HV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.aiG() != null && !StringUtils.isNull(UserIconLayout.this.FT.aiG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.FT.aiG().getUserId()) && UserIconLayout.this.FT.aiL() != null) {
                    if (UserIconLayout.this.FT.ajP() != null && UserIconLayout.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.ajP().channelId, UserIconLayout.this.FT.ajP().ZN)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.aiG().getUserId(), UserIconLayout.this.FT.aiG().getName_show(), UserIconLayout.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.HO != null) {
                        UserIconLayout.this.HO.onClick(view);
                    }
                }
            }
        };
        this.csu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.FT != null && UserIconLayout.this.FT.ajP() != null && UserIconLayout.this.FT.ajP().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.FT.ajP().channelId, UserIconLayout.this.FT.ajP().ZN)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.csn.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.HH = new UserIconBox(this.mContext);
        this.HG = new UserIconBox(this.mContext);
        this.csn = new TextView(this.mContext);
        this.HM = com.baidu.tbadk.ala.b.afc().l(this.mContext, 1);
        if (this.HM != null) {
            this.HM.setVisibility(8);
        }
        this.cso = new ImageView(this.mContext);
        if (this.cso != null) {
            this.cso.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.csn.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.csr) {
            this.csn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.HH.setLayoutParams(layoutParams);
        this.HG.setLayoutParams(layoutParams2);
        this.csn.setLayoutParams(layoutParams3);
        this.cso.setLayoutParams(layoutParams4);
        addView(this.HH);
        addView(this.csn);
        if (this.cso != null) {
            addView(this.cso);
        }
        if (this.HM != null) {
            addView(this.HM);
        }
        addView(this.HG);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.aiG() != null) {
            this.FT = bhVar;
            this.HH.setOnClickListener(this.HU);
            this.HG.setOnClickListener(this.HW);
            this.csn.setOnClickListener(this.HV);
            this.cso.setOnClickListener(this.csu);
            if (bhVar.aiG() != null && bhVar.aiG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aiG().getAlaUserData();
                if (this.HM != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTT = alaUserData;
                    aVar.type = 1;
                    this.HM.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.FT.ajP() != null && this.FT.ajP().channelId > 0) {
                this.csn.setText(aa.subString(this.FT.ajP().channelName, 20));
                this.HG.setVisibility(8);
                this.HH.setVisibility(8);
                if (this.csq) {
                    this.cso.setVisibility(0);
                } else {
                    this.cso.setVisibility(8);
                }
                am.setViewTextColor(this.csn, (int) R.color.cp_cont_b);
                return;
            }
            this.cso.setVisibility(8);
            if (StringUtils.isNull(this.FT.aiG().getName_show())) {
                this.csn.setVisibility(8);
                i = 4;
            } else {
                this.csn.setVisibility(0);
                String name_show = this.FT.aiG().getName_show();
                if (this.csr) {
                    if (this.cst) {
                        this.csn.setText(bV(this.FT.aiG().getSealPrefix(), aa.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.csn.setText(aa.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.cst) {
                    this.csn.setText(bV(this.FT.aiG().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.csn.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.aiG().getIconInfo();
            if (this.csp && v.getCount(iconInfo) != 0) {
                this.HG.setVisibility(0);
                this.HG.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.HG.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.aiG().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.HH.setVisibility(0);
                this.HH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.HH.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.FT != null && this.FT.aiG() != null) {
            if (!v.isEmpty(this.FT.aiG().getTShowInfoNew()) || this.FT.aiG().isBigV()) {
                am.setViewTextColor(this.csn, (int) R.color.cp_cont_h);
                if (bhVar.aiG() != null && bhVar.aiG().getAlaUserData() != null) {
                    bhVar.aiG().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.csn, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.HO = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.csr = z;
    }

    public void setPageName(int i) {
        this.css = i;
    }
}

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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bk aee;
    private View.OnClickListener agI;
    private View.OnClickListener agO;
    private View.OnClickListener agP;
    private View.OnClickListener agQ;
    private UserIconBox agy;
    private UserIconBox agz;
    private View dXB;
    public TextView dXU;
    public boolean dXV;
    private boolean dXW;
    private int dXX;
    private boolean dXY;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.dXV = false;
        this.dXW = false;
        this.dXX = 0;
        this.dXY = false;
        this.agQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (UserIconLayout.this.dXX == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        this.agO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null && UserIconLayout.this.aee.aQx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aee.aQx().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null && !StringUtils.isNull(UserIconLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aee.aQx().getUserId()) && UserIconLayout.this.aee.aQC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aee.aQx().getUserId(), UserIconLayout.this.aee.aQx().getName_show(), UserIconLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agI != null) {
                        UserIconLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXV = false;
        this.dXW = false;
        this.dXX = 0;
        this.dXY = false;
        this.agQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (UserIconLayout.this.dXX == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        this.agO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null && UserIconLayout.this.aee.aQx().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aee.aQx().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.G(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aee != null && UserIconLayout.this.aee.aQx() != null && !StringUtils.isNull(UserIconLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aee.aQx().getUserId()) && UserIconLayout.this.aee.aQC() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aee.aQx().getUserId(), UserIconLayout.this.aee.aQx().getName_show(), UserIconLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    if (UserIconLayout.this.agI != null) {
                        UserIconLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.dXU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.agz = new UserIconBox(this.mContext);
        this.agy = new UserIconBox(this.mContext);
        this.dXU = new TextView(this.mContext);
        this.dXB = com.baidu.tbadk.ala.b.aMC().p(this.mContext, 1);
        if (this.dXB != null) {
            this.dXB.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.dXU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.dXW) {
            this.dXU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.agz.setLayoutParams(layoutParams);
        this.agy.setLayoutParams(layoutParams2);
        this.dXU.setLayoutParams(layoutParams3);
        addView(this.agz);
        addView(this.dXU);
        if (this.dXB != null) {
            addView(this.dXB);
        }
        addView(this.agy);
    }

    public void setData(bk bkVar) {
        int i;
        if (bkVar != null && bkVar.aQx() != null) {
            this.aee = bkVar;
            this.agz.setOnClickListener(this.agO);
            this.agy.setOnClickListener(this.agQ);
            this.dXU.setOnClickListener(this.agP);
            if (bkVar.aQx() != null && bkVar.aQx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bkVar.aQx().getAlaUserData();
                if (this.dXB != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dxn = alaUserData;
                    aVar.type = 1;
                    this.dXB.setTag(aVar);
                }
            }
            int i2 = 4;
            if (StringUtils.isNull(this.aee.aQx().getName_show())) {
                this.dXU.setVisibility(8);
                i = 4;
            } else {
                this.dXU.setVisibility(0);
                String name_show = this.aee.aQx().getName_show();
                if (this.dXW) {
                    if (this.dXY) {
                        this.dXU.setText(dk(this.aee.aQx().getSealPrefix(), ae.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.dXU.setText(ae.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.dXY) {
                    this.dXU.setText(dk(this.aee.aQx().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.dXU.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bkVar.aQx().getIconInfo();
            if (this.dXV && v.getCount(iconInfo) != 0) {
                this.agy.setVisibility(0);
                this.agy.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.agy.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bkVar.aQx().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agz.setVisibility(0);
                this.agz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.agz.setVisibility(8);
            }
            setUserTextColor(bkVar);
        }
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bk bkVar) {
        if (this.aee != null && this.aee.aQx() != null) {
            if (!v.isEmpty(this.aee.aQx().getTShowInfoNew()) || this.aee.aQx().isBigV()) {
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                if (bkVar.aQx() != null && bkVar.aQx().getAlaUserData() != null) {
                    bkVar.aQx().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agI = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.dXW = z;
    }

    public void setPageName(int i) {
        this.dXX = i;
    }
}

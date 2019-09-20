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
    private bh Wd;
    private UserIconBox XM;
    private UserIconBox XN;
    private View XS;
    private View.OnClickListener XU;
    private View.OnClickListener XZ;
    private View.OnClickListener Ya;
    private View.OnClickListener Yb;
    public TextView cdZ;
    private ImageView cea;
    public boolean ceb;
    public boolean cec;
    private boolean ced;
    private int cee;
    private boolean cef;
    private View.OnClickListener ceg;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ceb = false;
        this.cec = false;
        this.ced = false;
        this.cee = 0;
        this.cef = false;
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.Wd.aeC().getUserId(), true, true, true);
                    if (UserIconLayout.this.cee == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(UserIconLayout.this.mContext) && UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null && UserIconLayout.this.Wd.aeC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Wd.aeC().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null && !StringUtils.isNull(UserIconLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Wd.aeC().getUserId()) && UserIconLayout.this.Wd.aeH() != null) {
                    if (UserIconLayout.this.Wd.afM() != null && UserIconLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.afM().channelId, UserIconLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.aeC().getUserId(), UserIconLayout.this.Wd.aeC().getName_show(), UserIconLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XU != null) {
                        UserIconLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.ceg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.afM() != null && UserIconLayout.this.Wd.afM().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.afM().channelId, UserIconLayout.this.Wd.afM().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ceb = false;
        this.cec = false;
        this.ced = false;
        this.cee = 0;
        this.cef = false;
        this.Yb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.Wd.aeC().getUserId(), true, true, true);
                    if (UserIconLayout.this.cee == 1) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(UserIconLayout.this.mContext) && UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null && UserIconLayout.this.Wd.aeC().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Wd.aeC().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.aeC() != null && !StringUtils.isNull(UserIconLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Wd.aeC().getUserId()) && UserIconLayout.this.Wd.aeH() != null) {
                    if (UserIconLayout.this.Wd.afM() != null && UserIconLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.afM().channelId, UserIconLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.aeC().getUserId(), UserIconLayout.this.Wd.aeC().getName_show(), UserIconLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XU != null) {
                        UserIconLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.ceg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Wd != null && UserIconLayout.this.Wd.afM() != null && UserIconLayout.this.Wd.afM().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Wd.afM().channelId, UserIconLayout.this.Wd.afM().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cdZ.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
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
        this.XN = new UserIconBox(this.mContext);
        this.XM = new UserIconBox(this.mContext);
        this.cdZ = new TextView(this.mContext);
        this.XS = com.baidu.tbadk.ala.b.aao().n(this.mContext, 1);
        if (this.XS != null) {
            this.XS.setVisibility(8);
        }
        this.cea = new ImageView(this.mContext);
        if (this.cea != null) {
            this.cea.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds3), 0, 0);
        this.cdZ.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.fontsize24));
        if (!this.ced) {
            this.cdZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.XN.setLayoutParams(layoutParams);
        this.XM.setLayoutParams(layoutParams2);
        this.cdZ.setLayoutParams(layoutParams3);
        this.cea.setLayoutParams(layoutParams4);
        addView(this.XN);
        addView(this.cdZ);
        if (this.cea != null) {
            addView(this.cea);
        }
        if (this.XS != null) {
            addView(this.XS);
        }
        addView(this.XM);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.aeC() != null) {
            this.Wd = bhVar;
            this.XN.setOnClickListener(this.XZ);
            this.XM.setOnClickListener(this.Yb);
            this.cdZ.setOnClickListener(this.Ya);
            this.cea.setOnClickListener(this.ceg);
            if (bhVar.aeC() != null && bhVar.aeC().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aeC().getAlaUserData();
                if (this.XS != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bBl = alaUserData;
                    aVar.type = 1;
                    this.XS.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.Wd.afM() != null && this.Wd.afM().channelId > 0) {
                this.cdZ.setText(aa.S(this.Wd.afM().channelName, 20));
                this.XM.setVisibility(8);
                this.XN.setVisibility(8);
                if (this.cec) {
                    this.cea.setVisibility(0);
                } else {
                    this.cea.setVisibility(8);
                }
                am.j(this.cdZ, R.color.cp_cont_b);
                return;
            }
            this.cea.setVisibility(8);
            if (StringUtils.isNull(this.Wd.aeC().getName_show())) {
                this.cdZ.setVisibility(8);
                i = 4;
            } else {
                this.cdZ.setVisibility(0);
                String name_show = this.Wd.aeC().getName_show();
                if (this.ced) {
                    if (this.cef) {
                        this.cdZ.setText(bY(this.Wd.aeC().getSealPrefix(), aa.S(name_show, 20)));
                        int bk = com.baidu.adp.lib.util.k.bk(name_show);
                        if (bk >= 20) {
                            i2 = 1;
                        } else if (bk >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cdZ.setText(aa.S(name_show, 20));
                        i = 4;
                    }
                } else if (this.cef) {
                    this.cdZ.setText(bY(this.Wd.aeC().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cdZ.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.aeC().getIconInfo();
            if (this.ceb && v.Z(iconInfo) != 0) {
                this.XM.setVisibility(0);
                this.XM.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.XM.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.aeC().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XN.setVisibility(0);
                this.XN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.XN.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder bY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.Wd != null && this.Wd.aeC() != null) {
            if (!v.aa(this.Wd.aeC().getTShowInfoNew()) || this.Wd.aeC().isBigV()) {
                am.j(this.cdZ, R.color.cp_cont_h);
                if (bhVar.aeC() != null && bhVar.aeC().getAlaUserData() != null) {
                    bhVar.aeC().getAlaUserData();
                    return;
                }
                return;
            }
            am.j(this.cdZ, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ced = z;
    }

    public void setPageName(int i) {
        this.cee = i;
    }
}

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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bc atZ;
    private UserIconBox ayK;
    private UserIconBox ayM;
    private View ayR;
    private View.OnClickListener ayX;
    private View.OnClickListener ayY;
    private View.OnClickListener ayi;
    private View.OnClickListener ayk;
    public TextView azm;
    private ImageView azn;
    public boolean azo;
    public boolean azp;
    private boolean azq;
    private int azr;
    private boolean azs;
    private View.OnClickListener azt;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.azo = false;
        this.azp = false;
        this.azq = false;
        this.azr = 0;
        this.azs = false;
        this.ayY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atZ.vw().getUserId(), true, true, true);
                    if (UserIconLayout.this.azr == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bb.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null && UserIconLayout.this.atZ.vw().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atZ.vw().getTShowInfoNew();
                    if (w.z(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atZ.vw().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null && !StringUtils.isNull(UserIconLayout.this.atZ.vw().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atZ.vw().getUserId()) && UserIconLayout.this.atZ.vB() != null) {
                    if (UserIconLayout.this.atZ.ww() != null && UserIconLayout.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.ww().channelId, UserIconLayout.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.vw().getUserId(), UserIconLayout.this.atZ.vw().getName_show(), UserIconLayout.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ayi != null) {
                        UserIconLayout.this.ayi.onClick(view);
                    }
                }
            }
        };
        this.azt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.ww() != null && UserIconLayout.this.atZ.ww().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.ww().channelId, UserIconLayout.this.atZ.ww().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azo = false;
        this.azp = false;
        this.azq = false;
        this.azr = 0;
        this.azs = false;
        this.ayY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atZ.vw().getUserId(), true, true, true);
                    if (UserIconLayout.this.azr == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bb.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null && UserIconLayout.this.atZ.vw().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atZ.vw().getTShowInfoNew();
                    if (w.z(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atZ.vw().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.vw() != null && !StringUtils.isNull(UserIconLayout.this.atZ.vw().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atZ.vw().getUserId()) && UserIconLayout.this.atZ.vB() != null) {
                    if (UserIconLayout.this.atZ.ww() != null && UserIconLayout.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.ww().channelId, UserIconLayout.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.vw().getUserId(), UserIconLayout.this.atZ.vw().getName_show(), UserIconLayout.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.ayi != null) {
                        UserIconLayout.this.ayi.onClick(view);
                    }
                }
            }
        };
        this.azt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atZ != null && UserIconLayout.this.atZ.ww() != null && UserIconLayout.this.atZ.ww().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atZ.ww().channelId, UserIconLayout.this.atZ.ww().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.azm.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, i));
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
        this.ayK = new UserIconBox(this.mContext);
        this.ayM = new UserIconBox(this.mContext);
        this.azm = new TextView(this.mContext);
        this.ayR = com.baidu.tbadk.ala.b.rM().f(this.mContext, 1);
        if (this.ayR != null) {
            this.ayR.setVisibility(8);
        }
        this.azn = new ImageView(this.mContext);
        if (this.azn != null) {
            this.azn.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds3), 0, 0);
        this.azm.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.fontsize24));
        if (!this.azq) {
            this.azm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ayK.setLayoutParams(layoutParams);
        this.ayM.setLayoutParams(layoutParams2);
        this.azm.setLayoutParams(layoutParams3);
        this.azn.setLayoutParams(layoutParams4);
        addView(this.ayK);
        addView(this.azm);
        if (this.azn != null) {
            addView(this.azn);
        }
        if (this.ayR != null) {
            addView(this.ayR);
        }
        addView(this.ayM);
    }

    public void setData(bc bcVar) {
        int i;
        if (bcVar != null && bcVar.vw() != null) {
            this.atZ = bcVar;
            this.ayK.setOnClickListener(this.ayX);
            this.ayM.setOnClickListener(this.ayY);
            this.azm.setOnClickListener(this.ayk);
            this.azn.setOnClickListener(this.azt);
            if (bcVar.vw() != null && bcVar.vw().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bcVar.vw().getAlaUserData();
                if (this.ayR != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aan = alaUserData;
                    aVar.type = 1;
                    this.ayR.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.atZ.ww() != null && this.atZ.ww().channelId > 0) {
                this.azm.setText(x.u(this.atZ.ww().channelName, 20));
                this.ayM.setVisibility(8);
                this.ayK.setVisibility(8);
                if (this.azp) {
                    this.azn.setVisibility(0);
                } else {
                    this.azn.setVisibility(8);
                }
                am.h(this.azm, d.C0142d.cp_cont_b);
                return;
            }
            this.azn.setVisibility(8);
            if (StringUtils.isNull(this.atZ.vw().getName_show())) {
                this.azm.setVisibility(8);
                i = 4;
            } else {
                this.azm.setVisibility(0);
                String name_show = this.atZ.vw().getName_show();
                if (this.azq) {
                    if (this.azs) {
                        this.azm.setText(ak(this.atZ.vw().getSealPrefix(), x.u(name_show, 20)));
                        int bi = com.baidu.adp.lib.util.k.bi(name_show);
                        if (bi >= 20) {
                            i2 = 1;
                        } else if (bi >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.azm.setText(x.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.azs) {
                    this.azm.setText(ak(this.atZ.vw().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.azm.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bcVar.vw().getIconInfo();
            if (this.azo && w.z(iconInfo) != 0) {
                this.ayM.setVisibility(0);
                this.ayM.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.ayM.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bcVar.vw().getTShowInfoNew();
            if (w.z(tShowInfoNew) != 0) {
                this.ayK.setVisibility(0);
                this.ayK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.ayK.setVisibility(8);
            }
            setUserTextColor(bcVar);
        }
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bc bcVar) {
        if (this.atZ != null && this.atZ.vw() != null) {
            if (!w.A(this.atZ.vw().getTShowInfoNew()) || this.atZ.vw().isBigV()) {
                am.h(this.azm, d.C0142d.cp_cont_h);
                if (bcVar.vw() != null && bcVar.vw().getAlaUserData() != null) {
                    bcVar.vw().getAlaUserData();
                    return;
                }
                return;
            }
            am.h(this.azm, d.C0142d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ayi = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.azq = z;
    }

    public void setPageName(int i) {
        this.azr = i;
    }
}

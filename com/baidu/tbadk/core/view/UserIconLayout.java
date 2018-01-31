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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bd aYc;
    private UserIconBox bcN;
    private UserIconBox bcP;
    private View.OnClickListener bcY;
    private View.OnClickListener bcZ;
    private View.OnClickListener bcm;
    private View.OnClickListener bco;
    public TextView bdn;
    private View bdo;
    private ImageView bdp;
    public boolean bdq;
    public boolean bdr;
    private boolean bds;
    private int bdt;
    private boolean bdu;
    private View.OnClickListener bdv;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bdq = false;
        this.bdr = false;
        this.bds = false;
        this.bdt = 0;
        this.bdu = false;
        this.bcZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aYc.yT().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdt == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.bb(UserIconLayout.this.mContext) && UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null && UserIconLayout.this.aYc.yT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aYc.yT().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aYc.yT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null && !StringUtils.isNull(UserIconLayout.this.aYc.yT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aYc.yT().getUserId()) && UserIconLayout.this.aYc.yZ() != null) {
                    if (UserIconLayout.this.aYc.zV() != null && UserIconLayout.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.zV().channelId, UserIconLayout.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.yT().getUserId(), UserIconLayout.this.aYc.yT().getName_show(), UserIconLayout.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bcm != null) {
                        UserIconLayout.this.bcm.onClick(view);
                    }
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.zV() != null && UserIconLayout.this.aYc.zV().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.zV().channelId, UserIconLayout.this.aYc.zV().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdq = false;
        this.bdr = false;
        this.bds = false;
        this.bdt = 0;
        this.bdu = false;
        this.bcZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aYc.yT().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdt == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.bb(UserIconLayout.this.mContext) && UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null && UserIconLayout.this.aYc.yT().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aYc.yT().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aYc.yT().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.yT() != null && !StringUtils.isNull(UserIconLayout.this.aYc.yT().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aYc.yT().getUserId()) && UserIconLayout.this.aYc.yZ() != null) {
                    if (UserIconLayout.this.aYc.zV() != null && UserIconLayout.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.zV().channelId, UserIconLayout.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.yT().getUserId(), UserIconLayout.this.aYc.yT().getName_show(), UserIconLayout.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bcm != null) {
                        UserIconLayout.this.bcm.onClick(view);
                    }
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aYc != null && UserIconLayout.this.aYc.zV() != null && UserIconLayout.this.aYc.zV().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aYc.zV().channelId, UserIconLayout.this.aYc.zV().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bdn.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void bt(boolean z) {
        this.bdu = z;
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
        this.bcN = new UserIconBox(this.mContext);
        this.bcP = new UserIconBox(this.mContext);
        this.bdn = new TextView(this.mContext);
        this.bdo = com.baidu.tbadk.ala.b.uZ().t(this.mContext, 1);
        if (this.bdo != null) {
            this.bdo.setVisibility(8);
        }
        this.bdp = new ImageView(this.mContext);
        if (this.bdp != null) {
            this.bdp.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds3), 0, 0);
        this.bdn.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.fontsize24));
        if (!this.bds) {
            this.bdn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.bcN.setLayoutParams(layoutParams);
        this.bcP.setLayoutParams(layoutParams2);
        this.bdn.setLayoutParams(layoutParams3);
        this.bdp.setLayoutParams(layoutParams4);
        addView(this.bcN);
        addView(this.bdn);
        if (this.bdp != null) {
            addView(this.bdp);
        }
        if (this.bdo != null) {
            addView(this.bdo);
        }
        addView(this.bcP);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.yT() != null) {
            this.aYc = bdVar;
            this.bcN.setOnClickListener(this.bcY);
            this.bcP.setOnClickListener(this.bcZ);
            this.bdn.setOnClickListener(this.bco);
            this.bdp.setOnClickListener(this.bdv);
            if (bdVar.yT() != null && bdVar.yT().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.yT().getAlaUserData();
                if (this.bdo != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFL = alaUserData;
                    aVar.type = 1;
                    this.bdo.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aYc.zV() != null && this.aYc.zV().channelId > 0) {
                this.bdn.setText(w.u(this.aYc.zV().channelName, 20));
                this.bcP.setVisibility(8);
                this.bcN.setVisibility(8);
                if (this.bdr) {
                    this.bdp.setVisibility(0);
                } else {
                    this.bdp.setVisibility(8);
                }
                aj.r(this.bdn, d.C0108d.cp_cont_b);
                return;
            }
            this.bdp.setVisibility(8);
            if (StringUtils.isNull(this.aYc.yT().getName_show())) {
                this.bdn.setVisibility(8);
                i = 4;
            } else {
                this.bdn.setVisibility(0);
                String name_show = this.aYc.yT().getName_show();
                if (this.bds) {
                    if (this.bdu) {
                        this.bdn.setText(ae(this.aYc.yT().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bdn.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bdu) {
                    this.bdn.setText(ae(this.aYc.yT().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bdn.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.yT().getIconInfo();
            if (this.bdq && v.D(iconInfo) != 0) {
                this.bcP.setVisibility(0);
                this.bcP.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.bcP.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.yT().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bcN.setVisibility(0);
                this.bcN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.bcN.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a(this.mContext, str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.aYc != null && this.aYc.yT() != null) {
            if (!v.E(this.aYc.yT().getTShowInfoNew()) || this.aYc.yT().isBigV()) {
                aj.r(this.bdn, d.C0108d.cp_cont_h);
                if (bdVar.yT() != null && bdVar.yT().getAlaUserData() != null) {
                    bdVar.yT().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.bdn, d.C0108d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aYc);
        if (this.aYc != null && this.aYc.zV() != null && this.aYc.zV().channelId > 0) {
            aj.r(this.bdn, d.C0108d.cp_cont_b);
        }
        if (this.bdp != null) {
            aj.s(this.bdp, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bcm = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bds = z;
    }

    public void setPageName(int i) {
        this.bdt = i;
    }
}

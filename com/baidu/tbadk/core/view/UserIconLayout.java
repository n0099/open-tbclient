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
    private bd aXU;
    private UserIconBox bcF;
    private UserIconBox bcH;
    private View.OnClickListener bcQ;
    private View.OnClickListener bcR;
    private View.OnClickListener bce;
    private View.OnClickListener bcg;
    public TextView bdf;
    private View bdg;
    private ImageView bdh;
    public boolean bdi;
    public boolean bdj;
    private boolean bdk;
    private int bdl;
    private boolean bdm;
    private View.OnClickListener bdn;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.bdi = false;
        this.bdj = false;
        this.bdk = false;
        this.bdl = 0;
        this.bdm = false;
        this.bcR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aXU.yS().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdl == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(UserIconLayout.this.mContext) && UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null && UserIconLayout.this.aXU.yS().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aXU.yS().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aXU.yS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null && !StringUtils.isNull(UserIconLayout.this.aXU.yS().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aXU.yS().getUserId()) && UserIconLayout.this.aXU.yY() != null) {
                    if (UserIconLayout.this.aXU.zU() != null && UserIconLayout.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.zU().channelId, UserIconLayout.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.yS().getUserId(), UserIconLayout.this.aXU.yS().getName_show(), UserIconLayout.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bce != null) {
                        UserIconLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bdn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.zU() != null && UserIconLayout.this.aXU.zU().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.zU().channelId, UserIconLayout.this.aXU.zU().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdi = false;
        this.bdj = false;
        this.bdk = false;
        this.bdl = 0;
        this.bdm = false;
        this.bcR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aXU.yS().getUserId(), true, true, true);
                    if (UserIconLayout.this.bdl == 1) {
                        TiebaStatic.log(new ak("c10134").s("obj_type", 3));
                    }
                }
            }
        };
        this.bcQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.be(UserIconLayout.this.mContext) && UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null && UserIconLayout.this.aXU.yS().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aXU.yS().getTShowInfoNew();
                    if (v.D(tShowInfoNew) != 0 && v.f(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aXU.yS().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ak(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.yS() != null && !StringUtils.isNull(UserIconLayout.this.aXU.yS().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aXU.yS().getUserId()) && UserIconLayout.this.aXU.yY() != null) {
                    if (UserIconLayout.this.aXU.zU() != null && UserIconLayout.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.zU().channelId, UserIconLayout.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.yS().getUserId(), UserIconLayout.this.aXU.yS().getName_show(), UserIconLayout.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.bce != null) {
                        UserIconLayout.this.bce.onClick(view);
                    }
                }
            }
        };
        this.bdn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aXU != null && UserIconLayout.this.aXU.zU() != null && UserIconLayout.this.aXU.zU().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aXU.zU().channelId, UserIconLayout.this.aXU.zU().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.bdf.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, i));
    }

    public void bs(boolean z) {
        this.bdm = z;
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
        this.bcF = new UserIconBox(this.mContext);
        this.bcH = new UserIconBox(this.mContext);
        this.bdf = new TextView(this.mContext);
        this.bdg = com.baidu.tbadk.ala.b.uY().t(this.mContext, 1);
        if (this.bdg != null) {
            this.bdg.setVisibility(8);
        }
        this.bdh = new ImageView(this.mContext);
        if (this.bdh != null) {
            this.bdh.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds3), 0, 0);
        this.bdf.setTextSize(0, com.baidu.adp.lib.util.l.s(this.mContext, d.e.fontsize24));
        if (!this.bdk) {
            this.bdf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.bcF.setLayoutParams(layoutParams);
        this.bcH.setLayoutParams(layoutParams2);
        this.bdf.setLayoutParams(layoutParams3);
        this.bdh.setLayoutParams(layoutParams4);
        addView(this.bcF);
        addView(this.bdf);
        if (this.bdh != null) {
            addView(this.bdh);
        }
        if (this.bdg != null) {
            addView(this.bdg);
        }
        addView(this.bcH);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.yS() != null) {
            this.aXU = bdVar;
            this.bcF.setOnClickListener(this.bcQ);
            this.bcH.setOnClickListener(this.bcR);
            this.bdf.setOnClickListener(this.bcg);
            this.bdh.setOnClickListener(this.bdn);
            if (bdVar.yS() != null && bdVar.yS().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.yS().getAlaUserData();
                if (this.bdg != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aFI = alaUserData;
                    aVar.type = 1;
                    this.bdg.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aXU.zU() != null && this.aXU.zU().channelId > 0) {
                this.bdf.setText(w.u(this.aXU.zU().channelName, 20));
                this.bcH.setVisibility(8);
                this.bcF.setVisibility(8);
                if (this.bdj) {
                    this.bdh.setVisibility(0);
                } else {
                    this.bdh.setVisibility(8);
                }
                aj.r(this.bdf, d.C0107d.cp_cont_b);
                return;
            }
            this.bdh.setVisibility(8);
            if (StringUtils.isNull(this.aXU.yS().getName_show())) {
                this.bdf.setVisibility(8);
                i = 4;
            } else {
                this.bdf.setVisibility(0);
                String name_show = this.aXU.yS().getName_show();
                if (this.bdk) {
                    if (this.bdm) {
                        this.bdf.setText(af(this.aXU.yS().getSealPrefix(), w.u(name_show, 20)));
                        int aX = com.baidu.adp.lib.util.k.aX(name_show);
                        if (aX >= 20) {
                            i2 = 1;
                        } else if (aX >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.bdf.setText(w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.bdm) {
                    this.bdf.setText(af(this.aXU.yS().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.bdf.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.yS().getIconInfo();
            if (this.bdi && v.D(iconInfo) != 0) {
                this.bcH.setVisibility(0);
                this.bcH.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.bcH.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.yS().getTShowInfoNew();
            if (v.D(tShowInfoNew) != 0) {
                this.bcF.setVisibility(0);
                this.bcF.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.bcF.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a(this.mContext, str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.aXU != null && this.aXU.yS() != null) {
            if (!v.E(this.aXU.yS().getTShowInfoNew()) || this.aXU.yS().isBigV()) {
                aj.r(this.bdf, d.C0107d.cp_cont_h);
                if (bdVar.yS() != null && bdVar.yS().getAlaUserData() != null) {
                    bdVar.yS().getAlaUserData();
                    return;
                }
                return;
            }
            aj.r(this.bdf, d.C0107d.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aXU);
        if (this.aXU != null && this.aXU.zU() != null && this.aXU.zU().channelId > 0) {
            aj.r(this.bdf, d.C0107d.cp_cont_b);
        }
        if (this.bdh != null) {
            aj.s(this.bdh, d.f.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bce = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.bdk = z;
    }

    public void setPageName(int i) {
        this.bdl = i;
    }
}

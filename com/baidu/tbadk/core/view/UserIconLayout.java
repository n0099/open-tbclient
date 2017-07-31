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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bl akj;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    public TextView apG;
    private ImageView apH;
    public boolean apI;
    public boolean apJ;
    private boolean apK;
    private int apL;
    private boolean apM;
    private View.OnClickListener apN;
    private UserIconBox apm;
    private UserIconBox apn;
    private View apr;
    private View.OnClickListener apt;
    private View.OnClickListener apu;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apI = false;
        this.apJ = false;
        this.apK = false;
        this.apL = 0;
        this.apM = false;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.akj.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apL == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(UserIconLayout.this.mContext) && UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null && UserIconLayout.this.akj.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.akj.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.akj.getAuthor().getUserId()) && UserIconLayout.this.akj.rK() != null) {
                    if (UserIconLayout.this.akj.sJ() != null && UserIconLayout.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.sJ().channelId, UserIconLayout.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.getAuthor().getUserId(), UserIconLayout.this.akj.getAuthor().getName_show(), UserIconLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aoW != null) {
                        UserIconLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        this.apN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.sJ() != null && UserIconLayout.this.akj.sJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.sJ().channelId, UserIconLayout.this.akj.sJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apI = false;
        this.apJ = false;
        this.apK = false;
        this.apL = 0;
        this.apM = false;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.akj.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apL == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(UserIconLayout.this.mContext) && UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null && UserIconLayout.this.akj.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.akj.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.akj.getAuthor().getUserId()) && UserIconLayout.this.akj.rK() != null) {
                    if (UserIconLayout.this.akj.sJ() != null && UserIconLayout.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.sJ().channelId, UserIconLayout.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.getAuthor().getUserId(), UserIconLayout.this.akj.getAuthor().getName_show(), UserIconLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aoW != null) {
                        UserIconLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        this.apN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akj != null && UserIconLayout.this.akj.sJ() != null && UserIconLayout.this.akj.sJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akj.sJ().channelId, UserIconLayout.this.akj.sJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.apG.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.apM = z;
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
        this.apm = new UserIconBox(this.mContext);
        this.apn = new UserIconBox(this.mContext);
        this.apG = new TextView(this.mContext);
        this.apr = com.baidu.tbadk.ala.b.nC().h(this.mContext, 1);
        if (this.apr != null) {
            this.apr.setVisibility(8);
        }
        this.apH = new ImageView(this.mContext);
        if (this.apH != null) {
            this.apH.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds3), 0, 0);
        this.apG.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.fontsize24));
        if (!this.apK) {
            this.apG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.apm.setLayoutParams(layoutParams);
        this.apn.setLayoutParams(layoutParams2);
        this.apG.setLayoutParams(layoutParams3);
        this.apH.setLayoutParams(layoutParams4);
        addView(this.apm);
        addView(this.apG);
        if (this.apH != null) {
            addView(this.apH);
        }
        if (this.apr != null) {
            addView(this.apr);
        }
        addView(this.apn);
    }

    public void setData(bl blVar) {
        int i;
        if (blVar != null && blVar.getAuthor() != null) {
            this.akj = blVar;
            this.apm.setOnClickListener(this.apt);
            this.apn.setOnClickListener(this.apu);
            this.apG.setOnClickListener(this.aoX);
            this.apH.setOnClickListener(this.apN);
            if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                if (this.apr != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Ro = alaUserData;
                    aVar.type = 1;
                    this.apr.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.apr.setVisibility(8);
                    } else {
                        this.apr.setVisibility(0);
                    }
                }
            }
            int i2 = 3;
            if (this.akj.sJ() != null && this.akj.sJ().channelId > 0) {
                this.apG.setText(v.u(this.akj.sJ().channelName, 20));
                this.apn.setVisibility(8);
                this.apm.setVisibility(8);
                if (this.apJ) {
                    this.apH.setVisibility(0);
                } else {
                    this.apH.setVisibility(8);
                }
                ai.i(this.apG, d.e.cp_cont_b);
                return;
            }
            this.apH.setVisibility(8);
            if (StringUtils.isNull(this.akj.getAuthor().getName_show())) {
                this.apG.setVisibility(8);
                i = 3;
            } else {
                this.apG.setVisibility(0);
                String name_show = this.akj.getAuthor().getName_show();
                if (this.apK) {
                    if (this.apM) {
                        this.apG.setText(ae(this.akj.getAuthor().getSealPrefix(), v.u(name_show, 20)));
                        int aS = com.baidu.adp.lib.util.j.aS(name_show);
                        if (aS >= 20) {
                            i2 = 1;
                        } else if (aS >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.apG.setText(v.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.apM) {
                    this.apG.setText(ae(this.akj.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.apG.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (this.apI && u.u(iconInfo) != 0) {
                this.apn.setVisibility(0);
                this.apn.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.apn.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apm.setVisibility(0);
                this.apm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.apm.setVisibility(8);
            }
            setUserTextColor(blVar);
        }
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return com.baidu.tieba.card.m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bl blVar) {
        if (this.akj != null && this.akj.getAuthor() != null) {
            if (!u.v(this.akj.getAuthor().getTShowInfoNew()) || this.akj.getAuthor().isBigV()) {
                ai.i(this.apG, d.e.cp_cont_h);
                if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                    if (this.apr != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
                        this.apm.setLayoutParams(layoutParams);
                        this.apn.setLayoutParams(layoutParams2);
                        this.apG.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            ai.i(this.apG, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.akj);
        if (this.akj != null && this.akj.sJ() != null && this.akj.sJ().channelId > 0) {
            ai.i(this.apG, d.e.cp_cont_b);
        }
        if (this.apH != null) {
            ai.j(this.apH, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoW = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apK = z;
    }

    public void setPageName(int i) {
        this.apL = i;
    }
}

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
    private bl aiQ;
    private View.OnClickListener anD;
    private View.OnClickListener anE;
    private UserIconBox anT;
    private UserIconBox anU;
    private View anX;
    private View.OnClickListener anZ;
    private View.OnClickListener aoa;
    public TextView aom;
    private ImageView aon;
    public boolean aoo;
    public boolean aop;
    private boolean aoq;
    private int aor;
    private boolean aos;
    private View.OnClickListener aot;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aoo = false;
        this.aop = false;
        this.aoq = false;
        this.aor = 0;
        this.aos = false;
        this.aoa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aiQ.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aor == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(UserIconLayout.this.mContext) && UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null && UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Z(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiQ.getAuthor().getUserId()) && UserIconLayout.this.aiQ.rA() != null) {
                    if (UserIconLayout.this.aiQ.sz() != null && UserIconLayout.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.sz().channelId, UserIconLayout.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.getAuthor().getUserId(), UserIconLayout.this.aiQ.getAuthor().getName_show(), UserIconLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anD != null) {
                        UserIconLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.aot = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.sz() != null && UserIconLayout.this.aiQ.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.sz().channelId, UserIconLayout.this.aiQ.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoo = false;
        this.aop = false;
        this.aoq = false;
        this.aor = 0;
        this.aos = false;
        this.aoa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aiQ.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aor == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(UserIconLayout.this.mContext) && UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null && UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Z(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiQ.getAuthor().getUserId()) && UserIconLayout.this.aiQ.rA() != null) {
                    if (UserIconLayout.this.aiQ.sz() != null && UserIconLayout.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.sz().channelId, UserIconLayout.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.getAuthor().getUserId(), UserIconLayout.this.aiQ.getAuthor().getName_show(), UserIconLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anD != null) {
                        UserIconLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.aot = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiQ != null && UserIconLayout.this.aiQ.sz() != null && UserIconLayout.this.aiQ.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiQ.sz().channelId, UserIconLayout.this.aiQ.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aom.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.aos = z;
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
        this.anT = new UserIconBox(this.mContext);
        this.anU = new UserIconBox(this.mContext);
        this.aom = new TextView(this.mContext);
        this.anX = com.baidu.tbadk.ala.b.ns().h(this.mContext, 1);
        if (this.anX != null) {
            this.anX.setVisibility(8);
        }
        this.aon = new ImageView(this.mContext);
        if (this.aon != null) {
            this.aon.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds3), 0, 0);
        this.aom.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.fontsize24));
        if (!this.aoq) {
            this.aom.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.anT.setLayoutParams(layoutParams);
        this.anU.setLayoutParams(layoutParams2);
        this.aom.setLayoutParams(layoutParams3);
        this.aon.setLayoutParams(layoutParams4);
        addView(this.anT);
        addView(this.aom);
        if (this.aon != null) {
            addView(this.aon);
        }
        if (this.anX != null) {
            addView(this.anX);
        }
        addView(this.anU);
    }

    public void setData(bl blVar) {
        int i;
        if (blVar != null && blVar.getAuthor() != null) {
            this.aiQ = blVar;
            this.anT.setOnClickListener(this.anZ);
            this.anU.setOnClickListener(this.aoa);
            this.aom.setOnClickListener(this.anE);
            this.aon.setOnClickListener(this.aot);
            if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                if (this.anX != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PQ = alaUserData;
                    aVar.type = 1;
                    this.anX.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.anX.setVisibility(8);
                    } else {
                        this.anX.setVisibility(0);
                    }
                }
            }
            int i2 = 3;
            if (this.aiQ.sz() != null && this.aiQ.sz().channelId > 0) {
                this.aom.setText(v.u(this.aiQ.sz().channelName, 20));
                this.anU.setVisibility(8);
                this.anT.setVisibility(8);
                if (this.aop) {
                    this.aon.setVisibility(0);
                } else {
                    this.aon.setVisibility(8);
                }
                ai.i(this.aom, d.e.cp_cont_b);
                return;
            }
            this.aon.setVisibility(8);
            if (StringUtils.isNull(this.aiQ.getAuthor().getName_show())) {
                this.aom.setVisibility(8);
                i = 3;
            } else {
                this.aom.setVisibility(0);
                String name_show = this.aiQ.getAuthor().getName_show();
                if (this.aoq) {
                    if (this.aos) {
                        this.aom.setText(ae(this.aiQ.getAuthor().getSealPrefix(), v.u(name_show, 20)));
                        int aM = com.baidu.adp.lib.util.j.aM(name_show);
                        if (aM >= 20) {
                            i2 = 1;
                        } else if (aM >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aom.setText(v.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.aos) {
                    this.aom.setText(ae(this.aiQ.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.aom.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (this.aoo && u.u(iconInfo) != 0) {
                this.anU.setVisibility(0);
                this.anU.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.anU.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.anT.setVisibility(0);
                this.anT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.anT.setVisibility(8);
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
        if (this.aiQ != null && this.aiQ.getAuthor() != null) {
            if (!u.v(this.aiQ.getAuthor().getTShowInfoNew()) || this.aiQ.getAuthor().isBigV()) {
                ai.i(this.aom, d.e.cp_cont_h);
                if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                    if (this.anX != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
                        this.anT.setLayoutParams(layoutParams);
                        this.anU.setLayoutParams(layoutParams2);
                        this.aom.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            ai.i(this.aom, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aiQ);
        if (this.aiQ != null && this.aiQ.sz() != null && this.aiQ.sz().channelId > 0) {
            ai.i(this.aom, d.e.cp_cont_b);
        }
        if (this.aon != null) {
            ai.j(this.aon, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anD = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aoq = z;
    }

    public void setPageName(int i) {
        this.aor = i;
    }
}

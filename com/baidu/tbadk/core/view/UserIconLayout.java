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
    private bl akl;
    private View.OnClickListener aoX;
    private View.OnClickListener aoY;
    public TextView apH;
    private ImageView apI;
    public boolean apJ;
    public boolean apK;
    private boolean apL;
    private int apM;
    private boolean apN;
    private View.OnClickListener apO;
    private UserIconBox apn;
    private UserIconBox apo;
    private View aps;
    private View.OnClickListener apu;
    private View.OnClickListener apv;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.apJ = false;
        this.apK = false;
        this.apL = false;
        this.apM = 0;
        this.apN = false;
        this.apv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.akl.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apM == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(UserIconLayout.this.mContext) && UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null && UserIconLayout.this.akl.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.akl.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.akl.getAuthor().getUserId()) && UserIconLayout.this.akl.rL() != null) {
                    if (UserIconLayout.this.akl.sK() != null && UserIconLayout.this.akl.sK().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.sK().channelId, UserIconLayout.this.akl.sK().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.getAuthor().getUserId(), UserIconLayout.this.akl.getAuthor().getName_show(), UserIconLayout.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aoX != null) {
                        UserIconLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.apO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.sK() != null && UserIconLayout.this.akl.sK().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.sK().channelId, UserIconLayout.this.akl.sK().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apJ = false;
        this.apK = false;
        this.apL = false;
        this.apM = 0;
        this.apN = false;
        this.apv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.akl.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.apM == 1) {
                        TiebaStatic.log(new aj("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.apu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(UserIconLayout.this.mContext) && UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null && UserIconLayout.this.akl.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.akl.getAuthor().getTShowInfoNew();
                    if (u.u(tShowInfoNew) != 0 && u.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aa(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.akl.getAuthor().getUserId()) && UserIconLayout.this.akl.rL() != null) {
                    if (UserIconLayout.this.akl.sK() != null && UserIconLayout.this.akl.sK().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.sK().channelId, UserIconLayout.this.akl.sK().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.getAuthor().getUserId(), UserIconLayout.this.akl.getAuthor().getName_show(), UserIconLayout.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aoX != null) {
                        UserIconLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.apO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.akl != null && UserIconLayout.this.akl.sK() != null && UserIconLayout.this.akl.sK().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.akl.sK().channelId, UserIconLayout.this.akl.sK().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.apH.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.apN = z;
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
        this.apn = new UserIconBox(this.mContext);
        this.apo = new UserIconBox(this.mContext);
        this.apH = new TextView(this.mContext);
        this.aps = com.baidu.tbadk.ala.b.nD().h(this.mContext, 1);
        if (this.aps != null) {
            this.aps.setVisibility(8);
        }
        this.apI = new ImageView(this.mContext);
        if (this.apI != null) {
            this.apI.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds3), 0, 0);
        this.apH.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.fontsize24));
        if (!this.apL) {
            this.apH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.apn.setLayoutParams(layoutParams);
        this.apo.setLayoutParams(layoutParams2);
        this.apH.setLayoutParams(layoutParams3);
        this.apI.setLayoutParams(layoutParams4);
        addView(this.apn);
        addView(this.apH);
        if (this.apI != null) {
            addView(this.apI);
        }
        if (this.aps != null) {
            addView(this.aps);
        }
        addView(this.apo);
    }

    public void setData(bl blVar) {
        int i;
        if (blVar != null && blVar.getAuthor() != null) {
            this.akl = blVar;
            this.apn.setOnClickListener(this.apu);
            this.apo.setOnClickListener(this.apv);
            this.apH.setOnClickListener(this.aoY);
            this.apI.setOnClickListener(this.apO);
            if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                if (this.aps != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rq = alaUserData;
                    aVar.type = 1;
                    this.aps.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.aps.setVisibility(8);
                    } else {
                        this.aps.setVisibility(0);
                    }
                }
            }
            int i2 = 3;
            if (this.akl.sK() != null && this.akl.sK().channelId > 0) {
                this.apH.setText(v.u(this.akl.sK().channelName, 20));
                this.apo.setVisibility(8);
                this.apn.setVisibility(8);
                if (this.apK) {
                    this.apI.setVisibility(0);
                } else {
                    this.apI.setVisibility(8);
                }
                ai.i(this.apH, d.e.cp_cont_b);
                return;
            }
            this.apI.setVisibility(8);
            if (StringUtils.isNull(this.akl.getAuthor().getName_show())) {
                this.apH.setVisibility(8);
                i = 3;
            } else {
                this.apH.setVisibility(0);
                String name_show = this.akl.getAuthor().getName_show();
                if (this.apL) {
                    if (this.apN) {
                        this.apH.setText(ae(this.akl.getAuthor().getSealPrefix(), v.u(name_show, 20)));
                        int aT = com.baidu.adp.lib.util.j.aT(name_show);
                        if (aT >= 20) {
                            i2 = 1;
                        } else if (aT >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.apH.setText(v.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.apN) {
                    this.apH.setText(ae(this.akl.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.apH.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (this.apJ && u.u(iconInfo) != 0) {
                this.apo.setVisibility(0);
                this.apo.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.apo.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apn.setVisibility(0);
                this.apn.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.apn.setVisibility(8);
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
        if (this.akl != null && this.akl.getAuthor() != null) {
            if (!u.v(this.akl.getAuthor().getTShowInfoNew()) || this.akl.getAuthor().isBigV()) {
                ai.i(this.apH, d.e.cp_cont_h);
                if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                    if (this.aps != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds2), 0, 0);
                        this.apn.setLayoutParams(layoutParams);
                        this.apo.setLayoutParams(layoutParams2);
                        this.apH.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            ai.i(this.apH, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.akl);
        if (this.akl != null && this.akl.sK() != null && this.akl.sK().channelId > 0) {
            ai.i(this.apH, d.e.cp_cont_b);
        }
        if (this.apI != null) {
            ai.j(this.apI, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoX = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.apL = z;
    }

    public void setPageName(int i) {
        this.apM = i;
    }
}

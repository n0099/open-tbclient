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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh aiU;
    private UserIconBox anO;
    private UserIconBox anP;
    private View anT;
    private View.OnClickListener anV;
    private View.OnClickListener anW;
    private View.OnClickListener anx;
    private View.OnClickListener anz;
    public TextView aoi;
    private ImageView aoj;
    public boolean aok;
    public boolean aol;
    private boolean aom;
    private int aon;
    private boolean aoo;
    private View.OnClickListener aop;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aok = false;
        this.aol = false;
        this.aom = false;
        this.aon = 0;
        this.aoo = false;
        this.anW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aiU.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aon == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.anV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null && UserIconLayout.this.aiU.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiU.getAuthor().getTShowInfoNew();
                    if (v.t(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiU.getAuthor().getUserId()) && UserIconLayout.this.aiU.rt() != null) {
                    if (UserIconLayout.this.aiU.ss() != null && UserIconLayout.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.ss().channelId, UserIconLayout.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.getAuthor().getUserId(), UserIconLayout.this.aiU.getAuthor().getName_show(), UserIconLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anx != null) {
                        UserIconLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.aop = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.ss() != null && UserIconLayout.this.aiU.ss().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.ss().channelId, UserIconLayout.this.aiU.ss().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aok = false;
        this.aol = false;
        this.aom = false;
        this.aon = 0;
        this.aoo = false;
        this.anW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aiU.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aon == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.anV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(UserIconLayout.this.mContext) && UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null && UserIconLayout.this.aiU.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aiU.getAuthor().getTShowInfoNew();
                    if (v.t(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aiU.getAuthor().getUserId()) && UserIconLayout.this.aiU.rt() != null) {
                    if (UserIconLayout.this.aiU.ss() != null && UserIconLayout.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.ss().channelId, UserIconLayout.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.getAuthor().getUserId(), UserIconLayout.this.aiU.getAuthor().getName_show(), UserIconLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anx != null) {
                        UserIconLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.aop = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aiU != null && UserIconLayout.this.aiU.ss() != null && UserIconLayout.this.aiU.ss().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aiU.ss().channelId, UserIconLayout.this.aiU.ss().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aoi.setTextSize(0, l.f(this.mContext, i));
    }

    public void aN(boolean z) {
        this.aoo = z;
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
        this.anO = new UserIconBox(this.mContext);
        this.anP = new UserIconBox(this.mContext);
        this.aoi = new TextView(this.mContext);
        this.anT = com.baidu.tbadk.ala.b.nr().g(this.mContext, 1);
        if (this.anT != null) {
            this.anT.setVisibility(8);
        }
        this.aoj = new ImageView(this.mContext);
        if (this.aoj != null) {
            this.aoj.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.f.ds10), l.f(this.mContext, d.f.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.f.ds14), -l.f(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.f.ds8), l.f(this.mContext, d.f.ds3), 0, 0);
        this.aoi.setTextSize(0, l.f(this.mContext, d.f.fontsize24));
        if (!this.aom) {
            this.aoi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.anO.setLayoutParams(layoutParams);
        this.anP.setLayoutParams(layoutParams2);
        this.aoi.setLayoutParams(layoutParams3);
        this.aoj.setLayoutParams(layoutParams4);
        addView(this.anO);
        addView(this.aoi);
        if (this.aoj != null) {
            addView(this.aoj);
        }
        if (this.anT != null) {
            addView(this.anT);
        }
        addView(this.anP);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.aiU = bhVar;
            this.anO.setOnClickListener(this.anV);
            this.anP.setOnClickListener(this.anW);
            this.aoi.setOnClickListener(this.anz);
            this.aoj.setOnClickListener(this.aop);
            if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.getAuthor().getAlaUserData();
                if (this.anT != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Qv = alaUserData;
                    aVar.type = 1;
                    this.anT.setTag(aVar);
                }
            }
            int i2 = 3;
            if (this.aiU.ss() != null && this.aiU.ss().channelId > 0) {
                this.aoi.setText(u.u(this.aiU.ss().channelName, 20));
                this.anP.setVisibility(8);
                this.anO.setVisibility(8);
                if (this.aol) {
                    this.aoj.setVisibility(0);
                } else {
                    this.aoj.setVisibility(8);
                }
                aj.i(this.aoi, d.e.cp_cont_b);
                return;
            }
            this.aoj.setVisibility(8);
            if (StringUtils.isNull(this.aiU.getAuthor().getName_show())) {
                this.aoi.setVisibility(8);
                i = 3;
            } else {
                this.aoi.setVisibility(0);
                String name_show = this.aiU.getAuthor().getName_show();
                if (this.aom) {
                    if (this.aoo) {
                        this.aoi.setText(ag(this.aiU.getAuthor().getSealPrefix(), u.u(name_show, 20)));
                        int aP = k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aoi.setText(u.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.aoo) {
                    this.aoi.setText(ag(this.aiU.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.aoi.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.getAuthor().getIconInfo();
            if (this.aok && v.t(iconInfo) != 0) {
                this.anP.setVisibility(0);
                this.anP.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.anP.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.anO.setVisibility(0);
                this.anO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.anO.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.aiU != null && this.aiU.getAuthor() != null) {
            if (!v.u(this.aiU.getAuthor().getTShowInfoNew()) || this.aiU.getAuthor().isBigV()) {
                aj.i(this.aoi, d.e.cp_cont_h);
                if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                    bhVar.getAuthor().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.aoi, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aiU);
        if (this.aiU != null && this.aiU.ss() != null && this.aiU.ss().channelId > 0) {
            aj.i(this.aoi, d.e.cp_cont_b);
        }
        if (this.aoj != null) {
            aj.j(this.aoj, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aom = z;
    }

    public void setPageName(int i) {
        this.aon = i;
    }
}

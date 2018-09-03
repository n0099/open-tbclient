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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bb atE;
    private View.OnClickListener axL;
    private View.OnClickListener axN;
    private View ayB;
    private View.OnClickListener ayG;
    private View.OnClickListener ayH;
    public TextView ayV;
    private ImageView ayW;
    public boolean ayX;
    public boolean ayY;
    private boolean ayZ;
    private UserIconBox ayu;
    private UserIconBox ayw;
    private int aza;
    private boolean azb;
    private View.OnClickListener azc;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ayX = false;
        this.ayY = false;
        this.ayZ = false;
        this.aza = 0;
        this.azb = false;
        this.ayH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atE.vj().getUserId(), true, true, true);
                    if (UserIconLayout.this.aza == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (com.baidu.tbadk.core.util.bb.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null && UserIconLayout.this.atE.vj().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atE.vj().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atE.vj().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null && !StringUtils.isNull(UserIconLayout.this.atE.vj().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atE.vj().getUserId()) && UserIconLayout.this.atE.vp() != null) {
                    if (UserIconLayout.this.atE.wk() != null && UserIconLayout.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.wk().channelId, UserIconLayout.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.vj().getUserId(), UserIconLayout.this.atE.vj().getName_show(), UserIconLayout.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axL != null) {
                        UserIconLayout.this.axL.onClick(view);
                    }
                }
            }
        };
        this.azc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.wk() != null && UserIconLayout.this.atE.wk().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.wk().channelId, UserIconLayout.this.atE.wk().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayX = false;
        this.ayY = false;
        this.ayZ = false;
        this.aza = 0;
        this.azb = false;
        this.ayH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atE.vj().getUserId(), true, true, true);
                    if (UserIconLayout.this.aza == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (com.baidu.tbadk.core.util.bb.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null && UserIconLayout.this.atE.vj().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atE.vj().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atE.vj().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.vj() != null && !StringUtils.isNull(UserIconLayout.this.atE.vj().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atE.vj().getUserId()) && UserIconLayout.this.atE.vp() != null) {
                    if (UserIconLayout.this.atE.wk() != null && UserIconLayout.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.wk().channelId, UserIconLayout.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.vj().getUserId(), UserIconLayout.this.atE.vj().getName_show(), UserIconLayout.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axL != null) {
                        UserIconLayout.this.axL.onClick(view);
                    }
                }
            }
        };
        this.azc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atE != null && UserIconLayout.this.atE.wk() != null && UserIconLayout.this.atE.wk().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atE.wk().channelId, UserIconLayout.this.atE.wk().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ayV.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, i));
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
        this.ayu = new UserIconBox(this.mContext);
        this.ayw = new UserIconBox(this.mContext);
        this.ayV = new TextView(this.mContext);
        this.ayB = com.baidu.tbadk.ala.b.rv().g(this.mContext, 1);
        if (this.ayB != null) {
            this.ayB.setVisibility(8);
        }
        this.ayW = new ImageView(this.mContext);
        if (this.ayW != null) {
            this.ayW.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds10), com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds14), -com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds8), com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds3), 0, 0);
        this.ayV.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, f.e.fontsize24));
        if (!this.ayZ) {
            this.ayV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ayu.setLayoutParams(layoutParams);
        this.ayw.setLayoutParams(layoutParams2);
        this.ayV.setLayoutParams(layoutParams3);
        this.ayW.setLayoutParams(layoutParams4);
        addView(this.ayu);
        addView(this.ayV);
        if (this.ayW != null) {
            addView(this.ayW);
        }
        if (this.ayB != null) {
            addView(this.ayB);
        }
        addView(this.ayw);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.vj() != null) {
            this.atE = bbVar;
            this.ayu.setOnClickListener(this.ayG);
            this.ayw.setOnClickListener(this.ayH);
            this.ayV.setOnClickListener(this.axN);
            this.ayW.setOnClickListener(this.azc);
            if (bbVar.vj() != null && bbVar.vj().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.vj().getAlaUserData();
                if (this.ayB != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZS = alaUserData;
                    aVar.type = 1;
                    this.ayB.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.atE.wk() != null && this.atE.wk().channelId > 0) {
                this.ayV.setText(com.baidu.tbadk.util.w.u(this.atE.wk().channelName, 20));
                this.ayw.setVisibility(8);
                this.ayu.setVisibility(8);
                if (this.ayY) {
                    this.ayW.setVisibility(0);
                } else {
                    this.ayW.setVisibility(8);
                }
                am.h(this.ayV, f.d.cp_cont_b);
                return;
            }
            this.ayW.setVisibility(8);
            if (StringUtils.isNull(this.atE.vj().getName_show())) {
                this.ayV.setVisibility(8);
                i = 4;
            } else {
                this.ayV.setVisibility(0);
                String name_show = this.atE.vj().getName_show();
                if (this.ayZ) {
                    if (this.azb) {
                        this.ayV.setText(ah(this.atE.vj().getSealPrefix(), com.baidu.tbadk.util.w.u(name_show, 20)));
                        int bj = com.baidu.adp.lib.util.k.bj(name_show);
                        if (bj >= 20) {
                            i2 = 1;
                        } else if (bj >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.ayV.setText(com.baidu.tbadk.util.w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.azb) {
                    this.ayV.setText(ah(this.atE.vj().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.ayV.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.vj().getIconInfo();
            if (this.ayX && w.y(iconInfo) != 0) {
                this.ayw.setVisibility(0);
                this.ayw.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(f.e.ds30), this.mContext.getResources().getDimensionPixelSize(f.e.ds30), this.mContext.getResources().getDimensionPixelSize(f.e.ds10), true);
            } else {
                this.ayw.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.vj().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.ayu.setVisibility(0);
                this.ayu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(f.e.ds36), this.mContext.getResources().getDimensionPixelSize(f.e.ds36), this.mContext.getResources().getDimensionPixelSize(f.e.ds8), true);
            } else {
                this.ayu.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, f.C0146f.pic_smalldot_title));
            return o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.atE != null && this.atE.vj() != null) {
            if (!w.z(this.atE.vj().getTShowInfoNew()) || this.atE.vj().isBigV()) {
                am.h(this.ayV, f.d.cp_cont_h);
                if (bbVar.vj() != null && bbVar.vj().getAlaUserData() != null) {
                    bbVar.vj().getAlaUserData();
                    return;
                }
                return;
            }
            am.h(this.ayV, f.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axL = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ayZ = z;
    }

    public void setPageName(int i) {
        this.aza = i;
    }
}

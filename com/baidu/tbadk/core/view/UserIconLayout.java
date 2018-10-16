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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bb aAQ;
    private UserIconBox aFY;
    public TextView aGD;
    private ImageView aGE;
    public boolean aGF;
    public boolean aGG;
    private boolean aGH;
    private int aGI;
    private boolean aGJ;
    private View.OnClickListener aGK;
    private UserIconBox aGb;
    private View aGg;
    private View.OnClickListener aGk;
    private View.OnClickListener aGn;
    private View.OnClickListener aGo;
    private View.OnClickListener aGp;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aGF = false;
        this.aGG = false;
        this.aGH = false;
        this.aGI = 0;
        this.aGJ = false;
        this.aGp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aAQ.yv().getUserId(), true, true, true);
                    if (UserIconLayout.this.aGI == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aGn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bI(UserIconLayout.this.mContext) && UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null && UserIconLayout.this.aAQ.yv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aAQ.yv().getTShowInfoNew();
                    if (v.I(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aAQ.yv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null && !StringUtils.isNull(UserIconLayout.this.aAQ.yv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aAQ.yv().getUserId()) && UserIconLayout.this.aAQ.yB() != null) {
                    if (UserIconLayout.this.aAQ.zy() != null && UserIconLayout.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.zy().channelId, UserIconLayout.this.aAQ.zy().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.yv().getUserId(), UserIconLayout.this.aAQ.yv().getName_show(), UserIconLayout.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aGk != null) {
                        UserIconLayout.this.aGk.onClick(view);
                    }
                }
            }
        };
        this.aGK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.zy() != null && UserIconLayout.this.aAQ.zy().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.zy().channelId, UserIconLayout.this.aAQ.zy().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGF = false;
        this.aGG = false;
        this.aGH = false;
        this.aGI = 0;
        this.aGJ = false;
        this.aGp = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aAQ.yv().getUserId(), true, true, true);
                    if (UserIconLayout.this.aGI == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aGn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bI(UserIconLayout.this.mContext) && UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null && UserIconLayout.this.aAQ.yv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aAQ.yv().getTShowInfoNew();
                    if (v.I(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aAQ.yv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aGo = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.yv() != null && !StringUtils.isNull(UserIconLayout.this.aAQ.yv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aAQ.yv().getUserId()) && UserIconLayout.this.aAQ.yB() != null) {
                    if (UserIconLayout.this.aAQ.zy() != null && UserIconLayout.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.zy().channelId, UserIconLayout.this.aAQ.zy().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.yv().getUserId(), UserIconLayout.this.aAQ.yv().getName_show(), UserIconLayout.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aGk != null) {
                        UserIconLayout.this.aGk.onClick(view);
                    }
                }
            }
        };
        this.aGK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aAQ != null && UserIconLayout.this.aAQ.zy() != null && UserIconLayout.this.aAQ.zy().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aAQ.zy().channelId, UserIconLayout.this.aAQ.zy().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aGD.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aFY = new UserIconBox(this.mContext);
        this.aGb = new UserIconBox(this.mContext);
        this.aGD = new TextView(this.mContext);
        this.aGg = com.baidu.tbadk.ala.b.uL().j(this.mContext, 1);
        if (this.aGg != null) {
            this.aGg.setVisibility(8);
        }
        this.aGE = new ImageView(this.mContext);
        if (this.aGE != null) {
            this.aGE.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds3), 0, 0);
        this.aGD.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.fontsize24));
        if (!this.aGH) {
            this.aGD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aFY.setLayoutParams(layoutParams);
        this.aGb.setLayoutParams(layoutParams2);
        this.aGD.setLayoutParams(layoutParams3);
        this.aGE.setLayoutParams(layoutParams4);
        addView(this.aFY);
        addView(this.aGD);
        if (this.aGE != null) {
            addView(this.aGE);
        }
        if (this.aGg != null) {
            addView(this.aGg);
        }
        addView(this.aGb);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.yv() != null) {
            this.aAQ = bbVar;
            this.aFY.setOnClickListener(this.aGn);
            this.aGb.setOnClickListener(this.aGp);
            this.aGD.setOnClickListener(this.aGo);
            this.aGE.setOnClickListener(this.aGK);
            if (bbVar.yv() != null && bbVar.yv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.yv().getAlaUserData();
                if (this.aGg != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aht = alaUserData;
                    aVar.type = 1;
                    this.aGg.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aAQ.zy() != null && this.aAQ.zy().channelId > 0) {
                this.aGD.setText(y.A(this.aAQ.zy().channelName, 20));
                this.aGb.setVisibility(8);
                this.aFY.setVisibility(8);
                if (this.aGG) {
                    this.aGE.setVisibility(0);
                } else {
                    this.aGE.setVisibility(8);
                }
                al.h(this.aGD, e.d.cp_cont_b);
                return;
            }
            this.aGE.setVisibility(8);
            if (StringUtils.isNull(this.aAQ.yv().getName_show())) {
                this.aGD.setVisibility(8);
                i = 4;
            } else {
                this.aGD.setVisibility(0);
                String name_show = this.aAQ.yv().getName_show();
                if (this.aGH) {
                    if (this.aGJ) {
                        this.aGD.setText(aB(this.aAQ.yv().getSealPrefix(), y.A(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aGD.setText(y.A(name_show, 20));
                        i = 4;
                    }
                } else if (this.aGJ) {
                    this.aGD.setText(aB(this.aAQ.yv().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aGD.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.yv().getIconInfo();
            if (this.aGF && v.I(iconInfo) != 0) {
                this.aGb.setVisibility(0);
                this.aGb.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10), true);
            } else {
                this.aGb.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.yv().getTShowInfoNew();
            if (v.I(tShowInfoNew) != 0) {
                this.aFY.setVisibility(0);
                this.aFY.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8), true);
            } else {
                this.aFY.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder aB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.aAQ != null && this.aAQ.yv() != null) {
            if (!v.J(this.aAQ.yv().getTShowInfoNew()) || this.aAQ.yv().isBigV()) {
                al.h(this.aGD, e.d.cp_cont_h);
                if (bbVar.yv() != null && bbVar.yv().getAlaUserData() != null) {
                    bbVar.yv().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aGD, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aGk = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aGH = z;
    }

    public void setPageName(int i) {
        this.aGI = i;
    }
}

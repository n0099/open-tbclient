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
    private bb aFg;
    private View.OnClickListener aKC;
    private View.OnClickListener aKF;
    private View.OnClickListener aKG;
    private View.OnClickListener aKH;
    public TextView aKV;
    private ImageView aKW;
    public boolean aKX;
    public boolean aKY;
    private boolean aKZ;
    private UserIconBox aKq;
    private UserIconBox aKt;
    private View aKy;
    private int aLa;
    private boolean aLb;
    private View.OnClickListener aLc;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aKX = false;
        this.aKY = false;
        this.aKZ = false;
        this.aLa = 0;
        this.aLb = false;
        this.aKH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFg.zG().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLa == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null && UserIconLayout.this.aFg.zG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFg.zG().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFg.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aKG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null && !StringUtils.isNull(UserIconLayout.this.aFg.zG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFg.zG().getUserId()) && UserIconLayout.this.aFg.zM() != null) {
                    if (UserIconLayout.this.aFg.AJ() != null && UserIconLayout.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.AJ().channelId, UserIconLayout.this.aFg.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.zG().getUserId(), UserIconLayout.this.aFg.zG().getName_show(), UserIconLayout.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aKC != null) {
                        UserIconLayout.this.aKC.onClick(view);
                    }
                }
            }
        };
        this.aLc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.AJ() != null && UserIconLayout.this.aFg.AJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.AJ().channelId, UserIconLayout.this.aFg.AJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKX = false;
        this.aKY = false;
        this.aKZ = false;
        this.aLa = 0;
        this.aLb = false;
        this.aKH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFg.zG().getUserId(), true, true, true);
                    if (UserIconLayout.this.aLa == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null && UserIconLayout.this.aFg.zG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFg.zG().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFg.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aKG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.zG() != null && !StringUtils.isNull(UserIconLayout.this.aFg.zG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFg.zG().getUserId()) && UserIconLayout.this.aFg.zM() != null) {
                    if (UserIconLayout.this.aFg.AJ() != null && UserIconLayout.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.AJ().channelId, UserIconLayout.this.aFg.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.zG().getUserId(), UserIconLayout.this.aFg.zG().getName_show(), UserIconLayout.this.aFg.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aKC != null) {
                        UserIconLayout.this.aKC.onClick(view);
                    }
                }
            }
        };
        this.aLc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFg != null && UserIconLayout.this.aFg.AJ() != null && UserIconLayout.this.aFg.AJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFg.AJ().channelId, UserIconLayout.this.aFg.AJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aKV.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aKq = new UserIconBox(this.mContext);
        this.aKt = new UserIconBox(this.mContext);
        this.aKV = new TextView(this.mContext);
        this.aKy = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 1);
        if (this.aKy != null) {
            this.aKy.setVisibility(8);
        }
        this.aKW = new ImageView(this.mContext);
        if (this.aKW != null) {
            this.aKW.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds3), 0, 0);
        this.aKV.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.fontsize24));
        if (!this.aKZ) {
            this.aKV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aKq.setLayoutParams(layoutParams);
        this.aKt.setLayoutParams(layoutParams2);
        this.aKV.setLayoutParams(layoutParams3);
        this.aKW.setLayoutParams(layoutParams4);
        addView(this.aKq);
        addView(this.aKV);
        if (this.aKW != null) {
            addView(this.aKW);
        }
        if (this.aKy != null) {
            addView(this.aKy);
        }
        addView(this.aKt);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.zG() != null) {
            this.aFg = bbVar;
            this.aKq.setOnClickListener(this.aKF);
            this.aKt.setOnClickListener(this.aKH);
            this.aKV.setOnClickListener(this.aKG);
            this.aKW.setOnClickListener(this.aLc);
            if (bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zG().getAlaUserData();
                if (this.aKy != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = alaUserData;
                    aVar.type = 1;
                    this.aKy.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aFg.AJ() != null && this.aFg.AJ().channelId > 0) {
                this.aKV.setText(y.A(this.aFg.AJ().channelName, 20));
                this.aKt.setVisibility(8);
                this.aKq.setVisibility(8);
                if (this.aKY) {
                    this.aKW.setVisibility(0);
                } else {
                    this.aKW.setVisibility(8);
                }
                al.h(this.aKV, e.d.cp_cont_b);
                return;
            }
            this.aKW.setVisibility(8);
            if (StringUtils.isNull(this.aFg.zG().getName_show())) {
                this.aKV.setVisibility(8);
                i = 4;
            } else {
                this.aKV.setVisibility(0);
                String name_show = this.aFg.zG().getName_show();
                if (this.aKZ) {
                    if (this.aLb) {
                        this.aKV.setText(aE(this.aFg.zG().getSealPrefix(), y.A(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aKV.setText(y.A(name_show, 20));
                        i = 4;
                    }
                } else if (this.aLb) {
                    this.aKV.setText(aE(this.aFg.zG().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aKV.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.zG().getIconInfo();
            if (this.aKX && v.H(iconInfo) != 0) {
                this.aKt.setVisibility(0);
                this.aKt.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10), true);
            } else {
                this.aKt.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.zG().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKq.setVisibility(0);
                this.aKq.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
            } else {
                this.aKq.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder aE(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.aFg != null && this.aFg.zG() != null) {
            if (!v.I(this.aFg.zG().getTShowInfoNew()) || this.aFg.zG().isBigV()) {
                al.h(this.aKV, e.d.cp_cont_h);
                if (bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                    bbVar.zG().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aKV, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKC = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aKZ = z;
    }

    public void setPageName(int i) {
        this.aLa = i;
    }
}

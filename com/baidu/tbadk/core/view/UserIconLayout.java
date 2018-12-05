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
    private bb aFf;
    private View.OnClickListener aKA;
    private View.OnClickListener aKD;
    private View.OnClickListener aKE;
    private View.OnClickListener aKF;
    public TextView aKT;
    private ImageView aKU;
    public boolean aKV;
    public boolean aKW;
    private boolean aKX;
    private int aKY;
    private boolean aKZ;
    private UserIconBox aKo;
    private UserIconBox aKr;
    private View aKw;
    private View.OnClickListener aLa;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aKV = false;
        this.aKW = false;
        this.aKX = false;
        this.aKY = 0;
        this.aKZ = false;
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFf.zG().getUserId(), true, true, true);
                    if (UserIconLayout.this.aKY == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aKD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null && UserIconLayout.this.aFf.zG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFf.zG().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFf.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aKE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null && !StringUtils.isNull(UserIconLayout.this.aFf.zG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFf.zG().getUserId()) && UserIconLayout.this.aFf.zM() != null) {
                    if (UserIconLayout.this.aFf.AJ() != null && UserIconLayout.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.AJ().channelId, UserIconLayout.this.aFf.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.zG().getUserId(), UserIconLayout.this.aFf.zG().getName_show(), UserIconLayout.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aKA != null) {
                        UserIconLayout.this.aKA.onClick(view);
                    }
                }
            }
        };
        this.aLa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.AJ() != null && UserIconLayout.this.aFf.AJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.AJ().channelId, UserIconLayout.this.aFf.AJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKV = false;
        this.aKW = false;
        this.aKX = false;
        this.aKY = 0;
        this.aKZ = false;
        this.aKF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.aFf.zG().getUserId(), true, true, true);
                    if (UserIconLayout.this.aKY == 1) {
                        TiebaStatic.log(new am("c10134").x("obj_type", 3));
                    }
                }
            }
        };
        this.aKD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bJ(UserIconLayout.this.mContext) && UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null && UserIconLayout.this.aFf.zG().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.aFf.zG().getTShowInfoNew();
                    if (v.H(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.aFf.zG().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aKE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.zG() != null && !StringUtils.isNull(UserIconLayout.this.aFf.zG().getName_show()) && !StringUtils.isNull(UserIconLayout.this.aFf.zG().getUserId()) && UserIconLayout.this.aFf.zM() != null) {
                    if (UserIconLayout.this.aFf.AJ() != null && UserIconLayout.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.AJ().channelId, UserIconLayout.this.aFf.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.zG().getUserId(), UserIconLayout.this.aFf.zG().getName_show(), UserIconLayout.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aKA != null) {
                        UserIconLayout.this.aKA.onClick(view);
                    }
                }
            }
        };
        this.aLa = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.aFf != null && UserIconLayout.this.aFf.AJ() != null && UserIconLayout.this.aFf.AJ().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.aFf.AJ().channelId, UserIconLayout.this.aFf.AJ().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aKT.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aKo = new UserIconBox(this.mContext);
        this.aKr = new UserIconBox(this.mContext);
        this.aKT = new TextView(this.mContext);
        this.aKw = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 1);
        if (this.aKw != null) {
            this.aKw.setVisibility(8);
        }
        this.aKU = new ImageView(this.mContext);
        if (this.aKU != null) {
            this.aKU.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds3), 0, 0);
        this.aKT.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.fontsize24));
        if (!this.aKX) {
            this.aKT.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aKo.setLayoutParams(layoutParams);
        this.aKr.setLayoutParams(layoutParams2);
        this.aKT.setLayoutParams(layoutParams3);
        this.aKU.setLayoutParams(layoutParams4);
        addView(this.aKo);
        addView(this.aKT);
        if (this.aKU != null) {
            addView(this.aKU);
        }
        if (this.aKw != null) {
            addView(this.aKw);
        }
        addView(this.aKr);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.zG() != null) {
            this.aFf = bbVar;
            this.aKo.setOnClickListener(this.aKD);
            this.aKr.setOnClickListener(this.aKF);
            this.aKT.setOnClickListener(this.aKE);
            this.aKU.setOnClickListener(this.aLa);
            if (bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.zG().getAlaUserData();
                if (this.aKw != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.alI = alaUserData;
                    aVar.type = 1;
                    this.aKw.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.aFf.AJ() != null && this.aFf.AJ().channelId > 0) {
                this.aKT.setText(y.A(this.aFf.AJ().channelName, 20));
                this.aKr.setVisibility(8);
                this.aKo.setVisibility(8);
                if (this.aKW) {
                    this.aKU.setVisibility(0);
                } else {
                    this.aKU.setVisibility(8);
                }
                al.h(this.aKT, e.d.cp_cont_b);
                return;
            }
            this.aKU.setVisibility(8);
            if (StringUtils.isNull(this.aFf.zG().getName_show())) {
                this.aKT.setVisibility(8);
                i = 4;
            } else {
                this.aKT.setVisibility(0);
                String name_show = this.aFf.zG().getName_show();
                if (this.aKX) {
                    if (this.aKZ) {
                        this.aKT.setText(aE(this.aFf.zG().getSealPrefix(), y.A(name_show, 20)));
                        int bz = com.baidu.adp.lib.util.k.bz(name_show);
                        if (bz >= 20) {
                            i2 = 1;
                        } else if (bz >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aKT.setText(y.A(name_show, 20));
                        i = 4;
                    }
                } else if (this.aKZ) {
                    this.aKT.setText(aE(this.aFf.zG().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aKT.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.zG().getIconInfo();
            if (this.aKV && v.H(iconInfo) != 0) {
                this.aKr.setVisibility(0);
                this.aKr.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10), true);
            } else {
                this.aKr.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.zG().getTShowInfoNew();
            if (v.H(tShowInfoNew) != 0) {
                this.aKo.setVisibility(0);
                this.aKo.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
            } else {
                this.aKo.setVisibility(8);
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
        if (this.aFf != null && this.aFf.zG() != null) {
            if (!v.I(this.aFf.zG().getTShowInfoNew()) || this.aFf.zG().isBigV()) {
                al.h(this.aKT, e.d.cp_cont_h);
                if (bbVar.zG() != null && bbVar.zG().getAlaUserData() != null) {
                    bbVar.zG().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aKT, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aKA = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aKX = z;
    }

    public void setPageName(int i) {
        this.aKY = i;
    }
}

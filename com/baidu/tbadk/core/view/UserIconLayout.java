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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bb atD;
    private View.OnClickListener axO;
    private View.OnClickListener axQ;
    private View ayE;
    private View.OnClickListener ayJ;
    private View.OnClickListener ayK;
    public TextView ayY;
    private ImageView ayZ;
    private UserIconBox ayx;
    private UserIconBox ayz;
    public boolean aza;
    public boolean azb;
    private boolean azc;
    private int azd;
    private boolean aze;
    private View.OnClickListener azf;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aza = false;
        this.azb = false;
        this.azc = false;
        this.azd = 0;
        this.aze = false;
        this.ayK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atD.vk().getUserId(), true, true, true);
                    if (UserIconLayout.this.azd == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aV(UserIconLayout.this.mContext) && UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null && UserIconLayout.this.atD.vk().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atD.vk().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atD.vk().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null && !StringUtils.isNull(UserIconLayout.this.atD.vk().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atD.vk().getUserId()) && UserIconLayout.this.atD.vq() != null) {
                    if (UserIconLayout.this.atD.wl() != null && UserIconLayout.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.wl().channelId, UserIconLayout.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.vk().getUserId(), UserIconLayout.this.atD.vk().getName_show(), UserIconLayout.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axO != null) {
                        UserIconLayout.this.axO.onClick(view);
                    }
                }
            }
        };
        this.azf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.wl() != null && UserIconLayout.this.atD.wl().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.wl().channelId, UserIconLayout.this.atD.wl().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aza = false;
        this.azb = false;
        this.azc = false;
        this.azd = 0;
        this.aze = false;
        this.ayK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atD.vk().getUserId(), true, true, true);
                    if (UserIconLayout.this.azd == 1) {
                        TiebaStatic.log(new an("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.ayJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aV(UserIconLayout.this.mContext) && UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null && UserIconLayout.this.atD.vk().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atD.vk().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atD.vk().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.vk() != null && !StringUtils.isNull(UserIconLayout.this.atD.vk().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atD.vk().getUserId()) && UserIconLayout.this.atD.vq() != null) {
                    if (UserIconLayout.this.atD.wl() != null && UserIconLayout.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.wl().channelId, UserIconLayout.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.vk().getUserId(), UserIconLayout.this.atD.vk().getName_show(), UserIconLayout.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axO != null) {
                        UserIconLayout.this.axO.onClick(view);
                    }
                }
            }
        };
        this.azf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atD != null && UserIconLayout.this.atD.wl() != null && UserIconLayout.this.atD.wl().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atD.wl().channelId, UserIconLayout.this.atD.wl().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ayY.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, i));
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
        this.ayx = new UserIconBox(this.mContext);
        this.ayz = new UserIconBox(this.mContext);
        this.ayY = new TextView(this.mContext);
        this.ayE = com.baidu.tbadk.ala.b.rx().g(this.mContext, 1);
        if (this.ayE != null) {
            this.ayE.setVisibility(8);
        }
        this.ayZ = new ImageView(this.mContext);
        if (this.ayZ != null) {
            this.ayZ.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds3), 0, 0);
        this.ayY.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.fontsize24));
        if (!this.azc) {
            this.ayY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ayx.setLayoutParams(layoutParams);
        this.ayz.setLayoutParams(layoutParams2);
        this.ayY.setLayoutParams(layoutParams3);
        this.ayZ.setLayoutParams(layoutParams4);
        addView(this.ayx);
        addView(this.ayY);
        if (this.ayZ != null) {
            addView(this.ayZ);
        }
        if (this.ayE != null) {
            addView(this.ayE);
        }
        addView(this.ayz);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.vk() != null) {
            this.atD = bbVar;
            this.ayx.setOnClickListener(this.ayJ);
            this.ayz.setOnClickListener(this.ayK);
            this.ayY.setOnClickListener(this.axQ);
            this.ayZ.setOnClickListener(this.azf);
            if (bbVar.vk() != null && bbVar.vk().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.vk().getAlaUserData();
                if (this.ayE != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.ZR = alaUserData;
                    aVar.type = 1;
                    this.ayE.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.atD.wl() != null && this.atD.wl().channelId > 0) {
                this.ayY.setText(com.baidu.tbadk.util.w.u(this.atD.wl().channelName, 20));
                this.ayz.setVisibility(8);
                this.ayx.setVisibility(8);
                if (this.azb) {
                    this.ayZ.setVisibility(0);
                } else {
                    this.ayZ.setVisibility(8);
                }
                am.h(this.ayY, d.C0140d.cp_cont_b);
                return;
            }
            this.ayZ.setVisibility(8);
            if (StringUtils.isNull(this.atD.vk().getName_show())) {
                this.ayY.setVisibility(8);
                i = 4;
            } else {
                this.ayY.setVisibility(0);
                String name_show = this.atD.vk().getName_show();
                if (this.azc) {
                    if (this.aze) {
                        this.ayY.setText(ai(this.atD.vk().getSealPrefix(), com.baidu.tbadk.util.w.u(name_show, 20)));
                        int bj = com.baidu.adp.lib.util.k.bj(name_show);
                        if (bj >= 20) {
                            i2 = 1;
                        } else if (bj >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.ayY.setText(com.baidu.tbadk.util.w.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.aze) {
                    this.ayY.setText(ai(this.atD.vk().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.ayY.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.vk().getIconInfo();
            if (this.aza && w.y(iconInfo) != 0) {
                this.ayz.setVisibility(0);
                this.ayz.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.ayz.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.vk().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.ayx.setVisibility(0);
                this.ayx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.ayx.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder ai(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.atD != null && this.atD.vk() != null) {
            if (!w.z(this.atD.vk().getTShowInfoNew()) || this.atD.vk().isBigV()) {
                am.h(this.ayY, d.C0140d.cp_cont_h);
                if (bbVar.vk() != null && bbVar.vk().getAlaUserData() != null) {
                    bbVar.vk().getAlaUserData();
                    return;
                }
                return;
            }
            am.h(this.ayY, d.C0140d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axO = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.azc = z;
    }

    public void setPageName(int i) {
        this.azd = i;
    }
}

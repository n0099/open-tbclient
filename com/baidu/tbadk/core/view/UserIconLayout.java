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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bd atn;
    private UserIconBox axT;
    private UserIconBox axV;
    private View.OnClickListener axr;
    private View.OnClickListener axt;
    private boolean ayA;
    private View.OnClickListener ayB;
    private View.OnClickListener aye;
    private View.OnClickListener ayf;
    public TextView ayt;
    private View ayu;
    private ImageView ayv;
    public boolean ayw;
    public boolean ayx;
    private boolean ayy;
    private int ayz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ayw = false;
        this.ayx = false;
        this.ayy = false;
        this.ayz = 0;
        this.ayA = false;
        this.ayf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atn.vm().getUserId(), true, true, true);
                    if (UserIconLayout.this.ayz == 1) {
                        TiebaStatic.log(new am("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aye = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null && UserIconLayout.this.atn.vm().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atn.vm().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atn.vm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null && !StringUtils.isNull(UserIconLayout.this.atn.vm().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atn.vm().getUserId()) && UserIconLayout.this.atn.vr() != null) {
                    if (UserIconLayout.this.atn.wm() != null && UserIconLayout.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.wm().channelId, UserIconLayout.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.vm().getUserId(), UserIconLayout.this.atn.vm().getName_show(), UserIconLayout.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axr != null) {
                        UserIconLayout.this.axr.onClick(view);
                    }
                }
            }
        };
        this.ayB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.wm() != null && UserIconLayout.this.atn.wm().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.wm().channelId, UserIconLayout.this.atn.wm().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayw = false;
        this.ayx = false;
        this.ayy = false;
        this.ayz = 0;
        this.ayA = false;
        this.ayf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.atn.vm().getUserId(), true, true, true);
                    if (UserIconLayout.this.ayz == 1) {
                        TiebaStatic.log(new am("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aye = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.aU(UserIconLayout.this.mContext) && UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null && UserIconLayout.this.atn.vm().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.atn.vm().getTShowInfoNew();
                    if (w.y(tShowInfoNew) != 0 && w.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.atn.vm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ad(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.vm() != null && !StringUtils.isNull(UserIconLayout.this.atn.vm().getName_show()) && !StringUtils.isNull(UserIconLayout.this.atn.vm().getUserId()) && UserIconLayout.this.atn.vr() != null) {
                    if (UserIconLayout.this.atn.wm() != null && UserIconLayout.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.wm().channelId, UserIconLayout.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.vm().getUserId(), UserIconLayout.this.atn.vm().getName_show(), UserIconLayout.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.axr != null) {
                        UserIconLayout.this.axr.onClick(view);
                    }
                }
            }
        };
        this.ayB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.atn != null && UserIconLayout.this.atn.wm() != null && UserIconLayout.this.atn.wm().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.atn.wm().channelId, UserIconLayout.this.atn.wm().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ayt.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, i));
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
        this.axT = new UserIconBox(this.mContext);
        this.axV = new UserIconBox(this.mContext);
        this.ayt = new TextView(this.mContext);
        this.ayu = com.baidu.tbadk.ala.b.rM().f(this.mContext, 1);
        if (this.ayu != null) {
            this.ayu.setVisibility(8);
        }
        this.ayv = new ImageView(this.mContext);
        if (this.ayv != null) {
            this.ayv.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds10), com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds14), -com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds8), com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds3), 0, 0);
        this.ayt.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext, d.e.fontsize24));
        if (!this.ayy) {
            this.ayt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.axT.setLayoutParams(layoutParams);
        this.axV.setLayoutParams(layoutParams2);
        this.ayt.setLayoutParams(layoutParams3);
        this.ayv.setLayoutParams(layoutParams4);
        addView(this.axT);
        addView(this.ayt);
        if (this.ayv != null) {
            addView(this.ayv);
        }
        if (this.ayu != null) {
            addView(this.ayu);
        }
        addView(this.axV);
    }

    public void setData(bd bdVar) {
        int i;
        if (bdVar != null && bdVar.vm() != null) {
            this.atn = bdVar;
            this.axT.setOnClickListener(this.aye);
            this.axV.setOnClickListener(this.ayf);
            this.ayt.setOnClickListener(this.axt);
            this.ayv.setOnClickListener(this.ayB);
            if (bdVar.vm() != null && bdVar.vm().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bdVar.vm().getAlaUserData();
                if (this.ayu != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aak = alaUserData;
                    aVar.type = 1;
                    this.ayu.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.atn.wm() != null && this.atn.wm().channelId > 0) {
                this.ayt.setText(x.u(this.atn.wm().channelName, 20));
                this.axV.setVisibility(8);
                this.axT.setVisibility(8);
                if (this.ayx) {
                    this.ayv.setVisibility(0);
                } else {
                    this.ayv.setVisibility(8);
                }
                al.h(this.ayt, d.C0141d.cp_cont_b);
                return;
            }
            this.ayv.setVisibility(8);
            if (StringUtils.isNull(this.atn.vm().getName_show())) {
                this.ayt.setVisibility(8);
                i = 4;
            } else {
                this.ayt.setVisibility(0);
                String name_show = this.atn.vm().getName_show();
                if (this.ayy) {
                    if (this.ayA) {
                        this.ayt.setText(ak(this.atn.vm().getSealPrefix(), x.u(name_show, 20)));
                        int bg = com.baidu.adp.lib.util.k.bg(name_show);
                        if (bg >= 20) {
                            i2 = 1;
                        } else if (bg >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.ayt.setText(x.u(name_show, 20));
                        i = 4;
                    }
                } else if (this.ayA) {
                    this.ayt.setText(ak(this.atn.vm().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.ayt.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bdVar.vm().getIconInfo();
            if (this.ayw && w.y(iconInfo) != 0) {
                this.axV.setVisibility(0);
                this.axV.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds30), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            } else {
                this.axV.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bdVar.vm().getTShowInfoNew();
            if (w.y(tShowInfoNew) != 0) {
                this.axT.setVisibility(0);
                this.axT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
            } else {
                this.axT.setVisibility(8);
            }
            setUserTextColor(bdVar);
        }
    }

    private SpannableStringBuilder ak(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bd bdVar) {
        if (this.atn != null && this.atn.vm() != null) {
            if (!w.z(this.atn.vm().getTShowInfoNew()) || this.atn.vm().isBigV()) {
                al.h(this.ayt, d.C0141d.cp_cont_h);
                if (bdVar.vm() != null && bdVar.vm().getAlaUserData() != null) {
                    bdVar.vm().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.ayt, d.C0141d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axr = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ayy = z;
    }

    public void setPageName(int i) {
        this.ayz = i;
    }
}

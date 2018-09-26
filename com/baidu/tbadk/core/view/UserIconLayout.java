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
    private View aBA;
    private View.OnClickListener aBE;
    private View.OnClickListener aBH;
    private View.OnClickListener aBI;
    private View.OnClickListener aBJ;
    public TextView aBX;
    private ImageView aBY;
    public boolean aBZ;
    private UserIconBox aBs;
    private UserIconBox aBv;
    public boolean aCa;
    private boolean aCb;
    private int aCc;
    private boolean aCd;
    private View.OnClickListener aCe;
    private bb awf;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aBZ = false;
        this.aCa = false;
        this.aCb = false;
        this.aCc = 0;
        this.aCd = false;
        this.aBJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.awf.wm().getUserId(), true, true, true);
                    if (UserIconLayout.this.aCc == 1) {
                        TiebaStatic.log(new am("c10134").w("obj_type", 3));
                    }
                }
            }
        };
        this.aBH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bA(UserIconLayout.this.mContext) && UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null && UserIconLayout.this.awf.wm().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.awf.wm().getTShowInfoNew();
                    if (v.y(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.awf.wm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aBI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null && !StringUtils.isNull(UserIconLayout.this.awf.wm().getName_show()) && !StringUtils.isNull(UserIconLayout.this.awf.wm().getUserId()) && UserIconLayout.this.awf.ws() != null) {
                    if (UserIconLayout.this.awf.xp() != null && UserIconLayout.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.xp().channelId, UserIconLayout.this.awf.xp().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.wm().getUserId(), UserIconLayout.this.awf.wm().getName_show(), UserIconLayout.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aBE != null) {
                        UserIconLayout.this.aBE.onClick(view);
                    }
                }
            }
        };
        this.aCe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.xp() != null && UserIconLayout.this.awf.xp().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.xp().channelId, UserIconLayout.this.awf.xp().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBZ = false;
        this.aCa = false;
        this.aCb = false;
        this.aCc = 0;
        this.aCd = false;
        this.aBJ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.awf.wm().getUserId(), true, true, true);
                    if (UserIconLayout.this.aCc == 1) {
                        TiebaStatic.log(new am("c10134").w("obj_type", 3));
                    }
                }
            }
        };
        this.aBH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ba.bA(UserIconLayout.this.mContext) && UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null && UserIconLayout.this.awf.wm().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.awf.wm().getTShowInfoNew();
                    if (v.y(tShowInfoNew) != 0 && v.d(tShowInfoNew, 0) != null && (url = UserIconLayout.this.awf.wm().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.aK(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.aBI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.wm() != null && !StringUtils.isNull(UserIconLayout.this.awf.wm().getName_show()) && !StringUtils.isNull(UserIconLayout.this.awf.wm().getUserId()) && UserIconLayout.this.awf.ws() != null) {
                    if (UserIconLayout.this.awf.xp() != null && UserIconLayout.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.xp().channelId, UserIconLayout.this.awf.xp().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.wm().getUserId(), UserIconLayout.this.awf.wm().getName_show(), UserIconLayout.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.aBE != null) {
                        UserIconLayout.this.aBE.onClick(view);
                    }
                }
            }
        };
        this.aCe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.awf != null && UserIconLayout.this.awf.xp() != null && UserIconLayout.this.awf.xp().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.awf.xp().channelId, UserIconLayout.this.awf.xp().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aBX.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, i));
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
        this.aBs = new UserIconBox(this.mContext);
        this.aBv = new UserIconBox(this.mContext);
        this.aBX = new TextView(this.mContext);
        this.aBA = com.baidu.tbadk.ala.b.sB().i(this.mContext, 1);
        if (this.aBA != null) {
            this.aBA.setVisibility(8);
        }
        this.aBY = new ImageView(this.mContext);
        if (this.aBY != null) {
            this.aBY.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds10), com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds14), -com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds8), com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds3), 0, 0);
        this.aBX.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.fontsize24));
        if (!this.aCb) {
            this.aBX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aBs.setLayoutParams(layoutParams);
        this.aBv.setLayoutParams(layoutParams2);
        this.aBX.setLayoutParams(layoutParams3);
        this.aBY.setLayoutParams(layoutParams4);
        addView(this.aBs);
        addView(this.aBX);
        if (this.aBY != null) {
            addView(this.aBY);
        }
        if (this.aBA != null) {
            addView(this.aBA);
        }
        addView(this.aBv);
    }

    public void setData(bb bbVar) {
        int i;
        if (bbVar != null && bbVar.wm() != null) {
            this.awf = bbVar;
            this.aBs.setOnClickListener(this.aBH);
            this.aBv.setOnClickListener(this.aBJ);
            this.aBX.setOnClickListener(this.aBI);
            this.aBY.setOnClickListener(this.aCe);
            if (bbVar.wm() != null && bbVar.wm().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bbVar.wm().getAlaUserData();
                if (this.aBA != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.acu = alaUserData;
                    aVar.type = 1;
                    this.aBA.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.awf.xp() != null && this.awf.xp().channelId > 0) {
                this.aBX.setText(y.z(this.awf.xp().channelName, 20));
                this.aBv.setVisibility(8);
                this.aBs.setVisibility(8);
                if (this.aCa) {
                    this.aBY.setVisibility(0);
                } else {
                    this.aBY.setVisibility(8);
                }
                al.h(this.aBX, e.d.cp_cont_b);
                return;
            }
            this.aBY.setVisibility(8);
            if (StringUtils.isNull(this.awf.wm().getName_show())) {
                this.aBX.setVisibility(8);
                i = 4;
            } else {
                this.aBX.setVisibility(0);
                String name_show = this.awf.wm().getName_show();
                if (this.aCb) {
                    if (this.aCd) {
                        this.aBX.setText(ap(this.awf.wm().getSealPrefix(), y.z(name_show, 20)));
                        int bA = com.baidu.adp.lib.util.k.bA(name_show);
                        if (bA >= 20) {
                            i2 = 1;
                        } else if (bA >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aBX.setText(y.z(name_show, 20));
                        i = 4;
                    }
                } else if (this.aCd) {
                    this.aBX.setText(ap(this.awf.wm().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.aBX.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bbVar.wm().getIconInfo();
            if (this.aBZ && v.y(iconInfo) != 0) {
                this.aBv.setVisibility(0);
                this.aBv.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds30), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds10), true);
            } else {
                this.aBv.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bbVar.wm().getTShowInfoNew();
            if (v.y(tShowInfoNew) != 0) {
                this.aBs.setVisibility(0);
                this.aBs.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds36), this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds8), true);
            } else {
                this.aBs.setVisibility(8);
            }
            setUserTextColor(bbVar);
        }
    }

    private SpannableStringBuilder ap(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, e.f.pic_smalldot_title));
            return com.baidu.tieba.card.o.a(this.mContext, str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bb bbVar) {
        if (this.awf != null && this.awf.wm() != null) {
            if (!v.z(this.awf.wm().getTShowInfoNew()) || this.awf.wm().isBigV()) {
                al.h(this.aBX, e.d.cp_cont_h);
                if (bbVar.wm() != null && bbVar.wm().getAlaUserData() != null) {
                    bbVar.wm().getAlaUserData();
                    return;
                }
                return;
            }
            al.h(this.aBX, e.d.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aBE = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aCb = z;
    }

    public void setPageName(int i) {
        this.aCc = i;
    }
}

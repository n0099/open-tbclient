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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bg VJ;
    private View.OnClickListener XE;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    private UserIconBox Xs;
    private UserIconBox Xt;
    private View Xx;
    private View.OnClickListener Xz;
    public TextView cbW;
    private ImageView cbX;
    public boolean cbY;
    public boolean cbZ;
    private boolean cca;
    private int ccb;
    private boolean ccc;
    private View.OnClickListener ccd;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.cbY = false;
        this.cbZ = false;
        this.cca = false;
        this.ccb = 0;
        this.ccc = false;
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.VJ.adv().getUserId(), true, true, true);
                    if (UserIconLayout.this.ccb == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(UserIconLayout.this.mContext) && UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null && UserIconLayout.this.VJ.adv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.VJ.adv().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null && !StringUtils.isNull(UserIconLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.VJ.adv().getUserId()) && UserIconLayout.this.VJ.adA() != null) {
                    if (UserIconLayout.this.VJ.aeF() != null && UserIconLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.aeF().channelId, UserIconLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.adv().getUserId(), UserIconLayout.this.VJ.adv().getName_show(), UserIconLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.Xz != null) {
                        UserIconLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.ccd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.aeF() != null && UserIconLayout.this.VJ.aeF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.aeF().channelId, UserIconLayout.this.VJ.aeF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbY = false;
        this.cbZ = false;
        this.cca = false;
        this.ccb = 0;
        this.ccc = false;
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.VJ.adv().getUserId(), true, true, true);
                    if (UserIconLayout.this.ccb == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(UserIconLayout.this.mContext) && UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null && UserIconLayout.this.VJ.adv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.VJ.adv().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.adv() != null && !StringUtils.isNull(UserIconLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.VJ.adv().getUserId()) && UserIconLayout.this.VJ.adA() != null) {
                    if (UserIconLayout.this.VJ.aeF() != null && UserIconLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.aeF().channelId, UserIconLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.adv().getUserId(), UserIconLayout.this.VJ.adv().getName_show(), UserIconLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.Xz != null) {
                        UserIconLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.ccd = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VJ != null && UserIconLayout.this.VJ.aeF() != null && UserIconLayout.this.VJ.aeF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VJ.aeF().channelId, UserIconLayout.this.VJ.aeF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cbW.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
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
        this.Xt = new UserIconBox(this.mContext);
        this.Xs = new UserIconBox(this.mContext);
        this.cbW = new TextView(this.mContext);
        this.Xx = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 1);
        if (this.Xx != null) {
            this.Xx.setVisibility(8);
        }
        this.cbX = new ImageView(this.mContext);
        if (this.cbX != null) {
            this.cbX.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds3), 0, 0);
        this.cbW.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.fontsize24));
        if (!this.cca) {
            this.cbW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.Xt.setLayoutParams(layoutParams);
        this.Xs.setLayoutParams(layoutParams2);
        this.cbW.setLayoutParams(layoutParams3);
        this.cbX.setLayoutParams(layoutParams4);
        addView(this.Xt);
        addView(this.cbW);
        if (this.cbX != null) {
            addView(this.cbX);
        }
        if (this.Xx != null) {
            addView(this.Xx);
        }
        addView(this.Xs);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.adv() != null) {
            this.VJ = bgVar;
            this.Xt.setOnClickListener(this.XE);
            this.Xs.setOnClickListener(this.XG);
            this.cbW.setOnClickListener(this.XF);
            this.cbX.setOnClickListener(this.ccd);
            if (bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
                if (this.Xx != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = alaUserData;
                    aVar.type = 1;
                    this.Xx.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.VJ.aeF() != null && this.VJ.aeF().channelId > 0) {
                this.cbW.setText(ab.S(this.VJ.aeF().channelName, 20));
                this.Xs.setVisibility(8);
                this.Xt.setVisibility(8);
                if (this.cbZ) {
                    this.cbX.setVisibility(0);
                } else {
                    this.cbX.setVisibility(8);
                }
                al.j(this.cbW, R.color.cp_cont_b);
                return;
            }
            this.cbX.setVisibility(8);
            if (StringUtils.isNull(this.VJ.adv().getName_show())) {
                this.cbW.setVisibility(8);
                i = 4;
            } else {
                this.cbW.setVisibility(0);
                String name_show = this.VJ.adv().getName_show();
                if (this.cca) {
                    if (this.ccc) {
                        this.cbW.setText(bX(this.VJ.adv().getSealPrefix(), ab.S(name_show, 20)));
                        int bj = com.baidu.adp.lib.util.k.bj(name_show);
                        if (bj >= 20) {
                            i2 = 1;
                        } else if (bj >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cbW.setText(ab.S(name_show, 20));
                        i = 4;
                    }
                } else if (this.ccc) {
                    this.cbW.setText(bX(this.VJ.adv().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cbW.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
            if (this.cbY && v.Z(iconInfo) != 0) {
                this.Xs.setVisibility(0);
                this.Xs.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.Xs.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xt.setVisibility(0);
                this.Xt.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.Xt.setVisibility(8);
            }
            setUserTextColor(bgVar);
        }
    }

    private SpannableStringBuilder bX(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bg bgVar) {
        if (this.VJ != null && this.VJ.adv() != null) {
            if (!v.aa(this.VJ.adv().getTShowInfoNew()) || this.VJ.adv().isBigV()) {
                al.j(this.cbW, R.color.cp_cont_h);
                if (bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                    bgVar.adv().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.cbW, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Xz = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.cca = z;
    }

    public void setPageName(int i) {
        this.ccb = i;
    }
}

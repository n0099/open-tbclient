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
    private bg VK;
    private View.OnClickListener XA;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    private View.OnClickListener XH;
    private UserIconBox Xt;
    private UserIconBox Xu;
    private View Xy;
    public TextView cbV;
    private ImageView cbW;
    public boolean cbX;
    public boolean cbY;
    private boolean cbZ;
    private int cca;
    private boolean ccb;
    private View.OnClickListener ccc;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.cbX = false;
        this.cbY = false;
        this.cbZ = false;
        this.cca = 0;
        this.ccb = false;
        this.XH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.VK.adv().getUserId(), true, true, true);
                    if (UserIconLayout.this.cca == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(UserIconLayout.this.mContext) && UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null && UserIconLayout.this.VK.adv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.VK.adv().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null && !StringUtils.isNull(UserIconLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.VK.adv().getUserId()) && UserIconLayout.this.VK.adA() != null) {
                    if (UserIconLayout.this.VK.aeF() != null && UserIconLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.aeF().channelId, UserIconLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.adv().getUserId(), UserIconLayout.this.VK.adv().getName_show(), UserIconLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XA != null) {
                        UserIconLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.ccc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.aeF() != null && UserIconLayout.this.VK.aeF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.aeF().channelId, UserIconLayout.this.VK.aeF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbX = false;
        this.cbY = false;
        this.cbZ = false;
        this.cca = 0;
        this.ccb = false;
        this.XH = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.VK.adv().getUserId(), true, true, true);
                    if (UserIconLayout.this.cca == 1) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    }
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(UserIconLayout.this.mContext) && UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null && UserIconLayout.this.VK.adv().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.VK.adv().getTShowInfoNew();
                    if (v.Z(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.adv() != null && !StringUtils.isNull(UserIconLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(UserIconLayout.this.VK.adv().getUserId()) && UserIconLayout.this.VK.adA() != null) {
                    if (UserIconLayout.this.VK.aeF() != null && UserIconLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.aeF().channelId, UserIconLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.adv().getUserId(), UserIconLayout.this.VK.adv().getName_show(), UserIconLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.XA != null) {
                        UserIconLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.ccc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.VK != null && UserIconLayout.this.VK.aeF() != null && UserIconLayout.this.VK.aeF().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.VK.aeF().channelId, UserIconLayout.this.VK.aeF().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.cbV.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, i));
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
        this.Xu = new UserIconBox(this.mContext);
        this.Xt = new UserIconBox(this.mContext);
        this.cbV = new TextView(this.mContext);
        this.Xy = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 1);
        if (this.Xy != null) {
            this.Xy.setVisibility(8);
        }
        this.cbW = new ImageView(this.mContext);
        if (this.cbW != null) {
            this.cbW.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds3), 0, 0);
        this.cbV.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.fontsize24));
        if (!this.cbZ) {
            this.cbV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.Xu.setLayoutParams(layoutParams);
        this.Xt.setLayoutParams(layoutParams2);
        this.cbV.setLayoutParams(layoutParams3);
        this.cbW.setLayoutParams(layoutParams4);
        addView(this.Xu);
        addView(this.cbV);
        if (this.cbW != null) {
            addView(this.cbW);
        }
        if (this.Xy != null) {
            addView(this.Xy);
        }
        addView(this.Xt);
    }

    public void setData(bg bgVar) {
        int i;
        if (bgVar != null && bgVar.adv() != null) {
            this.VK = bgVar;
            this.Xu.setOnClickListener(this.XF);
            this.Xt.setOnClickListener(this.XH);
            this.cbV.setOnClickListener(this.XG);
            this.cbW.setOnClickListener(this.ccc);
            if (bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
                if (this.Xy != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bzQ = alaUserData;
                    aVar.type = 1;
                    this.Xy.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.VK.aeF() != null && this.VK.aeF().channelId > 0) {
                this.cbV.setText(ab.S(this.VK.aeF().channelName, 20));
                this.Xt.setVisibility(8);
                this.Xu.setVisibility(8);
                if (this.cbY) {
                    this.cbW.setVisibility(0);
                } else {
                    this.cbW.setVisibility(8);
                }
                al.j(this.cbV, R.color.cp_cont_b);
                return;
            }
            this.cbW.setVisibility(8);
            if (StringUtils.isNull(this.VK.adv().getName_show())) {
                this.cbV.setVisibility(8);
                i = 4;
            } else {
                this.cbV.setVisibility(0);
                String name_show = this.VK.adv().getName_show();
                if (this.cbZ) {
                    if (this.ccb) {
                        this.cbV.setText(bX(this.VK.adv().getSealPrefix(), ab.S(name_show, 20)));
                        int bj = com.baidu.adp.lib.util.k.bj(name_show);
                        if (bj >= 20) {
                            i2 = 1;
                        } else if (bj >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.cbV.setText(ab.S(name_show, 20));
                        i = 4;
                    }
                } else if (this.ccb) {
                    this.cbV.setText(bX(this.VK.adv().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.cbV.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
            if (this.cbX && v.Z(iconInfo) != 0) {
                this.Xt.setVisibility(0);
                this.Xt.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.Xt.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xu.setVisibility(0);
                this.Xu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.Xu.setVisibility(8);
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
        if (this.VK != null && this.VK.adv() != null) {
            if (!v.aa(this.VK.adv().getTShowInfoNew()) || this.VK.adv().isBigV()) {
                al.j(this.cbV, R.color.cp_cont_h);
                if (bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
                    bgVar.adv().getAlaUserData();
                    return;
                }
                return;
            }
            al.j(this.cbV, R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.cbZ = z;
    }

    public void setPageName(int i) {
        this.cca = i;
    }
}

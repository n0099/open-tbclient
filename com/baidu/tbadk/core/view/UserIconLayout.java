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
    private bh ajg;
    private View.OnClickListener anJ;
    private View.OnClickListener anL;
    private boolean aoA;
    private View.OnClickListener aoB;
    private UserIconBox aoa;
    private UserIconBox aob;
    private View aof;
    private View.OnClickListener aoh;
    private View.OnClickListener aoi;
    public TextView aou;
    private ImageView aov;
    public boolean aow;
    public boolean aox;
    private boolean aoy;
    private int aoz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aow = false;
        this.aox = false;
        this.aoy = false;
        this.aoz = 0;
        this.aoA = false;
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajg.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aoz == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(UserIconLayout.this.mContext) && UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null && UserIconLayout.this.ajg.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajg.getAuthor().getTShowInfoNew();
                    if (v.t(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajg.getAuthor().getUserId()) && UserIconLayout.this.ajg.rA() != null) {
                    if (UserIconLayout.this.ajg.sz() != null && UserIconLayout.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.sz().channelId, UserIconLayout.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.getAuthor().getUserId(), UserIconLayout.this.ajg.getAuthor().getName_show(), UserIconLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anJ != null) {
                        UserIconLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.aoB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.sz() != null && UserIconLayout.this.ajg.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.sz().channelId, UserIconLayout.this.ajg.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aow = false;
        this.aox = false;
        this.aoy = false;
        this.aoz = 0;
        this.aoA = false;
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null) {
                    com.baidu.tbadk.browser.a.a(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.l.user_icon_web_view_title), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.ajg.getAuthor().getUserId(), true, true, true);
                    if (UserIconLayout.this.aoz == 1) {
                        TiebaStatic.log(new ak("c10134").r("obj_type", 3));
                    }
                }
            }
        };
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(UserIconLayout.this.mContext) && UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null && UserIconLayout.this.ajg.getAuthor().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.ajg.getAuthor().getTShowInfoNew();
                    if (v.t(tShowInfoNew) != 0 && v.c(tShowInfoNew, 0) != null && (url = UserIconLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.Y(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(UserIconLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(UserIconLayout.this.ajg.getAuthor().getUserId()) && UserIconLayout.this.ajg.rA() != null) {
                    if (UserIconLayout.this.ajg.sz() != null && UserIconLayout.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.sz().channelId, UserIconLayout.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.getAuthor().getUserId(), UserIconLayout.this.ajg.getAuthor().getName_show(), UserIconLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.anJ != null) {
                        UserIconLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.aoB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.ajg != null && UserIconLayout.this.ajg.sz() != null && UserIconLayout.this.ajg.sz().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.ajg.sz().channelId, UserIconLayout.this.ajg.sz().mCurrentPage)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aou.setTextSize(0, l.f(this.mContext, i));
    }

    public void aO(boolean z) {
        this.aoA = z;
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
        this.aoa = new UserIconBox(this.mContext);
        this.aob = new UserIconBox(this.mContext);
        this.aou = new TextView(this.mContext);
        this.aof = com.baidu.tbadk.ala.b.nz().h(this.mContext, 1);
        if (this.aof != null) {
            this.aof.setVisibility(8);
        }
        this.aov = new ImageView(this.mContext);
        if (this.aov != null) {
            this.aov.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.f(this.mContext, d.f.ds10), l.f(this.mContext, d.f.ds4));
        layoutParams2.setMargins(l.f(this.mContext, d.f.ds14), -l.f(this.mContext, d.f.ds1), 0, 0);
        layoutParams3.setMargins(0, l.f(this.mContext, d.f.ds2), 0, 0);
        layoutParams4.setMargins(l.f(this.mContext, d.f.ds8), l.f(this.mContext, d.f.ds3), 0, 0);
        this.aou.setTextSize(0, l.f(this.mContext, d.f.fontsize24));
        if (!this.aoy) {
            this.aou.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aoa.setLayoutParams(layoutParams);
        this.aob.setLayoutParams(layoutParams2);
        this.aou.setLayoutParams(layoutParams3);
        this.aov.setLayoutParams(layoutParams4);
        addView(this.aoa);
        addView(this.aou);
        if (this.aov != null) {
            addView(this.aov);
        }
        if (this.aof != null) {
            addView(this.aof);
        }
        addView(this.aob);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.ajg = bhVar;
            this.aoa.setOnClickListener(this.aoh);
            this.aob.setOnClickListener(this.aoi);
            this.aou.setOnClickListener(this.anL);
            this.aov.setOnClickListener(this.aoB);
            if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.getAuthor().getAlaUserData();
                if (this.aof != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.QH = alaUserData;
                    aVar.type = 1;
                    this.aof.setTag(aVar);
                }
            }
            int i2 = 3;
            if (this.ajg.sz() != null && this.ajg.sz().channelId > 0) {
                this.aou.setText(u.u(this.ajg.sz().channelName, 20));
                this.aob.setVisibility(8);
                this.aoa.setVisibility(8);
                if (this.aox) {
                    this.aov.setVisibility(0);
                } else {
                    this.aov.setVisibility(8);
                }
                aj.i(this.aou, d.e.cp_cont_b);
                return;
            }
            this.aov.setVisibility(8);
            if (StringUtils.isNull(this.ajg.getAuthor().getName_show())) {
                this.aou.setVisibility(8);
                i = 3;
            } else {
                this.aou.setVisibility(0);
                String name_show = this.ajg.getAuthor().getName_show();
                if (this.aoy) {
                    if (this.aoA) {
                        this.aou.setText(ah(this.ajg.getAuthor().getSealPrefix(), u.u(name_show, 20)));
                        int aP = k.aP(name_show);
                        if (aP >= 20) {
                            i2 = 1;
                        } else if (aP >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.aou.setText(u.u(name_show, 20));
                        i = 3;
                    }
                } else if (this.aoA) {
                    this.aou.setText(ah(this.ajg.getAuthor().getSealPrefix(), name_show));
                    i = 3;
                } else {
                    this.aou.setText(name_show);
                    i = 3;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.getAuthor().getIconInfo();
            if (this.aow && v.t(iconInfo) != 0) {
                this.aob.setVisibility(0);
                this.aob.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds30), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            } else {
                this.aob.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.aoa.setVisibility(0);
                this.aoa.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
            } else {
                this.aoa.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder ah(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.g.pic_smalldot_title));
            return m.a(this.mContext, str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.ajg != null && this.ajg.getAuthor() != null) {
            if (!v.u(this.ajg.getAuthor().getTShowInfoNew()) || this.ajg.getAuthor().isBigV()) {
                aj.i(this.aou, d.e.cp_cont_h);
                if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                    bhVar.getAuthor().getAlaUserData();
                    return;
                }
                return;
            }
            aj.i(this.aou, d.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ajg);
        if (this.ajg != null && this.ajg.sz() != null && this.ajg.sz().channelId > 0) {
            aj.i(this.aou, d.e.cp_cont_b);
        }
        if (this.aov != null) {
            aj.j(this.aov, d.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anJ = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aoy = z;
    }

    public void setPageName(int i) {
        this.aoz = i;
    }
}

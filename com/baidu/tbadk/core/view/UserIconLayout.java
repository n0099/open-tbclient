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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh Fs;
    private UserIconBox Hg;
    private UserIconBox Hh;
    private View Hm;
    private View.OnClickListener Ho;
    private View.OnClickListener Ht;
    private View.OnClickListener Hu;
    private View.OnClickListener Hv;
    private boolean crA;
    private int crB;
    private boolean crC;
    private View.OnClickListener crD;
    public TextView crw;
    private ImageView crx;
    public boolean cry;
    public boolean crz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.cry = false;
        this.crz = false;
        this.crA = false;
        this.crB = 0;
        this.crC = false;
        this.Hv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (UserIconLayout.this.crB == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        this.Ht = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null && UserIconLayout.this.Fs.aiE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Fs.aiE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null && !StringUtils.isNull(UserIconLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Fs.aiE().getUserId()) && UserIconLayout.this.Fs.aiJ() != null) {
                    if (UserIconLayout.this.Fs.ajN() != null && UserIconLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.ajN().channelId, UserIconLayout.this.Fs.ajN().Zv)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.aiE().getUserId(), UserIconLayout.this.Fs.aiE().getName_show(), UserIconLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.Ho != null) {
                        UserIconLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.crD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.ajN() != null && UserIconLayout.this.Fs.ajN().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.ajN().channelId, UserIconLayout.this.Fs.ajN().Zv)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cry = false;
        this.crz = false;
        this.crA = false;
        this.crB = 0;
        this.crC = false;
        this.Hv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(UserIconLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + UserIconLayout.this.Fs.aiE().getUserId(), true, true, true);
                    if (UserIconLayout.this.crB == 1) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    }
                }
            }
        };
        this.Ht = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(UserIconLayout.this.mContext) && UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null && UserIconLayout.this.Fs.aiE().getTShowInfoNew() != null) {
                    ArrayList<IconData> tShowInfoNew = UserIconLayout.this.Fs.aiE().getTShowInfoNew();
                    if (v.getCount(tShowInfoNew) != 0 && v.getItem(tShowInfoNew, 0) != null && (url = UserIconLayout.this.Fs.aiE().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.i.ab(UserIconLayout.this.mContext) instanceof TbPageContext)) {
                        ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(UserIconLayout.this.mContext), new String[]{url});
                    }
                }
            }
        };
        this.Hu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.aiE() != null && !StringUtils.isNull(UserIconLayout.this.Fs.aiE().getName_show()) && !StringUtils.isNull(UserIconLayout.this.Fs.aiE().getUserId()) && UserIconLayout.this.Fs.aiJ() != null) {
                    if (UserIconLayout.this.Fs.ajN() != null && UserIconLayout.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.ajN().channelId, UserIconLayout.this.Fs.ajN().Zv)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.aiE().getUserId(), UserIconLayout.this.Fs.aiE().getName_show(), UserIconLayout.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (UserIconLayout.this.Ho != null) {
                        UserIconLayout.this.Ho.onClick(view);
                    }
                }
            }
        };
        this.crD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.UserIconLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UserIconLayout.this.Fs != null && UserIconLayout.this.Fs.ajN() != null && UserIconLayout.this.Fs.ajN().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(UserIconLayout.this.mContext, UserIconLayout.this.Fs.ajN().channelId, UserIconLayout.this.Fs.ajN().Zv)));
                }
            }
        };
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.crw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, i));
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
        this.Hh = new UserIconBox(this.mContext);
        this.Hg = new UserIconBox(this.mContext);
        this.crw = new TextView(this.mContext);
        this.Hm = com.baidu.tbadk.ala.b.afa().l(this.mContext, 1);
        if (this.Hm != null) {
            this.Hm.setVisibility(8);
        }
        this.crx = new ImageView(this.mContext);
        if (this.crx != null) {
            this.crx.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds10), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds14), -com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds8), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds3), 0, 0);
        this.crw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.fontsize24));
        if (!this.crA) {
            this.crw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.Hh.setLayoutParams(layoutParams);
        this.Hg.setLayoutParams(layoutParams2);
        this.crw.setLayoutParams(layoutParams3);
        this.crx.setLayoutParams(layoutParams4);
        addView(this.Hh);
        addView(this.crw);
        if (this.crx != null) {
            addView(this.crx);
        }
        if (this.Hm != null) {
            addView(this.Hm);
        }
        addView(this.Hg);
    }

    public void setData(bh bhVar) {
        int i;
        if (bhVar != null && bhVar.aiE() != null) {
            this.Fs = bhVar;
            this.Hh.setOnClickListener(this.Ht);
            this.Hg.setOnClickListener(this.Hv);
            this.crw.setOnClickListener(this.Hu);
            this.crx.setOnClickListener(this.crD);
            if (bhVar.aiE() != null && bhVar.aiE().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.aiE().getAlaUserData();
                if (this.Hm != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.bTc = alaUserData;
                    aVar.type = 1;
                    this.Hm.setTag(aVar);
                }
            }
            int i2 = 4;
            if (this.Fs.ajN() != null && this.Fs.ajN().channelId > 0) {
                this.crw.setText(aa.subString(this.Fs.ajN().channelName, 20));
                this.Hg.setVisibility(8);
                this.Hh.setVisibility(8);
                if (this.crz) {
                    this.crx.setVisibility(0);
                } else {
                    this.crx.setVisibility(8);
                }
                am.setViewTextColor(this.crw, (int) R.color.cp_cont_b);
                return;
            }
            this.crx.setVisibility(8);
            if (StringUtils.isNull(this.Fs.aiE().getName_show())) {
                this.crw.setVisibility(8);
                i = 4;
            } else {
                this.crw.setVisibility(0);
                String name_show = this.Fs.aiE().getName_show();
                if (this.crA) {
                    if (this.crC) {
                        this.crw.setText(bV(this.Fs.aiE().getSealPrefix(), aa.subString(name_show, 20)));
                        int byteLength = com.baidu.adp.lib.util.k.byteLength(name_show);
                        if (byteLength >= 20) {
                            i2 = 1;
                        } else if (byteLength >= 16) {
                            i2 = 2;
                        }
                        i = i2;
                    } else {
                        this.crw.setText(aa.subString(name_show, 20));
                        i = 4;
                    }
                } else if (this.crC) {
                    this.crw.setText(bV(this.Fs.aiE().getSealPrefix(), name_show));
                    i = 4;
                } else {
                    this.crw.setText(name_show);
                    i = 4;
                }
            }
            ArrayList<IconData> iconInfo = bhVar.aiE().getIconInfo();
            if (this.cry && v.getCount(iconInfo) != 0) {
                this.Hg.setVisibility(0);
                this.Hg.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10), true);
            } else {
                this.Hg.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.aiE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Hh.setVisibility(0);
                this.Hh.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            } else {
                this.Hh.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder bV(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new n.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.n.a(this.mContext, str2, (ArrayList<n.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.Fs != null && this.Fs.aiE() != null) {
            if (!v.isEmpty(this.Fs.aiE().getTShowInfoNew()) || this.Fs.aiE().isBigV()) {
                am.setViewTextColor(this.crw, (int) R.color.cp_cont_h);
                if (bhVar.aiE() != null && bhVar.aiE().getAlaUserData() != null) {
                    bhVar.aiE().getAlaUserData();
                    return;
                }
                return;
            }
            am.setViewTextColor(this.crw, (int) R.color.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Ho = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.crA = z;
    }

    public void setPageName(int i) {
        this.crB = i;
    }
}

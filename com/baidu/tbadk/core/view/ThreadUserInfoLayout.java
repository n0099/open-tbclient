package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    private bz ahu;
    private View.OnClickListener akB;
    private View.OnClickListener akC;
    private View.OnClickListener akD;
    public TextView akj;
    public TextView akk;
    protected UserIconBox akl;
    private UserIconBox akm;
    protected TextView akq;
    private View.OnClickListener akt;
    private TextView fhC;
    public ClickableHeaderImageView fiK;
    private TextView fiz;
    private TextView fjg;
    private View fjh;
    private TextView fji;
    private View fjj;
    private FrameLayout fjk;
    private boolean fjl;
    private View fjm;
    private boolean fjn;
    private boolean fjo;
    private Context mContext;
    private int mFrom;
    private int mSkinType;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.fjl = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getUserId()) && ThreadUserInfoLayout.this.ahu.bnB() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahu.bnx().getUserId(), ThreadUserInfoLayout.this.ahu.bnx().getName_show(), ThreadUserInfoLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahu.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akt != null) {
                        ThreadUserInfoLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.akD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjl = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getUserId()) && ThreadUserInfoLayout.this.ahu.bnB() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahu.bnx().getUserId(), ThreadUserInfoLayout.this.ahu.bnx().getName_show(), ThreadUserInfoLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahu.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akt != null) {
                        ThreadUserInfoLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.akD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjl = true;
        this.mFrom = 1;
        this.mSkinType = 3;
        this.akB = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(ThreadUserInfoLayout.this.mContext) && ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew() != null && x.getItem(ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew(), 0) != null && (url = ThreadUserInfoLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(ThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(ThreadUserInfoLayout.this.ahu.bnx().getUserId()) && ThreadUserInfoLayout.this.ahu.bnB() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.mContext, ThreadUserInfoLayout.this.ahu.bnx().getUserId(), ThreadUserInfoLayout.this.ahu.bnx().getName_show(), ThreadUserInfoLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.ahu.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadUserInfoLayout.this.akt != null) {
                        ThreadUserInfoLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.akD = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadUserInfoLayout.this.ahu != null && ThreadUserInfoLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(ThreadUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ThreadUserInfoLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (ThreadUserInfoLayout.this.mFrom == 1) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.fiK = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.akm = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.akj = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.akk = (TextView) inflate.findViewById(R.id.identity_view);
        this.akl = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.fhC = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.fjg = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.fjh = inflate.findViewById(R.id.divider);
        this.fjm = findViewById(R.id.divider_forum_name);
        this.fiz = (TextView) findViewById(R.id.thread_info_forum_name);
        this.akq = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.fji = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.fjk = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        this.fjj = com.baidu.tbadk.ala.b.bjv().A(this.mContext, 1);
        if (this.fjj != null) {
            this.fjj.setVisibility(8);
            this.fjk.addView(this.fjj);
        }
        setGravity(16);
        initHeaderImg();
        this.akm.setOnClickListener(this.akB);
        this.akj.setOnClickListener(this.akC);
        this.akl.setOnClickListener(this.akD);
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahu = bzVar;
        if (this.ahu.eQO > 0) {
            if (this.ahu.eQP == 0 && this.ahu.bnx() != null) {
                if (!x.isEmpty(this.ahu.bnx().getTShowInfoNew())) {
                    this.ahu.bnx().getTShowInfoNew().clear();
                }
                this.ahu.bnx().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.akm.setOnClickListener(null);
            this.akj.setOnClickListener(null);
            this.akl.setOnClickListener(null);
            this.fiK.setClickable(false);
        } else {
            this.akm.setOnClickListener(this.akB);
            this.akj.setOnClickListener(this.akC);
            this.akl.setOnClickListener(this.akD);
            this.fiK.setClickable(true);
        }
        l(bzVar);
        i(bzVar);
        j(bzVar);
        k(bzVar);
        m(bzVar);
        F(bzVar);
        K(bzVar);
        d(bzVar);
        L(bzVar);
        setVisibility(0);
        J(bzVar);
        I(bzVar);
        return true;
    }

    private void initHeaderImg() {
        if (this.fiK != null) {
            this.fiK.setDefaultResource(17170445);
            this.fiK.setPlaceHolder(1);
            this.fiK.setIsRound(true);
            this.fiK.setAfterClickListener(this.akt);
        }
    }

    private void I(bz bzVar) {
        if (this.mFrom == 3) {
            if (bzVar != null && bzVar.bnx() != null && bzVar.bnx().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bzVar.bnx().getAlaUserData();
                if (this.fjj != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eEt = alaUserData;
                    aVar.type = 1;
                    this.fjj.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.fjj.setVisibility(8);
                    } else {
                        this.fjj.setVisibility(0);
                    }
                }
            } else if (this.fjj != null) {
                this.fjj.setVisibility(8);
            }
        }
    }

    private void J(bz bzVar) {
        if (this.fji != null && bzVar != null && bzVar.bnx() != null) {
            if (bzVar.bnx().hadConcerned()) {
                this.fji.setVisibility(0);
                ao.setViewTextColor(this.fji, R.color.CAM_X0109);
                ao.setBackgroundResource(this.fji, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
                return;
            }
            this.fji.setVisibility(8);
        }
    }

    private void l(bz bzVar) {
        if (this.akm != null && bzVar != null && bzVar.bnx() != null) {
            ArrayList<IconData> tShowInfoNew = bzVar.bnx().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.akm.setVisibility(0);
                this.akm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akm.setVisibility(8);
        }
    }

    private void m(bz bzVar) {
        if (this.akk != null && bzVar != null && bzVar.bnx() != null) {
            MetaData bnx = bzVar.bnx();
            if (bnx.getIs_bawu() == 1) {
                int i = bzVar.eRc ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
                int i2 = bzVar.eRc ? R.color.CAM_X0101 : R.color.CAM_X0107;
                ao.setBackgroundResource(this.akk, i);
                ao.setViewTextColor(this.akk, i2);
                if (bzVar.eRc) {
                    this.akk.setVisibility(0);
                    this.akk.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                    this.akk.setVisibility(0);
                    this.akk.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_member_xbazhu_tip);
                    this.akk.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_content_assist_tip);
                    this.akk.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_manage_assist_tip);
                    this.akk.setVisibility(0);
                    return;
                } else {
                    this.akk.setVisibility(8);
                    return;
                }
            }
            this.akk.setVisibility(8);
        }
    }

    private void i(bz bzVar) {
        if (this.akj != null && bzVar != null) {
            if (!StringUtils.isNull(this.ahu.bnx().getName_show())) {
                this.akj.setText(Bo(this.ahu.bnx().getName_show()));
            }
            tD();
            if (this.mFrom == 3 || this.mFrom == 4) {
                String name_show = this.ahu.bnx().getName_show();
                String userName = this.ahu.bnx().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.akj.setText(com.baidu.tieba.pb.c.bb(this.mContext, this.akj.getText().toString()));
                    this.akj.setGravity(16);
                    this.akj.setTag(R.id.tag_nick_name_activity, com.baidu.tieba.pb.c.dix());
                    ao.setViewTextColor(this.akj, R.color.CAM_X0312, 1);
                }
            }
        }
    }

    private void k(bz bzVar) {
        if (this.akl != null) {
            if (this.fjo) {
                this.akl.setVisibility(8);
            } else if (bzVar == null || bzVar.bnx() == null || ((bzVar.eQO > 0 && bzVar.eQP == 0) || !this.fjl)) {
                this.akl.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bzVar.bnx().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.akl.setVisibility(0);
                    this.akl.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    return;
                }
                this.akl.setVisibility(8);
            }
        }
    }

    private void F(bz bzVar) {
        String formatTime;
        if (this.fhC != null && bzVar != null) {
            if (bzVar.bnq() <= 0) {
                this.fhC.setVisibility(4);
                return;
            }
            this.fhC.setVisibility(0);
            if (this.mFrom == 2) {
                formatTime = at.getPostTimeInterval(bzVar.bnq());
            } else if (bzVar.boR()) {
                formatTime = at.getFormatTime(bzVar.getCreateTime());
            } else {
                formatTime = at.getFormatTime(bzVar.bnq() * 1000);
            }
            this.fhC.setText(formatTime);
        }
    }

    protected void j(bz bzVar) {
        if (this.akq == null || bzVar == null) {
            this.akq.setVisibility(8);
        } else if (this.fjo) {
            if (StringUtils.isNull(bzVar.bkW())) {
                this.akq.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akq.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.akq.setLayoutParams(layoutParams);
            }
            this.akq.setText(bzVar.bkW());
            this.akq.setVisibility(0);
        } else if (this.ahu.bnQ() == null || this.ahu.bnQ().share_info == null || this.ahu.bnQ().share_info.share_user_count <= 0 || !this.ahu.boU() || (this.ahu.eQO > 0 && this.ahu.eQP == 0)) {
            this.akq.setVisibility(8);
        } else {
            this.akq.setVisibility(0);
            int i = this.ahu.bnQ().share_info.share_user_count;
            if (i == 1) {
                this.akq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
            } else {
                this.akq.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{at.numberUniform(i)}));
            }
        }
    }

    private void K(bz bzVar) {
        if (bzVar == null || StringUtils.isNull(bzVar.getAddress())) {
            this.fjg.setVisibility(8);
            this.fjh.setVisibility(8);
            return;
        }
        this.fjg.setText(this.ahu.getAddress());
        this.fjg.setVisibility(0);
        this.fjh.setVisibility(0);
    }

    public void L(bz bzVar) {
        String str;
        if (bzVar == null) {
            this.fiz.setVisibility(8);
            this.fjm.setVisibility(8);
            return;
        }
        this.ahu.bnB();
        String str2 = (this.mFrom == 3 || this.mFrom == 4) ? null : null;
        if (bzVar.bpn()) {
            str2 = bzVar.eRb.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.fiz.setVisibility(8);
            this.fjm.setVisibility(8);
            return;
        }
        if (this.ahu.eQO > 0 && this.ahu.eQP == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = at.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.fiz.setText(str);
        this.fiz.setVisibility(0);
        this.fjm.setVisibility(0);
    }

    public void kc(boolean z) {
        if (z) {
            L(this.ahu);
            return;
        }
        this.fiz.setVisibility(8);
        this.fjm.setVisibility(8);
    }

    private void d(bz bzVar) {
        if (this.fiK != null && bzVar != null && this.ahu.bnx() != null) {
            if (this.ahu.eQO > 0 && this.ahu.eQP == 0) {
                this.fiK.setShowV(false);
            } else {
                this.fiK.setShowV(this.ahu.bnx().isBigV());
            }
        }
    }

    private void tD() {
        if (this.ahu != null && this.ahu.bnx() != null) {
            if (this.ahu.eQO > 0 && this.ahu.eQP == 0) {
                ao.setViewTextColor(this.akj, R.color.CAM_X0106);
            } else if (!x.isEmpty(this.ahu.bnx().getTShowInfoNew()) || this.ahu.bnx().isBigV()) {
                ao.setViewTextColor(this.akj, R.color.CAM_X0301);
            } else {
                ao.setViewTextColor(this.akj, R.color.CAM_X0106);
            }
        }
    }

    public void onChangeSkinType() {
        tD();
        ao.setViewTextColor(this.akq, R.color.CAM_X0106);
        ao.setViewTextColor(this.fhC, R.color.CAM_X0109);
        ao.setBackgroundColor(this.fjh, R.color.CAM_X0110);
        ao.setViewTextColor(this.fjg, R.color.CAM_X0109);
        ao.setViewTextColor(this.fiz, R.color.CAM_X0109);
        ao.setBackgroundColor(this.fjh, R.color.CAM_X0110);
        ao.setBackgroundColor(this.fjm, R.color.CAM_X0110);
        m(this.ahu);
    }

    public void setIsSimpleThread(boolean z) {
        this.fjn = z;
    }

    public boolean getIsSimpleThread() {
        return this.fjn;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
        if (this.fiK != null) {
            this.fiK.setAfterClickListener(this.akt);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fiK != null) {
            this.fiK.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.fiK;
    }

    public TextView getUserName() {
        return this.akj;
    }

    protected String Bo(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void setTShowVisible(boolean z) {
        this.fjl = z;
    }

    public void setIsFromConcern(boolean z) {
        this.fjo = z;
    }
}

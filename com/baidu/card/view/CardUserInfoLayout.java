package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.b;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class CardUserInfoLayout extends LinearLayout implements n {
    private bj Ki;
    private HeadPendantClickableView MC;
    private TextView ME;
    private TextView MF;
    private UserIconBox MG;
    private UserIconBox MH;
    private TextView MI;
    private TextView MJ;
    protected RelativeLayout MK;
    private DynamicUserLikeButton MN;
    private ImageView MO;
    private View MP;
    private FrameLayout MQ;
    private LayerDrawable MR;
    private LayerDrawable MS;
    private View.OnClickListener MT;
    private View.OnClickListener MU;
    private View MV;
    private View MW;
    private c MX;
    private int MY;
    private Runnable MZ;
    private View.OnClickListener Na;
    private View.OnClickListener Nb;
    private View.OnClickListener Nc;
    private BdUniqueId mBdUniqueId;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSkinType;
    private int tbds118;
    private int tbds148;
    private int tbds156;
    private int tbds164;
    private int tbds40;
    private int tbds580;
    private int tbds6;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.tbds6 = 0;
        this.tbds40 = 0;
        this.MY = 1285;
        this.MZ = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.nd();
            }
        };
        this.Na = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.Ki != null && CardUserInfoLayout.this.Ki.azE() != null && CardUserInfoLayout.this.Ki.azE().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.Ki.azE().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.Ki.azE().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEa().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Nb = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Ki != null && CardUserInfoLayout.this.Ki.azE() != null && !StringUtils.isNull(CardUserInfoLayout.this.Ki.azE().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.Ki.azE().getUserId()) && CardUserInfoLayout.this.Ki.azJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Ki.azE().getUserId(), CardUserInfoLayout.this.Ki.azE().getName_show(), CardUserInfoLayout.this.Ki.azJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.Ki.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.MT != null) {
                        CardUserInfoLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        this.Nc = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Ki != null && CardUserInfoLayout.this.Ki.azE() != null) {
                    a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.Ki.azE().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.MU != null) {
                        CardUserInfoLayout.this.MT.onClick(view);
                    }
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(16);
        int dimens = l.getDimens(getContext(), R.dimen.tbds94);
        if (!TbSingleton.getInstance().checkDistanceAccuracy(getContext())) {
            dimens = l.getDimens(getContext(), R.dimen.tbds110);
        }
        setLayoutParams(new ViewGroup.LayoutParams(-2, dimens));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        na();
        ne();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.MY = i;
        mZ();
    }

    private void mZ() {
        this.MH.setVisibility(isShow(1) ? 0 : 8);
        this.ME.setVisibility(isShow(4) ? 0 : 8);
        this.MF.setVisibility(isShow(16) ? 0 : 8);
        this.MJ.setVisibility(isShow(8) ? 0 : 8);
        this.MG.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MV.getLayoutParams();
        if (isShow(128)) {
            this.MI.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.MI.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.MV.setLayoutParams(layoutParams);
        if (isShow(64)) {
            this.MQ.setVisibility(0);
            this.MP = b.avT().u(getContext(), 1);
            if (this.MP != null) {
                this.MP.setVisibility(8);
                this.MQ.addView(this.MP);
            }
        } else {
            this.MQ.setVisibility(8);
        }
        this.MN.setVisibility(isShow(2048) ? 0 : 8);
        this.MO.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.MY & i) > 0;
    }

    private void na() {
        this.MC = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.MC.setHasPendantStyle();
        this.MC.getHeadView().setIsRound(true);
        this.MC.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.MC.getHeadView().setDefaultResource(17170445);
        this.MC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.MC.getHeadView().setPlaceHolder(1);
        this.MC.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.MT != null) {
                    CardUserInfoLayout.this.MT.onClick(view);
                }
            }
        });
        this.MH = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.MH.setOnClickListener(this.Na);
        this.ME = (TextView) findViewById(R.id.user_name);
        this.ME.setOnClickListener(this.Nb);
        this.MF = (TextView) findViewById(R.id.identity_view);
        this.MJ = (TextView) findViewById(R.id.thread_share_intro);
        this.MG = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.MG.setOnClickListener(this.Nc);
        this.MI = (TextView) findViewById(R.id.thread_extend_info);
        this.MQ = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.MV = findViewById(R.id.user_name_and_reply_time);
        this.MW = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.MK = (RelativeLayout) findViewById(R.id.suffix_container);
        this.MN = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.MO = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.MC.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.MR != null && this.MR.getDrawable(1) != null) {
                    this.MR.getDrawable(1).setAlpha(255);
                }
                if (this.MS != null && this.MS.getDrawable(1) != null) {
                    this.MS.getDrawable(1).setAlpha(255);
                }
            } else {
                if (this.MR != null && this.MR.getDrawable(1) != null) {
                    this.MR.getDrawable(1).setAlpha(0);
                }
                if (this.MS != null && this.MS.getDrawable(1) != null) {
                    this.MS.getDrawable(1).setAlpha(0);
                }
            }
            this.MN.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.MC != null && bjVar != null && this.Ki.azE() != null) {
            this.MC.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.MC, this.Ki.azE(), 0)) {
                if (this.Ki.cPB > 0 && this.Ki.cPC == 0) {
                    this.MC.fE(false);
                } else {
                    this.MC.a(this.Ki.azE(), 0);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        this.Ki = bjVar;
        e(bjVar);
        f(bjVar);
        k(bjVar);
        l(bjVar);
        h(bjVar);
        j(bjVar);
        c(bjVar);
        n(bjVar);
        i(bjVar);
        g(bjVar);
        nc();
        d(bjVar);
        setVisibility(0);
        if (isShow(128) && !bjVar.cQe && !bjVar.aBu()) {
            this.MV.post(this.MZ);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.MO != null) {
            if (bjVar.cPZ) {
                this.MO.setVisibility(0);
            } else {
                this.MO.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.azE() != null) {
            String userId = bjVar.azE().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aBy() || bjVar.ays() || bjVar.aBz()) && bjVar.cQe && !TextUtils.equals(userId, currentAccount)) {
                this.MY |= 2048;
            } else if ((bjVar.aBy() || bjVar.ays() || bjVar.aBz()) && bjVar.cQf && !bjVar.azE().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.MY |= 2048;
            } else {
                this.MY &= -2049;
            }
            if (bjVar.aBv()) {
                this.MY |= 4096;
            } else {
                this.MY &= -4097;
            }
            if (bjVar.cQe && !bjVar.aBC()) {
                this.MY &= -129;
            } else {
                this.MY |= 128;
            }
            setShowFlag(this.MY);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.azE() == null) {
            this.MC.setVisibility(8);
            return;
        }
        MetaData azE = bjVar.azE();
        if (!isShow(256)) {
            azE.setPendantData(null);
        }
        this.MC.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (bjVar != null && bjVar.azE() != null && bjVar.azE().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bjVar.azE().getAlaUserData();
            if (this.MP != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.cFA = alaUserData;
                aVar.type = 1;
                this.MP.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.MP.setVisibility(8);
                } else {
                    this.MP.setVisibility(0);
                }
            }
        } else if (this.MP != null) {
            this.MP.setVisibility(8);
        }
    }

    private void h(bj bjVar) {
        if (this.ME != null && bjVar != null) {
            if (bjVar.cQe || bjVar.aBu()) {
                ViewGroup.LayoutParams layoutParams = this.MV.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.MV.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.MW.getLayoutParams();
                layoutParams2.width = -1;
                this.MW.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ME.getLayoutParams();
                layoutParams3.width = -1;
                this.ME.setLayoutParams(layoutParams3);
                this.ME.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.azE() != null && !StringUtils.isNull(bjVar.azE().getName_show())) {
                    this.ME.setText(bjVar.azE().getName_show());
                } else {
                    this.ME.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.Ki.azb())) {
                this.ME.setText(this.Ki.azb());
            } else {
                this.ME.setText(R.string.user_name_default_txt);
            }
            nb();
        }
    }

    protected void i(bj bjVar) {
        if (this.MJ != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.MJ.setVisibility(8);
            } else if (this.Ki.getType() == bj.cOQ) {
                this.MJ.setVisibility(0);
                this.MJ.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.MJ, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.axy())) {
                    this.MJ.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MJ.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.MJ.setLayoutParams(layoutParams);
                }
                this.MJ.setText(bjVar.axy());
                this.MJ.setVisibility(0);
            } else if (StringUtils.isNull(this.Ki.azd())) {
                this.MJ.setVisibility(8);
            } else {
                this.MJ.setVisibility(0);
                this.MJ.setText(this.Ki.azd());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.MG != null) {
            if (!isShow(32)) {
                this.MG.setVisibility(8);
            } else if (bjVar == null || bjVar.azE() == null || (bjVar.cPB > 0 && bjVar.cPC == 0)) {
                this.MG.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.azE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.MG.setVisibility(0);
                    this.MG.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.MG.setVisibility(8);
            }
        }
    }

    protected String o(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void nb() {
        if (this.Ki != null && this.Ki.azE() != null) {
            if (this.Ki.cPB > 0 && this.Ki.cPC == 0) {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Ki.azE().getTShowInfoNew()) || this.Ki.azE().isBigV()) {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.ME, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.MH != null && bjVar != null && bjVar.azE() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.azE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MH.setVisibility(0);
                this.MH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.MH.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.MF != null && bjVar != null && bjVar.azE() != null && isShow(16)) {
            MetaData azE = bjVar.azE();
            if (this.MF.getLayoutParams() != null) {
                this.MF.getLayoutParams().width = -2;
            }
            this.MF.setOnClickListener(null);
            if (azE.getIs_bawu() == 1) {
                am.setBackgroundResource(this.MF, R.drawable.brand_official_btn);
                am.setViewTextColor(this.MF, (int) R.color.cp_cont_a);
                if (bjVar.cPO) {
                    this.MF.setVisibility(0);
                    this.MF.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(azE.getBawu_type())) {
                    this.MF.setBackgroundDrawable(this.MR);
                    this.MF.setVisibility(0);
                    this.MF.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(azE.getBawu_type())) {
                    this.MF.setBackgroundDrawable(this.MS);
                    this.MF.setText(R.string.bawu_member_xbazhu_tip);
                    this.MF.setVisibility(0);
                } else if ("pri_content_assist".equals(azE.getBawu_type())) {
                    this.MF.setText(R.string.bawu_content_assist_tip);
                    this.MF.setVisibility(0);
                } else if ("pri_manage_assist".equals(azE.getBawu_type())) {
                    this.MF.setText(R.string.bawu_manage_assist_tip);
                    this.MF.setVisibility(0);
                } else if (azE.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.MF.setVisibility(8);
                }
            } else if (azE.getIs_biggie()) {
                m(bjVar);
            } else {
                this.MF.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.MC;
    }

    public View getUserName() {
        return this.ME;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.MF, R.drawable.brand_official_btn);
        am.setViewTextColor(this.MF, (int) R.color.cp_cont_a);
        this.MF.setText(R.string.video_mcn);
        if (bjVar.aAK()) {
            this.MG.setVisibility(8);
        }
        this.MF.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.MU = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.MC != null) {
            this.MC.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.MI != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.azc())) {
                this.MI.setVisibility(8);
                return;
            }
            if (bjVar.azE() != null && bjVar.azE().getBaijiahaoInfo() != null) {
                this.MI.setLines(1);
                this.MI.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.MI.setMaxLines(Integer.MAX_VALUE);
                this.MI.setEllipsize(null);
            }
            am.setViewTextColor(this.MI, (int) R.color.cp_cont_d);
            this.MI.setText(bjVar.azc());
            this.MI.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void nc() {
        if (isShow(2048) && this.Ki != null && this.Ki.azE() != null && this.mPageContext != null && this.MN != null) {
            if (this.MX == null) {
                this.MX = new c(this.mPageContext, this.MN);
                this.MX.j(this.mBdUniqueId);
            }
            this.MX.a(this.Ki.azE());
            this.MN.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cp("obj_id", CardUserInfoLayout.this.Ki.azE().getUserId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).cp("tid", CardUserInfoLayout.this.Ki.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nd() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ME.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.MJ.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ME.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, o(this.Ki.azE().getName_show(), 12)) + this.ME.getPaddingLeft() + this.ME.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, o(this.Ki.azE().getName_show(), 10)) + this.ME.getPaddingLeft() + this.ME.getPaddingRight();
            int measuredWidth = this.MH.getMeasuredWidth();
            int measuredWidth2 = this.ME.getMeasuredWidth();
            int measuredWidth3 = this.MJ.getMeasuredWidth();
            int measuredWidth4 = this.MF.getMeasuredWidth();
            int measuredWidth5 = this.MG.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ME.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ME.setText(o(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ME.setText(o(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.MG.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.MF.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.MH.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.MJ.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.Ki != null && this.Ki.azE() != null && this.Ki.azE().getBaijiahaoInfo() != null) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.MI.setMaxWidth(i2);
        }
    }

    private void ne() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.MR = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.tbds6).ts("#4D000000").aEw()});
        this.MS = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEw(), com.baidu.tbadk.core.util.f.a.b.aEu().kk(0).ah(this.tbds6).ts("#4D000000").aEw()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.MK;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

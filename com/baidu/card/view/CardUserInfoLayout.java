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
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.f.a.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class CardUserInfoLayout extends LinearLayout implements n {
    private bj Kn;
    private HeadPendantClickableView MI;
    private TBLottieAnimationView MJ;
    private TextView MK;
    private TextView MN;
    private UserIconBox MO;
    private UserIconBox MP;
    private TextView MQ;
    private TextView MR;
    protected RelativeLayout MS;
    private DynamicUserLikeButton MT;
    private ImageView MU;
    private LayerDrawable MV;
    private LayerDrawable MW;
    private View.OnClickListener MX;
    private View.OnClickListener MY;
    private View MZ;
    private View Na;
    private c Nb;
    private int Nc;
    private Runnable Ne;
    private View.OnClickListener Nf;
    private View.OnClickListener Ng;
    private View.OnClickListener Nh;
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
        this.Nc = 34053;
        this.Ne = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.ne();
            }
        };
        this.Nf = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.Kn != null && CardUserInfoLayout.this.Kn.azX() != null && CardUserInfoLayout.this.Kn.azX().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.Kn.azX().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.Kn.azX().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aEt().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ng = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Kn != null && CardUserInfoLayout.this.Kn.azX() != null && !StringUtils.isNull(CardUserInfoLayout.this.Kn.azX().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.Kn.azX().getUserId()) && CardUserInfoLayout.this.Kn.aAc() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Kn.azX().getUserId(), CardUserInfoLayout.this.Kn.azX().getName_show(), CardUserInfoLayout.this.Kn.aAc(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.Kn.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.MX != null) {
                        CardUserInfoLayout.this.MX.onClick(view);
                    }
                }
            }
        };
        this.Nh = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Kn != null && CardUserInfoLayout.this.Kn.azX() != null) {
                    a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.Kn.azX().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.MY != null) {
                        CardUserInfoLayout.this.MX.onClick(view);
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
        nb();
        nf();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.Nc = i;
        na();
    }

    private void na() {
        this.MP.setVisibility(isShow(1) ? 0 : 8);
        this.MK.setVisibility(isShow(4) ? 0 : 8);
        this.MN.setVisibility(isShow(16) ? 0 : 8);
        this.MR.setVisibility(isShow(8) ? 0 : 8);
        this.MO.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MZ.getLayoutParams();
        if (isShow(128)) {
            this.MQ.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.MQ.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.MZ.setLayoutParams(layoutParams);
        this.MT.setVisibility(isShow(2048) ? 0 : 8);
        this.MU.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.Nc & i) > 0;
    }

    private void nb() {
        this.MI = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.MI.setHasPendantStyle();
        this.MI.getHeadView().setIsRound(true);
        this.MI.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.MI.getHeadView().setDefaultResource(17170445);
        this.MI.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.MI.getHeadView().setPlaceHolder(1);
        this.MI.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.MX != null) {
                    CardUserInfoLayout.this.MX.onClick(view);
                }
            }
        });
        this.MJ = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.MP = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.MP.setOnClickListener(this.Nf);
        this.MK = (TextView) findViewById(R.id.user_name);
        this.MK.setOnClickListener(this.Ng);
        this.MN = (TextView) findViewById(R.id.identity_view);
        this.MR = (TextView) findViewById(R.id.thread_share_intro);
        this.MO = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.MO.setOnClickListener(this.Nh);
        this.MQ = (TextView) findViewById(R.id.thread_extend_info);
        this.MZ = findViewById(R.id.user_name_and_reply_time);
        this.Na = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.MS = (RelativeLayout) findViewById(R.id.suffix_container);
        this.MT = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.MU = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.MI.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.MV != null && this.MV.getDrawable(1) != null) {
                    this.MV.getDrawable(1).setAlpha(255);
                }
                if (this.MW != null && this.MW.getDrawable(1) != null) {
                    this.MW.getDrawable(1).setAlpha(255);
                }
                if (this.MJ != null) {
                    this.MJ.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.MJ != null) {
                    this.MJ.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.MV != null && this.MV.getDrawable(1) != null) {
                    this.MV.getDrawable(1).setAlpha(0);
                }
                if (this.MW != null && this.MW.getDrawable(1) != null) {
                    this.MW.getDrawable(1).setAlpha(0);
                }
                if (this.MJ != null) {
                    this.MJ.setAnimation("live/card_live_bg.json");
                }
            }
            this.MT.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.MI != null && bjVar != null && this.Kn.azX() != null) {
            this.MI.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.MI, this.Kn.azX(), 0)) {
                if (this.Kn.cPL > 0 && this.Kn.cPM == 0) {
                    this.MI.fJ(false);
                } else {
                    this.MI.a(this.Kn.azX(), 0);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        this.Kn = bjVar;
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
        nd();
        d(bjVar);
        setVisibility(0);
        if (isShow(128) && !bjVar.cQo && !bjVar.aBN()) {
            this.MZ.post(this.Ne);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.MU != null) {
            if (bjVar.cQj) {
                this.MU.setVisibility(0);
            } else {
                this.MU.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.azX() != null) {
            String userId = bjVar.azX().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aBR() || bjVar.ayL() || bjVar.aBS()) && bjVar.cQo && !TextUtils.equals(userId, currentAccount)) {
                this.Nc |= 2048;
            } else if ((bjVar.aBR() || bjVar.ayL() || bjVar.aBS()) && bjVar.cQp && !bjVar.azX().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.Nc |= 2048;
            } else {
                this.Nc &= -2049;
            }
            if (bjVar.aBO()) {
                this.Nc |= 4096;
            } else {
                this.Nc &= -4097;
            }
            if (bjVar.cQo && !bjVar.aBV()) {
                this.Nc &= -129;
            } else {
                this.Nc |= 128;
            }
            setShowFlag(this.Nc);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.azX() == null) {
            this.MI.setVisibility(8);
            return;
        }
        MetaData azX = bjVar.azX();
        if (!isShow(256)) {
            azX.setPendantData(null);
        }
        this.MI.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (!isShow(32768)) {
            this.MJ.setVisibility(8);
            if (this.MJ.isAnimating()) {
                this.MJ.cancelAnimation();
            }
            this.MI.setIsclearmode(false);
        } else if (bjVar != null && bjVar.azX() != null && bjVar.azX().getAlaUserData() != null) {
            if (bjVar.azX().getAlaUserData().live_status != 1) {
                this.MJ.setVisibility(8);
                this.MJ.cancelAnimation();
                this.MI.setIsclearmode(false);
                return;
            }
            this.MI.setIsclearmode(true);
            this.Nc &= -257;
            f(bjVar);
            this.MJ.setSpeed(0.8f);
            this.MJ.setVisibility(0);
            this.MJ.loop(true);
            this.MJ.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.MJ.playAnimation();
                }
            });
        } else {
            this.MJ.setVisibility(8);
            this.MJ.cancelAnimation();
            this.MI.setIsclearmode(false);
        }
    }

    private void h(bj bjVar) {
        if (this.MK != null && bjVar != null) {
            if (bjVar.cQo || bjVar.aBN()) {
                ViewGroup.LayoutParams layoutParams = this.MZ.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.MZ.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.Na.getLayoutParams();
                layoutParams2.width = -1;
                this.Na.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.MK.getLayoutParams();
                layoutParams3.width = -1;
                this.MK.setLayoutParams(layoutParams3);
                this.MK.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.azX() != null && !StringUtils.isNull(bjVar.azX().getName_show())) {
                    this.MK.setText(bjVar.azX().getName_show());
                } else {
                    this.MK.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.Kn.azu())) {
                this.MK.setText(this.Kn.azu());
            } else {
                this.MK.setText(R.string.user_name_default_txt);
            }
            nc();
        }
    }

    protected void i(bj bjVar) {
        if (this.MR != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.MR.setVisibility(8);
            } else if (this.Kn.getType() == bj.cPa) {
                this.MR.setVisibility(0);
                this.MR.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.MR, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.axR())) {
                    this.MR.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.MR.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.MR.setLayoutParams(layoutParams);
                }
                this.MR.setText(bjVar.axR());
                this.MR.setVisibility(0);
            } else if (StringUtils.isNull(this.Kn.azw())) {
                this.MR.setVisibility(8);
            } else {
                this.MR.setVisibility(0);
                this.MR.setText(this.Kn.azw());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.MO != null) {
            if (!isShow(32)) {
                this.MO.setVisibility(8);
            } else if (bjVar == null || bjVar.azX() == null || (bjVar.cPL > 0 && bjVar.cPM == 0)) {
                this.MO.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.azX().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.MO.setVisibility(0);
                    this.MO.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.MO.setVisibility(8);
            }
        }
    }

    protected String o(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void nc() {
        if (this.Kn != null && this.Kn.azX() != null) {
            if (this.Kn.cPL > 0 && this.Kn.cPM == 0) {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.Kn.azX().getTShowInfoNew()) || this.Kn.azX().isBigV()) {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.MK, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.MP != null && bjVar != null && bjVar.azX() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.azX().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.MP.setVisibility(0);
                this.MP.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.MP.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.MN != null && bjVar != null && bjVar.azX() != null && isShow(16)) {
            MetaData azX = bjVar.azX();
            if (this.MN.getLayoutParams() != null) {
                this.MN.getLayoutParams().width = -2;
            }
            this.MN.setOnClickListener(null);
            if (azX.getIs_bawu() == 1) {
                am.setBackgroundResource(this.MN, R.drawable.brand_official_btn);
                am.setViewTextColor(this.MN, (int) R.color.cp_cont_a);
                if (bjVar.cPY) {
                    this.MN.setVisibility(0);
                    this.MN.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(azX.getBawu_type())) {
                    this.MN.setBackgroundDrawable(this.MV);
                    this.MN.setVisibility(0);
                    this.MN.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(azX.getBawu_type())) {
                    this.MN.setBackgroundDrawable(this.MW);
                    this.MN.setText(R.string.bawu_member_xbazhu_tip);
                    this.MN.setVisibility(0);
                } else if ("pri_content_assist".equals(azX.getBawu_type())) {
                    this.MN.setText(R.string.bawu_content_assist_tip);
                    this.MN.setVisibility(0);
                } else if ("pri_manage_assist".equals(azX.getBawu_type())) {
                    this.MN.setText(R.string.bawu_manage_assist_tip);
                    this.MN.setVisibility(0);
                } else if (azX.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.MN.setVisibility(8);
                }
            } else if (azX.getIs_biggie()) {
                m(bjVar);
            } else {
                this.MN.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.MI;
    }

    public View getUserName() {
        return this.MK;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.MN, R.drawable.brand_official_btn);
        am.setViewTextColor(this.MN, (int) R.color.cp_cont_a);
        this.MN.setText(R.string.video_mcn);
        if (bjVar.aBd()) {
            this.MO.setVisibility(8);
        }
        this.MN.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.MX = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.MY = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.MI != null) {
            this.MI.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.MQ != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.azv())) {
                this.MQ.setVisibility(8);
                return;
            }
            if (bjVar.azX() != null && bjVar.azX().getBaijiahaoInfo() != null) {
                this.MQ.setLines(1);
                this.MQ.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.MQ.setMaxLines(Integer.MAX_VALUE);
                this.MQ.setEllipsize(null);
            }
            am.setViewTextColor(this.MQ, (int) R.color.cp_cont_d);
            this.MQ.setText(bjVar.azv());
            this.MQ.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void nd() {
        if (isShow(2048) && this.Kn != null && this.Kn.azX() != null && this.mPageContext != null && this.MT != null) {
            if (this.Nb == null) {
                this.Nb = new c(this.mPageContext, this.MT);
                this.Nb.j(this.mBdUniqueId);
            }
            this.Nb.a(this.Kn.azX());
            this.MT.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.7
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cp("obj_id", CardUserInfoLayout.this.Kn.azX().getUserId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).cp("tid", CardUserInfoLayout.this.Kn.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ne() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.MK.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.MR.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.MK.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, o(this.Kn.azX().getName_show(), 12)) + this.MK.getPaddingLeft() + this.MK.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, o(this.Kn.azX().getName_show(), 10)) + this.MK.getPaddingLeft() + this.MK.getPaddingRight();
            int measuredWidth = this.MP.getMeasuredWidth();
            int measuredWidth2 = this.MK.getMeasuredWidth();
            int measuredWidth3 = this.MR.getMeasuredWidth();
            int measuredWidth4 = this.MN.getMeasuredWidth();
            int measuredWidth5 = this.MO.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.MK.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.MK.setText(o(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.MK.setText(o(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.MO.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.MN.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.MP.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.MR.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.Kn != null && this.Kn.azX() != null && this.Kn.azX().getBaijiahaoInfo() != null) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.MQ.setMaxWidth(i2);
        }
    }

    private void nf() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.MV = new LayerDrawable(new Drawable[]{b.aEN().kk(0).ag(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aEP(), b.aEN().kk(0).ag(this.tbds6).tw("#4D000000").aEP()});
        this.MW = new LayerDrawable(new Drawable[]{b.aEN().kk(0).ag(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aEP(), b.aEN().kk(0).ag(this.tbds6).tw("#4D000000").aEP()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.MS;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class CardUserInfoLayout extends LinearLayout implements n {
    private bj adG;
    private HeadPendantClickableView afU;
    private TBLottieAnimationView afV;
    private TextView afW;
    private TextView afX;
    private UserIconBox afY;
    private UserIconBox afZ;
    private TextView aga;
    private TextView agb;
    protected RelativeLayout agc;
    private DynamicUserLikeButton agd;
    private ImageView agf;
    private LayerDrawable agg;
    private LayerDrawable agh;
    private View.OnClickListener agi;
    private View.OnClickListener agj;
    private View agk;
    private View agl;
    private c agm;
    private int agn;
    private Runnable ago;
    private View.OnClickListener agp;
    private View.OnClickListener agq;
    private View.OnClickListener agr;
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
        this.agn = 34053;
        this.ago = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.rO();
            }
        };
        this.agp = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.adG != null && CardUserInfoLayout.this.adG.aKE() != null && CardUserInfoLayout.this.adG.aKE().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.adG.aKE().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.adG.aKE().getTShowInfoNew().get(0).getUrl()) != null && (i.T(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOY().b((TbPageContext) i.T(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agq = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.adG != null && CardUserInfoLayout.this.adG.aKE() != null && !StringUtils.isNull(CardUserInfoLayout.this.adG.aKE().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.adG.aKE().getUserId()) && CardUserInfoLayout.this.adG.aKJ() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.adG.aKE().getUserId(), CardUserInfoLayout.this.adG.aKE().getName_show(), CardUserInfoLayout.this.adG.aKJ(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.adG.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.agi != null) {
                        CardUserInfoLayout.this.agi.onClick(view);
                    }
                }
            }
        };
        this.agr = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.adG != null && CardUserInfoLayout.this.adG.aKE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.adG.aKE().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.agj != null) {
                        CardUserInfoLayout.this.agi.onClick(view);
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
        rL();
        rP();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.agn = i;
        rK();
    }

    private void rK() {
        this.afZ.setVisibility(isShow(1) ? 0 : 8);
        this.afW.setVisibility(isShow(4) ? 0 : 8);
        this.afX.setVisibility(isShow(16) ? 0 : 8);
        this.agb.setVisibility(isShow(8) ? 0 : 8);
        this.afY.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agk.getLayoutParams();
        if (isShow(128)) {
            this.aga.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.aga.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.agk.setLayoutParams(layoutParams);
        this.agd.setVisibility(isShow(2048) ? 0 : 8);
        this.agf.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.agn & i) > 0;
    }

    private void rL() {
        this.afU = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.afU.setHasPendantStyle();
        this.afU.getHeadView().setIsRound(true);
        this.afU.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.afU.getHeadView().setDefaultResource(17170445);
        this.afU.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.afU.getHeadView().setPlaceHolder(1);
        this.afU.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agi != null) {
                    CardUserInfoLayout.this.agi.onClick(view);
                }
            }
        });
        this.afV = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.afZ = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.afZ.setOnClickListener(this.agp);
        this.afW = (TextView) findViewById(R.id.user_name);
        this.afW.setOnClickListener(this.agq);
        this.afX = (TextView) findViewById(R.id.identity_view);
        this.agb = (TextView) findViewById(R.id.thread_share_intro);
        this.afY = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.afY.setOnClickListener(this.agr);
        this.aga = (TextView) findViewById(R.id.thread_extend_info);
        this.agk = findViewById(R.id.user_name_and_reply_time);
        this.agl = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.agc = (RelativeLayout) findViewById(R.id.suffix_container);
        this.agd = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.agf = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.afU.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.agg != null && this.agg.getDrawable(1) != null) {
                    this.agg.getDrawable(1).setAlpha(255);
                }
                if (this.agh != null && this.agh.getDrawable(1) != null) {
                    this.agh.getDrawable(1).setAlpha(255);
                }
                if (this.afV != null) {
                    this.afV.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.afV != null) {
                    this.afV.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.agg != null && this.agg.getDrawable(1) != null) {
                    this.agg.getDrawable(1).setAlpha(0);
                }
                if (this.agh != null && this.agh.getDrawable(1) != null) {
                    this.agh.getDrawable(1).setAlpha(0);
                }
                if (this.afV != null) {
                    this.afV.setAnimation("live/card_live_bg.json");
                }
            }
            this.agd.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.afU != null && bjVar != null && this.adG.aKE() != null) {
            this.afU.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.afU, this.adG.aKE(), 0)) {
                if (this.adG.dtm > 0 && this.adG.dtn == 0) {
                    this.afU.gP(false);
                } else {
                    this.afU.a(this.adG.aKE(), 0);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        this.adG = bjVar;
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
        rN();
        d(bjVar);
        setVisibility(0);
        if (isShow(128) && !bjVar.dtQ && !bjVar.aMt()) {
            this.agk.post(this.ago);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.agf != null) {
            if (bjVar.dtL) {
                this.agf.setVisibility(0);
            } else {
                this.agf.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.aKE() != null) {
            String userId = bjVar.aKE().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aMx() || bjVar.aJt() || bjVar.aJu()) && bjVar.dtQ && !TextUtils.equals(userId, currentAccount)) {
                this.agn |= 2048;
            } else if ((bjVar.aMx() || bjVar.aJt() || bjVar.aJu()) && bjVar.dtR && !bjVar.aKE().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.agn |= 2048;
            } else if (bjVar.aKX() != null && j.ab(bjVar) && bjVar.dtQ && !TextUtils.equals(userId, currentAccount)) {
                this.agn |= 2048;
            } else {
                this.agn &= -2049;
            }
            if (bjVar.aMu()) {
                this.agn |= 4096;
            } else {
                this.agn &= -4097;
            }
            if (bjVar.dtQ && !bjVar.aMA()) {
                this.agn &= -129;
            } else {
                this.agn |= 128;
            }
            setShowFlag(this.agn);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.aKE() == null) {
            this.afU.setVisibility(8);
            return;
        }
        MetaData aKE = bjVar.aKE();
        if (!isShow(256)) {
            aKE.setPendantData(null);
        }
        this.afU.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (!isShow(32768)) {
            this.afV.setVisibility(8);
            if (this.afV.isAnimating()) {
                this.afV.cancelAnimation();
            }
            this.afU.setIsclearmode(false);
        } else if (bjVar != null && bjVar.aKE() != null && bjVar.aKE().getAlaUserData() != null) {
            if (bjVar.aKE().getAlaUserData().live_status != 1) {
                this.afV.setVisibility(8);
                this.afV.cancelAnimation();
                this.afU.setIsclearmode(false);
                return;
            }
            this.afU.setIsclearmode(true);
            this.agn &= -257;
            f(bjVar);
            this.afV.setSpeed(0.8f);
            this.afV.setVisibility(0);
            this.afV.loop(true);
            this.afV.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.afV.playAnimation();
                }
            });
        } else {
            this.afV.setVisibility(8);
            this.afV.cancelAnimation();
            this.afU.setIsclearmode(false);
        }
    }

    private void h(bj bjVar) {
        if (this.afW != null && bjVar != null) {
            if (bjVar.dtQ || bjVar.aMt()) {
                ViewGroup.LayoutParams layoutParams = this.agk.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.agk.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.agl.getLayoutParams();
                layoutParams2.width = -1;
                this.agl.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.afW.getLayoutParams();
                layoutParams3.width = -1;
                this.afW.setLayoutParams(layoutParams3);
                this.afW.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.aKE() != null && !StringUtils.isNull(bjVar.aKE().getName_show())) {
                    this.afW.setText(bjVar.aKE().getName_show());
                } else {
                    this.afW.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.adG.aKc())) {
                this.afW.setText(this.adG.aKc());
            } else {
                this.afW.setText(R.string.user_name_default_txt);
            }
            rM();
        }
    }

    protected void i(bj bjVar) {
        if (this.agb != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.agb.setVisibility(8);
            } else if (this.adG.getType() == bj.dsB) {
                this.agb.setVisibility(0);
                this.agb.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.agb, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.aIx())) {
                    this.agb.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agb.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.agb.setLayoutParams(layoutParams);
                }
                this.agb.setText(bjVar.aIx());
                this.agb.setVisibility(0);
            } else if (StringUtils.isNull(this.adG.aKe())) {
                this.agb.setVisibility(8);
            } else {
                this.agb.setVisibility(0);
                this.agb.setText(this.adG.aKe());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.afY != null) {
            if (!isShow(32)) {
                this.afY.setVisibility(8);
            } else if (bjVar == null || bjVar.aKE() == null || (bjVar.dtm > 0 && bjVar.dtn == 0)) {
                this.afY.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aKE().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.afY.setVisibility(0);
                    this.afY.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.afY.setVisibility(8);
            }
        }
    }

    protected String s(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void rM() {
        if (this.adG != null && this.adG.aKE() != null) {
            if (this.adG.dtm > 0 && this.adG.dtn == 0) {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.adG.aKE().getTShowInfoNew()) || this.adG.aKE().isBigV()) {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.afW, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.afZ != null && bjVar != null && bjVar.aKE() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.aKE().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.afZ.setVisibility(0);
                this.afZ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.afZ.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.afX != null && bjVar != null && bjVar.aKE() != null && isShow(16)) {
            MetaData aKE = bjVar.aKE();
            if (this.afX.getLayoutParams() != null) {
                this.afX.getLayoutParams().width = -2;
            }
            this.afX.setOnClickListener(null);
            if (aKE.getIs_bawu() == 1) {
                am.setBackgroundResource(this.afX, R.drawable.brand_official_btn);
                am.setViewTextColor(this.afX, (int) R.color.cp_cont_a);
                if (bjVar.dtA) {
                    this.afX.setVisibility(0);
                    this.afX.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aKE.getBawu_type())) {
                    this.afX.setBackgroundDrawable(this.agg);
                    this.afX.setVisibility(0);
                    this.afX.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aKE.getBawu_type())) {
                    this.afX.setBackgroundDrawable(this.agh);
                    this.afX.setText(R.string.bawu_member_xbazhu_tip);
                    this.afX.setVisibility(0);
                } else if ("pri_content_assist".equals(aKE.getBawu_type())) {
                    this.afX.setText(R.string.bawu_content_assist_tip);
                    this.afX.setVisibility(0);
                } else if ("pri_manage_assist".equals(aKE.getBawu_type())) {
                    this.afX.setText(R.string.bawu_manage_assist_tip);
                    this.afX.setVisibility(0);
                } else if (aKE.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.afX.setVisibility(8);
                }
            } else if (aKE.getIs_biggie()) {
                m(bjVar);
            } else {
                this.afX.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.afU;
    }

    public View getUserName() {
        return this.afW;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.afX, R.drawable.brand_official_btn);
        am.setViewTextColor(this.afX, (int) R.color.cp_cont_a);
        this.afX.setText(R.string.video_mcn);
        if (bjVar.aLJ()) {
            this.afY.setVisibility(8);
        }
        this.afX.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agi = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.agj = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.afU != null) {
            this.afU.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.aga != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.aKd())) {
                this.aga.setVisibility(8);
                return;
            }
            if (bjVar.aKE() != null && bjVar.aKE().isBaijiahaoUser()) {
                this.aga.setLines(1);
                this.aga.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.aga.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.aga.setEllipsize(null);
            }
            am.setViewTextColor(this.aga, (int) R.color.cp_cont_d);
            this.aga.setText(bjVar.aKd());
            this.aga.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void rN() {
        if (isShow(2048) && this.adG != null && this.adG.aKE() != null && this.mPageContext != null && this.agd != null) {
            if (this.agm == null) {
                this.agm = new c(this.mPageContext, this.agd);
                this.agm.j(this.mBdUniqueId);
            }
            this.agm.a(this.adG.aKE());
            this.agd.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.7
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cI("obj_id", CardUserInfoLayout.this.adG.aKE().getUserId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).cI("tid", CardUserInfoLayout.this.adG.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rO() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.afW.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.agb.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.afW.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, s(this.adG.aKE().getName_show(), 12)) + this.afW.getPaddingLeft() + this.afW.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, s(this.adG.aKE().getName_show(), 10)) + this.afW.getPaddingLeft() + this.afW.getPaddingRight();
            int measuredWidth = this.afZ.getMeasuredWidth();
            int measuredWidth2 = this.afW.getMeasuredWidth();
            int measuredWidth3 = this.agb.getMeasuredWidth();
            int measuredWidth4 = this.afX.getMeasuredWidth();
            int measuredWidth5 = this.afY.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.afW.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.afW.setText(s(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.afW.setText(s(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.afY.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.afX.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.afZ.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.agb.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.adG != null && this.adG.aKE() != null && this.adG.aKE().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.aga.setMaxWidth(i2);
        }
    }

    private void rP() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.agg = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.tbds6).va("#4D000000").aPA()});
        this.agh = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPA(), com.baidu.tbadk.core.util.e.a.c.aPy().kL(0).P(this.tbds6).va("#4D000000").aPA()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.agc;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

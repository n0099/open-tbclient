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
    private bj adJ;
    private HeadPendantClickableView afX;
    private TBLottieAnimationView afY;
    private TextView afZ;
    private TextView aga;
    private UserIconBox agb;
    private UserIconBox agc;
    private TextView agd;
    private TextView agf;
    protected RelativeLayout agg;
    private DynamicUserLikeButton agh;
    private ImageView agi;
    private LayerDrawable agj;
    private LayerDrawable agk;
    private View.OnClickListener agl;
    private View.OnClickListener agm;
    private View agn;
    private View ago;
    private c agp;
    private int agq;
    private Runnable agr;
    private View.OnClickListener ags;
    private View.OnClickListener agt;
    private View.OnClickListener agu;
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
        this.agq = 34053;
        this.agr = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.rO();
            }
        };
        this.ags = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.adJ != null && CardUserInfoLayout.this.adJ.aKC() != null && CardUserInfoLayout.this.adJ.aKC().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.adJ.aKC().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.adJ.aKC().getTShowInfoNew().get(0).getUrl()) != null && (i.G(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aOV().b((TbPageContext) i.G(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agt = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.adJ != null && CardUserInfoLayout.this.adJ.aKC() != null && !StringUtils.isNull(CardUserInfoLayout.this.adJ.aKC().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.adJ.aKC().getUserId()) && CardUserInfoLayout.this.adJ.aKH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.adJ.aKC().getUserId(), CardUserInfoLayout.this.adJ.aKC().getName_show(), CardUserInfoLayout.this.adJ.aKH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.adJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.agl != null) {
                        CardUserInfoLayout.this.agl.onClick(view);
                    }
                }
            }
        };
        this.agu = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.adJ != null && CardUserInfoLayout.this.adJ.aKC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.adJ.aKC().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.agm != null) {
                        CardUserInfoLayout.this.agl.onClick(view);
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
        this.agq = i;
        rK();
    }

    private void rK() {
        this.agc.setVisibility(isShow(1) ? 0 : 8);
        this.afZ.setVisibility(isShow(4) ? 0 : 8);
        this.aga.setVisibility(isShow(16) ? 0 : 8);
        this.agf.setVisibility(isShow(8) ? 0 : 8);
        this.agb.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agn.getLayoutParams();
        if (isShow(128)) {
            this.agd.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.agd.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.agn.setLayoutParams(layoutParams);
        this.agh.setVisibility(isShow(2048) ? 0 : 8);
        this.agi.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.agq & i) > 0;
    }

    private void rL() {
        this.afX = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.afX.setHasPendantStyle();
        this.afX.getHeadView().setIsRound(true);
        this.afX.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.afX.getHeadView().setDefaultResource(17170445);
        this.afX.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.afX.getHeadView().setPlaceHolder(1);
        this.afX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agl != null) {
                    CardUserInfoLayout.this.agl.onClick(view);
                }
            }
        });
        this.afY = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.agc = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.agc.setOnClickListener(this.ags);
        this.afZ = (TextView) findViewById(R.id.user_name);
        this.afZ.setOnClickListener(this.agt);
        this.aga = (TextView) findViewById(R.id.identity_view);
        this.agf = (TextView) findViewById(R.id.thread_share_intro);
        this.agb = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.agb.setOnClickListener(this.agu);
        this.agd = (TextView) findViewById(R.id.thread_extend_info);
        this.agn = findViewById(R.id.user_name_and_reply_time);
        this.ago = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.agg = (RelativeLayout) findViewById(R.id.suffix_container);
        this.agh = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.agi = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.afX.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.agj != null && this.agj.getDrawable(1) != null) {
                    this.agj.getDrawable(1).setAlpha(255);
                }
                if (this.agk != null && this.agk.getDrawable(1) != null) {
                    this.agk.getDrawable(1).setAlpha(255);
                }
                if (this.afY != null) {
                    this.afY.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.afY != null) {
                    this.afY.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.agj != null && this.agj.getDrawable(1) != null) {
                    this.agj.getDrawable(1).setAlpha(0);
                }
                if (this.agk != null && this.agk.getDrawable(1) != null) {
                    this.agk.getDrawable(1).setAlpha(0);
                }
                if (this.afY != null) {
                    this.afY.setAnimation("live/card_live_bg.json");
                }
            }
            this.agh.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.afX != null && bjVar != null && this.adJ.aKC() != null) {
            this.afX.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.afX, this.adJ.aKC(), 0)) {
                if (this.adJ.dtq > 0 && this.adJ.dtr == 0) {
                    this.afX.gP(false);
                } else {
                    this.afX.a(this.adJ.aKC(), 0);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        this.adJ = bjVar;
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
        if (isShow(128) && !bjVar.dtU && !bjVar.aMr()) {
            this.agn.post(this.agr);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.agi != null) {
            if (bjVar.dtP) {
                this.agi.setVisibility(0);
            } else {
                this.agi.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.aKC() != null) {
            String userId = bjVar.aKC().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aMv() || bjVar.aJr() || bjVar.aJs()) && bjVar.dtU && !TextUtils.equals(userId, currentAccount)) {
                this.agq |= 2048;
            } else if ((bjVar.aMv() || bjVar.aJr() || bjVar.aJs()) && bjVar.dtV && !bjVar.aKC().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.agq |= 2048;
            } else if (bjVar.aKV() != null && j.ab(bjVar) && bjVar.dtU && !TextUtils.equals(userId, currentAccount)) {
                this.agq |= 2048;
            } else {
                this.agq &= -2049;
            }
            if (bjVar.aMs()) {
                this.agq |= 4096;
            } else {
                this.agq &= -4097;
            }
            if (bjVar.dtU && !bjVar.aMy()) {
                this.agq &= -129;
            } else {
                this.agq |= 128;
            }
            setShowFlag(this.agq);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.aKC() == null) {
            this.afX.setVisibility(8);
            return;
        }
        MetaData aKC = bjVar.aKC();
        if (!isShow(256)) {
            aKC.setPendantData(null);
        }
        this.afX.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (!isShow(32768)) {
            this.afY.setVisibility(8);
            if (this.afY.isAnimating()) {
                this.afY.cancelAnimation();
            }
            this.afX.setIsclearmode(false);
        } else if (bjVar != null && bjVar.aKC() != null && bjVar.aKC().getAlaUserData() != null) {
            if (bjVar.aKC().getAlaUserData().live_status != 1) {
                this.afY.setVisibility(8);
                this.afY.cancelAnimation();
                this.afX.setIsclearmode(false);
                return;
            }
            this.afX.setIsclearmode(true);
            this.agq &= -257;
            f(bjVar);
            this.afY.setSpeed(0.8f);
            this.afY.setVisibility(0);
            this.afY.loop(true);
            this.afY.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.afY.playAnimation();
                }
            });
        } else {
            this.afY.setVisibility(8);
            this.afY.cancelAnimation();
            this.afX.setIsclearmode(false);
        }
    }

    private void h(bj bjVar) {
        if (this.afZ != null && bjVar != null) {
            if (bjVar.dtU || bjVar.aMr()) {
                ViewGroup.LayoutParams layoutParams = this.agn.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.agn.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ago.getLayoutParams();
                layoutParams2.width = -1;
                this.ago.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.afZ.getLayoutParams();
                layoutParams3.width = -1;
                this.afZ.setLayoutParams(layoutParams3);
                this.afZ.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.aKC() != null && !StringUtils.isNull(bjVar.aKC().getName_show())) {
                    this.afZ.setText(bjVar.aKC().getName_show());
                } else {
                    this.afZ.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.adJ.aKa())) {
                this.afZ.setText(this.adJ.aKa());
            } else {
                this.afZ.setText(R.string.user_name_default_txt);
            }
            rM();
        }
    }

    protected void i(bj bjVar) {
        if (this.agf != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.agf.setVisibility(8);
            } else if (this.adJ.getType() == bj.dsF) {
                this.agf.setVisibility(0);
                this.agf.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.agf, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.aIv())) {
                    this.agf.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agf.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.agf.setLayoutParams(layoutParams);
                }
                this.agf.setText(bjVar.aIv());
                this.agf.setVisibility(0);
            } else if (StringUtils.isNull(this.adJ.aKc())) {
                this.agf.setVisibility(8);
            } else {
                this.agf.setVisibility(0);
                this.agf.setText(this.adJ.aKc());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.agb != null) {
            if (!isShow(32)) {
                this.agb.setVisibility(8);
            } else if (bjVar == null || bjVar.aKC() == null || (bjVar.dtq > 0 && bjVar.dtr == 0)) {
                this.agb.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aKC().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.agb.setVisibility(0);
                    this.agb.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.agb.setVisibility(8);
            }
        }
    }

    protected String s(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void rM() {
        if (this.adJ != null && this.adJ.aKC() != null) {
            if (this.adJ.dtq > 0 && this.adJ.dtr == 0) {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.adJ.aKC().getTShowInfoNew()) || this.adJ.aKC().isBigV()) {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.afZ, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.agc != null && bjVar != null && bjVar.aKC() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.aKC().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agc.setVisibility(0);
                this.agc.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.agc.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.aga != null && bjVar != null && bjVar.aKC() != null && isShow(16)) {
            MetaData aKC = bjVar.aKC();
            if (this.aga.getLayoutParams() != null) {
                this.aga.getLayoutParams().width = -2;
            }
            this.aga.setOnClickListener(null);
            if (aKC.getIs_bawu() == 1) {
                am.setBackgroundResource(this.aga, R.drawable.brand_official_btn);
                am.setViewTextColor(this.aga, (int) R.color.cp_cont_a);
                if (bjVar.dtE) {
                    this.aga.setVisibility(0);
                    this.aga.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aKC.getBawu_type())) {
                    this.aga.setBackgroundDrawable(this.agj);
                    this.aga.setVisibility(0);
                    this.aga.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aKC.getBawu_type())) {
                    this.aga.setBackgroundDrawable(this.agk);
                    this.aga.setText(R.string.bawu_member_xbazhu_tip);
                    this.aga.setVisibility(0);
                } else if ("pri_content_assist".equals(aKC.getBawu_type())) {
                    this.aga.setText(R.string.bawu_content_assist_tip);
                    this.aga.setVisibility(0);
                } else if ("pri_manage_assist".equals(aKC.getBawu_type())) {
                    this.aga.setText(R.string.bawu_manage_assist_tip);
                    this.aga.setVisibility(0);
                } else if (aKC.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.aga.setVisibility(8);
                }
            } else if (aKC.getIs_biggie()) {
                m(bjVar);
            } else {
                this.aga.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.afX;
    }

    public View getUserName() {
        return this.afZ;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.aga, R.drawable.brand_official_btn);
        am.setViewTextColor(this.aga, (int) R.color.cp_cont_a);
        this.aga.setText(R.string.video_mcn);
        if (bjVar.aLH()) {
            this.agb.setVisibility(8);
        }
        this.aga.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agl = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.agm = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.afX != null) {
            this.afX.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.agd != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.aKb())) {
                this.agd.setVisibility(8);
                return;
            }
            if (bjVar.aKC() != null && bjVar.aKC().isBaijiahaoUser()) {
                this.agd.setLines(1);
                this.agd.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.agd.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.agd.setEllipsize(null);
            }
            am.setViewTextColor(this.agd, (int) R.color.cp_cont_d);
            this.agd.setText(bjVar.aKb());
            this.agd.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void rN() {
        if (isShow(2048) && this.adJ != null && this.adJ.aKC() != null && this.mPageContext != null && this.agh != null) {
            if (this.agp == null) {
                this.agp = new c(this.mPageContext, this.agh);
                this.agp.j(this.mBdUniqueId);
            }
            this.agp.a(this.adJ.aKC());
            this.agh.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.7
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cI("obj_id", CardUserInfoLayout.this.adJ.aKC().getUserId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).cI("tid", CardUserInfoLayout.this.adJ.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rO() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.afZ.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.agf.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.afZ.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, s(this.adJ.aKC().getName_show(), 12)) + this.afZ.getPaddingLeft() + this.afZ.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, s(this.adJ.aKC().getName_show(), 10)) + this.afZ.getPaddingLeft() + this.afZ.getPaddingRight();
            int measuredWidth = this.agc.getMeasuredWidth();
            int measuredWidth2 = this.afZ.getMeasuredWidth();
            int measuredWidth3 = this.agf.getMeasuredWidth();
            int measuredWidth4 = this.aga.getMeasuredWidth();
            int measuredWidth5 = this.agb.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.afZ.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.afZ.setText(s(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.afZ.setText(s(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.agb.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.aga.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.agc.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.agf.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.adJ != null && this.adJ.aKC() != null && this.adJ.aKC().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.agd.setMaxWidth(i2);
        }
    }

    private void rP() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.agj = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.tbds6).vd("#4D000000").aPx()});
        this.agk = new LayerDrawable(new Drawable[]{com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aPx(), com.baidu.tbadk.core.util.e.a.c.aPv().kL(0).P(this.tbds6).vd("#4D000000").aPx()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.agg;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

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
import com.baidu.card.o;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class CardUserInfoLayout extends LinearLayout implements o {
    private static final int ahQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bu aeK;
    private TextView ahA;
    private TextView ahB;
    private UserIconBox ahC;
    private UserIconBox ahD;
    private TextView ahE;
    private ImageView ahF;
    private TextView ahG;
    private TextView ahH;
    protected RelativeLayout ahI;
    private ImageView ahJ;
    private LayerDrawable ahK;
    private LayerDrawable ahL;
    private View.OnClickListener ahM;
    private View.OnClickListener ahN;
    private View ahO;
    private View ahP;
    private int ahR;
    private Runnable ahS;
    private View.OnClickListener ahT;
    private View.OnClickListener ahU;
    private View.OnClickListener ahV;
    private HeadPendantClickableView ahy;
    private TBLottieAnimationView ahz;
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
        this.ahR = 34053;
        this.ahS = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.ss();
            }
        };
        this.ahT = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (be.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.aeK != null && CardUserInfoLayout.this.aeK.aSp() != null && CardUserInfoLayout.this.aeK.aSp().getTShowInfoNew() != null && w.getItem(CardUserInfoLayout.this.aeK.aSp().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.aeK.aSp().getTShowInfoNew().get(0).getUrl()) != null && (i.G(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bc.aWU().b((TbPageContext) i.G(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahU = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aeK != null && CardUserInfoLayout.this.aeK.aSp() != null && !StringUtils.isNull(CardUserInfoLayout.this.aeK.aSp().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.aeK.aSp().getUserId()) && CardUserInfoLayout.this.aeK.aSt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && be.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.aeK.aSp().getUserId(), CardUserInfoLayout.this.aeK.aSp().getName_show(), CardUserInfoLayout.this.aeK.aSt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.aeK.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ahM != null) {
                        CardUserInfoLayout.this.ahM.onClick(view);
                    }
                }
            }
        };
        this.ahV = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aeK != null && CardUserInfoLayout.this.aeK.aSp() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.aeK.aSp().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ahN != null) {
                        CardUserInfoLayout.this.ahM.onClick(view);
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
        sq();
        st();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.ahR = i;
        sp();
    }

    private void sp() {
        this.ahD.setVisibility(isShow(1) ? 0 : 8);
        this.ahA.setVisibility(isShow(4) ? 0 : 8);
        this.ahB.setVisibility(isShow(16) ? 0 : 8);
        this.ahH.setVisibility(isShow(8) ? 0 : 8);
        this.ahC.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahO.getLayoutParams();
        if (isShow(128)) {
            this.ahE.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.ahE.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.ahO.setLayoutParams(layoutParams);
        this.ahJ.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ahR & i) > 0;
    }

    private void sq() {
        this.ahy = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ahy.setHasPendantStyle();
        this.ahy.getHeadView().setIsRound(true);
        this.ahy.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahy.getHeadView().setDefaultResource(17170445);
        this.ahy.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ahy.getHeadView().setPlaceHolder(1);
        this.ahy.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahM != null) {
                    CardUserInfoLayout.this.ahM.onClick(view);
                }
            }
        });
        this.ahz = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.ahD = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ahD.setOnClickListener(this.ahT);
        this.ahA = (TextView) findViewById(R.id.user_name);
        this.ahA.setOnClickListener(this.ahU);
        this.ahB = (TextView) findViewById(R.id.identity_view);
        this.ahH = (TextView) findViewById(R.id.thread_share_intro);
        this.ahC = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.ahC.setOnClickListener(this.ahV);
        this.ahE = (TextView) findViewById(R.id.thread_extend_info);
        if (g.aWc()) {
            this.ahE.setPadding(0, -ahQ, 0, 0);
        }
        this.ahF = (ImageView) findViewById(R.id.ala_location_icon);
        this.ahG = (TextView) findViewById(R.id.ala_location);
        this.ahO = findViewById(R.id.user_name_and_reply_time);
        this.ahP = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ahI = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ahJ = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ahy.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ahK != null && this.ahK.getDrawable(1) != null) {
                    this.ahK.getDrawable(1).setAlpha(255);
                }
                if (this.ahL != null && this.ahL.getDrawable(1) != null) {
                    this.ahL.getDrawable(1).setAlpha(255);
                }
                if (this.ahz != null) {
                    this.ahz.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.ahz != null) {
                    this.ahz.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.ahK != null && this.ahK.getDrawable(1) != null) {
                    this.ahK.getDrawable(1).setAlpha(0);
                }
                if (this.ahL != null && this.ahL.getDrawable(1) != null) {
                    this.ahL.getDrawable(1).setAlpha(0);
                }
                if (this.ahz != null) {
                    this.ahz.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void c(bu buVar) {
        if (this.ahy != null && buVar != null && this.aeK.aSp() != null) {
            this.ahy.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ahy, this.aeK.aSp(), 0)) {
                this.ahy.setIsHomePage(buVar.dOy);
                if (this.aeK.dNV > 0 && this.aeK.dNW == 0) {
                    this.ahy.hs(false);
                } else {
                    this.ahy.a(this.aeK.aSp(), 0);
                }
            }
        }
    }

    public void setData(bu buVar) {
        if (buVar == null) {
            setVisibility(8);
            return;
        }
        this.aeK = buVar;
        e(buVar);
        f(buVar);
        k(buVar);
        l(buVar);
        h(buVar);
        j(buVar);
        c(buVar);
        m(buVar);
        n(buVar);
        i(buVar);
        g(buVar);
        d(buVar);
        setVisibility(0);
        if (isShow(128) && !buVar.dOy && !buVar.aUh()) {
            this.ahO.post(this.ahS);
        }
    }

    private void d(bu buVar) {
        if (isShow(4096) && buVar != null && this.ahJ != null) {
            if (buVar.dOu) {
                this.ahJ.setVisibility(0);
            } else {
                this.ahJ.setVisibility(8);
            }
        }
    }

    private void e(bu buVar) {
        if (buVar != null && buVar.aSp() != null) {
            if (buVar.aUi()) {
                this.ahR |= 4096;
            } else {
                this.ahR &= -4097;
            }
            if (buVar.dOy && !buVar.aQZ() && !buVar.aUs() && buVar.getType() != bu.dLI) {
                this.ahR &= -129;
            } else {
                this.ahR |= 128;
            }
            setShowFlag(this.ahR);
        }
    }

    private void f(bu buVar) {
        if (buVar.aSp() == null) {
            this.ahy.setVisibility(8);
            return;
        }
        MetaData aSp = buVar.aSp();
        if (!isShow(256)) {
            aSp.setPendantData(null);
        }
        this.ahy.setData(buVar);
    }

    private void g(bu buVar) {
        if (!isShow(32768)) {
            this.ahz.setVisibility(8);
            if (this.ahz.isAnimating()) {
                this.ahz.cancelAnimation();
            }
            this.ahy.setIsclearmode(false);
        } else if (buVar != null && buVar.aSp() != null && buVar.aSp().getAlaUserData() != null) {
            if (buVar.aSp().getAlaUserData().live_status != 1) {
                this.ahz.setVisibility(8);
                this.ahz.cancelAnimation();
                this.ahy.setIsclearmode(false);
                return;
            }
            this.ahy.setIsclearmode(true);
            this.ahR &= -257;
            f(buVar);
            this.ahz.setSpeed(0.8f);
            this.ahz.setVisibility(0);
            this.ahz.loop(true);
            this.ahz.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ahz.playAnimation();
                }
            });
        } else {
            this.ahz.setVisibility(8);
            this.ahz.cancelAnimation();
            this.ahy.setIsclearmode(false);
        }
    }

    private void h(bu buVar) {
        if (this.ahA != null && buVar != null) {
            if (buVar.dOy || buVar.aUh()) {
                ViewGroup.LayoutParams layoutParams = this.ahO.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ahO.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ahP.getLayoutParams();
                layoutParams2.width = -1;
                this.ahP.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ahA.getLayoutParams();
                layoutParams3.width = -1;
                this.ahA.setLayoutParams(layoutParams3);
                this.ahA.setEllipsize(TextUtils.TruncateAt.END);
                if (buVar.aSp() != null && !StringUtils.isNull(buVar.aSp().getName_show())) {
                    this.ahA.setText(buVar.aSp().getName_show());
                } else {
                    this.ahA.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.aeK.aRM())) {
                this.ahA.setText(this.aeK.aRM());
            } else {
                this.ahA.setText(R.string.user_name_default_txt);
            }
            sr();
        }
    }

    protected void i(bu buVar) {
        if (this.ahH != null) {
            if (buVar == null || (!isShow(8) && !isShow(512))) {
                this.ahH.setVisibility(8);
            } else if (this.aeK.getType() == bu.dNk) {
                this.ahH.setVisibility(0);
                this.ahH.getPaint().setFakeBoldText(true);
                an.setViewTextColor(this.ahH, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(buVar.aPT())) {
                    this.ahH.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahH.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ahH.setLayoutParams(layoutParams);
                }
                this.ahH.setText(buVar.aPT());
                this.ahH.setVisibility(0);
            } else if (StringUtils.isNull(this.aeK.aRO())) {
                this.ahH.setVisibility(8);
            } else {
                this.ahH.setVisibility(0);
                this.ahH.setText(this.aeK.aRO());
            }
        }
    }

    private void j(bu buVar) {
        if (this.ahC != null) {
            if (!isShow(32)) {
                this.ahC.setVisibility(8);
            } else if (buVar == null || buVar.aSp() == null || (buVar.dNV > 0 && buVar.dNW == 0)) {
                this.ahC.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = buVar.aSp().getIconInfo();
                if (w.getCount(iconInfo) != 0) {
                    this.ahC.setVisibility(0);
                    this.ahC.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.ahC.setVisibility(8);
            }
        }
    }

    protected String s(String str, int i) {
        return ar.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void sr() {
        if (this.aeK != null && this.aeK.aSp() != null) {
            if (this.aeK.dNV > 0 && this.aeK.dNW == 0) {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_f);
            } else if (!w.isEmpty(this.aeK.aSp().getTShowInfoNew()) || this.aeK.aUs()) {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_h);
            } else {
                an.setViewTextColor(this.ahA, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bu buVar) {
        if (this.ahD != null && buVar != null && buVar.aSp() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = buVar.aSp().getTShowInfoNew();
            if (w.getCount(tShowInfoNew) != 0) {
                this.ahD.setVisibility(0);
                this.ahD.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ahD.setVisibility(8);
        }
    }

    private void l(bu buVar) {
        if (this.ahB != null && buVar != null && buVar.aSp() != null && isShow(16)) {
            MetaData aSp = buVar.aSp();
            if (this.ahB.getLayoutParams() != null) {
                this.ahB.getLayoutParams().width = -2;
            }
            this.ahB.setOnClickListener(null);
            if (aSp.getIs_bawu() == 1) {
                an.setBackgroundResource(this.ahB, R.drawable.brand_official_btn);
                an.setViewTextColor(this.ahB, (int) R.color.cp_cont_a);
                if (buVar.dOj) {
                    this.ahB.setVisibility(0);
                    this.ahB.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(aSp.getBawu_type())) {
                    this.ahB.setBackgroundDrawable(this.ahK);
                    this.ahB.setVisibility(0);
                    this.ahB.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(aSp.getBawu_type())) {
                    this.ahB.setBackgroundDrawable(this.ahL);
                    this.ahB.setText(R.string.bawu_member_xbazhu_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(aSp.getBawu_type())) {
                    this.ahB.setText(R.string.bawu_content_assist_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(aSp.getBawu_type())) {
                    this.ahB.setText(R.string.bawu_manage_assist_tip);
                    this.ahB.setVisibility(0);
                    return;
                } else {
                    this.ahB.setVisibility(8);
                    return;
                }
            }
            this.ahB.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ahy;
    }

    public View getUserName() {
        return this.ahA;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahM = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ahN = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ahy != null) {
            this.ahy.setPageId(bdUniqueId);
        }
    }

    private void m(bu buVar) {
        if (this.ahE != null) {
            if (buVar == null || TextUtils.isEmpty(buVar.aRN())) {
                this.ahE.setVisibility(8);
                return;
            }
            if (buVar.aSp() != null && buVar.aSp().isBaijiahaoUser()) {
                this.ahE.setLines(1);
                this.ahE.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ahE.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ahE.setEllipsize(null);
            }
            an.setViewTextColor(this.ahE, (int) R.color.cp_cont_d);
            this.ahE.setText(buVar.aRN());
            this.ahE.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void n(bu buVar) {
        String address;
        boolean z = true;
        da("");
        if (buVar != null && buVar.getType() == bu.dLI && buVar.aSJ() != null && buVar.aSJ().openRecomLocation != 0) {
            String aSE = buVar.aSE();
            String aSF = buVar.aSF();
            boolean z2 = UtilHelper.isDecimal(aSE) && UtilHelper.isDecimal(aSF);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo cZJ = com.baidu.tieba.recapp.d.a.cZF().cZJ();
                String str = cZJ.latitude;
                String str2 = cZJ.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(aSE), Double.parseDouble(aSF));
                    if (GetDistance <= 50.0d) {
                        address = ar.m(GetDistance);
                    } else {
                        address = buVar.getAddress();
                    }
                }
                address = "";
            } else {
                if (z2) {
                    address = buVar.getAddress();
                }
                address = "";
            }
            da(address);
        }
    }

    private void da(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ahF.setVisibility(z ? 0 : 8);
        this.ahG.setVisibility(z ? 0 : 8);
        if (z) {
            this.ahG.setText(str);
            SvgManager.aWQ().a(this.ahF, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            an.setViewTextColor(this.ahG, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ss() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ahA.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.ahH.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ahA.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, s(this.aeK.aSp().getName_show(), 12)) + this.ahA.getPaddingLeft() + this.ahA.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, s(this.aeK.aSp().getName_show(), 10)) + this.ahA.getPaddingLeft() + this.ahA.getPaddingRight();
            int measuredWidth = this.ahD.getMeasuredWidth();
            int measuredWidth2 = this.ahA.getMeasuredWidth();
            int measuredWidth3 = this.ahH.getMeasuredWidth();
            int measuredWidth4 = this.ahB.getMeasuredWidth();
            int measuredWidth5 = this.ahC.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ahA.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ahA.setText(s(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ahA.setText(s(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.ahC.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ahB.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ahD.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.ahH.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.aeK != null && this.aeK.aSp() != null && this.aeK.aSp().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.ahE.setMaxWidth(i2);
        }
    }

    private void st() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.ahK = new LayerDrawable(new Drawable[]{c.aXu().lG(0).Q(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aXw(), c.aXu().lG(0).Q(this.tbds6).xa("#4D000000").aXw()});
        this.ahL = new LayerDrawable(new Drawable[]{c.aXu().lG(0).Q(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aXw(), c.aXu().lG(0).Q(this.tbds6).xa("#4D000000").aXw()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.ahI;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

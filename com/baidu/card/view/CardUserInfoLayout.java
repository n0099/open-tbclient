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
import com.baidu.card.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes15.dex */
public class CardUserInfoLayout extends LinearLayout implements p {
    private static final int aiV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bw afJ;
    private HeadPendantClickableView aiD;
    private TBLottieAnimationView aiE;
    private TextView aiF;
    private TextView aiG;
    private UserIconBox aiH;
    private UserIconBox aiI;
    private TextView aiJ;
    private ImageView aiK;
    private TextView aiL;
    private TextView aiM;
    protected RelativeLayout aiN;
    private ImageView aiO;
    private LayerDrawable aiP;
    private LayerDrawable aiQ;
    private View.OnClickListener aiR;
    private View.OnClickListener aiS;
    private View aiT;
    private View aiU;
    private int aiW;
    private Runnable aiX;
    private View.OnClickListener aiY;
    private View.OnClickListener aiZ;
    private View.OnClickListener aja;
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
        this.aiW = 34053;
        this.aiX = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.uh();
            }
        };
        this.aiY = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.afJ != null && CardUserInfoLayout.this.afJ.beE() != null && CardUserInfoLayout.this.afJ.beE().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.afJ.beE().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.afJ.beE().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aiZ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.afJ != null && CardUserInfoLayout.this.afJ.beE() != null && !StringUtils.isNull(CardUserInfoLayout.this.afJ.beE().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.afJ.beE().getUserId()) && CardUserInfoLayout.this.afJ.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.afJ.beE().getUserId(), CardUserInfoLayout.this.afJ.beE().getName_show(), CardUserInfoLayout.this.afJ.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.afJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.aiR != null) {
                        CardUserInfoLayout.this.aiR.onClick(view);
                    }
                }
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.afJ != null && CardUserInfoLayout.this.afJ.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.afJ.beE().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.aiS != null) {
                        CardUserInfoLayout.this.aiR.onClick(view);
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
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        uf();
        ui();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.aiW = i;
        ue();
    }

    private void ue() {
        this.aiI.setVisibility(isShow(1) ? 0 : 8);
        this.aiF.setVisibility(isShow(4) ? 0 : 8);
        this.aiG.setVisibility(isShow(16) ? 0 : 8);
        this.aiM.setVisibility(isShow(8) ? 0 : 8);
        this.aiH.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiT.getLayoutParams();
        if (isShow(128)) {
            this.aiJ.setVisibility(0);
        } else {
            this.aiJ.setVisibility(8);
        }
        this.aiT.setLayoutParams(layoutParams);
        this.aiO.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.aiW & i) > 0;
    }

    private void uf() {
        this.aiD = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.aiD.setHasPendantStyle();
        this.aiD.getHeadView().setIsRound(true);
        this.aiD.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiD.getHeadView().setDefaultResource(17170445);
        this.aiD.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.aiD.getHeadView().setPlaceHolder(1);
        this.aiD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aiR != null) {
                    CardUserInfoLayout.this.aiR.onClick(view);
                }
            }
        });
        this.aiE = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.aiI = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.aiI.setOnClickListener(this.aiY);
        this.aiF = (TextView) findViewById(R.id.user_name);
        this.aiF.setOnClickListener(this.aiZ);
        this.aiG = (TextView) findViewById(R.id.identity_view);
        this.aiM = (TextView) findViewById(R.id.thread_share_intro);
        this.aiH = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.aiH.setOnClickListener(this.aja);
        this.aiH.setAutoChangedStyle(false);
        this.aiJ = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bix()) {
            this.aiJ.setPadding(0, -aiV, 0, 0);
        }
        this.aiK = (ImageView) findViewById(R.id.ala_location_icon);
        this.aiL = (TextView) findViewById(R.id.ala_location);
        this.aiT = findViewById(R.id.user_name_and_reply_time);
        this.aiU = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.aiN = (RelativeLayout) findViewById(R.id.suffix_container);
        this.aiO = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.aiD.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.aiP != null && this.aiP.getDrawable(1) != null) {
                    this.aiP.getDrawable(1).setAlpha(255);
                }
                if (this.aiQ != null && this.aiQ.getDrawable(1) != null) {
                    this.aiQ.getDrawable(1).setAlpha(255);
                }
                if (this.aiE != null) {
                    this.aiE.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.aiE != null) {
                    this.aiE.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.aiP != null && this.aiP.getDrawable(1) != null) {
                    this.aiP.getDrawable(1).setAlpha(0);
                }
                if (this.aiQ != null && this.aiQ.getDrawable(1) != null) {
                    this.aiQ.getDrawable(1).setAlpha(0);
                }
                if (this.aiE != null) {
                    this.aiE.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void c(bw bwVar) {
        if (this.aiD != null && bwVar != null && this.afJ.beE() != null) {
            this.aiD.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.aiD, this.afJ.beE(), 0)) {
                this.aiD.setIsHomePage(bwVar.eef);
                if (this.afJ.edC > 0 && this.afJ.edD == 0) {
                    this.aiD.iu(false);
                } else {
                    this.aiD.a(this.afJ.beE(), 0);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        this.afJ = bwVar;
        e(bwVar);
        f(bwVar);
        k(bwVar);
        l(bwVar);
        h(bwVar);
        j(bwVar);
        c(bwVar);
        m(bwVar);
        n(bwVar);
        i(bwVar);
        g(bwVar);
        d(bwVar);
        setVisibility(0);
        if (isShow(128) && !bwVar.eef && !bwVar.bgw()) {
            this.aiT.post(this.aiX);
        }
    }

    private void d(bw bwVar) {
        if (isShow(4096) && bwVar != null && this.aiO != null) {
            if (bwVar.eeb) {
                this.aiO.setVisibility(0);
            } else {
                this.aiO.setVisibility(8);
            }
        }
    }

    private void e(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            if (bwVar.bcm()) {
                this.aiW |= 4096;
            } else {
                this.aiW &= -4097;
            }
            if ((bwVar.eef && !bwVar.bdo() && !bwVar.bgF() && bwVar.getType() != bw.ebp) || (bwVar.eef && com.baidu.tbadk.a.d.bad() && bwVar.getType() != bw.ebp)) {
                this.aiW &= -129;
            } else {
                this.aiW |= 128;
            }
            setShowFlag(this.aiW);
        }
    }

    private void f(bw bwVar) {
        if (bwVar.beE() == null) {
            this.aiD.setVisibility(8);
            return;
        }
        MetaData beE = bwVar.beE();
        if (!isShow(256)) {
            beE.setPendantData(null);
        }
        this.aiD.setData(bwVar);
    }

    private void g(bw bwVar) {
        if (!isShow(32768)) {
            this.aiE.setVisibility(8);
            if (this.aiE.isAnimating()) {
                this.aiE.cancelAnimation();
            }
            this.aiD.setIsclearmode(false);
        } else if (bwVar != null && bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
            if (bwVar.beE().getAlaUserData().live_status != 1) {
                this.aiE.setVisibility(8);
                this.aiE.cancelAnimation();
                this.aiD.setIsclearmode(false);
                return;
            }
            this.aiD.setIsclearmode(true);
            this.aiW &= -257;
            f(bwVar);
            this.aiE.setSpeed(0.8f);
            this.aiE.setVisibility(0);
            this.aiE.loop(true);
            this.aiE.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.aiE.playAnimation();
                }
            });
        } else {
            this.aiE.setVisibility(8);
            this.aiE.cancelAnimation();
            this.aiD.setIsclearmode(false);
        }
    }

    private void h(bw bwVar) {
        if (this.aiF != null && bwVar != null) {
            if (bwVar.eef || bwVar.bgw()) {
                ViewGroup.LayoutParams layoutParams = this.aiT.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.aiT.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.aiU.getLayoutParams();
                layoutParams2.width = -1;
                this.aiU.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.aiF.getLayoutParams();
                layoutParams3.width = -1;
                this.aiF.setLayoutParams(layoutParams3);
                this.aiF.setEllipsize(TextUtils.TruncateAt.END);
                if (bwVar.beE() != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
                    this.aiF.setText(bwVar.beE().getName_show());
                } else {
                    this.aiF.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.afJ.beb())) {
                this.aiF.setText(this.afJ.beb());
            } else {
                this.aiF.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.a(this.aiF);
            ug();
        }
    }

    protected void i(bw bwVar) {
        if (this.aiM != null) {
            if (bwVar == null || (!isShow(8) && !isShow(512))) {
                this.aiM.setVisibility(8);
            } else if (this.afJ.getType() == bw.ecR) {
                this.aiM.setVisibility(0);
                this.aiM.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.aiM, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bwVar.bcf())) {
                    this.aiM.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiM.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.aiM.setLayoutParams(layoutParams);
                }
                this.aiM.setText(bwVar.bcf());
                this.aiM.setVisibility(0);
            } else if (StringUtils.isNull(this.afJ.bed())) {
                this.aiM.setVisibility(8);
            } else {
                this.aiM.setVisibility(0);
                this.aiM.setText(this.afJ.bed());
            }
        }
    }

    private void j(bw bwVar) {
        if (this.aiH != null) {
            if (!isShow(32)) {
                this.aiH.setVisibility(8);
            } else if (bwVar == null || bwVar.beE() == null || (bwVar.edC > 0 && bwVar.edD == 0)) {
                this.aiH.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.beE().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aiH.setVisibility(0);
                    this.aiH.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.aiH.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void ug() {
        if (this.afJ != null && this.afJ.beE() != null) {
            if (this.afJ.edC > 0 && this.afJ.edD == 0) {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.aiF);
            } else if (!y.isEmpty(this.afJ.beE().getTShowInfoNew()) || this.afJ.bgF()) {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aiF, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.aiF);
            }
        }
    }

    private void k(bw bwVar) {
        if (this.aiI != null && bwVar != null && bwVar.beE() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bwVar.beE().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aiI.setVisibility(0);
                this.aiI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aiI.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.aiG != null && bwVar != null && bwVar.beE() != null && isShow(16)) {
            MetaData beE = bwVar.beE();
            if (this.aiG.getLayoutParams() != null) {
                this.aiG.getLayoutParams().width = -2;
            }
            this.aiG.setOnClickListener(null);
            if (beE.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ap.setBackgroundResource(this.aiG, i);
                ap.setViewTextColor(this.aiG, i2);
                if (bwVar.edQ) {
                    this.aiG.setVisibility(0);
                    this.aiG.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                    this.aiG.setBackgroundDrawable(this.aiP);
                    this.aiG.setVisibility(0);
                    this.aiG.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                    this.aiG.setBackgroundDrawable(this.aiQ);
                    this.aiG.setText(R.string.bawu_member_xbazhu_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(beE.getBawu_type())) {
                    this.aiG.setText(R.string.bawu_content_assist_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(beE.getBawu_type())) {
                    this.aiG.setText(R.string.bawu_manage_assist_tip);
                    this.aiG.setVisibility(0);
                    return;
                } else {
                    this.aiG.setVisibility(8);
                    return;
                }
            }
            this.aiG.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.aiD;
    }

    public View getUserName() {
        return this.aiF;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiR = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.aiS = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.aiD != null) {
            this.aiD.setPageId(bdUniqueId);
        }
    }

    private void m(bw bwVar) {
        if (this.aiJ != null) {
            if (bwVar == null || TextUtils.isEmpty(bwVar.bec())) {
                this.aiJ.setVisibility(8);
                return;
            }
            if (bwVar.beE() != null && bwVar.beE().isBaijiahaoUser()) {
                this.aiJ.setLines(1);
                this.aiJ.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.aiJ.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.aiJ.setEllipsize(null);
            }
            ap.setViewTextColor(this.aiJ, R.color.cp_cont_d);
            this.aiJ.setText(bwVar.bec());
            this.aiJ.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void n(bw bwVar) {
        String address;
        boolean z = true;
        dj("");
        if (bwVar != null && bwVar.getType() == bw.ebp && bwVar.beY() != null && bwVar.beY().openRecomLocation != 0) {
            String beT = bwVar.beT();
            String beU = bwVar.beU();
            boolean z2 = UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo dob = com.baidu.tieba.recapp.d.a.dnW().dob();
                String str = dob.latitude;
                String str2 = dob.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(beT), Double.parseDouble(beU));
                    if (GetDistance <= 50.0d) {
                        address = at.s(GetDistance);
                    } else {
                        address = bwVar.getAddress();
                    }
                }
                address = "";
            } else {
                if (z2) {
                    address = bwVar.getAddress();
                }
                address = "";
            }
            dj(address);
        }
    }

    private void dj(String str) {
        boolean z = !StringUtils.isNull(str);
        this.aiK.setVisibility(z ? 0 : 8);
        this.aiL.setVisibility(z ? 0 : 8);
        if (z) {
            this.aiL.setText(str);
            SvgManager.bjq().a(this.aiK, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.aiL, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uh() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.aiF.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.aiM.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.aiF.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.afJ.beE().getName_show(), 12)) + this.aiF.getPaddingLeft() + this.aiF.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.afJ.beE().getName_show(), 10)) + this.aiF.getPaddingLeft() + this.aiF.getPaddingRight();
            int measuredWidth = this.aiI.getMeasuredWidth();
            int measuredWidth2 = this.aiF.getMeasuredWidth();
            int measuredWidth3 = this.aiM.getMeasuredWidth();
            int measuredWidth4 = this.aiG.getMeasuredWidth();
            int measuredWidth5 = this.aiH.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.aiF.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.aiF.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.aiF.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.aiH.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.aiG.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.aiI.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.aiM.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.afJ != null && this.afJ.beE() != null && this.afJ.beE().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.aiJ.setMaxWidth(i2);
        }
    }

    private void ui() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.aiP = new LayerDrawable(new Drawable[]{b.bjR().oe(0).V(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), b.bjR().oe(0).V(this.tbds6).Aw("#4D000000").bjT()});
        this.aiQ = new LayerDrawable(new Drawable[]{b.bjR().oe(0).V(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), b.bjR().oe(0).V(this.tbds6).Aw("#4D000000").bjT()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.aiN;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

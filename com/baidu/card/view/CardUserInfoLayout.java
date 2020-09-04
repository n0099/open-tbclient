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
    private static final int aiX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bw afL;
    private HeadPendantClickableView aiF;
    private TBLottieAnimationView aiG;
    private TextView aiH;
    private TextView aiI;
    private UserIconBox aiJ;
    private UserIconBox aiK;
    private TextView aiL;
    private ImageView aiM;
    private TextView aiN;
    private TextView aiO;
    protected RelativeLayout aiP;
    private ImageView aiQ;
    private LayerDrawable aiR;
    private LayerDrawable aiS;
    private View.OnClickListener aiT;
    private View.OnClickListener aiU;
    private View aiV;
    private View aiW;
    private int aiY;
    private Runnable aiZ;
    private View.OnClickListener aja;
    private View.OnClickListener ajb;
    private View.OnClickListener ajc;
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
        this.aiY = 34053;
        this.aiZ = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.uh();
            }
        };
        this.aja = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.afL != null && CardUserInfoLayout.this.afL.beE() != null && CardUserInfoLayout.this.afL.beE().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.afL.beE().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.afL.beE().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bju().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajb = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.afL != null && CardUserInfoLayout.this.afL.beE() != null && !StringUtils.isNull(CardUserInfoLayout.this.afL.beE().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.afL.beE().getUserId()) && CardUserInfoLayout.this.afL.beI() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.afL.beE().getUserId(), CardUserInfoLayout.this.afL.beE().getName_show(), CardUserInfoLayout.this.afL.beI(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.afL.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.aiT != null) {
                        CardUserInfoLayout.this.aiT.onClick(view);
                    }
                }
            }
        };
        this.ajc = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.afL != null && CardUserInfoLayout.this.afL.beE() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.afL.beE().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.aiU != null) {
                        CardUserInfoLayout.this.aiT.onClick(view);
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
        this.aiY = i;
        ue();
    }

    private void ue() {
        this.aiK.setVisibility(isShow(1) ? 0 : 8);
        this.aiH.setVisibility(isShow(4) ? 0 : 8);
        this.aiI.setVisibility(isShow(16) ? 0 : 8);
        this.aiO.setVisibility(isShow(8) ? 0 : 8);
        this.aiJ.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiV.getLayoutParams();
        if (isShow(128)) {
            this.aiL.setVisibility(0);
        } else {
            this.aiL.setVisibility(8);
        }
        this.aiV.setLayoutParams(layoutParams);
        this.aiQ.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.aiY & i) > 0;
    }

    private void uf() {
        this.aiF = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.aiF.setHasPendantStyle();
        this.aiF.getHeadView().setIsRound(true);
        this.aiF.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiF.getHeadView().setDefaultResource(17170445);
        this.aiF.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.aiF.getHeadView().setPlaceHolder(1);
        this.aiF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aiT != null) {
                    CardUserInfoLayout.this.aiT.onClick(view);
                }
            }
        });
        this.aiG = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.aiK = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.aiK.setOnClickListener(this.aja);
        this.aiH = (TextView) findViewById(R.id.user_name);
        this.aiH.setOnClickListener(this.ajb);
        this.aiI = (TextView) findViewById(R.id.identity_view);
        this.aiO = (TextView) findViewById(R.id.thread_share_intro);
        this.aiJ = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.aiJ.setOnClickListener(this.ajc);
        this.aiJ.setAutoChangedStyle(false);
        this.aiL = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bix()) {
            this.aiL.setPadding(0, -aiX, 0, 0);
        }
        this.aiM = (ImageView) findViewById(R.id.ala_location_icon);
        this.aiN = (TextView) findViewById(R.id.ala_location);
        this.aiV = findViewById(R.id.user_name_and_reply_time);
        this.aiW = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.aiP = (RelativeLayout) findViewById(R.id.suffix_container);
        this.aiQ = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.aiF.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.aiR != null && this.aiR.getDrawable(1) != null) {
                    this.aiR.getDrawable(1).setAlpha(255);
                }
                if (this.aiS != null && this.aiS.getDrawable(1) != null) {
                    this.aiS.getDrawable(1).setAlpha(255);
                }
                if (this.aiG != null) {
                    this.aiG.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.aiG != null) {
                    this.aiG.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.aiR != null && this.aiR.getDrawable(1) != null) {
                    this.aiR.getDrawable(1).setAlpha(0);
                }
                if (this.aiS != null && this.aiS.getDrawable(1) != null) {
                    this.aiS.getDrawable(1).setAlpha(0);
                }
                if (this.aiG != null) {
                    this.aiG.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void c(bw bwVar) {
        if (this.aiF != null && bwVar != null && this.afL.beE() != null) {
            this.aiF.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.aiF, this.afL.beE(), 0)) {
                this.aiF.setIsHomePage(bwVar.eej);
                if (this.afL.edG > 0 && this.afL.edH == 0) {
                    this.aiF.iv(false);
                } else {
                    this.aiF.a(this.afL.beE(), 0);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        this.afL = bwVar;
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
        if (isShow(128) && !bwVar.eej && !bwVar.bgw()) {
            this.aiV.post(this.aiZ);
        }
    }

    private void d(bw bwVar) {
        if (isShow(4096) && bwVar != null && this.aiQ != null) {
            if (bwVar.eef) {
                this.aiQ.setVisibility(0);
            } else {
                this.aiQ.setVisibility(8);
            }
        }
    }

    private void e(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            if (bwVar.bcm()) {
                this.aiY |= 4096;
            } else {
                this.aiY &= -4097;
            }
            if ((bwVar.eej && !bwVar.bdo() && !bwVar.bgF() && bwVar.getType() != bw.ebt) || (bwVar.eej && com.baidu.tbadk.a.d.bad() && bwVar.getType() != bw.ebt)) {
                this.aiY &= -129;
            } else {
                this.aiY |= 128;
            }
            setShowFlag(this.aiY);
        }
    }

    private void f(bw bwVar) {
        if (bwVar.beE() == null) {
            this.aiF.setVisibility(8);
            return;
        }
        MetaData beE = bwVar.beE();
        if (!isShow(256)) {
            beE.setPendantData(null);
        }
        this.aiF.setData(bwVar);
    }

    private void g(bw bwVar) {
        if (!isShow(32768)) {
            this.aiG.setVisibility(8);
            if (this.aiG.isAnimating()) {
                this.aiG.cancelAnimation();
            }
            this.aiF.setIsclearmode(false);
        } else if (bwVar != null && bwVar.beE() != null && bwVar.beE().getAlaUserData() != null) {
            if (bwVar.beE().getAlaUserData().live_status != 1) {
                this.aiG.setVisibility(8);
                this.aiG.cancelAnimation();
                this.aiF.setIsclearmode(false);
                return;
            }
            this.aiF.setIsclearmode(true);
            this.aiY &= -257;
            f(bwVar);
            this.aiG.setSpeed(0.8f);
            this.aiG.setVisibility(0);
            this.aiG.loop(true);
            this.aiG.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.aiG.playAnimation();
                }
            });
        } else {
            this.aiG.setVisibility(8);
            this.aiG.cancelAnimation();
            this.aiF.setIsclearmode(false);
        }
    }

    private void h(bw bwVar) {
        if (this.aiH != null && bwVar != null) {
            if (bwVar.eej || bwVar.bgw()) {
                ViewGroup.LayoutParams layoutParams = this.aiV.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.aiV.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.aiW.getLayoutParams();
                layoutParams2.width = -1;
                this.aiW.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.aiH.getLayoutParams();
                layoutParams3.width = -1;
                this.aiH.setLayoutParams(layoutParams3);
                this.aiH.setEllipsize(TextUtils.TruncateAt.END);
                if (bwVar.beE() != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
                    this.aiH.setText(bwVar.beE().getName_show());
                } else {
                    this.aiH.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.afL.beb())) {
                this.aiH.setText(this.afL.beb());
            } else {
                this.aiH.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.a(this.aiH);
            ug();
        }
    }

    protected void i(bw bwVar) {
        if (this.aiO != null) {
            if (bwVar == null || (!isShow(8) && !isShow(512))) {
                this.aiO.setVisibility(8);
            } else if (this.afL.getType() == bw.ecV) {
                this.aiO.setVisibility(0);
                this.aiO.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.aiO, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bwVar.bcf())) {
                    this.aiO.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiO.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.aiO.setLayoutParams(layoutParams);
                }
                this.aiO.setText(bwVar.bcf());
                this.aiO.setVisibility(0);
            } else if (StringUtils.isNull(this.afL.bed())) {
                this.aiO.setVisibility(8);
            } else {
                this.aiO.setVisibility(0);
                this.aiO.setText(this.afL.bed());
            }
        }
    }

    private void j(bw bwVar) {
        if (this.aiJ != null) {
            if (!isShow(32)) {
                this.aiJ.setVisibility(8);
            } else if (bwVar == null || bwVar.beE() == null || (bwVar.edG > 0 && bwVar.edH == 0)) {
                this.aiJ.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.beE().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aiJ.setVisibility(0);
                    this.aiJ.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.aiJ.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void ug() {
        if (this.afL != null && this.afL.beE() != null) {
            if (this.afL.edG > 0 && this.afL.edH == 0) {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.aiH);
            } else if (!y.isEmpty(this.afL.beE().getTShowInfoNew()) || this.afL.bgF()) {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aiH, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.aiH);
            }
        }
    }

    private void k(bw bwVar) {
        if (this.aiK != null && bwVar != null && bwVar.beE() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bwVar.beE().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aiK.setVisibility(0);
                this.aiK.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aiK.setVisibility(8);
        }
    }

    private void l(bw bwVar) {
        if (this.aiI != null && bwVar != null && bwVar.beE() != null && isShow(16)) {
            MetaData beE = bwVar.beE();
            if (this.aiI.getLayoutParams() != null) {
                this.aiI.getLayoutParams().width = -2;
            }
            this.aiI.setOnClickListener(null);
            if (beE.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ap.setBackgroundResource(this.aiI, i);
                ap.setViewTextColor(this.aiI, i2);
                if (bwVar.edU) {
                    this.aiI.setVisibility(0);
                    this.aiI.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(beE.getBawu_type())) {
                    this.aiI.setBackgroundDrawable(this.aiR);
                    this.aiI.setVisibility(0);
                    this.aiI.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(beE.getBawu_type())) {
                    this.aiI.setBackgroundDrawable(this.aiS);
                    this.aiI.setText(R.string.bawu_member_xbazhu_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(beE.getBawu_type())) {
                    this.aiI.setText(R.string.bawu_content_assist_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(beE.getBawu_type())) {
                    this.aiI.setText(R.string.bawu_manage_assist_tip);
                    this.aiI.setVisibility(0);
                    return;
                } else {
                    this.aiI.setVisibility(8);
                    return;
                }
            }
            this.aiI.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.aiF;
    }

    public View getUserName() {
        return this.aiH;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aiT = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.aiU = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.aiF != null) {
            this.aiF.setPageId(bdUniqueId);
        }
    }

    private void m(bw bwVar) {
        if (this.aiL != null) {
            if (bwVar == null || TextUtils.isEmpty(bwVar.bec())) {
                this.aiL.setVisibility(8);
                return;
            }
            if (bwVar.beE() != null && bwVar.beE().isBaijiahaoUser()) {
                this.aiL.setLines(1);
                this.aiL.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.aiL.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.aiL.setEllipsize(null);
            }
            ap.setViewTextColor(this.aiL, R.color.cp_cont_d);
            this.aiL.setText(bwVar.bec());
            this.aiL.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void n(bw bwVar) {
        String address;
        boolean z = true;
        dk("");
        if (bwVar != null && bwVar.getType() == bw.ebt && bwVar.beY() != null && bwVar.beY().openRecomLocation != 0) {
            String beT = bwVar.beT();
            String beU = bwVar.beU();
            boolean z2 = UtilHelper.isDecimal(beT) && UtilHelper.isDecimal(beU);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo doe = com.baidu.tieba.recapp.d.a.dnZ().doe();
                String str = doe.latitude;
                String str2 = doe.longitude;
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
            dk(address);
        }
    }

    private void dk(String str) {
        boolean z = !StringUtils.isNull(str);
        this.aiM.setVisibility(z ? 0 : 8);
        this.aiN.setVisibility(z ? 0 : 8);
        if (z) {
            this.aiN.setText(str);
            SvgManager.bjq().a(this.aiM, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.aiN, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uh() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.aiH.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.aiO.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.aiH.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.afL.beE().getName_show(), 12)) + this.aiH.getPaddingLeft() + this.aiH.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.afL.beE().getName_show(), 10)) + this.aiH.getPaddingLeft() + this.aiH.getPaddingRight();
            int measuredWidth = this.aiK.getMeasuredWidth();
            int measuredWidth2 = this.aiH.getMeasuredWidth();
            int measuredWidth3 = this.aiO.getMeasuredWidth();
            int measuredWidth4 = this.aiI.getMeasuredWidth();
            int measuredWidth5 = this.aiJ.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.aiH.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.aiH.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.aiH.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.aiJ.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.aiI.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.aiK.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.aiO.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.afL != null && this.afL.beE() != null && this.afL.beE().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.aiL.setMaxWidth(i2);
        }
    }

    private void ui() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.aiR = new LayerDrawable(new Drawable[]{b.bjR().oe(0).V(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bjT(), b.bjR().oe(0).V(this.tbds6).Ax("#4D000000").bjT()});
        this.aiS = new LayerDrawable(new Drawable[]{b.bjR().oe(0).V(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bjT(), b.bjR().oe(0).V(this.tbds6).Ax("#4D000000").bjT()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.aiP;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

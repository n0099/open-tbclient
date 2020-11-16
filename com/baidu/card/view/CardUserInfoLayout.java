package com.baidu.card.view;

import android.content.Context;
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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes20.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int ajN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bx agB;
    private TextView ajA;
    private UserIconBox ajB;
    private UserIconBox ajC;
    private TextView ajD;
    private ImageView ajE;
    private TextView ajF;
    private TextView ajG;
    protected RelativeLayout ajH;
    private ImageView ajI;
    private View.OnClickListener ajJ;
    private View.OnClickListener ajK;
    private View ajL;
    private View ajM;
    private int ajO;
    private Runnable ajP;
    private View.OnClickListener ajQ;
    private View.OnClickListener ajR;
    private View.OnClickListener ajS;
    private HeadPendantClickableView ajx;
    private TBLottieAnimationView ajy;
    private TextView ajz;
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
        this.ajO = 34053;
        this.ajP = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.un();
            }
        };
        this.ajQ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.agB != null && CardUserInfoLayout.this.agB.blC() != null && CardUserInfoLayout.this.agB.blC().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.agB.blC().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.agB.blC().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bqF().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajR = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agB != null && CardUserInfoLayout.this.agB.blC() != null && !StringUtils.isNull(CardUserInfoLayout.this.agB.blC().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.agB.blC().getUserId()) && CardUserInfoLayout.this.agB.blG() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.agB.blC().getUserId(), CardUserInfoLayout.this.agB.blC().getName_show(), CardUserInfoLayout.this.agB.blG(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.agB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ajJ != null) {
                        CardUserInfoLayout.this.ajJ.onClick(view);
                    }
                }
            }
        };
        this.ajS = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agB != null && CardUserInfoLayout.this.agB.blC() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.agB.blC().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ajK != null) {
                        CardUserInfoLayout.this.ajJ.onClick(view);
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
        ul();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.ajO = i;
        uk();
    }

    private void uk() {
        this.ajC.setVisibility(isShow(1) ? 0 : 8);
        this.ajz.setVisibility(isShow(4) ? 0 : 8);
        this.ajA.setVisibility(isShow(16) ? 0 : 8);
        this.ajG.setVisibility(isShow(8) ? 0 : 8);
        this.ajB.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajL.getLayoutParams();
        if (isShow(128)) {
            this.ajD.setVisibility(0);
        } else {
            this.ajD.setVisibility(8);
        }
        this.ajL.setLayoutParams(layoutParams);
        this.ajI.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ajO & i) > 0;
    }

    private void ul() {
        this.ajx = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ajx.setHasPendantStyle();
        this.ajx.getHeadView().setIsRound(true);
        this.ajx.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajx.getHeadView().setDefaultResource(17170445);
        this.ajx.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ajx.getHeadView().setPlaceHolder(1);
        this.ajx.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ajJ != null) {
                    CardUserInfoLayout.this.ajJ.onClick(view);
                }
            }
        });
        this.ajy = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.ajC = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ajC.setOnClickListener(this.ajQ);
        this.ajz = (TextView) findViewById(R.id.user_name);
        this.ajz.setOnClickListener(this.ajR);
        this.ajA = (TextView) findViewById(R.id.identity_view);
        this.ajG = (TextView) findViewById(R.id.thread_share_intro);
        this.ajB = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.ajB.setOnClickListener(this.ajS);
        this.ajB.setAutoChangedStyle(false);
        this.ajD = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bpH()) {
            this.ajD.setPadding(0, -ajN, 0, 0);
        }
        this.ajE = (ImageView) findViewById(R.id.ala_location_icon);
        this.ajF = (TextView) findViewById(R.id.ala_location);
        this.ajL = findViewById(R.id.user_name_and_reply_time);
        this.ajM = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ajH = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ajI = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ajx.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ajy != null) {
                    this.ajy.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.ajy != null) {
                    this.ajy.setAnimation("live/card_live_bg_black.json");
                }
            } else if (this.ajy != null) {
                this.ajy.setAnimation("live/card_live_bg.json");
            }
        }
    }

    private void d(bx bxVar) {
        if (this.ajx != null && bxVar != null && this.agB.blC() != null) {
            this.ajx.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ajx, this.agB.blC(), 0)) {
                this.ajx.setIsHomePage(bxVar.eFg);
                if (this.agB.eED > 0 && this.agB.eEE == 0) {
                    this.ajx.jn(false);
                } else {
                    this.ajx.a(this.agB.blC(), 0);
                }
            }
        }
    }

    public void setData(bx bxVar) {
        if (bxVar == null) {
            setVisibility(8);
        } else if (c(bxVar)) {
            setVisibility(4);
        } else {
            this.agB = bxVar;
            f(bxVar);
            g(bxVar);
            l(bxVar);
            m(bxVar);
            i(bxVar);
            k(bxVar);
            d(bxVar);
            n(bxVar);
            o(bxVar);
            j(bxVar);
            h(bxVar);
            e(bxVar);
            setVisibility(0);
            if (isShow(128) && !bxVar.eFg && !bxVar.bnw()) {
                this.ajL.post(this.ajP);
            }
        }
    }

    private void e(bx bxVar) {
        if (isShow(4096) && bxVar != null && this.ajI != null) {
            if (bxVar.eFc) {
                this.ajI.setVisibility(0);
            } else {
                this.ajI.setVisibility(8);
            }
        }
    }

    private void f(bx bxVar) {
        if (bxVar != null && bxVar.blC() != null) {
            if (bxVar.bjk()) {
                this.ajO |= 4096;
            } else {
                this.ajO &= -4097;
            }
            if (!(bxVar instanceof AdvertAppInfo) && ((bxVar.eFg && !bxVar.bkm() && !bxVar.bnF() && bxVar.getType() != bx.eCp && bxVar.getType() != bx.eCs) || (bxVar.eFg && com.baidu.tbadk.a.d.bhm() && bxVar.getType() != bx.eCp && bxVar.getType() != bx.eCs))) {
                this.ajO &= -129;
            } else {
                this.ajO |= 128;
            }
            setShowFlag(this.ajO);
        }
    }

    private void g(bx bxVar) {
        if (bxVar.blC() == null) {
            this.ajx.setVisibility(8);
            return;
        }
        MetaData blC = bxVar.blC();
        if (!isShow(256)) {
            blC.setPendantData(null);
        }
        this.ajx.setData(bxVar);
    }

    private void h(bx bxVar) {
        if (!isShow(32768)) {
            this.ajy.setVisibility(8);
            if (this.ajy.isAnimating()) {
                this.ajy.cancelAnimation();
            }
            this.ajx.setIsclearmode(false);
            return;
        }
        boolean z = (bxVar == null || bxVar.blC() == null || bxVar.blC().getAlaUserData() == null || bxVar.blC().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (bxVar == null || bxVar.blW() == null || bxVar.blW().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.ajx.setIsclearmode(true);
            this.ajO &= -257;
            g(bxVar);
            this.ajy.setSpeed(0.8f);
            this.ajy.setVisibility(0);
            this.ajy.loop(true);
            this.ajy.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ajy.playAnimation();
                }
            });
            return;
        }
        this.ajy.setVisibility(8);
        this.ajy.cancelAnimation();
        this.ajx.setIsclearmode(false);
    }

    private void i(bx bxVar) {
        if (this.ajz != null && bxVar != null) {
            if (bxVar.eFg || bxVar.bnw()) {
                ViewGroup.LayoutParams layoutParams = this.ajL.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ajL.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ajM.getLayoutParams();
                layoutParams2.width = -1;
                this.ajM.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ajz.getLayoutParams();
                layoutParams3.width = -1;
                this.ajz.setLayoutParams(layoutParams3);
                this.ajz.setEllipsize(TextUtils.TruncateAt.END);
                if (bxVar.blC() != null && !StringUtils.isNull(bxVar.blC().getName_show())) {
                    this.ajz.setText(bxVar.blC().getName_show());
                } else {
                    this.ajz.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.agB.bkZ())) {
                this.ajz.setText(this.agB.bkZ());
            } else {
                this.ajz.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.e(this.ajz);
            um();
        }
    }

    protected void j(bx bxVar) {
        if (this.ajG != null) {
            if (bxVar == null || (!isShow(8) && !isShow(512))) {
                this.ajG.setVisibility(8);
            } else if (this.agB.getType() == bx.eDS) {
                this.ajG.setVisibility(0);
                this.ajG.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.ajG, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bxVar.bje())) {
                    this.ajG.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajG.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ajG.setLayoutParams(layoutParams);
                }
                this.ajG.setText(bxVar.bje());
                this.ajG.setVisibility(0);
            } else if (StringUtils.isNull(this.agB.blb())) {
                this.ajG.setVisibility(8);
            } else {
                this.ajG.setVisibility(0);
                this.ajG.setText(this.agB.blb());
            }
        }
    }

    private void k(bx bxVar) {
        if (this.ajB != null) {
            if (!isShow(32)) {
                this.ajB.setVisibility(8);
            } else if (bxVar == null || bxVar.blC() == null || (bxVar.eED > 0 && bxVar.eEE == 0)) {
                this.ajB.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bxVar.blC().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajB.setVisibility(0);
                    this.ajB.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.ajB.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void um() {
        if (this.agB != null && this.agB.blC() != null) {
            if (this.agB.eED > 0 && this.agB.eEE == 0) {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0106);
                com.baidu.tbadk.a.b.a.f(this.ajz);
            } else if (!y.isEmpty(this.agB.blC().getTShowInfoNew()) || this.agB.bnF()) {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.ajz, R.color.CAM_X0106);
                com.baidu.tbadk.a.b.a.f(this.ajz);
            }
        }
    }

    private void l(bx bxVar) {
        if (this.ajC != null && bxVar != null && bxVar.blC() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bxVar.blC().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajC.setVisibility(0);
                this.ajC.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajC.setVisibility(8);
        }
    }

    private void m(bx bxVar) {
        if (this.ajA != null && bxVar != null && bxVar.blC() != null && isShow(16)) {
            MetaData blC = bxVar.blC();
            if (this.ajA.getLayoutParams() != null) {
                this.ajA.getLayoutParams().width = -2;
            }
            this.ajA.setOnClickListener(null);
            if (blC.getIs_bawu() == 1) {
                c.bj(this.ajA).oT(R.color.CAM_X0101).pe(R.string.A_X04).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (bxVar.eER) {
                    this.ajA.setVisibility(0);
                    this.ajA.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                    this.ajA.setVisibility(0);
                    this.ajA.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_content_assist_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(blC.getBawu_type())) {
                    this.ajA.setText(R.string.bawu_manage_assist_tip);
                    this.ajA.setVisibility(0);
                    return;
                } else {
                    this.ajA.setVisibility(8);
                    return;
                }
            }
            this.ajA.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ajx;
    }

    public View getUserName() {
        return this.ajz;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajJ = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ajK = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajx != null) {
            this.ajx.setPageId(bdUniqueId);
        }
    }

    private void n(bx bxVar) {
        if (this.ajD != null) {
            if (bxVar == null || TextUtils.isEmpty(bxVar.bla())) {
                this.ajD.setVisibility(8);
                return;
            }
            if (bxVar.blC() != null && bxVar.blC().isBaijiahaoUser()) {
                this.ajD.setLines(1);
                this.ajD.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ajD.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ajD.setEllipsize(null);
            }
            ap.setViewTextColor(this.ajD, R.color.CAM_X0109);
            this.ajD.setText(bxVar.bla());
            this.ajD.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bx bxVar) {
        String address;
        boolean z = true;
        m20do("");
        if (bxVar != null) {
            if ((bxVar.getType() == bx.eCp || bxVar.getType() == bx.eCs) && bxVar.blW() != null && bxVar.blW().openRecomLocation != 0) {
                String blR = bxVar.blR();
                String blS = bxVar.blS();
                boolean z2 = UtilHelper.isDecimal(blR) && UtilHelper.isDecimal(blS);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dAL = com.baidu.tieba.recapp.d.a.dAG().dAL();
                    String str = dAL.latitude;
                    String str2 = dAL.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(b.toDouble(str, 0.0d), b.toDouble(str2, 0.0d), b.toDouble(blR, 0.0d), b.toDouble(blS, 0.0d));
                        if (GetDistance <= 50.0d) {
                            address = au.v(GetDistance);
                        } else {
                            address = bxVar.getAddress();
                        }
                    }
                    address = "";
                } else {
                    if (z2) {
                        address = bxVar.getAddress();
                    }
                    address = "";
                }
                m20do(address);
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m20do(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ajE.setVisibility(z ? 0 : 8);
        this.ajF.setVisibility(z ? 0 : 8);
        if (z) {
            this.ajF.setText(str);
            SvgManager.bqB().a(this.ajE, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.ajF, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void un() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ajz.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.ajG.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ajz.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.agB.blC().getName_show(), 12)) + this.ajz.getPaddingLeft() + this.ajz.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.agB.blC().getName_show(), 10)) + this.ajz.getPaddingLeft() + this.ajz.getPaddingRight();
            int measuredWidth = this.ajC.getMeasuredWidth();
            int measuredWidth2 = this.ajz.getMeasuredWidth();
            int measuredWidth3 = this.ajG.getMeasuredWidth();
            int measuredWidth4 = this.ajA.getMeasuredWidth();
            int measuredWidth5 = this.ajB.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ajz.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ajz.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ajz.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.ajB.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ajA.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ajC.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.ajG.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.agB != null && this.agB.blC() != null && this.agB.blC().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.agB.blC().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.ajD.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.ajH;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bx bxVar) {
        return (bxVar == null || bxVar.blC() == null || !bxVar.eFh || !com.baidu.tbadk.a.d.bhv() || bxVar.blC().hadConcerned() || az.x(bxVar)) ? false : true;
    }
}

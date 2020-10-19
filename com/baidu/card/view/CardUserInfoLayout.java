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
import com.baidu.card.q;
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
import com.baidu.tbadk.core.util.ay;
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
/* loaded from: classes21.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int ajJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bw agw;
    private TextView ajA;
    protected RelativeLayout ajB;
    private ImageView ajC;
    private LayerDrawable ajD;
    private LayerDrawable ajE;
    private View.OnClickListener ajF;
    private View.OnClickListener ajG;
    private View ajH;
    private View ajI;
    private int ajK;
    private Runnable ajL;
    private View.OnClickListener ajM;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    private HeadPendantClickableView ajr;
    private TBLottieAnimationView ajs;
    private TextView ajt;
    private TextView aju;
    private UserIconBox ajv;
    private UserIconBox ajw;
    private TextView ajx;
    private ImageView ajy;
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
        this.ajK = 34053;
        this.ajL = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.un();
            }
        };
        this.ajM = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.agw != null && CardUserInfoLayout.this.agw.bih() != null && CardUserInfoLayout.this.agw.bih().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.agw.bih().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.agw.bih().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bmY().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agw != null && CardUserInfoLayout.this.agw.bih() != null && !StringUtils.isNull(CardUserInfoLayout.this.agw.bih().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.agw.bih().getUserId()) && CardUserInfoLayout.this.agw.bil() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.agw.bih().getUserId(), CardUserInfoLayout.this.agw.bih().getName_show(), CardUserInfoLayout.this.agw.bil(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.agw.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ajF != null) {
                        CardUserInfoLayout.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agw != null && CardUserInfoLayout.this.agw.bih() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.agw.bih().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ajG != null) {
                        CardUserInfoLayout.this.ajF.onClick(view);
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
        uo();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.ajK = i;
        uk();
    }

    private void uk() {
        this.ajw.setVisibility(isShow(1) ? 0 : 8);
        this.ajt.setVisibility(isShow(4) ? 0 : 8);
        this.aju.setVisibility(isShow(16) ? 0 : 8);
        this.ajA.setVisibility(isShow(8) ? 0 : 8);
        this.ajv.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajH.getLayoutParams();
        if (isShow(128)) {
            this.ajx.setVisibility(0);
        } else {
            this.ajx.setVisibility(8);
        }
        this.ajH.setLayoutParams(layoutParams);
        this.ajC.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ajK & i) > 0;
    }

    private void ul() {
        this.ajr = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ajr.setHasPendantStyle();
        this.ajr.getHeadView().setIsRound(true);
        this.ajr.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajr.getHeadView().setDefaultResource(17170445);
        this.ajr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ajr.getHeadView().setPlaceHolder(1);
        this.ajr.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ajF != null) {
                    CardUserInfoLayout.this.ajF.onClick(view);
                }
            }
        });
        this.ajs = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.ajw = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ajw.setOnClickListener(this.ajM);
        this.ajt = (TextView) findViewById(R.id.user_name);
        this.ajt.setOnClickListener(this.ajN);
        this.aju = (TextView) findViewById(R.id.identity_view);
        this.ajA = (TextView) findViewById(R.id.thread_share_intro);
        this.ajv = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.ajv.setOnClickListener(this.ajO);
        this.ajv.setAutoChangedStyle(false);
        this.ajx = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bmb()) {
            this.ajx.setPadding(0, -ajJ, 0, 0);
        }
        this.ajy = (ImageView) findViewById(R.id.ala_location_icon);
        this.ajz = (TextView) findViewById(R.id.ala_location);
        this.ajH = findViewById(R.id.user_name_and_reply_time);
        this.ajI = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ajB = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ajC = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ajr.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ajD != null && this.ajD.getDrawable(1) != null) {
                    this.ajD.getDrawable(1).setAlpha(255);
                }
                if (this.ajE != null && this.ajE.getDrawable(1) != null) {
                    this.ajE.getDrawable(1).setAlpha(255);
                }
                if (this.ajs != null) {
                    this.ajs.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.ajs != null) {
                    this.ajs.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.ajD != null && this.ajD.getDrawable(1) != null) {
                    this.ajD.getDrawable(1).setAlpha(0);
                }
                if (this.ajE != null && this.ajE.getDrawable(1) != null) {
                    this.ajE.getDrawable(1).setAlpha(0);
                }
                if (this.ajs != null) {
                    this.ajs.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void d(bw bwVar) {
        if (this.ajr != null && bwVar != null && this.agw.bih() != null) {
            this.ajr.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ajr, this.agw.bih(), 0)) {
                this.ajr.setIsHomePage(bwVar.esz);
                if (this.agw.erW > 0 && this.agw.erX == 0) {
                    this.ajr.iQ(false);
                } else {
                    this.ajr.a(this.agw.bih(), 0);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
        } else if (c(bwVar)) {
            setVisibility(4);
        } else {
            this.agw = bwVar;
            f(bwVar);
            g(bwVar);
            l(bwVar);
            m(bwVar);
            i(bwVar);
            k(bwVar);
            d(bwVar);
            n(bwVar);
            o(bwVar);
            j(bwVar);
            h(bwVar);
            e(bwVar);
            setVisibility(0);
            if (isShow(128) && !bwVar.esz && !bwVar.bjZ()) {
                this.ajH.post(this.ajL);
            }
        }
    }

    private void e(bw bwVar) {
        if (isShow(4096) && bwVar != null && this.ajC != null) {
            if (bwVar.esv) {
                this.ajC.setVisibility(0);
            } else {
                this.ajC.setVisibility(8);
            }
        }
    }

    private void f(bw bwVar) {
        if (bwVar != null && bwVar.bih() != null) {
            if (bwVar.bfP()) {
                this.ajK |= 4096;
            } else {
                this.ajK &= -4097;
            }
            if ((bwVar.esz && !bwVar.bgR() && !bwVar.bki() && bwVar.getType() != bw.epI) || (bwVar.esz && com.baidu.tbadk.a.d.bdB() && bwVar.getType() != bw.epI)) {
                this.ajK &= -129;
            } else {
                this.ajK |= 128;
            }
            setShowFlag(this.ajK);
        }
    }

    private void g(bw bwVar) {
        if (bwVar.bih() == null) {
            this.ajr.setVisibility(8);
            return;
        }
        MetaData bih = bwVar.bih();
        if (!isShow(256)) {
            bih.setPendantData(null);
        }
        this.ajr.setData(bwVar);
    }

    private void h(bw bwVar) {
        if (!isShow(32768)) {
            this.ajs.setVisibility(8);
            if (this.ajs.isAnimating()) {
                this.ajs.cancelAnimation();
            }
            this.ajr.setIsclearmode(false);
        } else if (bwVar != null && bwVar.bih() != null && bwVar.bih().getAlaUserData() != null) {
            if (bwVar.bih().getAlaUserData().live_status != 1) {
                this.ajs.setVisibility(8);
                this.ajs.cancelAnimation();
                this.ajr.setIsclearmode(false);
                return;
            }
            this.ajr.setIsclearmode(true);
            this.ajK &= -257;
            g(bwVar);
            this.ajs.setSpeed(0.8f);
            this.ajs.setVisibility(0);
            this.ajs.loop(true);
            this.ajs.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ajs.playAnimation();
                }
            });
        } else {
            this.ajs.setVisibility(8);
            this.ajs.cancelAnimation();
            this.ajr.setIsclearmode(false);
        }
    }

    private void i(bw bwVar) {
        if (this.ajt != null && bwVar != null) {
            if (bwVar.esz || bwVar.bjZ()) {
                ViewGroup.LayoutParams layoutParams = this.ajH.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ajH.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ajI.getLayoutParams();
                layoutParams2.width = -1;
                this.ajI.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ajt.getLayoutParams();
                layoutParams3.width = -1;
                this.ajt.setLayoutParams(layoutParams3);
                this.ajt.setEllipsize(TextUtils.TruncateAt.END);
                if (bwVar.bih() != null && !StringUtils.isNull(bwVar.bih().getName_show())) {
                    this.ajt.setText(bwVar.bih().getName_show());
                } else {
                    this.ajt.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.agw.bhE())) {
                this.ajt.setText(this.agw.bhE());
            } else {
                this.ajt.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.a(this.ajt);
            um();
        }
    }

    protected void j(bw bwVar) {
        if (this.ajA != null) {
            if (bwVar == null || (!isShow(8) && !isShow(512))) {
                this.ajA.setVisibility(8);
            } else if (this.agw.getType() == bw.erk) {
                this.ajA.setVisibility(0);
                this.ajA.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.ajA, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bwVar.bfH())) {
                    this.ajA.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajA.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ajA.setLayoutParams(layoutParams);
                }
                this.ajA.setText(bwVar.bfH());
                this.ajA.setVisibility(0);
            } else if (StringUtils.isNull(this.agw.bhG())) {
                this.ajA.setVisibility(8);
            } else {
                this.ajA.setVisibility(0);
                this.ajA.setText(this.agw.bhG());
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajv != null) {
            if (!isShow(32)) {
                this.ajv.setVisibility(8);
            } else if (bwVar == null || bwVar.bih() == null || (bwVar.erW > 0 && bwVar.erX == 0)) {
                this.ajv.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bih().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajv.setVisibility(0);
                    this.ajv.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.ajv.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void um() {
        if (this.agw != null && this.agw.bih() != null) {
            if (this.agw.erW > 0 && this.agw.erX == 0) {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ajt);
            } else if (!y.isEmpty(this.agw.bih().getTShowInfoNew()) || this.agw.bki()) {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.ajt, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ajt);
            }
        }
    }

    private void l(bw bwVar) {
        if (this.ajw != null && bwVar != null && bwVar.bih() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bwVar.bih().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajw.setVisibility(0);
                this.ajw.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajw.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.aju != null && bwVar != null && bwVar.bih() != null && isShow(16)) {
            MetaData bih = bwVar.bih();
            if (this.aju.getLayoutParams() != null) {
                this.aju.getLayoutParams().width = -2;
            }
            this.aju.setOnClickListener(null);
            if (bih.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ap.setBackgroundResource(this.aju, i);
                ap.setViewTextColor(this.aju, i2);
                if (bwVar.esk) {
                    this.aju.setVisibility(0);
                    this.aju.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bih.getBawu_type())) {
                    this.aju.setBackgroundDrawable(this.ajD);
                    this.aju.setVisibility(0);
                    this.aju.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bih.getBawu_type())) {
                    this.aju.setBackgroundDrawable(this.ajE);
                    this.aju.setText(R.string.bawu_member_xbazhu_tip);
                    this.aju.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bih.getBawu_type())) {
                    this.aju.setText(R.string.bawu_content_assist_tip);
                    this.aju.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bih.getBawu_type())) {
                    this.aju.setText(R.string.bawu_manage_assist_tip);
                    this.aju.setVisibility(0);
                    return;
                } else {
                    this.aju.setVisibility(8);
                    return;
                }
            }
            this.aju.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ajr;
    }

    public View getUserName() {
        return this.ajt;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajF = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajr != null) {
            this.ajr.setPageId(bdUniqueId);
        }
    }

    private void n(bw bwVar) {
        if (this.ajx != null) {
            if (bwVar == null || TextUtils.isEmpty(bwVar.bhF())) {
                this.ajx.setVisibility(8);
                return;
            }
            if (bwVar.bih() != null && bwVar.bih().isBaijiahaoUser()) {
                this.ajx.setLines(1);
                this.ajx.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ajx.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ajx.setEllipsize(null);
            }
            ap.setViewTextColor(this.ajx, R.color.cp_cont_d);
            this.ajx.setText(bwVar.bhF());
            this.ajx.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bw bwVar) {
        String address;
        boolean z = true;
        dm("");
        if (bwVar != null && bwVar.getType() == bw.epI && bwVar.biB() != null && bwVar.biB().openRecomLocation != 0) {
            String biw = bwVar.biw();
            String bix = bwVar.bix();
            boolean z2 = UtilHelper.isDecimal(biw) && UtilHelper.isDecimal(bix);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo dvy = com.baidu.tieba.recapp.d.a.dvt().dvy();
                String str = dvy.latitude;
                String str2 = dvy.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(biw), Double.parseDouble(bix));
                    if (GetDistance <= 50.0d) {
                        address = at.v(GetDistance);
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
            dm(address);
        }
    }

    private void dm(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ajy.setVisibility(z ? 0 : 8);
        this.ajz.setVisibility(z ? 0 : 8);
        if (z) {
            this.ajz.setText(str);
            SvgManager.bmU().a(this.ajy, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.ajz, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void un() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ajt.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.ajA.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ajt.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.agw.bih().getName_show(), 12)) + this.ajt.getPaddingLeft() + this.ajt.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.agw.bih().getName_show(), 10)) + this.ajt.getPaddingLeft() + this.ajt.getPaddingRight();
            int measuredWidth = this.ajw.getMeasuredWidth();
            int measuredWidth2 = this.ajt.getMeasuredWidth();
            int measuredWidth3 = this.ajA.getMeasuredWidth();
            int measuredWidth4 = this.aju.getMeasuredWidth();
            int measuredWidth5 = this.ajv.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ajt.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ajt.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ajt.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.ajv.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.aju.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ajw.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.ajA.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.agw != null && this.agw.bih() != null && this.agw.bih().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.agw.bih().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.ajx.setMaxWidth(i2);
        }
    }

    private void uo() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.ajD = new LayerDrawable(new Drawable[]{b.bnw().oO(0).X(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bny(), b.bnw().oO(0).X(this.tbds6).BF("#4D000000").bny()});
        this.ajE = new LayerDrawable(new Drawable[]{b.bnw().oO(0).X(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bny(), b.bnw().oO(0).X(this.tbds6).BF("#4D000000").bny()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.ajB;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bih() == null || !bwVar.esA || !com.baidu.tbadk.a.d.bdK() || bwVar.bih().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}

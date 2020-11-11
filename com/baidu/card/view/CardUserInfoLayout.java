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
    private static final int ajK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bw agx;
    private TextView ajA;
    private TextView ajB;
    protected RelativeLayout ajC;
    private ImageView ajD;
    private LayerDrawable ajE;
    private LayerDrawable ajF;
    private View.OnClickListener ajG;
    private View.OnClickListener ajH;
    private View ajI;
    private View ajJ;
    private int ajL;
    private Runnable ajM;
    private View.OnClickListener ajN;
    private View.OnClickListener ajO;
    private View.OnClickListener ajP;
    private HeadPendantClickableView ajs;
    private TBLottieAnimationView ajt;
    private TextView aju;
    private TextView ajv;
    private UserIconBox ajw;
    private UserIconBox ajx;
    private TextView ajy;
    private ImageView ajz;
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
        this.ajL = 34053;
        this.ajM = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.un();
            }
        };
        this.ajN = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.agx != null && CardUserInfoLayout.this.agx.bmA() != null && CardUserInfoLayout.this.agx.bmA().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.agx.bmA().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.agx.bmA().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.brr().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajO = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agx != null && CardUserInfoLayout.this.agx.bmA() != null && !StringUtils.isNull(CardUserInfoLayout.this.agx.bmA().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.agx.bmA().getUserId()) && CardUserInfoLayout.this.agx.bmE() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.agx.bmA().getUserId(), CardUserInfoLayout.this.agx.bmA().getName_show(), CardUserInfoLayout.this.agx.bmE(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.agx.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ajG != null) {
                        CardUserInfoLayout.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.ajP = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agx != null && CardUserInfoLayout.this.agx.bmA() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.agx.bmA().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ajH != null) {
                        CardUserInfoLayout.this.ajG.onClick(view);
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
        this.ajL = i;
        uk();
    }

    private void uk() {
        this.ajx.setVisibility(isShow(1) ? 0 : 8);
        this.aju.setVisibility(isShow(4) ? 0 : 8);
        this.ajv.setVisibility(isShow(16) ? 0 : 8);
        this.ajB.setVisibility(isShow(8) ? 0 : 8);
        this.ajw.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajI.getLayoutParams();
        if (isShow(128)) {
            this.ajy.setVisibility(0);
        } else {
            this.ajy.setVisibility(8);
        }
        this.ajI.setLayoutParams(layoutParams);
        this.ajD.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ajL & i) > 0;
    }

    private void ul() {
        this.ajs = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ajs.setHasPendantStyle();
        this.ajs.getHeadView().setIsRound(true);
        this.ajs.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajs.getHeadView().setDefaultResource(17170445);
        this.ajs.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ajs.getHeadView().setPlaceHolder(1);
        this.ajs.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ajG != null) {
                    CardUserInfoLayout.this.ajG.onClick(view);
                }
            }
        });
        this.ajt = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.ajx = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ajx.setOnClickListener(this.ajN);
        this.aju = (TextView) findViewById(R.id.user_name);
        this.aju.setOnClickListener(this.ajO);
        this.ajv = (TextView) findViewById(R.id.identity_view);
        this.ajB = (TextView) findViewById(R.id.thread_share_intro);
        this.ajw = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.ajw.setOnClickListener(this.ajP);
        this.ajw.setAutoChangedStyle(false);
        this.ajy = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bqu()) {
            this.ajy.setPadding(0, -ajK, 0, 0);
        }
        this.ajz = (ImageView) findViewById(R.id.ala_location_icon);
        this.ajA = (TextView) findViewById(R.id.ala_location);
        this.ajI = findViewById(R.id.user_name_and_reply_time);
        this.ajJ = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ajC = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ajD = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ajs.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ajE != null && this.ajE.getDrawable(1) != null) {
                    this.ajE.getDrawable(1).setAlpha(255);
                }
                if (this.ajF != null && this.ajF.getDrawable(1) != null) {
                    this.ajF.getDrawable(1).setAlpha(255);
                }
                if (this.ajt != null) {
                    this.ajt.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.ajt != null) {
                    this.ajt.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.ajE != null && this.ajE.getDrawable(1) != null) {
                    this.ajE.getDrawable(1).setAlpha(0);
                }
                if (this.ajF != null && this.ajF.getDrawable(1) != null) {
                    this.ajF.getDrawable(1).setAlpha(0);
                }
                if (this.ajt != null) {
                    this.ajt.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void d(bw bwVar) {
        if (this.ajs != null && bwVar != null && this.agx.bmA() != null) {
            this.ajs.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ajs, this.agx.bmA(), 0)) {
                this.ajs.setIsHomePage(bwVar.eGO);
                if (this.agx.eGl > 0 && this.agx.eGm == 0) {
                    this.ajs.jm(false);
                } else {
                    this.ajs.a(this.agx.bmA(), 0);
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
            this.agx = bwVar;
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
            if (isShow(128) && !bwVar.eGO && !bwVar.bos()) {
                this.ajI.post(this.ajM);
            }
        }
    }

    private void e(bw bwVar) {
        if (isShow(4096) && bwVar != null && this.ajD != null) {
            if (bwVar.eGK) {
                this.ajD.setVisibility(0);
            } else {
                this.ajD.setVisibility(8);
            }
        }
    }

    private void f(bw bwVar) {
        if (bwVar != null && bwVar.bmA() != null) {
            if (bwVar.bki()) {
                this.ajL |= 4096;
            } else {
                this.ajL &= -4097;
            }
            if ((bwVar.eGO && !bwVar.blk() && !bwVar.boB() && bwVar.getType() != bw.eDX && bwVar.getType() != bw.eEa) || (bwVar.eGO && com.baidu.tbadk.a.d.bhU() && bwVar.getType() != bw.eDX && bwVar.getType() != bw.eEa)) {
                this.ajL &= -129;
            } else {
                this.ajL |= 128;
            }
            setShowFlag(this.ajL);
        }
    }

    private void g(bw bwVar) {
        if (bwVar.bmA() == null) {
            this.ajs.setVisibility(8);
            return;
        }
        MetaData bmA = bwVar.bmA();
        if (!isShow(256)) {
            bmA.setPendantData(null);
        }
        this.ajs.setData(bwVar);
    }

    private void h(bw bwVar) {
        if (!isShow(32768)) {
            this.ajt.setVisibility(8);
            if (this.ajt.isAnimating()) {
                this.ajt.cancelAnimation();
            }
            this.ajs.setIsclearmode(false);
            return;
        }
        boolean z = (bwVar == null || bwVar.bmA() == null || bwVar.bmA().getAlaUserData() == null || bwVar.bmA().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (bwVar == null || bwVar.bmU() == null || bwVar.bmU().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.ajs.setIsclearmode(true);
            this.ajL &= -257;
            g(bwVar);
            this.ajt.setSpeed(0.8f);
            this.ajt.setVisibility(0);
            this.ajt.loop(true);
            this.ajt.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ajt.playAnimation();
                }
            });
            return;
        }
        this.ajt.setVisibility(8);
        this.ajt.cancelAnimation();
        this.ajs.setIsclearmode(false);
    }

    private void i(bw bwVar) {
        if (this.aju != null && bwVar != null) {
            if (bwVar.eGO || bwVar.bos()) {
                ViewGroup.LayoutParams layoutParams = this.ajI.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ajI.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ajJ.getLayoutParams();
                layoutParams2.width = -1;
                this.ajJ.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.aju.getLayoutParams();
                layoutParams3.width = -1;
                this.aju.setLayoutParams(layoutParams3);
                this.aju.setEllipsize(TextUtils.TruncateAt.END);
                if (bwVar.bmA() != null && !StringUtils.isNull(bwVar.bmA().getName_show())) {
                    this.aju.setText(bwVar.bmA().getName_show());
                } else {
                    this.aju.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.agx.blX())) {
                this.aju.setText(this.agx.blX());
            } else {
                this.aju.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.e(this.aju);
            um();
        }
    }

    protected void j(bw bwVar) {
        if (this.ajB != null) {
            if (bwVar == null || (!isShow(8) && !isShow(512))) {
                this.ajB.setVisibility(8);
            } else if (this.agx.getType() == bw.eFA) {
                this.ajB.setVisibility(0);
                this.ajB.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.ajB, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bwVar.bka())) {
                    this.ajB.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajB.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ajB.setLayoutParams(layoutParams);
                }
                this.ajB.setText(bwVar.bka());
                this.ajB.setVisibility(0);
            } else if (StringUtils.isNull(this.agx.blZ())) {
                this.ajB.setVisibility(8);
            } else {
                this.ajB.setVisibility(0);
                this.ajB.setText(this.agx.blZ());
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajw != null) {
            if (!isShow(32)) {
                this.ajw.setVisibility(8);
            } else if (bwVar == null || bwVar.bmA() == null || (bwVar.eGl > 0 && bwVar.eGm == 0)) {
                this.ajw.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bmA().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajw.setVisibility(0);
                    this.ajw.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.ajw.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void um() {
        if (this.agx != null && this.agx.bmA() != null) {
            if (this.agx.eGl > 0 && this.agx.eGm == 0) {
                ap.setViewTextColor(this.aju, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.f(this.aju);
            } else if (!y.isEmpty(this.agx.bmA().getTShowInfoNew()) || this.agx.boB()) {
                ap.setViewTextColor(this.aju, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.aju, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.f(this.aju);
            }
        }
    }

    private void l(bw bwVar) {
        if (this.ajx != null && bwVar != null && bwVar.bmA() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bwVar.bmA().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.ajx.setVisibility(0);
                this.ajx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ajx.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.ajv != null && bwVar != null && bwVar.bmA() != null && isShow(16)) {
            MetaData bmA = bwVar.bmA();
            if (this.ajv.getLayoutParams() != null) {
                this.ajv.getLayoutParams().width = -2;
            }
            this.ajv.setOnClickListener(null);
            if (bmA.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ap.setBackgroundResource(this.ajv, i);
                ap.setViewTextColor(this.ajv, i2);
                if (bwVar.eGz) {
                    this.ajv.setVisibility(0);
                    this.ajv.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bmA.getBawu_type())) {
                    this.ajv.setBackgroundDrawable(this.ajE);
                    this.ajv.setVisibility(0);
                    this.ajv.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bmA.getBawu_type())) {
                    this.ajv.setBackgroundDrawable(this.ajF);
                    this.ajv.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bmA.getBawu_type())) {
                    this.ajv.setText(R.string.bawu_content_assist_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bmA.getBawu_type())) {
                    this.ajv.setText(R.string.bawu_manage_assist_tip);
                    this.ajv.setVisibility(0);
                    return;
                } else {
                    this.ajv.setVisibility(8);
                    return;
                }
            }
            this.ajv.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ajs;
    }

    public View getUserName() {
        return this.aju;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ajH = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajs != null) {
            this.ajs.setPageId(bdUniqueId);
        }
    }

    private void n(bw bwVar) {
        if (this.ajy != null) {
            if (bwVar == null || TextUtils.isEmpty(bwVar.blY())) {
                this.ajy.setVisibility(8);
                return;
            }
            if (bwVar.bmA() != null && bwVar.bmA().isBaijiahaoUser()) {
                this.ajy.setLines(1);
                this.ajy.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ajy.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ajy.setEllipsize(null);
            }
            ap.setViewTextColor(this.ajy, R.color.cp_cont_d);
            this.ajy.setText(bwVar.blY());
            this.ajy.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bw bwVar) {
        String address;
        boolean z = true;
        dm("");
        if (bwVar != null) {
            if ((bwVar.getType() == bw.eDX || bwVar.getType() == bw.eEa) && bwVar.bmU() != null && bwVar.bmU().openRecomLocation != 0) {
                String bmP = bwVar.bmP();
                String bmQ = bwVar.bmQ();
                boolean z2 = UtilHelper.isDecimal(bmP) && UtilHelper.isDecimal(bmQ);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dBh = com.baidu.tieba.recapp.d.a.dBc().dBh();
                    String str = dBh.latitude;
                    String str2 = dBh.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(bmP), Double.parseDouble(bmQ));
                        if (GetDistance <= 50.0d) {
                            address = at.w(GetDistance);
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
    }

    private void dm(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ajz.setVisibility(z ? 0 : 8);
        this.ajA.setVisibility(z ? 0 : 8);
        if (z) {
            this.ajA.setText(str);
            SvgManager.brn().a(this.ajz, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.ajA, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void un() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.aju.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.ajB.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.aju.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.agx.bmA().getName_show(), 12)) + this.aju.getPaddingLeft() + this.aju.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.agx.bmA().getName_show(), 10)) + this.aju.getPaddingLeft() + this.aju.getPaddingRight();
            int measuredWidth = this.ajx.getMeasuredWidth();
            int measuredWidth2 = this.aju.getMeasuredWidth();
            int measuredWidth3 = this.ajB.getMeasuredWidth();
            int measuredWidth4 = this.ajv.getMeasuredWidth();
            int measuredWidth5 = this.ajw.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.aju.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.aju.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.aju.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.ajw.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ajv.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ajx.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.ajB.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.agx != null && this.agx.bmA() != null && this.agx.bmA().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.agx.bmA().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.ajy.setMaxWidth(i2);
        }
    }

    private void uo() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.ajE = new LayerDrawable(new Drawable[]{b.brP().pj(0).ab(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).brR(), b.brP().pj(0).ab(this.tbds6).Cm("#4D000000").brR()});
        this.ajF = new LayerDrawable(new Drawable[]{b.brP().pj(0).ab(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).brR(), b.brP().pj(0).ab(this.tbds6).Cm("#4D000000").brR()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.ajC;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bmA() == null || !bwVar.eGP || !com.baidu.tbadk.a.d.bid() || bwVar.bmA().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}

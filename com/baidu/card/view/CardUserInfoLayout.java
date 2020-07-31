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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes15.dex */
public class CardUserInfoLayout extends LinearLayout implements o {
    private static final int ahH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bv aeA;
    private ImageView ahA;
    private LayerDrawable ahB;
    private LayerDrawable ahC;
    private View.OnClickListener ahD;
    private View.OnClickListener ahE;
    private View ahF;
    private View ahG;
    private int ahI;
    private Runnable ahJ;
    private View.OnClickListener ahK;
    private View.OnClickListener ahL;
    private View.OnClickListener ahM;
    private HeadPendantClickableView ahp;
    private TBLottieAnimationView ahq;
    private TextView ahr;
    private TextView ahs;
    private UserIconBox aht;
    private UserIconBox ahu;
    private TextView ahv;
    private ImageView ahw;
    private TextView ahx;
    private TextView ahy;
    protected RelativeLayout ahz;
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
        this.ahI = 34053;
        this.ahJ = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.su();
            }
        };
        this.ahK = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bf.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.aeA != null && CardUserInfoLayout.this.aeA.aWl() != null && CardUserInfoLayout.this.aeA.aWl().getTShowInfoNew() != null && x.getItem(CardUserInfoLayout.this.aeA.aWl().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.aeA.aWl().getTShowInfoNew().get(0).getUrl()) != null && (i.G(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bd.baV().b((TbPageContext) i.G(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ahL = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aeA != null && CardUserInfoLayout.this.aeA.aWl() != null && !StringUtils.isNull(CardUserInfoLayout.this.aeA.aWl().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.aeA.aWl().getUserId()) && CardUserInfoLayout.this.aeA.aWp() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bf.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.aeA.aWl().getUserId(), CardUserInfoLayout.this.aeA.aWl().getName_show(), CardUserInfoLayout.this.aeA.aWp(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.aeA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ahD != null) {
                        CardUserInfoLayout.this.ahD.onClick(view);
                    }
                }
            }
        };
        this.ahM = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aeA != null && CardUserInfoLayout.this.aeA.aWl() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.aeA.aWl().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ahE != null) {
                        CardUserInfoLayout.this.ahD.onClick(view);
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
        ss();
        sv();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.ahI = i;
        sr();
    }

    private void sr() {
        this.ahu.setVisibility(isShow(1) ? 0 : 8);
        this.ahr.setVisibility(isShow(4) ? 0 : 8);
        this.ahs.setVisibility(isShow(16) ? 0 : 8);
        this.ahy.setVisibility(isShow(8) ? 0 : 8);
        this.aht.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahF.getLayoutParams();
        if (isShow(128)) {
            this.ahv.setVisibility(0);
        } else {
            this.ahv.setVisibility(8);
        }
        this.ahF.setLayoutParams(layoutParams);
        this.ahA.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ahI & i) > 0;
    }

    private void ss() {
        this.ahp = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ahp.setHasPendantStyle();
        this.ahp.getHeadView().setIsRound(true);
        this.ahp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahp.getHeadView().setDefaultResource(17170445);
        this.ahp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ahp.getHeadView().setPlaceHolder(1);
        this.ahp.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahD != null) {
                    CardUserInfoLayout.this.ahD.onClick(view);
                }
            }
        });
        this.ahq = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.ahu = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ahu.setOnClickListener(this.ahK);
        this.ahr = (TextView) findViewById(R.id.user_name);
        this.ahr.setOnClickListener(this.ahL);
        this.ahs = (TextView) findViewById(R.id.identity_view);
        this.ahy = (TextView) findViewById(R.id.thread_share_intro);
        this.aht = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.aht.setOnClickListener(this.ahM);
        this.ahv = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bac()) {
            this.ahv.setPadding(0, -ahH, 0, 0);
        }
        this.ahw = (ImageView) findViewById(R.id.ala_location_icon);
        this.ahx = (TextView) findViewById(R.id.ala_location);
        this.ahF = findViewById(R.id.user_name_and_reply_time);
        this.ahG = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ahz = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ahA = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ahp.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ahB != null && this.ahB.getDrawable(1) != null) {
                    this.ahB.getDrawable(1).setAlpha(255);
                }
                if (this.ahC != null && this.ahC.getDrawable(1) != null) {
                    this.ahC.getDrawable(1).setAlpha(255);
                }
                if (this.ahq != null) {
                    this.ahq.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.ahq != null) {
                    this.ahq.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.ahB != null && this.ahB.getDrawable(1) != null) {
                    this.ahB.getDrawable(1).setAlpha(0);
                }
                if (this.ahC != null && this.ahC.getDrawable(1) != null) {
                    this.ahC.getDrawable(1).setAlpha(0);
                }
                if (this.ahq != null) {
                    this.ahq.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void c(bv bvVar) {
        if (this.ahp != null && bvVar != null && this.aeA.aWl() != null) {
            this.ahp.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ahp, this.aeA.aWl(), 0)) {
                this.ahp.setIsHomePage(bvVar.dUJ);
                if (this.aeA.dUg > 0 && this.aeA.dUh == 0) {
                    this.ahp.hX(false);
                } else {
                    this.ahp.a(this.aeA.aWl(), 0);
                }
            }
        }
    }

    public void setData(bv bvVar) {
        if (bvVar == null) {
            setVisibility(8);
            return;
        }
        this.aeA = bvVar;
        e(bvVar);
        f(bvVar);
        k(bvVar);
        l(bvVar);
        h(bvVar);
        j(bvVar);
        c(bvVar);
        m(bvVar);
        n(bvVar);
        i(bvVar);
        g(bvVar);
        d(bvVar);
        setVisibility(0);
        if (isShow(128) && !bvVar.dUJ && !bvVar.aYd()) {
            this.ahF.post(this.ahJ);
        }
    }

    private void d(bv bvVar) {
        if (isShow(4096) && bvVar != null && this.ahA != null) {
            if (bvVar.dUF) {
                this.ahA.setVisibility(0);
            } else {
                this.ahA.setVisibility(8);
            }
        }
    }

    private void e(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null) {
            if (bvVar.aTV()) {
                this.ahI |= 4096;
            } else {
                this.ahI &= -4097;
            }
            if ((bvVar.dUJ && !bvVar.aUV() && !bvVar.aYm() && bvVar.getType() != bv.dRT) || (bvVar.dUJ && com.baidu.tbadk.a.d.aRL() && bvVar.getType() != bv.dRT)) {
                this.ahI &= -129;
            } else {
                this.ahI |= 128;
            }
            setShowFlag(this.ahI);
        }
    }

    private void f(bv bvVar) {
        if (bvVar.aWl() == null) {
            this.ahp.setVisibility(8);
            return;
        }
        MetaData aWl = bvVar.aWl();
        if (!isShow(256)) {
            aWl.setPendantData(null);
        }
        this.ahp.setData(bvVar);
    }

    private void g(bv bvVar) {
        if (!isShow(32768)) {
            this.ahq.setVisibility(8);
            if (this.ahq.isAnimating()) {
                this.ahq.cancelAnimation();
            }
            this.ahp.setIsclearmode(false);
        } else if (bvVar != null && bvVar.aWl() != null && bvVar.aWl().getAlaUserData() != null) {
            if (bvVar.aWl().getAlaUserData().live_status != 1) {
                this.ahq.setVisibility(8);
                this.ahq.cancelAnimation();
                this.ahp.setIsclearmode(false);
                return;
            }
            this.ahp.setIsclearmode(true);
            this.ahI &= -257;
            f(bvVar);
            this.ahq.setSpeed(0.8f);
            this.ahq.setVisibility(0);
            this.ahq.loop(true);
            this.ahq.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ahq.playAnimation();
                }
            });
        } else {
            this.ahq.setVisibility(8);
            this.ahq.cancelAnimation();
            this.ahp.setIsclearmode(false);
        }
    }

    private void h(bv bvVar) {
        if (this.ahr != null && bvVar != null) {
            if (bvVar.dUJ || bvVar.aYd()) {
                ViewGroup.LayoutParams layoutParams = this.ahF.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ahF.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ahG.getLayoutParams();
                layoutParams2.width = -1;
                this.ahG.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ahr.getLayoutParams();
                layoutParams3.width = -1;
                this.ahr.setLayoutParams(layoutParams3);
                this.ahr.setEllipsize(TextUtils.TruncateAt.END);
                if (bvVar.aWl() != null && !StringUtils.isNull(bvVar.aWl().getName_show())) {
                    this.ahr.setText(bvVar.aWl().getName_show());
                } else {
                    this.ahr.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.aeA.aVI())) {
                this.ahr.setText(this.aeA.aVI());
            } else {
                this.ahr.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.a(this.ahr);
            st();
        }
    }

    protected void i(bv bvVar) {
        if (this.ahy != null) {
            if (bvVar == null || (!isShow(8) && !isShow(512))) {
                this.ahy.setVisibility(8);
            } else if (this.aeA.getType() == bv.dTv) {
                this.ahy.setVisibility(0);
                this.ahy.getPaint().setFakeBoldText(true);
                ao.setViewTextColor(this.ahy, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bvVar.aTO())) {
                    this.ahy.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahy.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ahy.setLayoutParams(layoutParams);
                }
                this.ahy.setText(bvVar.aTO());
                this.ahy.setVisibility(0);
            } else if (StringUtils.isNull(this.aeA.aVK())) {
                this.ahy.setVisibility(8);
            } else {
                this.ahy.setVisibility(0);
                this.ahy.setText(this.aeA.aVK());
            }
        }
    }

    private void j(bv bvVar) {
        if (this.aht != null) {
            if (!isShow(32)) {
                this.aht.setVisibility(8);
            } else if (bvVar == null || bvVar.aWl() == null || (bvVar.dUg > 0 && bvVar.dUh == 0)) {
                this.aht.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bvVar.aWl().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.aht.setVisibility(0);
                    this.aht.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.aht.setVisibility(8);
            }
        }
    }

    protected String s(String str, int i) {
        return as.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void st() {
        if (this.aeA != null && this.aeA.aWl() != null) {
            if (this.aeA.dUg > 0 && this.aeA.dUh == 0) {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ahr);
            } else if (!x.isEmpty(this.aeA.aWl().getTShowInfoNew()) || this.aeA.aYm()) {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_h);
            } else {
                ao.setViewTextColor(this.ahr, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ahr);
            }
        }
    }

    private void k(bv bvVar) {
        if (this.ahu != null && bvVar != null && bvVar.aWl() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bvVar.aWl().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ahu.setVisibility(0);
                this.ahu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ahu.setVisibility(8);
        }
    }

    private void l(bv bvVar) {
        if (this.ahs != null && bvVar != null && bvVar.aWl() != null && isShow(16)) {
            MetaData aWl = bvVar.aWl();
            if (this.ahs.getLayoutParams() != null) {
                this.ahs.getLayoutParams().width = -2;
            }
            this.ahs.setOnClickListener(null);
            if (aWl.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ao.setBackgroundResource(this.ahs, i);
                ao.setViewTextColor(this.ahs, i2);
                if (bvVar.dUu) {
                    this.ahs.setVisibility(0);
                    this.ahs.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(aWl.getBawu_type())) {
                    this.ahs.setBackgroundDrawable(this.ahB);
                    this.ahs.setVisibility(0);
                    this.ahs.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(aWl.getBawu_type())) {
                    this.ahs.setBackgroundDrawable(this.ahC);
                    this.ahs.setText(R.string.bawu_member_xbazhu_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(aWl.getBawu_type())) {
                    this.ahs.setText(R.string.bawu_content_assist_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(aWl.getBawu_type())) {
                    this.ahs.setText(R.string.bawu_manage_assist_tip);
                    this.ahs.setVisibility(0);
                    return;
                } else {
                    this.ahs.setVisibility(8);
                    return;
                }
            }
            this.ahs.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ahp;
    }

    public View getUserName() {
        return this.ahr;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ahE = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ahp != null) {
            this.ahp.setPageId(bdUniqueId);
        }
    }

    private void m(bv bvVar) {
        if (this.ahv != null) {
            if (bvVar == null || TextUtils.isEmpty(bvVar.aVJ())) {
                this.ahv.setVisibility(8);
                return;
            }
            if (bvVar.aWl() != null && bvVar.aWl().isBaijiahaoUser()) {
                this.ahv.setLines(1);
                this.ahv.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ahv.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ahv.setEllipsize(null);
            }
            ao.setViewTextColor(this.ahv, R.color.cp_cont_d);
            this.ahv.setText(bvVar.aVJ());
            this.ahv.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void n(bv bvVar) {
        String address;
        boolean z = true;
        cZ("");
        if (bvVar != null && bvVar.getType() == bv.dRT && bvVar.aWF() != null && bvVar.aWF().openRecomLocation != 0) {
            String aWA = bvVar.aWA();
            String aWB = bvVar.aWB();
            boolean z2 = UtilHelper.isDecimal(aWA) && UtilHelper.isDecimal(aWB);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo dcR = com.baidu.tieba.recapp.d.a.dcN().dcR();
                String str = dcR.latitude;
                String str2 = dcR.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(aWA), Double.parseDouble(aWB));
                    if (GetDistance <= 50.0d) {
                        address = as.m(GetDistance);
                    } else {
                        address = bvVar.getAddress();
                    }
                }
                address = "";
            } else {
                if (z2) {
                    address = bvVar.getAddress();
                }
                address = "";
            }
            cZ(address);
        }
    }

    private void cZ(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ahw.setVisibility(z ? 0 : 8);
        this.ahx.setVisibility(z ? 0 : 8);
        if (z) {
            this.ahx.setText(str);
            SvgManager.baR().a(this.ahw, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.ahx, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void su() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ahr.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.ahy.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ahr.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, s(this.aeA.aWl().getName_show(), 12)) + this.ahr.getPaddingLeft() + this.ahr.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, s(this.aeA.aWl().getName_show(), 10)) + this.ahr.getPaddingLeft() + this.ahr.getPaddingRight();
            int measuredWidth = this.ahu.getMeasuredWidth();
            int measuredWidth2 = this.ahr.getMeasuredWidth();
            int measuredWidth3 = this.ahy.getMeasuredWidth();
            int measuredWidth4 = this.ahs.getMeasuredWidth();
            int measuredWidth5 = this.aht.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ahr.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ahr.setText(s(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ahr.setText(s(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.aht.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ahs.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ahu.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.ahy.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.aeA != null && this.aeA.aWl() != null && this.aeA.aWl().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.ahv.setMaxWidth(i2);
        }
    }

    private void sv() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.ahB = new LayerDrawable(new Drawable[]{c.bbv().ma(0).Q(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bbx(), c.bbv().ma(0).Q(this.tbds6).yi("#4D000000").bbx()});
        this.ahC = new LayerDrawable(new Drawable[]{c.bbv().ma(0).Q(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bbx(), c.bbv().ma(0).Q(this.tbds6).yi("#4D000000").bbx()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.ahz;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

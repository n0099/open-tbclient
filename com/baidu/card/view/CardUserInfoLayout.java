package com.baidu.card.view;

import android.content.Context;
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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int alq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bz aim;
    private HeadPendantClickableView akY;
    private TBLottieAnimationView akZ;
    private TextView ala;
    private TextView alb;
    private UserIconBox alc;
    private UserIconBox ald;
    private TextView ale;
    private ImageView alf;
    private TextView alg;
    private TextView alh;
    protected RelativeLayout ali;
    private ImageView alj;
    private View.OnClickListener alk;
    private View.OnClickListener alm;
    private View aln;
    private View alo;
    private ImageView alp;
    private int alr;
    private Runnable als;
    private View.OnClickListener alt;
    private View.OnClickListener alu;
    private View.OnClickListener alv;
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
        this.alr = 34053;
        this.als = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.tP();
            }
        };
        this.alt = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.aim != null && CardUserInfoLayout.this.aim.brr() != null && CardUserInfoLayout.this.aim.brr().getTShowInfoNew() != null && x.getItem(CardUserInfoLayout.this.aim.brr().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.aim.brr().getTShowInfoNew().get(0).getUrl()) != null && (j.K(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bwv().b((TbPageContext) j.K(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alu = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aim != null && CardUserInfoLayout.this.aim.brr() != null && !StringUtils.isNull(CardUserInfoLayout.this.aim.brr().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.aim.brr().getUserId()) && CardUserInfoLayout.this.aim.brv() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.aim.brr().getUserId(), CardUserInfoLayout.this.aim.brr().getName_show(), CardUserInfoLayout.this.aim.brv(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.aim.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.alk != null) {
                        CardUserInfoLayout.this.alk.onClick(view);
                    }
                }
            }
        };
        this.alv = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aim != null && CardUserInfoLayout.this.aim.brr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.aim.brr().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.alm != null) {
                        CardUserInfoLayout.this.alk.onClick(view);
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
        tN();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.alr = i;
        tM();
    }

    private void tM() {
        this.ald.setVisibility(isShow(1) ? 0 : 8);
        this.ala.setVisibility(isShow(4) ? 0 : 8);
        this.alb.setVisibility(isShow(16) ? 0 : 8);
        this.alh.setVisibility(isShow(8) ? 0 : 8);
        this.alc.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aln.getLayoutParams();
        if (isShow(128)) {
            this.ale.setVisibility(0);
        } else {
            this.ale.setVisibility(8);
        }
        this.aln.setLayoutParams(layoutParams);
        this.alj.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.alr & i) > 0;
    }

    private void tN() {
        this.akY = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.akY.setHasPendantStyle();
        this.akY.getHeadView().setIsRound(true);
        this.akY.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.akY.getHeadView().setDefaultResource(17170445);
        this.akY.getHeadView().setPlaceHolder(1);
        this.akY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.alk != null) {
                    CardUserInfoLayout.this.alk.onClick(view);
                }
            }
        });
        this.akZ = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.alp = (ImageView) findViewById(R.id.img_official_v);
        this.ald = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.ald.setOnClickListener(this.alt);
        this.ala = (TextView) findViewById(R.id.user_name);
        this.ala.setOnClickListener(this.alu);
        this.alb = (TextView) findViewById(R.id.identity_view);
        this.alh = (TextView) findViewById(R.id.thread_share_intro);
        this.alc = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.alc.setOnClickListener(this.alv);
        this.alc.setAutoChangedStyle(false);
        this.ale = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bvE()) {
            this.ale.setPadding(0, -alq, 0, 0);
        }
        this.alf = (ImageView) findViewById(R.id.ala_location_icon);
        this.alg = (TextView) findViewById(R.id.ala_location);
        this.aln = findViewById(R.id.user_name_and_reply_time);
        this.alo = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ali = (RelativeLayout) findViewById(R.id.suffix_container);
        this.alj = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.akY.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.akZ != null) {
                    this.akZ.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.akZ != null) {
                    this.akZ.setAnimation("live/card_live_bg_black.json");
                }
            } else if (this.akZ != null) {
                this.akZ.setAnimation("live/card_live_bg.json");
            }
            if (this.alp.getVisibility() == 0) {
                WebPManager.a(this.alp, R.drawable.ic_icon_mask_shang22_n, (WebPManager.ResourceStateType) null);
            }
        }
    }

    private void d(bz bzVar) {
        if (this.akY != null && bzVar != null && this.aim.brr() != null) {
            this.akY.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.akY, this.aim.brr(), 0)) {
                this.akY.setIsHomePage(bzVar.eWd);
                if (this.aim.eVz > 0 && this.aim.eVA == 0) {
                    this.akY.jZ(false);
                } else {
                    this.akY.a(this.aim.brr(), 0);
                }
            }
        }
    }

    public void setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
        } else if (c(bzVar)) {
            setVisibility(4);
        } else {
            this.aim = bzVar;
            f(bzVar);
            g(bzVar);
            l(bzVar);
            m(bzVar);
            i(bzVar);
            k(bzVar);
            d(bzVar);
            n(bzVar);
            o(bzVar);
            j(bzVar);
            h(bzVar);
            e(bzVar);
            setVisibility(0);
            if (isShow(128) && !bzVar.eWd && !bzVar.btm()) {
                this.aln.post(this.als);
            }
        }
    }

    private void e(bz bzVar) {
        if (isShow(4096) && bzVar != null && this.alj != null) {
            if (bzVar.eVZ) {
                this.alj.setVisibility(0);
            } else {
                this.alj.setVisibility(8);
            }
        }
    }

    private void f(bz bzVar) {
        if (bzVar != null && bzVar.brr() != null) {
            if (bzVar.boW()) {
                this.alr |= 4096;
            } else {
                this.alr &= -4097;
            }
            if (!(bzVar instanceof AdvertAppInfo) && ((bzVar.eWd && !bzVar.bqa() && !bzVar.btw() && bzVar.getType() != bz.eTk && bzVar.getType() != bz.eTn) || (bzVar.eWd && d.bmF() && bzVar.getType() != bz.eTk && bzVar.getType() != bz.eTn))) {
                this.alr &= -129;
            } else {
                this.alr |= 128;
            }
            setShowFlag(this.alr);
        }
    }

    private void g(bz bzVar) {
        if (bzVar.brr() == null) {
            this.akY.setVisibility(8);
            return;
        }
        MetaData brr = bzVar.brr();
        if (!isShow(256)) {
            brr.setPendantData(null);
        }
        this.akY.setData(bzVar);
    }

    private void h(bz bzVar) {
        if (!isShow(32768)) {
            this.akZ.setVisibility(8);
            if (this.akZ.isAnimating()) {
                this.akZ.cancelAnimation();
            }
            this.akY.setIsclearmode(false);
            this.alp.setVisibility(8);
            return;
        }
        boolean z = (bzVar == null || bzVar.brr() == null || bzVar.brr().getAlaUserData() == null || bzVar.brr().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (bzVar == null || bzVar.brK() == null || bzVar.brK().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.akY.setIsclearmode(true);
            if (bzVar != null && bzVar.brr() != null && bzVar.brr().isOfficial()) {
                this.alp.setVisibility(0);
                ao.setImageResource(this.alp, R.drawable.ic_icon_mask_shang22_n);
            }
            this.alr &= -257;
            g(bzVar);
            this.akZ.setSpeed(0.8f);
            this.akZ.setVisibility(0);
            this.akZ.loop(true);
            this.akZ.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.akZ.playAnimation();
                }
            });
            return;
        }
        this.akZ.setVisibility(8);
        this.akZ.cancelAnimation();
        this.akY.setIsclearmode(false);
        this.alp.setVisibility(8);
    }

    private void i(bz bzVar) {
        if (this.ala != null && bzVar != null) {
            if (bzVar.eWd || bzVar.btm()) {
                ViewGroup.LayoutParams layoutParams = this.aln.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.aln.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.alo.getLayoutParams();
                layoutParams2.width = -1;
                this.alo.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ala.getLayoutParams();
                layoutParams3.width = -1;
                this.ala.setLayoutParams(layoutParams3);
                this.ala.setEllipsize(TextUtils.TruncateAt.END);
                if (bzVar.brr() != null && !StringUtils.isNull(bzVar.brr().getName_show())) {
                    this.ala.setText(bzVar.brr().getName_show());
                } else {
                    this.ala.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.aim.bqO())) {
                this.ala.setText(this.aim.bqO());
            } else {
                this.ala.setText(R.string.user_name_default_txt);
            }
            b.g(this.ala);
            tO();
        }
    }

    protected void j(bz bzVar) {
        if (this.alh != null) {
            if (bzVar == null || (!isShow(8) && !isShow(512))) {
                this.alh.setVisibility(8);
            } else if (this.aim.getType() == bz.eUO) {
                this.alh.setVisibility(0);
                this.alh.getPaint().setFakeBoldText(true);
                ao.setViewTextColor(this.alh, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bzVar.boQ())) {
                    this.alh.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alh.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.alh.setLayoutParams(layoutParams);
                }
                this.alh.setText(bzVar.boQ());
                this.alh.setVisibility(0);
            } else if (StringUtils.isNull(this.aim.bqQ())) {
                this.alh.setVisibility(8);
            } else {
                this.alh.setVisibility(0);
                this.alh.setText(this.aim.bqQ());
            }
        }
    }

    private void k(bz bzVar) {
        if (this.alc != null) {
            if (!isShow(32)) {
                this.alc.setVisibility(8);
            } else if (bzVar == null || bzVar.brr() == null || (bzVar.eVz > 0 && bzVar.eVA == 0)) {
                this.alc.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bzVar.brr().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.alc.setVisibility(0);
                    this.alc.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.alc.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void tO() {
        if (this.aim != null && this.aim.brr() != null) {
            if (this.aim.eVz > 0 && this.aim.eVA == 0) {
                ao.setViewTextColor(this.ala, R.color.CAM_X0106);
                b.h(this.ala);
            } else if (!x.isEmpty(this.aim.brr().getTShowInfoNew()) || this.aim.btw()) {
                ao.setViewTextColor(this.ala, R.color.CAM_X0301);
            } else {
                ao.setViewTextColor(this.ala, R.color.CAM_X0106);
                b.h(this.ala);
            }
        }
    }

    private void l(bz bzVar) {
        if (this.ald != null && bzVar != null && bzVar.brr() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bzVar.brr().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.ald.setVisibility(0);
                this.ald.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.ald.setVisibility(8);
        }
    }

    private void m(bz bzVar) {
        if (this.alb != null && bzVar != null && bzVar.brr() != null && isShow(16)) {
            MetaData brr = bzVar.brr();
            if (this.alb.getLayoutParams() != null) {
                this.alb.getLayoutParams().width = -2;
            }
            this.alb.setOnClickListener(null);
            if (brr.getIs_bawu() == 1) {
                c.bv(this.alb).pC(R.color.CAM_X0101).pO(R.string.A_X04).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (bzVar.eVN) {
                    this.alb.setVisibility(0);
                    this.alb.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                    this.alb.setVisibility(0);
                    this.alb.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_member_xbazhu_tip);
                    this.alb.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_content_assist_tip);
                    this.alb.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(brr.getBawu_type())) {
                    this.alb.setText(R.string.bawu_manage_assist_tip);
                    this.alb.setVisibility(0);
                    return;
                } else {
                    this.alb.setVisibility(8);
                    return;
                }
            }
            this.alb.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.akY;
    }

    public View getUserName() {
        return this.ala;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alk = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.akY != null) {
            this.akY.setPageId(bdUniqueId);
        }
    }

    private void n(bz bzVar) {
        if (this.ale != null) {
            if (bzVar == null || TextUtils.isEmpty(bzVar.bqP())) {
                this.ale.setVisibility(8);
                return;
            }
            if (bzVar.brr() != null && bzVar.brr().isBaijiahaoUser()) {
                this.ale.setLines(1);
                this.ale.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ale.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ale.setEllipsize(null);
            }
            ao.setViewTextColor(this.ale, R.color.CAM_X0109);
            this.ale.setText(bzVar.bqP());
            this.ale.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bz bzVar) {
        String address;
        boolean z = true;
        dk("");
        if (bzVar != null) {
            if ((bzVar.getType() == bz.eTk || bzVar.getType() == bz.eTn) && bzVar.brK() != null && bzVar.brK().openRecomLocation != 0) {
                String latitude = bzVar.getLatitude();
                String brG = bzVar.brG();
                boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(brG);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dFT = com.baidu.tieba.recapp.c.a.dFO().dFT();
                    String str = dFT.latitude;
                    String str2 = dFT.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(com.baidu.adp.lib.f.b.toDouble(str, 0.0d), com.baidu.adp.lib.f.b.toDouble(str2, 0.0d), com.baidu.adp.lib.f.b.toDouble(latitude, 0.0d), com.baidu.adp.lib.f.b.toDouble(brG, 0.0d));
                        if (GetDistance <= 50.0d) {
                            address = at.v(GetDistance);
                        } else {
                            address = bzVar.getAddress();
                        }
                    }
                    address = "";
                } else {
                    if (z2) {
                        address = bzVar.getAddress();
                    }
                    address = "";
                }
                dk(address);
            }
        }
    }

    private void dk(String str) {
        boolean z = !StringUtils.isNull(str);
        this.alf.setVisibility(z ? 0 : 8);
        this.alg.setVisibility(z ? 0 : 8);
        if (z) {
            this.alg.setText(str);
            SvgManager.bwr().a(this.alf, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.alg, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tP() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ala.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.alh.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ala.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.aim.brr().getName_show(), 12)) + this.ala.getPaddingLeft() + this.ala.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.aim.brr().getName_show(), 10)) + this.ala.getPaddingLeft() + this.ala.getPaddingRight();
            int measuredWidth = this.ald.getMeasuredWidth();
            int measuredWidth2 = this.ala.getMeasuredWidth();
            int measuredWidth3 = this.alh.getMeasuredWidth();
            int measuredWidth4 = this.alb.getMeasuredWidth();
            int measuredWidth5 = this.alc.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ala.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ala.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ala.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.alc.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.alb.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.ald.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.alh.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.aim != null && this.aim.brr() != null && this.aim.brr().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.aim.brr().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.ale.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.ali;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.brr() == null || !bzVar.eWe || !d.bmO() || bzVar.brr().hadConcerned() || ay.x(bzVar)) ? false : true;
    }
}

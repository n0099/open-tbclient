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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
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
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes21.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int akN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private by ahA;
    private UserIconBox akA;
    private UserIconBox akB;
    private TextView akC;
    private ImageView akD;
    private TextView akE;
    private TextView akF;
    protected RelativeLayout akG;
    private ImageView akH;
    private View.OnClickListener akI;
    private View.OnClickListener akJ;
    private View akK;
    private View akL;
    private ImageView akM;
    private int akO;
    private Runnable akP;
    private View.OnClickListener akQ;
    private View.OnClickListener akR;
    private View.OnClickListener akS;
    private HeadPendantClickableView akw;
    private TBLottieAnimationView akx;
    private TextView aky;
    private TextView akz;
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
        this.akO = 34053;
        this.akP = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.uq();
            }
        };
        this.akQ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.ahA != null && CardUserInfoLayout.this.ahA.boP() != null && CardUserInfoLayout.this.ahA.boP().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.ahA.boP().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.ahA.boP().getTShowInfoNew().get(0).getUrl()) != null && (i.J(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bua().b((TbPageContext) i.J(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akR = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahA != null && CardUserInfoLayout.this.ahA.boP() != null && !StringUtils.isNull(CardUserInfoLayout.this.ahA.boP().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.ahA.boP().getUserId()) && CardUserInfoLayout.this.ahA.boT() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.ahA.boP().getUserId(), CardUserInfoLayout.this.ahA.boP().getName_show(), CardUserInfoLayout.this.ahA.boT(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.ahA.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.akI != null) {
                        CardUserInfoLayout.this.akI.onClick(view);
                    }
                }
            }
        };
        this.akS = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahA != null && CardUserInfoLayout.this.ahA.boP() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.ahA.boP().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.akJ != null) {
                        CardUserInfoLayout.this.akI.onClick(view);
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
        uo();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.akO = i;
        un();
    }

    private void un() {
        this.akB.setVisibility(isShow(1) ? 0 : 8);
        this.aky.setVisibility(isShow(4) ? 0 : 8);
        this.akz.setVisibility(isShow(16) ? 0 : 8);
        this.akF.setVisibility(isShow(8) ? 0 : 8);
        this.akA.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akK.getLayoutParams();
        if (isShow(128)) {
            this.akC.setVisibility(0);
        } else {
            this.akC.setVisibility(8);
        }
        this.akK.setLayoutParams(layoutParams);
        this.akH.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.akO & i) > 0;
    }

    private void uo() {
        this.akw = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.akw.setHasPendantStyle();
        this.akw.getHeadView().setIsRound(true);
        this.akw.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.akw.getHeadView().setDefaultResource(17170445);
        this.akw.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.akw.getHeadView().setPlaceHolder(1);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.akI != null) {
                    CardUserInfoLayout.this.akI.onClick(view);
                }
            }
        });
        this.akx = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.akM = (ImageView) findViewById(R.id.img_official_v);
        this.akB = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.akB.setOnClickListener(this.akQ);
        this.aky = (TextView) findViewById(R.id.user_name);
        this.aky.setOnClickListener(this.akR);
        this.akz = (TextView) findViewById(R.id.identity_view);
        this.akF = (TextView) findViewById(R.id.thread_share_intro);
        this.akA = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.akA.setOnClickListener(this.akS);
        this.akA.setAutoChangedStyle(false);
        this.akC = (TextView) findViewById(R.id.thread_extend_info);
        if (g.btb()) {
            this.akC.setPadding(0, -akN, 0, 0);
        }
        this.akD = (ImageView) findViewById(R.id.ala_location_icon);
        this.akE = (TextView) findViewById(R.id.ala_location);
        this.akK = findViewById(R.id.user_name_and_reply_time);
        this.akL = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.akG = (RelativeLayout) findViewById(R.id.suffix_container);
        this.akH = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.akw.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.akx != null) {
                    this.akx.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.akx != null) {
                    this.akx.setAnimation("live/card_live_bg_black.json");
                }
            } else if (this.akx != null) {
                this.akx.setAnimation("live/card_live_bg.json");
            }
            if (this.akM.getVisibility() == 0) {
                WebPManager.a(this.akM, R.drawable.ic_icon_mask_shang22_n, (WebPManager.ResourceStateType) null);
            }
        }
    }

    private void d(by byVar) {
        if (this.akw != null && byVar != null && this.ahA.boP() != null) {
            this.akw.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.akw, this.ahA.boP(), 0)) {
                this.akw.setIsHomePage(byVar.eMi);
                if (this.ahA.eLF > 0 && this.ahA.eLG == 0) {
                    this.akw.jD(false);
                } else {
                    this.akw.a(this.ahA.boP(), 0);
                }
            }
        }
    }

    public void setData(by byVar) {
        if (byVar == null) {
            setVisibility(8);
        } else if (c(byVar)) {
            setVisibility(4);
        } else {
            this.ahA = byVar;
            f(byVar);
            g(byVar);
            l(byVar);
            m(byVar);
            i(byVar);
            k(byVar);
            d(byVar);
            n(byVar);
            o(byVar);
            j(byVar);
            h(byVar);
            e(byVar);
            setVisibility(0);
            if (isShow(128) && !byVar.eMi && !byVar.bqJ()) {
                this.akK.post(this.akP);
            }
        }
    }

    private void e(by byVar) {
        if (isShow(4096) && byVar != null && this.akH != null) {
            if (byVar.eMe) {
                this.akH.setVisibility(0);
            } else {
                this.akH.setVisibility(8);
            }
        }
    }

    private void f(by byVar) {
        if (byVar != null && byVar.boP() != null) {
            if (byVar.bmu()) {
                this.akO |= 4096;
            } else {
                this.akO &= -4097;
            }
            if (!(byVar instanceof AdvertAppInfo) && ((byVar.eMi && !byVar.bnz() && !byVar.bqT() && byVar.getType() != by.eJr && byVar.getType() != by.eJu) || (byVar.eMi && d.bkq() && byVar.getType() != by.eJr && byVar.getType() != by.eJu))) {
                this.akO &= -129;
            } else {
                this.akO |= 128;
            }
            setShowFlag(this.akO);
        }
    }

    private void g(by byVar) {
        if (byVar.boP() == null) {
            this.akw.setVisibility(8);
            return;
        }
        MetaData boP = byVar.boP();
        if (!isShow(256)) {
            boP.setPendantData(null);
        }
        this.akw.setData(byVar);
    }

    private void h(by byVar) {
        if (!isShow(32768)) {
            this.akx.setVisibility(8);
            if (this.akx.isAnimating()) {
                this.akx.cancelAnimation();
            }
            this.akw.setIsclearmode(false);
            this.akM.setVisibility(8);
            return;
        }
        boolean z = (byVar == null || byVar.boP() == null || byVar.boP().getAlaUserData() == null || byVar.boP().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (byVar == null || byVar.bpj() == null || byVar.bpj().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.akw.setIsclearmode(true);
            if (byVar != null && byVar.boP() != null && byVar.boP().isOfficial()) {
                this.akM.setVisibility(0);
                ap.setImageResource(this.akM, R.drawable.ic_icon_mask_shang22_n);
            }
            this.akO &= -257;
            g(byVar);
            this.akx.setSpeed(0.8f);
            this.akx.setVisibility(0);
            this.akx.loop(true);
            this.akx.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.akx.playAnimation();
                }
            });
            return;
        }
        this.akx.setVisibility(8);
        this.akx.cancelAnimation();
        this.akw.setIsclearmode(false);
        this.akM.setVisibility(8);
    }

    private void i(by byVar) {
        if (this.aky != null && byVar != null) {
            if (byVar.eMi || byVar.bqJ()) {
                ViewGroup.LayoutParams layoutParams = this.akK.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.akK.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.akL.getLayoutParams();
                layoutParams2.width = -1;
                this.akL.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.aky.getLayoutParams();
                layoutParams3.width = -1;
                this.aky.setLayoutParams(layoutParams3);
                this.aky.setEllipsize(TextUtils.TruncateAt.END);
                if (byVar.boP() != null && !StringUtils.isNull(byVar.boP().getName_show())) {
                    this.aky.setText(byVar.boP().getName_show());
                } else {
                    this.aky.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.ahA.bom())) {
                this.aky.setText(this.ahA.bom());
            } else {
                this.aky.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.e(this.aky);
            up();
        }
    }

    protected void j(by byVar) {
        if (this.akF != null) {
            if (byVar == null || (!isShow(8) && !isShow(512))) {
                this.akF.setVisibility(8);
            } else if (this.ahA.getType() == by.eKU) {
                this.akF.setVisibility(0);
                this.akF.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.akF, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(byVar.bmo())) {
                    this.akF.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akF.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.akF.setLayoutParams(layoutParams);
                }
                this.akF.setText(byVar.bmo());
                this.akF.setVisibility(0);
            } else if (StringUtils.isNull(this.ahA.boo())) {
                this.akF.setVisibility(8);
            } else {
                this.akF.setVisibility(0);
                this.akF.setText(this.ahA.boo());
            }
        }
    }

    private void k(by byVar) {
        if (this.akA != null) {
            if (!isShow(32)) {
                this.akA.setVisibility(8);
            } else if (byVar == null || byVar.boP() == null || (byVar.eLF > 0 && byVar.eLG == 0)) {
                this.akA.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = byVar.boP().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.akA.setVisibility(0);
                    this.akA.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.akA.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void up() {
        if (this.ahA != null && this.ahA.boP() != null) {
            if (this.ahA.eLF > 0 && this.ahA.eLG == 0) {
                ap.setViewTextColor(this.aky, R.color.CAM_X0106);
                com.baidu.tbadk.a.b.a.f(this.aky);
            } else if (!y.isEmpty(this.ahA.boP().getTShowInfoNew()) || this.ahA.bqT()) {
                ap.setViewTextColor(this.aky, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.aky, R.color.CAM_X0106);
                com.baidu.tbadk.a.b.a.f(this.aky);
            }
        }
    }

    private void l(by byVar) {
        if (this.akB != null && byVar != null && byVar.boP() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = byVar.boP().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akB.setVisibility(0);
                this.akB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akB.setVisibility(8);
        }
    }

    private void m(by byVar) {
        if (this.akz != null && byVar != null && byVar.boP() != null && isShow(16)) {
            MetaData boP = byVar.boP();
            if (this.akz.getLayoutParams() != null) {
                this.akz.getLayoutParams().width = -2;
            }
            this.akz.setOnClickListener(null);
            if (boP.getIs_bawu() == 1) {
                c.bm(this.akz).ps(R.color.CAM_X0101).pE(R.string.A_X04).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (byVar.eLT) {
                    this.akz.setVisibility(0);
                    this.akz.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                    this.akz.setVisibility(0);
                    this.akz.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_member_xbazhu_tip);
                    this.akz.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_content_assist_tip);
                    this.akz.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(boP.getBawu_type())) {
                    this.akz.setText(R.string.bawu_manage_assist_tip);
                    this.akz.setVisibility(0);
                    return;
                } else {
                    this.akz.setVisibility(8);
                    return;
                }
            }
            this.akz.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.akw;
    }

    public View getUserName() {
        return this.aky;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.akJ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.akw != null) {
            this.akw.setPageId(bdUniqueId);
        }
    }

    private void n(by byVar) {
        if (this.akC != null) {
            if (byVar == null || TextUtils.isEmpty(byVar.bon())) {
                this.akC.setVisibility(8);
                return;
            }
            if (byVar.boP() != null && byVar.boP().isBaijiahaoUser()) {
                this.akC.setLines(1);
                this.akC.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.akC.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.akC.setEllipsize(null);
            }
            ap.setViewTextColor(this.akC, R.color.CAM_X0109);
            this.akC.setText(byVar.bon());
            this.akC.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(by byVar) {
        String address;
        boolean z = true;
        dr("");
        if (byVar != null) {
            if ((byVar.getType() == by.eJr || byVar.getType() == by.eJu) && byVar.bpj() != null && byVar.bpj().openRecomLocation != 0) {
                String bpe = byVar.bpe();
                String bpf = byVar.bpf();
                boolean z2 = UtilHelper.isDecimal(bpe) && UtilHelper.isDecimal(bpf);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dGc = com.baidu.tieba.recapp.d.a.dFX().dGc();
                    String str = dGc.latitude;
                    String str2 = dGc.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(b.toDouble(str, 0.0d), b.toDouble(str2, 0.0d), b.toDouble(bpe, 0.0d), b.toDouble(bpf, 0.0d));
                        if (GetDistance <= 50.0d) {
                            address = au.v(GetDistance);
                        } else {
                            address = byVar.getAddress();
                        }
                    }
                    address = "";
                } else {
                    if (z2) {
                        address = byVar.getAddress();
                    }
                    address = "";
                }
                dr(address);
            }
        }
    }

    private void dr(String str) {
        boolean z = !StringUtils.isNull(str);
        this.akD.setVisibility(z ? 0 : 8);
        this.akE.setVisibility(z ? 0 : 8);
        if (z) {
            this.akE.setText(str);
            SvgManager.btW().a(this.akD, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.akE, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uq() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.aky.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.akF.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.aky.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.ahA.boP().getName_show(), 12)) + this.aky.getPaddingLeft() + this.aky.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.ahA.boP().getName_show(), 10)) + this.aky.getPaddingLeft() + this.aky.getPaddingRight();
            int measuredWidth = this.akB.getMeasuredWidth();
            int measuredWidth2 = this.aky.getMeasuredWidth();
            int measuredWidth3 = this.akF.getMeasuredWidth();
            int measuredWidth4 = this.akz.getMeasuredWidth();
            int measuredWidth5 = this.akA.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.aky.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.aky.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.aky.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.akA.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.akz.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.akB.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.akF.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.ahA != null && this.ahA.boP() != null && this.ahA.boP().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.ahA.boP().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.akC.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.akG;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(by byVar) {
        return (byVar == null || byVar.boP() == null || !byVar.eMj || !d.bkz() || byVar.boP().hadConcerned() || az.x(byVar)) ? false : true;
    }
}

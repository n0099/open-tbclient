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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int alG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private cb aiB;
    private ImageView alA;
    private View.OnClickListener alB;
    private View.OnClickListener alC;
    private View alD;
    private View alE;
    private ImageView alF;
    private int alH;
    private Runnable alI;
    private View.OnClickListener alJ;
    private View.OnClickListener alK;
    private View.OnClickListener alL;
    private HeadPendantClickableView alp;
    private TBLottieAnimationView alq;
    private TextView alr;
    private TextView als;
    private UserIconBox alt;
    private UserIconBox alu;
    private TextView alv;
    private ImageView alw;
    private TextView alx;
    private TextView aly;
    protected RelativeLayout alz;
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
        this.alH = 34053;
        this.alI = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.tB();
            }
        };
        this.alJ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.aiB != null && CardUserInfoLayout.this.aiB.bnS() != null && CardUserInfoLayout.this.aiB.bnS().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.aiB.bnS().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.aiB.bnS().getTShowInfoNew().get(0).getUrl()) != null && (j.J(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsY().b((TbPageContext) j.J(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.alK = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aiB != null && CardUserInfoLayout.this.aiB.bnS() != null && !StringUtils.isNull(CardUserInfoLayout.this.aiB.bnS().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.aiB.bnS().getUserId()) && CardUserInfoLayout.this.aiB.bnW() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.aiB.bnS().getUserId(), CardUserInfoLayout.this.aiB.bnS().getName_show(), CardUserInfoLayout.this.aiB.bnW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.aiB.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.alB != null) {
                        CardUserInfoLayout.this.alB.onClick(view);
                    }
                }
            }
        };
        this.alL = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aiB != null && CardUserInfoLayout.this.aiB.bnS() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.aiB.bnS().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.alC != null) {
                        CardUserInfoLayout.this.alB.onClick(view);
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
        tz();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.alH = i;
        ty();
    }

    private void ty() {
        this.alu.setVisibility(isShow(1) ? 0 : 8);
        this.alr.setVisibility(isShow(4) ? 0 : 8);
        this.als.setVisibility(isShow(16) ? 0 : 8);
        this.aly.setVisibility(isShow(8) ? 0 : 8);
        this.alt.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.alD.getLayoutParams();
        if (isShow(128)) {
            this.alv.setVisibility(0);
        } else {
            this.alv.setVisibility(8);
        }
        this.alD.setLayoutParams(layoutParams);
        this.alA.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.alH & i) > 0;
    }

    private void tz() {
        this.alp = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.alp.setHasPendantStyle();
        this.alp.getHeadView().setIsRound(true);
        this.alp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.alp.getHeadView().setDefaultResource(17170445);
        this.alp.getHeadView().setPlaceHolder(1);
        this.alp.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.alB != null) {
                    CardUserInfoLayout.this.alB.onClick(view);
                }
            }
        });
        this.alq = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.alF = (ImageView) findViewById(R.id.img_official_v);
        this.alu = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.alu.setOnClickListener(this.alJ);
        this.alr = (TextView) findViewById(R.id.user_name);
        this.alr.setOnClickListener(this.alK);
        this.als = (TextView) findViewById(R.id.identity_view);
        this.aly = (TextView) findViewById(R.id.thread_share_intro);
        this.alt = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.alt.setOnClickListener(this.alL);
        this.alt.setAutoChangedStyle(false);
        this.alv = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bsf()) {
            this.alv.setPadding(0, -alG, 0, 0);
        }
        this.alw = (ImageView) findViewById(R.id.ala_location_icon);
        this.alx = (TextView) findViewById(R.id.ala_location);
        this.alD = findViewById(R.id.user_name_and_reply_time);
        this.alE = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.alz = (RelativeLayout) findViewById(R.id.suffix_container);
        this.alA = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.alp.getHeadView().setPlaceHolder(1);
            if (this.alq != null) {
                ap.a(this.alq, R.raw.card_live_header_bg);
            }
            if (this.alF.getVisibility() == 0) {
                WebPManager.a(this.alF, R.drawable.ic_icon_mask_shang22_n, (WebPManager.ResourceStateType) null);
            }
        }
    }

    private void d(cb cbVar) {
        if (this.alp != null && cbVar != null && this.aiB.bnS() != null) {
            this.alp.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.alp, this.aiB.bnS(), 0)) {
                this.alp.setIsHomePage(cbVar.eVf);
                if (this.aiB.eUB > 0 && this.aiB.eUC == 0) {
                    this.alp.jY(false);
                } else {
                    this.alp.a(this.aiB.bnS(), 0);
                }
            }
        }
    }

    public void setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
        } else if (c(cbVar)) {
            setVisibility(4);
        } else {
            this.aiB = cbVar;
            f(cbVar);
            g(cbVar);
            l(cbVar);
            m(cbVar);
            i(cbVar);
            k(cbVar);
            d(cbVar);
            n(cbVar);
            o(cbVar);
            j(cbVar);
            h(cbVar);
            e(cbVar);
            setVisibility(0);
            if (isShow(128) && !cbVar.eVf && !cbVar.bpM()) {
                this.alD.post(this.alI);
            }
        }
    }

    private void e(cb cbVar) {
        if (isShow(4096) && cbVar != null && this.alA != null) {
            if (cbVar.eVb) {
                this.alA.setVisibility(0);
            } else {
                this.alA.setVisibility(8);
            }
        }
    }

    private void f(cb cbVar) {
        if (cbVar != null && cbVar.bnS() != null) {
            if (cbVar.blw()) {
                this.alH |= 4096;
            } else {
                this.alH &= -4097;
            }
            if (!(cbVar instanceof AdvertAppInfo) && ((cbVar.eVf && !cbVar.bmB() && !cbVar.bpW() && cbVar.getType() != cb.eSm && cbVar.getType() != cb.eSp) || (cbVar.eVf && d.biZ() && cbVar.getType() != cb.eSm && cbVar.getType() != cb.eSp))) {
                this.alH &= -129;
            } else {
                this.alH |= 128;
            }
            setShowFlag(this.alH);
        }
    }

    private void g(cb cbVar) {
        if (cbVar.bnS() == null) {
            this.alp.setVisibility(8);
            return;
        }
        MetaData bnS = cbVar.bnS();
        if (!isShow(256)) {
            bnS.setPendantData(null);
        }
        this.alp.setData(cbVar);
    }

    private void h(cb cbVar) {
        if (!isShow(32768)) {
            this.alq.setVisibility(8);
            if (this.alq.isAnimating()) {
                this.alq.cancelAnimation();
            }
            this.alp.setIsclearmode(false);
            this.alF.setVisibility(8);
            return;
        }
        boolean z = (cbVar == null || cbVar.bnS() == null || cbVar.bnS().getAlaUserData() == null || cbVar.bnS().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (cbVar == null || cbVar.bol() == null || cbVar.bol().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.alp.setIsclearmode(true);
            if (cbVar != null && cbVar.bnS() != null && cbVar.bnS().isOfficial()) {
                this.alF.setVisibility(0);
                ap.setImageResource(this.alF, R.drawable.ic_icon_mask_shang22_n);
            }
            this.alH &= -257;
            g(cbVar);
            this.alq.setSpeed(0.8f);
            this.alq.setVisibility(0);
            this.alq.loop(true);
            this.alq.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.alq.playAnimation();
                }
            });
            return;
        }
        this.alq.setVisibility(8);
        this.alq.cancelAnimation();
        this.alp.setIsclearmode(false);
        this.alF.setVisibility(8);
    }

    private void i(cb cbVar) {
        if (this.alr != null && cbVar != null) {
            if (cbVar.eVf || cbVar.bpM()) {
                ViewGroup.LayoutParams layoutParams = this.alD.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.alD.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.alE.getLayoutParams();
                layoutParams2.width = -1;
                this.alE.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.alr.getLayoutParams();
                layoutParams3.width = -1;
                this.alr.setLayoutParams(layoutParams3);
                this.alr.setEllipsize(TextUtils.TruncateAt.END);
                if (cbVar.bnS() != null && !StringUtils.isNull(cbVar.bnS().getName_show())) {
                    this.alr.setText(cbVar.bnS().getName_show());
                } else {
                    this.alr.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.aiB.bnp())) {
                this.alr.setText(this.aiB.bnp());
            } else {
                this.alr.setText(R.string.user_name_default_txt);
            }
            b.g(this.alr);
            tA();
        }
    }

    protected void j(cb cbVar) {
        if (this.aly != null) {
            if (cbVar == null || (!isShow(8) && !isShow(512))) {
                this.aly.setVisibility(8);
            } else if (this.aiB.getType() == cb.eTQ) {
                this.aly.setVisibility(0);
                this.aly.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.aly, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(cbVar.blq())) {
                    this.aly.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aly.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.aly.setLayoutParams(layoutParams);
                }
                this.aly.setText(cbVar.blq());
                this.aly.setVisibility(0);
            } else if (StringUtils.isNull(this.aiB.bnr())) {
                this.aly.setVisibility(8);
            } else {
                this.aly.setVisibility(0);
                this.aly.setText(this.aiB.bnr());
            }
        }
    }

    private void k(cb cbVar) {
        if (this.alt != null) {
            if (!isShow(32)) {
                this.alt.setVisibility(8);
            } else if (cbVar == null || cbVar.bnS() == null || (cbVar.eUB > 0 && cbVar.eUC == 0)) {
                this.alt.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = cbVar.bnS().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.alt.setVisibility(0);
                    this.alt.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.alt.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void tA() {
        if (this.aiB != null && this.aiB.bnS() != null) {
            if (this.aiB.eUB > 0 && this.aiB.eUC == 0) {
                ap.setViewTextColor(this.alr, R.color.CAM_X0106);
                b.h(this.alr);
            } else if (!y.isEmpty(this.aiB.bnS().getTShowInfoNew()) || this.aiB.bpW()) {
                ap.setViewTextColor(this.alr, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.alr, R.color.CAM_X0106);
                b.h(this.alr);
            }
        }
    }

    private void l(cb cbVar) {
        if (this.alu != null && cbVar != null && cbVar.bnS() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = cbVar.bnS().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.alu.setVisibility(0);
                this.alu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.alu.setVisibility(8);
        }
    }

    private void m(cb cbVar) {
        if (this.als != null && cbVar != null && cbVar.bnS() != null && isShow(16)) {
            MetaData bnS = cbVar.bnS();
            if (this.als.getLayoutParams() != null) {
                this.als.getLayoutParams().width = -2;
            }
            this.als.setOnClickListener(null);
            if (bnS.getIs_bawu() == 1) {
                c.br(this.als).nZ(R.color.CAM_X0101).om(R.string.A_X04).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (cbVar.eUP) {
                    this.als.setVisibility(0);
                    this.als.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                    this.als.setVisibility(0);
                    this.als.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_member_xbazhu_tip);
                    this.als.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_content_assist_tip);
                    this.als.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnS.getBawu_type())) {
                    this.als.setText(R.string.bawu_manage_assist_tip);
                    this.als.setVisibility(0);
                    return;
                } else {
                    this.als.setVisibility(8);
                    return;
                }
            }
            this.als.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.alp;
    }

    public View getUserName() {
        return this.alr;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.alB = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.alC = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.alp != null) {
            this.alp.setPageId(bdUniqueId);
        }
    }

    private void n(cb cbVar) {
        if (this.alv != null) {
            if (cbVar == null || TextUtils.isEmpty(cbVar.bnq())) {
                this.alv.setVisibility(8);
                return;
            }
            if (cbVar.bnS() != null && cbVar.bnS().isBaijiahaoUser()) {
                this.alv.setLines(1);
                this.alv.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.alv.setMaxLines(Integer.MAX_VALUE);
                this.alv.setEllipsize(null);
            }
            ap.setViewTextColor(this.alv, R.color.CAM_X0109);
            this.alv.setText(cbVar.bnq());
            this.alv.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(cb cbVar) {
        String address;
        boolean z = true;
        dj("");
        if (cbVar != null) {
            if ((cbVar.getType() == cb.eSm || cbVar.getType() == cb.eSp) && cbVar.bol() != null && cbVar.bol().openRecomLocation != 0) {
                String latitude = cbVar.getLatitude();
                String boh = cbVar.boh();
                boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(boh);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dEz = com.baidu.tieba.recapp.c.a.dEu().dEz();
                    String str = dEz.latitude;
                    String str2 = dEz.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(com.baidu.adp.lib.f.b.toDouble(str, 0.0d), com.baidu.adp.lib.f.b.toDouble(str2, 0.0d), com.baidu.adp.lib.f.b.toDouble(latitude, 0.0d), com.baidu.adp.lib.f.b.toDouble(boh, 0.0d));
                        if (GetDistance <= 50.0d) {
                            address = au.p(GetDistance);
                        } else {
                            address = cbVar.getAddress();
                        }
                    }
                    address = "";
                } else {
                    if (z2) {
                        address = cbVar.getAddress();
                    }
                    address = "";
                }
                dj(address);
            }
        }
    }

    private void dj(String str) {
        boolean z = !StringUtils.isNull(str);
        this.alw.setVisibility(z ? 0 : 8);
        this.alx.setVisibility(z ? 0 : 8);
        if (z) {
            this.alx.setText(str);
            SvgManager.bsU().a(this.alw, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.alx, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tB() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.alr.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.aly.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.alr.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.aiB.bnS().getName_show(), 12)) + this.alr.getPaddingLeft() + this.alr.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.aiB.bnS().getName_show(), 10)) + this.alr.getPaddingLeft() + this.alr.getPaddingRight();
            int measuredWidth = this.alu.getMeasuredWidth();
            int measuredWidth2 = this.alr.getMeasuredWidth();
            int measuredWidth3 = this.aly.getMeasuredWidth();
            int measuredWidth4 = this.als.getMeasuredWidth();
            int measuredWidth5 = this.alt.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.alr.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.alr.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.alr.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.alt.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.als.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.alu.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.aly.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.aiB != null && this.aiB.bnS() != null && this.aiB.bnS().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.aiB.bnS().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.alv.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.alz;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnS() == null || !cbVar.eVg || !d.bji() || cbVar.bnS().hadConcerned() || az.x(cbVar)) ? false : true;
    }
}

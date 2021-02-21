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
    private static final int akn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private cb ahi;
    private HeadPendantClickableView ajW;
    private TBLottieAnimationView ajX;
    private TextView ajY;
    private TextView ajZ;
    private UserIconBox aka;
    private UserIconBox akb;
    private TextView akc;
    private ImageView akd;
    private TextView ake;
    private TextView akf;
    protected RelativeLayout akg;
    private ImageView akh;
    private View.OnClickListener aki;
    private View.OnClickListener akj;
    private View akk;
    private View akl;
    private ImageView akm;
    private int ako;
    private Runnable akp;
    private View.OnClickListener akq;
    private View.OnClickListener akr;
    private View.OnClickListener aks;
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
        this.ako = 34053;
        this.akp = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.tB();
            }
        };
        this.akq = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bh.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.ahi != null && CardUserInfoLayout.this.ahi.bnQ() != null && CardUserInfoLayout.this.ahi.bnQ().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.ahi.bnQ().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.ahi.bnQ().getTShowInfoNew().get(0).getUrl()) != null && (j.K(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bf.bsV().b((TbPageContext) j.K(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akr = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahi != null && CardUserInfoLayout.this.ahi.bnQ() != null && !StringUtils.isNull(CardUserInfoLayout.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.ahi.bnQ().getUserId()) && CardUserInfoLayout.this.ahi.bnU() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bh.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.ahi.bnQ().getUserId(), CardUserInfoLayout.this.ahi.bnQ().getName_show(), CardUserInfoLayout.this.ahi.bnU(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.ahi.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.aki != null) {
                        CardUserInfoLayout.this.aki.onClick(view);
                    }
                }
            }
        };
        this.aks = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahi != null && CardUserInfoLayout.this.ahi.bnQ() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.ahi.bnQ().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.akj != null) {
                        CardUserInfoLayout.this.aki.onClick(view);
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
        this.ako = i;
        ty();
    }

    private void ty() {
        this.akb.setVisibility(isShow(1) ? 0 : 8);
        this.ajY.setVisibility(isShow(4) ? 0 : 8);
        this.ajZ.setVisibility(isShow(16) ? 0 : 8);
        this.akf.setVisibility(isShow(8) ? 0 : 8);
        this.aka.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akk.getLayoutParams();
        if (isShow(128)) {
            this.akc.setVisibility(0);
        } else {
            this.akc.setVisibility(8);
        }
        this.akk.setLayoutParams(layoutParams);
        this.akh.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ako & i) > 0;
    }

    private void tz() {
        this.ajW = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.ajW.setHasPendantStyle();
        this.ajW.getHeadView().setIsRound(true);
        this.ajW.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajW.getHeadView().setDefaultResource(17170445);
        this.ajW.getHeadView().setPlaceHolder(1);
        this.ajW.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aki != null) {
                    CardUserInfoLayout.this.aki.onClick(view);
                }
            }
        });
        this.ajX = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.akm = (ImageView) findViewById(R.id.img_official_v);
        this.akb = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.akb.setOnClickListener(this.akq);
        this.ajY = (TextView) findViewById(R.id.user_name);
        this.ajY.setOnClickListener(this.akr);
        this.ajZ = (TextView) findViewById(R.id.identity_view);
        this.akf = (TextView) findViewById(R.id.thread_share_intro);
        this.aka = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.aka.setOnClickListener(this.aks);
        this.aka.setAutoChangedStyle(false);
        this.akc = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bse()) {
            this.akc.setPadding(0, -akn, 0, 0);
        }
        this.akd = (ImageView) findViewById(R.id.ala_location_icon);
        this.ake = (TextView) findViewById(R.id.ala_location);
        this.akk = findViewById(R.id.user_name_and_reply_time);
        this.akl = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.akg = (RelativeLayout) findViewById(R.id.suffix_container);
        this.akh = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.ajW.getHeadView().setPlaceHolder(1);
            if (this.ajX != null) {
                ap.a(this.ajX, R.raw.card_live_header_bg);
            }
            if (this.akm.getVisibility() == 0) {
                WebPManager.a(this.akm, R.drawable.ic_icon_mask_shang22_n, (WebPManager.ResourceStateType) null);
            }
        }
    }

    private void d(cb cbVar) {
        if (this.ajW != null && cbVar != null && this.ahi.bnQ() != null) {
            this.ajW.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.ajW, this.ahi.bnQ(), 0)) {
                this.ajW.setIsHomePage(cbVar.eTE);
                if (this.ahi.eTa > 0 && this.ahi.eTb == 0) {
                    this.ajW.jY(false);
                } else {
                    this.ajW.a(this.ahi.bnQ(), 0);
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
            this.ahi = cbVar;
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
            if (isShow(128) && !cbVar.eTE && !cbVar.bpK()) {
                this.akk.post(this.akp);
            }
        }
    }

    private void e(cb cbVar) {
        if (isShow(4096) && cbVar != null && this.akh != null) {
            if (cbVar.eTA) {
                this.akh.setVisibility(0);
            } else {
                this.akh.setVisibility(8);
            }
        }
    }

    private void f(cb cbVar) {
        if (cbVar != null && cbVar.bnQ() != null) {
            if (cbVar.blu()) {
                this.ako |= 4096;
            } else {
                this.ako &= -4097;
            }
            if (!(cbVar instanceof AdvertAppInfo) && ((cbVar.eTE && !cbVar.bmz() && !cbVar.bpU() && cbVar.getType() != cb.eQL && cbVar.getType() != cb.eQO) || (cbVar.eTE && d.biX() && cbVar.getType() != cb.eQL && cbVar.getType() != cb.eQO))) {
                this.ako &= -129;
            } else {
                this.ako |= 128;
            }
            setShowFlag(this.ako);
        }
    }

    private void g(cb cbVar) {
        if (cbVar.bnQ() == null) {
            this.ajW.setVisibility(8);
            return;
        }
        MetaData bnQ = cbVar.bnQ();
        if (!isShow(256)) {
            bnQ.setPendantData(null);
        }
        this.ajW.setData(cbVar);
    }

    private void h(cb cbVar) {
        if (!isShow(32768)) {
            this.ajX.setVisibility(8);
            if (this.ajX.isAnimating()) {
                this.ajX.cancelAnimation();
            }
            this.ajW.setIsclearmode(false);
            this.akm.setVisibility(8);
            return;
        }
        boolean z = (cbVar == null || cbVar.bnQ() == null || cbVar.bnQ().getAlaUserData() == null || cbVar.bnQ().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (cbVar == null || cbVar.boj() == null || cbVar.boj().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.ajW.setIsclearmode(true);
            if (cbVar != null && cbVar.bnQ() != null && cbVar.bnQ().isOfficial()) {
                this.akm.setVisibility(0);
                ap.setImageResource(this.akm, R.drawable.ic_icon_mask_shang22_n);
            }
            this.ako &= -257;
            g(cbVar);
            this.ajX.setSpeed(0.8f);
            this.ajX.setVisibility(0);
            this.ajX.loop(true);
            this.ajX.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.ajX.playAnimation();
                }
            });
            return;
        }
        this.ajX.setVisibility(8);
        this.ajX.cancelAnimation();
        this.ajW.setIsclearmode(false);
        this.akm.setVisibility(8);
    }

    private void i(cb cbVar) {
        if (this.ajY != null && cbVar != null) {
            if (cbVar.eTE || cbVar.bpK()) {
                ViewGroup.LayoutParams layoutParams = this.akk.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.akk.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.akl.getLayoutParams();
                layoutParams2.width = -1;
                this.akl.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ajY.getLayoutParams();
                layoutParams3.width = -1;
                this.ajY.setLayoutParams(layoutParams3);
                this.ajY.setEllipsize(TextUtils.TruncateAt.END);
                if (cbVar.bnQ() != null && !StringUtils.isNull(cbVar.bnQ().getName_show())) {
                    this.ajY.setText(cbVar.bnQ().getName_show());
                } else {
                    this.ajY.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.ahi.bnn())) {
                this.ajY.setText(this.ahi.bnn());
            } else {
                this.ajY.setText(R.string.user_name_default_txt);
            }
            b.g(this.ajY);
            tA();
        }
    }

    protected void j(cb cbVar) {
        if (this.akf != null) {
            if (cbVar == null || (!isShow(8) && !isShow(512))) {
                this.akf.setVisibility(8);
            } else if (this.ahi.getType() == cb.eSp) {
                this.akf.setVisibility(0);
                this.akf.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.akf, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(cbVar.blo())) {
                    this.akf.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akf.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.akf.setLayoutParams(layoutParams);
                }
                this.akf.setText(cbVar.blo());
                this.akf.setVisibility(0);
            } else if (StringUtils.isNull(this.ahi.bnp())) {
                this.akf.setVisibility(8);
            } else {
                this.akf.setVisibility(0);
                this.akf.setText(this.ahi.bnp());
            }
        }
    }

    private void k(cb cbVar) {
        if (this.aka != null) {
            if (!isShow(32)) {
                this.aka.setVisibility(8);
            } else if (cbVar == null || cbVar.bnQ() == null || (cbVar.eTa > 0 && cbVar.eTb == 0)) {
                this.aka.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = cbVar.bnQ().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.aka.setVisibility(0);
                    this.aka.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.aka.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return au.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void tA() {
        if (this.ahi != null && this.ahi.bnQ() != null) {
            if (this.ahi.eTa > 0 && this.ahi.eTb == 0) {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0106);
                b.h(this.ajY);
            } else if (!y.isEmpty(this.ahi.bnQ().getTShowInfoNew()) || this.ahi.bpU()) {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0301);
            } else {
                ap.setViewTextColor(this.ajY, R.color.CAM_X0106);
                b.h(this.ajY);
            }
        }
    }

    private void l(cb cbVar) {
        if (this.akb != null && cbVar != null && cbVar.bnQ() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = cbVar.bnQ().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.akb.setVisibility(0);
                this.akb.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akb.setVisibility(8);
        }
    }

    private void m(cb cbVar) {
        if (this.ajZ != null && cbVar != null && cbVar.bnQ() != null && isShow(16)) {
            MetaData bnQ = cbVar.bnQ();
            if (this.ajZ.getLayoutParams() != null) {
                this.ajZ.getLayoutParams().width = -2;
            }
            this.ajZ.setOnClickListener(null);
            if (bnQ.getIs_bawu() == 1) {
                c.br(this.ajZ).nY(R.color.CAM_X0101).ol(R.string.A_X04).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (cbVar.eTo) {
                    this.ajZ.setVisibility(0);
                    this.ajZ.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                    this.ajZ.setVisibility(0);
                    this.ajZ.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_content_assist_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnQ.getBawu_type())) {
                    this.ajZ.setText(R.string.bawu_manage_assist_tip);
                    this.ajZ.setVisibility(0);
                    return;
                } else {
                    this.ajZ.setVisibility(8);
                    return;
                }
            }
            this.ajZ.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.ajW;
    }

    public View getUserName() {
        return this.ajY;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aki = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.akj = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajW != null) {
            this.ajW.setPageId(bdUniqueId);
        }
    }

    private void n(cb cbVar) {
        if (this.akc != null) {
            if (cbVar == null || TextUtils.isEmpty(cbVar.bno())) {
                this.akc.setVisibility(8);
                return;
            }
            if (cbVar.bnQ() != null && cbVar.bnQ().isBaijiahaoUser()) {
                this.akc.setLines(1);
                this.akc.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.akc.setMaxLines(Integer.MAX_VALUE);
                this.akc.setEllipsize(null);
            }
            ap.setViewTextColor(this.akc, R.color.CAM_X0109);
            this.akc.setText(cbVar.bno());
            this.akc.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(cb cbVar) {
        String address;
        boolean z = true;
        df("");
        if (cbVar != null) {
            if ((cbVar.getType() == cb.eQL || cbVar.getType() == cb.eQO) && cbVar.boj() != null && cbVar.boj().openRecomLocation != 0) {
                String latitude = cbVar.getLatitude();
                String bof = cbVar.bof();
                boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bof);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dEr = com.baidu.tieba.recapp.c.a.dEm().dEr();
                    String str = dEr.latitude;
                    String str2 = dEr.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(com.baidu.adp.lib.f.b.toDouble(str, 0.0d), com.baidu.adp.lib.f.b.toDouble(str2, 0.0d), com.baidu.adp.lib.f.b.toDouble(latitude, 0.0d), com.baidu.adp.lib.f.b.toDouble(bof, 0.0d));
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
                df(address);
            }
        }
    }

    private void df(String str) {
        boolean z = !StringUtils.isNull(str);
        this.akd.setVisibility(z ? 0 : 8);
        this.ake.setVisibility(z ? 0 : 8);
        if (z) {
            this.ake.setText(str);
            SvgManager.bsR().a(this.akd, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.ake, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tB() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ajY.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.akf.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ajY.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.ahi.bnQ().getName_show(), 12)) + this.ajY.getPaddingLeft() + this.ajY.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.ahi.bnQ().getName_show(), 10)) + this.ajY.getPaddingLeft() + this.ajY.getPaddingRight();
            int measuredWidth = this.akb.getMeasuredWidth();
            int measuredWidth2 = this.ajY.getMeasuredWidth();
            int measuredWidth3 = this.akf.getMeasuredWidth();
            int measuredWidth4 = this.ajZ.getMeasuredWidth();
            int measuredWidth5 = this.aka.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ajY.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ajY.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ajY.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.aka.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ajZ.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.akb.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.akf.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.ahi != null && this.ahi.bnQ() != null && this.ahi.bnQ().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.ahi.bnQ().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.akc.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.akg;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(cb cbVar) {
        return (cbVar == null || cbVar.bnQ() == null || !cbVar.eTF || !d.bjg() || cbVar.bnQ().hadConcerned() || az.x(cbVar)) ? false : true;
    }
}

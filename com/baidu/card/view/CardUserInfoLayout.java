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
    private static final int aky = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bz ahu;
    private Runnable akA;
    private View.OnClickListener akB;
    private View.OnClickListener akC;
    private View.OnClickListener akD;
    private HeadPendantClickableView akh;
    private TBLottieAnimationView aki;
    private TextView akj;
    private TextView akk;
    private UserIconBox akl;
    private UserIconBox akm;
    private TextView akn;
    private ImageView ako;
    private TextView akp;
    private TextView akq;
    protected RelativeLayout akr;
    private ImageView aks;
    private View.OnClickListener akt;
    private View.OnClickListener aku;
    private View akv;
    private View akw;
    private ImageView akx;
    private int akz;
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
        this.akz = 34053;
        this.akA = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.tE();
            }
        };
        this.akB = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.ahu != null && CardUserInfoLayout.this.ahu.bnx() != null && CardUserInfoLayout.this.ahu.bnx().getTShowInfoNew() != null && x.getItem(CardUserInfoLayout.this.ahu.bnx().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.ahu.bnx().getTShowInfoNew().get(0).getUrl()) != null && (j.K(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bsB().b((TbPageContext) j.K(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.akC = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahu != null && CardUserInfoLayout.this.ahu.bnx() != null && !StringUtils.isNull(CardUserInfoLayout.this.ahu.bnx().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.ahu.bnx().getUserId()) && CardUserInfoLayout.this.ahu.bnB() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.ahu.bnx().getUserId(), CardUserInfoLayout.this.ahu.bnx().getName_show(), CardUserInfoLayout.this.ahu.bnB(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.ahu.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.akt != null) {
                        CardUserInfoLayout.this.akt.onClick(view);
                    }
                }
            }
        };
        this.akD = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ahu != null && CardUserInfoLayout.this.ahu.bnx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.ahu.bnx().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.aku != null) {
                        CardUserInfoLayout.this.akt.onClick(view);
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
        tC();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.akz = i;
        tB();
    }

    private void tB() {
        this.akm.setVisibility(isShow(1) ? 0 : 8);
        this.akj.setVisibility(isShow(4) ? 0 : 8);
        this.akk.setVisibility(isShow(16) ? 0 : 8);
        this.akq.setVisibility(isShow(8) ? 0 : 8);
        this.akl.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akv.getLayoutParams();
        if (isShow(128)) {
            this.akn.setVisibility(0);
        } else {
            this.akn.setVisibility(8);
        }
        this.akv.setLayoutParams(layoutParams);
        this.aks.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.akz & i) > 0;
    }

    private void tC() {
        this.akh = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.akh.setHasPendantStyle();
        this.akh.getHeadView().setIsRound(true);
        this.akh.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.akh.getHeadView().setDefaultResource(17170445);
        this.akh.getHeadView().setPlaceHolder(1);
        this.akh.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.akt != null) {
                    CardUserInfoLayout.this.akt.onClick(view);
                }
            }
        });
        this.aki = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.akx = (ImageView) findViewById(R.id.img_official_v);
        this.akm = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.akm.setOnClickListener(this.akB);
        this.akj = (TextView) findViewById(R.id.user_name);
        this.akj.setOnClickListener(this.akC);
        this.akk = (TextView) findViewById(R.id.identity_view);
        this.akq = (TextView) findViewById(R.id.thread_share_intro);
        this.akl = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.akl.setOnClickListener(this.akD);
        this.akl.setAutoChangedStyle(false);
        this.akn = (TextView) findViewById(R.id.thread_extend_info);
        if (g.brK()) {
            this.akn.setPadding(0, -aky, 0, 0);
        }
        this.ako = (ImageView) findViewById(R.id.ala_location_icon);
        this.akp = (TextView) findViewById(R.id.ala_location);
        this.akv = findViewById(R.id.user_name_and_reply_time);
        this.akw = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.akr = (RelativeLayout) findViewById(R.id.suffix_container);
        this.aks = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.akh.getHeadView().setPlaceHolder(1);
            if (this.aki != null) {
                ao.a(this.aki, R.raw.card_live_header_bg);
            }
            if (this.akx.getVisibility() == 0) {
                WebPManager.a(this.akx, R.drawable.ic_icon_mask_shang22_n, (WebPManager.ResourceStateType) null);
            }
        }
    }

    private void d(bz bzVar) {
        if (this.akh != null && bzVar != null && this.ahu.bnx() != null) {
            this.akh.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.akh, this.ahu.bnx(), 0)) {
                this.akh.setIsHomePage(bzVar.eRs);
                if (this.ahu.eQO > 0 && this.ahu.eQP == 0) {
                    this.akh.jV(false);
                } else {
                    this.akh.a(this.ahu.bnx(), 0);
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
            this.ahu = bzVar;
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
            if (isShow(128) && !bzVar.eRs && !bzVar.bps()) {
                this.akv.post(this.akA);
            }
        }
    }

    private void e(bz bzVar) {
        if (isShow(4096) && bzVar != null && this.aks != null) {
            if (bzVar.eRo) {
                this.aks.setVisibility(0);
            } else {
                this.aks.setVisibility(8);
            }
        }
    }

    private void f(bz bzVar) {
        if (bzVar != null && bzVar.bnx() != null) {
            if (bzVar.blc()) {
                this.akz |= 4096;
            } else {
                this.akz &= -4097;
            }
            if (!(bzVar instanceof AdvertAppInfo) && ((bzVar.eRs && !bzVar.bmg() && !bzVar.bpC() && bzVar.getType() != bz.eOz && bzVar.getType() != bz.eOC) || (bzVar.eRs && d.biL() && bzVar.getType() != bz.eOz && bzVar.getType() != bz.eOC))) {
                this.akz &= -129;
            } else {
                this.akz |= 128;
            }
            setShowFlag(this.akz);
        }
    }

    private void g(bz bzVar) {
        if (bzVar.bnx() == null) {
            this.akh.setVisibility(8);
            return;
        }
        MetaData bnx = bzVar.bnx();
        if (!isShow(256)) {
            bnx.setPendantData(null);
        }
        this.akh.setData(bzVar);
    }

    private void h(bz bzVar) {
        if (!isShow(32768)) {
            this.aki.setVisibility(8);
            if (this.aki.isAnimating()) {
                this.aki.cancelAnimation();
            }
            this.akh.setIsclearmode(false);
            this.akx.setVisibility(8);
            return;
        }
        boolean z = (bzVar == null || bzVar.bnx() == null || bzVar.bnx().getAlaUserData() == null || bzVar.bnx().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (bzVar == null || bzVar.bnQ() == null || bzVar.bnQ().friendRoomStatus != 2) ? false : true;
        if (z || z2) {
            this.akh.setIsclearmode(true);
            if (bzVar != null && bzVar.bnx() != null && bzVar.bnx().isOfficial()) {
                this.akx.setVisibility(0);
                ao.setImageResource(this.akx, R.drawable.ic_icon_mask_shang22_n);
            }
            this.akz &= -257;
            g(bzVar);
            this.aki.setSpeed(0.8f);
            this.aki.setVisibility(0);
            this.aki.loop(true);
            this.aki.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.aki.playAnimation();
                }
            });
            return;
        }
        this.aki.setVisibility(8);
        this.aki.cancelAnimation();
        this.akh.setIsclearmode(false);
        this.akx.setVisibility(8);
    }

    private void i(bz bzVar) {
        if (this.akj != null && bzVar != null) {
            if (bzVar.eRs || bzVar.bps()) {
                ViewGroup.LayoutParams layoutParams = this.akv.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.akv.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.akw.getLayoutParams();
                layoutParams2.width = -1;
                this.akw.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.akj.getLayoutParams();
                layoutParams3.width = -1;
                this.akj.setLayoutParams(layoutParams3);
                this.akj.setEllipsize(TextUtils.TruncateAt.END);
                if (bzVar.bnx() != null && !StringUtils.isNull(bzVar.bnx().getName_show())) {
                    this.akj.setText(bzVar.bnx().getName_show());
                } else {
                    this.akj.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.ahu.bmU())) {
                this.akj.setText(this.ahu.bmU());
            } else {
                this.akj.setText(R.string.user_name_default_txt);
            }
            b.g(this.akj);
            tD();
        }
    }

    protected void j(bz bzVar) {
        if (this.akq != null) {
            if (bzVar == null || (!isShow(8) && !isShow(512))) {
                this.akq.setVisibility(8);
            } else if (this.ahu.getType() == bz.eQd) {
                this.akq.setVisibility(0);
                this.akq.getPaint().setFakeBoldText(true);
                ao.setViewTextColor(this.akq, R.color.CAM_X0105);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bzVar.bkW())) {
                    this.akq.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akq.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.akq.setLayoutParams(layoutParams);
                }
                this.akq.setText(bzVar.bkW());
                this.akq.setVisibility(0);
            } else if (StringUtils.isNull(this.ahu.bmW())) {
                this.akq.setVisibility(8);
            } else {
                this.akq.setVisibility(0);
                this.akq.setText(this.ahu.bmW());
            }
        }
    }

    private void k(bz bzVar) {
        if (this.akl != null) {
            if (!isShow(32)) {
                this.akl.setVisibility(8);
            } else if (bzVar == null || bzVar.bnx() == null || (bzVar.eQO > 0 && bzVar.eQP == 0)) {
                this.akl.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bzVar.bnx().getIconInfo();
                if (x.getCount(iconInfo) != 0) {
                    this.akl.setVisibility(0);
                    this.akl.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.akl.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void tD() {
        if (this.ahu != null && this.ahu.bnx() != null) {
            if (this.ahu.eQO > 0 && this.ahu.eQP == 0) {
                ao.setViewTextColor(this.akj, R.color.CAM_X0106);
                b.h(this.akj);
            } else if (!x.isEmpty(this.ahu.bnx().getTShowInfoNew()) || this.ahu.bpC()) {
                ao.setViewTextColor(this.akj, R.color.CAM_X0301);
            } else {
                ao.setViewTextColor(this.akj, R.color.CAM_X0106);
                b.h(this.akj);
            }
        }
    }

    private void l(bz bzVar) {
        if (this.akm != null && bzVar != null && bzVar.bnx() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bzVar.bnx().getTShowInfoNew();
            if (x.getCount(tShowInfoNew) != 0) {
                this.akm.setVisibility(0);
                this.akm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.akm.setVisibility(8);
        }
    }

    private void m(bz bzVar) {
        if (this.akk != null && bzVar != null && bzVar.bnx() != null && isShow(16)) {
            MetaData bnx = bzVar.bnx();
            if (this.akk.getLayoutParams() != null) {
                this.akk.getLayoutParams().width = -2;
            }
            this.akk.setOnClickListener(null);
            if (bnx.getIs_bawu() == 1) {
                c.bv(this.akk).nV(R.color.CAM_X0101).oh(R.string.A_X04).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (bzVar.eRc) {
                    this.akk.setVisibility(0);
                    this.akk.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                    this.akk.setVisibility(0);
                    this.akk.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_member_xbazhu_tip);
                    this.akk.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_content_assist_tip);
                    this.akk.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bnx.getBawu_type())) {
                    this.akk.setText(R.string.bawu_manage_assist_tip);
                    this.akk.setVisibility(0);
                    return;
                } else {
                    this.akk.setVisibility(8);
                    return;
                }
            }
            this.akk.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.akh;
    }

    public View getUserName() {
        return this.akj;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.akh != null) {
            this.akh.setPageId(bdUniqueId);
        }
    }

    private void n(bz bzVar) {
        if (this.akn != null) {
            if (bzVar == null || TextUtils.isEmpty(bzVar.bmV())) {
                this.akn.setVisibility(8);
                return;
            }
            if (bzVar.bnx() != null && bzVar.bnx().isBaijiahaoUser()) {
                this.akn.setLines(1);
                this.akn.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.akn.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.akn.setEllipsize(null);
            }
            ao.setViewTextColor(this.akn, R.color.CAM_X0109);
            this.akn.setText(bzVar.bmV());
            this.akn.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bz bzVar) {
        String address;
        boolean z = true;
        df("");
        if (bzVar != null) {
            if ((bzVar.getType() == bz.eOz || bzVar.getType() == bz.eOC) && bzVar.bnQ() != null && bzVar.bnQ().openRecomLocation != 0) {
                String latitude = bzVar.getLatitude();
                String bnM = bzVar.bnM();
                boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bnM);
                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                if (z2 && isSystemLocationProviderEnabled) {
                    AppPosInfo dCb = com.baidu.tieba.recapp.c.a.dBW().dCb();
                    String str = dCb.latitude;
                    String str2 = dCb.longitude;
                    if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                        z = false;
                    }
                    if (z) {
                        double GetDistance = l.GetDistance(com.baidu.adp.lib.f.b.toDouble(str, 0.0d), com.baidu.adp.lib.f.b.toDouble(str2, 0.0d), com.baidu.adp.lib.f.b.toDouble(latitude, 0.0d), com.baidu.adp.lib.f.b.toDouble(bnM, 0.0d));
                        if (GetDistance <= 50.0d) {
                            address = at.p(GetDistance);
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
                df(address);
            }
        }
    }

    private void df(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ako.setVisibility(z ? 0 : 8);
        this.akp.setVisibility(z ? 0 : 8);
        if (z) {
            this.akp.setText(str);
            SvgManager.bsx().a(this.ako, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
            ao.setViewTextColor(this.akp, R.color.CAM_X0109);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tE() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.akj.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.akq.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.akj.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.ahu.bnx().getName_show(), 12)) + this.akj.getPaddingLeft() + this.akj.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.ahu.bnx().getName_show(), 10)) + this.akj.getPaddingLeft() + this.akj.getPaddingRight();
            int measuredWidth = this.akm.getMeasuredWidth();
            int measuredWidth2 = this.akj.getMeasuredWidth();
            int measuredWidth3 = this.akq.getMeasuredWidth();
            int measuredWidth4 = this.akk.getMeasuredWidth();
            int measuredWidth5 = this.akl.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.akj.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.akj.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.akj.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.akl.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.akk.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.akm.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.akq.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.ahu != null && this.ahu.bnx() != null && this.ahu.bnx().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
                if (!this.ahu.bnx().hadConcerned()) {
                    i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
                }
            }
            this.akn.setMaxWidth(i2);
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.akr;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bz bzVar) {
        return (bzVar == null || bzVar.bnx() == null || !bzVar.eRt || !d.biU() || bzVar.bnx().hadConcerned() || ay.x(bzVar)) ? false : true;
    }
}

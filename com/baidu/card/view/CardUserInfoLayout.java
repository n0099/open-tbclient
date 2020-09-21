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
/* loaded from: classes20.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    private static final int ajr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private bw agf;
    private HeadPendantClickableView aiZ;
    private TBLottieAnimationView aja;
    private TextView ajb;
    private TextView ajc;
    private UserIconBox ajd;
    private UserIconBox aje;
    private TextView ajf;
    private ImageView ajg;
    private TextView ajh;
    private TextView aji;
    protected RelativeLayout ajj;
    private ImageView ajk;
    private LayerDrawable ajl;
    private LayerDrawable ajm;
    private View.OnClickListener ajn;
    private View.OnClickListener ajo;
    private View ajp;
    private View ajq;
    private int ajs;
    private Runnable ajt;
    private View.OnClickListener aju;
    private View.OnClickListener ajv;
    private View.OnClickListener ajw;
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
        this.ajs = 34053;
        this.ajt = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.un();
            }
        };
        this.aju = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bg.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.agf != null && CardUserInfoLayout.this.agf.bfy() != null && CardUserInfoLayout.this.agf.bfy().getTShowInfoNew() != null && y.getItem(CardUserInfoLayout.this.agf.bfy().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.agf.bfy().getTShowInfoNew().get(0).getUrl()) != null && (i.I(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    be.bkp().b((TbPageContext) i.I(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ajv = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agf != null && CardUserInfoLayout.this.agf.bfy() != null && !StringUtils.isNull(CardUserInfoLayout.this.agf.bfy().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.agf.bfy().getUserId()) && CardUserInfoLayout.this.agf.bfC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bg.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.agf.bfy().getUserId(), CardUserInfoLayout.this.agf.bfy().getName_show(), CardUserInfoLayout.this.agf.bfC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.agf.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.ajn != null) {
                        CardUserInfoLayout.this.ajn.onClick(view);
                    }
                }
            }
        };
        this.ajw = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agf != null && CardUserInfoLayout.this.agf.bfy() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.agf.bfy().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ajo != null) {
                        CardUserInfoLayout.this.ajn.onClick(view);
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
        this.ajs = i;
        uk();
    }

    private void uk() {
        this.aje.setVisibility(isShow(1) ? 0 : 8);
        this.ajb.setVisibility(isShow(4) ? 0 : 8);
        this.ajc.setVisibility(isShow(16) ? 0 : 8);
        this.aji.setVisibility(isShow(8) ? 0 : 8);
        this.ajd.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajp.getLayoutParams();
        if (isShow(128)) {
            this.ajf.setVisibility(0);
        } else {
            this.ajf.setVisibility(8);
        }
        this.ajp.setLayoutParams(layoutParams);
        this.ajk.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ajs & i) > 0;
    }

    private void ul() {
        this.aiZ = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.aiZ.setHasPendantStyle();
        this.aiZ.getHeadView().setIsRound(true);
        this.aiZ.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiZ.getHeadView().setDefaultResource(17170445);
        this.aiZ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.aiZ.getHeadView().setPlaceHolder(1);
        this.aiZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ajn != null) {
                    CardUserInfoLayout.this.ajn.onClick(view);
                }
            }
        });
        this.aja = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.aje = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.aje.setOnClickListener(this.aju);
        this.ajb = (TextView) findViewById(R.id.user_name);
        this.ajb.setOnClickListener(this.ajv);
        this.ajc = (TextView) findViewById(R.id.identity_view);
        this.aji = (TextView) findViewById(R.id.thread_share_intro);
        this.ajd = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.ajd.setOnClickListener(this.ajw);
        this.ajd.setAutoChangedStyle(false);
        this.ajf = (TextView) findViewById(R.id.thread_extend_info);
        if (g.bjs()) {
            this.ajf.setPadding(0, -ajr, 0, 0);
        }
        this.ajg = (ImageView) findViewById(R.id.ala_location_icon);
        this.ajh = (TextView) findViewById(R.id.ala_location);
        this.ajp = findViewById(R.id.user_name_and_reply_time);
        this.ajq = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.ajj = (RelativeLayout) findViewById(R.id.suffix_container);
        this.ajk = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.aiZ.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.ajl != null && this.ajl.getDrawable(1) != null) {
                    this.ajl.getDrawable(1).setAlpha(255);
                }
                if (this.ajm != null && this.ajm.getDrawable(1) != null) {
                    this.ajm.getDrawable(1).setAlpha(255);
                }
                if (this.aja != null) {
                    this.aja.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.aja != null) {
                    this.aja.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.ajl != null && this.ajl.getDrawable(1) != null) {
                    this.ajl.getDrawable(1).setAlpha(0);
                }
                if (this.ajm != null && this.ajm.getDrawable(1) != null) {
                    this.ajm.getDrawable(1).setAlpha(0);
                }
                if (this.aja != null) {
                    this.aja.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void d(bw bwVar) {
        if (this.aiZ != null && bwVar != null && this.agf.bfy() != null) {
            this.aiZ.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.aiZ, this.agf.bfy(), 0)) {
                this.aiZ.setIsHomePage(bwVar.egt);
                if (this.agf.efQ > 0 && this.agf.efR == 0) {
                    this.aiZ.is(false);
                } else {
                    this.aiZ.a(this.agf.bfy(), 0);
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
            this.agf = bwVar;
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
            if (isShow(128) && !bwVar.egt && !bwVar.bhq()) {
                this.ajp.post(this.ajt);
            }
        }
    }

    private void e(bw bwVar) {
        if (isShow(4096) && bwVar != null && this.ajk != null) {
            if (bwVar.egp) {
                this.ajk.setVisibility(0);
            } else {
                this.ajk.setVisibility(8);
            }
        }
    }

    private void f(bw bwVar) {
        if (bwVar != null && bwVar.bfy() != null) {
            if (bwVar.bdg()) {
                this.ajs |= 4096;
            } else {
                this.ajs &= -4097;
            }
            if ((bwVar.egt && !bwVar.bei() && !bwVar.bhz() && bwVar.getType() != bw.edD) || (bwVar.egt && com.baidu.tbadk.a.d.baT() && bwVar.getType() != bw.edD)) {
                this.ajs &= -129;
            } else {
                this.ajs |= 128;
            }
            setShowFlag(this.ajs);
        }
    }

    private void g(bw bwVar) {
        if (bwVar.bfy() == null) {
            this.aiZ.setVisibility(8);
            return;
        }
        MetaData bfy = bwVar.bfy();
        if (!isShow(256)) {
            bfy.setPendantData(null);
        }
        this.aiZ.setData(bwVar);
    }

    private void h(bw bwVar) {
        if (!isShow(32768)) {
            this.aja.setVisibility(8);
            if (this.aja.isAnimating()) {
                this.aja.cancelAnimation();
            }
            this.aiZ.setIsclearmode(false);
        } else if (bwVar != null && bwVar.bfy() != null && bwVar.bfy().getAlaUserData() != null) {
            if (bwVar.bfy().getAlaUserData().live_status != 1) {
                this.aja.setVisibility(8);
                this.aja.cancelAnimation();
                this.aiZ.setIsclearmode(false);
                return;
            }
            this.aiZ.setIsclearmode(true);
            this.ajs &= -257;
            g(bwVar);
            this.aja.setSpeed(0.8f);
            this.aja.setVisibility(0);
            this.aja.loop(true);
            this.aja.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.aja.playAnimation();
                }
            });
        } else {
            this.aja.setVisibility(8);
            this.aja.cancelAnimation();
            this.aiZ.setIsclearmode(false);
        }
    }

    private void i(bw bwVar) {
        if (this.ajb != null && bwVar != null) {
            if (bwVar.egt || bwVar.bhq()) {
                ViewGroup.LayoutParams layoutParams = this.ajp.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.ajp.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ajq.getLayoutParams();
                layoutParams2.width = -1;
                this.ajq.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ajb.getLayoutParams();
                layoutParams3.width = -1;
                this.ajb.setLayoutParams(layoutParams3);
                this.ajb.setEllipsize(TextUtils.TruncateAt.END);
                if (bwVar.bfy() != null && !StringUtils.isNull(bwVar.bfy().getName_show())) {
                    this.ajb.setText(bwVar.bfy().getName_show());
                } else {
                    this.ajb.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.agf.beV())) {
                this.ajb.setText(this.agf.beV());
            } else {
                this.ajb.setText(R.string.user_name_default_txt);
            }
            com.baidu.tbadk.a.b.a.a(this.ajb);
            um();
        }
    }

    protected void j(bw bwVar) {
        if (this.aji != null) {
            if (bwVar == null || (!isShow(8) && !isShow(512))) {
                this.aji.setVisibility(8);
            } else if (this.agf.getType() == bw.eff) {
                this.aji.setVisibility(0);
                this.aji.getPaint().setFakeBoldText(true);
                ap.setViewTextColor(this.aji, R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bwVar.bcZ())) {
                    this.aji.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aji.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.aji.setLayoutParams(layoutParams);
                }
                this.aji.setText(bwVar.bcZ());
                this.aji.setVisibility(0);
            } else if (StringUtils.isNull(this.agf.beX())) {
                this.aji.setVisibility(8);
            } else {
                this.aji.setVisibility(0);
                this.aji.setText(this.agf.beX());
            }
        }
    }

    private void k(bw bwVar) {
        if (this.ajd != null) {
            if (!isShow(32)) {
                this.ajd.setVisibility(8);
            } else if (bwVar == null || bwVar.bfy() == null || (bwVar.efQ > 0 && bwVar.efR == 0)) {
                this.ajd.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bwVar.bfy().getIconInfo();
                if (y.getCount(iconInfo) != 0) {
                    this.ajd.setVisibility(0);
                    this.ajd.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.ajd.setVisibility(8);
            }
        }
    }

    protected String t(String str, int i) {
        return at.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void um() {
        if (this.agf != null && this.agf.bfy() != null) {
            if (this.agf.efQ > 0 && this.agf.efR == 0) {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ajb);
            } else if (!y.isEmpty(this.agf.bfy().getTShowInfoNew()) || this.agf.bhz()) {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_h);
            } else {
                ap.setViewTextColor(this.ajb, R.color.cp_cont_f);
                com.baidu.tbadk.a.b.a.b(this.ajb);
            }
        }
    }

    private void l(bw bwVar) {
        if (this.aje != null && bwVar != null && bwVar.bfy() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bwVar.bfy().getTShowInfoNew();
            if (y.getCount(tShowInfoNew) != 0) {
                this.aje.setVisibility(0);
                this.aje.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.aje.setVisibility(8);
        }
    }

    private void m(bw bwVar) {
        if (this.ajc != null && bwVar != null && bwVar.bfy() != null && isShow(16)) {
            MetaData bfy = bwVar.bfy();
            if (this.ajc.getLayoutParams() != null) {
                this.ajc.getLayoutParams().width = -2;
            }
            this.ajc.setOnClickListener(null);
            if (bfy.getIs_bawu() == 1) {
                int i = R.drawable.brand_official_btn;
                int i2 = R.color.cp_cont_a;
                ap.setBackgroundResource(this.ajc, i);
                ap.setViewTextColor(this.ajc, i2);
                if (bwVar.ege) {
                    this.ajc.setVisibility(0);
                    this.ajc.setText(R.string.brand_Official);
                    return;
                } else if (Config.BAWU_TYPE_MANAGER.equals(bfy.getBawu_type())) {
                    this.ajc.setBackgroundDrawable(this.ajl);
                    this.ajc.setVisibility(0);
                    this.ajc.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (Config.BAWU_TYPE_ASSIST.equals(bfy.getBawu_type())) {
                    this.ajc.setBackgroundDrawable(this.ajm);
                    this.ajc.setText(R.string.bawu_member_xbazhu_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(bfy.getBawu_type())) {
                    this.ajc.setText(R.string.bawu_content_assist_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(bfy.getBawu_type())) {
                    this.ajc.setText(R.string.bawu_manage_assist_tip);
                    this.ajc.setVisibility(0);
                    return;
                } else {
                    this.ajc.setVisibility(8);
                    return;
                }
            }
            this.ajc.setVisibility(8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.aiZ;
    }

    public View getUserName() {
        return this.ajb;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ajn = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.aiZ != null) {
            this.aiZ.setPageId(bdUniqueId);
        }
    }

    private void n(bw bwVar) {
        if (this.ajf != null) {
            if (bwVar == null || TextUtils.isEmpty(bwVar.beW())) {
                this.ajf.setVisibility(8);
                return;
            }
            if (bwVar.bfy() != null && bwVar.bfy().isBaijiahaoUser()) {
                this.ajf.setLines(1);
                this.ajf.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.ajf.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.ajf.setEllipsize(null);
            }
            ap.setViewTextColor(this.ajf, R.color.cp_cont_d);
            this.ajf.setText(bwVar.beW());
            this.ajf.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bw bwVar) {
        String address;
        boolean z = true;
        dm("");
        if (bwVar != null && bwVar.getType() == bw.edD && bwVar.bfS() != null && bwVar.bfS().openRecomLocation != 0) {
            String bfN = bwVar.bfN();
            String bfO = bwVar.bfO();
            boolean z2 = UtilHelper.isDecimal(bfN) && UtilHelper.isDecimal(bfO);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo drN = com.baidu.tieba.recapp.d.a.drI().drN();
                String str = drN.latitude;
                String str2 = drN.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(bfN), Double.parseDouble(bfO));
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
            dm(address);
        }
    }

    private void dm(String str) {
        boolean z = !StringUtils.isNull(str);
        this.ajg.setVisibility(z ? 0 : 8);
        this.ajh.setVisibility(z ? 0 : 8);
        if (z) {
            this.ajh.setText(str);
            SvgManager.bkl().a(this.ajg, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            ap.setViewTextColor(this.ajh, R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void un() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.ajb.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.aji.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.ajb.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, t(this.agf.bfy().getName_show(), 12)) + this.ajb.getPaddingLeft() + this.ajb.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, t(this.agf.bfy().getName_show(), 10)) + this.ajb.getPaddingLeft() + this.ajb.getPaddingRight();
            int measuredWidth = this.aje.getMeasuredWidth();
            int measuredWidth2 = this.ajb.getMeasuredWidth();
            int measuredWidth3 = this.aji.getMeasuredWidth();
            int measuredWidth4 = this.ajc.getMeasuredWidth();
            int measuredWidth5 = this.ajd.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.ajb.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.ajb.setText(t(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.ajb.setText(t(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.ajd.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.ajc.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.aje.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.aji.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.agf != null && this.agf.bfy() != null && this.agf.bfy().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.ajf.setMaxWidth(i2);
        }
    }

    private void uo() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.ajl = new LayerDrawable(new Drawable[]{b.bkM().oq(0).V(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bkO(), b.bkM().oq(0).V(this.tbds6).AT("#4D000000").bkO()});
        this.ajm = new LayerDrawable(new Drawable[]{b.bkM().oq(0).V(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bkO(), b.bkM().oq(0).V(this.tbds6).AT("#4D000000").bkO()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.ajj;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    private boolean c(bw bwVar) {
        return (bwVar == null || bwVar.bfy() == null || !bwVar.egu || !com.baidu.tbadk.a.d.bbc() || bwVar.bfy().hadConcerned() || ay.x(bwVar)) ? false : true;
    }
}

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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.e.a.c;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class CardUserInfoLayout extends LinearLayout implements o {
    private bk aee;
    private TextView agA;
    private ImageView agB;
    private TextView agC;
    private TextView agD;
    protected RelativeLayout agE;
    private ImageView agF;
    private LayerDrawable agG;
    private LayerDrawable agH;
    private View.OnClickListener agI;
    private View.OnClickListener agJ;
    private View agK;
    private View agL;
    private int agM;
    private Runnable agN;
    private View.OnClickListener agO;
    private View.OnClickListener agP;
    private View.OnClickListener agQ;
    private HeadPendantClickableView agu;
    private TBLottieAnimationView agv;
    private TextView agw;
    private TextView agx;
    private UserIconBox agy;
    private UserIconBox agz;
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
        this.agM = 34053;
        this.agN = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.rX();
            }
        };
        this.agO = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.aee != null && CardUserInfoLayout.this.aee.aQx() != null && CardUserInfoLayout.this.aee.aQx().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.aee.aQx().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.aee.aQx().getTShowInfoNew().get(0).getUrl()) != null && (i.G(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aVa().b((TbPageContext) i.G(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.agP = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aee != null && CardUserInfoLayout.this.aee.aQx() != null && !StringUtils.isNull(CardUserInfoLayout.this.aee.aQx().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.aee.aQx().getUserId()) && CardUserInfoLayout.this.aee.aQC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.aee.aQx().getUserId(), CardUserInfoLayout.this.aee.aQx().getName_show(), CardUserInfoLayout.this.aee.aQC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.aee.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.agI != null) {
                        CardUserInfoLayout.this.agI.onClick(view);
                    }
                }
            }
        };
        this.agQ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.aee != null && CardUserInfoLayout.this.aee.aQx() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.aee.aQx().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.agJ != null) {
                        CardUserInfoLayout.this.agI.onClick(view);
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
        int dimens = l.getDimens(getContext(), R.dimen.tbds94);
        if (!TbSingleton.getInstance().checkDistanceAccuracy(getContext())) {
            dimens = l.getDimens(getContext(), R.dimen.tbds110);
        }
        setLayoutParams(new ViewGroup.LayoutParams(-2, dimens));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        rV();
        rY();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.agM = i;
        rU();
    }

    private void rU() {
        this.agz.setVisibility(isShow(1) ? 0 : 8);
        this.agw.setVisibility(isShow(4) ? 0 : 8);
        this.agx.setVisibility(isShow(16) ? 0 : 8);
        this.agD.setVisibility(isShow(8) ? 0 : 8);
        this.agy.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agK.getLayoutParams();
        if (isShow(128)) {
            this.agA.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.agA.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.agK.setLayoutParams(layoutParams);
        this.agF.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.agM & i) > 0;
    }

    private void rV() {
        this.agu = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.agu.setHasPendantStyle();
        this.agu.getHeadView().setIsRound(true);
        this.agu.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.agu.getHeadView().setDefaultResource(17170445);
        this.agu.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.agu.getHeadView().setPlaceHolder(1);
        this.agu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.agI != null) {
                    CardUserInfoLayout.this.agI.onClick(view);
                }
            }
        });
        this.agv = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.agz = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.agz.setOnClickListener(this.agO);
        this.agw = (TextView) findViewById(R.id.user_name);
        this.agw.setOnClickListener(this.agP);
        this.agx = (TextView) findViewById(R.id.identity_view);
        this.agD = (TextView) findViewById(R.id.thread_share_intro);
        this.agy = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.agy.setOnClickListener(this.agQ);
        this.agA = (TextView) findViewById(R.id.thread_extend_info);
        this.agB = (ImageView) findViewById(R.id.ala_location_icon);
        this.agC = (TextView) findViewById(R.id.ala_location);
        this.agK = findViewById(R.id.user_name_and_reply_time);
        this.agL = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.agE = (RelativeLayout) findViewById(R.id.suffix_container);
        this.agF = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.agu.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.agG != null && this.agG.getDrawable(1) != null) {
                    this.agG.getDrawable(1).setAlpha(255);
                }
                if (this.agH != null && this.agH.getDrawable(1) != null) {
                    this.agH.getDrawable(1).setAlpha(255);
                }
                if (this.agv != null) {
                    this.agv.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.agv != null) {
                    this.agv.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.agG != null && this.agG.getDrawable(1) != null) {
                    this.agG.getDrawable(1).setAlpha(0);
                }
                if (this.agH != null && this.agH.getDrawable(1) != null) {
                    this.agH.getDrawable(1).setAlpha(0);
                }
                if (this.agv != null) {
                    this.agv.setAnimation("live/card_live_bg.json");
                }
            }
        }
    }

    private void c(bk bkVar) {
        if (this.agu != null && bkVar != null && this.aee.aQx() != null) {
            this.agu.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.agu, this.aee.aQx(), 0)) {
                if (this.aee.dHk > 0 && this.aee.dHl == 0) {
                    this.agu.hj(false);
                } else {
                    this.agu.a(this.aee.aQx(), 0);
                }
            }
        }
    }

    public void setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return;
        }
        this.aee = bkVar;
        e(bkVar);
        f(bkVar);
        k(bkVar);
        l(bkVar);
        h(bkVar);
        j(bkVar);
        c(bkVar);
        n(bkVar);
        o(bkVar);
        i(bkVar);
        g(bkVar);
        d(bkVar);
        setVisibility(0);
        if (isShow(128) && !bkVar.dHM && !bkVar.aSq()) {
            this.agK.post(this.agN);
        }
    }

    private void d(bk bkVar) {
        if (isShow(4096) && bkVar != null && this.agF != null) {
            if (bkVar.dHI) {
                this.agF.setVisibility(0);
            } else {
                this.agF.setVisibility(8);
            }
        }
    }

    private void e(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null) {
            if (bkVar.aSr()) {
                this.agM |= 4096;
            } else {
                this.agM &= -4097;
            }
            if (bkVar.dHM && !bkVar.aSx() && !bkVar.aSD() && bkVar.getType() != bk.dEW) {
                this.agM &= -129;
            } else {
                this.agM |= 128;
            }
            setShowFlag(this.agM);
        }
    }

    private void f(bk bkVar) {
        if (bkVar.aQx() == null) {
            this.agu.setVisibility(8);
            return;
        }
        MetaData aQx = bkVar.aQx();
        if (!isShow(256)) {
            aQx.setPendantData(null);
        }
        this.agu.setData(bkVar);
    }

    private void g(bk bkVar) {
        if (!isShow(32768)) {
            this.agv.setVisibility(8);
            if (this.agv.isAnimating()) {
                this.agv.cancelAnimation();
            }
            this.agu.setIsclearmode(false);
        } else if (bkVar != null && bkVar.aQx() != null && bkVar.aQx().getAlaUserData() != null) {
            if (bkVar.aQx().getAlaUserData().live_status != 1) {
                this.agv.setVisibility(8);
                this.agv.cancelAnimation();
                this.agu.setIsclearmode(false);
                return;
            }
            this.agu.setIsclearmode(true);
            this.agM &= -257;
            f(bkVar);
            this.agv.setSpeed(0.8f);
            this.agv.setVisibility(0);
            this.agv.loop(true);
            this.agv.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.agv.playAnimation();
                }
            });
        } else {
            this.agv.setVisibility(8);
            this.agv.cancelAnimation();
            this.agu.setIsclearmode(false);
        }
    }

    private void h(bk bkVar) {
        if (this.agw != null && bkVar != null) {
            if (bkVar.dHM || bkVar.aSq()) {
                ViewGroup.LayoutParams layoutParams = this.agK.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.agK.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.agL.getLayoutParams();
                layoutParams2.width = -1;
                this.agL.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.agw.getLayoutParams();
                layoutParams3.width = -1;
                this.agw.setLayoutParams(layoutParams3);
                this.agw.setEllipsize(TextUtils.TruncateAt.END);
                if (bkVar.aQx() != null && !StringUtils.isNull(bkVar.aQx().getName_show())) {
                    this.agw.setText(bkVar.aQx().getName_show());
                } else {
                    this.agw.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.aee.aPV())) {
                this.agw.setText(this.aee.aPV());
            } else {
                this.agw.setText(R.string.user_name_default_txt);
            }
            rW();
        }
    }

    protected void i(bk bkVar) {
        if (this.agD != null) {
            if (bkVar == null || (!isShow(8) && !isShow(512))) {
                this.agD.setVisibility(8);
            } else if (this.aee.getType() == bk.dGz) {
                this.agD.setVisibility(0);
                this.agD.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.agD, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bkVar.aOj())) {
                    this.agD.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agD.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.agD.setLayoutParams(layoutParams);
                }
                this.agD.setText(bkVar.aOj());
                this.agD.setVisibility(0);
            } else if (StringUtils.isNull(this.aee.aPX())) {
                this.agD.setVisibility(8);
            } else {
                this.agD.setVisibility(0);
                this.agD.setText(this.aee.aPX());
            }
        }
    }

    private void j(bk bkVar) {
        if (this.agy != null) {
            if (!isShow(32)) {
                this.agy.setVisibility(8);
            } else if (bkVar == null || bkVar.aQx() == null || (bkVar.dHk > 0 && bkVar.dHl == 0)) {
                this.agy.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bkVar.aQx().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.agy.setVisibility(0);
                    this.agy.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.agy.setVisibility(8);
            }
        }
    }

    protected String s(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void rW() {
        if (this.aee != null && this.aee.aQx() != null) {
            if (this.aee.dHk > 0 && this.aee.dHl == 0) {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.aee.aQx().getTShowInfoNew()) || this.aee.aSD()) {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.agw, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bk bkVar) {
        if (this.agz != null && bkVar != null && bkVar.aQx() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bkVar.aQx().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.agz.setVisibility(0);
                this.agz.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.agz.setVisibility(8);
        }
    }

    private void l(bk bkVar) {
        if (this.agx != null && bkVar != null && bkVar.aQx() != null && isShow(16)) {
            MetaData aQx = bkVar.aQx();
            if (this.agx.getLayoutParams() != null) {
                this.agx.getLayoutParams().width = -2;
            }
            this.agx.setOnClickListener(null);
            if (aQx.getIs_bawu() == 1) {
                am.setBackgroundResource(this.agx, R.drawable.brand_official_btn);
                am.setViewTextColor(this.agx, (int) R.color.cp_cont_a);
                if (bkVar.dHx) {
                    this.agx.setVisibility(0);
                    this.agx.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aQx.getBawu_type())) {
                    this.agx.setBackgroundDrawable(this.agG);
                    this.agx.setVisibility(0);
                    this.agx.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aQx.getBawu_type())) {
                    this.agx.setBackgroundDrawable(this.agH);
                    this.agx.setText(R.string.bawu_member_xbazhu_tip);
                    this.agx.setVisibility(0);
                } else if ("pri_content_assist".equals(aQx.getBawu_type())) {
                    this.agx.setText(R.string.bawu_content_assist_tip);
                    this.agx.setVisibility(0);
                } else if ("pri_manage_assist".equals(aQx.getBawu_type())) {
                    this.agx.setText(R.string.bawu_manage_assist_tip);
                    this.agx.setVisibility(0);
                } else if (aQx.getIs_biggie()) {
                    m(bkVar);
                } else {
                    this.agx.setVisibility(8);
                }
            } else if (aQx.getIs_biggie()) {
                m(bkVar);
            } else {
                this.agx.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.agu;
    }

    public View getUserName() {
        return this.agw;
    }

    private void m(bk bkVar) {
        am.setBackgroundResource(this.agx, R.drawable.brand_official_btn);
        am.setViewTextColor(this.agx, (int) R.color.cp_cont_a);
        this.agx.setText(R.string.video_mcn);
        if (bkVar.aRG()) {
            this.agy.setVisibility(8);
        }
        this.agx.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agI = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.agJ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.agu != null) {
            this.agu.setPageId(bdUniqueId);
        }
    }

    private void n(bk bkVar) {
        if (this.agA != null) {
            if (bkVar == null || TextUtils.isEmpty(bkVar.aPW())) {
                this.agA.setVisibility(8);
                return;
            }
            if (bkVar.aQx() != null && bkVar.aQx().isBaijiahaoUser()) {
                this.agA.setLines(1);
                this.agA.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.agA.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.agA.setEllipsize(null);
            }
            am.setViewTextColor(this.agA, (int) R.color.cp_cont_d);
            this.agA.setText(bkVar.aPW());
            this.agA.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void o(bk bkVar) {
        String address;
        boolean z = true;
        cY("");
        if (bkVar != null && bkVar.getType() == bk.dEW && bkVar.aQS() != null && bkVar.aQS().openRecomLocation != 0) {
            String aQN = bkVar.aQN();
            String aQO = bkVar.aQO();
            boolean z2 = UtilHelper.isDecimal(aQN) && UtilHelper.isDecimal(aQO);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo cVt = com.baidu.tieba.recapp.d.a.cVp().cVt();
                String str = cVt.latitude;
                String str2 = cVt.longitude;
                if (!UtilHelper.isDecimal(str) || !UtilHelper.isDecimal(str2)) {
                    z = false;
                }
                if (z) {
                    double GetDistance = l.GetDistance(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(aQN), Double.parseDouble(aQO));
                    if (GetDistance <= 50.0d) {
                        address = aq.m(GetDistance);
                    } else {
                        address = bkVar.getAddress();
                    }
                }
                address = "";
            } else {
                if (z2) {
                    address = bkVar.getAddress();
                }
                address = "";
            }
            cY(address);
        }
    }

    private void cY(String str) {
        boolean z = !StringUtils.isNull(str);
        this.agB.setVisibility(z ? 0 : 8);
        this.agC.setVisibility(z ? 0 : 8);
        if (z) {
            this.agC.setText(str);
            SvgManager.aUW().a(this.agB, R.drawable.icon_pure_post_location_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.agC, (int) R.color.cp_cont_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rX() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.agw.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.agD.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.agw.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, s(this.aee.aQx().getName_show(), 12)) + this.agw.getPaddingLeft() + this.agw.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, s(this.aee.aQx().getName_show(), 10)) + this.agw.getPaddingLeft() + this.agw.getPaddingRight();
            int measuredWidth = this.agz.getMeasuredWidth();
            int measuredWidth2 = this.agw.getMeasuredWidth();
            int measuredWidth3 = this.agD.getMeasuredWidth();
            int measuredWidth4 = this.agx.getMeasuredWidth();
            int measuredWidth5 = this.agy.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.agw.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.agw.setText(s(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.agw.setText(s(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.agy.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.agx.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.agz.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.agD.setVisibility(8);
                }
            }
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.aee != null && this.aee.aQx() != null && this.aee.aQx().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.agA.setMaxWidth(i2);
        }
    }

    private void rY() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.agG = new LayerDrawable(new Drawable[]{c.aVA().lp(0).O(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aVC(), c.aVA().lp(0).O(this.tbds6).wJ("#4D000000").aVC()});
        this.agH = new LayerDrawable(new Drawable[]{c.aVA().lp(0).O(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aVC(), c.aVA().lp(0).O(this.tbds6).wJ("#4D000000").aVC()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.agE;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

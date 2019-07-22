package com.baidu.card.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.baidu.card.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.b;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CardUserInfoLayout extends LinearLayout implements j {
    private bg We;
    private HeadPendantClickableView XK;
    private TextView XL;
    private TextView XM;
    private UserIconBox XN;
    private UserIconBox XO;
    private TextView XP;
    private TextView XQ;
    protected RelativeLayout XR;
    private View XS;
    private FrameLayout XT;
    private View.OnClickListener XU;
    private View.OnClickListener XV;
    private View XW;
    private int XX;
    private Runnable XY;
    private View.OnClickListener XZ;
    private View.OnClickListener Ya;
    private View.OnClickListener Yb;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.XX = 1285;
        this.XY = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.qZ();
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bd.cF(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.We != null && CardUserInfoLayout.this.We.aex() != null && CardUserInfoLayout.this.We.aex().getTShowInfoNew() != null && v.c(CardUserInfoLayout.this.We.aex().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.We.aex().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    bb.ajC().c((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.We != null && CardUserInfoLayout.this.We.aex() != null && !StringUtils.isNull(CardUserInfoLayout.this.We.aex().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.We.aex().getUserId()) && CardUserInfoLayout.this.We.aeC() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bd.cF(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.We.afH() != null && CardUserInfoLayout.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.We.afH().channelId, CardUserInfoLayout.this.We.afH().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.We.aex().getUserId(), CardUserInfoLayout.this.We.aex().getName_show(), CardUserInfoLayout.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.We.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.XU != null) {
                        CardUserInfoLayout.this.XU.onClick(view);
                    }
                }
            }
        };
        this.Yb = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.We != null && CardUserInfoLayout.this.We.aex() != null) {
                    a.a(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.We.aex().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.XV != null) {
                        CardUserInfoLayout.this.XU.onClick(view);
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
        setMinimumHeight(l.g(getContext(), R.dimen.tbds92));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        qX();
    }

    public void setShowFlag(int i) {
        this.XX = i;
        qW();
    }

    private void qW() {
        this.XO.setVisibility(by(1) ? 0 : 8);
        this.XL.setVisibility(by(4) ? 0 : 8);
        this.XM.setVisibility(by(16) ? 0 : 8);
        this.XQ.setVisibility(by(8) ? 0 : 8);
        this.XN.setVisibility(by(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XW.getLayoutParams();
        if (by(128)) {
            this.XP.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.XP.setVisibility(8);
            layoutParams.bottomMargin = l.g(getContext(), R.dimen.tbds4);
        }
        this.XW.setLayoutParams(layoutParams);
        if (by(64)) {
            this.XT.setVisibility(0);
            this.XS = b.aak().n(getContext(), 1);
            if (this.XS != null) {
                this.XS.setVisibility(8);
                this.XT.addView(this.XS);
                return;
            }
            return;
        }
        this.XT.setVisibility(8);
    }

    private boolean by(int i) {
        return (this.XX & i) > 0;
    }

    private void qX() {
        this.XK = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.XK.setHasPendantStyle();
        this.XK.getHeadView().setIsRound(true);
        this.XK.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.XK.getHeadView().setDefaultResource(17170445);
        this.XK.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.XK.getHeadView().setDefaultBgResource(e.Qr());
        this.XK.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.XU != null) {
                    CardUserInfoLayout.this.XU.onClick(view);
                }
            }
        });
        this.XO = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.XO.setOnClickListener(this.XZ);
        this.XL = (TextView) findViewById(R.id.user_name);
        this.XL.setOnClickListener(this.Ya);
        this.XM = (TextView) findViewById(R.id.identity_view);
        this.XQ = (TextView) findViewById(R.id.thread_share_intro);
        this.XN = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.XN.setOnClickListener(this.Yb);
        this.XP = (TextView) findViewById(R.id.thread_extend_info);
        this.XT = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.XW = findViewById(R.id.user_name_and_reply_time);
        this.XR = (RelativeLayout) findViewById(R.id.suffix_container);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.XK.getHeadView().setDefaultBgResource(e.Qr());
        }
    }

    private void c(bg bgVar) {
        if (this.XK != null && bgVar != null && this.We.aex() != null) {
            if (!by(1024)) {
                this.XK.aA(false);
            } else if (this.We.bLO > 0 && this.We.bLP == 0) {
                this.XK.aA(false);
            } else {
                this.XK.aA(this.We.aex().isBigV());
            }
        }
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        this.We = bgVar;
        d(bgVar);
        i(bgVar);
        j(bgVar);
        f(bgVar);
        h(bgVar);
        c(bgVar);
        l(bgVar);
        g(bgVar);
        setVisibility(0);
        e(bgVar);
        if (by(128)) {
            this.XW.post(this.XY);
        }
    }

    private void d(bg bgVar) {
        if (bgVar.aex() == null) {
            this.XK.setVisibility(8);
            return;
        }
        MetaData aex = bgVar.aex();
        if (!by(256)) {
            aex.setPendantData(null);
        }
        this.XK.setData(bgVar);
    }

    private void e(bg bgVar) {
        if (bgVar != null && bgVar.aex() != null && bgVar.aex().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bgVar.aex().getAlaUserData();
            if (this.XS != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bAN = alaUserData;
                aVar.type = 1;
                this.XS.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.XS.setVisibility(8);
                } else {
                    this.XS.setVisibility(0);
                }
            }
        } else if (this.XS != null) {
            this.XS.setVisibility(8);
        }
    }

    private void f(bg bgVar) {
        if (this.XL != null && bgVar != null) {
            if (!StringUtils.isNull(this.We.adV())) {
                this.XL.setText(this.We.adV());
            } else {
                this.XL.setText(R.string.user_name_default_txt);
            }
            qY();
        }
    }

    protected void g(bg bgVar) {
        if (this.XQ != null) {
            if (bgVar == null || (!by(8) && !by(512))) {
                this.XQ.setVisibility(8);
            } else if (this.We.getType() == bg.bKV) {
                this.XQ.setVisibility(0);
                this.XQ.getPaint().setFakeBoldText(true);
                this.XQ.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                am.j(this.XQ, R.color.cp_cont_b);
            } else if (by(8)) {
                if (StringUtils.isNull(bgVar.acy())) {
                    this.XQ.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XQ.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.XQ.setLayoutParams(layoutParams);
                }
                this.XQ.setText(bgVar.acy());
                this.XQ.setVisibility(0);
            } else if (StringUtils.isNull(this.We.adX())) {
                this.XQ.setVisibility(8);
            } else {
                this.XQ.setVisibility(0);
                this.XQ.setText(this.We.adX());
            }
        }
    }

    private void h(bg bgVar) {
        if (this.XN != null) {
            if (!by(32)) {
                this.XN.setVisibility(8);
            } else if (bgVar == null || bgVar.aex() == null || (bgVar.bLO > 0 && bgVar.bLP == 0)) {
                this.XN.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.aex().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.XN.setVisibility(0);
                    this.XN.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.XN.setVisibility(8);
            }
        }
    }

    protected String p(String str, int i) {
        return aq.j(str, i, "...");
    }

    private void qY() {
        if (this.We != null && this.We.aex() != null) {
            if (this.We.bLO > 0 && this.We.bLP == 0) {
                am.j(this.XL, R.color.cp_cont_f);
            } else if (!v.aa(this.We.aex().getTShowInfoNew())) {
                am.j(this.XL, R.color.cp_cont_h);
            } else if (this.We.aex().isBigV()) {
                if (by(1024)) {
                    am.j(this.XL, R.color.cp_cont_h);
                } else {
                    am.j(this.XL, R.color.cp_cont_f);
                }
            } else {
                am.j(this.XL, R.color.cp_cont_f);
            }
        }
    }

    private void i(bg bgVar) {
        if (this.XO != null && bgVar != null && bgVar.aex() != null && by(1)) {
            ArrayList<IconData> tShowInfoNew = bgVar.aex().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XO.setVisibility(0);
                this.XO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.XO.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.XM != null && bgVar != null && bgVar.aex() != null && by(16)) {
            MetaData aex = bgVar.aex();
            if (aex.getIs_bawu() == 1) {
                am.k(this.XM, R.drawable.brand_official_btn);
                am.j(this.XM, R.color.cp_btn_a);
                if (bgVar.bMb) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.brand_Official);
                } else if ("manager".equals(aex.getBawu_type())) {
                    this.XM.setVisibility(0);
                    this.XM.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_member_xbazhu_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_content_assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_content_assist_tip);
                    this.XM.setVisibility(0);
                } else if ("pri_manage_assist".equals(aex.getBawu_type())) {
                    this.XM.setText(R.string.bawu_manage_assist_tip);
                    this.XM.setVisibility(0);
                } else if (aex.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.XM.setVisibility(8);
                }
            } else if (aex.getIs_biggie()) {
                k(bgVar);
            } else {
                this.XM.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.XK;
    }

    public View getUserName() {
        return this.XL;
    }

    private void k(bg bgVar) {
        am.k(this.XM, R.drawable.brand_official_btn);
        am.j(this.XM, R.color.cp_btn_a);
        this.XM.setText(R.string.video_mcn);
        if (bgVar.afx()) {
            this.XN.setVisibility(8);
        }
        this.XM.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.XV = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.XK != null) {
            this.XK.setPageId(bdUniqueId);
        }
    }

    private void l(bg bgVar) {
        if (this.XP != null) {
            if (bgVar == null || (bgVar.getAddress() == null && bgVar.aeq() == 0)) {
                this.XP.setVisibility(8);
                return;
            }
            am.j(this.XP, R.color.cp_cont_d);
            this.XP.setText(bgVar.adW());
            this.XP.setVisibility(by(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qZ() {
        int width;
        if (by(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.XL.getMeasuredHeight());
            layoutParams.setMargins(l.g(this.mContext, R.dimen.tbds10), l.g(this.mContext, R.dimen.tbds_5), 0, 0);
            this.XQ.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.XL.getPaint();
        int i = l.aj(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.g(this.mContext, R.dimen.tbds107)) > 0) {
            int c = l.c(paint, p(this.We.aex().getName_show(), 12)) + this.XL.getPaddingLeft() + this.XL.getPaddingRight();
            int c2 = l.c(paint, p(this.We.aex().getName_show(), 10)) + this.XL.getPaddingLeft() + this.XL.getPaddingRight();
            int measuredWidth = this.XO.getMeasuredWidth();
            int measuredWidth2 = this.XL.getMeasuredWidth();
            int measuredWidth3 = this.XQ.getMeasuredWidth();
            int measuredWidth4 = this.XM.getMeasuredWidth();
            int measuredWidth5 = this.XN.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c) {
                    this.XL.setText(p(this.We.aex().getName_show(), 12));
                } else if (width < c + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.XL.setText(p(this.We.aex().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c2) {
                    this.XN.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + c2) {
                    this.XM.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + c2) {
                    this.XO.setVisibility(8);
                }
                if (width > c2 + measuredWidth3) {
                    this.XQ.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.XR;
    }
}

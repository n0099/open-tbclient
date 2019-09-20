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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
    private bh Wd;
    private HeadPendantClickableView XJ;
    private TextView XK;
    private TextView XL;
    private UserIconBox XM;
    private UserIconBox XN;
    private TextView XO;
    private TextView XP;
    protected RelativeLayout XQ;
    private ImageView XR;
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
                CardUserInfoLayout.this.ra();
            }
        };
        this.XZ = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cF(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.Wd != null && CardUserInfoLayout.this.Wd.aeC() != null && CardUserInfoLayout.this.Wd.aeC().getTShowInfoNew() != null && v.c(CardUserInfoLayout.this.Wd.aeC().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.Wd.aeC().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.ajK().c((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.Ya = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Wd != null && CardUserInfoLayout.this.Wd.aeC() != null && !StringUtils.isNull(CardUserInfoLayout.this.Wd.aeC().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.Wd.aeC().getUserId()) && CardUserInfoLayout.this.Wd.aeH() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cF(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.Wd.afM() != null && CardUserInfoLayout.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Wd.afM().channelId, CardUserInfoLayout.this.Wd.afM().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.Wd.aeC().getUserId(), CardUserInfoLayout.this.Wd.aeC().getName_show(), CardUserInfoLayout.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.Wd.getTid());
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
                if (CardUserInfoLayout.this.Wd != null && CardUserInfoLayout.this.Wd.aeC() != null) {
                    a.a(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.Wd.aeC().getUserId(), true, true, true);
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
        qY();
    }

    public void setShowFlag(int i) {
        this.XX = i;
        qX();
    }

    private void qX() {
        this.XN.setVisibility(by(1) ? 0 : 8);
        this.XK.setVisibility(by(4) ? 0 : 8);
        this.XL.setVisibility(by(16) ? 0 : 8);
        this.XP.setVisibility(by(8) ? 0 : 8);
        this.XM.setVisibility(by(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XW.getLayoutParams();
        if (by(128)) {
            this.XO.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.XO.setVisibility(8);
            layoutParams.bottomMargin = l.g(getContext(), R.dimen.tbds4);
        }
        this.XW.setLayoutParams(layoutParams);
        if (by(64)) {
            this.XT.setVisibility(0);
            this.XS = b.aao().n(getContext(), 1);
            if (this.XS != null) {
                this.XS.setVisibility(8);
                this.XT.addView(this.XS);
            }
        } else {
            this.XT.setVisibility(8);
        }
        this.XR.setVisibility(by(4096) ? 0 : 8);
    }

    private boolean by(int i) {
        return (this.XX & i) > 0;
    }

    private void qY() {
        this.XJ = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.XJ.setHasPendantStyle();
        this.XJ.getHeadView().setIsRound(true);
        this.XJ.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.XJ.getHeadView().setDefaultResource(17170445);
        this.XJ.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.XJ.getHeadView().setDefaultBgResource(e.Qv());
        this.XJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.XU != null) {
                    CardUserInfoLayout.this.XU.onClick(view);
                }
            }
        });
        this.XN = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.XN.setOnClickListener(this.XZ);
        this.XK = (TextView) findViewById(R.id.user_name);
        this.XK.setOnClickListener(this.Ya);
        this.XL = (TextView) findViewById(R.id.identity_view);
        this.XP = (TextView) findViewById(R.id.thread_share_intro);
        this.XM = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.XM.setOnClickListener(this.Yb);
        this.XO = (TextView) findViewById(R.id.thread_extend_info);
        this.XT = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.XW = findViewById(R.id.user_name_and_reply_time);
        this.XQ = (RelativeLayout) findViewById(R.id.suffix_container);
        this.XR = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.XJ.getHeadView().setDefaultBgResource(e.Qv());
        }
    }

    private void c(bh bhVar) {
        if (this.XJ != null && bhVar != null && this.Wd.aeC() != null) {
            if (!by(1024)) {
                this.XJ.aA(false);
            } else if (this.Wd.bMr > 0 && this.Wd.bMs == 0) {
                this.XJ.aA(false);
            } else {
                this.XJ.aA(this.Wd.aeC().isBigV());
            }
        }
    }

    public void setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return;
        }
        this.Wd = bhVar;
        e(bhVar);
        j(bhVar);
        k(bhVar);
        g(bhVar);
        i(bhVar);
        c(bhVar);
        m(bhVar);
        h(bhVar);
        setVisibility(0);
        f(bhVar);
        d(bhVar);
        if (by(128)) {
            this.XW.post(this.XY);
        }
    }

    private void d(bh bhVar) {
        if (by(4096) && bhVar != null && this.XR != null) {
            if (bhVar.bMT) {
                this.XR.setVisibility(0);
            } else {
                this.XR.setVisibility(8);
            }
        }
    }

    private void e(bh bhVar) {
        if (bhVar.aeC() == null) {
            this.XJ.setVisibility(8);
            return;
        }
        MetaData aeC = bhVar.aeC();
        if (!by(256)) {
            aeC.setPendantData(null);
        }
        this.XJ.setData(bhVar);
    }

    private void f(bh bhVar) {
        if (bhVar != null && bhVar.aeC() != null && bhVar.aeC().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bhVar.aeC().getAlaUserData();
            if (this.XS != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bBl = alaUserData;
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

    private void g(bh bhVar) {
        if (this.XK != null && bhVar != null) {
            if (!StringUtils.isNull(this.Wd.aea())) {
                this.XK.setText(this.Wd.aea());
            } else {
                this.XK.setText(R.string.user_name_default_txt);
            }
            qZ();
        }
    }

    protected void h(bh bhVar) {
        if (this.XP != null) {
            if (bhVar == null || (!by(8) && !by(512))) {
                this.XP.setVisibility(8);
            } else if (this.Wd.getType() == bh.bLy) {
                this.XP.setVisibility(0);
                this.XP.getPaint().setFakeBoldText(true);
                this.XP.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                am.j(this.XP, R.color.cp_cont_b);
            } else if (by(8)) {
                if (StringUtils.isNull(bhVar.acD())) {
                    this.XP.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XP.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.XP.setLayoutParams(layoutParams);
                }
                this.XP.setText(bhVar.acD());
                this.XP.setVisibility(0);
            } else if (StringUtils.isNull(this.Wd.aec())) {
                this.XP.setVisibility(8);
            } else {
                this.XP.setVisibility(0);
                this.XP.setText(this.Wd.aec());
            }
        }
    }

    private void i(bh bhVar) {
        if (this.XM != null) {
            if (!by(32)) {
                this.XM.setVisibility(8);
            } else if (bhVar == null || bhVar.aeC() == null || (bhVar.bMr > 0 && bhVar.bMs == 0)) {
                this.XM.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bhVar.aeC().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.XM.setVisibility(0);
                    this.XM.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.XM.setVisibility(8);
            }
        }
    }

    protected String p(String str, int i) {
        return aq.j(str, i, "...");
    }

    private void qZ() {
        if (this.Wd != null && this.Wd.aeC() != null) {
            if (this.Wd.bMr > 0 && this.Wd.bMs == 0) {
                am.j(this.XK, R.color.cp_cont_f);
            } else if (!v.aa(this.Wd.aeC().getTShowInfoNew())) {
                am.j(this.XK, R.color.cp_cont_h);
            } else if (this.Wd.aeC().isBigV()) {
                if (by(1024)) {
                    am.j(this.XK, R.color.cp_cont_h);
                } else {
                    am.j(this.XK, R.color.cp_cont_f);
                }
            } else {
                am.j(this.XK, R.color.cp_cont_f);
            }
        }
    }

    private void j(bh bhVar) {
        if (this.XN != null && bhVar != null && bhVar.aeC() != null && by(1)) {
            ArrayList<IconData> tShowInfoNew = bhVar.aeC().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.XN.setVisibility(0);
                this.XN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.XN.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.XL != null && bhVar != null && bhVar.aeC() != null && by(16)) {
            MetaData aeC = bhVar.aeC();
            if (aeC.getIs_bawu() == 1) {
                am.k(this.XL, R.drawable.brand_official_btn);
                am.j(this.XL, R.color.cp_cont_a);
                if (bhVar.bME) {
                    this.XL.setVisibility(0);
                    this.XL.setText(R.string.brand_Official);
                } else if ("manager".equals(aeC.getBawu_type())) {
                    this.XL.setVisibility(0);
                    this.XL.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_member_xbazhu_tip);
                    this.XL.setVisibility(0);
                } else if ("pri_content_assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_content_assist_tip);
                    this.XL.setVisibility(0);
                } else if ("pri_manage_assist".equals(aeC.getBawu_type())) {
                    this.XL.setText(R.string.bawu_manage_assist_tip);
                    this.XL.setVisibility(0);
                } else if (aeC.getIs_biggie()) {
                    l(bhVar);
                } else {
                    this.XL.setVisibility(8);
                }
            } else if (aeC.getIs_biggie()) {
                l(bhVar);
            } else {
                this.XL.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.XJ;
    }

    public View getUserName() {
        return this.XK;
    }

    private void l(bh bhVar) {
        am.k(this.XL, R.drawable.brand_official_btn);
        am.j(this.XL, R.color.cp_cont_a);
        this.XL.setText(R.string.video_mcn);
        if (bhVar.afC()) {
            this.XM.setVisibility(8);
        }
        this.XL.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XU = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.XV = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.XJ != null) {
            this.XJ.setPageId(bdUniqueId);
        }
    }

    private void m(bh bhVar) {
        if (this.XO != null) {
            if (bhVar == null || (bhVar.getAddress() == null && bhVar.aev() == 0)) {
                this.XO.setVisibility(8);
                return;
            }
            am.j(this.XO, R.color.cp_cont_d);
            this.XO.setText(bhVar.aeb());
            this.XO.setVisibility(by(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ra() {
        int width;
        if (by(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.XK.getMeasuredHeight());
            layoutParams.setMargins(l.g(this.mContext, R.dimen.tbds10), l.g(this.mContext, R.dimen.tbds_5), 0, 0);
            this.XP.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.XK.getPaint();
        int i = l.aj(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.g(this.mContext, R.dimen.tbds107)) > 0) {
            int c = l.c(paint, p(this.Wd.aeC().getName_show(), 12)) + this.XK.getPaddingLeft() + this.XK.getPaddingRight();
            int c2 = l.c(paint, p(this.Wd.aeC().getName_show(), 10)) + this.XK.getPaddingLeft() + this.XK.getPaddingRight();
            int measuredWidth = this.XN.getMeasuredWidth();
            int measuredWidth2 = this.XK.getMeasuredWidth();
            int measuredWidth3 = this.XP.getMeasuredWidth();
            int measuredWidth4 = this.XL.getMeasuredWidth();
            int measuredWidth5 = this.XM.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c) {
                    this.XK.setText(p(this.Wd.aeC().getName_show(), 12));
                } else if (width < c + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.XK.setText(p(this.Wd.aeC().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c2) {
                    this.XM.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + c2) {
                    this.XL.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + c2) {
                    this.XN.setVisibility(8);
                }
                if (width > c2 + measuredWidth3) {
                    this.XP.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.XQ;
    }
}

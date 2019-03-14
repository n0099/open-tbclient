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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CardUserInfoLayout extends LinearLayout implements j {
    private bg XS;
    private UserIconBox ZA;
    private UserIconBox ZB;
    private TextView ZC;
    private TextView ZD;
    private View ZE;
    private FrameLayout ZF;
    private View.OnClickListener ZG;
    private View.OnClickListener ZH;
    private View ZI;
    private int ZJ;
    private Runnable ZK;
    private View.OnClickListener ZL;
    private View.OnClickListener ZM;
    private View.OnClickListener ZN;
    private HeadPendantClickableView Zx;
    private TextView Zy;
    private TextView Zz;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ZJ = 1285;
        this.ZK = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.rH();
            }
        };
        this.ZL = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cZ(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.XS != null && CardUserInfoLayout.this.XS.YR() != null && CardUserInfoLayout.this.XS.YR().getTShowInfoNew() != null && v.c(CardUserInfoLayout.this.XS.YR().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.XS.YR().getTShowInfoNew().get(0).getUrl()) != null && (i.aK(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.adD().c((TbPageContext) i.aK(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.ZM = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.XS != null && CardUserInfoLayout.this.XS.YR() != null && !StringUtils.isNull(CardUserInfoLayout.this.XS.YR().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.XS.YR().getUserId()) && CardUserInfoLayout.this.XS.YW() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cZ(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.XS.aab() != null && CardUserInfoLayout.this.XS.aab().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.XS.aab().channelId, CardUserInfoLayout.this.XS.aab().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.XS.YR().getUserId(), CardUserInfoLayout.this.XS.YR().getName_show(), CardUserInfoLayout.this.XS.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.XS.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.ZG != null) {
                        CardUserInfoLayout.this.ZG.onClick(view);
                    }
                }
            }
        };
        this.ZN = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.XS != null && CardUserInfoLayout.this.XS.YR() != null) {
                    a.a(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.XS.YR().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.ZH != null) {
                        CardUserInfoLayout.this.ZG.onClick(view);
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
        setMinimumHeight(l.h(getContext(), d.e.tbds92));
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(d.h.user_info_layout, (ViewGroup) this, true);
        rF();
    }

    public void setShowFlag(int i) {
        this.ZJ = i;
        rE();
    }

    private void rE() {
        this.ZB.setVisibility(bC(1) ? 0 : 8);
        this.Zy.setVisibility(bC(4) ? 0 : 8);
        this.Zz.setVisibility(bC(16) ? 0 : 8);
        this.ZD.setVisibility(bC(8) ? 0 : 8);
        this.ZA.setVisibility(bC(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZI.getLayoutParams();
        if (bC(128)) {
            this.ZC.setVisibility(0);
            layoutParams.topMargin = 0;
        } else {
            this.ZC.setVisibility(8);
            layoutParams.topMargin = l.h(getContext(), d.e.tbds2);
        }
        this.ZI.setLayoutParams(layoutParams);
        if (bC(64)) {
            this.ZF.setVisibility(0);
            this.ZE = b.UK().n(getContext(), 1);
            if (this.ZE != null) {
                this.ZE.setVisibility(8);
                this.ZF.addView(this.ZE);
                return;
            }
            return;
        }
        this.ZF.setVisibility(8);
    }

    private boolean bC(int i) {
        return (this.ZJ & i) > 0;
    }

    private void rF() {
        this.Zx = (HeadPendantClickableView) findViewById(d.g.user_avatar);
        this.Zx.setHasPendantStyle();
        this.Zx.getHeadView().setIsRound(true);
        this.Zx.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Zx.getHeadView().setDefaultResource(17170445);
        this.Zx.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.Zx.getHeadView().setDefaultBgResource(e.get());
        this.Zx.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.ZG != null) {
                    CardUserInfoLayout.this.ZG.onClick(view);
                }
            }
        });
        this.ZB = (UserIconBox) findViewById(d.g.user_tshow_icon);
        this.ZB.setOnClickListener(this.ZL);
        this.Zy = (TextView) findViewById(d.g.user_name);
        this.Zy.setOnClickListener(this.ZM);
        this.Zz = (TextView) findViewById(d.g.identity_view);
        this.ZD = (TextView) findViewById(d.g.thread_share_intro);
        this.ZA = (UserIconBox) findViewById(d.g.thread_user_icon);
        this.ZA.setOnClickListener(this.ZN);
        this.ZC = (TextView) findViewById(d.g.thread_extend_info);
        this.ZF = (FrameLayout) findViewById(d.g.ala_live_info_content_layout);
        this.ZI = findViewById(d.g.user_name_and_reply_time);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Zx.getHeadView().setDefaultBgResource(e.get());
        }
    }

    private void c(bg bgVar) {
        if (this.Zx != null && bgVar != null && this.XS.YR() != null) {
            if (!bC(1024)) {
                this.Zx.aF(false);
            } else if (this.XS.bDt > 0 && this.XS.bDu == 0) {
                this.Zx.aF(false);
            } else {
                this.Zx.aF(this.XS.YR().isBigV());
            }
        }
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        this.XS = bgVar;
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
        if (bC(128)) {
            this.ZI.post(this.ZK);
        }
    }

    private void d(bg bgVar) {
        if (bgVar.YR() == null) {
            this.Zx.setVisibility(8);
            return;
        }
        MetaData YR = bgVar.YR();
        if (!bC(256)) {
            YR.setPendantData(null);
        }
        this.Zx.setData(bgVar);
    }

    private void e(bg bgVar) {
        if (bgVar != null && bgVar.YR() != null && bgVar.YR().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bgVar.YR().getAlaUserData();
            if (this.ZE != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bsJ = alaUserData;
                aVar.type = 1;
                this.ZE.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.ZE.setVisibility(8);
                } else {
                    this.ZE.setVisibility(0);
                }
            }
        } else if (this.ZE != null) {
            this.ZE.setVisibility(8);
        }
    }

    private void f(bg bgVar) {
        if (this.Zy != null && bgVar != null) {
            if (!StringUtils.isNull(this.XS.Yp())) {
                this.Zy.setText(this.XS.Yp());
            } else {
                this.Zy.setText(d.j.user_name_default_txt);
            }
            rG();
        }
    }

    protected void g(bg bgVar) {
        if (this.ZD != null) {
            if (bgVar == null || (!bC(8) && !bC(512))) {
                this.ZD.setVisibility(8);
            } else if (this.XS.getType() == bg.bCA) {
                this.ZD.setVisibility(0);
                this.ZD.getPaint().setFakeBoldText(true);
                this.ZD.setText(this.mContext.getString(d.j.interview_live_info_tip_is_live));
                al.j(this.ZD, d.C0277d.cp_cont_b);
            } else if (bC(8)) {
                if (StringUtils.isNull(bgVar.WS())) {
                    this.ZD.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ZD.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.ZD.setLayoutParams(layoutParams);
                }
                this.ZD.setText(bgVar.WS());
                this.ZD.setVisibility(0);
            } else if (StringUtils.isNull(this.XS.Yr())) {
                this.ZD.setVisibility(8);
            } else {
                this.ZD.setVisibility(0);
                this.ZD.setText(this.XS.Yr());
            }
        }
    }

    private void h(bg bgVar) {
        if (this.ZA != null) {
            if (!bC(32)) {
                this.ZA.setVisibility(8);
            } else if (bgVar == null || bgVar.YR() == null || (bgVar.bDt > 0 && bgVar.bDu == 0)) {
                this.ZA.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.YR().getIconInfo();
                if (v.S(iconInfo) != 0) {
                    this.ZA.setVisibility(0);
                    this.ZA.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds40), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
                    return;
                }
                this.ZA.setVisibility(8);
            }
        }
    }

    protected String v(String str, int i) {
        return ap.g(str, i, "...");
    }

    private void rG() {
        if (this.XS != null && this.XS.YR() != null) {
            if (this.XS.bDt > 0 && this.XS.bDu == 0) {
                al.j(this.Zy, d.C0277d.cp_cont_f);
            } else if (!v.T(this.XS.YR().getTShowInfoNew())) {
                al.j(this.Zy, d.C0277d.cp_cont_h);
            } else if (this.XS.YR().isBigV()) {
                if (bC(1024)) {
                    al.j(this.Zy, d.C0277d.cp_cont_h);
                } else {
                    al.j(this.Zy, d.C0277d.cp_cont_f);
                }
            } else {
                al.j(this.Zy, d.C0277d.cp_cont_f);
            }
        }
    }

    private void i(bg bgVar) {
        if (this.ZB != null && bgVar != null && bgVar.YR() != null && bC(1)) {
            ArrayList<IconData> tShowInfoNew = bgVar.YR().getTShowInfoNew();
            if (v.S(tShowInfoNew) != 0) {
                this.ZB.setVisibility(0);
                this.ZB.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.tbds48), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.ZB.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Zz != null && bgVar != null && bgVar.YR() != null && bC(16)) {
            MetaData YR = bgVar.YR();
            if (YR.getIs_bawu() == 1) {
                int i = d.f.brand_official_btn;
                int i2 = d.C0277d.cp_btn_a;
                al.k(this.Zz, i);
                al.j(this.Zz, i2);
                if (bgVar.bDF) {
                    this.Zz.setVisibility(0);
                    this.Zz.setText(d.j.brand_Official);
                } else if ("manager".equals(YR.getBawu_type())) {
                    this.Zz.setVisibility(0);
                    this.Zz.setText(d.j.bawu_member_bazhu_tip);
                } else if ("assist".equals(YR.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_member_xbazhu_tip);
                    this.Zz.setVisibility(0);
                } else if ("pri_content_assist".equals(YR.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_content_assist_tip);
                    this.Zz.setVisibility(0);
                } else if ("pri_manage_assist".equals(YR.getBawu_type())) {
                    this.Zz.setText(d.j.bawu_manage_assist_tip);
                    this.Zz.setVisibility(0);
                } else if (YR.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Zz.setVisibility(8);
                }
            } else if (YR.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Zz.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Zx;
    }

    public View getUserName() {
        return this.Zy;
    }

    private void k(bg bgVar) {
        al.k(this.Zz, d.f.brand_official_btn);
        al.j(this.Zz, d.C0277d.cp_btn_a);
        this.Zz.setText(d.j.video_mcn);
        if (bgVar.ZR()) {
            this.ZA.setVisibility(8);
        }
        this.Zz.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ZG = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.ZH = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.Zx != null) {
            this.Zx.setPageId(bdUniqueId);
        }
    }

    private void l(bg bgVar) {
        if (this.ZC != null) {
            if (bgVar == null || (bgVar.getAddress() == null && bgVar.YK() == 0)) {
                this.ZC.setVisibility(8);
                return;
            }
            al.j(this.ZC, d.C0277d.cp_cont_d);
            this.ZC.setText(bgVar.Yq());
            this.ZC.setVisibility(bC(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rH() {
        int width;
        if (bC(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.Zy.getMeasuredHeight());
            layoutParams.setMargins(l.h(this.mContext, d.e.tbds10), l.h(this.mContext, d.e.tbds_5), 0, 0);
            this.ZD.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.Zy.getPaint();
        int i = l.aS(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.h(this.mContext, d.e.tbds107)) > 0) {
            int c = l.c(paint, v(this.XS.YR().getName_show(), 12)) + this.Zy.getPaddingLeft() + this.Zy.getPaddingRight();
            int c2 = l.c(paint, v(this.XS.YR().getName_show(), 10)) + this.Zy.getPaddingLeft() + this.Zy.getPaddingRight();
            int measuredWidth = this.ZB.getMeasuredWidth();
            int measuredWidth2 = this.Zy.getMeasuredWidth();
            int measuredWidth3 = this.ZD.getMeasuredWidth();
            int measuredWidth4 = this.Zz.getMeasuredWidth();
            int measuredWidth5 = this.ZA.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c) {
                    this.Zy.setText(v(this.XS.YR().getName_show(), 12));
                } else if (width < c + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.Zy.setText(v(this.XS.YR().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c2) {
                    this.ZA.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + c2) {
                    this.Zz.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + c2) {
                    this.ZB.setVisibility(8);
                }
                if (width > c2 + measuredWidth3) {
                    this.ZD.setVisibility(8);
                }
            }
        }
    }
}

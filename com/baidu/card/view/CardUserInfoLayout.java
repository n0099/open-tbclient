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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private bg VJ;
    private View.OnClickListener XA;
    private View XB;
    private int XC;
    private Runnable XD;
    private View.OnClickListener XE;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    private HeadPendantClickableView Xp;
    private TextView Xq;
    private TextView Xr;
    private UserIconBox Xs;
    private UserIconBox Xt;
    private TextView Xu;
    private TextView Xv;
    protected RelativeLayout Xw;
    private View Xx;
    private FrameLayout Xy;
    private View.OnClickListener Xz;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.XC = 1285;
        this.XD = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.qC();
            }
        };
        this.XE = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.VJ != null && CardUserInfoLayout.this.VJ.adv() != null && CardUserInfoLayout.this.VJ.adv().getTShowInfoNew() != null && v.c(CardUserInfoLayout.this.VJ.adv().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.VJ.adv().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.VJ != null && CardUserInfoLayout.this.VJ.adv() != null && !StringUtils.isNull(CardUserInfoLayout.this.VJ.adv().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.VJ.adv().getUserId()) && CardUserInfoLayout.this.VJ.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.VJ.aeF() != null && CardUserInfoLayout.this.VJ.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.VJ.aeF().channelId, CardUserInfoLayout.this.VJ.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.VJ.adv().getUserId(), CardUserInfoLayout.this.VJ.adv().getName_show(), CardUserInfoLayout.this.VJ.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.VJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.Xz != null) {
                        CardUserInfoLayout.this.Xz.onClick(view);
                    }
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.VJ != null && CardUserInfoLayout.this.VJ.adv() != null) {
                    a.a(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.VJ.adv().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.XA != null) {
                        CardUserInfoLayout.this.Xz.onClick(view);
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
        qA();
    }

    public void setShowFlag(int i) {
        this.XC = i;
        qz();
    }

    private void qz() {
        this.Xt.setVisibility(by(1) ? 0 : 8);
        this.Xq.setVisibility(by(4) ? 0 : 8);
        this.Xr.setVisibility(by(16) ? 0 : 8);
        this.Xv.setVisibility(by(8) ? 0 : 8);
        this.Xs.setVisibility(by(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XB.getLayoutParams();
        if (by(128)) {
            this.Xu.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.Xu.setVisibility(8);
            layoutParams.bottomMargin = l.g(getContext(), R.dimen.tbds4);
        }
        this.XB.setLayoutParams(layoutParams);
        if (by(64)) {
            this.Xy.setVisibility(0);
            this.Xx = b.Zl().n(getContext(), 1);
            if (this.Xx != null) {
                this.Xx.setVisibility(8);
                this.Xy.addView(this.Xx);
                return;
            }
            return;
        }
        this.Xy.setVisibility(8);
    }

    private boolean by(int i) {
        return (this.XC & i) > 0;
    }

    private void qA() {
        this.Xp = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.Xp.setHasPendantStyle();
        this.Xp.getHeadView().setIsRound(true);
        this.Xp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xp.getHeadView().setDefaultResource(17170445);
        this.Xp.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.Xp.getHeadView().setDefaultBgResource(e.get());
        this.Xp.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Xz != null) {
                    CardUserInfoLayout.this.Xz.onClick(view);
                }
            }
        });
        this.Xt = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.Xt.setOnClickListener(this.XE);
        this.Xq = (TextView) findViewById(R.id.user_name);
        this.Xq.setOnClickListener(this.XF);
        this.Xr = (TextView) findViewById(R.id.identity_view);
        this.Xv = (TextView) findViewById(R.id.thread_share_intro);
        this.Xs = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.Xs.setOnClickListener(this.XG);
        this.Xu = (TextView) findViewById(R.id.thread_extend_info);
        this.Xy = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.XB = findViewById(R.id.user_name_and_reply_time);
        this.Xw = (RelativeLayout) findViewById(R.id.suffix_container);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Xp.getHeadView().setDefaultBgResource(e.get());
        }
    }

    private void c(bg bgVar) {
        if (this.Xp != null && bgVar != null && this.VJ.adv() != null) {
            if (!by(1024)) {
                this.Xp.ax(false);
            } else if (this.VJ.bKO > 0 && this.VJ.bKP == 0) {
                this.Xp.ax(false);
            } else {
                this.Xp.ax(this.VJ.adv().isBigV());
            }
        }
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        this.VJ = bgVar;
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
            this.XB.post(this.XD);
        }
    }

    private void d(bg bgVar) {
        if (bgVar.adv() == null) {
            this.Xp.setVisibility(8);
            return;
        }
        MetaData adv = bgVar.adv();
        if (!by(256)) {
            adv.setPendantData(null);
        }
        this.Xp.setData(bgVar);
    }

    private void e(bg bgVar) {
        if (bgVar != null && bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
            if (this.Xx != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bzQ = alaUserData;
                aVar.type = 1;
                this.Xx.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.Xx.setVisibility(8);
                } else {
                    this.Xx.setVisibility(0);
                }
            }
        } else if (this.Xx != null) {
            this.Xx.setVisibility(8);
        }
    }

    private void f(bg bgVar) {
        if (this.Xq != null && bgVar != null) {
            if (!StringUtils.isNull(this.VJ.acT())) {
                this.Xq.setText(this.VJ.acT());
            } else {
                this.Xq.setText(R.string.user_name_default_txt);
            }
            qB();
        }
    }

    protected void g(bg bgVar) {
        if (this.Xv != null) {
            if (bgVar == null || (!by(8) && !by(512))) {
                this.Xv.setVisibility(8);
            } else if (this.VJ.getType() == bg.bJV) {
                this.Xv.setVisibility(0);
                this.Xv.getPaint().setFakeBoldText(true);
                this.Xv.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                al.j(this.Xv, R.color.cp_cont_b);
            } else if (by(8)) {
                if (StringUtils.isNull(bgVar.abw())) {
                    this.Xv.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xv.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.Xv.setLayoutParams(layoutParams);
                }
                this.Xv.setText(bgVar.abw());
                this.Xv.setVisibility(0);
            } else if (StringUtils.isNull(this.VJ.acV())) {
                this.Xv.setVisibility(8);
            } else {
                this.Xv.setVisibility(0);
                this.Xv.setText(this.VJ.acV());
            }
        }
    }

    private void h(bg bgVar) {
        if (this.Xs != null) {
            if (!by(32)) {
                this.Xs.setVisibility(8);
            } else if (bgVar == null || bgVar.adv() == null || (bgVar.bKO > 0 && bgVar.bKP == 0)) {
                this.Xs.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.Xs.setVisibility(0);
                    this.Xs.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.Xs.setVisibility(8);
            }
        }
    }

    protected String p(String str, int i) {
        return ap.j(str, i, "...");
    }

    private void qB() {
        if (this.VJ != null && this.VJ.adv() != null) {
            if (this.VJ.bKO > 0 && this.VJ.bKP == 0) {
                al.j(this.Xq, R.color.cp_cont_f);
            } else if (!v.aa(this.VJ.adv().getTShowInfoNew())) {
                al.j(this.Xq, R.color.cp_cont_h);
            } else if (this.VJ.adv().isBigV()) {
                if (by(1024)) {
                    al.j(this.Xq, R.color.cp_cont_h);
                } else {
                    al.j(this.Xq, R.color.cp_cont_f);
                }
            } else {
                al.j(this.Xq, R.color.cp_cont_f);
            }
        }
    }

    private void i(bg bgVar) {
        if (this.Xt != null && bgVar != null && bgVar.adv() != null && by(1)) {
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xt.setVisibility(0);
                this.Xt.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Xt.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Xr != null && bgVar != null && bgVar.adv() != null && by(16)) {
            MetaData adv = bgVar.adv();
            if (adv.getIs_bawu() == 1) {
                al.k(this.Xr, R.drawable.brand_official_btn);
                al.j(this.Xr, R.color.cp_btn_a);
                if (bgVar.bLb) {
                    this.Xr.setVisibility(0);
                    this.Xr.setText(R.string.brand_Official);
                } else if ("manager".equals(adv.getBawu_type())) {
                    this.Xr.setVisibility(0);
                    this.Xr.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_member_xbazhu_tip);
                    this.Xr.setVisibility(0);
                } else if ("pri_content_assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_content_assist_tip);
                    this.Xr.setVisibility(0);
                } else if ("pri_manage_assist".equals(adv.getBawu_type())) {
                    this.Xr.setText(R.string.bawu_manage_assist_tip);
                    this.Xr.setVisibility(0);
                } else if (adv.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Xr.setVisibility(8);
                }
            } else if (adv.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Xr.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Xp;
    }

    public View getUserName() {
        return this.Xq;
    }

    private void k(bg bgVar) {
        al.k(this.Xr, R.drawable.brand_official_btn);
        al.j(this.Xr, R.color.cp_btn_a);
        this.Xr.setText(R.string.video_mcn);
        if (bgVar.aev()) {
            this.Xs.setVisibility(8);
        }
        this.Xr.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Xz = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.Xp != null) {
            this.Xp.setPageId(bdUniqueId);
        }
    }

    private void l(bg bgVar) {
        if (this.Xu != null) {
            if (bgVar == null || (bgVar.getAddress() == null && bgVar.ado() == 0)) {
                this.Xu.setVisibility(8);
                return;
            }
            al.j(this.Xu, R.color.cp_cont_d);
            this.Xu.setText(bgVar.acU());
            this.Xu.setVisibility(by(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qC() {
        int width;
        if (by(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.Xq.getMeasuredHeight());
            layoutParams.setMargins(l.g(this.mContext, R.dimen.tbds10), l.g(this.mContext, R.dimen.tbds_5), 0, 0);
            this.Xv.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.Xq.getPaint();
        int i = l.aj(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.g(this.mContext, R.dimen.tbds107)) > 0) {
            int c = l.c(paint, p(this.VJ.adv().getName_show(), 12)) + this.Xq.getPaddingLeft() + this.Xq.getPaddingRight();
            int c2 = l.c(paint, p(this.VJ.adv().getName_show(), 10)) + this.Xq.getPaddingLeft() + this.Xq.getPaddingRight();
            int measuredWidth = this.Xt.getMeasuredWidth();
            int measuredWidth2 = this.Xq.getMeasuredWidth();
            int measuredWidth3 = this.Xv.getMeasuredWidth();
            int measuredWidth4 = this.Xr.getMeasuredWidth();
            int measuredWidth5 = this.Xs.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c) {
                    this.Xq.setText(p(this.VJ.adv().getName_show(), 12));
                } else if (width < c + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.Xq.setText(p(this.VJ.adv().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c2) {
                    this.Xs.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + c2) {
                    this.Xr.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + c2) {
                    this.Xt.setVisibility(8);
                }
                if (width > c2 + measuredWidth3) {
                    this.Xv.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.Xw;
    }
}

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
    private bg VK;
    private View.OnClickListener XA;
    private View.OnClickListener XB;
    private View XC;
    private int XD;
    private Runnable XE;
    private View.OnClickListener XF;
    private View.OnClickListener XG;
    private View.OnClickListener XH;
    private HeadPendantClickableView Xq;
    private TextView Xr;
    private TextView Xs;
    private UserIconBox Xt;
    private UserIconBox Xu;
    private TextView Xv;
    private TextView Xw;
    protected RelativeLayout Xx;
    private View Xy;
    private FrameLayout Xz;
    private Context mContext;
    private int mSkinType;

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.XD = 1285;
        this.XE = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.qC();
            }
        };
        this.XF = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.cE(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.VK != null && CardUserInfoLayout.this.VK.adv() != null && CardUserInfoLayout.this.VK.adv().getTShowInfoNew() != null && v.c(CardUserInfoLayout.this.VK.adv().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.VK.adv().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aiz().c((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.XG = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.VK != null && CardUserInfoLayout.this.VK.adv() != null && !StringUtils.isNull(CardUserInfoLayout.this.VK.adv().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.VK.adv().getUserId()) && CardUserInfoLayout.this.VK.adA() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.cE(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (CardUserInfoLayout.this.VK.aeF() != null && CardUserInfoLayout.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.VK.aeF().channelId, CardUserInfoLayout.this.VK.aeF().mCurrentPage)));
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.VK.adv().getUserId(), CardUserInfoLayout.this.VK.adv().getName_show(), CardUserInfoLayout.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                        personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.VK.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                    if (CardUserInfoLayout.this.XA != null) {
                        CardUserInfoLayout.this.XA.onClick(view);
                    }
                }
            }
        };
        this.XH = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.VK != null && CardUserInfoLayout.this.VK.adv() != null) {
                    a.a(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.VK.adv().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.XB != null) {
                        CardUserInfoLayout.this.XA.onClick(view);
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
        this.XD = i;
        qz();
    }

    private void qz() {
        this.Xu.setVisibility(by(1) ? 0 : 8);
        this.Xr.setVisibility(by(4) ? 0 : 8);
        this.Xs.setVisibility(by(16) ? 0 : 8);
        this.Xw.setVisibility(by(8) ? 0 : 8);
        this.Xt.setVisibility(by(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.XC.getLayoutParams();
        if (by(128)) {
            this.Xv.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.Xv.setVisibility(8);
            layoutParams.bottomMargin = l.g(getContext(), R.dimen.tbds4);
        }
        this.XC.setLayoutParams(layoutParams);
        if (by(64)) {
            this.Xz.setVisibility(0);
            this.Xy = b.Zl().n(getContext(), 1);
            if (this.Xy != null) {
                this.Xy.setVisibility(8);
                this.Xz.addView(this.Xy);
                return;
            }
            return;
        }
        this.Xz.setVisibility(8);
    }

    private boolean by(int i) {
        return (this.XD & i) > 0;
    }

    private void qA() {
        this.Xq = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.Xq.setHasPendantStyle();
        this.Xq.getHeadView().setIsRound(true);
        this.Xq.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xq.getHeadView().setDefaultResource(17170445);
        this.Xq.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.Xq.getHeadView().setDefaultBgResource(e.get());
        this.Xq.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.XA != null) {
                    CardUserInfoLayout.this.XA.onClick(view);
                }
            }
        });
        this.Xu = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.Xu.setOnClickListener(this.XF);
        this.Xr = (TextView) findViewById(R.id.user_name);
        this.Xr.setOnClickListener(this.XG);
        this.Xs = (TextView) findViewById(R.id.identity_view);
        this.Xw = (TextView) findViewById(R.id.thread_share_intro);
        this.Xt = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.Xt.setOnClickListener(this.XH);
        this.Xv = (TextView) findViewById(R.id.thread_extend_info);
        this.Xz = (FrameLayout) findViewById(R.id.ala_live_info_content_layout);
        this.XC = findViewById(R.id.user_name_and_reply_time);
        this.Xx = (RelativeLayout) findViewById(R.id.suffix_container);
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Xq.getHeadView().setDefaultBgResource(e.get());
        }
    }

    private void c(bg bgVar) {
        if (this.Xq != null && bgVar != null && this.VK.adv() != null) {
            if (!by(1024)) {
                this.Xq.ax(false);
            } else if (this.VK.bKN > 0 && this.VK.bKO == 0) {
                this.Xq.ax(false);
            } else {
                this.Xq.ax(this.VK.adv().isBigV());
            }
        }
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        this.VK = bgVar;
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
            this.XC.post(this.XE);
        }
    }

    private void d(bg bgVar) {
        if (bgVar.adv() == null) {
            this.Xq.setVisibility(8);
            return;
        }
        MetaData adv = bgVar.adv();
        if (!by(256)) {
            adv.setPendantData(null);
        }
        this.Xq.setData(bgVar);
    }

    private void e(bg bgVar) {
        if (bgVar != null && bgVar.adv() != null && bgVar.adv().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = bgVar.adv().getAlaUserData();
            if (this.Xy != null) {
                com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                aVar.bzQ = alaUserData;
                aVar.type = 1;
                this.Xy.setTag(aVar);
                if (alaUserData.anchor_live == 0) {
                    this.Xy.setVisibility(8);
                } else {
                    this.Xy.setVisibility(0);
                }
            }
        } else if (this.Xy != null) {
            this.Xy.setVisibility(8);
        }
    }

    private void f(bg bgVar) {
        if (this.Xr != null && bgVar != null) {
            if (!StringUtils.isNull(this.VK.acT())) {
                this.Xr.setText(this.VK.acT());
            } else {
                this.Xr.setText(R.string.user_name_default_txt);
            }
            qB();
        }
    }

    protected void g(bg bgVar) {
        if (this.Xw != null) {
            if (bgVar == null || (!by(8) && !by(512))) {
                this.Xw.setVisibility(8);
            } else if (this.VK.getType() == bg.bJU) {
                this.Xw.setVisibility(0);
                this.Xw.getPaint().setFakeBoldText(true);
                this.Xw.setText(this.mContext.getString(R.string.interview_live_info_tip_is_live));
                al.j(this.Xw, R.color.cp_cont_b);
            } else if (by(8)) {
                if (StringUtils.isNull(bgVar.abw())) {
                    this.Xw.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xw.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.Xw.setLayoutParams(layoutParams);
                }
                this.Xw.setText(bgVar.abw());
                this.Xw.setVisibility(0);
            } else if (StringUtils.isNull(this.VK.acV())) {
                this.Xw.setVisibility(8);
            } else {
                this.Xw.setVisibility(0);
                this.Xw.setText(this.VK.acV());
            }
        }
    }

    private void h(bg bgVar) {
        if (this.Xt != null) {
            if (!by(32)) {
                this.Xt.setVisibility(8);
            } else if (bgVar == null || bgVar.adv() == null || (bgVar.bKN > 0 && bgVar.bKO == 0)) {
                this.Xt.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bgVar.adv().getIconInfo();
                if (v.Z(iconInfo) != 0) {
                    this.Xt.setVisibility(0);
                    this.Xt.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.Xt.setVisibility(8);
            }
        }
    }

    protected String p(String str, int i) {
        return ap.j(str, i, "...");
    }

    private void qB() {
        if (this.VK != null && this.VK.adv() != null) {
            if (this.VK.bKN > 0 && this.VK.bKO == 0) {
                al.j(this.Xr, R.color.cp_cont_f);
            } else if (!v.aa(this.VK.adv().getTShowInfoNew())) {
                al.j(this.Xr, R.color.cp_cont_h);
            } else if (this.VK.adv().isBigV()) {
                if (by(1024)) {
                    al.j(this.Xr, R.color.cp_cont_h);
                } else {
                    al.j(this.Xr, R.color.cp_cont_f);
                }
            } else {
                al.j(this.Xr, R.color.cp_cont_f);
            }
        }
    }

    private void i(bg bgVar) {
        if (this.Xu != null && bgVar != null && bgVar.adv() != null && by(1)) {
            ArrayList<IconData> tShowInfoNew = bgVar.adv().getTShowInfoNew();
            if (v.Z(tShowInfoNew) != 0) {
                this.Xu.setVisibility(0);
                this.Xu.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Xu.setVisibility(8);
        }
    }

    private void j(bg bgVar) {
        if (this.Xs != null && bgVar != null && bgVar.adv() != null && by(16)) {
            MetaData adv = bgVar.adv();
            if (adv.getIs_bawu() == 1) {
                al.k(this.Xs, R.drawable.brand_official_btn);
                al.j(this.Xs, R.color.cp_btn_a);
                if (bgVar.bLa) {
                    this.Xs.setVisibility(0);
                    this.Xs.setText(R.string.brand_Official);
                } else if ("manager".equals(adv.getBawu_type())) {
                    this.Xs.setVisibility(0);
                    this.Xs.setText(R.string.bawu_member_bazhu_tip);
                } else if ("assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_member_xbazhu_tip);
                    this.Xs.setVisibility(0);
                } else if ("pri_content_assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_content_assist_tip);
                    this.Xs.setVisibility(0);
                } else if ("pri_manage_assist".equals(adv.getBawu_type())) {
                    this.Xs.setText(R.string.bawu_manage_assist_tip);
                    this.Xs.setVisibility(0);
                } else if (adv.getIs_biggie()) {
                    k(bgVar);
                } else {
                    this.Xs.setVisibility(8);
                }
            } else if (adv.getIs_biggie()) {
                k(bgVar);
            } else {
                this.Xs.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Xq;
    }

    public View getUserName() {
        return this.Xr;
    }

    private void k(bg bgVar) {
        al.k(this.Xs, R.drawable.brand_official_btn);
        al.j(this.Xs, R.color.cp_btn_a);
        this.Xs.setText(R.string.video_mcn);
        if (bgVar.aev()) {
            this.Xt.setVisibility(8);
        }
        this.Xs.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.XB = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.Xq != null) {
            this.Xq.setPageId(bdUniqueId);
        }
    }

    private void l(bg bgVar) {
        if (this.Xv != null) {
            if (bgVar == null || (bgVar.getAddress() == null && bgVar.ado() == 0)) {
                this.Xv.setVisibility(8);
                return;
            }
            al.j(this.Xv, R.color.cp_cont_d);
            this.Xv.setText(bgVar.acU());
            this.Xv.setVisibility(by(128) ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qC() {
        int width;
        if (by(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.Xr.getMeasuredHeight());
            layoutParams.setMargins(l.g(this.mContext, R.dimen.tbds10), l.g(this.mContext, R.dimen.tbds_5), 0, 0);
            this.Xw.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.Xr.getPaint();
        int i = l.aj(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.g(this.mContext, R.dimen.tbds107)) > 0) {
            int c = l.c(paint, p(this.VK.adv().getName_show(), 12)) + this.Xr.getPaddingLeft() + this.Xr.getPaddingRight();
            int c2 = l.c(paint, p(this.VK.adv().getName_show(), 10)) + this.Xr.getPaddingLeft() + this.Xr.getPaddingRight();
            int measuredWidth = this.Xu.getMeasuredWidth();
            int measuredWidth2 = this.Xr.getMeasuredWidth();
            int measuredWidth3 = this.Xw.getMeasuredWidth();
            int measuredWidth4 = this.Xs.getMeasuredWidth();
            int measuredWidth5 = this.Xt.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c) {
                    this.Xr.setText(p(this.VK.adv().getName_show(), 12));
                } else if (width < c + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.Xr.setText(p(this.VK.adv().getName_show(), 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + c2) {
                    this.Xt.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + c2) {
                    this.Xs.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + c2) {
                    this.Xu.setVisibility(8);
                }
                if (width > c2 + measuredWidth3) {
                    this.Xw.setVisibility(8);
                }
            }
        }
    }

    public RelativeLayout getSuffixContainer() {
        return this.Xx;
    }
}

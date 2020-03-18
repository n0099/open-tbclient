package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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
import com.baidu.card.n;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class CardUserInfoLayout extends LinearLayout implements n {
    private bj KJ;
    private View NB;
    private c NC;
    private int ND;
    private Runnable NF;
    private View.OnClickListener NG;
    private View.OnClickListener NH;
    private View.OnClickListener NI;
    private HeadPendantClickableView Nk;
    private TBLottieAnimationView Nl;
    private TextView Nm;
    private TextView Nn;
    private UserIconBox No;
    private UserIconBox Np;
    private TextView Nq;
    private TextView Nr;
    protected RelativeLayout Ns;
    private DynamicUserLikeButton Nt;
    private ImageView Nu;
    private LayerDrawable Nv;
    private LayerDrawable Nw;
    private View.OnClickListener Nx;
    private View.OnClickListener Ny;
    private View Nz;
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
        this.ND = 34053;
        this.NF = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.nv();
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCr() != null && CardUserInfoLayout.this.KJ.aCr().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.KJ.aCr().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.KJ.aCr().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGK().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCr() != null && !StringUtils.isNull(CardUserInfoLayout.this.KJ.aCr().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.KJ.aCr().getUserId()) && CardUserInfoLayout.this.KJ.aCw() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.KJ.aCr().getUserId(), CardUserInfoLayout.this.KJ.aCr().getName_show(), CardUserInfoLayout.this.KJ.aCw(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.Nx != null) {
                        CardUserInfoLayout.this.Nx.onClick(view);
                    }
                }
            }
        };
        this.NI = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCr() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.KJ.aCr().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.Ny != null) {
                        CardUserInfoLayout.this.Nx.onClick(view);
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
        ns();
        nw();
        this.tbds40 = l.getDimens(this.mContext, R.dimen.tbds40);
        this.tbds164 = l.getDimens(this.mContext, R.dimen.tbds164);
        this.tbds156 = l.getDimens(this.mContext, R.dimen.tbds156);
        this.tbds148 = l.getDimens(this.mContext, R.dimen.tbds148);
        this.tbds118 = l.getDimens(this.mContext, R.dimen.tbds118);
        this.tbds580 = l.getDimens(this.mContext, R.dimen.tbds580);
    }

    public void setShowFlag(int i) {
        this.ND = i;
        nr();
    }

    private void nr() {
        this.Np.setVisibility(isShow(1) ? 0 : 8);
        this.Nm.setVisibility(isShow(4) ? 0 : 8);
        this.Nn.setVisibility(isShow(16) ? 0 : 8);
        this.Nr.setVisibility(isShow(8) ? 0 : 8);
        this.No.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nz.getLayoutParams();
        if (isShow(128)) {
            this.Nq.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.Nq.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.Nz.setLayoutParams(layoutParams);
        this.Nt.setVisibility(isShow(2048) ? 0 : 8);
        this.Nu.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.ND & i) > 0;
    }

    private void ns() {
        this.Nk = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.Nk.setHasPendantStyle();
        this.Nk.getHeadView().setIsRound(true);
        this.Nk.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Nk.getHeadView().setDefaultResource(17170445);
        this.Nk.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.Nk.getHeadView().setPlaceHolder(1);
        this.Nk.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Nx != null) {
                    CardUserInfoLayout.this.Nx.onClick(view);
                }
            }
        });
        this.Nl = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.Np = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.Np.setOnClickListener(this.NG);
        this.Nm = (TextView) findViewById(R.id.user_name);
        this.Nm.setOnClickListener(this.NH);
        this.Nn = (TextView) findViewById(R.id.identity_view);
        this.Nr = (TextView) findViewById(R.id.thread_share_intro);
        this.No = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.No.setOnClickListener(this.NI);
        this.Nq = (TextView) findViewById(R.id.thread_extend_info);
        this.Nz = findViewById(R.id.user_name_and_reply_time);
        this.NB = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.Ns = (RelativeLayout) findViewById(R.id.suffix_container);
        this.Nt = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.Nu = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Nk.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.Nv != null && this.Nv.getDrawable(1) != null) {
                    this.Nv.getDrawable(1).setAlpha(255);
                }
                if (this.Nw != null && this.Nw.getDrawable(1) != null) {
                    this.Nw.getDrawable(1).setAlpha(255);
                }
                if (this.Nl != null) {
                    this.Nl.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.Nl != null) {
                    this.Nl.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.Nv != null && this.Nv.getDrawable(1) != null) {
                    this.Nv.getDrawable(1).setAlpha(0);
                }
                if (this.Nw != null && this.Nw.getDrawable(1) != null) {
                    this.Nw.getDrawable(1).setAlpha(0);
                }
                if (this.Nl != null) {
                    this.Nl.setAnimation("live/card_live_bg.json");
                }
            }
            this.Nt.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.Nk != null && bjVar != null && this.KJ.aCr() != null) {
            this.Nk.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.Nk, this.KJ.aCr(), 0)) {
                if (this.KJ.cUc > 0 && this.KJ.cUd == 0) {
                    this.Nk.fR(false);
                } else {
                    this.Nk.a(this.KJ.aCr(), 0);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        this.KJ = bjVar;
        e(bjVar);
        f(bjVar);
        k(bjVar);
        l(bjVar);
        h(bjVar);
        j(bjVar);
        c(bjVar);
        n(bjVar);
        i(bjVar);
        g(bjVar);
        nu();
        d(bjVar);
        setVisibility(0);
        if (isShow(128) && !bjVar.cUF && !bjVar.aEf()) {
            this.Nz.post(this.NF);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.Nu != null) {
            if (bjVar.cUA) {
                this.Nu.setVisibility(0);
            } else {
                this.Nu.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.aCr() != null) {
            String userId = bjVar.aCr().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aEj() || bjVar.aBg() || bjVar.aBh()) && bjVar.cUF && !TextUtils.equals(userId, currentAccount)) {
                this.ND |= 2048;
            } else if ((bjVar.aEj() || bjVar.aBg() || bjVar.aBh()) && bjVar.cUG && !bjVar.aCr().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.ND |= 2048;
            } else if (bjVar.aCK() != null && j.ab(bjVar) && bjVar.cUF && !TextUtils.equals(userId, currentAccount)) {
                this.ND |= 2048;
            } else {
                this.ND &= -2049;
            }
            if (bjVar.aEg()) {
                this.ND |= 4096;
            } else {
                this.ND &= -4097;
            }
            if (bjVar.cUF && !bjVar.aEm()) {
                this.ND &= -129;
            } else {
                this.ND |= 128;
            }
            setShowFlag(this.ND);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.aCr() == null) {
            this.Nk.setVisibility(8);
            return;
        }
        MetaData aCr = bjVar.aCr();
        if (!isShow(256)) {
            aCr.setPendantData(null);
        }
        this.Nk.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (!isShow(32768)) {
            this.Nl.setVisibility(8);
            if (this.Nl.isAnimating()) {
                this.Nl.cancelAnimation();
            }
            this.Nk.setIsclearmode(false);
        } else if (bjVar != null && bjVar.aCr() != null && bjVar.aCr().getAlaUserData() != null) {
            if (bjVar.aCr().getAlaUserData().live_status != 1) {
                this.Nl.setVisibility(8);
                this.Nl.cancelAnimation();
                this.Nk.setIsclearmode(false);
                return;
            }
            this.Nk.setIsclearmode(true);
            this.ND &= -257;
            f(bjVar);
            this.Nl.setSpeed(0.8f);
            this.Nl.setVisibility(0);
            this.Nl.loop(true);
            this.Nl.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.Nl.playAnimation();
                }
            });
        } else {
            this.Nl.setVisibility(8);
            this.Nl.cancelAnimation();
            this.Nk.setIsclearmode(false);
        }
    }

    private void h(bj bjVar) {
        if (this.Nm != null && bjVar != null) {
            if (bjVar.cUF || bjVar.aEf()) {
                ViewGroup.LayoutParams layoutParams = this.Nz.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.Nz.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.NB.getLayoutParams();
                layoutParams2.width = -1;
                this.NB.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.Nm.getLayoutParams();
                layoutParams3.width = -1;
                this.Nm.setLayoutParams(layoutParams3);
                this.Nm.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.aCr() != null && !StringUtils.isNull(bjVar.aCr().getName_show())) {
                    this.Nm.setText(bjVar.aCr().getName_show());
                } else {
                    this.Nm.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.KJ.aBP())) {
                this.Nm.setText(this.KJ.aBP());
            } else {
                this.Nm.setText(R.string.user_name_default_txt);
            }
            nt();
        }
    }

    protected void i(bj bjVar) {
        if (this.Nr != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.Nr.setVisibility(8);
            } else if (this.KJ.getType() == bj.cTr) {
                this.Nr.setVisibility(0);
                this.Nr.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.Nr, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.aAk())) {
                    this.Nr.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nr.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.Nr.setLayoutParams(layoutParams);
                }
                this.Nr.setText(bjVar.aAk());
                this.Nr.setVisibility(0);
            } else if (StringUtils.isNull(this.KJ.aBR())) {
                this.Nr.setVisibility(8);
            } else {
                this.Nr.setVisibility(0);
                this.Nr.setText(this.KJ.aBR());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.No != null) {
            if (!isShow(32)) {
                this.No.setVisibility(8);
            } else if (bjVar == null || bjVar.aCr() == null || (bjVar.cUc > 0 && bjVar.cUd == 0)) {
                this.No.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aCr().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.No.setVisibility(0);
                    this.No.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.No.setVisibility(8);
            }
        }
    }

    protected String o(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void nt() {
        if (this.KJ != null && this.KJ.aCr() != null) {
            if (this.KJ.cUc > 0 && this.KJ.cUd == 0) {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.KJ.aCr().getTShowInfoNew()) || this.KJ.aCr().isBigV()) {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.Np != null && bjVar != null && bjVar.aCr() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.aCr().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.Np.setVisibility(0);
                this.Np.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.Np.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.Nn != null && bjVar != null && bjVar.aCr() != null && isShow(16)) {
            MetaData aCr = bjVar.aCr();
            if (this.Nn.getLayoutParams() != null) {
                this.Nn.getLayoutParams().width = -2;
            }
            this.Nn.setOnClickListener(null);
            if (aCr.getIs_bawu() == 1) {
                am.setBackgroundResource(this.Nn, R.drawable.brand_official_btn);
                am.setViewTextColor(this.Nn, (int) R.color.cp_cont_a);
                if (bjVar.cUp) {
                    this.Nn.setVisibility(0);
                    this.Nn.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aCr.getBawu_type())) {
                    this.Nn.setBackgroundDrawable(this.Nv);
                    this.Nn.setVisibility(0);
                    this.Nn.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aCr.getBawu_type())) {
                    this.Nn.setBackgroundDrawable(this.Nw);
                    this.Nn.setText(R.string.bawu_member_xbazhu_tip);
                    this.Nn.setVisibility(0);
                } else if ("pri_content_assist".equals(aCr.getBawu_type())) {
                    this.Nn.setText(R.string.bawu_content_assist_tip);
                    this.Nn.setVisibility(0);
                } else if ("pri_manage_assist".equals(aCr.getBawu_type())) {
                    this.Nn.setText(R.string.bawu_manage_assist_tip);
                    this.Nn.setVisibility(0);
                } else if (aCr.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.Nn.setVisibility(8);
                }
            } else if (aCr.getIs_biggie()) {
                m(bjVar);
            } else {
                this.Nn.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Nk;
    }

    public View getUserName() {
        return this.Nm;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.Nn, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Nn, (int) R.color.cp_cont_a);
        this.Nn.setText(R.string.video_mcn);
        if (bjVar.aDw()) {
            this.No.setVisibility(8);
        }
        this.Nn.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nx = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.Ny = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.Nk != null) {
            this.Nk.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.Nq != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.aBQ())) {
                this.Nq.setVisibility(8);
                return;
            }
            if (bjVar.aCr() != null && bjVar.aCr().isBaijiahaoUser()) {
                this.Nq.setLines(1);
                this.Nq.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.Nq.setMaxLines(Integer.MAX_VALUE);
                this.Nq.setEllipsize(null);
            }
            am.setViewTextColor(this.Nq, (int) R.color.cp_cont_d);
            this.Nq.setText(bjVar.aBQ());
            this.Nq.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void nu() {
        if (isShow(2048) && this.KJ != null && this.KJ.aCr() != null && this.mPageContext != null && this.Nt != null) {
            if (this.NC == null) {
                this.NC = new c(this.mPageContext, this.Nt);
                this.NC.j(this.mBdUniqueId);
            }
            this.NC.a(this.KJ.aCr());
            this.Nt.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.7
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cx("obj_id", CardUserInfoLayout.this.KJ.aCr().getUserId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).cx("tid", CardUserInfoLayout.this.KJ.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nv() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.Nm.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.Nr.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.Nm.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, o(this.KJ.aCr().getName_show(), 12)) + this.Nm.getPaddingLeft() + this.Nm.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, o(this.KJ.aCr().getName_show(), 10)) + this.Nm.getPaddingLeft() + this.Nm.getPaddingRight();
            int measuredWidth = this.Np.getMeasuredWidth();
            int measuredWidth2 = this.Nm.getMeasuredWidth();
            int measuredWidth3 = this.Nr.getMeasuredWidth();
            int measuredWidth4 = this.Nn.getMeasuredWidth();
            int measuredWidth5 = this.No.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.Nm.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.Nm.setText(o(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.Nm.setText(o(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.No.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.Nn.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.Np.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.Nr.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.KJ != null && this.KJ.aCr() != null && this.KJ.aCr().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.Nq.setMaxWidth(i2);
        }
    }

    private void nw() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.Nv = new LayerDrawable(new Drawable[]{b.aHg().kB(0).af(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHi(), b.aHg().kB(0).af(this.tbds6).tM("#4D000000").aHi()});
        this.Nw = new LayerDrawable(new Drawable[]{b.aHg().kB(0).af(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHi(), b.aHg().kB(0).af(this.tbds6).tM("#4D000000").aHi()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.Ns;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

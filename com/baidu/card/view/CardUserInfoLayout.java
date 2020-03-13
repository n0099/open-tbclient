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
    private c NB;
    private int NC;
    private Runnable ND;
    private View.OnClickListener NF;
    private View.OnClickListener NG;
    private View.OnClickListener NH;
    private HeadPendantClickableView Nj;
    private TBLottieAnimationView Nk;
    private TextView Nl;
    private TextView Nm;
    private UserIconBox Nn;
    private UserIconBox No;
    private TextView Np;
    private TextView Nq;
    protected RelativeLayout Nr;
    private DynamicUserLikeButton Ns;
    private ImageView Nt;
    private LayerDrawable Nu;
    private LayerDrawable Nv;
    private View.OnClickListener Nw;
    private View.OnClickListener Nx;
    private View Ny;
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
        this.NC = 34053;
        this.ND = new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CardUserInfoLayout.this.nv();
            }
        };
        this.NF = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (bc.checkUpIsLogin(CardUserInfoLayout.this.mContext) && CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCo() != null && CardUserInfoLayout.this.KJ.aCo().getTShowInfoNew() != null && v.getItem(CardUserInfoLayout.this.KJ.aCo().getTShowInfoNew(), 0) != null && (url = CardUserInfoLayout.this.KJ.aCo().getTShowInfoNew().get(0).getUrl()) != null && (i.ab(CardUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    ba.aGG().b((TbPageContext) i.ab(CardUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.NG = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCo() != null && !StringUtils.isNull(CardUserInfoLayout.this.KJ.aCo().getName_show()) && !StringUtils.isNull(CardUserInfoLayout.this.KJ.aCo().getUserId()) && CardUserInfoLayout.this.KJ.aCt() != null) {
                    if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(R.id.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && bc.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.mContext, CardUserInfoLayout.this.KJ.aCo().getUserId(), CardUserInfoLayout.this.KJ.aCo().getName_show(), CardUserInfoLayout.this.KJ.aCt(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                    personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.KJ.getTid());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (CardUserInfoLayout.this.Nw != null) {
                        CardUserInfoLayout.this.Nw.onClick(view);
                    }
                }
            }
        };
        this.NH = new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.KJ != null && CardUserInfoLayout.this.KJ.aCo() != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(CardUserInfoLayout.this.mContext.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + CardUserInfoLayout.this.KJ.aCo().getUserId(), true, true, true);
                    if (CardUserInfoLayout.this.Nx != null) {
                        CardUserInfoLayout.this.Nw.onClick(view);
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
        this.NC = i;
        nr();
    }

    private void nr() {
        this.No.setVisibility(isShow(1) ? 0 : 8);
        this.Nl.setVisibility(isShow(4) ? 0 : 8);
        this.Nm.setVisibility(isShow(16) ? 0 : 8);
        this.Nq.setVisibility(isShow(8) ? 0 : 8);
        this.Nn.setVisibility(isShow(32) ? 0 : 8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ny.getLayoutParams();
        if (isShow(128)) {
            this.Np.setVisibility(0);
            layoutParams.bottomMargin = 0;
        } else {
            this.Np.setVisibility(8);
            layoutParams.bottomMargin = l.getDimens(getContext(), R.dimen.tbds4);
        }
        this.Ny.setLayoutParams(layoutParams);
        this.Ns.setVisibility(isShow(2048) ? 0 : 8);
        this.Nt.setVisibility(isShow(4096) ? 0 : 8);
    }

    private boolean isShow(int i) {
        return (this.NC & i) > 0;
    }

    private void ns() {
        this.Nj = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.Nj.setHasPendantStyle();
        this.Nj.getHeadView().setIsRound(true);
        this.Nj.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Nj.getHeadView().setDefaultResource(17170445);
        this.Nj.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.Nj.getHeadView().setPlaceHolder(1);
        this.Nj.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.CardUserInfoLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CardUserInfoLayout.this.Nw != null) {
                    CardUserInfoLayout.this.Nw.onClick(view);
                }
            }
        });
        this.Nk = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.No = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.No.setOnClickListener(this.NF);
        this.Nl = (TextView) findViewById(R.id.user_name);
        this.Nl.setOnClickListener(this.NG);
        this.Nm = (TextView) findViewById(R.id.identity_view);
        this.Nq = (TextView) findViewById(R.id.thread_share_intro);
        this.Nn = (UserIconBox) findViewById(R.id.thread_user_icon);
        this.Nn.setOnClickListener(this.NH);
        this.Np = (TextView) findViewById(R.id.thread_extend_info);
        this.Ny = findViewById(R.id.user_name_and_reply_time);
        this.Nz = findViewById(R.id.card_home_page_normal_thread_user_info);
        this.Nr = (RelativeLayout) findViewById(R.id.suffix_container);
        this.Ns = (DynamicUserLikeButton) findViewById(R.id.bjh_follow);
        this.Nt = (ImageView) findViewById(R.id.frs_head_line_mark);
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            this.Nj.getHeadView().setPlaceHolder(1);
            if (i == 1) {
                if (this.Nu != null && this.Nu.getDrawable(1) != null) {
                    this.Nu.getDrawable(1).setAlpha(255);
                }
                if (this.Nv != null && this.Nv.getDrawable(1) != null) {
                    this.Nv.getDrawable(1).setAlpha(255);
                }
                if (this.Nk != null) {
                    this.Nk.setAnimation("live/card_live_bg_night.json");
                }
            } else if (i == 4) {
                if (this.Nk != null) {
                    this.Nk.setAnimation("live/card_live_bg_black.json");
                }
            } else {
                if (this.Nu != null && this.Nu.getDrawable(1) != null) {
                    this.Nu.getDrawable(1).setAlpha(0);
                }
                if (this.Nv != null && this.Nv.getDrawable(1) != null) {
                    this.Nv.getDrawable(1).setAlpha(0);
                }
                if (this.Nk != null) {
                    this.Nk.setAnimation("live/card_live_bg.json");
                }
            }
            this.Ns.onChangeSkinType(i);
        }
    }

    private void c(bj bjVar) {
        if (this.Nj != null && bjVar != null && this.KJ.aCo() != null) {
            this.Nj.setBigVDimenSize(R.dimen.tbds32);
            if (!UtilHelper.showHeadBjhBigVIcon(this.Nj, this.KJ.aCo(), 0)) {
                if (this.KJ.cTP > 0 && this.KJ.cTQ == 0) {
                    this.Nj.fQ(false);
                } else {
                    this.Nj.a(this.KJ.aCo(), 0);
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
        if (isShow(128) && !bjVar.cUs && !bjVar.aEb()) {
            this.Ny.post(this.ND);
        }
    }

    private void d(bj bjVar) {
        if (isShow(4096) && bjVar != null && this.Nt != null) {
            if (bjVar.cUn) {
                this.Nt.setVisibility(0);
            } else {
                this.Nt.setVisibility(8);
            }
        }
    }

    private void e(bj bjVar) {
        if (bjVar != null && bjVar.aCo() != null) {
            String userId = bjVar.aCo().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if ((bjVar.aEf() || bjVar.aBd() || bjVar.aBe()) && bjVar.cUs && !TextUtils.equals(userId, currentAccount)) {
                this.NC |= 2048;
            } else if ((bjVar.aEf() || bjVar.aBd() || bjVar.aBe()) && bjVar.cUt && !bjVar.aCo().hadConcerned() && !TextUtils.equals(userId, currentAccount)) {
                this.NC |= 2048;
            } else if (bjVar.aCH() != null && j.aa(bjVar) && bjVar.cUs && !TextUtils.equals(userId, currentAccount)) {
                this.NC |= 2048;
            } else {
                this.NC &= -2049;
            }
            if (bjVar.aEc()) {
                this.NC |= 4096;
            } else {
                this.NC &= -4097;
            }
            if (bjVar.cUs && !bjVar.aEi()) {
                this.NC &= -129;
            } else {
                this.NC |= 128;
            }
            setShowFlag(this.NC);
        }
    }

    private void f(bj bjVar) {
        if (bjVar.aCo() == null) {
            this.Nj.setVisibility(8);
            return;
        }
        MetaData aCo = bjVar.aCo();
        if (!isShow(256)) {
            aCo.setPendantData(null);
        }
        this.Nj.setData(bjVar);
    }

    private void g(bj bjVar) {
        if (!isShow(32768)) {
            this.Nk.setVisibility(8);
            if (this.Nk.isAnimating()) {
                this.Nk.cancelAnimation();
            }
            this.Nj.setIsclearmode(false);
        } else if (bjVar != null && bjVar.aCo() != null && bjVar.aCo().getAlaUserData() != null) {
            if (bjVar.aCo().getAlaUserData().live_status != 1) {
                this.Nk.setVisibility(8);
                this.Nk.cancelAnimation();
                this.Nj.setIsclearmode(false);
                return;
            }
            this.Nj.setIsclearmode(true);
            this.NC &= -257;
            f(bjVar);
            this.Nk.setSpeed(0.8f);
            this.Nk.setVisibility(0);
            this.Nk.loop(true);
            this.Nk.post(new Runnable() { // from class: com.baidu.card.view.CardUserInfoLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    CardUserInfoLayout.this.Nk.playAnimation();
                }
            });
        } else {
            this.Nk.setVisibility(8);
            this.Nk.cancelAnimation();
            this.Nj.setIsclearmode(false);
        }
    }

    private void h(bj bjVar) {
        if (this.Nl != null && bjVar != null) {
            if (bjVar.cUs || bjVar.aEb()) {
                ViewGroup.LayoutParams layoutParams = this.Ny.getLayoutParams();
                layoutParams.width = this.tbds580;
                this.Ny.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.Nz.getLayoutParams();
                layoutParams2.width = -1;
                this.Nz.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.Nl.getLayoutParams();
                layoutParams3.width = -1;
                this.Nl.setLayoutParams(layoutParams3);
                this.Nl.setEllipsize(TextUtils.TruncateAt.END);
                if (bjVar.aCo() != null && !StringUtils.isNull(bjVar.aCo().getName_show())) {
                    this.Nl.setText(bjVar.aCo().getName_show());
                } else {
                    this.Nl.setText(R.string.user_name_default_txt);
                }
            } else if (!StringUtils.isNull(this.KJ.aBM())) {
                this.Nl.setText(this.KJ.aBM());
            } else {
                this.Nl.setText(R.string.user_name_default_txt);
            }
            nt();
        }
    }

    protected void i(bj bjVar) {
        if (this.Nq != null) {
            if (bjVar == null || (!isShow(8) && !isShow(512))) {
                this.Nq.setVisibility(8);
            } else if (this.KJ.getType() == bj.cTe) {
                this.Nq.setVisibility(0);
                this.Nq.getPaint().setFakeBoldText(true);
                am.setViewTextColor(this.Nq, (int) R.color.cp_cont_b);
            } else if (isShow(8)) {
                if (StringUtils.isNull(bjVar.aAh())) {
                    this.Nq.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nq.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.Nq.setLayoutParams(layoutParams);
                }
                this.Nq.setText(bjVar.aAh());
                this.Nq.setVisibility(0);
            } else if (StringUtils.isNull(this.KJ.aBO())) {
                this.Nq.setVisibility(8);
            } else {
                this.Nq.setVisibility(0);
                this.Nq.setText(this.KJ.aBO());
            }
        }
    }

    private void j(bj bjVar) {
        if (this.Nn != null) {
            if (!isShow(32)) {
                this.Nn.setVisibility(8);
            } else if (bjVar == null || bjVar.aCo() == null || (bjVar.cTP > 0 && bjVar.cTQ == 0)) {
                this.Nn.setVisibility(8);
            } else {
                ArrayList<IconData> iconInfo = bjVar.aCo().getIconInfo();
                if (v.getCount(iconInfo) != 0) {
                    this.Nn.setVisibility(0);
                    this.Nn.a(iconInfo, 4, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds40), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                    return;
                }
                this.Nn.setVisibility(8);
            }
        }
    }

    protected String o(String str, int i) {
        return aq.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE);
    }

    private void nt() {
        if (this.KJ != null && this.KJ.aCo() != null) {
            if (this.KJ.cTP > 0 && this.KJ.cTQ == 0) {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_f);
            } else if (!v.isEmpty(this.KJ.aCo().getTShowInfoNew()) || this.KJ.aCo().isBigV()) {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_h);
            } else {
                am.setViewTextColor(this.Nl, (int) R.color.cp_cont_f);
            }
        }
    }

    private void k(bj bjVar) {
        if (this.No != null && bjVar != null && bjVar.aCo() != null && isShow(1)) {
            ArrayList<IconData> tShowInfoNew = bjVar.aCo().getTShowInfoNew();
            if (v.getCount(tShowInfoNew) != 0) {
                this.No.setVisibility(0);
                this.No.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds48), this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.No.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.Nm != null && bjVar != null && bjVar.aCo() != null && isShow(16)) {
            MetaData aCo = bjVar.aCo();
            if (this.Nm.getLayoutParams() != null) {
                this.Nm.getLayoutParams().width = -2;
            }
            this.Nm.setOnClickListener(null);
            if (aCo.getIs_bawu() == 1) {
                am.setBackgroundResource(this.Nm, R.drawable.brand_official_btn);
                am.setViewTextColor(this.Nm, (int) R.color.cp_cont_a);
                if (bjVar.cUc) {
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.brand_Official);
                } else if (Config.BAWU_TYPE_MANAGER.equals(aCo.getBawu_type())) {
                    this.Nm.setBackgroundDrawable(this.Nu);
                    this.Nm.setVisibility(0);
                    this.Nm.setText(R.string.bawu_member_bazhu_tip);
                } else if (Config.BAWU_TYPE_ASSIST.equals(aCo.getBawu_type())) {
                    this.Nm.setBackgroundDrawable(this.Nv);
                    this.Nm.setText(R.string.bawu_member_xbazhu_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_content_assist".equals(aCo.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_content_assist_tip);
                    this.Nm.setVisibility(0);
                } else if ("pri_manage_assist".equals(aCo.getBawu_type())) {
                    this.Nm.setText(R.string.bawu_manage_assist_tip);
                    this.Nm.setVisibility(0);
                } else if (aCo.getIs_biggie()) {
                    m(bjVar);
                } else {
                    this.Nm.setVisibility(8);
                }
            } else if (aCo.getIs_biggie()) {
                m(bjVar);
            } else {
                this.Nm.setVisibility(8);
            }
        }
    }

    public HeadPendantClickableView getAvatar() {
        return this.Nj;
    }

    public View getUserName() {
        return this.Nl;
    }

    private void m(bj bjVar) {
        am.setBackgroundResource(this.Nm, R.drawable.brand_official_btn);
        am.setViewTextColor(this.Nm, (int) R.color.cp_cont_a);
        this.Nm.setText(R.string.video_mcn);
        if (bjVar.aDs()) {
            this.Nn.setVisibility(8);
        }
        this.Nm.setVisibility(0);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.Nw = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.Nx = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.Nj != null) {
            this.Nj.setPageId(bdUniqueId);
        }
    }

    private void n(bj bjVar) {
        if (this.Np != null) {
            if (bjVar == null || TextUtils.isEmpty(bjVar.aBN())) {
                this.Np.setVisibility(8);
                return;
            }
            if (bjVar.aCo() != null && bjVar.aCo().isBaijiahaoUser()) {
                this.Np.setLines(1);
                this.Np.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.Np.setMaxLines(Integer.MAX_VALUE);
                this.Np.setEllipsize(null);
            }
            am.setViewTextColor(this.Np, (int) R.color.cp_cont_d);
            this.Np.setText(bjVar.aBN());
            this.Np.setVisibility(isShow(128) ? 0 : 8);
        }
    }

    private void nu() {
        if (isShow(2048) && this.KJ != null && this.KJ.aCo() != null && this.mPageContext != null && this.Ns != null) {
            if (this.NB == null) {
                this.NB = new c(this.mPageContext, this.Ns);
                this.NB.j(this.mBdUniqueId);
            }
            this.NB.a(this.KJ.aCo());
            this.Ns.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.card.view.CardUserInfoLayout.7
                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void G(View view) {
                    TiebaStatic.log(new an("c13570").cy("obj_id", CardUserInfoLayout.this.KJ.aCo().getUserId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).cy("tid", CardUserInfoLayout.this.KJ.getId()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nv() {
        int width;
        if (isShow(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.Nl.getMeasuredHeight());
            layoutParams.setMargins(l.getDimens(this.mContext, R.dimen.tbds10), l.getDimens(this.mContext, R.dimen.tbds_5), 0, 0);
            this.Nq.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.Nl.getPaint();
        int i = l.getScreenDimensions(this.mContext)[0];
        if (i > 0 && (width = (getWidth() - ((i * 31) / 108)) - l.getDimens(this.mContext, R.dimen.tbds107)) > 0) {
            int textWidth = l.getTextWidth(paint, o(this.KJ.aCo().getName_show(), 12)) + this.Nl.getPaddingLeft() + this.Nl.getPaddingRight();
            int textWidth2 = l.getTextWidth(paint, o(this.KJ.aCo().getName_show(), 10)) + this.Nl.getPaddingLeft() + this.Nl.getPaddingRight();
            int measuredWidth = this.No.getMeasuredWidth();
            int measuredWidth2 = this.Nl.getMeasuredWidth();
            int measuredWidth3 = this.Nq.getMeasuredWidth();
            int measuredWidth4 = this.Nm.getMeasuredWidth();
            int measuredWidth5 = this.Nn.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.Nl.getText().toString();
                if (width > measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth) {
                    this.Nl.setText(o(charSequence, 12));
                } else if (width < textWidth + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    this.Nl.setText(o(charSequence, 10));
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + textWidth2) {
                    this.Nn.setVisibility(8);
                }
                if (width < measuredWidth + measuredWidth3 + measuredWidth4 + textWidth2) {
                    this.Nm.setVisibility(8);
                }
                if (width > measuredWidth + measuredWidth3 + textWidth2) {
                    this.No.setVisibility(8);
                }
                if (width > textWidth2 + measuredWidth3) {
                    this.Nq.setVisibility(8);
                }
            }
            int i2 = Integer.MAX_VALUE;
            if (isShow(2048)) {
                i2 = ((i - this.tbds164) - this.tbds156) - this.tbds148;
            } else if (this.KJ != null && this.KJ.aCo() != null && this.KJ.aCo().isBaijiahaoUser()) {
                i2 = (i - this.tbds164) - this.tbds118;
            }
            this.Np.setMaxWidth(i2);
        }
    }

    private void nw() {
        this.tbds6 = l.getDimens(this.mContext, R.dimen.tbds6);
        this.Nu = new LayerDrawable(new Drawable[]{b.aHc().kB(0).af(this.tbds6).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).aHe(), b.aHc().kB(0).af(this.tbds6).tN("#4D000000").aHe()});
        this.Nv = new LayerDrawable(new Drawable[]{b.aHc().kB(0).af(this.tbds6).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).aHe(), b.aHc().kB(0).af(this.tbds6).tN("#4D000000").aHe()});
    }

    public RelativeLayout getSuffixContainer() {
        return this.Nr;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }
}

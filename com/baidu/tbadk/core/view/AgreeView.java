package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ahw;
    private int cardType;
    private bu dLi;
    private boolean dYA;
    private a dYB;
    private CustomMessageListener dYC;
    private CustomMessageListener dYD;
    private TBLottieAnimationView dYi;
    private TextView dYj;
    private TBLottieAnimationView dYk;
    private TextView dYl;
    private AgreeData dYm;
    private com.baidu.tieba.tbadkCore.data.e dYn;
    private ScaleAnimation dYo;
    private boolean dYp;
    private boolean dYq;
    private com.baidu.tbadk.core.data.c dYr;
    private int dYs;
    private int dYt;
    private int dYu;
    private int dYv;
    private String dYw;
    public View.OnClickListener dYx;
    private LinearLayout dYy;
    private LinearLayout dYz;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;

    /* loaded from: classes8.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.dYm != null) {
            this.dYm.agreeType = agreeData.agreeType;
            this.dYm.hasAgree = agreeData.hasAgree;
            this.dYm.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dYt = R.raw.lottie_agree;
        this.dYu = R.raw.lottie_disagree;
        this.dYv = R.color.cp_cont_j;
        this.cardType = 1;
        this.dYA = false;
        this.dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && agreeData != null && AgreeView.this.dYn != null && !AgreeView.this.dYm.isInPost && AgreeView.this.dYn.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dYm.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dYm.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dYm.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dYD = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && !TextUtils.isEmpty(AgreeView.this.dYm.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dYm.postId.equals(agreeData.postId) && !AgreeView.this.dYm.isInThread) {
                        if (AgreeView.this.dYp) {
                            if (AgreeView.this.dYm.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dYn.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dYx != null) {
                    AgreeView.this.dYx.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dYt = R.raw.lottie_agree;
        this.dYu = R.raw.lottie_disagree;
        this.dYv = R.color.cp_cont_j;
        this.cardType = 1;
        this.dYA = false;
        this.dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && agreeData != null && AgreeView.this.dYn != null && !AgreeView.this.dYm.isInPost && AgreeView.this.dYn.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dYm.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dYm.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dYm.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dYD = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && !TextUtils.isEmpty(AgreeView.this.dYm.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dYm.postId.equals(agreeData.postId) && !AgreeView.this.dYm.isInThread) {
                        if (AgreeView.this.dYp) {
                            if (AgreeView.this.dYm.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dYn.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dYx != null) {
                    AgreeView.this.dYx.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dYt = R.raw.lottie_agree;
        this.dYu = R.raw.lottie_disagree;
        this.dYv = R.color.cp_cont_j;
        this.cardType = 1;
        this.dYA = false;
        this.dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && agreeData != null && AgreeView.this.dYn != null && !AgreeView.this.dYm.isInPost && AgreeView.this.dYn.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dYm.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dYm.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dYm.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dYD = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dYm != null && !TextUtils.isEmpty(AgreeView.this.dYm.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dYm.postId.equals(agreeData.postId) && !AgreeView.this.dYm.isInThread) {
                        if (AgreeView.this.dYp) {
                            if (AgreeView.this.dYm.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dYn.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dYx != null) {
                    AgreeView.this.dYx.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.dYi = new TBLottieAnimationView(context);
        this.dYi.setId(R.id.img_agree);
        this.dYi.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dYi.setOnClickListener(this.mOnClickListener);
        this.dYi.addAnimatorListener(this);
        this.dYj = new TextView(context);
        this.dYj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dYj.setOnClickListener(this.mOnClickListener);
        this.dYk = new TBLottieAnimationView(context);
        this.dYk.setId(R.id.img_disagree);
        this.dYk.addAnimatorListener(this);
        this.dYk.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dYk.setOnClickListener(this.mOnClickListener);
        this.dYl = new TextView(context);
        this.dYl.setText(R.string.c_disagree);
        this.dYl.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dYl.setOnClickListener(this.mOnClickListener);
        this.dYn = new com.baidu.tieba.tbadkCore.data.e();
        this.dYn.uniqueId = getPageId();
        aXH();
        setAgreeAnimationResource();
    }

    private void aXH() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.dYz = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.dYi);
        linearLayout.addView(this.dYj);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.dYy = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.dYk);
        linearLayout2.addView(this.dYl);
        hn(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.dYz.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.dYz.setLayoutParams(layoutParams);
        this.dYi.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.dYj.setLayoutParams(layoutParams2);
        this.dYy.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.dYy.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.dYk.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.dYl.setLayoutParams(layoutParams5);
    }

    public void hn(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.dYA);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.dYA);
    }

    public void aXI() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dYi.setLayoutParams(layoutParams);
        this.dYj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dYj.setLayoutParams(layoutParams2);
        this.dYk.setVisibility(8);
        this.dYl.setVisibility(8);
    }

    public void ho(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dYi.setLayoutParams(layoutParams);
        this.dYj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        if (!z) {
            layoutParams2.leftMargin = i;
        }
        this.dYj.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        }
        layoutParams3.gravity = 16;
        this.dYk.setLayoutParams(layoutParams3);
        if (z) {
            this.dYl.setVisibility(8);
            return;
        }
        this.dYl.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dYl.setLayoutParams(layoutParams4);
    }

    public void aXJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        aS(this.dYi);
        aS(this.dYk);
        aS(this.dYj);
        aS(this.dYl);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.dYi, new LinearLayout.LayoutParams(dimens, dimens));
        this.dYj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.dYj, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.dYy = linearLayout2;
        linearLayout2.addView(this.dYk, new LinearLayout.LayoutParams(dimens, dimens));
        this.dYl.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.dYl, layoutParams4);
    }

    private void aS(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dYC);
        MessageManager.getInstance().registerListener(this.dYD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dYC);
        MessageManager.getInstance().unRegisterListener(this.dYD);
    }

    public void setTopicId(String str) {
        this.dYw = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.dYp = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.dYq = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dYi;
    }

    public TextView getAgreeNumView() {
        return this.dYj;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.dYk;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.dYm = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.dYm;
    }

    public void setAgreeAnimationResource() {
        if (this.dYp) {
            an.b(this.dYi, this.dYt);
            an.b(this.dYk, this.dYu);
            return;
        }
        an.a(this.dYi, this.dYt);
        an.a(this.dYk, this.dYu);
    }

    private String b(AgreeData agreeData) {
        return c(agreeData);
    }

    private String c(AgreeData agreeData) {
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        if (j == 0) {
            return getContext().getString(R.string.c_agree);
        }
        if (j > 0) {
            return ar.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + ar.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.dYj.setText(b(this.dYm));
        if (this.dYm.hasAgree) {
            if (this.dYm.agreeType == 2) {
                this.dYk.setProgress(0.0f);
                this.dYi.setProgress(1.0f);
                this.dYj.setTextColor(an.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dYl);
                return;
            }
            this.dYi.setProgress(0.0f);
            this.dYk.setProgress(1.0f);
            setTextNormalColor(this.dYj);
            this.dYl.setTextColor(an.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dYi.setProgress(0.0f);
        this.dYk.setProgress(0.0f);
        setTextNormalColor(this.dYj);
        setTextNormalColor(this.dYl);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.dYq) {
            textView.setTextColor(an.getColor(R.color.cp_cont_d));
        } else if (this.dYp) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(an.getColor(this.dYv));
        }
    }

    public void hp(boolean z) {
        this.dYi.setMinAndMaxProgress(0.0f, 1.0f);
        this.dYk.setMinAndMaxProgress(0.0f, 1.0f);
        this.dYj.setText(b(this.dYm));
        this.dYi.clearColorFilter();
        this.dYk.clearColorFilter();
        if (z) {
            this.dYi.playAnimation();
            this.dYk.cancelAnimation();
            this.dYk.setFrame(0);
        } else {
            this.dYk.playAnimation();
            this.dYi.cancelAnimation();
            this.dYi.setFrame(0);
        }
        if (this.dYm.hasAgree) {
            if (this.dYm.agreeType == 2) {
                this.dYj.setTextColor(an.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dYl);
                return;
            }
            setTextNormalColor(this.dYj);
            this.dYl.setTextColor(an.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.dYj);
        setTextNormalColor(this.dYl);
    }

    public void aXK() {
        aT(this.dYi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        int i = 0;
        int i2 = 1;
        if (this.dYm != null) {
            if (!this.dYp || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.dYp || be.checkUpIsLogin(getContext())) && view != this.dYj) {
                    if (view.getId() == this.dYi.getId()) {
                        this.dYi.cancelAnimation();
                        if (this.dYr != null) {
                            this.dYr.type = 1;
                        }
                        if (this.dYm.hasAgree) {
                            if (this.dYm.agreeType == 2) {
                                this.dYm.agreeType = 2;
                                this.dYm.hasAgree = false;
                                this.dYm.agreeNum--;
                                updateUI();
                                if (this.dYr != null) {
                                    this.dYr.dHt = 1;
                                }
                            } else {
                                this.dYm.agreeType = 2;
                                this.dYm.hasAgree = true;
                                this.dYm.agreeNum++;
                                hp(true);
                                com.baidu.tieba.o.a.cYy().H(getTbPageContext());
                                if (this.dYr != null) {
                                    this.dYr.dHt = 0;
                                    i2 = 0;
                                }
                            }
                            lX(i2);
                        } else {
                            this.dYm.agreeType = 2;
                            this.dYm.hasAgree = true;
                            this.dYm.agreeNum++;
                            hp(true);
                            com.baidu.tieba.o.a.cYy().H(getTbPageContext());
                            if (this.dYr != null) {
                                this.dYr.dHt = 0;
                            }
                        }
                        i2 = 0;
                        lX(i2);
                    } else if (view.getId() == this.dYk.getId()) {
                        this.dYk.cancelAnimation();
                        if (this.dYr != null) {
                            this.dYr.type = 2;
                        }
                        if (this.dYm.hasAgree) {
                            if (this.dYm.agreeType == 5) {
                                this.dYm.agreeType = 5;
                                this.dYm.hasAgree = false;
                                updateUI();
                                if (this.dYr != null) {
                                    this.dYr.dHx = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.dYm.agreeType = 5;
                                this.dYm.hasAgree = true;
                                this.dYm.agreeNum--;
                                hp(false);
                                if (this.dYr != null) {
                                    this.dYr.dHx = 1;
                                }
                            }
                        } else {
                            this.dYm.agreeType = 5;
                            this.dYm.hasAgree = true;
                            hp(false);
                            if (this.dYr != null) {
                                this.dYr.dHx = 1;
                            }
                        }
                        lX(i);
                    }
                    this.dYn.agreeData = this.dYm;
                    if (this.dYm.isInThread) {
                        if (this.dYm.baijiahaoData != null) {
                            this.dYm.nid = this.dYm.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dYn));
                        a(this.dYm, AgreeEvent.IS_THREAD);
                    } else if (this.dYm.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dYn));
                        a(this.dYm, AgreeEvent.IS_POST);
                    }
                    if (this.ahw != null) {
                        this.ahw.onClick(view);
                    }
                    aXL();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        com.baidu.tbadk.mutiprocess.g.publishEvent(agreeEvent);
    }

    public void lX(int i) {
        if (this.dYm != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.dYm.threadId);
            httpMessage.addParam("op_type", i);
            if (this.dYm.objType == 0) {
                this.dYm.objType = 3;
            }
            httpMessage.addParam("obj_type", this.dYm.objType);
            httpMessage.addParam("agree_type", this.dYm.agreeType);
            httpMessage.addParam("forum_id", this.dYm.forumId);
            if (!TextUtils.isEmpty(this.dYm.postId)) {
                httpMessage.addParam("post_id", this.dYm.postId);
            }
            if (this.dYm.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.dYm.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.dYm.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.dYm.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.dYm.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.dYp) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.mutiprocess.f.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.mutiprocess.f.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getStoken())) {
                    httpMessage.addParam("stoken", com.baidu.tbadk.mutiprocess.f.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void aXL() {
        if (this.dYr != null && this.dYm != null) {
            int i = 0;
            if (this.dYm.baijiahaoData != null) {
                i = this.dYm.baijiahaoData.oriUgcType;
            }
            if (this.dYr.type == 1) {
                if (StringUtils.isNull(this.dYw)) {
                    ao dk = new ao("c12003").ag("obj_locate", this.dYr.dHq).ag("obj_param1", this.dYr.dHr).ag("obj_source", this.dYr.dHs).ag("obj_id", this.dYr.dHt).ag("obj_name", i).dk("post_id", this.dYm.postId);
                    if (this.dLi != null) {
                        dk.dk("tid", this.dLi.getId()).dk("nid", this.dLi.getNid()).s("fid", this.dLi.getFid()).ag(IntentConfig.CARD_TYPE, this.cardType).dk("ab_tag", this.dLi.mRecomAbTag).dk(IntentConfig.RECOM_SOURCE, this.dLi.mRecomSource).dk("weight", this.dLi.mRecomWeight).dk("extra", this.dLi.mRecomExtra);
                        if (this.dLi.getBaijiahaoData() != null) {
                            dk.dk("obj_param4", this.dLi.getBaijiahaoData().oriUgcNid);
                            if (this.dLi.aQY() || this.dLi.aUm()) {
                                dk.dk("obj_param6", this.dLi.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dLi.aUk()) {
                            dk.ag("obj_param5", 2);
                        } else if (this.dLi.aQX() || this.dLi.aQY()) {
                            dk.ag("obj_param5", 3);
                        } else if (this.dLi.threadType == 0 || this.dLi.threadType == 40) {
                            dk.ag("obj_param5", 1);
                        }
                    } else {
                        dk.dk("tid", this.dYm.threadId);
                        dk.dk("nid", this.dYm.nid);
                        dk.dk("fid", this.dYm.forumId);
                        dk.ag(IntentConfig.CARD_TYPE, this.dYm.cardType);
                        dk.dk("ab_tag", this.dYm.recomAbTag);
                        dk.dk(IntentConfig.RECOM_SOURCE, this.dYm.recomSource);
                        dk.dk("weight", this.dYm.recomWeight);
                        dk.dk("extra", this.dYm.recomExtra);
                        if (this.dYm.baijiahaoData != null) {
                            dk.dk("obj_param6", this.dYm.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (lY(this.dYr.dHq) && lZ(this.dYr.dHu) != -1) {
                        dk.ag(TiebaInitialize.Params.OBJ_TO, lZ(this.dYr.dHu));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dk.dk("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dk.ag("resource_id", this.dYs);
                    } else if (this.mFrom == 18) {
                        dk.dk("obj_tab", "a099");
                        dk.dk("resource_id", this.mTabName);
                    } else {
                        dk.ag("resource_id", this.dYs);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dk);
                    }
                    if (this.dYm.isFromImageViewer) {
                        dk.dk("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.dYm.mImageViewerFromPage == "index") {
                            dk.dk(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    TiebaStatic.log(dk);
                    return;
                }
                TiebaStatic.log(new ao("c13358").dk("tid", this.dYm.threadId).dk("topic_id", this.dYw));
            } else if (this.dYr.type == 2) {
                ao dk2 = new ao("c13271").ag("obj_type", this.dYr.dHv).ag("obj_locate", this.dYr.dHw).ag(TiebaInitialize.Params.OBJ_PARAM2, this.dYs).ag("obj_id", this.dYr.dHx).ag("obj_name", i).dk("post_id", this.dYm.postId).dk("nid", this.dYm.nid);
                if (this.dLi != null) {
                    dk2.dk("tid", this.dLi.getId()).dk("nid", this.dLi.getNid()).s("fid", this.dLi.getFid()).ag(IntentConfig.CARD_TYPE, this.cardType).dk("ab_tag", this.dLi.mRecomAbTag).dk(IntentConfig.RECOM_SOURCE, this.dLi.mRecomSource).dk("weight", this.dLi.mRecomWeight).dk("extra", this.dLi.mRecomExtra);
                    if (this.dLi.getBaijiahaoData() != null) {
                        dk2.dk("obj_param4", this.dLi.getBaijiahaoData().oriUgcNid);
                        if (this.dLi.aQY() || this.dLi.aUm()) {
                            dk2.dk("obj_param6", this.dLi.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dLi.aUk()) {
                        dk2.ag("obj_param5", 2);
                    } else if (this.dLi.aQX() || this.dLi.aQY()) {
                        dk2.ag("obj_param5", 3);
                    } else if (this.dLi.threadType == 0 || this.dLi.threadType == 40) {
                        dk2.ag("obj_param5", 1);
                    }
                } else {
                    dk2.dk("tid", this.dYm.threadId);
                    dk2.dk("nid", this.dYm.nid);
                    dk2.dk("fid", this.dYm.forumId);
                    dk2.ag(IntentConfig.CARD_TYPE, this.dYm.cardType);
                    dk2.dk("ab_tag", this.dYm.recomAbTag);
                    dk2.dk(IntentConfig.RECOM_SOURCE, this.dYm.recomSource);
                    dk2.dk("weight", this.dYm.recomWeight);
                    dk2.dk("extra", this.dYm.recomExtra);
                    if (this.dYm.baijiahaoData != null) {
                        dk2.dk("obj_param6", this.dYm.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dk2.dk("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dk2.dk("obj_tab", "a099");
                    dk2.dk("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dk2);
                }
                if (this.dYm.isFromImageViewer) {
                    dk2.dk("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.dYm.mImageViewerFromPage == "index") {
                        dk2.dk(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dk2);
            }
        }
    }

    public static boolean lY(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int lZ(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.dYo == null) {
            this.dYo = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dYo.setDuration(200L);
        }
        return this.dYo;
    }

    public void onChangeSkinType(int i) {
        if (this.dYm != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dYp) {
                an.b(this.dYi, this.dYt);
                an.b(this.dYk, this.dYu);
            } else {
                an.a(this.dYi, this.dYt);
                an.a(this.dYk, this.dYu);
            }
            updateUI();
        }
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.mPageContext == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.mPageContext;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.dYr = cVar;
    }

    public void setGameId(int i) {
        this.dYs = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.dYk.setVisibility(z ? 8 : 0);
        this.dYl.setVisibility(z ? 8 : 0);
        if (z && this.dYy != null) {
            this.dYy.setVisibility(8);
        }
        if (this.dYA != z && this.dYB != null) {
            this.dYB.f(this.dYk, z);
        }
        this.dYA = z;
    }

    public void setDisagreeShow(boolean z) {
        this.dYk.setVisibility(z ? 8 : 0);
        this.dYl.setVisibility(z ? 8 : 0);
        if (this.dYy != null) {
            this.dYy.setVisibility(z ? 8 : 0);
        }
        this.dYA = z;
    }

    public boolean aXM() {
        return this.dYA;
    }

    public void setThreadData(bu buVar) {
        this.dLi = buVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.dYt = i;
        this.dYu = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.dYv = i;
        setTextNormalColor(this.dYj);
        setTextNormalColor(this.dYl);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.dYB = aVar;
    }
}

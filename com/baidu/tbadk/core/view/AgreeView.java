package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener MG;
    private bj cNb;
    private TBLottieAnimationView cZa;
    private TextView cZb;
    private TBLottieAnimationView cZc;
    private TextView cZd;
    private AgreeData cZe;
    private com.baidu.tieba.tbadkCore.data.e cZf;
    private ScaleAnimation cZg;
    private boolean cZh;
    private boolean cZi;
    private com.baidu.tbadk.core.data.d cZj;
    private int cZk;
    private int cZl;
    private int cZm;
    private String cZn;
    private View cZo;
    private CustomMessageListener cZp;
    private CustomMessageListener cZq;
    private int cardType;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.cZe != null) {
            this.cZe.agreeType = agreeData.agreeType;
            this.cZe.hasAgree = agreeData.hasAgree;
            this.cZe.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cZl = R.raw.lottie_agree;
        this.cZm = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZp = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && agreeData != null && AgreeView.this.cZf != null && !AgreeView.this.cZe.isInPost && AgreeView.this.cZf.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cZe.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cZe.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cZe.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZq = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && !TextUtils.isEmpty(AgreeView.this.cZe.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cZe.postId.equals(agreeData.postId) && !AgreeView.this.cZe.isInThread) {
                        if (AgreeView.this.cZh) {
                            if (AgreeView.this.cZe.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cZf.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cZl = R.raw.lottie_agree;
        this.cZm = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZp = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && agreeData != null && AgreeView.this.cZf != null && !AgreeView.this.cZe.isInPost && AgreeView.this.cZf.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cZe.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cZe.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cZe.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZq = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && !TextUtils.isEmpty(AgreeView.this.cZe.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cZe.postId.equals(agreeData.postId) && !AgreeView.this.cZe.isInThread) {
                        if (AgreeView.this.cZh) {
                            if (AgreeView.this.cZe.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cZf.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cZl = R.raw.lottie_agree;
        this.cZm = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZp = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && agreeData != null && AgreeView.this.cZf != null && !AgreeView.this.cZe.isInPost && AgreeView.this.cZf.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cZe.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cZe.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cZe.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZq = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cZe != null && !TextUtils.isEmpty(AgreeView.this.cZe.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cZe.postId.equals(agreeData.postId) && !AgreeView.this.cZe.isInThread) {
                        if (AgreeView.this.cZh) {
                            if (AgreeView.this.cZe.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cZf.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.cZa = new TBLottieAnimationView(context);
        this.cZa.setId(R.id.img_agree);
        this.cZa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cZa.setOnClickListener(this.mOnClickListener);
        this.cZa.addAnimatorListener(this);
        this.cZb = new TextView(context);
        this.cZb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.cZb.setOnClickListener(this.mOnClickListener);
        this.cZc = new TBLottieAnimationView(context);
        this.cZc.setId(R.id.img_disagree);
        this.cZc.addAnimatorListener(this);
        this.cZc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cZc.setOnClickListener(this.mOnClickListener);
        this.cZd = new TextView(context);
        this.cZd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.cZd.setOnClickListener(this.mOnClickListener);
        this.cZf = new com.baidu.tieba.tbadkCore.data.e();
        this.cZf.uniqueId = getPageId();
        aFa();
        setAgreeAnimationResource();
    }

    private void aFa() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.cZa, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.cZb, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.cZc, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.cZd.setText(R.string.c_disagree);
        addView(this.cZd, layoutParams2);
    }

    public void aFb() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.cZa.setLayoutParams(layoutParams);
        this.cZb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.cZb.setLayoutParams(layoutParams2);
        this.cZc.setVisibility(8);
        this.cZd.setVisibility(8);
    }

    public void aFc() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.cZa.setLayoutParams(layoutParams);
        this.cZb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.cZb.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.cZc.setLayoutParams(layoutParams3);
        this.cZd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.cZd.setLayoutParams(layoutParams4);
    }

    public void aFd() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.cZa, new LinearLayout.LayoutParams(dimens, dimens));
        this.cZb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.cZb, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.cZo = linearLayout2;
        linearLayout2.addView(this.cZc, new LinearLayout.LayoutParams(dimens, dimens));
        this.cZd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.cZd, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cZp);
        MessageManager.getInstance().registerListener(this.cZq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cZp);
        MessageManager.getInstance().unRegisterListener(this.cZq);
    }

    public void setTopicId(String str) {
        this.cZn = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.cZh = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.cZi = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.cZa;
    }

    public TextView getAgreeNumView() {
        return this.cZb;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.cZc;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.cZe = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.cZe;
    }

    public void setAgreeAnimationResource() {
        if (this.cZh) {
            this.cZa.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZl));
            this.cZc.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZm));
            return;
        }
        am.a(this.cZa, this.cZl);
        am.a(this.cZc, this.cZm);
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
            return aq.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + aq.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.cZb.setText(b(this.cZe));
        if (this.cZe.hasAgree) {
            if (this.cZe.agreeType == 2) {
                this.cZc.setProgress(0.0f);
                this.cZa.setProgress(1.0f);
                this.cZb.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.cZd);
                return;
            }
            this.cZa.setProgress(0.0f);
            this.cZc.setProgress(1.0f);
            setTextNormalColor(this.cZb);
            this.cZd.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.cZa.setProgress(0.0f);
        this.cZc.setProgress(0.0f);
        setTextNormalColor(this.cZb);
        setTextNormalColor(this.cZd);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.cZi) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.cZh) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fG(boolean z) {
        this.cZa.setMinAndMaxProgress(0.0f, 1.0f);
        this.cZc.setMinAndMaxProgress(0.0f, 1.0f);
        this.cZb.setText(b(this.cZe));
        this.cZa.clearColorFilter();
        this.cZc.clearColorFilter();
        if (z) {
            this.cZa.playAnimation();
            this.cZc.cancelAnimation();
            this.cZc.setFrame(0);
        } else {
            this.cZc.playAnimation();
            this.cZa.cancelAnimation();
            this.cZa.setFrame(0);
        }
        if (this.cZe.hasAgree) {
            if (this.cZe.agreeType == 2) {
                this.cZb.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.cZd);
                return;
            }
            setTextNormalColor(this.cZb);
            this.cZd.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.cZb);
        setTextNormalColor(this.cZd);
    }

    public void aFe() {
        aR(this.cZa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.cZe != null) {
            if (!this.cZh || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.cZh || bc.checkUpIsLogin(getContext())) && view != this.cZb) {
                    if (view.getId() == this.cZa.getId()) {
                        this.cZa.cancelAnimation();
                        if (this.cZj != null) {
                            this.cZj.type = 1;
                        }
                        if (this.cZe.hasAgree) {
                            if (this.cZe.agreeType == 2) {
                                this.cZe.agreeType = 2;
                                this.cZe.hasAgree = false;
                                this.cZe.agreeNum--;
                                updateUI();
                                if (this.cZj != null) {
                                    this.cZj.cJA = 1;
                                }
                            } else {
                                this.cZe.agreeType = 2;
                                this.cZe.hasAgree = true;
                                this.cZe.agreeNum++;
                                fG(true);
                                com.baidu.tieba.n.a.cAC().B(getTbPageContext());
                                if (this.cZj != null) {
                                    this.cZj.cJA = 0;
                                    i2 = 0;
                                }
                            }
                            kB(i2);
                        } else {
                            this.cZe.agreeType = 2;
                            this.cZe.hasAgree = true;
                            this.cZe.agreeNum++;
                            fG(true);
                            com.baidu.tieba.n.a.cAC().B(getTbPageContext());
                            if (this.cZj != null) {
                                this.cZj.cJA = 0;
                            }
                        }
                        i2 = 0;
                        kB(i2);
                    } else if (view.getId() == this.cZc.getId()) {
                        this.cZc.cancelAnimation();
                        if (this.cZj != null) {
                            this.cZj.type = 2;
                        }
                        if (this.cZe.hasAgree) {
                            if (this.cZe.agreeType == 5) {
                                this.cZe.agreeType = 5;
                                this.cZe.hasAgree = false;
                                updateUI();
                                if (this.cZj != null) {
                                    this.cZj.cJE = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.cZe.agreeType = 5;
                                this.cZe.hasAgree = true;
                                this.cZe.agreeNum--;
                                fG(false);
                                if (this.cZj != null) {
                                    this.cZj.cJE = 1;
                                }
                            }
                        } else {
                            this.cZe.agreeType = 5;
                            this.cZe.hasAgree = true;
                            fG(false);
                            if (this.cZj != null) {
                                this.cZj.cJE = 1;
                            }
                        }
                        kB(i);
                    }
                    this.cZf.agreeData = this.cZe;
                    if (this.cZe.isInThread) {
                        if (this.cZe.baijiahaoData != null) {
                            this.cZe.nid = this.cZe.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cZf));
                        a(this.cZe, AgreeEvent.IS_THREAD);
                    } else if (this.cZe.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cZf));
                        a(this.cZe, AgreeEvent.IS_POST);
                    }
                    if (this.MG != null) {
                        this.MG.onClick(view);
                    }
                    aFf();
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

    public void kB(int i) {
        if (this.cZe != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.cZe.threadId);
            httpMessage.addParam("op_type", i);
            if (this.cZe.objType == 0) {
                this.cZe.objType = 3;
            }
            httpMessage.addParam("obj_type", this.cZe.objType);
            httpMessage.addParam("agree_type", this.cZe.agreeType);
            httpMessage.addParam("forum_id", this.cZe.forumId);
            if (!TextUtils.isEmpty(this.cZe.postId)) {
                httpMessage.addParam("post_id", this.cZe.postId);
            }
            if (this.cZe.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.cZe.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.cZe.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.cZe.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.cZe.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.cZh) {
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

    public void aFf() {
        if (this.cZj != null && this.cZe != null) {
            int i = 0;
            if (this.cZe.baijiahaoData != null) {
                i = this.cZe.baijiahaoData.oriUgcType;
            }
            if (this.cZj.type == 1) {
                if (StringUtils.isNull(this.cZn)) {
                    an cp = new an("c12003").Z("obj_locate", this.cZj.cJx).Z("obj_param1", this.cZj.cJy).Z("obj_source", this.cZj.cJz).Z("resource_id", this.cZk).Z("obj_id", this.cZj.cJA).Z("obj_name", i).cp("post_id", this.cZe.postId);
                    if (this.cNb != null) {
                        cp.cp("tid", this.cNb.getId()).s("fid", this.cNb.getFid()).Z("card_type", this.cardType).cp(TiebaInitialize.Params.AB_TAG, this.cNb.mRecomAbTag).cp("recom_source", this.cNb.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cNb.mRecomWeight).cp("extra", this.cNb.mRecomExtra);
                        if (this.cNb.getBaijiahaoData() != null) {
                            cp.cp("obj_param4", this.cNb.getBaijiahaoData().oriUgcNid);
                            if (this.cNb.aBS() || this.cNb.aBU()) {
                                cp.cp("obj_param6", this.cNb.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.cNb.aBR()) {
                            cp.Z("obj_param5", 2);
                        } else if (this.cNb.ayL() || this.cNb.aBS()) {
                            cp.Z("obj_param5", 3);
                        } else if (this.cNb.threadType == 0 || this.cNb.threadType == 40) {
                            cp.Z("obj_param5", 1);
                        }
                    }
                    if (kC(this.cZj.cJx) && kD(this.cZj.cJB) != -1) {
                        cp.Z(TiebaInitialize.Params.OBJ_TO, kD(this.cZj.cJB));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        cp.cp("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cp);
                    }
                    TiebaStatic.log(cp);
                    return;
                }
                TiebaStatic.log(new an("c13358").cp("tid", this.cZe.threadId).cp("topic_id", this.cZn));
            } else if (this.cZj.type == 2) {
                an cp2 = new an("c13271").Z("obj_type", this.cZj.cJC).Z("obj_locate", this.cZj.cJD).Z(TiebaInitialize.Params.OBJ_PARAM2, this.cZk).Z("obj_id", this.cZj.cJE).Z("obj_name", i).cp("post_id", this.cZe.postId);
                if (this.cNb != null) {
                    cp2.cp("tid", this.cNb.getId()).s("fid", this.cNb.getFid()).Z("card_type", this.cardType).cp(TiebaInitialize.Params.AB_TAG, this.cNb.mRecomAbTag).cp("recom_source", this.cNb.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cNb.mRecomWeight).cp("extra", this.cNb.mRecomExtra);
                    if (this.cNb.getBaijiahaoData() != null) {
                        cp2.cp("obj_param4", this.cNb.getBaijiahaoData().oriUgcNid);
                        if (this.cNb.aBS() || this.cNb.aBU()) {
                            cp2.cp("obj_param6", this.cNb.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.cNb.aBR()) {
                        cp2.Z("obj_param5", 2);
                    } else if (this.cNb.ayL() || this.cNb.aBS()) {
                        cp2.Z("obj_param5", 3);
                    } else if (this.cNb.threadType == 0 || this.cNb.threadType == 40) {
                        cp2.Z("obj_param5", 1);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    cp2.cp("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cp2);
                }
                TiebaStatic.log(cp2);
            }
        }
    }

    public static boolean kC(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int kD(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.cZg == null) {
            this.cZg = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.cZg.setDuration(200L);
        }
        return this.cZg;
    }

    public void onChangeSkinType(int i) {
        if (this.cZe != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.cZh) {
                this.cZa.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZl));
                this.cZc.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZm));
            } else {
                am.a(this.cZa, this.cZl);
                am.a(this.cZc, this.cZm);
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

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.cZj = dVar;
    }

    public void setGameId(int i) {
        this.cZk = i;
    }

    public void setAgreeAlone(boolean z) {
        this.cZc.setVisibility(z ? 8 : 0);
        this.cZd.setVisibility(z ? 8 : 0);
        if (z && this.cZo != null) {
            this.cZo.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cNb = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

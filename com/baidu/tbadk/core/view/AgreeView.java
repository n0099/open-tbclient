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
/* loaded from: classes8.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener Ni;
    private bj cRt;
    private int cardType;
    private TBLottieAnimationView ddG;
    private TextView ddH;
    private TBLottieAnimationView ddI;
    private TextView ddJ;
    private AgreeData ddK;
    private com.baidu.tieba.tbadkCore.data.e ddL;
    private ScaleAnimation ddM;
    private boolean ddN;
    private boolean ddO;
    private com.baidu.tbadk.core.data.d ddP;
    private int ddQ;
    private int ddR;
    private int ddS;
    private String ddT;
    private View ddU;
    private CustomMessageListener ddV;
    private CustomMessageListener ddW;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ddK != null) {
            this.ddK.agreeType = agreeData.agreeType;
            this.ddK.hasAgree = agreeData.hasAgree;
            this.ddK.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ddR = R.raw.lottie_agree;
        this.ddS = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && agreeData != null && AgreeView.this.ddL != null && !AgreeView.this.ddK.isInPost && AgreeView.this.ddL.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddK.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddK.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddK.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddW = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && !TextUtils.isEmpty(AgreeView.this.ddK.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddK.postId.equals(agreeData.postId) && !AgreeView.this.ddK.isInThread) {
                        if (AgreeView.this.ddN) {
                            if (AgreeView.this.ddK.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddL.uniqueId == eVar.uniqueId) {
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
        this.ddR = R.raw.lottie_agree;
        this.ddS = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && agreeData != null && AgreeView.this.ddL != null && !AgreeView.this.ddK.isInPost && AgreeView.this.ddL.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddK.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddK.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddK.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddW = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && !TextUtils.isEmpty(AgreeView.this.ddK.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddK.postId.equals(agreeData.postId) && !AgreeView.this.ddK.isInThread) {
                        if (AgreeView.this.ddN) {
                            if (AgreeView.this.ddK.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddL.uniqueId == eVar.uniqueId) {
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
        this.ddR = R.raw.lottie_agree;
        this.ddS = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && agreeData != null && AgreeView.this.ddL != null && !AgreeView.this.ddK.isInPost && AgreeView.this.ddL.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddK.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddK.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddK.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddW = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddK != null && !TextUtils.isEmpty(AgreeView.this.ddK.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddK.postId.equals(agreeData.postId) && !AgreeView.this.ddK.isInThread) {
                        if (AgreeView.this.ddN) {
                            if (AgreeView.this.ddK.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddL.uniqueId == eVar.uniqueId) {
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
        this.ddG = new TBLottieAnimationView(context);
        this.ddG.setId(R.id.img_agree);
        this.ddG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddG.setOnClickListener(this.mOnClickListener);
        this.ddG.addAnimatorListener(this);
        this.ddH = new TextView(context);
        this.ddH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddH.setOnClickListener(this.mOnClickListener);
        this.ddI = new TBLottieAnimationView(context);
        this.ddI.setId(R.id.img_disagree);
        this.ddI.addAnimatorListener(this);
        this.ddI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddI.setOnClickListener(this.mOnClickListener);
        this.ddJ = new TextView(context);
        this.ddJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddJ.setOnClickListener(this.mOnClickListener);
        this.ddL = new com.baidu.tieba.tbadkCore.data.e();
        this.ddL.uniqueId = getPageId();
        aHt();
        setAgreeAnimationResource();
    }

    private void aHt() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.ddG, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.ddH, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.ddI, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddJ.setText(R.string.c_disagree);
        addView(this.ddJ, layoutParams2);
    }

    public void aHu() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddG.setLayoutParams(layoutParams);
        this.ddH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddH.setLayoutParams(layoutParams2);
        this.ddI.setVisibility(8);
        this.ddJ.setVisibility(8);
    }

    public void aHv() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.ddG.setLayoutParams(layoutParams);
        this.ddH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.ddH.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.ddI.setLayoutParams(layoutParams3);
        this.ddJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddJ.setLayoutParams(layoutParams4);
    }

    public void aHw() {
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
        linearLayout.addView(this.ddG, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddH.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.ddH, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.ddU = linearLayout2;
        linearLayout2.addView(this.ddI, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.ddJ, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddV);
        MessageManager.getInstance().registerListener(this.ddW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddV);
        MessageManager.getInstance().unRegisterListener(this.ddW);
    }

    public void setTopicId(String str) {
        this.ddT = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ddN = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ddO = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.ddG;
    }

    public TextView getAgreeNumView() {
        return this.ddH;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ddI;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ddK = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ddK;
    }

    public void setAgreeAnimationResource() {
        if (this.ddN) {
            am.b(this.ddG, this.ddR);
            am.b(this.ddI, this.ddS);
            return;
        }
        am.a(this.ddG, this.ddR);
        am.a(this.ddI, this.ddS);
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
        this.ddH.setText(b(this.ddK));
        if (this.ddK.hasAgree) {
            if (this.ddK.agreeType == 2) {
                this.ddI.setProgress(0.0f);
                this.ddG.setProgress(1.0f);
                this.ddH.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddJ);
                return;
            }
            this.ddG.setProgress(0.0f);
            this.ddI.setProgress(1.0f);
            setTextNormalColor(this.ddH);
            this.ddJ.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.ddG.setProgress(0.0f);
        this.ddI.setProgress(0.0f);
        setTextNormalColor(this.ddH);
        setTextNormalColor(this.ddJ);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ddO) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.ddN) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fO(boolean z) {
        this.ddG.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddI.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddH.setText(b(this.ddK));
        this.ddG.clearColorFilter();
        this.ddI.clearColorFilter();
        if (z) {
            this.ddG.playAnimation();
            this.ddI.cancelAnimation();
            this.ddI.setFrame(0);
        } else {
            this.ddI.playAnimation();
            this.ddG.cancelAnimation();
            this.ddG.setFrame(0);
        }
        if (this.ddK.hasAgree) {
            if (this.ddK.agreeType == 2) {
                this.ddH.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddJ);
                return;
            }
            setTextNormalColor(this.ddH);
            this.ddJ.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.ddH);
        setTextNormalColor(this.ddJ);
    }

    public void aHx() {
        aR(this.ddG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.ddK != null) {
            if (!this.ddN || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.ddN || bc.checkUpIsLogin(getContext())) && view != this.ddH) {
                    if (view.getId() == this.ddG.getId()) {
                        this.ddG.cancelAnimation();
                        if (this.ddP != null) {
                            this.ddP.type = 1;
                        }
                        if (this.ddK.hasAgree) {
                            if (this.ddK.agreeType == 2) {
                                this.ddK.agreeType = 2;
                                this.ddK.hasAgree = false;
                                this.ddK.agreeNum--;
                                updateUI();
                                if (this.ddP != null) {
                                    this.ddP.cNS = 1;
                                }
                            } else {
                                this.ddK.agreeType = 2;
                                this.ddK.hasAgree = true;
                                this.ddK.agreeNum++;
                                fO(true);
                                com.baidu.tieba.o.a.cCv().C(getTbPageContext());
                                if (this.ddP != null) {
                                    this.ddP.cNS = 0;
                                    i2 = 0;
                                }
                            }
                            kS(i2);
                        } else {
                            this.ddK.agreeType = 2;
                            this.ddK.hasAgree = true;
                            this.ddK.agreeNum++;
                            fO(true);
                            com.baidu.tieba.o.a.cCv().C(getTbPageContext());
                            if (this.ddP != null) {
                                this.ddP.cNS = 0;
                            }
                        }
                        i2 = 0;
                        kS(i2);
                    } else if (view.getId() == this.ddI.getId()) {
                        this.ddI.cancelAnimation();
                        if (this.ddP != null) {
                            this.ddP.type = 2;
                        }
                        if (this.ddK.hasAgree) {
                            if (this.ddK.agreeType == 5) {
                                this.ddK.agreeType = 5;
                                this.ddK.hasAgree = false;
                                updateUI();
                                if (this.ddP != null) {
                                    this.ddP.cNW = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.ddK.agreeType = 5;
                                this.ddK.hasAgree = true;
                                this.ddK.agreeNum--;
                                fO(false);
                                if (this.ddP != null) {
                                    this.ddP.cNW = 1;
                                }
                            }
                        } else {
                            this.ddK.agreeType = 5;
                            this.ddK.hasAgree = true;
                            fO(false);
                            if (this.ddP != null) {
                                this.ddP.cNW = 1;
                            }
                        }
                        kS(i);
                    }
                    this.ddL.agreeData = this.ddK;
                    if (this.ddK.isInThread) {
                        if (this.ddK.baijiahaoData != null) {
                            this.ddK.nid = this.ddK.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddL));
                        a(this.ddK, AgreeEvent.IS_THREAD);
                    } else if (this.ddK.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddL));
                        a(this.ddK, AgreeEvent.IS_POST);
                    }
                    if (this.Ni != null) {
                        this.Ni.onClick(view);
                    }
                    aHy();
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

    public void kS(int i) {
        if (this.ddK != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.ddK.threadId);
            httpMessage.addParam("op_type", i);
            if (this.ddK.objType == 0) {
                this.ddK.objType = 3;
            }
            httpMessage.addParam("obj_type", this.ddK.objType);
            httpMessage.addParam("agree_type", this.ddK.agreeType);
            httpMessage.addParam("forum_id", this.ddK.forumId);
            if (!TextUtils.isEmpty(this.ddK.postId)) {
                httpMessage.addParam("post_id", this.ddK.postId);
            }
            if (this.ddK.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.ddK.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.ddK.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.ddK.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.ddK.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.ddN) {
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

    public void aHy() {
        if (this.ddP != null && this.ddK != null) {
            int i = 0;
            if (this.ddK.baijiahaoData != null) {
                i = this.ddK.baijiahaoData.oriUgcType;
            }
            if (this.ddP.type == 1) {
                if (StringUtils.isNull(this.ddT)) {
                    an cx = new an("c12003").X("obj_locate", this.ddP.cNP).X("obj_param1", this.ddP.cNQ).X("obj_source", this.ddP.cNR).X("resource_id", this.ddQ).X("obj_id", this.ddP.cNS).X("obj_name", i).cx("post_id", this.ddK.postId);
                    if (this.cRt != null) {
                        cx.cx("tid", this.cRt.getId()).s("fid", this.cRt.getFid()).X("card_type", this.cardType).cx(TiebaInitialize.Params.AB_TAG, this.cRt.mRecomAbTag).cx("recom_source", this.cRt.mRecomSource).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRt.mRecomWeight).cx("extra", this.cRt.mRecomExtra);
                        if (this.cRt.getBaijiahaoData() != null) {
                            cx.cx("obj_param4", this.cRt.getBaijiahaoData().oriUgcNid);
                            if (this.cRt.aBh() || this.cRt.aEl()) {
                                cx.cx("obj_param6", this.cRt.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.cRt.aEj()) {
                            cx.X("obj_param5", 2);
                        } else if (this.cRt.aBg() || this.cRt.aBh()) {
                            cx.X("obj_param5", 3);
                        } else if (this.cRt.threadType == 0 || this.cRt.threadType == 40) {
                            cx.X("obj_param5", 1);
                        }
                    }
                    if (kT(this.ddP.cNP) && kU(this.ddP.cNT) != -1) {
                        cx.X(TiebaInitialize.Params.OBJ_TO, kU(this.ddP.cNT));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        cx.cx("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cx);
                    }
                    TiebaStatic.log(cx);
                    return;
                }
                TiebaStatic.log(new an("c13358").cx("tid", this.ddK.threadId).cx("topic_id", this.ddT));
            } else if (this.ddP.type == 2) {
                an cx2 = new an("c13271").X("obj_type", this.ddP.cNU).X("obj_locate", this.ddP.cNV).X(TiebaInitialize.Params.OBJ_PARAM2, this.ddQ).X("obj_id", this.ddP.cNW).X("obj_name", i).cx("post_id", this.ddK.postId);
                if (this.cRt != null) {
                    cx2.cx("tid", this.cRt.getId()).s("fid", this.cRt.getFid()).X("card_type", this.cardType).cx(TiebaInitialize.Params.AB_TAG, this.cRt.mRecomAbTag).cx("recom_source", this.cRt.mRecomSource).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRt.mRecomWeight).cx("extra", this.cRt.mRecomExtra);
                    if (this.cRt.getBaijiahaoData() != null) {
                        cx2.cx("obj_param4", this.cRt.getBaijiahaoData().oriUgcNid);
                        if (this.cRt.aBh() || this.cRt.aEl()) {
                            cx2.cx("obj_param6", this.cRt.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.cRt.aEj()) {
                        cx2.X("obj_param5", 2);
                    } else if (this.cRt.aBg() || this.cRt.aBh()) {
                        cx2.X("obj_param5", 3);
                    } else if (this.cRt.threadType == 0 || this.cRt.threadType == 40) {
                        cx2.X("obj_param5", 1);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    cx2.cx("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cx2);
                }
                TiebaStatic.log(cx2);
            }
        }
    }

    public static boolean kT(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int kU(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.ddM == null) {
            this.ddM = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ddM.setDuration(200L);
        }
        return this.ddM;
    }

    public void onChangeSkinType(int i) {
        if (this.ddK != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ddN) {
                am.b(this.ddG, this.ddR);
                am.b(this.ddI, this.ddS);
            } else {
                am.a(this.ddG, this.ddR);
                am.a(this.ddI, this.ddS);
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
        this.ddP = dVar;
    }

    public void setGameId(int i) {
        this.ddQ = i;
    }

    public void setAgreeAlone(boolean z) {
        this.ddI.setVisibility(z ? 8 : 0);
        this.ddJ.setVisibility(z ? 8 : 0);
        if (z && this.ddU != null) {
            this.ddU.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cRt = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

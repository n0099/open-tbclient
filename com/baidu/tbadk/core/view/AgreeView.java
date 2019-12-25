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
/* loaded from: classes5.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener Mz;
    private bj cMR;
    private TBLottieAnimationView cYQ;
    private TextView cYR;
    private TBLottieAnimationView cYS;
    private TextView cYT;
    private AgreeData cYU;
    private com.baidu.tieba.tbadkCore.data.e cYV;
    private ScaleAnimation cYW;
    private boolean cYX;
    private boolean cYY;
    private com.baidu.tbadk.core.data.d cYZ;
    private int cZa;
    private int cZb;
    private int cZc;
    private String cZd;
    private View cZe;
    private CustomMessageListener cZf;
    private CustomMessageListener cZg;
    private int cardType;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.cYU != null) {
            this.cYU.agreeType = agreeData.agreeType;
            this.cYU.hasAgree = agreeData.hasAgree;
            this.cYU.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cZb = R.raw.lottie_agree;
        this.cZc = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZf = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && agreeData != null && AgreeView.this.cYV != null && !AgreeView.this.cYU.isInPost && AgreeView.this.cYV.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cYU.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cYU.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cYU.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZg = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && !TextUtils.isEmpty(AgreeView.this.cYU.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cYU.postId.equals(agreeData.postId) && !AgreeView.this.cYU.isInThread) {
                        if (AgreeView.this.cYX) {
                            if (AgreeView.this.cYU.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cYV.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cZb = R.raw.lottie_agree;
        this.cZc = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZf = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && agreeData != null && AgreeView.this.cYV != null && !AgreeView.this.cYU.isInPost && AgreeView.this.cYV.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cYU.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cYU.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cYU.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZg = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && !TextUtils.isEmpty(AgreeView.this.cYU.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cYU.postId.equals(agreeData.postId) && !AgreeView.this.cYU.isInThread) {
                        if (AgreeView.this.cYX) {
                            if (AgreeView.this.cYU.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cYV.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cZb = R.raw.lottie_agree;
        this.cZc = R.raw.lottie_disagree;
        this.cardType = 1;
        this.cZf = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && agreeData != null && AgreeView.this.cYV != null && !AgreeView.this.cYU.isInPost && AgreeView.this.cYV.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.cYU.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.cYU.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.cYU.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.cZg = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cYU != null && !TextUtils.isEmpty(AgreeView.this.cYU.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cYU.postId.equals(agreeData.postId) && !AgreeView.this.cYU.isInThread) {
                        if (AgreeView.this.cYX) {
                            if (AgreeView.this.cYU.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cYV.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.cYQ = new TBLottieAnimationView(context);
        this.cYQ.setId(R.id.img_agree);
        this.cYQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cYQ.setOnClickListener(this.mOnClickListener);
        this.cYQ.addAnimatorListener(this);
        this.cYR = new TextView(context);
        this.cYR.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.cYR.setOnClickListener(this.mOnClickListener);
        this.cYS = new TBLottieAnimationView(context);
        this.cYS.setId(R.id.img_disagree);
        this.cYS.addAnimatorListener(this);
        this.cYS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cYS.setOnClickListener(this.mOnClickListener);
        this.cYT = new TextView(context);
        this.cYT.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.cYT.setOnClickListener(this.mOnClickListener);
        this.cYV = new com.baidu.tieba.tbadkCore.data.e();
        this.cYV.uniqueId = getPageId();
        aEH();
        setAgreeAnimationResource();
    }

    private void aEH() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.cYQ, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.cYR, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.cYS, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.cYT.setText(R.string.c_disagree);
        addView(this.cYT, layoutParams2);
    }

    public void aEI() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.cYQ.setLayoutParams(layoutParams);
        this.cYR.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.cYR.setLayoutParams(layoutParams2);
        this.cYS.setVisibility(8);
        this.cYT.setVisibility(8);
    }

    public void aEJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.cYQ.setLayoutParams(layoutParams);
        this.cYR.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.cYR.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.cYS.setLayoutParams(layoutParams3);
        this.cYT.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.cYT.setLayoutParams(layoutParams4);
    }

    public void aEK() {
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
        linearLayout.addView(this.cYQ, new LinearLayout.LayoutParams(dimens, dimens));
        this.cYR.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.cYR, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.cZe = linearLayout2;
        linearLayout2.addView(this.cYS, new LinearLayout.LayoutParams(dimens, dimens));
        this.cYT.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.cYT, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cZf);
        MessageManager.getInstance().registerListener(this.cZg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cZf);
        MessageManager.getInstance().unRegisterListener(this.cZg);
    }

    public void setTopicId(String str) {
        this.cZd = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.cYX = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.cYY = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.cYQ;
    }

    public TextView getAgreeNumView() {
        return this.cYR;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.cYS;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.cYU = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.cYU;
    }

    public void setAgreeAnimationResource() {
        if (this.cYX) {
            this.cYQ.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZb));
            this.cYS.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZc));
            return;
        }
        am.a(this.cYQ, this.cZb);
        am.a(this.cYS, this.cZc);
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
        this.cYR.setText(b(this.cYU));
        if (this.cYU.hasAgree) {
            if (this.cYU.agreeType == 2) {
                this.cYS.setProgress(0.0f);
                this.cYQ.setProgress(1.0f);
                this.cYR.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.cYT);
                return;
            }
            this.cYQ.setProgress(0.0f);
            this.cYS.setProgress(1.0f);
            setTextNormalColor(this.cYR);
            this.cYT.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.cYQ.setProgress(0.0f);
        this.cYS.setProgress(0.0f);
        setTextNormalColor(this.cYR);
        setTextNormalColor(this.cYT);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.cYY) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.cYX) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fB(boolean z) {
        this.cYQ.setMinAndMaxProgress(0.0f, 1.0f);
        this.cYS.setMinAndMaxProgress(0.0f, 1.0f);
        this.cYR.setText(b(this.cYU));
        this.cYQ.clearColorFilter();
        this.cYS.clearColorFilter();
        if (z) {
            this.cYQ.playAnimation();
            this.cYS.cancelAnimation();
            this.cYS.setFrame(0);
        } else {
            this.cYS.playAnimation();
            this.cYQ.cancelAnimation();
            this.cYQ.setFrame(0);
        }
        if (this.cYU.hasAgree) {
            if (this.cYU.agreeType == 2) {
                this.cYR.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.cYT);
                return;
            }
            setTextNormalColor(this.cYR);
            this.cYT.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.cYR);
        setTextNormalColor(this.cYT);
    }

    public void aEL() {
        aN(this.cYQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i = 0;
        int i2 = 1;
        if (this.cYU != null) {
            if (!this.cYX || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.cYX || bc.checkUpIsLogin(getContext())) && view != this.cYR) {
                    if (view.getId() == this.cYQ.getId()) {
                        this.cYQ.cancelAnimation();
                        if (this.cYZ != null) {
                            this.cYZ.type = 1;
                        }
                        if (this.cYU.hasAgree) {
                            if (this.cYU.agreeType == 2) {
                                this.cYU.agreeType = 2;
                                this.cYU.hasAgree = false;
                                this.cYU.agreeNum--;
                                updateUI();
                                if (this.cYZ != null) {
                                    this.cYZ.cJp = 1;
                                }
                            } else {
                                this.cYU.agreeType = 2;
                                this.cYU.hasAgree = true;
                                this.cYU.agreeNum++;
                                fB(true);
                                com.baidu.tieba.n.a.czt().B(getTbPageContext());
                                if (this.cYZ != null) {
                                    this.cYZ.cJp = 0;
                                    i2 = 0;
                                }
                            }
                            kB(i2);
                        } else {
                            this.cYU.agreeType = 2;
                            this.cYU.hasAgree = true;
                            this.cYU.agreeNum++;
                            fB(true);
                            com.baidu.tieba.n.a.czt().B(getTbPageContext());
                            if (this.cYZ != null) {
                                this.cYZ.cJp = 0;
                            }
                        }
                        i2 = 0;
                        kB(i2);
                    } else if (view.getId() == this.cYS.getId()) {
                        this.cYS.cancelAnimation();
                        if (this.cYZ != null) {
                            this.cYZ.type = 2;
                        }
                        if (this.cYU.hasAgree) {
                            if (this.cYU.agreeType == 5) {
                                this.cYU.agreeType = 5;
                                this.cYU.hasAgree = false;
                                updateUI();
                                if (this.cYZ != null) {
                                    this.cYZ.cJt = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.cYU.agreeType = 5;
                                this.cYU.hasAgree = true;
                                this.cYU.agreeNum--;
                                fB(false);
                                if (this.cYZ != null) {
                                    this.cYZ.cJt = 1;
                                }
                            }
                        } else {
                            this.cYU.agreeType = 5;
                            this.cYU.hasAgree = true;
                            fB(false);
                            if (this.cYZ != null) {
                                this.cYZ.cJt = 1;
                            }
                        }
                        kB(i);
                    }
                    this.cYV.agreeData = this.cYU;
                    if (this.cYU.isInThread) {
                        if (this.cYU.baijiahaoData != null) {
                            this.cYU.nid = this.cYU.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cYV));
                        a(this.cYU, AgreeEvent.IS_THREAD);
                    } else if (this.cYU.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cYV));
                        a(this.cYU, AgreeEvent.IS_POST);
                    }
                    if (this.Mz != null) {
                        this.Mz.onClick(view);
                    }
                    aEM();
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
        if (this.cYU != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.cYU.threadId);
            httpMessage.addParam("op_type", i);
            if (this.cYU.objType == 0) {
                this.cYU.objType = 3;
            }
            httpMessage.addParam("obj_type", this.cYU.objType);
            httpMessage.addParam("agree_type", this.cYU.agreeType);
            httpMessage.addParam("forum_id", this.cYU.forumId);
            if (!TextUtils.isEmpty(this.cYU.postId)) {
                httpMessage.addParam("post_id", this.cYU.postId);
            }
            if (this.cYU.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.cYU.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.cYU.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.cYU.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.cYU.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.cYX) {
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

    public void aEM() {
        if (this.cYZ != null && this.cYU != null) {
            int i = 0;
            if (this.cYU.baijiahaoData != null) {
                i = this.cYU.baijiahaoData.oriUgcType;
            }
            if (this.cYZ.type == 1) {
                if (StringUtils.isNull(this.cZd)) {
                    an cp = new an("c12003").Z("obj_locate", this.cYZ.cJm).Z("obj_param1", this.cYZ.cJn).Z("obj_source", this.cYZ.cJo).Z("resource_id", this.cZa).Z("obj_id", this.cYZ.cJp).Z("obj_name", i).cp("post_id", this.cYU.postId);
                    if (this.cMR != null) {
                        cp.cp("tid", this.cMR.getId()).s("fid", this.cMR.getFid()).Z("card_type", this.cardType).cp(TiebaInitialize.Params.AB_TAG, this.cMR.mRecomAbTag).cp("source", this.cMR.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cMR.mRecomWeight).cp("extra", this.cMR.mRecomExtra);
                    }
                    if (kC(this.cYZ.cJm) && kD(this.cYZ.cJq) != -1) {
                        cp.Z(TiebaInitialize.Params.OBJ_TO, kD(this.cYZ.cJq));
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cp);
                    }
                    TiebaStatic.log(cp);
                    return;
                }
                TiebaStatic.log(new an("c13358").cp("tid", this.cYU.threadId).cp("topic_id", this.cZd));
            } else if (this.cYZ.type == 2) {
                an cp2 = new an("c13271").Z("obj_type", this.cYZ.cJr).Z("obj_locate", this.cYZ.cJs).Z(TiebaInitialize.Params.OBJ_PARAM2, this.cZa).Z("obj_id", this.cYZ.cJt).Z("obj_name", i).cp("post_id", this.cYU.postId);
                if (this.cMR != null) {
                    cp2.cp("tid", this.cMR.getId()).s("fid", this.cMR.getFid()).Z("card_type", this.cardType).cp(TiebaInitialize.Params.AB_TAG, this.cMR.mRecomAbTag).cp("source", this.cMR.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cMR.mRecomWeight).cp("extra", this.cMR.mRecomExtra);
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
        if (this.cYW == null) {
            this.cYW = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.cYW.setDuration(200L);
        }
        return this.cYW;
    }

    public void onChangeSkinType(int i) {
        if (this.cYU != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.cYX) {
                this.cYQ.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZb));
                this.cYS.setAnimation(am.c(TbadkCoreApplication.getInst().getResources(), this.cZc));
            } else {
                am.a(this.cYQ, this.cZb);
                am.a(this.cYS, this.cZc);
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
        this.cYZ = dVar;
    }

    public void setGameId(int i) {
        this.cZa = i;
    }

    public void setAgreeAlone(boolean z) {
        this.cYS.setVisibility(z ? 8 : 0);
        this.cYT.setVisibility(z ? 8 : 0);
        if (z && this.cZe != null) {
            this.cZe.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cMR = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }
}

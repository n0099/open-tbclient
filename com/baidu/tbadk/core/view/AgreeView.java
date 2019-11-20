package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private ColorFilter Ip;
    private TBLottieAnimationView clA;
    private TextView clB;
    private int clC;
    private AgreeData clD;
    private com.baidu.tieba.tbadkCore.data.e clE;
    private CustomMessageListener clG;
    private CustomMessageListener clH;
    private TBLottieAnimationView clJ;
    private int clK;
    private int clL;
    private int clM;
    private int clN;
    private ScaleAnimation clO;
    private String clP;
    private boolean clQ;
    private boolean clR;
    private com.baidu.tbadk.core.data.d clS;
    private int clT;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.clD.threadId.equals(agreeData.threadId) && AgreeView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.clD.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.clQ) {
                            if (AgreeView.this.clD.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.clE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
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
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.clD.threadId.equals(agreeData.threadId) && AgreeView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.clD.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.clQ) {
                            if (AgreeView.this.clD.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.clE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
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
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.clD.threadId.equals(agreeData.threadId) && AgreeView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.clD != null && !TextUtils.isEmpty(AgreeView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.clD.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.clQ) {
                            if (AgreeView.this.clD.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.clE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.clD.agreeType = agreeData.agreeType;
                        AgreeView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
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
        setGravity(5);
        this.clC = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136);
        this.clK = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds17);
        this.clL = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds7);
        this.clM = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds3);
        this.clN = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds13);
        this.clA = new TBLottieAnimationView(context);
        this.clA.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.clC, this.clC);
        layoutParams.gravity = 16;
        addView(this.clA, layoutParams);
        this.clA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.clA.setOnClickListener(this.mOnClickListener);
        this.clB = new TextView(context);
        this.clB.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.clK;
        layoutParams2.rightMargin = this.clK;
        addView(this.clB, layoutParams2);
        this.clJ = new TBLottieAnimationView(context);
        this.clJ.setId(R.id.img_disagree);
        this.clJ.addAnimatorListener(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.clC, this.clC);
        layoutParams3.gravity = 16;
        addView(this.clJ, layoutParams3);
        this.clJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.clA.addAnimatorListener(this);
        this.clJ.setOnClickListener(this.mOnClickListener);
        this.clP = context.getString(R.string.agree_disagree);
        this.Ip = new com.airbnb.lottie.k(am.getColor(R.color.cp_cont_j));
        this.clE = new com.baidu.tieba.tbadkCore.data.e();
        this.clE.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.clG);
        MessageManager.getInstance().registerListener(this.clH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.clG);
        MessageManager.getInstance().unRegisterListener(this.clH);
    }

    public void setIsFromBigpic(boolean z) {
        this.clQ = z;
        if (z) {
            this.Ip = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.clR = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.clA;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.clJ;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.clD = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.clD;
    }

    public void setAgreeAnimationResource(int i) {
        this.clA.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.clJ.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.clC = i;
        this.clK = i2;
        this.clL = i3;
        this.clM = i4;
        this.clN = i5;
        ViewGroup.LayoutParams layoutParams = this.clA.getLayoutParams();
        layoutParams.width = this.clC;
        layoutParams.height = this.clC;
        this.clA.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.clJ.getLayoutParams();
        layoutParams2.width = this.clC;
        layoutParams2.height = this.clC;
        this.clJ.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.clB.getLayoutParams();
        layoutParams3.leftMargin = this.clK;
        layoutParams3.rightMargin = this.clK;
        this.clB.setLayoutParams(layoutParams3);
    }

    private String a(AgreeData agreeData) {
        if (agreeData == null || (agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0)) {
            return getContext().getString(R.string.agree_disagree);
        }
        if (agreeData.diffAgreeNum >= 0) {
            return aq.numFormatOverWanNa(agreeData.diffAgreeNum);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + aq.numFormatOverWanNa(-agreeData.diffAgreeNum);
    }

    public void updateUI() {
        String a = a(this.clD);
        ot(a);
        this.clB.setText(a);
        if (this.clD.hasAgree) {
            if (this.clD.agreeType == 2) {
                this.clJ.setProgress(0.0f);
                this.clA.setProgress(1.0f);
                this.clB.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            }
            this.clA.setProgress(0.0f);
            this.clJ.setProgress(1.0f);
            this.clB.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.clA.setMinAndMaxProgress(0.0f, 0.0f);
        this.clJ.setMinAndMaxProgress(0.0f, 0.0f);
        this.clA.setProgress(0.0f);
        this.clJ.setProgress(0.0f);
        if (this.clR) {
            this.clB.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.clQ) {
            this.clB.setTextColor(am.getColor(R.color.white_alpha83));
        } else {
            this.clB.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    private void ot(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clB.getLayoutParams();
            if (str.equals(this.clP)) {
                layoutParams.leftMargin = this.clK;
                layoutParams.rightMargin = this.clK;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.clL;
                layoutParams.rightMargin = this.clL;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.clM;
                layoutParams.rightMargin = this.clM;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.clN;
                layoutParams.rightMargin = this.clN;
            } else {
                layoutParams.leftMargin = this.clK;
                layoutParams.rightMargin = this.clK;
            }
            this.clB.setLayoutParams(layoutParams);
        }
    }

    public void ep(boolean z) {
        this.clA.setMinAndMaxProgress(0.0f, 1.0f);
        this.clJ.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.clD);
        ot(a);
        this.clB.setText(a);
        this.clA.clearColorFilter();
        this.clJ.clearColorFilter();
        if (z) {
            this.clA.playAnimation();
            this.clJ.cancelAnimation();
            this.clJ.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.clJ.playAnimation();
            this.clA.cancelAnimation();
            this.clA.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.clA.setFrame(0);
        this.clJ.setFrame(0);
        if (this.clD.hasAgree) {
            if (this.clD.agreeType == 2) {
                this.clB.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.clB.setTextColor(am.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.clB.setTextColor(am.getColor(R.color.cp_cont_c));
    }

    public void ans() {
        aN(this.clA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i;
        int i2 = 0;
        if (this.clD != null) {
            if (!this.clQ || com.baidu.tbadk.n.a.checkUpIsLogin(getContext())) {
                if (this.clQ || bc.checkUpIsLogin(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).playAnimation();
                    }
                    if (view.getId() == this.clA.getId()) {
                        if (this.clS != null) {
                            this.clS.type = 1;
                        }
                        if (this.clD.hasAgree) {
                            if (this.clD.agreeType == 2) {
                                this.clD.agreeType = 2;
                                this.clD.hasAgree = false;
                                this.clD.diffAgreeNum--;
                                this.clD.agreeNum--;
                                updateUI();
                                if (this.clS != null) {
                                    this.clS.bXc = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.clD.agreeType = 2;
                                this.clD.hasAgree = true;
                                this.clD.diffAgreeNum += 2;
                                this.clD.agreeNum++;
                                this.clD.disAgreeNum--;
                                ep(true);
                                com.baidu.tieba.n.a.cfn().z(getTbPageContext());
                                if (this.clS != null) {
                                    this.clS.bXc = 0;
                                    i = 0;
                                }
                            }
                            ix(i);
                        } else {
                            this.clD.agreeType = 2;
                            this.clD.hasAgree = true;
                            this.clD.diffAgreeNum++;
                            this.clD.agreeNum++;
                            ep(true);
                            com.baidu.tieba.n.a.cfn().z(getTbPageContext());
                            if (this.clS != null) {
                                this.clS.bXc = 0;
                            }
                        }
                        i = 0;
                        ix(i);
                    } else if (view.getId() == this.clJ.getId()) {
                        if (this.clS != null) {
                            this.clS.type = 2;
                        }
                        if (this.clD.hasAgree) {
                            if (this.clD.agreeType == 5) {
                                this.clD.agreeType = 5;
                                this.clD.hasAgree = false;
                                this.clD.diffAgreeNum++;
                                this.clD.disAgreeNum--;
                                updateUI();
                                if (this.clS != null) {
                                    this.clS.bXf = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.clD.agreeType = 5;
                                this.clD.hasAgree = true;
                                this.clD.diffAgreeNum -= 2;
                                this.clD.agreeNum--;
                                this.clD.disAgreeNum++;
                                ep(false);
                                if (this.clS != null) {
                                    this.clS.bXf = 1;
                                }
                            }
                        } else {
                            this.clD.agreeType = 5;
                            this.clD.hasAgree = true;
                            this.clD.diffAgreeNum--;
                            this.clD.disAgreeNum++;
                            ep(false);
                            if (this.clS != null) {
                                this.clS.bXf = 1;
                            }
                        }
                        ix(i2);
                    }
                    this.clE.agreeData = this.clD;
                    if (this.clD.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.clE));
                        a(this.clD, "isInThread");
                    } else if (this.clD.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.clE));
                        a(this.clD, "isInPost");
                    }
                    ant();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void ix(int i) {
        if (this.clD != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.clD.threadId);
            httpMessage.addParam("op_type", i);
            if (this.clD.objType == 0) {
                this.clD.objType = 3;
            }
            httpMessage.addParam("obj_type", this.clD.objType);
            httpMessage.addParam("agree_type", this.clD.agreeType);
            httpMessage.addParam("forum_id", this.clD.forumId);
            if (!TextUtils.isEmpty(this.clD.postId)) {
                httpMessage.addParam("post_id", this.clD.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.clQ) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.n.a.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.n.a.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getStoken())) {
                    httpMessage.addParam("stoken", com.baidu.tbadk.n.a.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void ant() {
        if (this.clS != null) {
            if (this.clS.type == 1) {
                TiebaStatic.log(new an("c12003").O("obj_locate", this.clS.bWZ).O("obj_param1", this.clS.bXa).O("obj_source", this.clS.bXb).O("resource_id", this.clT).O("obj_id", this.clS.bXc));
            } else if (this.clS.type == 2) {
                TiebaStatic.log(new an("c13271").O("obj_type", this.clS.bXd).O("obj_locate", this.clS.bXe).O(TiebaInitialize.Params.OBJ_PARAM2, this.clT).O("obj_id", this.clS.bXf));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.clO == null) {
            this.clO = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.clO.setDuration(200L);
        }
        return this.clO;
    }

    public void onChangeSkinType(int i) {
        if (this.clD != null && this.mSkinType != i) {
            if (this.clQ) {
                this.Ip = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            am.a(this.clA, R.raw.agree);
            am.a(this.clJ, R.raw.disagree);
            updateUI();
            this.mSkinType = i;
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
        updateUI();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.clS = dVar;
    }

    public void setGameId(int i) {
        this.clT = i;
    }
}

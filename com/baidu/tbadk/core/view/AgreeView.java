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
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
    private ColorFilter YT;
    private int bXA;
    private ScaleAnimation bXB;
    private String bXC;
    private boolean bXD;
    private boolean bXE;
    private com.baidu.tbadk.core.data.d bXF;
    private int bXG;
    private TBLottieAnimationView bXn;
    private TextView bXo;
    private int bXp;
    private AgreeData bXq;
    private com.baidu.tieba.tbadkCore.data.e bXr;
    private CustomMessageListener bXt;
    private CustomMessageListener bXu;
    private TBLottieAnimationView bXw;
    private int bXx;
    private int bXy;
    private int bXz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bXq.threadId.equals(agreeData.threadId) && AgreeView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bXq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bXD) {
                            if (AgreeView.this.bXq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bXr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aM(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bXq.threadId.equals(agreeData.threadId) && AgreeView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bXq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bXD) {
                            if (AgreeView.this.bXq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bXr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aM(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bXq.threadId.equals(agreeData.threadId) && AgreeView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bXq != null && !TextUtils.isEmpty(AgreeView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bXq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bXD) {
                            if (AgreeView.this.bXq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bXr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aM(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bXp = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136);
        this.bXx = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds17);
        this.bXy = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds7);
        this.bXz = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds3);
        this.bXA = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds13);
        this.bXn = new TBLottieAnimationView(context);
        this.bXn.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bXp, this.bXp);
        layoutParams.gravity = 16;
        addView(this.bXn, layoutParams);
        this.bXn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bXn.setOnClickListener(this.mOnClickListener);
        this.bXo = new TextView(context);
        this.bXo.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bXx;
        layoutParams2.rightMargin = this.bXx;
        addView(this.bXo, layoutParams2);
        this.bXw = new TBLottieAnimationView(context);
        this.bXw.setId(R.id.img_disagree);
        this.bXw.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bXp, this.bXp);
        layoutParams3.gravity = 16;
        addView(this.bXw, layoutParams3);
        this.bXw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bXn.a(this);
        this.bXw.setOnClickListener(this.mOnClickListener);
        this.bXC = context.getString(R.string.agree_disagree);
        this.YT = new com.airbnb.lottie.k(am.getColor(R.color.cp_cont_j));
        this.bXr = new com.baidu.tieba.tbadkCore.data.e();
        this.bXr.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bXt);
        MessageManager.getInstance().registerListener(this.bXu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bXt);
        MessageManager.getInstance().unRegisterListener(this.bXu);
    }

    public void setIsFromBigpic(boolean z) {
        this.bXD = z;
        if (z) {
            this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bXE = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bXn;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bXw;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bXq = agreeData;
            JW();
        }
    }

    public AgreeData getData() {
        return this.bXq;
    }

    public void setAgreeAnimationResource(int i) {
        this.bXn.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bXw.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bXp = i;
        this.bXx = i2;
        this.bXy = i3;
        this.bXz = i4;
        this.bXA = i5;
        ViewGroup.LayoutParams layoutParams = this.bXn.getLayoutParams();
        layoutParams.width = this.bXp;
        layoutParams.height = this.bXp;
        this.bXn.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bXw.getLayoutParams();
        layoutParams2.width = this.bXp;
        layoutParams2.height = this.bXp;
        this.bXw.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bXo.getLayoutParams();
        layoutParams3.leftMargin = this.bXx;
        layoutParams3.rightMargin = this.bXx;
        this.bXo.setLayoutParams(layoutParams3);
    }

    private String a(AgreeData agreeData) {
        if (agreeData == null || (agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0)) {
            return getContext().getString(R.string.agree_disagree);
        }
        if (agreeData.diffAgreeNum >= 0) {
            return aq.aN(agreeData.diffAgreeNum);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + aq.aN(-agreeData.diffAgreeNum);
    }

    public void JW() {
        String a = a(this.bXq);
        oT(a);
        this.bXo.setText(a);
        if (this.bXq.hasAgree) {
            if (this.bXq.agreeType == 2) {
                this.bXw.setProgress(0.0f);
                this.bXn.setProgress(1.0f);
                this.bXo.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            }
            this.bXn.setProgress(0.0f);
            this.bXw.setProgress(1.0f);
            this.bXo.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.bXn.setMinAndMaxProgress(0.0f, 0.0f);
        this.bXw.setMinAndMaxProgress(0.0f, 0.0f);
        this.bXn.setProgress(0.0f);
        this.bXw.setProgress(0.0f);
        if (this.bXE) {
            this.bXo.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.bXD) {
            this.bXo.setTextColor(am.getColor(R.color.white_alpha83));
        } else {
            this.bXo.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    private void oT(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXo.getLayoutParams();
            if (str.equals(this.bXC)) {
                layoutParams.leftMargin = this.bXx;
                layoutParams.rightMargin = this.bXx;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bXy;
                layoutParams.rightMargin = this.bXy;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bXz;
                layoutParams.rightMargin = this.bXz;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bXA;
                layoutParams.rightMargin = this.bXA;
            } else {
                layoutParams.leftMargin = this.bXx;
                layoutParams.rightMargin = this.bXx;
            }
            this.bXo.setLayoutParams(layoutParams);
        }
    }

    public void ek(boolean z) {
        this.bXn.setMinAndMaxProgress(0.0f, 1.0f);
        this.bXw.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bXq);
        oT(a);
        this.bXo.setText(a);
        this.bXn.clearColorFilter();
        this.bXw.clearColorFilter();
        if (z) {
            this.bXn.br();
            this.bXw.cancelAnimation();
            this.bXw.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bXw.br();
            this.bXn.cancelAnimation();
            this.bXn.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bXn.setFrame(0);
        this.bXw.setFrame(0);
        if (this.bXq.hasAgree) {
            if (this.bXq.agreeType == 2) {
                this.bXo.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.bXo.setTextColor(am.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.bXo.setTextColor(am.getColor(R.color.cp_cont_c));
    }

    public void aks() {
        aM(this.bXn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        int i2 = 0;
        if (this.bXq != null) {
            if (!this.bXD || com.baidu.tbadk.n.a.cF(getContext())) {
                if (this.bXD || bc.cF(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).br();
                    }
                    if (view.getId() == this.bXn.getId()) {
                        if (this.bXF != null) {
                            this.bXF.type = 1;
                        }
                        if (this.bXq.hasAgree) {
                            if (this.bXq.agreeType == 2) {
                                this.bXq.agreeType = 2;
                                this.bXq.hasAgree = false;
                                this.bXq.diffAgreeNum--;
                                this.bXq.agreeNum--;
                                JW();
                                if (this.bXF != null) {
                                    this.bXF.bGb = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bXq.agreeType = 2;
                                this.bXq.hasAgree = true;
                                this.bXq.diffAgreeNum += 2;
                                this.bXq.agreeNum++;
                                this.bXq.disAgreeNum--;
                                ek(true);
                                com.baidu.tieba.n.a.cir().z(getTbPageContext());
                                if (this.bXF != null) {
                                    this.bXF.bGb = 0;
                                    i = 0;
                                }
                            }
                            iz(i);
                        } else {
                            this.bXq.agreeType = 2;
                            this.bXq.hasAgree = true;
                            this.bXq.diffAgreeNum++;
                            this.bXq.agreeNum++;
                            ek(true);
                            com.baidu.tieba.n.a.cir().z(getTbPageContext());
                            if (this.bXF != null) {
                                this.bXF.bGb = 0;
                            }
                        }
                        i = 0;
                        iz(i);
                    } else if (view.getId() == this.bXw.getId()) {
                        if (this.bXF != null) {
                            this.bXF.type = 2;
                        }
                        if (this.bXq.hasAgree) {
                            if (this.bXq.agreeType == 5) {
                                this.bXq.agreeType = 5;
                                this.bXq.hasAgree = false;
                                this.bXq.diffAgreeNum++;
                                this.bXq.disAgreeNum--;
                                JW();
                                if (this.bXF != null) {
                                    this.bXF.bGe = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bXq.agreeType = 5;
                                this.bXq.hasAgree = true;
                                this.bXq.diffAgreeNum -= 2;
                                this.bXq.agreeNum--;
                                this.bXq.disAgreeNum++;
                                ek(false);
                                if (this.bXF != null) {
                                    this.bXF.bGe = 1;
                                }
                            }
                        } else {
                            this.bXq.agreeType = 5;
                            this.bXq.hasAgree = true;
                            this.bXq.diffAgreeNum--;
                            this.bXq.disAgreeNum++;
                            ek(false);
                            if (this.bXF != null) {
                                this.bXF.bGe = 1;
                            }
                        }
                        iz(i2);
                    }
                    this.bXr.agreeData = this.bXq;
                    if (this.bXq.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bXr));
                        a(this.bXq, "isInThread");
                    } else if (this.bXq.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bXr));
                        a(this.bXq, "isInPost");
                    }
                    akt();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iz(int i) {
        if (this.bXq != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bXq.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bXq.objType == 0) {
                this.bXq.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bXq.objType);
            httpMessage.addParam("agree_type", this.bXq.agreeType);
            httpMessage.addParam("forum_id", this.bXq.forumId);
            if (!TextUtils.isEmpty(this.bXq.postId)) {
                httpMessage.addParam("post_id", this.bXq.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bXD) {
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

    public void akt() {
        if (this.bXF != null) {
            if (this.bXF.type == 1) {
                TiebaStatic.log(new an("c12003").P("obj_locate", this.bXF.bFY).P("obj_param1", this.bXF.bFZ).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bXF.bGa).P("resource_id", this.bXG).P(VideoPlayActivityConfig.OBJ_ID, this.bXF.bGb));
            } else if (this.bXF.type == 2) {
                TiebaStatic.log(new an("c13271").P("obj_type", this.bXF.bGc).P("obj_locate", this.bXF.bGd).P("obj_param2", this.bXG).P(VideoPlayActivityConfig.OBJ_ID, this.bXF.bGe));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bXB == null) {
            this.bXB = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bXB.setDuration(200L);
        }
        return this.bXB;
    }

    public void onChangeSkinType(int i) {
        if (this.bXq != null && this.mSkinType != i) {
            if (this.bXD) {
                this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            am.a(this.bXn, (int) R.raw.agree);
            am.a(this.bXw, (int) R.raw.disagree);
            JW();
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
        JW();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.bXF = dVar;
    }

    public void setGameId(int i) {
        this.bXG = i;
    }
}

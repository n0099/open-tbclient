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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private ColorFilter aaF;
    private int bNA;
    private AgreeData bNB;
    private com.baidu.tieba.tbadkCore.data.e bNC;
    private CustomMessageListener bNE;
    private CustomMessageListener bNF;
    private TBLottieAnimationView bNH;
    private int bNI;
    private int bNJ;
    private int bNK;
    private int bNL;
    private ScaleAnimation bNM;
    private String bNN;
    private boolean bNO;
    private boolean bNP;
    private com.baidu.tbadk.core.data.d bNQ;
    private TBLottieAnimationView bNy;
    private TextView bNz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNB.threadId.equals(agreeData.threadId) && AgreeView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNB.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNO) {
                            if (AgreeView.this.bNB.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNC.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aE(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNB.threadId.equals(agreeData.threadId) && AgreeView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNB.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNO) {
                            if (AgreeView.this.bNB.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNC.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aE(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNB.threadId.equals(agreeData.threadId) && AgreeView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNB != null && !TextUtils.isEmpty(AgreeView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNB.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNO) {
                            if (AgreeView.this.bNB.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNC.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aE(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bNA = com.baidu.adp.lib.util.l.h(context, d.e.tbds136);
        this.bNI = -com.baidu.adp.lib.util.l.h(context, d.e.tbds17);
        this.bNJ = com.baidu.adp.lib.util.l.h(context, d.e.tbds7);
        this.bNK = -com.baidu.adp.lib.util.l.h(context, d.e.tbds3);
        this.bNL = -com.baidu.adp.lib.util.l.h(context, d.e.tbds13);
        this.bNy = new TBLottieAnimationView(context);
        this.bNy.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bNA, this.bNA);
        layoutParams.gravity = 16;
        addView(this.bNy, layoutParams);
        this.bNy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNy.setOnClickListener(this.mOnClickListener);
        this.bNz = new TextView(context);
        this.bNz.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bNI;
        layoutParams2.rightMargin = this.bNI;
        addView(this.bNz, layoutParams2);
        this.bNH = new TBLottieAnimationView(context);
        this.bNH.setId(d.g.img_disagree);
        this.bNH.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bNA, this.bNA);
        layoutParams3.gravity = 16;
        addView(this.bNH, layoutParams3);
        this.bNH.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNy.a(this);
        this.bNH.setOnClickListener(this.mOnClickListener);
        this.bNN = context.getString(d.j.agree_disagree);
        this.aaF = new com.airbnb.lottie.k(al.getColor(d.C0277d.cp_cont_j));
        this.bNC = new com.baidu.tieba.tbadkCore.data.e();
        this.bNC.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNE);
        MessageManager.getInstance().registerListener(this.bNF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bNE);
        MessageManager.getInstance().unRegisterListener(this.bNF);
    }

    public void setIsFromBigpic(boolean z) {
        this.bNO = z;
        if (z) {
            this.aaF = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bNP = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bNy;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bNH;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNB = agreeData;
            GR();
        }
    }

    public AgreeData getData() {
        return this.bNB;
    }

    public void setAgreeAnimationResource(int i) {
        this.bNy.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bNH.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bNA = i;
        this.bNI = i2;
        this.bNJ = i3;
        this.bNK = i4;
        this.bNL = i5;
        ViewGroup.LayoutParams layoutParams = this.bNy.getLayoutParams();
        layoutParams.width = this.bNA;
        layoutParams.height = this.bNA;
        this.bNy.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bNH.getLayoutParams();
        layoutParams2.width = this.bNA;
        layoutParams2.height = this.bNA;
        this.bNH.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bNz.getLayoutParams();
        layoutParams3.leftMargin = this.bNI;
        layoutParams3.rightMargin = this.bNI;
        this.bNz.setLayoutParams(layoutParams3);
    }

    private String a(AgreeData agreeData) {
        if (agreeData == null || (agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0)) {
            return getContext().getString(d.j.agree_disagree);
        }
        if (agreeData.diffAgreeNum >= 0) {
            return ap.ay(agreeData.diffAgreeNum);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + ap.ay(-agreeData.diffAgreeNum);
    }

    public void GR() {
        String a = a(this.bNB);
        nk(a);
        this.bNz.setText(a);
        if (this.bNB.hasAgree) {
            if (this.bNB.agreeType == 2) {
                this.bNH.setProgress(0.0f);
                this.bNy.setProgress(1.0f);
                this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            }
            this.bNy.setProgress(0.0f);
            this.bNH.setProgress(1.0f);
            this.bNz.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            return;
        }
        this.bNy.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNH.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNy.setProgress(0.0f);
        this.bNH.setProgress(0.0f);
        if (this.bNP) {
            this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        } else if (this.bNO) {
            this.bNz.setTextColor(al.getColor(d.C0277d.white_alpha83));
        } else {
            this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    private void nk(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNz.getLayoutParams();
            if (str.equals(this.bNN)) {
                layoutParams.leftMargin = this.bNI;
                layoutParams.rightMargin = this.bNI;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bNJ;
                layoutParams.rightMargin = this.bNJ;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bNK;
                layoutParams.rightMargin = this.bNK;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bNL;
                layoutParams.rightMargin = this.bNL;
            } else {
                layoutParams.leftMargin = this.bNI;
                layoutParams.rightMargin = this.bNI;
            }
            this.bNz.setLayoutParams(layoutParams);
        }
    }

    public void dH(boolean z) {
        this.bNy.setMinAndMaxProgress(0.0f, 1.0f);
        this.bNH.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bNB);
        nk(a);
        this.bNz.setText(a);
        this.bNy.clearColorFilter();
        this.bNH.clearColorFilter();
        if (z) {
            this.bNy.cu();
            this.bNH.cancelAnimation();
            this.bNH.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bNH.cu();
            this.bNy.cancelAnimation();
            this.bNy.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bNy.setFrame(0);
        this.bNH.setFrame(0);
        if (this.bNB.hasAgree) {
            if (this.bNB.agreeType == 2) {
                this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            } else {
                this.bNz.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
                return;
            }
        }
        this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_c));
    }

    public void aee() {
        aE(this.bNy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        int i2 = 0;
        if (this.bNB != null) {
            if (!this.bNO || com.baidu.tbadk.n.a.cZ(getContext())) {
                if (this.bNO || bc.cZ(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).cu();
                    }
                    if (view.getId() == this.bNy.getId()) {
                        if (this.bNQ != null) {
                            this.bNQ.type = 1;
                        }
                        if (this.bNB.hasAgree) {
                            if (this.bNB.agreeType == 2) {
                                this.bNB.agreeType = 2;
                                this.bNB.hasAgree = false;
                                this.bNB.diffAgreeNum--;
                                this.bNB.agreeNum--;
                                GR();
                                if (this.bNQ != null) {
                                    this.bNQ.bxm = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bNB.agreeType = 2;
                                this.bNB.hasAgree = true;
                                this.bNB.diffAgreeNum += 2;
                                this.bNB.agreeNum++;
                                this.bNB.disAgreeNum--;
                                dH(true);
                                com.baidu.tieba.n.a.bWr().y(getTbPageContext());
                                if (this.bNQ != null) {
                                    this.bNQ.bxm = 0;
                                    i = 0;
                                }
                            }
                            hD(i);
                        } else {
                            this.bNB.agreeType = 2;
                            this.bNB.hasAgree = true;
                            this.bNB.diffAgreeNum++;
                            this.bNB.agreeNum++;
                            dH(true);
                            com.baidu.tieba.n.a.bWr().y(getTbPageContext());
                            if (this.bNQ != null) {
                                this.bNQ.bxm = 0;
                            }
                        }
                        i = 0;
                        hD(i);
                    } else if (view.getId() == this.bNH.getId()) {
                        if (this.bNQ != null) {
                            this.bNQ.type = 2;
                        }
                        if (this.bNB.hasAgree) {
                            if (this.bNB.agreeType == 5) {
                                this.bNB.agreeType = 5;
                                this.bNB.hasAgree = false;
                                this.bNB.diffAgreeNum++;
                                this.bNB.disAgreeNum--;
                                GR();
                                if (this.bNQ != null) {
                                    this.bNQ.bxp = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bNB.agreeType = 5;
                                this.bNB.hasAgree = true;
                                this.bNB.diffAgreeNum -= 2;
                                this.bNB.agreeNum--;
                                this.bNB.disAgreeNum++;
                                dH(false);
                                if (this.bNQ != null) {
                                    this.bNQ.bxp = 1;
                                }
                            }
                        } else {
                            this.bNB.agreeType = 5;
                            this.bNB.hasAgree = true;
                            this.bNB.diffAgreeNum--;
                            this.bNB.disAgreeNum++;
                            dH(false);
                            if (this.bNQ != null) {
                                this.bNQ.bxp = 1;
                            }
                        }
                        hD(i2);
                    }
                    this.bNC.agreeData = this.bNB;
                    if (this.bNB.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNC));
                        a(this.bNB, "isInThread");
                    } else if (this.bNB.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNC));
                        a(this.bNB, "isInPost");
                    }
                    aef();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hD(int i) {
        if (this.bNB != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNB.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNB.objType == 0) {
                this.bNB.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bNB.objType);
            httpMessage.addParam("agree_type", this.bNB.agreeType);
            httpMessage.addParam("forum_id", this.bNB.forumId);
            if (!TextUtils.isEmpty(this.bNB.postId)) {
                httpMessage.addParam("post_id", this.bNB.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bNO) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.n.a.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.n.a.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getStoken())) {
                    httpMessage.addParam(ISapiAccount.SAPI_ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void aef() {
        if (this.bNQ != null) {
            if (this.bNQ.type == 1) {
                TiebaStatic.log(new am("c12003").T("obj_locate", this.bNQ.bxj).T("obj_param1", this.bNQ.bxk).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bNQ.bxl).T(VideoPlayActivityConfig.OBJ_ID, this.bNQ.bxm));
            } else if (this.bNQ.type == 2) {
                TiebaStatic.log(new am("c13271").T("obj_type", this.bNQ.bxn).T("obj_locate", this.bNQ.bxo).T(VideoPlayActivityConfig.OBJ_ID, this.bNQ.bxp));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bNM == null) {
            this.bNM = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bNM.setDuration(200L);
        }
        return this.bNM;
    }

    public void onChangeSkinType(int i) {
        if (this.bNB != null && this.mSkinType != i) {
            if (this.bNO) {
                this.aaF = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bNy, d.i.agree);
            al.a(this.bNH, d.i.disagree);
            GR();
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
        GR();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.bNQ = dVar;
    }
}

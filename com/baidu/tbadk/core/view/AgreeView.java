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
    private ColorFilter aaH;
    private TBLottieAnimationView bNB;
    private TextView bNC;
    private int bND;
    private AgreeData bNE;
    private com.baidu.tieba.tbadkCore.data.e bNF;
    private CustomMessageListener bNH;
    private CustomMessageListener bNI;
    private TBLottieAnimationView bNK;
    private int bNL;
    private int bNM;
    private int bNN;
    private int bNO;
    private ScaleAnimation bNP;
    private String bNQ;
    private boolean bNR;
    private boolean bNS;
    private com.baidu.tbadk.core.data.d bNT;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNE.threadId.equals(agreeData.threadId) && AgreeView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNE.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNR) {
                            if (AgreeView.this.bNE.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNF.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
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
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNE.threadId.equals(agreeData.threadId) && AgreeView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNE.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNR) {
                            if (AgreeView.this.bNE.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNF.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
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
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNE.threadId.equals(agreeData.threadId) && AgreeView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNE != null && !TextUtils.isEmpty(AgreeView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNE.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNR) {
                            if (AgreeView.this.bNE.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNF.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
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
        this.bND = com.baidu.adp.lib.util.l.h(context, d.e.tbds136);
        this.bNL = -com.baidu.adp.lib.util.l.h(context, d.e.tbds17);
        this.bNM = com.baidu.adp.lib.util.l.h(context, d.e.tbds7);
        this.bNN = -com.baidu.adp.lib.util.l.h(context, d.e.tbds3);
        this.bNO = -com.baidu.adp.lib.util.l.h(context, d.e.tbds13);
        this.bNB = new TBLottieAnimationView(context);
        this.bNB.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bND, this.bND);
        layoutParams.gravity = 16;
        addView(this.bNB, layoutParams);
        this.bNB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNB.setOnClickListener(this.mOnClickListener);
        this.bNC = new TextView(context);
        this.bNC.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bNL;
        layoutParams2.rightMargin = this.bNL;
        addView(this.bNC, layoutParams2);
        this.bNK = new TBLottieAnimationView(context);
        this.bNK.setId(d.g.img_disagree);
        this.bNK.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bND, this.bND);
        layoutParams3.gravity = 16;
        addView(this.bNK, layoutParams3);
        this.bNK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNB.a(this);
        this.bNK.setOnClickListener(this.mOnClickListener);
        this.bNQ = context.getString(d.j.agree_disagree);
        this.aaH = new com.airbnb.lottie.k(al.getColor(d.C0277d.cp_cont_j));
        this.bNF = new com.baidu.tieba.tbadkCore.data.e();
        this.bNF.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNH);
        MessageManager.getInstance().registerListener(this.bNI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bNH);
        MessageManager.getInstance().unRegisterListener(this.bNI);
    }

    public void setIsFromBigpic(boolean z) {
        this.bNR = z;
        if (z) {
            this.aaH = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bNS = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bNB;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bNK;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNE = agreeData;
            GP();
        }
    }

    public AgreeData getData() {
        return this.bNE;
    }

    public void setAgreeAnimationResource(int i) {
        this.bNB.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bNK.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bND = i;
        this.bNL = i2;
        this.bNM = i3;
        this.bNN = i4;
        this.bNO = i5;
        ViewGroup.LayoutParams layoutParams = this.bNB.getLayoutParams();
        layoutParams.width = this.bND;
        layoutParams.height = this.bND;
        this.bNB.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bNK.getLayoutParams();
        layoutParams2.width = this.bND;
        layoutParams2.height = this.bND;
        this.bNK.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bNC.getLayoutParams();
        layoutParams3.leftMargin = this.bNL;
        layoutParams3.rightMargin = this.bNL;
        this.bNC.setLayoutParams(layoutParams3);
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

    public void GP() {
        String a = a(this.bNE);
        nl(a);
        this.bNC.setText(a);
        if (this.bNE.hasAgree) {
            if (this.bNE.agreeType == 2) {
                this.bNK.setProgress(0.0f);
                this.bNB.setProgress(1.0f);
                this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            }
            this.bNB.setProgress(0.0f);
            this.bNK.setProgress(1.0f);
            this.bNC.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            return;
        }
        this.bNB.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNK.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNB.setProgress(0.0f);
        this.bNK.setProgress(0.0f);
        if (this.bNS) {
            this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        } else if (this.bNR) {
            this.bNC.setTextColor(al.getColor(d.C0277d.white_alpha83));
        } else {
            this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    private void nl(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNC.getLayoutParams();
            if (str.equals(this.bNQ)) {
                layoutParams.leftMargin = this.bNL;
                layoutParams.rightMargin = this.bNL;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bNM;
                layoutParams.rightMargin = this.bNM;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bNN;
                layoutParams.rightMargin = this.bNN;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bNO;
                layoutParams.rightMargin = this.bNO;
            } else {
                layoutParams.leftMargin = this.bNL;
                layoutParams.rightMargin = this.bNL;
            }
            this.bNC.setLayoutParams(layoutParams);
        }
    }

    public void dH(boolean z) {
        this.bNB.setMinAndMaxProgress(0.0f, 1.0f);
        this.bNK.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bNE);
        nl(a);
        this.bNC.setText(a);
        this.bNB.clearColorFilter();
        this.bNK.clearColorFilter();
        if (z) {
            this.bNB.cu();
            this.bNK.cancelAnimation();
            this.bNK.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bNK.cu();
            this.bNB.cancelAnimation();
            this.bNB.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bNB.setFrame(0);
        this.bNK.setFrame(0);
        if (this.bNE.hasAgree) {
            if (this.bNE.agreeType == 2) {
                this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            } else {
                this.bNC.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
                return;
            }
        }
        this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_c));
    }

    public void aeb() {
        aE(this.bNB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        int i2 = 0;
        if (this.bNE != null) {
            if (!this.bNR || com.baidu.tbadk.n.a.cZ(getContext())) {
                if (this.bNR || bc.cZ(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).cu();
                    }
                    if (view.getId() == this.bNB.getId()) {
                        if (this.bNT != null) {
                            this.bNT.type = 1;
                        }
                        if (this.bNE.hasAgree) {
                            if (this.bNE.agreeType == 2) {
                                this.bNE.agreeType = 2;
                                this.bNE.hasAgree = false;
                                this.bNE.diffAgreeNum--;
                                this.bNE.agreeNum--;
                                GP();
                                if (this.bNT != null) {
                                    this.bNT.bxq = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bNE.agreeType = 2;
                                this.bNE.hasAgree = true;
                                this.bNE.diffAgreeNum += 2;
                                this.bNE.agreeNum++;
                                this.bNE.disAgreeNum--;
                                dH(true);
                                com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                                if (this.bNT != null) {
                                    this.bNT.bxq = 0;
                                    i = 0;
                                }
                            }
                            hC(i);
                        } else {
                            this.bNE.agreeType = 2;
                            this.bNE.hasAgree = true;
                            this.bNE.diffAgreeNum++;
                            this.bNE.agreeNum++;
                            dH(true);
                            com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                            if (this.bNT != null) {
                                this.bNT.bxq = 0;
                            }
                        }
                        i = 0;
                        hC(i);
                    } else if (view.getId() == this.bNK.getId()) {
                        if (this.bNT != null) {
                            this.bNT.type = 2;
                        }
                        if (this.bNE.hasAgree) {
                            if (this.bNE.agreeType == 5) {
                                this.bNE.agreeType = 5;
                                this.bNE.hasAgree = false;
                                this.bNE.diffAgreeNum++;
                                this.bNE.disAgreeNum--;
                                GP();
                                if (this.bNT != null) {
                                    this.bNT.bxt = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bNE.agreeType = 5;
                                this.bNE.hasAgree = true;
                                this.bNE.diffAgreeNum -= 2;
                                this.bNE.agreeNum--;
                                this.bNE.disAgreeNum++;
                                dH(false);
                                if (this.bNT != null) {
                                    this.bNT.bxt = 1;
                                }
                            }
                        } else {
                            this.bNE.agreeType = 5;
                            this.bNE.hasAgree = true;
                            this.bNE.diffAgreeNum--;
                            this.bNE.disAgreeNum++;
                            dH(false);
                            if (this.bNT != null) {
                                this.bNT.bxt = 1;
                            }
                        }
                        hC(i2);
                    }
                    this.bNF.agreeData = this.bNE;
                    if (this.bNE.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNF));
                        a(this.bNE, "isInThread");
                    } else if (this.bNE.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNF));
                        a(this.bNE, "isInPost");
                    }
                    aec();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hC(int i) {
        if (this.bNE != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNE.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNE.objType == 0) {
                this.bNE.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bNE.objType);
            httpMessage.addParam("agree_type", this.bNE.agreeType);
            httpMessage.addParam("forum_id", this.bNE.forumId);
            if (!TextUtils.isEmpty(this.bNE.postId)) {
                httpMessage.addParam("post_id", this.bNE.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bNR) {
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

    public void aec() {
        if (this.bNT != null) {
            if (this.bNT.type == 1) {
                TiebaStatic.log(new am("c12003").T("obj_locate", this.bNT.bxn).T("obj_param1", this.bNT.bxo).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bNT.bxp).T(VideoPlayActivityConfig.OBJ_ID, this.bNT.bxq));
            } else if (this.bNT.type == 2) {
                TiebaStatic.log(new am("c13271").T("obj_type", this.bNT.bxr).T("obj_locate", this.bNT.bxs).T(VideoPlayActivityConfig.OBJ_ID, this.bNT.bxt));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bNP == null) {
            this.bNP = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bNP.setDuration(200L);
        }
        return this.bNP;
    }

    public void onChangeSkinType(int i) {
        if (this.bNE != null && this.mSkinType != i) {
            if (this.bNR) {
                this.aaH = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bNB, d.i.agree);
            al.a(this.bNK, d.i.disagree);
            GP();
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
        GP();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.bNT = dVar;
    }
}

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
    private ColorFilter aaG;
    private TBLottieAnimationView bNA;
    private TextView bNB;
    private int bNC;
    private AgreeData bND;
    private com.baidu.tieba.tbadkCore.data.e bNE;
    private CustomMessageListener bNG;
    private CustomMessageListener bNH;
    private TBLottieAnimationView bNJ;
    private int bNK;
    private int bNL;
    private int bNM;
    private int bNN;
    private ScaleAnimation bNO;
    private String bNP;
    private boolean bNQ;
    private boolean bNR;
    private com.baidu.tbadk.core.data.d bNS;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bND.threadId.equals(agreeData.threadId) && AgreeView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bND.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNQ) {
                            if (AgreeView.this.bND.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bND.threadId.equals(agreeData.threadId) && AgreeView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bND.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNQ) {
                            if (AgreeView.this.bND.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bND.threadId.equals(agreeData.threadId) && AgreeView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bND != null && !TextUtils.isEmpty(AgreeView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bND.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNQ) {
                            if (AgreeView.this.bND.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNE.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bND.agreeType = agreeData.agreeType;
                        AgreeView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNC = com.baidu.adp.lib.util.l.h(context, d.e.tbds136);
        this.bNK = -com.baidu.adp.lib.util.l.h(context, d.e.tbds17);
        this.bNL = com.baidu.adp.lib.util.l.h(context, d.e.tbds7);
        this.bNM = -com.baidu.adp.lib.util.l.h(context, d.e.tbds3);
        this.bNN = -com.baidu.adp.lib.util.l.h(context, d.e.tbds13);
        this.bNA = new TBLottieAnimationView(context);
        this.bNA.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bNC, this.bNC);
        layoutParams.gravity = 16;
        addView(this.bNA, layoutParams);
        this.bNA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNA.setOnClickListener(this.mOnClickListener);
        this.bNB = new TextView(context);
        this.bNB.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bNK;
        layoutParams2.rightMargin = this.bNK;
        addView(this.bNB, layoutParams2);
        this.bNJ = new TBLottieAnimationView(context);
        this.bNJ.setId(d.g.img_disagree);
        this.bNJ.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bNC, this.bNC);
        layoutParams3.gravity = 16;
        addView(this.bNJ, layoutParams3);
        this.bNJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNA.a(this);
        this.bNJ.setOnClickListener(this.mOnClickListener);
        this.bNP = context.getString(d.j.agree_disagree);
        this.aaG = new com.airbnb.lottie.k(al.getColor(d.C0277d.cp_cont_j));
        this.bNE = new com.baidu.tieba.tbadkCore.data.e();
        this.bNE.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bNG);
        MessageManager.getInstance().registerListener(this.bNH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bNG);
        MessageManager.getInstance().unRegisterListener(this.bNH);
    }

    public void setIsFromBigpic(boolean z) {
        this.bNQ = z;
        if (z) {
            this.aaG = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bNR = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bNA;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bNJ;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bND = agreeData;
            GP();
        }
    }

    public AgreeData getData() {
        return this.bND;
    }

    public void setAgreeAnimationResource(int i) {
        this.bNA.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bNJ.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bNC = i;
        this.bNK = i2;
        this.bNL = i3;
        this.bNM = i4;
        this.bNN = i5;
        ViewGroup.LayoutParams layoutParams = this.bNA.getLayoutParams();
        layoutParams.width = this.bNC;
        layoutParams.height = this.bNC;
        this.bNA.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bNJ.getLayoutParams();
        layoutParams2.width = this.bNC;
        layoutParams2.height = this.bNC;
        this.bNJ.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bNB.getLayoutParams();
        layoutParams3.leftMargin = this.bNK;
        layoutParams3.rightMargin = this.bNK;
        this.bNB.setLayoutParams(layoutParams3);
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
        String a = a(this.bND);
        nl(a);
        this.bNB.setText(a);
        if (this.bND.hasAgree) {
            if (this.bND.agreeType == 2) {
                this.bNJ.setProgress(0.0f);
                this.bNA.setProgress(1.0f);
                this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            }
            this.bNA.setProgress(0.0f);
            this.bNJ.setProgress(1.0f);
            this.bNB.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
            return;
        }
        this.bNA.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNJ.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNA.setProgress(0.0f);
        this.bNJ.setProgress(0.0f);
        if (this.bNR) {
            this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        } else if (this.bNQ) {
            this.bNB.setTextColor(al.getColor(d.C0277d.white_alpha83));
        } else {
            this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    private void nl(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNB.getLayoutParams();
            if (str.equals(this.bNP)) {
                layoutParams.leftMargin = this.bNK;
                layoutParams.rightMargin = this.bNK;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bNL;
                layoutParams.rightMargin = this.bNL;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bNM;
                layoutParams.rightMargin = this.bNM;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bNN;
                layoutParams.rightMargin = this.bNN;
            } else {
                layoutParams.leftMargin = this.bNK;
                layoutParams.rightMargin = this.bNK;
            }
            this.bNB.setLayoutParams(layoutParams);
        }
    }

    public void dH(boolean z) {
        this.bNA.setMinAndMaxProgress(0.0f, 1.0f);
        this.bNJ.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bND);
        nl(a);
        this.bNB.setText(a);
        this.bNA.clearColorFilter();
        this.bNJ.clearColorFilter();
        if (z) {
            this.bNA.cu();
            this.bNJ.cancelAnimation();
            this.bNJ.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bNJ.cu();
            this.bNA.cancelAnimation();
            this.bNA.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bNA.setFrame(0);
        this.bNJ.setFrame(0);
        if (this.bND.hasAgree) {
            if (this.bND.agreeType == 2) {
                this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                return;
            } else {
                this.bNB.setTextColor(al.getColor(d.C0277d.cp_link_tip_c));
                return;
            }
        }
        this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_c));
    }

    public void aeb() {
        aE(this.bNA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        int i2 = 0;
        if (this.bND != null) {
            if (!this.bNQ || com.baidu.tbadk.n.a.cZ(getContext())) {
                if (this.bNQ || bc.cZ(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).cu();
                    }
                    if (view.getId() == this.bNA.getId()) {
                        if (this.bNS != null) {
                            this.bNS.type = 1;
                        }
                        if (this.bND.hasAgree) {
                            if (this.bND.agreeType == 2) {
                                this.bND.agreeType = 2;
                                this.bND.hasAgree = false;
                                this.bND.diffAgreeNum--;
                                this.bND.agreeNum--;
                                GP();
                                if (this.bNS != null) {
                                    this.bNS.bxp = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bND.agreeType = 2;
                                this.bND.hasAgree = true;
                                this.bND.diffAgreeNum += 2;
                                this.bND.agreeNum++;
                                this.bND.disAgreeNum--;
                                dH(true);
                                com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                                if (this.bNS != null) {
                                    this.bNS.bxp = 0;
                                    i = 0;
                                }
                            }
                            hC(i);
                        } else {
                            this.bND.agreeType = 2;
                            this.bND.hasAgree = true;
                            this.bND.diffAgreeNum++;
                            this.bND.agreeNum++;
                            dH(true);
                            com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                            if (this.bNS != null) {
                                this.bNS.bxp = 0;
                            }
                        }
                        i = 0;
                        hC(i);
                    } else if (view.getId() == this.bNJ.getId()) {
                        if (this.bNS != null) {
                            this.bNS.type = 2;
                        }
                        if (this.bND.hasAgree) {
                            if (this.bND.agreeType == 5) {
                                this.bND.agreeType = 5;
                                this.bND.hasAgree = false;
                                this.bND.diffAgreeNum++;
                                this.bND.disAgreeNum--;
                                GP();
                                if (this.bNS != null) {
                                    this.bNS.bxs = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bND.agreeType = 5;
                                this.bND.hasAgree = true;
                                this.bND.diffAgreeNum -= 2;
                                this.bND.agreeNum--;
                                this.bND.disAgreeNum++;
                                dH(false);
                                if (this.bNS != null) {
                                    this.bNS.bxs = 1;
                                }
                            }
                        } else {
                            this.bND.agreeType = 5;
                            this.bND.hasAgree = true;
                            this.bND.diffAgreeNum--;
                            this.bND.disAgreeNum++;
                            dH(false);
                            if (this.bNS != null) {
                                this.bNS.bxs = 1;
                            }
                        }
                        hC(i2);
                    }
                    this.bNE.agreeData = this.bND;
                    if (this.bND.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNE));
                        a(this.bND, "isInThread");
                    } else if (this.bND.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNE));
                        a(this.bND, "isInPost");
                    }
                    aec();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hC(int i) {
        if (this.bND != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bND.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bND.objType == 0) {
                this.bND.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bND.objType);
            httpMessage.addParam("agree_type", this.bND.agreeType);
            httpMessage.addParam("forum_id", this.bND.forumId);
            if (!TextUtils.isEmpty(this.bND.postId)) {
                httpMessage.addParam("post_id", this.bND.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bNQ) {
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
        if (this.bNS != null) {
            if (this.bNS.type == 1) {
                TiebaStatic.log(new am("c12003").T("obj_locate", this.bNS.bxm).T("obj_param1", this.bNS.bxn).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bNS.bxo).T(VideoPlayActivityConfig.OBJ_ID, this.bNS.bxp));
            } else if (this.bNS.type == 2) {
                TiebaStatic.log(new am("c13271").T("obj_type", this.bNS.bxq).T("obj_locate", this.bNS.bxr).T(VideoPlayActivityConfig.OBJ_ID, this.bNS.bxs));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bNO == null) {
            this.bNO = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bNO.setDuration(200L);
        }
        return this.bNO;
    }

    public void onChangeSkinType(int i) {
        if (this.bND != null && this.mSkinType != i) {
            if (this.bNQ) {
                this.aaG = new PorterDuffColorFilter(al.getColor(d.C0277d.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bNA, d.i.agree);
            al.a(this.bNJ, d.i.disagree);
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
        this.bNS = dVar;
    }
}

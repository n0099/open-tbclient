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
    private ColorFilter aaE;
    private AgreeData bNA;
    private com.baidu.tieba.tbadkCore.data.e bNB;
    private CustomMessageListener bND;
    private CustomMessageListener bNE;
    private TBLottieAnimationView bNG;
    private int bNH;
    private int bNI;
    private int bNJ;
    private int bNK;
    private ScaleAnimation bNL;
    private String bNM;
    private boolean bNN;
    private boolean bNO;
    private com.baidu.tbadk.core.data.d bNP;
    private TBLottieAnimationView bNx;
    private TextView bNy;
    private int bNz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNA.threadId.equals(agreeData.threadId) && AgreeView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNA.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNN) {
                            if (AgreeView.this.bNA.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNB.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNA.threadId.equals(agreeData.threadId) && AgreeView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNA.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNN) {
                            if (AgreeView.this.bNA.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNB.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bNA.threadId.equals(agreeData.threadId) && AgreeView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bNA != null && !TextUtils.isEmpty(AgreeView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bNA.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bNN) {
                            if (AgreeView.this.bNA.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bNB.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNz = com.baidu.adp.lib.util.l.h(context, d.e.tbds136);
        this.bNH = -com.baidu.adp.lib.util.l.h(context, d.e.tbds17);
        this.bNI = com.baidu.adp.lib.util.l.h(context, d.e.tbds7);
        this.bNJ = -com.baidu.adp.lib.util.l.h(context, d.e.tbds3);
        this.bNK = -com.baidu.adp.lib.util.l.h(context, d.e.tbds13);
        this.bNx = new TBLottieAnimationView(context);
        this.bNx.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bNz, this.bNz);
        layoutParams.gravity = 16;
        addView(this.bNx, layoutParams);
        this.bNx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNx.setOnClickListener(this.mOnClickListener);
        this.bNy = new TextView(context);
        this.bNy.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bNH;
        layoutParams2.rightMargin = this.bNH;
        addView(this.bNy, layoutParams2);
        this.bNG = new TBLottieAnimationView(context);
        this.bNG.setId(d.g.img_disagree);
        this.bNG.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bNz, this.bNz);
        layoutParams3.gravity = 16;
        addView(this.bNG, layoutParams3);
        this.bNG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNx.a(this);
        this.bNG.setOnClickListener(this.mOnClickListener);
        this.bNM = context.getString(d.j.agree_disagree);
        this.aaE = new com.airbnb.lottie.k(al.getColor(d.C0236d.cp_cont_j));
        this.bNB = new com.baidu.tieba.tbadkCore.data.e();
        this.bNB.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bND);
        MessageManager.getInstance().registerListener(this.bNE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bND);
        MessageManager.getInstance().unRegisterListener(this.bNE);
    }

    public void setIsFromBigpic(boolean z) {
        this.bNN = z;
        if (z) {
            this.aaE = new PorterDuffColorFilter(al.getColor(d.C0236d.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bNO = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bNx;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bNG;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNA = agreeData;
            GR();
        }
    }

    public AgreeData getData() {
        return this.bNA;
    }

    public void setAgreeAnimationResource(int i) {
        this.bNx.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bNG.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bNz = i;
        this.bNH = i2;
        this.bNI = i3;
        this.bNJ = i4;
        this.bNK = i5;
        ViewGroup.LayoutParams layoutParams = this.bNx.getLayoutParams();
        layoutParams.width = this.bNz;
        layoutParams.height = this.bNz;
        this.bNx.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bNG.getLayoutParams();
        layoutParams2.width = this.bNz;
        layoutParams2.height = this.bNz;
        this.bNG.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bNy.getLayoutParams();
        layoutParams3.leftMargin = this.bNH;
        layoutParams3.rightMargin = this.bNH;
        this.bNy.setLayoutParams(layoutParams3);
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
        String a = a(this.bNA);
        nk(a);
        this.bNy.setText(a);
        if (this.bNA.hasAgree) {
            if (this.bNA.agreeType == 2) {
                this.bNG.setProgress(0.0f);
                this.bNx.setProgress(1.0f);
                this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_h));
                return;
            }
            this.bNx.setProgress(0.0f);
            this.bNG.setProgress(1.0f);
            this.bNy.setTextColor(al.getColor(d.C0236d.cp_link_tip_c));
            return;
        }
        this.bNx.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNG.setMinAndMaxProgress(0.0f, 0.0f);
        this.bNx.setProgress(0.0f);
        this.bNG.setProgress(0.0f);
        if (this.bNO) {
            this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_d));
        } else if (this.bNN) {
            this.bNy.setTextColor(al.getColor(d.C0236d.white_alpha83));
        } else {
            this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        }
    }

    private void nk(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNy.getLayoutParams();
            if (str.equals(this.bNM)) {
                layoutParams.leftMargin = this.bNH;
                layoutParams.rightMargin = this.bNH;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bNI;
                layoutParams.rightMargin = this.bNI;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bNJ;
                layoutParams.rightMargin = this.bNJ;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bNK;
                layoutParams.rightMargin = this.bNK;
            } else {
                layoutParams.leftMargin = this.bNH;
                layoutParams.rightMargin = this.bNH;
            }
            this.bNy.setLayoutParams(layoutParams);
        }
    }

    public void dH(boolean z) {
        this.bNx.setMinAndMaxProgress(0.0f, 1.0f);
        this.bNG.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bNA);
        nk(a);
        this.bNy.setText(a);
        this.bNx.clearColorFilter();
        this.bNG.clearColorFilter();
        if (z) {
            this.bNx.cu();
            this.bNG.cancelAnimation();
            this.bNG.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bNG.cu();
            this.bNx.cancelAnimation();
            this.bNx.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bNx.setFrame(0);
        this.bNG.setFrame(0);
        if (this.bNA.hasAgree) {
            if (this.bNA.agreeType == 2) {
                this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_h));
                return;
            } else {
                this.bNy.setTextColor(al.getColor(d.C0236d.cp_link_tip_c));
                return;
            }
        }
        this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_c));
    }

    public void aee() {
        aE(this.bNx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        int i2 = 0;
        if (this.bNA != null) {
            if (!this.bNN || com.baidu.tbadk.n.a.cZ(getContext())) {
                if (this.bNN || bc.cZ(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).cu();
                    }
                    if (view.getId() == this.bNx.getId()) {
                        if (this.bNP != null) {
                            this.bNP.type = 1;
                        }
                        if (this.bNA.hasAgree) {
                            if (this.bNA.agreeType == 2) {
                                this.bNA.agreeType = 2;
                                this.bNA.hasAgree = false;
                                this.bNA.diffAgreeNum--;
                                this.bNA.agreeNum--;
                                GR();
                                if (this.bNP != null) {
                                    this.bNP.bxk = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bNA.agreeType = 2;
                                this.bNA.hasAgree = true;
                                this.bNA.diffAgreeNum += 2;
                                this.bNA.agreeNum++;
                                this.bNA.disAgreeNum--;
                                dH(true);
                                com.baidu.tieba.n.a.bWp().y(getTbPageContext());
                                if (this.bNP != null) {
                                    this.bNP.bxk = 0;
                                    i = 0;
                                }
                            }
                            hD(i);
                        } else {
                            this.bNA.agreeType = 2;
                            this.bNA.hasAgree = true;
                            this.bNA.diffAgreeNum++;
                            this.bNA.agreeNum++;
                            dH(true);
                            com.baidu.tieba.n.a.bWp().y(getTbPageContext());
                            if (this.bNP != null) {
                                this.bNP.bxk = 0;
                            }
                        }
                        i = 0;
                        hD(i);
                    } else if (view.getId() == this.bNG.getId()) {
                        if (this.bNP != null) {
                            this.bNP.type = 2;
                        }
                        if (this.bNA.hasAgree) {
                            if (this.bNA.agreeType == 5) {
                                this.bNA.agreeType = 5;
                                this.bNA.hasAgree = false;
                                this.bNA.diffAgreeNum++;
                                this.bNA.disAgreeNum--;
                                GR();
                                if (this.bNP != null) {
                                    this.bNP.bxn = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bNA.agreeType = 5;
                                this.bNA.hasAgree = true;
                                this.bNA.diffAgreeNum -= 2;
                                this.bNA.agreeNum--;
                                this.bNA.disAgreeNum++;
                                dH(false);
                                if (this.bNP != null) {
                                    this.bNP.bxn = 1;
                                }
                            }
                        } else {
                            this.bNA.agreeType = 5;
                            this.bNA.hasAgree = true;
                            this.bNA.diffAgreeNum--;
                            this.bNA.disAgreeNum++;
                            dH(false);
                            if (this.bNP != null) {
                                this.bNP.bxn = 1;
                            }
                        }
                        hD(i2);
                    }
                    this.bNB.agreeData = this.bNA;
                    if (this.bNA.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNB));
                        a(this.bNA, "isInThread");
                    } else if (this.bNA.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNB));
                        a(this.bNA, "isInPost");
                    }
                    aef();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hD(int i) {
        if (this.bNA != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNA.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNA.objType == 0) {
                this.bNA.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bNA.objType);
            httpMessage.addParam("agree_type", this.bNA.agreeType);
            httpMessage.addParam("forum_id", this.bNA.forumId);
            if (!TextUtils.isEmpty(this.bNA.postId)) {
                httpMessage.addParam("post_id", this.bNA.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bNN) {
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
        if (this.bNP != null) {
            if (this.bNP.type == 1) {
                TiebaStatic.log(new am("c12003").T("obj_locate", this.bNP.bxh).T("obj_param1", this.bNP.bxi).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bNP.bxj).T(VideoPlayActivityConfig.OBJ_ID, this.bNP.bxk));
            } else if (this.bNP.type == 2) {
                TiebaStatic.log(new am("c13271").T("obj_type", this.bNP.bxl).T("obj_locate", this.bNP.bxm).T(VideoPlayActivityConfig.OBJ_ID, this.bNP.bxn));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bNL == null) {
            this.bNL = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bNL.setDuration(200L);
        }
        return this.bNL;
    }

    public void onChangeSkinType(int i) {
        if (this.bNA != null && this.mSkinType != i) {
            if (this.bNN) {
                this.aaE = new PorterDuffColorFilter(al.getColor(d.C0236d.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bNx, d.i.agree);
            al.a(this.bNG, d.i.disagree);
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
        this.bNP = dVar;
    }
}

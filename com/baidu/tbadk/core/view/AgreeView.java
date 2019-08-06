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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private ColorFilter YT;
    private CustomMessageListener bWA;
    private CustomMessageListener bWB;
    private TBLottieAnimationView bWD;
    private int bWE;
    private int bWF;
    private int bWG;
    private int bWH;
    private ScaleAnimation bWI;
    private String bWJ;
    private boolean bWK;
    private boolean bWL;
    private com.baidu.tbadk.core.data.d bWM;
    private int bWN;
    private TBLottieAnimationView bWu;
    private TextView bWv;
    private int bWw;
    private AgreeData bWx;
    private com.baidu.tieba.tbadkCore.data.e bWy;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWx.threadId.equals(agreeData.threadId) && AgreeView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWx.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWK) {
                            if (AgreeView.this.bWx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWy.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
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
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWx.threadId.equals(agreeData.threadId) && AgreeView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWx.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWK) {
                            if (AgreeView.this.bWx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWy.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
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
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWx.threadId.equals(agreeData.threadId) && AgreeView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWx != null && !TextUtils.isEmpty(AgreeView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWx.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWK) {
                            if (AgreeView.this.bWx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWy.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
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
        this.bWw = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136);
        this.bWE = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds17);
        this.bWF = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds7);
        this.bWG = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds3);
        this.bWH = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds13);
        this.bWu = new TBLottieAnimationView(context);
        this.bWu.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bWw, this.bWw);
        layoutParams.gravity = 16;
        addView(this.bWu, layoutParams);
        this.bWu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWu.setOnClickListener(this.mOnClickListener);
        this.bWv = new TextView(context);
        this.bWv.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bWE;
        layoutParams2.rightMargin = this.bWE;
        addView(this.bWv, layoutParams2);
        this.bWD = new TBLottieAnimationView(context);
        this.bWD.setId(R.id.img_disagree);
        this.bWD.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bWw, this.bWw);
        layoutParams3.gravity = 16;
        addView(this.bWD, layoutParams3);
        this.bWD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWu.a(this);
        this.bWD.setOnClickListener(this.mOnClickListener);
        this.bWJ = context.getString(R.string.agree_disagree);
        this.YT = new com.airbnb.lottie.k(am.getColor(R.color.cp_cont_j));
        this.bWy = new com.baidu.tieba.tbadkCore.data.e();
        this.bWy.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bWA);
        MessageManager.getInstance().registerListener(this.bWB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bWA);
        MessageManager.getInstance().unRegisterListener(this.bWB);
    }

    public void setIsFromBigpic(boolean z) {
        this.bWK = z;
        if (z) {
            this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bWL = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bWu;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bWD;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bWx = agreeData;
            JS();
        }
    }

    public AgreeData getData() {
        return this.bWx;
    }

    public void setAgreeAnimationResource(int i) {
        this.bWu.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bWD.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bWw = i;
        this.bWE = i2;
        this.bWF = i3;
        this.bWG = i4;
        this.bWH = i5;
        ViewGroup.LayoutParams layoutParams = this.bWu.getLayoutParams();
        layoutParams.width = this.bWw;
        layoutParams.height = this.bWw;
        this.bWu.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bWD.getLayoutParams();
        layoutParams2.width = this.bWw;
        layoutParams2.height = this.bWw;
        this.bWD.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bWv.getLayoutParams();
        layoutParams3.leftMargin = this.bWE;
        layoutParams3.rightMargin = this.bWE;
        this.bWv.setLayoutParams(layoutParams3);
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

    public void JS() {
        String a = a(this.bWx);
        oL(a);
        this.bWv.setText(a);
        if (this.bWx.hasAgree) {
            if (this.bWx.agreeType == 2) {
                this.bWD.setProgress(0.0f);
                this.bWu.setProgress(1.0f);
                this.bWv.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            }
            this.bWu.setProgress(0.0f);
            this.bWD.setProgress(1.0f);
            this.bWv.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.bWu.setMinAndMaxProgress(0.0f, 0.0f);
        this.bWD.setMinAndMaxProgress(0.0f, 0.0f);
        this.bWu.setProgress(0.0f);
        this.bWD.setProgress(0.0f);
        if (this.bWL) {
            this.bWv.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.bWK) {
            this.bWv.setTextColor(am.getColor(R.color.white_alpha83));
        } else {
            this.bWv.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    private void oL(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWv.getLayoutParams();
            if (str.equals(this.bWJ)) {
                layoutParams.leftMargin = this.bWE;
                layoutParams.rightMargin = this.bWE;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bWF;
                layoutParams.rightMargin = this.bWF;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bWG;
                layoutParams.rightMargin = this.bWG;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bWH;
                layoutParams.rightMargin = this.bWH;
            } else {
                layoutParams.leftMargin = this.bWE;
                layoutParams.rightMargin = this.bWE;
            }
            this.bWv.setLayoutParams(layoutParams);
        }
    }

    public void eh(boolean z) {
        this.bWu.setMinAndMaxProgress(0.0f, 1.0f);
        this.bWD.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bWx);
        oL(a);
        this.bWv.setText(a);
        this.bWu.clearColorFilter();
        this.bWD.clearColorFilter();
        if (z) {
            this.bWu.br();
            this.bWD.cancelAnimation();
            this.bWD.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bWD.br();
            this.bWu.cancelAnimation();
            this.bWu.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bWu.setFrame(0);
        this.bWD.setFrame(0);
        if (this.bWx.hasAgree) {
            if (this.bWx.agreeType == 2) {
                this.bWv.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.bWv.setTextColor(am.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.bWv.setTextColor(am.getColor(R.color.cp_cont_c));
    }

    public void akg() {
        aM(this.bWu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        int i2 = 0;
        if (this.bWx != null) {
            if (!this.bWK || com.baidu.tbadk.n.a.cF(getContext())) {
                if (this.bWK || bd.cF(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).br();
                    }
                    if (view.getId() == this.bWu.getId()) {
                        if (this.bWM != null) {
                            this.bWM.type = 1;
                        }
                        if (this.bWx.hasAgree) {
                            if (this.bWx.agreeType == 2) {
                                this.bWx.agreeType = 2;
                                this.bWx.hasAgree = false;
                                this.bWx.diffAgreeNum--;
                                this.bWx.agreeNum--;
                                JS();
                                if (this.bWM != null) {
                                    this.bWM.bFD = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bWx.agreeType = 2;
                                this.bWx.hasAgree = true;
                                this.bWx.diffAgreeNum += 2;
                                this.bWx.agreeNum++;
                                this.bWx.disAgreeNum--;
                                eh(true);
                                com.baidu.tieba.n.a.chD().z(getTbPageContext());
                                if (this.bWM != null) {
                                    this.bWM.bFD = 0;
                                    i = 0;
                                }
                            }
                            iw(i);
                        } else {
                            this.bWx.agreeType = 2;
                            this.bWx.hasAgree = true;
                            this.bWx.diffAgreeNum++;
                            this.bWx.agreeNum++;
                            eh(true);
                            com.baidu.tieba.n.a.chD().z(getTbPageContext());
                            if (this.bWM != null) {
                                this.bWM.bFD = 0;
                            }
                        }
                        i = 0;
                        iw(i);
                    } else if (view.getId() == this.bWD.getId()) {
                        if (this.bWM != null) {
                            this.bWM.type = 2;
                        }
                        if (this.bWx.hasAgree) {
                            if (this.bWx.agreeType == 5) {
                                this.bWx.agreeType = 5;
                                this.bWx.hasAgree = false;
                                this.bWx.diffAgreeNum++;
                                this.bWx.disAgreeNum--;
                                JS();
                                if (this.bWM != null) {
                                    this.bWM.bFG = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bWx.agreeType = 5;
                                this.bWx.hasAgree = true;
                                this.bWx.diffAgreeNum -= 2;
                                this.bWx.agreeNum--;
                                this.bWx.disAgreeNum++;
                                eh(false);
                                if (this.bWM != null) {
                                    this.bWM.bFG = 1;
                                }
                            }
                        } else {
                            this.bWx.agreeType = 5;
                            this.bWx.hasAgree = true;
                            this.bWx.diffAgreeNum--;
                            this.bWx.disAgreeNum++;
                            eh(false);
                            if (this.bWM != null) {
                                this.bWM.bFG = 1;
                            }
                        }
                        iw(i2);
                    }
                    this.bWy.agreeData = this.bWx;
                    if (this.bWx.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bWy));
                        a(this.bWx, "isInThread");
                    } else if (this.bWx.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bWy));
                        a(this.bWx, "isInPost");
                    }
                    akh();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iw(int i) {
        if (this.bWx != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bWx.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bWx.objType == 0) {
                this.bWx.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bWx.objType);
            httpMessage.addParam("agree_type", this.bWx.agreeType);
            httpMessage.addParam("forum_id", this.bWx.forumId);
            if (!TextUtils.isEmpty(this.bWx.postId)) {
                httpMessage.addParam("post_id", this.bWx.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bWK) {
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

    public void akh() {
        if (this.bWM != null) {
            if (this.bWM.type == 1) {
                TiebaStatic.log(new an("c12003").P("obj_locate", this.bWM.bFA).P("obj_param1", this.bWM.bFB).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bWM.bFC).P("resource_id", this.bWN).P(VideoPlayActivityConfig.OBJ_ID, this.bWM.bFD));
            } else if (this.bWM.type == 2) {
                TiebaStatic.log(new an("c13271").P("obj_type", this.bWM.bFE).P("obj_locate", this.bWM.bFF).P("obj_param2", this.bWN).P(VideoPlayActivityConfig.OBJ_ID, this.bWM.bFG));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bWI == null) {
            this.bWI = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bWI.setDuration(200L);
        }
        return this.bWI;
    }

    public void onChangeSkinType(int i) {
        if (this.bWx != null && this.mSkinType != i) {
            if (this.bWK) {
                this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            am.a(this.bWu, (int) R.raw.agree);
            am.a(this.bWD, (int) R.raw.disagree);
            JS();
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
        JS();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.bWM = dVar;
    }

    public void setGameId(int i) {
        this.bWN = i;
    }
}

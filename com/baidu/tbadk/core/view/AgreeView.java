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
    private int bWA;
    private int bWB;
    private ScaleAnimation bWC;
    private String bWD;
    private boolean bWE;
    private boolean bWF;
    private com.baidu.tbadk.core.data.d bWG;
    private int bWH;
    private TBLottieAnimationView bWo;
    private TextView bWp;
    private int bWq;
    private AgreeData bWr;
    private com.baidu.tieba.tbadkCore.data.e bWs;
    private CustomMessageListener bWu;
    private CustomMessageListener bWv;
    private TBLottieAnimationView bWx;
    private int bWy;
    private int bWz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWr.threadId.equals(agreeData.threadId) && AgreeView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWr.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWE) {
                            if (AgreeView.this.bWr.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWs.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWr.threadId.equals(agreeData.threadId) && AgreeView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWr.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWE) {
                            if (AgreeView.this.bWr.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWs.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bWr.threadId.equals(agreeData.threadId) && AgreeView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bWr != null && !TextUtils.isEmpty(AgreeView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bWr.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bWE) {
                            if (AgreeView.this.bWr.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bWs.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWq = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136);
        this.bWy = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds17);
        this.bWz = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds7);
        this.bWA = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds3);
        this.bWB = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds13);
        this.bWo = new TBLottieAnimationView(context);
        this.bWo.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bWq, this.bWq);
        layoutParams.gravity = 16;
        addView(this.bWo, layoutParams);
        this.bWo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWo.setOnClickListener(this.mOnClickListener);
        this.bWp = new TextView(context);
        this.bWp.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bWy;
        layoutParams2.rightMargin = this.bWy;
        addView(this.bWp, layoutParams2);
        this.bWx = new TBLottieAnimationView(context);
        this.bWx.setId(R.id.img_disagree);
        this.bWx.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bWq, this.bWq);
        layoutParams3.gravity = 16;
        addView(this.bWx, layoutParams3);
        this.bWx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWo.a(this);
        this.bWx.setOnClickListener(this.mOnClickListener);
        this.bWD = context.getString(R.string.agree_disagree);
        this.YT = new com.airbnb.lottie.k(am.getColor(R.color.cp_cont_j));
        this.bWs = new com.baidu.tieba.tbadkCore.data.e();
        this.bWs.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bWu);
        MessageManager.getInstance().registerListener(this.bWv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bWu);
        MessageManager.getInstance().unRegisterListener(this.bWv);
    }

    public void setIsFromBigpic(boolean z) {
        this.bWE = z;
        if (z) {
            this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bWF = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bWo;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bWx;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bWr = agreeData;
            JS();
        }
    }

    public AgreeData getData() {
        return this.bWr;
    }

    public void setAgreeAnimationResource(int i) {
        this.bWo.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bWx.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bWq = i;
        this.bWy = i2;
        this.bWz = i3;
        this.bWA = i4;
        this.bWB = i5;
        ViewGroup.LayoutParams layoutParams = this.bWo.getLayoutParams();
        layoutParams.width = this.bWq;
        layoutParams.height = this.bWq;
        this.bWo.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bWx.getLayoutParams();
        layoutParams2.width = this.bWq;
        layoutParams2.height = this.bWq;
        this.bWx.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bWp.getLayoutParams();
        layoutParams3.leftMargin = this.bWy;
        layoutParams3.rightMargin = this.bWy;
        this.bWp.setLayoutParams(layoutParams3);
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
        String a = a(this.bWr);
        oL(a);
        this.bWp.setText(a);
        if (this.bWr.hasAgree) {
            if (this.bWr.agreeType == 2) {
                this.bWx.setProgress(0.0f);
                this.bWo.setProgress(1.0f);
                this.bWp.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            }
            this.bWo.setProgress(0.0f);
            this.bWx.setProgress(1.0f);
            this.bWp.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.bWo.setMinAndMaxProgress(0.0f, 0.0f);
        this.bWx.setMinAndMaxProgress(0.0f, 0.0f);
        this.bWo.setProgress(0.0f);
        this.bWx.setProgress(0.0f);
        if (this.bWF) {
            this.bWp.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.bWE) {
            this.bWp.setTextColor(am.getColor(R.color.white_alpha83));
        } else {
            this.bWp.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    private void oL(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWp.getLayoutParams();
            if (str.equals(this.bWD)) {
                layoutParams.leftMargin = this.bWy;
                layoutParams.rightMargin = this.bWy;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bWz;
                layoutParams.rightMargin = this.bWz;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bWA;
                layoutParams.rightMargin = this.bWA;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bWB;
                layoutParams.rightMargin = this.bWB;
            } else {
                layoutParams.leftMargin = this.bWy;
                layoutParams.rightMargin = this.bWy;
            }
            this.bWp.setLayoutParams(layoutParams);
        }
    }

    public void eh(boolean z) {
        this.bWo.setMinAndMaxProgress(0.0f, 1.0f);
        this.bWx.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bWr);
        oL(a);
        this.bWp.setText(a);
        this.bWo.clearColorFilter();
        this.bWx.clearColorFilter();
        if (z) {
            this.bWo.br();
            this.bWx.cancelAnimation();
            this.bWx.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bWx.br();
            this.bWo.cancelAnimation();
            this.bWo.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bWo.setFrame(0);
        this.bWx.setFrame(0);
        if (this.bWr.hasAgree) {
            if (this.bWr.agreeType == 2) {
                this.bWp.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.bWp.setTextColor(am.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.bWp.setTextColor(am.getColor(R.color.cp_cont_c));
    }

    public void ake() {
        aM(this.bWo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        int i2 = 0;
        if (this.bWr != null) {
            if (!this.bWE || com.baidu.tbadk.n.a.cF(getContext())) {
                if (this.bWE || bd.cF(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).br();
                    }
                    if (view.getId() == this.bWo.getId()) {
                        if (this.bWG != null) {
                            this.bWG.type = 1;
                        }
                        if (this.bWr.hasAgree) {
                            if (this.bWr.agreeType == 2) {
                                this.bWr.agreeType = 2;
                                this.bWr.hasAgree = false;
                                this.bWr.diffAgreeNum--;
                                this.bWr.agreeNum--;
                                JS();
                                if (this.bWG != null) {
                                    this.bWG.bFC = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bWr.agreeType = 2;
                                this.bWr.hasAgree = true;
                                this.bWr.diffAgreeNum += 2;
                                this.bWr.agreeNum++;
                                this.bWr.disAgreeNum--;
                                eh(true);
                                com.baidu.tieba.n.a.chl().z(getTbPageContext());
                                if (this.bWG != null) {
                                    this.bWG.bFC = 0;
                                    i = 0;
                                }
                            }
                            iw(i);
                        } else {
                            this.bWr.agreeType = 2;
                            this.bWr.hasAgree = true;
                            this.bWr.diffAgreeNum++;
                            this.bWr.agreeNum++;
                            eh(true);
                            com.baidu.tieba.n.a.chl().z(getTbPageContext());
                            if (this.bWG != null) {
                                this.bWG.bFC = 0;
                            }
                        }
                        i = 0;
                        iw(i);
                    } else if (view.getId() == this.bWx.getId()) {
                        if (this.bWG != null) {
                            this.bWG.type = 2;
                        }
                        if (this.bWr.hasAgree) {
                            if (this.bWr.agreeType == 5) {
                                this.bWr.agreeType = 5;
                                this.bWr.hasAgree = false;
                                this.bWr.diffAgreeNum++;
                                this.bWr.disAgreeNum--;
                                JS();
                                if (this.bWG != null) {
                                    this.bWG.bFF = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bWr.agreeType = 5;
                                this.bWr.hasAgree = true;
                                this.bWr.diffAgreeNum -= 2;
                                this.bWr.agreeNum--;
                                this.bWr.disAgreeNum++;
                                eh(false);
                                if (this.bWG != null) {
                                    this.bWG.bFF = 1;
                                }
                            }
                        } else {
                            this.bWr.agreeType = 5;
                            this.bWr.hasAgree = true;
                            this.bWr.diffAgreeNum--;
                            this.bWr.disAgreeNum++;
                            eh(false);
                            if (this.bWG != null) {
                                this.bWG.bFF = 1;
                            }
                        }
                        iw(i2);
                    }
                    this.bWs.agreeData = this.bWr;
                    if (this.bWr.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bWs));
                        a(this.bWr, "isInThread");
                    } else if (this.bWr.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bWs));
                        a(this.bWr, "isInPost");
                    }
                    akf();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iw(int i) {
        if (this.bWr != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bWr.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bWr.objType == 0) {
                this.bWr.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bWr.objType);
            httpMessage.addParam("agree_type", this.bWr.agreeType);
            httpMessage.addParam("forum_id", this.bWr.forumId);
            if (!TextUtils.isEmpty(this.bWr.postId)) {
                httpMessage.addParam("post_id", this.bWr.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bWE) {
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

    public void akf() {
        if (this.bWG != null) {
            if (this.bWG.type == 1) {
                TiebaStatic.log(new an("c12003").P("obj_locate", this.bWG.bFz).P("obj_param1", this.bWG.bFA).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bWG.bFB).P("resource_id", this.bWH).P(VideoPlayActivityConfig.OBJ_ID, this.bWG.bFC));
            } else if (this.bWG.type == 2) {
                TiebaStatic.log(new an("c13271").P("obj_type", this.bWG.bFD).P("obj_locate", this.bWG.bFE).P("obj_param2", this.bWH).P(VideoPlayActivityConfig.OBJ_ID, this.bWG.bFF));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bWC == null) {
            this.bWC = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bWC.setDuration(200L);
        }
        return this.bWC;
    }

    public void onChangeSkinType(int i) {
        if (this.bWr != null && this.mSkinType != i) {
            if (this.bWE) {
                this.YT = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            am.a(this.bWo, (int) R.raw.agree);
            am.a(this.bWx, (int) R.raw.disagree);
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
        this.bWG = dVar;
    }

    public void setGameId(int i) {
        this.bWH = i;
    }
}
